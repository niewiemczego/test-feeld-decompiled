package io.seon.androidsdk.service;

import android.content.Context;
import com.getkeepsafe.relinker.ReLinker;

class JNIHandler {
    private static boolean libraryLoaded = false;

    JNIHandler() {
    }

    static void loadLibrary(Context context) {
        if (!libraryLoaded) {
            ReLinker.loadLibrary(context, "seon");
            libraryLoaded = true;
        }
    }

    /* access modifiers changed from: package-private */
    public native byte[] encrypt(Object obj, byte[] bArr, int i, byte[] bArr2, int i2);

    /* access modifiers changed from: package-private */
    public native String getDevUrl(Object obj);

    /* access modifiers changed from: package-private */
    public native String getProdUrl(Object obj);
}
