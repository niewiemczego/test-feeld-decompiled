package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.adapty.internal.crossplatform.UtilsKt;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import io.sentry.ProfilingTraceData;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;

class SVGParser {
    private static final String CURRENTCOLOR = "currentColor";
    public static final int ENTITY_WATCH_BUFFER_SIZE = 4096;
    private static final String FEATURE_STRING_PREFIX = "http://www.w3.org/TR/SVG11/feature#";
    private static final String NONE = "none";
    private static final String SVG_NAMESPACE = "http://www.w3.org/2000/svg";
    private static final String TAG = "SVGParser";
    private static final String VALID_DISPLAY_VALUES = "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|";
    private static final String VALID_VISIBILITY_VALUES = "|visible|hidden|collapse|";
    private static final String XLINK_NAMESPACE = "http://www.w3.org/1999/xlink";
    public static final String XML_STYLESHEET_ATTR_ALTERNATE = "alternate";
    public static final String XML_STYLESHEET_ATTR_ALTERNATE_NO = "no";
    public static final String XML_STYLESHEET_ATTR_HREF = "href";
    public static final String XML_STYLESHEET_ATTR_MEDIA = "media";
    public static final String XML_STYLESHEET_ATTR_MEDIA_ALL = "all";
    public static final String XML_STYLESHEET_ATTR_TYPE = "type";
    private static final String XML_STYLESHEET_PROCESSING_INSTRUCTION = "xml-stylesheet";
    private SVG.SvgContainer currentElement = null;
    private int ignoreDepth;
    private boolean ignoring = false;
    private boolean inMetadataElement = false;
    private boolean inStyleElement = false;
    private StringBuilder metadataElementContents = null;
    private SVGElem metadataTag = null;
    private StringBuilder styleElementContents = null;
    private SVG svgDocument = null;

    private void debug(String str, Object... objArr) {
    }

    /* access modifiers changed from: private */
    public void endDocument() {
    }

    private static float hueToRgb(float f, float f2, float f3) {
        float f4;
        if (f3 < 0.0f) {
            f3 += 6.0f;
        }
        if (f3 >= 6.0f) {
            f3 -= 6.0f;
        }
        if (f3 < 1.0f) {
            f4 = (f2 - f) * f3;
        } else if (f3 < 3.0f) {
            return f2;
        } else {
            if (f3 >= 4.0f) {
                return f;
            }
            f4 = (f2 - f) * (4.0f - f3);
        }
        return f4 + f;
    }

    SVGParser() {
    }

    private enum SVGElem {
        svg,
        a,
        circle,
        clipPath,
        defs,
        desc,
        ellipse,
        g,
        image,
        line,
        linearGradient,
        marker,
        mask,
        path,
        pattern,
        polygon,
        polyline,
        radialGradient,
        rect,
        solidColor,
        stop,
        style,
        SWITCH,
        symbol,
        text,
        textPath,
        title,
        tref,
        tspan,
        use,
        view,
        UNSUPPORTED;
        
        private static final Map<String, SVGElem> cache = null;

        static {
            cache = new HashMap();
            for (SVGElem sVGElem : values()) {
                if (sVGElem == SWITCH) {
                    cache.put("switch", sVGElem);
                } else if (sVGElem != UNSUPPORTED) {
                    cache.put(sVGElem.name(), sVGElem);
                }
            }
        }

        public static SVGElem fromString(String str) {
            SVGElem sVGElem = cache.get(str);
            if (sVGElem != null) {
                return sVGElem;
            }
            return UNSUPPORTED;
        }
    }

    private enum SVGAttr {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        image_rendering,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;
        
        private static final Map<String, SVGAttr> cache = null;

        static {
            cache = new HashMap();
            for (SVGAttr sVGAttr : values()) {
                if (sVGAttr == CLASS) {
                    cache.put(UtilsKt.CLASS_KEY, sVGAttr);
                } else if (sVGAttr != UNSUPPORTED) {
                    cache.put(sVGAttr.name().replace('_', '-'), sVGAttr);
                }
            }
        }

        public static SVGAttr fromString(String str) {
            SVGAttr sVGAttr = cache.get(str);
            if (sVGAttr != null) {
                return sVGAttr;
            }
            return UNSUPPORTED;
        }
    }

    private static class ColourKeywords {
        private static final Map<String, Integer> colourKeywords;

        private ColourKeywords() {
        }

        static {
            HashMap hashMap = new HashMap(47);
            colourKeywords = hashMap;
            hashMap.put("aliceblue", -984833);
            hashMap.put("antiquewhite", -332841);
            hashMap.put("aqua", -16711681);
            hashMap.put("aquamarine", -8388652);
            hashMap.put("azure", -983041);
            hashMap.put("beige", -657956);
            hashMap.put("bisque", -6972);
            hashMap.put("black", Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
            hashMap.put("blanchedalmond", -5171);
            hashMap.put("blue", -16776961);
            hashMap.put("blueviolet", -7722014);
            hashMap.put("brown", -5952982);
            hashMap.put("burlywood", -2180985);
            hashMap.put("cadetblue", -10510688);
            hashMap.put("chartreuse", -8388864);
            hashMap.put("chocolate", -2987746);
            hashMap.put("coral", -32944);
            hashMap.put("cornflowerblue", -10185235);
            hashMap.put("cornsilk", -1828);
            hashMap.put("crimson", -2354116);
            hashMap.put("cyan", -16711681);
            hashMap.put("darkblue", -16777077);
            hashMap.put("darkcyan", -16741493);
            hashMap.put("darkgoldenrod", -4684277);
            hashMap.put("darkgray", -5658199);
            hashMap.put("darkgreen", -16751616);
            hashMap.put("darkgrey", -5658199);
            hashMap.put("darkkhaki", -4343957);
            hashMap.put("darkmagenta", -7667573);
            hashMap.put("darkolivegreen", -11179217);
            hashMap.put("darkorange", -29696);
            hashMap.put("darkorchid", -6737204);
            hashMap.put("darkred", -7667712);
            hashMap.put("darksalmon", -1468806);
            hashMap.put("darkseagreen", -7357297);
            hashMap.put("darkslateblue", -12042869);
            hashMap.put("darkslategray", -13676721);
            hashMap.put("darkslategrey", -13676721);
            hashMap.put("darkturquoise", -16724271);
            hashMap.put("darkviolet", -7077677);
            hashMap.put("deeppink", -60269);
            hashMap.put("deepskyblue", -16728065);
            hashMap.put("dimgray", -9868951);
            hashMap.put("dimgrey", -9868951);
            hashMap.put("dodgerblue", -14774017);
            hashMap.put("firebrick", -5103070);
            hashMap.put("floralwhite", -1296);
            hashMap.put("forestgreen", -14513374);
            hashMap.put("fuchsia", -65281);
            hashMap.put("gainsboro", -2302756);
            hashMap.put("ghostwhite", -460545);
            hashMap.put("gold", -10496);
            hashMap.put("goldenrod", -2448096);
            hashMap.put("gray", -8355712);
            hashMap.put("green", -16744448);
            hashMap.put("greenyellow", -5374161);
            hashMap.put("grey", -8355712);
            hashMap.put("honeydew", -983056);
            hashMap.put("hotpink", -38476);
            hashMap.put("indianred", -3318692);
            hashMap.put("indigo", -11861886);
            hashMap.put("ivory", -16);
            hashMap.put("khaki", -989556);
            hashMap.put("lavender", -1644806);
            hashMap.put("lavenderblush", -3851);
            hashMap.put("lawngreen", -8586240);
            hashMap.put("lemonchiffon", -1331);
            hashMap.put("lightblue", -5383962);
            hashMap.put("lightcoral", -1015680);
            hashMap.put("lightcyan", -2031617);
            hashMap.put("lightgoldenrodyellow", -329006);
            hashMap.put("lightgray", -2894893);
            hashMap.put("lightgreen", -7278960);
            hashMap.put("lightgrey", -2894893);
            hashMap.put("lightpink", -18751);
            hashMap.put("lightsalmon", -24454);
            hashMap.put("lightseagreen", -14634326);
            hashMap.put("lightskyblue", -7876870);
            hashMap.put("lightslategray", -8943463);
            hashMap.put("lightslategrey", -8943463);
            hashMap.put("lightsteelblue", -5192482);
            hashMap.put("lightyellow", -32);
            hashMap.put("lime", -16711936);
            hashMap.put("limegreen", -13447886);
            hashMap.put("linen", -331546);
            hashMap.put("magenta", -65281);
            hashMap.put("maroon", -8388608);
            hashMap.put("mediumaquamarine", -10039894);
            hashMap.put("mediumblue", -16777011);
            hashMap.put("mediumorchid", -4565549);
            hashMap.put("mediumpurple", -7114533);
            hashMap.put("mediumseagreen", -12799119);
            hashMap.put("mediumslateblue", -8689426);
            hashMap.put("mediumspringgreen", -16713062);
            hashMap.put("mediumturquoise", -12004916);
            hashMap.put("mediumvioletred", -3730043);
            hashMap.put("midnightblue", -15132304);
            hashMap.put("mintcream", -655366);
            hashMap.put("mistyrose", -6943);
            hashMap.put("moccasin", -6987);
            hashMap.put("navajowhite", -8531);
            hashMap.put("navy", -16777088);
            hashMap.put("oldlace", -133658);
            hashMap.put("olive", -8355840);
            hashMap.put("olivedrab", -9728477);
            hashMap.put("orange", -23296);
            hashMap.put("orangered", -47872);
            hashMap.put("orchid", -2461482);
            hashMap.put("palegoldenrod", -1120086);
            hashMap.put("palegreen", -6751336);
            hashMap.put("paleturquoise", -5247250);
            hashMap.put("palevioletred", -2396013);
            hashMap.put("papayawhip", -4139);
            hashMap.put("peachpuff", -9543);
            hashMap.put("peru", -3308225);
            hashMap.put("pink", -16181);
            hashMap.put("plum", -2252579);
            hashMap.put("powderblue", -5185306);
            hashMap.put("purple", -8388480);
            hashMap.put("rebeccapurple", -10079335);
            hashMap.put("red", Integer.valueOf(SupportMenu.CATEGORY_MASK));
            hashMap.put("rosybrown", -4419697);
            hashMap.put("royalblue", -12490271);
            hashMap.put("saddlebrown", -7650029);
            hashMap.put("salmon", -360334);
            hashMap.put("sandybrown", -744352);
            hashMap.put("seagreen", -13726889);
            hashMap.put("seashell", -2578);
            hashMap.put("sienna", -6270419);
            hashMap.put("silver", -4144960);
            hashMap.put("skyblue", -7876885);
            hashMap.put("slateblue", -9807155);
            hashMap.put("slategray", -9404272);
            hashMap.put("slategrey", -9404272);
            hashMap.put("snow", -1286);
            hashMap.put("springgreen", -16711809);
            hashMap.put("steelblue", -12156236);
            hashMap.put("tan", -2968436);
            hashMap.put("teal", -16744320);
            hashMap.put("thistle", -2572328);
            hashMap.put("tomato", -40121);
            hashMap.put("turquoise", -12525360);
            hashMap.put("violet", -1146130);
            hashMap.put("wheat", -663885);
            hashMap.put("white", -1);
            hashMap.put("whitesmoke", -657931);
            hashMap.put("yellow", Integer.valueOf(InputDeviceCompat.SOURCE_ANY));
            hashMap.put("yellowgreen", -6632142);
            hashMap.put("transparent", 0);
        }

        static Integer get(String str) {
            return colourKeywords.get(str);
        }
    }

    private static class FontSizeKeywords {
        private static final Map<String, SVG.Length> fontSizeKeywords;

        private FontSizeKeywords() {
        }

        static {
            HashMap hashMap = new HashMap(9);
            fontSizeKeywords = hashMap;
            hashMap.put("xx-small", new SVG.Length(0.694f, SVG.Unit.pt));
            hashMap.put("x-small", new SVG.Length(0.833f, SVG.Unit.pt));
            hashMap.put("small", new SVG.Length(10.0f, SVG.Unit.pt));
            hashMap.put("medium", new SVG.Length(12.0f, SVG.Unit.pt));
            hashMap.put("large", new SVG.Length(14.4f, SVG.Unit.pt));
            hashMap.put("x-large", new SVG.Length(17.3f, SVG.Unit.pt));
            hashMap.put("xx-large", new SVG.Length(20.7f, SVG.Unit.pt));
            hashMap.put("smaller", new SVG.Length(83.33f, SVG.Unit.percent));
            hashMap.put("larger", new SVG.Length(120.0f, SVG.Unit.percent));
        }

        static SVG.Length get(String str) {
            return fontSizeKeywords.get(str);
        }
    }

    private static class FontWeightKeywords {
        private static final Map<String, Integer> fontWeightKeywords;

        private FontWeightKeywords() {
        }

        static {
            HashMap hashMap = new HashMap(13);
            fontWeightKeywords = hashMap;
            hashMap.put(ProfilingTraceData.TRUNCATION_REASON_NORMAL, 400);
            Integer valueOf = Integer.valueOf(TypefaceStyle.BOLD);
            hashMap.put(TtmlNode.BOLD, valueOf);
            hashMap.put("bolder", 1);
            hashMap.put("lighter", -1);
            hashMap.put("100", 100);
            hashMap.put("200", 200);
            hashMap.put("300", 300);
            hashMap.put("400", 400);
            hashMap.put("500", 500);
            hashMap.put("600", 600);
            hashMap.put("700", valueOf);
            hashMap.put("800", 800);
            hashMap.put("900", 900);
        }

        static Integer get(String str) {
            return fontWeightKeywords.get(str);
        }
    }

    private static class AspectRatioKeywords {
        private static final Map<String, PreserveAspectRatio.Alignment> aspectRatioKeywords;

        private AspectRatioKeywords() {
        }

        static {
            HashMap hashMap = new HashMap(10);
            aspectRatioKeywords = hashMap;
            hashMap.put("none", PreserveAspectRatio.Alignment.none);
            hashMap.put("xMinYMin", PreserveAspectRatio.Alignment.xMinYMin);
            hashMap.put("xMidYMin", PreserveAspectRatio.Alignment.xMidYMin);
            hashMap.put("xMaxYMin", PreserveAspectRatio.Alignment.xMaxYMin);
            hashMap.put("xMinYMid", PreserveAspectRatio.Alignment.xMinYMid);
            hashMap.put("xMidYMid", PreserveAspectRatio.Alignment.xMidYMid);
            hashMap.put("xMaxYMid", PreserveAspectRatio.Alignment.xMaxYMid);
            hashMap.put("xMinYMax", PreserveAspectRatio.Alignment.xMinYMax);
            hashMap.put("xMidYMax", PreserveAspectRatio.Alignment.xMidYMax);
            hashMap.put("xMaxYMax", PreserveAspectRatio.Alignment.xMaxYMax);
        }

        static PreserveAspectRatio.Alignment get(String str) {
            return aspectRatioKeywords.get(str);
        }
    }

    /* access modifiers changed from: package-private */
    public SVG parse(BufferedInputStream bufferedInputStream, boolean z) throws SVGParseException {
        if (!bufferedInputStream.markSupported()) {
            bufferedInputStream = new BufferedInputStream(bufferedInputStream);
        }
        try {
            bufferedInputStream.mark(3);
            int read = bufferedInputStream.read() + (bufferedInputStream.read() << 8);
            bufferedInputStream.reset();
            if (read == 35615) {
                bufferedInputStream = new BufferedInputStream(new GZIPInputStream(bufferedInputStream));
            }
        } catch (IOException unused) {
        }
        try {
            bufferedInputStream.mark(4096);
            parseUsingXmlPullParser(bufferedInputStream, z);
            return this.svgDocument;
        } finally {
            try {
                bufferedInputStream.close();
            } catch (IOException unused2) {
                Log.e(TAG, "Exception thrown closing input stream");
            }
        }
    }

    private class XPPAttributesWrapper implements Attributes {
        private XmlPullParser parser;

        public int getIndex(String str) {
            return -1;
        }

        public int getIndex(String str, String str2) {
            return -1;
        }

        public String getType(int i) {
            return null;
        }

        public String getType(String str) {
            return null;
        }

        public String getType(String str, String str2) {
            return null;
        }

        public String getValue(String str) {
            return null;
        }

        public String getValue(String str, String str2) {
            return null;
        }

        public XPPAttributesWrapper(XmlPullParser xmlPullParser) {
            this.parser = xmlPullParser;
        }

        public int getLength() {
            return this.parser.getAttributeCount();
        }

        public String getURI(int i) {
            return this.parser.getAttributeNamespace(i);
        }

        public String getLocalName(int i) {
            return this.parser.getAttributeName(i);
        }

        public String getQName(int i) {
            String attributeName = this.parser.getAttributeName(i);
            return this.parser.getAttributePrefix(i) != null ? this.parser.getAttributePrefix(i) + ':' + attributeName : attributeName;
        }

