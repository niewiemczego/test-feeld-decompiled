package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzafi implements zzacq<zzafi> {
    private static final String zza = "zzafi";
    private String zzb;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzafi zza(String str) throws zzaah {
        try {
            this.zzb = Strings.emptyToNull(new JSONObject(str).optString("producerProjectNumber"));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzahb.zza((Exception) e, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public zzafi() {
    }

    public zzafi(String str) {
        this.zzb = str;
    }
}
