package com.facebook.login;

import com.facebook.login.LoginClient;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LoginFragment$$ExternalSyntheticLambda0 implements LoginClient.OnCompletedListener {
    public final /* synthetic */ LoginFragment f$0;

    public /* synthetic */ LoginFragment$$ExternalSyntheticLambda0(LoginFragment loginFragment) {
        this.f$0 = loginFragment;
    }

    public final void onCompleted(LoginClient.Result result) {
        LoginFragment.m386onCreate$lambda0(this.f$0, result);
    }
}
