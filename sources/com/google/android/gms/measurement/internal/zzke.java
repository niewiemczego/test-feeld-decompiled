package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzke implements Runnable {
    private final URL zza;
    private final byte[] zzb = null;
    private final zzkb zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzkc zzf;

    public zzke(zzkc zzkc, String str, URL url, byte[] bArr, Map<String, String> map, zzkb zzkb) {
        this.zzf = zzkc;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzkb);
        this.zza = url;
        this.zzc = zzkb;
        this.zzd = str;
        this.zze = null;
    }

    private final void zzb(int i, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.zzf.zzl().zzb((Runnable) new zzkd(this, i, exc, bArr, map));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzc.zza(this.zzd, i, exc, bArr, map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            com.google.android.gms.measurement.internal.zzkc r0 = r5.zzf
            r0.zzr()
            r0 = 0
            r1 = 0
            java.net.URL r2 = r5.zza     // Catch:{ IOException -> 0x0064, all -> 0x0058 }
            com.google.android.gms.internal.measurement.zzcd r3 = com.google.android.gms.internal.measurement.zzcd.zza()     // Catch:{ IOException -> 0x0064, all -> 0x0058 }
            java.lang.String r4 = "client-measurement"
            java.net.URLConnection r2 = r3.zza(r2, r4)     // Catch:{ IOException -> 0x0064, all -> 0x0058 }
            boolean r3 = r2 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0064, all -> 0x0058 }
            if (r3 == 0) goto L_0x0050
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x0064, all -> 0x0058 }
            r2.setDefaultUseCaches(r0)     // Catch:{ IOException -> 0x0064, all -> 0x0058 }
            r3 = 60000(0xea60, float:8.4078E-41)
            r2.setConnectTimeout(r3)     // Catch:{ IOException -> 0x0064, all -> 0x0058 }
            r3 = 61000(0xee48, float:8.5479E-41)
            r2.setReadTimeout(r3)     // Catch:{ IOException -> 0x0064, all -> 0x0058 }
            r2.setInstanceFollowRedirects(r0)     // Catch:{ IOException -> 0x0064, all -> 0x0058 }
            r3 = 1
            r2.setDoInput(r3)     // Catch:{ IOException -> 0x0064, all -> 0x0058 }
            int r0 = r2.getResponseCode()     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            java.util.Map r3 = r2.getHeaderFields()     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            com.google.android.gms.measurement.internal.zzkc r4 = r5.zzf     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            byte[] r4 = com.google.android.gms.measurement.internal.zzkc.zza(r2)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            if (r2 == 0) goto L_0x0042
            r2.disconnect()
        L_0x0042:
            r5.zzb(r0, r1, r4, r3)
            return
        L_0x0046:
            r4 = move-exception
            goto L_0x005b
        L_0x0048:
            r4 = move-exception
            goto L_0x0067
        L_0x004a:
            r4 = move-exception
            r3 = r1
            goto L_0x005b
        L_0x004d:
            r4 = move-exception
            r3 = r1
            goto L_0x0067
        L_0x0050:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x0064, all -> 0x0058 }
            java.lang.String r3 = "Failed to obtain HTTP connection"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0064, all -> 0x0058 }
            throw r2     // Catch:{ IOException -> 0x0064, all -> 0x0058 }
        L_0x0058:
            r4 = move-exception
            r2 = r1
            r3 = r2
        L_0x005b:
            if (r2 == 0) goto L_0x0060
            r2.disconnect()
        L_0x0060:
            r5.zzb(r0, r1, r1, r3)
            throw r4
        L_0x0064:
            r4 = move-exception
            r2 = r1
            r3 = r2
        L_0x0067:
            if (r2 == 0) goto L_0x006c
            r2.disconnect()
        L_0x006c:
            r5.zzb(r0, r4, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzke.run():void");
    }
}
