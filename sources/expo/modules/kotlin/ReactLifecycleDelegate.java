package expo.modules.kotlin;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.LifecycleEventListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00040\u00040\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lexpo/modules/kotlin/ReactLifecycleDelegate;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "Lcom/facebook/react/bridge/ActivityEventListener;", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Lexpo/modules/kotlin/AppContext;)V", "appContextHolder", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onActivityResult", "", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onHostDestroy", "onHostPause", "onHostResume", "onNewIntent", "intent", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReactLifecycleDelegate.kt */
public final class ReactLifecycleDelegate implements LifecycleEventListener, ActivityEventListener {
    private final WeakReference<AppContext> appContextHolder;

    public ReactLifecycleDelegate(AppContext appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContextHolder = new WeakReference<>(appContext);
    }

    public void onHostResume() {
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onHostResume$expo_modules_core_release();
        }
    }

    public void onHostPause() {
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onHostPause$expo_modules_core_release();
        }
    }

    public void onHostDestroy() {
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onHostDestroy$expo_modules_core_release();
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onActivityResult$expo_modules_core_release(activity, i, i2, intent);
        }
    }

    public void onNewIntent(Intent intent) {
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onNewIntent$expo_modules_core_release(intent);
        }
    }
}
