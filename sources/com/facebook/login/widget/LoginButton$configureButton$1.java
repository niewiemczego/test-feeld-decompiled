package com.facebook.login.widget;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¨\u0006\u0007"}, d2 = {"com/facebook/login/widget/LoginButton$configureButton$1", "Lcom/facebook/AccessTokenTracker;", "onCurrentAccessTokenChanged", "", "oldAccessToken", "Lcom/facebook/AccessToken;", "currentAccessToken", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginButton.kt */
public final class LoginButton$configureButton$1 extends AccessTokenTracker {
    final /* synthetic */ LoginButton this$0;

    LoginButton$configureButton$1(LoginButton loginButton) {
        this.this$0 = loginButton;
    }

    /* access modifiers changed from: protected */
    public void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
        this.this$0.setButtonText();
        this.this$0.setButtonIcon();
    }
}
