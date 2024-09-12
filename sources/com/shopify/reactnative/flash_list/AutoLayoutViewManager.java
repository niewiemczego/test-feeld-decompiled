package com.shopify.reactnative.flash_list;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0016H\u0007J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0016H\u0007J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0006H\u0007J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0006H\u0007J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0006H\u0007¨\u0006\""}, d2 = {"Lcom/shopify/reactnative/flash_list/AutoLayoutViewManager;", "Lcom/facebook/react/views/view/ReactViewManager;", "()V", "convertToPixelLayout", "", "dp", "", "density", "createViewInstance", "Lcom/facebook/react/views/view/ReactViewGroup;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "setDisableAutoLayout", "", "view", "Lcom/shopify/reactnative/flash_list/AutoLayoutView;", "disableAutoLayout", "", "setEnableInstrumentation", "enableInstrumentation", "setHorizontal", "isHorizontal", "setRenderAheadOffset", "renderOffset", "setScrollOffset", "scrollOffset", "setWindowSize", "windowSize", "Companion", "shopify_flash-list_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ReactModule(name = "AutoLayoutView")
/* compiled from: AutoLayoutViewManager.kt */
public final class AutoLayoutViewManager extends ReactViewManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "AutoLayoutView";

    public String getName() {
        return REACT_CLASS;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/shopify/reactnative/flash_list/AutoLayoutViewManager$Companion;", "", "()V", "REACT_CLASS", "", "shopify_flash-list_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AutoLayoutViewManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ReactViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        AutoLayoutView autoLayoutView = new AutoLayoutView(themedReactContext);
        autoLayoutView.setPixelDensity((double) themedReactContext.getResources().getDisplayMetrics().density);
        return autoLayoutView;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> build = MapBuilder.builder().put("onBlankAreaEvent", MapBuilder.of("registrationName", "onBlankAreaEvent")).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder<String, Any>().p…Event\")\n        ).build()");
        return build;
    }

    @ReactProp(name = "horizontal")
    public final void setHorizontal(AutoLayoutView autoLayoutView, boolean z) {
        Intrinsics.checkNotNullParameter(autoLayoutView, ViewHierarchyConstants.VIEW_KEY);
        autoLayoutView.getAlShadow().setHorizontal(z);
    }

    @ReactProp(name = "disableAutoLayout")
    public final void setDisableAutoLayout(AutoLayoutView autoLayoutView, boolean z) {
        Intrinsics.checkNotNullParameter(autoLayoutView, ViewHierarchyConstants.VIEW_KEY);
        autoLayoutView.setDisableAutoLayout(z);
    }

    @ReactProp(name = "scrollOffset")
    public final void setScrollOffset(AutoLayoutView autoLayoutView, double d) {
        Intrinsics.checkNotNullParameter(autoLayoutView, ViewHierarchyConstants.VIEW_KEY);
        autoLayoutView.getAlShadow().setScrollOffset(convertToPixelLayout(d, autoLayoutView.getPixelDensity()));
    }

    @ReactProp(name = "windowSize")
    public final void setWindowSize(AutoLayoutView autoLayoutView, double d) {
        Intrinsics.checkNotNullParameter(autoLayoutView, ViewHierarchyConstants.VIEW_KEY);
        autoLayoutView.getAlShadow().setWindowSize(convertToPixelLayout(d, autoLayoutView.getPixelDensity()));
    }

    @ReactProp(name = "renderAheadOffset")
    public final void setRenderAheadOffset(AutoLayoutView autoLayoutView, double d) {
        Intrinsics.checkNotNullParameter(autoLayoutView, ViewHierarchyConstants.VIEW_KEY);
        autoLayoutView.getAlShadow().setRenderOffset(convertToPixelLayout(d, autoLayoutView.getPixelDensity()));
    }

    @ReactProp(name = "enableInstrumentation")
    public final void setEnableInstrumentation(AutoLayoutView autoLayoutView, boolean z) {
        Intrinsics.checkNotNullParameter(autoLayoutView, ViewHierarchyConstants.VIEW_KEY);
        autoLayoutView.setEnableInstrumentation(z);
    }

    private final int convertToPixelLayout(double d, double d2) {
        return MathKt.roundToInt(d * d2);
    }
}
