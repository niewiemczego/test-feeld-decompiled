package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Descriptor;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class DashMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<DashChunkSource>>, ChunkSampleStream.ReleaseCallback<DashChunkSource> {
    private static final Pattern CEA608_SERVICE_DESCRIPTOR_REGEX = Pattern.compile("CC([1-4])=(.+)");
    private static final Pattern CEA708_SERVICE_DESCRIPTOR_REGEX = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    private final Allocator allocator;
    private final BaseUrlExclusionList baseUrlExclusionList;
    private MediaPeriod.Callback callback;
    private final DashChunkSource.Factory chunkSourceFactory;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private final long elapsedRealtimeOffsetMs;
    private EventSampleStream[] eventSampleStreams = new EventSampleStream[0];
    private List<EventStream> eventStreams;
    final int id;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final MediaSourceEventListener.EventDispatcher mediaSourceEventDispatcher;
    private int periodIndex;
    private final PlayerEmsgHandler playerEmsgHandler;
    private final PlayerId playerId;
    private ChunkSampleStream<DashChunkSource>[] sampleStreams = newSampleStreamArray(0);
    private final IdentityHashMap<ChunkSampleStream<DashChunkSource>, PlayerEmsgHandler.PlayerTrackEmsgHandler> trackEmsgHandlerBySampleStream = new IdentityHashMap<>();
    private final TrackGroupInfo[] trackGroupInfos;
    private final TrackGroupArray trackGroups;
    private final TransferListener transferListener;

    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    public DashMediaPeriod(int i, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList2, int i2, DashChunkSource.Factory factory, TransferListener transferListener2, DrmSessionManager drmSessionManager2, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2, long j, LoaderErrorThrower loaderErrorThrower, Allocator allocator2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback, PlayerId playerId2) {
        Allocator allocator3 = allocator2;
        CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory3 = compositeSequenceableLoaderFactory2;
        this.id = i;
        this.manifest = dashManifest;
        this.baseUrlExclusionList = baseUrlExclusionList2;
        this.periodIndex = i2;
        this.chunkSourceFactory = factory;
        this.transferListener = transferListener2;
        this.drmSessionManager = drmSessionManager2;
        this.drmEventDispatcher = eventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.mediaSourceEventDispatcher = eventDispatcher2;
        this.elapsedRealtimeOffsetMs = j;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.allocator = allocator3;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory3;
        this.playerId = playerId2;
        this.playerEmsgHandler = new PlayerEmsgHandler(dashManifest, playerEmsgCallback, allocator3);
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory3.createCompositeSequenceableLoader(this.sampleStreams);
        Period period = dashManifest.getPeriod(i2);
        this.eventStreams = period.eventStreams;
        Pair<TrackGroupArray, TrackGroupInfo[]> buildTrackGroups = buildTrackGroups(drmSessionManager2, period.adaptationSets, this.eventStreams);
        this.trackGroups = (TrackGroupArray) buildTrackGroups.first;
        this.trackGroupInfos = (TrackGroupInfo[]) buildTrackGroups.second;
    }

    public void updateManifest(DashManifest dashManifest, int i) {
        this.manifest = dashManifest;
        this.periodIndex = i;
        this.playerEmsgHandler.updateManifest(dashManifest);
        ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArr = this.sampleStreams;
        if (chunkSampleStreamArr != null) {
            for (ChunkSampleStream<DashChunkSource> chunkSource : chunkSampleStreamArr) {
                chunkSource.getChunkSource().updateManifest(dashManifest, i);
            }
            this.callback.onContinueLoadingRequested(this);
        }
        this.eventStreams = dashManifest.getPeriod(i).eventStreams;
        for (EventSampleStream eventSampleStream : this.eventSampleStreams) {
            Iterator<EventStream> it = this.eventStreams.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EventStream next = it.next();
                if (next.id().equals(eventSampleStream.eventStreamId())) {
                    boolean z = true;
                    int periodCount = dashManifest.getPeriodCount() - 1;
                    if (!dashManifest.dynamic || i != periodCount) {
                        z = false;
                    }
                    eventSampleStream.updateEventStream(next, z);
                }
            }
        }
    }

    public void release() {
        this.playerEmsgHandler.release();
        for (ChunkSampleStream<DashChunkSource> release : this.sampleStreams) {
            release.release(this);
        }
        this.callback = null;
    }

    public synchronized void onSampleStreamReleased(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        PlayerEmsgHandler.PlayerTrackEmsgHandler remove = this.trackEmsgHandlerBySampleStream.remove(chunkSampleStream);
        if (remove != null) {
            remove.release();
        }
    }

    public void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        callback2.onPrepared(this);
    }

    public void maybeThrowPrepareError() throws IOException {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        List<AdaptationSet> list2 = this.manifest.getPeriod(this.periodIndex).adaptationSets;
        ArrayList arrayList = new ArrayList();
        for (ExoTrackSelection next : list) {
            TrackGroupInfo trackGroupInfo = this.trackGroupInfos[this.trackGroups.indexOf(next.getTrackGroup())];
            if (trackGroupInfo.trackGroupCategory == 0) {
                int[] iArr = trackGroupInfo.adaptationSetIndices;
                int length = next.length();
                int[] iArr2 = new int[length];
                for (int i = 0; i < next.length(); i++) {
                    iArr2[i] = next.getIndexInTrackGroup(i);
                }
                Arrays.sort(iArr2);
                int size = list2.get(iArr[0]).representations.size();
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = iArr2[i4];
                    while (true) {
                        int i6 = i3 + size;
                        if (i5 < i6) {
                            break;
                        }
                        i2++;
                        size = list2.get(iArr[i2]).representations.size();
                        i3 = i6;
                    }
                    arrayList.add(new StreamKey(this.periodIndex, iArr[i2], i5 - i3));
                }
            }
        }
        return arrayList;
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        int[] streamIndexToTrackGroupIndex = getStreamIndexToTrackGroupIndex(exoTrackSelectionArr);
        releaseDisabledStreams(exoTrackSelectionArr, zArr, sampleStreamArr);
        releaseOrphanEmbeddedStreams(exoTrackSelectionArr, sampleStreamArr, streamIndexToTrackGroupIndex);
        selectNewStreams(exoTrackSelectionArr, sampleStreamArr, zArr2, j, streamIndexToTrackGroupIndex);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ChunkSampleStream chunkSampleStream : sampleStreamArr) {
            if (chunkSampleStream instanceof ChunkSampleStream) {
                arrayList.add(chunkSampleStream);
            } else if (chunkSampleStream instanceof EventSampleStream) {
                arrayList2.add((EventSampleStream) chunkSampleStream);
            }
        }
        ChunkSampleStream<DashChunkSource>[] newSampleStreamArray = newSampleStreamArray(arrayList.size());
        this.sampleStreams = newSampleStreamArray;
        arrayList.toArray(newSampleStreamArray);
        EventSampleStream[] eventSampleStreamArr = new EventSampleStream[arrayList2.size()];
        this.eventSampleStreams = eventSampleStreamArr;
        arrayList2.toArray(eventSampleStreamArr);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.sampleStreams);
        return j;
    }

    public void discardBuffer(long j, boolean z) {
        for (ChunkSampleStream<DashChunkSource> discardBuffer : this.sampleStreams) {
            discardBuffer.discardBuffer(j, z);
        }
    }

    public void reevaluateBuffer(long j) {
        this.compositeSequenceableLoader.reevaluateBuffer(j);
    }

    public boolean continueLoading(long j) {
        return this.compositeSequenceableLoader.continueLoading(j);
    }

    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public long seekToUs(long j) {
        for (ChunkSampleStream<DashChunkSource> seekToUs : this.sampleStreams) {
            seekToUs.seekToUs(j);
        }
        for (EventSampleStream seekToUs2 : this.eventSampleStreams) {
            seekToUs2.seekToUs(j);
        }
        return j;
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
            if (chunkSampleStream.primaryTrackType == 2) {
                return chunkSampleStream.getAdjustedSeekPositionUs(j, seekParameters);
            }
        }
        return j;
    }

    public void onContinueLoadingRequested(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        this.callback.onContinueLoadingRequested(this);
    }

    private int[] getStreamIndexToTrackGroupIndex(ExoTrackSelection[] exoTrackSelectionArr) {
        int[] iArr = new int[exoTrackSelectionArr.length];
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i];
            if (exoTrackSelection != null) {
                iArr[i] = this.trackGroups.indexOf(exoTrackSelection.getTrackGroup());
            } else {
                iArr[i] = -1;
            }
        }
        return iArr;
    }

    private void releaseDisabledStreams(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr) {
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            if (exoTrackSelectionArr[i] == null || !zArr[i]) {
                ChunkSampleStream chunkSampleStream = sampleStreamArr[i];
                if (chunkSampleStream instanceof ChunkSampleStream) {
                    chunkSampleStream.release(this);
                } else if (chunkSampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) {
                    ((ChunkSampleStream.EmbeddedSampleStream) chunkSampleStream).release();
                }
                sampleStreamArr[i] = null;
            }
        }
    }

    private void releaseOrphanEmbeddedStreams(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, int[] iArr) {
        boolean z;
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            SampleStream sampleStream = sampleStreamArr[i];
            if ((sampleStream instanceof EmptySampleStream) || (sampleStream instanceof ChunkSampleStream.EmbeddedSampleStream)) {
                int primaryStreamIndex = getPrimaryStreamIndex(i, iArr);
                if (primaryStreamIndex == -1) {
                    z = sampleStreamArr[i] instanceof EmptySampleStream;
                } else {
                    ChunkSampleStream.EmbeddedSampleStream embeddedSampleStream = sampleStreamArr[i];
                    z = (embeddedSampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) && embeddedSampleStream.parent == sampleStreamArr[primaryStreamIndex];
                }
                if (!z) {
                    ChunkSampleStream.EmbeddedSampleStream embeddedSampleStream2 = sampleStreamArr[i];
                    if (embeddedSampleStream2 instanceof ChunkSampleStream.EmbeddedSampleStream) {
                        embeddedSampleStream2.release();
                    }
                    sampleStreamArr[i] = null;
                }
            }
        }
    }

    private void selectNewStreams(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, boolean[] zArr, long j, int[] iArr) {
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i];
            if (exoTrackSelection != null) {
                ChunkSampleStream chunkSampleStream = sampleStreamArr[i];
                if (chunkSampleStream == null) {
                    zArr[i] = true;
                    TrackGroupInfo trackGroupInfo = this.trackGroupInfos[iArr[i]];
                    if (trackGroupInfo.trackGroupCategory == 0) {
                        sampleStreamArr[i] = buildSampleStream(trackGroupInfo, exoTrackSelection, j);
                    } else if (trackGroupInfo.trackGroupCategory == 2) {
                        sampleStreamArr[i] = new EventSampleStream(this.eventStreams.get(trackGroupInfo.eventStreamGroupIndex), exoTrackSelection.getTrackGroup().getFormat(0), this.manifest.dynamic);
                    }
                } else if (chunkSampleStream instanceof ChunkSampleStream) {
                    ((DashChunkSource) chunkSampleStream.getChunkSource()).updateTrackSelection(exoTrackSelection);
                }
            }
        }
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            if (sampleStreamArr[i2] == null && exoTrackSelectionArr[i2] != null) {
                TrackGroupInfo trackGroupInfo2 = this.trackGroupInfos[iArr[i2]];
                if (trackGroupInfo2.trackGroupCategory == 1) {
                    int primaryStreamIndex = getPrimaryStreamIndex(i2, iArr);
                    if (primaryStreamIndex == -1) {
                        sampleStreamArr[i2] = new EmptySampleStream();
                    } else {
                        sampleStreamArr[i2] = sampleStreamArr[primaryStreamIndex].selectEmbeddedTrack(j, trackGroupInfo2.trackType);
                    }
                }
            }
        }
    }

    private int getPrimaryStreamIndex(int i, int[] iArr) {
        int i2 = iArr[i];
        if (i2 == -1) {
            return -1;
        }
        int i3 = this.trackGroupInfos[i2].primaryTrackGroupIndex;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 == i3 && this.trackGroupInfos[i5].trackGroupCategory == 0) {
                return i4;
            }
        }
        return -1;
    }

    private static Pair<TrackGroupArray, TrackGroupInfo[]> buildTrackGroups(DrmSessionManager drmSessionManager2, List<AdaptationSet> list, List<EventStream> list2) {
        int[][] groupedAdaptationSetIndices = getGroupedAdaptationSetIndices(list);
        int length = groupedAdaptationSetIndices.length;
        boolean[] zArr = new boolean[length];
        Format[][] formatArr = new Format[length][];
        int identifyEmbeddedTracks = identifyEmbeddedTracks(length, list, groupedAdaptationSetIndices, zArr, formatArr) + length + list2.size();
        TrackGroup[] trackGroupArr = new TrackGroup[identifyEmbeddedTracks];
        TrackGroupInfo[] trackGroupInfoArr = new TrackGroupInfo[identifyEmbeddedTracks];
        buildManifestEventTrackGroupInfos(list2, trackGroupArr, trackGroupInfoArr, buildPrimaryAndEmbeddedTrackGroupInfos(drmSessionManager2, list, groupedAdaptationSetIndices, length, zArr, formatArr, trackGroupArr, trackGroupInfoArr));
        return Pair.create(new TrackGroupArray(trackGroupArr), trackGroupInfoArr);
    }

    private static int[][] getGroupedAdaptationSetIndices(List<AdaptationSet> list) {
        int i;
        Descriptor findAdaptationSetSwitchingProperty;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i2 = 0; i2 < size; i2++) {
            sparseIntArray.put(list.get(i2).id, i2);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i2));
            arrayList.add(arrayList2);
            sparseArray.put(i2, arrayList2);
        }
        for (int i3 = 0; i3 < size; i3++) {
            AdaptationSet adaptationSet = list.get(i3);
            Descriptor findTrickPlayProperty = findTrickPlayProperty(adaptationSet.essentialProperties);
            if (findTrickPlayProperty == null) {
                findTrickPlayProperty = findTrickPlayProperty(adaptationSet.supplementalProperties);
            }
            if (findTrickPlayProperty == null || (i = sparseIntArray.get(Integer.parseInt(findTrickPlayProperty.value), -1)) == -1) {
                i = i3;
            }
            if (i == i3 && (findAdaptationSetSwitchingProperty = findAdaptationSetSwitchingProperty(adaptationSet.supplementalProperties)) != null) {
                for (String parseInt : Util.split(findAdaptationSetSwitchingProperty.value, ",")) {
                    int i4 = sparseIntArray.get(Integer.parseInt(parseInt), -1);
                    if (i4 != -1) {
                        i = Math.min(i, i4);
                    }
                }
            }
            if (i != i3) {
                List list2 = (List) sparseArray.get(i3);
                List list3 = (List) sparseArray.get(i);
                list3.addAll(list2);
                sparseArray.put(i3, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i5 = 0; i5 < size2; i5++) {
            int[] array = Ints.toArray((Collection) arrayList.get(i5));
            iArr[i5] = array;
            Arrays.sort(array);
        }
        return iArr;
    }

    private static int identifyEmbeddedTracks(int i, List<AdaptationSet> list, int[][] iArr, boolean[] zArr, Format[][] formatArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (hasEventMessageTrack(list, iArr[i3])) {
                zArr[i3] = true;
                i2++;
            }
            Format[] closedCaptionTrackFormats = getClosedCaptionTrackFormats(list, iArr[i3]);
            formatArr[i3] = closedCaptionTrackFormats;
            if (closedCaptionTrackFormats.length != 0) {
                i2++;
            }
        }
        return i2;
    }

    private static int buildPrimaryAndEmbeddedTrackGroupInfos(DrmSessionManager drmSessionManager2, List<AdaptationSet> list, int[][] iArr, int i, boolean[] zArr, Format[][] formatArr, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr) {
        String str;
        int i2;
        int i3;
        List<AdaptationSet> list2 = list;
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            int[] iArr2 = iArr[i5];
            ArrayList arrayList = new ArrayList();
            for (int i7 : iArr2) {
                arrayList.addAll(list2.get(i7).representations);
            }
            int size = arrayList.size();
            Format[] formatArr2 = new Format[size];
            for (int i8 = 0; i8 < size; i8++) {
                Format format = ((Representation) arrayList.get(i8)).format;
                formatArr2[i8] = format.copyWithCryptoType(drmSessionManager2.getCryptoType(format));
            }
            DrmSessionManager drmSessionManager3 = drmSessionManager2;
            AdaptationSet adaptationSet = list2.get(iArr2[0]);
            if (adaptationSet.id != -1) {
                str = Integer.toString(adaptationSet.id);
            } else {
                str = "unset:" + i5;
            }
            int i9 = i6 + 1;
            if (zArr[i5]) {
                i2 = i9 + 1;
            } else {
                i2 = i9;
                i9 = -1;
            }
            if (formatArr[i5].length != 0) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
                i2 = -1;
            }
            trackGroupArr[i6] = new TrackGroup(str, formatArr2);
            trackGroupInfoArr[i6] = TrackGroupInfo.primaryTrack(adaptationSet.type, iArr2, i6, i9, i2);
            if (i9 != -1) {
                String str2 = str + ":emsg";
                trackGroupArr[i9] = new TrackGroup(str2, new Format.Builder().setId(str2).setSampleMimeType(MimeTypes.APPLICATION_EMSG).build());
                trackGroupInfoArr[i9] = TrackGroupInfo.embeddedEmsgTrack(iArr2, i6);
            }
            if (i2 != -1) {
                trackGroupArr[i2] = new TrackGroup(str + ":cc", formatArr[i5]);
                trackGroupInfoArr[i2] = TrackGroupInfo.embeddedClosedCaptionTrack(iArr2, i6);
            }
            i5++;
            i6 = i3;
        }
        return i6;
    }

    private static void buildManifestEventTrackGroupInfos(List<EventStream> list, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr, int i) {
        int i2 = 0;
        while (i2 < list.size()) {
            EventStream eventStream = list.get(i2);
            trackGroupArr[i] = new TrackGroup(eventStream.id() + CertificateUtil.DELIMITER + i2, new Format.Builder().setId(eventStream.id()).setSampleMimeType(MimeTypes.APPLICATION_EMSG).build());
            trackGroupInfoArr[i] = TrackGroupInfo.mpdEventTrack(i2);
            i2++;
            i++;
        }
    }

    private ChunkSampleStream<DashChunkSource> buildSampleStream(TrackGroupInfo trackGroupInfo, ExoTrackSelection exoTrackSelection, long j) {
        int i;
        TrackGroup trackGroup;
        TrackGroup trackGroup2;
        int i2;
        TrackGroupInfo trackGroupInfo2 = trackGroupInfo;
        boolean z = trackGroupInfo2.embeddedEventMessageTrackGroupIndex != -1;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = null;
        if (z) {
            trackGroup = this.trackGroups.get(trackGroupInfo2.embeddedEventMessageTrackGroupIndex);
            i = 1;
        } else {
            trackGroup = null;
            i = 0;
        }
        boolean z2 = trackGroupInfo2.embeddedClosedCaptionTrackGroupIndex != -1;
        if (z2) {
            trackGroup2 = this.trackGroups.get(trackGroupInfo2.embeddedClosedCaptionTrackGroupIndex);
            i += trackGroup2.length;
        } else {
            trackGroup2 = null;
        }
        Format[] formatArr = new Format[i];
        int[] iArr = new int[i];
        if (z) {
            formatArr[0] = trackGroup.getFormat(0);
            iArr[0] = 5;
            i2 = 1;
        } else {
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            for (int i3 = 0; i3 < trackGroup2.length; i3++) {
                Format format = trackGroup2.getFormat(i3);
                formatArr[i2] = format;
                iArr[i2] = 3;
                arrayList.add(format);
                i2++;
            }
        }
        if (this.manifest.dynamic && z) {
            playerTrackEmsgHandler = this.playerEmsgHandler.newPlayerTrackEmsgHandler();
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = playerTrackEmsgHandler;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler3 = playerTrackEmsgHandler2;
        ChunkSampleStream chunkSampleStream = new ChunkSampleStream(trackGroupInfo2.trackType, iArr, formatArr, this.chunkSourceFactory.createDashChunkSource(this.manifestLoaderErrorThrower, this.manifest, this.baseUrlExclusionList, this.periodIndex, trackGroupInfo2.adaptationSetIndices, exoTrackSelection, trackGroupInfo2.trackType, this.elapsedRealtimeOffsetMs, z, arrayList, playerTrackEmsgHandler2, this.transferListener, this.playerId), this, this.allocator, j, this.drmSessionManager, this.drmEventDispatcher, this.loadErrorHandlingPolicy, this.mediaSourceEventDispatcher);
        synchronized (this) {
            this.trackEmsgHandlerBySampleStream.put(chunkSampleStream, playerTrackEmsgHandler3);
        }
        return chunkSampleStream;
    }

    private static Descriptor findAdaptationSetSwitchingProperty(List<Descriptor> list) {
        return findDescriptor(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    private static Descriptor findTrickPlayProperty(List<Descriptor> list) {
        return findDescriptor(list, "http://dashif.org/guidelines/trickmode");
    }

    private static Descriptor findDescriptor(List<Descriptor> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if (str.equals(descriptor.schemeIdUri)) {
                return descriptor;
            }
        }
        return null;
    }

    private static boolean hasEventMessageTrack(List<AdaptationSet> list, int[] iArr) {
        for (int i : iArr) {
            List<Representation> list2 = list.get(i).representations;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (!list2.get(i2).inbandEventStreams.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Format[] getClosedCaptionTrackFormats(List<AdaptationSet> list, int[] iArr) {
        for (int i : iArr) {
            AdaptationSet adaptationSet = list.get(i);
            List<Descriptor> list2 = list.get(i).accessibilityDescriptors;
            int i2 = 0;
            while (i2 < list2.size()) {
                Descriptor descriptor = list2.get(i2);
                if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri)) {
                    return parseClosedCaptionDescriptor(descriptor, CEA608_SERVICE_DESCRIPTOR_REGEX, new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_CEA608).setId(adaptationSet.id + ":cea608").build());
                } else if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri)) {
                    return parseClosedCaptionDescriptor(descriptor, CEA708_SERVICE_DESCRIPTOR_REGEX, new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_CEA708).setId(adaptationSet.id + ":cea708").build());
                } else {
                    i2++;
                }
            }
        }
        return new Format[0];
    }

    private static Format[] parseClosedCaptionDescriptor(Descriptor descriptor, Pattern pattern, Format format) {
        String str = descriptor.value;
        if (str == null) {
            return new Format[]{format};
        }
        String[] split = Util.split(str, ";");
        Format[] formatArr = new Format[split.length];
        for (int i = 0; i < split.length; i++) {
            Matcher matcher = pattern.matcher(split[i]);
            if (!matcher.matches()) {
                return new Format[]{format};
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            formatArr[i] = format.buildUpon().setId(format.id + CertificateUtil.DELIMITER + parseInt).setAccessibilityChannel(parseInt).setLanguage(matcher.group(2)).build();
        }
        return formatArr;
    }

    private static ChunkSampleStream<DashChunkSource>[] newSampleStreamArray(int i) {
        return new ChunkSampleStream[i];
    }

    private static final class TrackGroupInfo {
        private static final int CATEGORY_EMBEDDED = 1;
        private static final int CATEGORY_MANIFEST_EVENTS = 2;
        private static final int CATEGORY_PRIMARY = 0;
        public final int[] adaptationSetIndices;
        public final int embeddedClosedCaptionTrackGroupIndex;
        public final int embeddedEventMessageTrackGroupIndex;
        public final int eventStreamGroupIndex;
        public final int primaryTrackGroupIndex;
        public final int trackGroupCategory;
        public final int trackType;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface TrackGroupCategory {
        }

        public static TrackGroupInfo primaryTrack(int i, int[] iArr, int i2, int i3, int i4) {
            return new TrackGroupInfo(i, 0, iArr, i2, i3, i4, -1);
        }

        public static TrackGroupInfo embeddedEmsgTrack(int[] iArr, int i) {
            return new TrackGroupInfo(5, 1, iArr, i, -1, -1, -1);
        }

        public static TrackGroupInfo embeddedClosedCaptionTrack(int[] iArr, int i) {
            return new TrackGroupInfo(3, 1, iArr, i, -1, -1, -1);
        }

        public static TrackGroupInfo mpdEventTrack(int i) {
            return new TrackGroupInfo(5, 2, new int[0], -1, -1, -1, i);
        }

        private TrackGroupInfo(int i, int i2, int[] iArr, int i3, int i4, int i5, int i6) {
            this.trackType = i;
            this.adaptationSetIndices = iArr;
            this.trackGroupCategory = i2;
            this.primaryTrackGroupIndex = i3;
            this.embeddedEventMessageTrackGroupIndex = i4;
            this.embeddedClosedCaptionTrackGroupIndex = i5;
            this.eventStreamGroupIndex = i6;
        }
    }
}
