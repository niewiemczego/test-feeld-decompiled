package com.facebook.login;

import android.os.Bundle;
import com.facebook.LoginStatusCallback;
import com.facebook.internal.PlatformServiceClient;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LoginManager$$ExternalSyntheticLambda1 implements PlatformServiceClient.CompletedListener {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ LoginLogger f$1;
    public final /* synthetic */ LoginStatusCallback f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ LoginManager$$ExternalSyntheticLambda1(String str, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback, String str2) {
        this.f$0 = str;
        this.f$1 = loginLogger;
        this.f$2 = loginStatusCallback;
        this.f$3 = str2;
    }

    public final void completed(Bundle bundle) {
        LoginManager.m393retrieveLoginStatusImpl$lambda2(this.f$0, this.f$1, this.f$2, this.f$3, bundle);
    }
}
