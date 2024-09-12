package coil.decode;

import coil.size.Scale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J8\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\f2\b\b\u0001\u0010\u0006\u001a\u00020\f2\b\b\u0001\u0010\u0007\u001a\u00020\f2\b\b\u0001\u0010\b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0007J8\u0010\u000b\u001a\u00020\r2\b\b\u0001\u0010\u0005\u001a\u00020\r2\b\b\u0001\u0010\u0006\u001a\u00020\r2\b\b\u0001\u0010\u0007\u001a\u00020\r2\b\b\u0001\u0010\b\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0007J8\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000e"}, d2 = {"Lcoil/decode/DecodeUtils;", "", "()V", "calculateInSampleSize", "", "srcWidth", "srcHeight", "dstWidth", "dstHeight", "scale", "Lcoil/size/Scale;", "computeSizeMultiplier", "", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DecodeUtils.kt */
public final class DecodeUtils {
    public static final DecodeUtils INSTANCE = new DecodeUtils();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DecodeUtils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Scale.values().length];
            iArr[Scale.FILL.ordinal()] = 1;
            iArr[Scale.FIT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private DecodeUtils() {
    }

    @JvmStatic
    public static final int calculateInSampleSize(int i, int i2, int i3, int i4, Scale scale) {
        int i5;
        int highestOneBit = Integer.highestOneBit(i / i3);
        int highestOneBit2 = Integer.highestOneBit(i2 / i4);
        int i6 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i6 == 1) {
            i5 = Math.min(highestOneBit, highestOneBit2);
        } else if (i6 == 2) {
            i5 = Math.max(highestOneBit, highestOneBit2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return RangesKt.coerceAtLeast(i5, 1);
    }

    @JvmStatic
    public static final double computeSizeMultiplier(int i, int i2, int i3, int i4, Scale scale) {
        double d = ((double) i3) / ((double) i);
        double d2 = ((double) i4) / ((double) i2);
        int i5 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i5 == 1) {
            return Math.max(d, d2);
        }
        if (i5 == 2) {
            return Math.min(d, d2);
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final float computeSizeMultiplier(float f, float f2, float f3, float f4, Scale scale) {
        float f5 = f3 / f;
        float f6 = f4 / f2;
        int i = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i == 1) {
            return Math.max(f5, f6);
        }
        if (i == 2) {
            return Math.min(f5, f6);
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final double computeSizeMultiplier(double d, double d2, double d3, double d4, Scale scale) {
        double d5 = d3 / d;
        double d6 = d4 / d2;
        int i = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i == 1) {
            return Math.max(d5, d6);
        }
        if (i == 2) {
            return Math.min(d5, d6);
        }
        throw new NoWhenBranchMatchedException();
    }
}
