package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzer extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzez zzb;
    int zzc;
    zzez zzd;
    String zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzer(zzez zzez, Continuation continuation) {
        super(continuation);
        this.zzb = zzez;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zza2 = this.zzb.zza((String) null, 0, this);
        return zza2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? zza2 : Result.m982boximpl(zza2);
    }
}
