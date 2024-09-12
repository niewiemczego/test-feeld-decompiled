package expo.modules.application;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.android.installreferrer.api.InstallReferrerClient;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.ExpoMethod;
import expo.modules.core.interfaces.RegistryLifecycleListener;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000bH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lexpo/modules/application/ApplicationModule;", "Lexpo/modules/core/ExportedModule;", "Lexpo/modules/core/interfaces/RegistryLifecycleListener;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mActivity", "Landroid/app/Activity;", "mActivityProvider", "Lexpo/modules/core/interfaces/ActivityProvider;", "mModuleRegistry", "Lexpo/modules/core/ModuleRegistry;", "getConstants", "", "", "", "getInstallReferrerAsync", "", "promise", "Lexpo/modules/core/Promise;", "getInstallationTimeAsync", "getLastUpdateTimeAsync", "getName", "onCreate", "moduleRegistry", "Companion", "expo-application_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ApplicationModule.kt */
public final class ApplicationModule extends ExportedModule implements RegistryLifecycleListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Activity mActivity;
    private ActivityProvider mActivityProvider;
    private final Context mContext;
    private ModuleRegistry mModuleRegistry;

    public String getName() {
        return "ExpoApplication";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplicationModule(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        this.mModuleRegistry = moduleRegistry;
        ActivityProvider activityProvider = (ActivityProvider) moduleRegistry.getModule(ActivityProvider.class);
        this.mActivityProvider = activityProvider;
        this.mActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        String obj = this.mContext.getApplicationInfo().loadLabel(this.mContext.getPackageManager()).toString();
        String packageName = this.mContext.getPackageName();
        Map<String, Object> map = hashMap;
        map.put("applicationName", obj);
        map.put("applicationId", packageName);
        try {
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(packageName, 0);
            hashMap.put("nativeApplicationVersion", packageInfo.versionName);
            Companion companion = Companion;
            Intrinsics.checkNotNullExpressionValue(packageInfo, "pInfo");
            hashMap.put("nativeBuildVersion", String.valueOf((int) companion.getLongVersionCode(packageInfo)));
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(ApplicationModuleKt.TAG, "Exception: ", e);
        }
        map.put("androidId", Settings.Secure.getString(this.mContext.getContentResolver(), "android_id"));
        return map;
    }

    @ExpoMethod
    public final void getInstallationTimeAsync(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            promise.resolve(Double.valueOf((double) this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).firstInstallTime));
        } catch (PackageManager.NameNotFoundException e) {
            Throwable th = e;
            Log.e(ApplicationModuleKt.TAG, "Exception: ", th);
            promise.reject("ERR_APPLICATION_PACKAGE_NAME_NOT_FOUND", "Unable to get install time of this application. Could not get package info or package name.", th);
        }
    }

    @ExpoMethod
    public final void getLastUpdateTimeAsync(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            promise.resolve(Double.valueOf((double) this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).lastUpdateTime));
        } catch (PackageManager.NameNotFoundException e) {
            Throwable th = e;
            Log.e(ApplicationModuleKt.TAG, "Exception: ", th);
            promise.reject("ERR_APPLICATION_PACKAGE_NAME_NOT_FOUND", "Unable to get last update time of this application. Could not get package info or package name.", th);
        }
    }

    @ExpoMethod
    public final void getInstallReferrerAsync(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        StringBuilder sb = new StringBuilder();
        InstallReferrerClient build = InstallReferrerClient.newBuilder(this.mContext).build();
        build.startConnection(new ApplicationModule$getInstallReferrerAsync$1(build, sb, promise));
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lexpo/modules/application/ApplicationModule$Companion;", "", "()V", "getLongVersionCode", "", "info", "Landroid/content/pm/PackageInfo;", "expo-application_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ApplicationModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final long getLongVersionCode(PackageInfo packageInfo) {
            if (Build.VERSION.SDK_INT >= 28) {
                return packageInfo.getLongVersionCode();
            }
            return (long) packageInfo.versionCode;
        }
    }
}
