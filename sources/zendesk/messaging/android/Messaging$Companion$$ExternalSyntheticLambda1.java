package zendesk.messaging.android;

import zendesk.android.FailureCallback;
import zendesk.messaging.android.Messaging;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Messaging$Companion$$ExternalSyntheticLambda1 implements FailureCallback {
    public final /* synthetic */ FailureCallback f$0;

    public /* synthetic */ Messaging$Companion$$ExternalSyntheticLambda1(FailureCallback failureCallback) {
        this.f$0 = failureCallback;
    }

    public final void onFailure(Throwable th) {
        Messaging.Companion.m142initialize$lambda1(this.f$0, th);
    }
}
