package expo.modules.kotlin.modules;

import android.os.Bundle;
import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.events.EventEmitter;
import expo.modules.kotlin.providers.AppContextProvider;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\b J\b\u0010!\u001a\u00020\"H&J\u001a\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'J&\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010(R\"\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u00020\r8FX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00128\u0000@\u0000X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/kotlin/providers/AppContextProvider;", "()V", "_appContext", "Lexpo/modules/kotlin/AppContext;", "get_appContext$expo_modules_core_release$annotations", "get_appContext$expo_modules_core_release", "()Lexpo/modules/kotlin/AppContext;", "set_appContext$expo_modules_core_release", "(Lexpo/modules/kotlin/AppContext;)V", "appContext", "getAppContext", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$annotations", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScopeDelegate", "Lkotlin/Lazy;", "getCoroutineScopeDelegate$annotations", "getCoroutineScopeDelegate", "()Lkotlin/Lazy;", "setCoroutineScopeDelegate", "(Lkotlin/Lazy;)V", "moduleEventEmitter", "Lexpo/modules/kotlin/events/EventEmitter;", "getModuleEventEmitter", "()Lexpo/modules/kotlin/events/EventEmitter;", "moduleEventEmitter$delegate", "Lkotlin/Lazy;", "cleanUp", "", "cleanUp$expo_modules_core_release", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "sendEvent", "name", "", "body", "Landroid/os/Bundle;", "", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Module.kt */
public abstract class Module implements AppContextProvider {
    private AppContext _appContext;
    public Lazy<? extends CoroutineScope> coroutineScopeDelegate;
    private final Lazy moduleEventEmitter$delegate = LazyKt.lazy(new Module$moduleEventEmitter$2(this));

    @Deprecated(message = "Use a scope from the AppContext", replaceWith = @ReplaceWith(expression = "appContext.modulesQueue", imports = {}))
    public static /* synthetic */ void getCoroutineScope$annotations() {
    }

    public static /* synthetic */ void getCoroutineScopeDelegate$annotations() {
    }

    public static /* synthetic */ void get_appContext$expo_modules_core_release$annotations() {
    }

    public abstract ModuleDefinitionData definition();

    public final AppContext get_appContext$expo_modules_core_release() {
        return this._appContext;
    }

    public final void set_appContext$expo_modules_core_release(AppContext appContext) {
        this._appContext = appContext;
    }

    public AppContext getAppContext() {
        AppContext appContext = this._appContext;
        if (appContext != null) {
            return appContext;
        }
        throw new IllegalArgumentException("The module wasn't created! You can't access the app context.".toString());
    }

    private final EventEmitter getModuleEventEmitter() {
        return (EventEmitter) this.moduleEventEmitter$delegate.getValue();
    }

    public final Lazy<CoroutineScope> getCoroutineScopeDelegate() {
        Lazy<? extends CoroutineScope> lazy = this.coroutineScopeDelegate;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coroutineScopeDelegate");
        return null;
    }

    public final void setCoroutineScopeDelegate(Lazy<? extends CoroutineScope> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "<set-?>");
        this.coroutineScopeDelegate = lazy;
    }

    public final CoroutineScope getCoroutineScope() {
        return getCoroutineScopeDelegate().getValue();
    }

    public static /* synthetic */ void sendEvent$default(Module module, String str, Bundle bundle, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                bundle = Bundle.EMPTY;
            }
            module.sendEvent(str, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
    }

    public final void sendEvent(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "name");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(str, bundle);
        }
    }

    public final void sendEvent(String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "name");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(str, (Map<?, ?>) map);
        }
    }

    public final void cleanUp$expo_modules_core_release() {
        if (getCoroutineScopeDelegate().isInitialized()) {
            CoroutineScopeKt.cancel(getCoroutineScope(), new ModuleDestroyedException((String) null, 1, (DefaultConstructorMarker) null));
        }
    }
}
