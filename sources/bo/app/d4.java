package bo.app;

import com.braze.models.outgoing.BrazeProperties;
import com.google.firebase.analytics.FirebaseAnalytics;

public class d4 extends m6 {
    private final String f;

    public d4(String str, BrazeProperties brazeProperties, x1 x1Var) {
        super(brazeProperties, x1Var);
        this.f = str;
    }

    public String d() {
        return FirebaseAnalytics.Event.PURCHASE;
    }

    public String f() {
        return this.f;
    }
}
