package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzfo extends zzfq {
    private zzfo() {
        super((zzfp) null);
    }

    /* synthetic */ zzfo(zzfn zzfn) {
        super((zzfp) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j) {
        ((zzfc) zzhn.zzf(obj, j)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, Object obj2, long j) {
        zzfc zzfc = (zzfc) zzhn.zzf(obj, j);
        zzfc zzfc2 = (zzfc) zzhn.zzf(obj2, j);
        int size = zzfc.size();
        int size2 = zzfc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzfc.zzc()) {
                zzfc = zzfc.zzd(size2 + size);
            }
            zzfc.addAll(zzfc2);
        }
        if (size > 0) {
            zzfc2 = zzfc;
        }
        zzhn.zzs(obj, j, zzfc2);
    }
}
