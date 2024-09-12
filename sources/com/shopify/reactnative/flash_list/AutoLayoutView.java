package com.shopify.reactnative.flash_list;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\"H\u0002J\n\u0010#\u001a\u0004\u0018\u00010 H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/shopify/reactnative/flash_list/AutoLayoutView;", "Lcom/facebook/react/views/view/ReactViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alShadow", "Lcom/shopify/reactnative/flash_list/AutoLayoutShadow;", "getAlShadow", "()Lcom/shopify/reactnative/flash_list/AutoLayoutShadow;", "disableAutoLayout", "", "getDisableAutoLayout", "()Z", "setDisableAutoLayout", "(Z)V", "enableInstrumentation", "getEnableInstrumentation", "setEnableInstrumentation", "pixelDensity", "", "getPixelDensity", "()D", "setPixelDensity", "(D)V", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "emitBlankAreaEvent", "fixFooter", "fixLayout", "getFooter", "Landroid/view/View;", "getFooterDiff", "", "getParentScrollView", "shopify_flash-list_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AutoLayoutView.kt */
public final class AutoLayoutView extends ReactViewGroup {
    private final AutoLayoutShadow alShadow = new AutoLayoutShadow();
    private boolean disableAutoLayout;
    private boolean enableInstrumentation;
    private double pixelDensity = 1.0d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoLayoutView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final AutoLayoutShadow getAlShadow() {
        return this.alShadow;
    }

    public final boolean getEnableInstrumentation() {
        return this.enableInstrumentation;
    }

    public final void setEnableInstrumentation(boolean z) {
        this.enableInstrumentation = z;
    }

    public final boolean getDisableAutoLayout() {
        return this.disableAutoLayout;
    }

    public final void setDisableAutoLayout(boolean z) {
        this.disableAutoLayout = z;
    }

    public final double getPixelDensity() {
        return this.pixelDensity;
    }

    public final void setPixelDensity(double d) {
        this.pixelDensity = d;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        fixLayout();
        fixFooter();
        super.dispatchDraw(canvas);
        View parentScrollView = getParentScrollView();
        if (this.enableInstrumentation && parentScrollView != null) {
            int width = this.alShadow.getHorizontal() ? parentScrollView.getWidth() : parentScrollView.getHeight();
            int scrollX = this.alShadow.getHorizontal() ? parentScrollView.getScrollX() : parentScrollView.getScrollY();
            this.alShadow.computeBlankFromGivenOffset(scrollX, Math.max((this.alShadow.getHorizontal() ? getLeft() : getTop()) - scrollX, 0), Math.max((width + scrollX) - (this.alShadow.getHorizontal() ? getRight() : getBottom()), 0));
            emitBlankAreaEvent();
        }
    }

    private final void fixLayout() {
        if (getChildCount() > 1 && !this.disableAutoLayout) {
            int i = 0;
            int childCount = getChildCount();
            CellContainer[] cellContainerArr = new CellContainer[childCount];
            while (i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof CellContainer) {
                    cellContainerArr[i] = (CellContainer) childAt;
                    i++;
                } else {
                    throw new IllegalStateException("CellRendererComponent outer view should always be CellContainer. Learn more here: https://shopify.github.io/flash-list/docs/usage#cellrenderercomponent.");
                }
            }
            if (childCount > 1) {
                ArraysKt.sortWith(cellContainerArr, new AutoLayoutView$fixLayout$$inlined$sortBy$1());
            }
            AutoLayoutShadow autoLayoutShadow = this.alShadow;
            autoLayoutShadow.setOffsetFromStart(autoLayoutShadow.getHorizontal() ? getLeft() : getTop());
            this.alShadow.clearGapsAndOverlaps(cellContainerArr);
        }
    }

    private final void fixFooter() {
        View parentScrollView = getParentScrollView();
        if (!this.disableAutoLayout && parentScrollView != null) {
            boolean z = true;
            if (!this.alShadow.getHorizontal() ? getBottom() > parentScrollView.getHeight() : getRight() > parentScrollView.getWidth()) {
                z = false;
            }
            if (z) {
                ViewParent parent = getParent();
                View view = parent instanceof View ? (View) parent : null;
                View footer = getFooter();
                int footerDiff = getFooterDiff();
                if (footerDiff != 0 && footer != null && view != null) {
                    if (this.alShadow.getHorizontal()) {
                        footer.offsetLeftAndRight(footerDiff);
                        setRight(getRight() + footerDiff);
                        view.setRight(view.getRight() + footerDiff);
                        return;
                    }
                    footer.offsetTopAndBottom(footerDiff);
                    setBottom(getBottom() + footerDiff);
                    view.setBottom(view.getBottom() + footerDiff);
                }
            }
        }
    }

    private final int getFooterDiff() {
        int i;
        int i2;
        int i3;
        if (getChildCount() == 0) {
            this.alShadow.setLastMaxBoundOverall(0);
        } else if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            AutoLayoutShadow autoLayoutShadow = this.alShadow;
            if (autoLayoutShadow.getHorizontal()) {
                i3 = childAt.getRight();
            } else {
                i3 = childAt.getBottom();
            }
            autoLayoutShadow.setLastMaxBoundOverall(i3);
        }
        if (this.alShadow.getHorizontal()) {
            i2 = getRight();
            i = getLeft();
        } else {
            i2 = getBottom();
            i = getTop();
        }
        return this.alShadow.getLastMaxBoundOverall() - (i2 - i);
    }

    private final View getFooter() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof CellContainer) && ((CellContainer) childAt).getIndex() == -1) {
                return childAt;
            }
        }
        return null;
    }

    private final View getParentScrollView() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if ((parent instanceof ScrollView) || (parent instanceof HorizontalScrollView)) {
                return (View) parent;
            }
        }
        return null;
    }

    private final void emitBlankAreaEvent() {
        WritableMap createMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(createMap, "createMap()");
        createMap.putDouble("offsetStart", ((double) this.alShadow.getBlankOffsetAtStart()) / this.pixelDensity);
        createMap.putDouble("offsetEnd", ((double) this.alShadow.getBlankOffsetAtEnd()) / this.pixelDensity);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ((RCTEventEmitter) ((ReactContext) context).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "onBlankAreaEvent", createMap);
    }
}
