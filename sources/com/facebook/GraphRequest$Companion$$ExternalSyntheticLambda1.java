package com.facebook;

import com.facebook.GraphRequest;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GraphRequest$Companion$$ExternalSyntheticLambda1 implements GraphRequest.Callback {
    public final /* synthetic */ GraphRequest.GraphJSONObjectCallback f$0;

    public /* synthetic */ GraphRequest$Companion$$ExternalSyntheticLambda1(GraphRequest.GraphJSONObjectCallback graphJSONObjectCallback) {
        this.f$0 = graphJSONObjectCallback;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        GraphRequest.Companion.m210newMeRequest$lambda0(this.f$0, graphResponse);
    }
}
