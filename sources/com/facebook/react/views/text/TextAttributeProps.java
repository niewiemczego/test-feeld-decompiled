package com.facebook.react.views.text;

import android.os.Build;
import android.text.TextUtils;
import androidx.room.FtsOptions;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.ProfilingTraceData;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.CharUtils;

public class TextAttributeProps {
    private static final int DEFAULT_BREAK_STRATEGY = (Build.VERSION.SDK_INT < 23 ? 0 : 1);
    private static final int DEFAULT_HYPHENATION_FREQUENCY = 0;
    private static final int DEFAULT_JUSTIFICATION_MODE = 0;
    private static final int DEFAULT_TEXT_SHADOW_COLOR = 1426063360;
    private static final String PROP_SHADOW_COLOR = "textShadowColor";
    private static final String PROP_SHADOW_OFFSET = "textShadowOffset";
    private static final String PROP_SHADOW_OFFSET_HEIGHT = "height";
    private static final String PROP_SHADOW_OFFSET_WIDTH = "width";
    private static final String PROP_SHADOW_RADIUS = "textShadowRadius";
    private static final String PROP_TEXT_TRANSFORM = "textTransform";
    public static final short TA_KEY_ACCESSIBILITY_ROLE = 22;
    public static final short TA_KEY_ALIGNMENT = 12;
    public static final short TA_KEY_ALLOW_FONT_SCALING = 9;
    public static final short TA_KEY_BACKGROUND_COLOR = 1;
    public static final short TA_KEY_BEST_WRITING_DIRECTION = 13;
    public static final short TA_KEY_FONT_FAMILY = 3;
    public static final short TA_KEY_FONT_SIZE = 4;
    public static final short TA_KEY_FONT_SIZE_MULTIPLIER = 5;
    public static final short TA_KEY_FONT_STYLE = 7;
    public static final short TA_KEY_FONT_VARIANT = 8;
    public static final short TA_KEY_FONT_WEIGHT = 6;
    public static final short TA_KEY_FOREGROUND_COLOR = 0;
    public static final short TA_KEY_IS_HIGHLIGHTED = 20;
    public static final short TA_KEY_LAYOUT_DIRECTION = 21;
    public static final short TA_KEY_LETTER_SPACING = 10;
    public static final short TA_KEY_LINE_HEIGHT = 11;
    public static final short TA_KEY_OPACITY = 2;
    public static final short TA_KEY_TEXT_DECORATION_COLOR = 14;
    public static final short TA_KEY_TEXT_DECORATION_LINE = 15;
    public static final short TA_KEY_TEXT_DECORATION_STYLE = 16;
    public static final short TA_KEY_TEXT_SHADOW_COLOR = 19;
    public static final short TA_KEY_TEXT_SHADOW_RADIUS = 18;
    public static final int UNSET = -1;
    protected ReactAccessibilityDelegate.AccessibilityRole mAccessibilityRole = null;
    protected boolean mAllowFontScaling = true;
    protected int mBackgroundColor;
    protected int mColor;
    protected boolean mContainsImages = false;
    protected String mFontFamily = null;
    protected String mFontFeatureSettings = null;
    protected int mFontSize = -1;
    protected float mFontSizeInput = -1.0f;
    protected int mFontStyle = -1;
    protected int mFontWeight = -1;
    protected float mHeightOfTallestInlineImage = Float.NaN;
    protected boolean mIncludeFontPadding = true;
    protected boolean mIsAccessibilityLink = false;
    protected boolean mIsAccessibilityRoleSet = false;
    protected boolean mIsBackgroundColorSet = false;
    protected boolean mIsColorSet = false;
    protected boolean mIsLineThroughTextDecorationSet = false;
    protected boolean mIsUnderlineTextDecorationSet = false;
    protected int mLayoutDirection = -1;
    protected float mLetterSpacingInput = Float.NaN;
    protected float mLineHeight = Float.NaN;
    protected float mLineHeightInput = -1.0f;
    protected int mNumberOfLines = -1;
    protected int mTextAlign = 0;
    protected int mTextShadowColor = 1426063360;
    protected float mTextShadowOffsetDx = 0.0f;
    protected float mTextShadowOffsetDy = 0.0f;
    protected float mTextShadowRadius = 1.0f;
    protected TextTransform mTextTransform = TextTransform.NONE;

