package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
class zzfx extends zzfy {
    final zzft zzb;
    @CheckForNull
    final Character zzc;

    zzfx(zzft zzft, @CheckForNull Character ch) {
        this.zzb = zzft;
        if (ch != null) {
            ch.charValue();
            if (zzft.zzd('=')) {
                throw new IllegalArgumentException(zzfi.zza("Padding character %s was already in alphabet", ch));
            }
        }
        this.zzc = ch;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzfx) {
            zzfx zzfx = (zzfx) obj;
            if (this.zzb.equals(zzfx.zzb)) {
                Character ch = this.zzc;
                Character ch2 = zzfx.zzc;
                if (ch == ch2) {
                    return true;
                }
                if (ch == null || !ch.equals(ch2)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        Character ch = this.zzc;
        int hashCode = this.zzb.hashCode();
        if (ch == null) {
            i = 0;
        } else {
            i = ch.hashCode();
        }
        return i ^ hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public int zza(byte[] bArr, CharSequence charSequence) throws zzfw {
        zzft zzft;
        CharSequence zze = zze(charSequence);
        if (this.zzb.zzc(zze.length())) {
            int i = 0;
            int i2 = 0;
            while (i < zze.length()) {
                long j = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    zzft = this.zzb;
                    if (i3 >= zzft.zzc) {
                        break;
                    }
                    j <<= zzft.zzb;
                    if (i + i3 < zze.length()) {
                        j |= (long) this.zzb.zzb(zze.charAt(i4 + i));
                        i4++;
                    }
                    i3++;
                }
                int i5 = zzft.zzd;
                int i6 = i4 * zzft.zzb;
                int i7 = (i5 - 1) * 8;
                while (i7 >= (i5 * 8) - i6) {
                    bArr[i2] = (byte) ((int) ((j >>> i7) & 255));
                    i7 -= 8;
                    i2++;
                }
                i += this.zzb.zzc;
            }
            return i2;
        }
        throw new zzfw("Invalid input length " + zze.length());
    }

    /* access modifiers changed from: package-private */
    public void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzff.zzd(0, i2, bArr.length);
        while (i3 < i2) {
            zzf(appendable, bArr, i3, Math.min(this.zzb.zzd, i2 - i3));
            i3 += this.zzb.zzd;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i) {
        return (int) (((((long) this.zzb.zzb) * ((long) i)) + 7) / 8);
    }

    /* access modifiers changed from: package-private */
    public final int zzd(int i) {
        zzft zzft = this.zzb;
        return zzft.zzc * zzga.zza(i, zzft.zzd, RoundingMode.CEILING);
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzff.zzd(i, i + i2, bArr.length);
        int i3 = 0;
        zzff.zza(i2 <= this.zzb.zzd);
        long j = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j = (j | ((long) (bArr[i + i4] & 255))) << 8;
        }
        int i5 = (i2 + 1) * 8;
        zzft zzft = this.zzb;
        while (i3 < i2 * 8) {
            long j2 = j >>> ((i5 - zzft.zzb) - i3);
            zzft zzft2 = this.zzb;
            appendable.append(zzft2.zza(((int) j2) & zzft2.zza));
            i3 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i3 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append('=');
                i3 += this.zzb.zzb;
            }
        }
    }

    zzfx(String str, String str2, @CheckForNull Character ch) {
        this(new zzft(str, str2.toCharArray()), ch);
    }

    /* access modifiers changed from: package-private */
    public final CharSequence zze(CharSequence charSequence) {
        charSequence.getClass();
        Character ch = this.zzc;
        if (ch == null) {
            return charSequence;
        }
        ch.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0 || charSequence.charAt(length) != '=') {
            }
            length--;
            break;
        } while (charSequence.charAt(length) != '=');
        return charSequence.subSequence(0, length + 1);
    }
}
