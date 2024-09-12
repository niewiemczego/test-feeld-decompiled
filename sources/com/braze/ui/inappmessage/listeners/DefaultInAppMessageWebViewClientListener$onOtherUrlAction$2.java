package com.braze.ui.inappmessage.listeners;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultInAppMessageWebViewClientListener.kt */
final class DefaultInAppMessageWebViewClientListener$onOtherUrlAction$2 extends Lambda implements Function0<String> {
    final /* synthetic */ String $url;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultInAppMessageWebViewClientListener$onOtherUrlAction$2(String str) {
        super(0);
        this.$url = str;
    }

    public final String invoke() {
        return "Can't perform other url action because the cached activity is null. Url: " + this.$url;
    }
}
