package expo.modules.kotlin;

import android.content.Context;
import expo.modules.core.logging.Logger;
import expo.modules.core.logging.LoggerOptions;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"logger", "Lexpo/modules/core/logging/Logger;", "getLogger", "()Lexpo/modules/core/logging/Logger;", "expo-modules-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: CoreLogger.kt */
public final class CoreLoggerKt {
    private static final Logger logger = new Logger("ExpoModulesCore", (Context) null, LoggerOptions.Companion.getLogToOS());

    public static final Logger getLogger() {
        return logger;
    }
}
