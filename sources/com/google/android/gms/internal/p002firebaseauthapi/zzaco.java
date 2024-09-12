package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaco  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzaco {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzaco";

    public static Object zza(String str, Type type) throws zzaah {
        if (type == String.class) {
            try {
                zzaek zzaek = (zzaek) new zzaek().zza(str);
                if (zzaek.zzb()) {
                    return zzaek.zza();
                }
                throw new zzaah("No error message: " + str);
            } catch (Exception e) {
                throw new zzaah("Json conversion failed! " + e.getMessage(), e);
            }
        } else if (type == Void.class) {
            return null;
        } else {
            try {
                try {
                    return ((zzacq) ((Class) type).getConstructor(new Class[0]).newInstance(new Object[0])).zza(str);
                } catch (Exception e2) {
                    throw new zzaah("Json conversion failed! " + e2.getMessage(), e2);
                }
            } catch (Exception e3) {
                throw new zzaah("Instantiation of JsonResponse failed! " + String.valueOf(type), e3);
            }
        }
    }

    private zzaco() {
    }
}
