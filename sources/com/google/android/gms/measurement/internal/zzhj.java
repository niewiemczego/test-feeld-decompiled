package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzad;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zznp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzhj extends zzfj {
    /* access modifiers changed from: private */
    public final zzmp zza;
    private Boolean zzb;
    private String zzc;

    public final zzam zza(zzo zzo) {
        zzb(zzo, false);
        Preconditions.checkNotEmpty(zzo.zza);
        if (!zznp.zza()) {
            return new zzam((Bundle) null);
        }
        try {
            return (zzam) this.zza.zzl().zzb(new zzhu(this, zzo)).get(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zza.zzj().zzg().zza("Failed to get consent. appId", zzfr.zza(zzo.zza), e);
            return new zzam((Bundle) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final zzbg zzb(zzbg zzbg, zzo zzo) {
        boolean z = false;
        if (!(!"_cmp".equals(zzbg.zza) || zzbg.zzb == null || zzbg.zzb.zza() == 0)) {
            String zzd = zzbg.zzb.zzd("_cis");
            if ("referrer broadcast".equals(zzd) || "referrer API".equals(zzd)) {
                z = true;
            }
        }
        if (!z) {
            return zzbg;
        }
        this.zza.zzj().zzn().zza("Event has been filtered ", zzbg.toString());
        return new zzbg("_cmpx", zzbg.zzb, zzbg.zzc, zzbg.zzd);
    }

    public final String zzb(zzo zzo) {
        zzb(zzo, false);
        return this.zza.zzb(zzo);
    }

    public final List<zzmh> zza(zzo zzo, Bundle bundle) {
        zzb(zzo, false);
        Preconditions.checkNotNull(zzo.zza);
        try {
            return (List) this.zza.zzl().zza(new zzib(this, zzo, bundle)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get trigger URIs. appId", zzfr.zza(zzo.zza), e);
            return Collections.emptyList();
        }
    }

    public final List<zznc> zza(zzo zzo, boolean z) {
        zzb(zzo, false);
        String str = zzo.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zzne> list = (List) this.zza.zzl().zza(new zzia(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzne zzne : list) {
                if (z || !zznd.zzg(zzne.zzc)) {
                    arrayList.add(new zznc(zzne));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get user properties. appId", zzfr.zza(zzo.zza), e);
            return null;
        }
    }

    public final List<zzad> zza(String str, String str2, zzo zzo) {
        zzb(zzo, false);
        String str3 = zzo.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzl().zza(new zzhq(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    public final List<zzad> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzl().zza(new zzht(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    public final List<zznc> zza(String str, String str2, boolean z, zzo zzo) {
        zzb(zzo, false);
        String str3 = zzo.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zzne> list = (List) this.zza.zzl().zza(new zzho(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzne zzne : list) {
                if (z || !zznd.zzg(zzne.zzc)) {
                    arrayList.add(new zznc(zzne));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to query user properties. appId", zzfr.zza(zzo.zza), e);
            return Collections.emptyList();
        }
    }

    public final List<zznc> zza(String str, String str2, String str3, boolean z) {
        zza(str, true);
        try {
            List<zzne> list = (List) this.zza.zzl().zza(new zzhr(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzne zzne : list) {
                if (z || !zznd.zzg(zzne.zzc)) {
                    arrayList.add(new zznc(zzne));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get user properties as. appId", zzfr.zza(str), e);
            return Collections.emptyList();
        }
    }

    public zzhj(zzmp zzmp) {
        this(zzmp, (String) null);
    }

    private zzhj(zzmp zzmp, String str) {
        Preconditions.checkNotNull(zzmp);
        this.zza = zzmp;
        this.zzc = null;
    }

    public final void zzc(zzo zzo) {
        zzb(zzo, false);
        zza((Runnable) new zzhk(this, zzo));
    }

    private final void zzb(zzo zzo, boolean z) {
        Preconditions.checkNotNull(zzo);
        Preconditions.checkNotEmpty(zzo.zza);
        zza(zzo.zza, false);
        this.zza.zzq().zza(zzo.zzb, zzo.zzp);
    }

    private final void zza(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zza(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zza.zza()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.zzb = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zza.zzj().zzg().zza("Measurement Service called with invalid calling package. appId", zzfr.zza(str));
                    throw e;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zza(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.zza.zzj().zzg().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzbg zzbg, zzo zzo) {
        zzb zzb2;
        if (!this.zza.zzi().zzl(zzo.zza)) {
            zzd(zzbg, zzo);
            return;
        }
        this.zza.zzj().zzp().zza("EES config found for", zzo.zza);
        zzgp zzi = this.zza.zzi();
        String str = zzo.zza;
        if (TextUtils.isEmpty(str)) {
            zzb2 = null;
        } else {
            zzb2 = zzi.zza.get(str);
        }
        if (zzb2 == null) {
            this.zza.zzj().zzp().zza("EES not loaded for", zzo.zza);
            zzd(zzbg, zzo);
            return;
        }
        boolean z = false;
        try {
            Map<String, Object> zza2 = this.zza.zzp().zza(zzbg.zzb.zzb(), true);
            String zza3 = zzii.zza(zzbg.zza);
            if (zza3 == null) {
                zza3 = zzbg.zza;
            }
            z = zzb2.zza(new zzad(zza3, zzbg.zzd, zza2));
        } catch (zzc unused) {
            this.zza.zzj().zzg().zza("EES error. appId, eventName", zzo.zzb, zzbg.zza);
        }
        if (!z) {
            this.zza.zzj().zzp().zza("EES was not applied to event", zzbg.zza);
            zzd(zzbg, zzo);
            return;
        }
        if (zzb2.zzd()) {
            this.zza.zzj().zzp().zza("EES edited event", zzbg.zza);
            zzd(this.zza.zzp().zza(zzb2.zza().zzb()), zzo);
        } else {
            zzd(zzbg, zzo);
        }
        if (zzb2.zzc()) {
            for (zzad next : zzb2.zza().zzc()) {
                this.zza.zzj().zzp().zza("EES logging created event", next.zzb());
                zzd(this.zza.zzp().zza(next), zzo);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, Bundle bundle) {
        this.zza.zzf().zza(str, bundle);
    }

    public final void zza(zzbg zzbg, zzo zzo) {
        Preconditions.checkNotNull(zzbg);
        zzb(zzo, false);
        zza((Runnable) new zzhx(this, zzbg, zzo));
    }

    public final void zza(zzbg zzbg, String str, String str2) {
        Preconditions.checkNotNull(zzbg);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zza((Runnable) new zzhw(this, zzbg, str));
    }

    private final void zzd(zzbg zzbg, zzo zzo) {
        this.zza.zzr();
        this.zza.zza(zzbg, zzo);
    }

    public final void zzd(zzo zzo) {
        Preconditions.checkNotEmpty(zzo.zza);
        zza(zzo.zza, false);
        zza((Runnable) new zzhs(this, zzo));
    }

    private final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzl().zzg()) {
            runnable.run();
        } else {
            this.zza.zzl().zzb(runnable);
        }
    }

    public final void zza(zzad zzad, zzo zzo) {
        Preconditions.checkNotNull(zzad);
        Preconditions.checkNotNull(zzad.zzc);
        zzb(zzo, false);
        zzad zzad2 = new zzad(zzad);
        zzad2.zza = zzo.zza;
        zza((Runnable) new zzhm(this, zzad2, zzo));
    }

    public final void zza(zzad zzad) {
        Preconditions.checkNotNull(zzad);
        Preconditions.checkNotNull(zzad.zzc);
        Preconditions.checkNotEmpty(zzad.zza);
        zza(zzad.zza, true);
        zza((Runnable) new zzhp(this, new zzad(zzad)));
    }

    public final void zze(zzo zzo) {
        Preconditions.checkNotEmpty(zzo.zza);
        Preconditions.checkNotNull(zzo.zzt);
        zzhv zzhv = new zzhv(this, zzo);
        Preconditions.checkNotNull(zzhv);
        if (this.zza.zzl().zzg()) {
            zzhv.run();
        } else {
            this.zza.zzl().zzc((Runnable) zzhv);
        }
    }

    public final void zza(long j, String str, String str2, String str3) {
        zza((Runnable) new zzhn(this, str2, str3, str, j));
    }

    public final void zza(Bundle bundle, zzo zzo) {
        zzb(zzo, false);
        String str = zzo.zza;
        Preconditions.checkNotNull(str);
        zza((Runnable) new zzhi(this, str, bundle));
    }

    public final void zzf(zzo zzo) {
        zzb(zzo, false);
        zza((Runnable) new zzhl(this, zzo));
    }

    public final void zza(zznc zznc, zzo zzo) {
        Preconditions.checkNotNull(zznc);
        zzb(zzo, false);
        zza((Runnable) new zzhy(this, zznc, zzo));
    }

    public final byte[] zza(zzbg zzbg, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbg);
        zza(str, true);
        this.zza.zzj().zzc().zza("Log and bundle. event", this.zza.zzg().zza(zzbg.zza));
        long nanoTime = this.zza.zzb().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzl().zzb(new zzhz(this, zzbg, str)).get();
            if (bArr == null) {
                this.zza.zzj().zzg().zza("Log and bundle returned null. appId", zzfr.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzj().zzc().zza("Log and bundle processed. event, size, time_ms", this.zza.zzg().zza(zzbg.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzb().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to log and bundle. appId, event, error", zzfr.zza(str), this.zza.zzg().zza(zzbg.zza), e);
            return null;
        }
    }
}
