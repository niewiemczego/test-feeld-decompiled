package com.facebook.react.uimanager;

import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaWrap;

public class LayoutShadowNode extends ReactShadowNodeImpl {
    boolean mCollapsable;
    private final MutableYogaValue mTempYogaValue = new MutableYogaValue((AnonymousClass1) null);

    @ReactProp(name = "onPointerEnter")
    public void setShouldNotifyPointerEnter(boolean z) {
    }

    @ReactProp(name = "onPointerLeave")
    public void setShouldNotifyPointerLeave(boolean z) {
    }

    @ReactProp(name = "onPointerMove")
    public void setShouldNotifyPointerMove(boolean z) {
    }

    private static class MutableYogaValue {
        YogaUnit unit;
        float value;

        /* synthetic */ MutableYogaValue(AnonymousClass1 r1) {
            this();
        }

        private MutableYogaValue() {
        }

        private MutableYogaValue(MutableYogaValue mutableYogaValue) {
            this.value = mutableYogaValue.value;
            this.unit = mutableYogaValue.unit;
        }

        /* access modifiers changed from: package-private */
        public void setFromDynamic(Dynamic dynamic) {
            if (dynamic.isNull()) {
                this.unit = YogaUnit.UNDEFINED;
                this.value = Float.NaN;
            } else if (dynamic.getType() == ReadableType.String) {
                String asString = dynamic.asString();
                if (asString.equals("auto")) {
                    this.unit = YogaUnit.AUTO;
                    this.value = Float.NaN;
                } else if (asString.endsWith("%")) {
                    this.unit = YogaUnit.PERCENT;
                    this.value = Float.parseFloat(asString.substring(0, asString.length() - 1));
                } else {
                    throw new IllegalArgumentException("Unknown value: " + asString);
                }
            } else {
                this.unit = YogaUnit.POINT;
                this.value = PixelUtil.toPixelFromDIP(dynamic.asDouble());
            }
        }
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i == 1 || i == 2) {
                setStyleWidth(this.mTempYogaValue.value);
            } else if (i == 3) {
                setStyleWidthAuto();
            } else if (i == 4) {
                setStyleWidthPercent(this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    /* renamed from: com.facebook.react.uimanager.LayoutShadowNode$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$yoga$YogaUnit;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.yoga.YogaUnit[] r0 = com.facebook.yoga.YogaUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$yoga$YogaUnit = r0
                com.facebook.yoga.YogaUnit r1 = com.facebook.yoga.YogaUnit.POINT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.yoga.YogaUnit r1 = com.facebook.yoga.YogaUnit.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.yoga.YogaUnit r1 = com.facebook.yoga.YogaUnit.AUTO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.yoga.YogaUnit r1 = com.facebook.yoga.YogaUnit.PERCENT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.LayoutShadowNode.AnonymousClass1.<clinit>():void");
        }
    }

    @ReactProp(name = "minWidth")
    public void setMinWidth(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i == 1 || i == 2) {
                setStyleMinWidth(this.mTempYogaValue.value);
            } else if (i == 4) {
                setStyleMinWidthPercent(this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "collapsable")
    public void setCollapsable(boolean z) {
        this.mCollapsable = z;
    }

    @ReactProp(name = "maxWidth")
    public void setMaxWidth(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i == 1 || i == 2) {
                setStyleMaxWidth(this.mTempYogaValue.value);
            } else if (i == 4) {
                setStyleMaxWidthPercent(this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i == 1 || i == 2) {
                setStyleHeight(this.mTempYogaValue.value);
            } else if (i == 3) {
                setStyleHeightAuto();
            } else if (i == 4) {
                setStyleHeightPercent(this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "minHeight")
    public void setMinHeight(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i == 1 || i == 2) {
                setStyleMinHeight(this.mTempYogaValue.value);
            } else if (i == 4) {
                setStyleMinHeightPercent(this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "maxHeight")
    public void setMaxHeight(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i == 1 || i == 2) {
                setStyleMaxHeight(this.mTempYogaValue.value);
            } else if (i == 4) {
                setStyleMaxHeightPercent(this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "flex")
    public void setFlex(float f) {
        if (!isVirtual()) {
            super.setFlex(f);
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "flexGrow")
    public void setFlexGrow(float f) {
        if (!isVirtual()) {
            super.setFlexGrow(f);
        }
    }

    @ReactProp(defaultFloat = Float.NaN, name = "rowGap")
    public void setRowGap(float f) {
        if (!isVirtual()) {
            super.setRowGap(PixelUtil.toPixelFromDIP(f));
        }
    }

    @ReactProp(defaultFloat = Float.NaN, name = "columnGap")
    public void setColumnGap(float f) {
        if (!isVirtual()) {
            super.setColumnGap(PixelUtil.toPixelFromDIP(f));
        }
    }

    @ReactProp(defaultFloat = Float.NaN, name = "gap")
    public void setGap(float f) {
        if (!isVirtual()) {
            super.setGap(PixelUtil.toPixelFromDIP(f));
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "flexShrink")
    public void setFlexShrink(float f) {
        if (!isVirtual()) {
            super.setFlexShrink(f);
        }
    }

    @ReactProp(name = "flexBasis")
    public void setFlexBasis(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i == 1 || i == 2) {
                setFlexBasis(this.mTempYogaValue.value);
            } else if (i == 3) {
                setFlexBasisAuto();
            } else if (i == 4) {
                setFlexBasisPercent(this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(defaultFloat = Float.NaN, name = "aspectRatio")
    public void setAspectRatio(float f) {
        setStyleAspectRatio(f);
    }

    @ReactProp(name = "flexDirection")
    public void setFlexDirection(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setFlexDirection(YogaFlexDirection.COLUMN);
                return;
            }
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1448970769:
                    if (str.equals("row-reverse")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1354837162:
                    if (str.equals("column")) {
                        c = 1;
                        break;
                    }
                    break;
                case 113114:
                    if (str.equals("row")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1272730475:
                    if (str.equals("column-reverse")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    setFlexDirection(YogaFlexDirection.ROW_REVERSE);
                    return;
                case 1:
                    setFlexDirection(YogaFlexDirection.COLUMN);
                    return;
                case 2:
                    setFlexDirection(YogaFlexDirection.ROW);
                    return;
                case 3:
                    setFlexDirection(YogaFlexDirection.COLUMN_REVERSE);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException("invalid value for flexDirection: " + str);
            }
        }
    }

    @ReactProp(name = "flexWrap")
    public void setFlexWrap(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setFlexWrap(YogaWrap.NO_WRAP);
                return;
            }
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1039592053:
                    if (str.equals("nowrap")) {
                        c = 0;
                        break;
                    }
                    break;
                case -749527969:
                    if (str.equals("wrap-reverse")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3657802:
                    if (str.equals("wrap")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    setFlexWrap(YogaWrap.NO_WRAP);
                    return;
                case 1:
                    setFlexWrap(YogaWrap.WRAP_REVERSE);
                    return;
                case 2:
                    setFlexWrap(YogaWrap.WRAP);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException("invalid value for flexWrap: " + str);
            }
        }
    }

    @ReactProp(name = "alignSelf")
    public void setAlignSelf(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setAlignSelf(YogaAlign.AUTO);
                return;
            }
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals(TtmlNode.CENTER)) {
                        c = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c = 4;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    setAlignSelf(YogaAlign.STRETCH);
                    return;
                case 1:
                    setAlignSelf(YogaAlign.BASELINE);
                    return;
                case 2:
                    setAlignSelf(YogaAlign.CENTER);
                    return;
                case 3:
                    setAlignSelf(YogaAlign.FLEX_START);
                    return;
                case 4:
                    setAlignSelf(YogaAlign.AUTO);
                    return;
                case 5:
                    setAlignSelf(YogaAlign.SPACE_BETWEEN);
                    return;
                case 6:
                    setAlignSelf(YogaAlign.FLEX_END);
                    return;
                case 7:
                    setAlignSelf(YogaAlign.SPACE_AROUND);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException("invalid value for alignSelf: " + str);
            }
        }
    }

    @ReactProp(name = "alignItems")
    public void setAlignItems(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setAlignItems(YogaAlign.STRETCH);
                return;
            }
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals(TtmlNode.CENTER)) {
                        c = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c = 4;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    setAlignItems(YogaAlign.STRETCH);
                    return;
                case 1:
                    setAlignItems(YogaAlign.BASELINE);
                    return;
                case 2:
                    setAlignItems(YogaAlign.CENTER);
                    return;
                case 3:
                    setAlignItems(YogaAlign.FLEX_START);
                    return;
                case 4:
                    setAlignItems(YogaAlign.AUTO);
                    return;
                case 5:
                    setAlignItems(YogaAlign.SPACE_BETWEEN);
                    return;
                case 6:
                    setAlignItems(YogaAlign.FLEX_END);
                    return;
                case 7:
                    setAlignItems(YogaAlign.SPACE_AROUND);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException("invalid value for alignItems: " + str);
            }
        }
    }

    @ReactProp(name = "alignContent")
    public void setAlignContent(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setAlignContent(YogaAlign.FLEX_START);
                return;
            }
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals(TtmlNode.CENTER)) {
                        c = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c = 4;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    setAlignContent(YogaAlign.STRETCH);
                    return;
                case 1:
                    setAlignContent(YogaAlign.BASELINE);
                    return;
                case 2:
                    setAlignContent(YogaAlign.CENTER);
                    return;
                case 3:
                    setAlignContent(YogaAlign.FLEX_START);
                    return;
                case 4:
                    setAlignContent(YogaAlign.AUTO);
                    return;
                case 5:
                    setAlignContent(YogaAlign.SPACE_BETWEEN);
                    return;
                case 6:
                    setAlignContent(YogaAlign.FLEX_END);
                    return;
                case 7:
                    setAlignContent(YogaAlign.SPACE_AROUND);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException("invalid value for alignContent: " + str);
            }
        }
    }

    @ReactProp(name = "justifyContent")
    public void setJustifyContent(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setJustifyContent(YogaJustify.FLEX_START);
                return;
            }
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals(TtmlNode.CENTER)) {
                        c = 0;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c = 1;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2055030478:
                    if (str.equals("space-evenly")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    setJustifyContent(YogaJustify.CENTER);
                    return;
                case 1:
                    setJustifyContent(YogaJustify.FLEX_START);
                    return;
                case 2:
                    setJustifyContent(YogaJustify.SPACE_BETWEEN);
                    return;
                case 3:
                    setJustifyContent(YogaJustify.FLEX_END);
                    return;
                case 4:
                    setJustifyContent(YogaJustify.SPACE_AROUND);
                    return;
                case 5:
                    setJustifyContent(YogaJustify.SPACE_EVENLY);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException("invalid value for justifyContent: " + str);
            }
        }
    }

    @ReactProp(name = "overflow")
    public void setOverflow(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setOverflow(YogaOverflow.VISIBLE);
                return;
            }
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
                case 466743410:
                    if (str.equals(ViewProps.VISIBLE)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    setOverflow(YogaOverflow.HIDDEN);
                    return;
                case 1:
                    setOverflow(YogaOverflow.SCROLL);
                    return;
                case 2:
                    setOverflow(YogaOverflow.VISIBLE);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException("invalid value for overflow: " + str);
            }
        }
    }

    @ReactProp(name = "display")
    public void setDisplay(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setDisplay(YogaDisplay.FLEX);
                return;
            }
            str.hashCode();
            if (str.equals(ViewProps.FLEX)) {
                setDisplay(YogaDisplay.FLEX);
            } else if (str.equals("none")) {
                setDisplay(YogaDisplay.NONE);
            } else {
                throw new JSApplicationIllegalArgumentException("invalid value for display: " + str);
            }
        }
    }

    @ReactPropGroup(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i, Dynamic dynamic) {
        if (!isVirtual()) {
            int maybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i2 == 1 || i2 == 2) {
                setMargin(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            } else if (i2 == 3) {
                setMarginAuto(maybeTransformLeftRightToStartEnd);
            } else if (i2 == 4) {
                setMarginPercent(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactPropGroup(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i, Dynamic dynamic) {
        if (!isVirtual()) {
            int maybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i2 == 1 || i2 == 2) {
                setPadding(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            } else if (i2 == 4) {
                setPaddingPercent(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
    public void setBorderWidths(int i, float f) {
        if (!isVirtual()) {
            setBorder(maybeTransformLeftRightToStartEnd(ViewProps.BORDER_SPACING_TYPES[i]), PixelUtil.toPixelFromDIP(f));
        }
    }

    @ReactPropGroup(names = {"start", "end", "left", "right", "top", "bottom"})
    public void setPositionValues(int i, Dynamic dynamic) {
        if (!isVirtual()) {
            int maybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(new int[]{4, 5, 0, 2, 1, 3}[i]);
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i2 == 1 || i2 == 2) {
                setPosition(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            } else if (i2 == 4) {
                setPositionPercent(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    private int maybeTransformLeftRightToStartEnd(int i) {
        if (!I18nUtil.getInstance().doLeftAndRightSwapInRTL(getThemedContext())) {
            return i;
        }
        if (i == 0) {
            return 4;
        }
        if (i != 2) {
            return i;
        }
        return 5;
    }

    @ReactProp(name = "position")
    public void setPosition(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setPositionType(YogaPositionType.RELATIVE);
                return;
            }
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -892481938:
                    if (str.equals("static")) {
                        c = 0;
                        break;
                    }
                    break;
                case -554435892:
                    if (str.equals(Constants.PATH_TYPE_RELATIVE)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1728122231:
                    if (str.equals(Constants.PATH_TYPE_ABSOLUTE)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    setPositionType(YogaPositionType.STATIC);
                    return;
                case 1:
                    setPositionType(YogaPositionType.RELATIVE);
                    return;
                case 2:
                    setPositionType(YogaPositionType.ABSOLUTE);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException("invalid value for position: " + str);
            }
        }
    }

    @ReactProp(name = "onLayout")
    public void setShouldNotifyOnLayout(boolean z) {
        super.setShouldNotifyOnLayout(z);
    }
}
