package com.appsflyer.internal;

import android.content.Context;
import com.amplitude.reactnative.DatabaseConstants;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFf1jSDK;
import com.miui.referrer.api.GetAppsReferrerClient;
import com.miui.referrer.api.GetAppsReferrerDetails;
import com.miui.referrer.api.GetAppsReferrerStateListener;
import io.sentry.protocol.Response;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public final class AFf1hSDK extends AFf1pSDK {
    public AFf1hSDK(Runnable runnable) {
        super(DatabaseConstants.STORE_TABLE_NAME, "xiaomi", runnable);
    }

    private static boolean AFInAppEventType(Context context) {
        if (!AFKeystoreWrapper(context)) {
            return false;
        }
        try {
            Class.forName("com.miui.referrer.api.GetAppsReferrerClient");
            AFLogger.afDebugLog("Xiaomi Install Referrer is allowed");
            return true;
        } catch (ClassNotFoundException unused) {
            AFLogger.afRDLog(new StringBuilder("Class ").append("com.miui.referrer.api.GetAppsReferrerClient").append(" not found").toString());
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to access GetAppsReferrerClient", th);
            return false;
        }
    }

    public final void values(final Context context) {
        if (AFInAppEventType(context)) {
            this.AFLogger = System.currentTimeMillis();
            this.AFKeystoreWrapper = AFf1jSDK.AFa1wSDK.STARTED;
            addObserver(new Observer() {
                public final void update(Observable observable, Object obj) {
                    AFf1jSDK.this.values.run();
                }
            });
            final GetAppsReferrerClient build = GetAppsReferrerClient.Companion.newBuilder(context).build();
            build.startConnection(new GetAppsReferrerStateListener() {
                public final void onGetAppsServiceDisconnected() {
                }

                public final void onGetAppsReferrerSetupFinished(int i) {
                    AFf1hSDK.this.AFInAppEventType.put("api_ver", Long.valueOf(AFa1cSDK.values(context, "com.xiaomi.mipicks")));
                    AFf1hSDK.this.AFInAppEventType.put("api_ver_name", AFa1cSDK.AFInAppEventParameterName(context, "com.xiaomi.mipicks"));
                    if (i == -1) {
                        AFLogger.afWarnLog("XiaomiInstallReferrer SERVICE_DISCONNECTED");
                        AFf1hSDK.this.AFInAppEventType.put(Response.TYPE, "SERVICE_DISCONNECTED");
                    } else if (i == 0) {
                        AFf1hSDK aFf1hSDK = AFf1hSDK.this;
                        GetAppsReferrerClient getAppsReferrerClient = build;
                        aFf1hSDK.AFInAppEventType.put(Response.TYPE, "OK");
                        try {
                            AFLogger.afDebugLog("XiaomiInstallReferrer connected");
                            if (getAppsReferrerClient.isReady()) {
                                GetAppsReferrerDetails installReferrer = getAppsReferrerClient.getInstallReferrer();
                                String installReferrer2 = installReferrer.getInstallReferrer();
                                if (installReferrer2 != null) {
                                    aFf1hSDK.AFInAppEventType.put("referrer", installReferrer2);
                                }
                                aFf1hSDK.AFInAppEventType.put("click_ts", Long.valueOf(installReferrer.getReferrerClickTimestampSeconds()));
                                aFf1hSDK.AFInAppEventType.put("install_begin_ts", Long.valueOf(installReferrer.getInstallBeginTimestampSeconds()));
                                HashMap hashMap = new HashMap();
                                hashMap.put("click_server_ts", Long.valueOf(installReferrer.getReferrerClickTimestampServerSeconds()));
                                hashMap.put("install_begin_server_ts", Long.valueOf(installReferrer.getInstallBeginTimestampServerSeconds()));
                                hashMap.put("install_version", installReferrer.getInstallVersion());
                                aFf1hSDK.AFInAppEventType.put("xiaomi_custom", hashMap);
                            } else {
                                AFLogger.afWarnLog("XiaomiReferrerClient: XiaomiInstallReferrer is not ready");
                            }
                        } catch (Throwable th) {
                            AFLogger.afWarnLog(new StringBuilder("Failed to get Xiaomi install referrer: ").append(th.getMessage()).toString());
                        }
                    } else if (i == 1) {
                        AFf1hSDK.this.AFInAppEventType.put(Response.TYPE, "SERVICE_UNAVAILABLE");
                        AFLogger.afWarnLog("XiaomiInstallReferrer not supported");
                    } else if (i == 2) {
                        AFLogger.afWarnLog("XiaomiInstallReferrer FEATURE_NOT_SUPPORTED");
                        AFf1hSDK.this.AFInAppEventType.put(Response.TYPE, "FEATURE_NOT_SUPPORTED");
                    } else if (i == 3) {
                        AFLogger.afWarnLog("XiaomiInstallReferrer DEVELOPER_ERROR");
                        AFf1hSDK.this.AFInAppEventType.put(Response.TYPE, "DEVELOPER_ERROR");
                    } else if (i != 4) {
                        AFLogger.afWarnLog("responseCode not found.");
                    } else {
                        AFLogger.afWarnLog("XiaomiInstallReferrer DEVELOPER_ERROR");
                        AFf1hSDK.this.AFInAppEventType.put(Response.TYPE, "PERMISSION_ERROR");
                    }
                    AFLogger.afDebugLog("Xiaomi Install Referrer collected locally");
                    AFf1hSDK.this.values();
                    build.endConnection();
                }
            });
        }
    }
}
