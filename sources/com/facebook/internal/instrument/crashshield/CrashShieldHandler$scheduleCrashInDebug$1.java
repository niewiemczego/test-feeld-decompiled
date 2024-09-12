package com.facebook.internal.instrument.crashshield;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017¨\u0006\u0004"}, d2 = {"com/facebook/internal/instrument/crashshield/CrashShieldHandler$scheduleCrashInDebug$1", "Ljava/lang/Runnable;", "run", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CrashShieldHandler.kt */
public final class CrashShieldHandler$scheduleCrashInDebug$1 implements Runnable {
    final /* synthetic */ Throwable $e;

    CrashShieldHandler$scheduleCrashInDebug$1(Throwable th) {
        this.$e = th;
    }

    public void run() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                throw new RuntimeException(this.$e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
