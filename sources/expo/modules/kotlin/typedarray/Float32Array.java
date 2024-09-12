package expo.modules.kotlin.typedarray;

import expo.modules.kotlin.jni.JavaScriptTypedArray;
import expo.modules.kotlin.jni.TypedArrayKind;
import expo.modules.kotlin.typedarray.GenericTypedArray;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u0015J!\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0001J\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\bH\u0001J\u0011\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0001J\u0011\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\bH\u0001J\u0011\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\bH\u0001J\u0011\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\bH\u0001J\u0011\u0010%\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\bH\u0001J\u0019\u0010&\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0003H\u0002J\t\u0010(\u001a\u00020)H\u0001J!\u0010*\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0001J\u0019\u0010+\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u001dH\u0001J\u0019\u0010,\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0001J\u0019\u0010-\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010'\u001a\u00020 H\u0001J\u0019\u0010.\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010'\u001a\u00020\"H\u0001J\u0019\u0010/\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010'\u001a\u00020$H\u0001J\u0019\u00100\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0003H\u0001R\u0012\u0010\u0007\u001a\u00020\bX\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\bX\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0012\u0010\r\u001a\u00020\u000eX\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\bX\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lexpo/modules/kotlin/typedarray/Float32Array;", "Lexpo/modules/kotlin/typedarray/TypedArray;", "Lexpo/modules/kotlin/typedarray/GenericTypedArray;", "", "rawArray", "Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "(Lexpo/modules/kotlin/jni/JavaScriptTypedArray;)V", "byteLength", "", "getByteLength", "()I", "byteOffset", "getByteOffset", "kind", "Lexpo/modules/kotlin/jni/TypedArrayKind;", "getKind", "()Lexpo/modules/kotlin/jni/TypedArrayKind;", "length", "getLength", "get", "index", "(I)Ljava/lang/Float;", "read", "", "buffer", "", "position", "size", "read2Byte", "", "read4Byte", "read8Byte", "", "readByte", "", "readDouble", "", "readFloat", "set", "value", "toDirectBuffer", "Ljava/nio/ByteBuffer;", "write", "write2Byte", "write4Byte", "write8Byte", "writeByte", "writeDouble", "writeFloat", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConcreteTypedArrays.kt */
public final class Float32Array implements TypedArray, GenericTypedArray<Float> {
    private final JavaScriptTypedArray rawArray;

    public int getByteLength() {
        return this.rawArray.getByteLength();
    }

    public int getByteOffset() {
        return this.rawArray.getByteOffset();
    }

    public TypedArrayKind getKind() {
        return this.rawArray.getKind();
    }

    public int getLength() {
        return this.rawArray.getLength();
    }

    public void read(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "buffer");
        this.rawArray.read(bArr, i, i2);
    }

    public short read2Byte(int i) {
        return this.rawArray.read2Byte(i);
    }

    public int read4Byte(int i) {
        return this.rawArray.read4Byte(i);
    }

    public long read8Byte(int i) {
        return this.rawArray.read8Byte(i);
    }

    public byte readByte(int i) {
        return this.rawArray.readByte(i);
    }

    public double readDouble(int i) {
        return this.rawArray.readDouble(i);
    }

    public float readFloat(int i) {
        return this.rawArray.readFloat(i);
    }

    public ByteBuffer toDirectBuffer() {
        return this.rawArray.toDirectBuffer();
    }

    public void write(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "buffer");
        this.rawArray.write(bArr, i, i2);
    }

    public void write2Byte(int i, short s) {
        this.rawArray.write2Byte(i, s);
    }

    public void write4Byte(int i, int i2) {
        this.rawArray.write4Byte(i, i2);
    }

    public void write8Byte(int i, long j) {
        this.rawArray.write8Byte(i, j);
    }

    public void writeByte(int i, byte b) {
        this.rawArray.writeByte(i, b);
    }

    public void writeDouble(int i, double d) {
        this.rawArray.writeDouble(i, d);
    }

    public void writeFloat(int i, float f) {
        this.rawArray.writeFloat(i, f);
    }

    public Float32Array(JavaScriptTypedArray javaScriptTypedArray) {
        Intrinsics.checkNotNullParameter(javaScriptTypedArray, "rawArray");
        this.rawArray = javaScriptTypedArray;
    }

    public Iterator<Float> iterator() {
        return GenericTypedArray.DefaultImpls.iterator(this);
    }

    public /* bridge */ /* synthetic */ void set(int i, Object obj) {
        set(i, ((Number) obj).floatValue());
    }

    public Float get(int i) {
        TypedArray typedArray = this;
        if (i >= 0 && i < typedArray.getLength()) {
            return Float.valueOf(readFloat(i * 4));
        }
        throw new IndexOutOfBoundsException();
    }

    public void set(int i, float f) {
        TypedArray typedArray = this;
        if (i < 0 || i >= typedArray.getLength()) {
            throw new IndexOutOfBoundsException();
        }
        writeFloat(i * 4, f);
    }
}
