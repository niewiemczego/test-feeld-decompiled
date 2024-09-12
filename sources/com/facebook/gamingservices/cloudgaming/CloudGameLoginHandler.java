package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.gamingservices.GamingPayload;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudGameLoginHandler {
    private static final int DEFAULT_TIMEOUT_IN_SEC = 5;
    private static boolean IS_RUNNING_IN_CLOUD = false;
    private static SDKLogger mLogger;

    public static synchronized AccessToken init(Context context) throws FacebookException {
        AccessToken init;
        synchronized (CloudGameLoginHandler.class) {
            init = init(context, 5);
        }
        return init;
    }

    public static synchronized AccessToken init(Context context, int i) throws FacebookException {
        AccessToken currentAccessToken;
        synchronized (CloudGameLoginHandler.class) {
            if (i <= 0) {
                i = 5;
            }
            if (isCloudEnvReady(context, i)) {
                mLogger = SDKLogger.getInstance(context);
                GraphResponse executeAndWait = DaemonRequest.executeAndWait(context, (JSONObject) null, SDKMessageEnum.GET_ACCESS_TOKEN, i);
                if (executeAndWait == null || executeAndWait.getJSONObject() == null) {
                    throw new FacebookException("Cannot receive response.");
                } else if (executeAndWait.getError() == null) {
                    setPackageName(executeAndWait.getJSONObject(), context);
                    try {
                        currentAccessToken = setCurrentAccessToken(executeAndWait.getJSONObject());
                        GamingPayload.loadPayloadFromCloudGame(executeAndWait.getJSONObject().optString("payload"));
                        Profile.fetchProfileForCurrentAccessToken();
                        IS_RUNNING_IN_CLOUD = true;
                        mLogger.logLoginSuccess();
                    } catch (JSONException e) {
                        throw new FacebookException("Cannot properly handle response.", (Throwable) e);
                    }
                } else {
                    throw new FacebookException(executeAndWait.getError().getErrorMessage());
                }
            } else {
                throw new FacebookException("Not running in Cloud environment.");
            }
        }
        return currentAccessToken;
    }

    public static boolean isRunningInCloud() {
        return IS_RUNNING_IN_CLOUD;
    }

    private static boolean isCloudEnvReady(Context context, int i) {
        GraphResponse executeAndWait = DaemonRequest.executeAndWait(context, (JSONObject) null, SDKMessageEnum.IS_ENV_READY, i);
        if (executeAndWait == null || executeAndWait.getJSONObject() == null || executeAndWait.getError() != null) {
            return false;
        }
        return true;
    }

    public static void gameLoadComplete(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.MARK_GAME_LOADED);
    }

    private static void setPackageName(JSONObject jSONObject, Context context) {
        String optString = jSONObject.optString(SDKConstants.PARAM_DAEMON_PACKAGE_NAME);
        if (!optString.isEmpty()) {
            SharedPreferences.Editor edit = context.getSharedPreferences(SDKConstants.PREF_DAEMON_PACKAGE_NAME, 0).edit();
            edit.putString(SDKConstants.PARAM_DAEMON_PACKAGE_NAME, optString);
            edit.commit();
            return;
        }
        throw new FacebookException("Could not establish a secure connection.");
    }

    private static AccessToken setCurrentAccessToken(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject;
        String optString = jSONObject2.optString(SDKConstants.PARAM_ACCESS_TOKEN);
        String optString2 = jSONObject2.optString(SDKConstants.PARAM_ACCESS_TOKEN_SOURCE);
        String optString3 = jSONObject2.optString(SDKConstants.PARAM_APP_ID);
        String optString4 = jSONObject2.optString(SDKConstants.PARAM_DECLINED_PERMISSIONS);
        String optString5 = jSONObject2.optString(SDKConstants.PARAM_EXPIRED_PERMISSIONS);
        String optString6 = jSONObject2.optString(SDKConstants.PARAM_EXPIRATION_TIME);
        String optString7 = jSONObject2.optString(SDKConstants.PARAM_DATA_ACCESS_EXPIRATION_TIME);
        String optString8 = jSONObject2.optString(SDKConstants.PARAM_GRAPH_DOMAIN);
        String optString9 = jSONObject2.optString(SDKConstants.PARAM_LAST_REFRESH_TIME);
        String optString10 = jSONObject2.optString("permissions");
        String optString11 = jSONObject2.optString(SDKConstants.PARAM_USER_ID);
        String optString12 = jSONObject2.optString(SDKConstants.PARAM_SESSION_ID);
        String str = null;
        if (optString.isEmpty() || optString3.isEmpty() || optString11.isEmpty()) {
            return null;
        }
        SDKLogger sDKLogger = mLogger;
        if (sDKLogger != null) {
            sDKLogger.setAppID(optString3);
            mLogger.setUserID(optString11);
            mLogger.setSessionID(optString12);
        }
        List<String> convertPermissionsStringIntoPermissionsList = convertPermissionsStringIntoPermissionsList(optString10);
        List<String> convertPermissionsStringIntoPermissionsList2 = convertPermissionsStringIntoPermissionsList(optString4);
        List<String> convertPermissionsStringIntoPermissionsList3 = convertPermissionsStringIntoPermissionsList(optString5);
        AccessTokenSource valueOf = !optString2.isEmpty() ? AccessTokenSource.valueOf(optString2) : null;
        Date date = !optString6.isEmpty() ? new Date(((long) Integer.parseInt(optString6)) * 1000) : null;
        Date date2 = !optString9.isEmpty() ? new Date(((long) Integer.parseInt(optString9)) * 1000) : null;
        Date date3 = !optString7.isEmpty() ? new Date(((long) Integer.parseInt(optString7)) * 1000) : null;
        if (!optString8.isEmpty()) {
            str = optString8;
        }
        AccessToken accessToken = new AccessToken(optString, optString3, optString11, convertPermissionsStringIntoPermissionsList, convertPermissionsStringIntoPermissionsList2, convertPermissionsStringIntoPermissionsList3, valueOf, date, date2, date3, str);
        AccessToken.setCurrentAccessToken(accessToken);
        return accessToken;
    }

    private static List<String> convertPermissionsStringIntoPermissionsList(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (!str.isEmpty()) {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.get(i).toString());
            }
        }
        return arrayList;
    }
}
