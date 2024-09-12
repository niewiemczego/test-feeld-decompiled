package com.google.android.recaptcha.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzao extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzaw zzb;
    int zzc;
    zzaw zzd;
    zzbb zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzao(zzaw zzaw, Continuation continuation) {
        super(continuation);
        this.zzb = zzaw;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        return this.zzb.zzj(0, (String) null, (zzbd) null, this);
    }
}
