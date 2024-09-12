package com.google.android.gms.measurement.internal;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.security.CertificateUtil;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzfu implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzfr zzf;

    zzfu(zzfr zzfr, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzfr;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    public final void run() {
        zzgd zzn = this.zzf.zzu.zzn();
        if (!zzn.zzae()) {
            this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.zzf.zza == 0) {
            if (this.zzf.zze().zzx()) {
                this.zzf.zza = 'C';
            } else {
                this.zzf.zza = 'c';
            }
        }
        if (this.zzf.zzb < 0) {
            this.zzf.zzb = 82001;
        }
        String str = ExifInterface.GPS_MEASUREMENT_2D + "01VDIWEA?".charAt(this.zza) + this.zzf.zza + this.zzf.zzb + CertificateUtil.DELIMITER + zzfr.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
        if (str.length() > 1024) {
            str = this.zzb.substring(0, 1024);
        }
        if (zzn.zzb != null) {
            zzn.zzb.zza(str, 1);
        }
    }
}