    static {
        int i = Build.VERSION.SDK_INT;
        int i2 = Build.VERSION.SDK_INT;
    }

    private TextAttributeProps() {
    }

    public static TextAttributeProps fromMapBuffer(MapBuffer mapBuffer) {
        TextAttributeProps textAttributeProps = new TextAttributeProps();
        Iterator it = mapBuffer.iterator();
        while (it.hasNext()) {
            MapBuffer.Entry entry = (MapBuffer.Entry) it.next();
            int key = entry.getKey();
            if (key == 0) {
                textAttributeProps.setColor(Integer.valueOf(entry.getIntValue()));
            } else if (key == 1) {
                textAttributeProps.setBackgroundColor(Integer.valueOf(entry.getIntValue()));
            } else if (key == 3) {
                textAttributeProps.setFontFamily(entry.getStringValue());
            } else if (key == 4) {
                textAttributeProps.setFontSize((float) entry.getDoubleValue());
            } else if (key == 15) {
                textAttributeProps.setTextDecorationLine(entry.getStringValue());
            } else if (key == 18) {
                textAttributeProps.setTextShadowRadius((float) entry.getDoubleValue());
            } else if (key == 19) {
                textAttributeProps.setTextShadowColor(entry.getIntValue());
            } else if (key == 21) {
                textAttributeProps.setLayoutDirection(entry.getStringValue());
            } else if (key != 22) {
                switch (key) {
                    case 6:
                        textAttributeProps.setFontWeight(entry.getStringValue());
                        break;
                    case 7:
                        textAttributeProps.setFontStyle(entry.getStringValue());
                        break;
                    case 8:
                        textAttributeProps.setFontVariant(entry.getMapBufferValue());
                        break;
                    case 9:
                        textAttributeProps.setAllowFontScaling(entry.getBooleanValue());
                        break;
                    case 10:
                        textAttributeProps.setLetterSpacing((float) entry.getDoubleValue());
                        break;
                    case 11:
                        textAttributeProps.setLineHeight((float) entry.getDoubleValue());
                        break;
                }
            } else {
                textAttributeProps.setAccessibilityRole(entry.getStringValue());
            }
        }
        return textAttributeProps;
    }

