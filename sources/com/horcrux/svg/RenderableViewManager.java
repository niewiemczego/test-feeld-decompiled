package com.horcrux.svg;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSVGCircleManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGCircleManagerInterface;
import com.facebook.react.viewmanagers.RNSVGClipPathManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface;
import com.facebook.react.viewmanagers.RNSVGDefsManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGDefsManagerInterface;
import com.facebook.react.viewmanagers.RNSVGEllipseManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface;
import com.facebook.react.viewmanagers.RNSVGForeignObjectManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface;
import com.facebook.react.viewmanagers.RNSVGGroupManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGGroupManagerInterface;
import com.facebook.react.viewmanagers.RNSVGImageManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGImageManagerInterface;
import com.facebook.react.viewmanagers.RNSVGLineManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGLineManagerInterface;
import com.facebook.react.viewmanagers.RNSVGLinearGradientManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface;
import com.facebook.react.viewmanagers.RNSVGMarkerManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface;
import com.facebook.react.viewmanagers.RNSVGMaskManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGMaskManagerInterface;
import com.facebook.react.viewmanagers.RNSVGPathManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGPathManagerInterface;
import com.facebook.react.viewmanagers.RNSVGPatternManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGPatternManagerInterface;
import com.facebook.react.viewmanagers.RNSVGRadialGradientManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface;
import com.facebook.react.viewmanagers.RNSVGRectManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGRectManagerInterface;
import com.facebook.react.viewmanagers.RNSVGSymbolManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface;
import com.facebook.react.viewmanagers.RNSVGTSpanManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface;
import com.facebook.react.viewmanagers.RNSVGTextManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGTextManagerInterface;
import com.facebook.react.viewmanagers.RNSVGTextPathManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface;
import com.facebook.react.viewmanagers.RNSVGUseManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGUseManagerInterface;
import com.horcrux.svg.RenderableView;
import com.horcrux.svg.VirtualViewManager;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class RenderableViewManager<T extends RenderableView> extends VirtualViewManager<T> {
    RenderableViewManager(VirtualViewManager.SVGClass sVGClass) {
        super(sVGClass);
    }

    static class GroupViewManagerAbstract<U extends GroupView> extends RenderableViewManager<U> {
        GroupViewManagerAbstract(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
        }

        @ReactProp(name = "font")
        public void setFont(U u, @Nullable ReadableMap readableMap) {
            u.setFont(readableMap);
        }

        @ReactProp(name = "fontSize")
        public void setFontSize(U u, Dynamic dynamic) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()];
            if (i == 1) {
                javaOnlyMap.putDouble("fontSize", dynamic.asDouble());
            } else if (i == 2) {
                javaOnlyMap.putString("fontSize", dynamic.asString());
            } else {
                return;
            }
            u.setFont(javaOnlyMap);
        }

        public void setFontSize(U u, @Nullable String str) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.putString("fontSize", str);
            u.setFont(javaOnlyMap);
        }

        public void setFontSize(U u, @Nullable Double d) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.putDouble("fontSize", d.doubleValue());
            u.setFont(javaOnlyMap);
        }

        @ReactProp(name = "fontWeight")
        public void setFontWeight(U u, Dynamic dynamic) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()];
            if (i == 1) {
                javaOnlyMap.putDouble("fontWeight", dynamic.asDouble());
            } else if (i == 2) {
                javaOnlyMap.putString("fontWeight", dynamic.asString());
            } else {
                return;
            }
            u.setFont(javaOnlyMap);
        }

        public void setFontWeight(U u, @Nullable String str) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.putString("fontWeight", str);
            u.setFont(javaOnlyMap);
        }

        public void setFontWeight(U u, @Nullable Double d) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.putDouble("fontWeight", d.doubleValue());
            u.setFont(javaOnlyMap);
        }
    }

    /* renamed from: com.horcrux.svg.RenderableViewManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$bridge$ReadableType = r0
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.RenderableViewManager.AnonymousClass1.<clinit>():void");
        }
    }

    static class GroupViewManager extends GroupViewManagerAbstract<GroupView> implements RNSVGGroupManagerInterface<GroupView> {
        public static final String REACT_CLASS = "RNSVGGroup";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, @Nullable ReadableMap readableMap) {
            super.setFont((GroupView) view, readableMap);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable Double d) {
            super.setFontSize((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable String str) {
            super.setFontSize((GroupView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable Double d) {
            super.setFontWeight((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable String str) {
            super.setFontWeight((GroupView) view, str);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            super.setStrokeWidth((RenderableView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            super.setVectorEffect((RenderableView) view, i);
        }

        GroupViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGGroup);
            this.mDelegate = new RNSVGGroupManagerDelegate(this);
        }
    }

    static class PathViewManager extends RenderableViewManager<PathView> implements RNSVGPathManagerInterface<PathView> {
        public static final String REACT_CLASS = "RNSVGPath";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            RenderableViewManager.super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            RenderableViewManager.super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            RenderableViewManager.super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            RenderableViewManager.super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            RenderableViewManager.super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            RenderableViewManager.super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            RenderableViewManager.super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            RenderableViewManager.super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            RenderableViewManager.super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            RenderableViewManager.super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            RenderableViewManager.super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            RenderableViewManager.super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i);
        }

        PathViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGPath);
            this.mDelegate = new RNSVGPathManagerDelegate(this);
        }

        @ReactProp(name = "d")
        public void setD(PathView pathView, String str) {
            pathView.setD(str);
        }
    }

    static class TextViewManagerAbstract<K extends TextView> extends GroupViewManagerAbstract<K> {
        TextViewManagerAbstract(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
        }

        @ReactProp(name = "inlineSize")
        public void setInlineSize(K k, Dynamic dynamic) {
            k.setInlineSize(dynamic);
        }

        @ReactProp(name = "textLength")
        public void setTextLength(K k, Dynamic dynamic) {
            k.setTextLength(dynamic);
        }

        @ReactProp(name = "lengthAdjust")
        public void setLengthAdjust(K k, @Nullable String str) {
            k.setLengthAdjust(str);
        }

        @ReactProp(name = "alignmentBaseline")
        public void setMethod(K k, @Nullable String str) {
            k.setMethod(str);
        }

        @ReactProp(name = "baselineShift")
        public void setBaselineShift(K k, Dynamic dynamic) {
            k.setBaselineShift(dynamic);
        }

        @ReactProp(name = "verticalAlign")
        public void setVerticalAlign(K k, @Nullable String str) {
            k.setVerticalAlign(str);
        }

        @ReactProp(name = "rotate")
        public void setRotate(K k, Dynamic dynamic) {
            k.setRotate(dynamic);
        }

        @ReactProp(name = "dx")
        public void setDeltaX(K k, Dynamic dynamic) {
            k.setDeltaX(dynamic);
        }

        @ReactProp(name = "dy")
        public void setDeltaY(K k, Dynamic dynamic) {
            k.setDeltaY(dynamic);
        }

        @ReactProp(name = "x")
        public void setX(K k, Dynamic dynamic) {
            k.setPositionX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(K k, Dynamic dynamic) {
            k.setPositionY(dynamic);
        }

        @ReactProp(name = "font")
        public void setFont(K k, @Nullable ReadableMap readableMap) {
            k.setFont(readableMap);
        }

        public void setAlignmentBaseline(K k, @Nullable String str) {
            k.setMethod(str);
        }

        public void setDx(K k, @Nullable ReadableArray readableArray) {
            k.setDeltaX(readableArray);
        }

        public void setDy(K k, @Nullable ReadableArray readableArray) {
            k.setDeltaY(readableArray);
        }

        public void setX(K k, @Nullable ReadableArray readableArray) {
            k.setPositionX(readableArray);
        }

        public void setY(K k, @Nullable ReadableArray readableArray) {
            k.setPositionY(readableArray);
        }

        public void setRotate(K k, @Nullable ReadableArray readableArray) {
            k.setRotate(readableArray);
        }

        public void setInlineSize(K k, @Nullable String str) {
            k.setInlineSize(str);
        }

        public void setTextLength(K k, @Nullable String str) {
            k.setTextLength(str);
        }

        public void setBaselineShift(K k, @Nullable String str) {
            k.setBaselineShift(str);
        }

        public void setInlineSize(K k, @Nullable Double d) {
            k.setInlineSize(d);
        }

        public void setTextLength(K k, @Nullable Double d) {
            k.setTextLength(d);
        }

        public void setBaselineShift(K k, @Nullable Double d) {
            k.setBaselineShift(d);
        }
    }

    static class TextViewManager extends TextViewManagerAbstract<TextView> implements RNSVGTextManagerInterface<TextView> {
        public static final String REACT_CLASS = "RNSVGText";

        public /* bridge */ /* synthetic */ void setAlignmentBaseline(View view, @Nullable String str) {
            super.setAlignmentBaseline((TextView) view, str);
        }

        public /* bridge */ /* synthetic */ void setBaselineShift(View view, @Nullable Double d) {
            super.setBaselineShift((TextView) view, d);
        }

        public /* bridge */ /* synthetic */ void setBaselineShift(View view, @Nullable String str) {
            super.setBaselineShift((TextView) view, str);
        }

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setDx(View view, @Nullable ReadableArray readableArray) {
            super.setDx((TextView) view, readableArray);
        }

        public /* bridge */ /* synthetic */ void setDy(View view, @Nullable ReadableArray readableArray) {
            super.setDy((TextView) view, readableArray);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, @Nullable ReadableMap readableMap) {
            super.setFont((TextView) view, readableMap);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable Double d) {
            super.setFontSize((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable String str) {
            super.setFontSize((GroupView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable Double d) {
            super.setFontWeight((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable String str) {
            super.setFontWeight((GroupView) view, str);
        }

        public /* bridge */ /* synthetic */ void setInlineSize(View view, @Nullable Double d) {
            super.setInlineSize((TextView) view, d);
        }

        public /* bridge */ /* synthetic */ void setInlineSize(View view, @Nullable String str) {
            super.setInlineSize((TextView) view, str);
        }

        @ReactProp(name = "lengthAdjust")
        public /* bridge */ /* synthetic */ void setLengthAdjust(View view, @Nullable String str) {
            super.setLengthAdjust((TextView) view, str);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setRotate(View view, @Nullable ReadableArray readableArray) {
            super.setRotate((TextView) view, readableArray);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            super.setStrokeWidth((RenderableView) view, str);
        }

        public /* bridge */ /* synthetic */ void setTextLength(View view, @Nullable Double d) {
            super.setTextLength((TextView) view, d);
        }

        public /* bridge */ /* synthetic */ void setTextLength(View view, @Nullable String str) {
            super.setTextLength((TextView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            super.setVectorEffect((RenderableView) view, i);
        }

        @ReactProp(name = "verticalAlign")
        public /* bridge */ /* synthetic */ void setVerticalAlign(View view, @Nullable String str) {
            super.setVerticalAlign((TextView) view, str);
        }

        public /* bridge */ /* synthetic */ void setX(View view, @Nullable ReadableArray readableArray) {
            super.setX((TextView) view, readableArray);
        }

        public /* bridge */ /* synthetic */ void setY(View view, @Nullable ReadableArray readableArray) {
            super.setY((TextView) view, readableArray);
        }

        TextViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGText);
            this.mDelegate = new RNSVGTextManagerDelegate(this);
        }

        TextViewManager(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
            this.mDelegate = new RNSVGTextManagerDelegate(this);
        }
    }

    static class TSpanViewManager extends TextViewManagerAbstract<TSpanView> implements RNSVGTSpanManagerInterface<TSpanView> {
        public static final String REACT_CLASS = "RNSVGTSpan";

        public /* bridge */ /* synthetic */ void setAlignmentBaseline(View view, @Nullable String str) {
            super.setAlignmentBaseline((TextView) view, str);
        }

        public /* bridge */ /* synthetic */ void setBaselineShift(View view, @Nullable Double d) {
            super.setBaselineShift((TextView) view, d);
        }

        public /* bridge */ /* synthetic */ void setBaselineShift(View view, @Nullable String str) {
            super.setBaselineShift((TextView) view, str);
        }

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setDx(View view, @Nullable ReadableArray readableArray) {
            super.setDx((TextView) view, readableArray);
        }

        public /* bridge */ /* synthetic */ void setDy(View view, @Nullable ReadableArray readableArray) {
            super.setDy((TextView) view, readableArray);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, @Nullable ReadableMap readableMap) {
            super.setFont((TextView) view, readableMap);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable Double d) {
            super.setFontSize((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable String str) {
            super.setFontSize((GroupView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable Double d) {
            super.setFontWeight((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable String str) {
            super.setFontWeight((GroupView) view, str);
        }

        public /* bridge */ /* synthetic */ void setInlineSize(View view, @Nullable Double d) {
            super.setInlineSize((TextView) view, d);
        }

        public /* bridge */ /* synthetic */ void setInlineSize(View view, @Nullable String str) {
            super.setInlineSize((TextView) view, str);
        }

        @ReactProp(name = "lengthAdjust")
        public /* bridge */ /* synthetic */ void setLengthAdjust(View view, @Nullable String str) {
            super.setLengthAdjust((TextView) view, str);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setRotate(View view, @Nullable ReadableArray readableArray) {
            super.setRotate((TextView) view, readableArray);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            super.setStrokeWidth((RenderableView) view, str);
        }

        public /* bridge */ /* synthetic */ void setTextLength(View view, @Nullable Double d) {
            super.setTextLength((TextView) view, d);
        }

        public /* bridge */ /* synthetic */ void setTextLength(View view, @Nullable String str) {
            super.setTextLength((TextView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            super.setVectorEffect((RenderableView) view, i);
        }

        @ReactProp(name = "verticalAlign")
        public /* bridge */ /* synthetic */ void setVerticalAlign(View view, @Nullable String str) {
            super.setVerticalAlign((TextView) view, str);
        }

        public /* bridge */ /* synthetic */ void setX(View view, @Nullable ReadableArray readableArray) {
            super.setX((TextView) view, readableArray);
        }

        public /* bridge */ /* synthetic */ void setY(View view, @Nullable ReadableArray readableArray) {
            super.setY((TextView) view, readableArray);
        }

        TSpanViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGTSpan);
            this.mDelegate = new RNSVGTSpanManagerDelegate(this);
        }

        TSpanViewManager(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
            this.mDelegate = new RNSVGTSpanManagerDelegate(this);
        }

        @ReactProp(name = "content")
        public void setContent(TSpanView tSpanView, @Nullable String str) {
            tSpanView.setContent(str);
        }
    }

    static class TextPathViewManager extends TextViewManagerAbstract<TextPathView> implements RNSVGTextPathManagerInterface<TextPathView> {
        public static final String REACT_CLASS = "RNSVGTextPath";

        public /* bridge */ /* synthetic */ void setAlignmentBaseline(View view, @Nullable String str) {
            super.setAlignmentBaseline((TextView) view, str);
        }

        public /* bridge */ /* synthetic */ void setBaselineShift(View view, @Nullable Double d) {
            super.setBaselineShift((TextView) view, d);
        }

        public /* bridge */ /* synthetic */ void setBaselineShift(View view, @Nullable String str) {
            super.setBaselineShift((TextView) view, str);
        }

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setDx(View view, @Nullable ReadableArray readableArray) {
            super.setDx((TextView) view, readableArray);
        }

        public /* bridge */ /* synthetic */ void setDy(View view, @Nullable ReadableArray readableArray) {
            super.setDy((TextView) view, readableArray);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, @Nullable ReadableMap readableMap) {
            super.setFont((TextView) view, readableMap);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable Double d) {
            super.setFontSize((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable String str) {
            super.setFontSize((GroupView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable Double d) {
            super.setFontWeight((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable String str) {
            super.setFontWeight((GroupView) view, str);
        }

        public /* bridge */ /* synthetic */ void setInlineSize(View view, @Nullable Double d) {
            super.setInlineSize((TextView) view, d);
        }

        public /* bridge */ /* synthetic */ void setInlineSize(View view, @Nullable String str) {
            super.setInlineSize((TextView) view, str);
        }

        @ReactProp(name = "lengthAdjust")
        public /* bridge */ /* synthetic */ void setLengthAdjust(View view, @Nullable String str) {
            super.setLengthAdjust((TextView) view, str);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setRotate(View view, @Nullable ReadableArray readableArray) {
            super.setRotate((TextView) view, readableArray);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            super.setStrokeWidth((RenderableView) view, str);
        }

        public /* bridge */ /* synthetic */ void setTextLength(View view, @Nullable Double d) {
            super.setTextLength((TextView) view, d);
        }

        public /* bridge */ /* synthetic */ void setTextLength(View view, @Nullable String str) {
            super.setTextLength((TextView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            super.setVectorEffect((RenderableView) view, i);
        }

        @ReactProp(name = "verticalAlign")
        public /* bridge */ /* synthetic */ void setVerticalAlign(View view, @Nullable String str) {
            super.setVerticalAlign((TextView) view, str);
        }

        public /* bridge */ /* synthetic */ void setX(View view, @Nullable ReadableArray readableArray) {
            super.setX((TextView) view, readableArray);
        }

        public /* bridge */ /* synthetic */ void setY(View view, @Nullable ReadableArray readableArray) {
            super.setY((TextView) view, readableArray);
        }

        TextPathViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGTextPath);
            this.mDelegate = new RNSVGTextPathManagerDelegate(this);
        }

        TextPathViewManager(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
            this.mDelegate = new RNSVGTextPathManagerDelegate(this);
        }

        @ReactProp(name = "href")
        public void setHref(TextPathView textPathView, String str) {
            textPathView.setHref(str);
        }

        @ReactProp(name = "startOffset")
        public void setStartOffset(TextPathView textPathView, Dynamic dynamic) {
            textPathView.setStartOffset(dynamic);
        }

        @ReactProp(name = "method")
        public void setMethod(TextPathView textPathView, @Nullable String str) {
            textPathView.setMethod(str);
        }

        public void setMidLine(TextPathView textPathView, @Nullable String str) {
            textPathView.setSharp(str);
        }

        @ReactProp(name = "spacing")
        public void setSpacing(TextPathView textPathView, @Nullable String str) {
            textPathView.setSpacing(str);
        }

        public void setStartOffset(TextPathView textPathView, @Nullable String str) {
            textPathView.setStartOffset(str);
        }

        public void setStartOffset(TextPathView textPathView, @Nullable Double d) {
            textPathView.setStartOffset(d);
        }

        @ReactProp(name = "side")
        public void setSide(TextPathView textPathView, @Nullable String str) {
            textPathView.setSide(str);
        }

        @ReactProp(name = "midLine")
        public void setSharp(TextPathView textPathView, @Nullable String str) {
            textPathView.setSharp(str);
        }
    }

    static class ImageViewManager extends RenderableViewManager<ImageView> implements RNSVGImageManagerInterface<ImageView> {
        public static final String REACT_CLASS = "RNSVGImage";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            RenderableViewManager.super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            RenderableViewManager.super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            RenderableViewManager.super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            RenderableViewManager.super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            RenderableViewManager.super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            RenderableViewManager.super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            RenderableViewManager.super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            RenderableViewManager.super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            RenderableViewManager.super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            RenderableViewManager.super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            RenderableViewManager.super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            RenderableViewManager.super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i);
        }

        ImageViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGImage);
            this.mDelegate = new RNSVGImageManagerDelegate(this);
        }

        @ReactProp(name = "x")
        public void setX(ImageView imageView, Dynamic dynamic) {
            imageView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(ImageView imageView, Dynamic dynamic) {
            imageView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(ImageView imageView, Dynamic dynamic) {
            imageView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(ImageView imageView, Dynamic dynamic) {
            imageView.setHeight(dynamic);
        }

        public void setX(ImageView imageView, @Nullable String str) {
            imageView.setX(str);
        }

        public void setY(ImageView imageView, @Nullable String str) {
            imageView.setY(str);
        }

        public void setWidth(ImageView imageView, @Nullable String str) {
            imageView.setWidth(str);
        }

        public void setHeight(ImageView imageView, @Nullable String str) {
            imageView.setHeight(str);
        }

        public void setX(ImageView imageView, @Nullable Double d) {
            imageView.setX(d);
        }

        public void setY(ImageView imageView, @Nullable Double d) {
            imageView.setY(d);
        }

        public void setWidth(ImageView imageView, @Nullable Double d) {
            imageView.setWidth(d);
        }

        public void setHeight(ImageView imageView, @Nullable Double d) {
            imageView.setHeight(d);
        }

        @ReactProp(customType = "ImageSource", name = "src")
        public void setSrc(ImageView imageView, @Nullable ReadableMap readableMap) {
            imageView.setSrc(readableMap);
        }

        @ReactProp(name = "align")
        public void setAlign(ImageView imageView, String str) {
            imageView.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(ImageView imageView, int i) {
            imageView.setMeetOrSlice(i);
        }
    }

    static class CircleViewManager extends RenderableViewManager<CircleView> implements RNSVGCircleManagerInterface<CircleView> {
        public static final String REACT_CLASS = "RNSVGCircle";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            RenderableViewManager.super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            RenderableViewManager.super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            RenderableViewManager.super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            RenderableViewManager.super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            RenderableViewManager.super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            RenderableViewManager.super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            RenderableViewManager.super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            RenderableViewManager.super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            RenderableViewManager.super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            RenderableViewManager.super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            RenderableViewManager.super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            RenderableViewManager.super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i);
        }

        CircleViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGCircle);
            this.mDelegate = new RNSVGCircleManagerDelegate(this);
        }

        @ReactProp(name = "cx")
        public void setCx(CircleView circleView, Dynamic dynamic) {
            circleView.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(CircleView circleView, Dynamic dynamic) {
            circleView.setCy(dynamic);
        }

        @ReactProp(name = "r")
        public void setR(CircleView circleView, Dynamic dynamic) {
            circleView.setR(dynamic);
        }

        public void setCx(CircleView circleView, String str) {
            circleView.setCx(str);
        }

        public void setCx(CircleView circleView, Double d) {
            circleView.setCx(d);
        }

        public void setCy(CircleView circleView, String str) {
            circleView.setCy(str);
        }

        public void setCy(CircleView circleView, Double d) {
            circleView.setCy(d);
        }

        public void setR(CircleView circleView, String str) {
            circleView.setR(str);
        }

        public void setR(CircleView circleView, Double d) {
            circleView.setR(d);
        }
    }

    static class EllipseViewManager extends RenderableViewManager<EllipseView> implements RNSVGEllipseManagerInterface<EllipseView> {
        public static final String REACT_CLASS = "RNSVGEllipse";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            RenderableViewManager.super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            RenderableViewManager.super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            RenderableViewManager.super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            RenderableViewManager.super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            RenderableViewManager.super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            RenderableViewManager.super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            RenderableViewManager.super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            RenderableViewManager.super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            RenderableViewManager.super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            RenderableViewManager.super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            RenderableViewManager.super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            RenderableViewManager.super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i);
        }

        EllipseViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGEllipse);
            this.mDelegate = new RNSVGEllipseManagerDelegate(this);
        }

        @ReactProp(name = "cx")
        public void setCx(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setCy(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setRy(dynamic);
        }

        public void setCx(EllipseView ellipseView, @Nullable String str) {
            ellipseView.setCx(str);
        }

        public void setCy(EllipseView ellipseView, @Nullable String str) {
            ellipseView.setCy(str);
        }

        public void setRx(EllipseView ellipseView, @Nullable String str) {
            ellipseView.setRx(str);
        }

        public void setRy(EllipseView ellipseView, @Nullable String str) {
            ellipseView.setRy(str);
        }

        public void setCx(EllipseView ellipseView, @Nullable Double d) {
            ellipseView.setCx(d);
        }

        public void setCy(EllipseView ellipseView, @Nullable Double d) {
            ellipseView.setCy(d);
        }

        public void setRx(EllipseView ellipseView, @Nullable Double d) {
            ellipseView.setRx(d);
        }

        public void setRy(EllipseView ellipseView, @Nullable Double d) {
            ellipseView.setRy(d);
        }
    }

    static class LineViewManager extends RenderableViewManager<LineView> implements RNSVGLineManagerInterface<LineView> {
        public static final String REACT_CLASS = "RNSVGLine";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            RenderableViewManager.super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            RenderableViewManager.super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            RenderableViewManager.super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            RenderableViewManager.super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            RenderableViewManager.super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            RenderableViewManager.super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            RenderableViewManager.super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            RenderableViewManager.super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            RenderableViewManager.super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            RenderableViewManager.super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            RenderableViewManager.super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            RenderableViewManager.super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i);
        }

        LineViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGLine);
            this.mDelegate = new RNSVGLineManagerDelegate(this);
        }

        @ReactProp(name = "x1")
        public void setX1(LineView lineView, Dynamic dynamic) {
            lineView.setX1(dynamic);
        }

        @ReactProp(name = "y1")
        public void setY1(LineView lineView, Dynamic dynamic) {
            lineView.setY1(dynamic);
        }

        @ReactProp(name = "x2")
        public void setX2(LineView lineView, Dynamic dynamic) {
            lineView.setX2(dynamic);
        }

        @ReactProp(name = "y2")
        public void setY2(LineView lineView, Dynamic dynamic) {
            lineView.setY2(dynamic);
        }

        public void setX1(LineView lineView, @Nullable String str) {
            lineView.setX1(str);
        }

        public void setY1(LineView lineView, @Nullable String str) {
            lineView.setY1(str);
        }

        public void setX2(LineView lineView, @Nullable String str) {
            lineView.setX2(str);
        }

        public void setY2(LineView lineView, @Nullable String str) {
            lineView.setY2(str);
        }

        public void setX1(LineView lineView, @Nullable Double d) {
            lineView.setX1(d);
        }

        public void setY1(LineView lineView, @Nullable Double d) {
            lineView.setY1(d);
        }

        public void setX2(LineView lineView, @Nullable Double d) {
            lineView.setX2(d);
        }

        public void setY2(LineView lineView, @Nullable Double d) {
            lineView.setY2(d);
        }
    }

    static class RectViewManager extends RenderableViewManager<RectView> implements RNSVGRectManagerInterface<RectView> {
        public static final String REACT_CLASS = "RNSVGRect";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            RenderableViewManager.super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            RenderableViewManager.super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            RenderableViewManager.super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            RenderableViewManager.super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            RenderableViewManager.super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            RenderableViewManager.super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            RenderableViewManager.super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            RenderableViewManager.super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            RenderableViewManager.super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            RenderableViewManager.super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            RenderableViewManager.super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            RenderableViewManager.super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i);
        }

        RectViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGRect);
            this.mDelegate = new RNSVGRectManagerDelegate(this);
        }

        @ReactProp(name = "x")
        public void setX(RectView rectView, Dynamic dynamic) {
            rectView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(RectView rectView, Dynamic dynamic) {
            rectView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(RectView rectView, Dynamic dynamic) {
            rectView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(RectView rectView, Dynamic dynamic) {
            rectView.setHeight(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(RectView rectView, Dynamic dynamic) {
            rectView.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(RectView rectView, Dynamic dynamic) {
            rectView.setRy(dynamic);
        }

        public void setX(RectView rectView, @Nullable String str) {
            rectView.setX(str);
        }

        public void setY(RectView rectView, @Nullable String str) {
            rectView.setY(str);
        }

        public void setHeight(RectView rectView, @Nullable String str) {
            rectView.setHeight(str);
        }

        public void setWidth(RectView rectView, @Nullable String str) {
            rectView.setWidth(str);
        }

        public void setRx(RectView rectView, @Nullable String str) {
            rectView.setRx(str);
        }

        public void setRy(RectView rectView, @Nullable String str) {
            rectView.setRy(str);
        }

        public void setX(RectView rectView, @Nullable Double d) {
            rectView.setX(d);
        }

        public void setY(RectView rectView, @Nullable Double d) {
            rectView.setY(d);
        }

        public void setHeight(RectView rectView, @Nullable Double d) {
            rectView.setHeight(d);
        }

        public void setWidth(RectView rectView, @Nullable Double d) {
            rectView.setWidth(d);
        }

        public void setRx(RectView rectView, @Nullable Double d) {
            rectView.setRx(d);
        }

        public void setRy(RectView rectView, @Nullable Double d) {
            rectView.setRy(d);
        }
    }

    static class ClipPathViewManager extends GroupViewManagerAbstract<ClipPathView> implements RNSVGClipPathManagerInterface<ClipPathView> {
        public static final String REACT_CLASS = "RNSVGClipPath";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, @Nullable ReadableMap readableMap) {
            super.setFont((GroupView) view, readableMap);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable Double d) {
            super.setFontSize((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable String str) {
            super.setFontSize((GroupView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable Double d) {
            super.setFontWeight((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable String str) {
            super.setFontWeight((GroupView) view, str);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            super.setStrokeWidth((RenderableView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            super.setVectorEffect((RenderableView) view, i);
        }

        ClipPathViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGClipPath);
            this.mDelegate = new RNSVGClipPathManagerDelegate(this);
        }
    }

    static class DefsViewManager extends VirtualViewManager<DefsView> implements RNSVGDefsManagerInterface<DefsView> {
        public static final String REACT_CLASS = "RNSVGDefs";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((VirtualView) view, z);
        }

        DefsViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGDefs);
            this.mDelegate = new RNSVGDefsManagerDelegate(this);
        }
    }

    static class UseViewManager extends RenderableViewManager<UseView> implements RNSVGUseManagerInterface<UseView> {
        public static final String REACT_CLASS = "RNSVGUse";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            RenderableViewManager.super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            RenderableViewManager.super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            RenderableViewManager.super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            RenderableViewManager.super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            RenderableViewManager.super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            RenderableViewManager.super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            RenderableViewManager.super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            RenderableViewManager.super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            RenderableViewManager.super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            RenderableViewManager.super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            RenderableViewManager.super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            RenderableViewManager.super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i);
        }

        UseViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGUse);
            this.mDelegate = new RNSVGUseManagerDelegate(this);
        }

        @ReactProp(name = "href")
        public void setHref(UseView useView, String str) {
            useView.setHref(str);
        }

        public void setX(UseView useView, @Nullable String str) {
            useView.setX(str);
        }

        public void setY(UseView useView, @Nullable String str) {
            useView.setY(str);
        }

        public void setHeight(UseView useView, @Nullable String str) {
            useView.setHeight(str);
        }

        public void setWidth(UseView useView, @Nullable Double d) {
            useView.setWidth(d);
        }

        public void setX(UseView useView, @Nullable Double d) {
            useView.setX(d);
        }

        public void setY(UseView useView, @Nullable Double d) {
            useView.setY(d);
        }

        public void setHeight(UseView useView, @Nullable Double d) {
            useView.setHeight(d);
        }

        public void setWidth(UseView useView, @Nullable String str) {
            useView.setWidth(str);
        }

        @ReactProp(name = "x")
        public void setX(UseView useView, Dynamic dynamic) {
            useView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(UseView useView, Dynamic dynamic) {
            useView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(UseView useView, Dynamic dynamic) {
            useView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(UseView useView, Dynamic dynamic) {
            useView.setHeight(dynamic);
        }
    }

    static class SymbolManager extends GroupViewManagerAbstract<SymbolView> implements RNSVGSymbolManagerInterface<SymbolView> {
        public static final String REACT_CLASS = "RNSVGSymbol";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, @Nullable ReadableMap readableMap) {
            super.setFont((GroupView) view, readableMap);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable Double d) {
            super.setFontSize((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable String str) {
            super.setFontSize((GroupView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable Double d) {
            super.setFontWeight((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable String str) {
            super.setFontWeight((GroupView) view, str);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            super.setStrokeWidth((RenderableView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            super.setVectorEffect((RenderableView) view, i);
        }

        SymbolManager() {
            super(VirtualViewManager.SVGClass.RNSVGSymbol);
            this.mDelegate = new RNSVGSymbolManagerDelegate(this);
        }

        @ReactProp(name = "minX")
        public void setMinX(SymbolView symbolView, float f) {
            symbolView.setMinX(f);
        }

        @ReactProp(name = "minY")
        public void setMinY(SymbolView symbolView, float f) {
            symbolView.setMinY(f);
        }

        @ReactProp(name = "vbWidth")
        public void setVbWidth(SymbolView symbolView, float f) {
            symbolView.setVbWidth(f);
        }

        @ReactProp(name = "vbHeight")
        public void setVbHeight(SymbolView symbolView, float f) {
            symbolView.setVbHeight(f);
        }

        @ReactProp(name = "align")
        public void setAlign(SymbolView symbolView, String str) {
            symbolView.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(SymbolView symbolView, int i) {
            symbolView.setMeetOrSlice(i);
        }
    }

    static class PatternManager extends GroupViewManagerAbstract<PatternView> implements RNSVGPatternManagerInterface<PatternView> {
        public static final String REACT_CLASS = "RNSVGPattern";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, @Nullable ReadableMap readableMap) {
            super.setFont((GroupView) view, readableMap);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable Double d) {
            super.setFontSize((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable String str) {
            super.setFontSize((GroupView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable Double d) {
            super.setFontWeight((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable String str) {
            super.setFontWeight((GroupView) view, str);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            super.setStrokeWidth((RenderableView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            super.setVectorEffect((RenderableView) view, i);
        }

        PatternManager() {
            super(VirtualViewManager.SVGClass.RNSVGPattern);
            this.mDelegate = new RNSVGPatternManagerDelegate(this);
        }

        @ReactProp(name = "x")
        public void setX(PatternView patternView, Dynamic dynamic) {
            patternView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(PatternView patternView, Dynamic dynamic) {
            patternView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(PatternView patternView, Dynamic dynamic) {
            patternView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(PatternView patternView, Dynamic dynamic) {
            patternView.setHeight(dynamic);
        }

        public void setX(PatternView patternView, @Nullable String str) {
            patternView.setX(str);
        }

        public void setY(PatternView patternView, @Nullable String str) {
            patternView.setY(str);
        }

        public void setHeight(PatternView patternView, @Nullable String str) {
            patternView.setHeight(str);
        }

        public void setWidth(PatternView patternView, @Nullable String str) {
            patternView.setWidth(str);
        }

        public void setX(PatternView patternView, @Nullable Double d) {
            patternView.setX(d);
        }

        public void setY(PatternView patternView, @Nullable Double d) {
            patternView.setY(d);
        }

        public void setHeight(PatternView patternView, @Nullable Double d) {
            patternView.setHeight(d);
        }

        public void setWidth(PatternView patternView, @Nullable Double d) {
            patternView.setWidth(d);
        }

        @ReactProp(name = "patternUnits")
        public void setPatternUnits(PatternView patternView, int i) {
            patternView.setPatternUnits(i);
        }

        @ReactProp(name = "patternContentUnits")
        public void setPatternContentUnits(PatternView patternView, int i) {
            patternView.setPatternContentUnits(i);
        }

        @ReactProp(name = "patternTransform")
        public void setPatternTransform(PatternView patternView, @Nullable ReadableArray readableArray) {
            patternView.setPatternTransform(readableArray);
        }

        @ReactProp(name = "minX")
        public void setMinX(PatternView patternView, float f) {
            patternView.setMinX(f);
        }

        @ReactProp(name = "minY")
        public void setMinY(PatternView patternView, float f) {
            patternView.setMinY(f);
        }

        @ReactProp(name = "vbWidth")
        public void setVbWidth(PatternView patternView, float f) {
            patternView.setVbWidth(f);
        }

        @ReactProp(name = "vbHeight")
        public void setVbHeight(PatternView patternView, float f) {
            patternView.setVbHeight(f);
        }

        @ReactProp(name = "align")
        public void setAlign(PatternView patternView, String str) {
            patternView.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(PatternView patternView, int i) {
            patternView.setMeetOrSlice(i);
        }
    }

    static class MaskManager extends GroupViewManagerAbstract<MaskView> implements RNSVGMaskManagerInterface<MaskView> {
        public static final String REACT_CLASS = "RNSVGMask";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, @Nullable ReadableMap readableMap) {
            super.setFont((GroupView) view, readableMap);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable Double d) {
            super.setFontSize((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable String str) {
            super.setFontSize((GroupView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable Double d) {
            super.setFontWeight((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable String str) {
            super.setFontWeight((GroupView) view, str);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            super.setStrokeWidth((RenderableView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            super.setVectorEffect((RenderableView) view, i);
        }

        MaskManager() {
            super(VirtualViewManager.SVGClass.RNSVGMask);
            this.mDelegate = new RNSVGMaskManagerDelegate(this);
        }

        @ReactProp(name = "x")
        public void setX(MaskView maskView, Dynamic dynamic) {
            maskView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(MaskView maskView, Dynamic dynamic) {
            maskView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(MaskView maskView, Dynamic dynamic) {
            maskView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(MaskView maskView, Dynamic dynamic) {
            maskView.setHeight(dynamic);
        }

        public void setX(MaskView maskView, @Nullable String str) {
            maskView.setX(str);
        }

        public void setY(MaskView maskView, @Nullable String str) {
            maskView.setY(str);
        }

        public void setHeight(MaskView maskView, @Nullable String str) {
            maskView.setHeight(str);
        }

        public void setWidth(MaskView maskView, @Nullable String str) {
            maskView.setWidth(str);
        }

        public void setX(MaskView maskView, @Nullable Double d) {
            maskView.setX(d);
        }

        public void setY(MaskView maskView, @Nullable Double d) {
            maskView.setY(d);
        }

        public void setHeight(MaskView maskView, @Nullable Double d) {
            maskView.setHeight(d);
        }

        public void setWidth(MaskView maskView, @Nullable Double d) {
            maskView.setWidth(d);
        }

        @ReactProp(name = "maskUnits")
        public void setMaskUnits(MaskView maskView, int i) {
            maskView.setMaskUnits(i);
        }

        @ReactProp(name = "maskContentUnits")
        public void setMaskContentUnits(MaskView maskView, int i) {
            maskView.setMaskContentUnits(i);
        }
    }

    static class ForeignObjectManager extends GroupViewManagerAbstract<ForeignObjectView> implements RNSVGForeignObjectManagerInterface<ForeignObjectView> {
        public static final String REACT_CLASS = "RNSVGForeignObject";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, @Nullable ReadableMap readableMap) {
            super.setFont((GroupView) view, readableMap);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable Double d) {
            super.setFontSize((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable String str) {
            super.setFontSize((GroupView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable Double d) {
            super.setFontWeight((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable String str) {
            super.setFontWeight((GroupView) view, str);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            super.setStrokeWidth((RenderableView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            super.setVectorEffect((RenderableView) view, i);
        }

        ForeignObjectManager() {
            super(VirtualViewManager.SVGClass.RNSVGForeignObject);
            this.mDelegate = new RNSVGForeignObjectManagerDelegate(this);
        }

        @ReactProp(name = "x")
        public void setX(ForeignObjectView foreignObjectView, Dynamic dynamic) {
            foreignObjectView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(ForeignObjectView foreignObjectView, Dynamic dynamic) {
            foreignObjectView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(ForeignObjectView foreignObjectView, Dynamic dynamic) {
            foreignObjectView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(ForeignObjectView foreignObjectView, Dynamic dynamic) {
            foreignObjectView.setHeight(dynamic);
        }

        public void setX(ForeignObjectView foreignObjectView, @Nullable String str) {
            foreignObjectView.setX(str);
        }

        public void setY(ForeignObjectView foreignObjectView, @Nullable String str) {
            foreignObjectView.setY(str);
        }

        public void setHeight(ForeignObjectView foreignObjectView, @Nullable String str) {
            foreignObjectView.setHeight(str);
        }

        public void setWidth(ForeignObjectView foreignObjectView, @Nullable String str) {
            foreignObjectView.setWidth(str);
        }

        public void setX(ForeignObjectView foreignObjectView, @Nullable Double d) {
            foreignObjectView.setX(d);
        }

        public void setY(ForeignObjectView foreignObjectView, @Nullable Double d) {
            foreignObjectView.setY(d);
        }

        public void setHeight(ForeignObjectView foreignObjectView, @Nullable Double d) {
            foreignObjectView.setHeight(d);
        }

        public void setWidth(ForeignObjectView foreignObjectView, @Nullable Double d) {
            foreignObjectView.setWidth(d);
        }
    }

    static class MarkerManager extends GroupViewManagerAbstract<MarkerView> implements RNSVGMarkerManagerInterface<MarkerView> {
        public static final String REACT_CLASS = "RNSVGMarker";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFill(View view, @Nullable ReadableMap readableMap) {
            super.setFill((RenderableView) view, readableMap);
        }

        @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f) {
            super.setFillOpacity((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i) {
            super.setFillRule((RenderableView) view, i);
        }

        @ReactProp(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, @Nullable ReadableMap readableMap) {
            super.setFont((GroupView) view, readableMap);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable Double d) {
            super.setFontSize((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontSize(View view, @Nullable String str) {
            super.setFontSize((GroupView) view, str);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable Double d) {
            super.setFontWeight((GroupView) view, d);
        }

        public /* bridge */ /* synthetic */ void setFontWeight(View view, @Nullable String str) {
            super.setFontWeight((GroupView) view, str);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, @Nullable ReadableArray readableArray) {
            super.setPropList((RenderableView) view, readableArray);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((VirtualView) view, z);
        }

        public /* bridge */ /* synthetic */ void setStroke(View view, @Nullable ReadableMap readableMap) {
            super.setStroke((RenderableView) view, readableMap);
        }

        @ReactProp(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, @Nullable ReadableArray readableArray) {
            super.setStrokeDasharray((RenderableView) view, readableArray);
        }

        @ReactProp(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f) {
            super.setStrokeDashoffset((RenderableView) view, f);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i) {
            super.setStrokeLinecap((RenderableView) view, i);
        }

        @ReactProp(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i) {
            super.setStrokeLinejoin((RenderableView) view, i);
        }

        @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f) {
            super.setStrokeMiterlimit((RenderableView) view, f);
        }

        @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f) {
            super.setStrokeOpacity((RenderableView) view, f);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable Double d) {
            super.setStrokeWidth((RenderableView) view, d);
        }

        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, @Nullable String str) {
            super.setStrokeWidth((RenderableView) view, str);
        }

        @ReactProp(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i) {
            super.setVectorEffect((RenderableView) view, i);
        }

        MarkerManager() {
            super(VirtualViewManager.SVGClass.RNSVGMarker);
            this.mDelegate = new RNSVGMarkerManagerDelegate(this);
        }

        @ReactProp(name = "refX")
        public void setRefX(MarkerView markerView, Dynamic dynamic) {
            markerView.setRefX(dynamic);
        }

        @ReactProp(name = "refY")
        public void setRefY(MarkerView markerView, Dynamic dynamic) {
            markerView.setRefY(dynamic);
        }

        @ReactProp(name = "markerWidth")
        public void setMarkerWidth(MarkerView markerView, Dynamic dynamic) {
            markerView.setMarkerWidth(dynamic);
        }

        @ReactProp(name = "markerHeight")
        public void setMarkerHeight(MarkerView markerView, Dynamic dynamic) {
            markerView.setMarkerHeight(dynamic);
        }

        public void setRefX(MarkerView markerView, @Nullable String str) {
            markerView.setRefX(str);
        }

        public void setRefY(MarkerView markerView, @Nullable String str) {
            markerView.setRefY(str);
        }

        public void setMarkerHeight(MarkerView markerView, @Nullable String str) {
            markerView.setMarkerHeight(str);
        }

        public void setMarkerWidth(MarkerView markerView, @Nullable String str) {
            markerView.setMarkerWidth(str);
        }

        public void setRefX(MarkerView markerView, @Nullable Double d) {
            markerView.setRefX(d);
        }

        public void setRefY(MarkerView markerView, @Nullable Double d) {
            markerView.setRefY(d);
        }

        public void setMarkerHeight(MarkerView markerView, @Nullable Double d) {
            markerView.setMarkerHeight(d);
        }

        public void setMarkerWidth(MarkerView markerView, @Nullable Double d) {
            markerView.setMarkerWidth(d);
        }

        @ReactProp(name = "markerUnits")
        public void setMarkerUnits(MarkerView markerView, String str) {
            markerView.setMarkerUnits(str);
        }

        @ReactProp(name = "orient")
        public void setOrient(MarkerView markerView, String str) {
            markerView.setOrient(str);
        }

        @ReactProp(name = "minX")
        public void setMinX(MarkerView markerView, float f) {
            markerView.setMinX(f);
        }

        @ReactProp(name = "minY")
        public void setMinY(MarkerView markerView, float f) {
            markerView.setMinY(f);
        }

        @ReactProp(name = "vbWidth")
        public void setVbWidth(MarkerView markerView, float f) {
            markerView.setVbWidth(f);
        }

        @ReactProp(name = "vbHeight")
        public void setVbHeight(MarkerView markerView, float f) {
            markerView.setVbHeight(f);
        }

        @ReactProp(name = "align")
        public void setAlign(MarkerView markerView, String str) {
            markerView.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(MarkerView markerView, int i) {
            markerView.setMeetOrSlice(i);
        }
    }

    static class LinearGradientManager extends VirtualViewManager<LinearGradientView> implements RNSVGLinearGradientManagerInterface<LinearGradientView> {
        public static final String REACT_CLASS = "RNSVGLinearGradient";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((VirtualView) view, z);
        }

        LinearGradientManager() {
            super(VirtualViewManager.SVGClass.RNSVGLinearGradient);
            this.mDelegate = new RNSVGLinearGradientManagerDelegate(this);
        }

        @ReactProp(name = "x1")
        public void setX1(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setX1(dynamic);
        }

        @ReactProp(name = "y1")
        public void setY1(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setY1(dynamic);
        }

        @ReactProp(name = "x2")
        public void setX2(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setX2(dynamic);
        }

        @ReactProp(name = "y2")
        public void setY2(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setY2(dynamic);
        }

        public void setX1(LinearGradientView linearGradientView, @Nullable String str) {
            linearGradientView.setX1(str);
        }

        public void setY1(LinearGradientView linearGradientView, @Nullable String str) {
            linearGradientView.setY1(str);
        }

        public void setX2(LinearGradientView linearGradientView, @Nullable String str) {
            linearGradientView.setX2(str);
        }

        public void setY2(LinearGradientView linearGradientView, @Nullable String str) {
            linearGradientView.setY2(str);
        }

        public void setX1(LinearGradientView linearGradientView, @Nullable Double d) {
            linearGradientView.setX1(d);
        }

        public void setY1(LinearGradientView linearGradientView, @Nullable Double d) {
            linearGradientView.setY1(d);
        }

        public void setX2(LinearGradientView linearGradientView, @Nullable Double d) {
            linearGradientView.setX2(d);
        }

        public void setY2(LinearGradientView linearGradientView, @Nullable Double d) {
            linearGradientView.setY2(d);
        }

        @ReactProp(name = "gradient")
        public void setGradient(LinearGradientView linearGradientView, ReadableArray readableArray) {
            linearGradientView.setGradient(readableArray);
        }

        @ReactProp(name = "gradientUnits")
        public void setGradientUnits(LinearGradientView linearGradientView, int i) {
            linearGradientView.setGradientUnits(i);
        }

        @ReactProp(name = "gradientTransform")
        public void setGradientTransform(LinearGradientView linearGradientView, @Nullable ReadableArray readableArray) {
            linearGradientView.setGradientTransform(readableArray);
        }
    }

    static class RadialGradientManager extends VirtualViewManager<RadialGradientView> implements RNSVGRadialGradientManagerInterface<RadialGradientView> {
        public static final String REACT_CLASS = "RNSVGRadialGradient";

        @ReactProp(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @ReactProp(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i) {
            super.setClipRule((VirtualView) view, i);
        }

        @ReactProp(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @ReactProp(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @ReactProp(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @ReactProp(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @ReactProp(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, @Nullable ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @ReactProp(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(@Nonnull View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, @Nullable String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @ReactProp(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z) {
            super.setResponsible((VirtualView) view, z);
        }

        RadialGradientManager() {
            super(VirtualViewManager.SVGClass.RNSVGRadialGradient);
            this.mDelegate = new RNSVGRadialGradientManagerDelegate(this);
        }

        @ReactProp(name = "fx")
        public void setFx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setFx(dynamic);
        }

        @ReactProp(name = "fy")
        public void setFy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setFy(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setRy(dynamic);
        }

        @ReactProp(name = "cx")
        public void setCx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setCy(dynamic);
        }

        public void setFx(RadialGradientView radialGradientView, @Nullable String str) {
            radialGradientView.setFx(str);
        }

        public void setFy(RadialGradientView radialGradientView, @Nullable String str) {
            radialGradientView.setFy(str);
        }

        public void setCx(RadialGradientView radialGradientView, @Nullable String str) {
            radialGradientView.setCx(str);
        }

        public void setCy(RadialGradientView radialGradientView, @Nullable String str) {
            radialGradientView.setCy(str);
        }

        public void setRx(RadialGradientView radialGradientView, @Nullable String str) {
            radialGradientView.setRx(str);
        }

        public void setRy(RadialGradientView radialGradientView, @Nullable String str) {
            radialGradientView.setRy(str);
        }

        public void setFx(RadialGradientView radialGradientView, @Nullable Double d) {
            radialGradientView.setFx(d);
        }

        public void setFy(RadialGradientView radialGradientView, @Nullable Double d) {
            radialGradientView.setFy(d);
        }

        public void setCx(RadialGradientView radialGradientView, @Nullable Double d) {
            radialGradientView.setCx(d);
        }

        public void setCy(RadialGradientView radialGradientView, @Nullable Double d) {
            radialGradientView.setCy(d);
        }

        public void setRx(RadialGradientView radialGradientView, @Nullable Double d) {
            radialGradientView.setRx(d);
        }

        public void setRy(RadialGradientView radialGradientView, @Nullable Double d) {
            radialGradientView.setRy(d);
        }

        @ReactProp(name = "gradient")
        public void setGradient(RadialGradientView radialGradientView, ReadableArray readableArray) {
            radialGradientView.setGradient(readableArray);
        }

        @ReactProp(name = "gradientUnits")
        public void setGradientUnits(RadialGradientView radialGradientView, int i) {
            radialGradientView.setGradientUnits(i);
        }

        @ReactProp(name = "gradientTransform")
        public void setGradientTransform(RadialGradientView radialGradientView, @Nullable ReadableArray readableArray) {
            radialGradientView.setGradientTransform(readableArray);
        }
    }

    @ReactProp(name = "fill")
    public void setFill(T t, @Nullable Dynamic dynamic) {
        t.setFill(dynamic);
    }

    public void setFill(T t, @Nullable ReadableMap readableMap) {
        t.setFill(readableMap);
    }

    @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
    public void setFillOpacity(T t, float f) {
        t.setFillOpacity(f);
    }

    @ReactProp(defaultInt = 1, name = "fillRule")
    public void setFillRule(T t, int i) {
        t.setFillRule(i);
    }

    @ReactProp(name = "stroke")
    public void setStroke(T t, @Nullable Dynamic dynamic) {
        t.setStroke(dynamic);
    }

    public void setStroke(T t, @Nullable ReadableMap readableMap) {
        t.setStroke(readableMap);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
    public void setStrokeOpacity(T t, float f) {
        t.setStrokeOpacity(f);
    }

    @ReactProp(name = "strokeDasharray")
    public void setStrokeDasharray(T t, @Nullable ReadableArray readableArray) {
        t.setStrokeDasharray(readableArray);
    }

    @ReactProp(name = "strokeDashoffset")
    public void setStrokeDashoffset(T t, float f) {
        t.setStrokeDashoffset(f);
    }

    @ReactProp(name = "strokeWidth")
    public void setStrokeWidth(T t, Dynamic dynamic) {
        t.setStrokeWidth(dynamic);
    }

    public void setStrokeWidth(T t, @Nullable String str) {
        t.setStrokeWidth(str);
    }

    public void setStrokeWidth(T t, @Nullable Double d) {
        t.setStrokeWidth(d);
    }

    @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
    public void setStrokeMiterlimit(T t, float f) {
        t.setStrokeMiterlimit(f);
    }

    @ReactProp(defaultInt = 1, name = "strokeLinecap")
    public void setStrokeLinecap(T t, int i) {
        t.setStrokeLinecap(i);
    }

    @ReactProp(defaultInt = 1, name = "strokeLinejoin")
    public void setStrokeLinejoin(T t, int i) {
        t.setStrokeLinejoin(i);
    }

    @ReactProp(name = "vectorEffect")
    public void setVectorEffect(T t, int i) {
        t.setVectorEffect(i);
    }

    @ReactProp(name = "propList")
    public void setPropList(T t, @Nullable ReadableArray readableArray) {
        t.setPropList(readableArray);
    }
}
