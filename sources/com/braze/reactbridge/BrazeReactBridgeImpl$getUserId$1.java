package com.braze.reactbridge;

import com.braze.BrazeUser;
import com.braze.reactbridge.BrazeReactBridgeImpl;
import com.facebook.react.bridge.Callback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/braze/BrazeUser;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BrazeReactBridgeImpl.kt */
final class BrazeReactBridgeImpl$getUserId$1 extends Lambda implements Function1<BrazeUser, Unit> {
    final /* synthetic */ Callback $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazeReactBridgeImpl$getUserId$1(Callback callback) {
        super(1);
        this.$callback = callback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BrazeUser) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BrazeUser brazeUser) {
        Intrinsics.checkNotNullParameter(brazeUser, "it");
        CharSequence userId = brazeUser.getUserId();
        if (userId == null || StringsKt.isBlank(userId)) {
            BrazeReactBridgeImpl.Companion.reportResult(this.$callback, (Object) null, "User ID not found.");
        } else {
            BrazeReactBridgeImpl.Companion.reportResult$default(BrazeReactBridgeImpl.Companion, this.$callback, brazeUser.getUserId(), (String) null, 2, (Object) null);
        }
    }
}
