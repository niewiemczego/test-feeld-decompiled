package com.google.android.gms.internal.p002firebaseauthapi;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.zzd;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzafb {
    private String zza;
    private String zzb;
    private boolean zzc;
    private String zzd;
    private String zze;
    private zzafu zzf;
    private String zzg;
    private String zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private zzd zzl;
    private List<zzafq> zzm;
    private zzaq<zzafp> zzn;

    public final long zza() {
        return this.zzi;
    }

    public final long zzb() {
        return this.zzj;
    }

    public final Uri zzc() {
        if (!TextUtils.isEmpty(this.zze)) {
            return Uri.parse(this.zze);
        }
        return null;
    }

    public final zzaq<zzafp> zzd() {
        return this.zzn;
    }

    public final zzd zze() {
        return this.zzl;
    }

    public final zzafb zza(zzd zzd2) {
        this.zzl = zzd2;
        return this;
    }

    public final zzafb zza(String str) {
        this.zzd = str;
        return this;
    }

    public final zzafb zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzafb zza(boolean z) {
        this.zzk = z;
        return this;
    }

    public final zzafb zzc(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzg = str;
        return this;
    }

    public final zzafb zzd(String str) {
        this.zze = str;
        return this;
    }

    public final zzafb zza(List<zzafr> list) {
        Preconditions.checkNotNull(list);
        zzafu zzafu = new zzafu();
        this.zzf = zzafu;
        zzafu.zza().addAll(list);
        return this;
    }

    public final zzafu zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzd;
    }

    public final String zzh() {
        return this.zzb;
    }

    public final String zzi() {
        return this.zza;
    }

    public final String zzj() {
        return this.zzh;
    }

    public final List<zzafq> zzk() {
        return this.zzm;
    }

    public final List<zzafr> zzl() {
        return this.zzf.zza();
    }

    public zzafb() {
        this.zzf = new zzafu();
        this.zzn = zzaq.zzh();
    }

    public zzafb(String str, String str2, boolean z, String str3, String str4, zzafu zzafu, String str5, String str6, long j, long j2, boolean z2, zzd zzd2, List<zzafq> list, zzaq<zzafp> zzaq) {
        zzafu zzafu2;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = str3;
        this.zze = str4;
        if (zzafu == null) {
            zzafu2 = new zzafu();
        } else {
            List<zzafr> zza2 = zzafu.zza();
            zzafu zzafu3 = new zzafu();
            if (zza2 != null) {
                zzafu3.zza().addAll(zza2);
            }
            zzafu2 = zzafu3;
        }
        this.zzf = zzafu2;
        this.zzg = str5;
        this.zzh = str6;
        this.zzi = j;
        this.zzj = j2;
        this.zzk = false;
        this.zzl = null;
        this.zzm = list == null ? new ArrayList<>() : list;
        this.zzn = zzaq;
    }

    public final boolean zzm() {
        return this.zzc;
    }

    public final boolean zzn() {
        return this.zzk;
    }
}
