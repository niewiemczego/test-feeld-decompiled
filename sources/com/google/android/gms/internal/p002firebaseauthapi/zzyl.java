package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zzd;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzyl {
    /* access modifiers changed from: private */
    public final zzadk zza;

    static /* synthetic */ void zza(zzyl zzyl, zzagu zzagu, zzacf zzacf, zzadj zzadj) {
        Status status;
        if (zzagu.zzo()) {
            zzd zzb = zzagu.zzb();
            String zzc = zzagu.zzc();
            String zzj = zzagu.zzj();
            if (zzagu.zzm()) {
                status = new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL);
            } else {
                status = zzao.zza(zzagu.zzd());
            }
            zzacf.zza(new zzyj(status, zzb, zzc, zzj));
            return;
        }
        zzyl.zza(new zzafm(zzagu.zzi(), zzagu.zze(), Long.valueOf(zzagu.zza()), "Bearer"), zzagu.zzh(), zzagu.zzg(), Boolean.valueOf(zzagu.zzn()), zzagu.zzb(), zzacf, zzadj);
    }

    static /* synthetic */ void zza(zzyl zzyl, zzacf zzacf, zzagd zzagd, zzadj zzadj) {
        Preconditions.checkNotNull(zzacf);
        Preconditions.checkNotNull(zzagd);
        Preconditions.checkNotNull(zzadj);
        zzyl.zza.zza(zzagd, (zzadm<zzagg>) new zzza(zzyl, zzacf, zzadj));
    }

    static /* synthetic */ void zza(zzyl zzyl, zzacf zzacf, zzafm zzafm, zzagb zzagb, zzadj zzadj) {
        Preconditions.checkNotNull(zzacf);
        Preconditions.checkNotNull(zzafm);
        Preconditions.checkNotNull(zzagb);
        Preconditions.checkNotNull(zzadj);
        zzyl.zza.zza(new zzaez(zzafm.zzc()), (zzadm<zzafc>) new zzyr(zzyl, zzadj, zzacf, zzafm, zzagb));
    }

    static /* synthetic */ void zza(zzyl zzyl, zzacf zzacf, zzafm zzafm, zzafb zzafb, zzagb zzagb, zzadj zzadj) {
        Preconditions.checkNotNull(zzacf);
        Preconditions.checkNotNull(zzafm);
        Preconditions.checkNotNull(zzafb);
        Preconditions.checkNotNull(zzagb);
        Preconditions.checkNotNull(zzadj);
        zzyl.zza.zza(zzagb, (zzadm<zzage>) new zzyq(zzyl, zzagb, zzafb, zzacf, zzafm, zzadj));
    }

    public zzyl(zzadk zzadk) {
        this.zza = (zzadk) Preconditions.checkNotNull(zzadk);
    }

    public final void zza(String str, String str2, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzacf);
        zzagb zzagb = new zzagb();
        zzagb.zze(str);
        zzagb.zzh(str2);
        this.zza.zza(zzagb, (zzadm<zzage>) new zzaaf(this, zzacf));
    }

    public final void zzb(String str, String str2, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzacf);
        zza(str, (zzadm<zzafm>) new zzaad(this, str2, zzacf));
    }

    public final void zzc(String str, String str2, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzacf);
        zza(str, (zzadm<zzafm>) new zzaac(this, str2, zzacf));
    }

    public final void zzd(String str, String str2, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(new zzafw(str, (String) null, str2), (zzadm<zzafv>) new zzyu(this, zzacf));
    }

    public final void zza(String str, String str2, String str3, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(new zzafw(str, str2, str3), (zzadm<zzafv>) new zzyw(this, zzacf));
    }

    public final void zza(String str, String str2, String str3, String str4, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(new zzagd(str, str2, (String) null, str3, str4, (String) null), (zzadm<zzagg>) new zzyn(this, zzacf));
    }

    public final void zza(String str, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzacf);
        zza(str, (zzadm<zzafm>) new zzzu(this, zzacf));
    }

    private final void zza(String str, zzadm<zzafm> zzadm) {
        Preconditions.checkNotNull(zzadm);
        Preconditions.checkNotEmpty(str);
        zzafm zzb = zzafm.zzb(str);
        if (zzb.zzg()) {
            zzadm.zza(zzb);
            return;
        }
        this.zza.zza(new zzafa(zzb.zzd()), (zzadm<zzafm>) new zzaae(this, zzadm));
    }

    public final void zza(zzaeq zzaeq, String str, zzacf zzacf) {
        Preconditions.checkNotNull(zzaeq);
        Preconditions.checkNotNull(zzacf);
        zza(str, (zzadm<zzafm>) new zzzm(this, zzaeq, zzacf));
    }

    public final void zza(zzaes zzaes, zzacf zzacf) {
        Preconditions.checkNotNull(zzaes);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(zzaes, (zzadm<zzaer>) new zzzo(this, zzacf));
    }

    /* access modifiers changed from: private */
    public final void zza(zzaeo zzaeo, zzacf zzacf) {
        Preconditions.checkNotNull(zzaeo);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(zzaeo, (zzadm<zzaen>) new zzyo(this, zzacf));
    }

    public final void zzb(String str, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(new zzafa(str), (zzadm<zzafm>) new zzyk(this, zzacf));
    }

    /* access modifiers changed from: private */
    public final void zza(zzafm zzafm, String str, String str2, Boolean bool, zzd zzd, zzacf zzacf, zzadj zzadj) {
        Preconditions.checkNotNull(zzafm);
        Preconditions.checkNotNull(zzadj);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(new zzaez(zzafm.zzc()), (zzadm<zzafc>) new zzyt(this, zzadj, str2, str, bool, zzd, zzacf, zzafm));
    }

    private final void zzb(zzafd zzafd, zzacf zzacf) {
        Preconditions.checkNotNull(zzafd);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(zzafd, (zzadm<zzafg>) new zzzz(this, zzacf));
    }

    public final void zza(zzaff zzaff, zzacf zzacf) {
        Preconditions.checkNotNull(zzaff);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(zzaff, (zzadm<zzafi>) new zzzt(this, zzacf));
    }

    public final void zze(String str, String str2, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(new zzaej(str, str2), (zzadm<zzaem>) new zzys(this, zzacf));
    }

    public final void zza(zzafk zzafk, zzacf zzacf) {
        Preconditions.checkNotNull(zzafk);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(zzafk, (zzadm<zzafj>) new zzzq(this, zzacf));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzacf);
        zza(str3, (zzadm<zzafm>) new zzzb(this, str, str2, str4, str5, zzacf));
    }

    public final void zza(String str, zzags zzags, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzags);
        Preconditions.checkNotNull(zzacf);
        zza(str, (zzadm<zzafm>) new zzzf(this, zzags, zzacf));
    }

    public final void zza(String str, zzagx zzagx, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzagx);
        Preconditions.checkNotNull(zzacf);
        zza(str, (zzadm<zzafm>) new zzzd(this, zzagx, zzacf));
    }

    public final void zzc(String str, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzacf);
        zza(str, (zzadm<zzafm>) new zzzs(this, zzacf));
    }

    public final void zza(zzafy zzafy, zzacf zzacf) {
        this.zza.zza(zzafy, (zzadm<zzaga>) new zzaab(this, zzacf));
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzacf);
        zzafd zzafd = new zzafd(4);
        zzafd.zzd(str);
        if (actionCodeSettings != null) {
            zzafd.zza(actionCodeSettings);
        }
        zzb(zzafd, zzacf);
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, String str2, String str3, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzacf);
        zzafd zzafd = new zzafd(actionCodeSettings.zza());
        zzafd.zzb(str);
        zzafd.zza(actionCodeSettings);
        zzafd.zzc(str2);
        zzafd.zza(str3);
        this.zza.zza(zzafd, (zzadm<zzafg>) new zzyv(this, zzacf));
    }

    public final void zza(zzafz zzafz, zzacf zzacf) {
        Preconditions.checkNotEmpty(zzafz.zzd());
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(zzafz, (zzadm<zzagc>) new zzyz(this, zzacf));
    }

    public final void zzd(String str, zzacf zzacf) {
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(str, (zzadm<Void>) new zzzw(this, zzacf));
    }

    public final void zze(String str, zzacf zzacf) {
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(new zzagd(str), (zzadm<zzagg>) new zzzy(this, zzacf));
    }

    public final void zza(zzags zzags, zzacf zzacf) {
        Preconditions.checkNotNull(zzags);
        Preconditions.checkNotNull(zzacf);
        zzags.zzb(true);
        this.zza.zza(zzags, (zzadm<zzagu>) new zzzk(this, zzacf));
    }

    public final void zza(zzagt zzagt, zzacf zzacf) {
        Preconditions.checkNotNull(zzagt);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(zzagt, (zzadm<zzagw>) new zzyx(this, zzacf));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(new zzagv(str, str2, str3, str4), (zzadm<zzagy>) new zzym(this, zzacf));
    }

    public final void zza(EmailAuthCredential emailAuthCredential, String str, zzacf zzacf) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zzacf);
        if (emailAuthCredential.zzg()) {
            zza(emailAuthCredential.zzb(), (zzadm<zzafm>) new zzyp(this, emailAuthCredential, str, zzacf));
        } else {
            zza(new zzaeo(emailAuthCredential, (String) null, str), zzacf);
        }
    }

    public final void zza(zzagx zzagx, zzacf zzacf) {
        Preconditions.checkNotNull(zzagx);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(zzagx, (zzadm<zzaha>) new zzyy(this, zzacf));
    }

    public final void zza(zzagf zzagf, zzacf zzacf) {
        Preconditions.checkNotNull(zzagf);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(zzagf, (zzadm<zzagi>) new zzzn(this, zzagf, zzacf));
    }

    public final void zza(zzagh zzagh, zzacf zzacf) {
        Preconditions.checkNotNull(zzagh);
        Preconditions.checkNotNull(zzacf);
        this.zza.zza(zzagh, (zzadm<zzagk>) new zzzr(this, zzacf));
    }

    public final void zzb(String str, String str2, String str3, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzacf);
        zza(str, (zzadm<zzafm>) new zzzi(this, str2, str3, zzacf));
    }

    public final void zzf(String str, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzacf);
        zza(str, (zzadm<zzafm>) new zzzh(this, zzacf));
    }

    public final void zzf(String str, String str2, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzacf);
        zza(str2, (zzadm<zzafm>) new zzzg(this, str, zzacf));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzacf zzacf) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzacf);
        zza(str, (zzadm<zzafm>) new zzaaa(this, userProfileChangeRequest, zzacf));
    }

    public final void zza(zzafd zzafd, zzacf zzacf) {
        zzb(zzafd, zzacf);
    }
}
