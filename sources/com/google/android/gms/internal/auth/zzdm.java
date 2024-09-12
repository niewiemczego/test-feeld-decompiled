package com.google.android.gms.internal.auth;

import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzdm implements Serializable, zzdj {
    final Object zza;

    zzdm(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof zzdm)) {
            return false;
        }
        Object obj2 = this.zza;
        Object obj3 = ((zzdm) obj).zza;
        if (obj2 == obj3 || obj2.equals(obj3)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.zza + ")";
    }

    public final Object zza() {
        return this.zza;
    }
}
