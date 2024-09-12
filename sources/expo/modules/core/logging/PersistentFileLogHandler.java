package expo.modules.core.logging;

import android.content.Context;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J'\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0010¢\u0006\u0002\b\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/core/logging/PersistentFileLogHandler;", "Lexpo/modules/core/logging/LogHandler;", "category", "", "context", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;)V", "persistentFileLog", "Lexpo/modules/core/logging/PersistentFileLog;", "log", "", "type", "Lexpo/modules/core/logging/LogType;", "message", "cause", "", "log$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PersistentFileLogHandler.kt */
public final class PersistentFileLogHandler extends LogHandler {
    private final PersistentFileLog persistentFileLog;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersistentFileLogHandler(String str, Context context) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "category");
        Intrinsics.checkNotNullParameter(context, "context");
        this.persistentFileLog = new PersistentFileLog(str, context);
    }

    public void log$expo_modules_core_release(LogType logType, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(logType, "type");
        Intrinsics.checkNotNullParameter(str, "message");
        PersistentFileLog.appendEntry$default(this.persistentFileLog, str, (Function1) null, 2, (Object) null);
        if (th != null) {
            PersistentFileLog persistentFileLog2 = this.persistentFileLog;
            String localizedMessage = th.getLocalizedMessage();
            PersistentFileLog.appendEntry$default(persistentFileLog2, localizedMessage + "\n" + ExceptionsKt.stackTraceToString(th), (Function1) null, 2, (Object) null);
        }
    }
}
