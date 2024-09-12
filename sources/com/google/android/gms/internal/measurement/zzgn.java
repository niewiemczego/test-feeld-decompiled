package com.google.android.gms.internal.measurement;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public abstract class zzgn<T> {
    private static final Object zza = new Object();
    @Nullable
    private static volatile zzgu zzb = null;
    private static volatile boolean zzc = false;
    private static final AtomicReference<Collection<zzgn<?>>> zzd = new AtomicReference<>();
    private static zzgy zze = new zzgy(zzgo.zza);
    private static final AtomicInteger zzf = new AtomicInteger();
    private final zzgv zzg;
    private final String zzh;
    private final T zzi;
    private volatile int zzj;
    private volatile T zzk;
    private final boolean zzl;

    static /* synthetic */ boolean zzd() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(Object obj);

    static /* synthetic */ zzgn zza(zzgv zzgv, String str, Boolean bool, boolean z) {
        return new zzgq(zzgv, str, bool, true);
    }

    static /* synthetic */ zzgn zza(zzgv zzgv, String str, Double d, boolean z) {
        return new zzgt(zzgv, str, d, true);
    }

    static /* synthetic */ zzgn zza(zzgv zzgv, String str, Long l, boolean z) {
        return new zzgr(zzgv, str, l, true);
    }

    static /* synthetic */ zzgn zza(zzgv zzgv, String str, String str2, boolean z) {
        return new zzgs(zzgv, str, str2, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zza() {
        /*
            r8 = this;
            boolean r0 = r8.zzl
            if (r0 != 0) goto L_0x0011
            com.google.android.gms.internal.measurement.zzgy r0 = zze
            java.lang.String r1 = r8.zzh
            boolean r0 = r0.zza(r1)
            java.lang.String r1 = "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error."
            com.google.common.base.Preconditions.checkState(r0, r1)
        L_0x0011:
            java.util.concurrent.atomic.AtomicInteger r0 = zzf
            int r0 = r0.get()
            int r1 = r8.zzj
            if (r1 >= r0) goto L_0x0097
            monitor-enter(r8)
            int r1 = r8.zzj     // Catch:{ all -> 0x0094 }
            if (r1 >= r0) goto L_0x0092
            com.google.android.gms.internal.measurement.zzgu r1 = zzb     // Catch:{ all -> 0x0094 }
            com.google.common.base.Optional r2 = com.google.common.base.Optional.absent()     // Catch:{ all -> 0x0094 }
            r3 = 0
            if (r1 == 0) goto L_0x0051
            com.google.common.base.Supplier r2 = r1.zzb()     // Catch:{ all -> 0x0094 }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0094 }
            com.google.common.base.Optional r2 = (com.google.common.base.Optional) r2     // Catch:{ all -> 0x0094 }
            boolean r4 = r2.isPresent()     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x0051
            java.lang.Object r3 = r2.get()     // Catch:{ all -> 0x0094 }
            com.google.android.gms.internal.measurement.zzgh r3 = (com.google.android.gms.internal.measurement.zzgh) r3     // Catch:{ all -> 0x0094 }
            com.google.android.gms.internal.measurement.zzgv r4 = r8.zzg     // Catch:{ all -> 0x0094 }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x0094 }
            com.google.android.gms.internal.measurement.zzgv r5 = r8.zzg     // Catch:{ all -> 0x0094 }
            java.lang.String r5 = r5.zza     // Catch:{ all -> 0x0094 }
            com.google.android.gms.internal.measurement.zzgv r6 = r8.zzg     // Catch:{ all -> 0x0094 }
            java.lang.String r6 = r6.zzd     // Catch:{ all -> 0x0094 }
            java.lang.String r7 = r8.zzh     // Catch:{ all -> 0x0094 }
            java.lang.String r3 = r3.zza(r4, r5, r6, r7)     // Catch:{ all -> 0x0094 }
        L_0x0051:
            if (r1 == 0) goto L_0x0055
            r4 = 1
            goto L_0x0056
        L_0x0055:
            r4 = 0
        L_0x0056:
            java.lang.String r5 = "Must call PhenotypeFlagInitializer.maybeInit() first"
            com.google.common.base.Preconditions.checkState(r4, r5)     // Catch:{ all -> 0x0094 }
            com.google.android.gms.internal.measurement.zzgv r4 = r8.zzg     // Catch:{ all -> 0x0094 }
            boolean r4 = r4.zzf     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x006f
            java.lang.Object r4 = r8.zza((com.google.android.gms.internal.measurement.zzgu) r1)     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x0068
            goto L_0x007f
        L_0x0068:
            java.lang.Object r4 = r8.zzb((com.google.android.gms.internal.measurement.zzgu) r1)     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x007d
            goto L_0x007f
        L_0x006f:
            java.lang.Object r4 = r8.zzb((com.google.android.gms.internal.measurement.zzgu) r1)     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x0076
            goto L_0x007f
        L_0x0076:
            java.lang.Object r4 = r8.zza((com.google.android.gms.internal.measurement.zzgu) r1)     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x007d
            goto L_0x007f
        L_0x007d:
            T r4 = r8.zzi     // Catch:{ all -> 0x0094 }
        L_0x007f:
            boolean r1 = r2.isPresent()     // Catch:{ all -> 0x0094 }
            if (r1 == 0) goto L_0x008e
            if (r3 != 0) goto L_0x008a
            T r4 = r8.zzi     // Catch:{ all -> 0x0094 }
            goto L_0x008e
        L_0x008a:
            java.lang.Object r4 = r8.zza((java.lang.Object) r3)     // Catch:{ all -> 0x0094 }
        L_0x008e:
            r8.zzk = r4     // Catch:{ all -> 0x0094 }
            r8.zzj = r0     // Catch:{ all -> 0x0094 }
        L_0x0092:
            monitor-exit(r8)     // Catch:{ all -> 0x0094 }
            goto L_0x0097
        L_0x0094:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0094 }
            throw r0
        L_0x0097:
            T r0 = r8.zzk
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgn.zza():java.lang.Object");
    }

    @Nullable
    private final T zza(zzgu zzgu) {
        if (!this.zzg.zze && (this.zzg.zzh == null || this.zzg.zzh.apply(zzgu.zza()).booleanValue())) {
            Object zza2 = zzgg.zza(zzgu.zza()).zza(this.zzg.zze ? null : zza(this.zzg.zzc));
            if (zza2 != null) {
                return zza(zza2);
            }
        }
        return null;
    }

    @Nullable
    private final T zzb(zzgu zzgu) {
        zzgb zzgb;
        Object zza2;
        if (this.zzg.zzb == null) {
            zzgb = zzgw.zza(zzgu.zza(), this.zzg.zza, zzgm.zza);
        } else if (zzgl.zza(zzgu.zza(), this.zzg.zzb)) {
            zzgb = this.zzg.zzg ? zzfy.zza(zzgu.zza().getContentResolver(), zzgk.zza(zzgk.zza(zzgu.zza(), this.zzg.zzb.getLastPathSegment())), zzgm.zza) : zzfy.zza(zzgu.zza().getContentResolver(), this.zzg.zzb, zzgm.zza);
        } else {
            zzgb = null;
        }
        if (zzgb == null || (zza2 = zzgb.zza(zzb())) == null) {
            return null;
        }
        return zza(zza2);
    }

    public final String zzb() {
        return zza(this.zzg.zzd);
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzh;
        }
        return str + this.zzh;
    }

    private zzgn(zzgv zzgv, String str, T t, boolean z) {
        this.zzj = -1;
        if (zzgv.zza == null && zzgv.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        } else if (zzgv.zza == null || zzgv.zzb == null) {
            this.zzg = zzgv;
            this.zzh = str;
            this.zzi = t;
            this.zzl = z;
        } else {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
    }

    public static void zzc() {
        zzf.incrementAndGet();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static void zzb(android.content.Context r3) {
        /*
            com.google.android.gms.internal.measurement.zzgu r0 = zzb
            if (r0 != 0) goto L_0x004b
            if (r3 != 0) goto L_0x0007
            goto L_0x004b
        L_0x0007:
            java.lang.Object r0 = zza
            monitor-enter(r0)
            com.google.android.gms.internal.measurement.zzgu r1 = zzb     // Catch:{ all -> 0x0048 }
            if (r1 != 0) goto L_0x0046
            if (r3 == 0) goto L_0x0046
            monitor-enter(r0)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.measurement.zzgu r1 = zzb     // Catch:{ all -> 0x0043 }
            android.content.Context r2 = r3.getApplicationContext()     // Catch:{ all -> 0x0043 }
            if (r2 != 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r3 = r2
        L_0x001b:
            if (r1 == 0) goto L_0x0023
            android.content.Context r1 = r1.zza()     // Catch:{ all -> 0x0043 }
            if (r1 == r3) goto L_0x0041
        L_0x0023:
            com.google.android.gms.internal.measurement.zzfy.zzc()     // Catch:{ all -> 0x0043 }
            com.google.android.gms.internal.measurement.zzgw.zza()     // Catch:{ all -> 0x0043 }
            com.google.android.gms.internal.measurement.zzgg.zza()     // Catch:{ all -> 0x0043 }
            com.google.android.gms.internal.measurement.zzgp r1 = new com.google.android.gms.internal.measurement.zzgp     // Catch:{ all -> 0x0043 }
            r1.<init>(r3)     // Catch:{ all -> 0x0043 }
            com.google.common.base.Supplier r1 = com.google.common.base.Suppliers.memoize(r1)     // Catch:{ all -> 0x0043 }
            com.google.android.gms.internal.measurement.zzfv r2 = new com.google.android.gms.internal.measurement.zzfv     // Catch:{ all -> 0x0043 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0043 }
            zzb = r2     // Catch:{ all -> 0x0043 }
            java.util.concurrent.atomic.AtomicInteger r3 = zzf     // Catch:{ all -> 0x0043 }
            r3.incrementAndGet()     // Catch:{ all -> 0x0043 }
        L_0x0041:
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            goto L_0x0046
        L_0x0043:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            throw r3     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgn.zzb(android.content.Context):void");
    }
}
