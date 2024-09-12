package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzfi<V> {
    private static final Object zza = new Object();
    private final String zzb;
    private final zzfg<V> zzc;
    private final V zzd;
    private final V zze;
    private final Object zzf;
    private volatile V zzg;
    private volatile V zzh;

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: CFG modification limit reached, blocks count: 171 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0046 */
    public final V zza(V r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zzf
            monitor-enter(r0)
            monitor-exit(r0)     // Catch:{ all -> 0x006f }
            if (r4 == 0) goto L_0x0007
            return r4
        L_0x0007:
            com.google.android.gms.measurement.internal.zzae r4 = com.google.android.gms.measurement.internal.zzff.zza
            if (r4 != 0) goto L_0x000e
            V r4 = r3.zzd
            return r4
        L_0x000e:
            java.lang.Object r4 = zza
            monitor-enter(r4)
            boolean r0 = com.google.android.gms.measurement.internal.zzae.zza()     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0022
            V r0 = r3.zzh     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x001e
            V r0 = r3.zzd     // Catch:{ all -> 0x006a }
            goto L_0x0020
        L_0x001e:
            V r0 = r3.zzh     // Catch:{ all -> 0x006a }
        L_0x0020:
            monitor-exit(r4)     // Catch:{ all -> 0x006a }
            return r0
        L_0x0022:
            monitor-exit(r4)     // Catch:{ all -> 0x006a }
            java.util.List r4 = com.google.android.gms.measurement.internal.zzbi.zzcv     // Catch:{ SecurityException -> 0x0058 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ SecurityException -> 0x0058 }
        L_0x002b:
            boolean r0 = r4.hasNext()     // Catch:{ SecurityException -> 0x0058 }
            if (r0 == 0) goto L_0x0058
            java.lang.Object r0 = r4.next()     // Catch:{ SecurityException -> 0x0058 }
            com.google.android.gms.measurement.internal.zzfi r0 = (com.google.android.gms.measurement.internal.zzfi) r0     // Catch:{ SecurityException -> 0x0058 }
            boolean r1 = com.google.android.gms.measurement.internal.zzae.zza()     // Catch:{ SecurityException -> 0x0058 }
            if (r1 != 0) goto L_0x0050
            r1 = 0
            com.google.android.gms.measurement.internal.zzfg<V> r2 = r0.zzc     // Catch:{ IllegalStateException -> 0x0046 }
            if (r2 == 0) goto L_0x0046
            java.lang.Object r1 = r2.zza()     // Catch:{ IllegalStateException -> 0x0046 }
        L_0x0046:
            java.lang.Object r2 = zza     // Catch:{ SecurityException -> 0x0058 }
            monitor-enter(r2)     // Catch:{ SecurityException -> 0x0058 }
            r0.zzh = r1     // Catch:{ all -> 0x004d }
            monitor-exit(r2)     // Catch:{ all -> 0x004d }
            goto L_0x002b
        L_0x004d:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004d }
            throw r4     // Catch:{ SecurityException -> 0x0058 }
        L_0x0050:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ SecurityException -> 0x0058 }
            java.lang.String r0 = "Refreshing flag cache must be done on a worker thread."
            r4.<init>(r0)     // Catch:{ SecurityException -> 0x0058 }
            throw r4     // Catch:{ SecurityException -> 0x0058 }
        L_0x0058:
            com.google.android.gms.measurement.internal.zzfg<V> r4 = r3.zzc
            if (r4 != 0) goto L_0x005f
            V r4 = r3.zzd
            return r4
        L_0x005f:
            java.lang.Object r4 = r4.zza()     // Catch:{ SecurityException -> 0x0067, IllegalStateException -> 0x0064 }
            return r4
        L_0x0064:
            V r4 = r3.zzd
            return r4
        L_0x0067:
            V r4 = r3.zzd
            return r4
        L_0x006a:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x006a }
            throw r0
        L_0x006d:
            monitor-exit(r0)     // Catch:{ all -> 0x006f }
            throw r4
        L_0x006f:
            r4 = move-exception
            goto L_0x006d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfi.zza(java.lang.Object):java.lang.Object");
    }

    public final String zza() {
        return this.zzb;
    }

    private zzfi(String str, V v, V v2, zzfg<V> zzfg) {
        this.zzf = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zzb = str;
        this.zzd = v;
        this.zze = v2;
        this.zzc = zzfg;
    }
}
