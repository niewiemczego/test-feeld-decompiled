package zendesk.messaging.android;

import zendesk.android.SuccessCallback;
import zendesk.android.Zendesk;
import zendesk.messaging.android.Messaging;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Messaging$Companion$$ExternalSyntheticLambda0 implements SuccessCallback {
    public final /* synthetic */ SuccessCallback f$0;

    public /* synthetic */ Messaging$Companion$$ExternalSyntheticLambda0(SuccessCallback successCallback) {
        this.f$0 = successCallback;
    }

    public final void onSuccess(Object obj) {
        Messaging.Companion.m141initialize$lambda0(this.f$0, (Zendesk) obj);
    }
}
