package com.horcrux.svg;

import android.graphics.Matrix;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.MatrixMathHelper;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.TransformHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.horcrux.svg.VirtualView;
import java.lang.reflect.Array;
import java.util.Locale;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: RenderableViewManager */
class VirtualViewManager<V extends VirtualView> extends ViewGroupManager<VirtualView> {
    private static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = 5.0f;
    private static final double EPSILON = 1.0E-5d;
    private static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
    private static final SparseArray<RenderableView> mTagToRenderableView = new SparseArray<>();
    private static final SparseArray<Runnable> mTagToRunnable = new SparseArray<>();
    private static final MatrixDecompositionContext sMatrixDecompositionContext = new MatrixDecompositionContext();
    private static final double[] sTransformDecompositionArray = new double[16];
    protected final String mClassName;
    protected ViewManagerDelegate<V> mDelegate;
    protected final SVGClass svgClass;

    /* compiled from: RenderableViewManager */
    protected enum SVGClass {
        RNSVGGroup,
        RNSVGPath,
        RNSVGText,
        RNSVGTSpan,
        RNSVGTextPath,
        RNSVGImage,
        RNSVGCircle,
        RNSVGEllipse,
        RNSVGLine,
        RNSVGRect,
        RNSVGClipPath,
        RNSVGDefs,
        RNSVGUse,
        RNSVGSymbol,
        RNSVGLinearGradient,
        RNSVGRadialGradient,
        RNSVGPattern,
        RNSVGMask,
        RNSVGMarker,
        RNSVGForeignObject
    }

    protected VirtualViewManager(SVGClass sVGClass) {
        this.svgClass = sVGClass;
        this.mClassName = sVGClass.toString();
    }

    /* access modifiers changed from: protected */
    public ViewManagerDelegate getDelegate() {
        return this.mDelegate;
    }

    /* compiled from: RenderableViewManager */
    static class RenderableShadowNode extends LayoutShadowNode {
        @ReactPropGroup(names = {"alignSelf", "alignItems", "collapsable", "flex", "flexBasis", "flexDirection", "flexGrow", "flexShrink", "flexWrap", "justifyContent", "overflow", "alignContent", "display", "position", "right", "top", "bottom", "left", "start", "end", "width", "height", "minWidth", "maxWidth", "minHeight", "maxHeight", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "marginStart", "marginEnd", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "paddingStart", "paddingEnd", "borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
        public void ignoreLayoutProps(int i, Dynamic dynamic) {
        }

        RenderableShadowNode() {
        }
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new RenderableShadowNode();
    }

    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return RenderableShadowNode.class;
    }

    /* compiled from: RenderableViewManager */
    static class MatrixDecompositionContext extends MatrixMathHelper.MatrixDecompositionContext {
        final double[] perspective = new double[4];
        final double[] rotationDegrees = new double[3];
        final double[] scale = new double[3];
        final double[] skew = new double[3];
        final double[] translation = new double[3];

        MatrixDecompositionContext() {
        }
    }

    private static boolean isZero(double d) {
        return !Double.isNaN(d) && Math.abs(d) < 1.0E-5d;
    }

