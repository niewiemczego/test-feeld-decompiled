package com.google.android.recaptcha.internal;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzfs {
    public static boolean zza(Collection collection, Iterator it) {
        it.getClass();
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }
}
