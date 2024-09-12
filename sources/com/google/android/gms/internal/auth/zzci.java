package com.google.android.gms.internal.auth;

import android.net.Uri;
import androidx.collection.SimpleArrayMap;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public final class zzci {
    private final SimpleArrayMap zza;

    zzci(SimpleArrayMap simpleArrayMap) {
        this.zza = simpleArrayMap;
    }

    @Nullable
    public final String zza(@Nullable Uri uri, @Nullable String str, @Nullable String str2, String str3) {
        if (uri == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.zza.get(uri.toString());
        if (simpleArrayMap == null) {
            return null;
        }
        return (String) simpleArrayMap.get("".concat(String.valueOf(str3)));
    }
}
