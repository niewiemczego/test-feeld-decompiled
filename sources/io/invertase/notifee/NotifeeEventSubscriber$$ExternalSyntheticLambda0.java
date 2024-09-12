package io.invertase.notifee;

import app.notifee.core.event.ForegroundServiceEvent;
import io.invertase.notifee.NotifeeReactUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotifeeEventSubscriber$$ExternalSyntheticLambda0 implements NotifeeReactUtils.GenericCallback {
    public final /* synthetic */ ForegroundServiceEvent f$0;

    public /* synthetic */ NotifeeEventSubscriber$$ExternalSyntheticLambda0(ForegroundServiceEvent foregroundServiceEvent) {
        this.f$0 = foregroundServiceEvent;
    }

    public final void call() {
        this.f$0.setCompletionResult();
    }
}
