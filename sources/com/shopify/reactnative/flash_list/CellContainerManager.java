package com.shopify.reactnative.flash_list;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u0010"}, d2 = {"Lcom/shopify/reactnative/flash_list/CellContainerManager;", "Lcom/facebook/react/views/view/ReactViewManager;", "()V", "createViewInstance", "Lcom/facebook/react/views/view/ReactViewGroup;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getName", "", "setIndex", "", "view", "Lcom/shopify/reactnative/flash_list/CellContainerImpl;", "index", "", "Companion", "shopify_flash-list_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ReactModule(name = "AutoLayoutView")
/* compiled from: CellContainerManager.kt */
public final class CellContainerManager extends ReactViewManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "CellContainer";

    public String getName() {
        return REACT_CLASS;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/shopify/reactnative/flash_list/CellContainerManager$Companion;", "", "()V", "REACT_CLASS", "", "shopify_flash-list_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CellContainerManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ReactViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        return new CellContainerImpl(themedReactContext);
    }

    @ReactProp(name = "index")
    public final void setIndex(CellContainerImpl cellContainerImpl, int i) {
        Intrinsics.checkNotNullParameter(cellContainerImpl, ViewHierarchyConstants.VIEW_KEY);
        cellContainerImpl.setIndex(i);
    }
}
