package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
public abstract class zzhm implements Serializable, Iterable<Byte> {
    public static final zzhm zza = new zzhw(zziz.zzb);
    private static final zzht zzb = new zzhz();
    private static final Comparator<zzhm> zzc = new zzho();
    private int zzd = 0;

    static /* synthetic */ int zza(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract byte zza(int i);

    public abstract zzhm zza(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzhn zzhn) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract byte zzb(int i);

    public abstract int zzb();

    /* access modifiers changed from: protected */
    public abstract int zzb(int i, int i2, int i3);

    public abstract boolean zzd();

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

    static zzhv zzc(int i) {
        return new zzhv(i);
    }

    public static zzhm zza(byte[] bArr, int i, int i2) {
        zza(i, i + i2, bArr.length);
        return new zzhw(zzb.zza(bArr, i, i2));
    }

    public static zzhm zza(String str) {
        return new zzhw(str.getBytes(zziz.zza));
    }

    static zzhm zza(byte[] bArr) {
        return new zzhw(bArr);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzb());
        if (zzb() <= 50) {
            str = zzlw.zza(this);
        } else {
            str = zzlw.zza(zza(0, 47)) + "...";
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public final String zzc() {
        return zzb() == 0 ? "" : zza(zziz.zza);
    }

    public /* synthetic */ Iterator iterator() {
        return new zzhp(this);
    }

    zzhm() {
    }
}
