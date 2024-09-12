package expo.modules.kotlin.jni;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lexpo/modules/kotlin/jni/TypedArrayKind;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Int8Array", "Int16Array", "Int32Array", "Uint8Array", "Uint8ClampedArray", "Uint16Array", "Uint32Array", "Float32Array", "Float64Array", "BigInt64Array", "BigUint64Array", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: JavaScriptTypedArray.kt */
public enum TypedArrayKind {
    Int8Array(0, 1, (int) null),
    Int16Array(0, 1, (int) null),
    Int32Array(0, 1, (int) null),
    Uint8Array(0, 1, (int) null),
    Uint8ClampedArray(0, 1, (int) null),
    Uint16Array(0, 1, (int) null),
    Uint32Array(0, 1, (int) null),
    Float32Array(0, 1, (int) null),
    Float64Array(0, 1, (int) null),
    BigInt64Array(0, 1, (int) null),
    BigUint64Array(0, 1, (int) null);
    
    private final int value;

    private TypedArrayKind(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
