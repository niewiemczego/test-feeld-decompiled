package com.caverock.androidsvg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.ViewCompat;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.SVG;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
import org.apache.commons.io.FileUtils;

class SVGAndroidRenderer {
    private static final float BEZIER_ARC_FACTOR = 0.5522848f;
    private static final String DEFAULT_FONT_FAMILY = "serif";
    public static final float LUMINANCE_TO_ALPHA_BLUE = 0.0722f;
    public static final float LUMINANCE_TO_ALPHA_GREEN = 0.7151f;
    public static final float LUMINANCE_TO_ALPHA_RED = 0.2127f;
    private static final String TAG = "SVGAndroidRenderer";
    private static HashSet<String> supportedFeatures;
    /* access modifiers changed from: private */
    public Canvas canvas;
    private SVG document;
    private float dpi;
    private Stack<Matrix> matrixStack;
    private Stack<SVG.SvgContainer> parentStack;
    private CSSParser.RuleMatchContext ruleMatchContext = null;
    /* access modifiers changed from: private */
    public RendererState state;
    private Stack<RendererState> stateStack;

    private static int clamp255(float f) {
        int i = (int) (f * 256.0f);
        if (i < 0) {
            return 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
    }

    /* access modifiers changed from: private */
    public static void debug(String str, Object... objArr) {
    }

    private float dotProduct(float f, float f2, float f3, float f4) {
        return (f * f3) + (f2 * f4);
    }

    private class RendererState {
        Paint fillPaint;
        boolean hasFill;
        boolean hasStroke;
        boolean spacePreserve;
        Paint strokePaint;
        SVG.Style style;
        SVG.Box viewBox;
        SVG.Box viewPort;

        RendererState() {
            Paint paint = new Paint();
            this.fillPaint = paint;
            paint.setFlags(193);
            if (Build.VERSION.SDK_INT >= 14) {
                this.fillPaint.setHinting(0);
            }
            this.fillPaint.setStyle(Paint.Style.FILL);
            this.fillPaint.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.strokePaint = paint2;
            paint2.setFlags(193);
            if (Build.VERSION.SDK_INT >= 14) {
                this.strokePaint.setHinting(0);
            }
            this.strokePaint.setStyle(Paint.Style.STROKE);
            this.strokePaint.setTypeface(Typeface.DEFAULT);
            this.style = SVG.Style.getDefaultStyle();
        }

        RendererState(RendererState rendererState) {
            this.hasFill = rendererState.hasFill;
            this.hasStroke = rendererState.hasStroke;
            this.fillPaint = new Paint(rendererState.fillPaint);
            this.strokePaint = new Paint(rendererState.strokePaint);
            if (rendererState.viewPort != null) {
                this.viewPort = new SVG.Box(rendererState.viewPort);
            }
            if (rendererState.viewBox != null) {
                this.viewBox = new SVG.Box(rendererState.viewBox);
            }
            this.spacePreserve = rendererState.spacePreserve;
            try {
                this.style = (SVG.Style) rendererState.style.clone();
            } catch (CloneNotSupportedException e) {
                Log.e(SVGAndroidRenderer.TAG, "Unexpected clone error", e);
                this.style = SVG.Style.getDefaultStyle();
            }
        }
    }

    private void resetState() {
        this.state = new RendererState();
        this.stateStack = new Stack<>();
        updateStyle(this.state, SVG.Style.getDefaultStyle());
        this.state.viewPort = null;
        this.state.spacePreserve = false;
        this.stateStack.push(new RendererState(this.state));
        this.matrixStack = new Stack<>();
        this.parentStack = new Stack<>();
    }

    SVGAndroidRenderer(Canvas canvas2, float f) {
        this.canvas = canvas2;
        this.dpi = f;
    }

    /* access modifiers changed from: package-private */
    public float getDPI() {
        return this.dpi;
    }

    /* access modifiers changed from: package-private */
    public float getCurrentFontSize() {
        return this.state.fillPaint.getTextSize();
    }

    /* access modifiers changed from: package-private */
    public float getCurrentFontXHeight() {
        return this.state.fillPaint.getTextSize() / 2.0f;
    }

    /* access modifiers changed from: package-private */
    public SVG.Box getCurrentViewPortInUserUnits() {
        if (this.state.viewBox != null) {
            return this.state.viewBox;
        }
        return this.state.viewPort;
    }

    /* access modifiers changed from: package-private */
    public void renderDocument(SVG svg, RenderOptions renderOptions) {
        PreserveAspectRatio preserveAspectRatio;
        SVG.Box box;
        if (renderOptions != null) {
            this.document = svg;
            SVG.Svg rootElement = svg.getRootElement();
            if (rootElement == null) {
                warn("Nothing to render. Document is empty.", new Object[0]);
                return;
            }
            if (renderOptions.hasView()) {
                SVG.SvgElementBase elementById = this.document.getElementById(renderOptions.viewId);
                if (elementById == null || !(elementById instanceof SVG.View)) {
                    Log.w(TAG, String.format("View element with id \"%s\" not found.", new Object[]{renderOptions.viewId}));
                    return;
                }
                SVG.View view = (SVG.View) elementById;
                if (view.viewBox == null) {
                    Log.w(TAG, String.format("View element with id \"%s\" is missing a viewBox attribute.", new Object[]{renderOptions.viewId}));
                    return;
                } else {
                    box = view.viewBox;
                    preserveAspectRatio = view.preserveAspectRatio;
                }
            } else {
                box = renderOptions.hasViewBox() ? renderOptions.viewBox : rootElement.viewBox;
                preserveAspectRatio = renderOptions.hasPreserveAspectRatio() ? renderOptions.preserveAspectRatio : rootElement.preserveAspectRatio;
            }
            if (renderOptions.hasCss()) {
                svg.addCSSRules(renderOptions.css);
            }
            if (renderOptions.hasTarget()) {
                CSSParser.RuleMatchContext ruleMatchContext2 = new CSSParser.RuleMatchContext();
                this.ruleMatchContext = ruleMatchContext2;
                ruleMatchContext2.targetElement = svg.getElementById(renderOptions.targetId);
            }
            resetState();
            checkXMLSpaceAttribute(rootElement);
            statePush();
            SVG.Box box2 = new SVG.Box(renderOptions.viewPort);
            if (rootElement.width != null) {
                box2.width = rootElement.width.floatValue(this, box2.width);
            }
            if (rootElement.height != null) {
                box2.height = rootElement.height.floatValue(this, box2.height);
            }
            render(rootElement, box2, box, preserveAspectRatio);
            statePop();
            if (renderOptions.hasCss()) {
                svg.clearRenderCSSRules();
                return;
            }
            return;
        }
        throw new NullPointerException("renderOptions shouldn't be null");
    }

    private void render(SVG.SvgObject svgObject) {
        if (!(svgObject instanceof SVG.NotDirectlyRendered)) {
            statePush();
            checkXMLSpaceAttribute(svgObject);
            if (svgObject instanceof SVG.Svg) {
                render((SVG.Svg) svgObject);
            } else if (svgObject instanceof SVG.Use) {
                render((SVG.Use) svgObject);
            } else if (svgObject instanceof SVG.Switch) {
                render((SVG.Switch) svgObject);
            } else if (svgObject instanceof SVG.Group) {
                render((SVG.Group) svgObject);
            } else if (svgObject instanceof SVG.Image) {
                render((SVG.Image) svgObject);
            } else if (svgObject instanceof SVG.Path) {
                render((SVG.Path) svgObject);
            } else if (svgObject instanceof SVG.Rect) {
                render((SVG.Rect) svgObject);
            } else if (svgObject instanceof SVG.Circle) {
                render((SVG.Circle) svgObject);
            } else if (svgObject instanceof SVG.Ellipse) {
                render((SVG.Ellipse) svgObject);
            } else if (svgObject instanceof SVG.Line) {
                render((SVG.Line) svgObject);
            } else if (svgObject instanceof SVG.Polygon) {
                render((SVG.Polygon) svgObject);
            } else if (svgObject instanceof SVG.PolyLine) {
                render((SVG.PolyLine) svgObject);
            } else if (svgObject instanceof SVG.Text) {
                render((SVG.Text) svgObject);
            }
            statePop();
        }
    }

    private void renderChildren(SVG.SvgContainer svgContainer, boolean z) {
        if (z) {
            parentPush(svgContainer);
        }
        for (SVG.SvgObject render : svgContainer.getChildren()) {
            render(render);
        }
        if (z) {
            parentPop();
        }
    }

    private void statePush() {
        this.canvas.save();
        this.stateStack.push(this.state);
        this.state = new RendererState(this.state);
    }

    private void statePop() {
        this.canvas.restore();
        this.state = this.stateStack.pop();
    }

    private void parentPush(SVG.SvgContainer svgContainer) {
        this.parentStack.push(svgContainer);
        this.matrixStack.push(this.canvas.getMatrix());
    }

    private void parentPop() {
        this.parentStack.pop();
        this.matrixStack.pop();
    }

    private void updateStyleForElement(RendererState rendererState, SVG.SvgElementBase svgElementBase) {
        rendererState.style.resetNonInheritingProperties(svgElementBase.parent == null);
        if (svgElementBase.baseStyle != null) {
            updateStyle(rendererState, svgElementBase.baseStyle);
        }
        if (this.document.hasCSSRules()) {
            for (CSSParser.Rule next : this.document.getCSSRules()) {
                if (CSSParser.ruleMatch(this.ruleMatchContext, next.selector, svgElementBase)) {
                    updateStyle(rendererState, next.style);
                }
            }
        }
        if (svgElementBase.style != null) {
            updateStyle(rendererState, svgElementBase.style);
        }
    }

    private void checkXMLSpaceAttribute(SVG.SvgObject svgObject) {
        if (svgObject instanceof SVG.SvgElementBase) {
            SVG.SvgElementBase svgElementBase = (SVG.SvgElementBase) svgObject;
            if (svgElementBase.spacePreserve != null) {
                this.state.spacePreserve = svgElementBase.spacePreserve.booleanValue();
            }
        }
    }

    private void doFilledPath(SVG.SvgElement svgElement, Path path) {
        if (this.state.style.fill instanceof SVG.PaintReference) {
            SVG.SvgObject resolveIRI = this.document.resolveIRI(((SVG.PaintReference) this.state.style.fill).href);
            if (resolveIRI instanceof SVG.Pattern) {
                fillWithPattern(svgElement, path, (SVG.Pattern) resolveIRI);
                return;
            }
        }
        this.canvas.drawPath(path, this.state.fillPaint);
    }

    private void doStroke(Path path) {
        if (this.state.style.vectorEffect == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.canvas.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.canvas.setMatrix(new Matrix());
            Shader shader = this.state.strokePaint.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.canvas.drawPath(path2, this.state.strokePaint);
            this.canvas.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.canvas.drawPath(path, this.state.strokePaint);
    }

    /* access modifiers changed from: private */
    public static void warn(String str, Object... objArr) {
        Log.w(TAG, String.format(str, objArr));
    }

    /* access modifiers changed from: private */
    public static void error(String str, Object... objArr) {
        Log.e(TAG, String.format(str, objArr));
    }

    private void render(SVG.Svg svg) {
        render(svg, makeViewPort(svg.x, svg.y, svg.width, svg.height), svg.viewBox, svg.preserveAspectRatio);
    }

    private void render(SVG.Svg svg, SVG.Box box) {
        render(svg, box, svg.viewBox, svg.preserveAspectRatio);
    }

    private void render(SVG.Svg svg, SVG.Box box, SVG.Box box2, PreserveAspectRatio preserveAspectRatio) {
        debug("Svg render", new Object[0]);
        if (box.width != 0.0f && box.height != 0.0f) {
            if (preserveAspectRatio == null) {
                preserveAspectRatio = svg.preserveAspectRatio != null ? svg.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
            }
            updateStyleForElement(this.state, svg);
            if (display()) {
                this.state.viewPort = box;
                if (!this.state.style.overflow.booleanValue()) {
                    setClipRect(this.state.viewPort.minX, this.state.viewPort.minY, this.state.viewPort.width, this.state.viewPort.height);
                }
                checkForClipPath(svg, this.state.viewPort);
                if (box2 != null) {
                    this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box2, preserveAspectRatio));
                    this.state.viewBox = svg.viewBox;
                } else {
                    this.canvas.translate(this.state.viewPort.minX, this.state.viewPort.minY);
                }
                boolean pushLayer = pushLayer();
                viewportFill();
                renderChildren(svg, true);
                if (pushLayer) {
                    popLayer(svg);
                }
                updateParentBoundingBox(svg);
            }
        }
    }

    private SVG.Box makeViewPort(SVG.Length length, SVG.Length length2, SVG.Length length3, SVG.Length length4) {
        float f = 0.0f;
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        if (length2 != null) {
            f = length2.floatValueY(this);
        }
        SVG.Box currentViewPortInUserUnits = getCurrentViewPortInUserUnits();
        return new SVG.Box(floatValueX, f, length3 != null ? length3.floatValueX(this) : currentViewPortInUserUnits.width, length4 != null ? length4.floatValueY(this) : currentViewPortInUserUnits.height);
    }

    private void render(SVG.Group group) {
        debug("Group render", new Object[0]);
        updateStyleForElement(this.state, group);
        if (display()) {
            if (group.transform != null) {
                this.canvas.concat(group.transform);
            }
            checkForClipPath(group);
            boolean pushLayer = pushLayer();
            renderChildren(group, true);
            if (pushLayer) {
                popLayer(group);
            }
            updateParentBoundingBox(group);
        }
    }

