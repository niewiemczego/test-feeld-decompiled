package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FirebaseMessaging$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ FirebaseMessaging f$0;
    public final /* synthetic */ TaskCompletionSource f$1;

    public /* synthetic */ FirebaseMessaging$$ExternalSyntheticLambda8(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.f$0 = firebaseMessaging;
        this.f$1 = taskCompletionSource;
    }

    public final void run() {
        this.f$0.m591lambda$deleteToken$5$comgooglefirebasemessagingFirebaseMessaging(this.f$1);
    }
}
