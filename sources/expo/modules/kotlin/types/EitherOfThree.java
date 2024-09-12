package expo.modules.kotlin.types;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\u00028\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\nH\u0007¢\u0006\u0002\b\u000fJ\u000b\u0010\u0010\u001a\u00028\u0002¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lexpo/modules/kotlin/types/EitherOfThree;", "FirstType", "", "SecondType", "ThirdType", "Lexpo/modules/kotlin/types/Either;", "value", "(Ljava/lang/Object;)V", "get", "type", "Lkotlin/reflect/KClass;", "getThirdType", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "is", "", "isThirdType", "third", "()Ljava/lang/Object;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Either.kt */
public class EitherOfThree<FirstType, SecondType, ThirdType> extends Either<FirstType, SecondType> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EitherOfThree(Object obj) {
        super(obj);
        Intrinsics.checkNotNullParameter(obj, "value");
    }

    public final boolean isThirdType(KClass<ThirdType> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        return kClass.isInstance(getValue());
    }

    public final ThirdType getThirdType(KClass<ThirdType> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        ThirdType value = getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type ThirdType of expo.modules.kotlin.types.EitherOfThree");
        return value;
    }

    public final ThirdType third() {
        ThirdType value = getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type ThirdType of expo.modules.kotlin.types.EitherOfThree");
        return value;
    }
}
