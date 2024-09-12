package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzc extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzg zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    private /* synthetic */ Object zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzc(zzg zzg, String str, long j, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzg;
        this.zzc = str;
        this.zzd = j;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        zzc zzc2 = new zzc(this.zzb, this.zzc, this.zzd, continuation);
        zzc2.zze = obj;
        return zzc2;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzc) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i != 0) {
            obj2 = obj;
        } else {
            CoroutineScope coroutineScope = (CoroutineScope) this.zze;
            ArrayList arrayList = new ArrayList();
            for (zza zzb2 : this.zzb.zzc()) {
                arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new zzb(zzb2, this.zzc, this.zzd, (Continuation) null), 3, (Object) null));
            }
            Deferred[] deferredArr = (Deferred[]) arrayList.toArray(new Deferred[0]);
            this.zza = 1;
            obj2 = AwaitKt.awaitAll((Deferred<? extends T>[]) (Deferred[]) Arrays.copyOf(deferredArr, deferredArr.length), this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        String str = this.zzc;
        zzof zzf = zzog.zzf();
        zzf.zzd(str);
        for (Result r2 : (List) obj2) {
            Object r22 = r2.m992unboximpl();
            if (Result.m990isSuccessimpl(r22)) {
                zzf.zzg((zzog) r22);
            }
        }
        return (zzog) zzf.zzj();
    }
}
