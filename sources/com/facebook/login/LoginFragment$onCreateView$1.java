package com.facebook.login;

import com.facebook.login.LoginClient;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/facebook/login/LoginFragment$onCreateView$1", "Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "onBackgroundProcessingStarted", "", "onBackgroundProcessingStopped", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginFragment.kt */
public final class LoginFragment$onCreateView$1 implements LoginClient.BackgroundProcessingListener {
    final /* synthetic */ LoginFragment this$0;

    LoginFragment$onCreateView$1(LoginFragment loginFragment) {
        this.this$0 = loginFragment;
    }

    public void onBackgroundProcessingStarted() {
        this.this$0.showSpinner();
    }

    public void onBackgroundProcessingStopped() {
        this.this$0.hideSpinner();
    }
}
