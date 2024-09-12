package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzjq extends zzjs {
    private zzjq() {
        super((zzjr) null);
    }

    /* synthetic */ zzjq(zzjp zzjp) {
        super((zzjr) null);
    }

    /* access modifiers changed from: package-private */
    public final List zza(Object obj, long j) {
        zzjb zzjb = (zzjb) zzlv.zzf(obj, j);
        if (zzjb.zzc()) {
            return zzjb;
        }
        int size = zzjb.size();
        zzjb zzd = zzjb.zzd(size == 0 ? 10 : size + size);
        zzlv.zzs(obj, j, zzd);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        ((zzjb) zzlv.zzf(obj, j)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj, Object obj2, long j) {
        zzjb zzjb = (zzjb) zzlv.zzf(obj, j);
        zzjb zzjb2 = (zzjb) zzlv.zzf(obj2, j);
        int size = zzjb.size();
        int size2 = zzjb2.size();
        if (size > 0 && size2 > 0) {
            if (!zzjb.zzc()) {
                zzjb = zzjb.zzd(size2 + size);
            }
            zzjb.addAll(zzjb2);
        }
        if (size > 0) {
            zzjb2 = zzjb;
        }
        zzlv.zzs(obj, j, zzjb2);
    }
}
