package com.facebook.gamingservices;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.bolts.TaskCompletionSource;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TournamentFetcher$$ExternalSyntheticLambda0 implements GraphRequest.Callback {
    public final /* synthetic */ TaskCompletionSource f$0;

    public /* synthetic */ TournamentFetcher$$ExternalSyntheticLambda0(TaskCompletionSource taskCompletionSource) {
        this.f$0 = taskCompletionSource;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        TournamentFetcher.m317fetchTournaments$lambda1(this.f$0, graphResponse);
    }
}
