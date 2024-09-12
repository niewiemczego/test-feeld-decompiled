package com.horcrux.svg;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.TextProperties;
import java.util.ArrayList;
import javax.annotation.Nullable;

class TextView extends GroupView {
    double cachedAdvance = Double.NaN;
    private TextProperties.AlignmentBaseline mAlignmentBaseline;
    private String mBaselineShift = null;
    @Nullable
    private ArrayList<SVGLength> mDeltaX;
    @Nullable
    private ArrayList<SVGLength> mDeltaY;
    SVGLength mInlineSize = null;
    TextProperties.TextLengthAdjust mLengthAdjust = TextProperties.TextLengthAdjust.spacing;
    @Nullable
    private ArrayList<SVGLength> mPositionX;
    @Nullable
    private ArrayList<SVGLength> mPositionY;
    @Nullable
    private ArrayList<SVGLength> mRotate;
    SVGLength mTextLength = null;

    public TextView(ReactContext reactContext) {
        super(reactContext);
    }

    public void invalidate() {
        if (this.mPath != null) {
            super.invalidate();
            getTextContainer().clearChildCache();
        }
    }

    /* access modifiers changed from: package-private */
    public void clearCache() {
        this.cachedAdvance = Double.NaN;
        super.clearCache();
    }

    public void setInlineSize(Dynamic dynamic) {
        this.mInlineSize = SVGLength.from(dynamic);
        invalidate();
    }

    public void setInlineSize(String str) {
        this.mInlineSize = SVGLength.from(str);
        invalidate();
    }

    public void setInlineSize(Double d) {
        this.mInlineSize = SVGLength.from(d);
        invalidate();
    }

    public void setTextLength(Dynamic dynamic) {
        this.mTextLength = SVGLength.from(dynamic);
        invalidate();
    }

    public void setTextLength(String str) {
        this.mTextLength = SVGLength.from(str);
        invalidate();
    }

    public void setTextLength(Double d) {
        this.mTextLength = SVGLength.from(d);
        invalidate();
    }

    public void setLengthAdjust(@Nullable String str) {
        this.mLengthAdjust = TextProperties.TextLengthAdjust.valueOf(str);
        invalidate();
    }

    public void setMethod(@Nullable String str) {
        this.mAlignmentBaseline = TextProperties.AlignmentBaseline.getEnum(str);
        invalidate();
    }

    public void setBaselineShift(Dynamic dynamic) {
        this.mBaselineShift = SVGLength.toString(dynamic);
        invalidate();
    }

    public void setBaselineShift(String str) {
        this.mBaselineShift = str;
        invalidate();
    }

    public void setBaselineShift(Double d) {
        this.mBaselineShift = String.valueOf(d);
        invalidate();
    }

    public void setVerticalAlign(@Nullable String str) {
        if (str != null) {
            String trim = str.trim();
            int lastIndexOf = trim.lastIndexOf(32);
            try {
                this.mAlignmentBaseline = TextProperties.AlignmentBaseline.getEnum(trim.substring(lastIndexOf));
            } catch (IllegalArgumentException unused) {
                this.mAlignmentBaseline = TextProperties.AlignmentBaseline.baseline;
            }
            try {
                this.mBaselineShift = trim.substring(0, lastIndexOf);
            } catch (IndexOutOfBoundsException unused2) {
                this.mBaselineShift = null;
            }
        } else {
            this.mAlignmentBaseline = TextProperties.AlignmentBaseline.baseline;
            this.mBaselineShift = null;
        }
        invalidate();
    }

    public void setRotate(Dynamic dynamic) {
        this.mRotate = SVGLength.arrayFrom(dynamic);
        invalidate();
    }

    public void setRotate(ReadableArray readableArray) {
        this.mRotate = SVGLength.arrayFrom(readableArray);
        invalidate();
    }

    public void setDeltaX(Dynamic dynamic) {
        this.mDeltaX = SVGLength.arrayFrom(dynamic);
        invalidate();
    }

    public void setDeltaX(ReadableArray readableArray) {
        this.mDeltaX = SVGLength.arrayFrom(readableArray);
        invalidate();
    }

    public void setDeltaY(Dynamic dynamic) {
        this.mDeltaY = SVGLength.arrayFrom(dynamic);
        invalidate();
    }

