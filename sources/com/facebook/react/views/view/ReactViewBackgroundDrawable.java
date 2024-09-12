package com.facebook.react.views.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.Spacing;
import com.facebook.yoga.YogaConstants;
import java.util.Arrays;
import java.util.Locale;

public class ReactViewBackgroundDrawable extends Drawable {
    private static final int ALL_BITS_SET = -1;
    private static final int ALL_BITS_UNSET = 0;
    private static final int DEFAULT_BORDER_ALPHA = 255;
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final int DEFAULT_BORDER_RGB = 0;
    private int mAlpha = 255;
    private Spacing mBorderAlpha;
    private float[] mBorderCornerRadii;
    private Spacing mBorderRGB;
    private float mBorderRadius = Float.NaN;
    private BorderStyle mBorderStyle;
    private Spacing mBorderWidth;
    private Path mCenterDrawPath;
    private int mColor = 0;
    private final Context mContext;
    private PointF mInnerBottomLeftCorner;
    private PointF mInnerBottomRightCorner;
    private Path mInnerClipPathForBorderRadius;
    private RectF mInnerClipTempRectForBorderRadius;
    private PointF mInnerTopLeftCorner;
    private PointF mInnerTopRightCorner;
    private int mLayoutDirection;
    private boolean mNeedUpdatePathForBorderRadius = false;
    private Path mOuterClipPathForBorderRadius;
    private RectF mOuterClipTempRectForBorderRadius;
    private final Paint mPaint = new Paint(1);
    private Path mPathForBorder;
    private Path mPathForBorderRadiusOutline;
    private final Path mPathForSingleBorder = new Path();
    private RectF mTempRectForBorderRadiusOutline;
    private RectF mTempRectForCenterDrawPath;

    public enum BorderRadiusLocation {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        TOP_START,
        TOP_END,
        BOTTOM_START,
        BOTTOM_END
    }

    private static int colorFromAlphaAndRGBComponents(float f, float f2) {
        return ((((int) f) << 24) & -16777216) | (((int) f2) & ViewCompat.MEASURED_SIZE_MASK);
    }

    private static int fastBorderCompatibleColorOrZero(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = -1;
        int i10 = (i > 0 ? i5 : -1) & (i2 > 0 ? i6 : -1) & (i3 > 0 ? i7 : -1);
        if (i4 > 0) {
            i9 = i8;
        }
        int i11 = i9 & i10;
        if (i <= 0) {
            i5 = 0;
        }
        if (i2 <= 0) {
            i6 = 0;
        }
        int i12 = i5 | i6;
        if (i3 <= 0) {
            i7 = 0;
        }
        int i13 = i12 | i7;
        if (i4 <= 0) {
            i8 = 0;
        }
        if (i11 == (i13 | i8)) {
            return i11;
        }
        return 0;
    }

