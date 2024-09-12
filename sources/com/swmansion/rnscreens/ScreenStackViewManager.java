package com.swmansion.rnscreens;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenStackManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenStackManagerInterface;
import com.swmansion.rnscreens.events.StackFinishTransitioningEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001%B\u0005¢\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0014J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010#\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010$H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/ScreenStack;", "Lcom/facebook/react/viewmanagers/RNSScreenStackManagerInterface;", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "addView", "", "parent", "child", "Landroid/view/View;", "index", "", "createShadowNodeInstance", "Lcom/facebook/react/uimanager/LayoutShadowNode;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getChildAt", "getChildCount", "getDelegate", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "needsCustomLayoutForChildren", "", "prepareOutTransition", "screen", "Lcom/swmansion/rnscreens/Screen;", "removeViewAt", "startTransitionRecursive", "Landroid/view/ViewGroup;", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ReactModule(name = "RNSScreenStack")
/* compiled from: ScreenStackViewManager.kt */
public final class ScreenStackViewManager extends ViewGroupManager<ScreenStack> implements RNSScreenStackManagerInterface<ScreenStack> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSScreenStack";
    private final ViewManagerDelegate<ScreenStack> delegate = new RNSScreenStackManagerDelegate(this);

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public ScreenStack createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        return new ScreenStack(themedReactContext);
    }

    public void addView(ScreenStack screenStack, View view, int i) {
        Intrinsics.checkNotNullParameter(screenStack, "parent");
        Intrinsics.checkNotNullParameter(view, "child");
        if (view instanceof Screen) {
            screenStack.addScreen((Screen) view, i);
            return;
        }
        throw new IllegalArgumentException("Attempt attach child that is not of type RNScreen".toString());
    }

    public void removeViewAt(ScreenStack screenStack, int i) {
        Intrinsics.checkNotNullParameter(screenStack, "parent");
        prepareOutTransition(screenStack.getScreenAt(i));
        screenStack.removeScreenAt(i);
    }

    private final void prepareOutTransition(Screen screen) {
        startTransitionRecursive(screen);
    }

    private final void startTransitionRecursive(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    Intrinsics.checkNotNullExpressionValue(childAt, "child");
                    viewGroup.startViewTransition(childAt);
                }
                if (childAt instanceof ScreenStackHeaderConfig) {
                    startTransitionRecursive(((ScreenStackHeaderConfig) childAt).getToolbar());
                }
                if (childAt instanceof ViewGroup) {
                    startTransitionRecursive((ViewGroup) childAt);
                }
            }
        }
    }

    public int getChildCount(ScreenStack screenStack) {
        Intrinsics.checkNotNullParameter(screenStack, "parent");
        return screenStack.getScreenCount();
    }

    public View getChildAt(ScreenStack screenStack, int i) {
        Intrinsics.checkNotNullParameter(screenStack, "parent");
        return screenStack.getScreenAt(i);
    }

    public LayoutShadowNode createShadowNodeInstance(ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "context");
        return new ScreensShadowNode(reactApplicationContext);
    }

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<ScreenStack> getDelegate() {
        return this.delegate;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.mutableMapOf(TuplesKt.to(StackFinishTransitioningEvent.EVENT_NAME, MapsKt.mutableMapOf(TuplesKt.to("registrationName", "onFinishTransitioning"))));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackViewManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenStackViewManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
