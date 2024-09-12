package com.appsflyer.internal;

import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import io.sentry.protocol.App;
import java.util.Map;
import java.util.UUID;

public final class AFe1zSDK extends AFd1iSDK<Map<String, String>> {
    private final boolean AFLogger$LogLevel;
    private String AFVersionDeclaration;
    private final UUID AppsFlyer2dXConversionCallback;
    private final AFc1kSDK afErrorLogForExcManagerOnly;
    public AFa1zSDK afRDLog;
    private String afWarnLog;
    private String getLevel;

    public interface AFa1zSDK {
        void AFInAppEventType(Map<String, String> map);

        void AFKeystoreWrapper(String str);
    }

    public final long AFInAppEventParameterName() {
        return 3000;
    }

    /* access modifiers changed from: protected */
    public final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean afDebugLog() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean afErrorLogForExcManagerOnly() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFe1zSDK(AFc1vSDK aFc1vSDK, UUID uuid, Uri uri) {
        super(AFd1sSDK.ONELINK, new AFd1sSDK[]{AFd1sSDK.RC_CDN}, aFc1vSDK, uuid.toString());
        Throwable cause;
        boolean z = false;
        this.afErrorLogForExcManagerOnly = aFc1vSDK.AFKeystoreWrapper();
        this.AppsFlyer2dXConversionCallback = uuid;
        if (!AFb1pSDK.valueOf(uri.getHost()) && !AFb1pSDK.valueOf(uri.getPath())) {
            try {
                try {
                    Object invoke = ((Class) AFb1kSDK.AFInAppEventType(TextUtils.getCapsMode("", 0, 0) + 37, -1 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((SystemClock.currentThreadTimeMillis() > -1 ? 1 : (SystemClock.currentThreadTimeMillis() == -1 ? 0 : -1)) + 46477))).getMethod("AFInAppEventParameterName", (Class[]) null).invoke(((Class) AFb1kSDK.AFInAppEventType(TextUtils.indexOf("", "", 0, 0) + 37, -1 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (((Process.getThreadPriority(0) + 20) >> 6) + 46478))).getDeclaredConstructor(new Class[]{Uri.class}).newInstance(new Object[]{uri}), (Object[]) null);
                    try {
                        boolean booleanValue = ((Boolean) ((Class) AFb1kSDK.AFInAppEventType((ViewConfiguration.getScrollBarSize() >> 8) + 52, TextUtils.indexOf("", '0', 0) + 38, (char) (-1 - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("AFInAppEventParameterName", (Class[]) null).invoke(invoke, (Object[]) null)).booleanValue();
                        try {
                            z = ((Boolean) ((Class) AFb1kSDK.AFInAppEventType(52 - (ViewConfiguration.getTapTimeout() >> 16), TextUtils.lastIndexOf("", '0', 0, 0) + 38, (char) (TextUtils.indexOf("", '0', 0, 0) + 1))).getMethod("values", (Class[]) null).invoke(invoke, (Object[]) null)).booleanValue();
                            String[] split = uri.getPath().split("/");
                            if (booleanValue && split.length == 3) {
                                this.afWarnLog = split[1];
                                this.AFVersionDeclaration = split[2];
                                this.getLevel = uri.toString();
                            }
                        } catch (Throwable th) {
                            if (cause != null) {
                                throw cause;
                            }
                            throw th;
                        }
                    } finally {
                        cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                    }
                } finally {
                    Throwable cause2 = th.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                }
            } finally {
                Throwable cause3 = th.getCause();
                if (cause3 != null) {
                    throw cause3;
                }
            }
        }
        this.AFLogger$LogLevel = z;
    }

    public final boolean afWarnLog() {
        return !TextUtils.isEmpty(this.afWarnLog) && !TextUtils.isEmpty(this.AFVersionDeclaration) && !this.afWarnLog.equals(App.TYPE);
    }

    public final boolean AFLogger$LogLevel() {
        return this.AFLogger$LogLevel;
    }

    public final void AFKeystoreWrapper() {
        super.AFKeystoreWrapper();
        AFa1zSDK aFa1zSDK = this.afRDLog;
        if (aFa1zSDK == null) {
            return;
        }
        if (this.AFInAppEventType != AFd1tSDK.SUCCESS || this.afInfoLog == null) {
            Throwable afRDLog2 = afRDLog();
            String str = "Can't get OneLink data";
            if (!(afRDLog2 instanceof ParsingException)) {
                String str2 = this.getLevel;
                if (str2 != null) {
                    str = str2;
                }
                aFa1zSDK.AFKeystoreWrapper(str);
            } else if (((ParsingException) afRDLog2).getRawResponse().isSuccessful()) {
                aFa1zSDK.AFKeystoreWrapper("Can't parse one link data");
            } else {
                String str3 = this.getLevel;
                if (str3 != null) {
                    str = str3;
                }
                aFa1zSDK.AFKeystoreWrapper(str);
            }
        } else {
            aFa1zSDK.AFInAppEventType((Map) this.afInfoLog.getBody());
        }
    }

    /* access modifiers changed from: protected */
    public final AFc1mSDK<Map<String, String>> AFInAppEventParameterName(String str) {
        return this.afErrorLogForExcManagerOnly.AFKeystoreWrapper(this.afWarnLog, this.AFVersionDeclaration, this.AppsFlyer2dXConversionCallback, str);
    }
}
