package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzce {
    private static final zzce zza = new zzce();
    private final zzbl zzb;
    private final zzax zzc;

    public final Task<AuthResult> zza() {
        return this.zzb.zza();
    }

    public final Task<String> zzb() {
        return this.zzb.zzb();
    }

    public static zzce zzc() {
        return zza;
    }

    private zzce() {
        this(zzbl.zzc(), zzax.zza());
    }

    private zzce(zzbl zzbl, zzax zzax) {
        this.zzb = zzbl;
        this.zzc = zzax;
    }

    public final void zza(Context context) {
        this.zzb.zza(context);
    }

    public final void zza(FirebaseAuth firebaseAuth) {
        this.zzb.zza(firebaseAuth);
    }

    public final boolean zza(Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth) {
        return this.zzc.zza(activity, taskCompletionSource, firebaseAuth);
    }

    public final boolean zza(Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        return this.zzc.zza(activity, taskCompletionSource, firebaseAuth, firebaseUser);
    }
}
