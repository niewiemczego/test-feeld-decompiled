package com.google.android.gms.internal.auth;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzdf extends zzdh {
    static final zzdf zza = new zzdf();

    private zzdf() {
    }

    public final boolean equals(@CheckForNull Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    public final Object zza() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final boolean zzb() {
        return false;
    }
}
