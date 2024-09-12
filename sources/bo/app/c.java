package bo.app;

import java.util.List;

public final class c extends k3 {
    public c(List list) {
        super(list);
    }

    public boolean a(u2 u2Var) {
        boolean z = false;
        for (c2 a : this.b) {
            if (!a.a(u2Var)) {
                return false;
            }
            z = true;
        }
        return z;
    }
}