    public static TextAttributeProps fromReadableMap(ReactStylesDiffMap reactStylesDiffMap) {
        TextAttributeProps textAttributeProps = new TextAttributeProps();
        textAttributeProps.setNumberOfLines(getIntProp(reactStylesDiffMap, ViewProps.NUMBER_OF_LINES, -1));
        textAttributeProps.setLineHeight(getFloatProp(reactStylesDiffMap, ViewProps.LINE_HEIGHT, -1.0f));
        textAttributeProps.setLetterSpacing(getFloatProp(reactStylesDiffMap, ViewProps.LETTER_SPACING, Float.NaN));
        textAttributeProps.setAllowFontScaling(getBooleanProp(reactStylesDiffMap, ViewProps.ALLOW_FONT_SCALING, true));
        textAttributeProps.setFontSize(getFloatProp(reactStylesDiffMap, "fontSize", -1.0f));
        ReadableMap readableMap = null;
        textAttributeProps.setColor(reactStylesDiffMap.hasKey("color") ? Integer.valueOf(reactStylesDiffMap.getInt("color", 0)) : null);
        textAttributeProps.setColor(reactStylesDiffMap.hasKey(ViewProps.FOREGROUND_COLOR) ? Integer.valueOf(reactStylesDiffMap.getInt(ViewProps.FOREGROUND_COLOR, 0)) : null);
        textAttributeProps.setBackgroundColor(reactStylesDiffMap.hasKey("backgroundColor") ? Integer.valueOf(reactStylesDiffMap.getInt("backgroundColor", 0)) : null);
        textAttributeProps.setFontFamily(getStringProp(reactStylesDiffMap, "fontFamily"));
        textAttributeProps.setFontWeight(getStringProp(reactStylesDiffMap, "fontWeight"));
        textAttributeProps.setFontStyle(getStringProp(reactStylesDiffMap, "fontStyle"));
        textAttributeProps.setFontVariant(getArrayProp(reactStylesDiffMap, ViewProps.FONT_VARIANT));
        textAttributeProps.setIncludeFontPadding(getBooleanProp(reactStylesDiffMap, ViewProps.INCLUDE_FONT_PADDING, true));
        textAttributeProps.setTextDecorationLine(getStringProp(reactStylesDiffMap, ViewProps.TEXT_DECORATION_LINE));
        if (reactStylesDiffMap.hasKey("textShadowOffset")) {
            readableMap = reactStylesDiffMap.getMap("textShadowOffset");
        }
        textAttributeProps.setTextShadowOffset(readableMap);
        textAttributeProps.setTextShadowRadius(getFloatProp(reactStylesDiffMap, "textShadowRadius", 1.0f));
        textAttributeProps.setTextShadowColor(getIntProp(reactStylesDiffMap, "textShadowColor", 1426063360));
        textAttributeProps.setTextTransform(getStringProp(reactStylesDiffMap, "textTransform"));
        textAttributeProps.setLayoutDirection(getStringProp(reactStylesDiffMap, ViewProps.LAYOUT_DIRECTION));
        textAttributeProps.setAccessibilityRole(getStringProp(reactStylesDiffMap, ViewProps.ACCESSIBILITY_ROLE));
        return textAttributeProps;
    }

