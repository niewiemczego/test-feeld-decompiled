package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzby;
import io.sentry.SentryLockReason;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzgm {
    final zzhf zza;

    /* access modifiers changed from: package-private */
    public final Bundle zza(String str, zzby zzby) {
        this.zza.zzl().zzt();
        if (zzby == null) {
            this.zza.zzj().zzu().zza("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(SentryLockReason.JsonKeys.PACKAGE_NAME, str);
        try {
            Bundle zza2 = zzby.zza(bundle);
            if (zza2 != null) {
                return zza2;
            }
            this.zza.zzj().zzg().zza("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.zza.zzj().zzg().zza("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }

    zzgm(zzmp zzmp) {
        this.zza = zzmp.zzk();
    }

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.zza.zza());
            if (packageManager == null) {
                this.zza.zzj().zzp().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            } else if (packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            this.zza.zzj().zzp().zza("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }
}
