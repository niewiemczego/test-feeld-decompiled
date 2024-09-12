package com.horcrux.svg;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.horcrux.svg.TextProperties;

class FontData {
    static final double DEFAULT_FONT_SIZE = 12.0d;
    private static final double DEFAULT_KERNING = 0.0d;
    private static final double DEFAULT_LETTER_SPACING = 0.0d;
    private static final double DEFAULT_WORD_SPACING = 0.0d;
    static final FontData Defaults = new FontData();
    private static final String FONT_DATA = "fontData";
    private static final String FONT_FEATURE_SETTINGS = "fontFeatureSettings";
    private static final String FONT_VARIANT_LIGATURES = "fontVariantLigatures";
    private static final String FONT_VARIATION_SETTINGS = "fontVariationSettings";
    private static final String KERNING = "kerning";
    private static final String LETTER_SPACING = "letterSpacing";
    private static final String TEXT_ANCHOR = "textAnchor";
    private static final String TEXT_DECORATION = "textDecoration";
    private static final String WORD_SPACING = "wordSpacing";
    int absoluteFontWeight;
    final ReadableMap fontData;
    final String fontFamily;
    final String fontFeatureSettings;
    final double fontSize;
    final TextProperties.FontStyle fontStyle;
    final TextProperties.FontVariantLigatures fontVariantLigatures;
    final String fontVariationSettings;
    TextProperties.FontWeight fontWeight;
    final double kerning;
    final double letterSpacing;
    final boolean manualKerning;
    final TextProperties.TextAnchor textAnchor;
    private final TextProperties.TextDecoration textDecoration;
    final double wordSpacing;

    static class AbsoluteFontWeight {
        private static final TextProperties.FontWeight[] WEIGHTS = {TextProperties.FontWeight.w100, TextProperties.FontWeight.w100, TextProperties.FontWeight.w200, TextProperties.FontWeight.w300, TextProperties.FontWeight.Normal, TextProperties.FontWeight.w500, TextProperties.FontWeight.w600, TextProperties.FontWeight.Bold, TextProperties.FontWeight.w800, TextProperties.FontWeight.w900, TextProperties.FontWeight.w900};
        private static final int[] absoluteFontWeights = {400, TypefaceStyle.BOLD, 100, 200, 300, 400, 500, 600, TypefaceStyle.BOLD, 800, 900};
        static final int normal = 400;

        private static int bolder(int i) {
            if (i < 350) {
                return 400;
            }
            if (i < 550) {
                return TypefaceStyle.BOLD;
            }
            if (i < 900) {
                return 900;
            }
            return i;
        }

        private static int lighter(int i) {
            if (i < 100) {
                return i;
            }
            if (i < 550) {
                return 100;
            }
            if (i < 750) {
                return 400;
            }
            return TypefaceStyle.BOLD;
        }

        AbsoluteFontWeight() {
        }

        static TextProperties.FontWeight nearestFontWeight(int i) {
            return WEIGHTS[Math.round(((float) i) / 100.0f)];
        }

        static int from(TextProperties.FontWeight fontWeight, FontData fontData) {
            if (fontWeight == TextProperties.FontWeight.Bolder) {
                return bolder(fontData.absoluteFontWeight);
            }
            if (fontWeight == TextProperties.FontWeight.Lighter) {
                return lighter(fontData.absoluteFontWeight);
            }
            return absoluteFontWeights[fontWeight.ordinal()];
        }
    }

    private FontData() {
        this.fontData = null;
        this.fontFamily = "";
        this.fontStyle = TextProperties.FontStyle.normal;
        this.fontWeight = TextProperties.FontWeight.Normal;
        this.absoluteFontWeight = 400;
        this.fontFeatureSettings = "";
        this.fontVariationSettings = "";
        this.fontVariantLigatures = TextProperties.FontVariantLigatures.normal;
        this.textAnchor = TextProperties.TextAnchor.start;
        this.textDecoration = TextProperties.TextDecoration.None;
        this.manualKerning = false;
        this.kerning = 0.0d;
        this.fontSize = DEFAULT_FONT_SIZE;
        this.wordSpacing = 0.0d;
        this.letterSpacing = 0.0d;
    }

    private double toAbsolute(ReadableMap readableMap, String str, double d, double d2, double d3) {
        if (readableMap.getType(str) == ReadableType.Number) {
            return readableMap.getDouble(str);
        }
        return PropHelper.fromRelative(readableMap.getString(str), d3, d, d2);
    }

