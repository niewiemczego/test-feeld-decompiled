package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class GithubAuthProvider {
    public static final String GITHUB_SIGN_IN_METHOD = "github.com";
    public static final String PROVIDER_ID = "github.com";

    public static AuthCredential getCredential(String str) {
        return new GithubAuthCredential(str);
    }

    private GithubAuthProvider() {
    }
}
