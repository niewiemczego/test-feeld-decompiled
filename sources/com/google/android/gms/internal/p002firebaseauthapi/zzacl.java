package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final /* synthetic */ class zzacl {
    public static String zza(zzaci zzaci, String str) {
        try {
            String str2 = new String(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(str.getBytes()));
            int length = str2.length();
            int i = 0;
            while (i < length) {
                if (zzk.zza(str2.charAt(i))) {
                    char[] charArray = str2.toCharArray();
                    while (i < length) {
                        char c = charArray[i];
                        if (zzk.zza(c)) {
                            charArray[i] = (char) (c ^ ' ');
                        }
                        i++;
                    }
                    return String.valueOf(charArray);
                }
                i++;
            }
            return str2;
        } catch (NoSuchAlgorithmException unused) {
            zzaci.zza.e("Failed to get SHA-256 MessageDigest", new Object[0]);
            return null;
        }
    }

    public static void zzb(zzaci zzaci, String str) {
        zzaci.zza(str, (Status) null);
    }
}
