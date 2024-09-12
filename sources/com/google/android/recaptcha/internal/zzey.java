package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzey extends SuspendLambda implements Function2 {
    final /* synthetic */ zzez zza;
    final /* synthetic */ zzoe zzb;
    final /* synthetic */ zzbb zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzey(zzez zzez, zzoe zzoe, zzbb zzbb, Continuation continuation) {
        super(2, continuation);
        this.zza = zzez;
        this.zzb = zzoe;
        this.zzc = zzbb;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzey(this.zza, this.zzb, this.zzc, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzey) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        try {
            zzez zzez = this.zza;
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.zza.zzq.zzb(), (CoroutineContext) null, (CoroutineStart) null, new zzex(this.zza, zzez.zzf().zzb(this.zzb, zzez.zzp), (Continuation) null), 3, (Object) null);
        } catch (zzp e) {
            zzez zzez2 = this.zza;
            zzez2.zzi.zzb(this.zzc, e, (String) null);
            this.zza.zzk().completeExceptionally(e);
        }
        return Unit.INSTANCE;
    }
}
