package com.braze.ui.inappmessage.jsinterface;

import com.braze.BrazeUser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/braze/BrazeUser;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InAppMessageUserJavascriptInterface.kt */
final class InAppMessageUserJavascriptInterface$setCustomUserAttributeJSON$1 extends Lambda implements Function1<BrazeUser, Unit> {
    final /* synthetic */ String $jsonStringValue;
    final /* synthetic */ String $key;
    final /* synthetic */ boolean $merge;
    final /* synthetic */ InAppMessageUserJavascriptInterface this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessageUserJavascriptInterface$setCustomUserAttributeJSON$1(InAppMessageUserJavascriptInterface inAppMessageUserJavascriptInterface, String str, String str2, boolean z) {
        super(1);
        this.this$0 = inAppMessageUserJavascriptInterface;
        this.$key = str;
        this.$jsonStringValue = str2;
        this.$merge = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BrazeUser) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BrazeUser brazeUser) {
        Intrinsics.checkNotNullParameter(brazeUser, "it");
        this.this$0.setCustomAttribute(brazeUser, this.$key, this.$jsonStringValue, this.$merge);
    }
}