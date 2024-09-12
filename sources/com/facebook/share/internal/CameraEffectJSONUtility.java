package com.facebook.share.internal;

import com.facebook.share.model.CameraEffectArguments;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0007R2\u0010\u0003\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/share/internal/CameraEffectJSONUtility;", "", "()V", "SETTERS", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/facebook/share/internal/CameraEffectJSONUtility$Setter;", "Lkotlin/collections/HashMap;", "convertToCameraEffectArguments", "Lcom/facebook/share/model/CameraEffectArguments;", "jsonObject", "Lorg/json/JSONObject;", "convertToJSON", "arguments", "Setter", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CameraEffectJSONUtility.kt */
public final class CameraEffectJSONUtility {
    public static final CameraEffectJSONUtility INSTANCE = new CameraEffectJSONUtility();
    private static final HashMap<Class<?>, Setter> SETTERS = MapsKt.hashMapOf(TuplesKt.to(String.class, new CameraEffectJSONUtility$SETTERS$1()), TuplesKt.to(String[].class, new CameraEffectJSONUtility$SETTERS$2()), TuplesKt.to(JSONArray.class, new CameraEffectJSONUtility$SETTERS$3()));

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&J\"\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&¨\u0006\f"}, d2 = {"Lcom/facebook/share/internal/CameraEffectJSONUtility$Setter;", "", "setOnArgumentsBuilder", "", "builder", "Lcom/facebook/share/model/CameraEffectArguments$Builder;", "key", "", "value", "setOnJSON", "json", "Lorg/json/JSONObject;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CameraEffectJSONUtility.kt */
    private interface Setter {
        void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException;

        void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    private CameraEffectJSONUtility() {
    }

    @JvmStatic
    public static final JSONObject convertToJSON(CameraEffectArguments cameraEffectArguments) throws JSONException {
        if (cameraEffectArguments == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String next : cameraEffectArguments.keySet()) {
            Object obj = cameraEffectArguments.get(next);
            if (obj != null) {
                Setter setter = SETTERS.get(obj.getClass());
                if (setter != null) {
                    setter.setOnJSON(jSONObject, next, obj);
                } else {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("Unsupported type: ", obj.getClass()));
                }
            }
        }
        return jSONObject;
    }

    @JvmStatic
    public static final CameraEffectArguments convertToCameraEffectArguments(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        CameraEffectArguments.Builder builder = new CameraEffectArguments.Builder();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj != JSONObject.NULL) {
                Setter setter = SETTERS.get(obj.getClass());
                if (setter != null) {
                    Intrinsics.checkNotNullExpressionValue(next, "key");
                    setter.setOnArgumentsBuilder(builder, next, obj);
                } else {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("Unsupported type: ", obj.getClass()));
                }
            }
        }
        return builder.build();
    }
}
