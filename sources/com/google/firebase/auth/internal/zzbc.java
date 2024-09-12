package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzach;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzbc extends BroadcastReceiver {
    private final WeakReference<Activity> zza;
    private final TaskCompletionSource<AuthResult> zzb;
    private final FirebaseAuth zzc;
    private final FirebaseUser zzd;
    private final /* synthetic */ zzax zze;

    zzbc(zzax zzax, Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zze = zzax;
        this.zza = new WeakReference<>(activity);
        this.zzb = taskCompletionSource;
        this.zzc = firebaseAuth;
        this.zzd = firebaseUser;
    }

    public final void onReceive(Context context, Intent intent) {
        if (((Activity) this.zza.get()) == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.zzb.setException(zzach.zza(new Status((int) FirebaseError.ERROR_INTERNAL_ERROR, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzax.zza(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(stringExtra)) {
                this.zzc.signInWithCredential(zzax.zza(intent)).addOnSuccessListener(new zzaz(this.zze, this.zzb, context)).addOnFailureListener(new zzaw(this.zze, this.zzb, context));
            } else if ("com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(stringExtra)) {
                this.zzd.linkWithCredential(zzax.zza(intent)).addOnSuccessListener(new zzbb(this.zze, this.zzb, context)).addOnFailureListener(new zzay(this.zze, this.zzb, context));
            } else if ("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(stringExtra)) {
                this.zzd.reauthenticateAndRetrieveData(zzax.zza(intent)).addOnSuccessListener(new zzbd(this.zze, this.zzb, context)).addOnFailureListener(new zzba(this.zze, this.zzb, context));
            } else {
                this.zzb.setException(zzach.zza(zzao.zza("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
            }
        } else if (zzcf.zzb(intent)) {
            this.zzb.setException(zzach.zza(zzcf.zza(intent)));
            zzax.zza(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            this.zzb.setException(zzach.zza(zzao.zza("WEB_CONTEXT_CANCELED")));
            zzax.zza(context);
        }
    }
}
