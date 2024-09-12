package com.google.android.gms.auth.api.identity;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final class zbf implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v6, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r12) {
        /*
            r11 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r12)
            r1 = 0
            r2 = 0
            r7 = r1
            r8 = r7
            r4 = r2
            r5 = r4
            r6 = r5
            r9 = r6
            r10 = r9
        L_0x000d:
            int r1 = r12.dataPosition()
            if (r1 >= r0) goto L_0x0059
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r12)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 1: goto L_0x004f;
                case 2: goto L_0x0045;
                case 3: goto L_0x0040;
                case 4: goto L_0x003b;
                case 5: goto L_0x0036;
                case 6: goto L_0x002c;
                case 7: goto L_0x0022;
                default: goto L_0x001e;
            }
        L_0x001e:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r12, r1)
            goto L_0x000d
        L_0x0022:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.identity.BeginSignInRequest$PasskeyJsonRequestOptions> r2 = com.google.android.gms.auth.api.identity.BeginSignInRequest.PasskeyJsonRequestOptions.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r12, r1, r2)
            r10 = r1
            com.google.android.gms.auth.api.identity.BeginSignInRequest$PasskeyJsonRequestOptions r10 = (com.google.android.gms.auth.api.identity.BeginSignInRequest.PasskeyJsonRequestOptions) r10
            goto L_0x000d
        L_0x002c:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.identity.BeginSignInRequest$PasskeysRequestOptions> r2 = com.google.android.gms.auth.api.identity.BeginSignInRequest.PasskeysRequestOptions.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r12, r1, r2)
            r9 = r1
            com.google.android.gms.auth.api.identity.BeginSignInRequest$PasskeysRequestOptions r9 = (com.google.android.gms.auth.api.identity.BeginSignInRequest.PasskeysRequestOptions) r9
            goto L_0x000d
        L_0x0036:
            int r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r12, r1)
            goto L_0x000d
        L_0x003b:
            boolean r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r12, r1)
            goto L_0x000d
        L_0x0040:
            java.lang.String r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r12, r1)
            goto L_0x000d
        L_0x0045:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.identity.BeginSignInRequest$GoogleIdTokenRequestOptions> r2 = com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r12, r1, r2)
            r5 = r1
            com.google.android.gms.auth.api.identity.BeginSignInRequest$GoogleIdTokenRequestOptions r5 = (com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions) r5
            goto L_0x000d
        L_0x004f:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions> r2 = com.google.android.gms.auth.api.identity.BeginSignInRequest.PasswordRequestOptions.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r12, r1, r2)
            r4 = r1
            com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions r4 = (com.google.android.gms.auth.api.identity.BeginSignInRequest.PasswordRequestOptions) r4
            goto L_0x000d
        L_0x0059:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r12, r0)
            com.google.android.gms.auth.api.identity.BeginSignInRequest r12 = new com.google.android.gms.auth.api.identity.BeginSignInRequest
            r3 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.identity.zbf.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new BeginSignInRequest[i];
    }
}
