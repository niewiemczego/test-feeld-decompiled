package com.facebook;

import com.facebook.AccessToken;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AccessTokenManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AccessTokenManager f$0;
    public final /* synthetic */ AccessToken.AccessTokenRefreshCallback f$1;

    public /* synthetic */ AccessTokenManager$$ExternalSyntheticLambda0(AccessTokenManager accessTokenManager, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        this.f$0 = accessTokenManager;
        this.f$1 = accessTokenRefreshCallback;
    }

    public final void run() {
        AccessTokenManager.m190refreshCurrentAccessToken$lambda0(this.f$0, this.f$1);
    }
}
