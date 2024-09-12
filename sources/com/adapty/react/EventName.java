package com.adapty.react;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/adapty/react/EventName;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ON_LATEST_PROFILE_LOAD", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdaptyConstants.kt */
public enum EventName {
    ON_LATEST_PROFILE_LOAD("onLatestProfileLoad");
    
    private final String value;

    private EventName(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
