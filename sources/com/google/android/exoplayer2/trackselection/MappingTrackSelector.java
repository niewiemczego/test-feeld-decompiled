package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

public abstract class MappingTrackSelector extends TrackSelector {
    private MappedTrackInfo currentMappedTrackInfo;

    /* access modifiers changed from: protected */
    public abstract Pair<RendererConfiguration[], ExoTrackSelection[]> selectTracks(MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException;

    public static final class MappedTrackInfo {
        public static final int RENDERER_SUPPORT_EXCEEDS_CAPABILITIES_TRACKS = 2;
        public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
        public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 3;
        public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACKS = 1;
        private final int rendererCount;
        private final int[][][] rendererFormatSupports;
        private final int[] rendererMixedMimeTypeAdaptiveSupports;
        private final String[] rendererNames;
        private final TrackGroupArray[] rendererTrackGroups;
        private final int[] rendererTrackTypes;
        private final TrackGroupArray unmappedTrackGroups;

        @Documented
        @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface RendererSupport {
        }

        MappedTrackInfo(String[] strArr, int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.rendererNames = strArr;
            this.rendererTrackTypes = iArr;
            this.rendererTrackGroups = trackGroupArrayArr;
            this.rendererFormatSupports = iArr3;
            this.rendererMixedMimeTypeAdaptiveSupports = iArr2;
            this.unmappedTrackGroups = trackGroupArray;
            this.rendererCount = iArr.length;
        }

        public int getRendererCount() {
            return this.rendererCount;
        }

        public String getRendererName(int i) {
            return this.rendererNames[i];
        }

        public int getRendererType(int i) {
            return this.rendererTrackTypes[i];
        }

        public TrackGroupArray getTrackGroups(int i) {
            return this.rendererTrackGroups[i];
        }

        public int getRendererSupport(int i) {
            int i2 = 0;
            for (int[] iArr : this.rendererFormatSupports[i]) {
                for (int formatSupport : r11[r2]) {
                    int formatSupport2 = RendererCapabilities.getFormatSupport(formatSupport);
                    int i3 = 2;
                    if (formatSupport2 == 0 || formatSupport2 == 1 || formatSupport2 == 2) {
                        i3 = 1;
                    } else if (formatSupport2 != 3) {
                        if (formatSupport2 == 4) {
                            return 3;
                        }
                        throw new IllegalStateException();
                    }
                    i2 = Math.max(i2, i3);
                }
            }
            return i2;
        }

        public int getTypeSupport(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.rendererCount; i3++) {
                if (this.rendererTrackTypes[i3] == i) {
                    i2 = Math.max(i2, getRendererSupport(i3));
                }
            }
            return i2;
        }

        public int getCapabilities(int i, int i2, int i3) {
            return this.rendererFormatSupports[i][i2][i3];
        }

        public int getTrackSupport(int i, int i2, int i3) {
            return RendererCapabilities.getFormatSupport(getCapabilities(i, i2, i3));
        }

        public int getAdaptiveSupport(int i, int i2, boolean z) {
            int i3 = this.rendererTrackGroups[i].get(i2).length;
            int[] iArr = new int[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int trackSupport = getTrackSupport(i, i2, i5);
                if (trackSupport == 4 || (z && trackSupport == 3)) {
                    iArr[i4] = i5;
                    i4++;
                }
            }
            return getAdaptiveSupport(i, i2, Arrays.copyOf(iArr, i4));
        }

        public int getAdaptiveSupport(int i, int i2, int[] iArr) {
            int i3 = 0;
            int i4 = 16;
            String str = null;
            boolean z = false;
            int i5 = 0;
            while (i3 < iArr.length) {
                String str2 = this.rendererTrackGroups[i].get(i2).getFormat(iArr[i3]).sampleMimeType;
                int i6 = i5 + 1;
                if (i5 == 0) {
                    str = str2;
                } else {
                    z |= !Util.areEqual(str, str2);
                }
                i4 = Math.min(i4, RendererCapabilities.getAdaptiveSupport(this.rendererFormatSupports[i][i2][i3]));
                i3++;
                i5 = i6;
            }
            return z ? Math.min(i4, this.rendererMixedMimeTypeAdaptiveSupports[i]) : i4;
        }

        public TrackGroupArray getUnmappedTrackGroups() {
            return this.unmappedTrackGroups;
        }
    }

