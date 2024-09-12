package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzd extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzg zzb;
    int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzd(zzg zzg, Continuation continuation) {
        super(continuation);
        this.zzb = zzg;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zzb2 = this.zzb.zzb(0, (zzoe) null, this);
        return zzb2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? zzb2 : Result.m982boximpl(zzb2);
    }
}
