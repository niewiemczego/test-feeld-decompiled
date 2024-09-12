package com.appsflyer.internal;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ExpandableListView;
import com.adapty.internal.utils.AnalyticsEventTypeAdapter;
import com.appsflyer.AFLogger;
import com.google.common.base.Ascii;
import java.lang.ref.WeakReference;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.CharUtils;
import org.json.JSONObject;

public final class AFb1ySDK {
    private static long AFInAppEventParameterName = 929402857429460130L;
    private static int AFInAppEventType = 1;
    private static int AFKeystoreWrapper;
    private static char valueOf;
    private static int values;

    public static String values(String str) {
        String str2;
        boolean z = false;
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            str2 = AFInAppEventParameterName(instance.digest());
            int i = AFInAppEventType + 61;
            AFKeystoreWrapper = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            AFLogger.afErrorLog(new StringBuilder("Error turning ").append(str.substring(0, 6)).append(".. to SHA1").toString(), e);
            str2 = null;
        }
        int i3 = AFKeystoreWrapper + 15;
        AFInAppEventType = i3 % 128;
        if (i3 % 2 != 0) {
            z = true;
        }
        if (z) {
            return str2;
        }
        throw null;
    }

    public static String AFInAppEventType(String str) {
        int i = AFKeystoreWrapper + 53;
        AFInAppEventType = i % 128;
        int i2 = i % 2;
        String str2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            str2 = AFInAppEventParameterName(instance.digest());
        } catch (Exception e) {
            AFLogger.afErrorLog(new StringBuilder("Error turning ").append(str.substring(0, 6)).append(".. to MD5").toString(), e);
        }
        int i3 = AFKeystoreWrapper + 15;
        AFInAppEventType = i3 % 128;
        int i4 = i3 % 2;
        return str2;
    }

    public static String AFKeystoreWrapper(String str) {
        int i = AFKeystoreWrapper + 57;
        AFInAppEventType = i % 128;
        int i2 = i % 2;
        String str2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            instance.update(str.getBytes());
            str2 = AFInAppEventType(instance.digest());
        } catch (Exception e) {
            AFLogger.afErrorLog(new StringBuilder("Error turning ").append(str.substring(0, 6)).append(".. to SHA-256").toString(), e);
        }
        int i3 = AFKeystoreWrapper + 85;
        AFInAppEventType = i3 % 128;
        int i4 = i3 % 2;
        return str2;
    }

    private static String AFInAppEventType(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if ((i < length ? 27 : CharUtils.CR) != 27) {
                String obj = sb.toString();
                int i2 = AFKeystoreWrapper + 53;
                AFInAppEventType = i2 % 128;
                int i3 = i2 % 2;
                return obj;
            }
            int i4 = AFKeystoreWrapper + 115;
            AFInAppEventType = i4 % 128;
            if (!(i4 % 2 == 0)) {
                sb.append(Integer.toString((bArr[i] & 255) + 256, 16).substring(1));
                i++;
            } else {
                sb.append(Integer.toString((bArr[i] | 257) >> Ascii.ACK, 26).substring(1));
                i += 52;
            }
        }
    }

    private static String AFInAppEventParameterName(byte[] bArr) {
        Formatter formatter = new Formatter();
        int length = bArr.length;
        boolean z = false;
        int i = 0;
        while (i < length) {
            int i2 = AFKeystoreWrapper + 49;
            AFInAppEventType = i2 % 128;
            if ((i2 % 2 == 0 ? 'P' : '<') != '<') {
                Object[] objArr = new Object[0];
                objArr[0] = Byte.valueOf(bArr[i]);
                formatter.format("%02x", objArr);
                i += 113;
            } else {
                formatter.format("%02x", new Object[]{Byte.valueOf(bArr[i])});
                i++;
            }
        }
        String obj = formatter.toString();
        formatter.close();
        int i3 = AFKeystoreWrapper + 61;
        AFInAppEventType = i3 % 128;
        if (i3 % 2 != 0) {
            z = true;
        }
        if (z) {
            return obj;
        }
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    public static String values(String str, String str2) {
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
            String lowerCase = AFInAppEventType(instance.doFinal(str.getBytes())).toLowerCase(Locale.getDefault());
            int i = AFKeystoreWrapper + 41;
            AFInAppEventType = i % 128;
            int i2 = i % 2;
            return lowerCase;
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            AFLogger.afErrorLog(e.getMessage(), e, true);
            return e.getMessage();
        }
    }

    public static boolean AFKeystoreWrapper(Map<String, Object> map, String[] strArr, AFb1bSDK aFb1bSDK) throws IllegalStateException {
        int i = AFKeystoreWrapper + 27;
        AFInAppEventType = i % 128;
        if (i % 2 == 0) {
            throw null;
        } else if (map == null || map.isEmpty()) {
            return false;
        } else {
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (!map.containsKey(strArr[i2])) {
                    return false;
                }
                i2++;
                int i3 = AFKeystoreWrapper + 49;
                AFInAppEventType = i3 % 128;
                int i4 = i3 % 2;
            }
            String str = (String) map.remove("sig");
            if (str == null) {
                return false;
            }
            boolean equals = values(new StringBuilder().append(new JSONObject((Map<?, ?>) map)).append(AFb1bSDK.AFKeystoreWrapper()).toString(), AFb1wSDK.AFInAppEventParameterName((WeakReference<Context>) new WeakReference(aFb1bSDK.values.AFKeystoreWrapper))).equals(str);
            int i5 = AFKeystoreWrapper + 49;
            AFInAppEventType = i5 % 128;
            if (i5 % 2 != 0) {
                return equals;
            }
            int i6 = 72 / 0;
            return equals;
        }
    }

    public static String AFKeystoreWrapper(Map<String, Object> map) {
        boolean z = false;
        Object[] objArr = new Object[1];
        AFKeystoreWrapper("玄뤇ᱠ", "䳯峊풕凟⅍ጀ㹅ɋ୼욓\f", View.resolveSizeAndState(0, 0, 0), "艐೥", (char) ExpandableListView.getPackedPositionGroup(0), objArr);
        String str = (String) map.get(((String) objArr[0]).intern());
        String values2 = values(new StringBuilder().append(((String) map.get("appsflyerKey")).substring(0, 7)).append(((String) map.get("uid")).substring(0, 7)).append(str.substring(str.length() - 7)).toString());
        int i = AFInAppEventType + 7;
        AFKeystoreWrapper = i % 128;
        if (i % 2 == 0) {
            z = true;
        }
        if (z) {
            return values2;
        }
        throw null;
    }

    public static String AFInAppEventParameterName(Map<String, Object> map) {
        StringBuilder append = new StringBuilder().append((String) map.get("appsflyerKey"));
        Object[] objArr = new Object[1];
        AFKeystoreWrapper("玄뤇ᱠ", "䳯峊풕凟⅍ጀ㹅ɋ୼욓\f", Color.blue(0), "艐೥", (char) TextUtils.indexOf("", "", 0, 0), objArr);
        String values2 = values(AFInAppEventType(new StringBuilder().append(new StringBuilder().append(new StringBuilder().append(new StringBuilder().append(append.append(map.get(((String) objArr[0]).intern())).toString()).append(map.get("uid")).toString()).append(map.get("installDate")).toString()).append(map.get(AnalyticsEventTypeAdapter.COUNTER)).toString()).append(map.get("iaecounter")).toString()));
        int i = AFKeystoreWrapper + 99;
        AFInAppEventType = i % 128;
        if (!(i % 2 == 0)) {
            return values2;
        }
        int i2 = 5 / 0;
        return values2;
    }

    public static String AFKeystoreWrapper(String... strArr) {
        int i = AFInAppEventType + 11;
        AFKeystoreWrapper = i % 128;
        boolean z = i % 2 == 0;
        String join = TextUtils.join("⁣", strArr);
        if (!z) {
            int i2 = 47 / 0;
        }
        return join;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void AFKeystoreWrapper(java.lang.String r8, java.lang.String r9, int r10, java.lang.String r11, char r12, java.lang.Object[] r13) {
        /*
            if (r11 == 0) goto L_0x0006
            char[] r11 = r11.toCharArray()
        L_0x0006:
            char[] r11 = (char[]) r11
            if (r9 == 0) goto L_0x000e
            char[] r9 = r9.toCharArray()
        L_0x000e:
            char[] r9 = (char[]) r9
            if (r8 == 0) goto L_0x0016
            char[] r8 = r8.toCharArray()
        L_0x0016:
            char[] r8 = (char[]) r8
            java.lang.Object r0 = com.appsflyer.internal.AFg1rSDK.AFInAppEventType
            monitor-enter(r0)
            java.lang.Object r8 = r8.clone()     // Catch:{ all -> 0x0094 }
            char[] r8 = (char[]) r8     // Catch:{ all -> 0x0094 }
            java.lang.Object r11 = r11.clone()     // Catch:{ all -> 0x0094 }
            char[] r11 = (char[]) r11     // Catch:{ all -> 0x0094 }
            r1 = 0
            char r2 = r8[r1]     // Catch:{ all -> 0x0094 }
            r12 = r12 ^ r2
            char r12 = (char) r12     // Catch:{ all -> 0x0094 }
            r8[r1] = r12     // Catch:{ all -> 0x0094 }
            r12 = 2
            char r2 = r11[r12]     // Catch:{ all -> 0x0094 }
            char r10 = (char) r10     // Catch:{ all -> 0x0094 }
            int r2 = r2 + r10
            char r10 = (char) r2     // Catch:{ all -> 0x0094 }
            r11[r12] = r10     // Catch:{ all -> 0x0094 }
            int r10 = r9.length     // Catch:{ all -> 0x0094 }
            char[] r2 = new char[r10]     // Catch:{ all -> 0x0094 }
            com.appsflyer.internal.AFg1rSDK.valueOf = r1     // Catch:{ all -> 0x0094 }
        L_0x003b:
            int r3 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0094 }
            if (r3 >= r10) goto L_0x008b
            int r3 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0094 }
            int r3 = r3 + r12
            int r3 = r3 % 4
            int r4 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0094 }
            int r4 = r4 + 3
            int r4 = r4 % 4
            int r5 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0094 }
            int r5 = r5 % 4
            char r5 = r8[r5]     // Catch:{ all -> 0x0094 }
            int r5 = r5 * 32718
            char r6 = r11[r3]     // Catch:{ all -> 0x0094 }
            int r5 = r5 + r6
            r6 = 65535(0xffff, float:9.1834E-41)
            int r5 = r5 % r6
            char r5 = (char) r5     // Catch:{ all -> 0x0094 }
            com.appsflyer.internal.AFg1rSDK.values = r5     // Catch:{ all -> 0x0094 }
            char r5 = r8[r4]     // Catch:{ all -> 0x0094 }
            int r5 = r5 * 32718
            char r3 = r11[r3]     // Catch:{ all -> 0x0094 }
            int r5 = r5 + r3
            int r5 = r5 / r6
            char r3 = (char) r5     // Catch:{ all -> 0x0094 }
            r11[r4] = r3     // Catch:{ all -> 0x0094 }
            char r3 = com.appsflyer.internal.AFg1rSDK.values     // Catch:{ all -> 0x0094 }
            r8[r4] = r3     // Catch:{ all -> 0x0094 }
            int r3 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0094 }
            int r5 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0094 }
            char r5 = r9[r5]     // Catch:{ all -> 0x0094 }
            char r4 = r8[r4]     // Catch:{ all -> 0x0094 }
            r4 = r4 ^ r5
            long r4 = (long) r4     // Catch:{ all -> 0x0094 }
            long r6 = AFInAppEventParameterName     // Catch:{ all -> 0x0094 }
            long r4 = r4 ^ r6
            int r6 = values     // Catch:{ all -> 0x0094 }
            long r6 = (long) r6     // Catch:{ all -> 0x0094 }
            long r4 = r4 ^ r6
            char r6 = valueOf     // Catch:{ all -> 0x0094 }
            long r6 = (long) r6     // Catch:{ all -> 0x0094 }
            long r4 = r4 ^ r6
            int r4 = (int) r4     // Catch:{ all -> 0x0094 }
            char r4 = (char) r4     // Catch:{ all -> 0x0094 }
            r2[r3] = r4     // Catch:{ all -> 0x0094 }
            int r3 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0094 }
            int r3 = r3 + 1
            com.appsflyer.internal.AFg1rSDK.valueOf = r3     // Catch:{ all -> 0x0094 }
            goto L_0x003b
        L_0x008b:
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x0094 }
            r8.<init>(r2)     // Catch:{ all -> 0x0094 }
            monitor-exit(r0)     // Catch:{ all -> 0x0094 }
            r13[r1] = r8
            return
        L_0x0094:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1ySDK.AFKeystoreWrapper(java.lang.String, java.lang.String, int, java.lang.String, char, java.lang.Object[]):void");
    }
}
