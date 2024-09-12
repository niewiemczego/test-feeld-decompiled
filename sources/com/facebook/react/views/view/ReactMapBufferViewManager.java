package com.facebook.react.views.view;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0016J\"\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\"\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J0\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH\u0016J\u001a\u0010$\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/facebook/react/views/view/ReactMapBufferViewManager;", "Lcom/facebook/react/views/view/ReactViewManagerWrapper;", "()V", "viewGroupManager", "Lcom/facebook/react/uimanager/ViewGroupManager;", "getViewGroupManager", "()Lcom/facebook/react/uimanager/ViewGroupManager;", "viewManager", "Lcom/facebook/react/views/view/ReactViewManager;", "createView", "Landroid/view/View;", "reactTag", "", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "props", "", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "jsResponderHandler", "Lcom/facebook/react/touch/JSResponderHandler;", "getName", "", "onDropViewInstance", "", "view", "receiveCommand", "root", "commandId", "args", "Lcom/facebook/react/bridge/ReadableArray;", "setPadding", "left", "top", "right", "bottom", "updateExtraData", "extraData", "updateProperties", "viewToUpdate", "updateState", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReactMapBufferViewManager.kt */
public final class ReactMapBufferViewManager implements ReactViewManagerWrapper {
    public static final ReactMapBufferViewManager INSTANCE = new ReactMapBufferViewManager();
    private static final ReactViewManager viewManager = new ReactViewManager();

    public Object updateState(View view, Object obj, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        return null;
    }

    private ReactMapBufferViewManager() {
    }

    public View createView(int i, ThemedReactContext themedReactContext, Object obj, StateWrapper stateWrapper, JSResponderHandler jSResponderHandler) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        Intrinsics.checkNotNullParameter(jSResponderHandler, "jsResponderHandler");
        View createView = viewManager.createView(i, themedReactContext, obj instanceof ReactStylesDiffMap ? (ReactStylesDiffMap) obj : null, stateWrapper, jSResponderHandler);
        ReactViewGroup reactViewGroup = (ReactViewGroup) createView;
        if (obj instanceof ReadableMapBuffer) {
            ReactMapBufferViewManager reactMapBufferViewManager = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(reactViewGroup, ViewHierarchyConstants.VIEW_KEY);
            reactMapBufferViewManager.updateProperties(reactViewGroup, obj);
        }
        Intrinsics.checkNotNullExpressionValue(createView, "viewManager\n          .c…            }\n          }");
        return createView;
    }

    public void updateProperties(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "viewToUpdate");
        if (!(obj instanceof ReadableMapBuffer)) {
            viewManager.updateProperties((ReactViewGroup) view, obj instanceof ReactStylesDiffMap ? (ReactStylesDiffMap) obj : null);
        } else {
            ReactMapBufferPropSetter.INSTANCE.setProps((ReactViewGroup) view, viewManager, (MapBuffer) obj);
        }
    }

    public void receiveCommand(View view, String str, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "root");
        Intrinsics.checkNotNullParameter(str, "commandId");
        viewManager.receiveCommand((ReactViewGroup) view, str, readableArray);
    }

    public void receiveCommand(View view, int i, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "root");
        viewManager.receiveCommand((ReactViewGroup) view, i, readableArray);
    }

    public void setPadding(View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        viewManager.setPadding((ReactViewGroup) view, i, i2, i3, i4);
    }

    public void updateExtraData(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "root");
        viewManager.updateExtraData((ReactViewGroup) view, obj);
    }

    public void onDropViewInstance(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        viewManager.onDropViewInstance((ReactViewGroup) view);
    }

    public String getName() {
        String name = viewManager.getName();
        Intrinsics.checkNotNullExpressionValue(name, "viewManager.name");
        return name;
    }

    public ViewGroupManager<?> getViewGroupManager() {
        return viewManager;
    }
}
