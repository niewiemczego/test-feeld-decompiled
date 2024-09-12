package com.facebook.bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/bolts/BoltsExecutors;", "", "()V", "background", "Ljava/util/concurrent/ExecutorService;", "immediate", "Ljava/util/concurrent/Executor;", "scheduled", "Ljava/util/concurrent/ScheduledExecutorService;", "Companion", "ImmediateExecutor", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BoltsExecutors.kt */
public final class BoltsExecutors {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final BoltsExecutors INSTANCE = new BoltsExecutors();
    /* access modifiers changed from: private */
    public final ExecutorService background;
    /* access modifiers changed from: private */
    public final Executor immediate;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService scheduled;

    @JvmStatic
    public static final ExecutorService background() {
        return Companion.background();
    }

    @JvmStatic
    public static final Executor immediate$facebook_bolts_release() {
        return Companion.immediate$facebook_bolts_release();
    }

    @JvmStatic
    public static final ScheduledExecutorService scheduled$facebook_bolts_release() {
        return Companion.scheduled$facebook_bolts_release();
    }

    private BoltsExecutors() {
        ExecutorService executorService;
        if (!Companion.isAndroidRuntime()) {
            executorService = Executors.newCachedThreadPool();
            Intrinsics.checkNotNullExpressionValue(executorService, "newCachedThreadPool()");
        } else {
            executorService = AndroidExecutors.Companion.newCachedThreadPool();
        }
        this.background = executorService;
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor()");
        this.scheduled = newSingleThreadScheduledExecutor;
        this.immediate = new ImmediateExecutor();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/bolts/BoltsExecutors$ImmediateExecutor;", "Ljava/util/concurrent/Executor;", "()V", "executionDepth", "Ljava/lang/ThreadLocal;", "", "decrementDepth", "execute", "", "command", "Ljava/lang/Runnable;", "incrementDepth", "Companion", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: BoltsExecutors.kt */
    private static final class ImmediateExecutor implements Executor {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final int MAX_DEPTH = 15;
        private final ThreadLocal<Integer> executionDepth = new ThreadLocal<>();

        private final int incrementDepth() {
            Integer num = this.executionDepth.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.executionDepth.set(Integer.valueOf(intValue));
            return intValue;
        }

        private final int decrementDepth() {
            Integer num = this.executionDepth.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.executionDepth.remove();
            } else {
                this.executionDepth.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public void execute(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "command");
            if (incrementDepth() <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    decrementDepth();
                    throw th;
                }
            } else {
                BoltsExecutors.Companion.background().execute(runnable);
            }
            decrementDepth();
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/bolts/BoltsExecutors$ImmediateExecutor$Companion;", "", "()V", "MAX_DEPTH", "", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: BoltsExecutors.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\r\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\fJ\r\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\b\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/facebook/bolts/BoltsExecutors$Companion;", "", "()V", "INSTANCE", "Lcom/facebook/bolts/BoltsExecutors;", "isAndroidRuntime", "", "()Z", "background", "Ljava/util/concurrent/ExecutorService;", "immediate", "Ljava/util/concurrent/Executor;", "immediate$facebook_bolts_release", "scheduled", "Ljava/util/concurrent/ScheduledExecutorService;", "scheduled$facebook_bolts_release", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: BoltsExecutors.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean isAndroidRuntime() {
            String property = System.getProperty("java.runtime.name");
            if (property == null) {
                return false;
            }
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String lowerCase = property.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "android", false, 2, (Object) null);
        }

        @JvmStatic
        public final ExecutorService background() {
            return BoltsExecutors.INSTANCE.background;
        }

        @JvmStatic
        public final ScheduledExecutorService scheduled$facebook_bolts_release() {
            return BoltsExecutors.INSTANCE.scheduled;
        }

        @JvmStatic
        public final Executor immediate$facebook_bolts_release() {
            return BoltsExecutors.INSTANCE.immediate;
        }
    }
}
