package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"expo/modules/kotlin/types/TypeConverterKt$createTrivialTypeConverter$2", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "convertFromAny", "value", "", "(Ljava/lang/Object;)Ljava/lang/Object;", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "(Lcom/facebook/react/bridge/Dynamic;)Ljava/lang/Object;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 176)
/* compiled from: TypeConverter.kt */
public final class TypeConverterKt$createTrivialTypeConverter$2 extends DynamicAwareTypeConverters<T> {
    final /* synthetic */ ExpectedType $cppRequireType;
    final /* synthetic */ Function1<Dynamic, T> $dynamicFallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypeConverterKt$createTrivialTypeConverter$2(boolean z, Function1<? super Dynamic, ? extends T> function1, ExpectedType expectedType) {
        super(z);
        this.$dynamicFallback = function1;
        this.$cppRequireType = expectedType;
    }

    public T convertFromDynamic(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, "value");
        return this.$dynamicFallback.invoke(dynamic);
    }

    public ExpectedType getCppRequiredTypes() {
        return this.$cppRequireType;
    }

    public T convertFromAny(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        Object obj2 = obj;
        return obj;
    }
}
