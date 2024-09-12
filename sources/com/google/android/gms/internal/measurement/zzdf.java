package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzgz;
import com.google.android.gms.measurement.internal.zzil;
import com.google.android.gms.measurement.internal.zzim;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
public class zzdf {
    private static volatile zzdf zzb;
    protected final Clock zza;
    /* access modifiers changed from: private */
    public final String zzc;
    private final ExecutorService zzd;
    private final AppMeasurementSdk zze;
    private final List<Pair<zzil, zzb>> zzf;
    private int zzg;
    /* access modifiers changed from: private */
    public boolean zzh;
    private String zzi;
    /* access modifiers changed from: private */
    public volatile zzcu zzj;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
    static class zzb extends zzcz {
        private final zzil zza;

        public final int zza() {
            return System.identityHashCode(this.zza);
        }

        zzb(zzil zzil) {
            this.zza = zzil;
        }

        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.onEvent(str, str2, bundle, j);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
    static class zzc extends zzcz {
        private final zzim zza;

        public final int zza() {
            return System.identityHashCode(this.zza);
        }

        zzc(zzim zzim) {
            this.zza = zzim;
        }

        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.interceptEvent(str, str2, bundle, j);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
    class zzd implements Application.ActivityLifecycleCallbacks {
        zzd() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzdf.this.zza((zza) new zzeo(this, bundle, activity));
        }

