package com.braze.reactbridge;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BrazeReactBridgeImpl.kt */
final class BrazeReactBridgeImpl$performInAppMessageAction$2$7 extends Lambda implements Function0<String> {
    final /* synthetic */ Uri $clickUri;
    final /* synthetic */ boolean $openUriInWebView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazeReactBridgeImpl$performInAppMessageAction$2$7(Uri uri, boolean z) {
        super(0);
        this.$clickUri = uri;
        this.$openUriInWebView = z;
    }

    public final String invoke() {
        Uri uri = this.$clickUri;
        return "Performing gotoUri " + uri + " " + this.$openUriInWebView;
    }
}
