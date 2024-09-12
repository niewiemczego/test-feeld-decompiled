package com.appsflyer.internal;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.browser.trusted.sharing.ShareTarget;
import com.adapty.internal.utils.AnalyticsEventTypeAdapter;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.google.android.gms.common.ConnectionResult;
import io.sentry.protocol.Mechanism;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

public final class AFc1kSDK {
    public static String AFInAppEventParameterName = "https://%sgcdsdk.%s/install_data/v5.0/";
    private static String AFKeystoreWrapper = "https://%smonitorsdk.%s/remote-debug?app_id=";
    private static char[] afDebugLog = null;
    private static int afErrorLog = 1;
    private static int afRDLog;
    private static String values = "https://%sonelink.%s/shortlink-sdk/v2";
    private final CreateOneLinkHttpTask AFInAppEventType;
    private final AFd1xSDK AFLogger;
    private final AppsFlyerProperties afInfoLog;
    private final AFb1bSDK valueOf;

    static void AFInAppEventParameterName() {
        afDebugLog = new char[]{':', 't', 'j', 'g', 'j', 'h', '^', '@', 'I', 'S', 'S', 'k', '1', 'j', 'i', 'g', 'i'};
    }

    static {
        AFInAppEventParameterName();
        int i = afRDLog + 61;
        afErrorLog = i % 128;
        int i2 = i % 2;
    }

    public AFc1kSDK(CreateOneLinkHttpTask createOneLinkHttpTask, AFb1bSDK aFb1bSDK, AppsFlyerProperties appsFlyerProperties, AFd1xSDK aFd1xSDK) {
        this.AFInAppEventType = createOneLinkHttpTask;
        this.valueOf = aFb1bSDK;
        this.afInfoLog = appsFlyerProperties;
        this.AFLogger = aFd1xSDK;
    }

