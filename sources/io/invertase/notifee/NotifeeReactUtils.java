package io.invertase.notifee;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import app.notifee.core.EventSubscriber;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

class NotifeeReactUtils {
    /* access modifiers changed from: private */
    public static final SparseArray<GenericCallback> headlessTasks = new SparseArray<>();
    private static final HeadlessJsTaskEventListener headlessTasksListener = new HeadlessJsTaskEventListener() {
        public void onHeadlessJsTaskStart(int i) {
        }

        public void onHeadlessJsTaskFinish(int i) {
            synchronized (NotifeeReactUtils.headlessTasks) {
                GenericCallback genericCallback = (GenericCallback) NotifeeReactUtils.headlessTasks.get(i);
                if (genericCallback != null) {
                    NotifeeReactUtils.headlessTasks.remove(i);
                    genericCallback.call();
                }
            }
        }
    };

    interface GenericCallback {
        void call();
    }

    NotifeeReactUtils() {
    }

    /* access modifiers changed from: package-private */
    public static void promiseResolver(Promise promise, Exception exc, Bundle bundle) {
        if (exc != null) {
            promise.reject((Throwable) exc);
        } else if (bundle != null) {
            promise.resolve(Arguments.fromBundle(bundle));
        } else {
            promise.resolve((Object) null);
        }
    }

    /* access modifiers changed from: package-private */
    public static void promiseResolver(Promise promise, Exception exc, List<Bundle> list) {
        if (exc != null) {
            promise.reject((Throwable) exc);
            return;
        }
        WritableArray createArray = Arguments.createArray();
        for (Bundle fromBundle : list) {
            createArray.pushMap(Arguments.fromBundle(fromBundle));
        }
        promise.resolve(createArray);
    }

    /* access modifiers changed from: package-private */
    public static void promiseBooleanResolver(Promise promise, Exception exc, Boolean bool) {
        if (exc != null) {
            promise.reject((Throwable) exc);
        } else {
            promise.resolve(bool);
        }
    }

    /* access modifiers changed from: package-private */
    public static void promiseStringListResolver(Promise promise, Exception exc, List<String> list) {
        if (exc != null) {
            promise.reject((Throwable) exc);
            return;
        }
        WritableArray createArray = Arguments.createArray();
        for (String pushString : list) {
            createArray.pushString(pushString);
        }
        promise.resolve(createArray);
    }

    /* access modifiers changed from: package-private */
    public static void promiseResolver(Promise promise, Exception exc) {
        if (exc != null) {
            promise.reject((Throwable) exc);
        } else {
            promise.resolve((Object) null);
        }
    }

    private static ReactContext getReactContext() {
        return ((ReactApplication) EventSubscriber.getContext()).getReactNativeHost().getReactInstanceManager().getCurrentReactContext();
    }

    private static void initializeReactContext(final GenericCallback genericCallback) {
        final ReactInstanceManager reactInstanceManager = ((ReactApplication) EventSubscriber.getContext()).getReactNativeHost().getReactInstanceManager();
        reactInstanceManager.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() {
            public void onReactContextInitialized(ReactContext reactContext) {
                ReactInstanceManager.this.removeReactInstanceEventListener(this);
                Handler handler = new Handler(Looper.getMainLooper());
                GenericCallback genericCallback = genericCallback;
                Objects.requireNonNull(genericCallback);
                handler.postDelayed(new NotifeeReactUtils$2$$ExternalSyntheticLambda0(genericCallback), 100);
            }
        });
        if (!reactInstanceManager.hasStartedCreatingInitialContext()) {
            reactInstanceManager.createReactContextInBackground();
        }
    }

    static void clearRunningHeadlessTasks() {
        int i = 0;
        while (true) {
            SparseArray<GenericCallback> sparseArray = headlessTasks;
            if (i < sparseArray.size()) {
                sparseArray.valueAt(i).call();
                sparseArray.remove(i);
                i++;
            } else {
                return;
            }
        }
    }

    static void startHeadlessTask(String str, WritableMap writableMap, long j, GenericCallback genericCallback) {
        NotifeeReactUtils$$ExternalSyntheticLambda0 notifeeReactUtils$$ExternalSyntheticLambda0 = new NotifeeReactUtils$$ExternalSyntheticLambda0(str, writableMap, j, genericCallback);
        if (getReactContext() == null) {
            initializeReactContext(notifeeReactUtils$$ExternalSyntheticLambda0);
        } else {
            notifeeReactUtils$$ExternalSyntheticLambda0.call();
        }
    }

    static /* synthetic */ void lambda$startHeadlessTask$1(String str, WritableMap writableMap, long j, GenericCallback genericCallback) {
        HeadlessJsTaskContext instance = HeadlessJsTaskContext.getInstance(getReactContext());
        HeadlessJsTaskConfig headlessJsTaskConfig = new HeadlessJsTaskConfig(str, writableMap, j, true);
        SparseArray<GenericCallback> sparseArray = headlessTasks;
        synchronized (sparseArray) {
            if (sparseArray.size() == 0) {
                instance.addTaskEventListener(headlessTasksListener);
            }
        }
        sparseArray.put(instance.startTask(headlessJsTaskConfig), new NotifeeReactUtils$$ExternalSyntheticLambda1(instance, genericCallback));
    }

    static /* synthetic */ void lambda$startHeadlessTask$0(HeadlessJsTaskContext headlessJsTaskContext, GenericCallback genericCallback) {
        SparseArray<GenericCallback> sparseArray = headlessTasks;
        synchronized (sparseArray) {
            if (sparseArray.size() == 0) {
                headlessJsTaskContext.removeTaskEventListener(headlessTasksListener);
            }
        }
        if (genericCallback != null) {
            genericCallback.call();
        }
    }

    static void sendEvent(String str, WritableMap writableMap) {
        try {
            ReactContext reactContext = getReactContext();
            if (reactContext == null) {
                return;
            }
            if (reactContext.hasActiveCatalystInstance()) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
            }
        } catch (Exception e) {
            Log.e("SEND_EVENT", "", e);
        }
    }

    static boolean isAppInForeground() {
        return Boolean.valueOf(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)).booleanValue();
    }

    static void hideNotificationDrawer() {
        try {
            Object systemService = EventSubscriber.getContext().getSystemService("statusbar");
            Method method = Class.forName("android.app.StatusBarManager").getMethod(Build.VERSION.SDK_INT >= 17 ? "collapsePanels" : "collapse", new Class[0]);
            method.setAccessible(true);
            method.invoke(systemService, new Object[0]);
        } catch (Exception e) {
            Log.e("HIDE_NOTIF_DRAWER", "", e);
        }
    }
}
