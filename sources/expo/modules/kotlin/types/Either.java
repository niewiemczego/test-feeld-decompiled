package expo.modules.kotlin.types;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u000b\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\u001d\u0010\u000b\u001a\u00028\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u000b\u001a\u00028\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0007¢\u0006\u0002\b\u0013J\u001b\u0010\u0011\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0007¢\u0006\u0002\b\u0014J\u000b\u0010\u0015\u001a\u00028\u0001¢\u0006\u0002\u0010\tR\u001c\u0010\u0004\u001a\u00020\u00028\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lexpo/modules/kotlin/types/Either;", "FirstType", "", "SecondType", "value", "(Ljava/lang/Object;)V", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "first", "get", "type", "Lkotlin/reflect/KClass;", "getFirstType", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getSecondType", "is", "", "isFirstType", "isSecondType", "second", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Either.kt */
public class Either<FirstType, SecondType> {
    private final Object value;

    public static /* synthetic */ void getValue$annotations() {
    }

    public Either(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        this.value = obj;
    }

    public final Object getValue() {
        return this.value;
    }

    public final boolean isFirstType(KClass<FirstType> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        return kClass.isInstance(this.value);
    }

    public final boolean isSecondType(KClass<SecondType> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        return kClass.isInstance(this.value);
    }

    public final FirstType getFirstType(KClass<FirstType> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        FirstType firsttype = this.value;
        Intrinsics.checkNotNull(firsttype, "null cannot be cast to non-null type FirstType of expo.modules.kotlin.types.Either");
        return firsttype;
    }

    public final SecondType getSecondType(KClass<SecondType> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        SecondType secondtype = this.value;
        Intrinsics.checkNotNull(secondtype, "null cannot be cast to non-null type SecondType of expo.modules.kotlin.types.Either");
        return secondtype;
    }

    public final FirstType first() {
        FirstType firsttype = this.value;
        Intrinsics.checkNotNull(firsttype, "null cannot be cast to non-null type FirstType of expo.modules.kotlin.types.Either");
        return firsttype;
    }

    public final SecondType second() {
        SecondType secondtype = this.value;
        Intrinsics.checkNotNull(secondtype, "null cannot be cast to non-null type SecondType of expo.modules.kotlin.types.Either");
        return secondtype;
    }
}
