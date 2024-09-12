package com.facebook.appevents.ondeviceprocessing;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.FacebookSignatureValidator;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.ppml.receiver.IReceiverService;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u001a\u001b\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007J&\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper;", "", "()V", "RECEIVER_SERVICE_ACTION", "", "RECEIVER_SERVICE_PACKAGE", "RECEIVER_SERVICE_PACKAGE_WAKIZASHI", "TAG", "kotlin.jvm.PlatformType", "isServiceAvailable", "", "Ljava/lang/Boolean;", "getVerifiedServiceIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "sendCustomEvents", "Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$ServiceResult;", "applicationId", "appEvents", "", "Lcom/facebook/appevents/AppEvent;", "sendEvents", "eventType", "Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$EventType;", "sendInstallEvent", "EventType", "RemoteServiceConnection", "ServiceResult", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: RemoteServiceWrapper.kt */
public final class RemoteServiceWrapper {
    public static final RemoteServiceWrapper INSTANCE = new RemoteServiceWrapper();
    public static final String RECEIVER_SERVICE_ACTION = "ReceiverService";
    public static final String RECEIVER_SERVICE_PACKAGE = "com.facebook.katana";
    public static final String RECEIVER_SERVICE_PACKAGE_WAKIZASHI = "com.facebook.wakizashi";
    private static final String TAG = "RemoteServiceWrapper";
    private static Boolean isServiceAvailable;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$ServiceResult;", "", "(Ljava/lang/String;I)V", "OPERATION_SUCCESS", "SERVICE_NOT_AVAILABLE", "SERVICE_ERROR", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: RemoteServiceWrapper.kt */
    public enum ServiceResult {
        OPERATION_SUCCESS,
        SERVICE_NOT_AVAILABLE,
        SERVICE_ERROR
    }

    private RemoteServiceWrapper() {
    }

