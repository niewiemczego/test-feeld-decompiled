package bo.app;

import com.braze.Constants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class i4 extends j {
    public static final a j = new a((DefaultConstructorMarker) null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i4 a(String str) {
            Intrinsics.checkNotNullParameter(str, "campaignId");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.BRAZE_PUSH_CAMPAIGN_ID_KEY, (Object) str);
            return new i4(h1.PUSH_CLICKED, jSONObject, (DefaultConstructorMarker) null);
        }

        private a() {
        }

        public final String a(x1 x1Var) {
            Intrinsics.checkNotNullParameter(x1Var, "event");
            String string = x1Var.q().getString(Constants.BRAZE_PUSH_CAMPAIGN_ID_KEY);
            Intrinsics.checkNotNullExpressionValue(string, "event.data.getString(IBrazeEvent.DATA_CAMPAIGN_ID)");
            return string;
        }
    }

    public /* synthetic */ i4(h1 h1Var, JSONObject jSONObject, DefaultConstructorMarker defaultConstructorMarker) {
        this(h1Var, jSONObject);
    }

    private i4(h1 h1Var, JSONObject jSONObject) {
        super(h1Var, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
    }
}
