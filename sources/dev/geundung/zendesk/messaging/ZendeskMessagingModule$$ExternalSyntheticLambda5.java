package dev.geundung.zendesk.messaging;

import com.facebook.react.bridge.Promise;
import zendesk.android.SuccessCallback;
import zendesk.android.ZendeskUser;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ZendeskMessagingModule$$ExternalSyntheticLambda5 implements SuccessCallback {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ ZendeskMessagingModule$$ExternalSyntheticLambda5(Promise promise) {
        this.f$0 = promise;
    }

    public final void onSuccess(Object obj) {
        ZendeskMessagingModule.m672login$lambda3(this.f$0, (ZendeskUser) obj);
    }
}
