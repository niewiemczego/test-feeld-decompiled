package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zze  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zze extends zzb {
    public final URLConnection zza(URL url, String str) throws IOException {
        return url.openConnection();
    }

    private zze() {
    }
}
