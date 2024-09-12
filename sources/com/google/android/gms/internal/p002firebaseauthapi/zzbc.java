package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzbc<K> extends zzav<K> {
    private final transient zzau<K, ?> zza;
    private final transient zzaq<K> zzb;

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }

    /* access modifiers changed from: package-private */
    public final boolean zze() {
        return true;
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzaq<K> zzc() {
        return this.zzb;
    }

    public final zzbd<K> zzd() {
        return (zzbd) zzc().iterator();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    zzbc(zzau<K, ?> zzau, zzaq<K> zzaq) {
        this.zza = zzau;
        this.zzb = zzaq;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }
}
