package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzau;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
abstract class zzacw<ResultT, CallbackT> implements zzadh<ResultT> {
    protected final int zza;
    private ResultT zzaa;
    private Status zzab;
    protected final zzacy zzb = new zzacy(this);
    protected FirebaseApp zzc;
    protected FirebaseUser zzd;
    protected CallbackT zze;
    protected zzau zzf;
    protected zzacx<ResultT> zzg;
    protected final List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> zzh = new ArrayList();
    protected Executor zzi;
    protected zzafm zzj;
    protected zzafb zzk;
    protected zzaem zzl;
    protected zzafv zzm;
    protected String zzn;
    protected String zzo;
    protected AuthCredential zzp;
    protected String zzq;
    protected String zzr;
    protected zzyi zzs;
    protected zzafj zzt;
    protected zzafi zzu;
    protected zzagi zzv;
    protected zzaga zzw;
    boolean zzx;
    private boolean zzy = true;
    /* access modifiers changed from: private */
    public boolean zzz;

    public final zzacw<ResultT, CallbackT> zza(CallbackT callbackt) {
        this.zze = Preconditions.checkNotNull(callbackt, "external callback cannot be null");
        return this;
    }

    public abstract void zzb();

    public final zzacw<ResultT, CallbackT> zza(zzau zzau) {
        this.zzf = (zzau) Preconditions.checkNotNull(zzau, "external failure callback cannot be null");
        return this;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacw$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    private static class zza extends LifecycleCallback {
        private final List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> zza;

        private zza(LifecycleFragment lifecycleFragment, List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> list) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("PhoneAuthActivityStopCallback", this);
            this.zza = list;
        }

        public static void zza(Activity activity, List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> list) {
            LifecycleFragment fragment = getFragment(activity);
            if (((zza) fragment.getCallbackOrNull("PhoneAuthActivityStopCallback", zza.class)) == null) {
                new zza(fragment, list);
            }
        }

        public void onStop() {
            synchronized (this.zza) {
                this.zza.clear();
            }
        }
    }

    public final zzacw<ResultT, CallbackT> zza(FirebaseApp firebaseApp) {
        this.zzc = (FirebaseApp) Preconditions.checkNotNull(firebaseApp, "firebaseApp cannot be null");
        return this;
    }

    public final zzacw<ResultT, CallbackT> zza(FirebaseUser firebaseUser) {
        this.zzd = (FirebaseUser) Preconditions.checkNotNull(firebaseUser, "firebaseUser cannot be null");
        return this;
    }

    public final zzacw<ResultT, CallbackT> zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, String str) {
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zza2 = zzads.zza(str, onVerificationStateChangedCallbacks, this);
        synchronized (this.zzh) {
            this.zzh.add((PhoneAuthProvider.OnVerificationStateChangedCallbacks) Preconditions.checkNotNull(zza2));
        }
        if (activity != null) {
            zza.zza(activity, this.zzh);
        }
        this.zzi = (Executor) Preconditions.checkNotNull(executor);
        return this;
    }

    static /* synthetic */ void zza(zzacw zzacw) {
        zzacw.zzb();
        Preconditions.checkState(zzacw.zzz, "no success or failure set on method implementation");
    }

    static /* synthetic */ void zza(zzacw zzacw, Status status) {
        zzau zzau = zzacw.zzf;
        if (zzau != null) {
            zzau.zza(status);
        }
    }

    public zzacw(int i) {
        this.zza = i;
    }

    public final void zza(Status status) {
        this.zzz = true;
        this.zzx = false;
        this.zzab = status;
        this.zzg.zza(null, status);
    }

    public final void zzb(ResultT resultt) {
        this.zzz = true;
        this.zzx = true;
        this.zzaa = resultt;
        this.zzg.zza(resultt, (Status) null);
    }
}
