package bo.app;

import com.braze.models.outgoing.BrazeProperties;

public abstract class m6 extends k6 implements w2 {
    private BrazeProperties e;

    protected m6(BrazeProperties brazeProperties, x1 x1Var) {
        super(x1Var);
        this.e = brazeProperties;
    }

    public BrazeProperties c() {
        return this.e;
    }
}
