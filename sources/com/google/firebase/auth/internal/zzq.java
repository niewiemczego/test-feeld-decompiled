package com.google.firebase.auth.internal;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzbj;
import com.google.android.gms.internal.p002firebaseauthapi.zzbp;
import com.google.android.gms.internal.p002firebaseauthapi.zzce;
import com.google.android.gms.internal.p002firebaseauthapi.zzkj;
import com.google.android.gms.internal.p002firebaseauthapi.zzkq;
import com.google.android.gms.internal.p002firebaseauthapi.zzlx;
import com.google.android.gms.internal.p002firebaseauthapi.zzw;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzq {
    private static zzq zza;
    private final String zzb;
    private final zzlx zzc;

    public static zzq zza(Context context, String str) {
        zzq zzq = zza;
        if (zzq == null || !zzw.zza(zzq.zzb, str)) {
            zza = new zzq(context, str, true);
        }
        return zza;
    }

    public final String zza(String str) {
        String str2;
        zzlx zzlx = this.zzc;
        if (zzlx == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to decrypt payload");
            return null;
        }
        try {
            synchronized (zzlx) {
                str2 = new String(((zzbp) this.zzc.zza().zza(zzbp.class)).zza(Base64.decode(str, 8), (byte[]) null), "UTF-8");
            }
            return str2;
        } catch (UnsupportedEncodingException | GeneralSecurityException e) {
            Log.e("FirebearCryptoHelper", "Exception encountered while decrypting bytes:\n" + e.getMessage());
            return null;
        }
    }

    public final String zza() {
        if (this.zzc == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to get Public key");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        zzce zza2 = zzbj.zza((OutputStream) byteArrayOutputStream);
        try {
            synchronized (this.zzc) {
                this.zzc.zza().zza().zza(zza2);
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        } catch (IOException | GeneralSecurityException e) {
            Log.e("FirebearCryptoHelper", "Exception encountered when attempting to get Public Key:\n" + e.getMessage());
            return null;
        }
    }

    private zzq(Context context, String str, boolean z) {
        zzlx zzlx;
        this.zzb = str;
        try {
            zzkj.zza();
            zzlx.zza zza2 = new zzlx.zza().zza(context, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", new Object[]{str})).zza(zzkq.zza);
            zza2.zza(String.format("android-keystore://firebear_master_key_id.%s", new Object[]{str}));
            zzlx = zza2.zza();
        } catch (IOException | GeneralSecurityException e) {
            Log.e("FirebearCryptoHelper", "Exception encountered during crypto setup:\n" + e.getMessage());
            zzlx = null;
        }
        this.zzc = zzlx;
    }
}
