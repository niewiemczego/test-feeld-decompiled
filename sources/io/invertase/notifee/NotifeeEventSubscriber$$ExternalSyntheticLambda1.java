package io.invertase.notifee;

import app.notifee.core.event.BlockStateEvent;
import io.invertase.notifee.NotifeeReactUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotifeeEventSubscriber$$ExternalSyntheticLambda1 implements NotifeeReactUtils.GenericCallback {
    public final /* synthetic */ BlockStateEvent f$0;

    public /* synthetic */ NotifeeEventSubscriber$$ExternalSyntheticLambda1(BlockStateEvent blockStateEvent) {
        this.f$0 = blockStateEvent;
    }

    public final void call() {
        this.f$0.setCompletionResult();
    }
}
