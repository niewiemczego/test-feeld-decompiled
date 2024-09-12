package com.appsflyer.internal;

public class AFc1eSDK {
    public final long AFInAppEventType;

    public AFc1eSDK(long j) {
        this.AFInAppEventType = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.AFInAppEventType == ((AFc1eSDK) obj).AFInAppEventType;
    }

    public int hashCode() {
        long j = this.AFInAppEventType;
        return (int) (j ^ (j >>> 32));
    }
}
