package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzk extends zzp implements zzm {
    zzk(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    public final int zza(int i, String str, String str2) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(3);
        zzr.writeString(str);
        zzr.writeString(str2);
        Parcel zzs = zzs(5, zzr);
        int readInt = zzs.readInt();
        zzs.recycle();
        return readInt;
    }

    public final int zzc(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(i);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.zzc(zzr, bundle);
        Parcel zzs = zzs(10, zzr);
        int readInt = zzs.readInt();
        zzs.recycle();
        return readInt;
    }

    public final Bundle zzd(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(9);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.zzc(zzr, bundle);
        Parcel zzs = zzs(902, zzr);
        Bundle bundle2 = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle2;
    }

    public final Bundle zze(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(9);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.zzc(zzr, bundle);
        Parcel zzs = zzs(12, zzr);
        Bundle bundle2 = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle2;
    }

    public final Bundle zzf(int i, String str, String str2, String str3, String str4) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(3);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.writeString(str3);
        zzr.writeString((String) null);
        Parcel zzs = zzs(3, zzr);
        Bundle bundle = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle;
    }

    public final Bundle zzg(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(i);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.writeString(str3);
        zzr.writeString((String) null);
        zzr.zzc(zzr, bundle);
        Parcel zzs = zzs(8, zzr);
        Bundle bundle2 = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle2;
    }

    public final Bundle zzh(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(6);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.writeString(str3);
        zzr.zzc(zzr, bundle);
        Parcel zzs = zzs(9, zzr);
        Bundle bundle2 = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle2;
    }

    public final Bundle zzi(int i, String str, String str2, String str3) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(3);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.writeString(str3);
        Parcel zzs = zzs(4, zzr);
        Bundle bundle = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle;
    }

    public final Bundle zzj(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(i);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.writeString(str3);
        zzr.zzc(zzr, bundle);
        Parcel zzs = zzs(11, zzr);
        Bundle bundle2 = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle2;
    }

    public final Bundle zzk(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(3);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.zzc(zzr, bundle);
        Parcel zzs = zzs(2, zzr);
        Bundle bundle2 = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle2;
    }

    public final Bundle zzl(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(i);
        zzr.writeString(str);
        zzr.writeString(str2);
        zzr.zzc(zzr, bundle);
        zzr.zzc(zzr, bundle2);
        Parcel zzs = zzs(901, zzr);
        Bundle bundle3 = (Bundle) zzr.zza(zzs, Bundle.CREATOR);
        zzs.recycle();
        return bundle3;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.android.gms.internal.play_billing.zzd, android.os.IBinder] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzm(int r2, java.lang.String r3, android.os.Bundle r4, com.google.android.gms.internal.play_billing.zzd r5) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r2 = r1.zzr()
            r0 = 21
            r2.writeInt(r0)
            r2.writeString(r3)
            com.google.android.gms.internal.play_billing.zzr.zzc(r2, r4)
            r2.writeStrongBinder(r5)
            r3 = 1501(0x5dd, float:2.103E-42)
            r1.zzu(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzk.zzm(int, java.lang.String, android.os.Bundle, com.google.android.gms.internal.play_billing.zzd):void");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.android.gms.internal.play_billing.zzf, android.os.IBinder] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzn(int r2, java.lang.String r3, android.os.Bundle r4, com.google.android.gms.internal.play_billing.zzf r5) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r2 = r1.zzr()
            r0 = 21
            r2.writeInt(r0)
            r2.writeString(r3)
            com.google.android.gms.internal.play_billing.zzr.zzc(r2, r4)
            r2.writeStrongBinder(r5)
            r3 = 1601(0x641, float:2.243E-42)
            r1.zzu(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzk.zzn(int, java.lang.String, android.os.Bundle, com.google.android.gms.internal.play_billing.zzf):void");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.android.gms.internal.play_billing.zzh, android.os.IBinder] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzo(int r2, java.lang.String r3, android.os.Bundle r4, com.google.android.gms.internal.play_billing.zzh r5) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r2 = r1.zzr()
            r0 = 18
            r2.writeInt(r0)
            r2.writeString(r3)
            com.google.android.gms.internal.play_billing.zzr.zzc(r2, r4)
            r2.writeStrongBinder(r5)
            r3 = 1301(0x515, float:1.823E-42)
            r1.zzt(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzk.zzo(int, java.lang.String, android.os.Bundle, com.google.android.gms.internal.play_billing.zzh):void");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.android.gms.internal.play_billing.zzj, android.os.IBinder] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzp(int r2, java.lang.String r3, android.os.Bundle r4, com.google.android.gms.internal.play_billing.zzj r5) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r2 = r1.zzr()
            r0 = 21
            r2.writeInt(r0)
            r2.writeString(r3)
            com.google.android.gms.internal.play_billing.zzr.zzc(r2, r4)
            r2.writeStrongBinder(r5)
            r3 = 1401(0x579, float:1.963E-42)
            r1.zzu(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzk.zzp(int, java.lang.String, android.os.Bundle, com.google.android.gms.internal.play_billing.zzj):void");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.os.IBinder, com.google.android.gms.internal.play_billing.zzo] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzq(int r2, java.lang.String r3, android.os.Bundle r4, com.google.android.gms.internal.play_billing.zzo r5) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r2 = r1.zzr()
            r0 = 12
            r2.writeInt(r0)
            r2.writeString(r3)
            com.google.android.gms.internal.play_billing.zzr.zzc(r2, r4)
            r2.writeStrongBinder(r5)
            r3 = 1201(0x4b1, float:1.683E-42)
            r1.zzt(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzk.zzq(int, java.lang.String, android.os.Bundle, com.google.android.gms.internal.play_billing.zzo):void");
    }

    public final int zzv(int i, String str, String str2) throws RemoteException {
        Parcel zzr = zzr();
        zzr.writeInt(i);
        zzr.writeString(str);
        zzr.writeString(str2);
        Parcel zzs = zzs(1, zzr);
        int readInt = zzs.readInt();
        zzs.recycle();
        return readInt;
    }
}
