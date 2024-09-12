package com.google.android.gms.measurement.internal;

import io.sentry.SentryLockReason;
import io.sentry.protocol.App;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final /* synthetic */ class zzgr implements Callable {
    private /* synthetic */ zzgp zza;
    private /* synthetic */ String zzb;

    public /* synthetic */ zzgr(zzgp zzgp, String str) {
        this.zza = zzgp;
        this.zzb = str;
    }

    public final Object call() {
        zzgp zzgp = this.zza;
        String str = this.zzb;
        zzh zzd = zzgp.zzh().zzd(str);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put(SentryLockReason.JsonKeys.PACKAGE_NAME, str);
        hashMap.put("gmp_version", 82001L);
        if (zzd != null) {
            String zzaa = zzd.zzaa();
            if (zzaa != null) {
                hashMap.put(App.JsonKeys.APP_VERSION, zzaa);
            }
            hashMap.put("app_version_int", Long.valueOf(zzd.zzc()));
            hashMap.put("dynamite_version", Long.valueOf(zzd.zzm()));
        }
        return hashMap;
    }
}
