package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzam implements Iterator<zzaq> {
    private final /* synthetic */ Iterator zza;

    public final /* synthetic */ Object next() {
        return new zzas((String) this.zza.next());
    }

    zzam(Iterator it) {
        this.zza = it;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }
}
