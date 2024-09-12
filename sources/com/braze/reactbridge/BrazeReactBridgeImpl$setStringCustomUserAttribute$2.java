package com.braze.reactbridge;

import com.braze.BrazeUser;
import com.braze.reactbridge.BrazeReactBridgeImpl;
import com.facebook.react.bridge.Callback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/braze/BrazeUser;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BrazeReactBridgeImpl.kt */
final class BrazeReactBridgeImpl$setStringCustomUserAttribute$2 extends Lambda implements Function1<BrazeUser, Unit> {
    final /* synthetic */ Callback $callback;
    final /* synthetic */ String $key;
    final /* synthetic */ String $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazeReactBridgeImpl$setStringCustomUserAttribute$2(Callback callback, String str, String str2) {
        super(1);
        this.$callback = callback;
        this.$key = str;
        this.$value = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BrazeUser) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BrazeUser brazeUser) {
        Intrinsics.checkNotNullParameter(brazeUser, "it");
        BrazeReactBridgeImpl.Companion.reportResult$default(BrazeReactBridgeImpl.Companion, this.$callback, Boolean.valueOf(brazeUser.setCustomUserAttribute(this.$key, this.$value)), (String) null, 2, (Object) null);
    }
}
