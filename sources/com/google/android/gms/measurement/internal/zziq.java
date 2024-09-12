package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.facebook.internal.ServerProtocol;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zznp;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zzoh;
import com.google.android.gms.internal.measurement.zzoi;
import com.google.android.gms.internal.measurement.zzpg;
import com.google.android.gms.internal.measurement.zzps;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzih;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.protocol.App;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zziq extends zze {
    protected zzjx zza;
    final zzu zzb;
    private zzim zzc;
    private final Set<zzil> zzd = new CopyOnWriteArraySet();
    private boolean zze;
    private final AtomicReference<String> zzf = new AtomicReference<>();
    private final Object zzg = new Object();
    /* access modifiers changed from: private */
    public boolean zzh = false;
    private PriorityQueue<zzmh> zzi;
    private zzih zzj = zzih.zza;
    private final AtomicLong zzk = new AtomicLong(0);
    private long zzl = -1;
    private boolean zzm = true;
    /* access modifiers changed from: private */
    public zzaw zzn;
    private final zznf zzo = new zzjp(this);

    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public final /* bridge */ /* synthetic */ zzb zzc() {
        return super.zzc();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzae zzd() {
        return super.zzd();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzaf zze() {
        return super.zze();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzba zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzfl zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzfo zzh() {
        return super.zzh();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzfq zzi() {
        return super.zzi();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzfr zzj() {
        return super.zzj();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzgd zzk() {
        return super.zzk();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzgy zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ zziq zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzkh zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkp zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzlx zzp() {
        return super.zzp();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zznd zzq() {
        return super.zzq();
    }

    public final Boolean zzaa() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzl().zza(atomicReference, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, "boolean test flag value", new zzja(this, atomicReference));
    }

    public final Double zzab() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzl().zza(atomicReference, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, "double test flag value", new zzju(this, atomicReference));
    }

    public final Integer zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzl().zza(atomicReference, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, "int test flag value", new zzjr(this, atomicReference));
    }

    public final Long zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzl().zza(atomicReference, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, "long test flag value", new zzjs(this, atomicReference));
    }

    public final String zzae() {
        return this.zzf.get();
    }

    public final String zzaf() {
        zzki zzaa = this.zzu.zzq().zzaa();
        if (zzaa != null) {
            return zzaa.zzb;
        }
        return null;
    }

    public final String zzag() {
        zzki zzaa = this.zzu.zzq().zzaa();
        if (zzaa != null) {
            return zzaa.zza;
        }
        return null;
    }

    public final String zzah() {
        if (this.zzu.zzu() != null) {
            return this.zzu.zzu();
        }
        try {
            return new zzgz(zza(), this.zzu.zzx()).zza("google_app_id");
        } catch (IllegalStateException e) {
            this.zzu.zzj().zzg().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public final String zzai() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzl().zza(atomicReference, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, "String test flag value", new zzjj(this, atomicReference));
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzae.zza()) {
            zzj().zzg().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzl().zza(atomicReference, 5000, "get conditional user properties", new zzjo(this, atomicReference, (String) null, str, str2));
            List list = (List) atomicReference.get();
            if (list != null) {
                return zznd.zzb((List<zzad>) list);
            }
            zzj().zzg().zza("Timed out waiting for get conditional user properties", (Object) null);
            return new ArrayList<>();
        }
    }

    public final List<zznc> zza(boolean z) {
        zzu();
        zzj().zzp().zza("Getting user properties (FE)");
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzae.zza()) {
            zzj().zzg().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzl().zza(atomicReference, 5000, "get user properties", new zzji(this, atomicReference, z));
            List<zznc> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzj().zzg().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzae.zza()) {
            zzj().zzg().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzl().zza(atomicReference, 5000, "get user properties", new zzjn(this, atomicReference, (String) null, str, str2, z));
            List<zznc> list = (List) atomicReference.get();
            if (list == null) {
                zzj().zzg().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zznc zznc : list) {
                Object zza2 = zznc.zza();
                if (zza2 != null) {
                    arrayMap.put(zznc.zza, zza2);
                }
            }
            return arrayMap;
        }
    }

    private final PriorityQueue<zzmh> zzao() {
        if (this.zzi == null) {
            this.zzi = new PriorityQueue<>(Comparator.comparing(zzip.zza, zzis.zza));
        }
        return this.zzi;
    }

    static /* synthetic */ void zza(zziq zziq, zzih zzih, zzih zzih2) {
        boolean zza2 = zzih.zza(zzih2, zzih.zza.ANALYTICS_STORAGE, zzih.zza.AD_STORAGE);
        boolean zzb2 = zzih.zzb(zzih2, zzih.zza.ANALYTICS_STORAGE, zzih.zza.AD_STORAGE);
        if (zza2 || zzb2) {
            zziq.zzg().zzag();
        }
    }

    static /* synthetic */ void zza(zziq zziq, zzih zzih, long j, boolean z, boolean z2) {
        zziq.zzt();
        zziq.zzu();
        zzih zzm2 = zziq.zzk().zzm();
        if (j <= zziq.zzl && zzih.zza(zzm2.zza(), zzih.zza())) {
            zziq.zzj().zzn().zza("Dropped out-of-date consent setting, proposed settings", zzih);
        } else if (zziq.zzk().zza(zzih)) {
            zziq.zzl = j;
            zziq.zzo().zza(z);
            if (z2) {
                zziq.zzo().zza((AtomicReference<String>) new AtomicReference());
            }
        } else {
            zziq.zzj().zzn().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzih.zza()));
        }
    }

    protected zziq(zzhf zzhf) {
        super(zzhf);
        this.zzb = new zzu(zzhf);
    }

    public final void zzaj() {
        zzt();
        zzu();
        if (this.zzu.zzaf()) {
            if (zze().zza(zzbi.zzbh)) {
                Boolean zzg2 = zze().zzg("google_analytics_deferred_deep_link_enabled");
                if (zzg2 != null && zzg2.booleanValue()) {
                    zzj().zzc().zza("Deferred Deep Link feature enabled.");
                    zzl().zzb((Runnable) new zziv(this));
                }
            }
            zzo().zzac();
            this.zzm = false;
            String zzv = zzk().zzv();
            if (!TextUtils.isEmpty(zzv)) {
                zzf().zzab();
                if (!zzv.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzv);
                    zzc("auto", "_ou", bundle);
                }
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    public final void zza(String str, String str2, Bundle bundle) {
        long currentTimeMillis = zzb().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzl().zzb((Runnable) new zzjl(this, bundle2));
    }

    public final void zzak() {
        if ((zza().getApplicationContext() instanceof Application) && this.zza != null) {
            ((Application) zza().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzal() {
        if (zzpg.zza() && zze().zza(zzbi.zzcg)) {
            if (zzl().zzg()) {
                zzj().zzg().zza("Cannot get trigger URIs from analytics worker thread");
            } else if (zzae.zza()) {
                zzj().zzg().zza("Cannot get trigger URIs from main thread");
            } else {
                zzu();
                zzj().zzp().zza("Getting trigger URIs (FE)");
                AtomicReference atomicReference = new AtomicReference();
                zzl().zza(atomicReference, 5000, "get trigger URIs", new zzir(this, atomicReference));
                List list = (List) atomicReference.get();
                if (list == null) {
                    zzj().zzg().zza("Timed out waiting for get trigger URIs");
                } else {
                    zzl().zzb((Runnable) new zziu(this, list));
                }
            }
        }
    }

    public final void zzam() {
        zzt();
        if (zzk().zzo.zza()) {
            zzj().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long zza2 = zzk().zzp.zza();
        zzk().zzp.zza(1 + zza2);
        if (zza2 >= 5) {
            zzj().zzu().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzk().zzo.zza(true);
        } else if (!zznp.zza() || !zze().zza(zzbi.zzcn)) {
            this.zzu.zzah();
        } else {
            if (this.zzn == null) {
                this.zzn = new zzjh(this, this.zzu);
            }
            this.zzn.zza(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(List list) {
        zzt();
        if (Build.VERSION.SDK_INT >= 30) {
            SparseArray<Long> zzg2 = zzk().zzg();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzmh zzmh = (zzmh) it.next();
                if (!zzg2.contains(zzmh.zzc) || zzg2.get(zzmh.zzc).longValue() < zzmh.zzb) {
                    zzao().add(zzmh);
                }
            }
            zzan();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Bundle bundle) {
        if (bundle == null) {
            zzk().zzt.zza(new Bundle());
            return;
        }
        Bundle zza2 = zzk().zzt.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                zzq();
                if (zznd.zza(obj)) {
                    zzq();
                    zznd.zza(this.zzo, 27, (String) null, (String) null, 0);
                }
                zzj().zzv().zza("Invalid default event parameter type. Name, value", str, obj);
            } else if (zznd.zzg(str)) {
                zzj().zzv().zza("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                zza2.remove(str);
            } else if (zzq().zza("param", str, zze().zzb(this.zzu.zzh().zzad()), obj)) {
                zzq().zza(zza2, str, obj);
            }
        }
        zzq();
        if (zznd.zza(zza2, zze().zzg())) {
            zzq();
            zznd.zza(this.zzo, 26, (String) null, (String) null, 0);
            zzj().zzv().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        zzk().zzt.zza(zza2);
        zzo().zza(zza2);
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzb().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3 = str2;
        String str4 = str == null ? App.TYPE : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (str3 == FirebaseAnalytics.Event.SCREEN_VIEW || (str3 != null && str2.equals(FirebaseAnalytics.Event.SCREEN_VIEW))) {
            zzn().zza(bundle2, j);
            return;
        }
        long j2 = j;
        zzb(str4, str2, j, bundle2, z2, !z2 || this.zzc == null || zznd.zzg(str2), z, (String) null);
    }

    public final void zza(String str, String str2, Bundle bundle, String str3) {
        zzs();
        zzb(str, str2, zzb().currentTimeMillis(), bundle, false, true, true, str3);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(String str, String str2, Bundle bundle) {
        zzt();
        zza(str, str2, zzb().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzt();
        zza(str, str2, j, bundle, true, this.zzc == null || zznd.zzg(str2), true, (String) null);
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        boolean z4;
        String str4;
        long j2;
        zziq zziq;
        String str5;
        String str6;
        String str7;
        boolean z5;
        Class<?> cls;
        String str8 = str;
        String str9 = str2;
        long j3 = j;
        Bundle bundle2 = bundle;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzt();
        zzu();
        if (!this.zzu.zzac()) {
            zzj().zzc().zza("Event not sent since app measurement is disabled");
            return;
        }
        List<String> zzaf = zzg().zzaf();
        if (zzaf == null || zzaf.contains(str9)) {
            int i = 0;
            if (!this.zze) {
                this.zze = true;
                try {
                    if (!this.zzu.zzag()) {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zza().getClassLoader());
                    } else {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                    }
                    try {
                        cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{zza()});
                    } catch (Exception e) {
                        zzj().zzu().zza("Failed to invoke Tag Manager's initialize() method", e);
                    }
                } catch (ClassNotFoundException unused) {
                    zzj().zzn().zza("Tag Manager is not found and thus will not be used");
                }
            }
            if ("_cmp".equals(str9)) {
                if (bundle2.containsKey("gclid")) {
                    zza("auto", "_lgclid", (Object) bundle2.getString("gclid"), zzb().currentTimeMillis());
                }
                if (zzoi.zza() && zze().zza(zzbi.zzcs) && bundle2.containsKey("gbraid")) {
                    zza("auto", "_gbraid", (Object) bundle2.getString("gbraid"), zzb().currentTimeMillis());
                }
            }
            if (z && zznd.zzj(str2)) {
                zzq().zza(bundle2, zzk().zzt.zza());
            }
            if (!z3 && !"_iap".equals(str9)) {
                zznd zzt = this.zzu.zzt();
                int i2 = 2;
                if (zzt.zzc("event", str9)) {
                    if (!zzt.zza("event", zzii.zza, zzii.zzb, str9)) {
                        i2 = 13;
                    } else if (zzt.zza("event", 40, str9)) {
                        i2 = 0;
                    }
                }
                if (i2 != 0) {
                    zzj().zzh().zza("Invalid public event name. Event will not be logged (FE)", zzi().zza(str9));
                    this.zzu.zzt();
                    String zza2 = zznd.zza(str9, 40, true);
                    if (str9 != null) {
                        i = str2.length();
                    }
                    this.zzu.zzt();
                    zznd.zza(this.zzo, i2, "_ev", zza2, i);
                    return;
                }
            }
            zzki zza3 = zzn().zza(false);
            if (zza3 != null && !bundle2.containsKey("_sc")) {
                zza3.zzd = true;
            }
            zznd.zza(zza3, bundle2, z && !z3);
            boolean equals = "am".equals(str8);
            boolean zzg2 = zznd.zzg(str2);
            if (z && this.zzc != null && !zzg2 && !equals) {
                zzj().zzc().zza("Passing event to registered event handler (FE)", zzi().zza(str9), zzi().zza(bundle2));
                Preconditions.checkNotNull(this.zzc);
                this.zzc.interceptEvent(str, str2, bundle, j);
            } else if (this.zzu.zzaf()) {
                int zza4 = zzq().zza(str9);
                if (zza4 != 0) {
                    zzj().zzh().zza("Invalid event name. Event will not be logged (FE)", zzi().zza(str9));
                    zzq();
                    String zza5 = zznd.zza(str9, 40, true);
                    if (str9 != null) {
                        i = str2.length();
                    }
                    this.zzu.zzt();
                    zznd.zza(this.zzo, str3, zza4, "_ev", zza5, i);
                    return;
                }
                Bundle zza6 = zzq().zza(str3, str2, bundle, (List<String>) CollectionUtils.listOf((T[]) new String[]{"_o", "_sn", "_sc", "_si"}), z3);
                Preconditions.checkNotNull(zza6);
                if (zzn().zza(false) != null && "_ae".equals(str9)) {
                    zzmd zzmd = zzp().zzb;
                    long elapsedRealtime = zzmd.zzb.zzb().elapsedRealtime();
                    long j4 = elapsedRealtime - zzmd.zza;
                    zzmd.zza = elapsedRealtime;
                    if (j4 > 0) {
                        zzq().zza(zza6, j4);
                    }
                }
                if (zznv.zza() && zze().zza(zzbi.zzbm)) {
                    if (!"auto".equals(str8) && "_ssr".equals(str9)) {
                        zznd zzq = zzq();
                        String string = zza6.getString("_ffr");
                        if (Strings.isEmptyOrWhitespace(string)) {
                            str7 = null;
                        } else {
                            str7 = string != null ? string.trim() : string;
                        }
                        if (zzng.zza(str7, zzq.zzk().zzq.zza())) {
                            zzq.zzj().zzc().zza("Not logging duplicate session_start_with_rollout event");
                            z5 = false;
                        } else {
                            zzq.zzk().zzq.zza(str7);
                            z5 = true;
                        }
                        if (!z5) {
                            return;
                        }
                    } else if ("_ae".equals(str9)) {
                        String zza7 = zzq().zzk().zzq.zza();
                        if (!TextUtils.isEmpty(zza7)) {
                            zza6.putString("_ffr", zza7);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(zza6);
                if (zze().zza(zzbi.zzcj)) {
                    z4 = zzp().zzaa();
                } else {
                    z4 = zzk().zzn.zza();
                }
                if (zzk().zzk.zza() <= 0 || !zzk().zza(j3) || !z4) {
                    j2 = 0;
                    str4 = "_ae";
                } else {
                    zzj().zzp().zza("Current session is expired, remove the session number, ID, and engagement time");
                    j2 = 0;
                    str4 = "_ae";
                    zza("auto", "_sid", (Object) null, zzb().currentTimeMillis());
                    zza("auto", "_sno", (Object) null, zzb().currentTimeMillis());
                    zza("auto", "_se", (Object) null, zzb().currentTimeMillis());
                    zzk().zzl.zza(0);
                }
                if (zza6.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j2) == 1) {
                    zzj().zzp().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                    zziq = this;
                    zziq.zzu.zzs().zza.zza(j3, true);
                } else {
                    zziq = this;
                }
                ArrayList arrayList2 = new ArrayList(zza6.keySet());
                Collections.sort(arrayList2);
                ArrayList arrayList3 = arrayList2;
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    String str10 = (String) obj;
                    if (str10 != null) {
                        zzq();
                        Bundle[] zzb2 = zznd.zzb(zza6.get(str10));
                        if (zzb2 != null) {
                            zza6.putParcelableArray(str10, zzb2);
                        }
                    }
                }
                int i4 = 0;
                while (i4 < arrayList.size()) {
                    Bundle bundle3 = (Bundle) arrayList.get(i4);
                    if (i4 != 0) {
                        str6 = "_ep";
                        str5 = str;
                    } else {
                        str5 = str;
                        str6 = str2;
                    }
                    bundle3.putString("_o", str5);
                    if (z2) {
                        bundle3 = zzq().zzb(bundle3);
                    }
                    Bundle bundle4 = bundle3;
                    zzo().zza(new zzbg(str6, new zzbb(bundle4), str, j), str3);
                    if (!equals) {
                        for (zzil onEvent : zziq.zzd) {
                            onEvent.onEvent(str, str2, new Bundle(bundle4), j);
                            String str11 = str3;
                        }
                    }
                    i4++;
                }
                if (zzn().zza(false) != null) {
                    if (str4.equals(str2)) {
                        zzp().zza(true, true, zzb().elapsedRealtime());
                    }
                }
            }
        } else {
            zzj().zzc().zza("Dropping non-safelisted event. event name, origin", str9, str8);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzan() {
        zzmh poll;
        MeasurementManagerFutures zzn2;
        zzt();
        if (!zzao().isEmpty() && !this.zzh && (poll = zzao().poll()) != null && (zzn2 = zzq().zzn()) != null) {
            this.zzh = true;
            zzj().zzp().zza("Registering trigger URI", poll.zza);
            ListenableFuture<Unit> registerTriggerAsync = zzn2.registerTriggerAsync(Uri.parse(poll.zza));
            if (registerTriggerAsync == null) {
                this.zzh = false;
                zzao().add(poll);
                return;
            }
            SparseArray<Long> zzg2 = zzk().zzg();
            zzg2.put(poll.zzc, Long.valueOf(poll.zzb));
            zzgd zzk2 = zzk();
            if (zzg2 == null) {
                zzk2.zzi.zza((Bundle) null);
            } else {
                int[] iArr = new int[zzg2.size()];
                long[] jArr = new long[zzg2.size()];
                for (int i = 0; i < zzg2.size(); i++) {
                    iArr[i] = zzg2.keyAt(i);
                    jArr[i] = zzg2.valueAt(i).longValue();
                }
                Bundle bundle = new Bundle();
                bundle.putIntArray("uriSources", iArr);
                bundle.putLongArray("uriTimestamps", jArr);
                zzk2.zzi.zza(bundle);
            }
            Futures.addCallback(registerTriggerAsync, new zzjc(this, poll), new zziz(this));
        }
    }

    public final void zza(zzil zzil) {
        zzu();
        Preconditions.checkNotNull(zzil);
        if (!this.zzd.add(zzil)) {
            zzj().zzu().zza("OnEventListener already registered");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j, boolean z) {
        zzt();
        zzu();
        zzj().zzc().zza("Resetting analytics data (FE)");
        zzlx zzp = zzp();
        zzp.zzt();
        zzp.zzb.zza();
        if (zzps.zza() && zze().zza(zzbi.zzbs)) {
            zzg().zzag();
        }
        boolean zzac = this.zzu.zzac();
        zzgd zzk2 = zzk();
        zzk2.zzc.zza(j);
        if (!TextUtils.isEmpty(zzk2.zzk().zzq.zza())) {
            zzk2.zzq.zza((String) null);
        }
        if (zzoh.zza() && zzk2.zze().zza(zzbi.zzbn)) {
            zzk2.zzk.zza(0);
        }
        zzk2.zzl.zza(0);
        if (!zzk2.zze().zzv()) {
            zzk2.zzb(!zzac);
        }
        zzk2.zzr.zza((String) null);
        zzk2.zzs.zza(0);
        zzk2.zzt.zza((Bundle) null);
        if (z) {
            zzo().zzaf();
        }
        if (zzoh.zza() && zze().zza(zzbi.zzbn)) {
            zzp().zza.zza();
        }
        this.zzm = !zzac;
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzl().zzb((Runnable) new zzjg(this, str, str2, j, zznd.zza(bundle), z, z2, z3, str3));
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzl().zzb((Runnable) new zzjf(this, str, str2, obj, j));
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str) {
        this.zzf.set(str);
    }

    public final void zzb(Bundle bundle) {
        zza(bundle, zzb().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzj().zzu().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzie.zza(bundle2, "app_id", String.class, null);
        zzie.zza(bundle2, "origin", String.class, null);
        zzie.zza(bundle2, "name", String.class, null);
        zzie.zza(bundle2, "value", Object.class, null);
        zzie.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzie.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzie.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzie.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzie.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzie.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzie.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzie.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzie.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (zzq().zzb(string) != 0) {
            zzj().zzg().zza("Invalid conditional user property name", zzi().zzc(string));
        } else if (zzq().zza(string, obj) != 0) {
            zzj().zzg().zza("Invalid conditional user property value", zzi().zzc(string), obj);
        } else {
            Object zzc2 = zzq().zzc(string, obj);
            if (zzc2 == null) {
                zzj().zzg().zza("Unable to normalize conditional user property value", zzi().zzc(string), obj);
                return;
            }
            zzie.zza(bundle2, zzc2);
            long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzj().zzg().zza("Invalid conditional user property time to live", zzi().zzc(string), Long.valueOf(j3));
                } else {
                    zzl().zzb((Runnable) new zzjm(this, bundle2));
                }
            } else {
                zzj().zzg().zza("Invalid conditional user property timeout", zzi().zzc(string), Long.valueOf(j2));
            }
        }
    }

    public final void zza(zzih zzih, long j) {
        zzih zzih2;
        boolean z;
        boolean z2;
        boolean z3;
        zzih zzih3 = zzih;
        zzu();
        int zza2 = zzih.zza();
        if (zza2 != -10 && zzih.zzc() == null && zzih.zzd() == null) {
            zzj().zzv().zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.zzg) {
            zzih2 = this.zzj;
            z = true;
            z2 = false;
            if (zzih.zza(zza2, zzih2.zza())) {
                boolean zzc2 = zzih3.zzc(this.zzj);
                if (zzih.zzh() && !this.zzj.zzh()) {
                    z2 = true;
                }
                zzih3 = zzih3.zzb(this.zzj);
                this.zzj = zzih3;
                z3 = z2;
                z2 = zzc2;
            } else {
                z = false;
                z3 = false;
            }
        }
        if (!z) {
            zzj().zzn().zza("Ignoring lower-priority consent settings, proposed settings", zzih3);
            return;
        }
        long andIncrement = this.zzk.getAndIncrement();
        if (z2) {
            zza((String) null);
            zzl().zzc((Runnable) new zzjv(this, zzih3, j, andIncrement, z3, zzih2));
            return;
        }
        zzjy zzjy = new zzjy(this, zzih3, andIncrement, z3, zzih2);
        if (zza2 == 30 || zza2 == -10) {
            zzl().zzc((Runnable) zzjy);
        } else {
            zzl().zzb((Runnable) zzjy);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Bundle bundle, int i, long j) {
        zzu();
        String zza2 = zzih.zza(bundle);
        if (zza2 != null) {
            zzj().zzv().zza("Ignoring invalid consent setting", zza2);
            zzj().zzv().zza("Valid consent values are 'granted', 'denied'");
        }
        zzih zza3 = zzih.zza(bundle, i);
        if (!zznp.zza() || !zze().zza(zzbi.zzcl)) {
            zza(zza3, j);
            return;
        }
        if (zza3.zzi()) {
            zza(zza3, j);
        }
        zzay zza4 = zzay.zza(bundle, i);
        if (zza4.zzg()) {
            zza(zza4);
        }
        Boolean zza5 = zzay.zza(bundle);
        if (zza5 != null) {
            zza(App.TYPE, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, (Object) zza5.toString(), false);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzay zzay) {
        zzl().zzb((Runnable) new zzjw(this, zzay));
    }

    public final void zza(zzim zzim) {
        zzim zzim2;
        zzt();
        zzu();
        if (!(zzim == null || zzim == (zzim2 = this.zzc))) {
            Preconditions.checkState(zzim2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzim;
    }

    public final void zza(Boolean bool) {
        zzu();
        zzl().zzb((Runnable) new zzjt(this, bool));
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzih zzih) {
        zzt();
        boolean z = (zzih.zzh() && zzih.zzg()) || zzo().zzaj();
        if (z != this.zzu.zzad()) {
            this.zzu.zzb(z);
            Boolean zzp = zzk().zzp();
            if (!z || zzp == null || zzp.booleanValue()) {
                zza(Boolean.valueOf(z), false);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zza(Boolean bool, boolean z) {
        zzt();
        zzu();
        zzj().zzc().zza("Setting app measurement enabled (FE)", bool);
        zzk().zza(bool);
        if (z) {
            zzk().zzb(bool);
        }
        if (this.zzu.zzad() || (bool != null && !bool.booleanValue())) {
            zzap();
        }
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzb().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = App.TYPE;
        }
        String str3 = str;
        int i = 6;
        int i2 = 0;
        if (z) {
            i = zzq().zzb(str2);
        } else {
            zznd zzq = zzq();
            if (zzq.zzc("user property", str2)) {
                if (!zzq.zza("user property", zzij.zza, str2)) {
                    i = 15;
                } else if (zzq.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            zzq();
            String zza2 = zznd.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzu.zzt();
            zznd.zza(this.zzo, i, "_ev", zza2, i2);
        } else if (obj != null) {
            int zza3 = zzq().zza(str2, obj);
            if (zza3 != 0) {
                zzq();
                String zza4 = zznd.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzu.zzt();
                zznd.zza(this.zzo, zza3, "_ev", zza4, i2);
                return;
            }
            Object zzc2 = zzq().zzc(str2, obj);
            if (zzc2 != null) {
                zza(str3, str2, j, zzc2);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzt()
            r8.zzu()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0063
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0053
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0053
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L_0x0035
            r4 = r2
            goto L_0x0037
        L_0x0035:
            r4 = 0
        L_0x0037:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzgd r0 = r8.zzk()
            com.google.android.gms.measurement.internal.zzgj r0 = r0.zzh
            r4 = r10
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r10.longValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x004e
            java.lang.String r11 = "true"
        L_0x004e:
            r0.zza(r11)
            r6 = r10
            goto L_0x0061
        L_0x0053:
            if (r11 != 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzgd r10 = r8.zzk()
            com.google.android.gms.measurement.internal.zzgj r10 = r10.zzh
            java.lang.String r0 = "unset"
            r10.zza(r0)
            r6 = r11
        L_0x0061:
            r3 = r1
            goto L_0x0065
        L_0x0063:
            r3 = r10
            r6 = r11
        L_0x0065:
            com.google.android.gms.measurement.internal.zzhf r10 = r8.zzu
            boolean r10 = r10.zzac()
            if (r10 != 0) goto L_0x007b
            com.google.android.gms.measurement.internal.zzfr r9 = r8.zzj()
            com.google.android.gms.measurement.internal.zzft r9 = r9.zzp()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L_0x007b:
            com.google.android.gms.measurement.internal.zzhf r10 = r8.zzu
            boolean r10 = r10.zzaf()
            if (r10 != 0) goto L_0x0084
            return
        L_0x0084:
            com.google.android.gms.measurement.internal.zznc r10 = new com.google.android.gms.measurement.internal.zznc
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzkp r9 = r8.zzo()
            r9.zza((com.google.android.gms.measurement.internal.zznc) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziq.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void zzb(zzil zzil) {
        zzu();
        Preconditions.checkNotNull(zzil);
        if (!this.zzd.remove(zzil)) {
            zzj().zzu().zza("OnEventListener had not been registered");
        }
    }

    /* access modifiers changed from: private */
    public final void zzap() {
        zzt();
        String zza2 = zzk().zzh.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                zza(App.TYPE, "_npa", (Object) null, zzb().currentTimeMillis());
            } else {
                zza(App.TYPE, "_npa", (Object) Long.valueOf(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(zza2) ? 1 : 0), zzb().currentTimeMillis());
            }
        }
        if (!this.zzu.zzac() || !this.zzm) {
            zzj().zzc().zza("Updating Scion state (FE)");
            zzo().zzag();
            return;
        }
        zzj().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzaj();
        if (zzoh.zza() && zze().zza(zzbi.zzbn)) {
            zzp().zza.zza();
        }
        zzl().zzb((Runnable) new zzje(this));
    }
}
