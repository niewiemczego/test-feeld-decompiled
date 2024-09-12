package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.internal.measurement.zzgn;
import com.google.android.gms.internal.measurement.zznp;
import com.google.android.gms.internal.measurement.zzoi;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public class zzhf implements zzif {
    private static volatile zzhf zzb;
    final long zza;
    private Boolean zzaa;
    private long zzab;
    private volatile Boolean zzac;
    private Boolean zzad;
    private Boolean zzae;
    private volatile boolean zzaf;
    private int zzag;
    private int zzah;
    private AtomicInteger zzai = new AtomicInteger(0);
    private final Context zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final zzae zzh;
    private final zzaf zzi;
    private final zzgd zzj;
    private final zzfr zzk;
    private final zzgy zzl;
    private final zzlx zzm;
    private final zznd zzn;
    private final zzfq zzo;
    private final Clock zzp;
    private final zzkh zzq;
    private final zziq zzr;
    private final zzb zzs;
    private final zzkc zzt;
    private final String zzu;
    private zzfo zzv;
    private zzkp zzw;
    private zzba zzx;
    private zzfl zzy;
    private boolean zzz = false;

    public final int zzc() {
        zzl().zzt();
        if (this.zzi.zzv()) {
            return 1;
        }
        Boolean bool = this.zzae;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (!zzad()) {
            return 8;
        }
        Boolean zzu2 = zzn().zzu();
        if (zzu2 == null) {
            Boolean zzg2 = this.zzi.zzg("firebase_analytics_collection_enabled");
            if (zzg2 == null) {
                Boolean bool2 = this.zzad;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (this.zzac == null || this.zzac.booleanValue()) {
                    return 0;
                } else {
                    return 7;
                }
            } else if (zzg2.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (zzu2.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    @Pure
    public final Context zza() {
        return this.zzc;
    }

    @Pure
    public final Clock zzb() {
        return this.zzp;
    }

    @Pure
    public final zzb zze() {
        zzb zzb2 = this.zzs;
        if (zzb2 != null) {
            return zzb2;
        }
        throw new IllegalStateException("Component not created");
    }

    @Pure
    public final zzae zzd() {
        return this.zzh;
    }

    @Pure
    public final zzaf zzf() {
        return this.zzi;
    }

    @Pure
    public final zzba zzg() {
        zza((zzic) this.zzx);
        return this.zzx;
    }

    @Pure
    public final zzfl zzh() {
        zza((zze) this.zzy);
        return this.zzy;
    }

    @Pure
    public final zzfo zzi() {
        zza((zze) this.zzv);
        return this.zzv;
    }

    @Pure
    public final zzfq zzk() {
        return this.zzo;
    }

    @Pure
    public final zzfr zzj() {
        zza((zzic) this.zzk);
        return this.zzk;
    }

    public final zzfr zzm() {
        zzfr zzfr = this.zzk;
        if (zzfr == null || !zzfr.zzae()) {
            return null;
        }
        return this.zzk;
    }

    @Pure
    public final zzgd zzn() {
        zza((zzid) this.zzj);
        return this.zzj;
    }

    @Pure
    public final zzgy zzl() {
        zza((zzic) this.zzl);
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    @SideEffectFree
    public final zzgy zzo() {
        return this.zzl;
    }

    public static zzhf zza(Context context, zzdd zzdd, Long l) {
        if (zzdd != null && (zzdd.zze == null || zzdd.zzf == null)) {
            zzdd = new zzdd(zzdd.zza, zzdd.zzb, zzdd.zzc, zzdd.zzd, (String) null, (String) null, zzdd.zzg, (String) null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzhf.class) {
                if (zzb == null) {
                    zzb = new zzhf(new zzio(context, zzdd, l));
                }
            }
        } else if (!(zzdd == null || zzdd.zzg == null || !zzdd.zzg.containsKey("dataCollectionDefaultEnabled"))) {
            Preconditions.checkNotNull(zzb);
            zzb.zza(zzdd.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzb);
        return zzb;
    }

    @Pure
    public final zziq zzp() {
        zza((zze) this.zzr);
        return this.zzr;
    }

    @Pure
    private final zzkc zzai() {
        zza((zzic) this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzkh zzq() {
        zza((zze) this.zzq);
        return this.zzq;
    }

    @Pure
    public final zzkp zzr() {
        zza((zze) this.zzw);
        return this.zzw;
    }

    @Pure
    public final zzlx zzs() {
        zza((zze) this.zzm);
        return this.zzm;
    }

    @Pure
    public final zznd zzt() {
        zza((zzid) this.zzn);
        return this.zzn;
    }

    @Pure
    public final String zzu() {
        return this.zzd;
    }

    @Pure
    public final String zzv() {
        return this.zze;
    }

    @Pure
    public final String zzw() {
        return this.zzf;
    }

    @Pure
    public final String zzx() {
        return this.zzu;
    }

    static /* synthetic */ void zza(zzhf zzhf, zzio zzio) {
        zzhf.zzl().zzt();
        zzba zzba = new zzba(zzhf);
        zzba.zzac();
        zzhf.zzx = zzba;
        zzfl zzfl = new zzfl(zzhf, zzio.zzf);
        zzfl.zzv();
        zzhf.zzy = zzfl;
        zzfo zzfo = new zzfo(zzhf);
        zzfo.zzv();
        zzhf.zzv = zzfo;
        zzkp zzkp = new zzkp(zzhf);
        zzkp.zzv();
        zzhf.zzw = zzkp;
        zzhf.zzn.zzad();
        zzhf.zzj.zzad();
        zzhf.zzy.zzw();
        zzhf.zzj().zzn().zza("App measurement initialized, version", 82001L);
        zzhf.zzj().zzn().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzad2 = zzfl.zzad();
        if (TextUtils.isEmpty(zzhf.zzd)) {
            if (zzhf.zzt().zzf(zzad2)) {
                zzhf.zzj().zzn().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzhf.zzj().zzn().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app " + zzad2);
            }
        }
        zzhf.zzj().zzc().zza("Debug-level message logging enabled");
        if (zzhf.zzag != zzhf.zzai.get()) {
            zzhf.zzj().zzg().zza("Not all components initialized", Integer.valueOf(zzhf.zzag), Integer.valueOf(zzhf.zzai.get()));
        }
        zzhf.zzz = true;
    }

    private zzhf(zzio zzio) {
        long j;
        boolean z = false;
        Preconditions.checkNotNull(zzio);
        zzae zzae2 = new zzae(zzio.zza);
        this.zzh = zzae2;
        zzff.zza = zzae2;
        Context context = zzio.zza;
        this.zzc = context;
        this.zzd = zzio.zzb;
        this.zze = zzio.zzc;
        this.zzf = zzio.zzd;
        this.zzg = zzio.zzh;
        this.zzac = zzio.zze;
        this.zzu = zzio.zzj;
        this.zzaf = true;
        zzdd zzdd = zzio.zzg;
        if (!(zzdd == null || zzdd.zzg == null)) {
            Object obj = zzdd.zzg.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzad = (Boolean) obj;
            }
            Object obj2 = zzdd.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzae = (Boolean) obj2;
            }
        }
        zzgn.zzb(context);
        Clock instance = DefaultClock.getInstance();
        this.zzp = instance;
        if (zzio.zzi != null) {
            j = zzio.zzi.longValue();
        } else {
            j = instance.currentTimeMillis();
        }
        this.zza = j;
        this.zzi = new zzaf(this);
        zzgd zzgd = new zzgd(this);
        zzgd.zzac();
        this.zzj = zzgd;
        zzfr zzfr = new zzfr(this);
        zzfr.zzac();
        this.zzk = zzfr;
        zznd zznd = new zznd(this);
        zznd.zzac();
        this.zzn = zznd;
        this.zzo = new zzfq(new zzin(zzio, this));
        this.zzs = new zzb(this);
        zzkh zzkh = new zzkh(this);
        zzkh.zzv();
        this.zzq = zzkh;
        zziq zziq = new zziq(this);
        zziq.zzv();
        this.zzr = zziq;
        zzlx zzlx = new zzlx(this);
        zzlx.zzv();
        this.zzm = zzlx;
        zzkc zzkc = new zzkc(this);
        zzkc.zzac();
        this.zzt = zzkc;
        zzgy zzgy = new zzgy(this);
        zzgy.zzac();
        this.zzl = zzgy;
        if (!(zzio.zzg == null || zzio.zzg.zzb == 0)) {
            z = true;
        }
        boolean z2 = !z;
        if (context.getApplicationContext() instanceof Application) {
            zziq zzp2 = zzp();
            if (zzp2.zza().getApplicationContext() instanceof Application) {
                Application application = (Application) zzp2.zza().getApplicationContext();
                if (zzp2.zza == null) {
                    zzp2.zza = new zzjx(zzp2);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzp2.zza);
                    application.registerActivityLifecycleCallbacks(zzp2.zza);
                    zzp2.zzj().zzp().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzj().zzu().zza("Application context is not an Application");
        }
        zzgy.zzb((Runnable) new zzhg(this, zzio));
    }

    private static void zza(zzid zzid) {
        if (zzid == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void zza(zze zze2) {
        if (zze2 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zze2.zzy()) {
            throw new IllegalStateException("Component not initialized: " + String.valueOf(zze2.getClass()));
        }
    }

    private static void zza(zzic zzic) {
        if (zzic == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzic.zzae()) {
            throw new IllegalStateException("Component not initialized: " + String.valueOf(zzic.getClass()));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzy() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: package-private */
    public final void zzz() {
        this.zzai.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        if (!((i == 200 || i == 204 || i == 304) && th == null)) {
            zzj().zzu().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzn().zzo.zza(true);
        if (bArr == null || bArr.length == 0) {
            zzj().zzc().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, "");
            String optString2 = jSONObject.optString("gclid", "");
            String optString3 = jSONObject.optString("gbraid", "");
            double optDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(optString)) {
                zzj().zzc().zza("Deferred Deep Link is empty.");
                return;
            }
            Bundle bundle = new Bundle();
            if (!zzoi.zza() || !this.zzi.zza(zzbi.zzcs)) {
                if (!zzt().zzi(optString)) {
                    zzj().zzu().zza("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                    return;
                }
            } else if (!zzt().zzi(optString)) {
                zzj().zzu().zza("Deferred Deep Link validation failed. gclid, gbraid, deep link", optString2, optString3, optString);
                return;
            } else {
                bundle.putString("gbraid", optString3);
            }
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.zzr.zzc("auto", "_cmp", bundle);
            zznd zzt2 = zzt();
            if (!TextUtils.isEmpty(optString) && zzt2.zza(optString, optDouble)) {
                zzt2.zza().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
            }
        } catch (JSONException e) {
            zzj().zzg().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzaa() {
        this.zzag++;
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        this.zzac = Boolean.valueOf(z);
    }

    public final void zzb(boolean z) {
        zzl().zzt();
        this.zzaf = z;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d8, code lost:
        if (r1.zzi() != false) goto L_0x00dc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.measurement.zzdd r10) {
        /*
            r9 = this;
            com.google.android.gms.measurement.internal.zzgy r0 = r9.zzl()
            r0.zzt()
            boolean r0 = com.google.android.gms.internal.measurement.zzpg.zza()
            if (r0 == 0) goto L_0x004e
            com.google.android.gms.measurement.internal.zzaf r0 = r9.zzi
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzbi.zzcg
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean>) r1)
            if (r0 == 0) goto L_0x004e
            com.google.android.gms.measurement.internal.zznd r0 = r9.zzt()
            boolean r0 = r0.zzw()
            if (r0 == 0) goto L_0x004e
            com.google.android.gms.measurement.internal.zznd r0 = r9.zzt()
            r0.zzt()
            android.content.IntentFilter r1 = new android.content.IntentFilter
            r1.<init>()
            java.lang.String r2 = "com.google.android.gms.measurement.TRIGGERS_AVAILABLE"
            r1.addAction(r2)
            com.google.android.gms.measurement.internal.zzp r2 = new com.google.android.gms.measurement.internal.zzp
            com.google.android.gms.measurement.internal.zzhf r3 = r0.zzu
            r2.<init>(r3)
            android.content.Context r3 = r0.zza()
            r4 = 2
            androidx.core.content.ContextCompat.registerReceiver(r3, r2, r1, r4)
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzft r0 = r0.zzc()
            java.lang.String r1 = "Registered app receiver"
            r0.zza(r1)
        L_0x004e:
            com.google.android.gms.measurement.internal.zzgd r0 = r9.zzn()
            com.google.android.gms.measurement.internal.zzih r0 = r0.zzm()
            int r1 = r0.zza()
            com.google.android.gms.measurement.internal.zzaf r2 = r9.zzi
            java.lang.String r3 = "google_analytics_default_allow_ad_storage"
            java.lang.Boolean r2 = r2.zzg(r3)
            com.google.android.gms.measurement.internal.zzaf r3 = r9.zzi
            java.lang.String r4 = "google_analytics_default_allow_analytics_storage"
            java.lang.Boolean r3 = r3.zzg(r4)
            r4 = -10
            r5 = 0
            r6 = 30
            if (r2 != 0) goto L_0x0073
            if (r3 == 0) goto L_0x0083
        L_0x0073:
            com.google.android.gms.measurement.internal.zzgd r7 = r9.zzn()
            boolean r7 = r7.zza((int) r4)
            if (r7 == 0) goto L_0x0083
            com.google.android.gms.measurement.internal.zzih r1 = new com.google.android.gms.measurement.internal.zzih
            r1.<init>(r2, r3, r4)
            goto L_0x00dc
        L_0x0083:
            com.google.android.gms.measurement.internal.zzfl r2 = r9.zzh()
            java.lang.String r2 = r2.zzae()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00b0
            if (r1 == 0) goto L_0x00a1
            if (r1 == r6) goto L_0x00a1
            r2 = 10
            if (r1 == r2) goto L_0x00a1
            if (r1 == r6) goto L_0x00a1
            if (r1 == r6) goto L_0x00a1
            r2 = 40
            if (r1 != r2) goto L_0x00b0
        L_0x00a1:
            com.google.android.gms.measurement.internal.zziq r1 = r9.zzp()
            com.google.android.gms.measurement.internal.zzih r2 = new com.google.android.gms.measurement.internal.zzih
            r2.<init>(r5, r5, r4)
            long r7 = r9.zza
            r1.zza((com.google.android.gms.measurement.internal.zzih) r2, (long) r7)
            goto L_0x00db
        L_0x00b0:
            com.google.android.gms.measurement.internal.zzfl r1 = r9.zzh()
            java.lang.String r1 = r1.zzae()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x00db
            if (r10 == 0) goto L_0x00db
            android.os.Bundle r1 = r10.zzg
            if (r1 == 0) goto L_0x00db
            com.google.android.gms.measurement.internal.zzgd r1 = r9.zzn()
            boolean r1 = r1.zza((int) r6)
            if (r1 == 0) goto L_0x00db
            android.os.Bundle r1 = r10.zzg
            com.google.android.gms.measurement.internal.zzih r1 = com.google.android.gms.measurement.internal.zzih.zza((android.os.Bundle) r1, (int) r6)
            boolean r2 = r1.zzi()
            if (r2 == 0) goto L_0x00db
            goto L_0x00dc
        L_0x00db:
            r1 = r5
        L_0x00dc:
            if (r1 == 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zziq r0 = r9.zzp()
            long r2 = r9.zza
            r0.zza((com.google.android.gms.measurement.internal.zzih) r1, (long) r2)
            r0 = r1
        L_0x00e8:
            com.google.android.gms.measurement.internal.zziq r1 = r9.zzp()
            r1.zza((com.google.android.gms.measurement.internal.zzih) r0)
            boolean r0 = com.google.android.gms.internal.measurement.zznp.zza()
            r1 = 0
            if (r0 == 0) goto L_0x01ad
            com.google.android.gms.measurement.internal.zzaf r0 = r9.zzi
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbi.zzcl
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean>) r2)
            if (r0 == 0) goto L_0x01ad
            com.google.android.gms.measurement.internal.zzgd r0 = r9.zzn()
            com.google.android.gms.measurement.internal.zzay r0 = r0.zzh()
            int r0 = r0.zza()
            com.google.android.gms.measurement.internal.zzaf r2 = r9.zzi
            java.lang.String r3 = "google_analytics_default_allow_ad_user_data"
            java.lang.Boolean r2 = r2.zzg(r3)
            if (r2 == 0) goto L_0x012a
            boolean r3 = com.google.android.gms.measurement.internal.zzih.zza((int) r4, (int) r0)
            if (r3 == 0) goto L_0x012a
            com.google.android.gms.measurement.internal.zziq r10 = r9.zzp()
            com.google.android.gms.measurement.internal.zzay r0 = new com.google.android.gms.measurement.internal.zzay
            r0.<init>((java.lang.Boolean) r2, (int) r4)
            r10.zza((com.google.android.gms.measurement.internal.zzay) r0)
            goto L_0x01ad
        L_0x012a:
            com.google.android.gms.measurement.internal.zzfl r2 = r9.zzh()
            java.lang.String r2 = r2.zzae()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0149
            if (r0 == 0) goto L_0x013c
            if (r0 != r6) goto L_0x0149
        L_0x013c:
            com.google.android.gms.measurement.internal.zziq r10 = r9.zzp()
            com.google.android.gms.measurement.internal.zzay r0 = new com.google.android.gms.measurement.internal.zzay
            r0.<init>((java.lang.Boolean) r5, (int) r4)
            r10.zza((com.google.android.gms.measurement.internal.zzay) r0)
            goto L_0x01ad
        L_0x0149:
            com.google.android.gms.measurement.internal.zzfl r2 = r9.zzh()
            java.lang.String r2 = r2.zzae()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0176
            if (r10 == 0) goto L_0x0176
            android.os.Bundle r2 = r10.zzg
            if (r2 == 0) goto L_0x0176
            boolean r0 = com.google.android.gms.measurement.internal.zzih.zza((int) r6, (int) r0)
            if (r0 == 0) goto L_0x0176
            android.os.Bundle r0 = r10.zzg
            com.google.android.gms.measurement.internal.zzay r0 = com.google.android.gms.measurement.internal.zzay.zza(r0, r6)
            boolean r2 = r0.zzg()
            if (r2 == 0) goto L_0x0176
            com.google.android.gms.measurement.internal.zziq r2 = r9.zzp()
            r2.zza((com.google.android.gms.measurement.internal.zzay) r0)
        L_0x0176:
            com.google.android.gms.measurement.internal.zzfl r0 = r9.zzh()
            java.lang.String r0 = r0.zzae()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x01ad
            if (r10 == 0) goto L_0x01ad
            android.os.Bundle r0 = r10.zzg
            if (r0 == 0) goto L_0x01ad
            com.google.android.gms.measurement.internal.zzgd r0 = r9.zzn()
            com.google.android.gms.measurement.internal.zzgj r0 = r0.zzh
            java.lang.String r0 = r0.zza()
            if (r0 != 0) goto L_0x01ad
            android.os.Bundle r0 = r10.zzg
            java.lang.Boolean r0 = com.google.android.gms.measurement.internal.zzay.zza((android.os.Bundle) r0)
            if (r0 == 0) goto L_0x01ad
            com.google.android.gms.measurement.internal.zziq r2 = r9.zzp()
            java.lang.String r10 = r10.zze
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "allow_personalized_ads"
            r2.zza((java.lang.String) r10, (java.lang.String) r3, (java.lang.Object) r0, (boolean) r1)
        L_0x01ad:
            com.google.android.gms.measurement.internal.zzgd r10 = r9.zzn()
            com.google.android.gms.measurement.internal.zzgi r10 = r10.zzc
            long r2 = r10.zza()
            r6 = 0
            int r10 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r10 != 0) goto L_0x01db
            com.google.android.gms.measurement.internal.zzfr r10 = r9.zzj()
            com.google.android.gms.measurement.internal.zzft r10 = r10.zzp()
            long r2 = r9.zza
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "Persisting first open"
            r10.zza(r2, r0)
            com.google.android.gms.measurement.internal.zzgd r10 = r9.zzn()
            com.google.android.gms.measurement.internal.zzgi r10 = r10.zzc
            long r2 = r9.zza
            r10.zza(r2)
        L_0x01db:
            com.google.android.gms.measurement.internal.zziq r10 = r9.zzp()
            com.google.android.gms.measurement.internal.zzu r10 = r10.zzb
            r10.zzb()
            boolean r10 = r9.zzaf()
            if (r10 != 0) goto L_0x026f
            boolean r10 = r9.zzac()
            if (r10 == 0) goto L_0x03df
            com.google.android.gms.measurement.internal.zznd r10 = r9.zzt()
            java.lang.String r0 = "android.permission.INTERNET"
            boolean r10 = r10.zze(r0)
            if (r10 != 0) goto L_0x0209
            com.google.android.gms.measurement.internal.zzfr r10 = r9.zzj()
            com.google.android.gms.measurement.internal.zzft r10 = r10.zzg()
            java.lang.String r0 = "App is missing INTERNET permission"
            r10.zza(r0)
        L_0x0209:
            com.google.android.gms.measurement.internal.zznd r10 = r9.zzt()
            java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r10 = r10.zze(r0)
            if (r10 != 0) goto L_0x0222
            com.google.android.gms.measurement.internal.zzfr r10 = r9.zzj()
            com.google.android.gms.measurement.internal.zzft r10 = r10.zzg()
            java.lang.String r0 = "App is missing ACCESS_NETWORK_STATE permission"
            r10.zza(r0)
        L_0x0222:
            android.content.Context r10 = r9.zzc
            com.google.android.gms.common.wrappers.PackageManagerWrapper r10 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r10)
            boolean r10 = r10.isCallerInstantApp()
            if (r10 != 0) goto L_0x0260
            com.google.android.gms.measurement.internal.zzaf r10 = r9.zzi
            boolean r10 = r10.zzw()
            if (r10 != 0) goto L_0x0260
            android.content.Context r10 = r9.zzc
            boolean r10 = com.google.android.gms.measurement.internal.zznd.zza((android.content.Context) r10)
            if (r10 != 0) goto L_0x024b
            com.google.android.gms.measurement.internal.zzfr r10 = r9.zzj()
            com.google.android.gms.measurement.internal.zzft r10 = r10.zzg()
            java.lang.String r0 = "AppMeasurementReceiver not registered/enabled"
            r10.zza(r0)
        L_0x024b:
            android.content.Context r10 = r9.zzc
            boolean r10 = com.google.android.gms.measurement.internal.zznd.zza((android.content.Context) r10, (boolean) r1)
            if (r10 != 0) goto L_0x0260
            com.google.android.gms.measurement.internal.zzfr r10 = r9.zzj()
            com.google.android.gms.measurement.internal.zzft r10 = r10.zzg()
            java.lang.String r0 = "AppMeasurementService not registered/enabled"
            r10.zza(r0)
        L_0x0260:
            com.google.android.gms.measurement.internal.zzfr r10 = r9.zzj()
            com.google.android.gms.measurement.internal.zzft r10 = r10.zzg()
            java.lang.String r0 = "Uploading is not possible. App measurement disabled"
            r10.zza(r0)
            goto L_0x03df
        L_0x026f:
            com.google.android.gms.measurement.internal.zzfl r10 = r9.zzh()
            java.lang.String r10 = r10.zzae()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x028b
            com.google.android.gms.measurement.internal.zzfl r10 = r9.zzh()
            java.lang.String r10 = r10.zzac()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x030b
        L_0x028b:
            r9.zzt()
            com.google.android.gms.measurement.internal.zzfl r10 = r9.zzh()
            java.lang.String r10 = r10.zzae()
            com.google.android.gms.measurement.internal.zzgd r0 = r9.zzn()
            java.lang.String r0 = r0.zzx()
            com.google.android.gms.measurement.internal.zzfl r1 = r9.zzh()
            java.lang.String r1 = r1.zzac()
            com.google.android.gms.measurement.internal.zzgd r2 = r9.zzn()
            java.lang.String r2 = r2.zzw()
            boolean r10 = com.google.android.gms.measurement.internal.zznd.zza((java.lang.String) r10, (java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2)
            if (r10 == 0) goto L_0x02ed
            com.google.android.gms.measurement.internal.zzfr r10 = r9.zzj()
            com.google.android.gms.measurement.internal.zzft r10 = r10.zzn()
            java.lang.String r0 = "Rechecking which service to use due to a GMP App Id change"
            r10.zza(r0)
            com.google.android.gms.measurement.internal.zzgd r10 = r9.zzn()
            r10.zzy()
            com.google.android.gms.measurement.internal.zzfo r10 = r9.zzi()
            r10.zzaa()
            com.google.android.gms.measurement.internal.zzkp r10 = r9.zzw
            r10.zzae()
            com.google.android.gms.measurement.internal.zzkp r10 = r9.zzw
            r10.zzad()
            com.google.android.gms.measurement.internal.zzgd r10 = r9.zzn()
            com.google.android.gms.measurement.internal.zzgi r10 = r10.zzc
            long r0 = r9.zza
            r10.zza(r0)
            com.google.android.gms.measurement.internal.zzgd r10 = r9.zzn()
            com.google.android.gms.measurement.internal.zzgj r10 = r10.zze
            r10.zza(r5)
        L_0x02ed:
            com.google.android.gms.measurement.internal.zzgd r10 = r9.zzn()
            com.google.android.gms.measurement.internal.zzfl r0 = r9.zzh()
            java.lang.String r0 = r0.zzae()
            r10.zzc(r0)
            com.google.android.gms.measurement.internal.zzgd r10 = r9.zzn()
            com.google.android.gms.measurement.internal.zzfl r0 = r9.zzh()
            java.lang.String r0 = r0.zzac()
            r10.zzb((java.lang.String) r0)
        L_0x030b:
            com.google.android.gms.measurement.internal.zzgd r10 = r9.zzn()
            com.google.android.gms.measurement.internal.zzih r10 = r10.zzm()
            com.google.android.gms.measurement.internal.zzih$zza r0 = com.google.android.gms.measurement.internal.zzih.zza.ANALYTICS_STORAGE
            boolean r10 = r10.zza((com.google.android.gms.measurement.internal.zzih.zza) r0)
            if (r10 != 0) goto L_0x0324
            com.google.android.gms.measurement.internal.zzgd r10 = r9.zzn()
            com.google.android.gms.measurement.internal.zzgj r10 = r10.zze
            r10.zza(r5)
        L_0x0324:
            com.google.android.gms.measurement.internal.zziq r10 = r9.zzp()
            com.google.android.gms.measurement.internal.zzgd r0 = r9.zzn()
            com.google.android.gms.measurement.internal.zzgj r0 = r0.zze
            java.lang.String r0 = r0.zza()
            r10.zza((java.lang.String) r0)
            boolean r10 = com.google.android.gms.internal.measurement.zznv.zza()
            if (r10 == 0) goto L_0x0375
            com.google.android.gms.measurement.internal.zzaf r10 = r9.zzi
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r0 = com.google.android.gms.measurement.internal.zzbi.zzbm
            boolean r10 = r10.zza((com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean>) r0)
            if (r10 == 0) goto L_0x0375
            com.google.android.gms.measurement.internal.zznd r10 = r9.zzt()
            boolean r10 = r10.zzx()
            if (r10 != 0) goto L_0x0375
            com.google.android.gms.measurement.internal.zzgd r10 = r9.zzn()
            com.google.android.gms.measurement.internal.zzgj r10 = r10.zzq
            java.lang.String r10 = r10.zza()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0375
            com.google.android.gms.measurement.internal.zzfr r10 = r9.zzj()
            com.google.android.gms.measurement.internal.zzft r10 = r10.zzu()
            java.lang.String r0 = "Remote config removed with active feature rollouts"
            r10.zza(r0)
            com.google.android.gms.measurement.internal.zzgd r10 = r9.zzn()
            com.google.android.gms.measurement.internal.zzgj r10 = r10.zzq
            r10.zza(r5)
        L_0x0375:
            com.google.android.gms.measurement.internal.zzfl r10 = r9.zzh()
            java.lang.String r10 = r10.zzae()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0391
            com.google.android.gms.measurement.internal.zzfl r10 = r9.zzh()
            java.lang.String r10 = r10.zzac()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x03df
        L_0x0391:
            boolean r10 = r9.zzac()
            com.google.android.gms.measurement.internal.zzgd r0 = r9.zzn()
            boolean r0 = r0.zzaa()
            if (r0 != 0) goto L_0x03b0
            com.google.android.gms.measurement.internal.zzaf r0 = r9.zzi
            boolean r0 = r0.zzv()
            if (r0 != 0) goto L_0x03b0
            com.google.android.gms.measurement.internal.zzgd r0 = r9.zzn()
            r1 = r10 ^ 1
            r0.zzb((boolean) r1)
        L_0x03b0:
            if (r10 == 0) goto L_0x03b9
            com.google.android.gms.measurement.internal.zziq r10 = r9.zzp()
            r10.zzaj()
        L_0x03b9:
            com.google.android.gms.measurement.internal.zzlx r10 = r9.zzs()
            com.google.android.gms.measurement.internal.zzmf r10 = r10.zza
            r10.zza()
            com.google.android.gms.measurement.internal.zzkp r10 = r9.zzr()
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            r10.zza((java.util.concurrent.atomic.AtomicReference<java.lang.String>) r0)
            com.google.android.gms.measurement.internal.zzkp r10 = r9.zzr()
            com.google.android.gms.measurement.internal.zzgd r0 = r9.zzn()
            com.google.android.gms.measurement.internal.zzgf r0 = r0.zzt
            android.os.Bundle r0 = r0.zza()
            r10.zza((android.os.Bundle) r0)
        L_0x03df:
            boolean r10 = com.google.android.gms.internal.measurement.zzpg.zza()
            if (r10 == 0) goto L_0x040d
            com.google.android.gms.measurement.internal.zzaf r10 = r9.zzi
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r0 = com.google.android.gms.measurement.internal.zzbi.zzcg
            boolean r10 = r10.zza((com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean>) r0)
            if (r10 == 0) goto L_0x040d
            com.google.android.gms.measurement.internal.zznd r10 = r9.zzt()
            boolean r10 = r10.zzw()
            if (r10 == 0) goto L_0x040d
            java.lang.Thread r10 = new java.lang.Thread
            com.google.android.gms.measurement.internal.zziq r0 = r9.zzp()
            r0.getClass()
            com.google.android.gms.measurement.internal.zzhe r1 = new com.google.android.gms.measurement.internal.zzhe
            r1.<init>(r0)
            r10.<init>(r1)
            r10.start()
        L_0x040d:
            com.google.android.gms.measurement.internal.zzgd r10 = r9.zzn()
            com.google.android.gms.measurement.internal.zzgg r10 = r10.zzj
            r0 = 1
            r10.zza(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhf.zza(com.google.android.gms.internal.measurement.zzdd):void");
    }

    public final boolean zzab() {
        return this.zzac != null && this.zzac.booleanValue();
    }

    public final boolean zzac() {
        return zzc() == 0;
    }

    public final boolean zzad() {
        zzl().zzt();
        return this.zzaf;
    }

    @Pure
    public final boolean zzae() {
        return TextUtils.isEmpty(this.zzd);
    }

    /* access modifiers changed from: protected */
    public final boolean zzaf() {
        if (this.zzz) {
            zzl().zzt();
            Boolean bool = this.zzaa;
            if (bool == null || this.zzab == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzab) > 1000)) {
                this.zzab = this.zzp.elapsedRealtime();
                boolean z = true;
                Boolean valueOf = Boolean.valueOf(zzt().zze("android.permission.INTERNET") && zzt().zze("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzc).isCallerInstantApp() || this.zzi.zzw() || (zznd.zza(this.zzc) && zznd.zza(this.zzc, false))));
                this.zzaa = valueOf;
                if (valueOf.booleanValue()) {
                    if (!zzt().zza(zzh().zzae(), zzh().zzac()) && TextUtils.isEmpty(zzh().zzac())) {
                        z = false;
                    }
                    this.zzaa = Boolean.valueOf(z);
                }
            }
            return this.zzaa.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    @Pure
    public final boolean zzag() {
        return this.zzg;
    }

    public final boolean zzah() {
        zzl().zzt();
        zza((zzic) zzai());
        String zzad2 = zzh().zzad();
        Pair<String, Boolean> zza2 = zzn().zza(zzad2);
        boolean z = false;
        if (!this.zzi.zzp() || ((Boolean) zza2.second).booleanValue() || TextUtils.isEmpty((CharSequence) zza2.first)) {
            zzj().zzc().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return false;
        } else if (!zzai().zzc()) {
            zzj().zzu().zza("Network is not available for Deferred Deep Link request. Skipping");
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            if (zznp.zza() && this.zzi.zza(zzbi.zzcn)) {
                Bundle bundle = null;
                zziq zzp2 = zzp();
                zzp2.zzt();
                zzam zzaa2 = zzp2.zzo().zzaa();
                if (zzaa2 != null) {
                    bundle = zzaa2.zza;
                }
                int i = 1;
                if (bundle == null) {
                    int i2 = this.zzah;
                    this.zzah = i2 + 1;
                    if (i2 < 10) {
                        z = true;
                    }
                    zzj().zzc().zza("Failed to retrieve DMA consent from the service, " + (z ? "Retrying." : "Skipping.") + " retryCount", Integer.valueOf(this.zzah));
                    return z;
                }
                sb.append("&gcs=").append(zzih.zza(bundle, 100).zzf());
                zzay zza3 = zzay.zza(bundle, 100);
                sb.append("&dma=").append(zza3.zzd() == Boolean.FALSE ? 0 : 1);
                if (!TextUtils.isEmpty(zza3.zze())) {
                    sb.append("&dma_cps=").append(zza3.zze());
                }
                if (zzay.zza(bundle) == Boolean.TRUE) {
                    i = 0;
                }
                sb.append("&npa=").append(i);
                zzj().zzp().zza("Consent query parameters to Bow", sb);
            }
            zznd zzt2 = zzt();
            zzh();
            URL zza4 = zzt2.zza(82001, zzad2, (String) zza2.first, zzn().zzp.zza() - 1, sb.toString());
            if (zza4 != null) {
                zzkc zzai2 = zzai();
                zzhh zzhh = new zzhh(this);
                zzai2.zzt();
                zzai2.zzab();
                Preconditions.checkNotNull(zza4);
                Preconditions.checkNotNull(zzhh);
                zzai2.zzl().zza((Runnable) new zzke(zzai2, zzad2, zza4, (byte[]) null, (Map<String, String>) null, zzhh));
            }
            return false;
        }
    }
}
