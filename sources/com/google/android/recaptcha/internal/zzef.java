package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzef {
    private List zza = CollectionsKt.emptyList();

    public final long zza(long[] jArr) {
        Iterator<T> it = CollectionsKt.plus(this.zza, ArraysKt.toList(jArr)).iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = Long.valueOf(((Number) next).longValue() ^ ((Number) it.next()).longValue());
            }
            return ((Number) next).longValue();
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public final void zzb(long[] jArr) {
        this.zza = ArraysKt.toList(jArr);
    }
}
