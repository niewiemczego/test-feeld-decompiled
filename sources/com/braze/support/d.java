package com.braze.support;

import com.braze.models.FeatureFlag;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    public static final d a = new d();

    public static final class a extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Boolean a(int i) {
            return Boolean.valueOf(this.b.opt(i) instanceof JSONObject);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final class b extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Object a(int i) {
            Object obj = this.b.get(i);
            if (obj != null) {
                return (JSONObject) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
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
            return "Failed to deserialize feature flag Json: " + this.b;
        }
    }

    private d() {
    }

    public final List a(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "featureFlagsJson");
        ArrayList arrayList = new ArrayList();
        for (JSONObject a2 : SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(RangesKt.until(0, jSONArray.length())), new a(jSONArray)), new b(jSONArray))) {
            FeatureFlag a3 = a.a(a2);
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return arrayList;
    }

    public final FeatureFlag a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "featureFlagObject");
        try {
            String string = jSONObject.getString("id");
            Intrinsics.checkNotNullExpressionValue(string, "featureFlagObject.getString(FeatureFlag.ID)");
            boolean z = jSONObject.getBoolean("enabled");
            JSONObject optJSONObject = jSONObject.optJSONObject(FeatureFlag.PROPERTIES);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            return new FeatureFlag(string, z, optJSONObject, JsonUtils.getOptionalString(jSONObject, FeatureFlag.TRACKING_STRING));
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) new c(jSONObject));
            return null;
        }
    }
}
