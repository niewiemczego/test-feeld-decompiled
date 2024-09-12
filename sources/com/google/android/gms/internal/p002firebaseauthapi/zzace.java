package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.TotpSecret;
import com.google.firebase.auth.UserProfileChangeRequest;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzace  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzace {
    private static final Logger zza = new Logger("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzyl zzb;
    private final zzadt zzc;

    zzace(FirebaseApp firebaseApp, ScheduledExecutorService scheduledExecutorService) {
        Preconditions.checkNotNull(firebaseApp);
        Context applicationContext = firebaseApp.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zzb = new zzyl(new zzacs(firebaseApp, zzact.zza()));
        this.zzc = new zzadt(applicationContext, scheduledExecutorService);
    }

    public final void zza(String str, String str2, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zza(str, str2, new zzacf(zzacc, zza));
    }

    public final void zzb(String str, String str2, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zzb(str, str2, new zzacf(zzacc, zza));
    }

    public final void zzc(String str, String str2, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zzc(str, str2, new zzacf(zzacc, zza));
    }

    public final void zzd(String str, String str2, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zzd(str, str2, new zzacf(zzacc, zza));
    }

    public final void zza(zzxx zzxx, zzacc zzacc) {
        Preconditions.checkNotNull(zzxx);
        Preconditions.checkNotEmpty(zzxx.zza());
        Preconditions.checkNotEmpty(zzxx.zzb());
        Preconditions.checkNotNull(zzacc);
        this.zzb.zza(zzxx.zza(), zzxx.zzb(), zzxx.zzc(), new zzacf(zzacc, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zza(str, str2, str3, str4, new zzacf(zzacc, zza));
    }

    public final void zza(String str, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zza(str, new zzacf(zzacc, zza));
    }

    public final void zza(MultiFactorAssertion multiFactorAssertion, String str, String str2, String str3, zzacc zzacc) {
        zzaeq zzaeq;
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotNull(zzacc);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential zza2 = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            zzaeq = zzaeu.zza(str, (String) Preconditions.checkNotNull(zza2.zzc()), (String) Preconditions.checkNotNull(zza2.getSmsCode()), str2, str3);
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
            zzaeq = zzaew.zza(str, Preconditions.checkNotEmpty(str2), Preconditions.checkNotEmpty(((TotpSecret) Preconditions.checkNotNull(totpMultiFactorAssertion.zza())).getSessionInfo()), Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzc()), str3);
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
        this.zzb.zza(zzaeq, str, new zzacf(zzacc, zza));
    }

    public final void zza(String str, MultiFactorAssertion multiFactorAssertion, String str2, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzacc);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential zza2 = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            this.zzb.zza((zzaes) zzaet.zza(str, (String) Preconditions.checkNotNull(zza2.zzc()), (String) Preconditions.checkNotNull(zza2.getSmsCode()), str2), new zzacf(zzacc, zza));
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
            this.zzb.zza((zzaes) zzaev.zza(str, Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzc()), str2, Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzb())), new zzacf(zzacc, zza));
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final void zzb(String str, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zzb(str, new zzacf(zzacc, zza));
    }

    public final void zza(zzxw zzxw, zzacc zzacc) {
        Preconditions.checkNotNull(zzxw);
        this.zzb.zza(zzaff.zzb(), new zzacf(zzacc, zza));
    }

    public final void zze(String str, String str2, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        this.zzb.zze(str, str2, new zzacf(zzacc, zza));
    }

    public final void zza(zzxz zzxz, zzacc zzacc) {
        Preconditions.checkNotNull(zzxz);
        this.zzb.zza(zzafk.zza(zzxz.zzb(), zzxz.zza()), new zzacf(zzacc, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zza(str, str2, str3, str4, str5, new zzacf(zzacc, zza));
    }

    public final void zza(String str, zzags zzags, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzags);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zza(str, zzags, new zzacf(zzacc, zza));
    }

    public final void zza(zzxy zzxy, zzacc zzacc) {
        Preconditions.checkNotNull(zzacc);
        Preconditions.checkNotNull(zzxy);
        this.zzb.zza(Preconditions.checkNotEmpty(zzxy.zzb()), zzadn.zza((PhoneAuthCredential) Preconditions.checkNotNull(zzxy.zza())), new zzacf(zzacc, zza));
    }

    public final void zzc(String str, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zzc(str, new zzacf(zzacc, zza));
    }

    public final void zza(zzafy zzafy, zzacc zzacc) {
        Preconditions.checkNotNull(zzafy);
        this.zzb.zza(zzafy, new zzacf(zzacc, zza));
    }

    public final void zza(zzyb zzyb, zzacc zzacc) {
        Preconditions.checkNotNull(zzyb);
        Preconditions.checkNotEmpty(zzyb.zzb());
        Preconditions.checkNotNull(zzacc);
        this.zzb.zza(zzyb.zzb(), zzyb.zza(), new zzacf(zzacc, zza));
    }

    public final void zza(zzya zzya, zzacc zzacc) {
        Preconditions.checkNotNull(zzya);
        Preconditions.checkNotEmpty(zzya.zzc());
        Preconditions.checkNotNull(zzacc);
        this.zzb.zza(zzya.zzc(), zzya.zza(), zzya.zzd(), zzya.zzb(), new zzacf(zzacc, zza));
    }

    public final void zza(zzyd zzyd, zzacc zzacc) {
        Preconditions.checkNotNull(zzacc);
        Preconditions.checkNotNull(zzyd);
        zzafz zzafz = (zzafz) Preconditions.checkNotNull(zzyd.zza());
        String zzd = zzafz.zzd();
        zzacf zzacf = new zzacf(zzacc, zza);
        if (this.zzc.zzd(zzd)) {
            if (zzafz.zze()) {
                this.zzc.zzc(zzd);
            } else {
                this.zzc.zzb(zzacf, zzd);
                return;
            }
        }
        long zzb2 = zzafz.zzb();
        boolean zzf = zzafz.zzf();
        if (zza(zzb2, zzf)) {
            zzafz.zza(new zzaed(this.zzc.zzb()));
        }
        this.zzc.zza(zzd, zzacf, zzb2, zzf);
        this.zzb.zza(zzafz, this.zzc.zza(zzacf, zzd));
    }

    public final void zza(zzyc zzyc, zzacc zzacc) {
        Preconditions.checkNotNull(zzyc);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zzd(zzyc.zza(), new zzacf(zzacc, zza));
    }

    public final void zzd(String str, zzacc zzacc) {
        Preconditions.checkNotNull(zzacc);
        this.zzb.zze(str, new zzacf(zzacc, zza));
    }

    public final void zza(zzags zzags, zzacc zzacc) {
        Preconditions.checkNotNull(zzags);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zza(zzags, new zzacf(zzacc, zza));
    }

    public final void zza(zzagt zzagt, zzacc zzacc) {
        Preconditions.checkNotNull(zzagt);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zza(zzagt, new zzacf(zzacc, zza));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzacc);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zzb(str, str2, str3, str4, new zzacf(zzacc, zza));
    }

    public final void zza(zzyf zzyf, zzacc zzacc) {
        Preconditions.checkNotNull(zzyf);
        Preconditions.checkNotNull(zzyf.zza());
        Preconditions.checkNotNull(zzacc);
        this.zzb.zza(zzyf.zza(), zzyf.zzb(), new zzacf(zzacc, zza));
    }

    public final void zza(zzye zzye, zzacc zzacc) {
        Preconditions.checkNotNull(zzacc);
        Preconditions.checkNotNull(zzye);
        this.zzb.zza(zzadn.zza((PhoneAuthCredential) Preconditions.checkNotNull(zzye.zza())), new zzacf(zzacc, zza));
    }

    public final void zza(String str, String str2, String str3, long j, boolean z, boolean z2, String str4, String str5, boolean z3, zzacc zzacc) {
        String str6 = str2;
        String str7 = str;
        Preconditions.checkNotEmpty(str, "idToken should not be empty.");
        Preconditions.checkNotNull(zzacc);
        zzacf zzacf = new zzacf(zzacc, zza);
        if (this.zzc.zzd(str2)) {
            if (z) {
                this.zzc.zzc(str2);
            } else {
                this.zzc.zzb(zzacf, str2);
                return;
            }
        }
        zzagj zza2 = zzagj.zza(str, str2, str3, str4, str5, (String) null);
        long j2 = j;
        if (zza(j, z3)) {
            zza2.zza(new zzaed(this.zzc.zzb()));
        }
        this.zzc.zza(str2, zzacf, j, z3);
        this.zzb.zza((zzagf) zza2, this.zzc.zza(zzacf, str2));
    }

    public final void zza(zzyh zzyh, zzacc zzacc) {
        Preconditions.checkNotNull(zzyh);
        Preconditions.checkNotNull(zzacc);
        String phoneNumber = zzyh.zzb().getPhoneNumber();
        zzacf zzacf = new zzacf(zzacc, zza);
        if (this.zzc.zzd(phoneNumber)) {
            if (zzyh.zzg()) {
                this.zzc.zzc(phoneNumber);
            } else {
                this.zzc.zzb(zzacf, phoneNumber);
                return;
            }
        }
        long zza2 = zzyh.zza();
        boolean zzh = zzyh.zzh();
        zzagh zza3 = zzagh.zza(zzyh.zzd(), zzyh.zzb().getUid(), zzyh.zzb().getPhoneNumber(), zzyh.zzc(), zzyh.zzf(), zzyh.zze());
        if (zza(zza2, zzh)) {
            zza3.zza(new zzaed(this.zzc.zzb()));
        }
        this.zzc.zza(phoneNumber, zzacf, zza2, zzh);
        this.zzb.zza(zza3, this.zzc.zza(zzacf, phoneNumber));
    }

    public final void zza(zzagl zzagl, zzacc zzacc) {
        this.zzb.zza((zzagf) zzagl, new zzacf((zzacc) Preconditions.checkNotNull(zzacc), zza));
    }

    public final void zza(String str, String str2, String str3, zzacc zzacc) {
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotEmpty(str2, "uid should not be empty.");
        Preconditions.checkNotNull(zzacc);
        this.zzb.zzb(str, str2, str3, new zzacf(zzacc, zza));
    }

    public final void zze(String str, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zzf(str, new zzacf(zzacc, zza));
    }

    public final void zzf(String str, String str2, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zzf(str, str2, new zzacf(zzacc, zza));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzacc zzacc) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzacc);
        this.zzb.zza(str, userProfileChangeRequest, new zzacf(zzacc, zza));
    }

    public final void zza(zzyg zzyg, zzacc zzacc) {
        Preconditions.checkNotNull(zzyg);
        this.zzb.zza(zzafd.zza(zzyg.zza(), zzyg.zzb(), zzyg.zzc()), new zzacf(zzacc, zza));
    }

    private static boolean zza(long j, boolean z) {
        if (j > 0 && z) {
            return true;
        }
        zza.w("App hash will not be appended to the request.", new Object[0]);
        return false;
    }
}
