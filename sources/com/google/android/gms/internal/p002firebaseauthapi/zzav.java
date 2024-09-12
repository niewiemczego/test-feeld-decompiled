package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzav  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzav<E> extends zzal<E> implements Set<E> {
    @CheckForNull
    private transient zzaq<E> zza;

    public int hashCode() {
        return zzbe.zza(this);
    }

    public zzaq<E> zzc() {
        zzaq<E> zzaq = this.zza;
        if (zzaq != null) {
            return zzaq;
        }
        zzaq<E> zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    /* access modifiers changed from: package-private */
    public zzaq<E> zzg() {
        return zzaq.zza(toArray());
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    zzav() {
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        return zzbe.zza(this, obj);
    }
}
