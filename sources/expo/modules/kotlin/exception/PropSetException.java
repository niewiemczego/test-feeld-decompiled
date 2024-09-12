package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lexpo/modules/kotlin/exception/PropSetException;", "Lexpo/modules/kotlin/exception/DecoratedException;", "propName", "", "viewType", "Lkotlin/reflect/KClass;", "cause", "Lexpo/modules/kotlin/exception/CodedException;", "(Ljava/lang/String;Lkotlin/reflect/KClass;Lexpo/modules/kotlin/exception/CodedException;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CodedException.kt */
public final class PropSetException extends DecoratedException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PropSetException(String str, KClass<?> kClass, CodedException codedException) {
        super("Cannot set prop '" + str + "' on view '" + kClass + "'", codedException);
        Intrinsics.checkNotNullParameter(str, "propName");
        Intrinsics.checkNotNullParameter(kClass, "viewType");
        Intrinsics.checkNotNullParameter(codedException, "cause");
    }
}
