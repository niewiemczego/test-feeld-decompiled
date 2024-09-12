package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class MediaItem implements Bundleable {
    public static final Bundleable.Creator<MediaItem> CREATOR = new MediaItem$$ExternalSyntheticLambda0();
    public static final String DEFAULT_MEDIA_ID = "";
    public static final MediaItem EMPTY = new Builder().build();
    private static final int FIELD_CLIPPING_PROPERTIES = 3;
    private static final int FIELD_LIVE_CONFIGURATION = 1;
    private static final int FIELD_MEDIA_ID = 0;
    private static final int FIELD_MEDIA_METADATA = 2;
    private static final int FIELD_REQUEST_METADATA = 4;
    public final ClippingConfiguration clippingConfiguration;
    @Deprecated
    public final ClippingProperties clippingProperties;
    public final LiveConfiguration liveConfiguration;
    public final LocalConfiguration localConfiguration;
    public final String mediaId;
    public final MediaMetadata mediaMetadata;
    @Deprecated
    public final PlaybackProperties playbackProperties;
    public final RequestMetadata requestMetadata;

    public static MediaItem fromUri(String str) {
        return new Builder().setUri(str).build();
    }

    public static MediaItem fromUri(Uri uri) {
        return new Builder().setUri(uri).build();
    }

    public static final class Builder {
        private AdsConfiguration adsConfiguration;
        private ClippingConfiguration.Builder clippingConfiguration;
        private String customCacheKey;
        private DrmConfiguration.Builder drmConfiguration;
        private LiveConfiguration.Builder liveConfiguration;
        private String mediaId;
        private MediaMetadata mediaMetadata;
        private String mimeType;
        private RequestMetadata requestMetadata;
        private List<StreamKey> streamKeys;
        private ImmutableList<SubtitleConfiguration> subtitleConfigurations;
        private Object tag;
        private Uri uri;

        public Builder() {
            this.clippingConfiguration = new ClippingConfiguration.Builder();
            this.drmConfiguration = new DrmConfiguration.Builder();
            this.streamKeys = Collections.emptyList();
            this.subtitleConfigurations = ImmutableList.of();
            this.liveConfiguration = new LiveConfiguration.Builder();
            this.requestMetadata = RequestMetadata.EMPTY;
        }

        private Builder(MediaItem mediaItem) {
            this();
            DrmConfiguration.Builder builder;
            this.clippingConfiguration = mediaItem.clippingConfiguration.buildUpon();
            this.mediaId = mediaItem.mediaId;
            this.mediaMetadata = mediaItem.mediaMetadata;
            this.liveConfiguration = mediaItem.liveConfiguration.buildUpon();
            this.requestMetadata = mediaItem.requestMetadata;
            LocalConfiguration localConfiguration = mediaItem.localConfiguration;
            if (localConfiguration != null) {
                this.customCacheKey = localConfiguration.customCacheKey;
                this.mimeType = localConfiguration.mimeType;
                this.uri = localConfiguration.uri;
                this.streamKeys = localConfiguration.streamKeys;
                this.subtitleConfigurations = localConfiguration.subtitleConfigurations;
                this.tag = localConfiguration.tag;
                if (localConfiguration.drmConfiguration != null) {
                    builder = localConfiguration.drmConfiguration.buildUpon();
                } else {
                    builder = new DrmConfiguration.Builder();
                }
                this.drmConfiguration = builder;
                this.adsConfiguration = localConfiguration.adsConfiguration;
            }
        }

        public Builder setMediaId(String str) {
            this.mediaId = (String) Assertions.checkNotNull(str);
            return this;
        }

        public Builder setUri(String str) {
            return setUri(str == null ? null : Uri.parse(str));
        }

        public Builder setUri(Uri uri2) {
            this.uri = uri2;
            return this;
        }

        public Builder setMimeType(String str) {
            this.mimeType = str;
            return this;
        }

        public Builder setClippingConfiguration(ClippingConfiguration clippingConfiguration2) {
            this.clippingConfiguration = clippingConfiguration2.buildUpon();
            return this;
        }

        @Deprecated
        public Builder setClipStartPositionMs(long j) {
            this.clippingConfiguration.setStartPositionMs(j);
            return this;
        }

        @Deprecated
        public Builder setClipEndPositionMs(long j) {
            this.clippingConfiguration.setEndPositionMs(j);
            return this;
        }

        @Deprecated
        public Builder setClipRelativeToLiveWindow(boolean z) {
            this.clippingConfiguration.setRelativeToLiveWindow(z);
            return this;
        }

        @Deprecated
        public Builder setClipRelativeToDefaultPosition(boolean z) {
            this.clippingConfiguration.setRelativeToDefaultPosition(z);
            return this;
        }

        @Deprecated
        public Builder setClipStartsAtKeyFrame(boolean z) {
            this.clippingConfiguration.setStartsAtKeyFrame(z);
            return this;
        }

        public Builder setDrmConfiguration(DrmConfiguration drmConfiguration2) {
            this.drmConfiguration = drmConfiguration2 != null ? drmConfiguration2.buildUpon() : new DrmConfiguration.Builder();
            return this;
        }

        @Deprecated
        public Builder setDrmLicenseUri(Uri uri2) {
            this.drmConfiguration.setLicenseUri(uri2);
            return this;
        }

        @Deprecated
        public Builder setDrmLicenseUri(String str) {
            this.drmConfiguration.setLicenseUri(str);
            return this;
        }

        @Deprecated
        public Builder setDrmLicenseRequestHeaders(Map<String, String> map) {
            DrmConfiguration.Builder builder = this.drmConfiguration;
            if (map == null) {
                map = ImmutableMap.of();
            }
            builder.setLicenseRequestHeaders(map);
            return this;
        }

        @Deprecated
        public Builder setDrmUuid(UUID uuid) {
            DrmConfiguration.Builder unused = this.drmConfiguration.setNullableScheme(uuid);
            return this;
        }

        @Deprecated
        public Builder setDrmMultiSession(boolean z) {
            this.drmConfiguration.setMultiSession(z);
            return this;
        }

        @Deprecated
        public Builder setDrmForceDefaultLicenseUri(boolean z) {
            this.drmConfiguration.setForceDefaultLicenseUri(z);
            return this;
        }

        @Deprecated
        public Builder setDrmPlayClearContentWithoutKey(boolean z) {
            this.drmConfiguration.setPlayClearContentWithoutKey(z);
            return this;
        }

        @Deprecated
        public Builder setDrmSessionForClearPeriods(boolean z) {
            this.drmConfiguration.setForceSessionsForAudioAndVideoTracks(z);
            return this;
        }

        @Deprecated
        public Builder setDrmSessionForClearTypes(List<Integer> list) {
            DrmConfiguration.Builder builder = this.drmConfiguration;
            if (list == null) {
                list = ImmutableList.of();
            }
            builder.setForcedSessionTrackTypes(list);
            return this;
        }

        @Deprecated
        public Builder setDrmKeySetId(byte[] bArr) {
            this.drmConfiguration.setKeySetId(bArr);
            return this;
        }

        public Builder setStreamKeys(List<StreamKey> list) {
            List<StreamKey> list2;
            if (list == null || list.isEmpty()) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(new ArrayList(list));
            }
            this.streamKeys = list2;
            return this;
        }

        public Builder setCustomCacheKey(String str) {
            this.customCacheKey = str;
            return this;
        }

        @Deprecated
        public Builder setSubtitles(List<Subtitle> list) {
            this.subtitleConfigurations = list != null ? ImmutableList.copyOf(list) : ImmutableList.of();
            return this;
        }

        public Builder setSubtitleConfigurations(List<SubtitleConfiguration> list) {
            this.subtitleConfigurations = ImmutableList.copyOf(list);
            return this;
        }

        public Builder setAdsConfiguration(AdsConfiguration adsConfiguration2) {
            this.adsConfiguration = adsConfiguration2;
            return this;
        }

        @Deprecated
        public Builder setAdTagUri(String str) {
            return setAdTagUri(str != null ? Uri.parse(str) : null);
        }

        @Deprecated
        public Builder setAdTagUri(Uri uri2) {
            return setAdTagUri(uri2, (Object) null);
        }

        @Deprecated
        public Builder setAdTagUri(Uri uri2, Object obj) {
            this.adsConfiguration = uri2 != null ? new AdsConfiguration.Builder(uri2).setAdsId(obj).build() : null;
            return this;
        }

        public Builder setLiveConfiguration(LiveConfiguration liveConfiguration2) {
            this.liveConfiguration = liveConfiguration2.buildUpon();
            return this;
        }

        @Deprecated
        public Builder setLiveTargetOffsetMs(long j) {
            this.liveConfiguration.setTargetOffsetMs(j);
            return this;
        }

        @Deprecated
        public Builder setLiveMinOffsetMs(long j) {
            this.liveConfiguration.setMinOffsetMs(j);
            return this;
        }

        @Deprecated
        public Builder setLiveMaxOffsetMs(long j) {
            this.liveConfiguration.setMaxOffsetMs(j);
            return this;
        }

        @Deprecated
        public Builder setLiveMinPlaybackSpeed(float f) {
            this.liveConfiguration.setMinPlaybackSpeed(f);
            return this;
        }

        @Deprecated
        public Builder setLiveMaxPlaybackSpeed(float f) {
            this.liveConfiguration.setMaxPlaybackSpeed(f);
            return this;
        }

        public Builder setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Builder setMediaMetadata(MediaMetadata mediaMetadata2) {
            this.mediaMetadata = mediaMetadata2;
            return this;
        }

        public Builder setRequestMetadata(RequestMetadata requestMetadata2) {
            this.requestMetadata = requestMetadata2;
            return this;
        }

        public MediaItem build() {
            PlaybackProperties playbackProperties;
            Assertions.checkState(this.drmConfiguration.licenseUri == null || this.drmConfiguration.scheme != null);
            Uri uri2 = this.uri;
            DrmConfiguration drmConfiguration2 = null;
            if (uri2 != null) {
                String str = this.mimeType;
                if (this.drmConfiguration.scheme != null) {
                    drmConfiguration2 = this.drmConfiguration.build();
                }
                playbackProperties = new PlaybackProperties(uri2, str, drmConfiguration2, this.adsConfiguration, this.streamKeys, this.customCacheKey, this.subtitleConfigurations, this.tag);
            } else {
                playbackProperties = null;
            }
            String str2 = this.mediaId;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            ClippingProperties buildClippingProperties = this.clippingConfiguration.buildClippingProperties();
            LiveConfiguration build = this.liveConfiguration.build();
            MediaMetadata mediaMetadata2 = this.mediaMetadata;
            if (mediaMetadata2 == null) {
                mediaMetadata2 = MediaMetadata.EMPTY;
            }
            return new MediaItem(str3, buildClippingProperties, playbackProperties, build, mediaMetadata2, this.requestMetadata);
        }
    }

    public static final class DrmConfiguration {
        public final boolean forceDefaultLicenseUri;
        public final ImmutableList<Integer> forcedSessionTrackTypes;
        /* access modifiers changed from: private */
        public final byte[] keySetId;
        public final ImmutableMap<String, String> licenseRequestHeaders;
        public final Uri licenseUri;
        public final boolean multiSession;
        public final boolean playClearContentWithoutKey;
        @Deprecated
        public final ImmutableMap<String, String> requestHeaders;
        public final UUID scheme;
        @Deprecated
        public final ImmutableList<Integer> sessionForClearTypes;
        @Deprecated
        public final UUID uuid;

        public static final class Builder {
            /* access modifiers changed from: private */
            public boolean forceDefaultLicenseUri;
            /* access modifiers changed from: private */
            public ImmutableList<Integer> forcedSessionTrackTypes;
            /* access modifiers changed from: private */
            public byte[] keySetId;
            /* access modifiers changed from: private */
            public ImmutableMap<String, String> licenseRequestHeaders;
            /* access modifiers changed from: private */
            public Uri licenseUri;
            /* access modifiers changed from: private */
            public boolean multiSession;
            /* access modifiers changed from: private */
            public boolean playClearContentWithoutKey;
            /* access modifiers changed from: private */
            public UUID scheme;

            public Builder(UUID uuid) {
                this.scheme = uuid;
                this.licenseRequestHeaders = ImmutableMap.of();
                this.forcedSessionTrackTypes = ImmutableList.of();
            }

            @Deprecated
            private Builder() {
                this.licenseRequestHeaders = ImmutableMap.of();
                this.forcedSessionTrackTypes = ImmutableList.of();
            }

            private Builder(DrmConfiguration drmConfiguration) {
                this.scheme = drmConfiguration.scheme;
                this.licenseUri = drmConfiguration.licenseUri;
                this.licenseRequestHeaders = drmConfiguration.licenseRequestHeaders;
                this.multiSession = drmConfiguration.multiSession;
                this.playClearContentWithoutKey = drmConfiguration.playClearContentWithoutKey;
                this.forceDefaultLicenseUri = drmConfiguration.forceDefaultLicenseUri;
                this.forcedSessionTrackTypes = drmConfiguration.forcedSessionTrackTypes;
                this.keySetId = drmConfiguration.keySetId;
            }

            public Builder setScheme(UUID uuid) {
                this.scheme = uuid;
                return this;
            }

            /* access modifiers changed from: private */
            @Deprecated
            public Builder setNullableScheme(UUID uuid) {
                this.scheme = uuid;
                return this;
            }

            public Builder setLicenseUri(Uri uri) {
                this.licenseUri = uri;
                return this;
            }

            public Builder setLicenseUri(String str) {
                this.licenseUri = str == null ? null : Uri.parse(str);
                return this;
            }

            public Builder setLicenseRequestHeaders(Map<String, String> map) {
                this.licenseRequestHeaders = ImmutableMap.copyOf(map);
                return this;
            }

            public Builder setMultiSession(boolean z) {
                this.multiSession = z;
                return this;
            }

            public Builder setForceDefaultLicenseUri(boolean z) {
                this.forceDefaultLicenseUri = z;
                return this;
            }

            public Builder setPlayClearContentWithoutKey(boolean z) {
                this.playClearContentWithoutKey = z;
                return this;
            }

            @Deprecated
            public Builder forceSessionsForAudioAndVideoTracks(boolean z) {
                return setForceSessionsForAudioAndVideoTracks(z);
            }

            public Builder setForceSessionsForAudioAndVideoTracks(boolean z) {
                ImmutableList immutableList;
                if (z) {
                    immutableList = ImmutableList.of(2, 1);
                } else {
                    immutableList = ImmutableList.of();
                }
                setForcedSessionTrackTypes(immutableList);
                return this;
            }

            public Builder setForcedSessionTrackTypes(List<Integer> list) {
                this.forcedSessionTrackTypes = ImmutableList.copyOf(list);
                return this;
            }

            public Builder setKeySetId(byte[] bArr) {
                this.keySetId = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
                return this;
            }

            public DrmConfiguration build() {
                return new DrmConfiguration(this);
            }
        }

        private DrmConfiguration(Builder builder) {
            Assertions.checkState(!builder.forceDefaultLicenseUri || builder.licenseUri != null);
            UUID uuid2 = (UUID) Assertions.checkNotNull(builder.scheme);
            this.scheme = uuid2;
            this.uuid = uuid2;
            this.licenseUri = builder.licenseUri;
            this.requestHeaders = builder.licenseRequestHeaders;
            this.licenseRequestHeaders = builder.licenseRequestHeaders;
            this.multiSession = builder.multiSession;
            this.forceDefaultLicenseUri = builder.forceDefaultLicenseUri;
            this.playClearContentWithoutKey = builder.playClearContentWithoutKey;
            this.sessionForClearTypes = builder.forcedSessionTrackTypes;
            this.forcedSessionTrackTypes = builder.forcedSessionTrackTypes;
            this.keySetId = builder.keySetId != null ? Arrays.copyOf(builder.keySetId, builder.keySetId.length) : null;
        }

        public byte[] getKeySetId() {
            byte[] bArr = this.keySetId;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrmConfiguration)) {
                return false;
            }
            DrmConfiguration drmConfiguration = (DrmConfiguration) obj;
            if (!this.scheme.equals(drmConfiguration.scheme) || !Util.areEqual(this.licenseUri, drmConfiguration.licenseUri) || !Util.areEqual(this.licenseRequestHeaders, drmConfiguration.licenseRequestHeaders) || this.multiSession != drmConfiguration.multiSession || this.forceDefaultLicenseUri != drmConfiguration.forceDefaultLicenseUri || this.playClearContentWithoutKey != drmConfiguration.playClearContentWithoutKey || !this.forcedSessionTrackTypes.equals(drmConfiguration.forcedSessionTrackTypes) || !Arrays.equals(this.keySetId, drmConfiguration.keySetId)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.scheme.hashCode() * 31;
            Uri uri = this.licenseUri;
            return ((((((((((((hashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.licenseRequestHeaders.hashCode()) * 31) + (this.multiSession ? 1 : 0)) * 31) + (this.forceDefaultLicenseUri ? 1 : 0)) * 31) + (this.playClearContentWithoutKey ? 1 : 0)) * 31) + this.forcedSessionTrackTypes.hashCode()) * 31) + Arrays.hashCode(this.keySetId);
        }
    }

    public static final class AdsConfiguration {
        public final Uri adTagUri;
        public final Object adsId;

        public static final class Builder {
            /* access modifiers changed from: private */
            public Uri adTagUri;
            /* access modifiers changed from: private */
            public Object adsId;

            public Builder(Uri uri) {
                this.adTagUri = uri;
            }

            public Builder setAdTagUri(Uri uri) {
                this.adTagUri = uri;
                return this;
            }

            public Builder setAdsId(Object obj) {
                this.adsId = obj;
                return this;
            }

            public AdsConfiguration build() {
                return new AdsConfiguration(this);
            }
        }

        private AdsConfiguration(Builder builder) {
            this.adTagUri = builder.adTagUri;
            this.adsId = builder.adsId;
        }

        public Builder buildUpon() {
            return new Builder(this.adTagUri).setAdsId(this.adsId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdsConfiguration)) {
                return false;
            }
            AdsConfiguration adsConfiguration = (AdsConfiguration) obj;
            if (!this.adTagUri.equals(adsConfiguration.adTagUri) || !Util.areEqual(this.adsId, adsConfiguration.adsId)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.adTagUri.hashCode() * 31;
            Object obj = this.adsId;
            return hashCode + (obj != null ? obj.hashCode() : 0);
        }
    }

    public static class LocalConfiguration {
        public final AdsConfiguration adsConfiguration;
        public final String customCacheKey;
        public final DrmConfiguration drmConfiguration;
        public final String mimeType;
        public final List<StreamKey> streamKeys;
        public final ImmutableList<SubtitleConfiguration> subtitleConfigurations;
        @Deprecated
        public final List<Subtitle> subtitles;
        public final Object tag;
        public final Uri uri;

        private LocalConfiguration(Uri uri2, String str, DrmConfiguration drmConfiguration2, AdsConfiguration adsConfiguration2, List<StreamKey> list, String str2, ImmutableList<SubtitleConfiguration> immutableList, Object obj) {
            this.uri = uri2;
            this.mimeType = str;
            this.drmConfiguration = drmConfiguration2;
            this.adsConfiguration = adsConfiguration2;
            this.streamKeys = list;
            this.customCacheKey = str2;
            this.subtitleConfigurations = immutableList;
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i = 0; i < immutableList.size(); i++) {
                builder.add((Object) ((SubtitleConfiguration) immutableList.get(i)).buildUpon().buildSubtitle());
            }
            this.subtitles = builder.build();
            this.tag = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalConfiguration)) {
                return false;
            }
            LocalConfiguration localConfiguration = (LocalConfiguration) obj;
            if (!this.uri.equals(localConfiguration.uri) || !Util.areEqual(this.mimeType, localConfiguration.mimeType) || !Util.areEqual(this.drmConfiguration, localConfiguration.drmConfiguration) || !Util.areEqual(this.adsConfiguration, localConfiguration.adsConfiguration) || !this.streamKeys.equals(localConfiguration.streamKeys) || !Util.areEqual(this.customCacheKey, localConfiguration.customCacheKey) || !this.subtitleConfigurations.equals(localConfiguration.subtitleConfigurations) || !Util.areEqual(this.tag, localConfiguration.tag)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.uri.hashCode() * 31;
            String str = this.mimeType;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            DrmConfiguration drmConfiguration2 = this.drmConfiguration;
            int hashCode3 = (hashCode2 + (drmConfiguration2 == null ? 0 : drmConfiguration2.hashCode())) * 31;
            AdsConfiguration adsConfiguration2 = this.adsConfiguration;
            int hashCode4 = (((hashCode3 + (adsConfiguration2 == null ? 0 : adsConfiguration2.hashCode())) * 31) + this.streamKeys.hashCode()) * 31;
            String str2 = this.customCacheKey;
            int hashCode5 = (((hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.subtitleConfigurations.hashCode()) * 31;
            Object obj = this.tag;
            if (obj != null) {
                i = obj.hashCode();
            }
            return hashCode5 + i;
        }
    }

    @Deprecated
    public static final class PlaybackProperties extends LocalConfiguration {
        private PlaybackProperties(Uri uri, String str, DrmConfiguration drmConfiguration, AdsConfiguration adsConfiguration, List<StreamKey> list, String str2, ImmutableList<SubtitleConfiguration> immutableList, Object obj) {
            super(uri, str, drmConfiguration, adsConfiguration, list, str2, immutableList, obj);
        }
    }

    public static final class LiveConfiguration implements Bundleable {
        public static final Bundleable.Creator<LiveConfiguration> CREATOR = new MediaItem$LiveConfiguration$$ExternalSyntheticLambda0();
        private static final int FIELD_MAX_OFFSET_MS = 2;
        private static final int FIELD_MAX_PLAYBACK_SPEED = 4;
        private static final int FIELD_MIN_OFFSET_MS = 1;
        private static final int FIELD_MIN_PLAYBACK_SPEED = 3;
        private static final int FIELD_TARGET_OFFSET_MS = 0;
        public static final LiveConfiguration UNSET = new Builder().build();
        public final long maxOffsetMs;
        public final float maxPlaybackSpeed;
        public final long minOffsetMs;
        public final float minPlaybackSpeed;
        public final long targetOffsetMs;

        public static final class Builder {
            /* access modifiers changed from: private */
            public long maxOffsetMs;
            /* access modifiers changed from: private */
            public float maxPlaybackSpeed;
            /* access modifiers changed from: private */
            public long minOffsetMs;
            /* access modifiers changed from: private */
            public float minPlaybackSpeed;
            /* access modifiers changed from: private */
            public long targetOffsetMs;

            public Builder() {
                this.targetOffsetMs = C.TIME_UNSET;
                this.minOffsetMs = C.TIME_UNSET;
                this.maxOffsetMs = C.TIME_UNSET;
                this.minPlaybackSpeed = -3.4028235E38f;
                this.maxPlaybackSpeed = -3.4028235E38f;
            }

            private Builder(LiveConfiguration liveConfiguration) {
                this.targetOffsetMs = liveConfiguration.targetOffsetMs;
                this.minOffsetMs = liveConfiguration.minOffsetMs;
                this.maxOffsetMs = liveConfiguration.maxOffsetMs;
                this.minPlaybackSpeed = liveConfiguration.minPlaybackSpeed;
                this.maxPlaybackSpeed = liveConfiguration.maxPlaybackSpeed;
            }

            public Builder setTargetOffsetMs(long j) {
                this.targetOffsetMs = j;
                return this;
            }

            public Builder setMinOffsetMs(long j) {
                this.minOffsetMs = j;
                return this;
            }

            public Builder setMaxOffsetMs(long j) {
                this.maxOffsetMs = j;
                return this;
            }

            public Builder setMinPlaybackSpeed(float f) {
                this.minPlaybackSpeed = f;
                return this;
            }

            public Builder setMaxPlaybackSpeed(float f) {
                this.maxPlaybackSpeed = f;
                return this;
            }

            public LiveConfiguration build() {
                return new LiveConfiguration(this);
            }
        }

        private LiveConfiguration(Builder builder) {
            this(builder.targetOffsetMs, builder.minOffsetMs, builder.maxOffsetMs, builder.minPlaybackSpeed, builder.maxPlaybackSpeed);
        }

        @Deprecated
        public LiveConfiguration(long j, long j2, long j3, float f, float f2) {
            this.targetOffsetMs = j;
            this.minOffsetMs = j2;
            this.maxOffsetMs = j3;
            this.minPlaybackSpeed = f;
            this.maxPlaybackSpeed = f2;
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LiveConfiguration)) {
                return false;
            }
            LiveConfiguration liveConfiguration = (LiveConfiguration) obj;
            if (this.targetOffsetMs == liveConfiguration.targetOffsetMs && this.minOffsetMs == liveConfiguration.minOffsetMs && this.maxOffsetMs == liveConfiguration.maxOffsetMs && this.minPlaybackSpeed == liveConfiguration.minPlaybackSpeed && this.maxPlaybackSpeed == liveConfiguration.maxPlaybackSpeed) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j = this.targetOffsetMs;
            long j2 = this.minOffsetMs;
            long j3 = this.maxOffsetMs;
            int i = ((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31;
            float f = this.minPlaybackSpeed;
            int i2 = 0;
            int floatToIntBits = (i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
            float f2 = this.maxPlaybackSpeed;
            if (f2 != 0.0f) {
                i2 = Float.floatToIntBits(f2);
            }
            return floatToIntBits + i2;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(keyForField(0), this.targetOffsetMs);
            bundle.putLong(keyForField(1), this.minOffsetMs);
            bundle.putLong(keyForField(2), this.maxOffsetMs);
            bundle.putFloat(keyForField(3), this.minPlaybackSpeed);
            bundle.putFloat(keyForField(4), this.maxPlaybackSpeed);
            return bundle;
        }

        static /* synthetic */ LiveConfiguration lambda$static$0(Bundle bundle) {
            return new LiveConfiguration(bundle.getLong(keyForField(0), C.TIME_UNSET), bundle.getLong(keyForField(1), C.TIME_UNSET), bundle.getLong(keyForField(2), C.TIME_UNSET), bundle.getFloat(keyForField(3), -3.4028235E38f), bundle.getFloat(keyForField(4), -3.4028235E38f));
        }

        private static String keyForField(int i) {
            return Integer.toString(i, 36);
        }
    }

    public static class SubtitleConfiguration {
        public final String id;
        public final String label;
        public final String language;
        public final String mimeType;
        public final int roleFlags;
        public final int selectionFlags;
        public final Uri uri;

        public static final class Builder {
            /* access modifiers changed from: private */
            public String id;
            /* access modifiers changed from: private */
            public String label;
            /* access modifiers changed from: private */
            public String language;
            /* access modifiers changed from: private */
            public String mimeType;
            /* access modifiers changed from: private */
            public int roleFlags;
            /* access modifiers changed from: private */
            public int selectionFlags;
            /* access modifiers changed from: private */
            public Uri uri;

            public Builder(Uri uri2) {
                this.uri = uri2;
            }

            private Builder(SubtitleConfiguration subtitleConfiguration) {
                this.uri = subtitleConfiguration.uri;
                this.mimeType = subtitleConfiguration.mimeType;
                this.language = subtitleConfiguration.language;
                this.selectionFlags = subtitleConfiguration.selectionFlags;
                this.roleFlags = subtitleConfiguration.roleFlags;
                this.label = subtitleConfiguration.label;
                this.id = subtitleConfiguration.id;
            }

            public Builder setUri(Uri uri2) {
                this.uri = uri2;
                return this;
            }

            public Builder setMimeType(String str) {
                this.mimeType = str;
                return this;
            }

            public Builder setLanguage(String str) {
                this.language = str;
                return this;
            }

            public Builder setSelectionFlags(int i) {
                this.selectionFlags = i;
                return this;
            }

            public Builder setRoleFlags(int i) {
                this.roleFlags = i;
                return this;
            }

            public Builder setLabel(String str) {
                this.label = str;
                return this;
            }

            public Builder setId(String str) {
                this.id = str;
                return this;
            }

            public SubtitleConfiguration build() {
                return new SubtitleConfiguration(this);
            }

            /* access modifiers changed from: private */
            public Subtitle buildSubtitle() {
                return new Subtitle(this);
            }
        }

        private SubtitleConfiguration(Uri uri2, String str, String str2, int i, int i2, String str3, String str4) {
            this.uri = uri2;
            this.mimeType = str;
            this.language = str2;
            this.selectionFlags = i;
            this.roleFlags = i2;
            this.label = str3;
            this.id = str4;
        }

        private SubtitleConfiguration(Builder builder) {
            this.uri = builder.uri;
            this.mimeType = builder.mimeType;
            this.language = builder.language;
            this.selectionFlags = builder.selectionFlags;
            this.roleFlags = builder.roleFlags;
            this.label = builder.label;
            this.id = builder.id;
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubtitleConfiguration)) {
                return false;
            }
            SubtitleConfiguration subtitleConfiguration = (SubtitleConfiguration) obj;
            if (!this.uri.equals(subtitleConfiguration.uri) || !Util.areEqual(this.mimeType, subtitleConfiguration.mimeType) || !Util.areEqual(this.language, subtitleConfiguration.language) || this.selectionFlags != subtitleConfiguration.selectionFlags || this.roleFlags != subtitleConfiguration.roleFlags || !Util.areEqual(this.label, subtitleConfiguration.label) || !Util.areEqual(this.id, subtitleConfiguration.id)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.uri.hashCode() * 31;
            String str = this.mimeType;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.language;
            int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31;
            String str3 = this.label;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.id;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode4 + i;
        }
    }

    @Deprecated
    public static final class Subtitle extends SubtitleConfiguration {
        @Deprecated
        public Subtitle(Uri uri, String str, String str2) {
            this(uri, str, str2, 0);
        }

        @Deprecated
        public Subtitle(Uri uri, String str, String str2, int i) {
            this(uri, str, str2, i, 0, (String) null);
        }

        @Deprecated
        public Subtitle(Uri uri, String str, String str2, int i, int i2, String str3) {
            super(uri, str, str2, i, i2, str3, (String) null);
        }

        private Subtitle(SubtitleConfiguration.Builder builder) {
            super(builder);
        }
    }

    public static class ClippingConfiguration implements Bundleable {
        public static final Bundleable.Creator<ClippingProperties> CREATOR = new MediaItem$ClippingConfiguration$$ExternalSyntheticLambda0();
        private static final int FIELD_END_POSITION_MS = 1;
        private static final int FIELD_RELATIVE_TO_DEFAULT_POSITION = 3;
        private static final int FIELD_RELATIVE_TO_LIVE_WINDOW = 2;
        private static final int FIELD_STARTS_AT_KEY_FRAME = 4;
        private static final int FIELD_START_POSITION_MS = 0;
        public static final ClippingConfiguration UNSET = new Builder().build();
        public final long endPositionMs;
        public final boolean relativeToDefaultPosition;
        public final boolean relativeToLiveWindow;
        public final long startPositionMs;
        public final boolean startsAtKeyFrame;

        public static final class Builder {
            /* access modifiers changed from: private */
            public long endPositionMs;
            /* access modifiers changed from: private */
            public boolean relativeToDefaultPosition;
            /* access modifiers changed from: private */
            public boolean relativeToLiveWindow;
            /* access modifiers changed from: private */
            public long startPositionMs;
            /* access modifiers changed from: private */
            public boolean startsAtKeyFrame;

            public Builder() {
                this.endPositionMs = Long.MIN_VALUE;
            }

            private Builder(ClippingConfiguration clippingConfiguration) {
                this.startPositionMs = clippingConfiguration.startPositionMs;
                this.endPositionMs = clippingConfiguration.endPositionMs;
                this.relativeToLiveWindow = clippingConfiguration.relativeToLiveWindow;
                this.relativeToDefaultPosition = clippingConfiguration.relativeToDefaultPosition;
                this.startsAtKeyFrame = clippingConfiguration.startsAtKeyFrame;
            }

            public Builder setStartPositionMs(long j) {
                Assertions.checkArgument(j >= 0);
                this.startPositionMs = j;
                return this;
            }

            public Builder setEndPositionMs(long j) {
                Assertions.checkArgument(j == Long.MIN_VALUE || j >= 0);
                this.endPositionMs = j;
                return this;
            }

            public Builder setRelativeToLiveWindow(boolean z) {
                this.relativeToLiveWindow = z;
                return this;
            }

            public Builder setRelativeToDefaultPosition(boolean z) {
                this.relativeToDefaultPosition = z;
                return this;
            }

            public Builder setStartsAtKeyFrame(boolean z) {
                this.startsAtKeyFrame = z;
                return this;
            }

            public ClippingConfiguration build() {
                return buildClippingProperties();
            }

            @Deprecated
            public ClippingProperties buildClippingProperties() {
                return new ClippingProperties(this);
            }
        }

        private ClippingConfiguration(Builder builder) {
            this.startPositionMs = builder.startPositionMs;
            this.endPositionMs = builder.endPositionMs;
            this.relativeToLiveWindow = builder.relativeToLiveWindow;
            this.relativeToDefaultPosition = builder.relativeToDefaultPosition;
            this.startsAtKeyFrame = builder.startsAtKeyFrame;
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClippingConfiguration)) {
                return false;
            }
            ClippingConfiguration clippingConfiguration = (ClippingConfiguration) obj;
            if (this.startPositionMs == clippingConfiguration.startPositionMs && this.endPositionMs == clippingConfiguration.endPositionMs && this.relativeToLiveWindow == clippingConfiguration.relativeToLiveWindow && this.relativeToDefaultPosition == clippingConfiguration.relativeToDefaultPosition && this.startsAtKeyFrame == clippingConfiguration.startsAtKeyFrame) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j = this.startPositionMs;
            long j2 = this.endPositionMs;
            return (((((((((int) (j ^ (j >>> 32))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + (this.relativeToLiveWindow ? 1 : 0)) * 31) + (this.relativeToDefaultPosition ? 1 : 0)) * 31) + (this.startsAtKeyFrame ? 1 : 0);
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(keyForField(0), this.startPositionMs);
            bundle.putLong(keyForField(1), this.endPositionMs);
            bundle.putBoolean(keyForField(2), this.relativeToLiveWindow);
            bundle.putBoolean(keyForField(3), this.relativeToDefaultPosition);
            bundle.putBoolean(keyForField(4), this.startsAtKeyFrame);
            return bundle;
        }

        private static String keyForField(int i) {
            return Integer.toString(i, 36);
        }
    }

    @Deprecated
    public static final class ClippingProperties extends ClippingConfiguration {
        public static final ClippingProperties UNSET = new ClippingConfiguration.Builder().buildClippingProperties();

        private ClippingProperties(ClippingConfiguration.Builder builder) {
            super(builder);
        }
    }

    public static final class RequestMetadata implements Bundleable {
        public static final Bundleable.Creator<RequestMetadata> CREATOR = new MediaItem$RequestMetadata$$ExternalSyntheticLambda0();
        public static final RequestMetadata EMPTY = new Builder().build();
        private static final int FIELD_EXTRAS = 2;
        private static final int FIELD_MEDIA_URI = 0;
        private static final int FIELD_SEARCH_QUERY = 1;
        public final Bundle extras;
        public final Uri mediaUri;
        public final String searchQuery;

        public static final class Builder {
            /* access modifiers changed from: private */
            public Bundle extras;
            /* access modifiers changed from: private */
            public Uri mediaUri;
            /* access modifiers changed from: private */
            public String searchQuery;

            public Builder() {
            }

            private Builder(RequestMetadata requestMetadata) {
                this.mediaUri = requestMetadata.mediaUri;
                this.searchQuery = requestMetadata.searchQuery;
                this.extras = requestMetadata.extras;
            }

            public Builder setMediaUri(Uri uri) {
                this.mediaUri = uri;
                return this;
            }

            public Builder setSearchQuery(String str) {
                this.searchQuery = str;
                return this;
            }

            public Builder setExtras(Bundle bundle) {
                this.extras = bundle;
                return this;
            }

            public RequestMetadata build() {
                return new RequestMetadata(this);
            }
        }

        private RequestMetadata(Builder builder) {
            this.mediaUri = builder.mediaUri;
            this.searchQuery = builder.searchQuery;
            this.extras = builder.extras;
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestMetadata)) {
                return false;
            }
            RequestMetadata requestMetadata = (RequestMetadata) obj;
            if (!Util.areEqual(this.mediaUri, requestMetadata.mediaUri) || !Util.areEqual(this.searchQuery, requestMetadata.searchQuery)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            Uri uri = this.mediaUri;
            int i = 0;
            int hashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.searchQuery;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            if (this.mediaUri != null) {
                bundle.putParcelable(keyForField(0), this.mediaUri);
            }
            if (this.searchQuery != null) {
                bundle.putString(keyForField(1), this.searchQuery);
            }
            if (this.extras != null) {
                bundle.putBundle(keyForField(2), this.extras);
            }
            return bundle;
        }

        private static String keyForField(int i) {
            return Integer.toString(i, 36);
        }
    }

    private MediaItem(String str, ClippingProperties clippingProperties2, PlaybackProperties playbackProperties2, LiveConfiguration liveConfiguration2, MediaMetadata mediaMetadata2, RequestMetadata requestMetadata2) {
        this.mediaId = str;
        this.localConfiguration = playbackProperties2;
        this.playbackProperties = playbackProperties2;
        this.liveConfiguration = liveConfiguration2;
        this.mediaMetadata = mediaMetadata2;
        this.clippingConfiguration = clippingProperties2;
        this.clippingProperties = clippingProperties2;
        this.requestMetadata = requestMetadata2;
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) obj;
        if (!Util.areEqual(this.mediaId, mediaItem.mediaId) || !this.clippingConfiguration.equals(mediaItem.clippingConfiguration) || !Util.areEqual(this.localConfiguration, mediaItem.localConfiguration) || !Util.areEqual(this.liveConfiguration, mediaItem.liveConfiguration) || !Util.areEqual(this.mediaMetadata, mediaItem.mediaMetadata) || !Util.areEqual(this.requestMetadata, mediaItem.requestMetadata)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.mediaId.hashCode() * 31;
        LocalConfiguration localConfiguration2 = this.localConfiguration;
        return ((((((((hashCode + (localConfiguration2 != null ? localConfiguration2.hashCode() : 0)) * 31) + this.liveConfiguration.hashCode()) * 31) + this.clippingConfiguration.hashCode()) * 31) + this.mediaMetadata.hashCode()) * 31) + this.requestMetadata.hashCode();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(keyForField(0), this.mediaId);
        bundle.putBundle(keyForField(1), this.liveConfiguration.toBundle());
        bundle.putBundle(keyForField(2), this.mediaMetadata.toBundle());
        bundle.putBundle(keyForField(3), this.clippingConfiguration.toBundle());
        bundle.putBundle(keyForField(4), this.requestMetadata.toBundle());
        return bundle;
    }

    /* access modifiers changed from: private */
    public static MediaItem fromBundle(Bundle bundle) {
        LiveConfiguration liveConfiguration2;
        MediaMetadata mediaMetadata2;
        ClippingProperties clippingProperties2;
        RequestMetadata requestMetadata2;
        String str = (String) Assertions.checkNotNull(bundle.getString(keyForField(0), ""));
        Bundle bundle2 = bundle.getBundle(keyForField(1));
        if (bundle2 == null) {
            liveConfiguration2 = LiveConfiguration.UNSET;
        } else {
            liveConfiguration2 = LiveConfiguration.CREATOR.fromBundle(bundle2);
        }
        LiveConfiguration liveConfiguration3 = liveConfiguration2;
        Bundle bundle3 = bundle.getBundle(keyForField(2));
        if (bundle3 == null) {
            mediaMetadata2 = MediaMetadata.EMPTY;
        } else {
            mediaMetadata2 = MediaMetadata.CREATOR.fromBundle(bundle3);
        }
        MediaMetadata mediaMetadata3 = mediaMetadata2;
        Bundle bundle4 = bundle.getBundle(keyForField(3));
        if (bundle4 == null) {
            clippingProperties2 = ClippingProperties.UNSET;
        } else {
            clippingProperties2 = ClippingConfiguration.CREATOR.fromBundle(bundle4);
        }
        ClippingProperties clippingProperties3 = clippingProperties2;
        Bundle bundle5 = bundle.getBundle(keyForField(4));
        if (bundle5 == null) {
            requestMetadata2 = RequestMetadata.EMPTY;
        } else {
            requestMetadata2 = RequestMetadata.CREATOR.fromBundle(bundle5);
        }
        return new MediaItem(str, clippingProperties3, (PlaybackProperties) null, liveConfiguration3, mediaMetadata3, requestMetadata2);
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }
}
