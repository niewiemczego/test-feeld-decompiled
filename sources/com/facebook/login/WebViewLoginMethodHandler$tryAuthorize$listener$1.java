package com.facebook.login;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginClient;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/facebook/login/WebViewLoginMethodHandler$tryAuthorize$listener$1", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "onComplete", "", "values", "Landroid/os/Bundle;", "error", "Lcom/facebook/FacebookException;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: WebViewLoginMethodHandler.kt */
public final class WebViewLoginMethodHandler$tryAuthorize$listener$1 implements WebDialog.OnCompleteListener {
    final /* synthetic */ LoginClient.Request $request;
    final /* synthetic */ WebViewLoginMethodHandler this$0;

    WebViewLoginMethodHandler$tryAuthorize$listener$1(WebViewLoginMethodHandler webViewLoginMethodHandler, LoginClient.Request request) {
        this.this$0 = webViewLoginMethodHandler;
        this.$request = request;
    }

    public void onComplete(Bundle bundle, FacebookException facebookException) {
        this.this$0.onWebDialogComplete(this.$request, bundle, facebookException);
    }
}
