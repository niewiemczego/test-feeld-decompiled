package com.facebook.react.common.mapbuffer;

import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.common.mapbuffer.MapBuffer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\n\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0003J\u0010\u0010\u0017\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0013\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0003¢\u0006\u0002\u0010 J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\"H\u0002J\u0016\u0010#\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0001J\u0016\u0010#\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000bJ\u0016\u0010#\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0012J\u0016\u0010#\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004J\u0016\u0010#\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u001bJ\u0018\u0010%\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\tH\u0002J(\u0010&\u001a\u0002H'\"\u0006\b\u0000\u0010'\u0018\u00012\u0006\u0010\f\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\tH\b¢\u0006\u0002\u0010(J\u0014\u0010)\u001a\u00020\u001d*\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/facebook/react/common/mapbuffer/WritableMapBuffer;", "Lcom/facebook/react/common/mapbuffer/MapBuffer;", "()V", "count", "", "getCount", "()I", "values", "Landroid/util/SparseArray;", "", "contains", "", "key", "entryAt", "Lcom/facebook/react/common/mapbuffer/MapBuffer$Entry;", "offset", "getBoolean", "getDouble", "", "getInt", "getKeyOffset", "getKeys", "", "getMapBuffer", "getMapBufferList", "", "getString", "", "getType", "Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "getValues", "", "()[Ljava/lang/Object;", "iterator", "", "put", "value", "putInternal", "verifyValue", "T", "(ILjava/lang/Object;)Ljava/lang/Object;", "dataType", "Companion", "MapBufferEntry", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WritableMapBuffer.kt */
public final class WritableMapBuffer implements MapBuffer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final SparseArray<Object> values = new SparseArray<>();

    public final WritableMapBuffer put(int i, boolean z) {
        return putInternal(i, Boolean.valueOf(z));
    }

    public final WritableMapBuffer put(int i, int i2) {
        return putInternal(i, Integer.valueOf(i2));
    }

    public final WritableMapBuffer put(int i, double d) {
        return putInternal(i, Double.valueOf(d));
    }

    public final WritableMapBuffer put(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return putInternal(i, str);
    }

    public final WritableMapBuffer put(int i, MapBuffer mapBuffer) {
        Intrinsics.checkNotNullParameter(mapBuffer, "value");
        return putInternal(i, mapBuffer);
    }

    private final WritableMapBuffer putInternal(int i, Object obj) {
        IntRange kEY_RANGE$ReactAndroid_release = MapBuffer.Companion.getKEY_RANGE$ReactAndroid_release();
        int first = kEY_RANGE$ReactAndroid_release.getFirst();
        boolean z = false;
        if (i <= kEY_RANGE$ReactAndroid_release.getLast() && first <= i) {
            z = true;
        }
        if (z) {
            this.values.put(i, obj);
            return this;
        }
        throw new IllegalArgumentException("Only integers in [0;65535] range are allowed for keys.".toString());
    }

    public int getCount() {
        return this.values.size();
    }

    public boolean contains(int i) {
        return this.values.get(i) != null;
    }

    public int getKeyOffset(int i) {
        return this.values.indexOfKey(i);
    }

    public MapBuffer.Entry entryAt(int i) {
        return new MapBufferEntry(this, i);
    }

    public MapBuffer.DataType getType(int i) {
        Object obj = this.values.get(i);
        if (obj != null) {
            Intrinsics.checkNotNullExpressionValue(obj, "value");
            return dataType(obj, i);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Key not found: ", Integer.valueOf(i)).toString());
    }

    public boolean getBoolean(int i) {
        Object obj = this.values.get(i);
        if (!(obj != null)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Key not found: ", Integer.valueOf(i)).toString());
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        } else {
            throw new IllegalStateException(("Expected " + Boolean.class + " for key: " + i + ", found " + obj.getClass() + " instead.").toString());
        }
    }

    public int getInt(int i) {
        Object obj = this.values.get(i);
        if (!(obj != null)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Key not found: ", Integer.valueOf(i)).toString());
        } else if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        } else {
            throw new IllegalStateException(("Expected " + Integer.class + " for key: " + i + ", found " + obj.getClass() + " instead.").toString());
        }
    }

    public double getDouble(int i) {
        Object obj = this.values.get(i);
        if (!(obj != null)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Key not found: ", Integer.valueOf(i)).toString());
        } else if (obj instanceof Double) {
            return ((Number) obj).doubleValue();
        } else {
            throw new IllegalStateException(("Expected " + Double.class + " for key: " + i + ", found " + obj.getClass() + " instead.").toString());
        }
    }

    public String getString(int i) {
        Object obj = this.values.get(i);
        if (!(obj != null)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Key not found: ", Integer.valueOf(i)).toString());
        } else if (obj instanceof String) {
            return (String) obj;
        } else {
            throw new IllegalStateException(("Expected " + String.class + " for key: " + i + ", found " + obj.getClass() + " instead.").toString());
        }
    }

    public MapBuffer getMapBuffer(int i) {
        Object obj = this.values.get(i);
        if (!(obj != null)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Key not found: ", Integer.valueOf(i)).toString());
        } else if (obj instanceof MapBuffer) {
            return (MapBuffer) obj;
        } else {
            throw new IllegalStateException(("Expected " + MapBuffer.class + " for key: " + i + ", found " + obj.getClass() + " instead.").toString());
        }
    }

    public List<MapBuffer> getMapBufferList(int i) {
        Object obj = this.values.get(i);
        if (!(obj != null)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Key not found: ", Integer.valueOf(i)).toString());
        } else if (obj instanceof List) {
            return (List) obj;
        } else {
            throw new IllegalStateException(("Expected " + List.class + " for key: " + i + ", found " + obj.getClass() + " instead.").toString());
        }
    }

    private final /* synthetic */ <T> T verifyValue(int i, Object obj) {
        if (obj != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (obj instanceof Object) {
                return obj;
            }
            StringBuilder append = new StringBuilder().append("Expected ");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            throw new IllegalStateException(append.append(Object.class).append(" for key: ").append(i).append(", found ").append(obj.getClass()).append(" instead.").toString().toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Key not found: ", Integer.valueOf(i)).toString());
    }

    /* access modifiers changed from: private */
    public final MapBuffer.DataType dataType(Object obj, int i) {
        if (obj instanceof Boolean) {
            return MapBuffer.DataType.BOOL;
        }
        if (obj instanceof Integer) {
            return MapBuffer.DataType.INT;
        }
        if (obj instanceof Double) {
            return MapBuffer.DataType.DOUBLE;
        }
        if (obj instanceof String) {
            return MapBuffer.DataType.STRING;
        }
        if (obj instanceof MapBuffer) {
            return MapBuffer.DataType.MAP;
        }
        throw new IllegalStateException("Key " + i + " has value of unknown type: " + obj.getClass());
    }

    public Iterator<MapBuffer.Entry> iterator() {
        return new WritableMapBuffer$iterator$1(this);
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/facebook/react/common/mapbuffer/WritableMapBuffer$MapBufferEntry;", "Lcom/facebook/react/common/mapbuffer/MapBuffer$Entry;", "index", "", "(Lcom/facebook/react/common/mapbuffer/WritableMapBuffer;I)V", "booleanValue", "", "getBooleanValue", "()Z", "doubleValue", "", "getDoubleValue", "()D", "intValue", "getIntValue", "()I", "key", "getKey", "mapBufferValue", "Lcom/facebook/react/common/mapbuffer/MapBuffer;", "getMapBufferValue", "()Lcom/facebook/react/common/mapbuffer/MapBuffer;", "stringValue", "", "getStringValue", "()Ljava/lang/String;", "type", "Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "getType", "()Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WritableMapBuffer.kt */
    private final class MapBufferEntry implements MapBuffer.Entry {
        private final int index;
        private final int key;
        final /* synthetic */ WritableMapBuffer this$0;
        private final MapBuffer.DataType type;

        public MapBufferEntry(WritableMapBuffer writableMapBuffer, int i) {
            Intrinsics.checkNotNullParameter(writableMapBuffer, "this$0");
            this.this$0 = writableMapBuffer;
            this.index = i;
            this.key = writableMapBuffer.values.keyAt(i);
            Object valueAt = writableMapBuffer.values.valueAt(i);
            Intrinsics.checkNotNullExpressionValue(valueAt, "values.valueAt(index)");
            this.type = writableMapBuffer.dataType(valueAt, getKey());
        }

        public int getKey() {
            return this.key;
        }

        public MapBuffer.DataType getType() {
            return this.type;
        }

        public boolean getBooleanValue() {
            int key2 = getKey();
            Object valueAt = this.this$0.values.valueAt(this.index);
            if (!(valueAt != null)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Key not found: ", Integer.valueOf(key2)).toString());
            } else if (valueAt instanceof Boolean) {
                return ((Boolean) valueAt).booleanValue();
            } else {
                throw new IllegalStateException(("Expected " + Boolean.class + " for key: " + key2 + ", found " + valueAt.getClass() + " instead.").toString());
            }
        }

        public int getIntValue() {
            int key2 = getKey();
            Object valueAt = this.this$0.values.valueAt(this.index);
            if (!(valueAt != null)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Key not found: ", Integer.valueOf(key2)).toString());
            } else if (valueAt instanceof Integer) {
                return ((Number) valueAt).intValue();
            } else {
                throw new IllegalStateException(("Expected " + Integer.class + " for key: " + key2 + ", found " + valueAt.getClass() + " instead.").toString());
            }
        }

        public double getDoubleValue() {
            int key2 = getKey();
            Object valueAt = this.this$0.values.valueAt(this.index);
            if (!(valueAt != null)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Key not found: ", Integer.valueOf(key2)).toString());
            } else if (valueAt instanceof Double) {
                return ((Number) valueAt).doubleValue();
            } else {
                throw new IllegalStateException(("Expected " + Double.class + " for key: " + key2 + ", found " + valueAt.getClass() + " instead.").toString());
            }
        }

        public String getStringValue() {
            int key2 = getKey();
            Object valueAt = this.this$0.values.valueAt(this.index);
            if (!(valueAt != null)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Key not found: ", Integer.valueOf(key2)).toString());
            } else if (valueAt instanceof String) {
                return (String) valueAt;
            } else {
                throw new IllegalStateException(("Expected " + String.class + " for key: " + key2 + ", found " + valueAt.getClass() + " instead.").toString());
            }
        }

        public MapBuffer getMapBufferValue() {
            int key2 = getKey();
            Object valueAt = this.this$0.values.valueAt(this.index);
            if (!(valueAt != null)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Key not found: ", Integer.valueOf(key2)).toString());
            } else if (valueAt instanceof MapBuffer) {
                return (MapBuffer) valueAt;
            } else {
                throw new IllegalStateException(("Expected " + MapBuffer.class + " for key: " + key2 + ", found " + valueAt.getClass() + " instead.").toString());
            }
        }
    }

    private final int[] getKeys() {
        int size = this.values.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.values.keyAt(i);
        }
        return iArr;
    }

    private final Object[] getValues() {
        int size = this.values.size();
        Object[] objArr = new Object[size];
        for (int i = 0; i < size; i++) {
            Object valueAt = this.values.valueAt(i);
            Intrinsics.checkNotNullExpressionValue(valueAt, "values.valueAt(it)");
            objArr[i] = valueAt;
        }
        return objArr;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/facebook/react/common/mapbuffer/WritableMapBuffer$Companion;", "", "()V", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WritableMapBuffer.kt */
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
