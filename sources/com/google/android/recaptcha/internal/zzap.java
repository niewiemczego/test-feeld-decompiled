package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzap extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzaw zzb;
    int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzap(zzaw zzaw, Continuation continuation) {
        super(continuation);
        this.zzb = zzaw;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object r4 = this.zzb.m565execute0E7RQCE((RecaptchaAction) null, 0, this);
        return r4 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r4 : Result.m982boximpl(r4);
    }
}
