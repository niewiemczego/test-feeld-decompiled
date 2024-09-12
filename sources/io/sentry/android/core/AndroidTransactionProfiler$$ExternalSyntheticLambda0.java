package io.sentry.android.core;

import io.sentry.android.core.internal.util.CpuInfoUtils;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidTransactionProfiler$$ExternalSyntheticLambda0 implements Callable {
    public final Object call() {
        return CpuInfoUtils.getInstance().readMaxFrequencies();
    }
}
