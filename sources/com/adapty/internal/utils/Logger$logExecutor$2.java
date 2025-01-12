package com.adapty.internal.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Logger.kt */
final class Logger$logExecutor$2 extends Lambda implements Function0<ExecutorService> {
    public static final Logger$logExecutor$2 INSTANCE = new Logger$logExecutor$2();

    Logger$logExecutor$2() {
        super(0);
    }

    public final ExecutorService invoke() {
        return Executors.newSingleThreadExecutor();
    }
}
