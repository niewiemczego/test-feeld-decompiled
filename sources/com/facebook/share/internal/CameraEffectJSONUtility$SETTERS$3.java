package com.facebook.share.internal;

import com.facebook.share.internal.CameraEffectJSONUtility;
import com.facebook.share.model.CameraEffectArguments;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r"}, d2 = {"com/facebook/share/internal/CameraEffectJSONUtility$SETTERS$3", "Lcom/facebook/share/internal/CameraEffectJSONUtility$Setter;", "setOnArgumentsBuilder", "", "builder", "Lcom/facebook/share/model/CameraEffectArguments$Builder;", "key", "", "value", "", "setOnJSON", "json", "Lorg/json/JSONObject;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CameraEffectJSONUtility.kt */
public final class CameraEffectJSONUtility$SETTERS$3 implements CameraEffectJSONUtility.Setter {
    CameraEffectJSONUtility$SETTERS$3() {
    }

    public void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(str, "key");
        if (obj != null) {
            JSONArray jSONArray = (JSONArray) obj;
            List arrayList = new ArrayList();
            int length = jSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    Object obj2 = jSONArray.get(i);
                    if (obj2 instanceof String) {
                        arrayList.add(obj2);
                        if (i2 >= length) {
                            break;
                        }
                        i = i2;
                    } else {
                        throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected type in an array: ", obj2.getClass()));
                    }
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                builder.putArgument(str, (String[]) array);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
    }

    public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        Intrinsics.checkNotNullParameter(str, "key");
        throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
    }
}
