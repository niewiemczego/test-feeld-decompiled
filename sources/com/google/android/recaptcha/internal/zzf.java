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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzf extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzg zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzoe zzd;
    private /* synthetic */ Object zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzf(zzg zzg, long j, zzoe zzoe, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzg;
        this.zzc = j;
        this.zzd = zzoe;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        zzf zzf = new zzf(this.zzb, this.zzc, this.zzd, continuation);
        zzf.zze = obj;
        return zzf;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzf) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Ref.ObjectRef objectRef;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.zza != 0) {
            objectRef = (Ref.ObjectRef) this.zze;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.zze;
            ArrayList arrayList = new ArrayList();
            for (zza zze2 : this.zzb.zzc()) {
                arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new zze(zze2, this.zzc, this.zzd, (Continuation) null), 3, (Object) null));
            }
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Deferred[] deferredArr = (Deferred[]) arrayList.toArray(new Deferred[0]);
            this.zze = objectRef2;
            this.zza = 1;
            obj2 = AwaitKt.awaitAll((Deferred<? extends T>[]) (Deferred[]) Arrays.copyOf(deferredArr, deferredArr.length), this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        }
        for (Result r3 : (List) obj2) {
            T r32 = Result.m986exceptionOrNullimpl(r3.m992unboximpl());
            if (r32 != null) {
                T t = null;
                if (objectRef.element != null) {
                    t = new zzp(zzn.zzc, zzl.zzal, (String) null);
                } else if (r32 instanceof zzp) {
                    t = (zzp) r32;
                }
                objectRef.element = t;
            }
        }
        zzp zzp = (zzp) objectRef.element;
        if (zzp != null) {
            Result.Companion companion = Result.Companion;
            obj3 = ResultKt.createFailure(zzp);
        } else {
            Result.Companion companion2 = Result.Companion;
            obj3 = Unit.INSTANCE;
        }
        return Result.m982boximpl(Result.m983constructorimpl(obj3));
    }
}
