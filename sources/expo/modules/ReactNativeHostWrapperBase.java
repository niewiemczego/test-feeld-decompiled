package expo.modules;

import android.app.Application;
import androidx.collection.ArrayMap;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.ReactNativeHostHandler;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0001(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\n\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0014J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\nH\u0014J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0013J\u001d\u0010#\u001a\u0002H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u00020\nH\u0000¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006)"}, d2 = {"Lexpo/modules/ReactNativeHostWrapperBase;", "Lcom/facebook/react/ReactNativeHost;", "application", "Landroid/app/Application;", "host", "(Landroid/app/Application;Lcom/facebook/react/ReactNativeHost;)V", "getHost", "()Lcom/facebook/react/ReactNativeHost;", "methodMap", "Landroidx/collection/ArrayMap;", "", "Ljava/lang/reflect/Method;", "reactNativeHostHandlers", "", "Lexpo/modules/core/interfaces/ReactNativeHostHandler;", "kotlin.jvm.PlatformType", "getReactNativeHostHandlers$expo_release", "()Ljava/util/List;", "createReactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "getBundleAssetName", "getJSBundleFile", "getJSIModulePackage", "Lcom/facebook/react/bridge/JSIModulePackage;", "getJSMainModuleName", "getJavaScriptExecutorFactory", "Lcom/facebook/react/bridge/JavaScriptExecutorFactory;", "getPackages", "", "Lcom/facebook/react/ReactPackage;", "getUseDeveloperSupport", "", "injectHostReactInstanceManager", "", "reactInstanceManager", "invokeDelegateMethod", "T", "name", "invokeDelegateMethod$expo_release", "(Ljava/lang/String;)Ljava/lang/Object;", "JSIModuleContainerPackage", "expo_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReactNativeHostWrapperBase.kt */
public class ReactNativeHostWrapperBase extends ReactNativeHost {
    private final ReactNativeHost host;
    private final ArrayMap<String, Method> methodMap;
    private final List<ReactNativeHostHandler> reactNativeHostHandlers;

    /* access modifiers changed from: protected */
    public final ReactNativeHost getHost() {
        return this.host;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReactNativeHostWrapperBase(Application application, ReactNativeHost reactNativeHost) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(reactNativeHost, "host");
        this.host = reactNativeHost;
        Collection arrayList = new ArrayList();
        for (Package createReactNativeHostHandlers : ExpoModulesPackage.Companion.getPackageList()) {
            List<? extends ReactNativeHostHandler> createReactNativeHostHandlers2 = createReactNativeHostHandlers.createReactNativeHostHandlers(application);
            Intrinsics.checkNotNullExpressionValue(createReactNativeHostHandlers2, "it.createReactNativeHostHandlers(application)");
            CollectionsKt.addAll(arrayList, createReactNativeHostHandlers2);
        }
        this.reactNativeHostHandlers = (List) arrayList;
        this.methodMap = new ArrayMap<>();
    }

    public final List<ReactNativeHostHandler> getReactNativeHostHandlers$expo_release() {
        return this.reactNativeHostHandlers;
    }

    /* access modifiers changed from: protected */
    public ReactInstanceManager createReactInstanceManager() {
        boolean useDeveloperSupport = getUseDeveloperSupport();
        for (ReactNativeHostHandler onWillCreateReactInstanceManager : this.reactNativeHostHandlers) {
            onWillCreateReactInstanceManager.onWillCreateReactInstanceManager(useDeveloperSupport);
        }
        ReactInstanceManager reactInstanceManager = (ReactInstanceManager) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), new ReactNativeHostWrapperBase$createReactInstanceManager$result$1(useDeveloperSupport)));
        if (reactInstanceManager == null) {
            reactInstanceManager = super.createReactInstanceManager();
        }
        for (ReactNativeHostHandler onDidCreateReactInstanceManager : this.reactNativeHostHandlers) {
            onDidCreateReactInstanceManager.onDidCreateReactInstanceManager(reactInstanceManager, useDeveloperSupport);
        }
        Intrinsics.checkNotNullExpressionValue(reactInstanceManager, "result");
        injectHostReactInstanceManager(reactInstanceManager);
        return reactInstanceManager;
    }

    /* access modifiers changed from: protected */
    public JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
        JavaScriptExecutorFactory javaScriptExecutorFactory = (JavaScriptExecutorFactory) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), ReactNativeHostWrapperBase$getJavaScriptExecutorFactory$1.INSTANCE));
        return javaScriptExecutorFactory == null ? (JavaScriptExecutorFactory) invokeDelegateMethod$expo_release("getJavaScriptExecutorFactory") : javaScriptExecutorFactory;
    }

    /* access modifiers changed from: protected */
    public JSIModulePackage getJSIModulePackage() {
        return new JSIModuleContainerPackage((JSIModulePackage) invokeDelegateMethod$expo_release("getJSIModulePackage"));
    }

    /* access modifiers changed from: protected */
    public String getJSMainModuleName() {
        return (String) invokeDelegateMethod$expo_release("getJSMainModuleName");
    }

    /* access modifiers changed from: protected */
    public String getJSBundleFile() {
        String str = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), new ReactNativeHostWrapperBase$getJSBundleFile$1(this)));
        return str == null ? (String) invokeDelegateMethod$expo_release("getJSBundleFile") : str;
    }

    /* access modifiers changed from: protected */
    public String getBundleAssetName() {
        String str = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), new ReactNativeHostWrapperBase$getBundleAssetName$1(this)));
        return str == null ? (String) invokeDelegateMethod$expo_release("getBundleAssetName") : str;
    }

    public boolean getUseDeveloperSupport() {
        Boolean bool = (Boolean) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), ReactNativeHostWrapperBase$getUseDeveloperSupport$1.INSTANCE));
        if (bool == null) {
            return this.host.getUseDeveloperSupport();
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: protected */
    public List<ReactPackage> getPackages() {
        return (List) invokeDelegateMethod$expo_release("getPackages");
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lexpo/modules/ReactNativeHostWrapperBase$JSIModuleContainerPackage;", "Lcom/facebook/react/bridge/JSIModulePackage;", "userJSIModulePackage", "(Lexpo/modules/ReactNativeHostWrapperBase;Lcom/facebook/react/bridge/JSIModulePackage;)V", "getJSIModules", "", "Lcom/facebook/react/bridge/JSIModuleSpec;", "Lcom/facebook/react/bridge/JSIModule;", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "jsContext", "Lcom/facebook/react/bridge/JavaScriptContextHolder;", "expo_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ReactNativeHostWrapperBase.kt */
    public final class JSIModuleContainerPackage implements JSIModulePackage {
        private final JSIModulePackage userJSIModulePackage;

        public JSIModuleContainerPackage(JSIModulePackage jSIModulePackage) {
            this.userJSIModulePackage = jSIModulePackage;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
            r5 = kotlin.collections.CollectionsKt.toList((r5 = r0.getJSIModules(r5, r6)));
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.List<com.facebook.react.bridge.JSIModuleSpec<com.facebook.react.bridge.JSIModule>> getJSIModules(com.facebook.react.bridge.ReactApplicationContext r5, com.facebook.react.bridge.JavaScriptContextHolder r6) {
            /*
                r4 = this;
                java.lang.String r0 = "reactApplicationContext"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "jsContext"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                expo.modules.ReactNativeHostWrapperBase r0 = expo.modules.ReactNativeHostWrapperBase.this
                java.util.List r0 = r0.getReactNativeHostHandlers$expo_release()
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                expo.modules.ReactNativeHostWrapperBase r1 = expo.modules.ReactNativeHostWrapperBase.this
                java.util.Iterator r0 = r0.iterator()
            L_0x0018:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x002c
                java.lang.Object r2 = r0.next()
                expo.modules.core.interfaces.ReactNativeHostHandler r2 = (expo.modules.core.interfaces.ReactNativeHostHandler) r2
                boolean r3 = r1.getUseDeveloperSupport()
                r2.onRegisterJSIModules(r5, r6, r3)
                goto L_0x0018
            L_0x002c:
                com.facebook.react.bridge.JSIModulePackage r0 = r4.userJSIModulePackage
                if (r0 == 0) goto L_0x003e
                java.util.List r5 = r0.getJSIModules(r5, r6)
                if (r5 == 0) goto L_0x003e
                java.lang.Iterable r5 = (java.lang.Iterable) r5
                java.util.List r5 = kotlin.collections.CollectionsKt.toList(r5)
                if (r5 != 0) goto L_0x0042
            L_0x003e:
                java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
            L_0x0042:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.ReactNativeHostWrapperBase.JSIModuleContainerPackage.getJSIModules(com.facebook.react.bridge.ReactApplicationContext, com.facebook.react.bridge.JavaScriptContextHolder):java.util.List");
        }
    }

    public final <T> T invokeDelegateMethod$expo_release(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        Method method = this.methodMap.get(str);
        if (method == null) {
            method = ReactNativeHost.class.getDeclaredMethod(str, new Class[0]);
            method.setAccessible(true);
            this.methodMap.put(str, method);
        }
        Intrinsics.checkNotNull(method);
        return method.invoke(this.host, new Object[0]);
    }

    public final void injectHostReactInstanceManager(ReactInstanceManager reactInstanceManager) {
        Intrinsics.checkNotNullParameter(reactInstanceManager, "reactInstanceManager");
        Field declaredField = ReactNativeHost.class.getDeclaredField("mReactInstanceManager");
        declaredField.setAccessible(true);
        declaredField.set(this.host, reactInstanceManager);
    }
}
