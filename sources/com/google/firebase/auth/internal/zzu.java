package com.google.firebase.auth.internal;

import com.google.android.gms.internal.p002firebaseauthapi.zzafv;
import com.google.firebase.auth.ActionCodeInfo;
import com.google.firebase.auth.ActionCodeResult;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzu implements ActionCodeResult {
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final ActionCodeInfo zzd;

    public final int getOperation() {
        return this.zza;
    }

    public final ActionCodeInfo getInfo() {
        return this.zzd;
    }

    public final String getData(int i) {
        if (this.zza == 4) {
            return null;
        }
        if (i == 0) {
            return this.zzb;
        }
        if (i != 1) {
            return null;
        }
        return this.zzc;
    }

    public zzu(zzafv zzafv) {
        this.zzb = zzafv.zzg() ? zzafv.zzc() : zzafv.zzb();
        this.zzc = zzafv.zzb();
        ActionCodeInfo actionCodeInfo = null;
        if (!zzafv.zzh()) {
            this.zza = 3;
            this.zzd = null;
            return;
        }
        String zzd2 = zzafv.zzd();
        zzd2.hashCode();
        char c = 65535;
        int i = 5;
        switch (zzd2.hashCode()) {
            case -1874510116:
                if (zzd2.equals("REVERT_SECOND_FACTOR_ADDITION")) {
                    c = 0;
                    break;
                }
                break;
            case -1452371317:
                if (zzd2.equals("PASSWORD_RESET")) {
                    c = 1;
                    break;
                }
                break;
            case -1341836234:
                if (zzd2.equals("VERIFY_EMAIL")) {
                    c = 2;
                    break;
                }
                break;
            case -1099157829:
                if (zzd2.equals("VERIFY_AND_CHANGE_EMAIL")) {
                    c = 3;
                    break;
                }
                break;
            case 870738373:
                if (zzd2.equals("EMAIL_SIGNIN")) {
                    c = 4;
                    break;
                }
                break;
            case 970484929:
                if (zzd2.equals("RECOVER_EMAIL")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                i = 6;
                break;
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 2;
                break;
            default:
                i = 3;
                break;
        }
        this.zza = i;
        if (i == 4 || i == 3) {
            this.zzd = null;
            return;
        }
        if (zzafv.zzf()) {
            actionCodeInfo = new zzv(zzafv.zzb(), zzbk.zza(zzafv.zza()));
        } else if (zzafv.zzg()) {
            actionCodeInfo = new zzt(zzafv.zzc(), zzafv.zzb());
        } else if (zzafv.zze()) {
            actionCodeInfo = new zzs(zzafv.zzb());
        }
        this.zzd = actionCodeInfo;
    }
}
