package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class FacebookAuthProvider {
    public static final String FACEBOOK_SIGN_IN_METHOD = "facebook.com";
    public static final String PROVIDER_ID = "facebook.com";

    public static AuthCredential getCredential(String str) {
        return new FacebookAuthCredential(str);
    }

    private FacebookAuthProvider() {
    }
}
