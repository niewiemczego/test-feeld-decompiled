package com.google.android.gms.internal.common;

import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;

@NullMarked
/* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
public final class zzr extends zzp {
    public static boolean zza(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
