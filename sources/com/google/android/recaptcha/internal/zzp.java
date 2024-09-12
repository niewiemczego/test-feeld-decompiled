package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaErrorCode;
import com.google.android.recaptcha.RecaptchaException;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzp extends Exception {
    public static final zzo zza = new zzo((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Map zzb = MapsKt.mapOf(TuplesKt.to(zzpb.JS_NETWORK_ERROR, new zzp(zzn.zze, zzl.zzm, (String) null)), TuplesKt.to(zzpb.JS_INTERNAL_ERROR, new zzp(zzn.zzc, zzl.zzk, (String) null)), TuplesKt.to(zzpb.JS_INVALID_SITE_KEY, new zzp(zzn.zzf, zzl.zzn, (String) null)), TuplesKt.to(zzpb.JS_INVALID_SITE_KEY_TYPE, new zzp(zzn.zzg, zzl.zzo, (String) null)), TuplesKt.to(zzpb.JS_THIRD_PARTY_APP_PACKAGE_NAME_NOT_ALLOWED, new zzp(zzn.zzh, zzl.zzp, (String) null)), TuplesKt.to(zzpb.JS_INVALID_ACTION, new zzp(zzn.zzi, zzl.zzq, (String) null)), TuplesKt.to(zzpb.JS_PROGRAM_ERROR, new zzp(zzn.zzc, zzl.zzu, (String) null)));
    private final zzn zzc;
    private final zzl zzd;
    private final String zze;
    private final Map zzf = MapsKt.mapOf(TuplesKt.to(zzn.zze, new RecaptchaException(RecaptchaErrorCode.NETWORK_ERROR, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzn.zzk, new RecaptchaException(RecaptchaErrorCode.NETWORK_ERROR, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzn.zzf, new RecaptchaException(RecaptchaErrorCode.INVALID_SITEKEY, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzn.zzg, new RecaptchaException(RecaptchaErrorCode.INVALID_KEYTYPE, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzn.zzh, new RecaptchaException(RecaptchaErrorCode.INVALID_PACKAGE_NAME, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzn.zzi, new RecaptchaException(RecaptchaErrorCode.INVALID_ACTION, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzn.zzc, new RecaptchaException(RecaptchaErrorCode.INTERNAL_ERROR, (String) null, 2, (DefaultConstructorMarker) null)));

    public zzp(zzn zzn, zzl zzl, String str) {
        this.zzc = zzn;
        this.zzd = zzl;
        this.zze = str;
    }

    public final zzl zza() {
        return this.zzd;
    }

    public final zzn zzb() {
        return this.zzc;
    }

    public final RecaptchaException zzc() {
        if (Intrinsics.areEqual((Object) this.zzd, (Object) zzl.zzT)) {
            return new RecaptchaException(RecaptchaErrorCode.INVALID_TIMEOUT, (String) null, 2, (DefaultConstructorMarker) null);
        }
        RecaptchaException recaptchaException = (RecaptchaException) this.zzf.get(this.zzc);
        return recaptchaException == null ? new RecaptchaException(RecaptchaErrorCode.INTERNAL_ERROR, (String) null, 2, (DefaultConstructorMarker) null) : recaptchaException;
    }

    public final String zzd() {
        return this.zze;
    }
}
