package com.braze.ui.actions.brazeactions.steps;

import com.braze.BrazeUser;
import com.braze.events.IValueCallback;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/braze/ui/actions/brazeactions/steps/BaseBrazeActionStep$Companion$runOnUser$1", "Lcom/braze/events/IValueCallback;", "Lcom/braze/BrazeUser;", "onError", "", "onSuccess", "value", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BaseBrazeActionStep.kt */
public final class BaseBrazeActionStep$Companion$runOnUser$1 implements IValueCallback<BrazeUser> {
    final /* synthetic */ Function1<BrazeUser, Unit> $block;

    BaseBrazeActionStep$Companion$runOnUser$1(Function1<? super BrazeUser, Unit> function1) {
        this.$block = function1;
    }

    public void onSuccess(BrazeUser brazeUser) {
        Intrinsics.checkNotNullParameter(brazeUser, "value");
        this.$block.invoke(brazeUser);
    }

    public void onError() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BaseBrazeActionStep$Companion$runOnUser$1$onError$1.INSTANCE, 3, (Object) null);
    }
}
