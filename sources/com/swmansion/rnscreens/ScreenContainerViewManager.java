package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u001b"}, d2 = {"Lcom/swmansion/rnscreens/ScreenContainerViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/ScreenContainer;", "()V", "addView", "", "parent", "child", "Landroid/view/View;", "index", "", "createShadowNodeInstance", "Lcom/facebook/react/uimanager/LayoutShadowNode;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getChildAt", "getChildCount", "getName", "", "needsCustomLayoutForChildren", "", "removeAllViews", "removeViewAt", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ReactModule(name = "RNSScreenContainer")
/* compiled from: ScreenContainerViewManager.kt */
public final class ScreenContainerViewManager extends ViewGroupManager<ScreenContainer> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSScreenContainer";

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public ScreenContainer createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        return new ScreenContainer(themedReactContext);
    }

    public void addView(ScreenContainer screenContainer, View view, int i) {
        Intrinsics.checkNotNullParameter(screenContainer, "parent");
        Intrinsics.checkNotNullParameter(view, "child");
        if (view instanceof Screen) {
            screenContainer.addScreen((Screen) view, i);
            return;
        }
        throw new IllegalArgumentException("Attempt attach child that is not of type RNScreens".toString());
    }

    public void removeViewAt(ScreenContainer screenContainer, int i) {
        Intrinsics.checkNotNullParameter(screenContainer, "parent");
        screenContainer.removeScreenAt(i);
    }

    public void removeAllViews(ScreenContainer screenContainer) {
        Intrinsics.checkNotNullParameter(screenContainer, "parent");
        screenContainer.removeAllScreens();
    }

    public int getChildCount(ScreenContainer screenContainer) {
        Intrinsics.checkNotNullParameter(screenContainer, "parent");
        return screenContainer.getScreenCount();
    }

    public View getChildAt(ScreenContainer screenContainer, int i) {
        Intrinsics.checkNotNullParameter(screenContainer, "parent");
        return screenContainer.getScreenAt(i);
    }

    public LayoutShadowNode createShadowNodeInstance(ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "context");
        return new ScreensShadowNode(reactApplicationContext);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/ScreenContainerViewManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenContainerViewManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
