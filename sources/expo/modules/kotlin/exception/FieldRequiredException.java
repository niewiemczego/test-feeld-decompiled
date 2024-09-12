package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/exception/FieldRequiredException;", "Lexpo/modules/kotlin/exception/CodedException;", "property", "Lkotlin/reflect/KProperty1;", "(Lkotlin/reflect/KProperty1;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CodedException.kt */
public final class FieldRequiredException extends CodedException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FieldRequiredException(KProperty1<?, ?> kProperty1) {
        super("Value for field '" + kProperty1 + "' is required, got nil", (Throwable) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(kProperty1, "property");
    }
}
