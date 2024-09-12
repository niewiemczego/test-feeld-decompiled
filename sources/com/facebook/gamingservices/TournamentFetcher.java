package com.facebook.gamingservices;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.bolts.TaskCompletionSource;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.sentry.protocol.Response;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¨\u0006\u0007"}, d2 = {"Lcom/facebook/gamingservices/TournamentFetcher;", "", "()V", "fetchTournaments", "Lcom/facebook/bolts/TaskCompletionSource;", "", "Lcom/facebook/gamingservices/Tournament;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TournamentFetcher.kt */
public final class TournamentFetcher {
    public final TaskCompletionSource<List<Tournament>> fetchTournaments() {
        TaskCompletionSource<List<Tournament>> taskCompletionSource = new TaskCompletionSource<>();
        Bundle bundle = new Bundle();
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to fetch tournament with an invalid access token");
        }
        if (currentAccessToken.getGraphDomain() != null && Intrinsics.areEqual((Object) FacebookSdk.GAMING, (Object) currentAccessToken.getGraphDomain())) {
            GraphRequest graphRequest = new GraphRequest(AccessToken.Companion.getCurrentAccessToken(), "me/tournaments", bundle, HttpMethod.GET, new TournamentFetcher$$ExternalSyntheticLambda0(taskCompletionSource), (String) null, 32, (DefaultConstructorMarker) null);
            graphRequest.setParameters(bundle);
            graphRequest.executeAsync();
            return taskCompletionSource;
        }
        throw new FacebookException("User is not using gaming login");
    }

    /* access modifiers changed from: private */
    /* renamed from: fetchTournaments$lambda-1  reason: not valid java name */
    public static final void m317fetchTournaments$lambda1(TaskCompletionSource taskCompletionSource, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(taskCompletionSource, "$task");
        Intrinsics.checkNotNullParameter(graphResponse, Response.TYPE);
        if (graphResponse.getError() != null) {
            FacebookRequestError error = graphResponse.getError();
            FacebookException facebookException = null;
            if ((error == null ? null : error.getException()) != null) {
                FacebookRequestError error2 = graphResponse.getError();
                if (error2 != null) {
                    facebookException = error2.getException();
                }
                taskCompletionSource.setError(facebookException);
                return;
            }
            taskCompletionSource.setError(new GraphAPIException("Graph API Error"));
            return;
        }
        try {
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (jSONObject == null) {
                taskCompletionSource.setError(new GraphAPIException("Failed to get response"));
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            if (jSONArray != null) {
                if (jSONArray.length() >= 1) {
                    Gson create = new GsonBuilder().create();
                    String jSONArray2 = jSONArray.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONArray2, "data.toString()");
                    Object fromJson = create.fromJson(jSONArray2, Tournament[].class);
                    Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(dataString, Array<Tournament>::class.java)");
                    taskCompletionSource.setResult(ArraysKt.toList((T[]) (Object[]) fromJson));
                    return;
                }
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ROOT, "No tournament found", Arrays.copyOf(new Object[]{Integer.valueOf(jSONArray.length()), 1}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            taskCompletionSource.setError(new GraphAPIException(format));
        } catch (JSONException e) {
            taskCompletionSource.setError(e);
        }
    }
}
