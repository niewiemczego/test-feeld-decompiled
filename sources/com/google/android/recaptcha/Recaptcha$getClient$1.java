package com.google.android.recaptcha;

import android.app.Application;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class Recaptcha$getClient$1 extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ Recaptcha zzb;
    int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recaptcha$getClient$1(Recaptcha recaptcha, Continuation continuation) {
        super(continuation);
        this.zzb = recaptcha;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object r7 = this.zzb.m562getClientBWLJW6A((Application) null, (String) null, 0, this);
        return r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r7 : Result.m982boximpl(r7);
    }
}
