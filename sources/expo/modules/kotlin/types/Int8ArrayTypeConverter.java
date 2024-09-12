package expo.modules.kotlin.types;

import expo.modules.kotlin.jni.JavaScriptTypedArray;
import expo.modules.kotlin.typedarray.Int8Array;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lexpo/modules/kotlin/types/Int8ArrayTypeConverter;", "Lexpo/modules/kotlin/types/BaseTypeArrayConverter;", "Lexpo/modules/kotlin/typedarray/Int8Array;", "isOptional", "", "(Z)V", "wrapJavaScriptTypedArray", "value", "Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TypedArrayTypeConverter.kt */
public final class Int8ArrayTypeConverter extends BaseTypeArrayConverter<Int8Array> {
    public Int8ArrayTypeConverter(boolean z) {
        super(z);
    }

    public Int8Array wrapJavaScriptTypedArray(JavaScriptTypedArray javaScriptTypedArray) {
        Intrinsics.checkNotNullParameter(javaScriptTypedArray, "value");
        return new Int8Array(javaScriptTypedArray);
    }
}
