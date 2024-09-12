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
final class zze extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zza zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzoe zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zze(zza zza2, long j, zzoe zzoe, Continuation continuation) {
        super(2, continuation);
        this.zzb = zza2;
        this.zzc = j;
        this.zzd = zzoe;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zze(this.zzb, this.zzc, this.zzd, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zze) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
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
            long j = this.zzc;
            zzoe zzoe = this.zzd;
            this.zza = 1;
            obj2 = zza2.zzb(j, zzoe, this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Result.m982boximpl(obj2);
    }
}
