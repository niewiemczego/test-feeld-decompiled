package com.appsflyer.internal;

import android.content.Context;
import android.os.Build;
import android.widget.ExpandableListView;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFc1qSDK;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Typography;
import org.json.JSONObject;

public final class AFc1pSDK implements AFc1nSDK {
    private static int AFVersionDeclaration = 0;
    private static long afInfoLog = -3085294026707372307L;
    private static int getLevel = 1;
    private final Lazy AFInAppEventParameterName = LazyKt.lazy(new Function0<AFc1xSDK>(this) {
        private /* synthetic */ AFc1pSDK values;

        {
            this.values = r1;
        }

        /* renamed from: AFInAppEventParameterName */
        public final AFc1xSDK invoke() {
            AFc1xSDK afErrorLog = AFc1pSDK.valueOf(this.values).afErrorLog();
            Intrinsics.checkNotNullExpressionValue(afErrorLog, "");
            return afErrorLog;
        }
    });
    private final Lazy AFInAppEventType = LazyKt.lazy(new Function0<AFb1bSDK>(this) {
        private /* synthetic */ AFc1pSDK AFKeystoreWrapper;

        {
            this.AFKeystoreWrapper = r1;
        }

        /* renamed from: valueOf */
        public final AFb1bSDK invoke() {
            AFb1bSDK AFInAppEventParameterName = AFc1pSDK.valueOf(this.AFKeystoreWrapper).AFInAppEventParameterName();
            Intrinsics.checkNotNullExpressionValue(AFInAppEventParameterName, "");
            return AFInAppEventParameterName;
        }
    });
    private final Lazy AFKeystoreWrapper = LazyKt.lazy(new Function0<AFb1rSDK>(this) {
        private /* synthetic */ AFc1pSDK AFInAppEventParameterName;

        {
            this.AFInAppEventParameterName = r1;
        }

        /* renamed from: valueOf */
        public final AFb1rSDK invoke() {
            AFb1rSDK afRDLog = AFc1pSDK.valueOf(this.AFInAppEventParameterName).afRDLog();
            Intrinsics.checkNotNullExpressionValue(afRDLog, "");
            return afRDLog;
        }
    });
    private final Lazy AFLogger = LazyKt.lazy(new Function0<AFa1cSDK>(this) {
        private /* synthetic */ AFc1pSDK AFInAppEventParameterName;

        {
            this.AFInAppEventParameterName = r1;
        }

        /* renamed from: AFInAppEventParameterName */
        public final AFa1cSDK invoke() {
            return new AFa1cSDK(this.AFInAppEventParameterName.values());
        }
    });
    private final Lazy afDebugLog = LazyKt.lazy(new Function0<ExecutorService>(this) {
        private /* synthetic */ AFc1pSDK values;

        {
            this.values = r1;
        }

        /* renamed from: AFKeystoreWrapper */
        public final ExecutorService invoke() {
            ExecutorService AFInAppEventType = AFc1pSDK.valueOf(this.values).AFInAppEventType();
            Intrinsics.checkNotNullExpressionValue(AFInAppEventType, "");
            return AFInAppEventType;
        }
    });
    private final String afErrorLog = "6.10.3";
    private final Lazy afRDLog = LazyKt.lazy(new Function0<AFa1bSDK>(this) {
        private /* synthetic */ AFc1pSDK AFInAppEventParameterName;

        {
            this.AFInAppEventParameterName = r1;
        }

        /* renamed from: AFInAppEventType */
        public final AFa1bSDK invoke() {
            AFc1wSDK afErrorLogForExcManagerOnly = AFc1pSDK.valueOf(this.AFInAppEventParameterName).afErrorLogForExcManagerOnly();
            Intrinsics.checkNotNullExpressionValue(afErrorLogForExcManagerOnly, "");
            return new AFa1bSDK(afErrorLogForExcManagerOnly);
        }
    });
    private final Lazy valueOf = LazyKt.lazy(new Function0<AFe1kSDK>(this) {
        private /* synthetic */ AFc1pSDK AFInAppEventType;

        {
            this.AFInAppEventType = r1;
        }

        /* renamed from: valueOf */
        public final AFe1kSDK invoke() {
            AFe1kSDK afWarnLog = AFc1pSDK.valueOf(this.AFInAppEventType).afWarnLog();
            Intrinsics.checkNotNullExpressionValue(afWarnLog, "");
            return afWarnLog;
        }
    });
    private AFc1vSDK values;

