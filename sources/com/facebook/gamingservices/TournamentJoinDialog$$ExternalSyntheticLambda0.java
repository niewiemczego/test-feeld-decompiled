package com.facebook.gamingservices;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TournamentJoinDialog$$ExternalSyntheticLambda0 implements CallbackManagerImpl.Callback {
    public final /* synthetic */ TournamentJoinDialog f$0;
    public final /* synthetic */ ResultProcessor f$1;

    public /* synthetic */ TournamentJoinDialog$$ExternalSyntheticLambda0(TournamentJoinDialog tournamentJoinDialog, ResultProcessor resultProcessor) {
        this.f$0 = tournamentJoinDialog;
        this.f$1 = resultProcessor;
    }

    public final boolean onActivityResult(int i, Intent intent) {
        return TournamentJoinDialog.m319registerCallbackImpl$lambda0(this.f$0, this.f$1, i, intent);
    }
}