    public void setDeltaY(ReadableArray readableArray) {
        this.mDeltaY = SVGLength.arrayFrom(readableArray);
        invalidate();
    }

    public void setPositionX(Dynamic dynamic) {
        this.mPositionX = SVGLength.arrayFrom(dynamic);
        invalidate();
    }

    public void setPositionX(ReadableArray readableArray) {
        this.mPositionX = SVGLength.arrayFrom(readableArray);
        invalidate();
    }

    public void setPositionY(Dynamic dynamic) {
        this.mPositionY = SVGLength.arrayFrom(dynamic);
        invalidate();
    }

    public void setPositionY(ReadableArray readableArray) {
        this.mPositionY = SVGLength.arrayFrom(readableArray);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f) {
        setupGlyphContext(canvas);
        clip(canvas, paint);
        getGroupPath(canvas, paint);
        pushGlyphContext();
        drawGroup(canvas, paint, f);
        popGlyphContext();
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        if (this.mPath != null) {
            return this.mPath;
        }
        setupGlyphContext(canvas);
        return getGroupPath(canvas, paint);
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint, Region.Op op) {
        return getPath(canvas, paint);
    }

    /* access modifiers changed from: package-private */
    public TextProperties.AlignmentBaseline getAlignmentBaseline() {
        TextProperties.AlignmentBaseline alignmentBaseline;
        if (this.mAlignmentBaseline == null) {
            ViewParent parent = getParent();
            while (parent != null) {
                if (!(parent instanceof TextView) || (alignmentBaseline = ((TextView) parent).mAlignmentBaseline) == null) {
                    parent = parent.getParent();
                } else {
                    this.mAlignmentBaseline = alignmentBaseline;
                    return alignmentBaseline;
                }
            }
        }
        if (this.mAlignmentBaseline == null) {
            this.mAlignmentBaseline = TextProperties.AlignmentBaseline.baseline;
        }
        return this.mAlignmentBaseline;
    }

    /* access modifiers changed from: package-private */
    public String getBaselineShift() {
        String str;
        if (this.mBaselineShift == null) {
            ViewParent parent = getParent();
            while (parent != null) {
                if (!(parent instanceof TextView) || (str = ((TextView) parent).mBaselineShift) == null) {
                    parent = parent.getParent();
                } else {
                    this.mBaselineShift = str;
                    return str;
                }
            }
        }
        return this.mBaselineShift;
    }

    /* access modifiers changed from: package-private */
    public Path getGroupPath(Canvas canvas, Paint paint) {
        if (this.mPath != null) {
            return this.mPath;
        }
        pushGlyphContext();
        this.mPath = super.getPath(canvas, paint);
        popGlyphContext();
        return this.mPath;
    }

    /* access modifiers changed from: package-private */
    public void pushGlyphContext() {
        getTextRootGlyphContext().pushContext(!(this instanceof TextPathView) && !(this instanceof TSpanView), this, this.mFont, this.mPositionX, this.mPositionY, this.mDeltaX, this.mDeltaY, this.mRotate);
    }

    /* access modifiers changed from: package-private */
    public TextView getTextAnchorRoot() {
        ArrayList<FontData> arrayList = getTextRootGlyphContext().mFontContext;
        ViewParent parent = getParent();
        int size = arrayList.size() - 1;
        TextView textView = this;
        ViewParent viewParent = parent;
        while (size >= 0 && (viewParent instanceof TextView) && arrayList.get(size).textAnchor != TextProperties.TextAnchor.start && textView.mPositionX == null) {
            textView = (TextView) viewParent;
            size--;
            viewParent = textView.getParent();
        }
        return textView;
    }

    /* access modifiers changed from: package-private */
    public double getSubtreeTextChunksTotalAdvance(Paint paint) {
        if (!Double.isNaN(this.cachedAdvance)) {
            return this.cachedAdvance;
        }
        double d = 0.0d;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TextView) {
                d += ((TextView) childAt).getSubtreeTextChunksTotalAdvance(paint);
            }
        }
        this.cachedAdvance = d;
        return d;
    }

    /* access modifiers changed from: package-private */
    public TextView getTextContainer() {
        TextView textView = this;
        ViewParent viewParent = getParent();
        while (viewParent instanceof TextView) {
            textView = (TextView) viewParent;
            viewParent = textView.getParent();
        }
        return textView;
    }
}
