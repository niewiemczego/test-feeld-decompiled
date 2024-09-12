package io.sentry.android.core;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAndroidEventProcessor$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ SentryAndroidOptions f$1;

    public /* synthetic */ DefaultAndroidEventProcessor$$ExternalSyntheticLambda0(Context context, SentryAndroidOptions sentryAndroidOptions) {
        this.f$0 = context;
        this.f$1 = sentryAndroidOptions;
    }

    public final Object call() {
        return DeviceInfoUtil.getInstance(this.f$0, this.f$1);
    }
}
