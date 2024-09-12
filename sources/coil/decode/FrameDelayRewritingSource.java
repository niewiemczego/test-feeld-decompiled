package coil.decode;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Source;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcoil/decode/FrameDelayRewritingSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "indexOf", "", "bytes", "Lokio/ByteString;", "read", "sink", "byteCount", "request", "", "write", "Companion", "coil-gif_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FrameDelayRewritingSource.kt */
public final class FrameDelayRewritingSource extends ForwardingSource {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int DEFAULT_FRAME_DELAY = 10;
    @Deprecated
    private static final ByteString FRAME_DELAY_START_MARKER = ByteString.Companion.decodeHex("0021F904");
    @Deprecated
    private static final int FRAME_DELAY_START_MARKER_SIZE_BYTES = 4;
    @Deprecated
    private static final int MINIMUM_FRAME_DELAY = 2;
    private final Buffer buffer = new Buffer();

    public FrameDelayRewritingSource(Source source) {
        super(source);
    }

    public long read(Buffer buffer2, long j) {
        request(j);
        if (this.buffer.size() == 0) {
            return j == 0 ? 0 : -1;
        }
        long j2 = 0;
        while (true) {
            long indexOf = indexOf(FRAME_DELAY_START_MARKER);
            if (indexOf == -1) {
                break;
            }
            j2 += write(buffer2, indexOf + ((long) 4));
            if (request(5) && this.buffer.getByte(4) == 0 && (((UByte.m1001constructorimpl(this.buffer.getByte(2)) & 255) << 8) | (UByte.m1001constructorimpl(this.buffer.getByte(1)) & 255)) < 2) {
                buffer2.writeByte((int) this.buffer.getByte(0));
                buffer2.writeByte(10);
                buffer2.writeByte(0);
                this.buffer.skip(3);
            }
        }
        if (j2 < j) {
            j2 += write(buffer2, j - j2);
        }
        if (j2 == 0) {
            return -1;
        }
        return j2;
    }

    private final long indexOf(ByteString byteString) {
        long j = -1;
        while (true) {
            j = this.buffer.indexOf(byteString.getByte(0), j + 1);
            if (j == -1 || (request((long) byteString.size()) && this.buffer.rangeEquals(j, byteString))) {
                return j;
            }
        }
        return j;
    }

    private final long write(Buffer buffer2, long j) {
        return RangesKt.coerceAtLeast(this.buffer.read(buffer2, j), 0);
    }

    private final boolean request(long j) {
        if (this.buffer.size() >= j) {
            return true;
        }
        long size = j - this.buffer.size();
        if (super.read(this.buffer, size) == size) {
            return true;
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcoil/decode/FrameDelayRewritingSource$Companion;", "", "()V", "DEFAULT_FRAME_DELAY", "", "FRAME_DELAY_START_MARKER", "Lokio/ByteString;", "FRAME_DELAY_START_MARKER_SIZE_BYTES", "MINIMUM_FRAME_DELAY", "coil-gif_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FrameDelayRewritingSource.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
