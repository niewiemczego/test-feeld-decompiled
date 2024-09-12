package com.facebook.share.internal;

import com.facebook.share.internal.CameraEffectJSONUtility;
import com.facebook.share.model.CameraEffectArguments;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r"}, d2 = {"com/facebook/share/internal/CameraEffectJSONUtility$SETTERS$2", "Lcom/facebook/share/internal/CameraEffectJSONUtility$Setter;", "setOnArgumentsBuilder", "", "builder", "Lcom/facebook/share/model/CameraEffectArguments$Builder;", "key", "", "value", "", "setOnJSON", "json", "Lorg/json/JSONObject;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CameraEffectJSONUtility.kt */
public final class CameraEffectJSONUtility$SETTERS$2 implements CameraEffectJSONUtility.Setter {
    CameraEffectJSONUtility$SETTERS$2() {
    }

    public void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(str, "key");
        throw new IllegalArgumentException("Unexpected type from JSON");
    }

    public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        Intrinsics.checkNotNullParameter(str, "key");
        JSONArray jSONArray = new JSONArray();
        if (obj != null) {
            String[] strArr = (String[]) obj;
            int i = 0;
            int length = strArr.length;
            while (i < length) {
                String str2 = strArr[i];
                i++;
                jSONArray.put((Object) str2);
            }
            jSONObject.put(str, (Object) jSONArray);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String?>");
    }
}
