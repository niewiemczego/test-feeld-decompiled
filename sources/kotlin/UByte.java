package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

@JvmInline
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u000fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0012J\u001b\u0010&\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u000fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0012J\u001b\u00102\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b8\u0010\u000bJ\u001b\u00107\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b9\u0010\u0012J\u001b\u00107\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b:\u0010\u001fJ\u001b\u00107\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u000fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0012J\u001b\u0010?\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bI\u0010GJ\u001b\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u000fJ\u001b\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0012J\u001b\u0010J\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\bM\u0010\u001fJ\u001b\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u0018J\u001b\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u000fJ\u001b\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u0012J\u001b\u0010O\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\bR\u0010\u001fJ\u001b\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bS\u0010\u0018J\u0010\u0010T\u001a\u00020\u0003H\b¢\u0006\u0004\bU\u0010\u0005J\u0010\u0010V\u001a\u00020WH\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\rH\b¢\u0006\u0004\b_\u0010-J\u0010\u0010`\u001a\u00020aH\b¢\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020eH\b¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\bj\u0010kJ\u0016\u0010l\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bm\u0010\u0005J\u0016\u0010n\u001a\u00020\u0010H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bo\u0010-J\u0016\u0010p\u001a\u00020\u0013H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bq\u0010cJ\u0016\u0010r\u001a\u00020\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bs\u0010gJ\u001b\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\bu\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006w"}, d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(B)I", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(BS)S", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-7apg3OU", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UByte.kt */
public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UByte m995boximpl(byte b) {
        return new UByte(b);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte m1001constructorimpl(byte b) {
        return b;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1007equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).m1051unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1008equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1013hashCodeimpl(byte b) {
        return Byte.hashCode(b);
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m1039toByteimpl(byte b) {
        return b;
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m1040toDoubleimpl(byte b) {
        return (double) (b & 255);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m1041toFloatimpl(byte b) {
        return (float) (b & 255);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m1042toIntimpl(byte b) {
        return b & 255;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m1043toLongimpl(byte b) {
        return ((long) b) & 255;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m1044toShortimpl(byte b) {
        return (short) (((short) b) & 255);
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m1046toUBytew2LRezQ(byte b) {
        return b;
    }

    public boolean equals(Object obj) {
        return m1007equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m1013hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ byte m1051unboximpl() {
        return this.data;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Intrinsics.compare((int) m1051unboximpl() & 255, (int) ((UByte) obj).m1051unboximpl() & 255);
    }

    private /* synthetic */ UByte(byte b) {
        this.data = b;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UByte$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UByte;", "B", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UByte.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private int m996compareTo7apg3OU(byte b) {
        return Intrinsics.compare((int) m1051unboximpl() & 255, (int) b & 255);
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static int m997compareTo7apg3OU(byte b, byte b2) {
        return Intrinsics.compare((int) b & 255, (int) b2 & 255);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m1000compareToxj2QHRw(byte b, short s) {
        return Intrinsics.compare((int) b & 255, (int) s & UShort.MAX_VALUE);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m999compareToWZ4Q5Ns(byte b, int i) {
        return Integer.compareUnsigned(UInt.m1078constructorimpl(b & 255), i);
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m998compareToVKZWuLQ(byte b, long j) {
        return Long.compareUnsigned(ULong.m1157constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m1025plus7apg3OU(byte b, byte b2) {
        return UInt.m1078constructorimpl(UInt.m1078constructorimpl(b & 255) + UInt.m1078constructorimpl(b2 & 255));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m1028plusxj2QHRw(byte b, short s) {
        return UInt.m1078constructorimpl(UInt.m1078constructorimpl(b & 255) + UInt.m1078constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m1027plusWZ4Q5Ns(byte b, int i) {
        return UInt.m1078constructorimpl(UInt.m1078constructorimpl(b & 255) + i);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m1026plusVKZWuLQ(byte b, long j) {
        return ULong.m1157constructorimpl(ULong.m1157constructorimpl(((long) b) & 255) + j);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m1016minus7apg3OU(byte b, byte b2) {
        return UInt.m1078constructorimpl(UInt.m1078constructorimpl(b & 255) - UInt.m1078constructorimpl(b2 & 255));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m1019minusxj2QHRw(byte b, short s) {
        return UInt.m1078constructorimpl(UInt.m1078constructorimpl(b & 255) - UInt.m1078constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m1018minusWZ4Q5Ns(byte b, int i) {
        return UInt.m1078constructorimpl(UInt.m1078constructorimpl(b & 255) - i);
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m1017minusVKZWuLQ(byte b, long j) {
        return ULong.m1157constructorimpl(ULong.m1157constructorimpl(((long) b) & 255) - j);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m1035times7apg3OU(byte b, byte b2) {
        return UInt.m1078constructorimpl(UInt.m1078constructorimpl(b & 255) * UInt.m1078constructorimpl(b2 & 255));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m1038timesxj2QHRw(byte b, short s) {
        return UInt.m1078constructorimpl(UInt.m1078constructorimpl(b & 255) * UInt.m1078constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m1037timesWZ4Q5Ns(byte b, int i) {
        return UInt.m1078constructorimpl(UInt.m1078constructorimpl(b & 255) * i);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m1036timesVKZWuLQ(byte b, long j) {
        return ULong.m1157constructorimpl(ULong.m1157constructorimpl(((long) b) & 255) * j);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m1003div7apg3OU(byte b, byte b2) {
        return Integer.divideUnsigned(UInt.m1078constructorimpl(b & 255), UInt.m1078constructorimpl(b2 & 255));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m1006divxj2QHRw(byte b, short s) {
        return Integer.divideUnsigned(UInt.m1078constructorimpl(b & 255), UInt.m1078constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m1005divWZ4Q5Ns(byte b, int i) {
        return Integer.divideUnsigned(UInt.m1078constructorimpl(b & 255), i);
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m1004divVKZWuLQ(byte b, long j) {
        return Long.divideUnsigned(ULong.m1157constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m1031rem7apg3OU(byte b, byte b2) {
        return Integer.remainderUnsigned(UInt.m1078constructorimpl(b & 255), UInt.m1078constructorimpl(b2 & 255));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m1034remxj2QHRw(byte b, short s) {
        return Integer.remainderUnsigned(UInt.m1078constructorimpl(b & 255), UInt.m1078constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m1033remWZ4Q5Ns(byte b, int i) {
        return Integer.remainderUnsigned(UInt.m1078constructorimpl(b & 255), i);
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m1032remVKZWuLQ(byte b, long j) {
        return Long.remainderUnsigned(ULong.m1157constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m1009floorDiv7apg3OU(byte b, byte b2) {
        return Integer.divideUnsigned(UInt.m1078constructorimpl(b & 255), UInt.m1078constructorimpl(b2 & 255));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m1012floorDivxj2QHRw(byte b, short s) {
        return Integer.divideUnsigned(UInt.m1078constructorimpl(b & 255), UInt.m1078constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m1011floorDivWZ4Q5Ns(byte b, int i) {
        return Integer.divideUnsigned(UInt.m1078constructorimpl(b & 255), i);
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m1010floorDivVKZWuLQ(byte b, long j) {
        return Long.divideUnsigned(ULong.m1157constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m1020mod7apg3OU(byte b, byte b2) {
        return m1001constructorimpl((byte) Integer.remainderUnsigned(UInt.m1078constructorimpl(b & 255), UInt.m1078constructorimpl(b2 & 255)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m1023modxj2QHRw(byte b, short s) {
        return UShort.m1264constructorimpl((short) Integer.remainderUnsigned(UInt.m1078constructorimpl(b & 255), UInt.m1078constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m1022modWZ4Q5Ns(byte b, int i) {
        return Integer.remainderUnsigned(UInt.m1078constructorimpl(b & 255), i);
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m1021modVKZWuLQ(byte b, long j) {
        return Long.remainderUnsigned(ULong.m1157constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: inc-w2LRezQ  reason: not valid java name */
    private static final byte m1014incw2LRezQ(byte b) {
        return m1001constructorimpl((byte) (b + 1));
    }

    /* renamed from: dec-w2LRezQ  reason: not valid java name */
    private static final byte m1002decw2LRezQ(byte b) {
        return m1001constructorimpl((byte) (b - 1));
    }

    /* renamed from: rangeTo-7apg3OU  reason: not valid java name */
    private static final UIntRange m1029rangeTo7apg3OU(byte b, byte b2) {
        return new UIntRange(UInt.m1078constructorimpl(b & 255), UInt.m1078constructorimpl(b2 & 255), (DefaultConstructorMarker) null);
    }

    /* renamed from: rangeUntil-7apg3OU  reason: not valid java name */
    private static final UIntRange m1030rangeUntil7apg3OU(byte b, byte b2) {
        return URangesKt.m2259untilJ1ME1BU(UInt.m1078constructorimpl(b & 255), UInt.m1078constructorimpl(b2 & 255));
    }

    /* renamed from: and-7apg3OU  reason: not valid java name */
    private static final byte m994and7apg3OU(byte b, byte b2) {
        return m1001constructorimpl((byte) (b & b2));
    }

    /* renamed from: or-7apg3OU  reason: not valid java name */
    private static final byte m1024or7apg3OU(byte b, byte b2) {
        return m1001constructorimpl((byte) (b | b2));
    }

    /* renamed from: xor-7apg3OU  reason: not valid java name */
    private static final byte m1050xor7apg3OU(byte b, byte b2) {
        return m1001constructorimpl((byte) (b ^ b2));
    }

    /* renamed from: inv-w2LRezQ  reason: not valid java name */
    private static final byte m1015invw2LRezQ(byte b) {
        return m1001constructorimpl((byte) (~b));
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m1049toUShortMh2AYeg(byte b) {
        return UShort.m1264constructorimpl((short) (((short) b) & 255));
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m1047toUIntpVg5ArA(byte b) {
        return UInt.m1078constructorimpl(b & 255);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m1048toULongsVKNKU(byte b) {
        return ULong.m1157constructorimpl(((long) b) & 255);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1045toStringimpl(byte b) {
        return String.valueOf(b & 255);
    }

    public String toString() {
        return m1045toStringimpl(this.data);
    }
}
