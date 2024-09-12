package expo.modules.adapters.react.apploader;

import android.content.Context;
import android.os.Handler;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.LifecycleState;
import expo.modules.apploader.HeadlessAppLoader;
import expo.modules.core.interfaces.Consumer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J4\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/adapters/react/apploader/RNHeadlessAppLoader;", "Lexpo/modules/apploader/HeadlessAppLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "invalidateApp", "", "appScopeKey", "", "isRunning", "loadApp", "", "params", "Lexpo/modules/apploader/HeadlessAppLoader$Params;", "alreadyRunning", "Ljava/lang/Runnable;", "callback", "Lexpo/modules/core/interfaces/Consumer;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RNHeadlessAppLoader.kt */
public final class RNHeadlessAppLoader implements HeadlessAppLoader {
    private final Context context;

    public RNHeadlessAppLoader(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public void loadApp(Context context2, HeadlessAppLoader.Params params, Runnable runnable, Consumer<Boolean> consumer) {
        Intrinsics.checkNotNullParameter(context2, "context");
        if (params == null || params.getAppScopeKey() == null) {
            throw new IllegalArgumentException("Params must be set with appScopeKey!");
        } else if (context2.getApplicationContext() instanceof ReactApplication) {
            Context applicationContext = context2.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
            ReactInstanceManager reactInstanceManager = ((ReactApplication) applicationContext).getReactNativeHost().getReactInstanceManager();
            if (!RNHeadlessAppLoaderKt.appRecords.containsKey(params.getAppScopeKey())) {
                reactInstanceManager.addReactInstanceEventListener(new RNHeadlessAppLoader$$ExternalSyntheticLambda0(params, consumer));
                Map access$getAppRecords$p = RNHeadlessAppLoaderKt.appRecords;
                String appScopeKey = params.getAppScopeKey();
                Intrinsics.checkNotNullExpressionValue(appScopeKey, "params.appScopeKey");
                Intrinsics.checkNotNullExpressionValue(reactInstanceManager, "reactInstanceManager");
                access$getAppRecords$p.put(appScopeKey, reactInstanceManager);
                if (reactInstanceManager.hasStartedCreatingInitialContext()) {
                    reactInstanceManager.recreateReactContextInBackground();
                } else {
                    reactInstanceManager.createReactContextInBackground();
                }
            } else if (runnable != null) {
                runnable.run();
            }
        } else {
            throw new IllegalStateException("Your application must implement ReactApplication");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadApp$lambda-0  reason: not valid java name */
    public static final void m682loadApp$lambda0(HeadlessAppLoader.Params params, Consumer consumer, ReactContext reactContext) {
        HeadlessAppLoaderNotifier.INSTANCE.notifyAppLoaded(params.getAppScopeKey());
        if (consumer != null) {
            consumer.apply(true);
        }
    }

    public boolean invalidateApp(String str) {
        if (!RNHeadlessAppLoaderKt.appRecords.containsKey(str) || RNHeadlessAppLoaderKt.appRecords.get(str) == null) {
            return false;
        }
        Object obj = RNHeadlessAppLoaderKt.appRecords.get(str);
        Intrinsics.checkNotNull(obj);
        new Handler(this.context.getMainLooper()).post(new RNHeadlessAppLoader$$ExternalSyntheticLambda1((ReactInstanceManager) obj, str));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: invalidateApp$lambda-1  reason: not valid java name */
    public static final void m681invalidateApp$lambda1(ReactInstanceManager reactInstanceManager, String str) {
        Intrinsics.checkNotNullParameter(reactInstanceManager, "$appRecord");
        if (reactInstanceManager.getLifecycleState() == LifecycleState.BEFORE_CREATE) {
            reactInstanceManager.destroy();
        }
        HeadlessAppLoaderNotifier.INSTANCE.notifyAppDestroyed(str);
        TypeIntrinsics.asMutableMap(RNHeadlessAppLoaderKt.appRecords).remove(str);
    }

    public boolean isRunning(String str) {
        if (RNHeadlessAppLoaderKt.appRecords.containsKey(str)) {
            Object obj = RNHeadlessAppLoaderKt.appRecords.get(str);
            Intrinsics.checkNotNull(obj);
            if (((ReactInstanceManager) obj).hasStartedCreatingInitialContext()) {
                return true;
            }
        }
        return false;
    }
}
