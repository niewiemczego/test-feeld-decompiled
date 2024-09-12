package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import expo.modules.kotlin.typedarray.TypedArray;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0017\u001a\u00020\u0007H J!\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H J\u0011\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0007H J\u0011\u0010 \u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H J\u0011\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0007H J\u0011\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u0007H J\u0011\u0010%\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u0007H J\u0011\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u0007H J\t\u0010)\u001a\u00020*H J!\u0010+\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H J\u0019\u0010,\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u001fH J\u0019\u0010.\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H J\u0019\u0010/\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\"H J\u0019\u00100\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010-\u001a\u00020$H J\u0019\u00101\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010-\u001a\u00020&H J\u0019\u00102\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010-\u001a\u00020(H R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\u00078VX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00078VX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0015\u0010\t¨\u00063"}, d2 = {"Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "Lexpo/modules/kotlin/typedarray/TypedArray;", "hybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "byteLength", "", "getByteLength", "()I", "byteLength$delegate", "Lkotlin/Lazy;", "byteOffset", "getByteOffset", "byteOffset$delegate", "kind", "Lexpo/modules/kotlin/jni/TypedArrayKind;", "getKind", "()Lexpo/modules/kotlin/jni/TypedArrayKind;", "kind$delegate", "length", "getLength", "length$delegate", "getRawKind", "read", "", "buffer", "", "position", "size", "read2Byte", "", "read4Byte", "read8Byte", "", "readByte", "", "readDouble", "", "readFloat", "", "toDirectBuffer", "Ljava/nio/ByteBuffer;", "write", "write2Byte", "value", "write4Byte", "write8Byte", "writeByte", "writeDouble", "writeFloat", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: JavaScriptTypedArray.kt */
public final class JavaScriptTypedArray extends JavaScriptObject implements TypedArray {
    private final Lazy byteLength$delegate = LazyKt.lazy(new JavaScriptTypedArray$byteLength$2(this));
    private final Lazy byteOffset$delegate = LazyKt.lazy(new JavaScriptTypedArray$byteOffset$2(this));
    private final Lazy kind$delegate = LazyKt.lazy(new JavaScriptTypedArray$kind$2(this));
    private final Lazy length$delegate = LazyKt.lazy(new JavaScriptTypedArray$length$2(this));

    /* access modifiers changed from: private */
    public final native int getRawKind();

    public native void read(byte[] bArr, int i, int i2);

    public native short read2Byte(int i);

    public native int read4Byte(int i);

    public native long read8Byte(int i);

    public native byte readByte(int i);

    public native double readDouble(int i);

    public native float readFloat(int i);

    public native ByteBuffer toDirectBuffer();

    public native void write(byte[] bArr, int i, int i2);

    public native void write2Byte(int i, short s);

    public native void write4Byte(int i, int i2);

    public native void write8Byte(int i, long j);

    public native void writeByte(int i, byte b);

    public native void writeDouble(int i, double d);

    public native void writeFloat(int i, float f);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JavaScriptTypedArray(HybridData hybridData) {
        super(hybridData);
        Intrinsics.checkNotNullParameter(hybridData, "hybridData");
    }

    public TypedArrayKind getKind() {
        return (TypedArrayKind) this.kind$delegate.getValue();
    }

    public int getLength() {
        return ((Number) this.length$delegate.getValue()).intValue();
    }

    public int getByteLength() {
        return ((Number) this.byteLength$delegate.getValue()).intValue();
    }

    public int getByteOffset() {
        return ((Number) this.byteOffset$delegate.getValue()).intValue();
    }
}
