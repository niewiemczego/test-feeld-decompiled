package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzacs extends zzadk implements zzaee {
    private zzacm zza;
    private zzacp zzb;
    private zzadp zzc;
    private final zzact zzd;
    private final FirebaseApp zze;
    private String zzf;
    private zzacv zzg;

    private final zzacv zzb() {
        if (this.zzg == null) {
            this.zzg = new zzacv(this.zze, this.zzd.zzb());
        }
        return this.zzg;
    }

    zzacs(FirebaseApp firebaseApp, zzact zzact) {
        this(firebaseApp, zzact, (zzadp) null, (zzacm) null, (zzacp) null);
    }

    private zzacs(FirebaseApp firebaseApp, zzact zzact, zzadp zzadp, zzacm zzacm, zzacp zzacp) {
        this.zze = firebaseApp;
        this.zzf = firebaseApp.getOptions().getApiKey();
        this.zzd = (zzact) Preconditions.checkNotNull(zzact);
        zza((zzadp) null, (zzacm) null, (zzacp) null);
        zzaec.zza(this.zzf, this);
    }

    public final void zza(zzaej zzaej, zzadm<zzaem> zzadm) {
        Preconditions.checkNotNull(zzaej);
        Preconditions.checkNotNull(zzadm);
        zzacm zzacm = this.zza;
        zzadl.zza(zzacm.zza("/createAuthUri", this.zzf), zzaej, zzadm, zzaem.class, zzacm.zza);
    }

    public final void zza(zzael zzael, zzadm<Void> zzadm) {
        Preconditions.checkNotNull(zzael);
        Preconditions.checkNotNull(zzadm);
        zzacm zzacm = this.zza;
        zzadl.zza(zzacm.zza("/deleteAccount", this.zzf), zzael, zzadm, Void.class, zzacm.zza);
    }

    public final void zza(zzaeo zzaeo, zzadm<zzaen> zzadm) {
        Preconditions.checkNotNull(zzaeo);
        Preconditions.checkNotNull(zzadm);
        zzacm zzacm = this.zza;
        zzadl.zza(zzacm.zza("/emailLinkSignin", this.zzf), zzaeo, zzadm, zzaen.class, zzacm.zza);
    }

    public final void zza(zzaeq zzaeq, zzadm<zzaep> zzadm) {
        Preconditions.checkNotNull(zzaeq);
        Preconditions.checkNotNull(zzadm);
        zzacp zzacp = this.zzb;
        zzadl.zza(zzacp.zza("/accounts/mfaEnrollment:finalize", this.zzf), zzaeq, zzadm, zzaep.class, zzacp.zza);
    }

    public final void zza(zzaes zzaes, zzadm<zzaer> zzadm) {
        Preconditions.checkNotNull(zzaes);
        Preconditions.checkNotNull(zzadm);
        zzacp zzacp = this.zzb;
        zzadl.zza(zzacp.zza("/accounts/mfaSignIn:finalize", this.zzf), zzaes, zzadm, zzaer.class, zzacp.zza);
    }

    public final void zza(zzafa zzafa, zzadm<zzafm> zzadm) {
        Preconditions.checkNotNull(zzafa);
        Preconditions.checkNotNull(zzadm);
        zzadp zzadp = this.zzc;
        zzadl.zza(zzadp.zza("/token", this.zzf), zzafa, zzadm, zzafm.class, zzadp.zza);
    }

    public final void zza(zzaez zzaez, zzadm<zzafc> zzadm) {
        Preconditions.checkNotNull(zzaez);
        Preconditions.checkNotNull(zzadm);
        zzacm zzacm = this.zza;
        zzadl.zza(zzacm.zza("/getAccountInfo", this.zzf), zzaez, zzadm, zzafc.class, zzacm.zza);
    }

    public final void zza(zzafd zzafd, zzadm<zzafg> zzadm) {
        Preconditions.checkNotNull(zzafd);
        Preconditions.checkNotNull(zzadm);
        if (zzafd.zzb() != null) {
            zzb().zzb(zzafd.zzb().zze());
        }
        zzacm zzacm = this.zza;
        zzadl.zza(zzacm.zza("/getOobConfirmationCode", this.zzf), zzafd, zzadm, zzafg.class, zzacm.zza);
    }

    public final void zza(zzaff zzaff, zzadm<zzafi> zzadm) {
        Preconditions.checkNotNull(zzaff);
        Preconditions.checkNotNull(zzadm);
        zzacm zzacm = this.zza;
        zzadl.zza(zzacm.zza("/getRecaptchaParam", this.zzf), zzadm, zzafi.class, zzacm.zza);
    }

    public final void zza(zzafk zzafk, zzadm<zzafj> zzadm) {
        Preconditions.checkNotNull(zzafk);
        Preconditions.checkNotNull(zzadm);
        zzacp zzacp = this.zzb;
        String zza2 = zzacp.zza("/recaptchaConfig", this.zzf);
        String zzb2 = zzafk.zzb();
        zzadl.zza(zza2 + "&clientType=" + zzb2 + "&version=" + zzafk.zzc(), zzadm, zzafj.class, zzacp.zza);
    }

    public final void zza() {
        zza((zzadp) null, (zzacm) null, (zzacp) null);
    }

    public final void zza(zzafw zzafw, zzadm<zzafv> zzadm) {
        Preconditions.checkNotNull(zzafw);
        Preconditions.checkNotNull(zzadm);
        zzacm zzacm = this.zza;
        zzadl.zza(zzacm.zza("/resetPassword", this.zzf), zzafw, zzadm, zzafv.class, zzacm.zza);
    }

    public final void zza(zzafy zzafy, zzadm<zzaga> zzadm) {
        Preconditions.checkNotNull(zzafy);
        Preconditions.checkNotNull(zzadm);
        zzacp zzacp = this.zzb;
        zzadl.zza(zzacp.zza("/accounts:revokeToken", this.zzf), zzafy, zzadm, zzaga.class, zzacp.zza);
    }

    public final void zza(zzafz zzafz, zzadm<zzagc> zzadm) {
        Preconditions.checkNotNull(zzafz);
        Preconditions.checkNotNull(zzadm);
        if (!TextUtils.isEmpty(zzafz.zzc())) {
            zzb().zzb(zzafz.zzc());
        }
        zzacm zzacm = this.zza;
        zzadl.zza(zzacm.zza("/sendVerificationCode", this.zzf), zzafz, zzadm, zzagc.class, zzacm.zza);
    }

    public final void zza(zzagb zzagb, zzadm<zzage> zzadm) {
        Preconditions.checkNotNull(zzagb);
        Preconditions.checkNotNull(zzadm);
        zzacm zzacm = this.zza;
        zzadl.zza(zzacm.zza("/setAccountInfo", this.zzf), zzagb, zzadm, zzage.class, zzacm.zza);
    }

    public final void zza(String str, zzadm<Void> zzadm) {
        Preconditions.checkNotNull(zzadm);
        zzb().zza(str);
        zzadm.zza(null);
    }

    public final void zza(zzagd zzagd, zzadm<zzagg> zzadm) {
        Preconditions.checkNotNull(zzagd);
        Preconditions.checkNotNull(zzadm);
        zzacm zzacm = this.zza;
        zzadl.zza(zzacm.zza("/signupNewUser", this.zzf), zzagd, zzadm, zzagg.class, zzacm.zza);
    }

    public final void zza(zzagf zzagf, zzadm<zzagi> zzadm) {
        Preconditions.checkNotNull(zzagf);
        Preconditions.checkNotNull(zzadm);
        if (zzagf instanceof zzagj) {
            zzagj zzagj = (zzagj) zzagf;
            if (!TextUtils.isEmpty(zzagj.zzb())) {
                zzb().zzb(zzagj.zzb());
            }
        }
        zzacp zzacp = this.zzb;
        zzadl.zza(zzacp.zza("/accounts/mfaEnrollment:start", this.zzf), zzagf, zzadm, zzagi.class, zzacp.zza);
    }

    public final void zza(zzagh zzagh, zzadm<zzagk> zzadm) {
        Preconditions.checkNotNull(zzagh);
        Preconditions.checkNotNull(zzadm);
        if (!TextUtils.isEmpty(zzagh.zzb())) {
            zzb().zzb(zzagh.zzb());
        }
        zzacp zzacp = this.zzb;
        zzadl.zza(zzacp.zza("/accounts/mfaSignIn:start", this.zzf), zzagh, zzadm, zzagk.class, zzacp.zza);
    }

    private final void zza(zzadp zzadp, zzacm zzacm, zzacp zzacp) {
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        String zza2 = zzadz.zza("firebear.secureToken");
        if (TextUtils.isEmpty(zza2)) {
            zza2 = zzaec.zzd(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for secureToken URL: " + zza2);
        }
        if (this.zzc == null) {
            this.zzc = new zzadp(zza2, zzb());
        }
        String zza3 = zzadz.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(zza3)) {
            zza3 = zzaec.zzb(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkit URL: " + zza3);
        }
        if (this.zza == null) {
            this.zza = new zzacm(zza3, zzb());
        }
        String zza4 = zzadz.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(zza4)) {
            zza4 = zzaec.zzc(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkitV2 URL: " + zza4);
        }
        if (this.zzb == null) {
            this.zzb = new zzacp(zza4, zzb());
        }
    }

    public final void zza(zzags zzags, zzadm<zzagu> zzadm) {
        Preconditions.checkNotNull(zzags);
        Preconditions.checkNotNull(zzadm);
        zzacm zzacm = this.zza;
        zzadl.zza(zzacm.zza("/verifyAssertion", this.zzf), zzags, zzadm, zzagu.class, zzacm.zza);
    }

    public final void zza(zzagt zzagt, zzadm<zzagw> zzadm) {
        Preconditions.checkNotNull(zzagt);
        Preconditions.checkNotNull(zzadm);
        zzacm zzacm = this.zza;
        zzadl.zza(zzacm.zza("/verifyCustomToken", this.zzf), zzagt, zzadm, zzagw.class, zzacm.zza);
    }

    public final void zza(zzagv zzagv, zzadm<zzagy> zzadm) {
        Preconditions.checkNotNull(zzagv);
        Preconditions.checkNotNull(zzadm);
        zzacm zzacm = this.zza;
        zzadl.zza(zzacm.zza("/verifyPassword", this.zzf), zzagv, zzadm, zzagy.class, zzacm.zza);
    }

    public final void zza(zzagx zzagx, zzadm<zzaha> zzadm) {
        Preconditions.checkNotNull(zzagx);
        Preconditions.checkNotNull(zzadm);
        zzacm zzacm = this.zza;
        zzadl.zza(zzacm.zza("/verifyPhoneNumber", this.zzf), zzagx, zzadm, zzaha.class, zzacm.zza);
    }

    public final void zza(zzagz zzagz, zzadm<zzahc> zzadm) {
        Preconditions.checkNotNull(zzagz);
        Preconditions.checkNotNull(zzadm);
        zzacp zzacp = this.zzb;
        zzadl.zza(zzacp.zza("/accounts/mfaEnrollment:withdraw", this.zzf), zzagz, zzadm, zzahc.class, zzacp.zza);
    }
}
