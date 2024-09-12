package coil.util;

import android.graphics.Bitmap;
import android.os.Build;
import coil.size.Dimension;
import coil.size.Scale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u000e\u0010\u0010\u001a\u00020\u0002*\u0004\u0018\u00010\u0002H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0011"}, d2 = {"isHardware", "", "Landroid/graphics/Bitmap$Config;", "(Landroid/graphics/Bitmap$Config;)Z", "indexOf", "", "Lokio/BufferedSource;", "bytes", "Lokio/ByteString;", "fromIndex", "toIndex", "toPx", "", "Lcoil/size/Dimension;", "scale", "Lcoil/size/Scale;", "toSoftware", "coil-svg_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* renamed from: coil.util.-SvgUtils  reason: invalid class name */
/* compiled from: Utils.kt */
public final class SvgUtils {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: coil.util.-SvgUtils$WhenMappings */
    /* compiled from: Utils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Scale.values().length];
            iArr[Scale.FILL.ordinal()] = 1;
            iArr[Scale.FIT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final long indexOf(BufferedSource bufferedSource, ByteString byteString, long j, long j2) {
        if (byteString.size() > 0) {
            byte b = byteString.getByte(0);
            long size = j2 - ((long) byteString.size());
            long j3 = j;
            while (j3 < size) {
                long indexOf = bufferedSource.indexOf(b, j3, size);
                if (indexOf == -1 || bufferedSource.rangeEquals(indexOf, byteString)) {
                    return indexOf;
                }
                j3 = indexOf + 1;
            }
            return -1;
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    public static final boolean isHardware(Bitmap.Config config) {
        return Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE;
    }

    public static final Bitmap.Config toSoftware(Bitmap.Config config) {
        return (config == null || isHardware(config)) ? Bitmap.Config.ARGB_8888 : config;
    }

    public static final float toPx(Dimension dimension, Scale scale) {
        if (dimension instanceof Dimension.Pixels) {
            return (float) ((Dimension.Pixels) dimension).px;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i == 1) {
            return Float.MIN_VALUE;
        }
        if (i == 2) {
            return Float.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
