package com.facebook;

import com.facebook.GraphRequest;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GraphRequest$$ExternalSyntheticLambda0 implements GraphRequest.Callback {
    public final /* synthetic */ GraphRequest.Callback f$0;

    public /* synthetic */ GraphRequest$$ExternalSyntheticLambda0(GraphRequest.Callback callback) {
        this.f$0 = callback;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        GraphRequest.m209_set_callback_$lambda0(this.f$0, graphResponse);
    }
}
