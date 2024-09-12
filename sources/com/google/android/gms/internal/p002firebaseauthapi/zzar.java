package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzar  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzar extends zzaq<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzaq zzc;

    /* access modifiers changed from: package-private */
    public final int zza() {
        return this.zzc.zzb() + this.zza + this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final boolean zze() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc.zzb() + this.zza;
    }

    public final int size() {
        return this.zzb;
    }

    public final zzaq<E> zza(int i, int i2) {
        zzz.zza(i, i2, this.zzb);
        zzaq zzaq = this.zzc;
        int i3 = this.zza;
        return (zzaq) zzaq.subList(i + i3, i2 + i3);
    }

    public final E get(int i) {
        zzz.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    zzar(zzaq zzaq, int i, int i2) {
        this.zzc = zzaq;
        this.zza = i;
        this.zzb = i2;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final Object[] zzf() {
        return this.zzc.zzf();
    }
}
