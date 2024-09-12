package com.facebook.react.views.text;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class CustomLetterSpacingSpan extends MetricAffectingSpan implements ReactSpan {
    private final float mLetterSpacing;

    public CustomLetterSpacingSpan(float f) {
        this.mLetterSpacing = f;
    }

    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        apply(textPaint);
    }

    public float getSpacing() {
        return this.mLetterSpacing;
    }

    private void apply(TextPaint textPaint) {
        if (!Float.isNaN(this.mLetterSpacing)) {
            textPaint.setLetterSpacing(this.mLetterSpacing);
        }
    }
}