    @JvmStatic
    public static final boolean isServiceAvailable() {
        Class<RemoteServiceWrapper> cls = RemoteServiceWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            if (isServiceAvailable == null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                isServiceAvailable = Boolean.valueOf(INSTANCE.getVerifiedServiceIntent(FacebookSdk.getApplicationContext()) != null);
            }
            Boolean bool = isServiceAvailable;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    @JvmStatic
    public static final ServiceResult sendInstallEvent(String str) {
        Class<RemoteServiceWrapper> cls = RemoteServiceWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "applicationId");
            return INSTANCE.sendEvents(EventType.MOBILE_APP_INSTALL, str, CollectionsKt.emptyList());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final ServiceResult sendCustomEvents(String str, List<AppEvent> list) {
        Class<RemoteServiceWrapper> cls = RemoteServiceWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "applicationId");
            Intrinsics.checkNotNullParameter(list, "appEvents");
            return INSTANCE.sendEvents(EventType.CUSTOM_APP_EVENTS, str, list);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private final ServiceResult sendEvents(EventType eventType, String str, List<AppEvent> list) {
        Context applicationContext;
        RemoteServiceConnection remoteServiceConnection;
        String str2;
        ServiceResult serviceResult;
        ServiceResult serviceResult2;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ServiceResult serviceResult3 = ServiceResult.SERVICE_NOT_AVAILABLE;
            AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
            AppEventUtility.assertIsNotMainThread();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            applicationContext = FacebookSdk.getApplicationContext();
            Intent verifiedServiceIntent = getVerifiedServiceIntent(applicationContext);
            if (verifiedServiceIntent == null) {
                return serviceResult3;
            }
            remoteServiceConnection = new RemoteServiceConnection();
            if (!applicationContext.bindService(verifiedServiceIntent, remoteServiceConnection, 1)) {
                return ServiceResult.SERVICE_ERROR;
            }
            try {
                IBinder binder = remoteServiceConnection.getBinder();
                if (binder != null) {
                    IReceiverService asInterface = IReceiverService.Stub.asInterface(binder);
                    RemoteServiceParametersHelper remoteServiceParametersHelper = RemoteServiceParametersHelper.INSTANCE;
                    Bundle buildEventsBundle = RemoteServiceParametersHelper.buildEventsBundle(eventType, str, list);
                    if (buildEventsBundle != null) {
                        asInterface.sendEvents(buildEventsBundle);
                        Utility utility = Utility.INSTANCE;
                        Utility.logd(TAG, Intrinsics.stringPlus("Successfully sent events to the remote service: ", buildEventsBundle));
                    }
                    serviceResult2 = ServiceResult.OPERATION_SUCCESS;
                } else {
                    serviceResult2 = ServiceResult.SERVICE_NOT_AVAILABLE;
                }
                applicationContext.unbindService(remoteServiceConnection);
                Utility utility2 = Utility.INSTANCE;
                Utility.logd(TAG, "Unbound from the remote service");
                return serviceResult2;
            } catch (InterruptedException e) {
                serviceResult = ServiceResult.SERVICE_ERROR;
                Utility utility3 = Utility.INSTANCE;
                str2 = TAG;
                Utility.logd(str2, (Exception) e);
                applicationContext.unbindService(remoteServiceConnection);
                Utility utility4 = Utility.INSTANCE;
                Utility.logd(str2, "Unbound from the remote service");
                return serviceResult;
            } catch (RemoteException e2) {
                serviceResult = ServiceResult.SERVICE_ERROR;
                Utility utility5 = Utility.INSTANCE;
                str2 = TAG;
                Utility.logd(str2, (Exception) e2);
                applicationContext.unbindService(remoteServiceConnection);
                Utility utility6 = Utility.INSTANCE;
                Utility.logd(str2, "Unbound from the remote service");
                return serviceResult;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Intent getVerifiedServiceIntent(Context context) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                Intent intent = new Intent(RECEIVER_SERVICE_ACTION);
                intent.setPackage("com.facebook.katana");
                if (packageManager.resolveService(intent, 0) != null) {
                    FacebookSignatureValidator facebookSignatureValidator = FacebookSignatureValidator.INSTANCE;
                    if (FacebookSignatureValidator.validateSignature(context, "com.facebook.katana")) {
                        return intent;
                    }
                }
                Intent intent2 = new Intent(RECEIVER_SERVICE_ACTION);
                intent2.setPackage(RECEIVER_SERVICE_PACKAGE_WAKIZASHI);
                if (packageManager.resolveService(intent2, 0) != null) {
                    FacebookSignatureValidator facebookSignatureValidator2 = FacebookSignatureValidator.INSTANCE;
                    if (FacebookSignatureValidator.validateSignature(context, RECEIVER_SERVICE_PACKAGE_WAKIZASHI)) {
                        return intent2;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$EventType;", "", "eventType", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "MOBILE_APP_INSTALL", "CUSTOM_APP_EVENTS", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: RemoteServiceWrapper.kt */
    public enum EventType {
        MOBILE_APP_INSTALL("MOBILE_APP_INSTALL"),
        CUSTOM_APP_EVENTS("CUSTOM_APP_EVENTS");
        
        private final String eventType;

        private EventType(String str) {
            this.eventType = str;
        }

        public String toString() {
            return this.eventType;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$RemoteServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "binder", "Landroid/os/IBinder;", "latch", "Ljava/util/concurrent/CountDownLatch;", "getBinder", "onNullBinding", "", "name", "Landroid/content/ComponentName;", "onServiceConnected", "serviceBinder", "onServiceDisconnected", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: RemoteServiceWrapper.kt */
    private static final class RemoteServiceConnection implements ServiceConnection {
        private IBinder binder;
        private final CountDownLatch latch = new CountDownLatch(1);

        public void onServiceDisconnected(ComponentName componentName) {
            Intrinsics.checkNotNullParameter(componentName, "name");
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Intrinsics.checkNotNullParameter(componentName, "name");
            Intrinsics.checkNotNullParameter(iBinder, "serviceBinder");
            this.binder = iBinder;
            this.latch.countDown();
        }

        public void onNullBinding(ComponentName componentName) {
            Intrinsics.checkNotNullParameter(componentName, "name");
            this.latch.countDown();
        }

        public final IBinder getBinder() throws InterruptedException {
            this.latch.await(5, TimeUnit.SECONDS);
            return this.binder;
        }
    }
}
