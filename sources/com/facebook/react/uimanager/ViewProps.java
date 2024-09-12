package com.facebook.react.uimanager;

import java.util.Arrays;
import java.util.HashSet;

public class ViewProps {
    public static final String ACCESSIBILITY_ACTIONS = "accessibilityActions";
    public static final String ACCESSIBILITY_COLLECTION = "accessibilityCollection";
    public static final String ACCESSIBILITY_COLLECTION_ITEM = "accessibilityCollectionItem";
    public static final String ACCESSIBILITY_HINT = "accessibilityHint";
    public static final String ACCESSIBILITY_LABEL = "accessibilityLabel";
    public static final String ACCESSIBILITY_LABELLED_BY = "accessibilityLabelledBy";
    public static final String ACCESSIBILITY_LIVE_REGION = "accessibilityLiveRegion";
    public static final String ACCESSIBILITY_ROLE = "accessibilityRole";
    public static final String ACCESSIBILITY_STATE = "accessibilityState";
    public static final String ACCESSIBILITY_VALUE = "accessibilityValue";
    public static final String ADJUSTS_FONT_SIZE_TO_FIT = "adjustsFontSizeToFit";
    public static final String ALIGN_CONTENT = "alignContent";
    public static final String ALIGN_ITEMS = "alignItems";
    public static final String ALIGN_SELF = "alignSelf";
    public static final String ALLOW_FONT_SCALING = "allowFontScaling";
    public static final String ASPECT_RATIO = "aspectRatio";
    public static final String AUTO = "auto";
    public static final String BACKGROUND_COLOR = "backgroundColor";
    public static final String BORDER_BOTTOM_COLOR = "borderBottomColor";
    public static final String BORDER_BOTTOM_END_RADIUS = "borderBottomEndRadius";
    public static final String BORDER_BOTTOM_LEFT_RADIUS = "borderBottomLeftRadius";
    public static final String BORDER_BOTTOM_RIGHT_RADIUS = "borderBottomRightRadius";
    public static final String BORDER_BOTTOM_START_RADIUS = "borderBottomStartRadius";
    public static final String BORDER_BOTTOM_WIDTH = "borderBottomWidth";
    public static final String BORDER_COLOR = "borderColor";
    public static final String BORDER_END_COLOR = "borderEndColor";
    public static final String BORDER_END_WIDTH = "borderEndWidth";
    public static final String BORDER_LEFT_COLOR = "borderLeftColor";
    public static final String BORDER_LEFT_WIDTH = "borderLeftWidth";
    public static final String BORDER_RADIUS = "borderRadius";
    public static final String BORDER_RIGHT_COLOR = "borderRightColor";
    public static final String BORDER_RIGHT_WIDTH = "borderRightWidth";
    public static final int[] BORDER_SPACING_TYPES = {8, 4, 5, 1, 3, 0, 2};
    public static final String BORDER_START_COLOR = "borderStartColor";
    public static final String BORDER_START_WIDTH = "borderStartWidth";
    public static final String BORDER_TOP_COLOR = "borderTopColor";
    public static final String BORDER_TOP_END_RADIUS = "borderTopEndRadius";
    public static final String BORDER_TOP_LEFT_RADIUS = "borderTopLeftRadius";
    public static final String BORDER_TOP_RIGHT_RADIUS = "borderTopRightRadius";
    public static final String BORDER_TOP_START_RADIUS = "borderTopStartRadius";
    public static final String BORDER_TOP_WIDTH = "borderTopWidth";
    public static final String BORDER_WIDTH = "borderWidth";
    public static final String BOTTOM = "bottom";
    public static final String BOX_NONE = "box-none";
    public static final String COLLAPSABLE = "collapsable";
    public static final String COLOR = "color";
    public static final String COLUMN_GAP = "columnGap";
    public static final String DISPLAY = "display";
    public static final String ELEVATION = "elevation";
    public static final String ELLIPSIZE_MODE = "ellipsizeMode";
    public static final String ENABLED = "enabled";
    public static final String END = "end";
    public static final String FLEX = "flex";
    public static final String FLEX_BASIS = "flexBasis";
    public static final String FLEX_DIRECTION = "flexDirection";
    public static final String FLEX_GROW = "flexGrow";
    public static final String FLEX_SHRINK = "flexShrink";
    public static final String FLEX_WRAP = "flexWrap";
    public static final String FONT_FAMILY = "fontFamily";
    public static final String FONT_SIZE = "fontSize";
    public static final String FONT_STYLE = "fontStyle";
    public static final String FONT_VARIANT = "fontVariant";
    public static final String FONT_WEIGHT = "fontWeight";
    public static final String FOREGROUND_COLOR = "foregroundColor";
    public static final String GAP = "gap";
    public static final String HEIGHT = "height";
    public static final String HIDDEN = "hidden";
    public static final String IMPORTANT_FOR_ACCESSIBILITY = "importantForAccessibility";
    public static final String INCLUDE_FONT_PADDING = "includeFontPadding";
    public static final String IS_ATTACHMENT = "isAttachment";
    public static final String JUSTIFY_CONTENT = "justifyContent";
    public static final String LAYOUT_DIRECTION = "layoutDirection";
    private static final HashSet<String> LAYOUT_ONLY_PROPS = new HashSet<>(Arrays.asList(new String[]{ALIGN_SELF, ALIGN_ITEMS, COLLAPSABLE, FLEX, FLEX_BASIS, FLEX_DIRECTION, FLEX_GROW, ROW_GAP, COLUMN_GAP, GAP, FLEX_SHRINK, FLEX_WRAP, JUSTIFY_CONTENT, ALIGN_CONTENT, "display", POSITION, "right", "top", BOTTOM, "left", "start", "end", "width", "height", MIN_WIDTH, MAX_WIDTH, MIN_HEIGHT, MAX_HEIGHT, MARGIN, MARGIN_VERTICAL, MARGIN_HORIZONTAL, MARGIN_LEFT, MARGIN_RIGHT, MARGIN_TOP, MARGIN_BOTTOM, MARGIN_START, MARGIN_END, PADDING, PADDING_VERTICAL, PADDING_HORIZONTAL, PADDING_LEFT, PADDING_RIGHT, PADDING_TOP, PADDING_BOTTOM, PADDING_START, PADDING_END}));
    public static final String LEFT = "left";
    public static final String LETTER_SPACING = "letterSpacing";
    public static final String LINE_HEIGHT = "lineHeight";
    public static final String MARGIN = "margin";
    public static final String MARGIN_BOTTOM = "marginBottom";
    public static final String MARGIN_END = "marginEnd";
    public static final String MARGIN_HORIZONTAL = "marginHorizontal";
    public static final String MARGIN_LEFT = "marginLeft";
    public static final String MARGIN_RIGHT = "marginRight";
    public static final String MARGIN_START = "marginStart";
    public static final String MARGIN_TOP = "marginTop";
    public static final String MARGIN_VERTICAL = "marginVertical";
    public static final String MAX_FONT_SIZE_MULTIPLIER = "maxFontSizeMultiplier";
    public static final String MAX_HEIGHT = "maxHeight";
    public static final String MAX_WIDTH = "maxWidth";
    public static final String MINIMUM_FONT_SCALE = "minimumFontScale";
    public static final String MIN_HEIGHT = "minHeight";
    public static final String MIN_WIDTH = "minWidth";
    public static final String NATIVE_ID = "nativeID";
    public static final String NEEDS_OFFSCREEN_ALPHA_COMPOSITING = "needsOffscreenAlphaCompositing";
    public static final String NONE = "none";
    public static final String NUMBER_OF_LINES = "numberOfLines";
    public static final String ON = "on";
    public static final String ON_LAYOUT = "onLayout";
    public static final String OPACITY = "opacity";
    public static final String OVERFLOW = "overflow";
    public static final String PADDING = "padding";
    public static final String PADDING_BOTTOM = "paddingBottom";
    public static final String PADDING_END = "paddingEnd";
    public static final String PADDING_HORIZONTAL = "paddingHorizontal";
    public static final String PADDING_LEFT = "paddingLeft";
    public static final int[] PADDING_MARGIN_SPACING_TYPES = {8, 7, 6, 4, 5, 1, 3, 0, 2};
    public static final String PADDING_RIGHT = "paddingRight";
    public static final String PADDING_START = "paddingStart";
    public static final String PADDING_TOP = "paddingTop";
    public static final String PADDING_VERTICAL = "paddingVertical";
    public static final String POINTER_EVENTS = "pointerEvents";
    public static final String POSITION = "position";
    public static final int[] POSITION_SPACING_TYPES = {4, 5, 1, 3};
    public static final String RENDER_TO_HARDWARE_TEXTURE = "renderToHardwareTextureAndroid";
    public static final String RESIZE_METHOD = "resizeMethod";
    public static final String RESIZE_MODE = "resizeMode";
    public static final String RIGHT = "right";
    public static final String ROTATION = "rotation";
    public static final String ROW_GAP = "rowGap";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String SCROLL = "scroll";
    public static final String SHADOW_COLOR = "shadowColor";
    public static final String START = "start";
    public static final String TEST_ID = "testID";
    public static final String TEXT_ALIGN = "textAlign";
    public static final String TEXT_ALIGN_VERTICAL = "textAlignVertical";
    public static final String TEXT_BREAK_STRATEGY = "textBreakStrategy";
    public static final String TEXT_DECORATION_LINE = "textDecorationLine";
    public static final String TOP = "top";
    public static final String TRANSFORM = "transform";
    public static final String TRANSLATE_X = "translateX";
    public static final String TRANSLATE_Y = "translateY";
    public static final String VIEW_CLASS_NAME = "RCTView";
    public static final String VISIBLE = "visible";
    public static final String WIDTH = "width";
    public static final String Z_INDEX = "zIndex";

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0173, code lost:
        if (r0.getType(BORDER_BOTTOM_COLOR) != com.facebook.react.bridge.ReadableType.Number) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0179, code lost:
        if (r0.getInt(BORDER_BOTTOM_COLOR) != 0) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0182, code lost:
        if (r0.isNull(BORDER_TOP_WIDTH) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x018a, code lost:
        if (r0.getDouble(BORDER_TOP_WIDTH) != 0.0d) goto L_0x018d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0195, code lost:
        if (r0.getType(BORDER_TOP_COLOR) != com.facebook.react.bridge.ReadableType.Number) goto L_0x019e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x019b, code lost:
        if (r0.getInt(BORDER_TOP_COLOR) != 0) goto L_0x019e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01a4, code lost:
        if (r0.isNull(BORDER_RIGHT_WIDTH) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01ac, code lost:
        if (r0.getDouble(BORDER_RIGHT_WIDTH) != 0.0d) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01b7, code lost:
        if (r0.getType(BORDER_RIGHT_COLOR) != com.facebook.react.bridge.ReadableType.Number) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01bd, code lost:
        if (r0.getInt(BORDER_RIGHT_COLOR) != 0) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b2, code lost:
        r16 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ca, code lost:
        switch(r16) {
            case 0: goto L_0x01b1;
            case 1: goto L_0x01a0;
            case 2: goto L_0x018f;
            case 3: goto L_0x017e;
            case 4: goto L_0x016d;
            case 5: goto L_0x015c;
            case 6: goto L_0x0149;
            case 7: goto L_0x0138;
            case 8: goto L_0x0127;
            case 9: goto L_0x0111;
            case 10: goto L_0x0100;
            case 11: goto L_0x00ce;
            default: goto L_0x00cd;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00cd, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d4, code lost:
        if (r0.hasKey("backgroundColor") == false) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d6, code lost:
        r5 = r0.getType("backgroundColor");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00dc, code lost:
        if (r5 != com.facebook.react.bridge.ReadableType.Number) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e2, code lost:
        if (r0.getInt("backgroundColor") == 0) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e4, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e7, code lost:
        if (r5 == com.facebook.react.bridge.ReadableType.Null) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e9, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ee, code lost:
        if (r0.hasKey(BORDER_WIDTH) == false) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f4, code lost:
        if (r0.isNull(BORDER_WIDTH) != false) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00fc, code lost:
        if (r0.getDouble(BORDER_WIDTH) == 0.0d) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00fe, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ff, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0104, code lost:
        if (r0.isNull(BORDER_WIDTH) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x010c, code lost:
        if (r0.getDouble(BORDER_WIDTH) != 0.0d) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0115, code lost:
        if (r0.isNull(OVERFLOW) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0122, code lost:
        if (VISIBLE.equals(r0.getString(OVERFLOW)) == false) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x012b, code lost:
        if (r0.isNull(BORDER_LEFT_WIDTH) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0133, code lost:
        if (r0.getDouble(BORDER_LEFT_WIDTH) != 0.0d) goto L_0x0136;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x013e, code lost:
        if (r0.getType(BORDER_LEFT_COLOR) != com.facebook.react.bridge.ReadableType.Number) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0144, code lost:
        if (r0.getInt(BORDER_LEFT_COLOR) != 0) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x014d, code lost:
        if (r0.isNull(OPACITY) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0157, code lost:
        if (r0.getDouble(OPACITY) != 1.0d) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0160, code lost:
        if (r0.isNull(BORDER_BOTTOM_WIDTH) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0168, code lost:
        if (r0.getDouble(BORDER_BOTTOM_WIDTH) != 0.0d) goto L_0x016b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isLayoutOnly(com.facebook.react.bridge.ReadableMap r19, java.lang.String r20) {
        /*
            r0 = r19
            r1 = r20
            java.util.HashSet<java.lang.String> r2 = LAYOUT_ONLY_PROPS
            boolean r2 = r2.contains(r1)
            r3 = 1
            if (r2 == 0) goto L_0x000e
            return r3
        L_0x000e:
            java.lang.String r2 = "pointerEvents"
            boolean r2 = r2.equals(r1)
            r4 = 0
            if (r2 == 0) goto L_0x002e
            java.lang.String r0 = r19.getString(r20)
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x002d
            java.lang.String r1 = "box-none"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r3 = r4
        L_0x002d:
            return r3
        L_0x002e:
            r20.hashCode()
            int r5 = r20.hashCode()
            java.lang.String r6 = "overflow"
            java.lang.String r7 = "borderLeftWidth"
            java.lang.String r8 = "borderLeftColor"
            java.lang.String r9 = "opacity"
            java.lang.String r10 = "borderBottomWidth"
            java.lang.String r11 = "borderBottomColor"
            java.lang.String r12 = "borderTopWidth"
            java.lang.String r13 = "borderTopColor"
            java.lang.String r14 = "borderRightWidth"
            java.lang.String r15 = "borderRightColor"
            java.lang.String r2 = "borderWidth"
            switch(r5) {
                case -1989576717: goto L_0x00bf;
                case -1971292586: goto L_0x00b5;
                case -1470826662: goto L_0x00aa;
                case -1452542531: goto L_0x00a1;
                case -1308858324: goto L_0x0098;
                case -1290574193: goto L_0x008f;
                case -1267206133: goto L_0x0086;
                case -242276144: goto L_0x007d;
                case -223992013: goto L_0x0073;
                case 529642498: goto L_0x0069;
                case 741115130: goto L_0x005f;
                case 1349188574: goto L_0x0052;
                default: goto L_0x004e;
            }
        L_0x004e:
            r16 = -1
            goto L_0x00c8
        L_0x0052:
            java.lang.String r5 = "borderRadius"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x005b
            goto L_0x004e
        L_0x005b:
            r1 = 11
            goto L_0x00b2
        L_0x005f:
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0066
            goto L_0x004e
        L_0x0066:
            r1 = 10
            goto L_0x00b2
        L_0x0069:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0070
            goto L_0x004e
        L_0x0070:
            r1 = 9
            goto L_0x00b2
        L_0x0073:
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x007a
            goto L_0x004e
        L_0x007a:
            r1 = 8
            goto L_0x00b2
        L_0x007d:
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x0084
            goto L_0x004e
        L_0x0084:
            r1 = 7
            goto L_0x00b2
        L_0x0086:
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x008d
            goto L_0x004e
        L_0x008d:
            r1 = 6
            goto L_0x00b2
        L_0x008f:
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x0096
            goto L_0x004e
        L_0x0096:
            r1 = 5
            goto L_0x00b2
        L_0x0098:
            boolean r1 = r1.equals(r11)
            if (r1 != 0) goto L_0x009f
            goto L_0x004e
        L_0x009f:
            r1 = 4
            goto L_0x00b2
        L_0x00a1:
            boolean r1 = r1.equals(r12)
            if (r1 != 0) goto L_0x00a8
            goto L_0x004e
        L_0x00a8:
            r1 = 3
            goto L_0x00b2
        L_0x00aa:
            boolean r1 = r1.equals(r13)
            if (r1 != 0) goto L_0x00b1
            goto L_0x004e
        L_0x00b1:
            r1 = 2
        L_0x00b2:
            r16 = r1
            goto L_0x00c8
        L_0x00b5:
            boolean r1 = r1.equals(r14)
            if (r1 != 0) goto L_0x00bc
            goto L_0x004e
        L_0x00bc:
            r16 = r3
            goto L_0x00c8
        L_0x00bf:
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x00c6
            goto L_0x004e
        L_0x00c6:
            r16 = r4
        L_0x00c8:
            r17 = 0
            switch(r16) {
                case 0: goto L_0x01b1;
                case 1: goto L_0x01a0;
                case 2: goto L_0x018f;
                case 3: goto L_0x017e;
                case 4: goto L_0x016d;
                case 5: goto L_0x015c;
                case 6: goto L_0x0149;
                case 7: goto L_0x0138;
                case 8: goto L_0x0127;
                case 9: goto L_0x0111;
                case 10: goto L_0x0100;
                case 11: goto L_0x00ce;
                default: goto L_0x00cd;
            }
        L_0x00cd:
            return r4
        L_0x00ce:
            java.lang.String r1 = "backgroundColor"
            boolean r5 = r0.hasKey(r1)
            if (r5 == 0) goto L_0x00ea
            com.facebook.react.bridge.ReadableType r5 = r0.getType(r1)
            com.facebook.react.bridge.ReadableType r6 = com.facebook.react.bridge.ReadableType.Number
            if (r5 != r6) goto L_0x00e5
            int r1 = r0.getInt(r1)
            if (r1 == 0) goto L_0x00e5
            return r4
        L_0x00e5:
            com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Null
            if (r5 == r1) goto L_0x00ea
            return r4
        L_0x00ea:
            boolean r1 = r0.hasKey(r2)
            if (r1 == 0) goto L_0x00ff
            boolean r1 = r0.isNull(r2)
            if (r1 != 0) goto L_0x00ff
            double r0 = r0.getDouble(r2)
            int r0 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x00ff
            return r4
        L_0x00ff:
            return r3
        L_0x0100:
            boolean r1 = r0.isNull(r2)
            if (r1 != 0) goto L_0x0110
            double r0 = r0.getDouble(r2)
            int r0 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r0 != 0) goto L_0x010f
            goto L_0x0110
        L_0x010f:
            r3 = r4
        L_0x0110:
            return r3
        L_0x0111:
            boolean r1 = r0.isNull(r6)
            if (r1 != 0) goto L_0x0126
            java.lang.String r0 = r0.getString(r6)
            java.lang.String r1 = "visible"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0125
            goto L_0x0126
        L_0x0125:
            r3 = r4
        L_0x0126:
            return r3
        L_0x0127:
            boolean r1 = r0.isNull(r7)
            if (r1 != 0) goto L_0x0137
            double r0 = r0.getDouble(r7)
            int r0 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r0 != 0) goto L_0x0136
            goto L_0x0137
        L_0x0136:
            r3 = r4
        L_0x0137:
            return r3
        L_0x0138:
            com.facebook.react.bridge.ReadableType r1 = r0.getType(r8)
            com.facebook.react.bridge.ReadableType r2 = com.facebook.react.bridge.ReadableType.Number
            if (r1 != r2) goto L_0x0147
            int r0 = r0.getInt(r8)
            if (r0 != 0) goto L_0x0147
            goto L_0x0148
        L_0x0147:
            r3 = r4
        L_0x0148:
            return r3
        L_0x0149:
            boolean r1 = r0.isNull(r9)
            if (r1 != 0) goto L_0x015b
            double r0 = r0.getDouble(r9)
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r3 = r4
        L_0x015b:
            return r3
        L_0x015c:
            boolean r1 = r0.isNull(r10)
            if (r1 != 0) goto L_0x016c
            double r0 = r0.getDouble(r10)
            int r0 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r0 != 0) goto L_0x016b
            goto L_0x016c
        L_0x016b:
            r3 = r4
        L_0x016c:
            return r3
        L_0x016d:
            com.facebook.react.bridge.ReadableType r1 = r0.getType(r11)
            com.facebook.react.bridge.ReadableType r2 = com.facebook.react.bridge.ReadableType.Number
            if (r1 != r2) goto L_0x017c
            int r0 = r0.getInt(r11)
            if (r0 != 0) goto L_0x017c
            goto L_0x017d
        L_0x017c:
            r3 = r4
        L_0x017d:
            return r3
        L_0x017e:
            boolean r1 = r0.isNull(r12)
            if (r1 != 0) goto L_0x018e
            double r0 = r0.getDouble(r12)
            int r0 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r0 != 0) goto L_0x018d
            goto L_0x018e
        L_0x018d:
            r3 = r4
        L_0x018e:
            return r3
        L_0x018f:
            com.facebook.react.bridge.ReadableType r1 = r0.getType(r13)
            com.facebook.react.bridge.ReadableType r2 = com.facebook.react.bridge.ReadableType.Number
            if (r1 != r2) goto L_0x019e
            int r0 = r0.getInt(r13)
            if (r0 != 0) goto L_0x019e
            goto L_0x019f
        L_0x019e:
            r3 = r4
        L_0x019f:
            return r3
        L_0x01a0:
            boolean r1 = r0.isNull(r14)
            if (r1 != 0) goto L_0x01b0
            double r0 = r0.getDouble(r14)
            int r0 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r0 != 0) goto L_0x01af
            goto L_0x01b0
        L_0x01af:
            r3 = r4
        L_0x01b0:
            return r3
        L_0x01b1:
            com.facebook.react.bridge.ReadableType r1 = r0.getType(r15)
            com.facebook.react.bridge.ReadableType r2 = com.facebook.react.bridge.ReadableType.Number
            if (r1 != r2) goto L_0x01c0
            int r0 = r0.getInt(r15)
            if (r0 != 0) goto L_0x01c0
            goto L_0x01c1
        L_0x01c0:
            r3 = r4
        L_0x01c1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ViewProps.isLayoutOnly(com.facebook.react.bridge.ReadableMap, java.lang.String):boolean");
    }
}
