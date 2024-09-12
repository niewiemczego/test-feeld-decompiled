package com.google.android.gms.dynamite;

/* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
public final class zzb {
    private static ClassLoader zza;
    private static Thread zzb;

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a1, code lost:
        if (r1 == null) goto L_0x00cc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.ClassLoader zza() {
        /*
            java.lang.Class<com.google.android.gms.dynamite.zzb> r0 = com.google.android.gms.dynamite.zzb.class
            monitor-enter(r0)
            java.lang.ClassLoader r1 = zza     // Catch:{ all -> 0x00d5 }
            if (r1 != 0) goto L_0x00d1
            java.lang.Thread r1 = zzb     // Catch:{ all -> 0x00d5 }
            r2 = 0
            if (r1 != 0) goto L_0x00a6
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x00d5 }
            java.lang.Thread r1 = r1.getThread()     // Catch:{ all -> 0x00d5 }
            java.lang.ThreadGroup r1 = r1.getThreadGroup()     // Catch:{ all -> 0x00d5 }
            if (r1 != 0) goto L_0x001d
            r1 = r2
            goto L_0x009f
        L_0x001d:
            java.lang.Class<java.lang.Void> r3 = java.lang.Void.class
            monitor-enter(r3)     // Catch:{ all -> 0x00d5 }
            int r4 = r1.activeGroupCount()     // Catch:{ SecurityException -> 0x0080 }
            java.lang.ThreadGroup[] r5 = new java.lang.ThreadGroup[r4]     // Catch:{ SecurityException -> 0x0080 }
            r1.enumerate(r5)     // Catch:{ SecurityException -> 0x0080 }
            r6 = 0
            r7 = r6
        L_0x002b:
            if (r7 >= r4) goto L_0x003f
            r8 = r5[r7]     // Catch:{ SecurityException -> 0x0080 }
            java.lang.String r9 = "dynamiteLoader"
            java.lang.String r10 = r8.getName()     // Catch:{ SecurityException -> 0x0080 }
            boolean r9 = r9.equals(r10)     // Catch:{ SecurityException -> 0x0080 }
            if (r9 == 0) goto L_0x003c
            goto L_0x0040
        L_0x003c:
            int r7 = r7 + 1
            goto L_0x002b
        L_0x003f:
            r8 = r2
        L_0x0040:
            if (r8 != 0) goto L_0x0049
            java.lang.ThreadGroup r8 = new java.lang.ThreadGroup     // Catch:{ SecurityException -> 0x0080 }
            java.lang.String r4 = "dynamiteLoader"
            r8.<init>(r1, r4)     // Catch:{ SecurityException -> 0x0080 }
        L_0x0049:
            int r1 = r8.activeCount()     // Catch:{ SecurityException -> 0x0080 }
            java.lang.Thread[] r4 = new java.lang.Thread[r1]     // Catch:{ SecurityException -> 0x0080 }
            r8.enumerate(r4)     // Catch:{ SecurityException -> 0x0080 }
        L_0x0052:
            if (r6 >= r1) goto L_0x0066
            r5 = r4[r6]     // Catch:{ SecurityException -> 0x0080 }
            java.lang.String r7 = "GmsDynamite"
            java.lang.String r9 = r5.getName()     // Catch:{ SecurityException -> 0x0080 }
            boolean r7 = r7.equals(r9)     // Catch:{ SecurityException -> 0x0080 }
            if (r7 == 0) goto L_0x0063
            goto L_0x0067
        L_0x0063:
            int r6 = r6 + 1
            goto L_0x0052
        L_0x0066:
            r5 = r2
        L_0x0067:
            if (r5 != 0) goto L_0x009d
            com.google.android.gms.dynamite.zza r1 = new com.google.android.gms.dynamite.zza     // Catch:{ SecurityException -> 0x007b }
            java.lang.String r4 = "GmsDynamite"
            r1.<init>(r8, r4)     // Catch:{ SecurityException -> 0x007b }
            r1.setContextClassLoader(r2)     // Catch:{ SecurityException -> 0x0078 }
            r1.start()     // Catch:{ SecurityException -> 0x0078 }
            r5 = r1
            goto L_0x009d
        L_0x0078:
            r4 = move-exception
            r5 = r1
            goto L_0x0083
        L_0x007b:
            r1 = move-exception
            r4 = r1
            goto L_0x0083
        L_0x007e:
            r1 = move-exception
            goto L_0x00a4
        L_0x0080:
            r1 = move-exception
            r4 = r1
            r5 = r2
        L_0x0083:
            java.lang.String r1 = "DynamiteLoaderV2CL"
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x007e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r6.<init>()     // Catch:{ all -> 0x007e }
            java.lang.String r7 = "Failed to enumerate thread/threadgroup "
            r6.append(r7)     // Catch:{ all -> 0x007e }
            r6.append(r4)     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x007e }
            android.util.Log.w(r1, r4)     // Catch:{ all -> 0x007e }
        L_0x009d:
            monitor-exit(r3)     // Catch:{ all -> 0x007e }
            r1 = r5
        L_0x009f:
            zzb = r1     // Catch:{ all -> 0x00d5 }
            if (r1 != 0) goto L_0x00a6
            goto L_0x00cc
        L_0x00a4:
            monitor-exit(r3)     // Catch:{ all -> 0x007e }
            throw r1     // Catch:{ all -> 0x00d5 }
        L_0x00a6:
            monitor-enter(r1)     // Catch:{ all -> 0x00d5 }
            java.lang.Thread r3 = zzb     // Catch:{ SecurityException -> 0x00b0 }
            java.lang.ClassLoader r2 = r3.getContextClassLoader()     // Catch:{ SecurityException -> 0x00b0 }
            goto L_0x00cb
        L_0x00ae:
            r2 = move-exception
            goto L_0x00cf
        L_0x00b0:
            r3 = move-exception
            java.lang.String r4 = "DynamiteLoaderV2CL"
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r5.<init>()     // Catch:{ all -> 0x00ae }
            java.lang.String r6 = "Failed to get thread context classloader "
            r5.append(r6)     // Catch:{ all -> 0x00ae }
            r5.append(r3)     // Catch:{ all -> 0x00ae }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00ae }
            android.util.Log.w(r4, r3)     // Catch:{ all -> 0x00ae }
        L_0x00cb:
            monitor-exit(r1)     // Catch:{ all -> 0x00ae }
        L_0x00cc:
            zza = r2     // Catch:{ all -> 0x00d5 }
            goto L_0x00d1
        L_0x00cf:
            monitor-exit(r1)     // Catch:{ all -> 0x00ae }
            throw r2     // Catch:{ all -> 0x00d5 }
        L_0x00d1:
            java.lang.ClassLoader r1 = zza     // Catch:{ all -> 0x00d5 }
            monitor-exit(r0)
            return r1
        L_0x00d5:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.zzb.zza():java.lang.ClassLoader");
    }
}
