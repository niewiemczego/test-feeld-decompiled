package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaag;
import com.google.android.gms.internal.p002firebaseauthapi.zzach;
import com.google.android.gms.internal.p002firebaseauthapi.zzack;
import com.google.android.gms.internal.p002firebaseauthapi.zzacu;
import com.google.android.gms.internal.p002firebaseauthapi.zzads;
import com.google.android.gms.internal.p002firebaseauthapi.zzaec;
import com.google.android.gms.internal.p002firebaseauthapi.zzafi;
import com.google.android.gms.internal.p002firebaseauthapi.zzafj;
import com.google.android.gms.internal.p002firebaseauthapi.zzafm;
import com.google.android.gms.internal.p002firebaseauthapi.zzafz;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.FirebaseException;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzac;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzam;
import com.google.firebase.auth.internal.zzau;
import com.google.firebase.auth.internal.zzav;
import com.google.firebase.auth.internal.zzbi;
import com.google.firebase.auth.internal.zzbl;
import com.google.firebase.auth.internal.zzbx;
import com.google.firebase.auth.internal.zzby;
import com.google.firebase.auth.internal.zzcb;
import com.google.firebase.auth.internal.zzcc;
import com.google.firebase.auth.internal.zzce;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class FirebaseAuth implements InternalAuthProvider {
    /* access modifiers changed from: private */
    public final FirebaseApp zza;
    private final Executor zzaa;
    private String zzab;
    /* access modifiers changed from: private */
    public final List<IdTokenListener> zzb;
    /* access modifiers changed from: private */
    public final List<com.google.firebase.auth.internal.IdTokenListener> zzc;
    /* access modifiers changed from: private */
    public final List<AuthStateListener> zzd;
    /* access modifiers changed from: private */
    public final zzaag zze;
    /* access modifiers changed from: private */
    public FirebaseUser zzf;
    /* access modifiers changed from: private */
    public final zzac zzg;
    private final Object zzh;
    /* access modifiers changed from: private */
    public String zzi;
    private final Object zzj;
    /* access modifiers changed from: private */
    public String zzk;
    private zzbx zzl;
    private final RecaptchaAction zzm;
    private final RecaptchaAction zzn;
    private final RecaptchaAction zzo;
    private final RecaptchaAction zzp;
    private final RecaptchaAction zzq;
    private final RecaptchaAction zzr;
    private final zzby zzs;
    private final zzce zzt;
    private final com.google.firebase.auth.internal.zzb zzu;
    private final Provider<InteropAppCheckTokenProvider> zzv;
    private final Provider<HeartBeatController> zzw;
    private zzcb zzx;
    private final Executor zzy;
    private final Executor zzz;

    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public interface AuthStateListener {
        void onAuthStateChanged(FirebaseAuth firebaseAuth);
    }

    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public interface IdTokenListener {
        void onIdTokenChanged(FirebaseAuth firebaseAuth);
    }

    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    class zza implements zzau, zzl {
        zza() {
        }

        public final void zza(zzafm zzafm, FirebaseUser firebaseUser) {
            Preconditions.checkNotNull(zzafm);
            Preconditions.checkNotNull(firebaseUser);
            firebaseUser.zza(zzafm);
            FirebaseAuth.this.zza(firebaseUser, zzafm, true, true);
        }

        public final void zza(Status status) {
            if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005 || status.getStatusCode() == 17091) {
                FirebaseAuth.this.signOut();
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    class zzb implements zzl {
        zzb() {
        }

        public final void zza(zzafm zzafm, FirebaseUser firebaseUser) {
            Preconditions.checkNotNull(zzafm);
            Preconditions.checkNotNull(firebaseUser);
            firebaseUser.zza(zzafm);
            FirebaseAuth.this.zza(firebaseUser, zzafm, true);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    class zzc extends zzb implements zzau, zzl {
        zzc(FirebaseAuth firebaseAuth) {
            super();
        }

        public final void zza(Status status) {
        }
    }

    public Task<Void> applyActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zza(this.zza, str, this.zzk);
    }

    public Task<ActionCodeResult> checkActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzb(this.zza, str, this.zzk);
    }

    public Task<Void> confirmPasswordReset(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zze.zza(this.zza, str, str2, this.zzk);
    }

    public Task<AuthResult> createUserWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return new zzq(this, str, str2).zza(this, this.zzk, this.zzo, "EMAIL_PASSWORD_PROVIDER");
    }

    public final Task<Void> zza(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zza(firebaseUser, (zzav) new zzu(this, firebaseUser));
    }

    public final Task<Void> zza(FirebaseUser firebaseUser, MultiFactorAssertion multiFactorAssertion, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(multiFactorAssertion);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.zze.zza(this.zza, (PhoneMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, (zzl) new zzb());
        } else if (!(multiFactorAssertion instanceof TotpMultiFactorAssertion)) {
            return Tasks.forException(zzach.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR)));
        } else {
            return this.zze.zza(this.zza, (TotpMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, this.zzk, (zzl) new zzb());
        }
    }

    @Deprecated
    public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzc(this.zza, str, this.zzk);
    }

    public Task<GetTokenResult> getAccessToken(boolean z) {
        return zza(this.zzf, z);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.zzaa] */
    public final Task<GetTokenResult> zza(FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return Tasks.forException(zzach.zza(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        zzafm zzc2 = firebaseUser.zzc();
        if (!zzc2.zzg() || z) {
            return this.zze.zza(this.zza, firebaseUser, zzc2.zzd(), (zzcc) new zzaa(this));
        }
        return Tasks.forResult(zzbi.zza(zzc2.zzc()));
    }

    public Task<AuthResult> getPendingAuthResult() {
        return this.zzt.zza();
    }

    public final Task<zzafi> zza() {
        return this.zze.zza();
    }

    public final Task<zzafj> zza(String str) {
        return this.zze.zza(this.zzk, str);
    }

    public Task<Void> initializeRecaptchaConfig() {
        if (this.zzl == null) {
            this.zzl = new zzbx(this.zza, this);
        }
        return this.zzl.zza(this.zzk, (Boolean) false).continueWithTask(new zzz(this));
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<AuthResult> zza(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        if (authCredential instanceof EmailAuthCredential) {
            return new zzn(this, firebaseUser, (EmailAuthCredential) authCredential.zza()).zza(this, firebaseUser.getTenantId(), this.zzo, "EMAIL_PASSWORD_PROVIDER");
        }
        return this.zze.zza(this.zza, firebaseUser, authCredential.zza(), (String) null, (zzcc) new zza());
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.FirebaseAuth$zza] */
    /* JADX WARNING: type inference failed for: r9v0, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<Void> zzb(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return zza(firebaseUser, emailAuthCredential, false);
            }
            if (zzb(Preconditions.checkNotEmpty(emailAuthCredential.zze()))) {
                return Tasks.forException(zzach.zza(new Status(17072)));
            }
            return zza(firebaseUser, emailAuthCredential, true);
        } else if (zza2 instanceof PhoneAuthCredential) {
            return this.zze.zza(this.zza, firebaseUser, (PhoneAuthCredential) zza2, this.zzk, (zzcc) new zza());
        } else {
            return this.zze.zzb(this.zza, firebaseUser, zza2, firebaseUser.getTenantId(), (zzcc) new zza());
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.FirebaseAuth$zza] */
    /* JADX WARNING: type inference failed for: r9v0, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<AuthResult> zzc(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return zza(emailAuthCredential.zzc(), Preconditions.checkNotEmpty(emailAuthCredential.zzd()), firebaseUser.getTenantId(), firebaseUser, true);
            } else if (zzb(Preconditions.checkNotEmpty(emailAuthCredential.zze()))) {
                return Tasks.forException(zzach.zza(new Status(17072)));
            } else {
                return zza(emailAuthCredential, firebaseUser, true);
            }
        } else if (zza2 instanceof PhoneAuthCredential) {
            return this.zze.zzb(this.zza, firebaseUser, (PhoneAuthCredential) zza2, this.zzk, (zzcc) new zza());
        } else {
            return this.zze.zzc(this.zza, firebaseUser, zza2, firebaseUser.getTenantId(), new zza());
        }
    }

    private final Task<Void> zza(FirebaseUser firebaseUser, zzcc zzcc) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zza(this.zza, firebaseUser, zzcc);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<Void> zzb(FirebaseUser firebaseUser) {
        return zza(firebaseUser, (zzcc) new zza());
    }

    public final Task<AuthResult> zza(MultiFactorAssertion multiFactorAssertion, zzam zzam, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzam);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.zze.zza(this.zza, firebaseUser, (PhoneMultiFactorAssertion) multiFactorAssertion, Preconditions.checkNotEmpty(zzam.zzc()), (zzl) new zzb());
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            return this.zze.zza(this.zza, firebaseUser, (TotpMultiFactorAssertion) multiFactorAssertion, Preconditions.checkNotEmpty(zzam.zzc()), this.zzk, (zzl) new zzb());
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public Task<Void> revokeAccessToken(String str) {
        Preconditions.checkNotEmpty(str);
        FirebaseUser currentUser = getCurrentUser();
        Preconditions.checkNotNull(currentUser);
        return currentUser.getIdToken(false).continueWithTask(new zzv(this, str));
    }

    public final Task<Void> zza(ActionCodeSettings actionCodeSettings, String str) {
        Preconditions.checkNotEmpty(str);
        if (this.zzi != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zzb();
            }
            actionCodeSettings.zza(this.zzi);
        }
        return this.zze.zza(this.zza, actionCodeSettings, str);
    }

    public Task<Void> sendPasswordResetEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return sendPasswordResetEmail(str, (ActionCodeSettings) null);
    }

    public Task<Void> sendPasswordResetEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str2 = this.zzi;
        if (str2 != null) {
            actionCodeSettings.zza(str2);
        }
        actionCodeSettings.zza(1);
        return new zzp(this, str, actionCodeSettings).zza(this, this.zzk, this.zzm, "EMAIL_PASSWORD_PROVIDER");
    }

    public Task<Void> sendSignInLinkToEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(actionCodeSettings);
        if (actionCodeSettings.canHandleCodeInApp()) {
            String str2 = this.zzi;
            if (str2 != null) {
                actionCodeSettings.zza(str2);
            }
            return new zzs(this, str, actionCodeSettings).zza(this, this.zzk, this.zzm, "EMAIL_PASSWORD_PROVIDER");
        }
        throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
    }

    public Task<Void> setFirebaseUIVersion(String str) {
        return this.zze.zza(str);
    }

    public Task<AuthResult> signInAnonymously() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser == null || !firebaseUser.isAnonymous()) {
            return this.zze.zza(this.zza, (zzl) new zzb(), this.zzk);
        }
        zzaf zzaf = (zzaf) this.zzf;
        zzaf.zza(false);
        return Tasks.forResult(new zzz(zzaf));
    }

    public Task<AuthResult> signInWithCredential(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if (!emailAuthCredential.zzf()) {
                return zza(emailAuthCredential.zzc(), (String) Preconditions.checkNotNull(emailAuthCredential.zzd()), this.zzk, (FirebaseUser) null, false);
            } else if (zzb(Preconditions.checkNotEmpty(emailAuthCredential.zze()))) {
                return Tasks.forException(zzach.zza(new Status(17072)));
            } else {
                return zza(emailAuthCredential, (FirebaseUser) null, false);
            }
        } else if (!(zza2 instanceof PhoneAuthCredential)) {
            return this.zze.zza(this.zza, zza2, this.zzk, (zzl) new zzb());
        } else {
            return this.zze.zza(this.zza, (PhoneAuthCredential) zza2, this.zzk, (zzl) new zzb());
        }
    }

    public Task<AuthResult> signInWithCustomToken(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zza(this.zza, str, this.zzk, (zzl) new zzb());
    }

    public Task<AuthResult> signInWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return zza(str, str2, this.zzk, (FirebaseUser) null, false);
    }

    public Task<AuthResult> signInWithEmailLink(String str, String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    public final Task<AuthResult> zza(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzt.zza(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzach.zza(new Status(17057)));
        }
        zzbl.zza(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zza(activity);
        return taskCompletionSource.getTask();
    }

    public final Task<AuthResult> zzb(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzt.zza(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzach.zza(new Status(17057)));
        }
        zzbl.zza(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzb(activity);
        return taskCompletionSource.getTask();
    }

    public Task<AuthResult> startActivityForSignInWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzt.zza(activity, taskCompletionSource, this)) {
            return Tasks.forException(zzach.zza(new Status(17057)));
        }
        zzbl.zza(activity.getApplicationContext(), this);
        federatedAuthProvider.zzc(activity);
        return taskCompletionSource.getTask();
    }

    public final Task<TotpSecret> zza(zzam zzam) {
        Preconditions.checkNotNull(zzam);
        return this.zze.zza(zzam, this.zzk).continueWithTask(new zzw(this));
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<Void> zza(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zze.zza(this.zza, firebaseUser, str, this.zzk, (zzcc) new zza()).continueWithTask(new zzr(this));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<AuthResult> zzb(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zzb(this.zza, firebaseUser, str, new zza());
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.FirebaseAuth$zzc] */
    public Task<Void> updateCurrentUser(FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser != null) {
            String tenantId = firebaseUser.getTenantId();
            if ((tenantId != null && !tenantId.equals(this.zzk)) || ((str = this.zzk) != null && !str.equals(tenantId))) {
                return Tasks.forException(zzach.zza(new Status(17072)));
            }
            String apiKey = firebaseUser.zza().getOptions().getApiKey();
            String apiKey2 = this.zza.getOptions().getApiKey();
            if (!firebaseUser.zzc().zzg() || !apiKey2.equals(apiKey)) {
                return zza(firebaseUser, (zzcc) new zzc(this));
            }
            zza(zzaf.zza(this.zza, firebaseUser), firebaseUser.zzc(), true);
            return Tasks.forResult(null);
        }
        throw new IllegalArgumentException("Cannot update current user with null user!");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<Void> zzc(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zze.zzc(this.zza, firebaseUser, str, new zza());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<Void> zzd(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zze.zzd(this.zza, firebaseUser, str, new zza());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<Void> zza(FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(phoneAuthCredential);
        return this.zze.zza(this.zza, firebaseUser, (PhoneAuthCredential) phoneAuthCredential.zza(), (zzcc) new zza());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<Void> zza(FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(userProfileChangeRequest);
        return this.zze.zza(this.zza, firebaseUser, userProfileChangeRequest, (zzcc) new zza());
    }

    public final Task<Void> zza(String str, String str2, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str3 = this.zzi;
        if (str3 != null) {
            actionCodeSettings.zza(str3);
        }
        return this.zze.zza(str, str2, actionCodeSettings);
    }

    public Task<String> verifyPasswordResetCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzd(this.zza, str, this.zzk);
    }

    private final Task<Void> zza(FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, boolean z) {
        return new zzad(this, z, firebaseUser, emailAuthCredential).zza(this, this.zzk, z ? this.zzm : this.zzn, "EMAIL_PASSWORD_PROVIDER");
    }

    private final Task<AuthResult> zza(String str, String str2, String str3, FirebaseUser firebaseUser, boolean z) {
        return new zzac(this, str, z, firebaseUser, str2, str3).zza(this, str3, this.zzn, "EMAIL_PASSWORD_PROVIDER");
    }

    private final Task<AuthResult> zza(EmailAuthCredential emailAuthCredential, FirebaseUser firebaseUser, boolean z) {
        return new zzab(this, z, firebaseUser, emailAuthCredential).zza(this, this.zzk, this.zzm, "EMAIL_PASSWORD_PROVIDER");
    }

    public FirebaseApp getApp() {
        return this.zza;
    }

    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    public static FirebaseAuth getInstance(FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.get(FirebaseAuth.class);
    }

    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzg;
    }

    public FirebaseUser getCurrentUser() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(PhoneAuthOptions phoneAuthOptions, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        if (phoneAuthOptions.zzj()) {
            return onVerificationStateChangedCallbacks;
        }
        return new zzo(this, phoneAuthOptions, onVerificationStateChangedCallbacks);
    }

    /* access modifiers changed from: private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        return (!this.zzg.zzd() || str == null || !str.equals(this.zzg.zza())) ? onVerificationStateChangedCallbacks : new zzl(this, onVerificationStateChangedCallbacks);
    }

    public final synchronized zzbx zzb() {
        return this.zzl;
    }

    private final synchronized zzcb zzj() {
        return zzj(this);
    }

    private static zzcb zzj(FirebaseAuth firebaseAuth) {
        if (firebaseAuth.zzx == null) {
            firebaseAuth.zzx = new zzcb((FirebaseApp) Preconditions.checkNotNull(firebaseAuth.zza));
        }
        return firebaseAuth.zzx;
    }

    public final Provider<InteropAppCheckTokenProvider> zzc() {
        return this.zzv;
    }

    public final Provider<HeartBeatController> zzd() {
        return this.zzw;
    }

    public String getCustomAuthDomain() {
        return this.zzab;
    }

    public String getLanguageCode() {
        String str;
        synchronized (this.zzh) {
            str = this.zzi;
        }
        return str;
    }

    public String getTenantId() {
        String str;
        synchronized (this.zzj) {
            str = this.zzk;
        }
        return str;
    }

    public String getUid() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser == null) {
            return null;
        }
        return firebaseUser.getUid();
    }

    public final Executor zze() {
        return this.zzy;
    }

    public final Executor zzf() {
        return this.zzz;
    }

    public final Executor zzg() {
        return this.zzaa;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FirebaseAuth(com.google.firebase.FirebaseApp r13, com.google.firebase.inject.Provider<com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider> r14, com.google.firebase.inject.Provider<com.google.firebase.heartbeatinfo.HeartBeatController> r15, java.util.concurrent.Executor r16, java.util.concurrent.Executor r17, java.util.concurrent.Executor r18, java.util.concurrent.ScheduledExecutorService r19, java.util.concurrent.Executor r20) {
        /*
            r12 = this;
            com.google.android.gms.internal.firebase-auth-api.zzaag r2 = new com.google.android.gms.internal.firebase-auth-api.zzaag
            r1 = r13
            r9 = r17
            r0 = r19
            r2.<init>(r13, r9, r0)
            com.google.firebase.auth.internal.zzby r3 = new com.google.firebase.auth.internal.zzby
            android.content.Context r0 = r13.getApplicationContext()
            java.lang.String r4 = r13.getPersistenceKey()
            r3.<init>(r0, r4)
            com.google.firebase.auth.internal.zzce r4 = com.google.firebase.auth.internal.zzce.zzc()
            com.google.firebase.auth.internal.zzb r5 = com.google.firebase.auth.internal.zzb.zza()
            r0 = r12
            r6 = r14
            r7 = r15
            r8 = r16
            r10 = r18
            r11 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.<init>(com.google.firebase.FirebaseApp, com.google.firebase.inject.Provider, com.google.firebase.inject.Provider, java.util.concurrent.Executor, java.util.concurrent.Executor, java.util.concurrent.Executor, java.util.concurrent.ScheduledExecutorService, java.util.concurrent.Executor):void");
    }

    private FirebaseAuth(FirebaseApp firebaseApp, zzaag zzaag, zzby zzby, zzce zzce, com.google.firebase.auth.internal.zzb zzb2, Provider<InteropAppCheckTokenProvider> provider, Provider<HeartBeatController> provider2, Executor executor, Executor executor2, Executor executor3, Executor executor4) {
        zzafm zza2;
        this.zzb = new CopyOnWriteArrayList();
        this.zzc = new CopyOnWriteArrayList();
        this.zzd = new CopyOnWriteArrayList();
        this.zzh = new Object();
        this.zzj = new Object();
        this.zzm = RecaptchaAction.custom("getOobCode");
        this.zzn = RecaptchaAction.custom("signInWithPassword");
        this.zzo = RecaptchaAction.custom("signUpPassword");
        this.zzp = RecaptchaAction.custom("sendVerificationCode");
        this.zzq = RecaptchaAction.custom("mfaSmsEnrollment");
        this.zzr = RecaptchaAction.custom("mfaSmsSignIn");
        this.zza = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zze = (zzaag) Preconditions.checkNotNull(zzaag);
        zzby zzby2 = (zzby) Preconditions.checkNotNull(zzby);
        this.zzs = zzby2;
        this.zzg = new zzac();
        zzce zzce2 = (zzce) Preconditions.checkNotNull(zzce);
        this.zzt = zzce2;
        this.zzu = (com.google.firebase.auth.internal.zzb) Preconditions.checkNotNull(zzb2);
        this.zzv = provider;
        this.zzw = provider2;
        this.zzy = executor2;
        this.zzz = executor3;
        this.zzaa = executor4;
        FirebaseUser zza3 = zzby2.zza();
        this.zzf = zza3;
        if (!(zza3 == null || (zza2 = zzby2.zza(zza3)) == null)) {
            zza(this, this.zzf, zza2, false, false);
        }
        zzce2.zza(this);
    }

    public void addAuthStateListener(AuthStateListener authStateListener) {
        this.zzd.add(authStateListener);
        this.zzaa.execute(new zzt(this, authStateListener));
    }

    public void addIdTokenListener(IdTokenListener idTokenListener) {
        this.zzb.add(idTokenListener);
        this.zzaa.execute(new zzk(this, idTokenListener));
    }

    public void addIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.add(idTokenListener);
        zzj().zza(this.zzc.size());
    }

    public final void zzh() {
        Preconditions.checkNotNull(this.zzs);
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser != null) {
            zzby zzby = this.zzs;
            Preconditions.checkNotNull(firebaseUser);
            zzby.zza(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}));
            this.zzf = null;
        }
        this.zzs.zza("com.google.firebase.auth.FIREBASE_USER");
        zzb(this, (FirebaseUser) null);
        zza(this, (FirebaseUser) null);
    }

    public static void zza(FirebaseException firebaseException, PhoneAuthOptions phoneAuthOptions, String str) {
        Log.e("FirebaseAuth", "Invoking verification failure callback for phone number/uid - " + str);
        phoneAuthOptions.zzi().execute(new zzi(zzads.zza(str, phoneAuthOptions.zze(), (zzacw) null), firebaseException));
    }

    public void removeAuthStateListener(AuthStateListener authStateListener) {
        this.zzd.remove(authStateListener);
    }

    public void removeIdTokenListener(IdTokenListener idTokenListener) {
        this.zzb.remove(idTokenListener);
    }

    public void removeIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.remove(idTokenListener);
        zzj().zza(this.zzc.size());
    }

    public void setCustomAuthDomain(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.startsWith("chrome-extension://")) {
            this.zzab = str;
            return;
        }
        try {
            this.zzab = (String) Preconditions.checkNotNull(new URI(str.contains("://") ? str : "http://" + str).getHost());
        } catch (URISyntaxException e) {
            if (Log.isLoggable("FirebaseAuth", 4)) {
                Log.i("FirebaseAuth", "Error parsing URL: '" + str + "', " + e.getMessage());
            }
            this.zzab = str;
        }
    }

    public void setLanguageCode(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzh) {
            this.zzi = str;
        }
    }

    public final synchronized void zza(zzbx zzbx) {
        this.zzl = zzbx;
    }

    public void setTenantId(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzj) {
            this.zzk = str;
        }
    }

    public final void zza(FirebaseUser firebaseUser, zzafm zzafm, boolean z) {
        zza(firebaseUser, zzafm, true, false);
    }

    /* access modifiers changed from: package-private */
    public final void zza(FirebaseUser firebaseUser, zzafm zzafm, boolean z, boolean z2) {
        zza(this, firebaseUser, zzafm, true, z2);
    }

    public void signOut() {
        zzh();
        zzcb zzcb = this.zzx;
        if (zzcb != null) {
            zzcb.zza();
        }
    }

    private static void zza(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            Log.d("FirebaseAuth", "Notifying auth state listeners about user ( " + firebaseUser.getUid() + " ).");
        } else {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        }
        firebaseAuth.zzaa.execute(new zzx(firebaseAuth));
    }

    private static void zzb(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            Log.d("FirebaseAuth", "Notifying id token listeners about user ( " + firebaseUser.getUid() + " ).");
        } else {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        }
        firebaseAuth.zzaa.execute(new zzy(firebaseAuth, new InternalTokenResult(firebaseUser != null ? firebaseUser.zzd() : null)));
    }

    private static void zza(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser, zzafm zzafm, boolean z, boolean z2) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzafm);
        boolean z3 = false;
        boolean z4 = true;
        boolean z5 = firebaseAuth.zzf != null && firebaseUser.getUid().equals(firebaseAuth.zzf.getUid());
        if (z5 || !z2) {
            FirebaseUser firebaseUser2 = firebaseAuth.zzf;
            if (firebaseUser2 == null) {
                z3 = true;
            } else {
                boolean z6 = !z5 || (firebaseUser2.zzc().zzc().equals(zzafm.zzc()) ^ true);
                if (!z5) {
                    z3 = true;
                }
                z4 = z6;
            }
            Preconditions.checkNotNull(firebaseUser);
            if (firebaseAuth.zzf == null || !firebaseUser.getUid().equals(firebaseAuth.getUid())) {
                firebaseAuth.zzf = firebaseUser;
            } else {
                firebaseAuth.zzf.zza(firebaseUser.getProviderData());
                if (!firebaseUser.isAnonymous()) {
                    firebaseAuth.zzf.zzb();
                }
                firebaseAuth.zzf.zzb(firebaseUser.getMultiFactor().getEnrolledFactors());
            }
            if (z) {
                firebaseAuth.zzs.zzb(firebaseAuth.zzf);
            }
            if (z4) {
                FirebaseUser firebaseUser3 = firebaseAuth.zzf;
                if (firebaseUser3 != null) {
                    firebaseUser3.zza(zzafm);
                }
                zzb(firebaseAuth, firebaseAuth.zzf);
            }
            if (z3) {
                zza(firebaseAuth, firebaseAuth.zzf);
            }
            if (z) {
                firebaseAuth.zzs.zza(firebaseUser, zzafm);
            }
            FirebaseUser firebaseUser4 = firebaseAuth.zzf;
            if (firebaseUser4 != null) {
                zzj(firebaseAuth).zza(firebaseUser4.zzc());
            }
        }
    }

    public void useAppLanguage() {
        synchronized (this.zzh) {
            this.zzi = zzacu.zza();
        }
    }

    public void useEmulator(String str, int i) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(i >= 0 && i <= 65535, "Port number must be in the range 0-65535");
        zzaec.zza(this.zza, str, i);
    }

    public static void zza(PhoneAuthOptions phoneAuthOptions) {
        String str;
        String str2;
        PhoneAuthOptions phoneAuthOptions2 = phoneAuthOptions;
        if (phoneAuthOptions.zzl()) {
            FirebaseAuth zzb2 = phoneAuthOptions.zzb();
            zzam zzam = (zzam) Preconditions.checkNotNull(phoneAuthOptions.zzc());
            if (zzam.zzd()) {
                str2 = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
                str = str2;
            } else {
                PhoneMultiFactorInfo phoneMultiFactorInfo = (PhoneMultiFactorInfo) Preconditions.checkNotNull(phoneAuthOptions.zzf());
                str = Preconditions.checkNotEmpty(phoneMultiFactorInfo.getUid());
                str2 = phoneMultiFactorInfo.getPhoneNumber();
            }
            if (phoneAuthOptions.zzd() == null || !zzads.zza(str, phoneAuthOptions.zze(), phoneAuthOptions.zza(), phoneAuthOptions.zzi())) {
                zzb2.zzu.zza(zzb2, str2, phoneAuthOptions.zza(), zzb2.zzi(), phoneAuthOptions.zzj(), false, zzam.zzd() ? zzb2.zzq : zzb2.zzr).addOnCompleteListener(new zzm(zzb2, phoneAuthOptions2, str));
                return;
            }
            return;
        }
        FirebaseAuth zzb3 = phoneAuthOptions.zzb();
        String checkNotEmpty = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
        if ((phoneAuthOptions.zzd() != null) || !zzads.zza(checkNotEmpty, phoneAuthOptions.zze(), phoneAuthOptions.zza(), phoneAuthOptions.zzi())) {
            zzb3.zzu.zza(zzb3, checkNotEmpty, phoneAuthOptions.zza(), zzb3.zzi(), phoneAuthOptions.zzj(), false, zzb3.zzp).addOnCompleteListener(new zzj(zzb3, phoneAuthOptions2, checkNotEmpty));
        }
    }

    public final void zza(PhoneAuthOptions phoneAuthOptions, String str, String str2) {
        long longValue = phoneAuthOptions.zzg().longValue();
        if (longValue < 0 || longValue > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        String checkNotEmpty = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
        zzafz zzafz = new zzafz(checkNotEmpty, longValue, phoneAuthOptions.zzd() != null, this.zzi, this.zzk, str, str2, zzi());
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zza2 = zza(checkNotEmpty, phoneAuthOptions.zze());
        this.zze.zza(this.zza, zzafz, TextUtils.isEmpty(str) ? zza(phoneAuthOptions, zza2) : zza2, phoneAuthOptions.zza(), phoneAuthOptions.zzi());
    }

    /* access modifiers changed from: package-private */
    public final boolean zzi() {
        return zzack.zza(getApp().getApplicationContext());
    }

    public boolean isSignInWithEmailLink(String str) {
        return EmailAuthCredential.zza(str);
    }

    private final boolean zzb(String str) {
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(str);
        return parseLink != null && !TextUtils.equals(this.zzk, parseLink.zza());
    }
}
