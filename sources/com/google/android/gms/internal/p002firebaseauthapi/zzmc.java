package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.IOException;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzmc implements zzce {
    private final SharedPreferences.Editor zza;
    private final String zzb;

    public zzmc(Context context, String str, String str2) {
        if (str != null) {
            this.zzb = str;
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                this.zza = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
            } else {
                this.zza = applicationContext.getSharedPreferences(str2, 0).edit();
            }
        } else {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
    }

    public final void zza(zzty zzty) throws IOException {
        if (!this.zza.putString(this.zzb, zzxh.zza(zzty.zzj())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    public final void zza(zzvh zzvh) throws IOException {
        if (!this.zza.putString(this.zzb, zzxh.zza(zzvh.zzj())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
