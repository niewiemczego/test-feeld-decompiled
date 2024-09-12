package com.appsflyer.internal;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;

public final class AFe1uSDK {
    private static int AFInAppEventParameterName = 0;
    private static int AFInAppEventType = 0;
    private static int values = 1;

    static {
        AFInAppEventParameterName();
        ViewConfiguration.getMaximumFlingVelocity();
        View.resolveSizeAndState(0, 0, 0);
        Color.argb(0, 0, 0, 0);
        int i = AFInAppEventType + 75;
        values = i % 128;
        int i2 = i % 2;
    }

    static void AFInAppEventParameterName() {
        AFInAppEventParameterName = 47;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFe1qSDK AFInAppEventType(com.appsflyer.internal.AFb1lSDK r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r5 = this;
            r0 = 31
            if (r6 == 0) goto L_0x0006
            r1 = r0
            goto L_0x0008
        L_0x0006:
            r1 = 46
        L_0x0008:
            r2 = 1
            r3 = 0
            if (r1 == r0) goto L_0x000d
            goto L_0x0029
        L_0x000d:
            int r0 = values
            int r1 = r0 + 31
            int r4 = r1 % 128
            AFInAppEventType = r4
            int r1 = r1 % 2
            if (r8 == 0) goto L_0x0029
            if (r9 == 0) goto L_0x001d
            r1 = r3
            goto L_0x001e
        L_0x001d:
            r1 = r2
        L_0x001e:
            if (r1 == r2) goto L_0x0029
            int r0 = r0 + 35
            int r1 = r0 % 128
            AFInAppEventType = r1
            int r0 = r0 % 2
            goto L_0x002a
        L_0x0029:
            r2 = r3
        L_0x002a:
            if (r2 != 0) goto L_0x0046
            com.appsflyer.internal.AFe1qSDK r6 = new com.appsflyer.internal.AFe1qSDK
            com.appsflyer.internal.AFf1uSDK r7 = com.appsflyer.internal.AFf1uSDK.INTERNAL_ERROR
            r6.<init>(r3, r7)
            int r7 = values
            int r7 = r7 + 27
            int r8 = r7 % 128
            AFInAppEventType = r8
            int r7 = r7 % 2
            if (r7 == 0) goto L_0x0045
            r7 = 34
            int r7 = r7 / r3
            return r6
        L_0x0043:
            r6 = move-exception
            throw r6
        L_0x0045:
            return r6
        L_0x0046:
            com.appsflyer.internal.AFe1qSDK r6 = valueOf(r6, r7, r8, r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1uSDK.AFInAppEventType(com.appsflyer.internal.AFb1lSDK, java.lang.String, java.lang.String, java.lang.String):com.appsflyer.internal.AFe1qSDK");
    }

    private static AFe1qSDK valueOf(AFb1lSDK aFb1lSDK, String str, String str2, String str3) {
        boolean z = true;
        if (str == null) {
            if (aFb1lSDK.AFKeystoreWrapper != AFf1tSDK.DEFAULT) {
                z = false;
            }
            return new AFe1qSDK(z, AFf1uSDK.NA);
        }
        String str4 = "";
        Object[] objArr = new Object[1];
        AFInAppEventType("\f�\u0000￿￾�\f￾￾\u0002￾￾\u0001\u0002\u0001￾\u0004\u0002\u0004�￿￿��\u0001￿\u0000�\u0004￿\u0003￿￻￿\u000f\u0001￾\u0000￼\u0001\u0001\u0000￿\u0001\f\u0000\u0002\u0001\u0010\u0000\f\u0002￼￾￿\u0002￿￾\u0002\u0002\u0002�￼\u0002", false, 6 - TextUtils.lastIndexOf(str4, '0'), 100 - View.MeasureSpec.getMode(0), 64 - ExpandableListView.getPackedPositionGroup(0), objArr);
        String intern = ((String) objArr[0]).intern();
        if (aFb1lSDK.AFKeystoreWrapper == AFf1tSDK.CUSTOM) {
            str4 = new StringBuilder(str2).reverse().toString();
        } else {
            str3 = intern;
        }
        boolean equals = values(new StringBuilder(str3).reverse().toString(), aFb1lSDK.values, "android", "v1", str4).equals(str);
        return new AFe1qSDK(equals, equals ? AFf1uSDK.SUCCESS : AFf1uSDK.FAILURE);
    }

    private static String values(String str, String str2, String str3, String str4, String str5) {
        String values2 = AFb1ySDK.values(AFb1ySDK.AFKeystoreWrapper(str2, str3, str4, str5, ""), str);
        if ((values2.length() < 12 ? 17 : '=') != 17) {
            String substring = values2.substring(0, 12);
            int i = AFInAppEventType + 119;
            values = i % 128;
            int i2 = i % 2;
            return substring;
        }
        int i3 = AFInAppEventType + 91;
        values = i3 % 128;
        int i4 = i3 % 2;
        return values2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void AFInAppEventType(java.lang.String r6, boolean r7, int r8, int r9, int r10, java.lang.Object[] r11) {
        /*
            if (r6 == 0) goto L_0x0006
            char[] r6 = r6.toCharArray()
        L_0x0006:
            char[] r6 = (char[]) r6
            java.lang.Object r0 = com.appsflyer.internal.AFg1mSDK.valueOf
            monitor-enter(r0)
            char[] r1 = new char[r10]     // Catch:{ all -> 0x0075 }
            r2 = 0
            com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName = r2     // Catch:{ all -> 0x0075 }
        L_0x0010:
            int r3 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            if (r3 >= r10) goto L_0x0033
            int r3 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            char r3 = r6[r3]     // Catch:{ all -> 0x0075 }
            com.appsflyer.internal.AFg1mSDK.AFInAppEventType = r3     // Catch:{ all -> 0x0075 }
            int r3 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            int r4 = com.appsflyer.internal.AFg1mSDK.AFInAppEventType     // Catch:{ all -> 0x0075 }
            int r4 = r4 + r9
            char r4 = (char) r4     // Catch:{ all -> 0x0075 }
            r1[r3] = r4     // Catch:{ all -> 0x0075 }
            int r3 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            char r4 = r1[r3]     // Catch:{ all -> 0x0075 }
            int r5 = AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            int r4 = r4 - r5
            char r4 = (char) r4     // Catch:{ all -> 0x0075 }
            r1[r3] = r4     // Catch:{ all -> 0x0075 }
            int r3 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            int r3 = r3 + 1
            com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName = r3     // Catch:{ all -> 0x0075 }
            goto L_0x0010
        L_0x0033:
            if (r8 <= 0) goto L_0x004e
            com.appsflyer.internal.AFg1mSDK.AFKeystoreWrapper = r8     // Catch:{ all -> 0x0075 }
            char[] r6 = new char[r10]     // Catch:{ all -> 0x0075 }
            java.lang.System.arraycopy(r1, r2, r6, r2, r10)     // Catch:{ all -> 0x0075 }
            int r8 = com.appsflyer.internal.AFg1mSDK.AFKeystoreWrapper     // Catch:{ all -> 0x0075 }
            int r8 = r10 - r8
            int r9 = com.appsflyer.internal.AFg1mSDK.AFKeystoreWrapper     // Catch:{ all -> 0x0075 }
            java.lang.System.arraycopy(r6, r2, r1, r8, r9)     // Catch:{ all -> 0x0075 }
            int r8 = com.appsflyer.internal.AFg1mSDK.AFKeystoreWrapper     // Catch:{ all -> 0x0075 }
            int r9 = com.appsflyer.internal.AFg1mSDK.AFKeystoreWrapper     // Catch:{ all -> 0x0075 }
            int r9 = r10 - r9
            java.lang.System.arraycopy(r6, r8, r1, r2, r9)     // Catch:{ all -> 0x0075 }
        L_0x004e:
            if (r7 == 0) goto L_0x006c
            char[] r6 = new char[r10]     // Catch:{ all -> 0x0075 }
            com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName = r2     // Catch:{ all -> 0x0075 }
        L_0x0054:
            int r7 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            if (r7 >= r10) goto L_0x006b
            int r7 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            int r8 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            int r8 = r10 - r8
            int r8 = r8 + -1
            char r8 = r1[r8]     // Catch:{ all -> 0x0075 }
            r6[r7] = r8     // Catch:{ all -> 0x0075 }
            int r7 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            int r7 = r7 + 1
            com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName = r7     // Catch:{ all -> 0x0075 }
            goto L_0x0054
        L_0x006b:
            r1 = r6
        L_0x006c:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0075 }
            r6.<init>(r1)     // Catch:{ all -> 0x0075 }
            monitor-exit(r0)     // Catch:{ all -> 0x0075 }
            r11[r2] = r6
            return
        L_0x0075:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1uSDK.AFInAppEventType(java.lang.String, boolean, int, int, int, java.lang.Object[]):void");
    }
}
