package app.notifee.core.event;

import app.notifee.core.interfaces.MethodCallResult;
import app.notifee.core.model.NotificationModel;

public class ForegroundServiceEvent {
    public final NotificationModel a;
    public MethodCallResult<Void> b;
    public boolean c = false;

    public ForegroundServiceEvent(NotificationModel notificationModel, MethodCallResult<Void> methodCallResult) {
        this.a = notificationModel;
        this.b = methodCallResult;
    }

    public NotificationModel getNotification() {
        return this.a;
    }

    public void setCompletionResult() {
        if (!this.c) {
            this.c = true;
            this.b.onComplete((Exception) null, null);
        }
    }
}
