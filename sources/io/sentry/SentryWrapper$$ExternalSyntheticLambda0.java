package io.sentry;

import java.util.function.Supplier;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryWrapper$$ExternalSyntheticLambda0 implements Supplier {
    public final /* synthetic */ IHub f$0;
    public final /* synthetic */ Supplier f$1;

    public /* synthetic */ SentryWrapper$$ExternalSyntheticLambda0(IHub iHub, Supplier supplier) {
        this.f$0 = iHub;
        this.f$1 = supplier;
    }

    public final Object get() {
        return SentryWrapper.lambda$wrapSupplier$1(this.f$0, this.f$1);
    }
}
