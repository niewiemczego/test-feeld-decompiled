package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class TwitterAuthProvider {
    public static final String PROVIDER_ID = "twitter.com";
    public static final String TWITTER_SIGN_IN_METHOD = "twitter.com";

    public static AuthCredential getCredential(String str, String str2) {
        return new TwitterAuthCredential(str, str2);
    }

    private TwitterAuthProvider() {
    }
}
