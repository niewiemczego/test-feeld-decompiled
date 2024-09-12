package bo.app;

import android.app.Activity;
import bo.app.y3;
import com.braze.models.IBrazeLocation;

public interface z1 {
    static /* synthetic */ void a(z1 z1Var, long j, long j2, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            z1Var.a(j, j2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? false : z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestContentCardsSync");
    }

    String a();

    void a(long j);

    void a(long j, long j2, int i, boolean z);

    void a(a2 a2Var);

    void a(b6 b6Var, u2 u2Var);

    void a(u2 u2Var);

    void a(y3.a aVar);

    void a(IBrazeLocation iBrazeLocation);

    void a(String str);

    void a(Throwable th);

    void a(boolean z);

    boolean a(x1 x1Var);

    void b(x1 x1Var);

    void b(String str);

    void b(Throwable th);

    void b(boolean z);

    boolean b();

    void c(boolean z);

    boolean c();

    void closeSession(Activity activity);

    void d();

    void e();

    void f();

    void g();

    void h();

    void openSession(Activity activity);

    void refreshFeatureFlags();

    static /* synthetic */ void a(z1 z1Var, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 0;
            }
            z1Var.a(j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: performPushDeliveryFlush");
    }
}
