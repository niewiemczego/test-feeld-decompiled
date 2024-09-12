package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FcmBroadcastProcessor$$ExternalSyntheticLambda1 implements Continuation {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ Intent f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ FcmBroadcastProcessor$$ExternalSyntheticLambda1(Context context, Intent intent, boolean z) {
        this.f$0 = context;
        this.f$1 = intent;
        this.f$2 = z;
    }

    public final Object then(Task task) {
        return FcmBroadcastProcessor.lambda$startMessagingService$2(this.f$0, this.f$1, this.f$2, task);
    }
}
