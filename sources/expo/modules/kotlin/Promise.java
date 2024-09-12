package expo.modules.kotlin;

import expo.modules.kotlin.exception.CodedException;
import io.sentry.SentryEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001H&¨\u0006\r"}, d2 = {"Lexpo/modules/kotlin/Promise;", "", "reject", "", "exception", "Lexpo/modules/kotlin/exception/CodedException;", "code", "", "message", "cause", "", "resolve", "value", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Promise.kt */
public interface Promise {
    void reject(CodedException codedException);

    void reject(String str, String str2, Throwable th);

    void resolve(Object obj);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Promise.kt */
    public static final class DefaultImpls {
        public static void reject(Promise promise, CodedException codedException) {
            Intrinsics.checkNotNullParameter(codedException, SentryEvent.JsonKeys.EXCEPTION);
            promise.reject(codedException.getCode(), codedException.getLocalizedMessage(), codedException.getCause());
        }
    }
}
