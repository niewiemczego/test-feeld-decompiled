package com.facebook.react.views.view;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001:\u0001%J4\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H&J\"\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\"\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J0\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH&J\u001a\u0010 \u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001H&J\u001a\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0001H&J&\u0010$\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006&"}, d2 = {"Lcom/facebook/react/views/view/ReactViewManagerWrapper;", "", "viewGroupManager", "Lcom/facebook/react/uimanager/ViewGroupManager;", "getViewGroupManager", "()Lcom/facebook/react/uimanager/ViewGroupManager;", "createView", "Landroid/view/View;", "reactTag", "", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "props", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "jsResponderHandler", "Lcom/facebook/react/touch/JSResponderHandler;", "getName", "", "onDropViewInstance", "", "view", "receiveCommand", "root", "commandId", "args", "Lcom/facebook/react/bridge/ReadableArray;", "setPadding", "left", "top", "right", "bottom", "updateExtraData", "extraData", "updateProperties", "viewToUpdate", "updateState", "DefaultViewManager", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReactViewManagerWrapper.kt */
public interface ReactViewManagerWrapper {
    View createView(int i, ThemedReactContext themedReactContext, Object obj, StateWrapper stateWrapper, JSResponderHandler jSResponderHandler);

    String getName();

    ViewGroupManager<?> getViewGroupManager();

    void onDropViewInstance(View view);

    void receiveCommand(View view, int i, ReadableArray readableArray);

    void receiveCommand(View view, String str, ReadableArray readableArray);

    void setPadding(View view, int i, int i2, int i3, int i4);

    void updateExtraData(View view, Object obj);

    void updateProperties(View view, Object obj);

    Object updateState(View view, Object obj, StateWrapper stateWrapper);

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0005J4\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\"\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\"\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J0\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH\u0016J\u001a\u0010$\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0018\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/facebook/react/views/view/ReactViewManagerWrapper$DefaultViewManager;", "Lcom/facebook/react/views/view/ReactViewManagerWrapper;", "viewManager", "Lcom/facebook/react/uimanager/ViewManager;", "Landroid/view/View;", "(Lcom/facebook/react/uimanager/ViewManager;)V", "viewGroupManager", "Lcom/facebook/react/uimanager/ViewGroupManager;", "getViewGroupManager", "()Lcom/facebook/react/uimanager/ViewGroupManager;", "createView", "reactTag", "", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "props", "", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "jsResponderHandler", "Lcom/facebook/react/touch/JSResponderHandler;", "getName", "", "onDropViewInstance", "", "view", "receiveCommand", "root", "commandId", "args", "Lcom/facebook/react/bridge/ReadableArray;", "setPadding", "left", "top", "right", "bottom", "updateExtraData", "extraData", "updateProperties", "viewToUpdate", "updateState", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ReactViewManagerWrapper.kt */
    public static final class DefaultViewManager implements ReactViewManagerWrapper {
        private final ViewManager<View, ?> viewManager;

        public DefaultViewManager(ViewManager<View, ?> viewManager2) {
            Intrinsics.checkNotNullParameter(viewManager2, "viewManager");
            this.viewManager = viewManager2;
        }

        public View createView(int i, ThemedReactContext themedReactContext, Object obj, StateWrapper stateWrapper, JSResponderHandler jSResponderHandler) {
            Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
            Intrinsics.checkNotNullParameter(jSResponderHandler, "jsResponderHandler");
            View createView = this.viewManager.createView(i, themedReactContext, obj instanceof ReactStylesDiffMap ? (ReactStylesDiffMap) obj : null, stateWrapper, jSResponderHandler);
            Intrinsics.checkNotNullExpressionValue(createView, "viewManager.createView(\n…pper, jsResponderHandler)");
            return createView;
        }

        public void updateProperties(View view, Object obj) {
            Intrinsics.checkNotNullParameter(view, "viewToUpdate");
            this.viewManager.updateProperties(view, obj instanceof ReactStylesDiffMap ? (ReactStylesDiffMap) obj : null);
        }

        public void receiveCommand(View view, String str, ReadableArray readableArray) {
            Intrinsics.checkNotNullParameter(view, "root");
            Intrinsics.checkNotNullParameter(str, "commandId");
            this.viewManager.receiveCommand(view, str, readableArray);
        }

        public void receiveCommand(View view, int i, ReadableArray readableArray) {
            Intrinsics.checkNotNullParameter(view, "root");
            this.viewManager.receiveCommand(view, i, readableArray);
        }

        public void setPadding(View view, int i, int i2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            this.viewManager.setPadding(view, i, i2, i3, i4);
        }

        public Object updateState(View view, Object obj, StateWrapper stateWrapper) {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            return this.viewManager.updateState(view, obj instanceof ReactStylesDiffMap ? (ReactStylesDiffMap) obj : null, stateWrapper);
        }

        public void updateExtraData(View view, Object obj) {
            Intrinsics.checkNotNullParameter(view, "root");
            this.viewManager.updateExtraData(view, obj);
        }

        public void onDropViewInstance(View view) {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            this.viewManager.onDropViewInstance(view);
        }

        public String getName() {
            String name = this.viewManager.getName();
            Intrinsics.checkNotNullExpressionValue(name, "viewManager.name");
            return name;
        }

        public ViewGroupManager<?> getViewGroupManager() {
            return (ViewGroupManager) this.viewManager;
        }
    }
}
