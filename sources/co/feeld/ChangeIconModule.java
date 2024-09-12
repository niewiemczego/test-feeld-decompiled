package co.feeld;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.os.Bundle;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.ArrayList;
import java.util.List;

public class ChangeIconModule extends ReactContextBaseJavaModule implements Application.ActivityLifecycleCallbacks {
    private List<String> classesToKill = new ArrayList();
    private String componentClass = "";
    private String iconChanged = "";

    public String getName() {
        return "ChangeIconModule";
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public ChangeIconModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getIcon(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject("ACTIVITY_NOT_FOUND");
            return;
        }
        if (this.componentClass.isEmpty()) {
            this.componentClass = currentActivity.getComponentName().getClassName();
        }
        String[] split = this.componentClass.split("MainActivity");
        promise.resolve((split.length <= 1 || split[1].isEmpty()) ? "Default" : split[1]);
    }

    @ReactMethod
    public void changeIcon(String str, Promise promise) {
        String str2;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject("ACTIVITY_NOT_FOUND");
        } else if (str.isEmpty()) {
            promise.reject("EMPTY_ICON_STRING");
        } else {
            if (this.componentClass.isEmpty()) {
                this.componentClass = currentActivity.getComponentName().getClassName();
            }
            String str3 = "co.feeld.MainActivity" + str;
            if (this.componentClass.equals(str3)) {
                promise.reject("ICON_ALREADY_USED");
                return;
            }
            try {
                currentActivity.getPackageManager().setComponentEnabledSetting(new ComponentName(BuildConfig.APPLICATION_ID, str3), 1, 1);
                promise.resolve(str + str3 + this.componentClass);
                String[] split = this.componentClass.split("MainActivity");
                List<String> list = this.classesToKill;
                if (split.length <= 1) {
                    str2 = this.componentClass + "Default";
                } else {
                    str2 = this.componentClass;
                }
                list.add(str2);
                this.componentClass = str3;
                currentActivity.getApplication().registerActivityLifecycleCallbacks(this);
                this.iconChanged = str3;
            } catch (Exception unused) {
                promise.reject("ICON_INVALID");
            }
        }
    }

    private void completeIconChange() {
        Activity currentActivity;
        if (!this.iconChanged.isEmpty() && (currentActivity = getCurrentActivity()) != null) {
            this.classesToKill.forEach(new ChangeIconModule$$ExternalSyntheticLambda0(this, currentActivity));
            this.classesToKill.clear();
            this.iconChanged = "";
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$completeIconChange$0$co-feeld-ChangeIconModule  reason: not valid java name */
    public /* synthetic */ void m83lambda$completeIconChange$0$cofeeldChangeIconModule(Activity activity, String str) {
        if (!str.equals(this.iconChanged)) {
            activity.getPackageManager().setComponentEnabledSetting(new ComponentName(BuildConfig.APPLICATION_ID, str), 2, 1);
        }
    }

    public void onActivityPaused(Activity activity) {
        completeIconChange();
    }
}
