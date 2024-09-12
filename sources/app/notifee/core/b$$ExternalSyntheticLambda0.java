package app.notifee.core;

import android.os.Bundle;
import app.notifee.core.model.NotificationModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import n.o.t.i.f.e.e.q;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class b$$ExternalSyntheticLambda0 implements OnCompleteListener {
    public final /* synthetic */ Bundle f$0;
    public final /* synthetic */ NotificationModel f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ q f$3;

    public /* synthetic */ b$$ExternalSyntheticLambda0(Bundle bundle, NotificationModel notificationModel, String str, q qVar) {
        this.f$0 = bundle;
        this.f$1 = notificationModel;
        this.f$2 = str;
        this.f$3 = qVar;
    }

    public final void onComplete(Task task) {
        b.a(this.f$0, this.f$1, this.f$2, this.f$3, task);
    }
}
