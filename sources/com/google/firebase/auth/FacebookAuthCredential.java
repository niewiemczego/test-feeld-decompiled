package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzags;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class FacebookAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<FacebookAuthCredential> CREATOR = new zzh();
    private final String zza;

    public String getProvider() {
        return "facebook.com";
    }

    public String getSignInMethod() {
        return "facebook.com";
    }

    public final AuthCredential zza() {
        return new FacebookAuthCredential(this.zza);
    }

    public static zzags zza(FacebookAuthCredential facebookAuthCredential, String str) {
        Preconditions.checkNotNull(facebookAuthCredential);
        return new zzags((String) null, facebookAuthCredential.zza, facebookAuthCredential.getProvider(), (String) null, (String) null, (String) null, str, (String) null, (String) null);
    }

    FacebookAuthCredential(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
