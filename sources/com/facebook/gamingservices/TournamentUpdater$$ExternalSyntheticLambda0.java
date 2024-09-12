package com.facebook.gamingservices;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.bolts.TaskCompletionSource;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TournamentUpdater$$ExternalSyntheticLambda0 implements GraphRequest.Callback {
    public final /* synthetic */ TaskCompletionSource f$0;

    public /* synthetic */ TournamentUpdater$$ExternalSyntheticLambda0(TaskCompletionSource taskCompletionSource) {
        this.f$0 = taskCompletionSource;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        TournamentUpdater.m322update$lambda0(this.f$0, graphResponse);
    }
}
