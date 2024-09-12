package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.JSONObject;

public class GameFeaturesLibrary {
    public static void getPayload(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.GET_PAYLOAD);
    }

    public static void canCreateShortcut(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.CAN_CREATE_SHORTCUT);
    }

    public static void createShortcut(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.CREATE_SHORTCUT);
    }

    public static void postSessionScore(Context context, int i, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("score", i), callback, SDKMessageEnum.POST_SESSION_SCORE);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.POST_SESSION_SCORE, e);
        }
    }

    public static void postSessionScoreAsync(Context context, int i, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("score", i), callback, SDKMessageEnum.POST_SESSION_SCORE_ASYNC);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.POST_SESSION_SCORE_ASYNC, e);
        }
    }

    public static void getTournamentAsync(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.GET_TOURNAMENT_ASYNC);
    }

    public static void createTournamentAsync(Context context, int i, String str, String str2, String str3, String str4, Integer num, JSONObject jSONObject, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_INITIAL_SCORE, i).put("title", (Object) str).put("image", (Object) str2).put(SDKConstants.PARAM_SORT_ORDER, (Object) str3).put(SDKConstants.PARAM_SCORE_FORMAT, (Object) str4).put(SDKConstants.PARAM_END_TIME, (Object) num).put("data", (Object) jSONObject), callback, SDKMessageEnum.TOURNAMENT_CREATE_ASYNC);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.TOURNAMENT_CREATE_ASYNC, e);
        }
    }

    public static void shareTournamentAsync(Context context, Integer num, JSONObject jSONObject, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("score", (Object) num).put("data", (Object) jSONObject), callback, SDKMessageEnum.TOURNAMENT_SHARE_ASYNC);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.TOURNAMENT_SHARE_ASYNC, e);
        }
    }

    public static void postTournamentScoreAsync(Context context, int i, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, new JSONObject().put("score", i), callback, SDKMessageEnum.TOURNAMENT_POST_SCORE_ASYNC);
    }

    public static void getTournamentsAsync(Context context, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.TOURNAMENT_GET_TOURNAMENTS_ASYNC);
    }

    public static void joinTournamentAsync(Context context, String str, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_TOURNAMENT_ID, (Object) str), callback, SDKMessageEnum.TOURNAMENT_JOIN_ASYNC);
    }

    public static void performHapticFeedback(Context context) {
        DaemonRequest.executeAsync(context, (JSONObject) null, (DaemonRequest.Callback) new DaemonRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
            }
        }, SDKMessageEnum.PERFORM_HAPTIC_FEEDBACK_ASYNC);
    }
}
