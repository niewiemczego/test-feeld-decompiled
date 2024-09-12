package com.google.common.util.concurrent;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SimpleTimeLimiter$1$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ Method f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object[] f$2;

    public /* synthetic */ SimpleTimeLimiter$1$$ExternalSyntheticLambda0(Method method, Object obj, Object[] objArr) {
        this.f$0 = method;
        this.f$1 = obj;
        this.f$2 = objArr;
    }

    public final Object call() {
        return SimpleTimeLimiter.AnonymousClass1.lambda$invoke$0(this.f$0, this.f$1, this.f$2);
    }
}
