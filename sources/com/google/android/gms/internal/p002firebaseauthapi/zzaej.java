package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import io.sentry.protocol.ViewHierarchyNode;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaej  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzaej implements zzacr {
    private String zza;
    private String zzb = "http://localhost";
    private final String zzc;

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ViewHierarchyNode.JsonKeys.IDENTIFIER, (Object) this.zza);
        jSONObject.put("continueUri", (Object) this.zzb);
        String str = this.zzc;
        if (str != null) {
            jSONObject.put("tenantId", (Object) str);
        }
        return jSONObject.toString();
    }

    public zzaej(String str, String str2) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzc = str2;
    }
}
