package com.braze.ui.actions.brazeactions.steps;

import com.braze.BrazeUser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/braze/BrazeUser;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AddToSubscriptionGroupStep.kt */
final class AddToSubscriptionGroupStep$run$1 extends Lambda implements Function1<BrazeUser, Unit> {
    final /* synthetic */ String $subscriptionGroupId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddToSubscriptionGroupStep$run$1(String str) {
        super(1);
        this.$subscriptionGroupId = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BrazeUser) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BrazeUser brazeUser) {
        Intrinsics.checkNotNullParameter(brazeUser, "it");
        brazeUser.addToSubscriptionGroup(this.$subscriptionGroupId);
    }
}
