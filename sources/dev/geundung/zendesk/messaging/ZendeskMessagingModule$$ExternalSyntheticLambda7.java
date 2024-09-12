package dev.geundung.zendesk.messaging;

import com.facebook.react.bridge.Promise;
import zendesk.android.SuccessCallback;
import zendesk.android.Zendesk;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ZendeskMessagingModule$$ExternalSyntheticLambda7 implements SuccessCallback {
    public final /* synthetic */ ZendeskMessagingModule f$0;
    public final /* synthetic */ Promise f$1;

    public /* synthetic */ ZendeskMessagingModule$$ExternalSyntheticLambda7(ZendeskMessagingModule zendeskMessagingModule, Promise promise) {
        this.f$0 = zendeskMessagingModule;
        this.f$1 = promise;
    }

    public final void onSuccess(Object obj) {
        ZendeskMessagingModule.m670initialize$lambda1(this.f$0, this.f$1, (Zendesk) obj);
    }
}
