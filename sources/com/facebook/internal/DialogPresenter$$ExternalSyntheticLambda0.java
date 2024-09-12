package com.facebook.internal;

import android.util.Pair;
import androidx.activity.result.ActivityResultCallback;
import com.facebook.CallbackManager;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DialogPresenter$$ExternalSyntheticLambda0 implements ActivityResultCallback {
    public final /* synthetic */ CallbackManager f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Ref.ObjectRef f$2;

    public /* synthetic */ DialogPresenter$$ExternalSyntheticLambda0(CallbackManager callbackManager, int i, Ref.ObjectRef objectRef) {
        this.f$0 = callbackManager;
        this.f$1 = i;
        this.f$2 = objectRef;
    }

    public final void onActivityResult(Object obj) {
        DialogPresenter.m323startActivityForResultWithAndroidX$lambda2(this.f$0, this.f$1, this.f$2, (Pair) obj);
    }
}