    public boolean onResolvedLayoutDirectionChanged(int i) {
        return false;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* renamed from: com.facebook.react.views.view.ReactViewBackgroundDrawable$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderStyle[] r0 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderStyle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle = r0
                com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderStyle r1 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderStyle.SOLID     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderStyle r1 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderStyle.DASHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderStyle r1 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderStyle.DOTTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.ReactViewBackgroundDrawable.AnonymousClass1.<clinit>():void");
        }
    }

    private enum BorderStyle {
        SOLID,
        DASHED,
        DOTTED;

        public static PathEffect getPathEffect(BorderStyle borderStyle, float f) {
            int i = AnonymousClass1.$SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle[borderStyle.ordinal()];
            if (i == 2) {
                float f2 = f * 3.0f;
                return new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
            } else if (i != 3) {
                return null;
            } else {
                return new DashPathEffect(new float[]{f, f, f, f}, 0.0f);
            }
        }
    }

    public ReactViewBackgroundDrawable(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        updatePathEffect();
        if (!hasRoundedBorders()) {
            drawRectangularBackgroundWithBorders(canvas);
        } else {
            drawRoundedBackgroundWithBorders(canvas);
        }
    }

    public boolean hasRoundedBorders() {
        if (!YogaConstants.isUndefined(this.mBorderRadius) && this.mBorderRadius > 0.0f) {
            return true;
        }
        float[] fArr = this.mBorderCornerRadii;
        if (fArr != null) {
            for (float f : fArr) {
                if (!YogaConstants.isUndefined(f) && f > 0.0f) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mNeedUpdatePathForBorderRadius = true;
    }

    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getOpacity() {
        return ColorUtil.getOpacityFromColor(ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha));
    }

    public void getOutline(Outline outline) {
        if ((YogaConstants.isUndefined(this.mBorderRadius) || this.mBorderRadius <= 0.0f) && this.mBorderCornerRadii == null) {
            outline.setRect(getBounds());
            return;
        }
        updatePath();
        outline.setConvexPath(this.mPathForBorderRadiusOutline);
    }

    public void setBorderWidth(int i, float f) {
        if (this.mBorderWidth == null) {
            this.mBorderWidth = new Spacing();
        }
        if (!FloatUtil.floatsEqual(this.mBorderWidth.getRaw(i), f)) {
            this.mBorderWidth.set(i, f);
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) {
                this.mNeedUpdatePathForBorderRadius = true;
            }
            invalidateSelf();
        }
    }

    public void setBorderColor(int i, float f, float f2) {
        setBorderRGB(i, f);
        setBorderAlpha(i, f2);
        this.mNeedUpdatePathForBorderRadius = true;
    }

    private void setBorderRGB(int i, float f) {
        if (this.mBorderRGB == null) {
            this.mBorderRGB = new Spacing(0.0f);
        }
        if (!FloatUtil.floatsEqual(this.mBorderRGB.getRaw(i), f)) {
            this.mBorderRGB.set(i, f);
            invalidateSelf();
        }
    }

    private void setBorderAlpha(int i, float f) {
        if (this.mBorderAlpha == null) {
            this.mBorderAlpha = new Spacing(255.0f);
        }
        if (!FloatUtil.floatsEqual(this.mBorderAlpha.getRaw(i), f)) {
            this.mBorderAlpha.set(i, f);
            invalidateSelf();
        }
    }

    public void setBorderStyle(String str) {
        BorderStyle valueOf = str == null ? null : BorderStyle.valueOf(str.toUpperCase(Locale.US));
        if (this.mBorderStyle != valueOf) {
            this.mBorderStyle = valueOf;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public void setRadius(float f) {
        if (!FloatUtil.floatsEqual(this.mBorderRadius, f)) {
            this.mBorderRadius = f;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public void setRadius(float f, int i) {
        if (this.mBorderCornerRadii == null) {
            float[] fArr = new float[8];
            this.mBorderCornerRadii = fArr;
            Arrays.fill(fArr, Float.NaN);
        }
        if (!FloatUtil.floatsEqual(this.mBorderCornerRadii[i], f)) {
            this.mBorderCornerRadii[i] = f;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public float getFullBorderRadius() {
        if (YogaConstants.isUndefined(this.mBorderRadius)) {
            return 0.0f;
        }
        return this.mBorderRadius;
    }

    public float getBorderRadius(BorderRadiusLocation borderRadiusLocation) {
        return getBorderRadiusOrDefaultTo(Float.NaN, borderRadiusLocation);
    }

    public float getBorderRadiusOrDefaultTo(float f, BorderRadiusLocation borderRadiusLocation) {
        float[] fArr = this.mBorderCornerRadii;
        if (fArr == null) {
            return f;
        }
        float f2 = fArr[borderRadiusLocation.ordinal()];
        return YogaConstants.isUndefined(f2) ? f : f2;
    }

    public void setColor(int i) {
        this.mColor = i;
        invalidateSelf();
    }

    public int getResolvedLayoutDirection() {
        return this.mLayoutDirection;
    }

    public boolean setResolvedLayoutDirection(int i) {
        if (this.mLayoutDirection == i) {
            return false;
        }
        this.mLayoutDirection = i;
        return onResolvedLayoutDirectionChanged(i);
    }

    public int getColor() {
        return this.mColor;
    }

    private void drawRoundedBackgroundWithBorders(Canvas canvas) {
        int i;
        int i2;
        float f;
        float f2;
        float f3;
        float f4;
        Canvas canvas2 = canvas;
        updatePath();
        canvas.save();
        int multiplyColorAlpha = ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha);
        if (Color.alpha(multiplyColorAlpha) != 0) {
            this.mPaint.setColor(multiplyColorAlpha);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas2.drawPath(this.mInnerClipPathForBorderRadius, this.mPaint);
        }
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        boolean z = false;
        int borderColor = getBorderColor(0);
        int borderColor2 = getBorderColor(1);
        int borderColor3 = getBorderColor(2);
        int borderColor4 = getBorderColor(3);
        if (directionAwareBorderInsets.top > 0.0f || directionAwareBorderInsets.bottom > 0.0f || directionAwareBorderInsets.left > 0.0f || directionAwareBorderInsets.right > 0.0f) {
            float fullBorderWidth = getFullBorderWidth();
            int borderColor5 = getBorderColor(8);
            if (directionAwareBorderInsets.top != fullBorderWidth || directionAwareBorderInsets.bottom != fullBorderWidth || directionAwareBorderInsets.left != fullBorderWidth || directionAwareBorderInsets.right != fullBorderWidth || borderColor != borderColor5 || borderColor2 != borderColor5 || borderColor3 != borderColor5 || borderColor4 != borderColor5) {
                this.mPaint.setStyle(Paint.Style.FILL);
                canvas2.clipPath(this.mOuterClipPathForBorderRadius, Region.Op.INTERSECT);
                canvas2.clipPath(this.mInnerClipPathForBorderRadius, Region.Op.DIFFERENCE);
                if (getResolvedLayoutDirection() == 1) {
                    z = true;
                }
                int borderColor6 = getBorderColor(4);
                int borderColor7 = getBorderColor(5);
                if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                    if (isBorderColorDefined(4)) {
                        borderColor = borderColor6;
                    }
                    if (isBorderColorDefined(5)) {
                        borderColor3 = borderColor7;
                    }
                    i2 = z ? borderColor3 : borderColor;
                    if (!z) {
                        borderColor = borderColor3;
                    }
                    i = borderColor;
                } else {
                    int i3 = z ? borderColor7 : borderColor6;
                    if (!z) {
                        borderColor6 = borderColor7;
                    }
                    boolean isBorderColorDefined = isBorderColorDefined(4);
                    boolean isBorderColorDefined2 = isBorderColorDefined(5);
                    boolean z2 = z ? isBorderColorDefined2 : isBorderColorDefined;
                    if (!z) {
                        isBorderColorDefined = isBorderColorDefined2;
                    }
                    if (z2) {
                        borderColor = i3;
                    }
                    if (isBorderColorDefined) {
                        i2 = borderColor;
                        i = borderColor6;
                    } else {
                        i2 = borderColor;
                        i = borderColor3;
                    }
                }
                float f5 = this.mOuterClipTempRectForBorderRadius.left;
                float f6 = this.mOuterClipTempRectForBorderRadius.right;
                float f7 = this.mOuterClipTempRectForBorderRadius.top;
                float f8 = this.mOuterClipTempRectForBorderRadius.bottom;
                if (directionAwareBorderInsets.left > 0.0f) {
                    f2 = f8;
                    f3 = f7;
                    f4 = f6;
                    f = f5;
                    drawQuadrilateral(canvas, i2, f5, f7, this.mInnerTopLeftCorner.x, this.mInnerTopLeftCorner.y, this.mInnerBottomLeftCorner.x, this.mInnerBottomLeftCorner.y, f5, f2);
                } else {
                    f2 = f8;
                    f3 = f7;
                    f4 = f6;
                    f = f5;
                }
                if (directionAwareBorderInsets.top > 0.0f) {
                    drawQuadrilateral(canvas, borderColor2, f, f3, this.mInnerTopLeftCorner.x, this.mInnerTopLeftCorner.y, this.mInnerTopRightCorner.x, this.mInnerTopRightCorner.y, f4, f3);
                }
                if (directionAwareBorderInsets.right > 0.0f) {
                    drawQuadrilateral(canvas, i, f4, f3, this.mInnerTopRightCorner.x, this.mInnerTopRightCorner.y, this.mInnerBottomRightCorner.x, this.mInnerBottomRightCorner.y, f4, f2);
                }
                if (directionAwareBorderInsets.bottom > 0.0f) {
                    drawQuadrilateral(canvas, borderColor4, f, f2, this.mInnerBottomLeftCorner.x, this.mInnerBottomLeftCorner.y, this.mInnerBottomRightCorner.x, this.mInnerBottomRightCorner.y, f4, f2);
                }
            } else if (fullBorderWidth > 0.0f) {
                this.mPaint.setColor(ColorUtil.multiplyColorAlpha(borderColor5, this.mAlpha));
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(fullBorderWidth);
                canvas2.drawPath(this.mCenterDrawPath, this.mPaint);
            }
        }
        canvas.restore();
    }

    private void updatePath() {
        float f;
        float f2;
        if (this.mNeedUpdatePathForBorderRadius) {
            this.mNeedUpdatePathForBorderRadius = false;
            if (this.mInnerClipPathForBorderRadius == null) {
                this.mInnerClipPathForBorderRadius = new Path();
            }
            if (this.mOuterClipPathForBorderRadius == null) {
                this.mOuterClipPathForBorderRadius = new Path();
            }
            if (this.mPathForBorderRadiusOutline == null) {
                this.mPathForBorderRadiusOutline = new Path();
            }
            if (this.mCenterDrawPath == null) {
                this.mCenterDrawPath = new Path();
            }
            if (this.mInnerClipTempRectForBorderRadius == null) {
                this.mInnerClipTempRectForBorderRadius = new RectF();
            }
            if (this.mOuterClipTempRectForBorderRadius == null) {
                this.mOuterClipTempRectForBorderRadius = new RectF();
            }
            if (this.mTempRectForBorderRadiusOutline == null) {
                this.mTempRectForBorderRadiusOutline = new RectF();
            }
            if (this.mTempRectForCenterDrawPath == null) {
                this.mTempRectForCenterDrawPath = new RectF();
            }
            this.mInnerClipPathForBorderRadius.reset();
            this.mOuterClipPathForBorderRadius.reset();
            this.mPathForBorderRadiusOutline.reset();
            this.mCenterDrawPath.reset();
            this.mInnerClipTempRectForBorderRadius.set(getBounds());
            this.mOuterClipTempRectForBorderRadius.set(getBounds());
            this.mTempRectForBorderRadiusOutline.set(getBounds());
            this.mTempRectForCenterDrawPath.set(getBounds());
            RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
            int borderColor = getBorderColor(0);
            int borderColor2 = getBorderColor(1);
            int borderColor3 = getBorderColor(2);
            int borderColor4 = getBorderColor(3);
            int borderColor5 = getBorderColor(8);
            if (!(Color.alpha(borderColor) == 0 || Color.alpha(borderColor2) == 0 || Color.alpha(borderColor3) == 0 || Color.alpha(borderColor4) == 0 || Color.alpha(borderColor5) == 0)) {
                this.mInnerClipTempRectForBorderRadius.top += directionAwareBorderInsets.top;
                this.mInnerClipTempRectForBorderRadius.bottom -= directionAwareBorderInsets.bottom;
                this.mInnerClipTempRectForBorderRadius.left += directionAwareBorderInsets.left;
                this.mInnerClipTempRectForBorderRadius.right -= directionAwareBorderInsets.right;
            }
            this.mTempRectForCenterDrawPath.top += directionAwareBorderInsets.top * 0.5f;
            this.mTempRectForCenterDrawPath.bottom -= directionAwareBorderInsets.bottom * 0.5f;
            this.mTempRectForCenterDrawPath.left += directionAwareBorderInsets.left * 0.5f;
            this.mTempRectForCenterDrawPath.right -= directionAwareBorderInsets.right * 0.5f;
            float fullBorderRadius = getFullBorderRadius();
            float borderRadiusOrDefaultTo = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_LEFT);
            float borderRadiusOrDefaultTo2 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_RIGHT);
            float borderRadiusOrDefaultTo3 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_LEFT);
            float borderRadiusOrDefaultTo4 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_RIGHT);
            boolean z = getResolvedLayoutDirection() == 1;
            float borderRadius = getBorderRadius(BorderRadiusLocation.TOP_START);
            float borderRadius2 = getBorderRadius(BorderRadiusLocation.TOP_END);
            float borderRadius3 = getBorderRadius(BorderRadiusLocation.BOTTOM_START);
            float borderRadius4 = getBorderRadius(BorderRadiusLocation.BOTTOM_END);
            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                if (!YogaConstants.isUndefined(borderRadius)) {
                    borderRadiusOrDefaultTo = borderRadius;
                }
                if (!YogaConstants.isUndefined(borderRadius2)) {
                    borderRadiusOrDefaultTo2 = borderRadius2;
                }
                if (!YogaConstants.isUndefined(borderRadius3)) {
                    borderRadiusOrDefaultTo3 = borderRadius3;
                }
                if (!YogaConstants.isUndefined(borderRadius4)) {
                    borderRadiusOrDefaultTo4 = borderRadius4;
                }
                f2 = z ? borderRadiusOrDefaultTo2 : borderRadiusOrDefaultTo;
                if (!z) {
                    borderRadiusOrDefaultTo = borderRadiusOrDefaultTo2;
                }
                f = z ? borderRadiusOrDefaultTo4 : borderRadiusOrDefaultTo3;
                if (z) {
                    borderRadiusOrDefaultTo4 = borderRadiusOrDefaultTo3;
                }
            } else {
                float f3 = z ? borderRadius2 : borderRadius;
                if (!z) {
                    borderRadius = borderRadius2;
                }
                float f4 = z ? borderRadius4 : borderRadius3;
                if (!z) {
                    borderRadius3 = borderRadius4;
                }
                if (!YogaConstants.isUndefined(f3)) {
                    borderRadiusOrDefaultTo = f3;
                }
                if (!YogaConstants.isUndefined(borderRadius)) {
                    borderRadiusOrDefaultTo2 = borderRadius;
                }
                if (!YogaConstants.isUndefined(f4)) {
                    borderRadiusOrDefaultTo3 = f4;
                }
                if (!YogaConstants.isUndefined(borderRadius3)) {
                    f2 = borderRadiusOrDefaultTo;
                    borderRadiusOrDefaultTo = borderRadiusOrDefaultTo2;
                    f = borderRadiusOrDefaultTo3;
                    borderRadiusOrDefaultTo4 = borderRadius3;
                } else {
                    f2 = borderRadiusOrDefaultTo;
                    borderRadiusOrDefaultTo = borderRadiusOrDefaultTo2;
                    f = borderRadiusOrDefaultTo3;
                }
            }
            float max = Math.max(f2 - directionAwareBorderInsets.left, 0.0f);
            float max2 = Math.max(f2 - directionAwareBorderInsets.top, 0.0f);
            float max3 = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.right, 0.0f);
            float max4 = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.top, 0.0f);
            float max5 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.right, 0.0f);
            float max6 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.bottom, 0.0f);
            float max7 = Math.max(f - directionAwareBorderInsets.left, 0.0f);
            float max8 = Math.max(f - directionAwareBorderInsets.bottom, 0.0f);
            RectF rectF = directionAwareBorderInsets;
            float f5 = f;
            this.mInnerClipPathForBorderRadius.addRoundRect(this.mInnerClipTempRectForBorderRadius, new float[]{max, max2, max3, max4, max5, max6, max7, max8}, Path.Direction.CW);
            this.mOuterClipPathForBorderRadius.addRoundRect(this.mOuterClipTempRectForBorderRadius, new float[]{f2, f2, borderRadiusOrDefaultTo, borderRadiusOrDefaultTo, borderRadiusOrDefaultTo4, borderRadiusOrDefaultTo4, f5, f5}, Path.Direction.CW);
            Spacing spacing = this.mBorderWidth;
            float f6 = spacing != null ? spacing.get(8) / 2.0f : 0.0f;
            float f7 = max6;
            float f8 = f2 + f6;
            float f9 = borderRadiusOrDefaultTo + f6;
            float f10 = borderRadiusOrDefaultTo4 + f6;
            float f11 = f5 + f6;
            this.mPathForBorderRadiusOutline.addRoundRect(this.mTempRectForBorderRadiusOutline, new float[]{f8, f8, f9, f9, f10, f10, f11, f11}, Path.Direction.CW);
            Path path = this.mCenterDrawPath;
            RectF rectF2 = this.mTempRectForCenterDrawPath;
            float[] fArr = new float[8];
            RectF rectF3 = rectF;
            float f12 = max5;
            fArr[0] = Math.max(f2 - (rectF3.left * 0.5f), rectF3.left > 0.0f ? f2 / rectF3.left : 0.0f);
            fArr[1] = Math.max(f2 - (rectF3.top * 0.5f), rectF3.top > 0.0f ? f2 / rectF3.top : 0.0f);
            fArr[2] = Math.max(borderRadiusOrDefaultTo - (rectF3.right * 0.5f), rectF3.right > 0.0f ? borderRadiusOrDefaultTo / rectF3.right : 0.0f);
            fArr[3] = Math.max(borderRadiusOrDefaultTo - (rectF3.top * 0.5f), rectF3.top > 0.0f ? borderRadiusOrDefaultTo / rectF3.top : 0.0f);
            fArr[4] = Math.max(borderRadiusOrDefaultTo4 - (rectF3.right * 0.5f), rectF3.right > 0.0f ? borderRadiusOrDefaultTo4 / rectF3.right : 0.0f);
            fArr[5] = Math.max(borderRadiusOrDefaultTo4 - (rectF3.bottom * 0.5f), rectF3.bottom > 0.0f ? borderRadiusOrDefaultTo4 / rectF3.bottom : 0.0f);
            fArr[6] = Math.max(f5 - (rectF3.left * 0.5f), rectF3.left > 0.0f ? f5 / rectF3.left : 0.0f);
            fArr[7] = Math.max(f5 - (rectF3.bottom * 0.5f), rectF3.bottom > 0.0f ? f5 / rectF3.bottom : 0.0f);
            path.addRoundRect(rectF2, fArr, Path.Direction.CW);
            if (this.mInnerTopLeftCorner == null) {
                this.mInnerTopLeftCorner = new PointF();
            }
            this.mInnerTopLeftCorner.x = this.mInnerClipTempRectForBorderRadius.left;
            this.mInnerTopLeftCorner.y = this.mInnerClipTempRectForBorderRadius.top;
            getEllipseIntersectionWithLine((double) this.mInnerClipTempRectForBorderRadius.left, (double) this.mInnerClipTempRectForBorderRadius.top, (double) (this.mInnerClipTempRectForBorderRadius.left + (max * 2.0f)), (double) (this.mInnerClipTempRectForBorderRadius.top + (max2 * 2.0f)), (double) this.mOuterClipTempRectForBorderRadius.left, (double) this.mOuterClipTempRectForBorderRadius.top, (double) this.mInnerClipTempRectForBorderRadius.left, (double) this.mInnerClipTempRectForBorderRadius.top, this.mInnerTopLeftCorner);
            if (this.mInnerBottomLeftCorner == null) {
                this.mInnerBottomLeftCorner = new PointF();
            }
            this.mInnerBottomLeftCorner.x = this.mInnerClipTempRectForBorderRadius.left;
            this.mInnerBottomLeftCorner.y = this.mInnerClipTempRectForBorderRadius.bottom;
            getEllipseIntersectionWithLine((double) this.mInnerClipTempRectForBorderRadius.left, (double) (this.mInnerClipTempRectForBorderRadius.bottom - (max8 * 2.0f)), (double) (this.mInnerClipTempRectForBorderRadius.left + (max7 * 2.0f)), (double) this.mInnerClipTempRectForBorderRadius.bottom, (double) this.mOuterClipTempRectForBorderRadius.left, (double) this.mOuterClipTempRectForBorderRadius.bottom, (double) this.mInnerClipTempRectForBorderRadius.left, (double) this.mInnerClipTempRectForBorderRadius.bottom, this.mInnerBottomLeftCorner);
            if (this.mInnerTopRightCorner == null) {
                this.mInnerTopRightCorner = new PointF();
            }
            this.mInnerTopRightCorner.x = this.mInnerClipTempRectForBorderRadius.right;
            this.mInnerTopRightCorner.y = this.mInnerClipTempRectForBorderRadius.top;
            getEllipseIntersectionWithLine((double) (this.mInnerClipTempRectForBorderRadius.right - (max3 * 2.0f)), (double) this.mInnerClipTempRectForBorderRadius.top, (double) this.mInnerClipTempRectForBorderRadius.right, (double) (this.mInnerClipTempRectForBorderRadius.top + (max4 * 2.0f)), (double) this.mOuterClipTempRectForBorderRadius.right, (double) this.mOuterClipTempRectForBorderRadius.top, (double) this.mInnerClipTempRectForBorderRadius.right, (double) this.mInnerClipTempRectForBorderRadius.top, this.mInnerTopRightCorner);
            if (this.mInnerBottomRightCorner == null) {
                this.mInnerBottomRightCorner = new PointF();
            }
            this.mInnerBottomRightCorner.x = this.mInnerClipTempRectForBorderRadius.right;
            this.mInnerBottomRightCorner.y = this.mInnerClipTempRectForBorderRadius.bottom;
            getEllipseIntersectionWithLine((double) (this.mInnerClipTempRectForBorderRadius.right - (f12 * 2.0f)), (double) (this.mInnerClipTempRectForBorderRadius.bottom - (f7 * 2.0f)), (double) this.mInnerClipTempRectForBorderRadius.right, (double) this.mInnerClipTempRectForBorderRadius.bottom, (double) this.mOuterClipTempRectForBorderRadius.right, (double) this.mOuterClipTempRectForBorderRadius.bottom, (double) this.mInnerClipTempRectForBorderRadius.right, (double) this.mInnerClipTempRectForBorderRadius.bottom, this.mInnerBottomRightCorner);
        }
    }

    private static void getEllipseIntersectionWithLine(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, PointF pointF) {
        PointF pointF2 = pointF;
        double d9 = (d + d3) / 2.0d;
        double d10 = (d2 + d4) / 2.0d;
        double d11 = d5 - d9;
        double d12 = d6 - d10;
        double abs = Math.abs(d3 - d) / 2.0d;
        double abs2 = Math.abs(d4 - d2) / 2.0d;
        double d13 = ((d8 - d10) - d12) / ((d7 - d9) - d11);
        double d14 = d12 - (d11 * d13);
        double d15 = abs2 * abs2;
        double d16 = abs * abs;
        double d17 = d15 + (d16 * d13 * d13);
        double d18 = abs * 2.0d * abs * d14 * d13;
        double d19 = (-(d16 * ((d14 * d14) - d15))) / d17;
        double d20 = d17 * 2.0d;
        double sqrt = ((-d18) / d20) - Math.sqrt(d19 + Math.pow(d18 / d20, 2.0d));
        double d21 = (d13 * sqrt) + d14;
        double d22 = sqrt + d9;
        double d23 = d21 + d10;
        if (!Double.isNaN(d22) && !Double.isNaN(d23)) {
            PointF pointF3 = pointF;
            pointF3.x = (float) d22;
            pointF3.y = (float) d23;
        }
    }

    public float getBorderWidthOrDefaultTo(float f, int i) {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null) {
            return f;
        }
        float raw = spacing.getRaw(i);
        return YogaConstants.isUndefined(raw) ? f : raw;
    }

    private void updatePathEffect() {
        BorderStyle borderStyle = this.mBorderStyle;
        this.mPaint.setPathEffect(borderStyle != null ? BorderStyle.getPathEffect(borderStyle, getFullBorderWidth()) : null);
    }

    private void updatePathEffect(int i) {
        BorderStyle borderStyle = this.mBorderStyle;
        this.mPaint.setPathEffect(borderStyle != null ? BorderStyle.getPathEffect(borderStyle, (float) i) : null);
    }

    public float getFullBorderWidth() {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null || YogaConstants.isUndefined(spacing.getRaw(8))) {
            return 0.0f;
        }
        return this.mBorderWidth.getRaw(8);
    }

    private void drawRectangularBackgroundWithBorders(Canvas canvas) {
        int i;
        int i2;
        int i3;
        Canvas canvas2 = canvas;
        this.mPaint.setStyle(Paint.Style.FILL);
        int multiplyColorAlpha = ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha);
        if (Color.alpha(multiplyColorAlpha) != 0) {
            this.mPaint.setColor(multiplyColorAlpha);
            canvas2.drawRect(getBounds(), this.mPaint);
        }
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        int round = Math.round(directionAwareBorderInsets.left);
        int round2 = Math.round(directionAwareBorderInsets.top);
        int round3 = Math.round(directionAwareBorderInsets.right);
        int round4 = Math.round(directionAwareBorderInsets.bottom);
        if (round > 0 || round3 > 0 || round2 > 0 || round4 > 0) {
            Rect bounds = getBounds();
            int borderColor = getBorderColor(0);
            int borderColor2 = getBorderColor(1);
            int borderColor3 = getBorderColor(2);
            int borderColor4 = getBorderColor(3);
            boolean z = getResolvedLayoutDirection() == 1;
            int borderColor5 = getBorderColor(4);
            int borderColor6 = getBorderColor(5);
            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                if (isBorderColorDefined(4)) {
                    borderColor = borderColor5;
                }
                if (isBorderColorDefined(5)) {
                    borderColor3 = borderColor6;
                }
                int i4 = z ? borderColor3 : borderColor;
                if (!z) {
                    borderColor = borderColor3;
                }
                i = borderColor;
                i2 = i4;
            } else {
                int i5 = z ? borderColor6 : borderColor5;
                if (!z) {
                    borderColor5 = borderColor6;
                }
                boolean isBorderColorDefined = isBorderColorDefined(4);
                boolean isBorderColorDefined2 = isBorderColorDefined(5);
                boolean z2 = z ? isBorderColorDefined2 : isBorderColorDefined;
                if (!z) {
                    isBorderColorDefined = isBorderColorDefined2;
                }
                if (z2) {
                    borderColor = i5;
                }
                i2 = borderColor;
                i = isBorderColorDefined ? borderColor5 : borderColor3;
            }
            int i6 = bounds.left;
            int i7 = bounds.top;
            int i8 = round3;
            int i9 = i6;
            int fastBorderCompatibleColorOrZero = fastBorderCompatibleColorOrZero(round, round2, round3, round4, i2, borderColor2, i, borderColor4);
            if (fastBorderCompatibleColorOrZero == 0) {
                this.mPaint.setAntiAlias(false);
                int width = bounds.width();
                int height = bounds.height();
                if (round > 0) {
                    float f = (float) i9;
                    float f2 = (float) (i9 + round);
                    int i10 = i7 + height;
                    i3 = i7;
                    drawQuadrilateral(canvas, i2, f, (float) i7, f2, (float) (i7 + round2), f2, (float) (i10 - round4), f, (float) i10);
                } else {
                    i3 = i7;
                }
                if (round2 > 0) {
                    float f3 = (float) i3;
                    float f4 = (float) (i3 + round2);
                    int i11 = i9 + width;
                    drawQuadrilateral(canvas, borderColor2, (float) i9, f3, (float) (i9 + round), f4, (float) (i11 - i8), f4, (float) i11, f3);
                }
                if (i8 > 0) {
                    int i12 = i9 + width;
                    float f5 = (float) i12;
                    int i13 = i3 + height;
                    float f6 = (float) (i12 - i8);
                    drawQuadrilateral(canvas, i, f5, (float) i3, f5, (float) i13, f6, (float) (i13 - round4), f6, (float) (i3 + round2));
                }
                if (round4 > 0) {
                    int i14 = i3 + height;
                    float f7 = (float) i14;
                    int i15 = i9 + width;
                    float f8 = (float) (i14 - round4);
                    drawQuadrilateral(canvas, borderColor4, (float) i9, f7, (float) i15, f7, (float) (i15 - i8), f8, (float) (i9 + round), f8);
                }
                this.mPaint.setAntiAlias(true);
            } else if (Color.alpha(fastBorderCompatibleColorOrZero) != 0) {
                int i16 = bounds.right;
                int i17 = bounds.bottom;
                this.mPaint.setColor(fastBorderCompatibleColorOrZero);
                this.mPaint.setStyle(Paint.Style.STROKE);
                if (round > 0) {
                    this.mPathForSingleBorder.reset();
                    int round5 = Math.round(directionAwareBorderInsets.left);
                    updatePathEffect(round5);
                    this.mPaint.setStrokeWidth((float) round5);
                    float f9 = (float) (i9 + (round5 / 2));
                    this.mPathForSingleBorder.moveTo(f9, (float) i7);
                    this.mPathForSingleBorder.lineTo(f9, (float) i17);
                    canvas2.drawPath(this.mPathForSingleBorder, this.mPaint);
                }
                if (round2 > 0) {
                    this.mPathForSingleBorder.reset();
                    int round6 = Math.round(directionAwareBorderInsets.top);
                    updatePathEffect(round6);
                    this.mPaint.setStrokeWidth((float) round6);
                    float f10 = (float) (i7 + (round6 / 2));
                    this.mPathForSingleBorder.moveTo((float) i9, f10);
                    this.mPathForSingleBorder.lineTo((float) i16, f10);
                    canvas2.drawPath(this.mPathForSingleBorder, this.mPaint);
                }
                if (i8 > 0) {
                    this.mPathForSingleBorder.reset();
                    int round7 = Math.round(directionAwareBorderInsets.right);
                    updatePathEffect(round7);
                    this.mPaint.setStrokeWidth((float) round7);
                    float f11 = (float) (i16 - (round7 / 2));
                    this.mPathForSingleBorder.moveTo(f11, (float) i7);
                    this.mPathForSingleBorder.lineTo(f11, (float) i17);
                    canvas2.drawPath(this.mPathForSingleBorder, this.mPaint);
                }
                if (round4 > 0) {
                    this.mPathForSingleBorder.reset();
                    int round8 = Math.round(directionAwareBorderInsets.bottom);
                    updatePathEffect(round8);
                    this.mPaint.setStrokeWidth((float) round8);
                    float f12 = (float) (i17 - (round8 / 2));
                    this.mPathForSingleBorder.moveTo((float) i9, f12);
                    this.mPathForSingleBorder.lineTo((float) i16, f12);
                    canvas2.drawPath(this.mPathForSingleBorder, this.mPaint);
                }
            }
        }
    }

    private void drawQuadrilateral(Canvas canvas, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (i != 0) {
            if (this.mPathForBorder == null) {
                this.mPathForBorder = new Path();
            }
            this.mPaint.setColor(i);
            this.mPathForBorder.reset();
            this.mPathForBorder.moveTo(f, f2);
            this.mPathForBorder.lineTo(f3, f4);
            this.mPathForBorder.lineTo(f5, f6);
            this.mPathForBorder.lineTo(f7, f8);
            this.mPathForBorder.lineTo(f, f2);
            canvas.drawPath(this.mPathForBorder, this.mPaint);
        }
    }

    private int getBorderWidth(int i) {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null) {
            return 0;
        }
        float f = spacing.get(i);
        if (YogaConstants.isUndefined(f)) {
            return -1;
        }
        return Math.round(f);
    }

    private boolean isBorderColorDefined(int i) {
        Spacing spacing = this.mBorderRGB;
        float f = Float.NaN;
        float f2 = spacing != null ? spacing.get(i) : Float.NaN;
        Spacing spacing2 = this.mBorderAlpha;
        if (spacing2 != null) {
            f = spacing2.get(i);
        }
        return !YogaConstants.isUndefined(f2) && !YogaConstants.isUndefined(f);
    }

    public int getBorderColor(int i) {
        Spacing spacing = this.mBorderRGB;
        float f = spacing != null ? spacing.get(i) : 0.0f;
        Spacing spacing2 = this.mBorderAlpha;
        return colorFromAlphaAndRGBComponents(spacing2 != null ? spacing2.get(i) : 255.0f, f);
    }

    public RectF getDirectionAwareBorderInsets() {
        float borderWidthOrDefaultTo = getBorderWidthOrDefaultTo(0.0f, 8);
        boolean z = true;
        float borderWidthOrDefaultTo2 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 1);
        float borderWidthOrDefaultTo3 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 3);
        float borderWidthOrDefaultTo4 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 0);
        float borderWidthOrDefaultTo5 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 2);
        if (this.mBorderWidth != null) {
            if (getResolvedLayoutDirection() != 1) {
                z = false;
            }
            float raw = this.mBorderWidth.getRaw(4);
            float raw2 = this.mBorderWidth.getRaw(5);
            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                if (!YogaConstants.isUndefined(raw)) {
                    borderWidthOrDefaultTo4 = raw;
                }
                if (!YogaConstants.isUndefined(raw2)) {
                    borderWidthOrDefaultTo5 = raw2;
                }
                float f = z ? borderWidthOrDefaultTo5 : borderWidthOrDefaultTo4;
                if (z) {
                    borderWidthOrDefaultTo5 = borderWidthOrDefaultTo4;
                }
                borderWidthOrDefaultTo4 = f;
            } else {
                float f2 = z ? raw2 : raw;
                if (!z) {
                    raw = raw2;
                }
                if (!YogaConstants.isUndefined(f2)) {
                    borderWidthOrDefaultTo4 = f2;
                }
                if (!YogaConstants.isUndefined(raw)) {
                    borderWidthOrDefaultTo5 = raw;
                }
            }
        }
        return new RectF(borderWidthOrDefaultTo4, borderWidthOrDefaultTo2, borderWidthOrDefaultTo5, borderWidthOrDefaultTo3);
    }
}
