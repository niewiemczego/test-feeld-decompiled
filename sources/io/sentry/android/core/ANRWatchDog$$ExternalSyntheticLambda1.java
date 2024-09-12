package io.sentry.android.core;

import android.os.SystemClock;
import io.sentry.transport.ICurrentDateProvider;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ANRWatchDog$$ExternalSyntheticLambda1 implements ICurrentDateProvider {
    public final long getCurrentTimeMillis() {
        return SystemClock.uptimeMillis();
    }
}
