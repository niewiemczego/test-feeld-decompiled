package dev.geundung.zendesk.messaging;

import com.facebook.react.bridge.Promise;
import zendesk.android.FailureCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ZendeskMessagingModule$$ExternalSyntheticLambda6 implements FailureCallback {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ ZendeskMessagingModule$$ExternalSyntheticLambda6(Promise promise) {
        this.f$0 = promise;
    }

    public final void onFailure(Throwable th) {
        ZendeskMessagingModule.m673login$lambda4(this.f$0, th);
    }
}
