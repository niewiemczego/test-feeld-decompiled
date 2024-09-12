package com.google.android.recaptcha.internal;

import android.content.ContentValues;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzbl extends SuspendLambda implements Function2 {
    final /* synthetic */ zzbm zza;
    final /* synthetic */ zzpd zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbl(zzbm zzbm, zzpd zzpd, Continuation continuation) {
        super(2, continuation);
        this.zza = zzbm;
        this.zzb = zzpd;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzbl(this.zza, this.zzb, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbl) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzbm zzbm = this.zza;
        zzpd zzpd = this.zzb;
        synchronized (zzbh.class) {
            if (zzbm.zze != null) {
                byte[] zzd = zzpd.zzd();
                zzba zzba = new zzba(zzfy.zzg().zzi(zzd, 0, zzd.length), System.currentTimeMillis(), 0);
                zzaz zzb2 = zzbm.zze;
                ContentValues contentValues = new ContentValues();
                contentValues.put("ss", zzba.zzc());
                contentValues.put("ts", Long.valueOf(zzba.zzb()));
                zzb2.getWritableDatabase().insert("ce", (String) null, contentValues);
                int zzb3 = zzbm.zze.zzb() - 500;
                if (zzb3 > 0) {
                    zzbm.zze.zza(CollectionsKt.take(zzbm.zze.zzd(), zzb3));
                }
                if (zzbm.zze.zzb() >= 20) {
                    zzbm.zzg();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
