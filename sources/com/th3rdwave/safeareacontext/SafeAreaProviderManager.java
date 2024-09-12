package com.th3rdwave.safeareacontext;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.viewmanagers.RNCSafeAreaProviderManagerDelegate;
import com.facebook.react.viewmanagers.RNCSafeAreaProviderManagerInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J$\u0010\u000f\u001a\u001e\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00000\u00000\u0006H\u0014J \u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00110\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R*\u0010\u0005\u001a\u001e\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00000\u00000\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaProviderManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/th3rdwave/safeareacontext/SafeAreaProvider;", "Lcom/facebook/react/viewmanagers/RNCSafeAreaProviderManagerInterface;", "()V", "mDelegate", "Lcom/facebook/react/viewmanagers/RNCSafeAreaProviderManagerDelegate;", "kotlin.jvm.PlatformType", "addEventEmitters", "", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "view", "createViewInstance", "context", "getDelegate", "getExportedCustomDirectEventTypeConstants", "", "", "getName", "Companion", "react-native-safe-area-context_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ReactModule(name = "RNCSafeAreaProvider")
/* compiled from: SafeAreaProviderManager.kt */
public final class SafeAreaProviderManager extends ViewGroupManager<SafeAreaProvider> implements RNCSafeAreaProviderManagerInterface<SafeAreaProvider> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNCSafeAreaProvider";
    private final RNCSafeAreaProviderManagerDelegate<SafeAreaProvider, SafeAreaProviderManager> mDelegate = new RNCSafeAreaProviderManagerDelegate<>(this);

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public RNCSafeAreaProviderManagerDelegate<SafeAreaProvider, SafeAreaProviderManager> getDelegate() {
        return this.mDelegate;
    }

    public SafeAreaProvider createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        return new SafeAreaProvider(themedReactContext);
    }

    public Map<String, Map<String, String>> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.mutableMapOf(TuplesKt.to(InsetsChangeEvent.EVENT_NAME, MapsKt.mutableMapOf(TuplesKt.to("registrationName", "onInsetsChange"))));
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, SafeAreaProvider safeAreaProvider) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        Intrinsics.checkNotNullParameter(safeAreaProvider, ViewHierarchyConstants.VIEW_KEY);
        super.addEventEmitters(themedReactContext, safeAreaProvider);
        safeAreaProvider.setOnInsetsChangeHandler(SafeAreaProviderManager$addEventEmitters$1.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaProviderManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-safe-area-context_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SafeAreaProviderManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
