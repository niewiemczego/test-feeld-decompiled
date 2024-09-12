package com.facebook.login;

import android.os.Bundle;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LoginLogger$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ LoginLogger f$0;
    public final /* synthetic */ Bundle f$1;

    public /* synthetic */ LoginLogger$$ExternalSyntheticLambda0(LoginLogger loginLogger, Bundle bundle) {
        this.f$0 = loginLogger;
        this.f$1 = bundle;
    }

    public final void run() {
        LoginLogger.m389logHeartbeatEvent$lambda0(this.f$0, this.f$1);
    }
}
