package com.google.android.exoplayer2.source;

import android.content.Context;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.text.SubtitleDecoderFactory;
import com.google.android.exoplayer2.text.SubtitleExtractor;
import com.google.android.exoplayer2.ui.AdViewProvider;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class DefaultMediaSourceFactory implements MediaSourceFactory {
    private static final String TAG = "DMediaSourceFactory";
    private AdViewProvider adViewProvider;
    private AdsLoader.Provider adsLoaderProvider;
    private DataSource.Factory dataSourceFactory;
    private final DelegateFactoryLoader delegateFactoryLoader;
    private long liveMaxOffsetMs;
    private float liveMaxSpeed;
    private long liveMinOffsetMs;
    private float liveMinSpeed;
    private long liveTargetOffsetMs;
    private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private MediaSource.Factory serverSideAdInsertionMediaSourceFactory;
    private boolean useProgressiveMediaSourceForSubtitles;

    @Deprecated
    public interface AdsLoaderProvider extends AdsLoader.Provider {
    }

    public DefaultMediaSourceFactory(Context context) {
        this((DataSource.Factory) new DefaultDataSource.Factory(context));
    }

    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        this((DataSource.Factory) new DefaultDataSource.Factory(context), extractorsFactory);
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory) {
        this(factory, (ExtractorsFactory) new DefaultExtractorsFactory());
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        this.dataSourceFactory = factory;
        DelegateFactoryLoader delegateFactoryLoader2 = new DelegateFactoryLoader(extractorsFactory);
        this.delegateFactoryLoader = delegateFactoryLoader2;
        delegateFactoryLoader2.setDataSourceFactory(factory);
        this.liveTargetOffsetMs = C.TIME_UNSET;
        this.liveMinOffsetMs = C.TIME_UNSET;
        this.liveMaxOffsetMs = C.TIME_UNSET;
        this.liveMinSpeed = -3.4028235E38f;
        this.liveMaxSpeed = -3.4028235E38f;
    }

    public DefaultMediaSourceFactory experimentalUseProgressiveMediaSourceForSubtitles(boolean z) {
        this.useProgressiveMediaSourceForSubtitles = z;
        return this;
    }

    @Deprecated
    public DefaultMediaSourceFactory setAdsLoaderProvider(AdsLoader.Provider provider) {
        this.adsLoaderProvider = provider;
        return this;
    }

    @Deprecated
    public DefaultMediaSourceFactory setAdViewProvider(AdViewProvider adViewProvider2) {
        this.adViewProvider = adViewProvider2;
        return this;
    }

    public DefaultMediaSourceFactory setLocalAdInsertionComponents(AdsLoader.Provider provider, AdViewProvider adViewProvider2) {
        this.adsLoaderProvider = (AdsLoader.Provider) Assertions.checkNotNull(provider);
        this.adViewProvider = (AdViewProvider) Assertions.checkNotNull(adViewProvider2);
        return this;
    }

    public DefaultMediaSourceFactory clearLocalAdInsertionComponents() {
        this.adsLoaderProvider = null;
        this.adViewProvider = null;
        return this;
    }

    public DefaultMediaSourceFactory setDataSourceFactory(DataSource.Factory factory) {
        this.dataSourceFactory = factory;
        this.delegateFactoryLoader.setDataSourceFactory(factory);
        return this;
    }

    public DefaultMediaSourceFactory setServerSideAdInsertionMediaSourceFactory(MediaSource.Factory factory) {
        this.serverSideAdInsertionMediaSourceFactory = factory;
        return this;
    }

    public DefaultMediaSourceFactory setLiveTargetOffsetMs(long j) {
        this.liveTargetOffsetMs = j;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMinOffsetMs(long j) {
        this.liveMinOffsetMs = j;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMaxOffsetMs(long j) {
        this.liveMaxOffsetMs = j;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMinSpeed(float f) {
        this.liveMinSpeed = f;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMaxSpeed(float f) {
        this.liveMaxSpeed = f;
        return this;
    }

    public DefaultMediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
        this.delegateFactoryLoader.setDrmSessionManagerProvider((DrmSessionManagerProvider) Assertions.checkNotNull(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    public DefaultMediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
        this.loadErrorHandlingPolicy = (LoadErrorHandlingPolicy) Assertions.checkNotNull(loadErrorHandlingPolicy2, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.delegateFactoryLoader.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy2);
        return this;
    }

    public int[] getSupportedTypes() {
        return this.delegateFactoryLoader.getSupportedTypes();
    }

    public MediaSource createMediaSource(MediaItem mediaItem) {
        Assertions.checkNotNull(mediaItem.localConfiguration);
        String scheme = mediaItem.localConfiguration.uri.getScheme();
        if (scheme != null && scheme.equals(C.SSAI_SCHEME)) {
            return ((MediaSource.Factory) Assertions.checkNotNull(this.serverSideAdInsertionMediaSourceFactory)).createMediaSource(mediaItem);
        }
        int inferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(mediaItem.localConfiguration.uri, mediaItem.localConfiguration.mimeType);
        MediaSource.Factory mediaSourceFactory = this.delegateFactoryLoader.getMediaSourceFactory(inferContentTypeForUriAndMimeType);
        Assertions.checkStateNotNull(mediaSourceFactory, "No suitable media source factory found for content type: " + inferContentTypeForUriAndMimeType);
        MediaItem.LiveConfiguration.Builder buildUpon = mediaItem.liveConfiguration.buildUpon();
        if (mediaItem.liveConfiguration.targetOffsetMs == C.TIME_UNSET) {
            buildUpon.setTargetOffsetMs(this.liveTargetOffsetMs);
        }
        if (mediaItem.liveConfiguration.minPlaybackSpeed == -3.4028235E38f) {
            buildUpon.setMinPlaybackSpeed(this.liveMinSpeed);
        }
        if (mediaItem.liveConfiguration.maxPlaybackSpeed == -3.4028235E38f) {
            buildUpon.setMaxPlaybackSpeed(this.liveMaxSpeed);
        }
        if (mediaItem.liveConfiguration.minOffsetMs == C.TIME_UNSET) {
            buildUpon.setMinOffsetMs(this.liveMinOffsetMs);
        }
        if (mediaItem.liveConfiguration.maxOffsetMs == C.TIME_UNSET) {
            buildUpon.setMaxOffsetMs(this.liveMaxOffsetMs);
        }
        MediaItem.LiveConfiguration build = buildUpon.build();
        if (!build.equals(mediaItem.liveConfiguration)) {
            mediaItem = mediaItem.buildUpon().setLiveConfiguration(build).build();
        }
        MediaSource createMediaSource = mediaSourceFactory.createMediaSource(mediaItem);
        ImmutableList<MediaItem.SubtitleConfiguration> immutableList = ((MediaItem.LocalConfiguration) Util.castNonNull(mediaItem.localConfiguration)).subtitleConfigurations;
        if (!immutableList.isEmpty()) {
            MediaSource[] mediaSourceArr = new MediaSource[(immutableList.size() + 1)];
            mediaSourceArr[0] = createMediaSource;
            for (int i = 0; i < immutableList.size(); i++) {
                if (this.useProgressiveMediaSourceForSubtitles) {
                    ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(this.dataSourceFactory, (ExtractorsFactory) new DefaultMediaSourceFactory$$ExternalSyntheticLambda0(new Format.Builder().setSampleMimeType(immutableList.get(i).mimeType).setLanguage(immutableList.get(i).language).setSelectionFlags(immutableList.get(i).selectionFlags).setRoleFlags(immutableList.get(i).roleFlags).setLabel(immutableList.get(i).label).setId(immutableList.get(i).id).build()));
                    LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.loadErrorHandlingPolicy;
                    if (loadErrorHandlingPolicy2 != null) {
                        factory.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy2);
                    }
                    mediaSourceArr[i + 1] = factory.createMediaSource(MediaItem.fromUri(immutableList.get(i).uri.toString()));
                } else {
                    SingleSampleMediaSource.Factory factory2 = new SingleSampleMediaSource.Factory(this.dataSourceFactory);
                    LoadErrorHandlingPolicy loadErrorHandlingPolicy3 = this.loadErrorHandlingPolicy;
                    if (loadErrorHandlingPolicy3 != null) {
                        factory2.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy3);
                    }
                    mediaSourceArr[i + 1] = factory2.createMediaSource(immutableList.get(i), C.TIME_UNSET);
                }
            }
            createMediaSource = new MergingMediaSource(mediaSourceArr);
        }
        return maybeWrapWithAdsMediaSource(mediaItem, maybeClipMediaSource(mediaItem, createMediaSource));
    }

    static /* synthetic */ Extractor[] lambda$createMediaSource$0(Format format) {
        Extractor extractor;
        Extractor[] extractorArr = new Extractor[1];
        if (SubtitleDecoderFactory.DEFAULT.supportsFormat(format)) {
            extractor = new SubtitleExtractor(SubtitleDecoderFactory.DEFAULT.createDecoder(format), format);
        } else {
            extractor = new UnknownSubtitlesExtractor(format);
        }
        extractorArr[0] = extractor;
        return extractorArr;
    }

    private static MediaSource maybeClipMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        if (mediaItem.clippingConfiguration.startPositionMs == 0 && mediaItem.clippingConfiguration.endPositionMs == Long.MIN_VALUE && !mediaItem.clippingConfiguration.relativeToDefaultPosition) {
            return mediaSource;
        }
        return new ClippingMediaSource(mediaSource, Util.msToUs(mediaItem.clippingConfiguration.startPositionMs), Util.msToUs(mediaItem.clippingConfiguration.endPositionMs), !mediaItem.clippingConfiguration.startsAtKeyFrame, mediaItem.clippingConfiguration.relativeToLiveWindow, mediaItem.clippingConfiguration.relativeToDefaultPosition);
    }

    private MediaSource maybeWrapWithAdsMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        Object obj;
        Assertions.checkNotNull(mediaItem.localConfiguration);
        MediaItem.AdsConfiguration adsConfiguration = mediaItem.localConfiguration.adsConfiguration;
        if (adsConfiguration == null) {
            return mediaSource;
        }
        AdsLoader.Provider provider = this.adsLoaderProvider;
        AdViewProvider adViewProvider2 = this.adViewProvider;
        if (provider == null || adViewProvider2 == null) {
            Log.w(TAG, "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return mediaSource;
        }
        AdsLoader adsLoader = provider.getAdsLoader(adsConfiguration);
        if (adsLoader == null) {
            Log.w(TAG, "Playing media without ads, as no AdsLoader was provided.");
            return mediaSource;
        }
        DataSpec dataSpec = new DataSpec(adsConfiguration.adTagUri);
        if (adsConfiguration.adsId != null) {
            obj = adsConfiguration.adsId;
        } else {
            obj = ImmutableList.of(mediaItem.mediaId, mediaItem.localConfiguration.uri, adsConfiguration.adTagUri);
        }
        return new AdsMediaSource(mediaSource, dataSpec, obj, this, adsLoader, adViewProvider2);
    }

    private static final class DelegateFactoryLoader {
        private DataSource.Factory dataSourceFactory;
        private DrmSessionManagerProvider drmSessionManagerProvider;
        private final ExtractorsFactory extractorsFactory;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private final Map<Integer, MediaSource.Factory> mediaSourceFactories = new HashMap();
        private final Map<Integer, Supplier<MediaSource.Factory>> mediaSourceFactorySuppliers = new HashMap();
        private final Set<Integer> supportedTypes = new HashSet();

        public DelegateFactoryLoader(ExtractorsFactory extractorsFactory2) {
            this.extractorsFactory = extractorsFactory2;
        }

        public int[] getSupportedTypes() {
            ensureAllSuppliersAreLoaded();
            return Ints.toArray(this.supportedTypes);
        }

        public MediaSource.Factory getMediaSourceFactory(int i) {
            MediaSource.Factory factory = this.mediaSourceFactories.get(Integer.valueOf(i));
            if (factory != null) {
                return factory;
            }
            Supplier<MediaSource.Factory> maybeLoadSupplier = maybeLoadSupplier(i);
            if (maybeLoadSupplier == null) {
                return null;
            }
            MediaSource.Factory factory2 = maybeLoadSupplier.get();
            DrmSessionManagerProvider drmSessionManagerProvider2 = this.drmSessionManagerProvider;
            if (drmSessionManagerProvider2 != null) {
                factory2.setDrmSessionManagerProvider(drmSessionManagerProvider2);
            }
            LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.loadErrorHandlingPolicy;
            if (loadErrorHandlingPolicy2 != null) {
                factory2.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy2);
            }
            this.mediaSourceFactories.put(Integer.valueOf(i), factory2);
            return factory2;
        }

        public void setDataSourceFactory(DataSource.Factory factory) {
            if (factory != this.dataSourceFactory) {
                this.dataSourceFactory = factory;
                this.mediaSourceFactorySuppliers.clear();
                this.mediaSourceFactories.clear();
            }
        }

        public void setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider2) {
            this.drmSessionManagerProvider = drmSessionManagerProvider2;
            for (MediaSource.Factory drmSessionManagerProvider3 : this.mediaSourceFactories.values()) {
                drmSessionManagerProvider3.setDrmSessionManagerProvider(drmSessionManagerProvider2);
            }
        }

        public void setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
            for (MediaSource.Factory loadErrorHandlingPolicy3 : this.mediaSourceFactories.values()) {
                loadErrorHandlingPolicy3.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy2);
            }
        }

        private void ensureAllSuppliersAreLoaded() {
            maybeLoadSupplier(0);
            maybeLoadSupplier(1);
            maybeLoadSupplier(2);
            maybeLoadSupplier(3);
            maybeLoadSupplier(4);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x008b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSource.Factory> maybeLoadSupplier(int r5) {
            /*
                r4 = this;
                java.util.Map<java.lang.Integer, com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSource$Factory>> r0 = r4.mediaSourceFactorySuppliers
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                boolean r0 = r0.containsKey(r1)
                if (r0 == 0) goto L_0x0019
                java.util.Map<java.lang.Integer, com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSource$Factory>> r0 = r4.mediaSourceFactorySuppliers
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r5 = r0.get(r5)
                com.google.common.base.Supplier r5 = (com.google.common.base.Supplier) r5
                return r5
            L_0x0019:
                r0 = 0
                com.google.android.exoplayer2.upstream.DataSource$Factory r1 = r4.dataSourceFactory
                java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r1)
                com.google.android.exoplayer2.upstream.DataSource$Factory r1 = (com.google.android.exoplayer2.upstream.DataSource.Factory) r1
                if (r5 == 0) goto L_0x006e
                r2 = 1
                if (r5 == r2) goto L_0x005c
                r2 = 2
                if (r5 == r2) goto L_0x004a
                r2 = 3
                if (r5 == r2) goto L_0x0038
                r2 = 4
                if (r5 == r2) goto L_0x0031
                goto L_0x0080
            L_0x0031:
                com.google.android.exoplayer2.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda4 r2 = new com.google.android.exoplayer2.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda4     // Catch:{ ClassNotFoundException -> 0x0080 }
                r2.<init>(r4, r1)     // Catch:{ ClassNotFoundException -> 0x0080 }
            L_0x0036:
                r0 = r2
                goto L_0x0080
            L_0x0038:
                java.lang.String r1 = "com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0080 }
                java.lang.Class<com.google.android.exoplayer2.source.MediaSource$Factory> r2 = com.google.android.exoplayer2.source.MediaSource.Factory.class
                java.lang.Class r1 = r1.asSubclass(r2)     // Catch:{ ClassNotFoundException -> 0x0080 }
                com.google.android.exoplayer2.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda3 r2 = new com.google.android.exoplayer2.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda3     // Catch:{ ClassNotFoundException -> 0x0080 }
                r2.<init>(r1)     // Catch:{ ClassNotFoundException -> 0x0080 }
                goto L_0x0036
            L_0x004a:
                java.lang.String r2 = "com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory"
                java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0080 }
                java.lang.Class<com.google.android.exoplayer2.source.MediaSource$Factory> r3 = com.google.android.exoplayer2.source.MediaSource.Factory.class
                java.lang.Class r2 = r2.asSubclass(r3)     // Catch:{ ClassNotFoundException -> 0x0080 }
                com.google.android.exoplayer2.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda2 r3 = new com.google.android.exoplayer2.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda2     // Catch:{ ClassNotFoundException -> 0x0080 }
                r3.<init>(r2, r1)     // Catch:{ ClassNotFoundException -> 0x0080 }
                goto L_0x007f
            L_0x005c:
                java.lang.String r2 = "com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory"
                java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0080 }
                java.lang.Class<com.google.android.exoplayer2.source.MediaSource$Factory> r3 = com.google.android.exoplayer2.source.MediaSource.Factory.class
                java.lang.Class r2 = r2.asSubclass(r3)     // Catch:{ ClassNotFoundException -> 0x0080 }
                com.google.android.exoplayer2.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda1 r3 = new com.google.android.exoplayer2.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda1     // Catch:{ ClassNotFoundException -> 0x0080 }
                r3.<init>(r2, r1)     // Catch:{ ClassNotFoundException -> 0x0080 }
                goto L_0x007f
            L_0x006e:
                java.lang.String r2 = "com.google.android.exoplayer2.source.dash.DashMediaSource$Factory"
                java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0080 }
                java.lang.Class<com.google.android.exoplayer2.source.MediaSource$Factory> r3 = com.google.android.exoplayer2.source.MediaSource.Factory.class
                java.lang.Class r2 = r2.asSubclass(r3)     // Catch:{ ClassNotFoundException -> 0x0080 }
                com.google.android.exoplayer2.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda0 r3 = new com.google.android.exoplayer2.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda0     // Catch:{ ClassNotFoundException -> 0x0080 }
                r3.<init>(r2, r1)     // Catch:{ ClassNotFoundException -> 0x0080 }
            L_0x007f:
                r0 = r3
            L_0x0080:
                java.util.Map<java.lang.Integer, com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSource$Factory>> r1 = r4.mediaSourceFactorySuppliers
                java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
                r1.put(r2, r0)
                if (r0 == 0) goto L_0x0094
                java.util.Set<java.lang.Integer> r1 = r4.supportedTypes
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r1.add(r5)
            L_0x0094:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.DefaultMediaSourceFactory.DelegateFactoryLoader.maybeLoadSupplier(int):com.google.common.base.Supplier");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$maybeLoadSupplier$4$com-google-android-exoplayer2-source-DefaultMediaSourceFactory$DelegateFactoryLoader  reason: not valid java name */
        public /* synthetic */ MediaSource.Factory m504lambda$maybeLoadSupplier$4$comgoogleandroidexoplayer2sourceDefaultMediaSourceFactory$DelegateFactoryLoader(DataSource.Factory factory) {
            return new ProgressiveMediaSource.Factory(factory, this.extractorsFactory);
        }
    }

    private static final class UnknownSubtitlesExtractor implements Extractor {
        private final Format format;

        public void release() {
        }

        public void seek(long j, long j2) {
        }

        public boolean sniff(ExtractorInput extractorInput) {
            return true;
        }

        public UnknownSubtitlesExtractor(Format format2) {
            this.format = format2;
        }

        public void init(ExtractorOutput extractorOutput) {
            TrackOutput track = extractorOutput.track(0, 3);
            extractorOutput.seekMap(new SeekMap.Unseekable(C.TIME_UNSET));
            extractorOutput.endTracks();
            track.format(this.format.buildUpon().setSampleMimeType(MimeTypes.TEXT_UNKNOWN).setCodecs(this.format.sampleMimeType).build());
        }

        public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
            return extractorInput.skip(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }
    }

    /* access modifiers changed from: private */
    public static MediaSource.Factory newInstance(Class<? extends MediaSource.Factory> cls, DataSource.Factory factory) {
        try {
            return (MediaSource.Factory) cls.getConstructor(new Class[]{DataSource.Factory.class}).newInstance(new Object[]{factory});
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: private */
    public static MediaSource.Factory newInstance(Class<? extends MediaSource.Factory> cls) {
        try {
            return (MediaSource.Factory) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
