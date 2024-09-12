package expo.modules.kotlin.types;

import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JavaScriptTypedArray;
import expo.modules.kotlin.typedarray.TypedArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0015\u0010\u000e\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u000fH&¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lexpo/modules/kotlin/types/BaseTypeArrayConverter;", "T", "Lexpo/modules/kotlin/typedarray/TypedArray;", "Lexpo/modules/kotlin/types/TypeConverter;", "isOptional", "", "(Z)V", "convertNonOptional", "value", "", "(Ljava/lang/Object;)Lexpo/modules/kotlin/typedarray/TypedArray;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "wrapJavaScriptTypedArray", "Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "(Lexpo/modules/kotlin/jni/JavaScriptTypedArray;)Lexpo/modules/kotlin/typedarray/TypedArray;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TypedArrayTypeConverter.kt */
public abstract class BaseTypeArrayConverter<T extends TypedArray> extends TypeConverter<T> {
    public boolean isTrivial() {
        return false;
    }

    public abstract T wrapJavaScriptTypedArray(JavaScriptTypedArray javaScriptTypedArray);

    public BaseTypeArrayConverter(boolean z) {
        super(z);
    }

    public T convertNonOptional(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        return wrapJavaScriptTypedArray((JavaScriptTypedArray) obj);
    }

    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.TYPED_ARRAY);
    }
}
