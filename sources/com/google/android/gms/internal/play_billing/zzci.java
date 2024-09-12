package com.google.android.gms.internal.play_billing;

import java.util.Set;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzci extends zzby {
    private final zzbd zza;
    private final Level zzb;
    private final Set zzc;
    private final zzbq zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzci(String str, @NullableDecl String str2, boolean z, zzbd zzbd, boolean z2, boolean z3) {
        super(str2);
        Level level = Level.ALL;
        Set zzd2 = zzck.zza;
        zzbq zzb2 = zzck.zzb;
        this.zza = zzbd;
        this.zzb = level;
        this.zzc = zzd2;
        this.zzd = zzb2;
    }
}
