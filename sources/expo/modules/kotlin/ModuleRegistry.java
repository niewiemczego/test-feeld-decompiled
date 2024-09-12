package expo.modules.kotlin;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.modules.Module;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\u0006\b\u0000\u0010\u0011\u0018\u0001H\b¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\tJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0013J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\tJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dJ!\u0010\u001b\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u0002H\u001e¢\u0006\u0002\u0010 J/\u0010\u001b\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u001e\"\u0004\b\u0001\u0010!2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u0002H\u001e2\u0006\u0010\"\u001a\u0002H!¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&J\u000e\u0010$\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0013R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\b8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006'"}, d2 = {"Lexpo/modules/kotlin/ModuleRegistry;", "", "Lexpo/modules/kotlin/ModuleHolder;", "appContext", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/AppContext;", "(Ljava/lang/ref/WeakReference;)V", "registry", "", "", "getRegistry$annotations", "()V", "getRegistry", "()Ljava/util/Map;", "cleanUp", "", "getModule", "T", "()Ljava/lang/Object;", "Lexpo/modules/kotlin/modules/Module;", "name", "getModuleHolder", "module", "hasModule", "", "iterator", "", "post", "eventName", "Lexpo/modules/kotlin/events/EventName;", "Sender", "sender", "(Lexpo/modules/kotlin/events/EventName;Ljava/lang/Object;)V", "Payload", "payload", "(Lexpo/modules/kotlin/events/EventName;Ljava/lang/Object;Ljava/lang/Object;)V", "register", "provider", "Lexpo/modules/kotlin/ModulesProvider;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ModuleRegistry.kt */
public final class ModuleRegistry implements Iterable<ModuleHolder>, KMappedMarker {
    private final WeakReference<AppContext> appContext;
    private final Map<String, ModuleHolder> registry = new LinkedHashMap();

    public static /* synthetic */ void getRegistry$annotations() {
    }

    public ModuleRegistry(WeakReference<AppContext> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "appContext");
        this.appContext = weakReference;
    }

    public final Map<String, ModuleHolder> getRegistry() {
        return this.registry;
    }

    public final void register(Module module) {
        AppContext appContext2;
        CoroutineScope backgroundCoroutineScope;
        Intrinsics.checkNotNullParameter(module, "module");
        ModuleHolder moduleHolder = new ModuleHolder(module);
        Object obj = this.appContext.get();
        if (obj != null) {
            module.set_appContext$expo_modules_core_release((AppContext) obj);
            module.setCoroutineScopeDelegate(LazyKt.lazy(new ModuleRegistry$register$2(moduleHolder)));
            moduleHolder.post(EventName.MODULE_CREATE);
            moduleHolder.registerContracts();
            KClass<? extends View> viewClass = moduleHolder.viewClass();
            if (!(viewClass == null || (appContext2 = (AppContext) this.appContext.get()) == null || (backgroundCoroutineScope = appContext2.getBackgroundCoroutineScope()) == null)) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(backgroundCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ModuleRegistry$register$3$1(viewClass, (Continuation<? super ModuleRegistry$register$3$1>) null), 3, (Object) null);
            }
            this.registry.put(moduleHolder.getName(), moduleHolder);
            return;
        }
        throw new IllegalArgumentException("Cannot create a module for invalid app context.".toString());
    }

    public final ModuleRegistry register(ModulesProvider modulesProvider) {
        Intrinsics.checkNotNullParameter(modulesProvider, "provider");
        ModuleRegistry moduleRegistry = this;
        for (Class newInstance : modulesProvider.getModulesList()) {
            Module module = (Module) newInstance.newInstance();
            Intrinsics.checkNotNullExpressionValue(module, "module");
            register(module);
        }
        return this;
    }

    public final boolean hasModule(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.registry.containsKey(str);
    }

    public final Module getModule(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        ModuleHolder moduleHolder = this.registry.get(str);
        if (moduleHolder != null) {
            return moduleHolder.getModule();
        }
        return null;
    }

    public final /* synthetic */ <T> T getModule() {
        T t;
        Object obj;
        Iterator it = getRegistry().values().iterator();
        while (true) {
            t = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Module module = ((ModuleHolder) obj).getModule();
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (module instanceof Object) {
                break;
            }
        }
        ModuleHolder moduleHolder = (ModuleHolder) obj;
        if (moduleHolder != null) {
            t = moduleHolder.getModule();
        }
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return (Object) t;
    }

    public final ModuleHolder getModuleHolder(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.registry.get(str);
    }

    public final ModuleHolder getModuleHolder(Module module) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(module, "module");
        Iterator it = this.registry.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ModuleHolder) obj).getModule() == module) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        return (ModuleHolder) obj;
    }

    public final void post(EventName eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Iterator it = iterator();
        while (it.hasNext()) {
            ((ModuleHolder) it.next()).post(eventName);
        }
    }

    public final <Sender> void post(EventName eventName, Sender sender) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Iterator it = iterator();
        while (it.hasNext()) {
            ((ModuleHolder) it.next()).post(eventName, sender);
        }
    }

    public final <Sender, Payload> void post(EventName eventName, Sender sender, Payload payload) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Iterator it = iterator();
        while (it.hasNext()) {
            ((ModuleHolder) it.next()).post(eventName, sender, payload);
        }
    }

    public Iterator<ModuleHolder> iterator() {
        return this.registry.values().iterator();
    }

    public final void cleanUp() {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((ModuleHolder) it.next()).cleanUp();
        }
        this.registry.clear();
        CoreLoggerKt.getLogger().info("✅ ModuleRegistry was destroyed");
    }
}
