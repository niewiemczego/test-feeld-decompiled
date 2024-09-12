package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import com.braze.Constants;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.bridge.UiThreadUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewHierarchyDumper {
    public static JSONObject toJSON(View view) throws JSONException {
        UiThreadUtil.assertOnUiThread();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.BRAZE_PUSH_CUSTOM_NOTIFICATION_ID, (Object) view.getClass().getName());
        jSONObject.put(ContextChain.TAG_INFRA, System.identityHashCode(view));
        Object tag = view.getTag();
        if (tag != null && (tag instanceof String)) {
            jSONObject.put(Constants.BRAZE_PUSH_TITLE_KEY, tag);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    jSONArray.put(i, (Object) toJSON(viewGroup.getChildAt(i)));
                }
                jSONObject.put("c", (Object) jSONArray);
            }
        }
        return jSONObject;
    }
}
