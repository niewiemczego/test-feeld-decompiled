package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzcy {
    /* access modifiers changed from: private */
    public static final Comparator zza = new zzcq();
    private static final Comparator zzb = new zzcr();
    private static final zzcy zzc = new zzcy(new zzcw(Collections.emptyList()));
    private final zzcw zzd;

    private zzcy(zzcw zzcw) {
        this.zzd = zzcw;
    }

    public static zzcy zza() {
        return zzc;
    }

    public final boolean equals(@NullableDecl Object obj) {
        return (obj instanceof zzcy) && ((zzcy) obj).zzd.equals(this.zzd);
    }

    public final int hashCode() {
        return ~this.zzd.hashCode();
    }

    public final String toString() {
        return this.zzd.toString();
    }
}
