package expo.modules.kotlin.views;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0007R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006!"}, d2 = {"Lexpo/modules/kotlin/views/GroupViewManagerWrapper;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Landroid/view/ViewGroup;", "Lexpo/modules/kotlin/views/ViewWrapperDelegateHolder;", "viewWrapperDelegate", "Lexpo/modules/kotlin/views/ViewManagerWrapperDelegate;", "(Lexpo/modules/kotlin/views/ViewManagerWrapperDelegate;)V", "getViewWrapperDelegate", "()Lexpo/modules/kotlin/views/ViewManagerWrapperDelegate;", "addView", "", "parent", "child", "Landroid/view/View;", "index", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getChildAt", "getChildCount", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "onDropViewInstance", "view", "removeView", "removeViewAt", "setProxiedProperties", "proxiedProperties", "Lcom/facebook/react/bridge/ReadableMap;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GroupViewManagerWrapper.kt */
public final class GroupViewManagerWrapper extends ViewGroupManager<ViewGroup> implements ViewWrapperDelegateHolder {
    private final ViewManagerWrapperDelegate viewWrapperDelegate;

    public ViewManagerWrapperDelegate getViewWrapperDelegate() {
        return this.viewWrapperDelegate;
    }

    public GroupViewManagerWrapper(ViewManagerWrapperDelegate viewManagerWrapperDelegate) {
        Intrinsics.checkNotNullParameter(viewManagerWrapperDelegate, "viewWrapperDelegate");
        this.viewWrapperDelegate = viewManagerWrapperDelegate;
    }

    public String getName() {
        return "ViewManagerAdapter_" + getViewWrapperDelegate().getName();
    }

    /* access modifiers changed from: protected */
    public ViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        View createView = getViewWrapperDelegate().createView(themedReactContext);
        Intrinsics.checkNotNull(createView, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) createView;
    }

    @ReactProp(name = "proxiedProperties")
    public final void setProxiedProperties(View view, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(readableMap, "proxiedProperties");
        getViewWrapperDelegate().setProxiedProperties(view, readableMap);
    }

    public void onDropViewInstance(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, ViewHierarchyConstants.VIEW_KEY);
        View view = viewGroup;
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

    public void addView(ViewGroup viewGroup, View view, int i) {
        Unit unit;
        Function3<ViewGroup, View, Integer, Unit> addViewAction;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(view, "child");
        ViewGroupDefinition viewGroupDefinition$expo_modules_core_release = getViewWrapperDelegate().getViewGroupDefinition$expo_modules_core_release();
        if (viewGroupDefinition$expo_modules_core_release == null || (addViewAction = viewGroupDefinition$expo_modules_core_release.getAddViewAction()) == null) {
            unit = null;
        } else {
            addViewAction.invoke(viewGroup, view, Integer.valueOf(i));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            super.addView(viewGroup, view, i);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0 = r0.getGetChildCountAction();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getChildCount(android.view.ViewGroup r2) {
        /*
            r1 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            expo.modules.kotlin.views.ViewManagerWrapperDelegate r0 = r1.getViewWrapperDelegate()
            expo.modules.kotlin.views.ViewGroupDefinition r0 = r0.getViewGroupDefinition$expo_modules_core_release()
            if (r0 == 0) goto L_0x001c
            kotlin.jvm.functions.Function1 r0 = r0.getGetChildCountAction()
            if (r0 == 0) goto L_0x001c
            java.lang.Object r0 = r0.invoke(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            if (r0 != 0) goto L_0x0027
            int r2 = super.getChildCount(r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
        L_0x0027:
            java.lang.Number r0 = (java.lang.Number) r0
            int r2 = r0.intValue()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.views.GroupViewManagerWrapper.getChildCount(android.view.ViewGroup):int");
    }

    public View getChildAt(ViewGroup viewGroup, int i) {
        Function2<ViewGroup, Integer, View> getChildAtAction;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ViewGroupDefinition viewGroupDefinition$expo_modules_core_release = getViewWrapperDelegate().getViewGroupDefinition$expo_modules_core_release();
        if (viewGroupDefinition$expo_modules_core_release == null || (getChildAtAction = viewGroupDefinition$expo_modules_core_release.getGetChildAtAction()) == null) {
            return super.getChildAt(viewGroup, i);
        }
        return getChildAtAction.invoke(viewGroup, Integer.valueOf(i));
    }

    public void removeViewAt(ViewGroup viewGroup, int i) {
        Unit unit;
        Function2<ViewGroup, Integer, Unit> removeViewAtAction;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ViewGroupDefinition viewGroupDefinition$expo_modules_core_release = getViewWrapperDelegate().getViewGroupDefinition$expo_modules_core_release();
        if (viewGroupDefinition$expo_modules_core_release == null || (removeViewAtAction = viewGroupDefinition$expo_modules_core_release.getRemoveViewAtAction()) == null) {
            unit = null;
        } else {
            removeViewAtAction.invoke(viewGroup, Integer.valueOf(i));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            super.removeViewAt(viewGroup, i);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public void removeView(ViewGroup viewGroup, View view) {
        Unit unit;
        Function2<ViewGroup, View, Unit> removeViewAction;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        ViewGroupDefinition viewGroupDefinition$expo_modules_core_release = getViewWrapperDelegate().getViewGroupDefinition$expo_modules_core_release();
        if (viewGroupDefinition$expo_modules_core_release == null || (removeViewAction = viewGroupDefinition$expo_modules_core_release.getRemoveViewAction()) == null) {
            unit = null;
        } else {
            removeViewAction.invoke(viewGroup, view);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            super.removeView(viewGroup, view);
            Unit unit2 = Unit.INSTANCE;
        }
    }
}
