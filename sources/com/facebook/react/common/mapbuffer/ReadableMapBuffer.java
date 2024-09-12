package com.facebook.react.common.mapbuffer;

import com.facebook.jni.HybridData;
import com.facebook.react.common.mapbuffer.MapBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u000f\b\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0013\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002J\u0010\u0010\"\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00000$2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010)\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010*\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020\tH\u0016J\t\u0010,\u001a\u00020\u0006H J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140.H\u0002J\u0010\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\tH\u0002J\u0010\u00101\u001a\u00020(2\u0006\u0010!\u001a\u00020\tH\u0002J\u0010\u00102\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\tH\u0002J\b\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\u0002J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\u00000$2\u0006\u00107\u001a\u00020\tH\u0002J\u0010\u00108\u001a\u00020\u00002\u0006\u00107\u001a\u00020\tH\u0002J\u0010\u00109\u001a\u00020&2\u0006\u00100\u001a\u00020\tH\u0002J \u0010:\u001a\u00020;2\u0006\u00100\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b<\u0010=J\b\u0010>\u001a\u00020&H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006A"}, d2 = {"Lcom/facebook/react/common/mapbuffer/ReadableMapBuffer;", "Lcom/facebook/react/common/mapbuffer/MapBuffer;", "hybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "buffer", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)V", "<set-?>", "", "count", "getCount", "()I", "mHybridData", "offsetForDynamicData", "getOffsetForDynamicData", "contains", "", "key", "entryAt", "Lcom/facebook/react/common/mapbuffer/MapBuffer$Entry;", "offset", "equals", "other", "", "getBoolean", "getBucketIndexForKey", "intKey", "getDouble", "", "getInt", "getKeyOffset", "getKeyOffsetForBucketIndex", "bucketIndex", "getMapBuffer", "getMapBufferList", "", "getString", "", "getType", "Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "getTypedValueOffsetForKey", "expected", "hashCode", "importByteBuffer", "iterator", "", "readBooleanValue", "bufferPosition", "readDataType", "readDoubleValue", "readHeader", "", "readIntValue", "readMapBufferListValue", "position", "readMapBufferValue", "readStringValue", "readUnsignedShort", "Lkotlin/UShort;", "readUnsignedShort-BwKQO78", "(I)S", "toString", "Companion", "MapBufferEntry", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReadableMapBuffer.kt */
public final class ReadableMapBuffer implements MapBuffer {
    private static final int ALIGNMENT = 254;
    private static final int BUCKET_SIZE = 12;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int HEADER_SIZE = 8;
    private static final int TYPE_OFFSET = 2;
    private static final int VALUE_OFFSET = 4;
    private final ByteBuffer buffer;
    private int count;
    private final HybridData mHybridData;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ReadableMapBuffer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MapBuffer.DataType.values().length];
            iArr[MapBuffer.DataType.BOOL.ordinal()] = 1;
            iArr[MapBuffer.DataType.INT.ordinal()] = 2;
            iArr[MapBuffer.DataType.DOUBLE.ordinal()] = 3;
            iArr[MapBuffer.DataType.STRING.ordinal()] = 4;
            iArr[MapBuffer.DataType.MAP.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    public final int getKeyOffsetForBucketIndex(int i) {
        return (i * 12) + 8;
    }

    private final native ByteBuffer importByteBuffer();

    public int getCount() {
        return this.count;
    }

    private ReadableMapBuffer(HybridData hybridData) {
        this.mHybridData = hybridData;
        this.buffer = importByteBuffer();
        readHeader();
    }

    private ReadableMapBuffer(ByteBuffer byteBuffer) {
        this.mHybridData = null;
        this.buffer = byteBuffer;
        readHeader();
    }

    private final void readHeader() {
        if (this.buffer.getShort() != ALIGNMENT) {
            this.buffer.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.count = m409readUnsignedShortBwKQO78(this.buffer.position()) & UShort.MAX_VALUE;
    }

    private final int getOffsetForDynamicData() {
        return getKeyOffsetForBucketIndex(getCount());
    }

    private final int getBucketIndexForKey(int i) {
        IntRange kEY_RANGE$ReactAndroid_release = MapBuffer.Companion.getKEY_RANGE$ReactAndroid_release();
        int i2 = 0;
        if (!(i <= kEY_RANGE$ReactAndroid_release.getLast() && kEY_RANGE$ReactAndroid_release.getFirst() <= i)) {
            return -1;
        }
        short r9 = UShort.m1264constructorimpl((short) i);
        int count2 = getCount() - 1;
        while (i2 <= count2) {
            int i3 = (i2 + count2) >>> 1;
            short r5 = m409readUnsignedShortBwKQO78(getKeyOffsetForBucketIndex(i3)) & UShort.MAX_VALUE;
            short s = 65535 & r9;
            if (Intrinsics.compare((int) r5, (int) s) < 0) {
                i2 = i3 + 1;
            } else if (Intrinsics.compare((int) r5, (int) s) <= 0) {
                return i3;
            } else {
                count2 = i3 - 1;
            }
        }
        return -1;
    }

    private final MapBuffer.DataType readDataType(int i) {
        return MapBuffer.DataType.values()[m409readUnsignedShortBwKQO78(getKeyOffsetForBucketIndex(i) + 2) & UShort.MAX_VALUE];
    }

    private final int getTypedValueOffsetForKey(int i, MapBuffer.DataType dataType) {
        int bucketIndexForKey = getBucketIndexForKey(i);
        boolean z = true;
        if (bucketIndexForKey != -1) {
            MapBuffer.DataType readDataType = readDataType(bucketIndexForKey);
            if (readDataType != dataType) {
                z = false;
            }
            if (z) {
                return getKeyOffsetForBucketIndex(bucketIndexForKey) + 4;
            }
            throw new IllegalStateException(("Expected " + dataType + " for key: " + i + ", found " + readDataType + " instead.").toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Key not found: ", Integer.valueOf(i)).toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: readUnsignedShort-BwKQO78  reason: not valid java name */
    public final short m409readUnsignedShortBwKQO78(int i) {
        return UShort.m1264constructorimpl(this.buffer.getShort(i));
    }

    /* access modifiers changed from: private */
    public final double readDoubleValue(int i) {
        return this.buffer.getDouble(i);
    }

    /* access modifiers changed from: private */
    public final int readIntValue(int i) {
        return this.buffer.getInt(i);
    }

    /* access modifiers changed from: private */
    public final boolean readBooleanValue(int i) {
        return readIntValue(i) == 1;
    }

    /* access modifiers changed from: private */
    public final String readStringValue(int i) {
        int offsetForDynamicData = getOffsetForDynamicData() + this.buffer.getInt(i);
        int i2 = this.buffer.getInt(offsetForDynamicData);
        byte[] bArr = new byte[i2];
        this.buffer.position(offsetForDynamicData + 4);
        this.buffer.get(bArr, 0, i2);
        return new String(bArr, Charsets.UTF_8);
    }

    /* access modifiers changed from: private */
    public final ReadableMapBuffer readMapBufferValue(int i) {
        int offsetForDynamicData = getOffsetForDynamicData() + this.buffer.getInt(i);
        int i2 = this.buffer.getInt(offsetForDynamicData);
        byte[] bArr = new byte[i2];
        this.buffer.position(offsetForDynamicData + 4);
        this.buffer.get(bArr, 0, i2);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(newBuffer)");
        return new ReadableMapBuffer(wrap);
    }

    private final List<ReadableMapBuffer> readMapBufferListValue(int i) {
        ArrayList arrayList = new ArrayList();
        int offsetForDynamicData = getOffsetForDynamicData() + this.buffer.getInt(i);
        int i2 = this.buffer.getInt(offsetForDynamicData);
        int i3 = offsetForDynamicData + 4;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = this.buffer.getInt(i3 + i4);
            byte[] bArr = new byte[i5];
            int i6 = i4 + 4;
            this.buffer.position(i3 + i6);
            this.buffer.get(bArr, 0, i5);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            Intrinsics.checkNotNullExpressionValue(wrap, "wrap(newMapBuffer)");
            arrayList.add(new ReadableMapBuffer(wrap));
            i4 = i6 + i5;
        }
        return arrayList;
    }

    public boolean contains(int i) {
        return getBucketIndexForKey(i) != -1;
    }

    public int getKeyOffset(int i) {
        return getBucketIndexForKey(i);
    }

    public MapBuffer.Entry entryAt(int i) {
        return new MapBufferEntry(this, getKeyOffsetForBucketIndex(i));
    }

    public MapBuffer.DataType getType(int i) {
        int bucketIndexForKey = getBucketIndexForKey(i);
        if (bucketIndexForKey != -1) {
            return readDataType(bucketIndexForKey);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Key not found: ", Integer.valueOf(i)).toString());
    }

    public int getInt(int i) {
        return readIntValue(getTypedValueOffsetForKey(i, MapBuffer.DataType.INT));
    }

    public double getDouble(int i) {
        return readDoubleValue(getTypedValueOffsetForKey(i, MapBuffer.DataType.DOUBLE));
    }

    public String getString(int i) {
        return readStringValue(getTypedValueOffsetForKey(i, MapBuffer.DataType.STRING));
    }

    public boolean getBoolean(int i) {
        return readBooleanValue(getTypedValueOffsetForKey(i, MapBuffer.DataType.BOOL));
    }

    public ReadableMapBuffer getMapBuffer(int i) {
        return readMapBufferValue(getTypedValueOffsetForKey(i, MapBuffer.DataType.MAP));
    }

    public List<ReadableMapBuffer> getMapBufferList(int i) {
        return readMapBufferListValue(getTypedValueOffsetForKey(i, MapBuffer.DataType.MAP));
    }

    public int hashCode() {
        this.buffer.rewind();
        return this.buffer.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ReadableMapBuffer)) {
            return false;
        }
        ByteBuffer byteBuffer = this.buffer;
        ByteBuffer byteBuffer2 = ((ReadableMapBuffer) obj).buffer;
        if (byteBuffer == byteBuffer2) {
            return true;
        }
        byteBuffer.rewind();
        byteBuffer2.rewind();
        return Intrinsics.areEqual((Object) byteBuffer, (Object) byteBuffer2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Iterator<MapBuffer.Entry> it = iterator();
        while (it.hasNext()) {
            MapBuffer.Entry next = it.next();
            sb.append(next.getKey());
            sb.append('=');
            int i = WhenMappings.$EnumSwitchMapping$0[next.getType().ordinal()];
            if (i == 1) {
                sb.append(next.getBooleanValue());
            } else if (i == 2) {
                sb.append(next.getIntValue());
            } else if (i == 3) {
                sb.append(next.getDoubleValue());
            } else if (i == 4) {
                sb.append(next.getStringValue());
            } else if (i == 5) {
                sb.append(next.getMapBufferValue().toString());
            }
            sb.append(',');
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }

    public Iterator<MapBuffer.Entry> iterator() {
        return new ReadableMapBuffer$iterator$1(this);
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001bH\u0002R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/facebook/react/common/mapbuffer/ReadableMapBuffer$MapBufferEntry;", "Lcom/facebook/react/common/mapbuffer/MapBuffer$Entry;", "bucketOffset", "", "(Lcom/facebook/react/common/mapbuffer/ReadableMapBuffer;I)V", "booleanValue", "", "getBooleanValue", "()Z", "doubleValue", "", "getDoubleValue", "()D", "intValue", "getIntValue", "()I", "key", "getKey", "mapBufferValue", "Lcom/facebook/react/common/mapbuffer/MapBuffer;", "getMapBufferValue", "()Lcom/facebook/react/common/mapbuffer/MapBuffer;", "stringValue", "", "getStringValue", "()Ljava/lang/String;", "type", "Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "getType", "()Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "assertType", "", "expected", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ReadableMapBuffer.kt */
    private final class MapBufferEntry implements MapBuffer.Entry {
        private final int bucketOffset;
        final /* synthetic */ ReadableMapBuffer this$0;

        public MapBufferEntry(ReadableMapBuffer readableMapBuffer, int i) {
            Intrinsics.checkNotNullParameter(readableMapBuffer, "this$0");
            this.this$0 = readableMapBuffer;
            this.bucketOffset = i;
        }

        private final void assertType(MapBuffer.DataType dataType) {
            MapBuffer.DataType type = getType();
            if (!(dataType == type)) {
                throw new IllegalStateException(("Expected " + dataType + " for key: " + getKey() + " found " + type + " instead.").toString());
            }
        }

        public int getKey() {
            return this.this$0.m409readUnsignedShortBwKQO78(this.bucketOffset) & UShort.MAX_VALUE;
        }

        public MapBuffer.DataType getType() {
            return MapBuffer.DataType.values()[this.this$0.m409readUnsignedShortBwKQO78(this.bucketOffset + 2) & UShort.MAX_VALUE];
        }

        public double getDoubleValue() {
            assertType(MapBuffer.DataType.DOUBLE);
            return this.this$0.readDoubleValue(this.bucketOffset + 4);
        }

        public int getIntValue() {
            assertType(MapBuffer.DataType.INT);
            return this.this$0.readIntValue(this.bucketOffset + 4);
        }

        public boolean getBooleanValue() {
            assertType(MapBuffer.DataType.BOOL);
            return this.this$0.readBooleanValue(this.bucketOffset + 4);
        }

        public String getStringValue() {
            assertType(MapBuffer.DataType.STRING);
            return this.this$0.readStringValue(this.bucketOffset + 4);
        }

        public MapBuffer getMapBufferValue() {
            assertType(MapBuffer.DataType.MAP);
            return this.this$0.readMapBufferValue(this.bucketOffset + 4);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/react/common/mapbuffer/ReadableMapBuffer$Companion;", "", "()V", "ALIGNMENT", "", "BUCKET_SIZE", "HEADER_SIZE", "TYPE_OFFSET", "VALUE_OFFSET", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ReadableMapBuffer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        MapBufferSoLoader.staticInit();
    }
}
