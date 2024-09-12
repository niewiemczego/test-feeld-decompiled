package com.facebook;

import com.facebook.GraphRequest;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GraphRequest$Companion$$ExternalSyntheticLambda2 implements GraphRequest.Callback {
    public final /* synthetic */ GraphRequest.GraphJSONArrayCallback f$0;

    public /* synthetic */ GraphRequest$Companion$$ExternalSyntheticLambda2(GraphRequest.GraphJSONArrayCallback graphJSONArrayCallback) {
        this.f$0 = graphJSONArrayCallback;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        GraphRequest.Companion.m211newPlacesSearchRequest$lambda1(this.f$0, graphResponse);
    }
}
