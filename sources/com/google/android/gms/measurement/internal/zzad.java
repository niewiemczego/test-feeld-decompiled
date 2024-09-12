package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new zzag();
    public String zza;
    public String zzb;
    public zznc zzc;
    public long zzd;
    public boolean zze;
    public String zzf;
    public zzbg zzg;
    public long zzh;
    public zzbg zzi;
    public long zzj;
    public zzbg zzk;

    zzad(zzad zzad) {
        Preconditions.checkNotNull(zzad);
        this.zza = zzad.zza;
        this.zzb = zzad.zzb;
        this.zzc = zzad.zzc;
        this.zzd = zzad.zzd;
        this.zze = zzad.zze;
        this.zzf = zzad.zzf;
        this.zzg = zzad.zzg;
        this.zzh = zzad.zzh;
        this.zzi = zzad.zzi;
        this.zzj = zzad.zzj;
        this.zzk = zzad.zzk;
    }

    zzad(String str, String str2, zznc zznc, long j, boolean z, String str3, zzbg zzbg, long j2, zzbg zzbg2, long j3, zzbg zzbg3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zznc;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzbg;
        this.zzh = j2;
        this.zzi = zzbg2;
        this.zzj = j3;
        this.zzk = zzbg3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
