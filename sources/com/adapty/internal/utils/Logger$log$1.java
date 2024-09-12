package com.adapty.internal.utils;

import com.adapty.utils.AdaptyLogLevel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 8, 0}, xi = 176)
/* compiled from: Logger.kt */
public final class Logger$log$1 implements Runnable {
    final /* synthetic */ String $message;
    final /* synthetic */ AdaptyLogLevel $messageLogLevel;

    public Logger$log$1(AdaptyLogLevel adaptyLogLevel, String str) {
        this.$messageLogLevel = adaptyLogLevel;
        this.$message = str;
    }

    public final void run() {
        Logger.logHandler.onLogMessageReceived(this.$messageLogLevel, this.$message);
    }
}
