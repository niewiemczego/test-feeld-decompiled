package com.appsflyer.internal;

import android.content.Context;

public final class AFe1eSDK extends AFa1sSDK {
    public final AFd1sSDK AFVersionDeclaration;

    @Deprecated
    public AFe1eSDK() {
        this.AFVersionDeclaration = null;
    }

    public AFe1eSDK(String str, byte[] bArr, String str2, AFd1sSDK aFd1sSDK) {
        super((String) null, str, Boolean.FALSE, (Context) null);
        this.afDebugLog = str2;
        AFKeystoreWrapper(bArr);
        this.AFVersionDeclaration = aFd1sSDK;
    }

    public final AFd1sSDK AFKeystoreWrapper() {
        AFd1sSDK aFd1sSDK = this.AFVersionDeclaration;
        if (aFd1sSDK != null) {
            return aFd1sSDK;
        }
        return AFd1sSDK.CACHED_EVENT;
    }
}
