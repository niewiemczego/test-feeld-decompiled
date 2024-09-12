package com.google.android.recaptcha.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzca implements zzbu {
    public static final zzbv zza = new zzbv((DefaultConstructorMarker) null);
    private final CoroutineScope zzb;
    private final zzcl zzc;
    /* access modifiers changed from: private */
    public final zzee zzd;
    private final Map zze;
    private final Map zzf;

    public zzca(CoroutineScope coroutineScope, zzcl zzcl, zzee zzee, Map map) {
        this.zzb = coroutineScope;
        this.zzc = zzcl;
        this.zzd = zzee;
        this.zze = map;
        this.zzf = zzcl.zzb().zzc();
    }

    /* access modifiers changed from: private */
    public final Object zzg(List list, zzcj zzcj, Continuation continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new zzbx(zzcj, list, this, (Continuation) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object zzh(Exception exc, zzcj zzcj, Continuation continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new zzby(exc, zzcj, this, (Continuation) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void zzi(zzpr zzpr, zzcj zzcj) throws zzae {
        zzfh zzb2 = zzfh.zzb();
        int zza2 = zzcj.zza();
        zzdd zzdd = (zzdd) this.zze.get(Integer.valueOf(zzpr.zzf()));
        if (zzdd != null) {
            int zzg = zzpr.zzg();
            zzpq[] zzpqArr = (zzpq[]) zzpr.zzj().toArray(new zzpq[0]);
            zzdd.zza(zzg, zzcj, (zzpq[]) Arrays.copyOf(zzpqArr, zzpqArr.length));
            if (zza2 == zzcj.zza()) {
                zzcj.zzg(zzcj.zza() + 1);
            }
            zzb2.zzf();
            long zza3 = zzb2.zza(TimeUnit.MICROSECONDS);
            zzv zzv = zzv.zza;
            int zzk = zzpr.zzk();
            if (zzk != 1) {
                zzv.zza(zzk - 2, zza3);
                zzpr.zzk();
                zzpr.zzg();
                CollectionsKt.joinToString$default(zzpr.zzj(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new zzbw(this), 31, (Object) null);
                return;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        throw new zzae(5, 2, (Throwable) null);
    }

    public final void zza(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.zzb, (CoroutineContext) null, (CoroutineStart) null, new zzbz(new zzcj(this.zzc), this, str, (Continuation) null), 3, (Object) null);
    }
}
