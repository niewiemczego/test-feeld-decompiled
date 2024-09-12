package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzab;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzah;
import com.google.firebase.auth.internal.zzam;
import com.google.firebase.auth.internal.zzau;
import com.google.firebase.auth.internal.zzav;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.internal.zzcc;
import com.google.firebase.auth.internal.zzl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaag  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzaag extends zzadf {
    public final Task<Void> zza(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzaaj) new zzaaj(str, str2).zza(firebaseApp));
    }

    public final Task<ActionCodeResult> zzb(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzaai) new zzaai(str, str2).zza(firebaseApp));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, String str2, String str3) {
        return zza((zzaal) new zzaal(str, str2, str3).zza(firebaseApp));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, String str2, String str3, String str4, zzl zzl) {
        return zza((zzaak) new zzaak(str, str2, str3, str4).zza(firebaseApp).zza(zzl));
    }

    public final Task<Void> zza(FirebaseUser firebaseUser, zzav zzav) {
        return zza((zzaan) new zzaan().zza(firebaseUser).zza(zzav).zza((zzau) zzav));
    }

    public final Task<SignInMethodQueryResult> zzc(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzaam) new zzaam(str, str2).zza(firebaseApp));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, PhoneMultiFactorAssertion phoneMultiFactorAssertion, FirebaseUser firebaseUser, String str, zzl zzl) {
        zzads.zza();
        zzaap zzaap = new zzaap(phoneMultiFactorAssertion, firebaseUser.zze(), str, (String) null);
        zzaap.zza(firebaseApp).zza(zzl);
        return zza(zzaap);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, TotpMultiFactorAssertion totpMultiFactorAssertion, FirebaseUser firebaseUser, String str, String str2, zzl zzl) {
        zzaap zzaap = new zzaap(totpMultiFactorAssertion, firebaseUser.zze(), str, str2);
        zzaap.zza(firebaseApp).zza(zzl);
        return zza(zzaap);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str, zzl zzl) {
        zzads.zza();
        zzaao zzaao = new zzaao(phoneMultiFactorAssertion, str, (String) null);
        zzaao.zza(firebaseApp).zza(zzl);
        if (firebaseUser != null) {
            zzaao.zza(firebaseUser);
        }
        return zza(zzaao);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, TotpMultiFactorAssertion totpMultiFactorAssertion, String str, String str2, zzl zzl) {
        zzaao zzaao = new zzaao(totpMultiFactorAssertion, str, str2);
        zzaao.zza(firebaseApp).zza(zzl);
        if (firebaseUser != null) {
            zzaao.zza(firebaseUser);
        }
        return zza(zzaao);
    }

    public final Task<GetTokenResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzcc zzcc) {
        return zza((zzaar) new zzaar(str).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<zzafi> zza() {
        return zza(new zzaaq());
    }

    public final Task<zzafj> zza(String str, String str2) {
        return zza(new zzaat(str, str2));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzcc zzcc) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzcc);
        List<String> zzf = firebaseUser.zzf();
        if (zzf != null && zzf.contains(authCredential.getProvider())) {
            return Tasks.forException(zzach.zza(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.zzf()) {
                return zza((zzaas) new zzaas(emailAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
            }
            return zza((zzaax) new zzaax(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
        } else if (authCredential instanceof PhoneAuthCredential) {
            zzads.zza();
            return zza((zzaau) new zzaau((PhoneAuthCredential) authCredential).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
        } else {
            Preconditions.checkNotNull(firebaseApp);
            Preconditions.checkNotNull(authCredential);
            Preconditions.checkNotNull(firebaseUser);
            Preconditions.checkNotNull(zzcc);
            return zza((zzaav) new zzaav(authCredential).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
        }
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzcc zzcc) {
        return zza((zzaaw) new zzaaw(authCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<AuthResult> zzc(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzcc zzcc) {
        return zza((zzaaz) new zzaaz(authCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, String str, zzcc zzcc) {
        return zza((zzaay) new zzaay(emailAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, String str, zzcc zzcc) {
        return zza((zzabb) new zzabb(emailAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, String str4, zzcc zzcc) {
        return zza((zzaba) new zzaba(str, str2, str3, str4).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, String str4, zzcc zzcc) {
        return zza((zzabd) new zzabd(str, str2, str3, str4).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzcc zzcc) {
        zzads.zza();
        return zza((zzabc) new zzabc(phoneAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzcc zzcc) {
        zzads.zza();
        return zza((zzabf) new zzabf(phoneAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, zzcc zzcc) {
        return zza((zzabe) new zzabe().zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<Void> zza(String str, String str2, String str3, String str4) {
        return zza(new zzabh(str, str2, str3, str4));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, ActionCodeSettings actionCodeSettings, String str) {
        return zza((zzabg) new zzabg(str, actionCodeSettings).zza(firebaseApp));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2, String str3) {
        actionCodeSettings.zza(1);
        return zza((zzabj) new zzabj(str, actionCodeSettings, str2, str3, "sendPasswordResetEmail").zza(firebaseApp));
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2, String str3) {
        actionCodeSettings.zza(6);
        return zza((zzabj) new zzabj(str, actionCodeSettings, str2, str3, "sendSignInLinkToEmail").zza(firebaseApp));
    }

    public final Task<Void> zza(String str) {
        return zza(new zzabi(str));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, zzl zzl, String str) {
        return zza((zzabl) new zzabl(str).zza(firebaseApp).zza(zzl));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, AuthCredential authCredential, String str, zzl zzl) {
        return zza((zzabk) new zzabk(authCredential, str).zza(firebaseApp).zza(zzl));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, String str2, zzl zzl) {
        return zza((zzabn) new zzabn(str, str2).zza(firebaseApp).zza(zzl));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, String str, String str2, String str3, String str4, zzl zzl) {
        return zza((zzabm) new zzabm(str, str2, str3, str4).zza(firebaseApp).zza(zzl));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, String str, zzl zzl) {
        return zza((zzabp) new zzabp(emailAuthCredential, str).zza(firebaseApp).zza(zzl));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, String str, zzl zzl) {
        zzads.zza();
        return zza((zzabo) new zzabo(phoneAuthCredential, str).zza(firebaseApp).zza(zzl));
    }

    public final Task<Void> zza(zzam zzam, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, boolean z3, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzabr zzabr = new zzabr(zzam, str, str2, j, z, z2, str3, str4, z3);
        String str5 = str;
        zzabr.zza(onVerificationStateChangedCallbacks, activity, executor, str);
        return zza(zzabr);
    }

    public final Task<zzagi> zza(zzam zzam, String str) {
        return zza(new zzabq(zzam, str));
    }

    public final Task<Void> zza(zzam zzam, PhoneMultiFactorInfo phoneMultiFactorInfo, String str, long j, boolean z, boolean z2, String str2, String str3, boolean z3, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzabt zzabt = new zzabt(phoneMultiFactorInfo, Preconditions.checkNotEmpty(zzam.zzc()), str, j, z, z2, str2, str3, z3);
        Activity activity2 = activity;
        zzabt.zza(onVerificationStateChangedCallbacks, activity2, executor, phoneMultiFactorInfo.getUid());
        return zza(zzabt);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, zzcc zzcc) {
        return zza((zzabs) new zzabs(firebaseUser.zze(), str, str2).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzcc zzcc) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzcc);
        List<String> zzf = firebaseUser.zzf();
        if ((zzf != null && !zzf.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzach.zza(new Status((int) FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        str.hashCode();
        if (!str.equals("password")) {
            return zza((zzabu) new zzabu(str).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
        }
        return zza((zzabv) new zzabv().zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<Void> zzc(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzcc zzcc) {
        return zza((zzabx) new zzabx(str).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<Void> zzd(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzcc zzcc) {
        return zza((zzabw) new zzabw(str).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, zzcc zzcc) {
        zzads.zza();
        return zza((zzabz) new zzabz(phoneAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, zzcc zzcc) {
        return zza((zzaby) new zzaby(userProfileChangeRequest).zza(firebaseApp).zza(firebaseUser).zza(zzcc).zza((zzau) zzcc));
    }

    public final Task<Void> zza(String str, String str2, ActionCodeSettings actionCodeSettings) {
        actionCodeSettings.zza(7);
        return zza(new zzacb(str, str2, actionCodeSettings));
    }

    public final Task<String> zzd(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzaca) new zzaca(str, str2).zza(firebaseApp));
    }

    static zzaf zza(FirebaseApp firebaseApp, zzafb zzafb) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzafb);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzab(zzafb, FirebaseAuthProvider.PROVIDER_ID));
        List<zzafr> zzl = zzafb.zzl();
        if (zzl != null && !zzl.isEmpty()) {
            for (int i = 0; i < zzl.size(); i++) {
                arrayList.add(new zzab(zzl.get(i)));
            }
        }
        zzaf zzaf = new zzaf(firebaseApp, arrayList);
        zzaf.zza(new zzah(zzafb.zzb(), zzafb.zza()));
        zzaf.zza(zzafb.zzn());
        zzaf.zza(zzafb.zze());
        zzaf.zzb(zzbk.zza(zzafb.zzk()));
        zzaf.zzc(zzafb.zzd());
        return zzaf;
    }

    public zzaag(FirebaseApp firebaseApp, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = new zzace(firebaseApp, scheduledExecutorService);
        this.zzb = executor;
    }

    public final void zza(FirebaseApp firebaseApp, zzafz zzafz, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        zza((zzacd) new zzacd(zzafz).zza(firebaseApp).zza(onVerificationStateChangedCallbacks, activity, executor, zzafz.zzd()));
    }
}