    public AFc1pSDK(AFc1vSDK aFc1vSDK) {
        Intrinsics.checkNotNullParameter(aFc1vSDK, "");
        this.values = aFc1vSDK;
    }

    public static final /* synthetic */ AFc1vSDK valueOf(AFc1pSDK aFc1pSDK) {
        int i = getLevel + 77;
        AFVersionDeclaration = i % 128;
        char c = i % 2 != 0 ? 18 : '?';
        AFc1vSDK aFc1vSDK = aFc1pSDK.values;
        if (c == 18) {
            int i2 = 19 / 0;
        }
        return aFc1vSDK;
    }

    private final AFb1rSDK AFInAppEventParameterName() {
        int i = AFVersionDeclaration + 1;
        getLevel = i % 128;
        int i2 = i % 2;
        AFb1rSDK aFb1rSDK = (AFb1rSDK) this.AFKeystoreWrapper.getValue();
        int i3 = AFVersionDeclaration + 93;
        getLevel = i3 % 128;
        int i4 = i3 % 2;
        return aFb1rSDK;
    }

    private final AFb1bSDK afErrorLog() {
        int i = AFVersionDeclaration + 115;
        getLevel = i % 128;
        int i2 = i % 2;
        AFb1bSDK aFb1bSDK = (AFb1bSDK) this.AFInAppEventType.getValue();
        int i3 = AFVersionDeclaration + 9;
        getLevel = i3 % 128;
        if ((i3 % 2 == 0 ? Typography.greater : '!') == '!') {
            return aFb1bSDK;
        }
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    private final AFc1xSDK afRDLog() {
        int i = AFVersionDeclaration + 67;
        getLevel = i % 128;
        if ((i % 2 == 0 ? 'U' : Typography.greater) != 'U') {
            return (AFc1xSDK) this.AFInAppEventParameterName.getValue();
        }
        AFc1xSDK aFc1xSDK = (AFc1xSDK) this.AFInAppEventParameterName.getValue();
        throw null;
    }

    private final AFe1kSDK afDebugLog() {
        int i = AFVersionDeclaration + 67;
        getLevel = i % 128;
        if ((i % 2 == 0 ? (char) 14 : 17) == 17) {
            AFe1kSDK aFe1kSDK = (AFe1kSDK) this.valueOf.getValue();
            int i2 = AFVersionDeclaration + 9;
            getLevel = i2 % 128;
            int i3 = i2 % 2;
            return aFe1kSDK;
        }
        AFe1kSDK aFe1kSDK2 = (AFe1kSDK) this.valueOf.getValue();
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    private final ExecutorService afInfoLog() {
        int i = AFVersionDeclaration + 109;
        getLevel = i % 128;
        if (!(i % 2 == 0)) {
            return (ExecutorService) this.afDebugLog.getValue();
        }
        ExecutorService executorService = (ExecutorService) this.afDebugLog.getValue();
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    private String AFLogger() {
        int i = getLevel;
        int i2 = i + 59;
        AFVersionDeclaration = i2 % 128;
        int i3 = i2 % 2;
        String str = this.afErrorLog;
        int i4 = i + 43;
        AFVersionDeclaration = i4 % 128;
        if ((i4 % 2 != 0 ? ',' : Typography.greater) != ',') {
            return str;
        }
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    private final AFb1nSDK AFVersionDeclaration() {
        AFb1lSDK aFb1lSDK = AFInAppEventParameterName().AFKeystoreWrapper.values;
        boolean z = false;
        if (aFb1lSDK != null) {
            int i = AFVersionDeclaration + 73;
            getLevel = i % 128;
            int i2 = i % 2;
            AFb1pSDK aFb1pSDK = aFb1lSDK.AFInAppEventParameterName;
            if (aFb1pSDK == null) {
                z = true;
            }
            if (!z) {
                int i3 = getLevel + 77;
                AFVersionDeclaration = i3 % 128;
                int i4 = i3 % 2;
                return aFb1pSDK.values;
            }
        }
        int i5 = getLevel + 87;
        AFVersionDeclaration = i5 % 128;
        int i6 = i5 % 2;
        return null;
    }

    public final AFc1tSDK values() {
        int i = AFVersionDeclaration + 79;
        getLevel = i % 128;
        int i2 = i % 2;
        AFc1tSDK aFc1tSDK = (AFc1tSDK) this.afRDLog.getValue();
        int i3 = getLevel + 121;
        AFVersionDeclaration = i3 % 128;
        int i4 = i3 % 2;
        return aFc1tSDK;
    }

    private AFc1qSDK getLevel() {
        int i = getLevel + 95;
        AFVersionDeclaration = i % 128;
        if (i % 2 == 0) {
            return (AFc1qSDK) this.AFLogger.getValue();
        }
        AFc1qSDK aFc1qSDK = (AFc1qSDK) this.AFLogger.getValue();
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    public final void values(Throwable th, String str) {
        int i = getLevel + 21;
        AFVersionDeclaration = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(str, "");
        afInfoLog().execute(new AFc1pSDK$$ExternalSyntheticLambda3(this, th, str));
        int i3 = AFVersionDeclaration + 23;
        getLevel = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Throwable th2 = null;
            super.hashCode();
            throw th2;
        }
    }

    /* access modifiers changed from: private */
    public static final void AFKeystoreWrapper(AFc1pSDK aFc1pSDK, Throwable th, String str) {
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(str, "");
        AFb1nSDK AFVersionDeclaration2 = aFc1pSDK.AFVersionDeclaration();
        boolean z = false;
        if (!(AFVersionDeclaration2 == null)) {
            int i = getLevel + 45;
            AFVersionDeclaration = i % 128;
            int i2 = i % 2;
            if (aFc1pSDK.AFKeystoreWrapper(AFVersionDeclaration2)) {
                int i3 = AFVersionDeclaration + 117;
                getLevel = i3 % 128;
                int i4 = i3 % 2;
                z = true;
            } else {
                int i5 = AFVersionDeclaration + 87;
                getLevel = i5 % 128;
                int i6 = i5 % 2;
            }
        }
        if (z) {
            int i7 = getLevel + 1;
            AFVersionDeclaration = i7 % 128;
            int i8 = i7 % 2;
            aFc1pSDK.values().AFInAppEventParameterName(th, str);
        }
    }

    public final void AFKeystoreWrapper() {
        int i = getLevel + 123;
        AFVersionDeclaration = i % 128;
        int i2 = i % 2;
        afInfoLog().execute(new AFc1pSDK$$ExternalSyntheticLambda2(this));
        int i3 = AFVersionDeclaration + 91;
        getLevel = i3 % 128;
        int i4 = i3 % 2;
    }

    /* access modifiers changed from: private */
    public static final void AFKeystoreWrapper(AFc1pSDK aFc1pSDK) {
        int i = AFVersionDeclaration + 67;
        getLevel = i % 128;
        if ((i % 2 == 0 ? ';' : '\'') == '\'') {
            Intrinsics.checkNotNullParameter(aFc1pSDK, "");
            aFc1pSDK.afWarnLog();
            int i2 = getLevel + 101;
            AFVersionDeclaration = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        aFc1pSDK.afWarnLog();
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    public final void AFInAppEventType() {
        int i = AFVersionDeclaration + 9;
        getLevel = i % 128;
        if ((i % 2 == 0 ? 'G' : 'M') != 'G') {
            afInfoLog().execute(new AFc1pSDK$$ExternalSyntheticLambda1(this));
            return;
        }
        afInfoLog().execute(new AFc1pSDK$$ExternalSyntheticLambda1(this));
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    /* access modifiers changed from: private */
    public static final void AFInAppEventType(AFc1pSDK aFc1pSDK) {
        int i = AFVersionDeclaration + 63;
        getLevel = i % 128;
        if ((i % 2 == 0 ? 11 : ',') != 11) {
            Intrinsics.checkNotNullParameter(aFc1pSDK, "");
            aFc1pSDK.AFLogger$LogLevel();
            return;
        }
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        aFc1pSDK.AFLogger$LogLevel();
        throw null;
    }

    public final void valueOf() {
        int i = getLevel + 11;
        AFVersionDeclaration = i % 128;
        Throwable th = null;
        if (!(i % 2 != 0)) {
            afInfoLog().execute(new AFc1pSDK$$ExternalSyntheticLambda0(this));
            int i2 = getLevel + 107;
            AFVersionDeclaration = i2 % 128;
            if ((i2 % 2 != 0 ? '\\' : '-') == '\\') {
                super.hashCode();
                throw th;
            }
            return;
        }
        afInfoLog().execute(new AFc1pSDK$$ExternalSyntheticLambda0(this));
        super.hashCode();
        throw th;
    }

    /* access modifiers changed from: private */
    public static final void AFInAppEventParameterName(AFc1pSDK aFc1pSDK) {
        int i = getLevel + 123;
        AFVersionDeclaration = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        aFc1pSDK.afErrorLogForExcManagerOnly();
        int i3 = getLevel + 61;
        AFVersionDeclaration = i3 % 128;
        if ((i3 % 2 != 0 ? 'D' : '.') == 'D') {
            Throwable th = null;
            super.hashCode();
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.Throwable} */
    /* JADX WARNING: type inference failed for: r4v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v6, types: [java.lang.String] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void afWarnLog() {
        /*
            r11 = this;
            monitor-enter(r11)
            com.appsflyer.internal.AFb1nSDK r0 = r11.AFVersionDeclaration()     // Catch:{ all -> 0x00e7 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000b
            r3 = r2
            goto L_0x000c
        L_0x000b:
            r3 = r1
        L_0x000c:
            r4 = 0
            if (r3 == r2) goto L_0x0012
            r5 = -1
            goto L_0x0028
        L_0x0012:
            int r3 = AFVersionDeclaration     // Catch:{ all -> 0x00e7 }
            int r3 = r3 + 97
            int r5 = r3 % 128
            getLevel = r5     // Catch:{ all -> 0x00e7 }
            int r3 = r3 % 2
            r5 = 73
            if (r3 != 0) goto L_0x0022
            r3 = r5
            goto L_0x0024
        L_0x0022:
            r3 = 81
        L_0x0024:
            if (r3 == r5) goto L_0x00df
            long r5 = r0.AFInAppEventParameterName     // Catch:{ all -> 0x00e7 }
        L_0x0028:
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00e7 }
            r9 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 / r9
            com.appsflyer.internal.AFb1nSDK r0 = r11.AFVersionDeclaration()     // Catch:{ NullPointerException -> 0x005d }
            if (r0 == 0) goto L_0x004e
            int r3 = getLevel     // Catch:{ all -> 0x00e7 }
            int r3 = r3 + 51
            int r9 = r3 % 128
            AFVersionDeclaration = r9     // Catch:{ all -> 0x00e7 }
            int r3 = r3 % 2
            if (r3 == 0) goto L_0x0043
            r3 = r2
            goto L_0x0044
        L_0x0043:
            r3 = r1
        L_0x0044:
            if (r3 != 0) goto L_0x0049
            java.lang.String r4 = r0.values     // Catch:{ NullPointerException -> 0x005d }
            goto L_0x004e
        L_0x0049:
            java.lang.String r0 = r0.values     // Catch:{ NullPointerException -> 0x005d }
            throw r4     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00e7 }
        L_0x004e:
            if (r4 != 0) goto L_0x0052
            java.lang.String r4 = ""
        L_0x0052:
            int r0 = AFVersionDeclaration     // Catch:{ all -> 0x00e7 }
            int r0 = r0 + 7
            int r3 = r0 % 128
            getLevel = r3     // Catch:{ all -> 0x00e7 }
            int r0 = r0 % 2
            goto L_0x005f
        L_0x005d:
            java.lang.String r4 = "NOT_DETECTED"
        L_0x005f:
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0065
            r0 = r2
            goto L_0x0066
        L_0x0065:
            r0 = r1
        L_0x0066:
            if (r0 == 0) goto L_0x0094
            java.lang.String r0 = "TTL is already passed"
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)     // Catch:{ all -> 0x00e7 }
            java.lang.String r1 = "[Exception Manager]: "
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x00e7 }
            com.appsflyer.AFLogger.afRDLog(r0)     // Catch:{ all -> 0x00e7 }
            com.appsflyer.internal.AFc1xSDK r0 = r11.afRDLog()     // Catch:{ all -> 0x00e7 }
            java.lang.String r1 = "af_send_exc_to_server_window"
            r0.valueOf(r1)     // Catch:{ all -> 0x00e7 }
            com.appsflyer.internal.AFc1tSDK r0 = r11.values()     // Catch:{ all -> 0x00e7 }
            r0.AFInAppEventParameterName()     // Catch:{ all -> 0x00e7 }
            int r0 = getLevel     // Catch:{ all -> 0x00e7 }
            int r0 = r0 + 69
            int r1 = r0 % 128
            AFVersionDeclaration = r1     // Catch:{ all -> 0x00e7 }
            int r0 = r0 % 2
            monitor-exit(r11)
            return
        L_0x0094:
            int r0 = com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFInAppEventType(r4)     // Catch:{ all -> 0x00e7 }
            r3 = -1
            r5 = 21
            if (r0 == r3) goto L_0x009f
            r0 = r5
            goto L_0x00a1
        L_0x009f:
            r0 = 64
        L_0x00a1:
            if (r0 == r5) goto L_0x00a4
            goto L_0x00cd
        L_0x00a4:
            int r0 = getLevel     // Catch:{ all -> 0x00e7 }
            int r0 = r0 + 77
            int r3 = r0 % 128
            AFVersionDeclaration = r3     // Catch:{ all -> 0x00e7 }
            int r0 = r0 % 2
            int r0 = com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFInAppEventType(r4)     // Catch:{ all -> 0x00e7 }
            java.lang.String r3 = r11.AFLogger()     // Catch:{ all -> 0x00e7 }
            int r3 = com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFInAppEventType(r3)     // Catch:{ all -> 0x00e7 }
            if (r0 > r3) goto L_0x00cd
            com.appsflyer.internal.AFc1tSDK r0 = r11.values()     // Catch:{ all -> 0x00e7 }
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ all -> 0x00e7 }
            java.lang.String r3 = r11.AFLogger()     // Catch:{ all -> 0x00e7 }
            r2[r1] = r3     // Catch:{ all -> 0x00e7 }
            r0.values(r2)     // Catch:{ all -> 0x00e7 }
            monitor-exit(r11)
            return
        L_0x00cd:
            com.appsflyer.internal.AFc1xSDK r0 = r11.afRDLog()     // Catch:{ all -> 0x00e7 }
            java.lang.String r1 = "af_send_exc_to_server_window"
            r0.valueOf(r1)     // Catch:{ all -> 0x00e7 }
            com.appsflyer.internal.AFc1tSDK r0 = r11.values()     // Catch:{ all -> 0x00e7 }
            r0.AFInAppEventParameterName()     // Catch:{ all -> 0x00e7 }
            monitor-exit(r11)
            return
        L_0x00df:
            long r0 = r0.AFInAppEventParameterName     // Catch:{ all -> 0x00e7 }
            super.hashCode()     // Catch:{ all -> 0x00e5 }
            throw r4     // Catch:{ all -> 0x00e5 }
        L_0x00e5:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00e7 }
        L_0x00e7:
            r0 = move-exception
            monitor-exit(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1pSDK.afWarnLog():void");
    }

    private final void AFLogger$LogLevel() {
        int i = getLevel + 119;
        AFVersionDeclaration = i % 128;
        int i2 = i % 2;
        AFb1nSDK AFVersionDeclaration2 = AFVersionDeclaration();
        if (!(AFVersionDeclaration2 == null)) {
            int i3 = getLevel + 93;
            AFVersionDeclaration = i3 % 128;
            int i4 = i3 % 2;
            if ((values(AFVersionDeclaration2) ? 'I' : 7) != 7) {
                String str = afDebugLog().AFInAppEventType;
                if (str != null) {
                    String jSONObject = new JSONObject((Map<?, ?>) AFKeystoreWrapper((Map<String, ? extends Object>) valueOf(AFVersionDeclaration2), values().valueOf())).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "");
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    AFKeystoreWrapper(jSONObject, str);
                    return;
                }
                return;
            }
            Intrinsics.checkNotNullParameter("skipping", "");
            AFLogger.afRDLog("[Exception Manager]: ".concat("skipping"));
        }
    }

    private final synchronized void afErrorLogForExcManagerOnly() {
        int i = AFVersionDeclaration + 57;
        getLevel = i % 128;
        if (i % 2 != 0) {
            AFb1nSDK AFVersionDeclaration2 = AFVersionDeclaration();
            if (!(AFVersionDeclaration2 == null)) {
                if (AFVersionDeclaration2.AFKeystoreWrapper == -1) {
                    int i2 = getLevel + 113;
                    AFVersionDeclaration = i2 % 128;
                    if ((i2 % 2 != 0 ? 'S' : ',') != 'S') {
                        afRDLog().valueOf("af_send_exc_to_server_window");
                        return;
                    }
                    afRDLog().valueOf("af_send_exc_to_server_window");
                    int i3 = 83 / 0;
                    return;
                }
                if ((afRDLog().AFKeystoreWrapper("af_send_exc_to_server_window", -1) == -1 ? '0' : 30) == '0') {
                    int i4 = AFVersionDeclaration2.valueOf;
                    int i5 = AFVersionDeclaration2.AFKeystoreWrapper;
                    AFc1xSDK afRDLog2 = afRDLog();
                    afRDLog2.AFInAppEventType("af_send_exc_to_server_window", System.currentTimeMillis() + TimeUnit.DAYS.toMillis((long) i5));
                    afRDLog2.valueOf("af_send_exc_min", i4);
                }
                int i6 = AFVersionDeclaration + 79;
                getLevel = i6 % 128;
                if (i6 % 2 == 0) {
                    int i7 = 22 / 0;
                    return;
                }
                return;
            }
            return;
        }
        AFVersionDeclaration();
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    private final Map<String, String> valueOf(AFb1nSDK aFb1nSDK) {
        Object[] objArr = new Object[1];
        AFInAppEventType("㭌洪鿺쇅", (ExpandableListView.getPackedPositionForGroup(0) > 0 ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0 ? 0 : -1)) + 52691, objArr);
        Map<String, String> mapOf = MapsKt.mapOf(TuplesKt.to(((String) objArr[0]).intern(), Build.BRAND), TuplesKt.to("model", Build.MODEL), TuplesKt.to("app_id", afErrorLog().values.AFKeystoreWrapper.getPackageName()), TuplesKt.to("p_ex", new AFb1uSDK().AFKeystoreWrapper()), TuplesKt.to("api", String.valueOf(Build.VERSION.SDK_INT)), TuplesKt.to("sdk", AFLogger()), TuplesKt.to("uid", AFb1wSDK.AFInAppEventParameterName((WeakReference<Context>) new WeakReference(afErrorLog().values.AFKeystoreWrapper))), TuplesKt.to("exc_config", aFb1nSDK.values()));
        int i = getLevel + 63;
        AFVersionDeclaration = i % 128;
        int i2 = i % 2;
        return mapOf;
    }

    private static Map<String, Object> AFKeystoreWrapper(Map<String, ? extends Object> map, List<AFc1sSDK> list) {
        int i = getLevel + 125;
        AFVersionDeclaration = i % 128;
        int i2 = i % 2;
        Map<String, Object> mapOf = MapsKt.mapOf(TuplesKt.to("deviceInfo", map), TuplesKt.to("excs", AFc1qSDK.AFa1vSDK.valueOf(list)));
        int i3 = AFVersionDeclaration + 91;
        getLevel = i3 % 128;
        if ((i3 % 2 == 0 ? 'L' : 25) == 25) {
            return mapOf;
        }
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    private final boolean values(AFb1nSDK aFb1nSDK) {
        long currentTimeMillis = System.currentTimeMillis();
        long AFKeystoreWrapper2 = afRDLog().AFKeystoreWrapper("af_send_exc_to_server_window", -1);
        Throwable th = null;
        if (aFb1nSDK.AFInAppEventParameterName < currentTimeMillis / 1000) {
            int i = AFVersionDeclaration + 77;
            getLevel = i % 128;
            if (i % 2 != 0) {
                return false;
            }
            super.hashCode();
            throw th;
        }
        if ((AFKeystoreWrapper2 != -1 ? ':' : 27) != 27 && AFKeystoreWrapper2 >= currentTimeMillis) {
            int AFKeystoreWrapper3 = afRDLog().AFKeystoreWrapper("af_send_exc_min", -1);
            if ((AFKeystoreWrapper3 != -1 ? 'Q' : 'c') != 'c') {
                int i2 = getLevel + 113;
                AFVersionDeclaration = i2 % 128;
                if ((i2 % 2 != 0 ? 18 : '[') == 18) {
                    values().AFKeystoreWrapper();
                    super.hashCode();
                    throw th;
                } else if (values().AFKeystoreWrapper() >= AFKeystoreWrapper3) {
                    String str = aFb1nSDK.values;
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    if (AFc1qSDK.AFa1vSDK.AFInAppEventType(str) != AFc1qSDK.AFa1vSDK.AFInAppEventType(AFLogger())) {
                        return false;
                    }
                    int i3 = AFVersionDeclaration + 9;
                    getLevel = i3 % 128;
                    int i4 = i3 % 2;
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean AFKeystoreWrapper(AFb1nSDK aFb1nSDK) {
        long currentTimeMillis = System.currentTimeMillis();
        long AFKeystoreWrapper2 = afRDLog().AFKeystoreWrapper("af_send_exc_to_server_window", -1);
        if (aFb1nSDK.AFInAppEventParameterName >= currentTimeMillis / 1000 && AFKeystoreWrapper2 != -1) {
            int i = AFVersionDeclaration + 73;
            getLevel = i % 128;
            int i2 = i % 2;
            if (AFKeystoreWrapper2 >= currentTimeMillis) {
                String str = aFb1nSDK.values;
                Intrinsics.checkNotNullExpressionValue(str, "");
                if ((AFc1qSDK.AFa1vSDK.AFInAppEventType(str) == AFc1qSDK.AFa1vSDK.AFInAppEventType(AFLogger()) ? 27 : '-') == 27) {
                    int i3 = getLevel + 15;
                    AFVersionDeclaration = i3 % 128;
                    if (i3 % 2 != 0) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private final void AFKeystoreWrapper(String str, String str2) {
        int i = getLevel + 43;
        AFVersionDeclaration = i % 128;
        int i2 = i % 2;
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        getLevel().AFKeystoreWrapper(bytes, MapsKt.mapOf(TuplesKt.to("Authorization", AFb1ySDK.values(str, str2))), 2000);
        int i3 = getLevel + 63;
        AFVersionDeclaration = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void AFInAppEventType(java.lang.String r7, int r8, java.lang.Object[] r9) {
        /*
            if (r7 == 0) goto L_0x0006
            char[] r7 = r7.toCharArray()
        L_0x0006:
            char[] r7 = (char[]) r7
            java.lang.Object r0 = com.appsflyer.internal.AFg1tSDK.values
            monitor-enter(r0)
            com.appsflyer.internal.AFg1tSDK.valueOf = r8     // Catch:{ all -> 0x003c }
            int r8 = r7.length     // Catch:{ all -> 0x003c }
            char[] r8 = new char[r8]     // Catch:{ all -> 0x003c }
            r1 = 0
            com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper = r1     // Catch:{ all -> 0x003c }
        L_0x0013:
            int r2 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper     // Catch:{ all -> 0x003c }
            int r3 = r7.length     // Catch:{ all -> 0x003c }
            if (r2 >= r3) goto L_0x0033
            int r2 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper     // Catch:{ all -> 0x003c }
            int r3 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper     // Catch:{ all -> 0x003c }
            char r3 = r7[r3]     // Catch:{ all -> 0x003c }
            int r4 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper     // Catch:{ all -> 0x003c }
            int r5 = com.appsflyer.internal.AFg1tSDK.valueOf     // Catch:{ all -> 0x003c }
            int r4 = r4 * r5
            r3 = r3 ^ r4
            long r3 = (long) r3     // Catch:{ all -> 0x003c }
            long r5 = afInfoLog     // Catch:{ all -> 0x003c }
            long r3 = r3 ^ r5
            int r3 = (int) r3     // Catch:{ all -> 0x003c }
            char r3 = (char) r3     // Catch:{ all -> 0x003c }
            r8[r2] = r3     // Catch:{ all -> 0x003c }
            int r2 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper     // Catch:{ all -> 0x003c }
            int r2 = r2 + 1
            com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper = r2     // Catch:{ all -> 0x003c }
            goto L_0x0013
        L_0x0033:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x003c }
            r7.<init>(r8)     // Catch:{ all -> 0x003c }
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            r9[r1] = r7
            return
        L_0x003c:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1pSDK.AFInAppEventType(java.lang.String, int, java.lang.Object[]):void");
    }
}
