package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import com.braze.enums.inappmessage.CropType;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#J\u0010\u0010%\u001a\u00020&2\u0006\u0010 \u001a\u00020!H\u0014J\u0018\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020#H\u0014J\u0010\u0010*\u001a\u00020&2\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0016J\u0010\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\tH\u0016J\u0012\u00102\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u0010\u001b\u001a\u00020&2\u0006\u00105\u001a\u00020\u001cH\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u001e¨\u00066"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageImageView;", "Landroid/widget/ImageView;", "Lcom/braze/ui/inappmessage/views/IInAppMessageImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "aspectRatio", "", "clipPath", "Landroid/graphics/Path;", "getClipPath", "()Landroid/graphics/Path;", "setClipPath", "(Landroid/graphics/Path;)V", "<set-?>", "", "inAppRadii", "getInAppRadii", "()[F", "rectf", "Landroid/graphics/RectF;", "getRectf", "()Landroid/graphics/RectF;", "setRectf", "(Landroid/graphics/RectF;)V", "setToHalfParentHeight", "", "getSetToHalfParentHeight$annotations", "()V", "clipCanvasToPath", "canvas", "Landroid/graphics/Canvas;", "widthPx", "", "heightPx", "onDraw", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAspectRatio", "setCornersRadiiPx", "topLeft", "topRight", "bottomLeft", "bottomRight", "setCornersRadiusPx", "cornersRadius", "setInAppMessageImageCropType", "cropType", "Lcom/braze/enums/inappmessage/CropType;", "setToHalfHeight", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InAppMessageImageView.kt */
public class InAppMessageImageView extends ImageView implements IInAppMessageImageView {
    private float aspectRatio = -1.0f;
    private Path clipPath = new Path();
    private float[] inAppRadii;
    private RectF rectf = new RectF();
    private boolean setToHalfParentHeight;

    private static /* synthetic */ void getSetToHalfParentHeight$annotations() {
    }

    public InAppMessageImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setAdjustViewBounds(true);
    }

    public final Path getClipPath() {
        return this.clipPath;
    }

    public final void setClipPath(Path path) {
        Intrinsics.checkNotNullParameter(path, "<set-?>");
        this.clipPath = path;
    }

    public final RectF getRectf() {
        return this.rectf;
    }

    public final void setRectf(RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "<set-?>");
        this.rectf = rectF;
    }

    public final float[] getInAppRadii() {
        float[] fArr = this.inAppRadii;
        if (fArr != null) {
            return fArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inAppRadii");
        return null;
    }

    public void setCornersRadiiPx(float f, float f2, float f3, float f4) {
        this.inAppRadii = new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    public void setCornersRadiusPx(float f) {
        setCornersRadiiPx(f, f, f, f);
    }

    public void setInAppMessageImageCropType(CropType cropType) {
        if (cropType == CropType.FIT_CENTER) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else if (cropType == CropType.CENTER_CROP) {
            setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public void setAspectRatio(float f) {
        this.aspectRatio = f;
        requestLayout();
    }

    public void setToHalfParentHeight(boolean z) {
        this.setToHalfParentHeight = z;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        clipCanvasToPath(canvas, getWidth(), getHeight());
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if ((this.aspectRatio == -1.0f) || getMeasuredHeight() <= 0 || getMeasuredWidth() <= 0) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        } else {
            int measuredWidth = getMeasuredWidth();
            setMeasuredDimension(measuredWidth, Math.min(getMeasuredHeight(), (int) (((float) measuredWidth) / this.aspectRatio)) + 1);
        }
        if (this.setToHalfParentHeight) {
            ViewParent parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            setMeasuredDimension(getMeasuredWidth(), (int) (((double) ((View) parent).getHeight()) * 0.5d));
        }
    }

    public final boolean clipCanvasToPath(Canvas canvas, int i, int i2) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.inAppRadii == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) InAppMessageImageView$clipCanvasToPath$2.INSTANCE, 3, (Object) null);
            return false;
        }
        try {
            this.clipPath.reset();
            this.rectf.set(0.0f, 0.0f, (float) i, (float) i2);
            this.clipPath.addRoundRect(this.rectf, getInAppRadii(), Path.Direction.CW);
            canvas.clipPath(this.clipPath);
            return true;
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) InAppMessageImageView$clipCanvasToPath$3.INSTANCE);
            return false;
        }
    }
}
