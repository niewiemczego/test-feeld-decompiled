package com.braze.ui.actions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: UriAction.kt */
final class UriAction$execute$3 extends Lambda implements Function0<String> {
    final /* synthetic */ UriAction this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UriAction$execute$3(UriAction uriAction) {
        super(0);
        this.this$0 = uriAction;
    }

    public final String invoke() {
        return "Executing Uri action from channel " + this.this$0.getChannel() + ": " + this.this$0.getUri() + ". UseWebView: " + this.this$0.getUseWebView() + ". Extras: " + this.this$0.getExtras();
    }
}
