package com.braze.ui.actions.brazeactions.steps;

import com.braze.BrazeUser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/braze/BrazeUser;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SetCustomUserAttributeStep.kt */
final class SetCustomUserAttributeStep$run$1 extends Lambda implements Function1<BrazeUser, Unit> {
    final /* synthetic */ StepData $data;
    final /* synthetic */ Object $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SetCustomUserAttributeStep$run$1(StepData stepData, Object obj) {
        super(1);
        this.$data = stepData;
        this.$value = obj;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BrazeUser) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BrazeUser brazeUser) {
        Intrinsics.checkNotNullParameter(brazeUser, "it");
        BrazeUser.setCustomAttribute$default(brazeUser, String.valueOf(this.$data.getFirstArg()), this.$value, false, 4, (Object) null);
    }
}
