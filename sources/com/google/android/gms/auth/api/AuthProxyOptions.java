package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public final class AuthProxyOptions implements Api.ApiOptions.Optional {
    public static final AuthProxyOptions zza = new AuthProxyOptions(new Bundle(), (zzb) null);
    private final Bundle zzb;

    /* synthetic */ AuthProxyOptions(Bundle bundle, zzb zzb2) {
        this.zzb = bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthProxyOptions)) {
            return false;
        }
        return Objects.checkBundlesEquality(this.zzb, ((AuthProxyOptions) obj).zzb);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb);
    }

    public final Bundle zza() {
        return new Bundle(this.zzb);
    }
}
