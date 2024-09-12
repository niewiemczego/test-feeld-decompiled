package com.facebook.gamingservices;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenGamingMediaDialog implements GraphRequest.OnProgressCallback {
    private Context context;
    private GraphRequest.Callback nestedCallback;

    public OpenGamingMediaDialog(Context context2) {
        this(context2, (GraphRequest.Callback) null);
    }

    public OpenGamingMediaDialog(Context context2, GraphRequest.Callback callback) {
        this.context = context2;
        this.nestedCallback = callback;
    }

    public void onCompleted(GraphResponse graphResponse) {
        GraphRequest.Callback callback = this.nestedCallback;
        if (callback != null) {
            callback.onCompleted(graphResponse);
        }
        if (graphResponse != null && graphResponse.getError() == null) {
            String optString = graphResponse.getJSONObject().optString("id", (String) null);
            String optString2 = graphResponse.getJSONObject().optString("video_id", (String) null);
            if (optString != null || optString2 != null) {
                if (optString == null) {
                    optString = optString2;
                }
                if (CloudGameLoginHandler.isRunningInCloud()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", (Object) optString);
                        jSONObject.put(SDKConstants.PARAM_DEEP_LINK, (Object) "MEDIA_ASSET");
                        DaemonRequest.executeAsync(this.context, jSONObject, (DaemonRequest.Callback) null, SDKMessageEnum.OPEN_GAMING_SERVICES_DEEP_LINK);
                    } catch (JSONException unused) {
                    }
                } else {
                    this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://fb.gg/me/media_asset/" + optString)));
                }
            }
        }
    }

    public void onProgress(long j, long j2) {
        GraphRequest.Callback callback = this.nestedCallback;
        if (callback != null && (callback instanceof GraphRequest.OnProgressCallback)) {
            ((GraphRequest.OnProgressCallback) callback).onProgress(j, j2);
        }
    }
}
