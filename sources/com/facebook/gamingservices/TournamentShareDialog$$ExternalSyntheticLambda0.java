package com.facebook.gamingservices;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TournamentShareDialog$$ExternalSyntheticLambda0 implements CallbackManagerImpl.Callback {
    public final /* synthetic */ TournamentShareDialog f$0;
    public final /* synthetic */ ResultProcessor f$1;

    public /* synthetic */ TournamentShareDialog$$ExternalSyntheticLambda0(TournamentShareDialog tournamentShareDialog, ResultProcessor resultProcessor) {
        this.f$0 = tournamentShareDialog;
        this.f$1 = resultProcessor;
    }

    public final boolean onActivityResult(int i, Intent intent) {
        return TournamentShareDialog.m321registerCallbackImpl$lambda0(this.f$0, this.f$1, i, intent);
    }
}
