package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzji implements Iterator {
    private final Iterator zza;

    public zzji(Iterator it) {
        this.zza = it;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        return entry.getValue() instanceof zzjj ? new zzjh(entry, (zzjg) null) : entry;
    }

    public final void remove() {
        this.zza.remove();
    }
}
