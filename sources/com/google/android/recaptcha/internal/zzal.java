package com.google.android.recaptcha.internal;

import android.app.Application;
import android.os.Build;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzal extends SuspendLambda implements Function2 {
    final /* synthetic */ Application zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbd zzc;
    final /* synthetic */ zzbq zzd;
    final /* synthetic */ zzab zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzal(Application application, String str, zzbd zzbd, zzbq zzbq, zzab zzab, Continuation continuation) {
        super(2, continuation);
        this.zza = application;
        this.zzb = str;
        this.zzc = zzbd;
        this.zzd = zzbq;
        this.zze = zzab;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzal(this.zza, this.zzb, this.zzc, this.zzd, this.zze, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzal) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzaf zzaf = zzaf.zza;
        zzbd zzbd = this.zzc;
        Application application = this.zza;
        String zza2 = zzaf.zza(application);
        String packageName = application.getPackageName();
        String zzd2 = zzbd.zzd();
        zzq zzq = new zzq(application);
        int i = Build.VERSION.SDK_INT;
        String zza3 = zzq.zza("_GRECAPTCHA_KC");
        if (zza3 == null) {
            zza3 = "";
        }
        String encode = URLEncoder.encode(this.zzb, "UTF-8");
        String encode2 = URLEncoder.encode(packageName, "UTF-8");
        String encode3 = URLEncoder.encode(zza2, "UTF-8");
        String encode4 = URLEncoder.encode("18.4.0", "UTF-8");
        String encode5 = URLEncoder.encode(zzd2, "UTF-8");
        byte[] bytes = ("k=" + encode + "&pk=" + encode2 + "&mst=" + encode3 + "&msv=" + encode4 + "&msi=" + encode5 + "&mov=" + i + "&mkc=" + zza3).getBytes(Charset.forName("UTF-8"));
        zzbq zzbq = this.zzd;
        zzab zzab = this.zze;
        return zzbq.zza(zzab.zzb(), bytes, this.zzc);
    }
}