    private static void decomposeMatrix() {
        MatrixDecompositionContext matrixDecompositionContext = sMatrixDecompositionContext;
        double[] dArr = matrixDecompositionContext.perspective;
        double[] dArr2 = matrixDecompositionContext.scale;
        double[] dArr3 = matrixDecompositionContext.skew;
        double[] dArr4 = matrixDecompositionContext.translation;
        double[] dArr5 = matrixDecompositionContext.rotationDegrees;
        if (!isZero(sTransformDecompositionArray[15])) {
            double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
            double[] dArr7 = new double[16];
            for (int i = 0; i < 4; i++) {
                for (int i2 = 0; i2 < 4; i2++) {
                    double[] dArr8 = sTransformDecompositionArray;
                    int i3 = (i * 4) + i2;
                    double d = dArr8[i3] / dArr8[15];
                    dArr6[i][i2] = d;
                    if (i2 == 3) {
                        d = 0.0d;
                    }
                    dArr7[i3] = d;
                }
            }
            dArr7[15] = 1.0d;
            if (!isZero(MatrixMathHelper.determinant(dArr7))) {
                if (!isZero(dArr6[0][3]) || !isZero(dArr6[1][3]) || !isZero(dArr6[2][3])) {
                    MatrixMathHelper.multiplyVectorByMatrix(new double[]{dArr6[0][3], dArr6[1][3], dArr6[2][3], dArr6[3][3]}, MatrixMathHelper.transpose(MatrixMathHelper.inverse(dArr7)), dArr);
                } else {
                    dArr[2] = 0.0d;
                    dArr[1] = 0.0d;
                    dArr[0] = 0.0d;
                    dArr[3] = 1.0d;
                }
                System.arraycopy(dArr6[3], 0, dArr4, 0, 3);
                double[][] dArr9 = (double[][]) Array.newInstance(Double.TYPE, new int[]{3, 3});
                for (int i4 = 0; i4 < 3; i4++) {
                    double[] dArr10 = dArr9[i4];
                    double[] dArr11 = dArr6[i4];
                    dArr10[0] = dArr11[0];
                    dArr10[1] = dArr11[1];
                    dArr10[2] = dArr11[2];
                }
                double v3Length = MatrixMathHelper.v3Length(dArr9[0]);
                dArr2[0] = v3Length;
                double[] v3Normalize = MatrixMathHelper.v3Normalize(dArr9[0], v3Length);
                dArr9[0] = v3Normalize;
                double v3Dot = MatrixMathHelper.v3Dot(v3Normalize, dArr9[1]);
                dArr3[0] = v3Dot;
                double[] v3Combine = MatrixMathHelper.v3Combine(dArr9[1], dArr9[0], 1.0d, -v3Dot);
                dArr9[1] = v3Combine;
                double v3Dot2 = MatrixMathHelper.v3Dot(dArr9[0], v3Combine);
                dArr3[0] = v3Dot2;
                double[] v3Combine2 = MatrixMathHelper.v3Combine(dArr9[1], dArr9[0], 1.0d, -v3Dot2);
                dArr9[1] = v3Combine2;
                double v3Length2 = MatrixMathHelper.v3Length(v3Combine2);
                dArr2[1] = v3Length2;
                dArr9[1] = MatrixMathHelper.v3Normalize(dArr9[1], v3Length2);
                dArr3[0] = dArr3[0] / dArr2[1];
                double v3Dot3 = MatrixMathHelper.v3Dot(dArr9[0], dArr9[2]);
                dArr3[1] = v3Dot3;
                double[] v3Combine3 = MatrixMathHelper.v3Combine(dArr9[2], dArr9[0], 1.0d, -v3Dot3);
                dArr9[2] = v3Combine3;
                double v3Dot4 = MatrixMathHelper.v3Dot(dArr9[1], v3Combine3);
                dArr3[2] = v3Dot4;
                double[] v3Combine4 = MatrixMathHelper.v3Combine(dArr9[2], dArr9[1], 1.0d, -v3Dot4);
                dArr9[2] = v3Combine4;
                double v3Length3 = MatrixMathHelper.v3Length(v3Combine4);
                dArr2[2] = v3Length3;
                double[] v3Normalize2 = MatrixMathHelper.v3Normalize(dArr9[2], v3Length3);
                dArr9[2] = v3Normalize2;
                double d2 = dArr3[1];
                double d3 = dArr2[2];
                dArr3[1] = d2 / d3;
                dArr3[2] = dArr3[2] / d3;
                if (MatrixMathHelper.v3Dot(dArr9[0], MatrixMathHelper.v3Cross(dArr9[1], v3Normalize2)) < 0.0d) {
                    for (int i5 = 0; i5 < 3; i5++) {
                        dArr2[i5] = dArr2[i5] * -1.0d;
                        double[] dArr12 = dArr9[i5];
                        dArr12[0] = dArr12[0] * -1.0d;
                        dArr12[1] = dArr12[1] * -1.0d;
                        dArr12[2] = dArr12[2] * -1.0d;
                    }
                }
                double[] dArr13 = dArr9[2];
                dArr5[0] = MatrixMathHelper.roundTo3Places((-Math.atan2(dArr13[1], dArr13[2])) * 57.29577951308232d);
                double[] dArr14 = dArr9[2];
                double d4 = dArr14[1];
                double d5 = dArr14[2];
                dArr5[1] = MatrixMathHelper.roundTo3Places((-Math.atan2(-dArr14[0], Math.sqrt((d4 * d4) + (d5 * d5)))) * 57.29577951308232d);
                dArr5[2] = MatrixMathHelper.roundTo3Places((-Math.atan2(dArr9[1][0], dArr9[0][0])) * 57.29577951308232d);
            }
        }
    }

