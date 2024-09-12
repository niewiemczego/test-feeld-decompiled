package com.google.android.gms.auth.api.identity;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final class zbd implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r13) {
        /*
            r12 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r13)
            r1 = 0
            r2 = 0
            r6 = r1
            r7 = r6
            r11 = r7
            r4 = r2
            r5 = r4
            r8 = r5
            r9 = r8
            r10 = r9
        L_0x000e:
            int r1 = r13.dataPosition()
            if (r1 >= r0) goto L_0x0052
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r13)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 1: goto L_0x004b;
                case 2: goto L_0x0046;
                case 3: goto L_0x0041;
                case 4: goto L_0x003c;
                case 5: goto L_0x0032;
                case 6: goto L_0x002d;
                case 7: goto L_0x0028;
                case 8: goto L_0x0023;
                default: goto L_0x001f;
            }
        L_0x001f:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r13, r1)
            goto L_0x000e
        L_0x0023:
            boolean r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r13, r1)
            goto L_0x000e
        L_0x0028:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r13, r1)
            goto L_0x000e
        L_0x002d:
            java.lang.String r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r13, r1)
            goto L_0x000e
        L_0x0032:
            android.os.Parcelable$Creator r2 = android.accounts.Account.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r13, r1, r2)
            r8 = r1
            android.accounts.Account r8 = (android.accounts.Account) r8
            goto L_0x000e
        L_0x003c:
            boolean r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r13, r1)
            goto L_0x000e
        L_0x0041:
            boolean r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r13, r1)
            goto L_0x000e
        L_0x0046:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r13, r1)
            goto L_0x000e
        L_0x004b:
            android.os.Parcelable$Creator<com.google.android.gms.common.api.Scope> r2 = com.google.android.gms.common.api.Scope.CREATOR
            java.util.ArrayList r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r13, r1, r2)
            goto L_0x000e
        L_0x0052:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r13, r0)
            com.google.android.gms.auth.api.identity.AuthorizationRequest r13 = new com.google.android.gms.auth.api.identity.AuthorizationRequest
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.identity.zbd.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AuthorizationRequest[i];
    }
}
