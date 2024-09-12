package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzll implements Iterator<Object> {
    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    zzll() {
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
