package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class w5 extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w5(String str, Throwable th) {
        super(str, th);
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(th, "innerException");
    }
}
