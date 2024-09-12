package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.AccessToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzafm extends AbstractSafeParcelable implements zzacq<zzafm> {
    public static final Parcelable.Creator<zzafm> CREATOR = new zzafl();
    private static final String zza = "zzafm";
    private String zzb;
    private String zzc;
    private Long zzd;
    private String zze;
    private Long zzf;

    public final long zza() {
        Long l = this.zzd;
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public final long zzb() {
        return this.zzf.longValue();
    }

    public static zzafm zzb(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzafm zzafm = new zzafm();
            zzafm.zzb = jSONObject.optString("refresh_token", (String) null);
            zzafm.zzc = jSONObject.optString("access_token", (String) null);
            zzafm.zzd = Long.valueOf(jSONObject.optLong(AccessToken.EXPIRES_IN_KEY));
            zzafm.zze = jSONObject.optString("token_type", (String) null);
            zzafm.zzf = Long.valueOf(jSONObject.optLong("issued_at"));
            return zzafm;
        } catch (JSONException e) {
            Log.d(zza, "Failed to read GetTokenResponse from JSONObject");
            throw new zzxv(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzafm zza(String str) throws zzaah {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("refresh_token"));
            this.zzc = Strings.emptyToNull(jSONObject.optString("access_token"));
            this.zzd = Long.valueOf(jSONObject.optLong(AccessToken.EXPIRES_IN_KEY, 0));
            this.zze = Strings.emptyToNull(jSONObject.optString("token_type"));
            this.zzf = Long.valueOf(System.currentTimeMillis());
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzahb.zza((Exception) e, zza, str);
        }
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh_token", (Object) this.zzb);
            jSONObject.put("access_token", (Object) this.zzc);
            jSONObject.put(AccessToken.EXPIRES_IN_KEY, (Object) this.zzd);
            jSONObject.put("token_type", (Object) this.zze);
            jSONObject.put("issued_at", (Object) this.zzf);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d(zza, "Failed to convert GetTokenResponse to JSON");
            throw new zzxv(e);
        }
    }

    public zzafm() {
        this.zzf = Long.valueOf(System.currentTimeMillis());
    }

    public zzafm(String str, String str2, Long l, String str3) {
        this(str, str2, l, str3, Long.valueOf(System.currentTimeMillis()));
    }

    zzafm(String str, String str2, Long l, String str3, Long l2) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = l;
        this.zze = str3;
        this.zzf = l2;
    }

    public final void zzc(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeLongObject(parcel, 4, Long.valueOf(zza()), false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeLongObject(parcel, 6, Long.valueOf(this.zzf.longValue()), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zzg() {
        return DefaultClock.getInstance().currentTimeMillis() + 300000 < this.zzf.longValue() + (this.zzd.longValue() * 1000);
    }
}
