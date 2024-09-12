package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public interface zzfk extends IInterface {
    zzam zza(zzo zzo) throws RemoteException;

    List<zzmh> zza(zzo zzo, Bundle bundle) throws RemoteException;

    List<zznc> zza(zzo zzo, boolean z) throws RemoteException;

    List<zzad> zza(String str, String str2, zzo zzo) throws RemoteException;

    List<zzad> zza(String str, String str2, String str3) throws RemoteException;

    List<zznc> zza(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zznc> zza(String str, String str2, boolean z, zzo zzo) throws RemoteException;

    void zza(long j, String str, String str2, String str3) throws RemoteException;

    void zza(Bundle bundle, zzo zzo) throws RemoteException;

    void zza(zzad zzad) throws RemoteException;

    void zza(zzad zzad, zzo zzo) throws RemoteException;

    void zza(zzbg zzbg, zzo zzo) throws RemoteException;

    void zza(zzbg zzbg, String str, String str2) throws RemoteException;

    void zza(zznc zznc, zzo zzo) throws RemoteException;

    byte[] zza(zzbg zzbg, String str) throws RemoteException;

    String zzb(zzo zzo) throws RemoteException;

    void zzc(zzo zzo) throws RemoteException;

    void zzd(zzo zzo) throws RemoteException;

    void zze(zzo zzo) throws RemoteException;

    void zzf(zzo zzo) throws RemoteException;
}