    public static int getTextAlignment(ReactStylesDiffMap reactStylesDiffMap, boolean z, int i) {
        if (!reactStylesDiffMap.hasKey("textAlign")) {
            return i;
        }
        String string = reactStylesDiffMap.getString("textAlign");
        if ("justify".equals(string)) {
            return 3;
        }
        if (string == null || "auto".equals(string)) {
            return 0;
        }
        if ("left".equals(string)) {
            if (z) {
                return 5;
            }
            return 3;
        } else if ("right".equals(string)) {
            if (z) {
                return 3;
            }
            return 5;
        } else if (TtmlNode.CENTER.equals(string)) {
            return 1;
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + string);
        }
    }

    public static int getJustificationMode(ReactStylesDiffMap reactStylesDiffMap, int i) {
        if (!reactStylesDiffMap.hasKey("textAlign")) {
            return i;
        }
        if (!"justify".equals(reactStylesDiffMap.getString("textAlign")) || Build.VERSION.SDK_INT < 26) {
            return DEFAULT_JUSTIFICATION_MODE;
        }
        return 1;
    }

    private static boolean getBooleanProp(ReactStylesDiffMap reactStylesDiffMap, String str, boolean z) {
        return reactStylesDiffMap.hasKey(str) ? reactStylesDiffMap.getBoolean(str, z) : z;
    }

    private static String getStringProp(ReactStylesDiffMap reactStylesDiffMap, String str) {
        if (reactStylesDiffMap.hasKey(str)) {
            return reactStylesDiffMap.getString(str);
        }
        return null;
    }

    private static int getIntProp(ReactStylesDiffMap reactStylesDiffMap, String str, int i) {
        return reactStylesDiffMap.hasKey(str) ? reactStylesDiffMap.getInt(str, i) : i;
    }

    private static float getFloatProp(ReactStylesDiffMap reactStylesDiffMap, String str, float f) {
        return reactStylesDiffMap.hasKey(str) ? reactStylesDiffMap.getFloat(str, f) : f;
    }

    private static ReadableArray getArrayProp(ReactStylesDiffMap reactStylesDiffMap, String str) {
        if (reactStylesDiffMap.hasKey(str)) {
            return reactStylesDiffMap.getArray(str);
        }
        return null;
    }

    public float getEffectiveLineHeight() {
        return !Float.isNaN(this.mLineHeight) && !Float.isNaN(this.mHeightOfTallestInlineImage) && (this.mHeightOfTallestInlineImage > this.mLineHeight ? 1 : (this.mHeightOfTallestInlineImage == this.mLineHeight ? 0 : -1)) > 0 ? this.mHeightOfTallestInlineImage : this.mLineHeight;
    }

    private void setNumberOfLines(int i) {
        if (i == 0) {
            i = -1;
        }
        this.mNumberOfLines = i;
    }

    private void setLineHeight(float f) {
        float f2;
        this.mLineHeightInput = f;
        if (f == -1.0f) {
            this.mLineHeight = Float.NaN;
            return;
        }
        if (this.mAllowFontScaling) {
            f2 = PixelUtil.toPixelFromSP(f);
        } else {
            f2 = PixelUtil.toPixelFromDIP(f);
        }
        this.mLineHeight = f2;
    }

    private void setLetterSpacing(float f) {
        this.mLetterSpacingInput = f;
    }

    public float getLetterSpacing() {
        float f;
        if (this.mAllowFontScaling) {
            f = PixelUtil.toPixelFromSP(this.mLetterSpacingInput);
        } else {
            f = PixelUtil.toPixelFromDIP(this.mLetterSpacingInput);
        }
        int i = this.mFontSize;
        if (i > 0) {
            return f / ((float) i);
        }
        throw new IllegalArgumentException("FontSize should be a positive value. Current value: " + this.mFontSize);
    }

    private void setAllowFontScaling(boolean z) {
        if (z != this.mAllowFontScaling) {
            this.mAllowFontScaling = z;
            setFontSize(this.mFontSizeInput);
            setLineHeight(this.mLineHeightInput);
            setLetterSpacing(this.mLetterSpacingInput);
        }
    }

    private void setFontSize(float f) {
        double d;
        this.mFontSizeInput = f;
        if (f != -1.0f) {
            if (this.mAllowFontScaling) {
                d = Math.ceil((double) PixelUtil.toPixelFromSP(f));
            } else {
                d = Math.ceil((double) PixelUtil.toPixelFromDIP(f));
            }
            f = (float) d;
        }
        this.mFontSize = (int) f;
    }

    private void setColor(Integer num) {
        boolean z = num != null;
        this.mIsColorSet = z;
        if (z) {
            this.mColor = num.intValue();
        }
    }

    private void setBackgroundColor(Integer num) {
        boolean z = num != null;
        this.mIsBackgroundColorSet = z;
        if (z) {
            this.mBackgroundColor = num.intValue();
        }
    }

    private void setFontFamily(String str) {
        this.mFontFamily = str;
    }

    private void setFontVariant(ReadableArray readableArray) {
        this.mFontFeatureSettings = ReactTypefaceUtils.parseFontVariant(readableArray);
    }

    private void setFontVariant(MapBuffer mapBuffer) {
        if (mapBuffer == null || mapBuffer.getCount() == 0) {
            this.mFontFeatureSettings = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = mapBuffer.iterator();
        while (it.hasNext()) {
            String stringValue = ((MapBuffer.Entry) it.next()).getStringValue();
            if (stringValue != null) {
                stringValue.hashCode();
                char c = 65535;
                switch (stringValue.hashCode()) {
                    case -1983120972:
                        if (stringValue.equals("stylistic-thirteen")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1933522176:
                        if (stringValue.equals("stylistic-fifteen")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1534462052:
                        if (stringValue.equals("stylistic-eighteen")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1195362251:
                        if (stringValue.equals("proportional-nums")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1061392823:
                        if (stringValue.equals("lining-nums")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -771984547:
                        if (stringValue.equals("tabular-nums")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -659678800:
                        if (stringValue.equals("oldstyle-nums")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 296506098:
                        if (stringValue.equals("stylistic-eight")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 309330544:
                        if (stringValue.equals("stylistic-seven")) {
                            c = 8;
                            break;
                        }
                        break;
                    case 310339585:
                        if (stringValue.equals("stylistic-three")) {
                            c = 9;
                            break;
                        }
                        break;
                    case 604478526:
                        if (stringValue.equals("stylistic-eleven")) {
                            c = 10;
                            break;
                        }
                        break;
                    case 979426287:
                        if (stringValue.equals("stylistic-five")) {
                            c = 11;
                            break;
                        }
                        break;
                    case 979432035:
                        if (stringValue.equals("stylistic-four")) {
                            c = 12;
                            break;
                        }
                        break;
                    case 979664367:
                        if (stringValue.equals("stylistic-nine")) {
                            c = CharUtils.CR;
                            break;
                        }
                        break;
                    case 1001434505:
                        if (stringValue.equals("stylistic-one")) {
                            c = 14;
                            break;
                        }
                        break;
                    case 1001438213:
                        if (stringValue.equals("stylistic-six")) {
                            c = 15;
                            break;
                        }
                        break;
                    case 1001439040:
                        if (stringValue.equals("stylistic-ten")) {
                            c = 16;
                            break;
                        }
                        break;
                    case 1001439599:
                        if (stringValue.equals("stylistic-two")) {
                            c = 17;
                            break;
                        }
                        break;
                    case 1030714463:
                        if (stringValue.equals("stylistic-sixteen")) {
                            c = 18;
                            break;
                        }
                        break;
                    case 1044065430:
                        if (stringValue.equals("stylistic-twelve")) {
                            c = 19;
                            break;
                        }
                        break;
                    case 1044067310:
                        if (stringValue.equals("stylistic-twenty")) {
                            c = 20;
                            break;
                        }
                        break;
                    case 1183323111:
                        if (stringValue.equals("small-caps")) {
                            c = 21;
                            break;
                        }
                        break;
                    case 1463562569:
                        if (stringValue.equals("stylistic-nineteen")) {
                            c = 22;
                            break;
                        }
                        break;
                    case 1648446397:
                        if (stringValue.equals("stylistic-fourteen")) {
                            c = 23;
                            break;
                        }
                        break;
                    case 2097122634:
                        if (stringValue.equals("stylistic-seventeen")) {
                            c = 24;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        arrayList.add("'ss13'");
                        break;
                    case 1:
                        arrayList.add("'ss15'");
                        break;
                    case 2:
                        arrayList.add("'ss18'");
                        break;
                    case 3:
                        arrayList.add("'pnum'");
                        break;
                    case 4:
                        arrayList.add("'lnum'");
                        break;
                    case 5:
                        arrayList.add("'tnum'");
                        break;
                    case 6:
                        arrayList.add("'onum'");
                        break;
                    case 7:
                        arrayList.add("'ss08'");
                        break;
                    case 8:
                        arrayList.add("'ss07'");
                        break;
                    case 9:
                        arrayList.add("'ss03'");
                        break;
                    case 10:
                        arrayList.add("'ss11'");
                        break;
                    case 11:
                        arrayList.add("'ss05'");
                        break;
                    case 12:
                        arrayList.add("'ss04'");
                        break;
                    case 13:
                        arrayList.add("'ss09'");
                        break;
                    case 14:
                        arrayList.add("'ss01'");
                        break;
                    case 15:
                        arrayList.add("'ss06'");
                        break;
                    case 16:
                        arrayList.add("'ss10'");
                        break;
                    case 17:
                        arrayList.add("'ss02'");
                        break;
                    case 18:
                        arrayList.add("'ss16'");
                        break;
                    case 19:
                        arrayList.add("'ss12'");
                        break;
                    case 20:
                        arrayList.add("'ss20'");
                        break;
                    case 21:
                        arrayList.add("'smcp'");
                        break;
                    case 22:
                        arrayList.add("'ss19'");
                        break;
                    case 23:
                        arrayList.add("'ss14'");
                        break;
                    case 24:
                        arrayList.add("'ss17'");
                        break;
                }
            }
        }
        this.mFontFeatureSettings = TextUtils.join(", ", arrayList);
    }

    private void setFontWeight(String str) {
        this.mFontWeight = ReactTypefaceUtils.parseFontWeight(str);
    }

    private void setFontStyle(String str) {
        this.mFontStyle = ReactTypefaceUtils.parseFontStyle(str);
    }

    private void setIncludeFontPadding(boolean z) {
        this.mIncludeFontPadding = z;
    }

    private void setTextDecorationLine(String str) {
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        if (str != null) {
            for (String str2 : str.split("-")) {
                if (TtmlNode.UNDERLINE.equals(str2)) {
                    this.mIsUnderlineTextDecorationSet = true;
                } else if ("strikethrough".equals(str2)) {
                    this.mIsLineThroughTextDecorationSet = true;
                }
            }
        }
    }

    private void setTextShadowOffset(ReadableMap readableMap) {
        this.mTextShadowOffsetDx = 0.0f;
        this.mTextShadowOffsetDy = 0.0f;
        if (readableMap != null) {
            if (readableMap.hasKey("width") && !readableMap.isNull("width")) {
                this.mTextShadowOffsetDx = PixelUtil.toPixelFromDIP(readableMap.getDouble("width"));
            }
            if (readableMap.hasKey("height") && !readableMap.isNull("height")) {
                this.mTextShadowOffsetDy = PixelUtil.toPixelFromDIP(readableMap.getDouble("height"));
            }
        }
    }

    public static int getLayoutDirection(String str) {
        if (str == null || "undefined".equals(str)) {
            return -1;
        }
        if ("rtl".equals(str)) {
            return 1;
        }
        if ("ltr".equals(str)) {
            return 0;
        }
        throw new JSApplicationIllegalArgumentException("Invalid layoutDirection: " + str);
    }

    private void setLayoutDirection(String str) {
        this.mLayoutDirection = getLayoutDirection(str);
    }

    private void setTextShadowRadius(float f) {
        if (f != this.mTextShadowRadius) {
            this.mTextShadowRadius = f;
        }
    }

    private void setTextShadowColor(int i) {
        if (i != this.mTextShadowColor) {
            this.mTextShadowColor = i;
        }
    }

    private void setTextTransform(String str) {
        if (str == null || "none".equals(str)) {
            this.mTextTransform = TextTransform.NONE;
        } else if ("uppercase".equals(str)) {
            this.mTextTransform = TextTransform.UPPERCASE;
        } else if ("lowercase".equals(str)) {
            this.mTextTransform = TextTransform.LOWERCASE;
        } else if ("capitalize".equals(str)) {
            this.mTextTransform = TextTransform.CAPITALIZE;
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textTransform: " + str);
        }
    }

    private void setAccessibilityRole(String str) {
        if (str != null) {
            this.mIsAccessibilityRoleSet = true;
            ReactAccessibilityDelegate.AccessibilityRole fromValue = ReactAccessibilityDelegate.AccessibilityRole.fromValue(str);
            this.mAccessibilityRole = fromValue;
            this.mIsAccessibilityLink = fromValue.equals(ReactAccessibilityDelegate.AccessibilityRole.LINK);
        }
    }

    public static int getTextBreakStrategy(String str) {
        int i = DEFAULT_BREAK_STRATEGY;
        if (str == null) {
            return i;
        }
        str.hashCode();
        if (!str.equals("balanced")) {
            return !str.equals(FtsOptions.TOKENIZER_SIMPLE) ? 1 : 0;
        }
        return 2;
    }

    public static int getHyphenationFrequency(String str) {
        int i = DEFAULT_HYPHENATION_FREQUENCY;
        if (str == null) {
            return i;
        }
        str.hashCode();
        if (!str.equals(ProfilingTraceData.TRUNCATION_REASON_NORMAL)) {
            return !str.equals("none") ? 2 : 0;
        }
        return 1;
    }
}
