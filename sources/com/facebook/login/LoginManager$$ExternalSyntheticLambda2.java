package com.facebook.login;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LoginManager$$ExternalSyntheticLambda2 implements CallbackManagerImpl.Callback {
    public final /* synthetic */ LoginManager f$0;

    public /* synthetic */ LoginManager$$ExternalSyntheticLambda2(LoginManager loginManager) {
        this.f$0 = loginManager;
    }

    public final boolean onActivityResult(int i, Intent intent) {
        return LoginManager.m394startLogin$lambda1(this.f$0, i, intent);
    }
}
