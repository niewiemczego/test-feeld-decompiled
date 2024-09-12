package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.soloader.SoLoader;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.ModuleRegistry;
import expo.modules.kotlin.exception.JavaScriptEvaluateException;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\n\u001a\u00020\u000bH J\t\u0010\f\u001a\u00020\rH J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H J\b\u0010\u0012\u001a\u00020\rH\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0007J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017H\u0007¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u000bH J\t\u0010\u001a\u001a\u00020\tH J!\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH J\t\u0010!\u001a\u00020\rH R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lexpo/modules/kotlin/jni/JSIInteropModuleRegistry;", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Lexpo/modules/kotlin/AppContext;)V", "appContextHolder", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "mHybridData", "Lcom/facebook/jni/HybridData;", "createObject", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "drainJSEventLoop", "", "evaluateScript", "Lexpo/modules/kotlin/jni/JavaScriptValue;", "script", "", "finalize", "getJavaScriptModuleObject", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "name", "getJavaScriptModulesName", "", "()[Ljava/lang/String;", "global", "initHybrid", "installJSI", "jsRuntimePointer", "", "jsInvokerHolder", "Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;", "nativeInvokerHolder", "installJSIForTests", "Companion", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: JSIInteropModuleRegistry.kt */
public final class JSIInteropModuleRegistry {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final WeakReference<AppContext> appContextHolder;
    private final HybridData mHybridData = initHybrid();

    private final native HybridData initHybrid();

    public final native JavaScriptObject createObject();

    public final native void drainJSEventLoop();

    public final native JavaScriptValue evaluateScript(String str) throws JavaScriptEvaluateException;

    public final native JavaScriptObject global();

    public final native void installJSI(long j, CallInvokerHolderImpl callInvokerHolderImpl, CallInvokerHolderImpl callInvokerHolderImpl2);

    public final native void installJSIForTests();

    public JSIInteropModuleRegistry(AppContext appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContextHolder = new WeakReference<>(appContext);
    }

    public final JavaScriptModuleObject getJavaScriptModuleObject(String str) {
        ModuleRegistry registry;
        ModuleHolder moduleHolder;
        Intrinsics.checkNotNullParameter(str, "name");
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext == null || (registry = appContext.getRegistry()) == null || (moduleHolder = registry.getModuleHolder(str)) == null) {
            return null;
        }
        return moduleHolder.getJsObject();
    }

    public final String[] getJavaScriptModulesName() {
        ModuleRegistry registry;
        Map<String, ModuleHolder> registry2;
        Set<String> keySet;
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (!(appContext == null || (registry = appContext.getRegistry()) == null || (registry2 = registry.getRegistry()) == null || (keySet = registry2.keySet()) == null)) {
            Object[] array = keySet.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (strArr != null) {
                return strArr;
            }
        }
        return (String[]) ((Object[]) new String[0]);
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        this.mHybridData.resetNative();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/jni/JSIInteropModuleRegistry$Companion;", "", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: JSIInteropModuleRegistry.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        SoLoader.loadLibrary("expo-modules-core");
    }
}
