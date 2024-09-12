package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zzd;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzzl implements zzadm<zzahc> {
    private final /* synthetic */ zzzi zza;

    zzzl(zzzi zzzi) {
        this.zza = zzzi;
    }

    public final void zza(String str) {
        this.zza.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzahc zzahc = (zzahc) obj;
        if (TextUtils.isEmpty(zzahc.zza()) || TextUtils.isEmpty(zzahc.zzb())) {
            this.zza.zza.zza(zzao.zza("INTERNAL_SUCCESS_SIGN_OUT"));
            return;
        }
        this.zza.zzb.zza(new zzafm(zzahc.zzb(), zzahc.zza(), Long.valueOf(zzafo.zza(zzahc.zza())), "Bearer"), (String) null, (String) null, false, (zzd) null, this.zza.zza, this);
    }
}