    private void setInheritedWeight(FontData fontData2) {
        this.absoluteFontWeight = fontData2.absoluteFontWeight;
        this.fontWeight = fontData2.fontWeight;
    }

    private void handleNumericWeight(FontData fontData2, double d) {
        long round = Math.round(d);
        if (round < 1 || round > 1000) {
            setInheritedWeight(fontData2);
            return;
        }
        int i = (int) round;
        this.absoluteFontWeight = i;
        this.fontWeight = AbsoluteFontWeight.nearestFontWeight(i);
    }

    FontData(ReadableMap readableMap, FontData fontData2, double d) {
        String str;
        String str2;
        TextProperties.FontVariantLigatures fontVariantLigatures2;
        TextProperties.TextAnchor textAnchor2;
        TextProperties.TextDecoration textDecoration2;
        double d2;
        double d3;
        double d4 = fontData2.fontSize;
        if (readableMap.hasKey("fontSize")) {
            this.fontSize = toAbsolute(readableMap, "fontSize", 1.0d, d4, d4);
        } else {
            this.fontSize = d4;
        }
        if (!readableMap.hasKey("fontWeight")) {
            setInheritedWeight(fontData2);
        } else if (readableMap.getType("fontWeight") == ReadableType.Number) {
            handleNumericWeight(fontData2, readableMap.getDouble("fontWeight"));
        } else {
            String string = readableMap.getString("fontWeight");
            if (TextProperties.FontWeight.hasEnum(string)) {
                int from = AbsoluteFontWeight.from(TextProperties.FontWeight.get(string), fontData2);
                this.absoluteFontWeight = from;
                this.fontWeight = AbsoluteFontWeight.nearestFontWeight(from);
            } else if (string != null) {
                handleNumericWeight(fontData2, Double.parseDouble(string));
            } else {
                setInheritedWeight(fontData2);
            }
        }
        this.fontData = readableMap.hasKey(FONT_DATA) ? readableMap.getMap(FONT_DATA) : fontData2.fontData;
        this.fontFamily = readableMap.hasKey("fontFamily") ? readableMap.getString("fontFamily") : fontData2.fontFamily;
        this.fontStyle = readableMap.hasKey("fontStyle") ? TextProperties.FontStyle.valueOf(readableMap.getString("fontStyle")) : fontData2.fontStyle;
        if (readableMap.hasKey(FONT_FEATURE_SETTINGS)) {
            str = readableMap.getString(FONT_FEATURE_SETTINGS);
        } else {
            str = fontData2.fontFeatureSettings;
        }
        this.fontFeatureSettings = str;
        if (readableMap.hasKey(FONT_VARIATION_SETTINGS)) {
            str2 = readableMap.getString(FONT_VARIATION_SETTINGS);
        } else {
            str2 = fontData2.fontVariationSettings;
        }
        this.fontVariationSettings = str2;
        if (readableMap.hasKey(FONT_VARIANT_LIGATURES)) {
            fontVariantLigatures2 = TextProperties.FontVariantLigatures.valueOf(readableMap.getString(FONT_VARIANT_LIGATURES));
        } else {
            fontVariantLigatures2 = fontData2.fontVariantLigatures;
        }
        this.fontVariantLigatures = fontVariantLigatures2;
        if (readableMap.hasKey(TEXT_ANCHOR)) {
            textAnchor2 = TextProperties.TextAnchor.valueOf(readableMap.getString(TEXT_ANCHOR));
        } else {
            textAnchor2 = fontData2.textAnchor;
        }
        this.textAnchor = textAnchor2;
        if (readableMap.hasKey("textDecoration")) {
            textDecoration2 = TextProperties.TextDecoration.getEnum(readableMap.getString("textDecoration"));
        } else {
            textDecoration2 = fontData2.textDecoration;
        }
        this.textDecoration = textDecoration2;
        boolean hasKey = readableMap.hasKey(KERNING);
        this.manualKerning = hasKey || fontData2.manualKerning;
        this.kerning = hasKey ? toAbsolute(readableMap, KERNING, d, this.fontSize, 0.0d) : fontData2.kerning;
        if (readableMap.hasKey(WORD_SPACING)) {
            d2 = toAbsolute(readableMap, WORD_SPACING, d, this.fontSize, 0.0d);
        } else {
            d2 = fontData2.wordSpacing;
        }
        this.wordSpacing = d2;
        if (readableMap.hasKey("letterSpacing")) {
            d3 = toAbsolute(readableMap, "letterSpacing", d, this.fontSize, 0.0d);
        } else {
            d3 = fontData2.letterSpacing;
        }
        this.letterSpacing = d3;
    }
}