    private void updateParentBoundingBox(SVG.SvgElement svgElement) {
        if (svgElement.parent != null && svgElement.boundingBox != null) {
            Matrix matrix = new Matrix();
            if (this.matrixStack.peek().invert(matrix)) {
                float[] fArr = {svgElement.boundingBox.minX, svgElement.boundingBox.minY, svgElement.boundingBox.maxX(), svgElement.boundingBox.minY, svgElement.boundingBox.maxX(), svgElement.boundingBox.maxY(), svgElement.boundingBox.minX, svgElement.boundingBox.maxY()};
                matrix.preConcat(this.canvas.getMatrix());
                matrix.mapPoints(fArr);
                float f = fArr[0];
                float f2 = fArr[1];
                RectF rectF = new RectF(f, f2, f, f2);
                for (int i = 2; i <= 6; i += 2) {
                    if (fArr[i] < rectF.left) {
                        rectF.left = fArr[i];
                    }
                    if (fArr[i] > rectF.right) {
                        rectF.right = fArr[i];
                    }
                    int i2 = i + 1;
                    if (fArr[i2] < rectF.top) {
                        rectF.top = fArr[i2];
                    }
                    if (fArr[i2] > rectF.bottom) {
                        rectF.bottom = fArr[i2];
                    }
                }
                SVG.SvgElement svgElement2 = (SVG.SvgElement) this.parentStack.peek();
                if (svgElement2.boundingBox == null) {
                    svgElement2.boundingBox = SVG.Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom);
                } else {
                    svgElement2.boundingBox.union(SVG.Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom));
                }
            }
        }
    }

    private boolean pushLayer() {
        SVG.SvgObject resolveIRI;
        if (!requiresCompositing()) {
            return false;
        }
        this.canvas.saveLayerAlpha((RectF) null, clamp255(this.state.style.opacity.floatValue()), 31);
        this.stateStack.push(this.state);
        RendererState rendererState = new RendererState(this.state);
        this.state = rendererState;
        if (rendererState.style.mask != null && ((resolveIRI = this.document.resolveIRI(this.state.style.mask)) == null || !(resolveIRI instanceof SVG.Mask))) {
            error("Mask reference '%s' not found", this.state.style.mask);
            this.state.style.mask = null;
        }
        return true;
    }

    private void popLayer(SVG.SvgElement svgElement) {
        popLayer(svgElement, svgElement.boundingBox);
    }

    private void popLayer(SVG.SvgElement svgElement, SVG.Box box) {
        if (this.state.style.mask != null) {
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.canvas.saveLayer((RectF) null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            this.canvas.saveLayer((RectF) null, paint2, 31);
            SVG.Mask mask = (SVG.Mask) this.document.resolveIRI(this.state.style.mask);
            renderMask(mask, svgElement, box);
            this.canvas.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.canvas.saveLayer((RectF) null, paint3, 31);
            renderMask(mask, svgElement, box);
            this.canvas.restore();
            this.canvas.restore();
        }
        statePop();
    }

    private boolean requiresCompositing() {
        return this.state.style.opacity.floatValue() < 1.0f || this.state.style.mask != null;
    }

    private void render(SVG.Switch switchR) {
        debug("Switch render", new Object[0]);
        updateStyleForElement(this.state, switchR);
        if (display()) {
            if (switchR.transform != null) {
                this.canvas.concat(switchR.transform);
            }
            checkForClipPath(switchR);
            boolean pushLayer = pushLayer();
            renderSwitchChild(switchR);
            if (pushLayer) {
                popLayer(switchR);
            }
            updateParentBoundingBox(switchR);
        }
    }

    private void renderSwitchChild(SVG.Switch switchR) {
        Set<String> systemLanguage;
        String language = Locale.getDefault().getLanguage();
        SVGExternalFileResolver fileResolver = SVG.getFileResolver();
        for (SVG.SvgObject next : switchR.getChildren()) {
            if (next instanceof SVG.SvgConditional) {
                SVG.SvgConditional svgConditional = (SVG.SvgConditional) next;
                if (svgConditional.getRequiredExtensions() == null && ((systemLanguage = svgConditional.getSystemLanguage()) == null || (!systemLanguage.isEmpty() && systemLanguage.contains(language)))) {
                    Set<String> requiredFeatures = svgConditional.getRequiredFeatures();
                    if (requiredFeatures != null) {
                        if (supportedFeatures == null) {
                            initialiseSupportedFeaturesMap();
                        }
                        if (requiredFeatures.isEmpty()) {
                            continue;
                        } else if (!supportedFeatures.containsAll(requiredFeatures)) {
                            continue;
                        }
                    }
                    Set<String> requiredFormats = svgConditional.getRequiredFormats();
                    if (requiredFormats != null) {
                        if (!requiredFormats.isEmpty() && fileResolver != null) {
                            Iterator<String> it = requiredFormats.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (!fileResolver.isFormatSupported(it.next())) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                    Set<String> requiredFonts = svgConditional.getRequiredFonts();
                    if (requiredFonts != null) {
                        if (!requiredFonts.isEmpty() && fileResolver != null) {
                            for (String resolveFont : requiredFonts) {
                                if (fileResolver.resolveFont(resolveFont, this.state.style.fontWeight.intValue(), String.valueOf(this.state.style.fontStyle)) == null) {
                                }
                            }
                        }
                    }
                    render(next);
                    return;
                }
            }
        }
    }

    private static synchronized void initialiseSupportedFeaturesMap() {
        synchronized (SVGAndroidRenderer.class) {
            HashSet<String> hashSet = new HashSet<>();
            supportedFeatures = hashSet;
            hashSet.add("Structure");
            supportedFeatures.add("BasicStructure");
            supportedFeatures.add("ConditionalProcessing");
            supportedFeatures.add("Image");
            supportedFeatures.add("Style");
            supportedFeatures.add("ViewportAttribute");
            supportedFeatures.add("Shape");
            supportedFeatures.add("BasicText");
            supportedFeatures.add("PaintAttribute");
            supportedFeatures.add("BasicPaintAttribute");
            supportedFeatures.add("OpacityAttribute");
            supportedFeatures.add("BasicGraphicsAttribute");
            supportedFeatures.add("Marker");
            supportedFeatures.add("Gradient");
            supportedFeatures.add("Pattern");
            supportedFeatures.add("Clip");
            supportedFeatures.add("BasicClip");
            supportedFeatures.add("Mask");
            supportedFeatures.add("View");
        }
    }

    private void render(SVG.Use use) {
        debug("Use render", new Object[0]);
        if (use.width != null && use.width.isZero()) {
            return;
        }
        if (use.height == null || !use.height.isZero()) {
            updateStyleForElement(this.state, use);
            if (display()) {
                SVG.SvgObject resolveIRI = use.document.resolveIRI(use.href);
                if (resolveIRI == null) {
                    error("Use reference '%s' not found", use.href);
                    return;
                }
                if (use.transform != null) {
                    this.canvas.concat(use.transform);
                }
                float f = 0.0f;
                float floatValueX = use.x != null ? use.x.floatValueX(this) : 0.0f;
                if (use.y != null) {
                    f = use.y.floatValueY(this);
                }
                this.canvas.translate(floatValueX, f);
                checkForClipPath(use);
                boolean pushLayer = pushLayer();
                parentPush(use);
                if (resolveIRI instanceof SVG.Svg) {
                    SVG.Box makeViewPort = makeViewPort((SVG.Length) null, (SVG.Length) null, use.width, use.height);
                    statePush();
                    render((SVG.Svg) resolveIRI, makeViewPort);
                    statePop();
                } else if (resolveIRI instanceof SVG.Symbol) {
                    SVG.Box makeViewPort2 = makeViewPort((SVG.Length) null, (SVG.Length) null, use.width != null ? use.width : new SVG.Length(100.0f, SVG.Unit.percent), use.height != null ? use.height : new SVG.Length(100.0f, SVG.Unit.percent));
                    statePush();
                    render((SVG.Symbol) resolveIRI, makeViewPort2);
                    statePop();
                } else {
                    render(resolveIRI);
                }
                parentPop();
                if (pushLayer) {
                    popLayer(use);
                }
                updateParentBoundingBox(use);
            }
        }
    }

    private void render(SVG.Path path) {
        debug("Path render", new Object[0]);
        if (path.d != null) {
            updateStyleForElement(this.state, path);
            if (!display() || !visible()) {
                return;
            }
            if (this.state.hasStroke || this.state.hasFill) {
                if (path.transform != null) {
                    this.canvas.concat(path.transform);
                }
                Path path2 = new PathConverter(path.d).getPath();
                if (path.boundingBox == null) {
                    path.boundingBox = calculatePathBounds(path2);
                }
                updateParentBoundingBox(path);
                checkForGradientsAndPatterns(path);
                checkForClipPath(path);
                boolean pushLayer = pushLayer();
                if (this.state.hasFill) {
                    path2.setFillType(getFillTypeFromState());
                    doFilledPath(path, path2);
                }
                if (this.state.hasStroke) {
                    doStroke(path2);
                }
                renderMarkers(path);
                if (pushLayer) {
                    popLayer(path);
                }
            }
        }
    }

    private SVG.Box calculatePathBounds(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.Box(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private void render(SVG.Rect rect) {
        debug("Rect render", new Object[0]);
        if (rect.width != null && rect.height != null && !rect.width.isZero() && !rect.height.isZero()) {
            updateStyleForElement(this.state, rect);
            if (display() && visible()) {
                if (rect.transform != null) {
                    this.canvas.concat(rect.transform);
                }
                Path makePathAndBoundingBox = makePathAndBoundingBox(rect);
                updateParentBoundingBox(rect);
                checkForGradientsAndPatterns(rect);
                checkForClipPath(rect);
                boolean pushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(rect, makePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(makePathAndBoundingBox);
                }
                if (pushLayer) {
                    popLayer(rect);
                }
            }
        }
    }

    private void render(SVG.Circle circle) {
        debug("Circle render", new Object[0]);
        if (circle.r != null && !circle.r.isZero()) {
            updateStyleForElement(this.state, circle);
            if (display() && visible()) {
                if (circle.transform != null) {
                    this.canvas.concat(circle.transform);
                }
                Path makePathAndBoundingBox = makePathAndBoundingBox(circle);
                updateParentBoundingBox(circle);
                checkForGradientsAndPatterns(circle);
                checkForClipPath(circle);
                boolean pushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(circle, makePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(makePathAndBoundingBox);
                }
                if (pushLayer) {
                    popLayer(circle);
                }
            }
        }
    }

    private void render(SVG.Ellipse ellipse) {
        debug("Ellipse render", new Object[0]);
        if (ellipse.rx != null && ellipse.ry != null && !ellipse.rx.isZero() && !ellipse.ry.isZero()) {
            updateStyleForElement(this.state, ellipse);
            if (display() && visible()) {
                if (ellipse.transform != null) {
                    this.canvas.concat(ellipse.transform);
                }
                Path makePathAndBoundingBox = makePathAndBoundingBox(ellipse);
                updateParentBoundingBox(ellipse);
                checkForGradientsAndPatterns(ellipse);
                checkForClipPath(ellipse);
                boolean pushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(ellipse, makePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(makePathAndBoundingBox);
                }
                if (pushLayer) {
                    popLayer(ellipse);
                }
            }
        }
    }

    private void render(SVG.Line line) {
        debug("Line render", new Object[0]);
        updateStyleForElement(this.state, line);
        if (display() && visible() && this.state.hasStroke) {
            if (line.transform != null) {
                this.canvas.concat(line.transform);
            }
            Path makePathAndBoundingBox = makePathAndBoundingBox(line);
            updateParentBoundingBox(line);
            checkForGradientsAndPatterns(line);
            checkForClipPath(line);
            boolean pushLayer = pushLayer();
            doStroke(makePathAndBoundingBox);
            renderMarkers(line);
            if (pushLayer) {
                popLayer(line);
            }
        }
    }

    private List<MarkerVector> calculateMarkerPositions(SVG.Line line) {
        float f = 0.0f;
        float floatValueX = line.x1 != null ? line.x1.floatValueX(this) : 0.0f;
        float floatValueY = line.y1 != null ? line.y1.floatValueY(this) : 0.0f;
        float floatValueX2 = line.x2 != null ? line.x2.floatValueX(this) : 0.0f;
        if (line.y2 != null) {
            f = line.y2.floatValueY(this);
        }
        float f2 = f;
        ArrayList arrayList = new ArrayList(2);
        float f3 = floatValueX2 - floatValueX;
        float f4 = f2 - floatValueY;
        arrayList.add(new MarkerVector(floatValueX, floatValueY, f3, f4));
        arrayList.add(new MarkerVector(floatValueX2, f2, f3, f4));
        return arrayList;
    }

    private void render(SVG.PolyLine polyLine) {
        debug("PolyLine render", new Object[0]);
        updateStyleForElement(this.state, polyLine);
        if (!display() || !visible()) {
            return;
        }
        if (this.state.hasStroke || this.state.hasFill) {
            if (polyLine.transform != null) {
                this.canvas.concat(polyLine.transform);
            }
            if (polyLine.points.length >= 2) {
                Path makePathAndBoundingBox = makePathAndBoundingBox(polyLine);
                updateParentBoundingBox(polyLine);
                makePathAndBoundingBox.setFillType(getFillTypeFromState());
                checkForGradientsAndPatterns(polyLine);
                checkForClipPath(polyLine);
                boolean pushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(polyLine, makePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(makePathAndBoundingBox);
                }
                renderMarkers(polyLine);
                if (pushLayer) {
                    popLayer(polyLine);
                }
            }
        }
    }

    private List<MarkerVector> calculateMarkerPositions(SVG.PolyLine polyLine) {
        SVG.PolyLine polyLine2 = polyLine;
        int length = polyLine2.points.length;
        int i = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        MarkerVector markerVector = new MarkerVector(polyLine2.points[0], polyLine2.points[1], 0.0f, 0.0f);
        float f = 0.0f;
        float f2 = 0.0f;
        while (i < length) {
            f = polyLine2.points[i];
            f2 = polyLine2.points[i + 1];
            markerVector.add(f, f2);
            arrayList.add(markerVector);
            i += 2;
            markerVector = new MarkerVector(f, f2, f - markerVector.x, f2 - markerVector.y);
        }
        if (!(polyLine2 instanceof SVG.Polygon)) {
            arrayList.add(markerVector);
        } else if (!(f == polyLine2.points[0] || f2 == polyLine2.points[1])) {
            float f3 = polyLine2.points[0];
            float f4 = polyLine2.points[1];
            markerVector.add(f3, f4);
            arrayList.add(markerVector);
            MarkerVector markerVector2 = new MarkerVector(f3, f4, f3 - markerVector.x, f4 - markerVector.y);
            markerVector2.add((MarkerVector) arrayList.get(0));
            arrayList.add(markerVector2);
            arrayList.set(0, markerVector2);
        }
        return arrayList;
    }

    private void render(SVG.Polygon polygon) {
        debug("Polygon render", new Object[0]);
        updateStyleForElement(this.state, polygon);
        if (!display() || !visible()) {
            return;
        }
        if (this.state.hasStroke || this.state.hasFill) {
            if (polygon.transform != null) {
                this.canvas.concat(polygon.transform);
            }
            if (polygon.points.length >= 2) {
                Path makePathAndBoundingBox = makePathAndBoundingBox((SVG.PolyLine) polygon);
                updateParentBoundingBox(polygon);
                checkForGradientsAndPatterns(polygon);
                checkForClipPath(polygon);
                boolean pushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(polygon, makePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(makePathAndBoundingBox);
                }
                renderMarkers(polygon);
                if (pushLayer) {
                    popLayer(polygon);
                }
            }
        }
    }

    private void render(SVG.Text text) {
        debug("Text render", new Object[0]);
        updateStyleForElement(this.state, text);
        if (display()) {
            if (text.transform != null) {
                this.canvas.concat(text.transform);
            }
            float f = 0.0f;
            float floatValueX = (text.x == null || text.x.size() == 0) ? 0.0f : ((SVG.Length) text.x.get(0)).floatValueX(this);
            float floatValueY = (text.y == null || text.y.size() == 0) ? 0.0f : ((SVG.Length) text.y.get(0)).floatValueY(this);
            float floatValueX2 = (text.dx == null || text.dx.size() == 0) ? 0.0f : ((SVG.Length) text.dx.get(0)).floatValueX(this);
            if (!(text.dy == null || text.dy.size() == 0)) {
                f = ((SVG.Length) text.dy.get(0)).floatValueY(this);
            }
            SVG.Style.TextAnchor anchorPosition = getAnchorPosition();
            if (anchorPosition != SVG.Style.TextAnchor.Start) {
                float calculateTextWidth = calculateTextWidth(text);
                if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                    calculateTextWidth /= 2.0f;
                }
                floatValueX -= calculateTextWidth;
            }
            if (text.boundingBox == null) {
                TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(floatValueX, floatValueY);
                enumerateTextSpans(text, textBoundsCalculator);
                text.boundingBox = new SVG.Box(textBoundsCalculator.bbox.left, textBoundsCalculator.bbox.top, textBoundsCalculator.bbox.width(), textBoundsCalculator.bbox.height());
            }
            updateParentBoundingBox(text);
            checkForGradientsAndPatterns(text);
            checkForClipPath(text);
            boolean pushLayer = pushLayer();
            enumerateTextSpans(text, new PlainTextDrawer(floatValueX + floatValueX2, floatValueY + f));
            if (pushLayer) {
                popLayer(text);
            }
        }
    }

    private SVG.Style.TextAnchor getAnchorPosition() {
        if (this.state.style.direction == SVG.Style.TextDirection.LTR || this.state.style.textAnchor == SVG.Style.TextAnchor.Middle) {
            return this.state.style.textAnchor;
        }
        return this.state.style.textAnchor == SVG.Style.TextAnchor.Start ? SVG.Style.TextAnchor.End : SVG.Style.TextAnchor.Start;
    }

    private class PlainTextDrawer extends TextProcessor {
        float x;
        float y;

        PlainTextDrawer(float f, float f2) {
            super(SVGAndroidRenderer.this, (AnonymousClass1) null);
            this.x = f;
            this.y = f2;
        }

        public void processText(String str) {
            SVGAndroidRenderer.debug("TextSequence render", new Object[0]);
            if (SVGAndroidRenderer.this.visible()) {
                if (SVGAndroidRenderer.this.state.hasFill) {
                    SVGAndroidRenderer.this.canvas.drawText(str, this.x, this.y, SVGAndroidRenderer.this.state.fillPaint);
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawText(str, this.x, this.y, SVGAndroidRenderer.this.state.strokePaint);
                }
            }
            this.x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    private abstract class TextProcessor {
        public boolean doTextContainer(SVG.TextContainer textContainer) {
            return true;
        }

        public abstract void processText(String str);

        private TextProcessor() {
        }

        /* synthetic */ TextProcessor(SVGAndroidRenderer sVGAndroidRenderer, AnonymousClass1 r2) {
            this();
        }
    }

    private void enumerateTextSpans(SVG.TextContainer textContainer, TextProcessor textProcessor) {
        if (display()) {
            Iterator it = textContainer.children.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.SvgObject svgObject = (SVG.SvgObject) it.next();
                if (svgObject instanceof SVG.TextSequence) {
                    textProcessor.processText(textXMLSpaceTransform(((SVG.TextSequence) svgObject).text, z, !it.hasNext()));
                } else {
                    processTextChild(svgObject, textProcessor);
                }
                z = false;
            }
        }
    }

    private void processTextChild(SVG.SvgObject svgObject, TextProcessor textProcessor) {
        float f;
        float f2;
        float f3;
        SVG.Style.TextAnchor anchorPosition;
        if (textProcessor.doTextContainer((SVG.TextContainer) svgObject)) {
            if (svgObject instanceof SVG.TextPath) {
                statePush();
                renderTextPath((SVG.TextPath) svgObject);
                statePop();
                return;
            }
            boolean z = true;
            if (svgObject instanceof SVG.TSpan) {
                debug("TSpan render", new Object[0]);
                statePush();
                SVG.TSpan tSpan = (SVG.TSpan) svgObject;
                updateStyleForElement(this.state, tSpan);
                if (display()) {
                    if (tSpan.x == null || tSpan.x.size() <= 0) {
                        z = false;
                    }
                    boolean z2 = textProcessor instanceof PlainTextDrawer;
                    float f4 = 0.0f;
                    if (z2) {
                        float floatValueX = !z ? ((PlainTextDrawer) textProcessor).x : ((SVG.Length) tSpan.x.get(0)).floatValueX(this);
                        f2 = (tSpan.y == null || tSpan.y.size() == 0) ? ((PlainTextDrawer) textProcessor).y : ((SVG.Length) tSpan.y.get(0)).floatValueY(this);
                        f = (tSpan.dx == null || tSpan.dx.size() == 0) ? 0.0f : ((SVG.Length) tSpan.dx.get(0)).floatValueX(this);
                        if (!(tSpan.dy == null || tSpan.dy.size() == 0)) {
                            f4 = ((SVG.Length) tSpan.dy.get(0)).floatValueY(this);
                        }
                        f3 = f4;
                        f4 = floatValueX;
                    } else {
                        f3 = 0.0f;
                        f2 = 0.0f;
                        f = 0.0f;
                    }
                    if (z && (anchorPosition = getAnchorPosition()) != SVG.Style.TextAnchor.Start) {
                        float calculateTextWidth = calculateTextWidth(tSpan);
                        if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                            calculateTextWidth /= 2.0f;
                        }
                        f4 -= calculateTextWidth;
                    }
                    checkForGradientsAndPatterns((SVG.SvgElement) tSpan.getTextRoot());
                    if (z2) {
                        PlainTextDrawer plainTextDrawer = (PlainTextDrawer) textProcessor;
                        plainTextDrawer.x = f4 + f;
                        plainTextDrawer.y = f2 + f3;
                    }
                    boolean pushLayer = pushLayer();
                    enumerateTextSpans(tSpan, textProcessor);
                    if (pushLayer) {
                        popLayer(tSpan);
                    }
                }
                statePop();
            } else if (svgObject instanceof SVG.TRef) {
                statePush();
                SVG.TRef tRef = (SVG.TRef) svgObject;
                updateStyleForElement(this.state, tRef);
                if (display()) {
                    checkForGradientsAndPatterns((SVG.SvgElement) tRef.getTextRoot());
                    SVG.SvgObject resolveIRI = svgObject.document.resolveIRI(tRef.href);
                    if (resolveIRI == null || !(resolveIRI instanceof SVG.TextContainer)) {
                        error("Tref reference '%s' not found", tRef.href);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        extractRawText((SVG.TextContainer) resolveIRI, sb);
                        if (sb.length() > 0) {
                            textProcessor.processText(sb.toString());
                        }
                    }
                }
                statePop();
            }
        }
    }

    private void renderTextPath(SVG.TextPath textPath) {
        debug("TextPath render", new Object[0]);
        updateStyleForElement(this.state, textPath);
        if (display() && visible()) {
            SVG.SvgObject resolveIRI = textPath.document.resolveIRI(textPath.href);
            if (resolveIRI == null) {
                error("TextPath reference '%s' not found", textPath.href);
                return;
            }
            SVG.Path path = (SVG.Path) resolveIRI;
            Path path2 = new PathConverter(path.d).getPath();
            if (path.transform != null) {
                path2.transform(path.transform);
            }
            float floatValue = textPath.startOffset != null ? textPath.startOffset.floatValue(this, new PathMeasure(path2, false).getLength()) : 0.0f;
            SVG.Style.TextAnchor anchorPosition = getAnchorPosition();
            if (anchorPosition != SVG.Style.TextAnchor.Start) {
                float calculateTextWidth = calculateTextWidth(textPath);
                if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                    calculateTextWidth /= 2.0f;
                }
                floatValue -= calculateTextWidth;
            }
            checkForGradientsAndPatterns((SVG.SvgElement) textPath.getTextRoot());
            boolean pushLayer = pushLayer();
            enumerateTextSpans(textPath, new PathTextDrawer(path2, floatValue, 0.0f));
            if (pushLayer) {
                popLayer(textPath);
            }
        }
    }

    private class PathTextDrawer extends PlainTextDrawer {
        private Path path;

        PathTextDrawer(Path path2, float f, float f2) {
            super(f, f2);
            this.path = path2;
        }

        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                if (SVGAndroidRenderer.this.state.hasFill) {
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(str, this.path, this.x, this.y, SVGAndroidRenderer.this.state.fillPaint);
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(str, this.path, this.x, this.y, SVGAndroidRenderer.this.state.strokePaint);
                }
            }
            this.x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    private float calculateTextWidth(SVG.TextContainer textContainer) {
        TextWidthCalculator textWidthCalculator = new TextWidthCalculator(this, (AnonymousClass1) null);
        enumerateTextSpans(textContainer, textWidthCalculator);
        return textWidthCalculator.x;
    }

    private class TextWidthCalculator extends TextProcessor {
        float x;

        private TextWidthCalculator() {
            super(SVGAndroidRenderer.this, (AnonymousClass1) null);
            this.x = 0.0f;
        }

        /* synthetic */ TextWidthCalculator(SVGAndroidRenderer sVGAndroidRenderer, AnonymousClass1 r2) {
            this();
        }

        public void processText(String str) {
            this.x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    private class TextBoundsCalculator extends TextProcessor {
        RectF bbox = new RectF();
        float x;
        float y;

        TextBoundsCalculator(float f, float f2) {
            super(SVGAndroidRenderer.this, (AnonymousClass1) null);
            this.x = f;
            this.y = f2;
        }

        public boolean doTextContainer(SVG.TextContainer textContainer) {
            if (!(textContainer instanceof SVG.TextPath)) {
                return true;
            }
            SVG.TextPath textPath = (SVG.TextPath) textContainer;
            SVG.SvgObject resolveIRI = textContainer.document.resolveIRI(textPath.href);
            if (resolveIRI == null) {
                SVGAndroidRenderer.error("TextPath path reference '%s' not found", textPath.href);
                return false;
            }
            SVG.Path path = (SVG.Path) resolveIRI;
            Path path2 = new PathConverter(path.d).getPath();
            if (path.transform != null) {
                path2.transform(path.transform);
            }
            RectF rectF = new RectF();
            path2.computeBounds(rectF, true);
            this.bbox.union(rectF);
            return false;
        }

        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                Rect rect = new Rect();
                SVGAndroidRenderer.this.state.fillPaint.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.x, this.y);
                this.bbox.union(rectF);
            }
            this.x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    private void extractRawText(SVG.TextContainer textContainer, StringBuilder sb) {
        Iterator it = textContainer.children.iterator();
        boolean z = true;
        while (it.hasNext()) {
            SVG.SvgObject svgObject = (SVG.SvgObject) it.next();
            if (svgObject instanceof SVG.TextContainer) {
                extractRawText((SVG.TextContainer) svgObject, sb);
            } else if (svgObject instanceof SVG.TextSequence) {
                sb.append(textXMLSpaceTransform(((SVG.TextSequence) svgObject).text, z, !it.hasNext()));
            }
            z = false;
        }
    }

    private String textXMLSpaceTransform(String str, boolean z, boolean z2) {
        if (this.state.spacePreserve) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String replaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (z) {
            replaceAll = replaceAll.replaceAll("^\\s+", "");
        }
        if (z2) {
            replaceAll = replaceAll.replaceAll("\\s+$", "");
        }
        return replaceAll.replaceAll("\\s{2,}", " ");
    }

    private void render(SVG.Symbol symbol, SVG.Box box) {
        debug("Symbol render", new Object[0]);
        if (box.width != 0.0f && box.height != 0.0f) {
            PreserveAspectRatio preserveAspectRatio = symbol.preserveAspectRatio != null ? symbol.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
            updateStyleForElement(this.state, symbol);
            this.state.viewPort = box;
            if (!this.state.style.overflow.booleanValue()) {
                setClipRect(this.state.viewPort.minX, this.state.viewPort.minY, this.state.viewPort.width, this.state.viewPort.height);
            }
            if (symbol.viewBox != null) {
                this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, symbol.viewBox, preserveAspectRatio));
                this.state.viewBox = symbol.viewBox;
            } else {
                this.canvas.translate(this.state.viewPort.minX, this.state.viewPort.minY);
            }
            boolean pushLayer = pushLayer();
            renderChildren(symbol, true);
            if (pushLayer) {
                popLayer(symbol);
            }
            updateParentBoundingBox(symbol);
        }
    }

    private void render(SVG.Image image) {
        int i = 0;
        debug("Image render", new Object[0]);
        if (image.width != null && !image.width.isZero() && image.height != null && !image.height.isZero() && image.href != null) {
            PreserveAspectRatio preserveAspectRatio = image.preserveAspectRatio != null ? image.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
            Bitmap checkForImageDataURL = checkForImageDataURL(image.href);
            if (checkForImageDataURL == null) {
                SVGExternalFileResolver fileResolver = SVG.getFileResolver();
                if (fileResolver != null) {
                    checkForImageDataURL = fileResolver.resolveImage(image.href);
                } else {
                    return;
                }
            }
            if (checkForImageDataURL == null) {
                error("Could not locate image '%s'", image.href);
                return;
            }
            SVG.Box box = new SVG.Box(0.0f, 0.0f, (float) checkForImageDataURL.getWidth(), (float) checkForImageDataURL.getHeight());
            updateStyleForElement(this.state, image);
            if (display() && visible()) {
                if (image.transform != null) {
                    this.canvas.concat(image.transform);
                }
                this.state.viewPort = new SVG.Box(image.x != null ? image.x.floatValueX(this) : 0.0f, image.y != null ? image.y.floatValueY(this) : 0.0f, image.width.floatValueX(this), image.height.floatValueX(this));
                if (!this.state.style.overflow.booleanValue()) {
                    setClipRect(this.state.viewPort.minX, this.state.viewPort.minY, this.state.viewPort.width, this.state.viewPort.height);
                }
                image.boundingBox = this.state.viewPort;
                updateParentBoundingBox(image);
                checkForClipPath(image);
                boolean pushLayer = pushLayer();
                viewportFill();
                this.canvas.save();
                this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box, preserveAspectRatio));
                if (this.state.style.imageRendering != SVG.Style.RenderQuality.optimizeSpeed) {
                    i = 2;
                }
                this.canvas.drawBitmap(checkForImageDataURL, 0.0f, 0.0f, new Paint(i));
                this.canvas.restore();
                if (pushLayer) {
                    popLayer(image);
                }
            }
        }
    }

    private Bitmap checkForImageDataURL(String str) {
        int indexOf;
        if (!str.startsWith("data:") || str.length() < 14 || (indexOf = str.indexOf(44)) < 12 || !";base64".equals(str.substring(indexOf - 7, indexOf))) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e) {
            Log.e(TAG, "Could not decode bad Data URL", e);
            return null;
        }
    }

    private boolean display() {
        if (this.state.style.display != null) {
            return this.state.style.display.booleanValue();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean visible() {
        if (this.state.style.visibility != null) {
            return this.state.style.visibility.booleanValue();
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0066, code lost:
        r3 = r3 - r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0084, code lost:
        if (r11 != 8) goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Matrix calculateViewBoxTransform(com.caverock.androidsvg.SVG.Box r9, com.caverock.androidsvg.SVG.Box r10, com.caverock.androidsvg.PreserveAspectRatio r11) {
        /*
            r8 = this;
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            if (r11 == 0) goto L_0x009d
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = r11.getAlignment()
            if (r1 != 0) goto L_0x000f
            goto L_0x009d
        L_0x000f:
            float r1 = r9.width
            float r2 = r10.width
            float r1 = r1 / r2
            float r2 = r9.height
            float r3 = r10.height
            float r2 = r2 / r3
            float r3 = r10.minX
            float r3 = -r3
            float r4 = r10.minY
            float r4 = -r4
            com.caverock.androidsvg.PreserveAspectRatio r5 = com.caverock.androidsvg.PreserveAspectRatio.STRETCH
            boolean r5 = r11.equals(r5)
            if (r5 == 0) goto L_0x0035
            float r10 = r9.minX
            float r9 = r9.minY
            r0.preTranslate(r10, r9)
            r0.preScale(r1, r2)
            r0.preTranslate(r3, r4)
            return r0
        L_0x0035:
            com.caverock.androidsvg.PreserveAspectRatio$Scale r5 = r11.getScale()
            com.caverock.androidsvg.PreserveAspectRatio$Scale r6 = com.caverock.androidsvg.PreserveAspectRatio.Scale.slice
            if (r5 != r6) goto L_0x0042
            float r1 = java.lang.Math.max(r1, r2)
            goto L_0x0046
        L_0x0042:
            float r1 = java.lang.Math.min(r1, r2)
        L_0x0046:
            float r2 = r9.width
            float r2 = r2 / r1
            float r5 = r9.height
            float r5 = r5 / r1
            int[] r6 = com.caverock.androidsvg.SVGAndroidRenderer.AnonymousClass1.$SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r7 = r11.getAlignment()
            int r7 = r7.ordinal()
            r6 = r6[r7]
            r7 = 1073741824(0x40000000, float:2.0)
            switch(r6) {
                case 1: goto L_0x0062;
                case 2: goto L_0x0062;
                case 3: goto L_0x0062;
                case 4: goto L_0x005e;
                case 5: goto L_0x005e;
                case 6: goto L_0x005e;
                default: goto L_0x005d;
            }
        L_0x005d:
            goto L_0x0067
        L_0x005e:
            float r6 = r10.width
            float r6 = r6 - r2
            goto L_0x0066
        L_0x0062:
            float r6 = r10.width
            float r6 = r6 - r2
            float r6 = r6 / r7
        L_0x0066:
            float r3 = r3 - r6
        L_0x0067:
            int[] r2 = com.caverock.androidsvg.SVGAndroidRenderer.AnonymousClass1.$SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r11 = r11.getAlignment()
            int r11 = r11.ordinal()
            r11 = r2[r11]
            r2 = 2
            if (r11 == r2) goto L_0x008b
            r2 = 3
            if (r11 == r2) goto L_0x0087
            r2 = 5
            if (r11 == r2) goto L_0x008b
            r2 = 6
            if (r11 == r2) goto L_0x0087
            r2 = 7
            if (r11 == r2) goto L_0x008b
            r2 = 8
            if (r11 == r2) goto L_0x0087
            goto L_0x0090
        L_0x0087:
            float r10 = r10.height
            float r10 = r10 - r5
            goto L_0x008f
        L_0x008b:
            float r10 = r10.height
            float r10 = r10 - r5
            float r10 = r10 / r7
        L_0x008f:
            float r4 = r4 - r10
        L_0x0090:
            float r10 = r9.minX
            float r9 = r9.minY
            r0.preTranslate(r10, r9)
            r0.preScale(r1, r1)
            r0.preTranslate(r3, r4)
        L_0x009d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.calculateViewBoxTransform(com.caverock.androidsvg.SVG$Box, com.caverock.androidsvg.SVG$Box, com.caverock.androidsvg.PreserveAspectRatio):android.graphics.Matrix");
    }

    private boolean isSpecified(SVG.Style style, long j) {
        return (style.specifiedFlags & j) != 0;
    }

    private void updateStyle(RendererState rendererState, SVG.Style style) {
        if (isSpecified(style, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)) {
            rendererState.style.color = style.color;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH)) {
            rendererState.style.opacity = style.opacity;
        }
        boolean z = false;
        if (isSpecified(style, 1)) {
            rendererState.style.fill = style.fill;
            rendererState.hasFill = (style.fill == null || style.fill == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (isSpecified(style, 4)) {
            rendererState.style.fillOpacity = style.fillOpacity;
        }
        if (isSpecified(style, 6149)) {
            setPaintColour(rendererState, true, rendererState.style.fill);
        }
        if (isSpecified(style, 2)) {
            rendererState.style.fillRule = style.fillRule;
        }
        if (isSpecified(style, 8)) {
            rendererState.style.stroke = style.stroke;
            rendererState.hasStroke = (style.stroke == null || style.stroke == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (isSpecified(style, 16)) {
            rendererState.style.strokeOpacity = style.strokeOpacity;
        }
        if (isSpecified(style, 6168)) {
            setPaintColour(rendererState, false, rendererState.style.stroke);
        }
        if (isSpecified(style, 34359738368L)) {
            rendererState.style.vectorEffect = style.vectorEffect;
        }
        if (isSpecified(style, 32)) {
            rendererState.style.strokeWidth = style.strokeWidth;
            rendererState.strokePaint.setStrokeWidth(rendererState.style.strokeWidth.floatValue(this));
        }
        if (isSpecified(style, 64)) {
            rendererState.style.strokeLineCap = style.strokeLineCap;
            int i = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap[style.strokeLineCap.ordinal()];
            if (i == 1) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.BUTT);
            } else if (i == 2) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.ROUND);
            } else if (i == 3) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (isSpecified(style, 128)) {
            rendererState.style.strokeLineJoin = style.strokeLineJoin;
            int i2 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin[style.strokeLineJoin.ordinal()];
            if (i2 == 1) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.MITER);
            } else if (i2 == 2) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.ROUND);
            } else if (i2 == 3) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (isSpecified(style, 256)) {
            rendererState.style.strokeMiterLimit = style.strokeMiterLimit;
            rendererState.strokePaint.setStrokeMiter(style.strokeMiterLimit.floatValue());
        }
        if (isSpecified(style, 512)) {
            rendererState.style.strokeDashArray = style.strokeDashArray;
        }
        if (isSpecified(style, 1024)) {
            rendererState.style.strokeDashOffset = style.strokeDashOffset;
        }
        Typeface typeface = null;
        if (isSpecified(style, 1536)) {
            if (rendererState.style.strokeDashArray == null) {
                rendererState.strokePaint.setPathEffect((PathEffect) null);
            } else {
                int length = rendererState.style.strokeDashArray.length;
                int i3 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i3];
                float f = 0.0f;
                for (int i4 = 0; i4 < i3; i4++) {
                    float floatValue = rendererState.style.strokeDashArray[i4 % length].floatValue(this);
                    fArr[i4] = floatValue;
                    f += floatValue;
                }
                if (f == 0.0f) {
                    rendererState.strokePaint.setPathEffect((PathEffect) null);
                } else {
                    float floatValue2 = rendererState.style.strokeDashOffset.floatValue(this);
                    if (floatValue2 < 0.0f) {
                        floatValue2 = (floatValue2 % f) + f;
                    }
                    rendererState.strokePaint.setPathEffect(new DashPathEffect(fArr, floatValue2));
                }
            }
        }
        if (isSpecified(style, 16384)) {
            float currentFontSize = getCurrentFontSize();
            rendererState.style.fontSize = style.fontSize;
            rendererState.fillPaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
            rendererState.strokePaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_PLAY_FROM_URI)) {
            rendererState.style.fontFamily = style.fontFamily;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
            if (style.fontWeight.intValue() == -1 && rendererState.style.fontWeight.intValue() > 100) {
                SVG.Style style2 = rendererState.style;
                style2.fontWeight = Integer.valueOf(style2.fontWeight.intValue() - 100);
            } else if (style.fontWeight.intValue() != 1 || rendererState.style.fontWeight.intValue() >= 900) {
                rendererState.style.fontWeight = style.fontWeight;
            } else {
                SVG.Style style3 = rendererState.style;
                style3.fontWeight = Integer.valueOf(style3.fontWeight.intValue() + 100);
            }
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH)) {
            rendererState.style.fontStyle = style.fontStyle;
        }
        if (isSpecified(style, 106496)) {
            if (rendererState.style.fontFamily != null && this.document != null) {
                SVGExternalFileResolver fileResolver = SVG.getFileResolver();
                for (String next : rendererState.style.fontFamily) {
                    Typeface checkGenericFont = checkGenericFont(next, rendererState.style.fontWeight, rendererState.style.fontStyle);
                    if (checkGenericFont != null || fileResolver == null) {
                        typeface = checkGenericFont;
                        continue;
                    } else {
                        typeface = fileResolver.resolveFont(next, rendererState.style.fontWeight.intValue(), String.valueOf(rendererState.style.fontStyle));
                        continue;
                    }
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                typeface = checkGenericFont("serif", rendererState.style.fontWeight, rendererState.style.fontStyle);
            }
            rendererState.fillPaint.setTypeface(typeface);
            rendererState.strokePaint.setTypeface(typeface);
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) {
            rendererState.style.textDecoration = style.textDecoration;
            rendererState.fillPaint.setStrikeThruText(style.textDecoration == SVG.Style.TextDecoration.LineThrough);
            rendererState.fillPaint.setUnderlineText(style.textDecoration == SVG.Style.TextDecoration.Underline);
            if (Build.VERSION.SDK_INT >= 17) {
                rendererState.strokePaint.setStrikeThruText(style.textDecoration == SVG.Style.TextDecoration.LineThrough);
                Paint paint = rendererState.strokePaint;
                if (style.textDecoration == SVG.Style.TextDecoration.Underline) {
                    z = true;
                }
                paint.setUnderlineText(z);
            }
        }
        if (isSpecified(style, 68719476736L)) {
            rendererState.style.direction = style.direction;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            rendererState.style.textAnchor = style.textAnchor;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            rendererState.style.overflow = style.overflow;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
            rendererState.style.markerStart = style.markerStart;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED)) {
            rendererState.style.markerMid = style.markerMid;
        }
        if (isSpecified(style, 8388608)) {
            rendererState.style.markerEnd = style.markerEnd;
        }
        if (isSpecified(style, 16777216)) {
            rendererState.style.display = style.display;
        }
        if (isSpecified(style, 33554432)) {
            rendererState.style.visibility = style.visibility;
        }
        if (isSpecified(style, 1048576)) {
            rendererState.style.clip = style.clip;
        }
        if (isSpecified(style, 268435456)) {
            rendererState.style.clipPath = style.clipPath;
        }
        if (isSpecified(style, 536870912)) {
            rendererState.style.clipRule = style.clipRule;
        }
        if (isSpecified(style, FileUtils.ONE_GB)) {
            rendererState.style.mask = style.mask;
        }
        if (isSpecified(style, 67108864)) {
            rendererState.style.stopColor = style.stopColor;
        }
        if (isSpecified(style, 134217728)) {
            rendererState.style.stopOpacity = style.stopOpacity;
        }
        if (isSpecified(style, 8589934592L)) {
            rendererState.style.viewportFill = style.viewportFill;
        }
        if (isSpecified(style, 17179869184L)) {
            rendererState.style.viewportFillOpacity = style.viewportFillOpacity;
        }
        if (isSpecified(style, 137438953472L)) {
            rendererState.style.imageRendering = style.imageRendering;
        }
    }

    /* renamed from: com.caverock.androidsvg.SVGAndroidRenderer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment;
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap;
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0068 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0088 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0093 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x009e */
        static {
            /*
                com.caverock.androidsvg.SVG$Style$LineJoin[] r0 = com.caverock.androidsvg.SVG.Style.LineJoin.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin = r0
                r1 = 1
                com.caverock.androidsvg.SVG$Style$LineJoin r2 = com.caverock.androidsvg.SVG.Style.LineJoin.Miter     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin     // Catch:{ NoSuchFieldError -> 0x001d }
                com.caverock.androidsvg.SVG$Style$LineJoin r3 = com.caverock.androidsvg.SVG.Style.LineJoin.Round     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.caverock.androidsvg.SVG$Style$LineJoin r4 = com.caverock.androidsvg.SVG.Style.LineJoin.Bevel     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.caverock.androidsvg.SVG$Style$LineCap[] r3 = com.caverock.androidsvg.SVG.Style.LineCap.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap = r3
                com.caverock.androidsvg.SVG$Style$LineCap r4 = com.caverock.androidsvg.SVG.Style.LineCap.Butt     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.caverock.androidsvg.SVG$Style$LineCap r4 = com.caverock.androidsvg.SVG.Style.LineCap.Round     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap     // Catch:{ NoSuchFieldError -> 0x004d }
                com.caverock.androidsvg.SVG$Style$LineCap r4 = com.caverock.androidsvg.SVG.Style.LineCap.Square     // Catch:{ NoSuchFieldError -> 0x004d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                com.caverock.androidsvg.PreserveAspectRatio$Alignment[] r3 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment = r3
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r4 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMidYMin     // Catch:{ NoSuchFieldError -> 0x005e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r1 = $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment     // Catch:{ NoSuchFieldError -> 0x0068 }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r3 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMidYMid     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment     // Catch:{ NoSuchFieldError -> 0x0072 }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMidYMax     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment     // Catch:{ NoSuchFieldError -> 0x007d }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMaxYMin     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment     // Catch:{ NoSuchFieldError -> 0x0088 }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMaxYMid     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment     // Catch:{ NoSuchFieldError -> 0x0093 }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMaxYMax     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment     // Catch:{ NoSuchFieldError -> 0x009e }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMinYMid     // Catch:{ NoSuchFieldError -> 0x009e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment     // Catch:{ NoSuchFieldError -> 0x00aa }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMinYMax     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.AnonymousClass1.<clinit>():void");
        }
    }

    private void setPaintColour(RendererState rendererState, boolean z, SVG.SvgPaint svgPaint) {
        int i;
        SVG.Style style = rendererState.style;
        float floatValue = (z ? style.fillOpacity : style.strokeOpacity).floatValue();
        if (svgPaint instanceof SVG.Colour) {
            i = ((SVG.Colour) svgPaint).colour;
        } else if (svgPaint instanceof SVG.CurrentColor) {
            i = rendererState.style.color.colour;
        } else {
            return;
        }
        int colourWithOpacity = colourWithOpacity(i, floatValue);
        if (z) {
            rendererState.fillPaint.setColor(colourWithOpacity);
        } else {
            rendererState.strokePaint.setColor(colourWithOpacity);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
        if (r6.equals("monospace") == false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Typeface checkGenericFont(java.lang.String r6, java.lang.Integer r7, com.caverock.androidsvg.SVG.Style.FontStyle r8) {
        /*
            r5 = this;
            com.caverock.androidsvg.SVG$Style$FontStyle r0 = com.caverock.androidsvg.SVG.Style.FontStyle.Italic
            r1 = 1
            r2 = 0
            if (r8 != r0) goto L_0x0008
            r8 = r1
            goto L_0x0009
        L_0x0008:
            r8 = r2
        L_0x0009:
            int r7 = r7.intValue()
            r0 = 500(0x1f4, float:7.0E-43)
            r3 = 3
            r4 = 2
            if (r7 <= r0) goto L_0x0019
            if (r8 == 0) goto L_0x0017
            r7 = r3
            goto L_0x001e
        L_0x0017:
            r7 = r1
            goto L_0x001e
        L_0x0019:
            if (r8 == 0) goto L_0x001d
            r7 = r4
            goto L_0x001e
        L_0x001d:
            r7 = r2
        L_0x001e:
            r6.hashCode()
            r8 = -1
            int r0 = r6.hashCode()
            switch(r0) {
                case -1536685117: goto L_0x0055;
                case -1431958525: goto L_0x004c;
                case -1081737434: goto L_0x0041;
                case 109326717: goto L_0x0036;
                case 1126973893: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            r1 = r8
            goto L_0x005f
        L_0x002b:
            java.lang.String r0 = "cursive"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            r1 = 4
            goto L_0x005f
        L_0x0036:
            java.lang.String r0 = "serif"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x003f
            goto L_0x0029
        L_0x003f:
            r1 = r3
            goto L_0x005f
        L_0x0041:
            java.lang.String r0 = "fantasy"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x004a
            goto L_0x0029
        L_0x004a:
            r1 = r4
            goto L_0x005f
        L_0x004c:
            java.lang.String r0 = "monospace"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x005f
            goto L_0x0029
        L_0x0055:
            java.lang.String r0 = "sans-serif"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x005e
            goto L_0x0029
        L_0x005e:
            r1 = r2
        L_0x005f:
            switch(r1) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0079;
                case 2: goto L_0x0072;
                case 3: goto L_0x006b;
                case 4: goto L_0x0064;
                default: goto L_0x0062;
            }
        L_0x0062:
            r6 = 0
            goto L_0x0086
        L_0x0064:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x006b:
            android.graphics.Typeface r6 = android.graphics.Typeface.SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x0072:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x0079:
            android.graphics.Typeface r6 = android.graphics.Typeface.MONOSPACE
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x0080:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
        L_0x0086:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.checkGenericFont(java.lang.String, java.lang.Integer, com.caverock.androidsvg.SVG$Style$FontStyle):android.graphics.Typeface");
    }

    private static int colourWithOpacity(int i, float f) {
        int i2 = 255;
        int round = Math.round(((float) ((i >> 24) & 255)) * f);
        if (round < 0) {
            i2 = 0;
        } else if (round <= 255) {
            i2 = round;
        }
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (i2 << 24);
    }

    private Path.FillType getFillTypeFromState() {
        if (this.state.style.fillRule == null || this.state.style.fillRule != SVG.Style.FillRule.EvenOdd) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    private void setClipRect(float f, float f2, float f3, float f4) {
        float f5 = f3 + f;
        float f6 = f4 + f2;
        if (this.state.style.clip != null) {
            f += this.state.style.clip.left.floatValueX(this);
            f2 += this.state.style.clip.top.floatValueY(this);
            f5 -= this.state.style.clip.right.floatValueX(this);
            f6 -= this.state.style.clip.bottom.floatValueY(this);
        }
        this.canvas.clipRect(f, f2, f5, f6);
    }

    private void viewportFill() {
        int i;
        if (this.state.style.viewportFill instanceof SVG.Colour) {
            i = ((SVG.Colour) this.state.style.viewportFill).colour;
        } else if (this.state.style.viewportFill instanceof SVG.CurrentColor) {
            i = this.state.style.color.colour;
        } else {
            return;
        }
        if (this.state.style.viewportFillOpacity != null) {
            i = colourWithOpacity(i, this.state.style.viewportFillOpacity.floatValue());
        }
        this.canvas.drawColor(i);
    }

    private class PathConverter implements SVG.PathInterface {
        float lastX;
        float lastY;
        Path path = new Path();

        PathConverter(SVG.PathDefinition pathDefinition) {
            if (pathDefinition != null) {
                pathDefinition.enumeratePath(this);
            }
        }

        /* access modifiers changed from: package-private */
        public Path getPath() {
            return this.path;
        }

        public void moveTo(float f, float f2) {
            this.path.moveTo(f, f2);
            this.lastX = f;
            this.lastY = f2;
        }

        public void lineTo(float f, float f2) {
            this.path.lineTo(f, f2);
            this.lastX = f;
            this.lastY = f2;
        }

        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            this.path.cubicTo(f, f2, f3, f4, f5, f6);
            this.lastX = f5;
            this.lastY = f6;
        }

        public void quadTo(float f, float f2, float f3, float f4) {
            this.path.quadTo(f, f2, f3, f4);
            this.lastX = f3;
            this.lastY = f4;
        }

        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            SVGAndroidRenderer.arcTo(this.lastX, this.lastY, f, f2, f3, z, z2, f4, f5, this);
            this.lastX = f4;
            this.lastY = f5;
        }

        public void close() {
            this.path.close();
        }
    }

    /* access modifiers changed from: private */
    public static void arcTo(float f, float f2, float f3, float f4, float f5, boolean z, boolean z2, float f6, float f7, SVG.PathInterface pathInterface) {
        float f8;
        SVG.PathInterface pathInterface2;
        float f9 = f5;
        boolean z3 = z2;
        float f10 = f6;
        float f11 = f7;
        if (f != f10 || f2 != f11) {
            if (f3 == 0.0f) {
                f8 = f10;
                pathInterface2 = pathInterface;
            } else if (f4 == 0.0f) {
                pathInterface2 = pathInterface;
                f8 = f10;
            } else {
                float abs = Math.abs(f3);
                float abs2 = Math.abs(f4);
                double radians = Math.toRadians(((double) f9) % 360.0d);
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d = ((double) (f - f10)) / 2.0d;
                double d2 = ((double) (f2 - f11)) / 2.0d;
                double d3 = (cos * d) + (sin * d2);
                double d4 = ((-sin) * d) + (d2 * cos);
                double d5 = (double) (abs * abs);
                double d6 = (double) (abs2 * abs2);
                double d7 = d3 * d3;
                double d8 = d4 * d4;
                double d9 = (d7 / d5) + (d8 / d6);
                if (d9 > 0.99999d) {
                    double sqrt = Math.sqrt(d9) * 1.00001d;
                    abs = (float) (((double) abs) * sqrt);
                    abs2 = (float) (sqrt * ((double) abs2));
                    d5 = (double) (abs * abs);
                    d6 = (double) (abs2 * abs2);
                }
                double d10 = -1.0d;
                double d11 = z == z3 ? -1.0d : 1.0d;
                double d12 = d5 * d6;
                double d13 = d5 * d8;
                double d14 = d6 * d7;
                double d15 = ((d12 - d13) - d14) / (d13 + d14);
                if (d15 < 0.0d) {
                    d15 = 0.0d;
                }
                double sqrt2 = d11 * Math.sqrt(d15);
                double d16 = (double) abs;
                double d17 = (double) abs2;
                double d18 = ((d16 * d4) / d17) * sqrt2;
                float f12 = abs2;
                double d19 = sqrt2 * (-((d17 * d3) / d16));
                float f13 = abs;
                double d20 = (((double) (f + f6)) / 2.0d) + ((cos * d18) - (sin * d19));
                double d21 = (((double) (f2 + f7)) / 2.0d) + (sin * d18) + (cos * d19);
                double d22 = (d3 - d18) / d16;
                double d23 = (d4 - d19) / d17;
                double d24 = ((-d3) - d18) / d16;
                double d25 = ((-d4) - d19) / d17;
                double d26 = (d22 * d22) + (d23 * d23);
                double acos = (d23 < 0.0d ? -1.0d : 1.0d) * Math.acos(d22 / Math.sqrt(d26));
                double sqrt3 = Math.sqrt(d26 * ((d24 * d24) + (d25 * d25)));
                double d27 = (d22 * d24) + (d23 * d25);
                if ((d22 * d25) - (d23 * d24) >= 0.0d) {
                    d10 = 1.0d;
                }
                double checkedArcCos = d10 * checkedArcCos(d27 / sqrt3);
                if (!z2 && checkedArcCos > 0.0d) {
                    checkedArcCos -= 6.283185307179586d;
                } else if (z2 && checkedArcCos < 0.0d) {
                    checkedArcCos += 6.283185307179586d;
                }
                float[] arcToBeziers = arcToBeziers(acos % 6.283185307179586d, checkedArcCos % 6.283185307179586d);
                Matrix matrix = new Matrix();
                matrix.postScale(f13, f12);
                matrix.postRotate(f5);
                matrix.postTranslate((float) d20, (float) d21);
                matrix.mapPoints(arcToBeziers);
                arcToBeziers[arcToBeziers.length - 2] = f6;
                arcToBeziers[arcToBeziers.length - 1] = f7;
                for (int i = 0; i < arcToBeziers.length; i += 6) {
                    pathInterface.cubicTo(arcToBeziers[i], arcToBeziers[i + 1], arcToBeziers[i + 2], arcToBeziers[i + 3], arcToBeziers[i + 4], arcToBeziers[i + 5]);
                }
                return;
            }
            pathInterface2.lineTo(f8, f11);
        }
    }

    private static double checkedArcCos(double d) {
        if (d < -1.0d) {
            return 3.141592653589793d;
        }
        if (d > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d);
    }

    private static float[] arcToBeziers(double d, double d2) {
        int ceil = (int) Math.ceil((Math.abs(d2) * 2.0d) / 3.141592653589793d);
        double d3 = d2 / ((double) ceil);
        double d4 = d3 / 2.0d;
        double sin = (Math.sin(d4) * 1.3333333333333333d) / (Math.cos(d4) + 1.0d);
        float[] fArr = new float[(ceil * 6)];
        int i = 0;
        for (int i2 = 0; i2 < ceil; i2++) {
            double d5 = d + (((double) i2) * d3);
            double cos = Math.cos(d5);
            double sin2 = Math.sin(d5);
            int i3 = i + 1;
            fArr[i] = (float) (cos - (sin * sin2));
            int i4 = i3 + 1;
            fArr[i3] = (float) (sin2 + (cos * sin));
            d3 = d3;
            double d6 = d5 + d3;
            double cos2 = Math.cos(d6);
            double sin3 = Math.sin(d6);
            int i5 = i4 + 1;
            fArr[i4] = (float) ((sin * sin3) + cos2);
            int i6 = i5 + 1;
            fArr[i5] = (float) (sin3 - (sin * cos2));
            int i7 = i6 + 1;
            fArr[i6] = (float) cos2;
            i = i7 + 1;
            fArr[i7] = (float) sin3;
        }
        return fArr;
    }

    private class MarkerVector {
        float dx = 0.0f;
        float dy = 0.0f;
        boolean isAmbiguous = false;
        float x;
        float y;

        MarkerVector(float f, float f2, float f3, float f4) {
            this.x = f;
            this.y = f2;
            double sqrt = Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
            if (sqrt != 0.0d) {
                this.dx = (float) (((double) f3) / sqrt);
                this.dy = (float) (((double) f4) / sqrt);
            }
        }

        /* access modifiers changed from: package-private */
        public void add(float f, float f2) {
            float f3 = f - this.x;
            float f4 = f2 - this.y;
            double sqrt = Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
            if (sqrt != 0.0d) {
                f3 = (float) (((double) f3) / sqrt);
                f4 = (float) (((double) f4) / sqrt);
            }
            float f5 = this.dx;
            if (f3 == (-f5) && f4 == (-this.dy)) {
                this.isAmbiguous = true;
                this.dx = -f4;
                this.dy = f3;
                return;
            }
            this.dx = f5 + f3;
            this.dy += f4;
        }

        /* access modifiers changed from: package-private */
        public void add(MarkerVector markerVector) {
            float f = markerVector.dx;
            float f2 = this.dx;
            if (f == (-f2)) {
                float f3 = markerVector.dy;
                if (f3 == (-this.dy)) {
                    this.isAmbiguous = true;
                    this.dx = -f3;
                    this.dy = markerVector.dx;
                    return;
                }
            }
            this.dx = f2 + f;
            this.dy += markerVector.dy;
        }

        public String toString() {
            return "(" + this.x + "," + this.y + " " + this.dx + "," + this.dy + ")";
        }
    }

    private class MarkerPositionCalculator implements SVG.PathInterface {
        private boolean closepathReAdjustPending;
        private MarkerVector lastPos = null;
        private List<MarkerVector> markers = new ArrayList();
        private boolean normalCubic = true;
        private boolean startArc = false;
        private float startX;
        private float startY;
        private int subpathStartIndex = -1;

        MarkerPositionCalculator(SVG.PathDefinition pathDefinition) {
            if (pathDefinition != null) {
                pathDefinition.enumeratePath(this);
                if (this.closepathReAdjustPending) {
                    this.lastPos.add(this.markers.get(this.subpathStartIndex));
                    this.markers.set(this.subpathStartIndex, this.lastPos);
                    this.closepathReAdjustPending = false;
                }
                MarkerVector markerVector = this.lastPos;
                if (markerVector != null) {
                    this.markers.add(markerVector);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public List<MarkerVector> getMarkers() {
            return this.markers;
        }

        public void moveTo(float f, float f2) {
            if (this.closepathReAdjustPending) {
                this.lastPos.add(this.markers.get(this.subpathStartIndex));
                this.markers.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            MarkerVector markerVector = this.lastPos;
            if (markerVector != null) {
                this.markers.add(markerVector);
            }
            this.startX = f;
            this.startY = f2;
            this.lastPos = new MarkerVector(f, f2, 0.0f, 0.0f);
            this.subpathStartIndex = this.markers.size();
        }

        public void lineTo(float f, float f2) {
            this.lastPos.add(f, f2);
            this.markers.add(this.lastPos);
            this.lastPos = new MarkerVector(f, f2, f - this.lastPos.x, f2 - this.lastPos.y);
            this.closepathReAdjustPending = false;
        }

        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            if (this.normalCubic || this.startArc) {
                this.lastPos.add(f, f2);
                this.markers.add(this.lastPos);
                this.startArc = false;
            }
            this.lastPos = new MarkerVector(f5, f6, f5 - f3, f6 - f4);
            this.closepathReAdjustPending = false;
        }

        public void quadTo(float f, float f2, float f3, float f4) {
            this.lastPos.add(f, f2);
            this.markers.add(this.lastPos);
            this.lastPos = new MarkerVector(f3, f4, f3 - f, f4 - f2);
            this.closepathReAdjustPending = false;
        }

        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.startArc = true;
            this.normalCubic = false;
            SVGAndroidRenderer.arcTo(this.lastPos.x, this.lastPos.y, f, f2, f3, z, z2, f4, f5, this);
            this.normalCubic = true;
            this.closepathReAdjustPending = false;
        }

        public void close() {
            this.markers.add(this.lastPos);
            lineTo(this.startX, this.startY);
            this.closepathReAdjustPending = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void renderMarkers(com.caverock.androidsvg.SVG.GraphicsElement r11) {
        /*
            r10 = this;
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r0 = r10.state
            com.caverock.androidsvg.SVG$Style r0 = r0.style
            java.lang.String r0 = r0.markerStart
            if (r0 != 0) goto L_0x0019
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r0 = r10.state
            com.caverock.androidsvg.SVG$Style r0 = r0.style
            java.lang.String r0 = r0.markerMid
            if (r0 != 0) goto L_0x0019
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r0 = r10.state
            com.caverock.androidsvg.SVG$Style r0 = r0.style
            java.lang.String r0 = r0.markerEnd
            if (r0 != 0) goto L_0x0019
            return
        L_0x0019:
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r0 = r10.state
            com.caverock.androidsvg.SVG$Style r0 = r0.style
            java.lang.String r0 = r0.markerStart
            java.lang.String r1 = "Marker reference '%s' not found"
            r2 = 0
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0044
            com.caverock.androidsvg.SVG r0 = r11.document
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r5 = r10.state
            com.caverock.androidsvg.SVG$Style r5 = r5.style
            java.lang.String r5 = r5.markerStart
            com.caverock.androidsvg.SVG$SvgObject r0 = r0.resolveIRI(r5)
            if (r0 == 0) goto L_0x0037
            com.caverock.androidsvg.SVG$Marker r0 = (com.caverock.androidsvg.SVG.Marker) r0
            goto L_0x0045
        L_0x0037:
            java.lang.Object[] r0 = new java.lang.Object[r4]
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r5 = r10.state
            com.caverock.androidsvg.SVG$Style r5 = r5.style
            java.lang.String r5 = r5.markerStart
            r0[r3] = r5
            error(r1, r0)
        L_0x0044:
            r0 = r2
        L_0x0045:
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r5 = r10.state
            com.caverock.androidsvg.SVG$Style r5 = r5.style
            java.lang.String r5 = r5.markerMid
            if (r5 == 0) goto L_0x006b
            com.caverock.androidsvg.SVG r5 = r11.document
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r6 = r10.state
            com.caverock.androidsvg.SVG$Style r6 = r6.style
            java.lang.String r6 = r6.markerMid
            com.caverock.androidsvg.SVG$SvgObject r5 = r5.resolveIRI(r6)
            if (r5 == 0) goto L_0x005e
            com.caverock.androidsvg.SVG$Marker r5 = (com.caverock.androidsvg.SVG.Marker) r5
            goto L_0x006c
        L_0x005e:
            java.lang.Object[] r5 = new java.lang.Object[r4]
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r6 = r10.state
            com.caverock.androidsvg.SVG$Style r6 = r6.style
            java.lang.String r6 = r6.markerMid
            r5[r3] = r6
            error(r1, r5)
        L_0x006b:
            r5 = r2
        L_0x006c:
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r6 = r10.state
            com.caverock.androidsvg.SVG$Style r6 = r6.style
            java.lang.String r6 = r6.markerEnd
            if (r6 == 0) goto L_0x0092
            com.caverock.androidsvg.SVG r6 = r11.document
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r7 = r10.state
            com.caverock.androidsvg.SVG$Style r7 = r7.style
            java.lang.String r7 = r7.markerEnd
            com.caverock.androidsvg.SVG$SvgObject r6 = r6.resolveIRI(r7)
            if (r6 == 0) goto L_0x0085
            com.caverock.androidsvg.SVG$Marker r6 = (com.caverock.androidsvg.SVG.Marker) r6
            goto L_0x0093
        L_0x0085:
            java.lang.Object[] r6 = new java.lang.Object[r4]
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r7 = r10.state
            com.caverock.androidsvg.SVG$Style r7 = r7.style
            java.lang.String r7 = r7.markerEnd
            r6[r3] = r7
            error(r1, r6)
        L_0x0092:
            r6 = r2
        L_0x0093:
            boolean r1 = r11 instanceof com.caverock.androidsvg.SVG.Path
            if (r1 == 0) goto L_0x00a5
            com.caverock.androidsvg.SVGAndroidRenderer$MarkerPositionCalculator r1 = new com.caverock.androidsvg.SVGAndroidRenderer$MarkerPositionCalculator
            com.caverock.androidsvg.SVG$Path r11 = (com.caverock.androidsvg.SVG.Path) r11
            com.caverock.androidsvg.SVG$PathDefinition r11 = r11.d
            r1.<init>(r11)
            java.util.List r11 = r1.getMarkers()
            goto L_0x00b6
        L_0x00a5:
            boolean r1 = r11 instanceof com.caverock.androidsvg.SVG.Line
            if (r1 == 0) goto L_0x00b0
            com.caverock.androidsvg.SVG$Line r11 = (com.caverock.androidsvg.SVG.Line) r11
            java.util.List r11 = r10.calculateMarkerPositions((com.caverock.androidsvg.SVG.Line) r11)
            goto L_0x00b6
        L_0x00b0:
            com.caverock.androidsvg.SVG$PolyLine r11 = (com.caverock.androidsvg.SVG.PolyLine) r11
            java.util.List r11 = r10.calculateMarkerPositions((com.caverock.androidsvg.SVG.PolyLine) r11)
        L_0x00b6:
            if (r11 != 0) goto L_0x00b9
            return
        L_0x00b9:
            int r1 = r11.size()
            if (r1 != 0) goto L_0x00c0
            return
        L_0x00c0:
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r7 = r10.state
            com.caverock.androidsvg.SVG$Style r7 = r7.style
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r8 = r10.state
            com.caverock.androidsvg.SVG$Style r8 = r8.style
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r9 = r10.state
            com.caverock.androidsvg.SVG$Style r9 = r9.style
            r9.markerEnd = r2
            r8.markerMid = r2
            r7.markerStart = r2
            if (r0 == 0) goto L_0x00dd
            java.lang.Object r2 = r11.get(r3)
            com.caverock.androidsvg.SVGAndroidRenderer$MarkerVector r2 = (com.caverock.androidsvg.SVGAndroidRenderer.MarkerVector) r2
            r10.renderMarker(r0, r2)
        L_0x00dd:
            if (r5 == 0) goto L_0x010e
            int r0 = r11.size()
            r2 = 2
            if (r0 <= r2) goto L_0x010e
            java.lang.Object r0 = r11.get(r3)
            com.caverock.androidsvg.SVGAndroidRenderer$MarkerVector r0 = (com.caverock.androidsvg.SVGAndroidRenderer.MarkerVector) r0
            java.lang.Object r2 = r11.get(r4)
            com.caverock.androidsvg.SVGAndroidRenderer$MarkerVector r2 = (com.caverock.androidsvg.SVGAndroidRenderer.MarkerVector) r2
            r3 = r4
        L_0x00f3:
            int r7 = r1 + -1
            if (r3 >= r7) goto L_0x010e
            int r3 = r3 + 1
            java.lang.Object r7 = r11.get(r3)
            com.caverock.androidsvg.SVGAndroidRenderer$MarkerVector r7 = (com.caverock.androidsvg.SVGAndroidRenderer.MarkerVector) r7
            boolean r8 = r2.isAmbiguous
            if (r8 == 0) goto L_0x0108
            com.caverock.androidsvg.SVGAndroidRenderer$MarkerVector r0 = r10.realignMarkerMid(r0, r2, r7)
            goto L_0x0109
        L_0x0108:
            r0 = r2
        L_0x0109:
            r10.renderMarker(r5, r0)
            r2 = r7
            goto L_0x00f3
        L_0x010e:
            if (r6 == 0) goto L_0x011a
            int r1 = r1 - r4
            java.lang.Object r11 = r11.get(r1)
            com.caverock.androidsvg.SVGAndroidRenderer$MarkerVector r11 = (com.caverock.androidsvg.SVGAndroidRenderer.MarkerVector) r11
            r10.renderMarker(r6, r11)
        L_0x011a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.renderMarkers(com.caverock.androidsvg.SVG$GraphicsElement):void");
    }

    private MarkerVector realignMarkerMid(MarkerVector markerVector, MarkerVector markerVector2, MarkerVector markerVector3) {
        float dotProduct = dotProduct(markerVector2.dx, markerVector2.dy, markerVector2.x - markerVector.x, markerVector2.y - markerVector.y);
        if (dotProduct == 0.0f) {
            dotProduct = dotProduct(markerVector2.dx, markerVector2.dy, markerVector3.x - markerVector2.x, markerVector3.y - markerVector2.y);
        }
        int i = (dotProduct > 0.0f ? 1 : (dotProduct == 0.0f ? 0 : -1));
        if (i > 0) {
            return markerVector2;
        }
        if (i == 0 && (markerVector2.dx > 0.0f || markerVector2.dy >= 0.0f)) {
            return markerVector2;
        }
        markerVector2.dx = -markerVector2.dx;
        markerVector2.dy = -markerVector2.dy;
        return markerVector2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f5, code lost:
        r12 = 0.0f - r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f7, code lost:
        r7 = com.caverock.androidsvg.SVGAndroidRenderer.AnonymousClass1.$SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[r7.getAlignment().ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0104, code lost:
        if (r7 == 2) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0107, code lost:
        if (r7 == 3) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x010a, code lost:
        if (r7 == 5) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x010d, code lost:
        if (r7 == 6) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0110, code lost:
        if (r7 == 7) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0114, code lost:
        if (r7 == 8) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0117, code lost:
        r0 = r4 - r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x011a, code lost:
        r0 = (r4 - r0) / 2.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x011d, code lost:
        r1 = 0.0f - r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0128, code lost:
        if (r10.state.style.overflow.booleanValue() != false) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012a, code lost:
        setClipRect(r12, r1, r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012d, code lost:
        r3.reset();
        r3.preScale(r5, r6);
        r10.canvas.concat(r3);
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x015c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void renderMarker(com.caverock.androidsvg.SVG.Marker r11, com.caverock.androidsvg.SVGAndroidRenderer.MarkerVector r12) {
        /*
            r10 = this;
            r10.statePush()
            java.lang.Float r0 = r11.orient
            r1 = 0
            if (r0 == 0) goto L_0x0037
            java.lang.Float r0 = r11.orient
            float r0 = r0.floatValue()
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 == 0) goto L_0x0030
            float r0 = r12.dx
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0020
            float r0 = r12.dy
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0037
        L_0x0020:
            float r0 = r12.dy
            double r2 = (double) r0
            float r0 = r12.dx
            double r4 = (double) r0
            double r2 = java.lang.Math.atan2(r2, r4)
            double r2 = java.lang.Math.toDegrees(r2)
            float r0 = (float) r2
            goto L_0x0038
        L_0x0030:
            java.lang.Float r0 = r11.orient
            float r0 = r0.floatValue()
            goto L_0x0038
        L_0x0037:
            r0 = r1
        L_0x0038:
            boolean r2 = r11.markerUnitsAreUser
            if (r2 == 0) goto L_0x003f
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x004b
        L_0x003f:
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r2 = r10.state
            com.caverock.androidsvg.SVG$Style r2 = r2.style
            com.caverock.androidsvg.SVG$Length r2 = r2.strokeWidth
            float r3 = r10.dpi
            float r2 = r2.floatValue((float) r3)
        L_0x004b:
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r3 = r10.findInheritFromAncestorState(r11)
            r10.state = r3
            android.graphics.Matrix r3 = new android.graphics.Matrix
            r3.<init>()
            float r4 = r12.x
            float r12 = r12.y
            r3.preTranslate(r4, r12)
            r3.preRotate(r0)
            r3.preScale(r2, r2)
            com.caverock.androidsvg.SVG$Length r12 = r11.refX
            if (r12 == 0) goto L_0x006e
            com.caverock.androidsvg.SVG$Length r12 = r11.refX
            float r12 = r12.floatValueX(r10)
            goto L_0x006f
        L_0x006e:
            r12 = r1
        L_0x006f:
            com.caverock.androidsvg.SVG$Length r0 = r11.refY
            if (r0 == 0) goto L_0x007a
            com.caverock.androidsvg.SVG$Length r0 = r11.refY
            float r0 = r0.floatValueY(r10)
            goto L_0x007b
        L_0x007a:
            r0 = r1
        L_0x007b:
            com.caverock.androidsvg.SVG$Length r2 = r11.markerWidth
            r4 = 1077936128(0x40400000, float:3.0)
            if (r2 == 0) goto L_0x0088
            com.caverock.androidsvg.SVG$Length r2 = r11.markerWidth
            float r2 = r2.floatValueX(r10)
            goto L_0x0089
        L_0x0088:
            r2 = r4
        L_0x0089:
            com.caverock.androidsvg.SVG$Length r5 = r11.markerHeight
            if (r5 == 0) goto L_0x0093
            com.caverock.androidsvg.SVG$Length r4 = r11.markerHeight
            float r4 = r4.floatValueY(r10)
        L_0x0093:
            com.caverock.androidsvg.SVG$Box r5 = r11.viewBox
            if (r5 == 0) goto L_0x0139
            com.caverock.androidsvg.SVG$Box r5 = r11.viewBox
            float r5 = r5.width
            float r5 = r2 / r5
            com.caverock.androidsvg.SVG$Box r6 = r11.viewBox
            float r6 = r6.height
            float r6 = r4 / r6
            com.caverock.androidsvg.PreserveAspectRatio r7 = r11.preserveAspectRatio
            if (r7 == 0) goto L_0x00aa
            com.caverock.androidsvg.PreserveAspectRatio r7 = r11.preserveAspectRatio
            goto L_0x00ac
        L_0x00aa:
            com.caverock.androidsvg.PreserveAspectRatio r7 = com.caverock.androidsvg.PreserveAspectRatio.LETTERBOX
        L_0x00ac:
            com.caverock.androidsvg.PreserveAspectRatio r8 = com.caverock.androidsvg.PreserveAspectRatio.STRETCH
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x00c6
            com.caverock.androidsvg.PreserveAspectRatio$Scale r8 = r7.getScale()
            com.caverock.androidsvg.PreserveAspectRatio$Scale r9 = com.caverock.androidsvg.PreserveAspectRatio.Scale.slice
            if (r8 != r9) goto L_0x00c1
            float r5 = java.lang.Math.max(r5, r6)
            goto L_0x00c5
        L_0x00c1:
            float r5 = java.lang.Math.min(r5, r6)
        L_0x00c5:
            r6 = r5
        L_0x00c6:
            float r12 = -r12
            float r12 = r12 * r5
            float r0 = -r0
            float r0 = r0 * r6
            r3.preTranslate(r12, r0)
            android.graphics.Canvas r12 = r10.canvas
            r12.concat(r3)
            com.caverock.androidsvg.SVG$Box r12 = r11.viewBox
            float r12 = r12.width
            float r12 = r12 * r5
            com.caverock.androidsvg.SVG$Box r0 = r11.viewBox
            float r0 = r0.height
            float r0 = r0 * r6
            int[] r8 = com.caverock.androidsvg.SVGAndroidRenderer.AnonymousClass1.$SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r9 = r7.getAlignment()
            int r9 = r9.ordinal()
            r8 = r8[r9]
            r9 = 1073741824(0x40000000, float:2.0)
            switch(r8) {
                case 1: goto L_0x00f2;
                case 2: goto L_0x00f2;
                case 3: goto L_0x00f2;
                case 4: goto L_0x00ef;
                case 5: goto L_0x00ef;
                case 6: goto L_0x00ef;
                default: goto L_0x00ed;
            }
        L_0x00ed:
            r12 = r1
            goto L_0x00f7
        L_0x00ef:
            float r12 = r2 - r12
            goto L_0x00f5
        L_0x00f2:
            float r12 = r2 - r12
            float r12 = r12 / r9
        L_0x00f5:
            float r12 = r1 - r12
        L_0x00f7:
            int[] r8 = com.caverock.androidsvg.SVGAndroidRenderer.AnonymousClass1.$SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r7 = r7.getAlignment()
            int r7 = r7.ordinal()
            r7 = r8[r7]
            r8 = 2
            if (r7 == r8) goto L_0x011a
            r8 = 3
            if (r7 == r8) goto L_0x0117
            r8 = 5
            if (r7 == r8) goto L_0x011a
            r8 = 6
            if (r7 == r8) goto L_0x0117
            r8 = 7
            if (r7 == r8) goto L_0x011a
            r8 = 8
            if (r7 == r8) goto L_0x0117
            goto L_0x011e
        L_0x0117:
            float r0 = r4 - r0
            goto L_0x011d
        L_0x011a:
            float r0 = r4 - r0
            float r0 = r0 / r9
        L_0x011d:
            float r1 = r1 - r0
        L_0x011e:
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r0 = r10.state
            com.caverock.androidsvg.SVG$Style r0 = r0.style
            java.lang.Boolean r0 = r0.overflow
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x012d
            r10.setClipRect(r12, r1, r2, r4)
        L_0x012d:
            r3.reset()
            r3.preScale(r5, r6)
            android.graphics.Canvas r12 = r10.canvas
            r12.concat(r3)
            goto L_0x0152
        L_0x0139:
            float r12 = -r12
            float r0 = -r0
            r3.preTranslate(r12, r0)
            android.graphics.Canvas r12 = r10.canvas
            r12.concat(r3)
            com.caverock.androidsvg.SVGAndroidRenderer$RendererState r12 = r10.state
            com.caverock.androidsvg.SVG$Style r12 = r12.style
            java.lang.Boolean r12 = r12.overflow
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L_0x0152
            r10.setClipRect(r1, r1, r2, r4)
        L_0x0152:
            boolean r12 = r10.pushLayer()
            r0 = 0
            r10.renderChildren(r11, r0)
            if (r12 == 0) goto L_0x015f
            r10.popLayer(r11)
        L_0x015f:
            r10.statePop()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.renderMarker(com.caverock.androidsvg.SVG$Marker, com.caverock.androidsvg.SVGAndroidRenderer$MarkerVector):void");
    }

    private RendererState findInheritFromAncestorState(SVG.SvgObject svgObject) {
        RendererState rendererState = new RendererState();
        updateStyle(rendererState, SVG.Style.getDefaultStyle());
        return findInheritFromAncestorState(svgObject, rendererState);
    }

    private RendererState findInheritFromAncestorState(SVG.SvgObject svgObject, RendererState rendererState) {
        ArrayList<SVG.SvgElementBase> arrayList = new ArrayList<>();
        while (true) {
            if (svgObject instanceof SVG.SvgElementBase) {
                arrayList.add(0, (SVG.SvgElementBase) svgObject);
            }
            if (svgObject.parent == null) {
                break;
            }
            svgObject = (SVG.SvgObject) svgObject.parent;
        }
        for (SVG.SvgElementBase updateStyleForElement : arrayList) {
            updateStyleForElement(rendererState, updateStyleForElement);
        }
        rendererState.viewBox = this.state.viewBox;
        rendererState.viewPort = this.state.viewPort;
        return rendererState;
    }

    private void checkForGradientsAndPatterns(SVG.SvgElement svgElement) {
        if (this.state.style.fill instanceof SVG.PaintReference) {
            decodePaintReference(true, svgElement.boundingBox, (SVG.PaintReference) this.state.style.fill);
        }
        if (this.state.style.stroke instanceof SVG.PaintReference) {
            decodePaintReference(false, svgElement.boundingBox, (SVG.PaintReference) this.state.style.stroke);
        }
    }

    private void decodePaintReference(boolean z, SVG.Box box, SVG.PaintReference paintReference) {
        SVG.SvgObject resolveIRI = this.document.resolveIRI(paintReference.href);
        if (resolveIRI == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = paintReference.href;
            error("%s reference '%s' not found", objArr);
            if (paintReference.fallback != null) {
                setPaintColour(this.state, z, paintReference.fallback);
            } else if (z) {
                this.state.hasFill = false;
            } else {
                this.state.hasStroke = false;
            }
        } else if (resolveIRI instanceof SVG.SvgLinearGradient) {
            makeLinearGradient(z, box, (SVG.SvgLinearGradient) resolveIRI);
        } else if (resolveIRI instanceof SVG.SvgRadialGradient) {
            makeRadialGradient(z, box, (SVG.SvgRadialGradient) resolveIRI);
        } else if (resolveIRI instanceof SVG.SolidColor) {
            setSolidColor(z, (SVG.SolidColor) resolveIRI);
        }
    }

    private void makeLinearGradient(boolean z, SVG.Box box, SVG.SvgLinearGradient svgLinearGradient) {
        float f;
        float f2;
        float f3;
        float f4;
        SVG.Box box2 = box;
        SVG.SvgLinearGradient svgLinearGradient2 = svgLinearGradient;
        if (svgLinearGradient2.href != null) {
            fillInChainedGradientFields((SVG.GradientElement) svgLinearGradient2, svgLinearGradient2.href);
        }
        int i = 0;
        boolean z2 = svgLinearGradient2.gradientUnitsAreUser != null && svgLinearGradient2.gradientUnitsAreUser.booleanValue();
        RendererState rendererState = this.state;
        Paint paint = z ? rendererState.fillPaint : rendererState.strokePaint;
        if (z2) {
            SVG.Box currentViewPortInUserUnits = getCurrentViewPortInUserUnits();
            float floatValueX = svgLinearGradient2.x1 != null ? svgLinearGradient2.x1.floatValueX(this) : 0.0f;
            float floatValueY = svgLinearGradient2.y1 != null ? svgLinearGradient2.y1.floatValueY(this) : 0.0f;
            f2 = svgLinearGradient2.x2 != null ? svgLinearGradient2.x2.floatValueX(this) : currentViewPortInUserUnits.width;
            f4 = floatValueX;
            f3 = floatValueY;
            f = svgLinearGradient2.y2 != null ? svgLinearGradient2.y2.floatValueY(this) : 0.0f;
        } else {
            float floatValue = svgLinearGradient2.x1 != null ? svgLinearGradient2.x1.floatValue(this, 1.0f) : 0.0f;
            float floatValue2 = svgLinearGradient2.y1 != null ? svgLinearGradient2.y1.floatValue(this, 1.0f) : 0.0f;
            float floatValue3 = svgLinearGradient2.x2 != null ? svgLinearGradient2.x2.floatValue(this, 1.0f) : 1.0f;
            f4 = floatValue;
            f = svgLinearGradient2.y2 != null ? svgLinearGradient2.y2.floatValue(this, 1.0f) : 0.0f;
            f3 = floatValue2;
            f2 = floatValue3;
        }
        statePush();
        this.state = findInheritFromAncestorState(svgLinearGradient2);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(box2.minX, box2.minY);
            matrix.preScale(box2.width, box2.height);
        }
        if (svgLinearGradient2.gradientTransform != null) {
            matrix.preConcat(svgLinearGradient2.gradientTransform);
        }
        int size = svgLinearGradient2.children.size();
        if (size == 0) {
            statePop();
            if (z) {
                this.state.hasFill = false;
            } else {
                this.state.hasStroke = false;
            }
        } else {
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f5 = -1.0f;
            for (SVG.SvgObject svgObject : svgLinearGradient2.children) {
                SVG.Stop stop = (SVG.Stop) svgObject;
                float floatValue4 = stop.offset != null ? stop.offset.floatValue() : 0.0f;
                if (i == 0 || floatValue4 >= f5) {
                    fArr[i] = floatValue4;
                    f5 = floatValue4;
                } else {
                    fArr[i] = f5;
                }
                statePush();
                updateStyleForElement(this.state, stop);
                SVG.Colour colour = (SVG.Colour) this.state.style.stopColor;
                if (colour == null) {
                    colour = SVG.Colour.BLACK;
                }
                iArr[i] = colourWithOpacity(colour.colour, this.state.style.stopOpacity.floatValue());
                i++;
                statePop();
            }
            if ((f4 == f2 && f3 == f) || size == 1) {
                statePop();
                paint.setColor(iArr[size - 1]);
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            if (svgLinearGradient2.spreadMethod != null) {
                if (svgLinearGradient2.spreadMethod == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (svgLinearGradient2.spreadMethod == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            statePop();
            LinearGradient linearGradient = new LinearGradient(f4, f3, f2, f, iArr, fArr, tileMode);
            linearGradient.setLocalMatrix(matrix);
            paint.setShader(linearGradient);
            paint.setAlpha(clamp255(this.state.style.fillOpacity.floatValue()));
        }
    }

    private void makeRadialGradient(boolean z, SVG.Box box, SVG.SvgRadialGradient svgRadialGradient) {
        float f;
        float f2;
        float f3;
        SVG.Box box2 = box;
        SVG.SvgRadialGradient svgRadialGradient2 = svgRadialGradient;
        if (svgRadialGradient2.href != null) {
            fillInChainedGradientFields((SVG.GradientElement) svgRadialGradient2, svgRadialGradient2.href);
        }
        int i = 0;
        boolean z2 = svgRadialGradient2.gradientUnitsAreUser != null && svgRadialGradient2.gradientUnitsAreUser.booleanValue();
        RendererState rendererState = this.state;
        Paint paint = z ? rendererState.fillPaint : rendererState.strokePaint;
        if (z2) {
            SVG.Length length = new SVG.Length(50.0f, SVG.Unit.percent);
            float floatValueX = svgRadialGradient2.cx != null ? svgRadialGradient2.cx.floatValueX(this) : length.floatValueX(this);
            float floatValueY = svgRadialGradient2.cy != null ? svgRadialGradient2.cy.floatValueY(this) : length.floatValueY(this);
            if (svgRadialGradient2.r != null) {
                length = svgRadialGradient2.r;
            }
            f = length.floatValue(this);
            f3 = floatValueX;
            f2 = floatValueY;
        } else {
            float floatValue = svgRadialGradient2.cx != null ? svgRadialGradient2.cx.floatValue(this, 1.0f) : 0.5f;
            float floatValue2 = svgRadialGradient2.cy != null ? svgRadialGradient2.cy.floatValue(this, 1.0f) : 0.5f;
            f3 = floatValue;
            f = svgRadialGradient2.r != null ? svgRadialGradient2.r.floatValue(this, 1.0f) : 0.5f;
            f2 = floatValue2;
        }
        statePush();
        this.state = findInheritFromAncestorState(svgRadialGradient2);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(box2.minX, box2.minY);
            matrix.preScale(box2.width, box2.height);
        }
        if (svgRadialGradient2.gradientTransform != null) {
            matrix.preConcat(svgRadialGradient2.gradientTransform);
        }
        int size = svgRadialGradient2.children.size();
        if (size == 0) {
            statePop();
            if (z) {
                this.state.hasFill = false;
            } else {
                this.state.hasStroke = false;
            }
        } else {
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f4 = -1.0f;
            Iterator it = svgRadialGradient2.children.iterator();
            while (true) {
                float f5 = 0.0f;
                if (!it.hasNext()) {
                    break;
                }
                SVG.Stop stop = (SVG.Stop) ((SVG.SvgObject) it.next());
                if (stop.offset != null) {
                    f5 = stop.offset.floatValue();
                }
                if (i == 0 || f5 >= f4) {
                    fArr[i] = f5;
                    f4 = f5;
                } else {
                    fArr[i] = f4;
                }
                statePush();
                updateStyleForElement(this.state, stop);
                SVG.Colour colour = (SVG.Colour) this.state.style.stopColor;
                if (colour == null) {
                    colour = SVG.Colour.BLACK;
                }
                iArr[i] = colourWithOpacity(colour.colour, this.state.style.stopOpacity.floatValue());
                i++;
                statePop();
            }
            if (f == 0.0f || size == 1) {
                statePop();
                paint.setColor(iArr[size - 1]);
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            if (svgRadialGradient2.spreadMethod != null) {
                if (svgRadialGradient2.spreadMethod == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (svgRadialGradient2.spreadMethod == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            statePop();
            RadialGradient radialGradient = new RadialGradient(f3, f2, f, iArr, fArr, tileMode);
            radialGradient.setLocalMatrix(matrix);
            paint.setShader(radialGradient);
            paint.setAlpha(clamp255(this.state.style.fillOpacity.floatValue()));
        }
    }

    private void fillInChainedGradientFields(SVG.GradientElement gradientElement, String str) {
        SVG.SvgObject resolveIRI = gradientElement.document.resolveIRI(str);
        if (resolveIRI == null) {
            warn("Gradient reference '%s' not found", str);
        } else if (!(resolveIRI instanceof SVG.GradientElement)) {
            error("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (resolveIRI == gradientElement) {
            error("Circular reference in gradient href attribute '%s'", str);
        } else {
            SVG.GradientElement gradientElement2 = (SVG.GradientElement) resolveIRI;
            if (gradientElement.gradientUnitsAreUser == null) {
                gradientElement.gradientUnitsAreUser = gradientElement2.gradientUnitsAreUser;
            }
            if (gradientElement.gradientTransform == null) {
                gradientElement.gradientTransform = gradientElement2.gradientTransform;
            }
            if (gradientElement.spreadMethod == null) {
                gradientElement.spreadMethod = gradientElement2.spreadMethod;
            }
            if (gradientElement.children.isEmpty()) {
                gradientElement.children = gradientElement2.children;
            }
            try {
                if (gradientElement instanceof SVG.SvgLinearGradient) {
                    fillInChainedGradientFields((SVG.SvgLinearGradient) gradientElement, (SVG.SvgLinearGradient) resolveIRI);
                } else {
                    fillInChainedGradientFields((SVG.SvgRadialGradient) gradientElement, (SVG.SvgRadialGradient) resolveIRI);
                }
            } catch (ClassCastException unused) {
            }
            if (gradientElement2.href != null) {
                fillInChainedGradientFields(gradientElement, gradientElement2.href);
            }
        }
    }

    private void fillInChainedGradientFields(SVG.SvgLinearGradient svgLinearGradient, SVG.SvgLinearGradient svgLinearGradient2) {
        if (svgLinearGradient.x1 == null) {
            svgLinearGradient.x1 = svgLinearGradient2.x1;
        }
        if (svgLinearGradient.y1 == null) {
            svgLinearGradient.y1 = svgLinearGradient2.y1;
        }
        if (svgLinearGradient.x2 == null) {
            svgLinearGradient.x2 = svgLinearGradient2.x2;
        }
        if (svgLinearGradient.y2 == null) {
            svgLinearGradient.y2 = svgLinearGradient2.y2;
        }
    }

    private void fillInChainedGradientFields(SVG.SvgRadialGradient svgRadialGradient, SVG.SvgRadialGradient svgRadialGradient2) {
        if (svgRadialGradient.cx == null) {
            svgRadialGradient.cx = svgRadialGradient2.cx;
        }
        if (svgRadialGradient.cy == null) {
            svgRadialGradient.cy = svgRadialGradient2.cy;
        }
        if (svgRadialGradient.r == null) {
            svgRadialGradient.r = svgRadialGradient2.r;
        }
        if (svgRadialGradient.fx == null) {
            svgRadialGradient.fx = svgRadialGradient2.fx;
        }
        if (svgRadialGradient.fy == null) {
            svgRadialGradient.fy = svgRadialGradient2.fy;
        }
    }

    private void setSolidColor(boolean z, SVG.SolidColor solidColor) {
        boolean z2 = true;
        if (z) {
            if (isSpecified(solidColor.baseStyle, 2147483648L)) {
                this.state.style.fill = solidColor.baseStyle.solidColor;
                RendererState rendererState = this.state;
                if (solidColor.baseStyle.solidColor == null) {
                    z2 = false;
                }
                rendererState.hasFill = z2;
            }
            if (isSpecified(solidColor.baseStyle, 4294967296L)) {
                this.state.style.fillOpacity = solidColor.baseStyle.solidOpacity;
            }
            if (isSpecified(solidColor.baseStyle, 6442450944L)) {
                RendererState rendererState2 = this.state;
                setPaintColour(rendererState2, z, rendererState2.style.fill);
                return;
            }
            return;
        }
        if (isSpecified(solidColor.baseStyle, 2147483648L)) {
            this.state.style.stroke = solidColor.baseStyle.solidColor;
            RendererState rendererState3 = this.state;
            if (solidColor.baseStyle.solidColor == null) {
                z2 = false;
            }
            rendererState3.hasStroke = z2;
        }
        if (isSpecified(solidColor.baseStyle, 4294967296L)) {
            this.state.style.strokeOpacity = solidColor.baseStyle.solidOpacity;
        }
        if (isSpecified(solidColor.baseStyle, 6442450944L)) {
            RendererState rendererState4 = this.state;
            setPaintColour(rendererState4, z, rendererState4.style.stroke);
        }
    }

    private void checkForClipPath(SVG.SvgElement svgElement) {
        checkForClipPath(svgElement, svgElement.boundingBox);
    }

    private void checkForClipPath(SVG.SvgElement svgElement, SVG.Box box) {
        if (this.state.style.clipPath != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                Path calculateClipPath = calculateClipPath(svgElement, box);
                if (calculateClipPath != null) {
                    this.canvas.clipPath(calculateClipPath);
                    return;
                }
                return;
            }
            checkForClipPath_OldStyle(svgElement, box);
        }
    }

    private Path calculateClipPath(SVG.SvgElement svgElement, SVG.Box box) {
        Path objectToPath;
        SVG.SvgObject resolveIRI = svgElement.document.resolveIRI(this.state.style.clipPath);
        boolean z = false;
        if (resolveIRI == null) {
            error("ClipPath reference '%s' not found", this.state.style.clipPath);
            return null;
        }
        SVG.ClipPath clipPath = (SVG.ClipPath) resolveIRI;
        this.stateStack.push(this.state);
        this.state = findInheritFromAncestorState(clipPath);
        if (clipPath.clipPathUnitsAreUser == null || clipPath.clipPathUnitsAreUser.booleanValue()) {
            z = true;
        }
        Matrix matrix = new Matrix();
        if (!z) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        if (clipPath.transform != null) {
            matrix.preConcat(clipPath.transform);
        }
        Path path = new Path();
        for (SVG.SvgObject svgObject : clipPath.children) {
            if ((svgObject instanceof SVG.SvgElement) && (objectToPath = objectToPath((SVG.SvgElement) svgObject, true)) != null) {
                path.op(objectToPath, Path.Op.UNION);
            }
        }
        if (this.state.style.clipPath != null) {
            if (clipPath.boundingBox == null) {
                clipPath.boundingBox = calculatePathBounds(path);
            }
            Path calculateClipPath = calculateClipPath(clipPath, clipPath.boundingBox);
            if (calculateClipPath != null) {
                path.op(calculateClipPath, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.state = this.stateStack.pop();
        return path;
    }

    private Path objectToPath(SVG.SvgElement svgElement, boolean z) {
        Path path;
        Path calculateClipPath;
        this.stateStack.push(this.state);
        RendererState rendererState = new RendererState(this.state);
        this.state = rendererState;
        updateStyleForElement(rendererState, svgElement);
        if (!display() || !visible()) {
            this.state = this.stateStack.pop();
            return null;
        }
        if (svgElement instanceof SVG.Use) {
            if (!z) {
                error("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
            SVG.Use use = (SVG.Use) svgElement;
            SVG.SvgObject resolveIRI = svgElement.document.resolveIRI(use.href);
            if (resolveIRI == null) {
                error("Use reference '%s' not found", use.href);
                this.state = this.stateStack.pop();
                return null;
            } else if (!(resolveIRI instanceof SVG.SvgElement)) {
                this.state = this.stateStack.pop();
                return null;
            } else {
                path = objectToPath((SVG.SvgElement) resolveIRI, false);
                if (path == null) {
                    return null;
                }
                if (use.boundingBox == null) {
                    use.boundingBox = calculatePathBounds(path);
                }
                if (use.transform != null) {
                    path.transform(use.transform);
                }
            }
        } else if (svgElement instanceof SVG.GraphicsElement) {
            SVG.GraphicsElement graphicsElement = (SVG.GraphicsElement) svgElement;
            if (svgElement instanceof SVG.Path) {
                path = new PathConverter(((SVG.Path) svgElement).d).getPath();
                if (svgElement.boundingBox == null) {
                    svgElement.boundingBox = calculatePathBounds(path);
                }
            } else {
                path = svgElement instanceof SVG.Rect ? makePathAndBoundingBox((SVG.Rect) svgElement) : svgElement instanceof SVG.Circle ? makePathAndBoundingBox((SVG.Circle) svgElement) : svgElement instanceof SVG.Ellipse ? makePathAndBoundingBox((SVG.Ellipse) svgElement) : svgElement instanceof SVG.PolyLine ? makePathAndBoundingBox((SVG.PolyLine) svgElement) : null;
            }
            if (path == null) {
                return null;
            }
            if (graphicsElement.boundingBox == null) {
                graphicsElement.boundingBox = calculatePathBounds(path);
            }
            if (graphicsElement.transform != null) {
                path.transform(graphicsElement.transform);
            }
            path.setFillType(getClipRuleFromState());
        } else if (svgElement instanceof SVG.Text) {
            SVG.Text text = (SVG.Text) svgElement;
            path = makePathAndBoundingBox(text);
            if (path == null) {
                return null;
            }
            if (text.transform != null) {
                path.transform(text.transform);
            }
            path.setFillType(getClipRuleFromState());
        } else {
            error("Invalid %s element found in clipPath definition", svgElement.getNodeName());
            return null;
        }
        if (!(this.state.style.clipPath == null || (calculateClipPath = calculateClipPath(svgElement, svgElement.boundingBox)) == null)) {
            path.op(calculateClipPath, Path.Op.INTERSECT);
        }
        this.state = this.stateStack.pop();
        return path;
    }

    private void checkForClipPath_OldStyle(SVG.SvgElement svgElement, SVG.Box box) {
        SVG.SvgObject resolveIRI = svgElement.document.resolveIRI(this.state.style.clipPath);
        if (resolveIRI == null) {
            error("ClipPath reference '%s' not found", this.state.style.clipPath);
            return;
        }
        SVG.ClipPath clipPath = (SVG.ClipPath) resolveIRI;
        if (clipPath.children.isEmpty()) {
            this.canvas.clipRect(0, 0, 0, 0);
            return;
        }
        boolean z = clipPath.clipPathUnitsAreUser == null || clipPath.clipPathUnitsAreUser.booleanValue();
        if (!(svgElement instanceof SVG.Group) || z) {
            clipStatePush();
            if (!z) {
                Matrix matrix = new Matrix();
                matrix.preTranslate(box.minX, box.minY);
                matrix.preScale(box.width, box.height);
                this.canvas.concat(matrix);
            }
            if (clipPath.transform != null) {
                this.canvas.concat(clipPath.transform);
            }
            this.state = findInheritFromAncestorState(clipPath);
            checkForClipPath(clipPath);
            Path path = new Path();
            for (SVG.SvgObject addObjectToClip : clipPath.children) {
                addObjectToClip(addObjectToClip, true, path, new Matrix());
            }
            this.canvas.clipPath(path);
            clipStatePop();
            return;
        }
        warn("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", svgElement.getNodeName());
    }

    private void addObjectToClip(SVG.SvgObject svgObject, boolean z, Path path, Matrix matrix) {
        if (display()) {
            clipStatePush();
            if (svgObject instanceof SVG.Use) {
                if (z) {
                    addObjectToClip((SVG.Use) svgObject, path, matrix);
                } else {
                    error("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (svgObject instanceof SVG.Path) {
                addObjectToClip((SVG.Path) svgObject, path, matrix);
            } else if (svgObject instanceof SVG.Text) {
                addObjectToClip((SVG.Text) svgObject, path, matrix);
            } else if (svgObject instanceof SVG.GraphicsElement) {
                addObjectToClip((SVG.GraphicsElement) svgObject, path, matrix);
            } else {
                error("Invalid %s element found in clipPath definition", svgObject.toString());
            }
            clipStatePop();
        }
    }

    private void clipStatePush() {
        CanvasLegacy.save(this.canvas, CanvasLegacy.MATRIX_SAVE_FLAG);
        this.stateStack.push(this.state);
        this.state = new RendererState(this.state);
    }

    private void clipStatePop() {
        this.canvas.restore();
        this.state = this.stateStack.pop();
    }

    private Path.FillType getClipRuleFromState() {
        if (this.state.style.clipRule == null || this.state.style.clipRule != SVG.Style.FillRule.EvenOdd) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    private void addObjectToClip(SVG.Path path, Path path2, Matrix matrix) {
        updateStyleForElement(this.state, path);
        if (display() && visible()) {
            if (path.transform != null) {
                matrix.preConcat(path.transform);
            }
            Path path3 = new PathConverter(path.d).getPath();
            if (path.boundingBox == null) {
                path.boundingBox = calculatePathBounds(path3);
            }
            checkForClipPath(path);
            path2.setFillType(getClipRuleFromState());
            path2.addPath(path3, matrix);
        }
    }

    private void addObjectToClip(SVG.GraphicsElement graphicsElement, Path path, Matrix matrix) {
        Path path2;
        updateStyleForElement(this.state, graphicsElement);
        if (display() && visible()) {
            if (graphicsElement.transform != null) {
                matrix.preConcat(graphicsElement.transform);
            }
            if (graphicsElement instanceof SVG.Rect) {
                path2 = makePathAndBoundingBox((SVG.Rect) graphicsElement);
            } else if (graphicsElement instanceof SVG.Circle) {
                path2 = makePathAndBoundingBox((SVG.Circle) graphicsElement);
            } else if (graphicsElement instanceof SVG.Ellipse) {
                path2 = makePathAndBoundingBox((SVG.Ellipse) graphicsElement);
            } else if (graphicsElement instanceof SVG.PolyLine) {
                path2 = makePathAndBoundingBox((SVG.PolyLine) graphicsElement);
            } else {
                return;
            }
            checkForClipPath(graphicsElement);
            path.setFillType(getClipRuleFromState());
            path.addPath(path2, matrix);
        }
    }

    private void addObjectToClip(SVG.Use use, Path path, Matrix matrix) {
        updateStyleForElement(this.state, use);
        if (display() && visible()) {
            if (use.transform != null) {
                matrix.preConcat(use.transform);
            }
            SVG.SvgObject resolveIRI = use.document.resolveIRI(use.href);
            if (resolveIRI == null) {
                error("Use reference '%s' not found", use.href);
                return;
            }
            checkForClipPath(use);
            addObjectToClip(resolveIRI, false, path, matrix);
        }
    }

    private void addObjectToClip(SVG.Text text, Path path, Matrix matrix) {
        updateStyleForElement(this.state, text);
        if (display()) {
            if (text.transform != null) {
                matrix.preConcat(text.transform);
            }
            float f = 0.0f;
            float floatValueX = (text.x == null || text.x.size() == 0) ? 0.0f : ((SVG.Length) text.x.get(0)).floatValueX(this);
            float floatValueY = (text.y == null || text.y.size() == 0) ? 0.0f : ((SVG.Length) text.y.get(0)).floatValueY(this);
            float floatValueX2 = (text.dx == null || text.dx.size() == 0) ? 0.0f : ((SVG.Length) text.dx.get(0)).floatValueX(this);
            if (!(text.dy == null || text.dy.size() == 0)) {
                f = ((SVG.Length) text.dy.get(0)).floatValueY(this);
            }
            if (this.state.style.textAnchor != SVG.Style.TextAnchor.Start) {
                float calculateTextWidth = calculateTextWidth(text);
                if (this.state.style.textAnchor == SVG.Style.TextAnchor.Middle) {
                    calculateTextWidth /= 2.0f;
                }
                floatValueX -= calculateTextWidth;
            }
            if (text.boundingBox == null) {
                TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(floatValueX, floatValueY);
                enumerateTextSpans(text, textBoundsCalculator);
                text.boundingBox = new SVG.Box(textBoundsCalculator.bbox.left, textBoundsCalculator.bbox.top, textBoundsCalculator.bbox.width(), textBoundsCalculator.bbox.height());
            }
            checkForClipPath(text);
            Path path2 = new Path();
            enumerateTextSpans(text, new PlainTextToPath(floatValueX + floatValueX2, floatValueY + f, path2));
            path.setFillType(getClipRuleFromState());
            path.addPath(path2, matrix);
        }
    }

    private class PlainTextToPath extends TextProcessor {
        Path textAsPath;
        float x;
        float y;

        PlainTextToPath(float f, float f2, Path path) {
            super(SVGAndroidRenderer.this, (AnonymousClass1) null);
            this.x = f;
            this.y = f2;
            this.textAsPath = path;
        }

        public boolean doTextContainer(SVG.TextContainer textContainer) {
            if (!(textContainer instanceof SVG.TextPath)) {
                return true;
            }
            SVGAndroidRenderer.warn("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        }

        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                Path path = new Path();
                SVGAndroidRenderer.this.state.fillPaint.getTextPath(str, 0, str.length(), this.x, this.y, path);
                this.textAsPath.addPath(path);
            }
            this.x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    private Path makePathAndBoundingBox(SVG.Line line) {
        float f = 0.0f;
        float floatValueX = line.x1 == null ? 0.0f : line.x1.floatValueX(this);
        float floatValueY = line.y1 == null ? 0.0f : line.y1.floatValueY(this);
        float floatValueX2 = line.x2 == null ? 0.0f : line.x2.floatValueX(this);
        if (line.y2 != null) {
            f = line.y2.floatValueY(this);
        }
        if (line.boundingBox == null) {
            line.boundingBox = new SVG.Box(Math.min(floatValueX, floatValueX2), Math.min(floatValueY, f), Math.abs(floatValueX2 - floatValueX), Math.abs(f - floatValueY));
        }
        Path path = new Path();
        path.moveTo(floatValueX, floatValueY);
        path.lineTo(floatValueX2, f);
        return path;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Path makePathAndBoundingBox(com.caverock.androidsvg.SVG.Rect r24) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            com.caverock.androidsvg.SVG$Length r2 = r1.rx
            r3 = 0
            if (r2 != 0) goto L_0x000f
            com.caverock.androidsvg.SVG$Length r2 = r1.ry
            if (r2 != 0) goto L_0x000f
            r2 = r3
            goto L_0x0019
        L_0x000f:
            com.caverock.androidsvg.SVG$Length r2 = r1.rx
            if (r2 != 0) goto L_0x001b
            com.caverock.androidsvg.SVG$Length r2 = r1.ry
            float r2 = r2.floatValueY(r0)
        L_0x0019:
            r4 = r2
            goto L_0x0032
        L_0x001b:
            com.caverock.androidsvg.SVG$Length r2 = r1.ry
            if (r2 != 0) goto L_0x0026
            com.caverock.androidsvg.SVG$Length r2 = r1.rx
            float r2 = r2.floatValueX(r0)
            goto L_0x0019
        L_0x0026:
            com.caverock.androidsvg.SVG$Length r2 = r1.rx
            float r2 = r2.floatValueX(r0)
            com.caverock.androidsvg.SVG$Length r4 = r1.ry
            float r4 = r4.floatValueY(r0)
        L_0x0032:
            com.caverock.androidsvg.SVG$Length r5 = r1.width
            float r5 = r5.floatValueX(r0)
            r6 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 / r6
            float r2 = java.lang.Math.min(r2, r5)
            com.caverock.androidsvg.SVG$Length r5 = r1.height
            float r5 = r5.floatValueY(r0)
            float r5 = r5 / r6
            float r4 = java.lang.Math.min(r4, r5)
            com.caverock.androidsvg.SVG$Length r5 = r1.x
            if (r5 == 0) goto L_0x0055
            com.caverock.androidsvg.SVG$Length r5 = r1.x
            float r5 = r5.floatValueX(r0)
            goto L_0x0056
        L_0x0055:
            r5 = r3
        L_0x0056:
            com.caverock.androidsvg.SVG$Length r6 = r1.y
            if (r6 == 0) goto L_0x0062
            com.caverock.androidsvg.SVG$Length r6 = r1.y
            float r6 = r6.floatValueY(r0)
            r13 = r6
            goto L_0x0063
        L_0x0062:
            r13 = r3
        L_0x0063:
            com.caverock.androidsvg.SVG$Length r6 = r1.width
            float r6 = r6.floatValueX(r0)
            com.caverock.androidsvg.SVG$Length r7 = r1.height
            float r7 = r7.floatValueY(r0)
            com.caverock.androidsvg.SVG$Box r8 = r1.boundingBox
            if (r8 != 0) goto L_0x007a
            com.caverock.androidsvg.SVG$Box r8 = new com.caverock.androidsvg.SVG$Box
            r8.<init>(r5, r13, r6, r7)
            r1.boundingBox = r8
        L_0x007a:
            float r15 = r5 + r6
            float r1 = r13 + r7
            android.graphics.Path r14 = new android.graphics.Path
            r14.<init>()
            int r6 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00e7
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x008d
            goto L_0x00e7
        L_0x008d:
            r3 = 1057841801(0x3f0d6289, float:0.5522848)
            float r16 = r2 * r3
            float r3 = r3 * r4
            float r12 = r13 + r4
            r14.moveTo(r5, r12)
            float r17 = r12 - r3
            float r11 = r5 + r2
            float r21 = r11 - r16
            r6 = r14
            r7 = r5
            r8 = r17
            r9 = r21
            r10 = r13
            r24 = r11
            r22 = r12
            r12 = r13
            r6.cubicTo(r7, r8, r9, r10, r11, r12)
            float r2 = r15 - r2
            r14.lineTo(r2, r13)
            float r6 = r2 + r16
            r7 = r14
            r8 = r6
            r9 = r13
            r10 = r15
            r11 = r17
            r12 = r15
            r13 = r22
            r7.cubicTo(r8, r9, r10, r11, r12, r13)
            float r12 = r1 - r4
            r14.lineTo(r15, r12)
            float r10 = r12 + r3
            r3 = r14
            r16 = r10
            r17 = r6
            r18 = r1
            r19 = r2
            r20 = r1
            r14.cubicTo(r15, r16, r17, r18, r19, r20)
            r2 = r24
            r3.lineTo(r2, r1)
            r6 = r3
            r7 = r21
            r8 = r1
            r9 = r5
            r11 = r5
            r6.cubicTo(r7, r8, r9, r10, r11, r12)
            r3.lineTo(r5, r13)
            goto L_0x00f7
        L_0x00e7:
            r3 = r14
            r3.moveTo(r5, r13)
            r3.lineTo(r15, r13)
            r3.lineTo(r15, r1)
            r3.lineTo(r5, r1)
            r3.lineTo(r5, r13)
        L_0x00f7:
            r3.close()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.makePathAndBoundingBox(com.caverock.androidsvg.SVG$Rect):android.graphics.Path");
    }

    private Path makePathAndBoundingBox(SVG.Circle circle) {
        SVG.Circle circle2 = circle;
        float f = 0.0f;
        float floatValueX = circle2.cx != null ? circle2.cx.floatValueX(this) : 0.0f;
        if (circle2.cy != null) {
            f = circle2.cy.floatValueY(this);
        }
        float floatValue = circle2.r.floatValue(this);
        float f2 = floatValueX - floatValue;
        float f3 = f - floatValue;
        float f4 = floatValueX + floatValue;
        float f5 = f + floatValue;
        if (circle2.boundingBox == null) {
            float f6 = 2.0f * floatValue;
            circle2.boundingBox = new SVG.Box(f2, f3, f6, f6);
        }
        float f7 = BEZIER_ARC_FACTOR * floatValue;
        Path path = new Path();
        path.moveTo(floatValueX, f3);
        float f8 = floatValueX + f7;
        float f9 = f - f7;
        Path path2 = path;
        path2.cubicTo(f8, f3, f4, f9, f4, f);
        float f10 = f + f7;
        path2.cubicTo(f4, f10, f8, f5, floatValueX, f5);
        float f11 = floatValueX - f7;
        path2.cubicTo(f11, f5, f2, f10, f2, f);
        path2.cubicTo(f2, f9, f11, f3, floatValueX, f3);
        path.close();
        return path;
    }

    private Path makePathAndBoundingBox(SVG.Ellipse ellipse) {
        SVG.Ellipse ellipse2 = ellipse;
        float f = 0.0f;
        float floatValueX = ellipse2.cx != null ? ellipse2.cx.floatValueX(this) : 0.0f;
        if (ellipse2.cy != null) {
            f = ellipse2.cy.floatValueY(this);
        }
        float floatValueX2 = ellipse2.rx.floatValueX(this);
        float floatValueY = ellipse2.ry.floatValueY(this);
        float f2 = floatValueX - floatValueX2;
        float f3 = f - floatValueY;
        float f4 = floatValueX + floatValueX2;
        float f5 = f + floatValueY;
        if (ellipse2.boundingBox == null) {
            ellipse2.boundingBox = new SVG.Box(f2, f3, floatValueX2 * 2.0f, 2.0f * floatValueY);
        }
        float f6 = floatValueX2 * BEZIER_ARC_FACTOR;
        float f7 = BEZIER_ARC_FACTOR * floatValueY;
        Path path = new Path();
        path.moveTo(floatValueX, f3);
        float f8 = floatValueX + f6;
        float f9 = f - f7;
        Path path2 = path;
        path.cubicTo(f8, f3, f4, f9, f4, f);
        float f10 = f7 + f;
        Path path3 = path2;
        path3.cubicTo(f4, f10, f8, f5, floatValueX, f5);
        float f11 = floatValueX - f6;
        path3.cubicTo(f11, f5, f2, f10, f2, f);
        path3.cubicTo(f2, f9, f11, f3, floatValueX, f3);
        path2.close();
        return path2;
    }

    private Path makePathAndBoundingBox(SVG.PolyLine polyLine) {
        Path path = new Path();
        path.moveTo(polyLine.points[0], polyLine.points[1]);
        for (int i = 2; i < polyLine.points.length; i += 2) {
            path.lineTo(polyLine.points[i], polyLine.points[i + 1]);
        }
        if (polyLine instanceof SVG.Polygon) {
            path.close();
        }
        if (polyLine.boundingBox == null) {
            polyLine.boundingBox = calculatePathBounds(path);
        }
        return path;
    }

    private Path makePathAndBoundingBox(SVG.Text text) {
        float f = 0.0f;
        float floatValueX = (text.x == null || text.x.size() == 0) ? 0.0f : ((SVG.Length) text.x.get(0)).floatValueX(this);
        float floatValueY = (text.y == null || text.y.size() == 0) ? 0.0f : ((SVG.Length) text.y.get(0)).floatValueY(this);
        float floatValueX2 = (text.dx == null || text.dx.size() == 0) ? 0.0f : ((SVG.Length) text.dx.get(0)).floatValueX(this);
        if (!(text.dy == null || text.dy.size() == 0)) {
            f = ((SVG.Length) text.dy.get(0)).floatValueY(this);
        }
        if (this.state.style.textAnchor != SVG.Style.TextAnchor.Start) {
            float calculateTextWidth = calculateTextWidth(text);
            if (this.state.style.textAnchor == SVG.Style.TextAnchor.Middle) {
                calculateTextWidth /= 2.0f;
            }
            floatValueX -= calculateTextWidth;
        }
        if (text.boundingBox == null) {
            TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(floatValueX, floatValueY);
            enumerateTextSpans(text, textBoundsCalculator);
            text.boundingBox = new SVG.Box(textBoundsCalculator.bbox.left, textBoundsCalculator.bbox.top, textBoundsCalculator.bbox.width(), textBoundsCalculator.bbox.height());
        }
        Path path = new Path();
        enumerateTextSpans(text, new PlainTextToPath(floatValueX + floatValueX2, floatValueY + f, path));
        return path;
    }

    private void fillWithPattern(SVG.SvgElement svgElement, Path path, SVG.Pattern pattern) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        SVG.SvgElement svgElement2 = svgElement;
        SVG.Pattern pattern2 = pattern;
        boolean z = pattern2.patternUnitsAreUser != null && pattern2.patternUnitsAreUser.booleanValue();
        if (pattern2.href != null) {
            fillInChainedPatternFields(pattern2, pattern2.href);
        }
        if (z) {
            f4 = pattern2.x != null ? pattern2.x.floatValueX(this) : 0.0f;
            f3 = pattern2.y != null ? pattern2.y.floatValueY(this) : 0.0f;
            f2 = pattern2.width != null ? pattern2.width.floatValueX(this) : 0.0f;
            f = pattern2.height != null ? pattern2.height.floatValueY(this) : 0.0f;
        } else {
            float floatValue = pattern2.x != null ? pattern2.x.floatValue(this, 1.0f) : 0.0f;
            float floatValue2 = pattern2.y != null ? pattern2.y.floatValue(this, 1.0f) : 0.0f;
            float floatValue3 = pattern2.width != null ? pattern2.width.floatValue(this, 1.0f) : 0.0f;
            float floatValue4 = pattern2.height != null ? pattern2.height.floatValue(this, 1.0f) : 0.0f;
            f4 = (floatValue * svgElement2.boundingBox.width) + svgElement2.boundingBox.minX;
            float f6 = (floatValue2 * svgElement2.boundingBox.height) + svgElement2.boundingBox.minY;
            float f7 = floatValue3 * svgElement2.boundingBox.width;
            f = floatValue4 * svgElement2.boundingBox.height;
            f3 = f6;
            f2 = f7;
        }
        if (f2 != 0.0f && f != 0.0f) {
            PreserveAspectRatio preserveAspectRatio = pattern2.preserveAspectRatio != null ? pattern2.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
            statePush();
            this.canvas.clipPath(path);
            RendererState rendererState = new RendererState();
            updateStyle(rendererState, SVG.Style.getDefaultStyle());
            rendererState.style.overflow = false;
            this.state = findInheritFromAncestorState(pattern2, rendererState);
            SVG.Box box = svgElement2.boundingBox;
            if (pattern2.patternTransform != null) {
                this.canvas.concat(pattern2.patternTransform);
                Matrix matrix = new Matrix();
                if (pattern2.patternTransform.invert(matrix)) {
                    float[] fArr = {svgElement2.boundingBox.minX, svgElement2.boundingBox.minY, svgElement2.boundingBox.maxX(), svgElement2.boundingBox.minY, svgElement2.boundingBox.maxX(), svgElement2.boundingBox.maxY(), svgElement2.boundingBox.minX, svgElement2.boundingBox.maxY()};
                    matrix.mapPoints(fArr);
                    float f8 = fArr[0];
                    float f9 = fArr[1];
                    RectF rectF = new RectF(f8, f9, f8, f9);
                    for (int i = 2; i <= 6; i += 2) {
                        if (fArr[i] < rectF.left) {
                            rectF.left = fArr[i];
                        }
                        if (fArr[i] > rectF.right) {
                            rectF.right = fArr[i];
                        }
                        int i2 = i + 1;
                        if (fArr[i2] < rectF.top) {
                            rectF.top = fArr[i2];
                        }
                        if (fArr[i2] > rectF.bottom) {
                            rectF.bottom = fArr[i2];
                        }
                    }
                    box = new SVG.Box(rectF.left, rectF.top, rectF.right - rectF.left, rectF.bottom - rectF.top);
                }
            }
            float floor = f4 + (((float) Math.floor((double) ((box.minX - f4) / f2))) * f2);
            float maxX = box.maxX();
            float maxY = box.maxY();
            SVG.Box box2 = new SVG.Box(0.0f, 0.0f, f2, f);
            boolean pushLayer = pushLayer();
            for (float floor2 = f3 + (((float) Math.floor((double) ((box.minY - f3) / f))) * f); floor2 < maxY; floor2 += f) {
                float f10 = floor;
                while (f10 < maxX) {
                    box2.minX = f10;
                    box2.minY = floor2;
                    statePush();
                    if (!this.state.style.overflow.booleanValue()) {
                        f5 = floor;
                        setClipRect(box2.minX, box2.minY, box2.width, box2.height);
                    } else {
                        f5 = floor;
                    }
                    if (pattern2.viewBox != null) {
                        this.canvas.concat(calculateViewBoxTransform(box2, pattern2.viewBox, preserveAspectRatio));
                    } else {
                        boolean z2 = pattern2.patternContentUnitsAreUser == null || pattern2.patternContentUnitsAreUser.booleanValue();
                        this.canvas.translate(f10, floor2);
                        if (!z2) {
                            this.canvas.scale(svgElement2.boundingBox.width, svgElement2.boundingBox.height);
                        }
                    }
                    for (SVG.SvgObject render : pattern2.children) {
                        render(render);
                    }
                    statePop();
                    f10 += f2;
                    floor = f5;
                }
                float f11 = floor;
            }
            if (pushLayer) {
                popLayer(pattern2);
            }
            statePop();
        }
    }

    private void fillInChainedPatternFields(SVG.Pattern pattern, String str) {
        SVG.SvgObject resolveIRI = pattern.document.resolveIRI(str);
        if (resolveIRI == null) {
            warn("Pattern reference '%s' not found", str);
        } else if (!(resolveIRI instanceof SVG.Pattern)) {
            error("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (resolveIRI == pattern) {
            error("Circular reference in pattern href attribute '%s'", str);
        } else {
            SVG.Pattern pattern2 = (SVG.Pattern) resolveIRI;
            if (pattern.patternUnitsAreUser == null) {
                pattern.patternUnitsAreUser = pattern2.patternUnitsAreUser;
            }
            if (pattern.patternContentUnitsAreUser == null) {
                pattern.patternContentUnitsAreUser = pattern2.patternContentUnitsAreUser;
            }
            if (pattern.patternTransform == null) {
                pattern.patternTransform = pattern2.patternTransform;
            }
            if (pattern.x == null) {
                pattern.x = pattern2.x;
            }
            if (pattern.y == null) {
                pattern.y = pattern2.y;
            }
            if (pattern.width == null) {
                pattern.width = pattern2.width;
            }
            if (pattern.height == null) {
                pattern.height = pattern2.height;
            }
            if (pattern.children.isEmpty()) {
                pattern.children = pattern2.children;
            }
            if (pattern.viewBox == null) {
                pattern.viewBox = pattern2.viewBox;
            }
            if (pattern.preserveAspectRatio == null) {
                pattern.preserveAspectRatio = pattern2.preserveAspectRatio;
            }
            if (pattern2.href != null) {
                fillInChainedPatternFields(pattern, pattern2.href);
            }
        }
    }

    private void renderMask(SVG.Mask mask, SVG.SvgElement svgElement, SVG.Box box) {
        float f;
        float f2;
        debug("Mask render", new Object[0]);
        boolean z = true;
        if (mask.maskUnitsAreUser != null && mask.maskUnitsAreUser.booleanValue()) {
            f2 = mask.width != null ? mask.width.floatValueX(this) : box.width;
            f = mask.height != null ? mask.height.floatValueY(this) : box.height;
        } else {
            float f3 = 1.2f;
            float floatValue = mask.width != null ? mask.width.floatValue(this, 1.0f) : 1.2f;
            if (mask.height != null) {
                f3 = mask.height.floatValue(this, 1.0f);
            }
            f2 = floatValue * box.width;
            f = f3 * box.height;
        }
        if (f2 != 0.0f && f != 0.0f) {
            statePush();
            RendererState findInheritFromAncestorState = findInheritFromAncestorState(mask);
            this.state = findInheritFromAncestorState;
            findInheritFromAncestorState.style.opacity = Float.valueOf(1.0f);
            boolean pushLayer = pushLayer();
            this.canvas.save();
            if (mask.maskContentUnitsAreUser != null && !mask.maskContentUnitsAreUser.booleanValue()) {
                z = false;
            }
            if (!z) {
                this.canvas.translate(box.minX, box.minY);
                this.canvas.scale(box.width, box.height);
            }
            renderChildren(mask, false);
            this.canvas.restore();
            if (pushLayer) {
                popLayer(svgElement, box);
            }
            statePop();
        }
    }
}
