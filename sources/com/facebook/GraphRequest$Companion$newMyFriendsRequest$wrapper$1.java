package com.facebook;

import com.facebook.GraphRequest;
import io.sentry.protocol.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/facebook/GraphRequest$Companion$newMyFriendsRequest$wrapper$1", "Lcom/facebook/GraphRequest$Callback;", "onCompleted", "", "response", "Lcom/facebook/GraphResponse;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GraphRequest.kt */
public final class GraphRequest$Companion$newMyFriendsRequest$wrapper$1 implements GraphRequest.Callback {
    final /* synthetic */ GraphRequest.GraphJSONArrayCallback $callback;

    GraphRequest$Companion$newMyFriendsRequest$wrapper$1(GraphRequest.GraphJSONArrayCallback graphJSONArrayCallback) {
        this.$callback = graphJSONArrayCallback;
    }

    public void onCompleted(GraphResponse graphResponse) {
        JSONArray jSONArray;
        Intrinsics.checkNotNullParameter(graphResponse, Response.TYPE);
        if (this.$callback != null) {
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (jSONObject == null) {
                jSONArray = null;
            } else {
                jSONArray = jSONObject.optJSONArray("data");
            }
            this.$callback.onCompleted(jSONArray, graphResponse);
        }
    }
}
