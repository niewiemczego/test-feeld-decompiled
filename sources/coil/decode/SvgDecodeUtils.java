package coil.decode;

import coil.util.SvgUtils;
import kotlin.Metadata;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"LEFT_ANGLE_BRACKET", "Lokio/ByteString;", "SVG_TAG", "isSvg", "", "Lcoil/decode/DecodeUtils;", "source", "Lokio/BufferedSource;", "coil-svg_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: DecodeUtils.kt */
public final class SvgDecodeUtils {
    private static final ByteString LEFT_ANGLE_BRACKET = ByteString.Companion.encodeUtf8("<");
    private static final ByteString SVG_TAG = ByteString.Companion.encodeUtf8("<svg");

    public static final boolean isSvg(DecodeUtils decodeUtils, BufferedSource bufferedSource) {
        if (bufferedSource.rangeEquals(0, LEFT_ANGLE_BRACKET)) {
            if (SvgUtils.indexOf(bufferedSource, SVG_TAG, 0, 1024) != -1) {
                return true;
            }
        }
        return false;
    }
}
