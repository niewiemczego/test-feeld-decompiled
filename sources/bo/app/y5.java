package bo.app;

import com.braze.models.IPutIntoJson;
import kotlin.NoWhenBranchMatchedException;

public enum y5 implements IPutIntoJson {
    SUBSCRIBED,
    UNSUBSCRIBED;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                bo.app.y5[] r0 = bo.app.y5.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                bo.app.y5 r1 = bo.app.y5.SUBSCRIBED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                bo.app.y5 r1 = bo.app.y5.UNSUBSCRIBED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.y5.a.<clinit>():void");
        }
    }

    /* renamed from: v */
    public String forJsonPut() {
        int i = a.a[ordinal()];
        if (i == 1) {
            return "subscribed";
        }
        if (i == 2) {
            return "unsubscribed";
        }
        throw new NoWhenBranchMatchedException();
    }
}
