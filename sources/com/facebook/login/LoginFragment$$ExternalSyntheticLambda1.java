package com.facebook.login;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LoginFragment$$ExternalSyntheticLambda1 implements ActivityResultCallback {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ LoginFragment$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onActivityResult(Object obj) {
        LoginFragment.m387onCreate$lambda1(this.f$0, (ActivityResult) obj);
    }
}
