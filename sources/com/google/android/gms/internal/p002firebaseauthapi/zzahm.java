package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzahm implements Serializable, Iterable<Byte> {
    public static final zzahm zza = new zzahw(zzajc.zzb);
    private static final zzaht zzb = new zzahz();
    private static final Comparator<zzahm> zzc = new zzaho();
    private int zzd = 0;

    static /* synthetic */ int zza(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract byte zza(int i);

    public abstract zzahm zza(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzahn zzahn) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void zza(byte[] bArr, int i, int i2, int i3);

    /* access modifiers changed from: package-private */
    public abstract byte zzb(int i);

    public abstract int zzb();

    /* access modifiers changed from: protected */
    public abstract int zzb(int i, int i2, int i3);

    public abstract zzaib zzc();

    public abstract boolean zzf();

    static int zza(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }

    public final int hashCode() {
        int i = this.zzd;
        if (i == 0) {
            int zzb2 = zzb();
            i = zzb(zzb2, 0, zzb2);
            if (i == 0) {
                i = 1;
            }
            this.zzd = i;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        return this.zzd;
    }

    static zzahv zzc(int i) {
        return new zzahv(i);
    }

    public static zzahm zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static zzahm zza(byte[] bArr, int i, int i2) {
        zza(i, i + i2, bArr.length);
        return new zzahw(zzb.zza(bArr, i, i2));
    }

    public static zzahm zza(String str) {
        return new zzahw(str.getBytes(zzajc.zza));
    }

    static zzahm zzb(byte[] bArr) {
        return new zzahw(bArr);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzb());
        if (zzb() <= 50) {
            str = zzalx.zza(this);
        } else {
            str = zzalx.zza(zza(0, 47)) + "...";
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public final String zzd() {
        return zzb() == 0 ? "" : zza(zzajc.zza);
    }

    public /* synthetic */ Iterator iterator() {
        return new zzahp(this);
    }

    zzahm() {
    }

    public final boolean zze() {
        return zzb() == 0;
    }

    public final byte[] zzg() {
        int zzb2 = zzb();
        if (zzb2 == 0) {
            return zzajc.zzb;
        }
        byte[] bArr = new byte[zzb2];
        zza(bArr, 0, 0, zzb2);
        return bArr;
    }
}
