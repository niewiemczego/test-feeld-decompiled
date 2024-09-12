package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class PhoneAuthCredential extends AuthCredential implements Cloneable {
    public static final Parcelable.Creator<PhoneAuthCredential> CREATOR = new zzap();
    private String zza;
    private String zzb;
    private String zzc;
    private boolean zzd;
    private String zze;

    public String getProvider() {
        return "phone";
    }

    public String getSignInMethod() {
        return "phone";
    }

    public final AuthCredential zza() {
        return (PhoneAuthCredential) clone();
    }

    public static PhoneAuthCredential zza(String str, String str2) {
        return new PhoneAuthCredential(str, str2, (String) null, true, (String) null);
    }

    public static PhoneAuthCredential zzb(String str, String str2) {
        return new PhoneAuthCredential((String) null, (String) null, str, true, str2);
    }

    public final PhoneAuthCredential zza(boolean z) {
        this.zzd = false;
        return this;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new PhoneAuthCredential(this.zza, getSmsCode(), this.zzc, this.zzd, this.zze);
    }

    public final String zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza;
    }

    public String getSmsCode() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zze;
    }

    PhoneAuthCredential(String str, String str2, String str3, boolean z, String str4) {
        Preconditions.checkArgument((!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)), "Cannot create PhoneAuthCredential without either sessionInfo + smsCode or temporary proof + phoneNumber.");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z;
        this.zze = str4;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, getSmsCode(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zze() {
        return this.zzd;
    }
}
