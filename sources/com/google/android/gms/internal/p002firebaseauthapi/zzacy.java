package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzacy implements zzacc {
    final /* synthetic */ zzacw zza;

    zzacy(zzacw zzacw) {
        this.zza = zzacw;
    }

    private final void zza(zzadd zzadd) {
        this.zza.zzi.execute(new zzade(this, zzadd));
    }

    private final void zza(Status status, AuthCredential authCredential, String str, String str2) {
        zzacw.zza(this.zza, status);
        this.zza.zzp = authCredential;
        this.zza.zzq = str;
        this.zza.zzr = str2;
        if (this.zza.zzf != null) {
            this.zza.zzf.zza(status);
        }
        this.zza.zza(status);
    }

    public final void zza(String str) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 8, "Unexpected response type " + this.zza.zza);
        this.zza.zzo = str;
        this.zza.zzz = true;
        this.zza.zzx = true;
        zza((zzadd) new zzadc(this, str));
    }

    public final void zzb(String str) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 8, "Unexpected response type " + this.zza.zza);
        this.zza.zzo = str;
        zza((zzadd) new zzada(this, str));
    }

    public final void zza(zzaem zzaem) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 3, "Unexpected response type " + this.zza.zza);
        this.zza.zzl = zzaem;
        zzacw.zza(this.zza);
    }

    public final void zza() throws RemoteException {
        Preconditions.checkState(this.zza.zza == 5, "Unexpected response type " + this.zza.zza);
        zzacw.zza(this.zza);
    }

    public final void zza(zzyj zzyj) {
        zza(zzyj.zza(), zzyj.zzb(), zzyj.zzc(), zzyj.zzd());
    }

    public final void zza(zzyi zzyi) {
        this.zza.zzs = zzyi;
        this.zza.zza(zzao.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 2, "Unexpected response type " + this.zza.zza);
        zza(status, phoneAuthCredential, (String) null, (String) null);
    }

    public final void zza(Status status) throws RemoteException {
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null) {
            if (statusMessage.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (statusMessage.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (statusMessage.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (statusMessage.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (statusMessage.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (statusMessage.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (statusMessage.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (statusMessage.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (statusMessage.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (statusMessage.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        if (this.zza.zza == 8) {
            this.zza.zzz = true;
            this.zza.zzx = false;
            zza((zzadd) new zzadb(this, status));
            return;
        }
        zzacw.zza(this.zza, status);
        this.zza.zza(status);
    }

    public final void zza(zzafi zzafi) throws RemoteException {
        this.zza.zzu = zzafi;
        zzacw.zza(this.zza);
    }

    public final void zza(zzafj zzafj) throws RemoteException {
        this.zza.zzt = zzafj;
        zzacw.zza(this.zza);
    }

    public final void zza(zzafm zzafm, zzafb zzafb) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 2, "Unexpected response type: " + this.zza.zza);
        this.zza.zzj = zzafm;
        this.zza.zzk = zzafb;
        zzacw.zza(this.zza);
    }

    public final void zza(zzafv zzafv) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 4, "Unexpected response type " + this.zza.zza);
        this.zza.zzm = zzafv;
        zzacw.zza(this.zza);
    }

    public final void zza(zzaga zzaga) throws RemoteException {
        this.zza.zzw = zzaga;
        zzacw.zza(this.zza);
    }

    public final void zzb() throws RemoteException {
        Preconditions.checkState(this.zza.zza == 6, "Unexpected response type " + this.zza.zza);
        zzacw.zza(this.zza);
    }

    public final void zzc(String str) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 7, "Unexpected response type " + this.zza.zza);
        this.zza.zzn = str;
        zzacw.zza(this.zza);
    }

    public final void zzc() throws RemoteException {
        Preconditions.checkState(this.zza.zza == 9, "Unexpected response type " + this.zza.zza);
        zzacw.zza(this.zza);
    }

    public final void zza(zzagi zzagi) throws RemoteException {
        this.zza.zzv = zzagi;
        zzacw.zza(this.zza);
    }

    public final void zza(zzafm zzafm) throws RemoteException {
        boolean z = true;
        if (this.zza.zza != 1) {
            z = false;
        }
        Preconditions.checkState(z, "Unexpected response type: " + this.zza.zza);
        this.zza.zzj = zzafm;
        zzacw.zza(this.zza);
    }

    public final void zza(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 8, "Unexpected response type " + this.zza.zza);
        this.zza.zzz = true;
        this.zza.zzx = true;
        zza((zzadd) new zzacz(this, phoneAuthCredential));
    }
}
