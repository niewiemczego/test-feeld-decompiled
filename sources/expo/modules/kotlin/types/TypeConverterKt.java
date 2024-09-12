package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0006\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00020\tH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000b"}, d2 = {"createTrivialTypeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "T", "", "isOptional", "", "cppRequireType", "Lexpo/modules/kotlin/jni/ExpectedType;", "dynamicFallback", "Lkotlin/Function1;", "Lcom/facebook/react/bridge/Dynamic;", "expo-modules-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TypeConverter.kt */
public final class TypeConverterKt {
    public static /* synthetic */ TypeConverter createTrivialTypeConverter$default(boolean z, ExpectedType expectedType, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            Intrinsics.needClassReification();
            function1 = TypeConverterKt$createTrivialTypeConverter$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(expectedType, "cppRequireType");
        Intrinsics.checkNotNullParameter(function1, "dynamicFallback");
        Intrinsics.needClassReification();
        return new TypeConverterKt$createTrivialTypeConverter$2(z, function1, expectedType);
    }

    public static final /* synthetic */ <T> TypeConverter<T> createTrivialTypeConverter(boolean z, ExpectedType expectedType, Function1<? super Dynamic, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(expectedType, "cppRequireType");
        Intrinsics.checkNotNullParameter(function1, "dynamicFallback");
        Intrinsics.needClassReification();
        return new TypeConverterKt$createTrivialTypeConverter$2(z, function1, expectedType);
    }
}
