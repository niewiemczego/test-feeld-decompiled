package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EnhancedIntentService$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ EnhancedIntentService f$0;
    public final /* synthetic */ Intent f$1;
    public final /* synthetic */ TaskCompletionSource f$2;

    public /* synthetic */ EnhancedIntentService$$ExternalSyntheticLambda0(EnhancedIntentService enhancedIntentService, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.f$0 = enhancedIntentService;
        this.f$1 = intent;
        this.f$2 = taskCompletionSource;
    }

    public final void run() {
        this.f$0.m587lambda$processIntent$0$comgooglefirebasemessagingEnhancedIntentService(this.f$1, this.f$2);
    }
}
