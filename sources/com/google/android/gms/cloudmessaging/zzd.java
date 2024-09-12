package com.google.android.gms.cloudmessaging;

import android.os.Build;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
public final class zzd extends ClassLoader {
    /* access modifiers changed from: protected */
    public final Class loadClass(String str, boolean z) throws ClassNotFoundException {
        if (str != "com.google.android.gms.iid.MessengerCompat" && (str == null || !str.equals("com.google.android.gms.iid.MessengerCompat"))) {
            return super.loadClass(str, z);
        }
        if (!Log.isLoggable("CloudMessengerCompat", 3) && (Build.VERSION.SDK_INT != 23 || !Log.isLoggable("CloudMessengerCompat", 3))) {
            return zze.class;
        }
        Log.d("CloudMessengerCompat", "Using renamed FirebaseIidMessengerCompat class");
        return zze.class;
    }
}
