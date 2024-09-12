package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Mutex.kt */
/* synthetic */ class MutexImpl$onLock$2 extends FunctionReferenceImpl implements Function3<MutexImpl, Object, Object, Object> {
    public static final MutexImpl$onLock$2 INSTANCE = new MutexImpl$onLock$2();

    MutexImpl$onLock$2() {
        super(3, MutexImpl.class, "onLockProcessResult", "onLockProcessResult(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(MutexImpl mutexImpl, Object obj, Object obj2) {
        return mutexImpl.onLockProcessResult(obj, obj2);
    }
}
