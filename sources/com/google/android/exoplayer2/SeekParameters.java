package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class SeekParameters {
    public static final SeekParameters CLOSEST_SYNC = new SeekParameters(Long.MAX_VALUE, Long.MAX_VALUE);
    public static final SeekParameters DEFAULT;
    public static final SeekParameters EXACT;
    public static final SeekParameters NEXT_SYNC = new SeekParameters(0, Long.MAX_VALUE);
    public static final SeekParameters PREVIOUS_SYNC = new SeekParameters(Long.MAX_VALUE, 0);
    public final long toleranceAfterUs;
    public final long toleranceBeforeUs;

    static {
        SeekParameters seekParameters = new SeekParameters(0, 0);
        EXACT = seekParameters;
        DEFAULT = seekParameters;
    }

    public SeekParameters(long j, long j2) {
        boolean z = true;
        Assertions.checkArgument(j >= 0);
        Assertions.checkArgument(j2 < 0 ? false : z);
        this.toleranceBeforeUs = j;
        this.toleranceAfterUs = j2;
    }

    public long resolveSeekPositionUs(long j, long j2, long j3) {
        long j4 = this.toleranceBeforeUs;
        if (j4 == 0 && this.toleranceAfterUs == 0) {
            return j;
        }
        long subtractWithOverflowDefault = Util.subtractWithOverflowDefault(j, j4, Long.MIN_VALUE);
        long addWithOverflowDefault = Util.addWithOverflowDefault(j, this.toleranceAfterUs, Long.MAX_VALUE);
        boolean z = true;
        boolean z2 = subtractWithOverflowDefault <= j2 && j2 <= addWithOverflowDefault;
        if (subtractWithOverflowDefault > j3 || j3 > addWithOverflowDefault) {
            z = false;
        }
        if (z2 && z) {
            return Math.abs(j2 - j) <= Math.abs(j3 - j) ? j2 : j3;
        }
        if (z2) {
            return j2;
        }
        return z ? j3 : subtractWithOverflowDefault;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SeekParameters seekParameters = (SeekParameters) obj;
        if (this.toleranceBeforeUs == seekParameters.toleranceBeforeUs && this.toleranceAfterUs == seekParameters.toleranceAfterUs) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.toleranceBeforeUs) * 31) + ((int) this.toleranceAfterUs);
    }
}