        public final void onActivityDestroyed(Activity activity) {
            zzdf.this.zza((zza) new zzet(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            zzdf.this.zza((zza) new zzes(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            zzdf.this.zza((zza) new zzep(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzcs zzcs = new zzcs();
            zzdf.this.zza((zza) new zzeu(this, activity, zzcs));
            Bundle zza2 = zzcs.zza(50);
            if (zza2 != null) {
                bundle.putAll(zza2);
            }
        }

        public final void onActivityStarted(Activity activity) {
            zzdf.this.zza((zza) new zzeq(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            zzdf.this.zza((zza) new zzer(this, activity));
        }
    }

    public final int zza(String str) {
        zzcs zzcs = new zzcs();
        zza((zza) new zzed(this, str, zzcs));
        Integer num = (Integer) zzcs.zza(zzcs.zza(10000), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
    abstract class zza implements Runnable {
        final long zza;
        final long zzb;
        private final boolean zzc;

        zza(zzdf zzdf) {
            this(true);
        }

        /* access modifiers changed from: package-private */
        public abstract void zza() throws RemoteException;

        /* access modifiers changed from: protected */
        public void zzb() {
        }

        zza(boolean z) {
            this.zza = zzdf.this.zza.currentTimeMillis();
            this.zzb = zzdf.this.zza.elapsedRealtime();
            this.zzc = z;
        }

        public void run() {
            if (zzdf.this.zzh) {
                zzb();
                return;
            }
            try {
                zza();
            } catch (Exception e) {
                zzdf.this.zza(e, false, this.zzc);
                zzb();
            }
        }
    }

    public final long zza() {
        zzcs zzcs = new zzcs();
        zza((zza) new zzdy(this, zzcs));
        Long zzb2 = zzcs.zzb(500);
        if (zzb2 != null) {
            return zzb2.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i = this.zzg + 1;
        this.zzg = i;
        return nextLong + ((long) i);
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zzcs zzcs = new zzcs();
        zza((zza) new zzeb(this, bundle, zzcs));
        if (z) {
            return zzcs.zza(5000);
        }
        return null;
    }

    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final zzcu zza(Context context, boolean z) {
        try {
            return zzct.asInterface(DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            zza((Exception) e, true, false);
            return null;
        }
    }

    public static zzdf zza(Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    public static zzdf zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzb == null) {
            synchronized (zzdf.class) {
                if (zzb == null) {
                    zzb = new zzdf(context, str, str2, str3, bundle);
                }
            }
        }
        return zzb;
    }

    public final Long zzc() {
        zzcs zzcs = new zzcs();
        zza((zza) new zzef(this, zzcs));
        return zzcs.zzb(120000);
    }

    public final Object zza(int i) {
        zzcs zzcs = new zzcs();
        zza((zza) new zzei(this, zzcs, i));
        return zzcs.zza(zzcs.zza((long) C.DEFAULT_SEEK_FORWARD_INCREMENT_MS), Object.class);
    }

    public final String zzd() {
        return this.zzi;
    }

    public final String zze() {
        zzcs zzcs = new zzcs();
        zza((zza) new zzeg(this, zzcs));
        return zzcs.zzc(120000);
    }

    public final String zzf() {
        zzcs zzcs = new zzcs();
        zza((zza) new zzdv(this, zzcs));
        return zzcs.zzc(50);
    }

    public final String zzg() {
        zzcs zzcs = new zzcs();
        zza((zza) new zzea(this, zzcs));
        return zzcs.zzc(500);
    }

    public final String zzh() {
        zzcs zzcs = new zzcs();
        zza((zza) new zzdx(this, zzcs));
        return zzcs.zzc(500);
    }

    public final String zzi() {
        zzcs zzcs = new zzcs();
        zza((zza) new zzdw(this, zzcs));
        return zzcs.zzc(500);
    }

    public final List<Bundle> zza(String str, String str2) {
        zzcs zzcs = new zzcs();
        zza((zza) new zzdj(this, str, str2, zzcs));
        List<Bundle> list = (List) zzcs.zza(zzcs.zza(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzcs zzcs = new zzcs();
        zza((zza) new zzdz(this, str, str2, z, zzcs));
        Bundle zza2 = zzcs.zza(5000);
        if (zza2 == null || zza2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zza2.size());
        for (String str3 : zza2.keySet()) {
            Object obj = zza2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    private zzdf(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzc(str2, str3)) {
            this.zzc = "FA";
        } else {
            this.zzc = str;
        }
        this.zza = DefaultClock.getInstance();
        this.zzd = zzch.zza().zza(new zzdr(this), zzcq.zza);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        boolean z = false;
        if (!(!zzb(context) || zzk())) {
            this.zzi = null;
            this.zzh = true;
            Log.w(this.zzc, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!zzc(str2, str3)) {
            this.zzi = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null ? true : z)) {
                    Log.w(this.zzc, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzc, "Deferring to Google Analytics for Firebase for event data collection. https://firebase.google.com/docs/analytics");
            }
        } else {
            this.zzi = str2;
        }
        zza((zza) new zzdi(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzc, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzd());
        }
    }

    /* access modifiers changed from: private */
    public final void zza(Exception exc, boolean z, boolean z2) {
        this.zzh |= z;
        if (z) {
            Log.w(this.zzc, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zza(5, "Error with data collection. Data lost.", (Object) exc, (Object) null, (Object) null);
        }
        Log.w(this.zzc, "Error with data collection. Data lost.", exc);
    }

    public final void zzb(String str) {
        zza((zza) new zzdu(this, str));
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza((zza) new zzdk(this, str, str2, bundle));
    }

    public final void zzc(String str) {
        zza((zza) new zzdt(this, str));
    }

    public final void zza(String str, Bundle bundle) {
        zza((String) null, str, bundle, false, true, (Long) null);
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, (Long) null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zza((zza) new zzel(this, l, str, str2, bundle, z, z2));
    }

    public final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zza((zza) new zzec(this, false, 5, str, obj, (Object) null, (Object) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r4.zzj == null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r4.zzj.registerOnMeasurementEventListener(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        android.util.Log.w(r4.zzc, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        zza((com.google.android.gms.internal.measurement.zzdf.zza) new com.google.android.gms.internal.measurement.zzej(r4, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.measurement.internal.zzil r5) {
        /*
            r4 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzil, com.google.android.gms.internal.measurement.zzdf$zzb>> r0 = r4.zzf
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzil, com.google.android.gms.internal.measurement.zzdf$zzb>> r2 = r4.zzf     // Catch:{ all -> 0x0055 }
            int r2 = r2.size()     // Catch:{ all -> 0x0055 }
            if (r1 >= r2) goto L_0x002b
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzil, com.google.android.gms.internal.measurement.zzdf$zzb>> r2 = r4.zzf     // Catch:{ all -> 0x0055 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0055 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0055 }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x0055 }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x0028
            java.lang.String r5 = r4.zzc     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = "OnEventListener already registered."
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return
        L_0x0028:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x002b:
            com.google.android.gms.internal.measurement.zzdf$zzb r1 = new com.google.android.gms.internal.measurement.zzdf$zzb     // Catch:{ all -> 0x0055 }
            r1.<init>(r5)     // Catch:{ all -> 0x0055 }
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzil, com.google.android.gms.internal.measurement.zzdf$zzb>> r2 = r4.zzf     // Catch:{ all -> 0x0055 }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ all -> 0x0055 }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x0055 }
            r2.add(r3)     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            com.google.android.gms.internal.measurement.zzcu r5 = r4.zzj
            if (r5 == 0) goto L_0x004c
            com.google.android.gms.internal.measurement.zzcu r5 = r4.zzj     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0045 }
            r5.registerOnMeasurementEventListener(r1)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0045 }
            return
        L_0x0045:
            java.lang.String r5 = r4.zzc
            java.lang.String r0 = "Failed to register event listener on calling thread. Trying again on the dynamite thread."
            android.util.Log.w(r5, r0)
        L_0x004c:
            com.google.android.gms.internal.measurement.zzej r5 = new com.google.android.gms.internal.measurement.zzej
            r5.<init>(r4, r1)
            r4.zza((com.google.android.gms.internal.measurement.zzdf.zza) r5)
            return
        L_0x0055:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzdf.zza(com.google.android.gms.measurement.internal.zzil):void");
    }

    public final void zzj() {
        zza((zza) new zzdp(this));
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        this.zzd.execute(zza2);
    }

    public final void zza(Bundle bundle) {
        zza((zza) new zzdh(this, bundle));
    }

    public final void zzb(Bundle bundle) {
        zza((zza) new zzdn(this, bundle));
    }

    public final void zzc(Bundle bundle) {
        zza((zza) new zzdq(this, bundle));
    }

    public final void zza(Activity activity, String str, String str2) {
        zza((zza) new zzdl(this, activity, str, str2));
    }

    public final void zza(boolean z) {
        zza((zza) new zzeh(this, z));
    }

    public final void zzd(Bundle bundle) {
        zza((zza) new zzek(this, bundle));
    }

    public final void zza(zzim zzim) {
        zzc zzc2 = new zzc(zzim);
        if (this.zzj != null) {
            try {
                this.zzj.setEventInterceptor(zzc2);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                Log.w(this.zzc, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        zza((zza) new zzee(this, zzc2));
    }

    public final void zza(Boolean bool) {
        zza((zza) new zzdo(this, bool));
    }

    public final void zza(long j) {
        zza((zza) new zzds(this, j));
    }

    public final void zzd(String str) {
        zza((zza) new zzdm(this, str));
    }

    public final void zzb(String str, String str2) {
        zza((String) null, str, (Object) str2, false);
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza((zza) new zzen(this, str, str2, obj, z));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r4.zzj == null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4.zzj.unregisterOnMeasurementEventListener(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        android.util.Log.w(r4.zzc, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        zza((com.google.android.gms.internal.measurement.zzdf.zza) new com.google.android.gms.internal.measurement.zzem(r4, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.measurement.internal.zzil r5) {
        /*
            r4 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzil, com.google.android.gms.internal.measurement.zzdf$zzb>> r0 = r4.zzf
            monitor-enter(r0)
            r1 = 0
            r2 = 0
        L_0x0008:
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzil, com.google.android.gms.internal.measurement.zzdf$zzb>> r3 = r4.zzf     // Catch:{ all -> 0x005c }
            int r3 = r3.size()     // Catch:{ all -> 0x005c }
            if (r2 >= r3) goto L_0x002d
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzil, com.google.android.gms.internal.measurement.zzdf$zzb>> r3 = r4.zzf     // Catch:{ all -> 0x005c }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x005c }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x005c }
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x005c }
            boolean r3 = r5.equals(r3)     // Catch:{ all -> 0x005c }
            if (r3 == 0) goto L_0x002a
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzil, com.google.android.gms.internal.measurement.zzdf$zzb>> r5 = r4.zzf     // Catch:{ all -> 0x005c }
            java.lang.Object r5 = r5.get(r2)     // Catch:{ all -> 0x005c }
            r1 = r5
            android.util.Pair r1 = (android.util.Pair) r1     // Catch:{ all -> 0x005c }
            goto L_0x002d
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x002d:
            if (r1 != 0) goto L_0x0038
            java.lang.String r5 = r4.zzc     // Catch:{ all -> 0x005c }
            java.lang.String r1 = "OnEventListener had not been registered."
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x005c }
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            return
        L_0x0038:
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzil, com.google.android.gms.internal.measurement.zzdf$zzb>> r5 = r4.zzf     // Catch:{ all -> 0x005c }
            r5.remove(r1)     // Catch:{ all -> 0x005c }
            java.lang.Object r5 = r1.second     // Catch:{ all -> 0x005c }
            com.google.android.gms.internal.measurement.zzdf$zzb r5 = (com.google.android.gms.internal.measurement.zzdf.zzb) r5     // Catch:{ all -> 0x005c }
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            com.google.android.gms.internal.measurement.zzcu r0 = r4.zzj
            if (r0 == 0) goto L_0x0053
            com.google.android.gms.internal.measurement.zzcu r0 = r4.zzj     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x004c }
            r0.unregisterOnMeasurementEventListener(r5)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x004c }
            return
        L_0x004c:
            java.lang.String r0 = r4.zzc
            java.lang.String r1 = "Failed to unregister event listener on calling thread. Trying again on the dynamite thread."
            android.util.Log.w(r0, r1)
        L_0x0053:
            com.google.android.gms.internal.measurement.zzem r0 = new com.google.android.gms.internal.measurement.zzem
            r0.<init>(r4, r5)
            r4.zza((com.google.android.gms.internal.measurement.zzdf.zza) r0)
            return
        L_0x005c:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzdf.zzb(com.google.android.gms.measurement.internal.zzil):void");
    }

    /* access modifiers changed from: private */
    public final boolean zzc(String str, String str2) {
        return (str2 == null || str == null || zzk()) ? false : true;
    }

    private final boolean zzk() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, getClass().getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean zzb(Context context) {
        try {
            if (new zzgz(context, zzgz.zza(context)).zza("google_app_id") != null) {
                return true;
            }
            return false;
        } catch (IllegalStateException unused) {
        }
    }
}
