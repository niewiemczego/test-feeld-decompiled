package com.appsflyer.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0010\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\nB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0001X\u0007¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0004"}, d2 = {"Lcom/appsflyer/internal/AFd1vSDK;", "", "valueOf", "Ljava/lang/String;", "AFInAppEventParameterName", "values", "AFInAppEventType", "p0", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum AFd1vSDK {
    API("api"),
    RC("rc"),
    DEFAULT("");
    
    public final String valueOf;

    private AFd1vSDK(String str) {
        this.valueOf = str;
    }
}
