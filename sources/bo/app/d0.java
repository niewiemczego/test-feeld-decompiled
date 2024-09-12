package bo.app;

import com.braze.models.outgoing.BrazeProperties;

public class d0 extends m6 {
    private final String f;

    public d0(String str, BrazeProperties brazeProperties, x1 x1Var) {
        super(brazeProperties, x1Var);
        this.f = str;
    }

    public String d() {
        return "custom_event";
    }

    public String f() {
        return this.f;
    }
}
