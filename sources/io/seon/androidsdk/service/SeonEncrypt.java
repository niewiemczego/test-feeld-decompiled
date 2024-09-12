package io.seon.androidsdk.service;

import android.content.Context;
import android.util.Base64;
import java.security.SecureRandom;

class SeonEncrypt {
    private final Context a;
    private final JNIHandler b = new JNIHandler();

    SeonEncrypt(Context context) {
        this.a = context;
        if (context != null) {
            JNIHandler.loadLibrary(context);
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] a(String str, byte[] bArr) {
        byte[] bytes = str.getBytes();
        return Base64.encode(this.b.encrypt(this.a, bytes, bytes.length, bArr, 1), 2);
    }

    static byte[] a() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}
