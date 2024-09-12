package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzgc implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzfx zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzfy zzf;

    public zzgc(zzfy zzfy, String str, URL url, byte[] bArr, Map<String, String> map, zzfx zzfx) {
        this.zzf = zzfy;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzfx);
        this.zza = url;
        this.zzb = bArr;
        this.zzc = zzfx;
        this.zzd = str;
        this.zze = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ed A[SYNTHETIC, Splitter:B:47:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0128 A[SYNTHETIC, Splitter:B:59:0x0128] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            java.lang.String r0 = "Error closing HTTP compressed POST connection output stream. appId"
            com.google.android.gms.measurement.internal.zzfy r1 = r13.zzf
            r1.zzr()
            r1 = 0
            r2 = 0
            java.net.URL r3 = r13.zza     // Catch:{ IOException -> 0x0121, all -> 0x00e7 }
            com.google.android.gms.internal.measurement.zzcd r4 = com.google.android.gms.internal.measurement.zzcd.zza()     // Catch:{ IOException -> 0x0121, all -> 0x00e7 }
            java.lang.String r5 = "client-measurement"
            java.net.URLConnection r3 = r4.zza(r3, r5)     // Catch:{ IOException -> 0x0121, all -> 0x00e7 }
            boolean r4 = r3 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0121, all -> 0x00e7 }
            if (r4 == 0) goto L_0x00df
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x0121, all -> 0x00e7 }
            r3.setDefaultUseCaches(r1)     // Catch:{ IOException -> 0x0121, all -> 0x00e7 }
            r4 = 60000(0xea60, float:8.4078E-41)
            r3.setConnectTimeout(r4)     // Catch:{ IOException -> 0x0121, all -> 0x00e7 }
            r4 = 61000(0xee48, float:8.5479E-41)
            r3.setReadTimeout(r4)     // Catch:{ IOException -> 0x0121, all -> 0x00e7 }
            r3.setInstanceFollowRedirects(r1)     // Catch:{ IOException -> 0x0121, all -> 0x00e7 }
            r4 = 1
            r3.setDoInput(r4)     // Catch:{ IOException -> 0x0121, all -> 0x00e7 }
            java.util.Map<java.lang.String, java.lang.String> r5 = r13.zze     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            if (r5 == 0) goto L_0x0059
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
        L_0x003d:
            boolean r6 = r5.hasNext()     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            if (r6 == 0) goto L_0x0059
            java.lang.Object r6 = r5.next()     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            java.lang.Object r7 = r6.getKey()     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            java.lang.Object r6 = r6.getValue()     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            r3.addRequestProperty(r7, r6)     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            goto L_0x003d
        L_0x0059:
            byte[] r5 = r13.zzb     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            if (r5 == 0) goto L_0x00a6
            com.google.android.gms.measurement.internal.zzfy r5 = r13.zzf     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            com.google.android.gms.measurement.internal.zzmz r5 = r5.g_()     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            byte[] r6 = r13.zzb     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            byte[] r5 = r5.zzb((byte[]) r6)     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            com.google.android.gms.measurement.internal.zzfy r6 = r13.zzf     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzj()     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            com.google.android.gms.measurement.internal.zzft r6 = r6.zzp()     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            java.lang.String r7 = "Uploading data. size"
            int r8 = r5.length     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            r6.zza(r7, r8)     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            r3.setDoOutput(r4)     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            java.lang.String r4 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r3.addRequestProperty(r4, r6)     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            int r4 = r5.length     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            r3.setFixedLengthStreamingMode(r4)     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            r3.connect()     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            java.io.OutputStream r4 = r3.getOutputStream()     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            r4.write(r5)     // Catch:{ IOException -> 0x009f, all -> 0x0099 }
            r4.close()     // Catch:{ IOException -> 0x009f, all -> 0x0099 }
            goto L_0x00a6
        L_0x0099:
            r5 = move-exception
            r8 = r1
            r11 = r2
            r2 = r4
            r4 = r5
            goto L_0x00eb
        L_0x009f:
            r5 = move-exception
            r8 = r1
            r11 = r2
            r2 = r4
            r9 = r5
            goto L_0x0126
        L_0x00a6:
            int r8 = r3.getResponseCode()     // Catch:{ IOException -> 0x00db, all -> 0x00d7 }
            java.util.Map r11 = r3.getHeaderFields()     // Catch:{ IOException -> 0x00d5, all -> 0x00d3 }
            com.google.android.gms.measurement.internal.zzfy r1 = r13.zzf     // Catch:{ IOException -> 0x00d1, all -> 0x00cf }
            byte[] r10 = com.google.android.gms.measurement.internal.zzfy.zza(r3)     // Catch:{ IOException -> 0x00d1, all -> 0x00cf }
            if (r3 == 0) goto L_0x00b9
            r3.disconnect()
        L_0x00b9:
            com.google.android.gms.measurement.internal.zzfy r0 = r13.zzf
            com.google.android.gms.measurement.internal.zzgy r0 = r0.zzl()
            com.google.android.gms.measurement.internal.zzga r1 = new com.google.android.gms.measurement.internal.zzga
            java.lang.String r6 = r13.zzd
            com.google.android.gms.measurement.internal.zzfx r7 = r13.zzc
            r9 = 0
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.zzb((java.lang.Runnable) r1)
            return
        L_0x00cf:
            r4 = move-exception
            goto L_0x00eb
        L_0x00d1:
            r4 = move-exception
            goto L_0x0125
        L_0x00d3:
            r4 = move-exception
            goto L_0x00d9
        L_0x00d5:
            r4 = move-exception
            goto L_0x00dd
        L_0x00d7:
            r4 = move-exception
            r8 = r1
        L_0x00d9:
            r11 = r2
            goto L_0x00eb
        L_0x00db:
            r4 = move-exception
            r8 = r1
        L_0x00dd:
            r11 = r2
            goto L_0x0125
        L_0x00df:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x0121, all -> 0x00e7 }
            java.lang.String r4 = "Failed to obtain HTTP connection"
            r3.<init>(r4)     // Catch:{ IOException -> 0x0121, all -> 0x00e7 }
            throw r3     // Catch:{ IOException -> 0x0121, all -> 0x00e7 }
        L_0x00e7:
            r4 = move-exception
            r8 = r1
            r3 = r2
            r11 = r3
        L_0x00eb:
            if (r2 == 0) goto L_0x0105
            r2.close()     // Catch:{ IOException -> 0x00f1 }
            goto L_0x0105
        L_0x00f1:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzfy r2 = r13.zzf
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzj()
            com.google.android.gms.measurement.internal.zzft r2 = r2.zzg()
            java.lang.String r5 = r13.zzd
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r5)
            r2.zza(r0, r5, r1)
        L_0x0105:
            if (r3 == 0) goto L_0x010a
            r3.disconnect()
        L_0x010a:
            com.google.android.gms.measurement.internal.zzfy r0 = r13.zzf
            com.google.android.gms.measurement.internal.zzgy r0 = r0.zzl()
            com.google.android.gms.measurement.internal.zzga r1 = new com.google.android.gms.measurement.internal.zzga
            java.lang.String r6 = r13.zzd
            com.google.android.gms.measurement.internal.zzfx r7 = r13.zzc
            r9 = 0
            r10 = 0
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.zzb((java.lang.Runnable) r1)
            throw r4
        L_0x0121:
            r4 = move-exception
            r8 = r1
            r3 = r2
            r11 = r3
        L_0x0125:
            r9 = r4
        L_0x0126:
            if (r2 == 0) goto L_0x0140
            r2.close()     // Catch:{ IOException -> 0x012c }
            goto L_0x0140
        L_0x012c:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzfy r2 = r13.zzf
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzj()
            com.google.android.gms.measurement.internal.zzft r2 = r2.zzg()
            java.lang.String r4 = r13.zzd
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r4)
            r2.zza(r0, r4, r1)
        L_0x0140:
            if (r3 == 0) goto L_0x0145
            r3.disconnect()
        L_0x0145:
            com.google.android.gms.measurement.internal.zzfy r0 = r13.zzf
            com.google.android.gms.measurement.internal.zzgy r0 = r0.zzl()
            com.google.android.gms.measurement.internal.zzga r1 = new com.google.android.gms.measurement.internal.zzga
            java.lang.String r6 = r13.zzd
            com.google.android.gms.measurement.internal.zzfx r7 = r13.zzc
            r10 = 0
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.zzb((java.lang.Runnable) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgc.run():void");
    }
}
