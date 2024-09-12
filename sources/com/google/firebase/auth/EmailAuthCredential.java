package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class EmailAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<EmailAuthCredential> CREATOR = new zzg();
    private String zza;
    private String zzb;
    private final String zzc;
    private String zzd;
    private boolean zze;

    public String getProvider() {
        return "password";
    }

    public final AuthCredential zza() {
        return new EmailAuthCredential(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final EmailAuthCredential zza(FirebaseUser firebaseUser) {
        this.zzd = firebaseUser.zze();
        this.zze = true;
        return this;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zzc;
    }

    public String getSignInMethod() {
        return !TextUtils.isEmpty(this.zzb) ? "password" : EmailAuthProvider.EMAIL_LINK_SIGN_IN_METHOD;
    }

    EmailAuthCredential(String str, String str2) {
        this(str, str2, (String) null, (String) null, false);
    }

    EmailAuthCredential(String str, String str2, String str3, String str4, boolean z) {
        this.zza = Preconditions.checkNotEmpty(str);
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = str4;
            this.zze = z;
            return;
        }
        throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zzf() {
        return !TextUtils.isEmpty(this.zzc);
    }

    public final boolean zzg() {
        return this.zze;
    }

    public static boolean zza(String str) {
        ActionCodeUrl parseLink;
        if (!TextUtils.isEmpty(str) && (parseLink = ActionCodeUrl.parseLink(str)) != null && parseLink.getOperation() == 4) {
            return true;
        }
        return false;
    }
}
