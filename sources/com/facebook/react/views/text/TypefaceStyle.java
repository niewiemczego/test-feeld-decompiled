package com.facebook.react.views.text;

import android.graphics.Typeface;
import android.os.Build;

class TypefaceStyle {
    public static final int BOLD = 700;
    private static final int MAX_WEIGHT = 1000;
    private static final int MIN_WEIGHT = 1;
    public static final int NORMAL = 400;
    private final boolean mItalic;
    private final int mWeight;

    public TypefaceStyle(int i, boolean z) {
        this.mItalic = z;
        this.mWeight = i == -1 ? 400 : i;
    }

    public TypefaceStyle(int i) {
        boolean z = false;
        i = i == -1 ? 0 : i;
        this.mItalic = (i & 2) != 0 ? true : z;
        this.mWeight = (i & 1) != 0 ? BOLD : 400;
    }

    public TypefaceStyle(int i, int i2) {
        boolean z = false;
        i = i == -1 ? 0 : i;
        this.mItalic = (i & 2) != 0 ? true : z;
        this.mWeight = i2 == -1 ? (i & 1) != 0 ? BOLD : 400 : i2;
    }

    public int getNearestStyle() {
        return this.mWeight < 700 ? this.mItalic ? 2 : 0 : this.mItalic ? 3 : 1;
    }

    public Typeface apply(Typeface typeface) {
        if (Build.VERSION.SDK_INT < 28) {
            return Typeface.create(typeface, getNearestStyle());
        }
        return Typeface.create(typeface, this.mWeight, this.mItalic);
    }
}
