package com.facebook.login;

import android.util.Pair;
import androidx.activity.result.ActivityResultCallback;
import com.facebook.login.LoginManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$$ExternalSyntheticLambda0 implements ActivityResultCallback {
    public final /* synthetic */ LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate f$0;
    public final /* synthetic */ LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder f$1;

    public /* synthetic */ LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$$ExternalSyntheticLambda0(LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate androidxActivityResultRegistryOwnerStartActivityDelegate, LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder) {
        this.f$0 = androidxActivityResultRegistryOwnerStartActivityDelegate;
        this.f$1 = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder;
    }

    public final void onActivityResult(Object obj) {
        LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate.m396startActivityForResult$lambda0(this.f$0, this.f$1, (Pair) obj);
    }
}
