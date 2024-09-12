package expo.modules.kotlin.exception;

import com.facebook.react.util.JSStackTrace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/exception/FunctionCallException;", "Lexpo/modules/kotlin/exception/DecoratedException;", "methodName", "", "moduleName", "cause", "Lexpo/modules/kotlin/exception/CodedException;", "(Ljava/lang/String;Ljava/lang/String;Lexpo/modules/kotlin/exception/CodedException;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CodedException.kt */
public final class FunctionCallException extends DecoratedException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionCallException(String str, String str2, CodedException codedException) {
        super("Call to function '" + str2 + "." + str + "' has been rejected.", codedException);
        Intrinsics.checkNotNullParameter(str, JSStackTrace.METHOD_NAME_KEY);
        Intrinsics.checkNotNullParameter(str2, "moduleName");
        Intrinsics.checkNotNullParameter(codedException, "cause");
    }
}
