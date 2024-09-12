package coil.decode;

import kotlin.Metadata;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u000f\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u0010\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u0011\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u0012\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"GIF_HEADER_87A", "Lokio/ByteString;", "GIF_HEADER_89A", "HEIF_HEADER_FTYP", "HEIF_HEADER_HEVC", "HEIF_HEADER_HEVX", "HEIF_HEADER_MSF1", "WEBP_HEADER_RIFF", "WEBP_HEADER_VPX8", "WEBP_HEADER_WEBP", "isAnimatedHeif", "", "Lcoil/decode/DecodeUtils;", "source", "Lokio/BufferedSource;", "isAnimatedWebP", "isGif", "isHeif", "isWebP", "coil-gif_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: DecodeUtils.kt */
public final class GifDecodeUtils {
    private static final ByteString GIF_HEADER_87A = ByteString.Companion.encodeUtf8("GIF87a");
    private static final ByteString GIF_HEADER_89A = ByteString.Companion.encodeUtf8("GIF89a");
    private static final ByteString HEIF_HEADER_FTYP = ByteString.Companion.encodeUtf8("ftyp");
    private static final ByteString HEIF_HEADER_HEVC = ByteString.Companion.encodeUtf8("hevc");
    private static final ByteString HEIF_HEADER_HEVX = ByteString.Companion.encodeUtf8("hevx");
    private static final ByteString HEIF_HEADER_MSF1 = ByteString.Companion.encodeUtf8("msf1");
    private static final ByteString WEBP_HEADER_RIFF = ByteString.Companion.encodeUtf8("RIFF");
    private static final ByteString WEBP_HEADER_VPX8 = ByteString.Companion.encodeUtf8("VP8X");
    private static final ByteString WEBP_HEADER_WEBP = ByteString.Companion.encodeUtf8("WEBP");

    public static final boolean isGif(DecodeUtils decodeUtils, BufferedSource bufferedSource) {
        return bufferedSource.rangeEquals(0, GIF_HEADER_89A) || bufferedSource.rangeEquals(0, GIF_HEADER_87A);
    }

    public static final boolean isWebP(DecodeUtils decodeUtils, BufferedSource bufferedSource) {
        return bufferedSource.rangeEquals(0, WEBP_HEADER_RIFF) && bufferedSource.rangeEquals(8, WEBP_HEADER_WEBP);
    }

    public static final boolean isAnimatedWebP(DecodeUtils decodeUtils, BufferedSource bufferedSource) {
        return isWebP(decodeUtils, bufferedSource) && bufferedSource.rangeEquals(12, WEBP_HEADER_VPX8) && bufferedSource.request(17) && ((byte) (bufferedSource.getBuffer().getByte(16) & 2)) > 0;
    }

    public static final boolean isHeif(DecodeUtils decodeUtils, BufferedSource bufferedSource) {
        return bufferedSource.rangeEquals(4, HEIF_HEADER_FTYP);
    }

    public static final boolean isAnimatedHeif(DecodeUtils decodeUtils, BufferedSource bufferedSource) {
        return isHeif(decodeUtils, bufferedSource) && (bufferedSource.rangeEquals(8, HEIF_HEADER_MSF1) || bufferedSource.rangeEquals(8, HEIF_HEADER_HEVC) || bufferedSource.rangeEquals(8, HEIF_HEADER_HEVX));
    }
}
