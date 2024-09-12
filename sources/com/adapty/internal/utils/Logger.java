package com.adapty.internal.utils;

import com.adapty.utils.AdaptyLogHandler;
import com.adapty.utils.AdaptyLogLevel;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0017"}, d2 = {"Lcom/adapty/internal/utils/Logger;", "", "()V", "logExecutor", "Ljava/util/concurrent/ExecutorService;", "getLogExecutor", "()Ljava/util/concurrent/ExecutorService;", "logExecutor$delegate", "Lkotlin/Lazy;", "logHandler", "Lcom/adapty/utils/AdaptyLogHandler;", "logLevel", "Lcom/adapty/utils/AdaptyLogLevel;", "canLog", "", "messageLogLevelValue", "", "log", "", "messageLogLevel", "msg", "Lkotlin/Function0;", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Logger.kt */
public final class Logger {
    public static final Logger INSTANCE = new Logger();
    private static final Lazy logExecutor$delegate = LazyKt.lazy(Logger$logExecutor$2.INSTANCE);
    public static volatile /* synthetic */ AdaptyLogHandler logHandler = new DefaultLogHandler();
    public static /* synthetic */ AdaptyLogLevel logLevel = AdaptyLogLevel.NONE;

    private Logger() {
    }

    /* access modifiers changed from: private */
    public final ExecutorService getLogExecutor() {
        Object value = logExecutor$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-logExecutor>(...)");
        return (ExecutorService) value;
    }

    public final /* synthetic */ void log(AdaptyLogLevel adaptyLogLevel, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(adaptyLogLevel, "messageLogLevel");
        Intrinsics.checkNotNullParameter(function0, "msg");
        if (canLog(adaptyLogLevel.value)) {
            getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, function0.invoke()));
        }
    }

    /* access modifiers changed from: private */
    public final boolean canLog(int i) {
        return (logLevel.value & i) == i;
    }
}
