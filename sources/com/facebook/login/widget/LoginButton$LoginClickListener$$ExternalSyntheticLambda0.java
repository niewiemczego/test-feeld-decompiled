package com.facebook.login.widget;

import android.content.DialogInterface;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LoginButton$LoginClickListener$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ LoginManager f$0;

    public /* synthetic */ LoginButton$LoginClickListener$$ExternalSyntheticLambda0(LoginManager loginManager) {
        this.f$0 = loginManager;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        LoginButton.LoginClickListener.m403performLogout$lambda2(this.f$0, dialogInterface, i);
    }
}
