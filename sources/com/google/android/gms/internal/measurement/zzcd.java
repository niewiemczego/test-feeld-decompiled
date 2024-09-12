package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public abstract class zzcd {
    private static zzcd zza = new zzcg();

    public static synchronized zzcd zza() {
        zzcd zzcd;
        synchronized (zzcd.class) {
            zzcd = zza;
        }
        return zzcd;
    }

    public abstract URLConnection zza(URL url, String str) throws IOException;
}
