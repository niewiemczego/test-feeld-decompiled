package com.facebook.gamingservices.internal;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.facebook.gamingservices.TournamentConfig;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000fJ%\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0012J%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0015J%\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/gamingservices/internal/TournamentShareDialogURIBuilder;", "", "()V", "authority", "", "me", "scheme", "tournament", "bundleForCreating", "Landroid/os/Bundle;", "config", "Lcom/facebook/gamingservices/TournamentConfig;", "score", "", "appID", "bundleForCreating$facebook_gamingservices_release", "bundleForUpdating", "tournamentID", "bundleForUpdating$facebook_gamingservices_release", "uriForCreating", "Landroid/net/Uri;", "uriForCreating$facebook_gamingservices_release", "uriForUpdating", "uriForUpdating$facebook_gamingservices_release", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TournamentShareDialogURIBuilder.kt */
public final class TournamentShareDialogURIBuilder {
    public static final TournamentShareDialogURIBuilder INSTANCE = new TournamentShareDialogURIBuilder();
    public static final String authority = "fb.gg";
    public static final String me = "me";
    public static final String scheme = "https";
    public static final String tournament = "instant_tournament";

    private TournamentShareDialogURIBuilder() {
    }

    public final Uri uriForUpdating$facebook_gamingservices_release(String str, Number number, String str2) {
        Intrinsics.checkNotNullParameter(str, "tournamentID");
        Intrinsics.checkNotNullParameter(number, "score");
        Intrinsics.checkNotNullParameter(str2, SDKConstants.PARAM_APP_ID);
        Uri build = new Uri.Builder().scheme("https").authority("fb.gg").appendPath(me).appendPath(tournament).appendPath(str2).appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_ID, str).appendQueryParameter("score", number.toString()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .scheme(scheme)\n        .authority(authority)\n        .appendPath(me)\n        .appendPath(tournament)\n        .appendPath(appID)\n        .appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_ID, tournamentID)\n        .appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_SCORE, score.toString())\n        .build()");
        return build;
    }

    public final Uri uriForCreating$facebook_gamingservices_release(TournamentConfig tournamentConfig, Number number, String str) {
        Intrinsics.checkNotNullParameter(tournamentConfig, "config");
        Intrinsics.checkNotNullParameter(number, "score");
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_APP_ID);
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").authority("fb.gg").appendPath(me).appendPath(tournament).appendPath(str).appendQueryParameter("score", number.toString());
        Instant endTime = tournamentConfig.getEndTime();
        if (endTime != null) {
            appendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_END_TIME, endTime.toString());
        }
        TournamentSortOrder sortOrder = tournamentConfig.getSortOrder();
        if (sortOrder != null) {
            appendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_SORT_ORDER, sortOrder.toString());
        }
        TournamentScoreType scoreType = tournamentConfig.getScoreType();
        if (scoreType != null) {
            appendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_SCORE_FORMAT, scoreType.toString());
        }
        String title = tournamentConfig.getTitle();
        if (title != null) {
            appendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_TITLE, title);
        }
        String payload = tournamentConfig.getPayload();
        if (payload != null) {
            appendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_PAYLOAD, payload);
        }
        Uri build = appendQueryParameter.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public final Bundle bundleForUpdating$facebook_gamingservices_release(String str, Number number, String str2) {
        Intrinsics.checkNotNullParameter(str, "tournamentID");
        Intrinsics.checkNotNullParameter(number, "score");
        Intrinsics.checkNotNullParameter(str2, SDKConstants.PARAM_APP_ID);
        Bundle bundle = new Bundle();
        bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, SDKConstants.PARAM_TOURNAMENTS);
        bundle.putString("app_id", str2);
        bundle.putString("score", number.toString());
        bundle.putString(SDKConstants.PARAM_TOURNAMENTS_ID, str);
        return bundle;
    }

    public final Bundle bundleForCreating$facebook_gamingservices_release(TournamentConfig tournamentConfig, Number number, String str) {
        Instant endTime;
        Intrinsics.checkNotNullParameter(tournamentConfig, "config");
        Intrinsics.checkNotNullParameter(number, "score");
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_APP_ID);
        Bundle bundle = new Bundle();
        bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, SDKConstants.PARAM_TOURNAMENTS);
        bundle.putString("app_id", str);
        bundle.putString("score", number.toString());
        TournamentSortOrder sortOrder = tournamentConfig.getSortOrder();
        if (sortOrder != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_SORT_ORDER, sortOrder.toString());
        }
        TournamentScoreType scoreType = tournamentConfig.getScoreType();
        if (scoreType != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_SCORE_FORMAT, scoreType.toString());
        }
        String title = tournamentConfig.getTitle();
        if (title != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_TITLE, title.toString());
        }
        String payload = tournamentConfig.getPayload();
        if (payload != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_PAYLOAD, payload.toString());
        }
        if (Build.VERSION.SDK_INT >= 26 && (endTime = tournamentConfig.getEndTime()) != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_END_TIME, String.valueOf((int) endTime.getEpochSecond()));
        }
        return bundle;
    }
}
