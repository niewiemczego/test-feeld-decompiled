package com.google.firebase.auth.internal;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p002firebaseauthapi.zzxv;
import com.google.firebase.auth.GetTokenResult;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzbi {
    private static final Logger zza = new Logger("GetTokenResultFactory", new String[0]);

    public static GetTokenResult zza(String str) {
        Map map;
        try {
            map = zzbh.zza(str);
        } catch (zzxv e) {
            zza.e("Error parsing token claims", e, new Object[0]);
            map = new HashMap();
        }
        return new GetTokenResult(str, map);
    }
}