        public String getValue(int i) {
            return this.parser.getAttributeValue(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0116, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x011e, code lost:
        throw new com.caverock.androidsvg.SVGParseException("Stream error", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x011f, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0127, code lost:
        throw new com.caverock.androidsvg.SVGParseException("XML parser problem", r9);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x011f A[ExcHandler: XmlPullParserException (r9v1 'e' org.xmlpull.v1.XmlPullParserException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseUsingXmlPullParser(java.io.InputStream r9, boolean r10) throws com.caverock.androidsvg.SVGParseException {
        /*
            r8 = this;
            org.xmlpull.v1.XmlPullParser r0 = android.util.Xml.newPullParser()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            com.caverock.androidsvg.SVGParser$XPPAttributesWrapper r1 = new com.caverock.androidsvg.SVGParser$XPPAttributesWrapper     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            r1.<init>(r0)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r2 = "http://xmlpull.org/v1/doc/features.html#process-docdecl"
            r3 = 0
            r0.setFeature(r2, r3)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r2 = "http://xmlpull.org/v1/doc/features.html#process-namespaces"
            r4 = 1
            r0.setFeature(r2, r4)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            r2 = 0
            r0.setInput(r9, r2)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            int r2 = r0.getEventType()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
        L_0x001d:
            if (r2 == r4) goto L_0x0112
            if (r2 == 0) goto L_0x0109
            r5 = 8
            java.lang.String r6 = "SVGParser"
            if (r2 == r5) goto L_0x00da
            r5 = 10
            if (r2 == r5) goto L_0x00b2
            r5 = 58
            r6 = 2
            if (r2 == r6) goto L_0x0083
            r7 = 3
            if (r2 == r7) goto L_0x0053
            r5 = 4
            if (r2 == r5) goto L_0x0044
            r5 = 5
            if (r2 == r5) goto L_0x003b
            goto L_0x010c
        L_0x003b:
            java.lang.String r2 = r0.getText()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            r8.text((java.lang.String) r2)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            goto L_0x010c
        L_0x0044:
            int[] r2 = new int[r6]     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            char[] r5 = r0.getTextCharacters(r2)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            r6 = r2[r3]     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            r2 = r2[r4]     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            r8.text(r5, r6, r2)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            goto L_0x010c
        L_0x0053:
            java.lang.String r2 = r0.getName()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r6 = r0.getPrefix()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            if (r6 == 0) goto L_0x0076
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r7 = r0.getPrefix()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.StringBuilder r5 = r6.append(r5)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.StringBuilder r2 = r5.append(r2)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r2 = r2.toString()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
        L_0x0076:
            java.lang.String r5 = r0.getNamespace()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r6 = r0.getName()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            r8.endElement(r5, r6, r2)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            goto L_0x010c
        L_0x0083:
            java.lang.String r2 = r0.getName()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r6 = r0.getPrefix()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            if (r6 == 0) goto L_0x00a6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r7 = r0.getPrefix()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.StringBuilder r5 = r6.append(r5)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.StringBuilder r2 = r5.append(r2)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r2 = r2.toString()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
        L_0x00a6:
            java.lang.String r5 = r0.getNamespace()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r6 = r0.getName()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            r8.startElement(r5, r6, r2, r1)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            goto L_0x010c
        L_0x00b2:
            if (r10 == 0) goto L_0x010c
            com.caverock.androidsvg.SVG r2 = r8.svgDocument     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            com.caverock.androidsvg.SVG$Svg r2 = r2.getRootElement()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            if (r2 != 0) goto L_0x010c
            java.lang.String r2 = r0.getText()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r5 = "<!ENTITY "
            boolean r2 = r2.contains(r5)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            if (r2 == 0) goto L_0x010c
            java.lang.String r10 = "Switching to SAX parser to process entities"
            android.util.Log.d(r6, r10)     // Catch:{ IOException -> 0x00d4, XmlPullParserException -> 0x011f }
            r9.reset()     // Catch:{ IOException -> 0x00d4, XmlPullParserException -> 0x011f }
            r8.parseUsingSAX(r9)     // Catch:{ IOException -> 0x00d4, XmlPullParserException -> 0x011f }
            goto L_0x00d9
        L_0x00d4:
            java.lang.String r9 = "Detected internal entity definitions, but could not parse them."
            android.util.Log.w(r6, r9)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
        L_0x00d9:
            return
        L_0x00da:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            r2.<init>()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r5 = "PROC INSTR: "
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r5 = r0.getText()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r2 = r2.toString()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            android.util.Log.d(r6, r2)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            com.caverock.androidsvg.SVGParser$TextScanner r2 = new com.caverock.androidsvg.SVGParser$TextScanner     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r5 = r0.getText()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            r2.<init>(r5)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.lang.String r5 = r2.nextToken()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            java.util.Map r2 = r8.parseProcessingInstructionAttributes(r2)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            r8.handleProcessingInstruction(r5, r2)     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            goto L_0x010c
        L_0x0109:
            r8.startDocument()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
        L_0x010c:
            int r2 = r0.nextToken()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            goto L_0x001d
        L_0x0112:
            r8.endDocument()     // Catch:{ XmlPullParserException -> 0x011f, IOException -> 0x0116 }
            return
        L_0x0116:
            r9 = move-exception
            com.caverock.androidsvg.SVGParseException r10 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r0 = "Stream error"
            r10.<init>(r0, r9)
            throw r10
        L_0x011f:
            r9 = move-exception
            com.caverock.androidsvg.SVGParseException r10 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r0 = "XML parser problem"
            r10.<init>(r0, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.parseUsingXmlPullParser(java.io.InputStream, boolean):void");
    }

    private void parseUsingSAX(InputStream inputStream) throws SVGParseException {
        Log.d(TAG, "Falling back to SAX parser");
        try {
            SAXParserFactory newInstance = SAXParserFactory.newInstance();
            newInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            XMLReader xMLReader = newInstance.newSAXParser().getXMLReader();
            SAXHandler sAXHandler = new SAXHandler(this, (AnonymousClass1) null);
            xMLReader.setContentHandler(sAXHandler);
            xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", sAXHandler);
            xMLReader.parse(new InputSource(inputStream));
        } catch (ParserConfigurationException e) {
            throw new SVGParseException("XML parser problem", e);
        } catch (SAXException e2) {
            throw new SVGParseException("SVG parse error", e2);
        } catch (IOException e3) {
            throw new SVGParseException("Stream error", e3);
        }
    }

    private class SAXHandler extends DefaultHandler2 {
        private SAXHandler() {
        }

        /* synthetic */ SAXHandler(SVGParser sVGParser, AnonymousClass1 r2) {
            this();
        }

        public void startDocument() throws SAXException {
            SVGParser.this.startDocument();
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            SVGParser.this.startElement(str, str2, str3, attributes);
        }

        public void characters(char[] cArr, int i, int i2) throws SAXException {
            SVGParser.this.text(new String(cArr, i, i2));
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            SVGParser.this.endElement(str, str2, str3);
        }

        public void endDocument() throws SAXException {
            SVGParser.this.endDocument();
        }

        public void processingInstruction(String str, String str2) throws SAXException {
            SVGParser.this.handleProcessingInstruction(str, SVGParser.this.parseProcessingInstructionAttributes(new TextScanner(str2)));
        }
    }

    /* access modifiers changed from: private */
    public void startDocument() {
        this.svgDocument = new SVG();
    }

    /* access modifiers changed from: private */
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SVGParseException {
        if (this.ignoring) {
            this.ignoreDepth++;
        } else if (SVG_NAMESPACE.equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            SVGElem fromString = SVGElem.fromString(str2);
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[fromString.ordinal()]) {
                case 1:
                    svg(attributes);
                    return;
                case 2:
                case 3:
                    g(attributes);
                    return;
                case 4:
                    defs(attributes);
                    return;
                case 5:
                    use(attributes);
                    return;
                case 6:
                    path(attributes);
                    return;
                case 7:
                    rect(attributes);
                    return;
                case 8:
                    circle(attributes);
                    return;
                case 9:
                    ellipse(attributes);
                    return;
                case 10:
                    line(attributes);
                    return;
                case 11:
                    polyline(attributes);
                    return;
                case 12:
                    polygon(attributes);
                    return;
                case 13:
                    text(attributes);
                    return;
                case 14:
                    tspan(attributes);
                    return;
                case 15:
                    tref(attributes);
                    return;
                case 16:
                    zwitch(attributes);
                    return;
                case 17:
                    symbol(attributes);
                    return;
                case 18:
                    marker(attributes);
                    return;
                case 19:
                    linearGradient(attributes);
                    return;
                case 20:
                    radialGradient(attributes);
                    return;
                case 21:
                    stop(attributes);
                    return;
                case 22:
                case 23:
                    this.inMetadataElement = true;
                    this.metadataTag = fromString;
                    return;
                case 24:
                    clipPath(attributes);
                    return;
                case 25:
                    textPath(attributes);
                    return;
                case 26:
                    pattern(attributes);
                    return;
                case 27:
                    image(attributes);
                    return;
                case 28:
                    view(attributes);
                    return;
                case 29:
                    mask(attributes);
                    return;
                case 30:
                    style(attributes);
                    return;
                case 31:
                    solidColor(attributes);
                    return;
                default:
                    this.ignoring = true;
                    this.ignoreDepth = 1;
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void text(String str) throws SVGParseException {
        if (!this.ignoring) {
            if (this.inMetadataElement) {
                if (this.metadataElementContents == null) {
                    this.metadataElementContents = new StringBuilder(str.length());
                }
                this.metadataElementContents.append(str);
            } else if (this.inStyleElement) {
                if (this.styleElementContents == null) {
                    this.styleElementContents = new StringBuilder(str.length());
                }
                this.styleElementContents.append(str);
            } else if (this.currentElement instanceof SVG.TextContainer) {
                appendToTextContainer(str);
            }
        }
    }

    private void text(char[] cArr, int i, int i2) throws SVGParseException {
        if (!this.ignoring) {
            if (this.inMetadataElement) {
                if (this.metadataElementContents == null) {
                    this.metadataElementContents = new StringBuilder(i2);
                }
                this.metadataElementContents.append(cArr, i, i2);
            } else if (this.inStyleElement) {
                if (this.styleElementContents == null) {
                    this.styleElementContents = new StringBuilder(i2);
                }
                this.styleElementContents.append(cArr, i, i2);
            } else if (this.currentElement instanceof SVG.TextContainer) {
                appendToTextContainer(new String(cArr, i, i2));
            }
        }
    }

    private void appendToTextContainer(String str) throws SVGParseException {
        SVG.SvgObject svgObject;
        SVG.SvgConditionalContainer svgConditionalContainer = (SVG.SvgConditionalContainer) this.currentElement;
        int size = svgConditionalContainer.children.size();
        if (size == 0) {
            svgObject = null;
        } else {
            svgObject = svgConditionalContainer.children.get(size - 1);
        }
        if (svgObject instanceof SVG.TextSequence) {
            SVG.TextSequence textSequence = (SVG.TextSequence) svgObject;
            textSequence.text += str;
            return;
        }
        this.currentElement.addChild(new SVG.TextSequence(str));
    }

    /* access modifiers changed from: private */
    public void endElement(String str, String str2, String str3) throws SVGParseException {
        if (this.ignoring) {
            int i = this.ignoreDepth - 1;
            this.ignoreDepth = i;
            if (i == 0) {
                this.ignoring = false;
                return;
            }
        }
        if (SVG_NAMESPACE.equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            int i2 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.fromString(str2).ordinal()];
            if (!(i2 == 1 || i2 == 2 || i2 == 4 || i2 == 5 || i2 == 13 || i2 == 14)) {
                switch (i2) {
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 31:
                        break;
                    case 22:
                    case 23:
                        this.inMetadataElement = false;
                        if (this.metadataElementContents != null) {
                            if (this.metadataTag == SVGElem.title) {
                                this.svgDocument.setTitle(this.metadataElementContents.toString());
                            } else if (this.metadataTag == SVGElem.desc) {
                                this.svgDocument.setDesc(this.metadataElementContents.toString());
                            }
                            this.metadataElementContents.setLength(0);
                            return;
                        }
                        return;
                    case 30:
                        StringBuilder sb = this.styleElementContents;
                        if (sb != null) {
                            this.inStyleElement = false;
                            parseCSSStyleSheet(sb.toString());
                            this.styleElementContents.setLength(0);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            this.currentElement = ((SVG.SvgObject) this.currentElement).parent;
        }
    }

    /* access modifiers changed from: private */
    public void handleProcessingInstruction(String str, Map<String, String> map) {
        String str2;
        String resolveCSSStyleSheet;
        if (str.equals(XML_STYLESHEET_PROCESSING_INSTRUCTION) && SVG.getFileResolver() != null) {
            if (map.get("type") != null && !"text/css".equals(map.get("type"))) {
                return;
            }
            if ((map.get(XML_STYLESHEET_ATTR_ALTERNATE) == null || XML_STYLESHEET_ATTR_ALTERNATE_NO.equals(map.get(XML_STYLESHEET_ATTR_ALTERNATE))) && (str2 = map.get("href")) != null && (resolveCSSStyleSheet = SVG.getFileResolver().resolveCSSStyleSheet(str2)) != null) {
                String str3 = map.get("media");
                if (str3 != null && !"all".equals(str3.trim())) {
                    resolveCSSStyleSheet = "@media " + str3 + " { " + resolveCSSStyleSheet + "}";
                }
                parseCSSStyleSheet(resolveCSSStyleSheet);
            }
        }
    }

    /* access modifiers changed from: private */
    public Map<String, String> parseProcessingInstructionAttributes(TextScanner textScanner) {
        HashMap hashMap = new HashMap();
        textScanner.skipWhitespace();
        String nextToken = textScanner.nextToken('=');
        while (nextToken != null) {
            textScanner.consume('=');
            hashMap.put(nextToken, textScanner.nextQuotedString());
            textScanner.skipWhitespace();
            nextToken = textScanner.nextToken('=');
        }
        return hashMap;
    }

    private void dumpNode(SVG.SvgObject svgObject, String str) {
        Log.d(TAG, str + svgObject);
        if (svgObject instanceof SVG.SvgConditionalContainer) {
            String str2 = str + "  ";
            for (SVG.SvgObject dumpNode : ((SVG.SvgConditionalContainer) svgObject).children) {
                dumpNode(dumpNode, str2);
            }
        }
    }

    private void svg(Attributes attributes) throws SVGParseException {
        debug("<svg>", new Object[0]);
        SVG.Svg svg = new SVG.Svg();
        svg.document = this.svgDocument;
        svg.parent = this.currentElement;
        parseAttributesCore(svg, attributes);
        parseAttributesStyle(svg, attributes);
        parseAttributesConditional(svg, attributes);
        parseAttributesViewBox(svg, attributes);
        parseAttributesSVG(svg, attributes);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            this.svgDocument.setRootElement(svg);
        } else {
            svgContainer.addChild(svg);
        }
        this.currentElement = svg;
    }

    private void parseAttributesSVG(SVG.Svg svg, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                svg.x = parseLength(trim);
            } else if (i2 == 2) {
                svg.y = parseLength(trim);
            } else if (i2 == 3) {
                svg.width = parseLength(trim);
                if (svg.width.isNegative()) {
                    throw new SVGParseException("Invalid <svg> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                svg.height = parseLength(trim);
                if (svg.height.isNegative()) {
                    throw new SVGParseException("Invalid <svg> element. height cannot be negative");
                }
            } else if (i2 == 5) {
                svg.version = trim;
            }
        }
    }

    /* renamed from: com.caverock.androidsvg.SVGParser$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem;

        /* JADX WARNING: Can't wrap try/catch for region: R(240:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|(2:77|78)|79|(2:81|82)|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|(3:283|284|286)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(241:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|(2:77|78)|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|(3:283|284|286)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(242:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|(3:283|284|286)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(243:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|(3:283|284|286)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(244:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|(3:283|284|286)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(245:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|(3:283|284|286)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(246:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|(3:283|284|286)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(247:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|(3:283|284|286)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(248:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|(3:283|284|286)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(249:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|(3:283|284|286)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(250:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|(3:283|284|286)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(251:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|(3:283|284|286)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(253:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|283|284|286) */
        /* JADX WARNING: Can't wrap try/catch for region: R(254:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|283|284|286) */
        /* JADX WARNING: Can't wrap try/catch for region: R(255:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|283|284|286) */
        /* JADX WARNING: Can't wrap try/catch for region: R(256:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|283|284|286) */
        /* JADX WARNING: Can't wrap try/catch for region: R(257:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|283|284|286) */
        /* JADX WARNING: Can't wrap try/catch for region: R(258:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|283|284|286) */
        /* JADX WARNING: Can't wrap try/catch for region: R(259:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|283|284|286) */
        /* JADX WARNING: Can't wrap try/catch for region: R(260:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|(2:219|220)|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|283|284|286) */
        /* JADX WARNING: Can't wrap try/catch for region: R(261:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|219|220|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|283|284|286) */
        /* JADX WARNING: Can't wrap try/catch for region: R(262:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|219|220|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|283|284|286) */
        /* JADX WARNING: Can't wrap try/catch for region: R(263:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|219|220|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|283|284|286) */
        /* JADX WARNING: Can't wrap try/catch for region: R(264:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|213|214|215|216|217|218|219|220|221|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|248|249|250|251|252|253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|277|278|279|280|281|282|283|284|286) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x015c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:103:0x0168 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:105:0x0174 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x0180 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:109:0x018c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:111:0x0198 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:113:0x01a4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:115:0x01b0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:117:0x01bc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:119:0x01c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:121:0x01d4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:123:0x01e0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:125:0x01ec */
        /* JADX WARNING: Missing exception handler attribute for start block: B:127:0x01f8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:129:0x0204 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:131:0x0210 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:133:0x021c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:135:0x0228 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:137:0x0234 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:139:0x0240 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:141:0x024c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:143:0x0258 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:145:0x0264 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:147:0x0270 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:149:0x027c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:151:0x0288 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:153:0x0294 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:155:0x02a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:157:0x02ac */
        /* JADX WARNING: Missing exception handler attribute for start block: B:159:0x02b8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:161:0x02c4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:163:0x02d0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:165:0x02dc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:167:0x02e8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:169:0x02f4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:171:0x0300 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:173:0x030c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:175:0x0318 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:177:0x0324 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:179:0x0330 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:181:0x033c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:183:0x0348 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:185:0x0354 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:187:0x0360 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:189:0x036c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:191:0x0378 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:193:0x0384 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:195:0x0390 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:197:0x039c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:199:0x03a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:201:0x03b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:203:0x03c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:205:0x03cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:207:0x03d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:209:0x03e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:211:0x03f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:213:0x03fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:215:0x0408 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:217:0x0414 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:219:0x0420 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:225:0x043d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:227:0x0447 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:229:0x0451 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:231:0x045b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:233:0x0465 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:235:0x046f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:237:0x0479 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:239:0x0483 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:241:0x048d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:243:0x0497 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:245:0x04a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:247:0x04ab */
        /* JADX WARNING: Missing exception handler attribute for start block: B:249:0x04b5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:251:0x04bf */
        /* JADX WARNING: Missing exception handler attribute for start block: B:253:0x04c9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:255:0x04d5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:257:0x04df */
        /* JADX WARNING: Missing exception handler attribute for start block: B:259:0x04e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:261:0x04f3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:263:0x04fd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:265:0x0507 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:267:0x0511 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:269:0x051d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:271:0x0529 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:273:0x0535 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:275:0x0541 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:277:0x054d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:279:0x0559 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:281:0x0565 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:283:0x0571 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x0138 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x0144 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:99:0x0150 */
        static {
            /*
                com.caverock.androidsvg.SVGParser$SVGAttr[] r0 = com.caverock.androidsvg.SVGParser.SVGAttr.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr = r0
                r1 = 1
                com.caverock.androidsvg.SVGParser$SVGAttr r2 = com.caverock.androidsvg.SVGParser.SVGAttr.x     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x001d }
                com.caverock.androidsvg.SVGParser$SVGAttr r3 = com.caverock.androidsvg.SVGParser.SVGAttr.y     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.caverock.androidsvg.SVGParser$SVGAttr r4 = com.caverock.androidsvg.SVGParser.SVGAttr.width     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.caverock.androidsvg.SVGParser$SVGAttr r5 = com.caverock.androidsvg.SVGParser.SVGAttr.height     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x003e }
                com.caverock.androidsvg.SVGParser$SVGAttr r6 = com.caverock.androidsvg.SVGParser.SVGAttr.version     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.caverock.androidsvg.SVGParser$SVGAttr r7 = com.caverock.androidsvg.SVGParser.SVGAttr.href     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.caverock.androidsvg.SVGParser$SVGAttr r8 = com.caverock.androidsvg.SVGParser.SVGAttr.preserveAspectRatio     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.caverock.androidsvg.SVGParser$SVGAttr r9 = com.caverock.androidsvg.SVGParser.SVGAttr.d     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r8 = 9
                int[] r9 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x006c }
                com.caverock.androidsvg.SVGParser$SVGAttr r10 = com.caverock.androidsvg.SVGParser.SVGAttr.pathLength     // Catch:{ NoSuchFieldError -> 0x006c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                r9 = 10
                int[] r10 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.caverock.androidsvg.SVGParser$SVGAttr r11 = com.caverock.androidsvg.SVGParser.SVGAttr.rx     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r10[r11] = r9     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                r10 = 11
                int[] r11 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.caverock.androidsvg.SVGParser$SVGAttr r12 = com.caverock.androidsvg.SVGParser.SVGAttr.ry     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r11[r12] = r10     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                r11 = 12
                int[] r12 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.caverock.androidsvg.SVGParser$SVGAttr r13 = com.caverock.androidsvg.SVGParser.SVGAttr.cx     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r13 = r13.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r12[r13] = r11     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                r12 = 13
                int[] r13 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x009c }
                com.caverock.androidsvg.SVGParser$SVGAttr r14 = com.caverock.androidsvg.SVGParser.SVGAttr.cy     // Catch:{ NoSuchFieldError -> 0x009c }
                int r14 = r14.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r13[r14] = r12     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                r13 = 14
                int[] r14 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.caverock.androidsvg.SVGParser$SVGAttr r15 = com.caverock.androidsvg.SVGParser.SVGAttr.r     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r15 = r15.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r14[r15] = r13     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                r14 = 15
                int[] r15 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.caverock.androidsvg.SVGParser$SVGAttr r16 = com.caverock.androidsvg.SVGParser.SVGAttr.x1     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r15[r16] = r14     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                r15 = 16
                int[] r16 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.caverock.androidsvg.SVGParser$SVGAttr r17 = com.caverock.androidsvg.SVGParser.SVGAttr.y1     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r17 = r17.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r16[r17] = r15     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                r16 = 17
                int[] r17 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.caverock.androidsvg.SVGParser$SVGAttr r18 = com.caverock.androidsvg.SVGParser.SVGAttr.x2     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r18 = r18.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r17[r18] = r16     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                r17 = 18
                int[] r18 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.caverock.androidsvg.SVGParser$SVGAttr r19 = com.caverock.androidsvg.SVGParser.SVGAttr.y2     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r19 = r19.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r18[r19] = r17     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                r18 = 19
                int[] r19 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.caverock.androidsvg.SVGParser$SVGAttr r20 = com.caverock.androidsvg.SVGParser.SVGAttr.dx     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r20 = r20.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r19[r20] = r18     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                r19 = 20
                int[] r20 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.caverock.androidsvg.SVGParser$SVGAttr r21 = com.caverock.androidsvg.SVGParser.SVGAttr.dy     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r21 = r21.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r20[r21] = r19     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                r20 = 21
                int[] r21 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.caverock.androidsvg.SVGParser$SVGAttr r22 = com.caverock.androidsvg.SVGParser.SVGAttr.requiredFeatures     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r22 = r22.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r21[r22] = r20     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                r21 = 22
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.requiredExtensions     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r22[r23] = r21     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.systemLanguage     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r24 = 23
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.requiredFormats     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r24 = 24
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x012c }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.requiredFonts     // Catch:{ NoSuchFieldError -> 0x012c }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r24 = 25
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0138 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.refX     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r24 = 26
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0144 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.refY     // Catch:{ NoSuchFieldError -> 0x0144 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0144 }
                r24 = 27
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0144 }
            L_0x0144:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0150 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.markerWidth     // Catch:{ NoSuchFieldError -> 0x0150 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0150 }
                r24 = 28
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0150 }
            L_0x0150:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x015c }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.markerHeight     // Catch:{ NoSuchFieldError -> 0x015c }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x015c }
                r24 = 29
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x015c }
            L_0x015c:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0168 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.markerUnits     // Catch:{ NoSuchFieldError -> 0x0168 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0168 }
                r24 = 30
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0168 }
            L_0x0168:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0174 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.orient     // Catch:{ NoSuchFieldError -> 0x0174 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0174 }
                r24 = 31
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0174 }
            L_0x0174:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0180 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.gradientUnits     // Catch:{ NoSuchFieldError -> 0x0180 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0180 }
                r24 = 32
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0180 }
            L_0x0180:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x018c }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.gradientTransform     // Catch:{ NoSuchFieldError -> 0x018c }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x018c }
                r24 = 33
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x018c }
            L_0x018c:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0198 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.spreadMethod     // Catch:{ NoSuchFieldError -> 0x0198 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0198 }
                r24 = 34
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0198 }
            L_0x0198:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x01a4 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.fx     // Catch:{ NoSuchFieldError -> 0x01a4 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x01a4 }
                r24 = 35
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x01a4 }
            L_0x01a4:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x01b0 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.fy     // Catch:{ NoSuchFieldError -> 0x01b0 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x01b0 }
                r24 = 36
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x01b0 }
            L_0x01b0:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x01bc }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.offset     // Catch:{ NoSuchFieldError -> 0x01bc }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x01bc }
                r24 = 37
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x01bc }
            L_0x01bc:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x01c8 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.clipPathUnits     // Catch:{ NoSuchFieldError -> 0x01c8 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x01c8 }
                r24 = 38
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x01c8 }
            L_0x01c8:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x01d4 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.startOffset     // Catch:{ NoSuchFieldError -> 0x01d4 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x01d4 }
                r24 = 39
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x01d4 }
            L_0x01d4:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x01e0 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.patternUnits     // Catch:{ NoSuchFieldError -> 0x01e0 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x01e0 }
                r24 = 40
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x01e0 }
            L_0x01e0:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x01ec }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.patternContentUnits     // Catch:{ NoSuchFieldError -> 0x01ec }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x01ec }
                r24 = 41
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x01ec }
            L_0x01ec:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x01f8 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.patternTransform     // Catch:{ NoSuchFieldError -> 0x01f8 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x01f8 }
                r24 = 42
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x01f8 }
            L_0x01f8:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0204 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.maskUnits     // Catch:{ NoSuchFieldError -> 0x0204 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0204 }
                r24 = 43
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0204 }
            L_0x0204:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0210 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.maskContentUnits     // Catch:{ NoSuchFieldError -> 0x0210 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0210 }
                r24 = 44
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0210 }
            L_0x0210:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x021c }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.style     // Catch:{ NoSuchFieldError -> 0x021c }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x021c }
                r24 = 45
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x021c }
            L_0x021c:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0228 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.CLASS     // Catch:{ NoSuchFieldError -> 0x0228 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0228 }
                r24 = 46
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0228 }
            L_0x0228:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0234 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.fill     // Catch:{ NoSuchFieldError -> 0x0234 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0234 }
                r24 = 47
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0234 }
            L_0x0234:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0240 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.fill_rule     // Catch:{ NoSuchFieldError -> 0x0240 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0240 }
                r24 = 48
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0240 }
            L_0x0240:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x024c }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.fill_opacity     // Catch:{ NoSuchFieldError -> 0x024c }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x024c }
                r24 = 49
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x024c }
            L_0x024c:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0258 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.stroke     // Catch:{ NoSuchFieldError -> 0x0258 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0258 }
                r24 = 50
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0258 }
            L_0x0258:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0264 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.stroke_opacity     // Catch:{ NoSuchFieldError -> 0x0264 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0264 }
                r24 = 51
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0264 }
            L_0x0264:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0270 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.stroke_width     // Catch:{ NoSuchFieldError -> 0x0270 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0270 }
                r24 = 52
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0270 }
            L_0x0270:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x027c }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.stroke_linecap     // Catch:{ NoSuchFieldError -> 0x027c }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x027c }
                r24 = 53
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x027c }
            L_0x027c:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0288 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.stroke_linejoin     // Catch:{ NoSuchFieldError -> 0x0288 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0288 }
                r24 = 54
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0288 }
            L_0x0288:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0294 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.stroke_miterlimit     // Catch:{ NoSuchFieldError -> 0x0294 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0294 }
                r24 = 55
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0294 }
            L_0x0294:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x02a0 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.stroke_dasharray     // Catch:{ NoSuchFieldError -> 0x02a0 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x02a0 }
                r24 = 56
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x02a0 }
            L_0x02a0:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x02ac }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.stroke_dashoffset     // Catch:{ NoSuchFieldError -> 0x02ac }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x02ac }
                r24 = 57
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x02ac }
            L_0x02ac:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x02b8 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.opacity     // Catch:{ NoSuchFieldError -> 0x02b8 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x02b8 }
                r24 = 58
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x02b8 }
            L_0x02b8:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x02c4 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.color     // Catch:{ NoSuchFieldError -> 0x02c4 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x02c4 }
                r24 = 59
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x02c4 }
            L_0x02c4:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x02d0 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.font     // Catch:{ NoSuchFieldError -> 0x02d0 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x02d0 }
                r24 = 60
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x02d0 }
            L_0x02d0:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x02dc }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.font_family     // Catch:{ NoSuchFieldError -> 0x02dc }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x02dc }
                r24 = 61
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x02dc }
            L_0x02dc:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x02e8 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.font_size     // Catch:{ NoSuchFieldError -> 0x02e8 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x02e8 }
                r24 = 62
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x02e8 }
            L_0x02e8:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x02f4 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.font_weight     // Catch:{ NoSuchFieldError -> 0x02f4 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x02f4 }
                r24 = 63
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x02f4 }
            L_0x02f4:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0300 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.font_style     // Catch:{ NoSuchFieldError -> 0x0300 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0300 }
                r24 = 64
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0300 }
            L_0x0300:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x030c }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.text_decoration     // Catch:{ NoSuchFieldError -> 0x030c }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x030c }
                r24 = 65
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x030c }
            L_0x030c:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0318 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.direction     // Catch:{ NoSuchFieldError -> 0x0318 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0318 }
                r24 = 66
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0318 }
            L_0x0318:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0324 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.text_anchor     // Catch:{ NoSuchFieldError -> 0x0324 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0324 }
                r24 = 67
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0324 }
            L_0x0324:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0330 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.overflow     // Catch:{ NoSuchFieldError -> 0x0330 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0330 }
                r24 = 68
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0330 }
            L_0x0330:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x033c }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.marker     // Catch:{ NoSuchFieldError -> 0x033c }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x033c }
                r24 = 69
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x033c }
            L_0x033c:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0348 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.marker_start     // Catch:{ NoSuchFieldError -> 0x0348 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0348 }
                r24 = 70
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0348 }
            L_0x0348:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0354 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.marker_mid     // Catch:{ NoSuchFieldError -> 0x0354 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0354 }
                r24 = 71
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0354 }
            L_0x0354:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0360 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.marker_end     // Catch:{ NoSuchFieldError -> 0x0360 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0360 }
                r24 = 72
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0360 }
            L_0x0360:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x036c }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.display     // Catch:{ NoSuchFieldError -> 0x036c }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x036c }
                r24 = 73
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x036c }
            L_0x036c:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0378 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.visibility     // Catch:{ NoSuchFieldError -> 0x0378 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0378 }
                r24 = 74
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0378 }
            L_0x0378:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0384 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.stop_color     // Catch:{ NoSuchFieldError -> 0x0384 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0384 }
                r24 = 75
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0384 }
            L_0x0384:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0390 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.stop_opacity     // Catch:{ NoSuchFieldError -> 0x0390 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0390 }
                r24 = 76
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0390 }
            L_0x0390:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x039c }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.clip     // Catch:{ NoSuchFieldError -> 0x039c }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x039c }
                r24 = 77
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x039c }
            L_0x039c:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x03a8 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.clip_path     // Catch:{ NoSuchFieldError -> 0x03a8 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x03a8 }
                r24 = 78
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x03a8 }
            L_0x03a8:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x03b4 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.clip_rule     // Catch:{ NoSuchFieldError -> 0x03b4 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x03b4 }
                r24 = 79
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x03b4 }
            L_0x03b4:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x03c0 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.mask     // Catch:{ NoSuchFieldError -> 0x03c0 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x03c0 }
                r24 = 80
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x03c0 }
            L_0x03c0:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x03cc }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.solid_color     // Catch:{ NoSuchFieldError -> 0x03cc }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x03cc }
                r24 = 81
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x03cc }
            L_0x03cc:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x03d8 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.solid_opacity     // Catch:{ NoSuchFieldError -> 0x03d8 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x03d8 }
                r24 = 82
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x03d8 }
            L_0x03d8:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x03e4 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.viewport_fill     // Catch:{ NoSuchFieldError -> 0x03e4 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x03e4 }
                r24 = 83
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x03e4 }
            L_0x03e4:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x03f0 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.viewport_fill_opacity     // Catch:{ NoSuchFieldError -> 0x03f0 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x03f0 }
                r24 = 84
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x03f0 }
            L_0x03f0:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x03fc }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.vector_effect     // Catch:{ NoSuchFieldError -> 0x03fc }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x03fc }
                r24 = 85
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x03fc }
            L_0x03fc:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0408 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.image_rendering     // Catch:{ NoSuchFieldError -> 0x0408 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0408 }
                r24 = 86
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0408 }
            L_0x0408:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0414 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.viewBox     // Catch:{ NoSuchFieldError -> 0x0414 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0414 }
                r24 = 87
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0414 }
            L_0x0414:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x0420 }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.type     // Catch:{ NoSuchFieldError -> 0x0420 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0420 }
                r24 = 88
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0420 }
            L_0x0420:
                int[] r22 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr     // Catch:{ NoSuchFieldError -> 0x042c }
                com.caverock.androidsvg.SVGParser$SVGAttr r23 = com.caverock.androidsvg.SVGParser.SVGAttr.media     // Catch:{ NoSuchFieldError -> 0x042c }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x042c }
                r24 = 89
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x042c }
            L_0x042c:
                com.caverock.androidsvg.SVGParser$SVGElem[] r15 = com.caverock.androidsvg.SVGParser.SVGElem.values()
                int r15 = r15.length
                int[] r15 = new int[r15]
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem = r15
                com.caverock.androidsvg.SVGParser$SVGElem r23 = com.caverock.androidsvg.SVGParser.SVGElem.svg     // Catch:{ NoSuchFieldError -> 0x043d }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x043d }
                r15[r23] = r1     // Catch:{ NoSuchFieldError -> 0x043d }
            L_0x043d:
                int[] r1 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x0447 }
                com.caverock.androidsvg.SVGParser$SVGElem r15 = com.caverock.androidsvg.SVGParser.SVGElem.g     // Catch:{ NoSuchFieldError -> 0x0447 }
                int r15 = r15.ordinal()     // Catch:{ NoSuchFieldError -> 0x0447 }
                r1[r15] = r0     // Catch:{ NoSuchFieldError -> 0x0447 }
            L_0x0447:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x0451 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.a     // Catch:{ NoSuchFieldError -> 0x0451 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0451 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0451 }
            L_0x0451:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x045b }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.defs     // Catch:{ NoSuchFieldError -> 0x045b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x045b }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x045b }
            L_0x045b:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x0465 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.use     // Catch:{ NoSuchFieldError -> 0x0465 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0465 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0465 }
            L_0x0465:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x046f }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.path     // Catch:{ NoSuchFieldError -> 0x046f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x046f }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x046f }
            L_0x046f:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x0479 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.rect     // Catch:{ NoSuchFieldError -> 0x0479 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0479 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0479 }
            L_0x0479:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x0483 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.circle     // Catch:{ NoSuchFieldError -> 0x0483 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0483 }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x0483 }
            L_0x0483:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x048d }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.ellipse     // Catch:{ NoSuchFieldError -> 0x048d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x048d }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x048d }
            L_0x048d:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x0497 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.line     // Catch:{ NoSuchFieldError -> 0x0497 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0497 }
                r0[r1] = r9     // Catch:{ NoSuchFieldError -> 0x0497 }
            L_0x0497:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x04a1 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.polyline     // Catch:{ NoSuchFieldError -> 0x04a1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x04a1 }
                r0[r1] = r10     // Catch:{ NoSuchFieldError -> 0x04a1 }
            L_0x04a1:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x04ab }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.polygon     // Catch:{ NoSuchFieldError -> 0x04ab }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x04ab }
                r0[r1] = r11     // Catch:{ NoSuchFieldError -> 0x04ab }
            L_0x04ab:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x04b5 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.text     // Catch:{ NoSuchFieldError -> 0x04b5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x04b5 }
                r0[r1] = r12     // Catch:{ NoSuchFieldError -> 0x04b5 }
            L_0x04b5:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x04bf }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.tspan     // Catch:{ NoSuchFieldError -> 0x04bf }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x04bf }
                r0[r1] = r13     // Catch:{ NoSuchFieldError -> 0x04bf }
            L_0x04bf:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x04c9 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.tref     // Catch:{ NoSuchFieldError -> 0x04c9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x04c9 }
                r0[r1] = r14     // Catch:{ NoSuchFieldError -> 0x04c9 }
            L_0x04c9:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x04d5 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.SWITCH     // Catch:{ NoSuchFieldError -> 0x04d5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x04d5 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x04d5 }
            L_0x04d5:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x04df }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.symbol     // Catch:{ NoSuchFieldError -> 0x04df }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x04df }
                r0[r1] = r16     // Catch:{ NoSuchFieldError -> 0x04df }
            L_0x04df:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x04e9 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.marker     // Catch:{ NoSuchFieldError -> 0x04e9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x04e9 }
                r0[r1] = r17     // Catch:{ NoSuchFieldError -> 0x04e9 }
            L_0x04e9:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x04f3 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.linearGradient     // Catch:{ NoSuchFieldError -> 0x04f3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x04f3 }
                r0[r1] = r18     // Catch:{ NoSuchFieldError -> 0x04f3 }
            L_0x04f3:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x04fd }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.radialGradient     // Catch:{ NoSuchFieldError -> 0x04fd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x04fd }
                r0[r1] = r19     // Catch:{ NoSuchFieldError -> 0x04fd }
            L_0x04fd:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x0507 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.stop     // Catch:{ NoSuchFieldError -> 0x0507 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0507 }
                r0[r1] = r20     // Catch:{ NoSuchFieldError -> 0x0507 }
            L_0x0507:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x0511 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.title     // Catch:{ NoSuchFieldError -> 0x0511 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0511 }
                r0[r1] = r21     // Catch:{ NoSuchFieldError -> 0x0511 }
            L_0x0511:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x051d }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.desc     // Catch:{ NoSuchFieldError -> 0x051d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x051d }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x051d }
            L_0x051d:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x0529 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.clipPath     // Catch:{ NoSuchFieldError -> 0x0529 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0529 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0529 }
            L_0x0529:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x0535 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.textPath     // Catch:{ NoSuchFieldError -> 0x0535 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0535 }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0535 }
            L_0x0535:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x0541 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.pattern     // Catch:{ NoSuchFieldError -> 0x0541 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0541 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0541 }
            L_0x0541:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x054d }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.image     // Catch:{ NoSuchFieldError -> 0x054d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x054d }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x054d }
            L_0x054d:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x0559 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.view     // Catch:{ NoSuchFieldError -> 0x0559 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0559 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0559 }
            L_0x0559:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x0565 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.mask     // Catch:{ NoSuchFieldError -> 0x0565 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0565 }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0565 }
            L_0x0565:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x0571 }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.style     // Catch:{ NoSuchFieldError -> 0x0571 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0571 }
                r2 = 30
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0571 }
            L_0x0571:
                int[] r0 = $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem     // Catch:{ NoSuchFieldError -> 0x057d }
                com.caverock.androidsvg.SVGParser$SVGElem r1 = com.caverock.androidsvg.SVGParser.SVGElem.solidColor     // Catch:{ NoSuchFieldError -> 0x057d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x057d }
                r2 = 31
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x057d }
            L_0x057d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.AnonymousClass1.<clinit>():void");
        }
    }

    private void g(Attributes attributes) throws SVGParseException {
        debug("<g>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Group group = new SVG.Group();
            group.document = this.svgDocument;
            group.parent = this.currentElement;
            parseAttributesCore(group, attributes);
            parseAttributesStyle(group, attributes);
            parseAttributesTransform(group, attributes);
            parseAttributesConditional(group, attributes);
            this.currentElement.addChild(group);
            this.currentElement = group;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void defs(Attributes attributes) throws SVGParseException {
        debug("<defs>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Defs defs = new SVG.Defs();
            defs.document = this.svgDocument;
            defs.parent = this.currentElement;
            parseAttributesCore(defs, attributes);
            parseAttributesStyle(defs, attributes);
            parseAttributesTransform(defs, attributes);
            this.currentElement.addChild(defs);
            this.currentElement = defs;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void use(Attributes attributes) throws SVGParseException {
        debug("<use>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Use use = new SVG.Use();
            use.document = this.svgDocument;
            use.parent = this.currentElement;
            parseAttributesCore(use, attributes);
            parseAttributesStyle(use, attributes);
            parseAttributesTransform(use, attributes);
            parseAttributesConditional(use, attributes);
            parseAttributesUse(use, attributes);
            this.currentElement.addChild(use);
            this.currentElement = use;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void parseAttributesUse(SVG.Use use, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                use.x = parseLength(trim);
            } else if (i2 == 2) {
                use.y = parseLength(trim);
            } else if (i2 == 3) {
                use.width = parseLength(trim);
                if (use.width.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                use.height = parseLength(trim);
                if (use.height.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                }
            } else if (i2 == 6 && ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i)))) {
                use.href = trim;
            }
        }
    }

    private void image(Attributes attributes) throws SVGParseException {
        debug("<image>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Image image = new SVG.Image();
            image.document = this.svgDocument;
            image.parent = this.currentElement;
            parseAttributesCore(image, attributes);
            parseAttributesStyle(image, attributes);
            parseAttributesTransform(image, attributes);
            parseAttributesConditional(image, attributes);
            parseAttributesImage(image, attributes);
            this.currentElement.addChild(image);
            this.currentElement = image;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void parseAttributesImage(SVG.Image image, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                image.x = parseLength(trim);
            } else if (i2 == 2) {
                image.y = parseLength(trim);
            } else if (i2 == 3) {
                image.width = parseLength(trim);
                if (image.width.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                image.height = parseLength(trim);
                if (image.height.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                }
            } else if (i2 != 6) {
                if (i2 == 7) {
                    parsePreserveAspectRatio(image, trim);
                }
            } else if ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                image.href = trim;
            }
        }
    }

    private void path(Attributes attributes) throws SVGParseException {
        debug("<path>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Path path = new SVG.Path();
            path.document = this.svgDocument;
            path.parent = this.currentElement;
            parseAttributesCore(path, attributes);
            parseAttributesStyle(path, attributes);
            parseAttributesTransform(path, attributes);
            parseAttributesConditional(path, attributes);
            parseAttributesPath(path, attributes);
            this.currentElement.addChild(path);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void parseAttributesPath(SVG.Path path, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 8) {
                path.d = parsePath(trim);
            } else if (i2 != 9) {
                continue;
            } else {
                path.pathLength = Float.valueOf(parseFloat(trim));
                if (path.pathLength.floatValue() < 0.0f) {
                    throw new SVGParseException("Invalid <path> element. pathLength cannot be negative");
                }
            }
        }
    }

    private void rect(Attributes attributes) throws SVGParseException {
        debug("<rect>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Rect rect = new SVG.Rect();
            rect.document = this.svgDocument;
            rect.parent = this.currentElement;
            parseAttributesCore(rect, attributes);
            parseAttributesStyle(rect, attributes);
            parseAttributesTransform(rect, attributes);
            parseAttributesConditional(rect, attributes);
            parseAttributesRect(rect, attributes);
            this.currentElement.addChild(rect);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void parseAttributesRect(SVG.Rect rect, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                rect.x = parseLength(trim);
            } else if (i2 == 2) {
                rect.y = parseLength(trim);
            } else if (i2 == 3) {
                rect.width = parseLength(trim);
                if (rect.width.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                rect.height = parseLength(trim);
                if (rect.height.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. height cannot be negative");
                }
            } else if (i2 == 10) {
                rect.rx = parseLength(trim);
                if (rect.rx.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. rx cannot be negative");
                }
            } else if (i2 != 11) {
                continue;
            } else {
                rect.ry = parseLength(trim);
                if (rect.ry.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. ry cannot be negative");
                }
            }
        }
    }

    private void circle(Attributes attributes) throws SVGParseException {
        debug("<circle>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Circle circle = new SVG.Circle();
            circle.document = this.svgDocument;
            circle.parent = this.currentElement;
            parseAttributesCore(circle, attributes);
            parseAttributesStyle(circle, attributes);
            parseAttributesTransform(circle, attributes);
            parseAttributesConditional(circle, attributes);
            parseAttributesCircle(circle, attributes);
            this.currentElement.addChild(circle);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void parseAttributesCircle(SVG.Circle circle, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case cx:
                    circle.cx = parseLength(trim);
                    break;
                case cy:
                    circle.cy = parseLength(trim);
                    break;
                case r:
                    circle.r = parseLength(trim);
                    if (!circle.r.isNegative()) {
                        break;
                    } else {
                        throw new SVGParseException("Invalid <circle> element. r cannot be negative");
                    }
            }
        }
    }

    private void ellipse(Attributes attributes) throws SVGParseException {
        debug("<ellipse>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Ellipse ellipse = new SVG.Ellipse();
            ellipse.document = this.svgDocument;
            ellipse.parent = this.currentElement;
            parseAttributesCore(ellipse, attributes);
            parseAttributesStyle(ellipse, attributes);
            parseAttributesTransform(ellipse, attributes);
            parseAttributesConditional(ellipse, attributes);
            parseAttributesEllipse(ellipse, attributes);
            this.currentElement.addChild(ellipse);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void parseAttributesEllipse(SVG.Ellipse ellipse, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case rx:
                    ellipse.rx = parseLength(trim);
                    if (!ellipse.rx.isNegative()) {
                        break;
                    } else {
                        throw new SVGParseException("Invalid <ellipse> element. rx cannot be negative");
                    }
                case ry:
                    ellipse.ry = parseLength(trim);
                    if (!ellipse.ry.isNegative()) {
                        break;
                    } else {
                        throw new SVGParseException("Invalid <ellipse> element. ry cannot be negative");
                    }
                case cx:
                    ellipse.cx = parseLength(trim);
                    break;
                case cy:
                    ellipse.cy = parseLength(trim);
                    break;
            }
        }
    }

    private void line(Attributes attributes) throws SVGParseException {
        debug("<line>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Line line = new SVG.Line();
            line.document = this.svgDocument;
            line.parent = this.currentElement;
            parseAttributesCore(line, attributes);
            parseAttributesStyle(line, attributes);
            parseAttributesTransform(line, attributes);
            parseAttributesConditional(line, attributes);
            parseAttributesLine(line, attributes);
            this.currentElement.addChild(line);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void parseAttributesLine(SVG.Line line, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x1:
                    line.x1 = parseLength(trim);
                    break;
                case y1:
                    line.y1 = parseLength(trim);
                    break;
                case x2:
                    line.x2 = parseLength(trim);
                    break;
                case y2:
                    line.y2 = parseLength(trim);
                    break;
            }
        }
    }

    private void polyline(Attributes attributes) throws SVGParseException {
        debug("<polyline>", new Object[0]);
        if (this.currentElement != null) {
            SVG.PolyLine polyLine = new SVG.PolyLine();
            polyLine.document = this.svgDocument;
            polyLine.parent = this.currentElement;
            parseAttributesCore(polyLine, attributes);
            parseAttributesStyle(polyLine, attributes);
            parseAttributesTransform(polyLine, attributes);
            parseAttributesConditional(polyLine, attributes);
            parseAttributesPolyLine(polyLine, attributes, "polyline");
            this.currentElement.addChild(polyLine);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void parseAttributesPolyLine(SVG.PolyLine polyLine, Attributes attributes, String str) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.points) {
                TextScanner textScanner = new TextScanner(attributes.getValue(i));
                ArrayList<Float> arrayList = new ArrayList<>();
                textScanner.skipWhitespace();
                while (!textScanner.empty()) {
                    float nextFloat = textScanner.nextFloat();
                    if (!Float.isNaN(nextFloat)) {
                        textScanner.skipCommaWhitespace();
                        float nextFloat2 = textScanner.nextFloat();
                        if (!Float.isNaN(nextFloat2)) {
                            textScanner.skipCommaWhitespace();
                            arrayList.add(Float.valueOf(nextFloat));
                            arrayList.add(Float.valueOf(nextFloat2));
                        } else {
                            throw new SVGParseException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                        }
                    } else {
                        throw new SVGParseException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                }
                polyLine.points = new float[arrayList.size()];
                int i2 = 0;
                for (Float floatValue : arrayList) {
                    polyLine.points[i2] = floatValue.floatValue();
                    i2++;
                }
            }
        }
    }

    private void polygon(Attributes attributes) throws SVGParseException {
        debug("<polygon>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Polygon polygon = new SVG.Polygon();
            polygon.document = this.svgDocument;
            polygon.parent = this.currentElement;
            parseAttributesCore(polygon, attributes);
            parseAttributesStyle(polygon, attributes);
            parseAttributesTransform(polygon, attributes);
            parseAttributesConditional(polygon, attributes);
            parseAttributesPolyLine(polygon, attributes, "polygon");
            this.currentElement.addChild(polygon);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void text(Attributes attributes) throws SVGParseException {
        debug("<text>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Text text = new SVG.Text();
            text.document = this.svgDocument;
            text.parent = this.currentElement;
            parseAttributesCore(text, attributes);
            parseAttributesStyle(text, attributes);
            parseAttributesTransform(text, attributes);
            parseAttributesConditional(text, attributes);
            parseAttributesTextPosition(text, attributes);
            this.currentElement.addChild(text);
            this.currentElement = text;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void parseAttributesTextPosition(SVG.TextPositionedContainer textPositionedContainer, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                textPositionedContainer.x = parseLengthList(trim);
            } else if (i2 == 2) {
                textPositionedContainer.y = parseLengthList(trim);
            } else if (i2 == 19) {
                textPositionedContainer.dx = parseLengthList(trim);
            } else if (i2 == 20) {
                textPositionedContainer.dy = parseLengthList(trim);
            }
        }
    }

    private void tspan(Attributes attributes) throws SVGParseException {
        debug("<tspan>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        } else if (svgContainer instanceof SVG.TextContainer) {
            SVG.TSpan tSpan = new SVG.TSpan();
            tSpan.document = this.svgDocument;
            tSpan.parent = this.currentElement;
            parseAttributesCore(tSpan, attributes);
            parseAttributesStyle(tSpan, attributes);
            parseAttributesConditional(tSpan, attributes);
            parseAttributesTextPosition(tSpan, attributes);
            this.currentElement.addChild(tSpan);
            this.currentElement = tSpan;
            if (tSpan.parent instanceof SVG.TextRoot) {
                tSpan.setTextRoot((SVG.TextRoot) tSpan.parent);
            } else {
                tSpan.setTextRoot(((SVG.TextChild) tSpan.parent).getTextRoot());
            }
        } else {
            throw new SVGParseException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
    }

    private void tref(Attributes attributes) throws SVGParseException {
        debug("<tref>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        } else if (svgContainer instanceof SVG.TextContainer) {
            SVG.TRef tRef = new SVG.TRef();
            tRef.document = this.svgDocument;
            tRef.parent = this.currentElement;
            parseAttributesCore(tRef, attributes);
            parseAttributesStyle(tRef, attributes);
            parseAttributesConditional(tRef, attributes);
            parseAttributesTRef(tRef, attributes);
            this.currentElement.addChild(tRef);
            if (tRef.parent instanceof SVG.TextRoot) {
                tRef.setTextRoot((SVG.TextRoot) tRef.parent);
            } else {
                tRef.setTextRoot(((SVG.TextChild) tRef.parent).getTextRoot());
            }
        } else {
            throw new SVGParseException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
    }

    private void parseAttributesTRef(SVG.TRef tRef, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 6 && ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i)))) {
                tRef.href = trim;
            }
        }
    }

    private void zwitch(Attributes attributes) throws SVGParseException {
        debug("<switch>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Switch switchR = new SVG.Switch();
            switchR.document = this.svgDocument;
            switchR.parent = this.currentElement;
            parseAttributesCore(switchR, attributes);
            parseAttributesStyle(switchR, attributes);
            parseAttributesTransform(switchR, attributes);
            parseAttributesConditional(switchR, attributes);
            this.currentElement.addChild(switchR);
            this.currentElement = switchR;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void parseAttributesConditional(SVG.SvgConditional svgConditional, Attributes attributes) throws SVGParseException {
        HashSet hashSet;
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case requiredFeatures:
                    svgConditional.setRequiredFeatures(parseRequiredFeatures(trim));
                    break;
                case requiredExtensions:
                    svgConditional.setRequiredExtensions(trim);
                    break;
                case systemLanguage:
                    svgConditional.setSystemLanguage(parseSystemLanguage(trim));
                    break;
                case requiredFormats:
                    svgConditional.setRequiredFormats(parseRequiredFormats(trim));
                    break;
                case requiredFonts:
                    List<String> parseFontFamily = parseFontFamily(trim);
                    if (parseFontFamily == null) {
                        hashSet = new HashSet(0);
                    }
                    svgConditional.setRequiredFonts(hashSet);
                    break;
            }
        }
    }

    private void symbol(Attributes attributes) throws SVGParseException {
        debug("<symbol>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Symbol symbol = new SVG.Symbol();
            symbol.document = this.svgDocument;
            symbol.parent = this.currentElement;
            parseAttributesCore(symbol, attributes);
            parseAttributesStyle(symbol, attributes);
            parseAttributesConditional(symbol, attributes);
            parseAttributesViewBox(symbol, attributes);
            this.currentElement.addChild(symbol);
            this.currentElement = symbol;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void marker(Attributes attributes) throws SVGParseException {
        debug("<marker>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Marker marker = new SVG.Marker();
            marker.document = this.svgDocument;
            marker.parent = this.currentElement;
            parseAttributesCore(marker, attributes);
            parseAttributesStyle(marker, attributes);
            parseAttributesConditional(marker, attributes);
            parseAttributesViewBox(marker, attributes);
            parseAttributesMarker(marker, attributes);
            this.currentElement.addChild(marker);
            this.currentElement = marker;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void parseAttributesMarker(SVG.Marker marker, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case refX:
                    marker.refX = parseLength(trim);
                    break;
                case refY:
                    marker.refY = parseLength(trim);
                    break;
                case markerWidth:
                    marker.markerWidth = parseLength(trim);
                    if (!marker.markerWidth.isNegative()) {
                        break;
                    } else {
                        throw new SVGParseException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                case markerHeight:
                    marker.markerHeight = parseLength(trim);
                    if (!marker.markerHeight.isNegative()) {
                        break;
                    } else {
                        throw new SVGParseException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                case markerUnits:
                    if ("strokeWidth".equals(trim)) {
                        marker.markerUnitsAreUser = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        marker.markerUnitsAreUser = true;
                        break;
                    } else {
                        throw new SVGParseException("Invalid value for attribute markerUnits");
                    }
                case orient:
                    if (!"auto".equals(trim)) {
                        marker.orient = Float.valueOf(parseFloat(trim));
                        break;
                    } else {
                        marker.orient = Float.valueOf(Float.NaN);
                        break;
                    }
            }
        }
    }

    private void linearGradient(Attributes attributes) throws SVGParseException {
        debug("<linearGradient>", new Object[0]);
        if (this.currentElement != null) {
            SVG.SvgLinearGradient svgLinearGradient = new SVG.SvgLinearGradient();
            svgLinearGradient.document = this.svgDocument;
            svgLinearGradient.parent = this.currentElement;
            parseAttributesCore(svgLinearGradient, attributes);
            parseAttributesStyle(svgLinearGradient, attributes);
            parseAttributesGradient(svgLinearGradient, attributes);
            parseAttributesLinearGradient(svgLinearGradient, attributes);
            this.currentElement.addChild(svgLinearGradient);
            this.currentElement = svgLinearGradient;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0095, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseAttributesGradient(com.caverock.androidsvg.SVG.GradientElement r6, org.xml.sax.Attributes r7) throws com.caverock.androidsvg.SVGParseException {
        /*
            r5 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            int r2 = r7.getLength()
            if (r1 >= r2) goto L_0x0099
            java.lang.String r2 = r7.getValue(r1)
            java.lang.String r2 = r2.trim()
            int[] r3 = com.caverock.androidsvg.SVGParser.AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr
            java.lang.String r4 = r7.getLocalName(r1)
            com.caverock.androidsvg.SVGParser$SVGAttr r4 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r4)
            int r4 = r4.ordinal()
            r3 = r3[r4]
            r4 = 6
            if (r3 == r4) goto L_0x007b
            switch(r3) {
                case 32: goto L_0x0054;
                case 33: goto L_0x004d;
                case 34: goto L_0x0027;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x0095
        L_0x0027:
            com.caverock.androidsvg.SVG$GradientSpread r3 = com.caverock.androidsvg.SVG.GradientSpread.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x002e }
            r6.spreadMethod = r3     // Catch:{ IllegalArgumentException -> 0x002e }
            goto L_0x0095
        L_0x002e:
            com.caverock.androidsvg.SVGParseException r6 = new com.caverock.androidsvg.SVGParseException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Invalid spreadMethod attribute. \""
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.StringBuilder r7 = r7.append(r2)
            java.lang.String r0 = "\" is not a valid value."
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x004d:
            android.graphics.Matrix r2 = r5.parseTransformList(r2)
            r6.gradientTransform = r2
            goto L_0x0095
        L_0x0054:
            java.lang.String r3 = "objectBoundingBox"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x0063
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            r6.gradientUnitsAreUser = r2
            goto L_0x0095
        L_0x0063:
            java.lang.String r3 = "userSpaceOnUse"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0073
            r2 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6.gradientUnitsAreUser = r2
            goto L_0x0095
        L_0x0073:
            com.caverock.androidsvg.SVGParseException r6 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r7 = "Invalid value for attribute gradientUnits"
            r6.<init>(r7)
            throw r6
        L_0x007b:
            java.lang.String r3 = r7.getURI(r1)
            java.lang.String r4 = ""
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0093
            java.lang.String r3 = r7.getURI(r1)
            java.lang.String r4 = "http://www.w3.org/1999/xlink"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0095
        L_0x0093:
            r6.href = r2
        L_0x0095:
            int r1 = r1 + 1
            goto L_0x0002
        L_0x0099:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.parseAttributesGradient(com.caverock.androidsvg.SVG$GradientElement, org.xml.sax.Attributes):void");
    }

    private void parseAttributesLinearGradient(SVG.SvgLinearGradient svgLinearGradient, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x1:
                    svgLinearGradient.x1 = parseLength(trim);
                    break;
                case y1:
                    svgLinearGradient.y1 = parseLength(trim);
                    break;
                case x2:
                    svgLinearGradient.x2 = parseLength(trim);
                    break;
                case y2:
                    svgLinearGradient.y2 = parseLength(trim);
                    break;
            }
        }
    }

    private void radialGradient(Attributes attributes) throws SVGParseException {
        debug("<radialGradient>", new Object[0]);
        if (this.currentElement != null) {
            SVG.SvgRadialGradient svgRadialGradient = new SVG.SvgRadialGradient();
            svgRadialGradient.document = this.svgDocument;
            svgRadialGradient.parent = this.currentElement;
            parseAttributesCore(svgRadialGradient, attributes);
            parseAttributesStyle(svgRadialGradient, attributes);
            parseAttributesGradient(svgRadialGradient, attributes);
            parseAttributesRadialGradient(svgRadialGradient, attributes);
            this.currentElement.addChild(svgRadialGradient);
            this.currentElement = svgRadialGradient;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseAttributesRadialGradient(com.caverock.androidsvg.SVG.SvgRadialGradient r5, org.xml.sax.Attributes r6) throws com.caverock.androidsvg.SVGParseException {
        /*
            r4 = this;
            r0 = 0
        L_0x0001:
            int r1 = r6.getLength()
            if (r0 >= r1) goto L_0x0060
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = com.caverock.androidsvg.SVGParser.AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr
            java.lang.String r3 = r6.getLocalName(r0)
            com.caverock.androidsvg.SVGParser$SVGAttr r3 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 35
            if (r2 == r3) goto L_0x0057
            r3 = 36
            if (r2 == r3) goto L_0x0050
            switch(r2) {
                case 12: goto L_0x0049;
                case 13: goto L_0x0042;
                case 14: goto L_0x002b;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x005d
        L_0x002b:
            com.caverock.androidsvg.SVG$Length r1 = parseLength(r1)
            r5.r = r1
            com.caverock.androidsvg.SVG$Length r1 = r5.r
            boolean r1 = r1.isNegative()
            if (r1 != 0) goto L_0x003a
            goto L_0x005d
        L_0x003a:
            com.caverock.androidsvg.SVGParseException r5 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r6 = "Invalid <radialGradient> element. r cannot be negative"
            r5.<init>(r6)
            throw r5
        L_0x0042:
            com.caverock.androidsvg.SVG$Length r1 = parseLength(r1)
            r5.cy = r1
            goto L_0x005d
        L_0x0049:
            com.caverock.androidsvg.SVG$Length r1 = parseLength(r1)
            r5.cx = r1
            goto L_0x005d
        L_0x0050:
            com.caverock.androidsvg.SVG$Length r1 = parseLength(r1)
            r5.fy = r1
            goto L_0x005d
        L_0x0057:
            com.caverock.androidsvg.SVG$Length r1 = parseLength(r1)
            r5.fx = r1
        L_0x005d:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.parseAttributesRadialGradient(com.caverock.androidsvg.SVG$SvgRadialGradient, org.xml.sax.Attributes):void");
    }

    private void stop(Attributes attributes) throws SVGParseException {
        debug("<stop>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        } else if (svgContainer instanceof SVG.GradientElement) {
            SVG.Stop stop = new SVG.Stop();
            stop.document = this.svgDocument;
            stop.parent = this.currentElement;
            parseAttributesCore(stop, attributes);
            parseAttributesStyle(stop, attributes);
            parseAttributesStop(stop, attributes);
            this.currentElement.addChild(stop);
            this.currentElement = stop;
        } else {
            throw new SVGParseException("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
        }
    }

    private void parseAttributesStop(SVG.Stop stop, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 37) {
                stop.offset = parseGradientOffset(trim);
            }
        }
    }

    private Float parseGradientOffset(String str) throws SVGParseException {
        if (str.length() != 0) {
            int length = str.length();
            boolean z = true;
            if (str.charAt(str.length() - 1) == '%') {
                length--;
            } else {
                z = false;
            }
            try {
                float parseFloat = parseFloat(str, 0, length);
                float f = 100.0f;
                if (z) {
                    parseFloat /= 100.0f;
                }
                if (parseFloat < 0.0f) {
                    f = 0.0f;
                } else if (parseFloat <= 100.0f) {
                    f = parseFloat;
                }
                return Float.valueOf(f);
            } catch (NumberFormatException e) {
                throw new SVGParseException("Invalid offset value in <stop>: " + str, e);
            }
        } else {
            throw new SVGParseException("Invalid offset value in <stop> (empty string)");
        }
    }

    private void solidColor(Attributes attributes) throws SVGParseException {
        debug("<solidColor>", new Object[0]);
        if (this.currentElement != null) {
            SVG.SolidColor solidColor = new SVG.SolidColor();
            solidColor.document = this.svgDocument;
            solidColor.parent = this.currentElement;
            parseAttributesCore(solidColor, attributes);
            parseAttributesStyle(solidColor, attributes);
            this.currentElement.addChild(solidColor);
            this.currentElement = solidColor;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void clipPath(Attributes attributes) throws SVGParseException {
        debug("<clipPath>", new Object[0]);
        if (this.currentElement != null) {
            SVG.ClipPath clipPath = new SVG.ClipPath();
            clipPath.document = this.svgDocument;
            clipPath.parent = this.currentElement;
            parseAttributesCore(clipPath, attributes);
            parseAttributesStyle(clipPath, attributes);
            parseAttributesTransform(clipPath, attributes);
            parseAttributesConditional(clipPath, attributes);
            parseAttributesClipPath(clipPath, attributes);
            this.currentElement.addChild(clipPath);
            this.currentElement = clipPath;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void parseAttributesClipPath(SVG.ClipPath clipPath, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 38) {
                if ("objectBoundingBox".equals(trim)) {
                    clipPath.clipPathUnitsAreUser = false;
                } else if ("userSpaceOnUse".equals(trim)) {
                    clipPath.clipPathUnitsAreUser = true;
                } else {
                    throw new SVGParseException("Invalid value for attribute clipPathUnits");
                }
            }
        }
    }

    private void textPath(Attributes attributes) throws SVGParseException {
        debug("<textPath>", new Object[0]);
        if (this.currentElement != null) {
            SVG.TextPath textPath = new SVG.TextPath();
            textPath.document = this.svgDocument;
            textPath.parent = this.currentElement;
            parseAttributesCore(textPath, attributes);
            parseAttributesStyle(textPath, attributes);
            parseAttributesConditional(textPath, attributes);
            parseAttributesTextPath(textPath, attributes);
            this.currentElement.addChild(textPath);
            this.currentElement = textPath;
            if (textPath.parent instanceof SVG.TextRoot) {
                textPath.setTextRoot((SVG.TextRoot) textPath.parent);
            } else {
                textPath.setTextRoot(((SVG.TextChild) textPath.parent).getTextRoot());
            }
        } else {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    private void parseAttributesTextPath(SVG.TextPath textPath, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 != 6) {
                if (i2 == 39) {
                    textPath.startOffset = parseLength(trim);
                }
            } else if ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                textPath.href = trim;
            }
        }
    }

    private void pattern(Attributes attributes) throws SVGParseException {
        debug("<pattern>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Pattern pattern = new SVG.Pattern();
            pattern.document = this.svgDocument;
            pattern.parent = this.currentElement;
            parseAttributesCore(pattern, attributes);
            parseAttributesStyle(pattern, attributes);
            parseAttributesConditional(pattern, attributes);
            parseAttributesViewBox(pattern, attributes);
            parseAttributesPattern(pattern, attributes);
            this.currentElement.addChild(pattern);
            this.currentElement = pattern;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00d7, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseAttributesPattern(com.caverock.androidsvg.SVG.Pattern r8, org.xml.sax.Attributes r9) throws com.caverock.androidsvg.SVGParseException {
        /*
            r7 = this;
            r0 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
        L_0x0005:
            int r2 = r9.getLength()
            if (r0 >= r2) goto L_0x00db
            java.lang.String r2 = r9.getValue(r0)
            java.lang.String r2 = r2.trim()
            int[] r3 = com.caverock.androidsvg.SVGParser.AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr
            java.lang.String r4 = r9.getLocalName(r0)
            com.caverock.androidsvg.SVGParser$SVGAttr r4 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r4)
            int r4 = r4.ordinal()
            r3 = r3[r4]
            r4 = 1
            if (r3 == r4) goto L_0x00d1
            r5 = 2
            if (r3 == r5) goto L_0x00ca
            r5 = 3
            if (r3 == r5) goto L_0x00b3
            r5 = 4
            if (r3 == r5) goto L_0x009c
            r5 = 6
            if (r3 == r5) goto L_0x0081
            java.lang.String r5 = "userSpaceOnUse"
            java.lang.String r6 = "objectBoundingBox"
            switch(r3) {
                case 40: goto L_0x0063;
                case 41: goto L_0x0043;
                case 42: goto L_0x003b;
                default: goto L_0x0039;
            }
        L_0x0039:
            goto L_0x00d7
        L_0x003b:
            android.graphics.Matrix r2 = r7.parseTransformList(r2)
            r8.patternTransform = r2
            goto L_0x00d7
        L_0x0043:
            boolean r3 = r6.equals(r2)
            if (r3 == 0) goto L_0x004d
            r8.patternContentUnitsAreUser = r1
            goto L_0x00d7
        L_0x004d:
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x005b
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r4)
            r8.patternContentUnitsAreUser = r2
            goto L_0x00d7
        L_0x005b:
            com.caverock.androidsvg.SVGParseException r8 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r9 = "Invalid value for attribute patternContentUnits"
            r8.<init>(r9)
            throw r8
        L_0x0063:
            boolean r3 = r6.equals(r2)
            if (r3 == 0) goto L_0x006c
            r8.patternUnitsAreUser = r1
            goto L_0x00d7
        L_0x006c:
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0079
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r4)
            r8.patternUnitsAreUser = r2
            goto L_0x00d7
        L_0x0079:
            com.caverock.androidsvg.SVGParseException r8 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r9 = "Invalid value for attribute patternUnits"
            r8.<init>(r9)
            throw r8
        L_0x0081:
            java.lang.String r3 = r9.getURI(r0)
            java.lang.String r4 = ""
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0099
            java.lang.String r3 = r9.getURI(r0)
            java.lang.String r4 = "http://www.w3.org/1999/xlink"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00d7
        L_0x0099:
            r8.href = r2
            goto L_0x00d7
        L_0x009c:
            com.caverock.androidsvg.SVG$Length r2 = parseLength(r2)
            r8.height = r2
            com.caverock.androidsvg.SVG$Length r2 = r8.height
            boolean r2 = r2.isNegative()
            if (r2 != 0) goto L_0x00ab
            goto L_0x00d7
        L_0x00ab:
            com.caverock.androidsvg.SVGParseException r8 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r9 = "Invalid <pattern> element. height cannot be negative"
            r8.<init>(r9)
            throw r8
        L_0x00b3:
            com.caverock.androidsvg.SVG$Length r2 = parseLength(r2)
            r8.width = r2
            com.caverock.androidsvg.SVG$Length r2 = r8.width
            boolean r2 = r2.isNegative()
            if (r2 != 0) goto L_0x00c2
            goto L_0x00d7
        L_0x00c2:
            com.caverock.androidsvg.SVGParseException r8 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r9 = "Invalid <pattern> element. width cannot be negative"
            r8.<init>(r9)
            throw r8
        L_0x00ca:
            com.caverock.androidsvg.SVG$Length r2 = parseLength(r2)
            r8.y = r2
            goto L_0x00d7
        L_0x00d1:
            com.caverock.androidsvg.SVG$Length r2 = parseLength(r2)
            r8.x = r2
        L_0x00d7:
            int r0 = r0 + 1
            goto L_0x0005
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.parseAttributesPattern(com.caverock.androidsvg.SVG$Pattern, org.xml.sax.Attributes):void");
    }

    private void view(Attributes attributes) throws SVGParseException {
        debug("<view>", new Object[0]);
        if (this.currentElement != null) {
            SVG.View view = new SVG.View();
            view.document = this.svgDocument;
            view.parent = this.currentElement;
            parseAttributesCore(view, attributes);
            parseAttributesConditional(view, attributes);
            parseAttributesViewBox(view, attributes);
            this.currentElement.addChild(view);
            this.currentElement = view;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void mask(Attributes attributes) throws SVGParseException {
        debug("<mask>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Mask mask = new SVG.Mask();
            mask.document = this.svgDocument;
            mask.parent = this.currentElement;
            parseAttributesCore(mask, attributes);
            parseAttributesStyle(mask, attributes);
            parseAttributesConditional(mask, attributes);
            parseAttributesMask(mask, attributes);
            this.currentElement.addChild(mask);
            this.currentElement = mask;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void parseAttributesMask(SVG.Mask mask, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                mask.x = parseLength(trim);
            } else if (i2 == 2) {
                mask.y = parseLength(trim);
            } else if (i2 == 3) {
                mask.width = parseLength(trim);
                if (mask.width.isNegative()) {
                    throw new SVGParseException("Invalid <mask> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                mask.height = parseLength(trim);
                if (mask.height.isNegative()) {
                    throw new SVGParseException("Invalid <mask> element. height cannot be negative");
                }
            } else if (i2 != 43) {
                if (i2 != 44) {
                    continue;
                } else if ("objectBoundingBox".equals(trim)) {
                    mask.maskContentUnitsAreUser = false;
                } else if ("userSpaceOnUse".equals(trim)) {
                    mask.maskContentUnitsAreUser = true;
                } else {
                    throw new SVGParseException("Invalid value for attribute maskContentUnits");
                }
            } else if ("objectBoundingBox".equals(trim)) {
                mask.maskUnitsAreUser = false;
            } else if ("userSpaceOnUse".equals(trim)) {
                mask.maskUnitsAreUser = true;
            } else {
                throw new SVGParseException("Invalid value for attribute maskUnits");
            }
        }
    }

    static class TextScanner {
        String input;
        int inputLength = 0;
        private NumberParser numberParser = new NumberParser();
        int position = 0;

        /* access modifiers changed from: package-private */
        public boolean isEOL(int i) {
            return i == 10 || i == 13;
        }

        /* access modifiers changed from: package-private */
        public boolean isWhitespace(int i) {
            return i == 32 || i == 10 || i == 13 || i == 9;
        }

        TextScanner(String str) {
            String trim = str.trim();
            this.input = trim;
            this.inputLength = trim.length();
        }

        /* access modifiers changed from: package-private */
        public boolean empty() {
            return this.position == this.inputLength;
        }

        /* access modifiers changed from: package-private */
        public void skipWhitespace() {
            while (true) {
                int i = this.position;
                if (i < this.inputLength && isWhitespace(this.input.charAt(i))) {
                    this.position++;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean skipCommaWhitespace() {
            skipWhitespace();
            int i = this.position;
            if (i == this.inputLength || this.input.charAt(i) != ',') {
                return false;
            }
            this.position++;
            skipWhitespace();
            return true;
        }

        /* access modifiers changed from: package-private */
        public float nextFloat() {
            float parseNumber = this.numberParser.parseNumber(this.input, this.position, this.inputLength);
            if (!Float.isNaN(parseNumber)) {
                this.position = this.numberParser.getEndPos();
            }
            return parseNumber;
        }

        /* access modifiers changed from: package-private */
        public float possibleNextFloat() {
            skipCommaWhitespace();
            float parseNumber = this.numberParser.parseNumber(this.input, this.position, this.inputLength);
            if (!Float.isNaN(parseNumber)) {
                this.position = this.numberParser.getEndPos();
            }
            return parseNumber;
        }

        /* access modifiers changed from: package-private */
        public float checkedNextFloat(float f) {
            if (Float.isNaN(f)) {
                return Float.NaN;
            }
            skipCommaWhitespace();
            return nextFloat();
        }

        /* access modifiers changed from: package-private */
        public float checkedNextFloat(Boolean bool) {
            if (bool == null) {
                return Float.NaN;
            }
            skipCommaWhitespace();
            return nextFloat();
        }

        /* access modifiers changed from: package-private */
        public Integer nextChar() {
            int i = this.position;
            if (i == this.inputLength) {
                return null;
            }
            String str = this.input;
            this.position = i + 1;
            return Integer.valueOf(str.charAt(i));
        }

        /* access modifiers changed from: package-private */
        public SVG.Length nextLength() {
            float nextFloat = nextFloat();
            if (Float.isNaN(nextFloat)) {
                return null;
            }
            SVG.Unit nextUnit = nextUnit();
            if (nextUnit == null) {
                return new SVG.Length(nextFloat, SVG.Unit.px);
            }
            return new SVG.Length(nextFloat, nextUnit);
        }

        /* access modifiers changed from: package-private */
        public Boolean nextFlag() {
            int i = this.position;
            if (i == this.inputLength) {
                return null;
            }
            char charAt = this.input.charAt(i);
            if (charAt != '0' && charAt != '1') {
                return null;
            }
            boolean z = true;
            this.position++;
            if (charAt != '1') {
                z = false;
            }
            return Boolean.valueOf(z);
        }

        /* access modifiers changed from: package-private */
        public Boolean checkedNextFlag(Object obj) {
            if (obj == null) {
                return null;
            }
            skipCommaWhitespace();
            return nextFlag();
        }

        /* access modifiers changed from: package-private */
        public boolean consume(char c) {
            int i = this.position;
            boolean z = i < this.inputLength && this.input.charAt(i) == c;
            if (z) {
                this.position++;
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public boolean consume(String str) {
            int length = str.length();
            int i = this.position;
            boolean z = i <= this.inputLength - length && this.input.substring(i, i + length).equals(str);
            if (z) {
                this.position += length;
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public int advanceChar() {
            int i = this.position;
            int i2 = this.inputLength;
            if (i == i2) {
                return -1;
            }
            int i3 = i + 1;
            this.position = i3;
            if (i3 < i2) {
                return this.input.charAt(i3);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public String nextToken() {
            return nextToken(' ', false);
        }

        /* access modifiers changed from: package-private */
        public String nextToken(char c) {
            return nextToken(c, false);
        }

        /* access modifiers changed from: package-private */
        public String nextTokenWithWhitespace(char c) {
            return nextToken(c, true);
        }

        /* access modifiers changed from: package-private */
        public String nextToken(char c, boolean z) {
            if (empty()) {
                return null;
            }
            char charAt = this.input.charAt(this.position);
            if ((!z && isWhitespace(charAt)) || charAt == c) {
                return null;
            }
            int i = this.position;
            int advanceChar = advanceChar();
            while (advanceChar != -1 && advanceChar != c && (z || !isWhitespace(advanceChar))) {
                advanceChar = advanceChar();
            }
            return this.input.substring(i, this.position);
        }

        /* access modifiers changed from: package-private */
        public String nextWord() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            char charAt = this.input.charAt(i);
            if ((charAt < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z')) {
                this.position = i;
                return null;
            }
            int advanceChar = advanceChar();
            while (true) {
                if ((advanceChar >= 65 && advanceChar <= 90) || (advanceChar >= 97 && advanceChar <= 122)) {
                    advanceChar = advanceChar();
                }
            }
            return this.input.substring(i, this.position);
        }

        /* access modifiers changed from: package-private */
        public String nextFunction() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            int charAt = this.input.charAt(i);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    int i2 = this.position;
                } else {
                    charAt = advanceChar();
                }
            }
            int i22 = this.position;
            while (isWhitespace(charAt)) {
                charAt = advanceChar();
            }
            if (charAt == 40) {
                this.position++;
                return this.input.substring(i, i22);
            }
            this.position = i;
            return null;
        }

        /* access modifiers changed from: package-private */
        public String ahead() {
            int i = this.position;
            while (!empty() && !isWhitespace(this.input.charAt(this.position))) {
                this.position++;
            }
            String substring = this.input.substring(i, this.position);
            this.position = i;
            return substring;
        }

        /* access modifiers changed from: package-private */
        public SVG.Unit nextUnit() {
            if (empty()) {
                return null;
            }
            if (this.input.charAt(this.position) == '%') {
                this.position++;
                return SVG.Unit.percent;
            }
            int i = this.position;
            if (i > this.inputLength - 2) {
                return null;
            }
            try {
                SVG.Unit valueOf = SVG.Unit.valueOf(this.input.substring(i, i + 2).toLowerCase(Locale.US));
                this.position += 2;
                return valueOf;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean hasLetter() {
            int i = this.position;
            if (i == this.inputLength) {
                return false;
            }
            char charAt = this.input.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public String nextQuotedString() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            char charAt = this.input.charAt(i);
            if (charAt != '\'' && charAt != '\"') {
                return null;
            }
            int advanceChar = advanceChar();
            while (advanceChar != -1 && advanceChar != charAt) {
                advanceChar = advanceChar();
            }
            if (advanceChar == -1) {
                this.position = i;
                return null;
            }
            int i2 = this.position + 1;
            this.position = i2;
            return this.input.substring(i + 1, i2 - 1);
        }

        /* access modifiers changed from: package-private */
        public String restOfText() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            this.position = this.inputLength;
            return this.input.substring(i);
        }
    }

    private void parseAttributesCore(SVG.SvgElementBase svgElementBase, Attributes attributes) throws SVGParseException {
        int i = 0;
        while (i < attributes.getLength()) {
            String qName = attributes.getQName(i);
            if (qName.equals("id") || qName.equals("xml:id")) {
                svgElementBase.id = attributes.getValue(i).trim();
                return;
            } else if (qName.equals("xml:space")) {
                String trim = attributes.getValue(i).trim();
                if (Constants.COLLATION_DEFAULT.equals(trim)) {
                    svgElementBase.spacePreserve = Boolean.FALSE;
                    return;
                } else if ("preserve".equals(trim)) {
                    svgElementBase.spacePreserve = Boolean.TRUE;
                    return;
                } else {
                    throw new SVGParseException("Invalid value for \"xml:space\" attribute: " + trim);
                }
            } else {
                i++;
            }
        }
    }

    private void parseAttributesStyle(SVG.SvgElementBase svgElementBase, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (trim.length() != 0) {
                int i2 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 == 45) {
                    parseStyle(svgElementBase, trim);
                } else if (i2 != 46) {
                    if (svgElementBase.baseStyle == null) {
                        svgElementBase.baseStyle = new SVG.Style();
                    }
                    processStyleProperty(svgElementBase.baseStyle, attributes.getLocalName(i), attributes.getValue(i).trim());
                } else {
                    svgElementBase.classNames = CSSParser.parseClassAttribute(trim);
                }
            }
        }
    }

    private static void parseStyle(SVG.SvgElementBase svgElementBase, String str) {
        TextScanner textScanner = new TextScanner(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String nextToken = textScanner.nextToken(':');
            textScanner.skipWhitespace();
            if (textScanner.consume(':')) {
                textScanner.skipWhitespace();
                String nextTokenWithWhitespace = textScanner.nextTokenWithWhitespace(';');
                if (nextTokenWithWhitespace != null) {
                    textScanner.skipWhitespace();
                    if (textScanner.empty() || textScanner.consume(';')) {
                        if (svgElementBase.style == null) {
                            svgElementBase.style = new SVG.Style();
                        }
                        processStyleProperty(svgElementBase.style, nextToken, nextTokenWithWhitespace);
                        textScanner.skipWhitespace();
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    static void processStyleProperty(SVG.Style style, String str, String str2) {
        if (str2.length() != 0 && !str2.equals("inherit")) {
            switch (SVGAttr.fromString(str)) {
                case fill:
                    style.fill = parsePaintSpecifier(str2);
                    if (style.fill != null) {
                        style.specifiedFlags |= 1;
                        return;
                    }
                    return;
                case fill_rule:
                    style.fillRule = parseFillRule(str2);
                    if (style.fillRule != null) {
                        style.specifiedFlags |= 2;
                        return;
                    }
                    return;
                case fill_opacity:
                    style.fillOpacity = parseOpacity(str2);
                    if (style.fillOpacity != null) {
                        style.specifiedFlags |= 4;
                        return;
                    }
                    return;
                case stroke:
                    style.stroke = parsePaintSpecifier(str2);
                    if (style.stroke != null) {
                        style.specifiedFlags |= 8;
                        return;
                    }
                    return;
                case stroke_opacity:
                    style.strokeOpacity = parseOpacity(str2);
                    if (style.strokeOpacity != null) {
                        style.specifiedFlags |= 16;
                        return;
                    }
                    return;
                case stroke_width:
                    style.strokeWidth = parseLength(str2);
                    style.specifiedFlags |= 32;
                    return;
                case stroke_linecap:
                    style.strokeLineCap = parseStrokeLineCap(str2);
                    if (style.strokeLineCap != null) {
                        style.specifiedFlags |= 64;
                        return;
                    }
                    return;
                case stroke_linejoin:
                    style.strokeLineJoin = parseStrokeLineJoin(str2);
                    if (style.strokeLineJoin != null) {
                        style.specifiedFlags |= 128;
                        return;
                    }
                    return;
                case stroke_miterlimit:
                    style.strokeMiterLimit = Float.valueOf(parseFloat(str2));
                    style.specifiedFlags |= 256;
                    return;
                case stroke_dasharray:
                    if ("none".equals(str2)) {
                        style.strokeDashArray = null;
                        style.specifiedFlags |= 512;
                        return;
                    }
                    style.strokeDashArray = parseStrokeDashArray(str2);
                    if (style.strokeDashArray != null) {
                        style.specifiedFlags |= 512;
                        return;
                    }
                    return;
                case stroke_dashoffset:
                    style.strokeDashOffset = parseLength(str2);
                    style.specifiedFlags |= 1024;
                    return;
                case opacity:
                    style.opacity = parseOpacity(str2);
                    style.specifiedFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    return;
                case color:
                    try {
                        style.color = parseColour(str2);
                        style.specifiedFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                        return;
                    } catch (SVGParseException unused) {
                    }
                case font:
                    parseFont(style, str2);
                    return;
                case font_family:
                    style.fontFamily = parseFontFamily(str2);
                    if (style.fontFamily != null) {
                        style.specifiedFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                        return;
                    }
                    return;
                case font_size:
                    style.fontSize = parseFontSize(str2);
                    if (style.fontSize != null) {
                        style.specifiedFlags |= 16384;
                        return;
                    }
                    return;
                case font_weight:
                    style.fontWeight = parseFontWeight(str2);
                    if (style.fontWeight != null) {
                        style.specifiedFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                        return;
                    }
                    return;
                case font_style:
                    style.fontStyle = parseFontStyle(str2);
                    if (style.fontStyle != null) {
                        style.specifiedFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                        return;
                    }
                    return;
                case text_decoration:
                    style.textDecoration = parseTextDecoration(str2);
                    if (style.textDecoration != null) {
                        style.specifiedFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                        return;
                    }
                    return;
                case direction:
                    style.direction = parseTextDirection(str2);
                    if (style.direction != null) {
                        style.specifiedFlags |= 68719476736L;
                        return;
                    }
                    return;
                case text_anchor:
                    style.textAnchor = parseTextAnchor(str2);
                    if (style.textAnchor != null) {
                        style.specifiedFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                        return;
                    }
                    return;
                case overflow:
                    style.overflow = parseOverflow(str2);
                    if (style.overflow != null) {
                        style.specifiedFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                        return;
                    }
                    return;
                case marker:
                    style.markerStart = parseFunctionalIRI(str2, str);
                    style.markerMid = style.markerStart;
                    style.markerEnd = style.markerStart;
                    style.specifiedFlags |= 14680064;
                    return;
                case marker_start:
                    style.markerStart = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    return;
                case marker_mid:
                    style.markerMid = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
                    return;
                case marker_end:
                    style.markerEnd = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 8388608;
                    return;
                case display:
                    if (str2.indexOf(124) < 0 && VALID_DISPLAY_VALUES.contains('|' + str2 + '|')) {
                        style.display = Boolean.valueOf(!str2.equals("none"));
                        style.specifiedFlags |= 16777216;
                        return;
                    }
                    return;
                case visibility:
                    if (str2.indexOf(124) < 0 && VALID_VISIBILITY_VALUES.contains('|' + str2 + '|')) {
                        style.visibility = Boolean.valueOf(str2.equals(ViewProps.VISIBLE));
                        style.specifiedFlags |= 33554432;
                        return;
                    }
                    return;
                case stop_color:
                    if (str2.equals(CURRENTCOLOR)) {
                        style.stopColor = SVG.CurrentColor.getInstance();
                    } else {
                        try {
                            style.stopColor = parseColour(str2);
                        } catch (SVGParseException e) {
                            Log.w(TAG, e.getMessage());
                            return;
                        }
                    }
                    style.specifiedFlags |= 67108864;
                    return;
                case stop_opacity:
                    style.stopOpacity = parseOpacity(str2);
                    style.specifiedFlags |= 134217728;
                    return;
                case clip:
                    style.clip = parseClip(str2);
                    if (style.clip != null) {
                        style.specifiedFlags |= 1048576;
                        return;
                    }
                    return;
                case clip_path:
                    style.clipPath = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 268435456;
                    return;
                case clip_rule:
                    style.clipRule = parseFillRule(str2);
                    style.specifiedFlags |= 536870912;
                    return;
                case mask:
                    style.mask = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= FileUtils.ONE_GB;
                    return;
                case solid_color:
                    if (str2.equals(CURRENTCOLOR)) {
                        style.solidColor = SVG.CurrentColor.getInstance();
                    } else {
                        try {
                            style.solidColor = parseColour(str2);
                        } catch (SVGParseException e2) {
                            Log.w(TAG, e2.getMessage());
                            return;
                        }
                    }
                    style.specifiedFlags |= 2147483648L;
                    return;
                case solid_opacity:
                    style.solidOpacity = parseOpacity(str2);
                    style.specifiedFlags |= 4294967296L;
                    return;
                case viewport_fill:
                    if (str2.equals(CURRENTCOLOR)) {
                        style.viewportFill = SVG.CurrentColor.getInstance();
                    } else {
                        try {
                            style.viewportFill = parseColour(str2);
                        } catch (SVGParseException e3) {
                            Log.w(TAG, e3.getMessage());
                            return;
                        }
                    }
                    style.specifiedFlags |= 8589934592L;
                    return;
                case viewport_fill_opacity:
                    style.viewportFillOpacity = parseOpacity(str2);
                    style.specifiedFlags |= 17179869184L;
                    return;
                case vector_effect:
                    style.vectorEffect = parseVectorEffect(str2);
                    if (style.vectorEffect != null) {
                        style.specifiedFlags |= 34359738368L;
                        return;
                    }
                    return;
                case image_rendering:
                    style.imageRendering = parseRenderQuality(str2);
                    if (style.imageRendering != null) {
                        style.specifiedFlags |= 137438953472L;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void parseAttributesViewBox(SVG.SvgViewBoxContainer svgViewBoxContainer, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 7) {
                parsePreserveAspectRatio(svgViewBoxContainer, trim);
            } else if (i2 == 87) {
                svgViewBoxContainer.viewBox = parseViewBox(trim);
            }
        }
    }

    private void parseAttributesTransform(SVG.HasTransform hasTransform, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.transform) {
                hasTransform.setTransform(parseTransformList(attributes.getValue(i)));
            }
        }
    }

    private Matrix parseTransformList(String str) throws SVGParseException {
        String str2 = str;
        Matrix matrix = new Matrix();
        TextScanner textScanner = new TextScanner(str2);
        textScanner.skipWhitespace();
        while (!textScanner.empty()) {
            String nextFunction = textScanner.nextFunction();
            if (nextFunction != null) {
                nextFunction.hashCode();
                char c = 65535;
                switch (nextFunction.hashCode()) {
                    case -1081239615:
                        if (nextFunction.equals("matrix")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -925180581:
                        if (nextFunction.equals("rotate")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 109250890:
                        if (nextFunction.equals("scale")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 109493390:
                        if (nextFunction.equals("skewX")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 109493391:
                        if (nextFunction.equals("skewY")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1052832078:
                        if (nextFunction.equals("translate")) {
                            c = 5;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        textScanner.skipWhitespace();
                        float nextFloat = textScanner.nextFloat();
                        textScanner.skipCommaWhitespace();
                        float nextFloat2 = textScanner.nextFloat();
                        textScanner.skipCommaWhitespace();
                        float nextFloat3 = textScanner.nextFloat();
                        textScanner.skipCommaWhitespace();
                        float nextFloat4 = textScanner.nextFloat();
                        textScanner.skipCommaWhitespace();
                        float nextFloat5 = textScanner.nextFloat();
                        textScanner.skipCommaWhitespace();
                        float nextFloat6 = textScanner.nextFloat();
                        textScanner.skipWhitespace();
                        if (!Float.isNaN(nextFloat6) && textScanner.consume(')')) {
                            Matrix matrix2 = new Matrix();
                            matrix2.setValues(new float[]{nextFloat, nextFloat3, nextFloat5, nextFloat2, nextFloat4, nextFloat6, 0.0f, 0.0f, 1.0f});
                            matrix.preConcat(matrix2);
                            break;
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str2);
                        }
                        break;
                    case 1:
                        textScanner.skipWhitespace();
                        float nextFloat7 = textScanner.nextFloat();
                        float possibleNextFloat = textScanner.possibleNextFloat();
                        float possibleNextFloat2 = textScanner.possibleNextFloat();
                        textScanner.skipWhitespace();
                        if (Float.isNaN(nextFloat7) || !textScanner.consume(')')) {
                            throw new SVGParseException("Invalid transform list: " + str2);
                        } else if (Float.isNaN(possibleNextFloat)) {
                            matrix.preRotate(nextFloat7);
                            break;
                        } else if (!Float.isNaN(possibleNextFloat2)) {
                            matrix.preRotate(nextFloat7, possibleNextFloat, possibleNextFloat2);
                            break;
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str2);
                        }
                        break;
                    case 2:
                        textScanner.skipWhitespace();
                        float nextFloat8 = textScanner.nextFloat();
                        float possibleNextFloat3 = textScanner.possibleNextFloat();
                        textScanner.skipWhitespace();
                        if (!Float.isNaN(nextFloat8) && textScanner.consume(')')) {
                            if (!Float.isNaN(possibleNextFloat3)) {
                                matrix.preScale(nextFloat8, possibleNextFloat3);
                                break;
                            } else {
                                matrix.preScale(nextFloat8, nextFloat8);
                                break;
                            }
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str2);
                        }
                        break;
                    case 3:
                        textScanner.skipWhitespace();
                        float nextFloat9 = textScanner.nextFloat();
                        textScanner.skipWhitespace();
                        if (!Float.isNaN(nextFloat9) && textScanner.consume(')')) {
                            matrix.preSkew((float) Math.tan(Math.toRadians((double) nextFloat9)), 0.0f);
                            break;
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str2);
                        }
                        break;
                    case 4:
                        textScanner.skipWhitespace();
                        float nextFloat10 = textScanner.nextFloat();
                        textScanner.skipWhitespace();
                        if (!Float.isNaN(nextFloat10) && textScanner.consume(')')) {
                            matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians((double) nextFloat10)));
                            break;
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str2);
                        }
                        break;
                    case 5:
                        textScanner.skipWhitespace();
                        float nextFloat11 = textScanner.nextFloat();
                        float possibleNextFloat4 = textScanner.possibleNextFloat();
                        textScanner.skipWhitespace();
                        if (!Float.isNaN(nextFloat11) && textScanner.consume(')')) {
                            if (!Float.isNaN(possibleNextFloat4)) {
                                matrix.preTranslate(nextFloat11, possibleNextFloat4);
                                break;
                            } else {
                                matrix.preTranslate(nextFloat11, 0.0f);
                                break;
                            }
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str2);
                        }
                        break;
                    default:
                        throw new SVGParseException("Invalid transform list fn: " + nextFunction + ")");
                }
                if (textScanner.empty()) {
                    return matrix;
                }
                textScanner.skipCommaWhitespace();
            } else {
                throw new SVGParseException("Bad transform function encountered in transform list: " + str2);
            }
        }
        return matrix;
    }

    static SVG.Length parseLength(String str) throws SVGParseException {
        if (str.length() != 0) {
            int length = str.length();
            SVG.Unit unit = SVG.Unit.px;
            char charAt = str.charAt(length - 1);
            if (charAt == '%') {
                length--;
                unit = SVG.Unit.percent;
            } else if (length > 2 && Character.isLetter(charAt) && Character.isLetter(str.charAt(length - 2))) {
                length -= 2;
                try {
                    unit = SVG.Unit.valueOf(str.substring(length).toLowerCase(Locale.US));
                } catch (IllegalArgumentException unused) {
                    throw new SVGParseException("Invalid length unit specifier: " + str);
                }
            }
            try {
                return new SVG.Length(parseFloat(str, 0, length), unit);
            } catch (NumberFormatException e) {
                throw new SVGParseException("Invalid length value: " + str, e);
            }
        } else {
            throw new SVGParseException("Invalid length value (empty string)");
        }
    }

    private static List<SVG.Length> parseLengthList(String str) throws SVGParseException {
        if (str.length() != 0) {
            ArrayList arrayList = new ArrayList(1);
            TextScanner textScanner = new TextScanner(str);
            textScanner.skipWhitespace();
            while (!textScanner.empty()) {
                float nextFloat = textScanner.nextFloat();
                if (!Float.isNaN(nextFloat)) {
                    SVG.Unit nextUnit = textScanner.nextUnit();
                    if (nextUnit == null) {
                        nextUnit = SVG.Unit.px;
                    }
                    arrayList.add(new SVG.Length(nextFloat, nextUnit));
                    textScanner.skipCommaWhitespace();
                } else {
                    throw new SVGParseException("Invalid length list value: " + textScanner.ahead());
                }
            }
            return arrayList;
        }
        throw new SVGParseException("Invalid length list (empty string)");
    }

    private static float parseFloat(String str) throws SVGParseException {
        int length = str.length();
        if (length != 0) {
            return parseFloat(str, 0, length);
        }
        throw new SVGParseException("Invalid float value (empty string)");
    }

    private static float parseFloat(String str, int i, int i2) throws SVGParseException {
        float parseNumber = new NumberParser().parseNumber(str, i, i2);
        if (!Float.isNaN(parseNumber)) {
            return parseNumber;
        }
        throw new SVGParseException("Invalid float value: " + str);
    }

    private static Float parseOpacity(String str) {
        try {
            float parseFloat = parseFloat(str);
            if (parseFloat < 0.0f) {
                parseFloat = 0.0f;
            } else if (parseFloat > 1.0f) {
                parseFloat = 1.0f;
            }
            return Float.valueOf(parseFloat);
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private static SVG.Box parseViewBox(String str) throws SVGParseException {
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        float nextFloat = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        float nextFloat2 = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        float nextFloat3 = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        float nextFloat4 = textScanner.nextFloat();
        if (Float.isNaN(nextFloat) || Float.isNaN(nextFloat2) || Float.isNaN(nextFloat3) || Float.isNaN(nextFloat4)) {
            throw new SVGParseException("Invalid viewBox definition - should have four numbers");
        } else if (nextFloat3 < 0.0f) {
            throw new SVGParseException("Invalid viewBox. width cannot be negative");
        } else if (nextFloat4 >= 0.0f) {
            return new SVG.Box(nextFloat, nextFloat2, nextFloat3, nextFloat4);
        } else {
            throw new SVGParseException("Invalid viewBox. height cannot be negative");
        }
    }

    private static void parsePreserveAspectRatio(SVG.SvgPreserveAspectRatioContainer svgPreserveAspectRatioContainer, String str) throws SVGParseException {
        svgPreserveAspectRatioContainer.preserveAspectRatio = parsePreserveAspectRatio(str);
    }

    static PreserveAspectRatio parsePreserveAspectRatio(String str) throws SVGParseException {
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        String nextToken = textScanner.nextToken();
        if ("defer".equals(nextToken)) {
            textScanner.skipWhitespace();
            nextToken = textScanner.nextToken();
        }
        PreserveAspectRatio.Alignment alignment = AspectRatioKeywords.get(nextToken);
        PreserveAspectRatio.Scale scale = null;
        textScanner.skipWhitespace();
        if (!textScanner.empty()) {
            String nextToken2 = textScanner.nextToken();
            nextToken2.hashCode();
            if (nextToken2.equals("meet")) {
                scale = PreserveAspectRatio.Scale.meet;
            } else if (nextToken2.equals("slice")) {
                scale = PreserveAspectRatio.Scale.slice;
            } else {
                throw new SVGParseException("Invalid preserveAspectRatio definition: " + str);
            }
        }
        return new PreserveAspectRatio(alignment, scale);
    }

    private static SVG.SvgPaint parsePaintSpecifier(String str) {
        if (!str.startsWith("url(")) {
            return parseColourSpecifer(str);
        }
        int indexOf = str.indexOf(")");
        SVG.SvgPaint svgPaint = null;
        if (indexOf == -1) {
            return new SVG.PaintReference(str.substring(4).trim(), (SVG.SvgPaint) null);
        }
        String trim = str.substring(4, indexOf).trim();
        String trim2 = str.substring(indexOf + 1).trim();
        if (trim2.length() > 0) {
            svgPaint = parseColourSpecifer(trim2);
        }
        return new SVG.PaintReference(trim, svgPaint);
    }

    private static SVG.SvgPaint parseColourSpecifer(String str) {
        str.hashCode();
        if (str.equals("none")) {
            return SVG.Colour.TRANSPARENT;
        }
        if (str.equals(CURRENTCOLOR)) {
            return SVG.CurrentColor.getInstance();
        }
        try {
            return parseColour(str);
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private static SVG.Colour parseColour(String str) throws SVGParseException {
        int i = 5;
        if (str.charAt(0) == '#') {
            IntegerParser parseHex = IntegerParser.parseHex(str, 1, str.length());
            if (parseHex != null) {
                int endPos = parseHex.getEndPos();
                if (endPos == 4) {
                    int value = parseHex.value();
                    int i2 = value & 3840;
                    int i3 = value & PsExtractor.VIDEO_STREAM_MASK;
                    int i4 = value & 15;
                    return new SVG.Colour(i4 | (i2 << 8) | -16777216 | (i2 << 12) | (i3 << 8) | (i3 << 4) | (i4 << 4));
                } else if (endPos == 5) {
                    int value2 = parseHex.value();
                    int i5 = 61440 & value2;
                    int i6 = value2 & 3840;
                    int i7 = value2 & PsExtractor.VIDEO_STREAM_MASK;
                    int i8 = value2 & 15;
                    return new SVG.Colour((i8 << 24) | (i8 << 28) | (i5 << 8) | (i5 << 4) | (i6 << 4) | i6 | i7 | (i7 >> 4));
                } else if (endPos == 7) {
                    return new SVG.Colour(parseHex.value() | ViewCompat.MEASURED_STATE_MASK);
                } else {
                    if (endPos == 9) {
                        return new SVG.Colour((parseHex.value() >>> 8) | (parseHex.value() << 24));
                    }
                    throw new SVGParseException("Bad hex colour value: " + str);
                }
            } else {
                throw new SVGParseException("Bad hex colour value: " + str);
            }
        } else {
            String lowerCase = str.toLowerCase(Locale.US);
            boolean startsWith = lowerCase.startsWith("rgba(");
            if (startsWith || lowerCase.startsWith("rgb(")) {
                if (!startsWith) {
                    i = 4;
                }
                TextScanner textScanner = new TextScanner(str.substring(i));
                textScanner.skipWhitespace();
                float nextFloat = textScanner.nextFloat();
                if (!Float.isNaN(nextFloat) && textScanner.consume('%')) {
                    nextFloat = (nextFloat * 256.0f) / 100.0f;
                }
                float checkedNextFloat = textScanner.checkedNextFloat(nextFloat);
                if (!Float.isNaN(checkedNextFloat) && textScanner.consume('%')) {
                    checkedNextFloat = (checkedNextFloat * 256.0f) / 100.0f;
                }
                float checkedNextFloat2 = textScanner.checkedNextFloat(checkedNextFloat);
                if (!Float.isNaN(checkedNextFloat2) && textScanner.consume('%')) {
                    checkedNextFloat2 = (checkedNextFloat2 * 256.0f) / 100.0f;
                }
                if (startsWith) {
                    float checkedNextFloat3 = textScanner.checkedNextFloat(checkedNextFloat2);
                    textScanner.skipWhitespace();
                    if (!Float.isNaN(checkedNextFloat3) && textScanner.consume(')')) {
                        return new SVG.Colour((clamp255(checkedNextFloat3 * 256.0f) << 24) | (clamp255(nextFloat) << 16) | (clamp255(checkedNextFloat) << 8) | clamp255(checkedNextFloat2));
                    }
                    throw new SVGParseException("Bad rgba() colour value: " + str);
                }
                textScanner.skipWhitespace();
                if (!Float.isNaN(checkedNextFloat2) && textScanner.consume(')')) {
                    return new SVG.Colour((clamp255(nextFloat) << 16) | ViewCompat.MEASURED_STATE_MASK | (clamp255(checkedNextFloat) << 8) | clamp255(checkedNextFloat2));
                }
                throw new SVGParseException("Bad rgb() colour value: " + str);
            }
            boolean startsWith2 = lowerCase.startsWith("hsla(");
            if (!startsWith2 && !lowerCase.startsWith("hsl(")) {
                return parseColourKeyword(lowerCase);
            }
            if (!startsWith2) {
                i = 4;
            }
            TextScanner textScanner2 = new TextScanner(str.substring(i));
            textScanner2.skipWhitespace();
            float nextFloat2 = textScanner2.nextFloat();
            float checkedNextFloat4 = textScanner2.checkedNextFloat(nextFloat2);
            if (!Float.isNaN(checkedNextFloat4)) {
                textScanner2.consume('%');
            }
            float checkedNextFloat5 = textScanner2.checkedNextFloat(checkedNextFloat4);
            if (!Float.isNaN(checkedNextFloat5)) {
                textScanner2.consume('%');
            }
            if (startsWith2) {
                float checkedNextFloat6 = textScanner2.checkedNextFloat(checkedNextFloat5);
                textScanner2.skipWhitespace();
                if (!Float.isNaN(checkedNextFloat6) && textScanner2.consume(')')) {
                    return new SVG.Colour((clamp255(checkedNextFloat6 * 256.0f) << 24) | hslToRgb(nextFloat2, checkedNextFloat4, checkedNextFloat5));
                }
                throw new SVGParseException("Bad hsla() colour value: " + str);
            }
            textScanner2.skipWhitespace();
            if (!Float.isNaN(checkedNextFloat5) && textScanner2.consume(')')) {
                return new SVG.Colour(hslToRgb(nextFloat2, checkedNextFloat4, checkedNextFloat5) | ViewCompat.MEASURED_STATE_MASK);
            }
            throw new SVGParseException("Bad hsl() colour value: " + str);
        }
    }

    private static int clamp255(float f) {
        if (f < 0.0f) {
            return 0;
        }
        if (f > 255.0f) {
            return 255;
        }
        return Math.round(f);
    }

    private static int hslToRgb(float f, float f2, float f3) {
        float f4 = 0.0f;
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        float f5 = f % 360.0f;
        if (i < 0) {
            f5 += 360.0f;
        }
        float f6 = f5 / 60.0f;
        float f7 = f2 / 100.0f;
        float f8 = f3 / 100.0f;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        } else if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        if (f8 >= 0.0f) {
            f4 = f8 > 1.0f ? 1.0f : f8;
        }
        float f9 = f4 <= 0.5f ? (f7 + 1.0f) * f4 : (f4 + f7) - (f7 * f4);
        float f10 = (f4 * 2.0f) - f9;
        return clamp255(hueToRgb(f10, f9, f6 - 2.0f) * 256.0f) | (clamp255(hueToRgb(f10, f9, f6 + 2.0f) * 256.0f) << 16) | (clamp255(hueToRgb(f10, f9, f6) * 256.0f) << 8);
    }

    private static SVG.Colour parseColourKeyword(String str) throws SVGParseException {
        Integer num = ColourKeywords.get(str);
        if (num != null) {
            return new SVG.Colour(num.intValue());
        }
        throw new SVGParseException("Invalid colour keyword: " + str);
    }

    private static void parseFont(SVG.Style style, String str) {
        String nextToken;
        int i;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".contains('|' + str + '|')) {
            TextScanner textScanner = new TextScanner(str);
            Integer num = null;
            SVG.Style.FontStyle fontStyle = null;
            String str2 = null;
            while (true) {
                nextToken = textScanner.nextToken(IOUtils.DIR_SEPARATOR_UNIX);
                textScanner.skipWhitespace();
                if (nextToken != null) {
                    if (num == null || fontStyle == null) {
                        if (!nextToken.equals(ProfilingTraceData.TRUNCATION_REASON_NORMAL) && ((num != null || (num = FontWeightKeywords.get(nextToken)) == null) && (fontStyle != null || (fontStyle = parseFontStyle(nextToken)) == null))) {
                            if (str2 != null || !nextToken.equals("small-caps")) {
                                break;
                            }
                            str2 = nextToken;
                        }
                    } else {
                        break;
                    }
                } else {
                    return;
                }
            }
            SVG.Length parseFontSize = parseFontSize(nextToken);
            if (textScanner.consume((char) IOUtils.DIR_SEPARATOR_UNIX)) {
                textScanner.skipWhitespace();
                String nextToken2 = textScanner.nextToken();
                if (nextToken2 != null) {
                    try {
                        parseLength(nextToken2);
                    } catch (SVGParseException unused) {
                        return;
                    }
                }
                textScanner.skipWhitespace();
            }
            style.fontFamily = parseFontFamily(textScanner.restOfText());
            style.fontSize = parseFontSize;
            if (num == null) {
                i = 400;
            } else {
                i = num.intValue();
            }
            style.fontWeight = Integer.valueOf(i);
            if (fontStyle == null) {
                fontStyle = SVG.Style.FontStyle.Normal;
            }
            style.fontStyle = fontStyle;
            style.specifiedFlags |= 122880;
        }
    }

    private static List<String> parseFontFamily(String str) {
        TextScanner textScanner = new TextScanner(str);
        ArrayList arrayList = null;
        do {
            String nextQuotedString = textScanner.nextQuotedString();
            if (nextQuotedString == null) {
                nextQuotedString = textScanner.nextTokenWithWhitespace(',');
            }
            if (nextQuotedString == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(nextQuotedString);
            textScanner.skipCommaWhitespace();
        } while (!textScanner.empty());
        return arrayList;
    }

    private static SVG.Length parseFontSize(String str) {
        try {
            SVG.Length length = FontSizeKeywords.get(str);
            return length == null ? parseLength(str) : length;
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private static Integer parseFontWeight(String str) {
        return FontWeightKeywords.get(str);
    }

    private static SVG.Style.FontStyle parseFontStyle(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1657669071:
                if (str.equals("oblique")) {
                    c = 0;
                    break;
                }
                break;
            case -1178781136:
                if (str.equals(TtmlNode.ITALIC)) {
                    c = 1;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals(ProfilingTraceData.TRUNCATION_REASON_NORMAL)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return SVG.Style.FontStyle.Oblique;
            case 1:
                return SVG.Style.FontStyle.Italic;
            case 2:
                return SVG.Style.FontStyle.Normal;
            default:
                return null;
        }
    }

    private static SVG.Style.TextDecoration parseTextDecoration(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1171789332:
                if (str.equals("line-through")) {
                    c = 0;
                    break;
                }
                break;
            case -1026963764:
                if (str.equals(TtmlNode.UNDERLINE)) {
                    c = 1;
                    break;
                }
                break;
            case 3387192:
                if (str.equals("none")) {
                    c = 2;
                    break;
                }
                break;
            case 93826908:
                if (str.equals("blink")) {
                    c = 3;
                    break;
                }
                break;
            case 529818312:
                if (str.equals("overline")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return SVG.Style.TextDecoration.LineThrough;
            case 1:
                return SVG.Style.TextDecoration.Underline;
            case 2:
                return SVG.Style.TextDecoration.None;
            case 3:
                return SVG.Style.TextDecoration.Blink;
            case 4:
                return SVG.Style.TextDecoration.Overline;
            default:
                return null;
        }
    }

    private static SVG.Style.TextDirection parseTextDirection(String str) {
        str.hashCode();
        if (str.equals("ltr")) {
            return SVG.Style.TextDirection.LTR;
        }
        if (!str.equals("rtl")) {
            return null;
        }
        return SVG.Style.TextDirection.RTL;
    }

    private static SVG.Style.FillRule parseFillRule(String str) {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        return null;
    }

    private static SVG.Style.LineCap parseStrokeLineCap(String str) {
        if ("butt".equals(str)) {
            return SVG.Style.LineCap.Butt;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineCap.Round;
        }
        if ("square".equals(str)) {
            return SVG.Style.LineCap.Square;
        }
        return null;
    }

    private static SVG.Style.LineJoin parseStrokeLineJoin(String str) {
        if ("miter".equals(str)) {
            return SVG.Style.LineJoin.Miter;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineJoin.Round;
        }
        if ("bevel".equals(str)) {
            return SVG.Style.LineJoin.Bevel;
        }
        return null;
    }

    private static SVG.Length[] parseStrokeDashArray(String str) {
        SVG.Length nextLength;
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        if (textScanner.empty() || (nextLength = textScanner.nextLength()) == null || nextLength.isNegative()) {
            return null;
        }
        float floatValue = nextLength.floatValue();
        ArrayList arrayList = new ArrayList();
        arrayList.add(nextLength);
        while (!textScanner.empty()) {
            textScanner.skipCommaWhitespace();
            SVG.Length nextLength2 = textScanner.nextLength();
            if (nextLength2 == null || nextLength2.isNegative()) {
                return null;
            }
            arrayList.add(nextLength2);
            floatValue += nextLength2.floatValue();
        }
        if (floatValue == 0.0f) {
            return null;
        }
        return (SVG.Length[]) arrayList.toArray(new SVG.Length[arrayList.size()]);
    }

    private static SVG.Style.TextAnchor parseTextAnchor(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1074341483:
                if (str.equals("middle")) {
                    c = 0;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return SVG.Style.TextAnchor.Middle;
            case 1:
                return SVG.Style.TextAnchor.End;
            case 2:
                return SVG.Style.TextAnchor.Start;
            default:
                return null;
        }
    }

    private static Boolean parseOverflow(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1217487446:
                if (str.equals(ViewProps.HIDDEN)) {
                    c = 0;
                    break;
                }
                break;
            case -907680051:
                if (str.equals(ViewProps.SCROLL)) {
                    c = 1;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c = 2;
                    break;
                }
                break;
            case 466743410:
                if (str.equals(ViewProps.VISIBLE)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return Boolean.FALSE;
            case 2:
            case 3:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    private static SVG.CSSClipRect parseClip(String str) {
        if ("auto".equals(str) || !str.startsWith("rect(")) {
            return null;
        }
        TextScanner textScanner = new TextScanner(str.substring(5));
        textScanner.skipWhitespace();
        SVG.Length parseLengthOrAuto = parseLengthOrAuto(textScanner);
        textScanner.skipCommaWhitespace();
        SVG.Length parseLengthOrAuto2 = parseLengthOrAuto(textScanner);
        textScanner.skipCommaWhitespace();
        SVG.Length parseLengthOrAuto3 = parseLengthOrAuto(textScanner);
        textScanner.skipCommaWhitespace();
        SVG.Length parseLengthOrAuto4 = parseLengthOrAuto(textScanner);
        textScanner.skipWhitespace();
        if (textScanner.consume(')') || textScanner.empty()) {
            return new SVG.CSSClipRect(parseLengthOrAuto, parseLengthOrAuto2, parseLengthOrAuto3, parseLengthOrAuto4);
        }
        return null;
    }

    private static SVG.Length parseLengthOrAuto(TextScanner textScanner) {
        if (textScanner.consume("auto")) {
            return new SVG.Length(0.0f);
        }
        return textScanner.nextLength();
    }

    private static SVG.Style.VectorEffect parseVectorEffect(String str) {
        str.hashCode();
        if (str.equals("none")) {
            return SVG.Style.VectorEffect.None;
        }
        if (!str.equals("non-scaling-stroke")) {
            return null;
        }
        return SVG.Style.VectorEffect.NonScalingStroke;
    }

    private static SVG.Style.RenderQuality parseRenderQuality(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -933002398:
                if (str.equals("optimizeQuality")) {
                    c = 0;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c = 1;
                    break;
                }
                break;
            case 362741610:
                if (str.equals("optimizeSpeed")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return SVG.Style.RenderQuality.optimizeQuality;
            case 1:
                return SVG.Style.RenderQuality.auto;
            case 2:
                return SVG.Style.RenderQuality.optimizeSpeed;
            default:
                return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0233, code lost:
        r2 = r8;
        r1 = r11;
        r4 = r15;
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x028a, code lost:
        r0.skipCommaWhitespace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0291, code lost:
        if (r0.empty() == false) goto L_0x0294;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0293, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0298, code lost:
        if (r0.hasLetter() == false) goto L_0x02a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x029a, code lost:
        r12 = r0.nextChar().intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.caverock.androidsvg.SVG.PathDefinition parsePath(java.lang.String r20) {
        /*
            com.caverock.androidsvg.SVGParser$TextScanner r0 = new com.caverock.androidsvg.SVGParser$TextScanner
            r1 = r20
            r0.<init>(r1)
            com.caverock.androidsvg.SVG$PathDefinition r9 = new com.caverock.androidsvg.SVG$PathDefinition
            r9.<init>()
            boolean r1 = r0.empty()
            if (r1 == 0) goto L_0x0013
            return r9
        L_0x0013:
            java.lang.Integer r1 = r0.nextChar()
            int r1 = r1.intValue()
            r2 = 77
            r10 = 109(0x6d, float:1.53E-43)
            if (r1 == r2) goto L_0x0024
            if (r1 == r10) goto L_0x0024
            return r9
        L_0x0024:
            r12 = r1
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r13 = 0
            r14 = 0
        L_0x002b:
            r0.skipWhitespace()
            r5 = 108(0x6c, float:1.51E-43)
            r6 = 1073741824(0x40000000, float:2.0)
            java.lang.String r7 = " path segment"
            java.lang.String r8 = "Bad path coords for "
            java.lang.String r15 = "SVGParser"
            switch(r12) {
                case 65: goto L_0x023a;
                case 67: goto L_0x01e4;
                case 72: goto L_0x01b4;
                case 76: goto L_0x0180;
                case 77: goto L_0x013d;
                case 81: goto L_0x00fe;
                case 83: goto L_0x00b0;
                case 84: goto L_0x0075;
                case 86: goto L_0x0047;
                case 90: goto L_0x003c;
                case 97: goto L_0x023a;
                case 99: goto L_0x01e4;
                case 104: goto L_0x01b4;
                case 108: goto L_0x0180;
                case 109: goto L_0x013d;
                case 113: goto L_0x00fe;
                case 115: goto L_0x00b0;
                case 116: goto L_0x0075;
                case 118: goto L_0x0047;
                case 122: goto L_0x003c;
                default: goto L_0x003b;
            }
        L_0x003b:
            return r9
        L_0x003c:
            r9.close()
            r1 = r13
            r2 = r1
            r3 = r14
        L_0x0042:
            r4 = r3
        L_0x0043:
            r18 = 0
            goto L_0x028a
        L_0x0047:
            float r4 = r0.nextFloat()
            boolean r5 = java.lang.Float.isNaN(r4)
            if (r5 == 0) goto L_0x006b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r8)
            char r1 = (char) r12
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r15, r0)
            return r9
        L_0x006b:
            r5 = 118(0x76, float:1.65E-43)
            if (r12 != r5) goto L_0x0070
            float r4 = r4 + r3
        L_0x0070:
            r3 = r4
            r9.lineTo(r1, r3)
            goto L_0x0042
        L_0x0075:
            float r5 = r1 * r6
            float r2 = r5 - r2
            float r6 = r6 * r3
            float r4 = r6 - r4
            float r5 = r0.nextFloat()
            float r6 = r0.checkedNextFloat((float) r5)
            boolean r16 = java.lang.Float.isNaN(r6)
            if (r16 == 0) goto L_0x00a4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r8)
            char r1 = (char) r12
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r15, r0)
            return r9
        L_0x00a4:
            r7 = 116(0x74, float:1.63E-43)
            if (r12 != r7) goto L_0x00aa
            float r5 = r5 + r1
            float r6 = r6 + r3
        L_0x00aa:
            r1 = r5
            r3 = r6
            r9.quadTo(r2, r4, r1, r3)
            goto L_0x0043
        L_0x00b0:
            float r5 = r1 * r6
            float r2 = r5 - r2
            float r6 = r6 * r3
            float r4 = r6 - r4
            float r5 = r0.nextFloat()
            float r6 = r0.checkedNextFloat((float) r5)
            float r11 = r0.checkedNextFloat((float) r6)
            float r16 = r0.checkedNextFloat((float) r11)
            boolean r17 = java.lang.Float.isNaN(r16)
            if (r17 == 0) goto L_0x00e7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r8)
            char r1 = (char) r12
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r15, r0)
            return r9
        L_0x00e7:
            r7 = 115(0x73, float:1.61E-43)
            if (r12 != r7) goto L_0x00f0
            float r11 = r11 + r1
            float r16 = r16 + r3
            float r5 = r5 + r1
            float r6 = r6 + r3
        L_0x00f0:
            r8 = r5
            r15 = r6
            r1 = r9
            r3 = r4
            r4 = r8
            r5 = r15
            r6 = r11
            r7 = r16
            r1.cubicTo(r2, r3, r4, r5, r6, r7)
            goto L_0x0233
        L_0x00fe:
            float r2 = r0.nextFloat()
            float r4 = r0.checkedNextFloat((float) r2)
            float r5 = r0.checkedNextFloat((float) r4)
            float r6 = r0.checkedNextFloat((float) r5)
            boolean r11 = java.lang.Float.isNaN(r6)
            if (r11 == 0) goto L_0x012e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r8)
            char r1 = (char) r12
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r15, r0)
            return r9
        L_0x012e:
            r7 = 113(0x71, float:1.58E-43)
            if (r12 != r7) goto L_0x0136
            float r5 = r5 + r1
            float r6 = r6 + r3
            float r2 = r2 + r1
            float r4 = r4 + r3
        L_0x0136:
            r1 = r5
            r3 = r6
            r9.quadTo(r2, r4, r1, r3)
            goto L_0x0043
        L_0x013d:
            float r2 = r0.nextFloat()
            float r4 = r0.checkedNextFloat((float) r2)
            boolean r6 = java.lang.Float.isNaN(r4)
            if (r6 == 0) goto L_0x0165
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r8)
            char r1 = (char) r12
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r15, r0)
            return r9
        L_0x0165:
            if (r12 != r10) goto L_0x016f
            boolean r6 = r9.isEmpty()
            if (r6 != 0) goto L_0x016f
            float r2 = r2 + r1
            float r4 = r4 + r3
        L_0x016f:
            r1 = r2
            r3 = r4
            r9.moveTo(r1, r3)
            if (r12 != r10) goto L_0x0177
            goto L_0x0179
        L_0x0177:
            r5 = 76
        L_0x0179:
            r2 = r1
            r13 = r2
            r4 = r3
            r14 = r4
            r12 = r5
            goto L_0x0043
        L_0x0180:
            float r2 = r0.nextFloat()
            float r4 = r0.checkedNextFloat((float) r2)
            boolean r6 = java.lang.Float.isNaN(r4)
            if (r6 == 0) goto L_0x01a8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r8)
            char r1 = (char) r12
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r15, r0)
            return r9
        L_0x01a8:
            if (r12 != r5) goto L_0x01ac
            float r2 = r2 + r1
            float r4 = r4 + r3
        L_0x01ac:
            r1 = r2
            r3 = r4
            r9.lineTo(r1, r3)
            r2 = r1
            goto L_0x0042
        L_0x01b4:
            float r2 = r0.nextFloat()
            boolean r5 = java.lang.Float.isNaN(r2)
            if (r5 == 0) goto L_0x01d8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r8)
            char r1 = (char) r12
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r15, r0)
            return r9
        L_0x01d8:
            r5 = 104(0x68, float:1.46E-43)
            if (r12 != r5) goto L_0x01dd
            float r2 = r2 + r1
        L_0x01dd:
            r1 = r2
            r9.lineTo(r1, r3)
            r2 = r1
            goto L_0x0043
        L_0x01e4:
            float r2 = r0.nextFloat()
            float r4 = r0.checkedNextFloat((float) r2)
            float r5 = r0.checkedNextFloat((float) r4)
            float r6 = r0.checkedNextFloat((float) r5)
            float r11 = r0.checkedNextFloat((float) r6)
            float r16 = r0.checkedNextFloat((float) r11)
            boolean r17 = java.lang.Float.isNaN(r16)
            if (r17 == 0) goto L_0x021c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r8)
            char r1 = (char) r12
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r15, r0)
            return r9
        L_0x021c:
            r7 = 99
            if (r12 != r7) goto L_0x0227
            float r11 = r11 + r1
            float r16 = r16 + r3
            float r2 = r2 + r1
            float r4 = r4 + r3
            float r5 = r5 + r1
            float r6 = r6 + r3
        L_0x0227:
            r3 = r4
            r8 = r5
            r15 = r6
            r1 = r9
            r4 = r8
            r5 = r15
            r6 = r11
            r7 = r16
            r1.cubicTo(r2, r3, r4, r5, r6, r7)
        L_0x0233:
            r2 = r8
            r1 = r11
            r4 = r15
            r3 = r16
            goto L_0x0043
        L_0x023a:
            float r2 = r0.nextFloat()
            float r4 = r0.checkedNextFloat((float) r2)
            float r5 = r0.checkedNextFloat((float) r4)
            java.lang.Float r6 = java.lang.Float.valueOf(r5)
            java.lang.Boolean r6 = r0.checkedNextFlag(r6)
            java.lang.Boolean r11 = r0.checkedNextFlag(r6)
            float r10 = r0.checkedNextFloat((java.lang.Boolean) r11)
            float r17 = r0.checkedNextFloat((float) r10)
            boolean r18 = java.lang.Float.isNaN(r17)
            if (r18 != 0) goto L_0x02a6
            r18 = 0
            int r19 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r19 < 0) goto L_0x02a6
            int r19 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r19 >= 0) goto L_0x026b
            goto L_0x02a6
        L_0x026b:
            r7 = 97
            if (r12 != r7) goto L_0x0272
            float r10 = r10 + r1
            float r17 = r17 + r3
        L_0x0272:
            boolean r6 = r6.booleanValue()
            boolean r7 = r11.booleanValue()
            r1 = r9
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r10
            r8 = r17
            r1.arcTo(r2, r3, r4, r5, r6, r7, r8)
            r1 = r10
            r2 = r1
            r3 = r17
            r4 = r3
        L_0x028a:
            r0.skipCommaWhitespace()
            boolean r5 = r0.empty()
            if (r5 == 0) goto L_0x0294
            return r9
        L_0x0294:
            boolean r5 = r0.hasLetter()
            if (r5 == 0) goto L_0x02a2
            java.lang.Integer r5 = r0.nextChar()
            int r12 = r5.intValue()
        L_0x02a2:
            r10 = 109(0x6d, float:1.53E-43)
            goto L_0x002b
        L_0x02a6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r8)
            char r1 = (char) r12
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r15, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.parsePath(java.lang.String):com.caverock.androidsvg.SVG$PathDefinition");
    }

    private static Set<String> parseRequiredFeatures(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            String nextToken = textScanner.nextToken();
            if (nextToken.startsWith(FEATURE_STRING_PREFIX)) {
                hashSet.add(nextToken.substring(35));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static Set<String> parseSystemLanguage(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            String nextToken = textScanner.nextToken();
            int indexOf = nextToken.indexOf(45);
            if (indexOf != -1) {
                nextToken = nextToken.substring(0, indexOf);
            }
            hashSet.add(new Locale(nextToken, "", "").getLanguage());
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static Set<String> parseRequiredFormats(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            hashSet.add(textScanner.nextToken());
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static String parseFunctionalIRI(String str, String str2) {
        if (str.equals("none") || !str.startsWith("url(")) {
            return null;
        }
        if (str.endsWith(")")) {
            return str.substring(4, str.length() - 1).trim();
        }
        return str.substring(4).trim();
    }

    private void style(Attributes attributes) throws SVGParseException {
        debug("<style>", new Object[0]);
        if (this.currentElement != null) {
            String str = "all";
            boolean z = true;
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i2 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 == 88) {
                    z = trim.equals("text/css");
                } else if (i2 == 89) {
                    str = trim;
                }
            }
            if (!z || !CSSParser.mediaMatches(str, CSSParser.MediaType.screen)) {
                this.ignoring = true;
                this.ignoreDepth = 1;
                return;
            }
            this.inStyleElement = true;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void parseCSSStyleSheet(String str) {
        this.svgDocument.addCSSRules(new CSSParser(CSSParser.MediaType.screen, CSSParser.Source.Document).parse(str));
    }
}
