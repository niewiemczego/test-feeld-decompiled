package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001eH\u0017J\b\u0010!\u001a\u00020\u0011H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaViewShadowNode;", "Lcom/facebook/react/uimanager/LayoutShadowNode;", "()V", "mLocalData", "Lcom/th3rdwave/safeareacontext/SafeAreaViewLocalData;", "mMargins", "", "mNeedsUpdate", "", "mPaddings", "getEdgeValue", "", "edgeMode", "Lcom/th3rdwave/safeareacontext/SafeAreaViewEdgeModes;", "insetValue", "edgeValue", "onBeforeLayout", "", "nativeViewHierarchyOptimizer", "Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;", "resetInsets", "mode", "Lcom/th3rdwave/safeareacontext/SafeAreaViewMode;", "setLocalData", "data", "", "setMargins", "index", "", "margin", "Lcom/facebook/react/bridge/Dynamic;", "setPaddings", "padding", "updateInsets", "react-native-safe-area-context_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SafeAreaViewShadowNode.kt */
public final class SafeAreaViewShadowNode extends LayoutShadowNode {
    private SafeAreaViewLocalData mLocalData;
    private final float[] mMargins = new float[ViewProps.PADDING_MARGIN_SPACING_TYPES.length];
    private boolean mNeedsUpdate;
    private final float[] mPaddings = new float[ViewProps.PADDING_MARGIN_SPACING_TYPES.length];

    public SafeAreaViewShadowNode() {
        int length = ViewProps.PADDING_MARGIN_SPACING_TYPES.length;
        for (int i = 0; i < length; i++) {
            this.mPaddings[i] = Float.NaN;
            this.mMargins[i] = Float.NaN;
        }
    }

    private final void updateInsets() {
        float f;
        float f2;
        SafeAreaViewLocalData safeAreaViewLocalData = this.mLocalData;
        if (safeAreaViewLocalData != null) {
            float[] fArr = safeAreaViewLocalData.getMode() == SafeAreaViewMode.PADDING ? this.mPaddings : this.mMargins;
            float f3 = fArr[8];
            float f4 = 0.0f;
            if (!Float.isNaN(f3)) {
                f2 = f3;
                f4 = f2;
                f = f4;
            } else {
                f3 = 0.0f;
                f2 = 0.0f;
                f = 0.0f;
            }
            float f5 = fArr[7];
            if (!Float.isNaN(f5)) {
                f3 = f5;
                f2 = f3;
            }
            float f6 = fArr[6];
            if (!Float.isNaN(f6)) {
                f4 = f6;
                f = f4;
            }
            float f7 = fArr[1];
            if (!Float.isNaN(f7)) {
                f3 = f7;
            }
            float f8 = fArr[2];
            if (!Float.isNaN(f8)) {
                f4 = f8;
            }
            float f9 = fArr[3];
            if (!Float.isNaN(f9)) {
                f2 = f9;
            }
            float f10 = fArr[0];
            if (!Float.isNaN(f10)) {
                f = f10;
            }
            float pixelFromDIP = PixelUtil.toPixelFromDIP(f3);
            float pixelFromDIP2 = PixelUtil.toPixelFromDIP(f4);
            float pixelFromDIP3 = PixelUtil.toPixelFromDIP(f2);
            float pixelFromDIP4 = PixelUtil.toPixelFromDIP(f);
            SafeAreaViewEdges edges = safeAreaViewLocalData.getEdges();
            EdgeInsets insets = safeAreaViewLocalData.getInsets();
            if (safeAreaViewLocalData.getMode() == SafeAreaViewMode.PADDING) {
                super.setPadding(1, getEdgeValue(edges.getTop(), insets.getTop(), pixelFromDIP));
                super.setPadding(2, getEdgeValue(edges.getRight(), insets.getRight(), pixelFromDIP2));
                super.setPadding(3, getEdgeValue(edges.getBottom(), insets.getBottom(), pixelFromDIP3));
                super.setPadding(0, getEdgeValue(edges.getLeft(), insets.getLeft(), pixelFromDIP4));
                return;
            }
            super.setMargin(1, getEdgeValue(edges.getTop(), insets.getTop(), pixelFromDIP));
            super.setMargin(2, getEdgeValue(edges.getRight(), insets.getRight(), pixelFromDIP2));
            super.setMargin(3, getEdgeValue(edges.getBottom(), insets.getBottom(), pixelFromDIP3));
            super.setMargin(0, getEdgeValue(edges.getLeft(), insets.getLeft(), pixelFromDIP4));
        }
    }

    private final float getEdgeValue(SafeAreaViewEdgeModes safeAreaViewEdgeModes, float f, float f2) {
        if (safeAreaViewEdgeModes == SafeAreaViewEdgeModes.OFF) {
            return f2;
        }
        return safeAreaViewEdgeModes == SafeAreaViewEdgeModes.MAXIMUM ? Math.max(f, f2) : f + f2;
    }

    private final void resetInsets(SafeAreaViewMode safeAreaViewMode) {
        if (safeAreaViewMode == SafeAreaViewMode.PADDING) {
            super.setPadding(1, this.mPaddings[1]);
            super.setPadding(2, this.mPaddings[1]);
            super.setPadding(3, this.mPaddings[3]);
            super.setPadding(0, this.mPaddings[0]);
        } else {
            super.setMargin(1, this.mMargins[1]);
            super.setMargin(2, this.mMargins[1]);
            super.setMargin(3, this.mMargins[3]);
            super.setMargin(0, this.mMargins[0]);
        }
        markUpdated();
    }

    public void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        Intrinsics.checkNotNullParameter(nativeViewHierarchyOptimizer, "nativeViewHierarchyOptimizer");
        if (this.mNeedsUpdate) {
            this.mNeedsUpdate = false;
            updateInsets();
        }
    }

    public void setLocalData(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        if (obj instanceof SafeAreaViewLocalData) {
            SafeAreaViewLocalData safeAreaViewLocalData = this.mLocalData;
            if (!(safeAreaViewLocalData == null || safeAreaViewLocalData.getMode() == ((SafeAreaViewLocalData) obj).getMode())) {
                resetInsets(safeAreaViewLocalData.getMode());
            }
            this.mLocalData = (SafeAreaViewLocalData) obj;
            this.mNeedsUpdate = false;
            updateInsets();
        }
    }

    @ReactPropGroup(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i, Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, ViewProps.PADDING);
        this.mPaddings[ViewProps.PADDING_MARGIN_SPACING_TYPES[i]] = dynamic.getType() == ReadableType.Number ? (float) dynamic.asDouble() : Float.NaN;
        super.setPaddings(i, dynamic);
        this.mNeedsUpdate = true;
    }

    @ReactPropGroup(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i, Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, ViewProps.MARGIN);
        this.mMargins[ViewProps.PADDING_MARGIN_SPACING_TYPES[i]] = dynamic.getType() == ReadableType.Number ? (float) dynamic.asDouble() : Float.NaN;
        super.setMargins(i, dynamic);
        this.mNeedsUpdate = true;
    }
}
