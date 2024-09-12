package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public abstract class zzee extends zzdm {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzee.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzd = zzhn.zzx();
    zzef zza;

    private zzee() {
    }

    /* synthetic */ zzee(zzed zzed) {
    }

    @Deprecated
    static int zzt(int i, zzgc zzgc, zzgm zzgm) {
        int zza2 = ((zzdg) zzgc).zza(zzgm);
        int zzx = zzx(i << 3);
        return zzx + zzx + zza2;
    }

    public static int zzu(int i) {
        if (i >= 0) {
            return zzx(i);
        }
        return 10;
    }

    static int zzv(zzgc zzgc, zzgm zzgm) {
        int zza2 = ((zzdg) zzgc).zza(zzgm);
        return zzx(zza2) + zza2;
    }

    public static int zzw(String str) {
        int i;
        try {
            i = zzhs.zzc(str);
        } catch (zzhr unused) {
            i = str.getBytes(zzfd.zzb).length;
        }
        return zzx(i) + i;
    }

    public static int zzx(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzy(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            j >>>= 14;
            i += 2;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static zzee zzz(byte[] bArr, int i, int i2) {
        return new zzeb(bArr, 0, i2);
    }

    public final void zzA() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzB(String str, zzhr zzhr) throws IOException {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzhr);
        byte[] bytes = str.getBytes(zzfd.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzec(e);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b) throws IOException;

    public abstract void zzd(int i, boolean z) throws IOException;

    public abstract void zze(int i, zzdw zzdw) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzg(int i) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzi(long j) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzk(int i) throws IOException;

    public abstract void zzl(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzm(int i, String str) throws IOException;

    public abstract void zzo(int i, int i2) throws IOException;

    public abstract void zzp(int i, int i2) throws IOException;

    public abstract void zzq(int i) throws IOException;

    public abstract void zzr(int i, long j) throws IOException;

    public abstract void zzs(long j) throws IOException;
}
