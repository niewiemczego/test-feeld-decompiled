package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ShareInternalUtility$$ExternalSyntheticLambda0 implements CallbackManagerImpl.Callback {
    public final /* synthetic */ int f$0;

    public /* synthetic */ ShareInternalUtility$$ExternalSyntheticLambda0(int i) {
        this.f$0 = i;
    }

    public final boolean onActivityResult(int i, Intent intent) {
        return ShareInternalUtility.m411registerStaticShareCallback$lambda0(this.f$0, i, intent);
    }
}
