package com.appsflyer.internal;

import java.util.Locale;

public enum AFf1uSDK {
    SUCCESS,
    FAILURE,
    NA,
    INTERNAL_ERROR;

    public final String toString() {
        return super.toString().toLowerCase(Locale.getDefault());
    }
}
