package com.learnium.RNDeviceInfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import io.sentry.protocol.OperatingSystem;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RNInstallReferrerClient {
    /* access modifiers changed from: private */
    public static Class<?> InstallReferrerClientClazz = null;
    private static Class<?> InstallReferrerStateListenerClazz = null;
    private static final int R_RESPONSE_FEATURE_NOT_SUPPORTED = 2;
    private static final int R_RESPONSE_OK = 0;
    private static final int R_RESPONSE_SERVICE_UNAVAILABLE = 1;
    /* access modifiers changed from: private */
    public static Class<?> ReferrerDetailsClazz;
    private Object installReferrerStateListener;
    /* access modifiers changed from: private */
    public Object mReferrerClient;
    /* access modifiers changed from: private */
    public final SharedPreferences sharedPreferences;

    static {
        try {
            InstallReferrerClientClazz = Class.forName("com.android.installreferrer.api.InstallReferrerClient");
            InstallReferrerStateListenerClazz = Class.forName("com.android.installreferrer.api.InstallReferrerStateListener");
            ReferrerDetailsClazz = Class.forName("com.android.installreferrer.api.ReferrerDetails");
        } catch (Exception unused) {
            System.err.println("RNInstallReferrerClient exception. 'installreferrer' APIs are unavailable.");
        }
    }

    RNInstallReferrerClient(Context context) {
        this.sharedPreferences = context.getSharedPreferences("react-native-device-info", 0);
        Class<?> cls = InstallReferrerClientClazz;
        if (cls != null && InstallReferrerStateListenerClazz != null && ReferrerDetailsClazz != null) {
            try {
                Object invoke = cls.getMethod("newBuilder", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
                this.mReferrerClient = invoke.getClass().getMethod(OperatingSystem.JsonKeys.BUILD, new Class[0]).invoke(invoke, new Object[0]);
                this.installReferrerStateListener = Proxy.newProxyInstance(InstallReferrerStateListenerClazz.getClassLoader(), new Class[]{InstallReferrerStateListenerClazz}, new InstallReferrerStateListenerProxy());
                InstallReferrerClientClazz.getMethod("startConnection", new Class[]{InstallReferrerStateListenerClazz}).invoke(this.mReferrerClient, new Object[]{this.installReferrerStateListener});
            } catch (Exception e) {
                System.err.println("RNInstallReferrerClient exception. getInstallReferrer will be unavailable: " + e.getMessage());
                e.printStackTrace(System.err);
            }
        }
    }

    private class InstallReferrerStateListenerProxy implements InvocationHandler {
        private InstallReferrerStateListenerProxy() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            try {
                if (name.equals("onInstallReferrerSetupFinished") && objArr != null) {
                    Integer num = objArr[0];
                    if (num instanceof Integer) {
                        onInstallReferrerSetupFinished(num.intValue());
                        return null;
                    }
                }
                if (!name.equals("onInstallReferrerServiceDisconnected")) {
                    return null;
                }
                onInstallReferrerServiceDisconnected();
                return null;
            } catch (Exception e) {
                throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
            }
        }

        public void onInstallReferrerSetupFinished(int i) {
            if (i == 0) {
                try {
                    Log.d("InstallReferrerState", "OK");
                    Object invoke = RNInstallReferrerClient.InstallReferrerClientClazz.getMethod("getInstallReferrer", new Class[0]).invoke(RNInstallReferrerClient.this.mReferrerClient, new Object[0]);
                    SharedPreferences.Editor edit = RNInstallReferrerClient.this.sharedPreferences.edit();
                    edit.putString("installReferrer", (String) RNInstallReferrerClient.ReferrerDetailsClazz.getMethod("getInstallReferrer", new Class[0]).invoke(invoke, new Object[0]));
                    edit.apply();
                    RNInstallReferrerClient.InstallReferrerClientClazz.getMethod("endConnection", new Class[0]).invoke(RNInstallReferrerClient.this.mReferrerClient, new Object[0]);
                } catch (Exception e) {
                    System.err.println("RNInstallReferrerClient exception. getInstallReferrer will be unavailable: " + e.getMessage());
                    e.printStackTrace(System.err);
                }
            } else if (i == 1) {
                Log.d("InstallReferrerState", "SERVICE_UNAVAILABLE");
            } else if (i == 2) {
                Log.d("InstallReferrerState", "FEATURE_NOT_SUPPORTED");
            }
        }

        public void onInstallReferrerServiceDisconnected() {
            Log.d("RNInstallReferrerClient", "InstallReferrerService disconnected");
        }
    }
}
