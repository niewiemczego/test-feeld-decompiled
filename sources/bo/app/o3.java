package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class o3 extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o3(String str, Throwable th) {
        super(str, th);
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(th, "innerException");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o3(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "message");
    }
}
