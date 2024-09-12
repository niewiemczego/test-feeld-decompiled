package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.internal.CallbackManagerImpl;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ShareInternalUtility$$ExternalSyntheticLambda1 implements CallbackManagerImpl.Callback {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ FacebookCallback f$1;

    public /* synthetic */ ShareInternalUtility$$ExternalSyntheticLambda1(int i, FacebookCallback facebookCallback) {
        this.f$0 = i;
        this.f$1 = facebookCallback;
    }

    public final boolean onActivityResult(int i, Intent intent) {
        return ShareInternalUtility.m410registerSharerCallback$lambda1(this.f$0, this.f$1, i, intent);
    }
}
