package com.facebook.gamingservices;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.gamingservices.TournamentJoinDialog;
import com.facebook.internal.AppCall;
import com.facebook.share.internal.ResultProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/facebook/gamingservices/TournamentJoinDialog$registerCallbackImpl$resultProcessor$1", "Lcom/facebook/share/internal/ResultProcessor;", "onSuccess", "", "appCall", "Lcom/facebook/internal/AppCall;", "results", "Landroid/os/Bundle;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TournamentJoinDialog.kt */
public final class TournamentJoinDialog$registerCallbackImpl$resultProcessor$1 extends ResultProcessor {
    final /* synthetic */ FacebookCallback<TournamentJoinDialog.Result> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TournamentJoinDialog$registerCallbackImpl$resultProcessor$1(FacebookCallback<TournamentJoinDialog.Result> facebookCallback) {
        super(facebookCallback);
        this.$callback = facebookCallback;
    }

    public void onSuccess(AppCall appCall, Bundle bundle) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        if (bundle != null) {
            if (bundle.getString("error_message") != null) {
                this.$callback.onError(new FacebookException(bundle.getString("error_message")));
                return;
            } else if (bundle.getString("payload") != null) {
                this.$callback.onSuccess(new TournamentJoinDialog.Result(bundle));
                return;
            }
        }
        onCancel(appCall);
    }
}
