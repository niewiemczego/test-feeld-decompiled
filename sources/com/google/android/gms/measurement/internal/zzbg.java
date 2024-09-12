package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzbg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbg> CREATOR = new zzbf();
    public final String zza;
    public final zzbb zzb;
    public final String zzc;
    public final long zzd;

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zza;
        return "origin=" + str + ",name=" + str2 + ",params=" + String.valueOf(this.zzb);
    }

    zzbg(zzbg zzbg, long j) {
        Preconditions.checkNotNull(zzbg);
        this.zza = zzbg.zza;
        this.zzb = zzbg.zzb;
        this.zzc = zzbg.zzc;
        this.zzd = j;
    }

    public zzbg(String str, zzbb zzbb, String str2, long j) {
        this.zza = str;
        this.zzb = zzbb;
        this.zzc = str2;
        this.zzd = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
