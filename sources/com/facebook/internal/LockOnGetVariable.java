package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004B\u0015\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0013\u0010\u0003\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/LockOnGetVariable;", "T", "", "value", "(Ljava/lang/Object;)V", "callable", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)V", "initLatch", "Ljava/util/concurrent/CountDownLatch;", "storedValue", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "waitOnInit", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LockOnGetVariable.kt */
public final class LockOnGetVariable<T> {
    private CountDownLatch initLatch;
    private T storedValue;

    public final T getValue() {
        waitOnInit();
        return this.storedValue;
    }

    public LockOnGetVariable(T t) {
        this.storedValue = t;
    }

    public LockOnGetVariable(Callable<T> callable) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        this.initLatch = new CountDownLatch(1);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        FacebookSdk.getExecutor().execute(new FutureTask(new LockOnGetVariable$$ExternalSyntheticLambda0(this, callable)));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final Void m342_init_$lambda0(LockOnGetVariable lockOnGetVariable, Callable callable) {
        Intrinsics.checkNotNullParameter(lockOnGetVariable, "this$0");
        Intrinsics.checkNotNullParameter(callable, "$callable");
        try {
            lockOnGetVariable.storedValue = callable.call();
        } finally {
            CountDownLatch countDownLatch = lockOnGetVariable.initLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    private final void waitOnInit() {
        CountDownLatch countDownLatch = this.initLatch;
        if (countDownLatch != null) {
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
    }
}
