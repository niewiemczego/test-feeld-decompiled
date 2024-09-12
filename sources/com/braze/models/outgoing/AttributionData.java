package com.braze.models.outgoing;

import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB'\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/braze/models/outgoing/AttributionData;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "forJsonPut", "", "network", "Ljava/lang/String;", "campaign", "adGroup", "creative", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public final class AttributionData implements IPutIntoJson<JSONObject> {
    private static final String ADGROUP_KEY = "adgroup";
    private static final String CAMPAIGN_KEY = "campaign";
    private static final String CREATIVE_KEY = "ad";
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String NETWORK_KEY = "source";
    private final String adGroup;
    private final String campaign;
    private final String creative;
    private final String network;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception creating AttributionData Json.";
        }
    }

    public AttributionData(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "network");
        Intrinsics.checkNotNullParameter(str2, "campaign");
        Intrinsics.checkNotNullParameter(str3, "adGroup");
        Intrinsics.checkNotNullParameter(str4, "creative");
        this.network = str;
        this.campaign = str2;
        this.adGroup = str3;
        this.creative = str4;
    }

    public JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!StringsKt.isBlank(this.network)) {
                jSONObject.put("source", (Object) this.network);
            }
            if (!StringsKt.isBlank(this.campaign)) {
                jSONObject.put("campaign", (Object) this.campaign);
            }
            if (!StringsKt.isBlank(this.adGroup)) {
                jSONObject.put(ADGROUP_KEY, (Object) this.adGroup);
            }
            if (!StringsKt.isBlank(this.creative)) {
                jSONObject.put(CREATIVE_KEY, (Object) this.creative);
            }
        } catch (JSONException e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) b.b);
        }
        return jSONObject;
    }
}
