package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RequestDeduplicator$$ExternalSyntheticLambda0 implements Continuation {
    public final /* synthetic */ RequestDeduplicator f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ RequestDeduplicator$$ExternalSyntheticLambda0(RequestDeduplicator requestDeduplicator, String str) {
        this.f$0 = requestDeduplicator;
        this.f$1 = str;
    }

    public final Object then(Task task) {
        return this.f$0.m601lambda$getOrStartGetTokenRequest$0$comgooglefirebasemessagingRequestDeduplicator(this.f$1, task);
    }
}
