package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.util.Log;
import androidx.core.view.ViewCompat;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.caverock.androidsvg.CSSParser;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.sentry.protocol.SentryStackFrame;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SVG {
    private static final int DEFAULT_PICTURE_HEIGHT = 512;
    private static final int DEFAULT_PICTURE_WIDTH = 512;
    private static final long SPECIFIED_ALL = -1;
    static final long SPECIFIED_CLIP = 1048576;
    static final long SPECIFIED_CLIP_PATH = 268435456;
    static final long SPECIFIED_CLIP_RULE = 536870912;
    static final long SPECIFIED_COLOR = 4096;
    static final long SPECIFIED_DIRECTION = 68719476736L;
    static final long SPECIFIED_DISPLAY = 16777216;
    static final long SPECIFIED_FILL = 1;
    static final long SPECIFIED_FILL_OPACITY = 4;
    static final long SPECIFIED_FILL_RULE = 2;
    static final long SPECIFIED_FONT_FAMILY = 8192;
    static final long SPECIFIED_FONT_SIZE = 16384;
    static final long SPECIFIED_FONT_STYLE = 65536;
    static final long SPECIFIED_FONT_WEIGHT = 32768;
    static final long SPECIFIED_IMAGE_RENDERING = 137438953472L;
    static final long SPECIFIED_MARKER_END = 8388608;
    static final long SPECIFIED_MARKER_MID = 4194304;
    static final long SPECIFIED_MARKER_START = 2097152;
    static final long SPECIFIED_MASK = 1073741824;
    static final long SPECIFIED_OPACITY = 2048;
    static final long SPECIFIED_OVERFLOW = 524288;
    static final long SPECIFIED_SOLID_COLOR = 2147483648L;
    static final long SPECIFIED_SOLID_OPACITY = 4294967296L;
    static final long SPECIFIED_STOP_COLOR = 67108864;
    static final long SPECIFIED_STOP_OPACITY = 134217728;
    static final long SPECIFIED_STROKE = 8;
    static final long SPECIFIED_STROKE_DASHARRAY = 512;
    static final long SPECIFIED_STROKE_DASHOFFSET = 1024;
    static final long SPECIFIED_STROKE_LINECAP = 64;
    static final long SPECIFIED_STROKE_LINEJOIN = 128;
    static final long SPECIFIED_STROKE_MITERLIMIT = 256;
    static final long SPECIFIED_STROKE_OPACITY = 16;
    static final long SPECIFIED_STROKE_WIDTH = 32;
    static final long SPECIFIED_TEXT_ANCHOR = 262144;
    static final long SPECIFIED_TEXT_DECORATION = 131072;
    static final long SPECIFIED_VECTOR_EFFECT = 34359738368L;
    static final long SPECIFIED_VIEWPORT_FILL = 8589934592L;
    static final long SPECIFIED_VIEWPORT_FILL_OPACITY = 17179869184L;
    static final long SPECIFIED_VISIBILITY = 33554432;
    private static final double SQRT2 = 1.414213562373095d;
    private static final String VERSION = "1.4";
    private static boolean enableInternalEntities = true;
    private static SVGExternalFileResolver externalFileResolver;
    private CSSParser.Ruleset cssRules = new CSSParser.Ruleset();
    private String desc = "";
    private Map<String, SvgElementBase> idToElementMap = new HashMap();
    private float renderDPI = 96.0f;
    private Svg rootElement = null;
    private String title = "";

    enum GradientSpread {
        pad,
        reflect,
        repeat
    }

    interface HasTransform {
        void setTransform(Matrix matrix);
    }

    interface NotDirectlyRendered {
    }

    interface PathInterface {
        void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5);

        void close();

        void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

        void lineTo(float f, float f2);

        void moveTo(float f, float f2);

        void quadTo(float f, float f2, float f3, float f4);
    }

    interface SvgConditional {
        String getRequiredExtensions();

        Set<String> getRequiredFeatures();

        Set<String> getRequiredFonts();

        Set<String> getRequiredFormats();

        Set<String> getSystemLanguage();

        void setRequiredExtensions(String str);

        void setRequiredFeatures(Set<String> set);

        void setRequiredFonts(Set<String> set);

        void setRequiredFormats(Set<String> set);

        void setSystemLanguage(Set<String> set);
    }

    interface SvgContainer {
        void addChild(SvgObject svgObject) throws SVGParseException;

        List<SvgObject> getChildren();
    }

    interface TextChild {
        TextRoot getTextRoot();

        void setTextRoot(TextRoot textRoot);
    }

    interface TextRoot {
    }

    enum Unit {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    public static String getVersion() {
        return VERSION;
    }

    SVG() {
    }

    public static SVG getFromInputStream(InputStream inputStream) throws SVGParseException {
        return new SVGParser().parse(inputStream, enableInternalEntities);
    }

    public static SVG getFromString(String str) throws SVGParseException {
        return new SVGParser().parse(new ByteArrayInputStream(str.getBytes()), enableInternalEntities);
    }

    public static SVG getFromResource(Context context, int i) throws SVGParseException {
        return getFromResource(context.getResources(), i);
    }

    public static SVG getFromResource(Resources resources, int i) throws SVGParseException {
        SVGParser sVGParser = new SVGParser();
        InputStream openRawResource = resources.openRawResource(i);
        try {
            return sVGParser.parse(openRawResource, enableInternalEntities);
        } finally {
            try {
                openRawResource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static SVG getFromAsset(AssetManager assetManager, String str) throws SVGParseException, IOException {
        SVGParser sVGParser = new SVGParser();
        InputStream open = assetManager.open(str);
        try {
            return sVGParser.parse(open, enableInternalEntities);
        } finally {
            try {
                open.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void setInternalEntitiesEnabled(boolean z) {
        enableInternalEntities = z;
    }

    public static boolean isInternalEntitiesEnabled() {
        return enableInternalEntities;
    }

    public static void registerExternalFileResolver(SVGExternalFileResolver sVGExternalFileResolver) {
        externalFileResolver = sVGExternalFileResolver;
    }

    public static void deregisterExternalFileResolver() {
        externalFileResolver = null;
    }

    public void setRenderDPI(float f) {
        this.renderDPI = f;
    }

    public float getRenderDPI() {
        return this.renderDPI;
    }

    public Picture renderToPicture() {
        return renderToPicture((RenderOptions) null);
    }

    public Picture renderToPicture(int i, int i2) {
        return renderToPicture(i, i2, (RenderOptions) null);
    }

    public Picture renderToPicture(RenderOptions renderOptions) {
        Box box = (renderOptions == null || !renderOptions.hasViewBox()) ? this.rootElement.viewBox : renderOptions.viewBox;
        if (renderOptions != null && renderOptions.hasViewPort()) {
            return renderToPicture((int) Math.ceil((double) renderOptions.viewPort.maxX()), (int) Math.ceil((double) renderOptions.viewPort.maxY()), renderOptions);
        } else if (this.rootElement.width != null && this.rootElement.width.unit != Unit.percent && this.rootElement.height != null && this.rootElement.height.unit != Unit.percent) {
            return renderToPicture((int) Math.ceil((double) this.rootElement.width.floatValue(this.renderDPI)), (int) Math.ceil((double) this.rootElement.height.floatValue(this.renderDPI)), renderOptions);
        } else if (this.rootElement.width != null && box != null) {
            float floatValue = this.rootElement.width.floatValue(this.renderDPI);
            return renderToPicture((int) Math.ceil((double) floatValue), (int) Math.ceil((double) ((box.height * floatValue) / box.width)), renderOptions);
        } else if (this.rootElement.height == null || box == null) {
            return renderToPicture(512, 512, renderOptions);
        } else {
            float floatValue2 = this.rootElement.height.floatValue(this.renderDPI);
            return renderToPicture((int) Math.ceil((double) ((box.width * floatValue2) / box.height)), (int) Math.ceil((double) floatValue2), renderOptions);
        }
    }

    public Picture renderToPicture(int i, int i2, RenderOptions renderOptions) {
        Picture picture = new Picture();
        Canvas beginRecording = picture.beginRecording(i, i2);
        if (renderOptions == null || renderOptions.viewPort == null) {
            renderOptions = renderOptions == null ? new RenderOptions() : new RenderOptions(renderOptions);
            renderOptions.viewPort(0.0f, 0.0f, (float) i, (float) i2);
        }
        new SVGAndroidRenderer(beginRecording, this.renderDPI).renderDocument(this, renderOptions);
        picture.endRecording();
        return picture;
    }

    public Picture renderViewToPicture(String str, int i, int i2) {
        RenderOptions renderOptions = new RenderOptions();
        renderOptions.view(str).viewPort(0.0f, 0.0f, (float) i, (float) i2);
        Picture picture = new Picture();
        new SVGAndroidRenderer(picture.beginRecording(i, i2), this.renderDPI).renderDocument(this, renderOptions);
        picture.endRecording();
        return picture;
    }

    public void renderToCanvas(Canvas canvas) {
        RenderOptions renderOptions = null;
        renderToCanvas(canvas, (RenderOptions) null);
    }

    public void renderToCanvas(Canvas canvas, RectF rectF) {
        RenderOptions renderOptions = new RenderOptions();
        if (rectF != null) {
            renderOptions.viewPort(rectF.left, rectF.top, rectF.width(), rectF.height());
        } else {
            renderOptions.viewPort(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        }
        new SVGAndroidRenderer(canvas, this.renderDPI).renderDocument(this, renderOptions);
    }

    public void renderToCanvas(Canvas canvas, RenderOptions renderOptions) {
        if (renderOptions == null) {
            renderOptions = new RenderOptions();
        }
        if (!renderOptions.hasViewPort()) {
            renderOptions.viewPort(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        }
        new SVGAndroidRenderer(canvas, this.renderDPI).renderDocument(this, renderOptions);
    }

    public void renderViewToCanvas(String str, Canvas canvas) {
        renderToCanvas(canvas, RenderOptions.create().view(str));
    }

    public void renderViewToCanvas(String str, Canvas canvas, RectF rectF) {
        RenderOptions view = RenderOptions.create().view(str);
        if (rectF != null) {
            view.viewPort(rectF.left, rectF.top, rectF.width(), rectF.height());
        }
        renderToCanvas(canvas, view);
    }

    public String getDocumentTitle() {
        if (this.rootElement != null) {
            return this.title;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public String getDocumentDescription() {
        if (this.rootElement != null) {
            return this.desc;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public String getDocumentSVGVersion() {
        Svg svg = this.rootElement;
        if (svg != null) {
            return svg.version;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public Set<String> getViewList() {
        if (this.rootElement != null) {
            List<SvgObject> elementsByTagName = getElementsByTagName(ViewHierarchyConstants.VIEW_KEY);
            HashSet hashSet = new HashSet(elementsByTagName.size());
            Iterator<SvgObject> it = elementsByTagName.iterator();
            while (it.hasNext()) {
                View view = (View) it.next();
                if (view.id != null) {
                    hashSet.add(view.id);
                } else {
                    Log.w("AndroidSVG", "getViewList(): found a <view> without an id attribute");
                }
            }
            return hashSet;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public float getDocumentWidth() {
        if (this.rootElement != null) {
            return getDocumentDimensions(this.renderDPI).width;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void setDocumentWidth(float f) {
        Svg svg = this.rootElement;
        if (svg != null) {
            svg.width = new Length(f);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void setDocumentWidth(String str) throws SVGParseException {
        Svg svg = this.rootElement;
        if (svg != null) {
            svg.width = SVGParser.parseLength(str);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public float getDocumentHeight() {
        if (this.rootElement != null) {
            return getDocumentDimensions(this.renderDPI).height;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void setDocumentHeight(float f) {
        Svg svg = this.rootElement;
        if (svg != null) {
            svg.height = new Length(f);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void setDocumentHeight(String str) throws SVGParseException {
        Svg svg = this.rootElement;
        if (svg != null) {
            svg.height = SVGParser.parseLength(str);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void setDocumentViewBox(float f, float f2, float f3, float f4) {
        Svg svg = this.rootElement;
        if (svg != null) {
            svg.viewBox = new Box(f, f2, f3, f4);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public RectF getDocumentViewBox() {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        } else if (svg.viewBox == null) {
            return null;
        } else {
            return this.rootElement.viewBox.toRectF();
        }
    }

    public void setDocumentPreserveAspectRatio(PreserveAspectRatio preserveAspectRatio) {
        Svg svg = this.rootElement;
        if (svg != null) {
            svg.preserveAspectRatio = preserveAspectRatio;
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public PreserveAspectRatio getDocumentPreserveAspectRatio() {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        } else if (svg.preserveAspectRatio == null) {
            return null;
        } else {
            return this.rootElement.preserveAspectRatio;
        }
    }

    public float getDocumentAspectRatio() {
        float f;
        float f2;
        Svg svg = this.rootElement;
        if (svg != null) {
            Length length = svg.width;
            Length length2 = this.rootElement.height;
            if (length == null || length2 == null || length.unit == Unit.percent || length2.unit == Unit.percent) {
                if (this.rootElement.viewBox == null || this.rootElement.viewBox.width == 0.0f || this.rootElement.viewBox.height == 0.0f) {
                    return -1.0f;
                }
                f = this.rootElement.viewBox.width;
                f2 = this.rootElement.viewBox.height;
            } else if (length.isZero() || length2.isZero()) {
                return -1.0f;
            } else {
                f = length.floatValue(this.renderDPI);
                f2 = length2.floatValue(this.renderDPI);
            }
            return f / f2;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    /* access modifiers changed from: package-private */
    public Svg getRootElement() {
        return this.rootElement;
    }

    /* access modifiers changed from: package-private */
    public void setRootElement(Svg svg) {
        this.rootElement = svg;
    }

    /* access modifiers changed from: package-private */
    public SvgObject resolveIRI(String str) {
        if (str == null) {
            return null;
        }
        String cssQuotedString = cssQuotedString(str);
        if (cssQuotedString.length() <= 1 || !cssQuotedString.startsWith("#")) {
            return null;
        }
        return getElementById(cssQuotedString.substring(1));
    }

    private String cssQuotedString(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        return str.replace("\\\n", "").replace("\\A", "\n");
    }

    private Box getDocumentDimensions(float f) {
        float f2;
        Length length = this.rootElement.width;
        Length length2 = this.rootElement.height;
        if (length == null || length.isZero() || length.unit == Unit.percent || length.unit == Unit.em || length.unit == Unit.ex) {
            return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
        }
        float floatValue = length.floatValue(f);
        if (length2 == null) {
            f2 = this.rootElement.viewBox != null ? (this.rootElement.viewBox.height * floatValue) / this.rootElement.viewBox.width : floatValue;
        } else if (length2.isZero() || length2.unit == Unit.percent || length2.unit == Unit.em || length2.unit == Unit.ex) {
            return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
        } else {
            f2 = length2.floatValue(f);
        }
        return new Box(0.0f, 0.0f, floatValue, f2);
    }

    /* access modifiers changed from: package-private */
    public void addCSSRules(CSSParser.Ruleset ruleset) {
        this.cssRules.addAll(ruleset);
    }

    /* access modifiers changed from: package-private */
    public List<CSSParser.Rule> getCSSRules() {
        return this.cssRules.getRules();
    }

    /* access modifiers changed from: package-private */
    public boolean hasCSSRules() {
        return !this.cssRules.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void clearRenderCSSRules() {
        this.cssRules.removeFromSource(CSSParser.Source.RenderOptions);
    }

    static class Box {
        float height;
        float minX;
        float minY;
        float width;

        Box(float f, float f2, float f3, float f4) {
            this.minX = f;
            this.minY = f2;
            this.width = f3;
            this.height = f4;
        }

        Box(Box box) {
            this.minX = box.minX;
            this.minY = box.minY;
            this.width = box.width;
            this.height = box.height;
        }

        static Box fromLimits(float f, float f2, float f3, float f4) {
            return new Box(f, f2, f3 - f, f4 - f2);
        }

        /* access modifiers changed from: package-private */
        public RectF toRectF() {
            return new RectF(this.minX, this.minY, maxX(), maxY());
        }

        /* access modifiers changed from: package-private */
        public float maxX() {
            return this.minX + this.width;
        }

        /* access modifiers changed from: package-private */
        public float maxY() {
            return this.minY + this.height;
        }

        /* access modifiers changed from: package-private */
        public void union(Box box) {
            float f = box.minX;
            if (f < this.minX) {
                this.minX = f;
            }
            float f2 = box.minY;
            if (f2 < this.minY) {
                this.minY = f2;
            }
            if (box.maxX() > maxX()) {
                this.width = box.maxX() - this.minX;
            }
            if (box.maxY() > maxY()) {
                this.height = box.maxY() - this.minY;
            }
        }

        public String toString() {
            return "[" + this.minX + " " + this.minY + " " + this.width + " " + this.height + "]";
        }
    }

    static class Style implements Cloneable {
        static final int FONT_WEIGHT_BOLD = 700;
        static final int FONT_WEIGHT_BOLDER = 1;
        static final int FONT_WEIGHT_LIGHTER = -1;
        static final int FONT_WEIGHT_NORMAL = 400;
        CSSClipRect clip;
        String clipPath;
        FillRule clipRule;
        Colour color;
        TextDirection direction;
        Boolean display;
        SvgPaint fill;
        Float fillOpacity;
        FillRule fillRule;
        List<String> fontFamily;
        Length fontSize;
        FontStyle fontStyle;
        Integer fontWeight;
        RenderQuality imageRendering;
        String markerEnd;
        String markerMid;
        String markerStart;
        String mask;
        Float opacity;
        Boolean overflow;
        SvgPaint solidColor;
        Float solidOpacity;
        long specifiedFlags = 0;
        SvgPaint stopColor;
        Float stopOpacity;
        SvgPaint stroke;
        Length[] strokeDashArray;
        Length strokeDashOffset;
        LineCap strokeLineCap;
        LineJoin strokeLineJoin;
        Float strokeMiterLimit;
        Float strokeOpacity;
        Length strokeWidth;
        TextAnchor textAnchor;
        TextDecoration textDecoration;
        VectorEffect vectorEffect;
        SvgPaint viewportFill;
        Float viewportFillOpacity;
        Boolean visibility;

        public enum FillRule {
            NonZero,
            EvenOdd
        }

        public enum FontStyle {
            Normal,
            Italic,
            Oblique
        }

        public enum LineCap {
            Butt,
            Round,
            Square
        }

        public enum LineJoin {
            Miter,
            Round,
            Bevel
        }

        public enum RenderQuality {
            auto,
            optimizeQuality,
            optimizeSpeed
        }

        public enum TextAnchor {
            Start,
            Middle,
            End
        }

        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        public enum TextDirection {
            LTR,
            RTL
        }

        public enum VectorEffect {
            None,
            NonScalingStroke
        }

        Style() {
        }

        static Style getDefaultStyle() {
            Style style = new Style();
            style.specifiedFlags = -1;
            style.fill = Colour.BLACK;
            style.fillRule = FillRule.NonZero;
            Float valueOf = Float.valueOf(1.0f);
            style.fillOpacity = valueOf;
            style.stroke = null;
            style.strokeOpacity = valueOf;
            style.strokeWidth = new Length(1.0f);
            style.strokeLineCap = LineCap.Butt;
            style.strokeLineJoin = LineJoin.Miter;
            style.strokeMiterLimit = Float.valueOf(4.0f);
            style.strokeDashArray = null;
            style.strokeDashOffset = new Length(0.0f);
            style.opacity = valueOf;
            style.color = Colour.BLACK;
            style.fontFamily = null;
            style.fontSize = new Length(12.0f, Unit.pt);
            style.fontWeight = 400;
            style.fontStyle = FontStyle.Normal;
            style.textDecoration = TextDecoration.None;
            style.direction = TextDirection.LTR;
            style.textAnchor = TextAnchor.Start;
            style.overflow = true;
            style.clip = null;
            style.markerStart = null;
            style.markerMid = null;
            style.markerEnd = null;
            style.display = Boolean.TRUE;
            style.visibility = Boolean.TRUE;
            style.stopColor = Colour.BLACK;
            style.stopOpacity = valueOf;
            style.clipPath = null;
            style.clipRule = FillRule.NonZero;
            style.mask = null;
            style.solidColor = null;
            style.solidOpacity = valueOf;
            style.viewportFill = null;
            style.viewportFillOpacity = valueOf;
            style.vectorEffect = VectorEffect.None;
            style.imageRendering = RenderQuality.auto;
            return style;
        }

        /* access modifiers changed from: package-private */
        public void resetNonInheritingProperties(boolean z) {
            this.display = Boolean.TRUE;
            this.overflow = z ? Boolean.TRUE : Boolean.FALSE;
            this.clip = null;
            this.clipPath = null;
            this.opacity = Float.valueOf(1.0f);
            this.stopColor = Colour.BLACK;
            this.stopOpacity = Float.valueOf(1.0f);
            this.mask = null;
            this.solidColor = null;
            this.solidOpacity = Float.valueOf(1.0f);
            this.viewportFill = null;
            this.viewportFillOpacity = Float.valueOf(1.0f);
            this.vectorEffect = VectorEffect.None;
        }

        /* access modifiers changed from: protected */
        public Object clone() throws CloneNotSupportedException {
            Style style = (Style) super.clone();
            Length[] lengthArr = this.strokeDashArray;
            if (lengthArr != null) {
                style.strokeDashArray = (Length[]) lengthArr.clone();
            }
            return style;
        }
    }

    static abstract class SvgPaint implements Cloneable {
        SvgPaint() {
        }
    }

    static class Colour extends SvgPaint {
        static final Colour BLACK = new Colour(ViewCompat.MEASURED_STATE_MASK);
        static final Colour TRANSPARENT = new Colour(0);
        int colour;

        Colour(int i) {
            this.colour = i;
        }

        public String toString() {
            return String.format("#%08x", new Object[]{Integer.valueOf(this.colour)});
        }
    }

    static class CurrentColor extends SvgPaint {
        private static CurrentColor instance = new CurrentColor();

        private CurrentColor() {
        }

        static CurrentColor getInstance() {
            return instance;
        }
    }

    static class PaintReference extends SvgPaint {
        SvgPaint fallback;
        String href;

        PaintReference(String str, SvgPaint svgPaint) {
            this.href = str;
            this.fallback = svgPaint;
        }

        public String toString() {
            return this.href + " " + this.fallback;
        }
    }

    static class Length implements Cloneable {
        Unit unit;
        float value;

        Length(float f, Unit unit2) {
            this.value = f;
            this.unit = unit2;
        }

        Length(float f) {
            this.value = f;
            this.unit = Unit.px;
        }

        /* access modifiers changed from: package-private */
        public float floatValue() {
            return this.value;
        }

        /* access modifiers changed from: package-private */
        public float floatValueX(SVGAndroidRenderer sVGAndroidRenderer) {
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVG$Unit[this.unit.ordinal()]) {
                case 1:
                    return this.value;
                case 2:
                    return this.value * sVGAndroidRenderer.getCurrentFontSize();
                case 3:
                    return this.value * sVGAndroidRenderer.getCurrentFontXHeight();
                case 4:
                    return this.value * sVGAndroidRenderer.getDPI();
                case 5:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 2.54f;
                case 6:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 25.4f;
                case 7:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 72.0f;
                case 8:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 6.0f;
                case 9:
                    Box currentViewPortInUserUnits = sVGAndroidRenderer.getCurrentViewPortInUserUnits();
                    if (currentViewPortInUserUnits == null) {
                        return this.value;
                    }
                    return (this.value * currentViewPortInUserUnits.width) / 100.0f;
                default:
                    return this.value;
            }
        }

        /* access modifiers changed from: package-private */
        public float floatValueY(SVGAndroidRenderer sVGAndroidRenderer) {
            if (this.unit != Unit.percent) {
                return floatValueX(sVGAndroidRenderer);
            }
            Box currentViewPortInUserUnits = sVGAndroidRenderer.getCurrentViewPortInUserUnits();
            if (currentViewPortInUserUnits == null) {
                return this.value;
            }
            return (this.value * currentViewPortInUserUnits.height) / 100.0f;
        }

        /* access modifiers changed from: package-private */
        public float floatValue(SVGAndroidRenderer sVGAndroidRenderer) {
            if (this.unit != Unit.percent) {
                return floatValueX(sVGAndroidRenderer);
            }
            Box currentViewPortInUserUnits = sVGAndroidRenderer.getCurrentViewPortInUserUnits();
            if (currentViewPortInUserUnits == null) {
                return this.value;
            }
            float f = currentViewPortInUserUnits.width;
            float f2 = currentViewPortInUserUnits.height;
            if (f == f2) {
                return (this.value * f) / 100.0f;
            }
            return (this.value * ((float) (Math.sqrt((double) ((f * f) + (f2 * f2))) / SVG.SQRT2))) / 100.0f;
        }

        /* access modifiers changed from: package-private */
        public float floatValue(SVGAndroidRenderer sVGAndroidRenderer, float f) {
            if (this.unit == Unit.percent) {
                return (this.value * f) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }

        /* access modifiers changed from: package-private */
        public float floatValue(float f) {
            int i = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVG$Unit[this.unit.ordinal()];
            if (i == 1) {
                return this.value;
            }
            switch (i) {
                case 4:
                    return this.value * f;
                case 5:
                    return (this.value * f) / 2.54f;
                case 6:
                    return (this.value * f) / 25.4f;
                case 7:
                    return (this.value * f) / 72.0f;
                case 8:
                    return (this.value * f) / 6.0f;
                default:
                    return this.value;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isZero() {
            return this.value == 0.0f;
        }

        /* access modifiers changed from: package-private */
        public boolean isNegative() {
            return this.value < 0.0f;
        }

        public String toString() {
            return String.valueOf(this.value) + this.unit;
        }
    }

    /* renamed from: com.caverock.androidsvg.SVG$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVG$Unit;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.caverock.androidsvg.SVG$Unit[] r0 = com.caverock.androidsvg.SVG.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$caverock$androidsvg$SVG$Unit = r0
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.px     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVG$Unit     // Catch:{ NoSuchFieldError -> 0x001d }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.em     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVG$Unit     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.ex     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVG$Unit     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.in     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVG$Unit     // Catch:{ NoSuchFieldError -> 0x003e }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.cm     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVG$Unit     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.mm     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVG$Unit     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.pt     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVG$Unit     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.pc     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVG$Unit     // Catch:{ NoSuchFieldError -> 0x006c }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.percent     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVG.AnonymousClass1.<clinit>():void");
        }
    }

    static class CSSClipRect {
        Length bottom;
        Length left;
        Length right;
        Length top;

        CSSClipRect(Length length, Length length2, Length length3, Length length4) {
            this.top = length;
            this.right = length2;
            this.bottom = length3;
            this.left = length4;
        }
    }

    static class SvgObject {
        SVG document;
        SvgContainer parent;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "";
        }

        SvgObject() {
        }
    }

    static abstract class SvgElementBase extends SvgObject {
        Style baseStyle = null;
        List<String> classNames = null;
        String id = null;
        Boolean spacePreserve = null;
        Style style = null;

        SvgElementBase() {
        }

        public String toString() {
            return getNodeName();
        }
    }

    static abstract class SvgElement extends SvgElementBase {
        Box boundingBox = null;

        SvgElement() {
        }
    }

    static abstract class SvgConditionalElement extends SvgElement implements SvgConditional {
        String requiredExtensions = null;
        Set<String> requiredFeatures = null;
        Set<String> requiredFonts = null;
        Set<String> requiredFormats = null;
        Set<String> systemLanguage = null;

        SvgConditionalElement() {
        }

        public void setRequiredFeatures(Set<String> set) {
            this.requiredFeatures = set;
        }

        public Set<String> getRequiredFeatures() {
            return this.requiredFeatures;
        }

        public void setRequiredExtensions(String str) {
            this.requiredExtensions = str;
        }

        public String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        public void setSystemLanguage(Set<String> set) {
            this.systemLanguage = set;
        }

        public Set<String> getSystemLanguage() {
            return this.systemLanguage;
        }

        public void setRequiredFormats(Set<String> set) {
            this.requiredFormats = set;
        }

        public Set<String> getRequiredFormats() {
            return this.requiredFormats;
        }

        public void setRequiredFonts(Set<String> set) {
            this.requiredFonts = set;
        }

        public Set<String> getRequiredFonts() {
            return this.requiredFonts;
        }
    }

    static abstract class SvgConditionalContainer extends SvgElement implements SvgContainer, SvgConditional {
        List<SvgObject> children = new ArrayList();
        String requiredExtensions = null;
        Set<String> requiredFeatures = null;
        Set<String> requiredFonts = null;
        Set<String> requiredFormats = null;
        Set<String> systemLanguage = null;

        public Set<String> getSystemLanguage() {
            return null;
        }

        SvgConditionalContainer() {
        }

        public List<SvgObject> getChildren() {
            return this.children;
        }

        public void addChild(SvgObject svgObject) throws SVGParseException {
            this.children.add(svgObject);
        }

        public void setRequiredFeatures(Set<String> set) {
            this.requiredFeatures = set;
        }

        public Set<String> getRequiredFeatures() {
            return this.requiredFeatures;
        }

        public void setRequiredExtensions(String str) {
            this.requiredExtensions = str;
        }

        public String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        public void setSystemLanguage(Set<String> set) {
            this.systemLanguage = set;
        }

        public void setRequiredFormats(Set<String> set) {
            this.requiredFormats = set;
        }

        public Set<String> getRequiredFormats() {
            return this.requiredFormats;
        }

        public void setRequiredFonts(Set<String> set) {
            this.requiredFonts = set;
        }

        public Set<String> getRequiredFonts() {
            return this.requiredFonts;
        }
    }

    static abstract class SvgPreserveAspectRatioContainer extends SvgConditionalContainer {
        PreserveAspectRatio preserveAspectRatio = null;

        SvgPreserveAspectRatioContainer() {
        }
    }

    static abstract class SvgViewBoxContainer extends SvgPreserveAspectRatioContainer {
        Box viewBox;

        SvgViewBoxContainer() {
        }
    }

    static class Svg extends SvgViewBoxContainer {
        Length height;
        public String version;
        Length width;
        Length x;
        Length y;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "svg";
        }

        Svg() {
        }
    }

    static class Group extends SvgConditionalContainer implements HasTransform {
        Matrix transform;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "group";
        }

        Group() {
        }

        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    static class Defs extends Group implements NotDirectlyRendered {
        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "defs";
        }

        Defs() {
        }
    }

    static abstract class GraphicsElement extends SvgConditionalElement implements HasTransform {
        Matrix transform;

        GraphicsElement() {
        }

        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    static class Use extends Group {
        Length height;
        String href;
        Length width;
        Length x;
        Length y;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "use";
        }

        Use() {
        }
    }

    static class Path extends GraphicsElement {
        PathDefinition d;
        Float pathLength;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH;
        }

        Path() {
        }
    }

    static class Rect extends GraphicsElement {
        Length height;
        Length rx;
        Length ry;
        Length width;
        Length x;
        Length y;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "rect";
        }

        Rect() {
        }
    }

    static class Circle extends GraphicsElement {
        Length cx;
        Length cy;
        Length r;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE;
        }

        Circle() {
        }
    }

    static class Ellipse extends GraphicsElement {
        Length cx;
        Length cy;
        Length rx;
        Length ry;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "ellipse";
        }

        Ellipse() {
        }
    }

    static class Line extends GraphicsElement {
        Length x1;
        Length x2;
        Length y1;
        Length y2;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "line";
        }

        Line() {
        }
    }

    static class PolyLine extends GraphicsElement {
        float[] points;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "polyline";
        }

        PolyLine() {
        }
    }

    static class Polygon extends PolyLine {
        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "polygon";
        }

        Polygon() {
        }
    }

    static abstract class TextContainer extends SvgConditionalContainer {
        TextContainer() {
        }

        public void addChild(SvgObject svgObject) throws SVGParseException {
            if (svgObject instanceof TextChild) {
                this.children.add(svgObject);
                return;
            }
            throw new SVGParseException("Text content elements cannot contain " + svgObject + " elements.");
        }
    }

    static abstract class TextPositionedContainer extends TextContainer {
        List<Length> dx;
        List<Length> dy;
        List<Length> x;
        List<Length> y;

        TextPositionedContainer() {
        }
    }

    static class Text extends TextPositionedContainer implements TextRoot, HasTransform {
        Matrix transform;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "text";
        }

        Text() {
        }

        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    static class TSpan extends TextPositionedContainer implements TextChild {
        private TextRoot textRoot;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "tspan";
        }

        TSpan() {
        }

        public void setTextRoot(TextRoot textRoot2) {
            this.textRoot = textRoot2;
        }

        public TextRoot getTextRoot() {
            return this.textRoot;
        }
    }

    static class TextSequence extends SvgObject implements TextChild {
        String text;
        private TextRoot textRoot;

        TextSequence(String str) {
            this.text = str;
        }

        public String toString() {
            return "TextChild: '" + this.text + "'";
        }

        public void setTextRoot(TextRoot textRoot2) {
            this.textRoot = textRoot2;
        }

        public TextRoot getTextRoot() {
            return this.textRoot;
        }
    }

    static class TRef extends TextContainer implements TextChild {
        String href;
        private TextRoot textRoot;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "tref";
        }

        TRef() {
        }

        public void setTextRoot(TextRoot textRoot2) {
            this.textRoot = textRoot2;
        }

        public TextRoot getTextRoot() {
            return this.textRoot;
        }
    }

    static class TextPath extends TextContainer implements TextChild {
        String href;
        Length startOffset;
        private TextRoot textRoot;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "textPath";
        }

        TextPath() {
        }

        public void setTextRoot(TextRoot textRoot2) {
            this.textRoot = textRoot2;
        }

        public TextRoot getTextRoot() {
            return this.textRoot;
        }
    }

    static class Switch extends Group {
        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "switch";
        }

        Switch() {
        }
    }

    static class Symbol extends SvgViewBoxContainer implements NotDirectlyRendered {
        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return SentryStackFrame.JsonKeys.SYMBOL;
        }

        Symbol() {
        }
    }

    static class Marker extends SvgViewBoxContainer implements NotDirectlyRendered {
        Length markerHeight;
        boolean markerUnitsAreUser;
        Length markerWidth;
        Float orient;
        Length refX;
        Length refY;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "marker";
        }

        Marker() {
        }
    }

    static abstract class GradientElement extends SvgElementBase implements SvgContainer {
        List<SvgObject> children = new ArrayList();
        Matrix gradientTransform;
        Boolean gradientUnitsAreUser;
        String href;
        GradientSpread spreadMethod;

        GradientElement() {
        }

        public List<SvgObject> getChildren() {
            return this.children;
        }

        public void addChild(SvgObject svgObject) throws SVGParseException {
            if (svgObject instanceof Stop) {
                this.children.add(svgObject);
                return;
            }
            throw new SVGParseException("Gradient elements cannot contain " + svgObject + " elements.");
        }
    }

    static class Stop extends SvgElementBase implements SvgContainer {
        Float offset;

        public void addChild(SvgObject svgObject) {
        }

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "stop";
        }

        Stop() {
        }

        public List<SvgObject> getChildren() {
            return Collections.emptyList();
        }
    }

    static class SvgLinearGradient extends GradientElement {
        Length x1;
        Length x2;
        Length y1;
        Length y2;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "linearGradient";
        }

        SvgLinearGradient() {
        }
    }

    static class SvgRadialGradient extends GradientElement {
        Length cx;
        Length cy;
        Length fx;
        Length fy;
        Length r;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "radialGradient";
        }

        SvgRadialGradient() {
        }
    }

    static class ClipPath extends Group implements NotDirectlyRendered {
        Boolean clipPathUnitsAreUser;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "clipPath";
        }

        ClipPath() {
        }
    }

    static class Pattern extends SvgViewBoxContainer implements NotDirectlyRendered {
        Length height;
        String href;
        Boolean patternContentUnitsAreUser;
        Matrix patternTransform;
        Boolean patternUnitsAreUser;
        Length width;
        Length x;
        Length y;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "pattern";
        }

        Pattern() {
        }
    }

    static class Image extends SvgPreserveAspectRatioContainer implements HasTransform {
        Length height;
        String href;
        Matrix transform;
        Length width;
        Length x;
        Length y;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "image";
        }

        Image() {
        }

        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    static class View extends SvgViewBoxContainer implements NotDirectlyRendered {
        static final String NODE_NAME = "view";

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "view";
        }

        View() {
        }
    }

    static class Mask extends SvgConditionalContainer implements NotDirectlyRendered {
        Length height;
        Boolean maskContentUnitsAreUser;
        Boolean maskUnitsAreUser;
        Length width;
        Length x;
        Length y;

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "mask";
        }

        Mask() {
        }
    }

    static class SolidColor extends SvgElementBase implements SvgContainer {
        public void addChild(SvgObject svgObject) {
        }

        /* access modifiers changed from: package-private */
        public String getNodeName() {
            return "solidColor";
        }

        SolidColor() {
        }

        public List<SvgObject> getChildren() {
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    public void setTitle(String str) {
        this.title = str;
    }

    /* access modifiers changed from: package-private */
    public void setDesc(String str) {
        this.desc = str;
    }

    static SVGExternalFileResolver getFileResolver() {
        return externalFileResolver;
    }

    static class PathDefinition implements PathInterface {
        private static final byte ARCTO = 4;
        private static final byte CLOSE = 8;
        private static final byte CUBICTO = 2;
        private static final byte LINETO = 1;
        private static final byte MOVETO = 0;
        private static final byte QUADTO = 3;
        private byte[] commands = new byte[8];
        private int commandsLength = 0;
        private float[] coords = new float[16];
        private int coordsLength = 0;

        PathDefinition() {
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.commandsLength == 0;
        }

        private void addCommand(byte b) {
            int i = this.commandsLength;
            byte[] bArr = this.commands;
            if (i == bArr.length) {
                byte[] bArr2 = new byte[(bArr.length * 2)];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.commands = bArr2;
            }
            byte[] bArr3 = this.commands;
            int i2 = this.commandsLength;
            this.commandsLength = i2 + 1;
            bArr3[i2] = b;
        }

        private void coordsEnsure(int i) {
            float[] fArr = this.coords;
            if (fArr.length < this.coordsLength + i) {
                float[] fArr2 = new float[(fArr.length * 2)];
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                this.coords = fArr2;
            }
        }

        public void moveTo(float f, float f2) {
            addCommand((byte) 0);
            coordsEnsure(2);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            int i2 = i + 1;
            fArr[i] = f;
            this.coordsLength = i2 + 1;
            fArr[i2] = f2;
        }

        public void lineTo(float f, float f2) {
            addCommand((byte) 1);
            coordsEnsure(2);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            int i2 = i + 1;
            fArr[i] = f;
            this.coordsLength = i2 + 1;
            fArr[i2] = f2;
        }

        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            addCommand((byte) 2);
            coordsEnsure(6);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            int i2 = i + 1;
            fArr[i] = f;
            int i3 = i2 + 1;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            fArr[i4] = f4;
            int i6 = i5 + 1;
            fArr[i5] = f5;
            this.coordsLength = i6 + 1;
            fArr[i6] = f6;
        }

        public void quadTo(float f, float f2, float f3, float f4) {
            addCommand((byte) 3);
            coordsEnsure(4);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            int i2 = i + 1;
            fArr[i] = f;
            int i3 = i2 + 1;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            fArr[i3] = f3;
            this.coordsLength = i4 + 1;
            fArr[i4] = f4;
        }

        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            addCommand(((z ? (char) 2 : 0) | true) | z2 ? (byte) 1 : 0);
            coordsEnsure(5);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            int i2 = i + 1;
            fArr[i] = f;
            int i3 = i2 + 1;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            fArr[i4] = f4;
            this.coordsLength = i5 + 1;
            fArr[i5] = f5;
        }

        public void close() {
            addCommand((byte) 8);
        }

        /* access modifiers changed from: package-private */
        public void enumeratePath(PathInterface pathInterface) {
            int i;
            int i2 = 0;
            for (int i3 = 0; i3 < this.commandsLength; i3++) {
                byte b = this.commands[i3];
                if (b == 0) {
                    float[] fArr = this.coords;
                    int i4 = i2 + 1;
                    i = i4 + 1;
                    pathInterface.moveTo(fArr[i2], fArr[i4]);
                } else if (b != 1) {
                    if (b == 2) {
                        float[] fArr2 = this.coords;
                        int i5 = i2 + 1;
                        float f = fArr2[i2];
                        int i6 = i5 + 1;
                        float f2 = fArr2[i5];
                        int i7 = i6 + 1;
                        float f3 = fArr2[i6];
                        int i8 = i7 + 1;
                        float f4 = fArr2[i7];
                        int i9 = i8 + 1;
                        float f5 = fArr2[i8];
                        i2 = i9 + 1;
                        pathInterface.cubicTo(f, f2, f3, f4, f5, fArr2[i9]);
                    } else if (b == 3) {
                        float[] fArr3 = this.coords;
                        int i10 = i2 + 1;
                        int i11 = i10 + 1;
                        int i12 = i11 + 1;
                        pathInterface.quadTo(fArr3[i2], fArr3[i10], fArr3[i11], fArr3[i12]);
                        i2 = i12 + 1;
                    } else if (b != 8) {
                        boolean z = (b & 2) != 0;
                        boolean z2 = (b & 1) != 0;
                        float[] fArr4 = this.coords;
                        int i13 = i2 + 1;
                        float f6 = fArr4[i2];
                        int i14 = i13 + 1;
                        float f7 = fArr4[i13];
                        int i15 = i14 + 1;
                        float f8 = fArr4[i14];
                        int i16 = i15 + 1;
                        pathInterface.arcTo(f6, f7, f8, z, z2, fArr4[i15], fArr4[i16]);
                        i2 = i16 + 1;
                    } else {
                        pathInterface.close();
                    }
                } else {
                    float[] fArr5 = this.coords;
                    int i17 = i2 + 1;
                    i = i17 + 1;
                    pathInterface.lineTo(fArr5[i2], fArr5[i17]);
                }
                i2 = i;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public SvgElementBase getElementById(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.rootElement.id)) {
            return this.rootElement;
        }
        if (this.idToElementMap.containsKey(str)) {
            return this.idToElementMap.get(str);
        }
        SvgElementBase elementById = getElementById(this.rootElement, str);
        this.idToElementMap.put(str, elementById);
        return elementById;
    }

    private SvgElementBase getElementById(SvgContainer svgContainer, String str) {
        SvgElementBase elementById;
        SvgElementBase svgElementBase = (SvgElementBase) svgContainer;
        if (str.equals(svgElementBase.id)) {
            return svgElementBase;
        }
        for (SvgObject next : svgContainer.getChildren()) {
            if (next instanceof SvgElementBase) {
                SvgElementBase svgElementBase2 = (SvgElementBase) next;
                if (str.equals(svgElementBase2.id)) {
                    return svgElementBase2;
                }
                if ((next instanceof SvgContainer) && (elementById = getElementById((SvgContainer) next, str)) != null) {
                    return elementById;
                }
            }
        }
        return null;
    }

    private List<SvgObject> getElementsByTagName(String str) {
        ArrayList arrayList = new ArrayList();
        getElementsByTagName(arrayList, this.rootElement, str);
        return arrayList;
    }

    private void getElementsByTagName(List<SvgObject> list, SvgObject svgObject, String str) {
        if (svgObject.getNodeName().equals(str)) {
            list.add(svgObject);
        }
        if (svgObject instanceof SvgContainer) {
            for (SvgObject elementsByTagName : ((SvgContainer) svgObject).getChildren()) {
                getElementsByTagName(list, elementsByTagName, str);
            }
        }
    }
}
