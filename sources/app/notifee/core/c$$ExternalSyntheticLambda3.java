package app.notifee.core;

import app.notifee.core.model.NotificationAndroidModel;
import app.notifee.core.model.NotificationModel;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class c$$ExternalSyntheticLambda3 implements Callable {
    public final /* synthetic */ NotificationAndroidModel f$0;
    public final /* synthetic */ NotificationModel f$1;

    public /* synthetic */ c$$ExternalSyntheticLambda3(NotificationAndroidModel notificationAndroidModel, NotificationModel notificationModel) {
        this.f$0 = notificationAndroidModel;
        this.f$1 = notificationModel;
    }

    public final Object call() {
        return c.a(this.f$0, this.f$1);
    }
}
