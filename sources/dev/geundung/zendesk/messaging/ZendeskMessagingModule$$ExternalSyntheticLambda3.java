package dev.geundung.zendesk.messaging;

import com.facebook.react.bridge.Promise;
import kotlin.Unit;
import zendesk.android.SuccessCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ZendeskMessagingModule$$ExternalSyntheticLambda3 implements SuccessCallback {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ ZendeskMessagingModule$$ExternalSyntheticLambda3(Promise promise) {
        this.f$0 = promise;
    }

    public final void onSuccess(Object obj) {
        ZendeskMessagingModule.m674logout$lambda5(this.f$0, (Unit) obj);
    }
}
