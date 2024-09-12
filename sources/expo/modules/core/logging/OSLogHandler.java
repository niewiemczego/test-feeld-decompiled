package expo.modules.core.logging;

import android.util.Log;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J'\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0010¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"Lexpo/modules/core/logging/OSLogHandler;", "Lexpo/modules/core/logging/LogHandler;", "category", "", "(Ljava/lang/String;)V", "log", "", "type", "Lexpo/modules/core/logging/LogType;", "message", "cause", "", "log$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OSLogHandler.kt */
public final class OSLogHandler extends LogHandler {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OSLogHandler(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "category");
    }

    public void log$expo_modules_core_release(LogType logType, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(logType, "type");
        Intrinsics.checkNotNullParameter(str, "message");
        if (!OSLogHandlerKt.isAndroid) {
            String type = logType.getType();
            System.out.println("[" + type + "] " + getCategory() + "\t" + str);
            if (th != null) {
                String localizedMessage = th.getLocalizedMessage();
                System.out.println(localizedMessage + "\n" + ExceptionsKt.stackTraceToString(th));
                return;
            }
            return;
        }
        int oSLogType = LogType.Companion.toOSLogType(logType);
        if (oSLogType == 3) {
            Log.d(getCategory(), str, th);
        } else if (oSLogType == 4) {
            Log.i(getCategory(), str, th);
        } else if (oSLogType == 5) {
            Log.w(getCategory(), str, th);
        } else if (oSLogType == 6) {
            Log.e(getCategory(), str, th);
        } else if (oSLogType == 7) {
            Log.e(getCategory(), str, th);
        }
    }
}
