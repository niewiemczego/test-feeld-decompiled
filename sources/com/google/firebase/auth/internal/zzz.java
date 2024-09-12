package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zzd;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzz implements AuthResult {
    public static final Parcelable.Creator<zzz> CREATOR = new zzy();
    private zzaf zza;
    private zzx zzb;
    private zzd zzc;

    public final int describeContents() {
        return 0;
    }

    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzb;
    }

    public final AuthCredential getCredential() {
        return this.zzc;
    }

    public final FirebaseUser getUser() {
        return this.zza;
    }

    public zzz(zzaf zzaf) {
        zzaf zzaf2 = (zzaf) Preconditions.checkNotNull(zzaf);
        this.zza = zzaf2;
        List<zzab> zzi = zzaf2.zzi();
        this.zzb = null;
        for (int i = 0; i < zzi.size(); i++) {
            if (!TextUtils.isEmpty(zzi.get(i).zza())) {
                this.zzb = new zzx(zzi.get(i).getProviderId(), zzi.get(i).zza(), zzaf.zzj());
            }
        }
        if (this.zzb == null) {
            this.zzb = new zzx(zzaf.zzj());
        }
        this.zzc = zzaf.zzg();
    }

    zzz(zzaf zzaf, zzx zzx, zzd zzd) {
        this.zza = zzaf;
        this.zzb = zzx;
        this.zzc = zzd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUser(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getAdditionalUserInfo(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
