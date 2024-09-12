package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzmd implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzmb zzb;

    public final /* synthetic */ Object next() {
        return this.zza.next();
    }

    zzmd(zzmb zzmb) {
        this.zzb = zzmb;
        this.zza = zzmb.zza.iterator();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }
}
