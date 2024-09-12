package com.swmansion.gesturehandler.react;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.gesturehandler.core.PointerEventsConfig;
import com.swmansion.gesturehandler.core.ViewConfigurationHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNViewConfigurationHelper;", "Lcom/swmansion/gesturehandler/core/ViewConfigurationHelper;", "()V", "getChildInDrawingOrderAtIndex", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "index", "", "getPointerEventsConfigForView", "Lcom/swmansion/gesturehandler/core/PointerEventsConfig;", "view", "isViewClippingChildren", "", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RNViewConfigurationHelper.kt */
public final class RNViewConfigurationHelper implements ViewConfigurationHelper {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RNViewConfigurationHelper.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEvents.values().length];
            iArr[PointerEvents.BOX_ONLY.ordinal()] = 1;
            iArr[PointerEvents.BOX_NONE.ordinal()] = 2;
            iArr[PointerEvents.NONE.ordinal()] = 3;
            iArr[PointerEvents.AUTO.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PointerEventsConfig getPointerEventsConfigForView(View view) {
        PointerEvents pointerEvents;
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        if (view instanceof ReactPointerEventsView) {
            pointerEvents = ((ReactPointerEventsView) view).getPointerEvents();
            Intrinsics.checkNotNullExpressionValue(pointerEvents, "{\n        (view as React…ew).pointerEvents\n      }");
        } else {
            pointerEvents = PointerEvents.AUTO;
        }
        if (!view.isEnabled()) {
            if (pointerEvents == PointerEvents.AUTO) {
                return PointerEventsConfig.BOX_NONE;
            }
            if (pointerEvents == PointerEvents.BOX_ONLY) {
                return PointerEventsConfig.NONE;
            }
        }
        int i = WhenMappings.$EnumSwitchMapping$0[pointerEvents.ordinal()];
        if (i == 1) {
            return PointerEventsConfig.BOX_ONLY;
        }
        if (i == 2) {
            return PointerEventsConfig.BOX_NONE;
        }
        if (i == 3) {
            return PointerEventsConfig.NONE;
        }
        if (i == 4) {
            return PointerEventsConfig.AUTO;
        }
        throw new NoWhenBranchMatchedException();
    }

    public View getChildInDrawingOrderAtIndex(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (viewGroup instanceof ReactViewGroup) {
            View childAt = viewGroup.getChildAt(((ReactViewGroup) viewGroup).getZIndexMappedChildIndex(i));
            Intrinsics.checkNotNullExpressionValue(childAt, "{\n      parent.getChildA…dChildIndex(index))\n    }");
            return childAt;
        }
        View childAt2 = viewGroup.getChildAt(i);
        Intrinsics.checkNotNullExpressionValue(childAt2, "parent.getChildAt(index)");
        return childAt2;
    }

    public boolean isViewClippingChildren(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, ViewHierarchyConstants.VIEW_KEY);
        if (viewGroup.getClipChildren()) {
            return true;
        }
        if (viewGroup instanceof ReactViewGroup) {
            return Intrinsics.areEqual((Object) ViewProps.HIDDEN, (Object) ((ReactViewGroup) viewGroup).getOverflow());
        }
        return false;
    }
}
