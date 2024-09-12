package io.sentry;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public final class SentryWrapper {
    public static <U> Callable<U> wrapCallable(Callable<U> callable) {
        return new SentryWrapper$$ExternalSyntheticLambda1(Sentry.getCurrentHub().clone(), callable);
    }

    static /* synthetic */ Object lambda$wrapCallable$0(IHub iHub, Callable callable) throws Exception {
        IHub currentHub = Sentry.getCurrentHub();
        Sentry.setCurrentHub(iHub);
        try {
            return callable.call();
        } finally {
            Sentry.setCurrentHub(currentHub);
        }
    }

    public static <U> Supplier<U> wrapSupplier(Supplier<U> supplier) {
        return new SentryWrapper$$ExternalSyntheticLambda0(Sentry.getCurrentHub().clone(), supplier);
    }

    static /* synthetic */ Object lambda$wrapSupplier$1(IHub iHub, Supplier supplier) {
        IHub currentHub = Sentry.getCurrentHub();
        Sentry.setCurrentHub(iHub);
        try {
            return supplier.get();
        } finally {
            Sentry.setCurrentHub(currentHub);
        }
    }
}
