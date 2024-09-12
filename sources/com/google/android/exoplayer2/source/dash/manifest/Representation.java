package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.List;

public abstract class Representation {
    public static final long REVISION_ID_DEFAULT = -1;
    public final ImmutableList<BaseUrl> baseUrls;
    public final List<Descriptor> essentialProperties;
    public final Format format;
    public final List<Descriptor> inbandEventStreams;
    private final RangedUri initializationUri;
    public final long presentationTimeOffsetUs;
    public final long revisionId;
    public final List<Descriptor> supplementalProperties;

    public abstract String getCacheKey();

    public abstract DashSegmentIndex getIndex();

    public abstract RangedUri getIndexUri();

    public static Representation newInstance(long j, Format format2, List<BaseUrl> list, SegmentBase segmentBase) {
        return newInstance(j, format2, list, segmentBase, (List<Descriptor>) null, ImmutableList.of(), ImmutableList.of(), (String) null);
    }

    public static Representation newInstance(long j, Format format2, List<BaseUrl> list, SegmentBase segmentBase, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4, String str) {
        SegmentBase segmentBase2 = segmentBase;
        if (segmentBase2 instanceof SegmentBase.SingleSegmentBase) {
            return new SingleSegmentRepresentation(j, format2, list, (SegmentBase.SingleSegmentBase) segmentBase2, list2, list3, list4, str, -1);
        } else if (segmentBase2 instanceof SegmentBase.MultiSegmentBase) {
            return new MultiSegmentRepresentation(j, format2, list, (SegmentBase.MultiSegmentBase) segmentBase2, list2, list3, list4);
        } else {
            throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        }
    }

    private Representation(long j, Format format2, List<BaseUrl> list, SegmentBase segmentBase, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        List<Descriptor> list5;
        Assertions.checkArgument(!list.isEmpty());
        this.revisionId = j;
        this.format = format2;
        this.baseUrls = ImmutableList.copyOf(list);
        if (list2 == null) {
            list5 = Collections.emptyList();
        } else {
            list5 = Collections.unmodifiableList(list2);
        }
        this.inbandEventStreams = list5;
        this.essentialProperties = list3;
        this.supplementalProperties = list4;
        this.initializationUri = segmentBase.getInitialization(this);
        this.presentationTimeOffsetUs = segmentBase.getPresentationTimeOffsetUs();
    }

    public RangedUri getInitializationUri() {
        return this.initializationUri;
    }

    public static class SingleSegmentRepresentation extends Representation {
        private final String cacheKey;
        public final long contentLength;
        private final RangedUri indexUri;
        private final SingleSegmentIndex segmentIndex;
        public final Uri uri;

        public static SingleSegmentRepresentation newInstance(long j, Format format, String str, long j2, long j3, long j4, long j5, List<Descriptor> list, String str2, long j6) {
            return new SingleSegmentRepresentation(j, format, ImmutableList.of(new BaseUrl(str)), new SegmentBase.SingleSegmentBase(new RangedUri((String) null, j2, (j3 - j2) + 1), 1, 0, j4, (j5 - j4) + 1), list, ImmutableList.of(), ImmutableList.of(), str2, j6);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SingleSegmentRepresentation(long j, Format format, List<BaseUrl> list, SegmentBase.SingleSegmentBase singleSegmentBase, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4, String str, long j2) {
            super(j, format, list, singleSegmentBase, list2, list3, list4);
            SingleSegmentIndex singleSegmentIndex;
            List<BaseUrl> list5 = list;
            this.uri = Uri.parse(list.get(0).url);
            RangedUri index = singleSegmentBase.getIndex();
            this.indexUri = index;
            this.cacheKey = str;
            this.contentLength = j2;
            if (index != null) {
                singleSegmentIndex = null;
            } else {
                singleSegmentIndex = new SingleSegmentIndex(new RangedUri((String) null, 0, j2));
            }
            this.segmentIndex = singleSegmentIndex;
        }

        public RangedUri getIndexUri() {
            return this.indexUri;
        }

        public DashSegmentIndex getIndex() {
            return this.segmentIndex;
        }

        public String getCacheKey() {
            return this.cacheKey;
        }
    }

    public static class MultiSegmentRepresentation extends Representation implements DashSegmentIndex {
        final SegmentBase.MultiSegmentBase segmentBase;

        public String getCacheKey() {
            return null;
        }

        public DashSegmentIndex getIndex() {
            return this;
        }

        public RangedUri getIndexUri() {
            return null;
        }

        public MultiSegmentRepresentation(long j, Format format, List<BaseUrl> list, SegmentBase.MultiSegmentBase multiSegmentBase, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
            super(j, format, list, multiSegmentBase, list2, list3, list4);
            this.segmentBase = multiSegmentBase;
        }

        public RangedUri getSegmentUrl(long j) {
            return this.segmentBase.getSegmentUrl(this, j);
        }

        public long getSegmentNum(long j, long j2) {
            return this.segmentBase.getSegmentNum(j, j2);
        }

        public long getTimeUs(long j) {
            return this.segmentBase.getSegmentTimeUs(j);
        }

        public long getDurationUs(long j, long j2) {
            return this.segmentBase.getSegmentDurationUs(j, j2);
        }

        public long getFirstSegmentNum() {
            return this.segmentBase.getFirstSegmentNum();
        }

        public long getFirstAvailableSegmentNum(long j, long j2) {
            return this.segmentBase.getFirstAvailableSegmentNum(j, j2);
        }

        public long getSegmentCount(long j) {
            return this.segmentBase.getSegmentCount(j);
        }

        public long getAvailableSegmentCount(long j, long j2) {
            return this.segmentBase.getAvailableSegmentCount(j, j2);
        }

        public long getNextSegmentAvailableTimeUs(long j, long j2) {
            return this.segmentBase.getNextSegmentAvailableTimeUs(j, j2);
        }

        public boolean isExplicit() {
            return this.segmentBase.isExplicit();
        }
    }
}
