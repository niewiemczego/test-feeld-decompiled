package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import com.google.android.exoplayer2.C;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.auth.PhoneAuthCredential;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzadt {
    /* access modifiers changed from: private */
    public static final Logger zza = new Logger("FirebaseAuth", "SmsRetrieverHelper");
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    /* access modifiers changed from: private */
    public final HashMap<String, zzaea> zzd = new HashMap<>();

    /* access modifiers changed from: package-private */
    public final zzacf zza(zzacf zzacf, String str) {
        return new zzady(this, zzacf, str);
    }

    static String zza(String str) {
        Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        Signature[] signatureArr;
        try {
            String packageName = this.zzb.getPackageName();
            if (Build.VERSION.SDK_INT < 28) {
                signatureArr = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 64).signatures;
            } else {
                signatureArr = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo.getApkContentsSigners();
            }
            String zza2 = zza(packageName, signatureArr[0].toCharsString());
            if (zza2 != null) {
                return zza2;
            }
            zza.e("Hash generation failed.", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            zza.e("Unable to find package to obtain hash.", new Object[0]);
            return null;
        }
    }

    private static String zza(String str, String str2) {
        String str3 = str + " " + str2;
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            instance.update(str3.getBytes(zzq.zza));
            String substring = Base64.encodeToString(Arrays.copyOf(instance.digest(), 9), 3).substring(0, 11);
            zza.d("Package: " + str + " -- Hash: " + substring, new Object[0]);
            return substring;
        } catch (NoSuchAlgorithmException e) {
            zza.e("NoSuchAlgorithm: " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    static /* synthetic */ void zza(zzadt zzadt, String str) {
        zzaea zzaea = zzadt.zzd.get(str);
        if (zzaea != null && !zzah.zzc(zzaea.zzd) && !zzah.zzc(zzaea.zze) && !zzaea.zzb.isEmpty()) {
            for (zzacf zza2 : zzaea.zzb) {
                zza2.zza(PhoneAuthCredential.zza(zzaea.zzd, zzaea.zze));
            }
            zzaea.zzh = true;
        }
    }

    zzadt(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzb = context;
        this.zzc = scheduledExecutorService;
    }

    /* access modifiers changed from: private */
    public final void zze(String str) {
        zzaea zzaea = this.zzd.get(str);
        if (zzaea != null && !zzaea.zzh && !zzah.zzc(zzaea.zzd)) {
            zza.w("Timed out waiting for SMS.", new Object[0]);
            for (zzacf zza2 : zzaea.zzb) {
                zza2.zza(zzaea.zzd);
            }
            zzaea.zzi = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzf */
    public final void zzb(String str) {
        zzaea zzaea = this.zzd.get(str);
        if (zzaea != null) {
            if (!zzaea.zzi) {
                zze(str);
            }
            zzc(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzacf zzacf, String str) {
        zzaea zzaea = this.zzd.get(str);
        if (zzaea != null) {
            zzaea.zzb.add(zzacf);
            if (zzaea.zzg) {
                zzacf.zzb(zzaea.zzd);
            }
            if (zzaea.zzh) {
                zzacf.zza(PhoneAuthCredential.zza(zzaea.zzd, zzaea.zze));
            }
            if (zzaea.zzi) {
                zzacf.zza(zzaea.zzd);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(String str) {
        zzaea zzaea = this.zzd.get(str);
        if (zzaea != null) {
            if (zzaea.zzf != null && !zzaea.zzf.isDone()) {
                zzaea.zzf.cancel(false);
            }
            zzaea.zzb.clear();
            this.zzd.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzacf zzacf, long j, boolean z) {
        this.zzd.put(str, new zzaea(j, z));
        zzb(zzacf, str);
        zzaea zzaea = this.zzd.get(str);
        if (zzaea.zza <= 0) {
            zza.w("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzaea.zzf = this.zzc.schedule(new zzadw(this, str), zzaea.zza, TimeUnit.SECONDS);
        if (!zzaea.zzc) {
            zza.w("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzadx zzadx = new zzadx(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SmsRetriever.SMS_RETRIEVED_ACTION);
        zzc.zza(this.zzb.getApplicationContext(), zzadx, intentFilter);
        SmsRetriever.getClient(this.zzb).startSmsRetriever().addOnFailureListener(new zzadv(this));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd(String str) {
        return this.zzd.get(str) != null;
    }
}