    private static void setTransformProperty(View view, ReadableArray readableArray) {
        TransformHelper.processTransform(readableArray, sTransformDecompositionArray);
        decomposeMatrix();
        MatrixDecompositionContext matrixDecompositionContext = sMatrixDecompositionContext;
        view.setTranslationX(PixelUtil.toPixelFromDIP((float) matrixDecompositionContext.translation[0]));
        view.setTranslationY(PixelUtil.toPixelFromDIP((float) matrixDecompositionContext.translation[1]));
        view.setRotation((float) matrixDecompositionContext.rotationDegrees[2]);
        view.setRotationX((float) matrixDecompositionContext.rotationDegrees[0]);
        view.setRotationY((float) matrixDecompositionContext.rotationDegrees[1]);
        view.setScaleX((float) matrixDecompositionContext.scale[0]);
        view.setScaleY((float) matrixDecompositionContext.scale[1]);
        double[] dArr = matrixDecompositionContext.perspective;
        if (dArr.length > 2) {
            float f = (float) dArr[2];
            if (f == 0.0f) {
                f = 7.8125E-4f;
            }
            float f2 = -1.0f / f;
            float f3 = DisplayMetricsHolder.getScreenDisplayMetrics().density;
            view.setCameraDistance(f3 * f3 * f2 * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        }
    }

    private static void resetTransformProperty(View view) {
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        view.setRotation(0.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setCameraDistance(0.0f);
    }

    @Nonnull
    public String getName() {
        return this.mClassName;
    }

    @ReactProp(name = "mask")
    public void setMask(V v, String str) {
        v.setMask(str);
    }

    @ReactProp(name = "markerStart")
    public void setMarkerStart(V v, String str) {
        v.setMarkerStart(str);
    }

    @ReactProp(name = "markerMid")
    public void setMarkerMid(V v, String str) {
        v.setMarkerMid(str);
    }

    @ReactProp(name = "markerEnd")
    public void setMarkerEnd(V v, String str) {
        v.setMarkerEnd(str);
    }

    @ReactProp(name = "clipPath")
    public void setClipPath(V v, String str) {
        v.setClipPath(str);
    }

    @ReactProp(name = "clipRule")
    public void setClipRule(V v, int i) {
        v.setClipRule(i);
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(@Nonnull V v, float f) {
        v.setOpacity(f);
    }

    @ReactProp(name = "responsible")
    public void setResponsible(V v, boolean z) {
        v.setResponsible(z);
    }

    @ReactProp(name = "pointerEvents")
    public void setPointerEvents(V v, @Nullable String str) {
        if (str == null) {
            v.setPointerEvents(PointerEvents.AUTO);
        } else {
            v.setPointerEvents(PointerEvents.valueOf(str.toUpperCase(Locale.US).replace("-", "_")));
        }
    }

    @ReactProp(name = "onLayout")
    public void setOnLayout(V v, boolean z) {
        v.setOnLayout(z);
    }

    @ReactProp(name = "name")
    public void setName(V v, String str) {
        v.setName(str);
    }

    @ReactProp(name = "display")
    public void setDisplay(V v, String str) {
        v.setDisplay(str);
    }

    @ReactProp(name = "matrix")
    public void setMatrix(V v, Dynamic dynamic) {
        v.setMatrix(dynamic);
    }

    public void setMatrix(V v, @Nullable ReadableArray readableArray) {
        v.setMatrix(readableArray);
    }

    public void setTransform(VirtualView virtualView, @Nullable ReadableArray readableArray) {
        if (readableArray == null) {
            resetTransformProperty(virtualView);
        } else {
            setTransformProperty(virtualView, readableArray);
        }
        Matrix matrix = virtualView.getMatrix();
        virtualView.mTransform = matrix;
        virtualView.mTransformInvertible = matrix.invert(virtualView.mInvTransform);
    }

    @ReactProp(name = "transform")
    public void setTransform(V v, Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Array) {
            setTransform((VirtualView) v, dynamic.asArray());
        }
    }

    /* access modifiers changed from: private */
    public void invalidateSvgView(V v) {
        SvgView svgView = v.getSvgView();
        if (svgView != null) {
            svgView.invalidate();
        }
        if (v instanceof TextView) {
            ((TextView) v).getTextContainer().clearChildCache();
        }
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(@Nonnull ThemedReactContext themedReactContext, @Nonnull VirtualView virtualView) {
        super.addEventEmitters(themedReactContext, virtualView);
        virtualView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            public void onChildViewAdded(View view, View view2) {
                if (view instanceof VirtualView) {
                    VirtualViewManager.this.invalidateSvgView((VirtualView) view);
                }
            }

            public void onChildViewRemoved(View view, View view2) {
                if (view instanceof VirtualView) {
                    VirtualViewManager.this.invalidateSvgView((VirtualView) view);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(@Nonnull VirtualView virtualView) {
        super.onAfterUpdateTransaction(virtualView);
        invalidateSvgView(virtualView);
    }

    /* renamed from: com.horcrux.svg.VirtualViewManager$2  reason: invalid class name */
    /* compiled from: RenderableViewManager */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass;

        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.horcrux.svg.VirtualViewManager$SVGClass[] r0 = com.horcrux.svg.VirtualViewManager.SVGClass.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass = r0
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGGroup     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x001d }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGPath     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGCircle     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGEllipse     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x003e }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGLine     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGRect     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGText     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGTSpan     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x006c }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGTextPath     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGImage     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGClipPath     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGDefs     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x009c }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGUse     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGSymbol     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGLinearGradient     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGRadialGradient     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGPattern     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGMask     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGMarker     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = $SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.horcrux.svg.VirtualViewManager$SVGClass r1 = com.horcrux.svg.VirtualViewManager.SVGClass.RNSVGForeignObject     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.VirtualViewManager.AnonymousClass2.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    @Nonnull
    public VirtualView createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
        switch (AnonymousClass2.$SwitchMap$com$horcrux$svg$VirtualViewManager$SVGClass[this.svgClass.ordinal()]) {
            case 1:
                return new GroupView(themedReactContext);
            case 2:
                return new PathView(themedReactContext);
            case 3:
                return new CircleView(themedReactContext);
            case 4:
                return new EllipseView(themedReactContext);
            case 5:
                return new LineView(themedReactContext);
            case 6:
                return new RectView(themedReactContext);
            case 7:
                return new TextView(themedReactContext);
            case 8:
                return new TSpanView(themedReactContext);
            case 9:
                return new TextPathView(themedReactContext);
            case 10:
                return new ImageView(themedReactContext);
            case 11:
                return new ClipPathView(themedReactContext);
            case 12:
                return new DefsView(themedReactContext);
            case 13:
                return new UseView(themedReactContext);
            case 14:
                return new SymbolView(themedReactContext);
            case 15:
                return new LinearGradientView(themedReactContext);
            case 16:
                return new RadialGradientView(themedReactContext);
            case 17:
                return new PatternView(themedReactContext);
            case 18:
                return new MaskView(themedReactContext);
            case 19:
                return new MarkerView(themedReactContext);
            case 20:
                return new ForeignObjectView(themedReactContext);
            default:
                throw new IllegalStateException("Unexpected type " + this.svgClass.toString());
        }
    }

    static void setRenderableView(int i, RenderableView renderableView) {
        mTagToRenderableView.put(i, renderableView);
        SparseArray<Runnable> sparseArray = mTagToRunnable;
        Runnable runnable = sparseArray.get(i);
        if (runnable != null) {
            runnable.run();
            sparseArray.delete(i);
        }
    }

    static void runWhenViewIsAvailable(int i, Runnable runnable) {
        mTagToRunnable.put(i, runnable);
    }

    @Nullable
    static RenderableView getRenderableViewByTag(int i) {
        return mTagToRenderableView.get(i);
    }

    public void onDropViewInstance(@Nonnull VirtualView virtualView) {
        super.onDropViewInstance(virtualView);
        mTagToRenderableView.remove(virtualView.getId());
    }
}
