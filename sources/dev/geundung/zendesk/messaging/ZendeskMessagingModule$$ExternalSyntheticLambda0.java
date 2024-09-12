package dev.geundung.zendesk.messaging;

import com.facebook.react.bridge.Promise;
import kotlin.Unit;
import zendesk.android.SuccessCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ZendeskMessagingModule$$ExternalSyntheticLambda0 implements SuccessCallback {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ ZendeskMessagingModule$$ExternalSyntheticLambda0(Promise promise) {
        this.f$0 = promise;
    }

    public final void onSuccess(Object obj) {
        ZendeskMessagingModule.m676sendPageViewEvent$lambda7(this.f$0, (Unit) obj);
    }
}
