package com.facebook.react.views.text;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.PixelUtil;

public class TextAttributes {
    public static final float DEFAULT_MAX_FONT_SIZE_MULTIPLIER = 0.0f;
    private boolean mAllowFontScaling = true;
    private float mFontSize = Float.NaN;
    private float mHeightOfTallestInlineViewOrImage = Float.NaN;
    private float mLetterSpacing = Float.NaN;
    private float mLineHeight = Float.NaN;
    private float mMaxFontSizeMultiplier = Float.NaN;
    private TextTransform mTextTransform = TextTransform.UNSET;

    public TextAttributes applyChild(TextAttributes textAttributes) {
        float f;
        float f2;
        TextAttributes textAttributes2 = new TextAttributes();
        textAttributes2.mAllowFontScaling = this.mAllowFontScaling;
        textAttributes2.mFontSize = !Float.isNaN(textAttributes.mFontSize) ? textAttributes.mFontSize : this.mFontSize;
        textAttributes2.mLineHeight = !Float.isNaN(textAttributes.mLineHeight) ? textAttributes.mLineHeight : this.mLineHeight;
        textAttributes2.mLetterSpacing = !Float.isNaN(textAttributes.mLetterSpacing) ? textAttributes.mLetterSpacing : this.mLetterSpacing;
        if (!Float.isNaN(textAttributes.mMaxFontSizeMultiplier)) {
            f = textAttributes.mMaxFontSizeMultiplier;
        } else {
            f = this.mMaxFontSizeMultiplier;
        }
        textAttributes2.mMaxFontSizeMultiplier = f;
        if (!Float.isNaN(textAttributes.mHeightOfTallestInlineViewOrImage)) {
            f2 = textAttributes.mHeightOfTallestInlineViewOrImage;
        } else {
            f2 = this.mHeightOfTallestInlineViewOrImage;
        }
        textAttributes2.mHeightOfTallestInlineViewOrImage = f2;
        textAttributes2.mTextTransform = textAttributes.mTextTransform != TextTransform.UNSET ? textAttributes.mTextTransform : this.mTextTransform;
        return textAttributes2;
    }

    public boolean getAllowFontScaling() {
        return this.mAllowFontScaling;
    }

    public void setAllowFontScaling(boolean z) {
        this.mAllowFontScaling = z;
    }

    public float getFontSize() {
        return this.mFontSize;
    }

    public void setFontSize(float f) {
        this.mFontSize = f;
    }

    public float getLineHeight() {
        return this.mLineHeight;
    }

    public void setLineHeight(float f) {
        this.mLineHeight = f;
    }

    public float getLetterSpacing() {
        return this.mLetterSpacing;
    }

    public void setLetterSpacing(float f) {
        this.mLetterSpacing = f;
    }

    public float getMaxFontSizeMultiplier() {
        return this.mMaxFontSizeMultiplier;
    }

    public void setMaxFontSizeMultiplier(float f) {
        if (f == 0.0f || f >= 1.0f) {
            this.mMaxFontSizeMultiplier = f;
            return;
        }
        throw new JSApplicationIllegalArgumentException("maxFontSizeMultiplier must be NaN, 0, or >= 1");
    }

    public float getHeightOfTallestInlineViewOrImage() {
        return this.mHeightOfTallestInlineViewOrImage;
    }

    public void setHeightOfTallestInlineViewOrImage(float f) {
        this.mHeightOfTallestInlineViewOrImage = f;
    }

    public TextTransform getTextTransform() {
        return this.mTextTransform;
    }

    public void setTextTransform(TextTransform textTransform) {
        this.mTextTransform = textTransform;
    }

    public int getEffectiveFontSize() {
        double d;
        float f = !Float.isNaN(this.mFontSize) ? this.mFontSize : 14.0f;
        if (this.mAllowFontScaling) {
            d = Math.ceil((double) PixelUtil.toPixelFromSP(f, getEffectiveMaxFontSizeMultiplier()));
        } else {
            d = Math.ceil((double) PixelUtil.toPixelFromDIP(f));
        }
        return (int) d;
    }

    public float getEffectiveLineHeight() {
        float f;
        if (Float.isNaN(this.mLineHeight)) {
            return Float.NaN;
        }
        if (this.mAllowFontScaling) {
            f = PixelUtil.toPixelFromSP(this.mLineHeight, getEffectiveMaxFontSizeMultiplier());
        } else {
            f = PixelUtil.toPixelFromDIP(this.mLineHeight);
        }
        return !Float.isNaN(this.mHeightOfTallestInlineViewOrImage) && (this.mHeightOfTallestInlineViewOrImage > f ? 1 : (this.mHeightOfTallestInlineViewOrImage == f ? 0 : -1)) > 0 ? this.mHeightOfTallestInlineViewOrImage : f;
    }

    public float getEffectiveLetterSpacing() {
        float f;
        if (Float.isNaN(this.mLetterSpacing)) {
            return Float.NaN;
        }
        if (this.mAllowFontScaling) {
            f = PixelUtil.toPixelFromSP(this.mLetterSpacing, getEffectiveMaxFontSizeMultiplier());
        } else {
            f = PixelUtil.toPixelFromDIP(this.mLetterSpacing);
        }
        return f / ((float) getEffectiveFontSize());
    }

    public float getEffectiveMaxFontSizeMultiplier() {
        if (!Float.isNaN(this.mMaxFontSizeMultiplier)) {
            return this.mMaxFontSizeMultiplier;
        }
        return 0.0f;
    }

    public String toString() {
        return "TextAttributes {\n  getAllowFontScaling(): " + getAllowFontScaling() + "\n  getFontSize(): " + getFontSize() + "\n  getEffectiveFontSize(): " + getEffectiveFontSize() + "\n  getHeightOfTallestInlineViewOrImage(): " + getHeightOfTallestInlineViewOrImage() + "\n  getLetterSpacing(): " + getLetterSpacing() + "\n  getEffectiveLetterSpacing(): " + getEffectiveLetterSpacing() + "\n  getLineHeight(): " + getLineHeight() + "\n  getEffectiveLineHeight(): " + getEffectiveLineHeight() + "\n  getTextTransform(): " + getTextTransform() + "\n  getMaxFontSizeMultiplier(): " + getMaxFontSizeMultiplier() + "\n  getEffectiveMaxFontSizeMultiplier(): " + getEffectiveMaxFontSizeMultiplier() + "\n}";
    }
}
