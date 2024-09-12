package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzags;
import com.google.android.gms.internal.p002firebaseauthapi.zzah;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzd extends OAuthCredential {
    public static final Parcelable.Creator<zzd> CREATOR = new zzf();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final zzags zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    public final AuthCredential zza() {
        return new zzd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }

    public static zzd zza(zzags zzags) {
        Preconditions.checkNotNull(zzags, "Must specify a non-null webSignInCredential");
        return new zzd((String) null, (String) null, (String) null, zzags, (String) null, (String) null, (String) null);
    }

    public static zzd zza(String str, String str2, String str3) {
        return zza(str, str2, str3, (String) null, (String) null);
    }

    public static zzd zza(String str, String str2, String str3, String str4, String str5) {
        Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return new zzd(str, str2, str3, (zzags) null, str4, str5, (String) null);
        }
        throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
    }

    static zzd zza(String str, String str2, String str3, String str4) {
        Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return new zzd(str, str2, str3, (zzags) null, (String) null, (String) null, str4);
        }
        throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
    }

    public static zzags zza(zzd zzd2, String str) {
        Preconditions.checkNotNull(zzd2);
        zzags zzags = zzd2.zzd;
        if (zzags != null) {
            return zzags;
        }
        return new zzags(zzd2.getIdToken(), zzd2.getAccessToken(), zzd2.getProvider(), (String) null, zzd2.getSecret(), (String) null, str, zzd2.zze, zzd2.zzg);
    }

    public String getAccessToken() {
        return this.zzc;
    }

    public String getIdToken() {
        return this.zzb;
    }

    public String getProvider() {
        return this.zza;
    }

    public String getSecret() {
        return this.zzf;
    }

    public String getSignInMethod() {
        return this.zza;
    }

    zzd(String str, String str2, String str3, zzags zzags, String str4, String str5, String str6) {
        this.zza = zzah.zzb(str);
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzags;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getProvider(), false);
        SafeParcelWriter.writeString(parcel, 2, getIdToken(), false);
        SafeParcelWriter.writeString(parcel, 3, getAccessToken(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeString(parcel, 6, getSecret(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
