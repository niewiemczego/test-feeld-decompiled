package com.google.firebase.appcheck;

public abstract class AppCheckTokenResult {
    public abstract Exception getError();

    public abstract String getToken();
}
