package expo.modules.keepawake;

import android.app.Activity;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.ModuleRegistryDelegate;
import expo.modules.core.errors.CurrentActivityNotFoundException;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.services.KeepAwakeManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00150\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001f\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u0001H\u001aH\u001a0\u0019\"\u0006\b\u0000\u0010\u001a\u0018\u0001H\bJ\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u001dH\u0016R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e²\u0006\n\u0010\u001f\u001a\u00020 X\u0002"}, d2 = {"Lexpo/modules/keepawake/ExpoKeepAwakeManager;", "Lexpo/modules/core/interfaces/services/KeepAwakeManager;", "Lexpo/modules/core/interfaces/InternalModule;", "moduleRegistryDelegate", "Lexpo/modules/core/ModuleRegistryDelegate;", "(Lexpo/modules/core/ModuleRegistryDelegate;)V", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "tags", "", "", "activate", "", "tag", "done", "Ljava/lang/Runnable;", "deactivate", "getExportedInterfaces", "", "Ljava/lang/Class;", "isActivated", "", "moduleRegistry", "Lkotlin/Lazy;", "T", "kotlin.jvm.PlatformType", "onCreate", "Lexpo/modules/core/ModuleRegistry;", "expo-keep-awake_release", "activityProvider", "Lexpo/modules/core/interfaces/ActivityProvider;"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoKeepAwakeManager.kt */
public final class ExpoKeepAwakeManager implements KeepAwakeManager, InternalModule {
    private final ModuleRegistryDelegate moduleRegistryDelegate;
    private final Set<String> tags;

    public ExpoKeepAwakeManager() {
        this((ModuleRegistryDelegate) null, 1, (DefaultConstructorMarker) null);
    }

    public ExpoKeepAwakeManager(ModuleRegistryDelegate moduleRegistryDelegate2) {
        Intrinsics.checkNotNullParameter(moduleRegistryDelegate2, "moduleRegistryDelegate");
        this.moduleRegistryDelegate = moduleRegistryDelegate2;
        this.tags = new HashSet();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExpoKeepAwakeManager(ModuleRegistryDelegate moduleRegistryDelegate2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ModuleRegistryDelegate() : moduleRegistryDelegate2);
    }

    private final /* synthetic */ <T> Lazy<T> moduleRegistry() {
        ModuleRegistryDelegate moduleRegistryDelegate2 = this.moduleRegistryDelegate;
        Intrinsics.needClassReification();
        return LazyKt.lazy(new ExpoKeepAwakeManager$moduleRegistry$$inlined$getFromModuleRegistry$1(moduleRegistryDelegate2));
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        this.moduleRegistryDelegate.onCreate(moduleRegistry);
    }

    /* renamed from: _get_currentActivity_$lambda-0  reason: not valid java name */
    private static final ActivityProvider m768_get_currentActivity_$lambda0(Lazy<? extends ActivityProvider> lazy) {
        Object value = lazy.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "_get_currentActivity_$lambda-0(...)");
        return (ActivityProvider) value;
    }

    public void activate(String str, Runnable runnable) throws CurrentActivityNotFoundException {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(runnable, "done");
        Activity currentActivity = getCurrentActivity();
        if (!isActivated()) {
            currentActivity.runOnUiThread(new ExpoKeepAwakeManager$$ExternalSyntheticLambda0(currentActivity));
        }
        this.tags.add(str);
        runnable.run();
    }

    /* access modifiers changed from: private */
    /* renamed from: activate$lambda-1  reason: not valid java name */
    public static final void m769activate$lambda1(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        activity.getWindow().addFlags(128);
    }

    public void deactivate(String str, Runnable runnable) throws CurrentActivityNotFoundException {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(runnable, "done");
        Activity currentActivity = getCurrentActivity();
        if (this.tags.size() == 1 && this.tags.contains(str)) {
            currentActivity.runOnUiThread(new ExpoKeepAwakeManager$$ExternalSyntheticLambda1(currentActivity));
        }
        this.tags.remove(str);
        runnable.run();
    }

    /* access modifiers changed from: private */
    /* renamed from: deactivate$lambda-2  reason: not valid java name */
    public static final void m770deactivate$lambda2(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        activity.getWindow().clearFlags(128);
    }

    public boolean isActivated() {
        return !this.tags.isEmpty();
    }

    public List<Class<?>> getExportedInterfaces() {
        return CollectionsKt.listOf(KeepAwakeManager.class);
    }

    private final Activity getCurrentActivity() throws CurrentActivityNotFoundException {
        Lazy lazy = LazyKt.lazy(new ExpoKeepAwakeManager$special$$inlined$moduleRegistry$1(this.moduleRegistryDelegate));
        if (m768_get_currentActivity_$lambda0(lazy).getCurrentActivity() != null) {
            Activity currentActivity = m768_get_currentActivity_$lambda0(lazy).getCurrentActivity();
            Intrinsics.checkNotNullExpressionValue(currentActivity, "{\n        activityProvider.currentActivity\n      }");
            return currentActivity;
        }
        throw new CurrentActivityNotFoundException();
    }
}
