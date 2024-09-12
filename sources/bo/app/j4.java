package bo.app;

import com.braze.Constants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class j4 extends j {
    private j4(h1 h1Var, JSONObject jSONObject, double d) {
        super(h1Var, jSONObject, d, (String) null, 8, (DefaultConstructorMarker) null);
    }

    public final String x() {
        String string = q().getString(Constants.BRAZE_PUSH_CAMPAIGN_ID_KEY);
        Intrinsics.checkNotNullExpressionValue(string, "data.getString(IBrazeEvent.DATA_CAMPAIGN_ID)");
        return string;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public j4(java.lang.String r4, long r5) {
        /*
            r3 = this;
            java.lang.String r0 = "campaignId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            bo.app.h1 r0 = bo.app.h1.PUSH_DELIVERY_EVENT
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "cid"
            org.json.JSONObject r4 = r1.put((java.lang.String) r2, (java.lang.Object) r4)
            java.lang.String r1 = "JSONObject().put(IBrazeE…_CAMPAIGN_ID, campaignId)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            double r5 = (double) r5
            r3.<init>(r0, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.j4.<init>(java.lang.String, long):void");
    }
}
