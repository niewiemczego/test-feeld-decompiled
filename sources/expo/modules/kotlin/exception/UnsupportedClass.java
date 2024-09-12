package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/exception/UnsupportedClass;", "Lexpo/modules/kotlin/exception/CodedException;", "clazz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CodedException.kt */
public final class UnsupportedClass extends CodedException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnsupportedClass(KClass<?> kClass) {
        super("Unsupported type: '" + kClass + "'", (Throwable) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(kClass, "clazz");
    }
}
