package com.google.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzafm;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class FirebaseUser extends AbstractSafeParcelable implements UserInfo {
    public abstract String getDisplayName();

    public abstract String getEmail();

    public abstract FirebaseUserMetadata getMetadata();

    public abstract MultiFactor getMultiFactor();

    public abstract String getPhoneNumber();

    public abstract Uri getPhotoUrl();

    public abstract List<? extends UserInfo> getProviderData();

    public abstract String getProviderId();

    public abstract String getTenantId();

    public abstract String getUid();

    public abstract boolean isAnonymous();

    public abstract FirebaseApp zza();

    public abstract FirebaseUser zza(List<? extends UserInfo> list);

    public abstract void zza(zzafm zzafm);

    public abstract FirebaseUser zzb();

    public abstract void zzb(List<MultiFactorInfo> list);

    public abstract zzafm zzc();

    public abstract String zzd();

    public abstract String zze();

    public abstract List<String> zzf();

    public Task<Void> delete() {
        return FirebaseAuth.getInstance(zza()).zza(this);
    }

    public Task<GetTokenResult> getIdToken(boolean z) {
        return FirebaseAuth.getInstance(zza()).zza(this, z);
    }

    public Task<AuthResult> linkWithCredential(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zza()).zza(this, authCredential);
    }

    public Task<Void> reauthenticate(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zza()).zzb(this, authCredential);
    }

    public Task<AuthResult> reauthenticateAndRetrieveData(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zza()).zzc(this, authCredential);
    }

    public Task<Void> reload() {
        return FirebaseAuth.getInstance(zza()).zzb(this);
    }

    public Task<Void> sendEmailVerification() {
        return FirebaseAuth.getInstance(zza()).zza(this, false).continueWithTask(new zzah(this));
    }

    public Task<Void> sendEmailVerification(ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zza()).zza(this, false).continueWithTask(new zzaj(this, actionCodeSettings));
    }

    public Task<AuthResult> startActivityForLinkWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        return FirebaseAuth.getInstance(zza()).zza(activity, federatedAuthProvider, this);
    }

    public Task<AuthResult> startActivityForReauthenticateWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        return FirebaseAuth.getInstance(zza()).zzb(activity, federatedAuthProvider, this);
    }

    public Task<AuthResult> unlink(String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zza()).zzb(this, str);
    }

    @Deprecated
    public Task<Void> updateEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zza()).zzc(this, str);
    }

    public Task<Void> updatePassword(String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zza()).zzd(this, str);
    }

    public Task<Void> updatePhoneNumber(PhoneAuthCredential phoneAuthCredential) {
        return FirebaseAuth.getInstance(zza()).zza(this, phoneAuthCredential);
    }

    public Task<Void> updateProfile(UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(userProfileChangeRequest);
        return FirebaseAuth.getInstance(zza()).zza(this, userProfileChangeRequest);
    }

    public Task<Void> verifyBeforeUpdateEmail(String str) {
        return verifyBeforeUpdateEmail(str, (ActionCodeSettings) null);
    }

    public Task<Void> verifyBeforeUpdateEmail(String str, ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zza()).zza(this, false).continueWithTask(new zzai(this, str, actionCodeSettings));
    }
}
