package com.appsflyer.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\b\u0018\u00002\u00020\tB#\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005H×\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0001X\u0007¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0011\u0010\b\u001a\u00020\u0005X\u0007¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0007¢\u0006\u0006\n\u0004\b\b\u0010\u0007"}, d2 = {"Lcom/appsflyer/internal/AFd1uSDK;", "Lcom/appsflyer/internal/AFd1vSDK;", "valueOf", "Lcom/appsflyer/internal/AFd1vSDK;", "values", "", "AFInAppEventParameterName", "Ljava/lang/String;", "AFKeystoreWrapper", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/appsflyer/internal/AFd1vSDK;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AFd1uSDK {
    public final String AFInAppEventParameterName;
    public final String AFKeystoreWrapper;
    public final AFd1vSDK valueOf;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFd1uSDK)) {
            return false;
        }
        AFd1uSDK aFd1uSDK = (AFd1uSDK) obj;
        return Intrinsics.areEqual((Object) this.AFInAppEventParameterName, (Object) aFd1uSDK.AFInAppEventParameterName) && Intrinsics.areEqual((Object) this.AFKeystoreWrapper, (Object) aFd1uSDK.AFKeystoreWrapper) && this.valueOf == aFd1uSDK.valueOf;
    }

    public final int hashCode() {
        int hashCode = this.AFInAppEventParameterName.hashCode() * 31;
        String str = this.AFKeystoreWrapper;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.valueOf.hashCode();
    }

    public final String toString() {
        return new StringBuilder("AFd1uSDK(AFKeystoreWrapper=").append(this.AFInAppEventParameterName).append(", AFInAppEventParameterName=").append(this.AFKeystoreWrapper).append(", values=").append(this.valueOf).append(')').toString();
    }

    public AFd1uSDK(String str, String str2, AFd1vSDK aFd1vSDK) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(aFd1vSDK, "");
        this.AFInAppEventParameterName = str;
        this.AFKeystoreWrapper = str2;
        this.valueOf = aFd1vSDK;
    }
}
