package com.braze.support;

import com.braze.models.BrazeGeofence;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    public static final e a = new e();

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received null or blank geofence Json. Not parsing.";
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to deserialize geofence Json due to JSONException: " + this.b;
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to deserialize geofence Json:" + this.b;
        }
    }

    private e() {
    }

    public static final List a(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "geofenceJson");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                try {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) a, BrazeLogger.Priority.W, (Throwable) null, (Function0) a.b, 2, (Object) null);
                } catch (JSONException e) {
                    BrazeLogger.INSTANCE.brazelog((Object) a, BrazeLogger.Priority.W, (Throwable) e, (Function0<String>) new b(optJSONObject));
                } catch (Exception e2) {
                    BrazeLogger.INSTANCE.brazelog((Object) a, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new c(optJSONObject));
                }
            } else {
                arrayList.add(new BrazeGeofence(optJSONObject));
            }
        }
        return arrayList;
    }
}
