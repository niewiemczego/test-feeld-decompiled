package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio._JvmPlatformKt;
import okio._UtilKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\b\u001a\r\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\b\u001a\r\u0010\u0018\u001a\u00020\u0007*\u00020\u0015H\b\u001a\r\u0010\u0019\u001a\u00020\u0015*\u00020\u0015H\b\u001a%\u0010\u001a\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\u0017\u0010\u001e\u001a\u00020\f*\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\b\u001a\u0015\u0010!\u001a\u00020\u0007*\u00020\u00172\u0006\u0010\"\u001a\u00020\nH\b\u001a\u0015\u0010#\u001a\u00020$*\u00020\u00152\u0006\u0010%\u001a\u00020\u0007H\b\u001a\r\u0010&\u001a\u00020\n*\u00020\u0015H\b\u001a%\u0010'\u001a\u00020\u0007*\u00020\u00152\u0006\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\b\u001a\u001d\u0010'\u001a\u00020\u0007*\u00020\u00152\u0006\u0010\u0010\u001a\u00020+2\u0006\u0010)\u001a\u00020\u0007H\b\u001a\u001d\u0010,\u001a\u00020\u0007*\u00020\u00152\u0006\u0010-\u001a\u00020+2\u0006\u0010)\u001a\u00020\u0007H\b\u001a\r\u0010.\u001a\u00020\n*\u00020\u0017H\b\u001a-\u0010/\u001a\u00020\f*\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\b\u001a\u0015\u00100\u001a\u00020\n*\u00020\u00152\u0006\u00101\u001a\u00020\u0001H\b\u001a%\u00100\u001a\u00020\n*\u00020\u00152\u0006\u00101\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\b\u001a\u001d\u00100\u001a\u00020\u0007*\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\u0015\u00102\u001a\u00020\u0007*\u00020\u00152\u0006\u00101\u001a\u000203H\b\u001a\u0014\u00104\u001a\u00020\u0017*\u00020\u00152\u0006\u00105\u001a\u00020\u0017H\u0000\u001a\r\u00106\u001a\u00020$*\u00020\u0015H\b\u001a\r\u00107\u001a\u00020\u0001*\u00020\u0015H\b\u001a\u0015\u00107\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\r\u00108\u001a\u00020+*\u00020\u0015H\b\u001a\u0015\u00108\u001a\u00020+*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\r\u00109\u001a\u00020\u0007*\u00020\u0015H\b\u001a\u0015\u0010:\u001a\u00020\u0014*\u00020\u00152\u0006\u00101\u001a\u00020\u0001H\b\u001a\u001d\u0010:\u001a\u00020\u0014*\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\r\u0010;\u001a\u00020\u0007*\u00020\u0015H\b\u001a\r\u0010<\u001a\u00020\n*\u00020\u0015H\b\u001a\r\u0010=\u001a\u00020\u0007*\u00020\u0015H\b\u001a\r\u0010>\u001a\u00020?*\u00020\u0015H\b\u001a\u0014\u0010@\u001a\u00020\u0017*\u00020\u00152\u0006\u00105\u001a\u00020\u0017H\u0000\u001a\u0015\u0010A\u001a\u00020B*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\r\u0010C\u001a\u00020\n*\u00020\u0015H\b\u001a\u000f\u0010D\u001a\u0004\u0018\u00010B*\u00020\u0015H\b\u001a\u0015\u0010E\u001a\u00020B*\u00020\u00152\u0006\u0010F\u001a\u00020\u0007H\b\u001a\u0015\u0010G\u001a\u00020\u0007*\u00020\u00172\u0006\u0010H\u001a\u00020\u0007H\b\u001a\u0015\u0010I\u001a\u00020\n*\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0007H\b\u001a\u0015\u0010J\u001a\u00020\n*\u00020\u00152\u0006\u0010K\u001a\u00020LH\b\u001a\u0015\u0010M\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\r\u0010N\u001a\u00020+*\u00020\u0015H\b\u001a\u0015\u0010N\u001a\u00020+*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\nH\b\u001a\u0015\u0010O\u001a\u00020\u000e*\u00020\u00152\u0006\u0010P\u001a\u00020\nH\b\u001a\u0015\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020\u0001H\b\u001a%\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\b\u001a\u001d\u0010Q\u001a\u00020\u0014*\u00020\u00152\u0006\u0010R\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a)\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010S\u001a\u00020+2\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\nH\b\u001a\u001d\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020T2\u0006\u0010\u001d\u001a\u00020\u0007H\b\u001a\u0015\u0010U\u001a\u00020\u0007*\u00020\u00152\u0006\u0010R\u001a\u00020TH\b\u001a\u0015\u0010V\u001a\u00020\u0015*\u00020\u00152\u0006\u0010(\u001a\u00020\nH\b\u001a\u0015\u0010W\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\b\u001a\u0015\u0010Y\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\b\u001a\u0015\u0010Z\u001a\u00020\u0015*\u00020\u00152\u0006\u0010[\u001a\u00020\nH\b\u001a\u0015\u0010\\\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\b\u001a\u0015\u0010]\u001a\u00020\u0015*\u00020\u00152\u0006\u0010^\u001a\u00020\nH\b\u001a%\u0010_\u001a\u00020\u0015*\u00020\u00152\u0006\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\nH\b\u001a\u0015\u0010c\u001a\u00020\u0015*\u00020\u00152\u0006\u0010d\u001a\u00020\nH\b\u001a\u0014\u0010e\u001a\u00020B*\u00020\u00152\u0006\u0010f\u001a\u00020\u0007H\u0000\u001a?\u0010g\u001a\u0002Hh\"\u0004\b\u0000\u0010h*\u00020\u00152\u0006\u0010)\u001a\u00020\u00072\u001a\u0010i\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002Hh0jH\bø\u0001\u0000¢\u0006\u0002\u0010k\u001a\u001e\u0010l\u001a\u00020\n*\u00020\u00152\u0006\u0010K\u001a\u00020L2\b\b\u0002\u0010m\u001a\u00020\fH\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006n"}, d2 = {"HEX_DIGIT_BYTES", "", "getHEX_DIGIT_BYTES$annotations", "()V", "getHEX_DIGIT_BYTES", "()[B", "OVERFLOW_DIGIT_START", "", "OVERFLOW_ZONE", "SEGMENTING_THRESHOLD", "", "rangeEquals", "", "segment", "Lokio/Segment;", "segmentPos", "bytes", "bytesOffset", "bytesLimit", "commonClear", "", "Lokio/Buffer;", "commonClose", "Lokio/Buffer$UnsafeCursor;", "commonCompleteSegmentByteCount", "commonCopy", "commonCopyTo", "out", "offset", "byteCount", "commonEquals", "other", "", "commonExpandBuffer", "minByteCount", "commonGet", "", "pos", "commonHashCode", "commonIndexOf", "b", "fromIndex", "toIndex", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonNext", "commonRangeEquals", "commonRead", "sink", "commonReadAll", "Lokio/Sink;", "commonReadAndWriteUnsafe", "unsafeCursor", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadLong", "commonReadShort", "", "commonReadUnsafe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonResizeBuffer", "newSize", "commonSeek", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonSnapshot", "commonWritableSegment", "minimumCapacity", "commonWrite", "source", "byteString", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteLong", "commonWriteShort", "s", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "readUtf8Line", "newline", "seek", "T", "lambda", "Lkotlin/Function2;", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "selectPrefix", "selectTruncated", "okio"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: -Buffer.kt */
public final class _BufferKt {
    private static final byte[] HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static /* synthetic */ void getHEX_DIGIT_BYTES$annotations() {
    }

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(Segment segment, int i, byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        int i4 = segment.limit;
        byte[] bArr2 = segment.data;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                byte[] bArr3 = segment.data;
                int i5 = segment.pos;
                bArr2 = bArr3;
                i = i5;
                i4 = segment.limit;
            }
            if (bArr2[i] != bArr[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static final String readUtf8Line(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j > 0) {
            long j2 = j - 1;
            if (buffer.getByte(j2) == ((byte) 13)) {
                String readUtf8 = buffer.readUtf8(j2);
                buffer.skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j);
        buffer.skip(1);
        return readUtf82;
    }

    public static final <T> T seek(Buffer buffer, long j, Function2<? super Segment, ? super Long, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(function2, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return function2.invoke(null, -1L);
        }
        if (buffer.size() - j < j) {
            long size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            return function2.invoke(segment, Long.valueOf(size));
        }
        long j2 = 0;
        while (true) {
            long j3 = ((long) (segment.limit - segment.pos)) + j2;
            if (j3 > j) {
                return function2.invoke(segment, Long.valueOf(j2));
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j2 = j3;
        }
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }

    public static final int selectPrefix(Buffer buffer, Options options, boolean z) {
        int i;
        int i2;
        int i3;
        Segment segment;
        int i4;
        Buffer buffer2 = buffer;
        Intrinsics.checkNotNullParameter(buffer2, "<this>");
        Intrinsics.checkNotNullParameter(options, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        Segment segment2 = buffer2.head;
        if (segment2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = segment2.data;
        int i5 = segment2.pos;
        int i6 = segment2.limit;
        int[] trie$okio = options.getTrie$okio();
        Segment segment3 = segment2;
        int i7 = -1;
        int i8 = 0;
        loop0:
        while (true) {
            int i9 = i8 + 1;
            int i10 = trie$okio[i8];
            int i11 = i9 + 1;
            int i12 = trie$okio[i9];
            if (i12 != -1) {
                i7 = i12;
            }
            if (segment3 == null) {
                break;
            }
            if (i10 < 0) {
                int i13 = i11 + (i10 * -1);
                while (true) {
                    int i14 = i5 + 1;
                    int i15 = i11 + 1;
                    if ((bArr[i5] & 255) != trie$okio[i11]) {
                        return i7;
                    }
                    boolean z2 = i15 == i13;
                    if (i14 == i6) {
                        Intrinsics.checkNotNull(segment3);
                        Segment segment4 = segment3.next;
                        Intrinsics.checkNotNull(segment4);
                        i4 = segment4.pos;
                        byte[] bArr2 = segment4.data;
                        i3 = segment4.limit;
                        if (segment4 == segment2) {
                            if (!z2) {
                                break loop0;
                            }
                            bArr = bArr2;
                            segment = null;
                        } else {
                            byte[] bArr3 = bArr2;
                            segment = segment4;
                            bArr = bArr3;
                        }
                    } else {
                        Segment segment5 = segment3;
                        i3 = i6;
                        i4 = i14;
                        segment = segment5;
                    }
                    if (z2) {
                        i2 = trie$okio[i15];
                        i = i4;
                        i6 = i3;
                        segment3 = segment;
                        break;
                    }
                    i5 = i4;
                    i6 = i3;
                    i11 = i15;
                    segment3 = segment;
                }
            } else {
                i = i5 + 1;
                byte b = bArr[i5] & 255;
                int i16 = i11 + i10;
                while (i11 != i16) {
                    if (b == trie$okio[i11]) {
                        i2 = trie$okio[i11 + i10];
                        if (i == i6) {
                            segment3 = segment3.next;
                            Intrinsics.checkNotNull(segment3);
                            i = segment3.pos;
                            bArr = segment3.data;
                            i6 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                    } else {
                        i11++;
                    }
                }
                return i7;
            }
            if (i2 >= 0) {
                return i2;
            }
            i8 = -i2;
            i5 = i;
        }
        if (z) {
            return -2;
        }
        return i7;
    }

    public static final Buffer commonCopyTo(Buffer buffer, Buffer buffer2, long j, long j2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "out");
        _UtilKt.checkOffsetAndCount(buffer.size(), j, j2);
        if (j2 == 0) {
            return buffer;
        }
        buffer2.setSize$okio(buffer2.size() + j2);
        Segment segment = buffer.head;
        while (true) {
            Intrinsics.checkNotNull(segment);
            if (j < ((long) (segment.limit - segment.pos))) {
                break;
            }
            j -= (long) (segment.limit - segment.pos);
            segment = segment.next;
        }
        while (j2 > 0) {
            Intrinsics.checkNotNull(segment);
            Segment sharedCopy = segment.sharedCopy();
            sharedCopy.pos += (int) j;
            sharedCopy.limit = Math.min(sharedCopy.pos + ((int) j2), sharedCopy.limit);
            if (buffer2.head == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy.prev;
                buffer2.head = sharedCopy.next;
            } else {
                Segment segment2 = buffer2.head;
                Intrinsics.checkNotNull(segment2);
                Segment segment3 = segment2.prev;
                Intrinsics.checkNotNull(segment3);
                segment3.push(sharedCopy);
            }
            j2 -= (long) (sharedCopy.limit - sharedCopy.pos);
            segment = segment.next;
            j = 0;
        }
        return buffer;
    }

    public static final long commonCompleteSegmentByteCount(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long size = buffer.size();
        if (size == 0) {
            return 0;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment.prev;
        Intrinsics.checkNotNull(segment2);
        return (segment2.limit >= 8192 || !segment2.owner) ? size : size - ((long) (segment2.limit - segment2.pos));
    }

    public static final byte commonReadByte(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() != 0) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            int i3 = i + 1;
            byte b = segment.data[i];
            buffer.setSize$okio(buffer.size() - 1);
            if (i3 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i3;
            }
            return b;
        }
        throw new EOFException();
    }

    public static final short commonReadShort(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() >= 2) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 2) {
                return (short) ((buffer.readByte() & 255) | ((buffer.readByte() & 255) << 8));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            buffer.setSize$okio(buffer.size() - 2);
            if (i4 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return (short) b;
        }
        throw new EOFException();
    }

    public static final int commonReadInt(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() >= 4) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (((long) (i2 - i)) < 4) {
                return (buffer.readByte() & 255) | ((buffer.readByte() & 255) << Ascii.CAN) | ((buffer.readByte() & 255) << Ascii.DLE) | ((buffer.readByte() & 255) << 8);
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << Ascii.CAN) | ((bArr[i3] & 255) << Ascii.DLE);
            int i5 = i4 + 1;
            byte b2 = b | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b3 = b2 | (bArr[i5] & 255);
            buffer.setSize$okio(buffer.size() - 4);
            if (i6 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i6;
            }
            return b3;
        }
        throw new EOFException();
    }

    public static final long commonReadLong(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() >= 8) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (((long) (i2 - i)) < 8) {
                return ((((long) buffer.readInt()) & 4294967295L) << 32) | (4294967295L & ((long) buffer.readInt()));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j2 = j | ((((long) bArr[i8]) & 255) << 8) | (((long) bArr[i9]) & 255);
            buffer.setSize$okio(buffer.size() - 8);
            if (i10 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i10;
            }
            return j2;
        }
        throw new EOFException();
    }

    public static final byte commonGet(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        _UtilKt.checkOffsetAndCount(buffer.size(), j, 1);
        Segment segment = buffer.head;
        if (segment == null) {
            Segment segment2 = null;
            Intrinsics.checkNotNull((Object) null);
            byte[] bArr = null.data;
            throw null;
        } else if (buffer.size() - j < j) {
            long size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            Intrinsics.checkNotNull(segment);
            return segment.data[(int) ((((long) segment.pos) + j) - size)];
        } else {
            long j2 = 0;
            while (true) {
                long j3 = ((long) (segment.limit - segment.pos)) + j2;
                if (j3 <= j) {
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j2 = j3;
                } else {
                    Intrinsics.checkNotNull(segment);
                    return segment.data[(int) ((((long) segment.pos) + j) - j2)];
                }
            }
        }
    }

    public static final void commonClear(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        buffer.skip(buffer.size());
    }

    public static final void commonSkip(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        while (j > 0) {
            Segment segment = buffer.head;
            if (segment != null) {
                int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
                long j2 = (long) min;
                buffer.setSize$okio(buffer.size() - j2);
                j -= j2;
                segment.pos += min;
                if (segment.pos == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer buffer, ByteString byteString, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteString.size();
        }
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static final Buffer commonWrite(Buffer buffer, ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static final Buffer commonWriteDecimalLong(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return buffer.writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return buffer.writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US ? j < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j < C.NANOS_PER_SECOND ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment writableSegment$okio = buffer.writableSegment$okio(i2);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit + i2;
        while (j != 0) {
            long j2 = (long) 10;
            i3--;
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i3 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i2;
        buffer.setSize$okio(buffer.size() + ((long) i2));
        return buffer;
    }

    public static final Buffer commonWriteHexadecimalUnsignedLong(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j == 0) {
            return buffer.writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment writableSegment$okio = buffer.writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        for (int i3 = (writableSegment$okio.limit + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment$okio.limit += i;
        buffer.setSize$okio(buffer.size() + ((long) i));
        return buffer;
    }

    public static final Segment commonWritableSegment(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        boolean z = true;
        if (i < 1 || i > 8192) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        } else if (buffer.head == null) {
            Segment take = SegmentPool.take();
            buffer.head = take;
            take.prev = take;
            take.next = take;
            return take;
        } else {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            Segment segment2 = segment.prev;
            Intrinsics.checkNotNull(segment2);
            return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] bArr) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "source");
        return buffer.write(bArr, 0, bArr.length);
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "source");
        long j = (long) i2;
        _UtilKt.checkOffsetAndCount((long) bArr.length, (long) i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int min = Math.min(i3 - i, 8192 - writableSegment$okio.limit);
            int i4 = i + min;
            ArraysKt.copyInto(bArr, writableSegment$okio.data, writableSegment$okio.limit, i, i4);
            writableSegment$okio.limit += min;
            i = i4;
        }
        buffer.setSize$okio(buffer.size() + j);
        return buffer;
    }

    public static final byte[] commonReadByteArray(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.readByteArray(buffer.size());
    }

    public static final byte[] commonReadByteArray(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (!(j >= 0 && j <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        } else if (buffer.size() >= j) {
            byte[] bArr = new byte[((int) j)];
            buffer.readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    public static final int commonRead(Buffer buffer, byte[] bArr) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        return buffer.read(bArr, 0, bArr.length);
    }

    public static final void commonReadFully(Buffer buffer, byte[] bArr) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int read = buffer.read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public static final int commonRead(Buffer buffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        _UtilKt.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        ArraysKt.copyInto(segment.data, bArr, i, segment.pos, segment.pos + min);
        segment.pos += min;
        buffer.setSize$okio(buffer.size() - ((long) min));
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        if (r12 != r13) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008c, code lost:
        r0.head = r10.pop();
        okio.SegmentPool.recycle(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0096, code lost:
        r10.pos = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0098, code lost:
        if (r7 != false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009c, code lost:
        if (r0.head != null) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a3, code lost:
        r0.setSize$okio(r16.size() - ((long) r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ac, code lost:
        if (r6 == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ae, code lost:
        r14 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
        r14 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b1, code lost:
        if (r5 >= r14) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bb, code lost:
        if (r16.size() == 0) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bd, code lost:
        if (r6 == false) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bf, code lost:
        r1 = "Expected a digit";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c2, code lost:
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ea, code lost:
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + okio._UtilKt.toHexString(r0.getByte(0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f0, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f1, code lost:
        if (r6 == false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return -r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadDecimalLong(okio.Buffer r16) {
        /*
            r0 = r16
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            long r1 = r16.size()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00f6
            r1 = -7
            r5 = 0
            r8 = r3
            r6 = r5
            r7 = r6
        L_0x0017:
            okio.Segment r10 = r0.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            byte[] r11 = r10.data
            int r12 = r10.pos
            int r13 = r10.limit
        L_0x0022:
            if (r12 >= r13) goto L_0x008a
            byte r15 = r11[r12]
            r14 = 48
            byte r14 = (byte) r14
            if (r15 < r14) goto L_0x0077
            r3 = 57
            byte r3 = (byte) r3
            if (r15 > r3) goto L_0x0077
            int r14 = r14 - r15
            r3 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x0048
            if (r3 != 0) goto L_0x0042
            long r3 = (long) r14
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x0042
            goto L_0x0048
        L_0x0042:
            r3 = 10
            long r8 = r8 * r3
            long r3 = (long) r14
            long r8 = r8 + r3
            goto L_0x0082
        L_0x0048:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeDecimalLong((long) r8)
            okio.Buffer r0 = r0.writeByte((int) r15)
            if (r6 != 0) goto L_0x005a
            r0.readByte()
        L_0x005a:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0077:
            r3 = 45
            byte r3 = (byte) r3
            if (r15 != r3) goto L_0x0089
            if (r5 != 0) goto L_0x0089
            r3 = 1
            long r1 = r1 - r3
            r6 = 1
        L_0x0082:
            int r12 = r12 + 1
            int r5 = r5 + 1
            r3 = 0
            goto L_0x0022
        L_0x0089:
            r7 = 1
        L_0x008a:
            if (r12 != r13) goto L_0x0096
            okio.Segment r3 = r10.pop()
            r0.head = r3
            okio.SegmentPool.recycle(r10)
            goto L_0x0098
        L_0x0096:
            r10.pos = r12
        L_0x0098:
            if (r7 != 0) goto L_0x00a3
            okio.Segment r3 = r0.head
            if (r3 != 0) goto L_0x009f
            goto L_0x00a3
        L_0x009f:
            r3 = 0
            goto L_0x0017
        L_0x00a3:
            long r1 = r16.size()
            long r3 = (long) r5
            long r1 = r1 - r3
            r0.setSize$okio(r1)
            if (r6 == 0) goto L_0x00b0
            r14 = 2
            goto L_0x00b1
        L_0x00b0:
            r14 = 1
        L_0x00b1:
            if (r5 >= r14) goto L_0x00f1
            long r1 = r16.size()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00eb
            if (r6 == 0) goto L_0x00c2
            java.lang.String r1 = "Expected a digit"
            goto L_0x00c4
        L_0x00c2:
            java.lang.String r1 = "Expected a digit or '-'"
        L_0x00c4:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r3 = " but was 0x"
            java.lang.StringBuilder r1 = r1.append(r3)
            r3 = 0
            byte r0 = r0.getByte(r3)
            java.lang.String r0 = okio._UtilKt.toHexString((byte) r0)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        L_0x00eb:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        L_0x00f1:
            if (r6 == 0) goto L_0x00f4
            goto L_0x00f5
        L_0x00f4:
            long r8 = -r8
        L_0x00f5:
            return r8
        L_0x00f6:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonReadDecimalLong(okio.Buffer):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a3 A[EDGE_INSN: B:44:0x00a3->B:28:0x00a3 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadHexadecimalUnsignedLong(okio.Buffer r14) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            long r0 = r14.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00c1
            r0 = 0
            r1 = r0
            r4 = r2
        L_0x0012:
            okio.Segment r6 = r14.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L_0x001d:
            if (r8 >= r9) goto L_0x00a3
            byte r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x002e
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x002e
            int r11 = r10 - r11
            goto L_0x0048
        L_0x002e:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x003d
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x003d
        L_0x0038:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L_0x0048
        L_0x003d:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0082
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0082
            goto L_0x0038
        L_0x0048:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0058
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x001d
        L_0x0058:
            okio.Buffer r14 = new okio.Buffer
            r14.<init>()
            okio.Buffer r14 = r14.writeHexadecimalUnsignedLong((long) r4)
            okio.Buffer r14 = r14.writeByte((int) r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r14 = r14.readUtf8()
            java.lang.StringBuilder r14 = r1.append(r14)
            java.lang.String r14 = r14.toString()
            r0.<init>(r14)
            throw r0
        L_0x0082:
            if (r0 == 0) goto L_0x0086
            r1 = 1
            goto L_0x00a3
        L_0x0086:
            java.lang.NumberFormatException r14 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = okio._UtilKt.toHexString((byte) r10)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        L_0x00a3:
            if (r8 != r9) goto L_0x00af
            okio.Segment r7 = r6.pop()
            r14.head = r7
            okio.SegmentPool.recycle(r6)
            goto L_0x00b1
        L_0x00af:
            r6.pos = r8
        L_0x00b1:
            if (r1 != 0) goto L_0x00b7
            okio.Segment r6 = r14.head
            if (r6 != 0) goto L_0x0012
        L_0x00b7:
            long r1 = r14.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.setSize$okio(r1)
            return r4
        L_0x00c1:
            java.io.EOFException r14 = new java.io.EOFException
            r14.<init>()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    public static final ByteString commonReadByteString(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.readByteString(buffer.size());
    }

    public static final ByteString commonReadByteString(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (!(j >= 0 && j <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        } else if (buffer.size() < j) {
            throw new EOFException();
        } else if (j < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return new ByteString(buffer.readByteArray(j));
        } else {
            ByteString snapshot = buffer.snapshot((int) j);
            buffer.skip(j);
            return snapshot;
        }
    }

    public static final int commonSelect(Buffer buffer, Options options) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(options, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        int selectPrefix$default = selectPrefix$default(buffer, options, false, 2, (Object) null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        buffer.skip((long) options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonReadFully(Buffer buffer, Buffer buffer2, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "sink");
        if (buffer.size() >= j) {
            buffer2.write(buffer, j);
        } else {
            buffer2.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    public static final long commonReadAll(Buffer buffer, Sink sink) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    public static final String commonReadUtf8(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (!(i >= 0 && j <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        } else if (buffer.size() < j) {
            throw new EOFException();
        } else if (i == 0) {
            return "";
        } else {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            if (((long) segment.pos) + j > ((long) segment.limit)) {
                return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j), 0, 0, 3, (Object) null);
            }
            int i2 = (int) j;
            String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, segment.pos, segment.pos + i2);
            segment.pos += i2;
            buffer.setSize$okio(buffer.size() - j);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return commonToUtf8String;
        }
    }

    public static final String commonReadUtf8Line(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long indexOf = buffer.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            byte b = (byte) 10;
            long indexOf = buffer.indexOf(b, 0, j2);
            if (indexOf != -1) {
                return readUtf8Line(buffer, indexOf);
            }
            if (j2 < buffer.size() && buffer.getByte(j2 - 1) == ((byte) 13) && buffer.getByte(j2) == b) {
                return readUtf8Line(buffer, j2);
            }
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, Math.min((long) 32, buffer.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(buffer.size(), j) + " content=" + buffer2.readByteString().hex() + Typography.ellipsis);
        }
        throw new IllegalArgumentException(("limit < 0: " + j).toString());
    }

    public static final int commonReadUtf8CodePoint(Buffer buffer) {
        byte b;
        int i;
        byte b2;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() != 0) {
            byte b3 = buffer.getByte(0);
            boolean z = false;
            if ((b3 & 128) == 0) {
                b2 = b3 & Byte.MAX_VALUE;
                b = 0;
                i = 1;
            } else if ((b3 & 224) == 192) {
                b2 = b3 & Ascii.US;
                i = 2;
                b = 128;
            } else if ((b3 & 240) == 224) {
                b2 = b3 & Ascii.SI;
                i = 3;
                b = 2048;
            } else if ((b3 & 248) == 240) {
                b2 = b3 & 7;
                i = 4;
                b = 65536;
            } else {
                buffer.skip(1);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            long j = (long) i;
            if (buffer.size() >= j) {
                int i2 = 1;
                while (i2 < i) {
                    long j2 = (long) i2;
                    byte b4 = buffer.getByte(j2);
                    if ((b4 & 192) == 128) {
                        b2 = (b2 << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
                        i2++;
                    } else {
                        buffer.skip(j2);
                        return Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                buffer.skip(j);
                if (b2 > 1114111) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                if (55296 <= b2 && b2 < 57344) {
                    z = true;
                }
                if (!z && b2 >= b) {
                    return b2;
                }
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            throw new EOFException("size < " + i + ": " + buffer.size() + " (to read code point prefixed 0x" + _UtilKt.toHexString(b3) + ')');
        }
        throw new EOFException();
    }

    public static final Buffer commonWriteUtf8(Buffer buffer, String str, int i, int i2) {
        char c;
        char charAt;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(str, "string");
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 <= str.length()) {
                    while (i < i2) {
                        char charAt2 = str.charAt(i);
                        if (charAt2 < 128) {
                            Segment writableSegment$okio = buffer.writableSegment$okio(1);
                            byte[] bArr = writableSegment$okio.data;
                            int i3 = writableSegment$okio.limit - i;
                            int min = Math.min(i2, 8192 - i3);
                            int i4 = i + 1;
                            bArr[i + i3] = (byte) charAt2;
                            while (true) {
                                i = i4;
                                if (i >= min || (charAt = str.charAt(i)) >= 128) {
                                    int i5 = (i3 + i) - writableSegment$okio.limit;
                                    writableSegment$okio.limit += i5;
                                    buffer.setSize$okio(buffer.size() + ((long) i5));
                                } else {
                                    i4 = i + 1;
                                    bArr[i + i3] = (byte) charAt;
                                }
                            }
                            int i52 = (i3 + i) - writableSegment$okio.limit;
                            writableSegment$okio.limit += i52;
                            buffer.setSize$okio(buffer.size() + ((long) i52));
                        } else {
                            if (charAt2 < 2048) {
                                Segment writableSegment$okio2 = buffer.writableSegment$okio(2);
                                writableSegment$okio2.data[writableSegment$okio2.limit] = (byte) ((charAt2 >> 6) | 192);
                                writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio2.limit += 2;
                                buffer.setSize$okio(buffer.size() + 2);
                            } else if (charAt2 < 55296 || charAt2 > 57343) {
                                Segment writableSegment$okio3 = buffer.writableSegment$okio(3);
                                writableSegment$okio3.data[writableSegment$okio3.limit] = (byte) ((charAt2 >> 12) | 224);
                                writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio3.limit += 3;
                                buffer.setSize$okio(buffer.size() + 3);
                            } else {
                                int i6 = i + 1;
                                if (i6 < i2) {
                                    c = str.charAt(i6);
                                } else {
                                    c = 0;
                                }
                                if (charAt2 <= 56319) {
                                    if (56320 <= c && c < 57344) {
                                        int i7 = (((charAt2 & 1023) << 10) | (c & 1023)) + 0;
                                        Segment writableSegment$okio4 = buffer.writableSegment$okio(4);
                                        writableSegment$okio4.data[writableSegment$okio4.limit] = (byte) ((i7 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                                        writableSegment$okio4.data[writableSegment$okio4.limit + 1] = (byte) (((i7 >> 12) & 63) | 128);
                                        writableSegment$okio4.data[writableSegment$okio4.limit + 2] = (byte) (((i7 >> 6) & 63) | 128);
                                        writableSegment$okio4.data[writableSegment$okio4.limit + 3] = (byte) ((i7 & 63) | 128);
                                        writableSegment$okio4.limit += 4;
                                        buffer.setSize$okio(buffer.size() + 4);
                                        i += 2;
                                    }
                                }
                                buffer.writeByte(63);
                                i = i6;
                            }
                            i++;
                        }
                    }
                    return buffer;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
    }

    public static final Buffer commonWriteUtf8CodePoint(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (i < 128) {
            buffer.writeByte(i);
        } else if (i < 2048) {
            Segment writableSegment$okio = buffer.writableSegment$okio(2);
            writableSegment$okio.data[writableSegment$okio.limit] = (byte) ((i >> 6) | 192);
            writableSegment$okio.data[writableSegment$okio.limit + 1] = (byte) ((i & 63) | 128);
            writableSegment$okio.limit += 2;
            buffer.setSize$okio(buffer.size() + 2);
        } else {
            boolean z = false;
            if (55296 <= i && i < 57344) {
                z = true;
            }
            if (z) {
                buffer.writeByte(63);
            } else if (i < 65536) {
                Segment writableSegment$okio2 = buffer.writableSegment$okio(3);
                writableSegment$okio2.data[writableSegment$okio2.limit] = (byte) ((i >> 12) | 224);
                writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte) (((i >> 6) & 63) | 128);
                writableSegment$okio2.data[writableSegment$okio2.limit + 2] = (byte) ((i & 63) | 128);
                writableSegment$okio2.limit += 3;
                buffer.setSize$okio(buffer.size() + 3);
            } else if (i <= 1114111) {
                Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
                writableSegment$okio3.data[writableSegment$okio3.limit] = (byte) ((i >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte) (((i >> 12) & 63) | 128);
                writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte) (((i >> 6) & 63) | 128);
                writableSegment$okio3.data[writableSegment$okio3.limit + 3] = (byte) ((i & 63) | 128);
                writableSegment$okio3.limit += 4;
                buffer.setSize$okio(buffer.size() + 4);
            } else {
                throw new IllegalArgumentException("Unexpected code point: 0x" + _UtilKt.toHexString(i));
            }
        }
        return buffer;
    }

    public static final long commonWriteAll(Buffer buffer, Source source) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public static final Buffer commonWrite(Buffer buffer, Source source, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        while (j > 0) {
            long read = source.read(buffer, j);
            if (read != -1) {
                j -= read;
            } else {
                throw new EOFException();
            }
        }
        return buffer;
    }

    public static final Buffer commonWriteByte(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        writableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    public static final Buffer commonWriteShort(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        writableSegment$okio.limit = i3 + 1;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    public static final Buffer commonWriteInt(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        writableSegment$okio.limit = i5 + 1;
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    public static final Buffer commonWriteLong(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i = writableSegment$okio.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        writableSegment$okio.limit = i8 + 1;
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    public static final void commonWrite(Buffer buffer, Buffer buffer2, long j) {
        Segment segment;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "source");
        if (buffer2 != buffer) {
            _UtilKt.checkOffsetAndCount(buffer2.size(), 0, j);
            while (j > 0) {
                Segment segment2 = buffer2.head;
                Intrinsics.checkNotNull(segment2);
                int i = segment2.limit;
                Segment segment3 = buffer2.head;
                Intrinsics.checkNotNull(segment3);
                if (j < ((long) (i - segment3.pos))) {
                    if (buffer.head != null) {
                        Segment segment4 = buffer.head;
                        Intrinsics.checkNotNull(segment4);
                        segment = segment4.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + j) - ((long) (segment.shared ? 0 : segment.pos)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            Segment segment5 = buffer2.head;
                            Intrinsics.checkNotNull(segment5);
                            segment5.writeTo(segment, (int) j);
                            buffer2.setSize$okio(buffer2.size() - j);
                            buffer.setSize$okio(buffer.size() + j);
                            return;
                        }
                    }
                    Segment segment6 = buffer2.head;
                    Intrinsics.checkNotNull(segment6);
                    buffer2.head = segment6.split((int) j);
                }
                Segment segment7 = buffer2.head;
                Intrinsics.checkNotNull(segment7);
                long j2 = (long) (segment7.limit - segment7.pos);
                buffer2.head = segment7.pop();
                if (buffer.head == null) {
                    buffer.head = segment7;
                    segment7.prev = segment7;
                    segment7.next = segment7.prev;
                } else {
                    Segment segment8 = buffer.head;
                    Intrinsics.checkNotNull(segment8);
                    Segment segment9 = segment8.prev;
                    Intrinsics.checkNotNull(segment9);
                    segment9.push(segment7).compact();
                }
                buffer2.setSize$okio(buffer2.size() - j2);
                buffer.setSize$okio(buffer.size() + j2);
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static final long commonRead(Buffer buffer, Buffer buffer2, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        } else if (buffer.size() == 0) {
            return -1;
        } else {
            if (j > buffer.size()) {
                j = buffer.size();
            }
            buffer2.write(buffer, j);
            return j;
        }
    }

    public static final long commonIndexOf(Buffer buffer, byte b, long j, long j2) {
        long j3;
        int i;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long j4 = 0;
        boolean z = false;
        if (0 <= j && j <= j2) {
            z = true;
        }
        if (z) {
            if (j2 > buffer.size()) {
                j2 = buffer.size();
            }
            if (j == j2) {
                return -1;
            }
            Segment segment = buffer.head;
            if (segment == null) {
                Segment segment2 = null;
                return -1;
            }
            if (buffer.size() - j < j) {
                j3 = buffer.size();
                while (j3 > j) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j3 -= (long) (segment.limit - segment.pos);
                }
                if (segment == null) {
                    return -1;
                }
                while (j3 < j2) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + j2) - j3);
                    i = (int) ((((long) segment.pos) + j) - j3);
                    while (i < min) {
                        if (bArr[i] != b) {
                            i++;
                        }
                    }
                    j3 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j3;
                }
                return -1;
            }
            while (true) {
                long j5 = ((long) (segment.limit - segment.pos)) + j4;
                if (j5 > j) {
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j4 = j5;
            }
            if (segment == null) {
                return -1;
            }
            while (j3 < j2) {
                byte[] bArr2 = segment.data;
                int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + j2) - j3);
                int i2 = (int) ((((long) segment.pos) + j) - j3);
                while (i < min2) {
                    if (bArr2[i] != b) {
                        i2 = i + 1;
                    }
                }
                j4 = j3 + ((long) (segment.limit - segment.pos));
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j = j4;
            }
            return -1;
            return ((long) (i - segment.pos)) + j3;
        }
        throw new IllegalArgumentException(("size=" + buffer.size() + " fromIndex=" + j + " toIndex=" + j2).toString());
    }

    public static final long commonIndexOf(Buffer buffer, ByteString byteString, long j) {
        Buffer buffer2 = buffer;
        long j2 = j;
        Intrinsics.checkNotNullParameter(buffer2, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (byteString.size() > 0) {
            long j3 = 0;
            if (j2 >= 0) {
                Segment segment = buffer2.head;
                if (segment == null) {
                    Segment segment2 = null;
                    return -1;
                } else if (buffer.size() - j2 < j2) {
                    long size = buffer.size();
                    while (size > j2) {
                        segment = segment.prev;
                        Intrinsics.checkNotNull(segment);
                        size -= (long) (segment.limit - segment.pos);
                    }
                    if (segment == null) {
                        return -1;
                    }
                    byte[] internalArray$okio = byteString.internalArray$okio();
                    byte b = internalArray$okio[0];
                    int size2 = byteString.size();
                    long size3 = (buffer.size() - ((long) size2)) + 1;
                    while (size < size3) {
                        byte[] bArr = segment.data;
                        int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + size3) - size);
                        for (int i = (int) ((((long) segment.pos) + j2) - size); i < min; i++) {
                            if (bArr[i] == b && rangeEquals(segment, i + 1, internalArray$okio, 1, size2)) {
                                return ((long) (i - segment.pos)) + size;
                            }
                        }
                        size += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j2 = size;
                    }
                    return -1;
                } else {
                    while (true) {
                        long j4 = ((long) (segment.limit - segment.pos)) + j3;
                        if (j4 > j2) {
                            break;
                        }
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j3 = j4;
                    }
                    if (segment == null) {
                        return -1;
                    }
                    byte[] internalArray$okio2 = byteString.internalArray$okio();
                    byte b2 = internalArray$okio2[0];
                    int size4 = byteString.size();
                    long size5 = (buffer.size() - ((long) size4)) + 1;
                    while (j3 < size5) {
                        byte[] bArr2 = segment.data;
                        long j5 = j3;
                        int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + size5) - j3);
                        long j6 = ((long) segment.pos) + j2;
                        long j7 = j5;
                        for (int i2 = (int) (j6 - j7); i2 < min2; i2++) {
                            if (bArr2[i2] == b2) {
                                if (rangeEquals(segment, i2 + 1, internalArray$okio2, 1, size4)) {
                                    return ((long) (i2 - segment.pos)) + j7;
                                }
                            }
                        }
                        j3 = j7 + ((long) (segment.limit - segment.pos));
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j2 = j3;
                    }
                    return -1;
                }
            } else {
                throw new IllegalArgumentException(("fromIndex < 0: " + j2).toString());
            }
        } else {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
    }

    public static final boolean commonRangeEquals(Buffer buffer, long j, ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || buffer.size() - j < ((long) i2) || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (buffer.getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean commonEquals(okio.Buffer r18, java.lang.Object r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = 1
            if (r0 != r1) goto L_0x000d
            return r2
        L_0x000d:
            boolean r3 = r1 instanceof okio.Buffer
            r4 = 0
            if (r3 != 0) goto L_0x0013
            return r4
        L_0x0013:
            long r5 = r18.size()
            okio.Buffer r1 = (okio.Buffer) r1
            long r7 = r1.size()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0022
            return r4
        L_0x0022:
            long r5 = r18.size()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x002d
            return r2
        L_0x002d:
            okio.Segment r3 = r0.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            okio.Segment r1 = r1.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r5 = r3.pos
            int r6 = r1.pos
            r9 = r7
        L_0x003c:
            long r11 = r18.size()
            int r11 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0083
            int r11 = r3.limit
            int r11 = r11 - r5
            int r12 = r1.limit
            int r12 = r12 - r6
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            r13 = r7
        L_0x0050:
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 >= 0) goto L_0x006b
            byte[] r15 = r3.data
            int r16 = r5 + 1
            byte r5 = r15[r5]
            byte[] r15 = r1.data
            int r17 = r6 + 1
            byte r6 = r15[r6]
            if (r5 == r6) goto L_0x0063
            return r4
        L_0x0063:
            r5 = 1
            long r13 = r13 + r5
            r5 = r16
            r6 = r17
            goto L_0x0050
        L_0x006b:
            int r13 = r3.limit
            if (r5 != r13) goto L_0x0076
            okio.Segment r3 = r3.next
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r5 = r3.pos
        L_0x0076:
            int r13 = r1.limit
            if (r6 != r13) goto L_0x0081
            okio.Segment r1 = r1.next
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r6 = r1.pos
        L_0x0081:
            long r9 = r9 + r11
            goto L_0x003c
        L_0x0083:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonEquals(okio.Buffer, java.lang.Object):boolean");
    }

    public static final int commonHashCode(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment segment = buffer.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        } while (segment != buffer.head);
        return i;
    }

    public static final Buffer commonCopy(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Buffer buffer2 = new Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer2.head = sharedCopy;
        sharedCopy.prev = buffer2.head;
        sharedCopy.next = sharedCopy.prev;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            Intrinsics.checkNotNull(segment3);
            Intrinsics.checkNotNull(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }

    public static final ByteString commonSnapshot(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() <= 2147483647L) {
            return buffer.snapshot((int) buffer.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + buffer.size()).toString());
    }

    public static final ByteString commonSnapshot(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (i == 0) {
            return ByteString.EMPTY;
        }
        _UtilKt.checkOffsetAndCount(buffer.size(), 0, (long) i);
        Segment segment = buffer.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Intrinsics.checkNotNull(segment);
            if (segment.limit != segment.pos) {
                i3 += segment.limit - segment.pos;
                i4++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[(i4 * 2)];
        Segment segment2 = buffer.head;
        int i5 = 0;
        while (i2 < i) {
            Intrinsics.checkNotNull(segment2);
            bArr[i5] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i5] = Math.min(i2, i);
            iArr[((Object[]) bArr).length + i5] = segment2.pos;
            segment2.shared = true;
            i5++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    public static final Buffer.UnsafeCursor commonReadUnsafe(Buffer buffer, Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = _UtilKt.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer == null) {
            resolveDefaultParameter.buffer = buffer;
            resolveDefaultParameter.readWrite = false;
            return resolveDefaultParameter;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final Buffer.UnsafeCursor commonReadAndWriteUnsafe(Buffer buffer, Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = _UtilKt.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer == null) {
            resolveDefaultParameter.buffer = buffer;
            resolveDefaultParameter.readWrite = true;
            return resolveDefaultParameter;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final int commonNext(Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        long j = unsafeCursor.offset;
        Buffer buffer = unsafeCursor.buffer;
        Intrinsics.checkNotNull(buffer);
        if (j != buffer.size()) {
            return unsafeCursor.seek(unsafeCursor.offset == -1 ? 0 : unsafeCursor.offset + ((long) (unsafeCursor.end - unsafeCursor.start)));
        }
        throw new IllegalStateException("no more bytes".toString());
    }

    public static final int commonSeek(Buffer.UnsafeCursor unsafeCursor, long j) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        Buffer buffer = unsafeCursor.buffer;
        if (buffer != null) {
            int i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
            if (i < 0 || j > buffer.size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + buffer.size());
            } else if (i == 0 || j == buffer.size()) {
                unsafeCursor.setSegment$okio((Segment) null);
                unsafeCursor.offset = j;
                unsafeCursor.data = null;
                unsafeCursor.start = -1;
                unsafeCursor.end = -1;
                return -1;
            } else {
                long j2 = 0;
                long size = buffer.size();
                Segment segment = buffer.head;
                Segment segment2 = buffer.head;
                if (unsafeCursor.getSegment$okio() != null) {
                    long j3 = unsafeCursor.offset;
                    int i2 = unsafeCursor.start;
                    Segment segment$okio = unsafeCursor.getSegment$okio();
                    Intrinsics.checkNotNull(segment$okio);
                    long j4 = j3 - ((long) (i2 - segment$okio.pos));
                    if (j4 > j) {
                        segment2 = unsafeCursor.getSegment$okio();
                        size = j4;
                    } else {
                        segment = unsafeCursor.getSegment$okio();
                        j2 = j4;
                    }
                }
                if (size - j > j - j2) {
                    while (true) {
                        Intrinsics.checkNotNull(segment);
                        if (j < ((long) (segment.limit - segment.pos)) + j2) {
                            break;
                        }
                        j2 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                    }
                } else {
                    while (size > j) {
                        Intrinsics.checkNotNull(segment2);
                        segment2 = segment2.prev;
                        Intrinsics.checkNotNull(segment2);
                        size -= (long) (segment2.limit - segment2.pos);
                    }
                    j2 = size;
                    segment = segment2;
                }
                if (unsafeCursor.readWrite) {
                    Intrinsics.checkNotNull(segment);
                    if (segment.shared) {
                        Segment unsharedCopy = segment.unsharedCopy();
                        if (buffer.head == segment) {
                            buffer.head = unsharedCopy;
                        }
                        segment = segment.push(unsharedCopy);
                        Segment segment3 = segment.prev;
                        Intrinsics.checkNotNull(segment3);
                        segment3.pop();
                    }
                }
                unsafeCursor.setSegment$okio(segment);
                unsafeCursor.offset = j;
                Intrinsics.checkNotNull(segment);
                unsafeCursor.data = segment.data;
                unsafeCursor.start = segment.pos + ((int) (j - j2));
                unsafeCursor.end = segment.limit;
                return unsafeCursor.end - unsafeCursor.start;
            }
        } else {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }

    public static final long commonResizeBuffer(Buffer.UnsafeCursor unsafeCursor, long j) {
        Buffer.UnsafeCursor unsafeCursor2 = unsafeCursor;
        long j2 = j;
        Intrinsics.checkNotNullParameter(unsafeCursor2, "<this>");
        Buffer buffer = unsafeCursor2.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        } else if (unsafeCursor2.readWrite) {
            long size = buffer.size();
            int i = (j2 > size ? 1 : (j2 == size ? 0 : -1));
            int i2 = 1;
            if (i <= 0) {
                if (j2 >= 0) {
                    long j3 = size - j2;
                    while (true) {
                        if (j3 <= 0) {
                            break;
                        }
                        Segment segment = buffer.head;
                        Intrinsics.checkNotNull(segment);
                        Segment segment2 = segment.prev;
                        Intrinsics.checkNotNull(segment2);
                        long j4 = (long) (segment2.limit - segment2.pos);
                        if (j4 > j3) {
                            segment2.limit -= (int) j3;
                            break;
                        }
                        buffer.head = segment2.pop();
                        SegmentPool.recycle(segment2);
                        j3 -= j4;
                    }
                    unsafeCursor2.setSegment$okio((Segment) null);
                    unsafeCursor2.offset = j2;
                    unsafeCursor2.data = null;
                    unsafeCursor2.start = -1;
                    unsafeCursor2.end = -1;
                } else {
                    throw new IllegalArgumentException(("newSize < 0: " + j2).toString());
                }
            } else if (i > 0) {
                long j5 = j2 - size;
                boolean z = true;
                while (j5 > 0) {
                    Segment writableSegment$okio = buffer.writableSegment$okio(i2);
                    int min = (int) Math.min(j5, (long) (8192 - writableSegment$okio.limit));
                    writableSegment$okio.limit += min;
                    j5 -= (long) min;
                    if (z) {
                        unsafeCursor2.setSegment$okio(writableSegment$okio);
                        unsafeCursor2.offset = size;
                        unsafeCursor2.data = writableSegment$okio.data;
                        unsafeCursor2.start = writableSegment$okio.limit - min;
                        unsafeCursor2.end = writableSegment$okio.limit;
                        z = false;
                    }
                    i2 = 1;
                }
            }
            buffer.setSize$okio(j2);
            return size;
        } else {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }
    }

    public static final long commonExpandBuffer(Buffer.UnsafeCursor unsafeCursor, int i) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        boolean z = true;
        if (i > 0) {
            if (i > 8192) {
                z = false;
            }
            if (z) {
                Buffer buffer = unsafeCursor.buffer;
                if (buffer == null) {
                    throw new IllegalStateException("not attached to a buffer".toString());
                } else if (unsafeCursor.readWrite) {
                    long size = buffer.size();
                    Segment writableSegment$okio = buffer.writableSegment$okio(i);
                    int i2 = 8192 - writableSegment$okio.limit;
                    writableSegment$okio.limit = 8192;
                    long j = (long) i2;
                    buffer.setSize$okio(size + j);
                    unsafeCursor.setSegment$okio(writableSegment$okio);
                    unsafeCursor.offset = size;
                    unsafeCursor.data = writableSegment$okio.data;
                    unsafeCursor.start = 8192 - i2;
                    unsafeCursor.end = 8192;
                    return j;
                } else {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                }
            } else {
                throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i).toString());
            }
        } else {
            throw new IllegalArgumentException(("minByteCount <= 0: " + i).toString());
        }
    }

    public static final void commonClose(Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        if (unsafeCursor.buffer != null) {
            unsafeCursor.buffer = null;
            unsafeCursor.setSegment$okio((Segment) null);
            unsafeCursor.offset = -1;
            unsafeCursor.data = null;
            unsafeCursor.start = -1;
            unsafeCursor.end = -1;
            return;
        }
        throw new IllegalStateException("not attached to a buffer".toString());
    }

    public static final long commonIndexOfElement(Buffer buffer, ByteString byteString, long j) {
        long j2;
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        long j3 = 0;
        if (j >= 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                Segment segment2 = null;
                return -1;
            }
            if (buffer.size() - j < j) {
                j2 = buffer.size();
                while (j2 > j) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j2 -= (long) (segment.limit - segment.pos);
                }
                if (segment == null) {
                    return -1;
                }
                if (byteString.size() == 2) {
                    byte b = byteString.getByte(0);
                    byte b2 = byteString.getByte(1);
                    while (j2 < buffer.size()) {
                        byte[] bArr = segment.data;
                        i2 = (int) ((((long) segment.pos) + j) - j2);
                        int i4 = segment.limit;
                        while (i2 < i4) {
                            byte b3 = bArr[i2];
                            if (!(b3 == b || b3 == b2)) {
                                i2++;
                            }
                        }
                        j2 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j = j2;
                    }
                } else {
                    byte[] internalArray$okio = byteString.internalArray$okio();
                    while (j2 < buffer.size()) {
                        byte[] bArr2 = segment.data;
                        i = (int) ((((long) segment.pos) + j) - j2);
                        int i5 = segment.limit;
                        while (i < i5) {
                            byte b4 = bArr2[i];
                            for (byte b5 : internalArray$okio) {
                                if (b4 == b5) {
                                    i3 = segment.pos;
                                    return ((long) (i2 - i3)) + j2;
                                }
                            }
                            i++;
                        }
                        j2 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j = j2;
                    }
                }
                return -1;
            }
            while (true) {
                long j4 = ((long) (segment.limit - segment.pos)) + j3;
                if (j4 > j) {
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j3 = j4;
            }
            if (segment == null) {
                return -1;
            }
            if (byteString.size() == 2) {
                byte b6 = byteString.getByte(0);
                byte b7 = byteString.getByte(1);
                while (j2 < buffer.size()) {
                    byte[] bArr3 = segment.data;
                    int i6 = (int) ((((long) segment.pos) + j) - j2);
                    int i7 = segment.limit;
                    while (i2 < i7) {
                        byte b8 = bArr3[i2];
                        if (!(b8 == b6 || b8 == b7)) {
                            i6 = i2 + 1;
                        }
                    }
                    j3 = j2 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j3;
                }
            } else {
                byte[] internalArray$okio2 = byteString.internalArray$okio();
                while (j2 < buffer.size()) {
                    byte[] bArr4 = segment.data;
                    int i8 = (int) ((((long) segment.pos) + j) - j2);
                    int i9 = segment.limit;
                    while (i < i9) {
                        byte b9 = bArr4[i];
                        for (byte b10 : internalArray$okio2) {
                            if (b9 == b10) {
                                i3 = segment.pos;
                                return ((long) (i2 - i3)) + j2;
                            }
                        }
                        i8 = i + 1;
                    }
                    j3 = j2 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j3;
                }
            }
            return -1;
            i3 = segment.pos;
            return ((long) (i2 - i3)) + j2;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
    }
}
