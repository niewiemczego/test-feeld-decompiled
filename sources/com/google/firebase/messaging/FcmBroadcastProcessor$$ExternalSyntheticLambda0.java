package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FcmBroadcastProcessor$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ Intent f$1;

    public /* synthetic */ FcmBroadcastProcessor$$ExternalSyntheticLambda0(Context context, Intent intent) {
        this.f$0 = context;
        this.f$1 = intent;
    }

    public final Object call() {
        return Integer.valueOf(ServiceStarter.getInstance().startMessagingService(this.f$0, this.f$1));
    }
}
