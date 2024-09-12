package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Util;
import com.google.common.math.BigIntegerMath;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public abstract class SegmentBase {
    final RangedUri initialization;
    final long presentationTimeOffset;
    final long timescale;

    public SegmentBase(RangedUri rangedUri, long j, long j2) {
        this.initialization = rangedUri;
        this.timescale = j;
        this.presentationTimeOffset = j2;
    }

    public RangedUri getInitialization(Representation representation) {
        return this.initialization;
    }

    public long getPresentationTimeOffsetUs() {
        return Util.scaleLargeTimestamp(this.presentationTimeOffset, 1000000, this.timescale);
    }

    public static class SingleSegmentBase extends SegmentBase {
        final long indexLength;
        final long indexStart;

        public SingleSegmentBase(RangedUri rangedUri, long j, long j2, long j3, long j4) {
            super(rangedUri, j, j2);
            this.indexStart = j3;
            this.indexLength = j4;
        }

        public SingleSegmentBase() {
            this((RangedUri) null, 1, 0, 0, 0);
        }

        public RangedUri getIndex() {
            if (this.indexLength <= 0) {
                return null;
            }
            return new RangedUri((String) null, this.indexStart, this.indexLength);
        }
    }

    public static abstract class MultiSegmentBase extends SegmentBase {
        final long availabilityTimeOffsetUs;
        final long duration;
        private final long periodStartUnixTimeUs;
        final List<SegmentTimelineElement> segmentTimeline;
        final long startNumber;
        private final long timeShiftBufferDepthUs;

        public abstract long getSegmentCount(long j);

        public abstract RangedUri getSegmentUrl(Representation representation, long j);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MultiSegmentBase(RangedUri rangedUri, long j, long j2, long j3, long j4, List<SegmentTimelineElement> list, long j5, long j6, long j7) {
            super(rangedUri, j, j2);
            this.startNumber = j3;
            this.duration = j4;
            this.segmentTimeline = list;
            this.availabilityTimeOffsetUs = j5;
            this.timeShiftBufferDepthUs = j6;
            this.periodStartUnixTimeUs = j7;
        }

        public long getSegmentNum(long j, long j2) {
            long firstSegmentNum = getFirstSegmentNum();
            long segmentCount = getSegmentCount(j2);
            if (segmentCount == 0) {
                return firstSegmentNum;
            }
            if (this.segmentTimeline == null) {
                long j3 = this.startNumber + (j / ((this.duration * 1000000) / this.timescale));
                if (j3 < firstSegmentNum) {
                    return firstSegmentNum;
                }
                if (segmentCount == -1) {
                    return j3;
                }
                return Math.min(j3, (firstSegmentNum + segmentCount) - 1);
            }
            long j4 = (segmentCount + firstSegmentNum) - 1;
            long j5 = firstSegmentNum;
            while (j5 <= j4) {
                long j6 = ((j4 - j5) / 2) + j5;
                int i = (getSegmentTimeUs(j6) > j ? 1 : (getSegmentTimeUs(j6) == j ? 0 : -1));
                if (i < 0) {
                    j5 = j6 + 1;
                } else if (i <= 0) {
                    return j6;
                } else {
                    j4 = j6 - 1;
                }
            }
            return j5 == firstSegmentNum ? j5 : j4;
        }

        public final long getSegmentDurationUs(long j, long j2) {
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                return (list.get((int) (j - this.startNumber)).duration * 1000000) / this.timescale;
            }
            long segmentCount = getSegmentCount(j2);
            if (segmentCount == -1 || j != (getFirstSegmentNum() + segmentCount) - 1) {
                return (this.duration * 1000000) / this.timescale;
            }
            return j2 - getSegmentTimeUs(j);
        }

        public final long getSegmentTimeUs(long j) {
            long j2;
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                j2 = list.get((int) (j - this.startNumber)).startTime - this.presentationTimeOffset;
            } else {
                j2 = (j - this.startNumber) * this.duration;
            }
            return Util.scaleLargeTimestamp(j2, 1000000, this.timescale);
        }

        public long getFirstSegmentNum() {
            return this.startNumber;
        }

        public long getFirstAvailableSegmentNum(long j, long j2) {
            if (getSegmentCount(j) == -1) {
                long j3 = this.timeShiftBufferDepthUs;
                if (j3 != C.TIME_UNSET) {
                    return Math.max(getFirstSegmentNum(), getSegmentNum((j2 - this.periodStartUnixTimeUs) - j3, j));
                }
            }
            return getFirstSegmentNum();
        }

        public long getAvailableSegmentCount(long j, long j2) {
            long segmentCount = getSegmentCount(j);
            if (segmentCount != -1) {
                return segmentCount;
            }
            return (long) ((int) (getSegmentNum((j2 - this.periodStartUnixTimeUs) + this.availabilityTimeOffsetUs, j) - getFirstAvailableSegmentNum(j, j2)));
        }

        public long getNextSegmentAvailableTimeUs(long j, long j2) {
            if (this.segmentTimeline != null) {
                return C.TIME_UNSET;
            }
            long firstAvailableSegmentNum = getFirstAvailableSegmentNum(j, j2) + getAvailableSegmentCount(j, j2);
            return (getSegmentTimeUs(firstAvailableSegmentNum) + getSegmentDurationUs(firstAvailableSegmentNum, j)) - this.availabilityTimeOffsetUs;
        }

        public boolean isExplicit() {
            return this.segmentTimeline != null;
        }
    }

    public static final class SegmentList extends MultiSegmentBase {
        final List<RangedUri> mediaSegments;

        public boolean isExplicit() {
            return true;
        }

        public SegmentList(RangedUri rangedUri, long j, long j2, long j3, long j4, List<SegmentTimelineElement> list, long j5, List<RangedUri> list2, long j6, long j7) {
            super(rangedUri, j, j2, j3, j4, list, j5, j6, j7);
            this.mediaSegments = list2;
        }

        public RangedUri getSegmentUrl(Representation representation, long j) {
            return this.mediaSegments.get((int) (j - this.startNumber));
        }

        public long getSegmentCount(long j) {
            return (long) this.mediaSegments.size();
        }
    }

    public static final class SegmentTemplate extends MultiSegmentBase {
        final long endNumber;
        final UrlTemplate initializationTemplate;
        final UrlTemplate mediaTemplate;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SegmentTemplate(RangedUri rangedUri, long j, long j2, long j3, long j4, long j5, List<SegmentTimelineElement> list, long j6, UrlTemplate urlTemplate, UrlTemplate urlTemplate2, long j7, long j8) {
            super(rangedUri, j, j2, j3, j5, list, j6, j7, j8);
            this.initializationTemplate = urlTemplate;
            this.mediaTemplate = urlTemplate2;
            this.endNumber = j4;
        }

        public RangedUri getInitialization(Representation representation) {
            UrlTemplate urlTemplate = this.initializationTemplate;
            if (urlTemplate != null) {
                return new RangedUri(urlTemplate.buildUri(representation.format.id, 0, representation.format.bitrate, 0), 0, -1);
            }
            return super.getInitialization(representation);
        }

        public RangedUri getSegmentUrl(Representation representation, long j) {
            long j2;
            Representation representation2 = representation;
            if (this.segmentTimeline != null) {
                j2 = ((SegmentTimelineElement) this.segmentTimeline.get((int) (j - this.startNumber))).startTime;
            } else {
                j2 = (j - this.startNumber) * this.duration;
            }
            long j3 = j2;
            return new RangedUri(this.mediaTemplate.buildUri(representation2.format.id, j, representation2.format.bitrate, j3), 0, -1);
        }

        public long getSegmentCount(long j) {
            if (this.segmentTimeline != null) {
                return (long) this.segmentTimeline.size();
            }
            long j2 = this.endNumber;
            if (j2 != -1) {
                return (j2 - this.startNumber) + 1;
            }
            if (j != C.TIME_UNSET) {
                return BigIntegerMath.divide(BigInteger.valueOf(j).multiply(BigInteger.valueOf(this.timescale)), BigInteger.valueOf(this.duration).multiply(BigInteger.valueOf(1000000)), RoundingMode.CEILING).longValue();
            }
            return -1;
        }
    }

    public static final class SegmentTimelineElement {
        final long duration;
        final long startTime;

        public SegmentTimelineElement(long j, long j2) {
            this.startTime = j;
            this.duration = j2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SegmentTimelineElement segmentTimelineElement = (SegmentTimelineElement) obj;
            if (this.startTime == segmentTimelineElement.startTime && this.duration == segmentTimelineElement.duration) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((int) this.startTime) * 31) + ((int) this.duration);
        }
    }
}
