package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.locks.Lock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: locks.kt */
public interface SimpleLock {
    public static final Companion Companion = Companion.$$INSTANCE;

    void lock();

    void unlock();

    /* compiled from: locks.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final DefaultSimpleLock simpleLock(Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
            if (runnable == null || function1 == null) {
                return new DefaultSimpleLock((Lock) null, 1, (DefaultConstructorMarker) null);
            }
            return new CancellableSimpleLock(runnable, function1);
        }
    }
}
