package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzb extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zza zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzb(zza zza2, String str, long j, Continuation continuation) {
        super(2, continuation);
        this.zzb = zza2;
        this.zzc = str;
        this.zzd = j;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzb(this.zzb, this.zzc, this.zzd, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzb) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i != 0) {
            obj2 = ((Result) obj).m992unboximpl();
        } else {
            zza zza2 = this.zzb;
            String str = this.zzc;
            long j = this.zzd;
            this.zza = 1;
            obj2 = zza2.zza(str, j, this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Result.m982boximpl(obj2);
    }
}
