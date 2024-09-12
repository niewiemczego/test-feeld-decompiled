package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/exception/RecordCastException;", "Lexpo/modules/kotlin/exception/DecoratedException;", "recordType", "Lkotlin/reflect/KType;", "cause", "Lexpo/modules/kotlin/exception/CodedException;", "(Lkotlin/reflect/KType;Lexpo/modules/kotlin/exception/CodedException;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CodedException.kt */
public final class RecordCastException extends DecoratedException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordCastException(KType kType, CodedException codedException) {
        super("Cannot create a record of the type: '" + kType + "'.", codedException);
        Intrinsics.checkNotNullParameter(kType, "recordType");
        Intrinsics.checkNotNullParameter(codedException, "cause");
    }
}
