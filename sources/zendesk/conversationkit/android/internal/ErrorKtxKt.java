package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"isUnauthorizedException", "", "", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ErrorKtx.kt */
public final class ErrorKtxKt {
    public static final boolean isUnauthorizedException(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        return (th instanceof HttpException) && ((HttpException) th).code() == 401;
    }
}
