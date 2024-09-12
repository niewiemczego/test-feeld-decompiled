package com.google.android.gms.internal.auth;

import android.util.Base64;
import android.util.Log;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzcy extends zzdc {
    final /* synthetic */ zzhu zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcy(zzcz zzcz, String str, Object obj, boolean z, zzhu zzhu, byte[] bArr) {
        super(zzcz, "getTokenRefactor__blocked_packages", obj, true, (zzdb) null);
        this.zza = zzhu;
    }

    /* access modifiers changed from: package-private */
    public final Object zza(Object obj) {
        try {
            return zzhr.zzk(Base64.decode((String) obj, 3));
        } catch (IOException | IllegalArgumentException unused) {
            String zzc = super.zzc();
            Log.e("PhenotypeFlag", "Invalid byte[] value for " + zzc + ": " + ((String) obj));
            return null;
        }
    }
}
