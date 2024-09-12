package com.th3rdwave.safeareacontext;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNCSafeAreaViewManagerInterface;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0017J\u001a\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0017J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016¨\u0006\u001f"}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaViewManager;", "Lcom/facebook/react/views/view/ReactViewManager;", "Lcom/facebook/react/viewmanagers/RNCSafeAreaViewManagerInterface;", "Lcom/th3rdwave/safeareacontext/SafeAreaView;", "()V", "createShadowNodeInstance", "Lcom/th3rdwave/safeareacontext/SafeAreaViewShadowNode;", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "Lcom/facebook/react/views/view/ReactViewGroup;", "getName", "", "getShadowNodeClass", "Ljava/lang/Class;", "setEdges", "", "view", "propList", "Lcom/facebook/react/bridge/ReadableMap;", "setMode", "mode", "updateState", "", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "Companion", "react-native-safe-area-context_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ReactModule(name = "RNCSafeAreaView")
/* compiled from: SafeAreaViewManager.kt */
public final class SafeAreaViewManager extends ReactViewManager implements RNCSafeAreaViewManagerInterface<SafeAreaView> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNCSafeAreaView";

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<ReactViewGroup> getDelegate() {
        return null;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class<SafeAreaViewShadowNode> getShadowNodeClass() {
        return SafeAreaViewShadowNode.class;
    }

    public SafeAreaView createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        return new SafeAreaView(themedReactContext);
    }

    public SafeAreaViewShadowNode createShadowNodeInstance() {
        return new SafeAreaViewShadowNode();
    }

    @ReactProp(name = "mode")
    public void setMode(SafeAreaView safeAreaView, String str) {
        Intrinsics.checkNotNullParameter(safeAreaView, ViewHierarchyConstants.VIEW_KEY);
        if (Intrinsics.areEqual((Object) str, (Object) ViewProps.PADDING)) {
            safeAreaView.setMode(SafeAreaViewMode.PADDING);
        } else if (Intrinsics.areEqual((Object) str, (Object) ViewProps.MARGIN)) {
            safeAreaView.setMode(SafeAreaViewMode.MARGIN);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        if (r2 == null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
        if (r3 == null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        if (r7 == null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
        if (r0 == null) goto L_0x0020;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "edges")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setEdges(com.th3rdwave.safeareacontext.SafeAreaView r6, com.facebook.react.bridge.ReadableMap r7) {
        /*
            r5 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            if (r7 == 0) goto L_0x0075
            java.lang.String r0 = "top"
            java.lang.String r0 = r7.getString(r0)
            java.lang.String r1 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            if (r0 == 0) goto L_0x0020
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toUpperCase(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes r0 = com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes.valueOf(r0)
            if (r0 != 0) goto L_0x0022
        L_0x0020:
            com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes r0 = com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes.OFF
        L_0x0022:
            java.lang.String r2 = "right"
            java.lang.String r2 = r7.getString(r2)
            if (r2 == 0) goto L_0x0039
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r2 = r2.toUpperCase(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes r2 = com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes.valueOf(r2)
            if (r2 != 0) goto L_0x003b
        L_0x0039:
            com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes r2 = com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes.OFF
        L_0x003b:
            java.lang.String r3 = "bottom"
            java.lang.String r3 = r7.getString(r3)
            if (r3 == 0) goto L_0x0052
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toUpperCase(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes r3 = com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes.valueOf(r3)
            if (r3 != 0) goto L_0x0054
        L_0x0052:
            com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes r3 = com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes.OFF
        L_0x0054:
            java.lang.String r4 = "left"
            java.lang.String r7 = r7.getString(r4)
            if (r7 == 0) goto L_0x006b
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r7 = r7.toUpperCase(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes r7 = com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes.valueOf(r7)
            if (r7 != 0) goto L_0x006d
        L_0x006b:
            com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes r7 = com.th3rdwave.safeareacontext.SafeAreaViewEdgeModes.OFF
        L_0x006d:
            com.th3rdwave.safeareacontext.SafeAreaViewEdges r1 = new com.th3rdwave.safeareacontext.SafeAreaViewEdges
            r1.<init>(r0, r2, r3, r7)
            r6.setEdges(r1)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.th3rdwave.safeareacontext.SafeAreaViewManager.setEdges(com.th3rdwave.safeareacontext.SafeAreaView, com.facebook.react.bridge.ReadableMap):void");
    }

    public Object updateState(ReactViewGroup reactViewGroup, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(reactViewGroup, ViewHierarchyConstants.VIEW_KEY);
        ((SafeAreaView) reactViewGroup).setStateWrapper(stateWrapper);
        return null;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaViewManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-safe-area-context_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SafeAreaViewManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
