package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzas extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzaw zzb;
    int zzc;
    zzaw zzd;
    zzbd zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzas(zzaw zzaw, Continuation continuation) {
        super(continuation);
        this.zzb = zzaw;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zze2 = this.zzb.zzk((RecaptchaAction) null, 0, this);
        return zze2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? zze2 : Result.m982boximpl(zze2);
    }
}