    public final MappedTrackInfo getCurrentMappedTrackInfo() {
        return this.currentMappedTrackInfo;
    }

    public final void onSelectionActivated(Object obj) {
        this.currentMappedTrackInfo = (MappedTrackInfo) obj;
    }

    public final TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException {
        int[] iArr;
        RendererCapabilities[] rendererCapabilitiesArr2 = rendererCapabilitiesArr;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        int[] iArr2 = new int[(rendererCapabilitiesArr2.length + 1)];
        int length = rendererCapabilitiesArr2.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr3 = new int[(rendererCapabilitiesArr2.length + 1)][][];
        for (int i = 0; i < length; i++) {
            trackGroupArr[i] = new TrackGroup[trackGroupArray2.length];
            iArr3[i] = new int[trackGroupArray2.length][];
        }
        int[] mixedMimeTypeAdaptationSupports = getMixedMimeTypeAdaptationSupports(rendererCapabilitiesArr);
        for (int i2 = 0; i2 < trackGroupArray2.length; i2++) {
            TrackGroup trackGroup = trackGroupArray2.get(i2);
            int findRenderer = findRenderer(rendererCapabilitiesArr, trackGroup, iArr2, trackGroup.type == 5);
            if (findRenderer == rendererCapabilitiesArr2.length) {
                iArr = new int[trackGroup.length];
            } else {
                iArr = getFormatSupport(rendererCapabilitiesArr2[findRenderer], trackGroup);
            }
            int i3 = iArr2[findRenderer];
            trackGroupArr[findRenderer][i3] = trackGroup;
            iArr3[findRenderer][i3] = iArr;
            iArr2[findRenderer] = i3 + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr2.length];
        String[] strArr = new String[rendererCapabilitiesArr2.length];
        int[] iArr4 = new int[rendererCapabilitiesArr2.length];
        for (int i4 = 0; i4 < rendererCapabilitiesArr2.length; i4++) {
            int i5 = iArr2[i4];
            trackGroupArrayArr[i4] = new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[i4], i5));
            iArr3[i4] = (int[][]) Util.nullSafeArrayCopy(iArr3[i4], i5);
            strArr[i4] = rendererCapabilitiesArr2[i4].getName();
            iArr4[i4] = rendererCapabilitiesArr2[i4].getTrackType();
        }
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(strArr, iArr4, trackGroupArrayArr, mixedMimeTypeAdaptationSupports, iArr3, new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[rendererCapabilitiesArr2.length], iArr2[rendererCapabilitiesArr2.length])));
        Pair<RendererConfiguration[], ExoTrackSelection[]> selectTracks = selectTracks(mappedTrackInfo, iArr3, mixedMimeTypeAdaptationSupports, mediaPeriodId, timeline);
        return new TrackSelectorResult((RendererConfiguration[]) selectTracks.first, (ExoTrackSelection[]) selectTracks.second, TrackSelectionUtil.buildTracks(mappedTrackInfo, (TrackSelection[]) selectTracks.second), mappedTrackInfo);
    }

    private static int findRenderer(RendererCapabilities[] rendererCapabilitiesArr, TrackGroup trackGroup, int[] iArr, boolean z) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        boolean z2 = true;
        int i = 0;
        for (int i2 = 0; i2 < rendererCapabilitiesArr.length; i2++) {
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < trackGroup.length; i4++) {
                i3 = Math.max(i3, RendererCapabilities.getFormatSupport(rendererCapabilities.supportsFormat(trackGroup.getFormat(i4))));
            }
            boolean z3 = iArr[i2] == 0;
            if (i3 > i || (i3 == i && z && !z2 && z3)) {
                length = i2;
                z2 = z3;
                i = i3;
            }
        }
        return length;
    }

    private static int[] getFormatSupport(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) throws ExoPlaybackException {
        int[] iArr = new int[trackGroup.length];
        for (int i = 0; i < trackGroup.length; i++) {
            iArr[i] = rendererCapabilities.supportsFormat(trackGroup.getFormat(i));
        }
        return iArr;
    }

    private static int[] getMixedMimeTypeAdaptationSupports(RendererCapabilities[] rendererCapabilitiesArr) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = rendererCapabilitiesArr[i].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }
}
