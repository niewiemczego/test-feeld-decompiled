package com.facebook.login;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.internal.CallbackManagerImpl;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LoginManager$$ExternalSyntheticLambda0 implements CallbackManagerImpl.Callback {
    public final /* synthetic */ LoginManager f$0;
    public final /* synthetic */ FacebookCallback f$1;

    public /* synthetic */ LoginManager$$ExternalSyntheticLambda0(LoginManager loginManager, FacebookCallback facebookCallback) {
        this.f$0 = loginManager;
        this.f$1 = facebookCallback;
    }

    public final boolean onActivityResult(int i, Intent intent) {
        return LoginManager.m392registerCallback$lambda0(this.f$0, this.f$1, i, intent);
    }
}
