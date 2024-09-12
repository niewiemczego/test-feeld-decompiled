package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lexpo/modules/kotlin/exception/UnexpectedException;", "Lexpo/modules/kotlin/exception/CodedException;", "throwable", "", "(Ljava/lang/Throwable;)V", "message", "", "(Ljava/lang/String;)V", "cause", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CodedException.kt */
public final class UnexpectedException extends CodedException {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnexpectedException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    public UnexpectedException(String str, Throwable th) {
        super(str, th);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UnexpectedException(Throwable th) {
        this(th.toString(), th);
        Intrinsics.checkNotNullParameter(th, "throwable");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UnexpectedException(String str) {
        this(str, (Throwable) null);
        Intrinsics.checkNotNullParameter(str, "message");
    }
}
