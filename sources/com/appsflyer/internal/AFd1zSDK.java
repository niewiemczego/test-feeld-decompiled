package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;

public final class AFd1zSDK {
    final String AFInAppEventType;
    final String values;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFd1zSDK)) {
            return false;
        }
        AFd1zSDK aFd1zSDK = (AFd1zSDK) obj;
        return Intrinsics.areEqual((Object) this.values, (Object) aFd1zSDK.values) && Intrinsics.areEqual((Object) this.AFInAppEventType, (Object) aFd1zSDK.AFInAppEventType);
    }

    public final int hashCode() {
        return (this.values.hashCode() * 31) + this.AFInAppEventType.hashCode();
    }

    public final String toString() {
        return new StringBuilder("HostConfig(prefix=").append(this.values).append(", host=").append(this.AFInAppEventType).append(')').toString();
    }

    public AFd1zSDK(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.values = str;
        this.AFInAppEventType = str2;
    }
}
