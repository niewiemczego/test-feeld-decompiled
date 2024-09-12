package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.UIManagerModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/swmansion/rnscreens/ScreensShadowNode;", "Lcom/facebook/react/uimanager/LayoutShadowNode;", "context", "Lcom/facebook/react/bridge/ReactContext;", "(Lcom/facebook/react/bridge/ReactContext;)V", "onBeforeLayout", "", "nativeViewHierarchyOptimizer", "Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ScreensShadowNode.kt */
public final class ScreensShadowNode extends LayoutShadowNode {
    private ReactContext context;

    public ScreensShadowNode(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "context");
        this.context = reactContext;
    }

    public void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        Intrinsics.checkNotNullParameter(nativeViewHierarchyOptimizer, "nativeViewHierarchyOptimizer");
        super.onBeforeLayout(nativeViewHierarchyOptimizer);
        UIManagerModule uIManagerModule = (UIManagerModule) this.context.getNativeModule(UIManagerModule.class);
        if (uIManagerModule != null) {
            uIManagerModule.addUIBlock(new ScreensShadowNode$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBeforeLayout$lambda-0  reason: not valid java name */
    public static final void m661onBeforeLayout$lambda0(ScreensShadowNode screensShadowNode, NativeViewHierarchyManager nativeViewHierarchyManager) {
        Intrinsics.checkNotNullParameter(screensShadowNode, "this$0");
        Intrinsics.checkNotNullParameter(nativeViewHierarchyManager, "nativeViewHierarchyManager");
        View resolveView = nativeViewHierarchyManager.resolveView(screensShadowNode.getReactTag());
        if (resolveView instanceof ScreenContainer) {
            ((ScreenContainer) resolveView).performUpdates();
        }
    }
}
