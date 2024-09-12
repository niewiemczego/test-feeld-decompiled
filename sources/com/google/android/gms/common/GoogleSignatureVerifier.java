package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.Set;
import javax.annotation.Nullable;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@CheckReturnValue
/* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
public class GoogleSignatureVerifier {
    @Nullable
    private static GoogleSignatureVerifier zza;
    @Nullable
    private static volatile Set zzb;
    private final Context zzc;
    private volatile String zzd;

    public GoogleSignatureVerifier(Context context) {
        this.zzc = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzn.zze(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    @Nullable
    static final zzj zza(PackageInfo packageInfo, zzj... zzjArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzk zzk = new zzk(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzjArr.length; i++) {
            if (zzjArr[i].equals(zzk)) {
                return zzjArr[i];
            }
        }
        return null;
    }

    public static final boolean zzb(PackageInfo packageInfo, boolean z) {
        zzj zzj;
        if (z && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null || (applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) {
                z = false;
            } else {
                z = true;
            }
        }
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                zzj = zza(packageInfo, zzm.zza);
            } else {
                zzj = zza(packageInfo, zzm.zza[0]);
            }
            if (zzj != null) {
                return true;
            }
        }
        return false;
    }

    private final zzx zzc(String str, boolean z, boolean z2) {
        zzx zzx;
        if (str == null) {
            return zzx.zzc("null pkg");
        }
        if (str.equals(this.zzd)) {
            return zzx.zzb();
        }
        if (zzn.zzg()) {
            zzx = zzn.zzb(str, GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.zzc.getPackageManager().getPackageInfo(str, 64);
                boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc);
                if (packageInfo == null) {
                    zzx = zzx.zzc("null pkg");
                } else if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
                    zzx = zzx.zzc("single cert required");
                } else {
                    zzk zzk = new zzk(packageInfo.signatures[0].toByteArray());
                    String str2 = packageInfo.packageName;
                    zzx zza2 = zzn.zza(str2, zzk, honorsDebugCertificates, false);
                    zzx = (!zza2.zza || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || !zzn.zza(str2, zzk, false, true).zza) ? zza2 : zzx.zzc("debuggable release cert app rejected");
                }
            } catch (PackageManager.NameNotFoundException e) {
                return zzx.zzd("no pkg ".concat(str), e);
            }
        }
        if (zzx.zza) {
            this.zzd = str;
        }
        return zzx;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zzb(packageInfo, false)) {
            return true;
        }
        if (zzb(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean isPackageGoogleSigned(String str) {
        zzx zzc2 = zzc(str, false, false);
        zzc2.zze();
        return zzc2.zza;
    }

    public boolean isUidGoogleSigned(int i) {
        zzx zzx;
        int length;
        String[] packagesForUid = this.zzc.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzx = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    Preconditions.checkNotNull(zzx);
                    break;
                }
                zzx = zzc(packagesForUid[i2], false, false);
                if (zzx.zza) {
                    break;
                }
                i2++;
            }
        } else {
            zzx = zzx.zzc("no pkgs");
        }
        zzx.zze();
        return zzx.zza;
    }
}
