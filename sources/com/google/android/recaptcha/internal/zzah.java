package com.google.android.recaptcha.internal;

import android.app.Application;
import android.webkit.WebView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzah extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ Application zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzah(Application application, String str, long j, zzbq zzbq, Continuation continuation) {
        super(2, continuation);
        this.zzb = application;
        this.zzc = str;
        this.zzd = j;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzah(this.zzb, this.zzc, this.zzd, (zzbq) null, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzah) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i == 0) {
            Application application = this.zzb;
            String str = this.zzc;
            long j = this.zzd;
            zzam zzam = zzam.zza;
            this.zza = 1;
            obj = zzam.zza(application, str, j, new zzab("https://www.recaptcha.net/recaptcha/api3"), (WebView) null, (zzbq) null, zzam.zze, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
