package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzags;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class PlayGamesAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<PlayGamesAuthCredential> CREATOR = new zzas();
    private final String zza;

    public String getProvider() {
        return "playgames.google.com";
    }

    public String getSignInMethod() {
        return "playgames.google.com";
    }

    public final AuthCredential zza() {
        return new PlayGamesAuthCredential(this.zza);
    }

    public static zzags zza(PlayGamesAuthCredential playGamesAuthCredential, String str) {
        Preconditions.checkNotNull(playGamesAuthCredential);
        return new zzags((String) null, (String) null, playGamesAuthCredential.getProvider(), (String) null, (String) null, playGamesAuthCredential.zza, str, (String) null, (String) null);
    }

    PlayGamesAuthCredential(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
