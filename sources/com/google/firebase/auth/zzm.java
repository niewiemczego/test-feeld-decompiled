package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzam;
import com.google.firebase.auth.internal.zzb;
import com.google.firebase.auth.internal.zzj;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzm implements OnCompleteListener<zzj> {
    private final /* synthetic */ PhoneAuthOptions zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ FirebaseAuth zzc;

    zzm(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.zza = phoneAuthOptions;
        this.zzb = str;
        this.zzc = firebaseAuth;
    }

    public final void onComplete(Task<zzj> task) {
        String str;
        String str2;
        if (!task.isSuccessful()) {
            String str3 = "Error while validating application identity: ";
            Exception exception = task.getException();
            if (exception != null) {
                str3 = str3 + exception.getMessage();
            }
            Log.e("FirebaseAuth", str3);
            if (exception == null || !zzb.zza(exception)) {
                Log.e("FirebaseAuth", "Proceeding without any application identifier.");
                str2 = null;
                str = null;
            } else {
                FirebaseAuth.zza((FirebaseException) exception, this.zza, this.zzb);
                return;
            }
        } else {
            String zzc2 = task.getResult().zzc();
            str = task.getResult().zza();
            str2 = zzc2;
        }
        long longValue = this.zza.zzg().longValue();
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zza2 = this.zzc.zza(this.zza.zzh(), this.zza.zze());
        if (TextUtils.isEmpty(str2)) {
            zza2 = this.zzc.zza(this.zza, zza2);
        }
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks = zza2;
        zzam zzam = (zzam) Preconditions.checkNotNull(this.zza.zzc());
        if (zzam.zzd()) {
            this.zzc.zze.zza(zzam, (String) Preconditions.checkNotNull(this.zza.zzh()), this.zzc.zzi, longValue, this.zza.zzd() != null, this.zza.zzk(), str2, str, this.zzc.zzi(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
        } else {
            this.zzc.zze.zza(zzam, (PhoneMultiFactorInfo) Preconditions.checkNotNull(this.zza.zzf()), this.zzc.zzi, longValue, this.zza.zzd() != null, this.zza.zzk(), str2, str, this.zzc.zzi(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
        }
    }
}
