package com.google.android.gms.internal.fido;

import com.google.common.base.Ascii;
import java.io.IOException;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
final class zzbd extends zzbe {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzbd(java.lang.String r2, java.lang.String r3, @javax.annotation.CheckForNull java.lang.Character r4) {
        /*
            r1 = this;
            com.google.android.gms.internal.fido.zzbb r0 = new com.google.android.gms.internal.fido.zzbb
            char[] r3 = r3.toCharArray()
            r0.<init>(r2, r3)
            r1.<init>(r0, r4)
            char[] r2 = r0.zzf
            int r2 = r2.length
            r3 = 64
            if (r2 != r3) goto L_0x0017
            r2 = 1
            goto L_0x0018
        L_0x0017:
            r2 = 0
        L_0x0018:
            com.google.android.gms.internal.fido.zzam.zzc(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzbd.<init>(java.lang.String, java.lang.String, java.lang.Character):void");
    }

    /* access modifiers changed from: package-private */
    public final void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzam.zze(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            zzbb zzbb = this.zzb;
            byte b = ((bArr[i3] & 255) << Ascii.DLE) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
            appendable.append(zzbb.zza(b >>> Ascii.DC2));
            appendable.append(this.zzb.zza((b >>> Ascii.FF) & 63));
            appendable.append(this.zzb.zza((b >>> 6) & 63));
            appendable.append(this.zzb.zza(b & Utf8.REPLACEMENT_BYTE));
            i3 = i6 + 1;
        }
        if (i3 < i2) {
            zzc(appendable, bArr, i3, i2 - i3);
        }
    }
}
