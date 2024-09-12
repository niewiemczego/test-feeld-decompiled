package com.appsflyer.internal;

import android.content.Context;
import com.facebook.internal.AttributionIdentifiers;

final class AFa1aSDK extends AFb1jSDK<String> {
    AFa1aSDK(Context context, AFc1vSDK aFc1vSDK) {
        super(context, aFc1vSDK, AttributionIdentifiers.ATTRIBUTION_ID_CONTENT_PROVIDER, "E3F9E1E0CF99D0E56A055BA65E241B3399F7CEA524326B0CDD6EC1327ED0FDC1");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c  */
    /* renamed from: AFInAppEventType */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String AFInAppEventParameterName() {
        /*
            r9 = this;
            r0 = 0
            java.lang.String r1 = "aid"
            android.content.Context r2 = r9.AFKeystoreWrapper     // Catch:{ all -> 0x0047 }
            android.content.ContentResolver r3 = r2.getContentResolver()     // Catch:{ all -> 0x0047 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = "content://"
            r2.<init>(r4)     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = r9.valueOf     // Catch:{ all -> 0x0047 }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x0047 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0047 }
            android.net.Uri r4 = android.net.Uri.parse(r2)     // Catch:{ all -> 0x0047 }
            java.lang.String[] r5 = new java.lang.String[]{r1}     // Catch:{ all -> 0x0047 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0041
            boolean r3 = r2.moveToFirst()     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x0041
            int r0 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x003f }
            java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003e
            r2.close()
        L_0x003e:
            return r0
        L_0x003f:
            r0 = move-exception
            goto L_0x004a
        L_0x0041:
            if (r2 == 0) goto L_0x0046
            r2.close()
        L_0x0046:
            return r0
        L_0x0047:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x004a:
            if (r2 == 0) goto L_0x004f
            r2.close()
        L_0x004f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1aSDK.AFInAppEventParameterName():java.lang.String");
    }

    public final String AFKeystoreWrapper() {
        this.AFInAppEventParameterName.AFInAppEventType().execute(this.values);
        return (String) super.values();
    }

    public final /* synthetic */ Object values() {
        this.AFInAppEventParameterName.AFInAppEventType().execute(this.values);
        return (String) super.values();
    }
}
