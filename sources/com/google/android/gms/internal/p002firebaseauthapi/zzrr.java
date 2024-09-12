package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzrr {
    @Nullable
    private ArrayList<zzru> zza = new ArrayList<>();
    private zzrl zzb = zzrl.zza;
    @Nullable
    private Integer zzc = null;

    public final zzrr zza(zzbw zzbw, int i, String str, String str2) {
        ArrayList<zzru> arrayList = this.zza;
        if (arrayList != null) {
            arrayList.add(new zzru(zzbw, i, str, str2));
            return this;
        }
        throw new IllegalStateException("addEntry cannot be called after build()");
    }

    public final zzrr zza(zzrl zzrl) {
        if (this.zza != null) {
            this.zzb = zzrl;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build()");
    }

    public final zzrr zza(int i) {
        if (this.zza != null) {
            this.zzc = Integer.valueOf(i);
            return this;
        }
        throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
    }

    public final zzrs zza() throws GeneralSecurityException {
        if (this.zza != null) {
            Integer num = this.zzc;
            if (num != null) {
                int intValue = num.intValue();
                ArrayList<zzru> arrayList = this.zza;
                ArrayList arrayList2 = arrayList;
                int size = arrayList.size();
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    zzru zzru = arrayList.get(i);
                    i++;
                    if (zzru.zza() == intValue) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    throw new GeneralSecurityException("primary key ID is not present in entries");
                }
            }
            zzrs zzrs = new zzrs(this.zzb, Collections.unmodifiableList(this.zza), this.zzc);
            this.zza = null;
            return zzrs;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
