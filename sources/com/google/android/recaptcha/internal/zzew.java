package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzew extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzez zzb;
    final /* synthetic */ zzoe zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzew(zzez zzez, zzoe zzoe, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzez;
        this.zzc = zzoe;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzew(this.zzb, this.zzc, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzew) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i == 0) {
            zzez zzez = this.zzb;
            zzez.zzi.zza(zzez.zzp.zza(zzne.INIT_NATIVE));
            zzcb.zza(zznz.zzj(zzfy.zzh().zzj(this.zzc.zzJ())));
            this.zzb.zzn.zzd();
            this.zzb.zzn.zze();
            zzez.zzl(this.zzb, this.zzc);
            Boxing.boxInt(this.zzb.zzk().hashCode());
            CompletableDeferred zzk = this.zzb.zzk();
            this.zza = 1;
            if (zzk.await(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Result.m982boximpl(Result.m983constructorimpl(Unit.INSTANCE));
    }
}
