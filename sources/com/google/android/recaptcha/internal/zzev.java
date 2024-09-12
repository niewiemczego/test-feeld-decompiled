package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzev extends ContinuationImpl {
    long zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zzez zzc;
    int zzd;
    zzez zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzev(zzez zzez, Continuation continuation) {
        super(continuation);
        this.zzc = zzez;
    }

    public final Object invokeSuspend(Object obj) {
        this.zzb = obj;
        this.zzd |= Integer.MIN_VALUE;
        Object zzb2 = this.zzc.zzb(0, (zzoe) null, this);
        return zzb2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? zzb2 : Result.m982boximpl(zzb2);
    }
}
