package bo.app;

import com.braze.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class f4 extends j {
    public static final a k = new a((DefaultConstructorMarker) null);
    private final boolean j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final x1 a(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "campaignId");
            Intrinsics.checkNotNullParameter(str2, "actionId");
            Intrinsics.checkNotNullParameter(str3, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.BRAZE_PUSH_CAMPAIGN_ID_KEY, (Object) str);
            jSONObject.put(Constants.BRAZE_PUSH_CONTENT_KEY, (Object) str2);
            return new f4(h1.PUSH_ACTION_BUTTON_CLICKED, jSONObject, str3, (DefaultConstructorMarker) null);
        }

        private a() {
        }
    }

    public /* synthetic */ f4(h1 h1Var, JSONObject jSONObject, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(h1Var, jSONObject, str);
    }

    public final boolean x() {
        return this.j;
    }

    private f4(h1 h1Var, JSONObject jSONObject, String str) {
        super(h1Var, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
        this.j = Intrinsics.areEqual((Object) str, (Object) Constants.BRAZE_PUSH_ACTION_TYPE_NONE);
    }
}
