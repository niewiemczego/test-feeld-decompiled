package expo.modules.kotlin.typedarray;

import expo.modules.kotlin.jni.TypedArrayKind;
import java.nio.ByteBuffer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020 H&J \u0010!\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H&J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0015H&J\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H&J\u0018\u0010%\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0018H&J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u001aH&J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u001cH&J\u0018\u0010(\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u001eH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005¨\u0006)"}, d2 = {"Lexpo/modules/kotlin/typedarray/TypedArray;", "", "byteLength", "", "getByteLength", "()I", "byteOffset", "getByteOffset", "kind", "Lexpo/modules/kotlin/jni/TypedArrayKind;", "getKind", "()Lexpo/modules/kotlin/jni/TypedArrayKind;", "length", "getLength", "read", "", "buffer", "", "position", "size", "read2Byte", "", "read4Byte", "read8Byte", "", "readByte", "", "readDouble", "", "readFloat", "", "toDirectBuffer", "Ljava/nio/ByteBuffer;", "write", "write2Byte", "value", "write4Byte", "write8Byte", "writeByte", "writeDouble", "writeFloat", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TypedArray.kt */
public interface TypedArray {
    int getByteLength();

    int getByteOffset();

    TypedArrayKind getKind();

    int getLength();

    void read(byte[] bArr, int i, int i2);

    short read2Byte(int i);

    int read4Byte(int i);

    long read8Byte(int i);

    byte readByte(int i);

    double readDouble(int i);

    float readFloat(int i);

    ByteBuffer toDirectBuffer();

    void write(byte[] bArr, int i, int i2);

    void write2Byte(int i, short s);

    void write4Byte(int i, int i2);

    void write8Byte(int i, long j);

    void writeByte(int i, byte b);

    void writeDouble(int i, double d);

    void writeFloat(int i, float f);
}
