package expo.modules.kotlin.views;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0016\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0007R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lexpo/modules/kotlin/views/SimpleViewManagerWrapper;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Landroid/view/View;", "Lexpo/modules/kotlin/views/ViewWrapperDelegateHolder;", "viewWrapperDelegate", "Lexpo/modules/kotlin/views/ViewManagerWrapperDelegate;", "(Lexpo/modules/kotlin/views/ViewManagerWrapperDelegate;)V", "getViewWrapperDelegate", "()Lexpo/modules/kotlin/views/ViewManagerWrapperDelegate;", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "onDropViewInstance", "", "view", "setProxiedProperties", "proxiedProperties", "Lcom/facebook/react/bridge/ReadableMap;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SimpleViewManagerWrapper.kt */
public final class SimpleViewManagerWrapper extends SimpleViewManager<View> implements ViewWrapperDelegateHolder {
    private final ViewManagerWrapperDelegate viewWrapperDelegate;

    public ViewManagerWrapperDelegate getViewWrapperDelegate() {
        return this.viewWrapperDelegate;
    }

    public SimpleViewManagerWrapper(ViewManagerWrapperDelegate viewManagerWrapperDelegate) {
        Intrinsics.checkNotNullParameter(viewManagerWrapperDelegate, "viewWrapperDelegate");
        this.viewWrapperDelegate = viewManagerWrapperDelegate;
    }

    public String getName() {
        return "ViewManagerAdapter_" + getViewWrapperDelegate().getName();
    }

    /* access modifiers changed from: protected */
    public View createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        return getViewWrapperDelegate().createView(themedReactContext);
    }

    @ReactProp(name = "proxiedProperties")
    public final void setProxiedProperties(View view, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(readableMap, "proxiedProperties");
        getViewWrapperDelegate().setProxiedProperties(view, readableMap);
    }

    public void onDropViewInstance(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onDropViewInstance(view);
        getViewWrapperDelegate().onDestroy(view);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = getViewWrapperDelegate().getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            return super.getExportedCustomDirectEventTypeConstants();
        }
        Map<String, Object> exportedCustomDirectEventTypeConstants2 = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants2 == null) {
            exportedCustomDirectEventTypeConstants2 = MapsKt.emptyMap();
        } else {
            Intrinsics.checkNotNullExpressionValue(exportedCustomDirectEventTypeConstants2, "super.getExportedCustomD…Constants() ?: emptyMap()");
        }
        MapBuilder.Builder builder = MapBuilder.builder();
        for (Map.Entry next : exportedCustomDirectEventTypeConstants2.entrySet()) {
            builder.put(next.getKey(), next.getValue());
        }
        for (Map.Entry next2 : exportedCustomDirectEventTypeConstants.entrySet()) {
            builder.put(next2.getKey(), next2.getValue());
        }
        return builder.build();
    }
}
