package expo.modules.keepawake;

import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.ModuleRegistryDelegate;
import expo.modules.core.Promise;
import expo.modules.core.errors.CurrentActivityNotFoundException;
import expo.modules.core.interfaces.ExpoMethod;
import expo.modules.core.interfaces.services.KeepAwakeManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u001f\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u0001H\u001aH\u001a0\u0019\"\u0006\b\u0000\u0010\u001a\u0018\u0001H\bJ\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u001dH\u0016R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lexpo/modules/keepawake/KeepAwakeModule;", "Lexpo/modules/core/ExportedModule;", "context", "Landroid/content/Context;", "moduleRegistryDelegate", "Lexpo/modules/core/ModuleRegistryDelegate;", "(Landroid/content/Context;Lexpo/modules/core/ModuleRegistryDelegate;)V", "isActivated", "", "()Z", "keepAwakeManager", "Lexpo/modules/core/interfaces/services/KeepAwakeManager;", "getKeepAwakeManager", "()Lexpo/modules/core/interfaces/services/KeepAwakeManager;", "keepAwakeManager$delegate", "Lkotlin/Lazy;", "activate", "", "tag", "", "promise", "Lexpo/modules/core/Promise;", "deactivate", "getName", "moduleRegistry", "Lkotlin/Lazy;", "T", "kotlin.jvm.PlatformType", "onCreate", "Lexpo/modules/core/ModuleRegistry;", "expo-keep-awake_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: KeepAwakeModule.kt */
public final class KeepAwakeModule extends ExportedModule {
    private final Lazy keepAwakeManager$delegate;
    private final ModuleRegistryDelegate moduleRegistryDelegate;

    public String getName() {
        return "ExpoKeepAwake";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KeepAwakeModule(Context context, ModuleRegistryDelegate moduleRegistryDelegate2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new ModuleRegistryDelegate() : moduleRegistryDelegate2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KeepAwakeModule(Context context, ModuleRegistryDelegate moduleRegistryDelegate2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moduleRegistryDelegate2, "moduleRegistryDelegate");
        this.moduleRegistryDelegate = moduleRegistryDelegate2;
        this.keepAwakeManager$delegate = LazyKt.lazy(new KeepAwakeModule$special$$inlined$moduleRegistry$1(moduleRegistryDelegate2));
    }

    private final KeepAwakeManager getKeepAwakeManager() {
        Object value = this.keepAwakeManager$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-keepAwakeManager>(...)");
        return (KeepAwakeManager) value;
    }

    private final /* synthetic */ <T> Lazy<T> moduleRegistry() {
        ModuleRegistryDelegate moduleRegistryDelegate2 = this.moduleRegistryDelegate;
        Intrinsics.needClassReification();
        return LazyKt.lazy(new KeepAwakeModule$moduleRegistry$$inlined$getFromModuleRegistry$1(moduleRegistryDelegate2));
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        this.moduleRegistryDelegate.onCreate(moduleRegistry);
    }

    /* access modifiers changed from: private */
    /* renamed from: activate$lambda-0  reason: not valid java name */
    public static final void m772activate$lambda0(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        promise.resolve(true);
    }

    @ExpoMethod
    public final void activate(String str, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            getKeepAwakeManager().activate(str, new KeepAwakeModule$$ExternalSyntheticLambda1(promise));
        } catch (CurrentActivityNotFoundException unused) {
            promise.reject("NO_CURRENT_ACTIVITY", "Unable to activate keep awake");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: deactivate$lambda-1  reason: not valid java name */
    public static final void m773deactivate$lambda1(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        promise.resolve(true);
    }

    @ExpoMethod
    public final void deactivate(String str, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            getKeepAwakeManager().deactivate(str, new KeepAwakeModule$$ExternalSyntheticLambda0(promise));
        } catch (CurrentActivityNotFoundException unused) {
            promise.reject("NO_CURRENT_ACTIVITY", "Unable to deactivate keep awake. However, it probably is deactivated already.");
        }
    }

    public final boolean isActivated() {
        return getKeepAwakeManager().isActivated();
    }
}
