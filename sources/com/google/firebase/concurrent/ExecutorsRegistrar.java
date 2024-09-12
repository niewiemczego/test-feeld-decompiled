package com.google.firebase.concurrent;

import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.Qualified;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public class ExecutorsRegistrar implements ComponentRegistrar {
    static final Lazy<ScheduledExecutorService> BG_EXECUTOR = new Lazy<>(new ExecutorsRegistrar$$ExternalSyntheticLambda4());
    static final Lazy<ScheduledExecutorService> BLOCKING_EXECUTOR = new Lazy<>(new ExecutorsRegistrar$$ExternalSyntheticLambda6());
    static final Lazy<ScheduledExecutorService> LITE_EXECUTOR = new Lazy<>(new ExecutorsRegistrar$$ExternalSyntheticLambda5());
    static final Lazy<ScheduledExecutorService> SCHEDULER = new Lazy<>(new ExecutorsRegistrar$$ExternalSyntheticLambda7());

    public List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.builder(Qualified.qualified(Background.class, ScheduledExecutorService.class), (Qualified<? super T>[]) new Qualified[]{Qualified.qualified(Background.class, ExecutorService.class), Qualified.qualified(Background.class, Executor.class)}).factory(new ExecutorsRegistrar$$ExternalSyntheticLambda0()).build(), Component.builder(Qualified.qualified(Blocking.class, ScheduledExecutorService.class), (Qualified<? super T>[]) new Qualified[]{Qualified.qualified(Blocking.class, ExecutorService.class), Qualified.qualified(Blocking.class, Executor.class)}).factory(new ExecutorsRegistrar$$ExternalSyntheticLambda1()).build(), Component.builder(Qualified.qualified(Lightweight.class, ScheduledExecutorService.class), (Qualified<? super T>[]) new Qualified[]{Qualified.qualified(Lightweight.class, ExecutorService.class), Qualified.qualified(Lightweight.class, Executor.class)}).factory(new ExecutorsRegistrar$$ExternalSyntheticLambda2()).build(), Component.builder(Qualified.qualified(UiThread.class, Executor.class)).factory(new ExecutorsRegistrar$$ExternalSyntheticLambda3()).build()});
    }

    /* access modifiers changed from: private */
    public static ScheduledExecutorService scheduled(ExecutorService executorService) {
        return new DelegatingScheduledExecutorService(executorService, SCHEDULER.get());
    }

    private static ThreadFactory factory(String str, int i) {
        return new CustomThreadFactory(str, i, (StrictMode.ThreadPolicy) null);
    }

    private static ThreadFactory factory(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        return new CustomThreadFactory(str, i, threadPolicy);
    }

    private static StrictMode.ThreadPolicy bgPolicy() {
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        if (Build.VERSION.SDK_INT >= 23) {
            detectNetwork.detectResourceMismatches();
            if (Build.VERSION.SDK_INT >= 26) {
                detectNetwork.detectUnbufferedIo();
            }
        }
        return detectNetwork.penaltyLog().build();
    }

    private static StrictMode.ThreadPolicy litePolicy() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }
}
