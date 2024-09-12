package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzac  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzac {
    /* access modifiers changed from: private */
    public final zzj zza;
    private final boolean zzb;
    private final zzai zzc;
    /* access modifiers changed from: private */
    public final int zzd;

    public static zzac zza(char c) {
        zzl zzl = new zzl(c);
        zzz.zza(zzl);
        return new zzac(new zzab(zzl));
    }

    public static zzac zza(String str) {
        zzs zza2 = zzy.zza(str);
        if (!zza2.zza("").zzc()) {
            return new zzac(new zzad(zza2));
        }
        throw new IllegalArgumentException(zzah.zza("The pattern may not match the empty string: %s", zza2));
    }

    public final List<String> zza(CharSequence charSequence) {
        zzz.zza(charSequence);
        Iterator<String> zza2 = this.zzc.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zza2.hasNext()) {
            arrayList.add(zza2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    private zzac(zzai zzai) {
        this(zzai, false, zzn.zza, Integer.MAX_VALUE);
    }

    private zzac(zzai zzai, boolean z, zzj zzj, int i) {
        this.zzc = zzai;
        this.zzb = false;
        this.zza = zzj;
        this.zzd = Integer.MAX_VALUE;
    }
}
