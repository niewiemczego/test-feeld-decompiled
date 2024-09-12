package com.google.android.gms.cloudmessaging;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
public final /* synthetic */ class zzk implements Handler.Callback {
    public final /* synthetic */ zzn zza;

    public /* synthetic */ zzk(zzn zzn) {
        this.zza = zzn;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004f, code lost:
        r5 = r5.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        r2.zzc(new com.google.android.gms.cloudmessaging.zzs(4, "Not supported by GmsCore", (java.lang.Throwable) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
        r2.zza(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            java.lang.String r0 = "MessengerIpcClient"
            int r1 = r5.arg1
            r2 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r2)
            if (r0 == 0) goto L_0x0021
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Received response to request: "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "MessengerIpcClient"
            android.util.Log.d(r2, r0)
        L_0x0021:
            com.google.android.gms.cloudmessaging.zzn r0 = r4.zza
            monitor-enter(r0)
            android.util.SparseArray r2 = r0.zze     // Catch:{ all -> 0x006e }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x006e }
            com.google.android.gms.cloudmessaging.zzr r2 = (com.google.android.gms.cloudmessaging.zzr) r2     // Catch:{ all -> 0x006e }
            if (r2 != 0) goto L_0x0046
            java.lang.String r5 = "MessengerIpcClient"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            r2.<init>()     // Catch:{ all -> 0x006e }
            java.lang.String r3 = "Received response for unknown request: "
            r2.append(r3)     // Catch:{ all -> 0x006e }
            r2.append(r1)     // Catch:{ all -> 0x006e }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x006e }
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x006e }
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            goto L_0x006c
        L_0x0046:
            android.util.SparseArray r3 = r0.zze     // Catch:{ all -> 0x006e }
            r3.remove(r1)     // Catch:{ all -> 0x006e }
            r0.zzf()     // Catch:{ all -> 0x006e }
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            android.os.Bundle r5 = r5.getData()
            java.lang.String r0 = "unsupported"
            r1 = 0
            boolean r0 = r5.getBoolean(r0, r1)
            if (r0 == 0) goto L_0x0069
            java.lang.String r5 = "Not supported by GmsCore"
            com.google.android.gms.cloudmessaging.zzs r0 = new com.google.android.gms.cloudmessaging.zzs
            r1 = 4
            r3 = 0
            r0.<init>(r1, r5, r3)
            r2.zzc(r0)
            goto L_0x006c
        L_0x0069:
            r2.zza(r5)
        L_0x006c:
            r5 = 1
            return r5
        L_0x006e:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzk.handleMessage(android.os.Message):boolean");
    }
}
