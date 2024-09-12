package com.google.firebase.auth.internal;

import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzae implements Parcelable.Creator<zzaf> {
    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v7, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r19) {
        /*
            r18 = this;
            r0 = r19
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r19)
            r2 = 0
            r3 = 0
            r5 = r2
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r15 = r13
            r16 = r15
            r17 = r16
            r14 = r3
        L_0x0017:
            int r2 = r19.dataPosition()
            if (r2 >= r1) goto L_0x008b
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r19)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 1: goto L_0x0081;
                case 2: goto L_0x0077;
                case 3: goto L_0x0072;
                case 4: goto L_0x006d;
                case 5: goto L_0x0066;
                case 6: goto L_0x0061;
                case 7: goto L_0x005c;
                case 8: goto L_0x0057;
                case 9: goto L_0x004d;
                case 10: goto L_0x0048;
                case 11: goto L_0x003e;
                case 12: goto L_0x0033;
                case 13: goto L_0x002c;
                default: goto L_0x0028;
            }
        L_0x0028:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0017
        L_0x002c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase-auth-api.zzafp> r3 = com.google.android.gms.internal.p002firebaseauthapi.zzafp.CREATOR
            java.util.ArrayList r17 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r0, r2, r3)
            goto L_0x0017
        L_0x0033:
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzbj> r3 = com.google.firebase.auth.internal.zzbj.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r16 = r2
            com.google.firebase.auth.internal.zzbj r16 = (com.google.firebase.auth.internal.zzbj) r16
            goto L_0x0017
        L_0x003e:
            android.os.Parcelable$Creator<com.google.firebase.auth.zzd> r3 = com.google.firebase.auth.zzd.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r15 = r2
            com.google.firebase.auth.zzd r15 = (com.google.firebase.auth.zzd) r15
            goto L_0x0017
        L_0x0048:
            boolean r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0017
        L_0x004d:
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzah> r3 = com.google.firebase.auth.internal.zzah.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r13 = r2
            com.google.firebase.auth.internal.zzah r13 = (com.google.firebase.auth.internal.zzah) r13
            goto L_0x0017
        L_0x0057:
            java.lang.Boolean r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBooleanObject(r0, r2)
            goto L_0x0017
        L_0x005c:
            java.lang.String r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0017
        L_0x0061:
            java.util.ArrayList r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringList(r0, r2)
            goto L_0x0017
        L_0x0066:
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzab> r3 = com.google.firebase.auth.internal.zzab.CREATOR
            java.util.ArrayList r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r0, r2, r3)
            goto L_0x0017
        L_0x006d:
            java.lang.String r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0017
        L_0x0072:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0017
        L_0x0077:
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzab> r3 = com.google.firebase.auth.internal.zzab.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r6 = r2
            com.google.firebase.auth.internal.zzab r6 = (com.google.firebase.auth.internal.zzab) r6
            goto L_0x0017
        L_0x0081:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase-auth-api.zzafm> r3 = com.google.android.gms.internal.p002firebaseauthapi.zzafm.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r5 = r2
            com.google.android.gms.internal.firebase-auth-api.zzafm r5 = (com.google.android.gms.internal.p002firebaseauthapi.zzafm) r5
            goto L_0x0017
        L_0x008b:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.firebase.auth.internal.zzaf r0 = new com.google.firebase.auth.internal.zzaf
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzae.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaf[i];
    }
}