    public final AFc1mSDK<String> valueOf(Map<String, Object> map, String str) {
        boolean z = false;
        String obj = new StringBuilder().append(String.format("https://%sars.%s/api/v2/android/validate_subscription?app_id=", new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()})).append(this.valueOf.values.AFKeystoreWrapper.getPackageName()).toString();
        try {
            Object[] objArr = new Object[2];
            objArr[1] = str;
            objArr[0] = map;
            Throwable th = null;
            AFc1mSDK<String> AFInAppEventParameterName2 = AFInAppEventParameterName(new AFc1rSDK(obj, (byte[]) ((Class) AFa1vSDK.AFInAppEventParameterName((char) (48063 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), 37 - (ViewConfiguration.getScrollBarSize() >> 8), 73 - ExpandableListView.getPackedPositionGroup(0))).getMethod("AFInAppEventParameterName", new Class[]{Map.class, String.class}).invoke(th, objArr), ShareTarget.METHOD_POST, Collections.emptyMap(), true), new AFc1hSDK());
            int i = afRDLog + 119;
            afErrorLog = i % 128;
            if (i % 2 != 0) {
                z = true;
            }
            if (z) {
                return AFInAppEventParameterName2;
            }
            super.hashCode();
            throw th;
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th2;
        }
    }

    public final AFc1mSDK<String> AFInAppEventParameterName(Map<String, Object> map, String str) {
        String obj = new StringBuilder().append(String.format("https://%sviap.%s/api/v1/android/validate_purchase?app_id=", new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()})).append(this.valueOf.values.AFKeystoreWrapper.getPackageName()).toString();
        try {
            Object[] objArr = new Object[2];
            objArr[1] = str;
            objArr[0] = map;
            AFc1mSDK<String> AFInAppEventParameterName2 = AFInAppEventParameterName(new AFc1rSDK(obj, (byte[]) ((Class) AFa1vSDK.AFInAppEventParameterName((char) (48063 - (ViewConfiguration.getWindowTouchSlop() >> 8)), Gravity.getAbsoluteGravity(0, 0) + 37, (Process.myTid() >> 22) + 73)).getMethod("AFInAppEventParameterName", new Class[]{Map.class, String.class}).invoke((Object) null, objArr), ShareTarget.METHOD_POST, Collections.emptyMap(), true), new AFc1hSDK());
            int i = afErrorLog + 81;
            afRDLog = i % 128;
            if ((i % 2 != 0 ? '7' : 'c') != '7') {
                return AFInAppEventParameterName2;
            }
            int i2 = 79 / 0;
            return AFInAppEventParameterName2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public final AFc1mSDK<String> AFInAppEventParameterName(Map<String, Object> map) {
        AFc1mSDK<String> AFInAppEventParameterName2 = AFInAppEventParameterName(new AFc1rSDK(new StringBuilder().append(String.format(AFKeystoreWrapper, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()})).append(this.valueOf.values.AFKeystoreWrapper.getPackageName()).toString(), new JSONObject((Map<?, ?>) map).toString().getBytes(), ShareTarget.METHOD_POST, Collections.emptyMap(), false), new AFc1hSDK());
        int i = afRDLog + 5;
        afErrorLog = i % 128;
        if (i % 2 != 0) {
            return AFInAppEventParameterName2;
        }
        int i2 = 92 / 0;
        return AFInAppEventParameterName2;
    }

    public final AFc1mSDK<AFb1lSDK> AFInAppEventType(boolean z, boolean z2, String str, int i) {
        String str2;
        String str3;
        AFd1xSDK aFd1xSDK = this.AFLogger;
        Intrinsics.checkNotNullParameter(str, "");
        if (z) {
            str2 = AFd1xSDK.values;
            int i2 = afRDLog + 93;
            afErrorLog = i2 % 128;
            int i3 = i2 % 2;
        } else {
            str2 = AFd1xSDK.AFInAppEventType;
        }
        String str4 = "stg";
        if (z2) {
            int i4 = afRDLog + 61;
            afErrorLog = i4 % 128;
            if ((i4 % 2 == 0 ? '?' : '7') != '7') {
                int i5 = 67 / 0;
            }
        } else {
            str4 = "";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[4];
        if ((AFd1xSDK.valueOf() ? 'C' : 20) != 20) {
            str3 = (String) aFd1xSDK.AFInAppEventParameterName.getValue();
        } else {
            str3 = "";
        }
        objArr[0] = str3;
        objArr[1] = str4;
        objArr[2] = aFd1xSDK.AFInAppEventParameterName();
        objArr[3] = str;
        String format = String.format(str2, Arrays.copyOf(objArr, 4));
        Intrinsics.checkNotNullExpressionValue(format, "");
        AFc1rSDK aFc1rSDK = new AFc1rSDK(format, ShareTarget.METHOD_GET);
        aFc1rSDK.AFInAppEventParameterName((int) ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        return AFInAppEventParameterName(aFc1rSDK, new AFc1fSDK());
    }

    public final AFc1mSDK<String> AFInAppEventType(AFa1sSDK aFa1sSDK, String str) {
        try {
            Object[] objArr = new Object[2];
            objArr[1] = str;
            objArr[0] = aFa1sSDK;
            AFc1mSDK<String> AFInAppEventParameterName2 = AFInAppEventParameterName(new AFc1rSDK(aFa1sSDK.AFLogger, (byte[]) ((Class) AFa1vSDK.AFInAppEventParameterName((char) (TextUtils.indexOf("", "") + 48063), 37 - TextUtils.indexOf("", "", 0), 74 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)))).getMethod("AFKeystoreWrapper", new Class[]{AFa1sSDK.class, String.class}).invoke((Object) null, objArr), ShareTarget.METHOD_POST, Collections.emptyMap(), aFa1sSDK.valueOf()), new AFc1hSDK());
            int i = afRDLog + 25;
            afErrorLog = i % 128;
            if (i % 2 != 0) {
                return AFInAppEventParameterName2;
            }
            int i2 = 91 / 0;
            return AFInAppEventParameterName2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public final AFc1mSDK<Map<String, Object>> values(String str, String str2) {
        AFc1mSDK<Map<String, Object>> AFInAppEventParameterName2 = AFInAppEventParameterName((AFc1rSDK) AFc1iSDK.AFKeystoreWrapper(this.valueOf.values.AFKeystoreWrapper.getPackageName(), AFb1wSDK.AFInAppEventParameterName((WeakReference<Context>) new WeakReference(this.valueOf.values.AFKeystoreWrapper)), str, str2), new AFc1dSDK());
        int i = afRDLog + 69;
        afErrorLog = i % 128;
        if (i % 2 != 0) {
            return AFInAppEventParameterName2;
        }
        throw null;
    }

    public final AFc1mSDK<String> values(AFe1eSDK aFe1eSDK) {
        AFc1mSDK<String> AFInAppEventParameterName2 = AFInAppEventParameterName(new AFc1rSDK(aFe1eSDK.AFLogger, aFe1eSDK.values(), ShareTarget.METHOD_POST, Collections.emptyMap(), true), new AFc1hSDK());
        int i = afErrorLog + 17;
        afRDLog = i % 128;
        if ((i % 2 != 0 ? '*' : '$') == '$') {
            return AFInAppEventParameterName2;
        }
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    public final AFc1mSDK<String> values(String str, Map<String, String> map, String str2, UUID uuid, String str3) {
        String obj = uuid.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("ttl", "-1");
        hashMap.put("uuid", obj);
        hashMap.put("data", map);
        hashMap.put(Mechanism.JsonKeys.META, AFKeystoreWrapper());
        if (str2 != null) {
            int i = afErrorLog + 89;
            afRDLog = i % 128;
            int i2 = i % 2;
            hashMap.put("brand_domain", str2);
        }
        String jSONObject = AFa1oSDK.values(hashMap).toString();
        HashMap hashMap2 = new HashMap();
        Object[] objArr = new Object[1];
        valueOf(true, "\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001", new int[]{0, 12, 0, 10}, objArr);
        hashMap2.put(((String) objArr[0]).intern(), AFInAppEventParameterName(str3, obj, ShareTarget.METHOD_POST, jSONObject));
        AFc1mSDK<String> valueOf2 = valueOf(new AFc1rSDK(new StringBuilder().append(String.format(values, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()})).append("/").append(str).toString(), jSONObject.getBytes(Charset.forName("UTF-8")), ShareTarget.METHOD_POST, hashMap2, false), new AFc1hSDK(), true);
        int i3 = afRDLog + 69;
        afErrorLog = i3 % 128;
        int i4 = i3 % 2;
        return valueOf2;
    }

    public final AFc1mSDK<Map<String, String>> AFKeystoreWrapper(String str, String str2, UUID uuid, String str3) {
        String obj = uuid.toString();
        String obj2 = new StringBuilder().append(String.format(values, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()})).append("/").append(str).append("?id=").append(str2).toString();
        Map<String, Object> AFKeystoreWrapper2 = AFKeystoreWrapper();
        String valueOf2 = String.valueOf(AFKeystoreWrapper2.get("build_number"));
        HashMap hashMap = new HashMap();
        hashMap.put("Af-UUID", uuid.toString());
        hashMap.put("Af-Meta-Sdk-Ver", valueOf2);
        hashMap.put("Af-Meta-Counter", String.valueOf(AFKeystoreWrapper2.get(AnalyticsEventTypeAdapter.COUNTER)));
        hashMap.put("Af-Meta-Model", String.valueOf(AFKeystoreWrapper2.get("model")));
        hashMap.put("Af-Meta-Platform", String.valueOf(AFKeystoreWrapper2.get("platformextension")));
        hashMap.put("Af-Meta-System-Version", String.valueOf(AFKeystoreWrapper2.get("sdk")));
        Object[] objArr = new Object[1];
        valueOf(true, "\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001", new int[]{0, 12, 0, 10}, objArr);
        hashMap.put(((String) objArr[0]).intern(), AFInAppEventParameterName(str3, obj, ShareTarget.METHOD_GET, obj, str, str2, valueOf2));
        AFc1mSDK<Map<String, String>> AFInAppEventParameterName2 = AFInAppEventParameterName(new AFc1rSDK(obj2, (byte[]) null, ShareTarget.METHOD_GET, hashMap, false), new AFc1cSDK());
        int i = afRDLog + 1;
        afErrorLog = i % 128;
        int i2 = i % 2;
        return AFInAppEventParameterName2;
    }

    public final AFc1mSDK<String> AFKeystoreWrapper(String str) {
        AFc1mSDK<String> AFInAppEventParameterName2 = AFInAppEventParameterName(new AFc1rSDK(str, (byte[]) null, ShareTarget.METHOD_GET, Collections.emptyMap(), false).AFInAppEventParameterName(10000).AFVersionDeclaration(), new AFc1hSDK());
        int i = afErrorLog + 105;
        afRDLog = i % 128;
        if ((i % 2 != 0 ? 21 : ',') != 21) {
            return AFInAppEventParameterName2;
        }
        int i2 = 49 / 0;
        return AFInAppEventParameterName2;
    }

    private <T> AFc1mSDK<T> AFInAppEventParameterName(AFc1rSDK aFc1rSDK, AFd1ySDK<T> aFd1ySDK) {
        int i = afRDLog + 121;
        afErrorLog = i % 128;
        int i2 = i % 2;
        AFc1mSDK<T> valueOf2 = valueOf(aFc1rSDK, aFd1ySDK, AFInAppEventType());
        int i3 = afRDLog + 57;
        afErrorLog = i3 % 128;
        int i4 = i3 % 2;
        return valueOf2;
    }

    private <T> AFc1mSDK<T> valueOf(AFc1rSDK aFc1rSDK, AFd1ySDK<T> aFd1ySDK, boolean z) {
        aFc1rSDK.valueOf(z);
        CreateOneLinkHttpTask createOneLinkHttpTask = this.AFInAppEventType;
        AFc1mSDK<T> aFc1mSDK = new AFc1mSDK<>(aFc1rSDK, createOneLinkHttpTask.valueOf, createOneLinkHttpTask.AFInAppEventParameterName, aFd1ySDK);
        int i = afRDLog + 107;
        afErrorLog = i % 128;
        int i2 = i % 2;
        return aFc1mSDK;
    }

    private Map<String, Object> AFKeystoreWrapper() {
        HashMap hashMap = new HashMap();
        hashMap.put("build_number", "6.10.3");
        hashMap.put(AnalyticsEventTypeAdapter.COUNTER, Integer.valueOf(this.valueOf.AFInAppEventType.AFKeystoreWrapper("appsFlyerCount", 0)));
        hashMap.put("model", Build.MODEL);
        Object[] objArr = new Object[1];
        valueOf(false, "\u0000\u0000\u0001\u0001\u0000", new int[]{12, 5, 0, 5}, objArr);
        hashMap.put(((String) objArr[0]).intern(), Build.BRAND);
        hashMap.put("sdk", Integer.toString(Build.VERSION.SDK_INT));
        AFb1bSDK aFb1bSDK = this.valueOf;
        hashMap.put("app_version_name", AFa1cSDK.AFInAppEventParameterName(aFb1bSDK.values.AFKeystoreWrapper, aFb1bSDK.values.AFKeystoreWrapper.getPackageName()));
        hashMap.put("app_id", this.valueOf.values.AFKeystoreWrapper.getPackageName());
        hashMap.put("platformextension", new AFb1uSDK().AFKeystoreWrapper());
        int i = afRDLog + 25;
        afErrorLog = i % 128;
        int i2 = i % 2;
        return hashMap;
    }

    private static String AFInAppEventParameterName(String str, String str2, String... strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        arrayList.add(1, "v2");
        String values2 = AFb1ySDK.values(AFb1ySDK.AFKeystoreWrapper((String[]) arrayList.toArray(new String[0])), new StringBuilder().append(str).append(str2).append("v2").toString());
        int i = afErrorLog + 69;
        afRDLog = i % 128;
        int i2 = i % 2;
        return values2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        if ((!r5.afInfoLog.getBoolean(com.appsflyer.AppsFlyerProperties.HTTP_CACHE, true)) != false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r5.afInfoLog.getBoolean(com.appsflyer.AppsFlyerProperties.HTTP_CACHE, true) == false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        r0 = afErrorLog + 103;
        afRDLog = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean AFInAppEventType() {
        /*
            r5 = this;
            int r0 = afRDLog
            int r0 = r0 + 99
            int r1 = r0 % 128
            afErrorLog = r1
            int r0 = r0 % 2
            r1 = 51
            if (r0 != 0) goto L_0x0011
            r0 = 19
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            r2 = 0
            java.lang.String r3 = "http_cache"
            r4 = 1
            if (r0 == r1) goto L_0x0026
            com.appsflyer.AppsFlyerProperties r0 = r5.afInfoLog
            boolean r0 = r0.getBoolean(r3, r4)
            if (r0 != 0) goto L_0x0022
            r0 = r4
            goto L_0x0023
        L_0x0022:
            r0 = r2
        L_0x0023:
            if (r0 == 0) goto L_0x0039
            goto L_0x002e
        L_0x0026:
            com.appsflyer.AppsFlyerProperties r0 = r5.afInfoLog
            boolean r0 = r0.getBoolean(r3, r4)
            if (r0 != 0) goto L_0x0039
        L_0x002e:
            int r0 = afRDLog
            int r0 = r0 + 45
            int r1 = r0 % 128
            afErrorLog = r1
            int r0 = r0 % 2
            return r4
        L_0x0039:
            int r0 = afErrorLog
            int r0 = r0 + 103
            int r1 = r0 % 128
            afRDLog = r1
            int r0 = r0 % 2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1kSDK.AFInAppEventType():boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r8v4, types: [char] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void valueOf(boolean r12, java.lang.String r13, int[] r14, java.lang.Object[] r15) {
        /*
            if (r13 == 0) goto L_0x0008
            java.lang.String r0 = "ISO-8859-1"
            byte[] r13 = r13.getBytes(r0)
        L_0x0008:
            byte[] r13 = (byte[]) r13
            java.lang.Object r0 = com.appsflyer.internal.AFg1vSDK.AFInAppEventParameterName
            monitor-enter(r0)
            r1 = 0
            r2 = r14[r1]     // Catch:{ all -> 0x00a2 }
            r3 = 1
            r4 = r14[r3]     // Catch:{ all -> 0x00a2 }
            r5 = 2
            r6 = r14[r5]     // Catch:{ all -> 0x00a2 }
            r7 = 3
            r7 = r14[r7]     // Catch:{ all -> 0x00a2 }
            char[] r8 = afDebugLog     // Catch:{ all -> 0x00a2 }
            char[] r9 = new char[r4]     // Catch:{ all -> 0x00a2 }
            java.lang.System.arraycopy(r8, r2, r9, r1, r4)     // Catch:{ all -> 0x00a2 }
            if (r13 == 0) goto L_0x0054
            char[] r2 = new char[r4]     // Catch:{ all -> 0x00a2 }
            com.appsflyer.internal.AFg1vSDK.AFInAppEventType = r1     // Catch:{ all -> 0x00a2 }
            r8 = r1
        L_0x0027:
            int r10 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            if (r10 >= r4) goto L_0x0053
            int r10 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            byte r10 = r13[r10]     // Catch:{ all -> 0x00a2 }
            if (r10 != r3) goto L_0x003e
            int r10 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            int r11 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            char r11 = r9[r11]     // Catch:{ all -> 0x00a2 }
            int r11 = r11 << r3
            int r11 = r11 + r3
            int r11 = r11 - r8
            char r8 = (char) r11     // Catch:{ all -> 0x00a2 }
            r2[r10] = r8     // Catch:{ all -> 0x00a2 }
            goto L_0x0049
        L_0x003e:
            int r10 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            int r11 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            char r11 = r9[r11]     // Catch:{ all -> 0x00a2 }
            int r11 = r11 << r3
            int r11 = r11 - r8
            char r8 = (char) r11     // Catch:{ all -> 0x00a2 }
            r2[r10] = r8     // Catch:{ all -> 0x00a2 }
        L_0x0049:
            int r8 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            char r8 = r2[r8]     // Catch:{ all -> 0x00a2 }
            int r10 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            int r10 = r10 + r3
            com.appsflyer.internal.AFg1vSDK.AFInAppEventType = r10     // Catch:{ all -> 0x00a2 }
            goto L_0x0027
        L_0x0053:
            r9 = r2
        L_0x0054:
            if (r7 <= 0) goto L_0x0063
            char[] r13 = new char[r4]     // Catch:{ all -> 0x00a2 }
            java.lang.System.arraycopy(r9, r1, r13, r1, r4)     // Catch:{ all -> 0x00a2 }
            int r2 = r4 - r7
            java.lang.System.arraycopy(r13, r1, r9, r2, r7)     // Catch:{ all -> 0x00a2 }
            java.lang.System.arraycopy(r13, r7, r9, r1, r2)     // Catch:{ all -> 0x00a2 }
        L_0x0063:
            if (r12 == 0) goto L_0x007f
            char[] r12 = new char[r4]     // Catch:{ all -> 0x00a2 }
            com.appsflyer.internal.AFg1vSDK.AFInAppEventType = r1     // Catch:{ all -> 0x00a2 }
        L_0x0069:
            int r13 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            if (r13 >= r4) goto L_0x007e
            int r13 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            int r2 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            int r2 = r4 - r2
            int r2 = r2 - r3
            char r2 = r9[r2]     // Catch:{ all -> 0x00a2 }
            r12[r13] = r2     // Catch:{ all -> 0x00a2 }
            int r13 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            int r13 = r13 + r3
            com.appsflyer.internal.AFg1vSDK.AFInAppEventType = r13     // Catch:{ all -> 0x00a2 }
            goto L_0x0069
        L_0x007e:
            r9 = r12
        L_0x007f:
            if (r6 <= 0) goto L_0x0099
            com.appsflyer.internal.AFg1vSDK.AFInAppEventType = r1     // Catch:{ all -> 0x00a2 }
        L_0x0083:
            int r12 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            if (r12 >= r4) goto L_0x0099
            int r12 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            int r13 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            char r13 = r9[r13]     // Catch:{ all -> 0x00a2 }
            r2 = r14[r5]     // Catch:{ all -> 0x00a2 }
            int r13 = r13 - r2
            char r13 = (char) r13     // Catch:{ all -> 0x00a2 }
            r9[r12] = r13     // Catch:{ all -> 0x00a2 }
            int r12 = com.appsflyer.internal.AFg1vSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            int r12 = r12 + r3
            com.appsflyer.internal.AFg1vSDK.AFInAppEventType = r12     // Catch:{ all -> 0x00a2 }
            goto L_0x0083
        L_0x0099:
            java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x00a2 }
            r12.<init>(r9)     // Catch:{ all -> 0x00a2 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a2 }
            r15[r1] = r12
            return
        L_0x00a2:
            r12 = move-exception
            monitor-exit(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1kSDK.valueOf(boolean, java.lang.String, int[], java.lang.Object[]):void");
    }
}
