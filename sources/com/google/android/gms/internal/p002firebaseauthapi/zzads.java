package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzads  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzads {
    private static final Map<String, zzadu> zza = new ArrayMap();

    public static PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, zzacw zzacw) {
        zza(str, zzacw);
        return new zzadr(onVerificationStateChangedCallbacks, str);
    }

    public static void zza() {
        zza.clear();
    }

    private static void zza(String str, zzacw zzacw) {
        zza.put(str, new zzadu(zzacw, DefaultClock.getInstance().currentTimeMillis()));
    }

    public static boolean zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        Map<String, zzadu> map = zza;
        if (map.containsKey(str)) {
            zzadu zzadu = map.get(str);
            if (DefaultClock.getInstance().currentTimeMillis() - zzadu.zzb >= 120000) {
                zza(str, (zzacw) null);
                return false;
            } else if (zzadu.zza == null) {
                return true;
            } else {
                zzadu.zza.zza(onVerificationStateChangedCallbacks, activity, executor, str);
                return true;
            }
        } else {
            zza(str, (zzacw) null);
            return false;
        }
    }
}
