package expo.modules.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.views.view.ReactViewBackgroundDrawable;
import com.facebook.yoga.YogaConstants;
import expo.modules.image.drawing.OutlineProvider;
import expo.modules.image.enums.ContentFit;
import expo.modules.image.records.ContentPosition;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010)\u001a\u00020*J\"\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u00101\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0016J0\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u0002052\u0006\u00108\u001a\u000205H\u0014J\b\u00109\u001a\u0004\u0018\u00010\u0019J\u0019\u0010:\u001a\u00020*2\b\u0010;\u001a\u0004\u0018\u000105H\u0000¢\u0006\u0004\b<\u0010=J%\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u0002052\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020AH\u0000¢\u0006\u0002\bCJ\u001d\u0010D\u001a\u00020*2\u0006\u0010?\u001a\u0002052\u0006\u0010E\u001a\u00020AH\u0000¢\u0006\u0002\bFJ\u0017\u0010G\u001a\u00020*2\b\u0010H\u001a\u0004\u0018\u00010IH\u0000¢\u0006\u0002\bJJ\u001d\u0010K\u001a\u00020*2\u0006\u0010?\u001a\u0002052\u0006\u0010L\u001a\u00020AH\u0000¢\u0006\u0002\bMJ\u0019\u0010N\u001a\u00020*2\b\u0010;\u001a\u0004\u0018\u000105H\u0000¢\u0006\u0004\bO\u0010=R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0004¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R$\u0010%\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000f\"\u0004\b'\u0010\u0011R\u000e\u0010(\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lexpo/modules/image/ExpoImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "borderDrawable", "Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;", "getBorderDrawable", "()Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;", "borderDrawableLazyHolder", "Lkotlin/Lazy;", "value", "Lexpo/modules/image/enums/ContentFit;", "contentFit", "getContentFit$expo_image_release", "()Lexpo/modules/image/enums/ContentFit;", "setContentFit$expo_image_release", "(Lexpo/modules/image/enums/ContentFit;)V", "Lexpo/modules/image/records/ContentPosition;", "contentPosition", "getContentPosition$expo_image_release", "()Lexpo/modules/image/records/ContentPosition;", "setContentPosition$expo_image_release", "(Lexpo/modules/image/records/ContentPosition;)V", "currentTarget", "Lexpo/modules/image/ImageViewWrapperTarget;", "getCurrentTarget", "()Lexpo/modules/image/ImageViewWrapperTarget;", "setCurrentTarget", "(Lexpo/modules/image/ImageViewWrapperTarget;)V", "isPlaceholder", "", "()Z", "setPlaceholder", "(Z)V", "outlineProvider", "Lexpo/modules/image/drawing/OutlineProvider;", "placeholderContentFit", "getPlaceholderContentFit$expo_image_release", "setPlaceholderContentFit$expo_image_release", "transformationMatrixChanged", "applyTransformationMatrix", "", "drawable", "Landroid/graphics/drawable/Drawable;", "draw", "canvas", "Landroid/graphics/Canvas;", "invalidateDrawable", "onDraw", "onLayout", "changed", "left", "", "top", "right", "bottom", "recycleView", "setBackgroundColor", "color", "setBackgroundColor$expo_image_release", "(Ljava/lang/Integer;)V", "setBorderColor", "position", "rgb", "", "alpha", "setBorderColor$expo_image_release", "setBorderRadius", "borderRadius", "setBorderRadius$expo_image_release", "setBorderStyle", "style", "", "setBorderStyle$expo_image_release", "setBorderWidth", "width", "setBorderWidth$expo_image_release", "setTintColor", "setTintColor$expo_image_release", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageView.kt */
public final class ExpoImageView extends AppCompatImageView {
    private final Lazy<ReactViewBackgroundDrawable> borderDrawableLazyHolder;
    private ContentFit contentFit = ContentFit.Cover;
    private ContentPosition contentPosition = ContentPosition.Companion.getCenter();
    private ImageViewWrapperTarget currentTarget;
    private boolean isPlaceholder;
    /* access modifiers changed from: private */
    public final OutlineProvider outlineProvider;
    private ContentFit placeholderContentFit = ContentFit.ScaleDown;
    private boolean transformationMatrixChanged;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpoImageView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        OutlineProvider outlineProvider2 = new OutlineProvider(context);
        this.outlineProvider = outlineProvider2;
        this.borderDrawableLazyHolder = LazyKt.lazy(new ExpoImageView$borderDrawableLazyHolder$1(context, this));
        setClipToOutline(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        super.setOutlineProvider(outlineProvider2);
    }

    public final ImageViewWrapperTarget getCurrentTarget() {
        return this.currentTarget;
    }

    public final void setCurrentTarget(ImageViewWrapperTarget imageViewWrapperTarget) {
        this.currentTarget = imageViewWrapperTarget;
    }

    public final boolean isPlaceholder() {
        return this.isPlaceholder;
    }

    public final void setPlaceholder(boolean z) {
        this.isPlaceholder = z;
    }

    public final ImageViewWrapperTarget recycleView() {
        setImageDrawable((Drawable) null);
        ImageViewWrapperTarget imageViewWrapperTarget = this.currentTarget;
        if (imageViewWrapperTarget != null) {
            imageViewWrapperTarget.setUsed(false);
        } else {
            imageViewWrapperTarget = null;
        }
        this.currentTarget = null;
        setVisibility(8);
        this.isPlaceholder = false;
        return imageViewWrapperTarget;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        applyTransformationMatrix();
    }

    public final void applyTransformationMatrix() {
        if (getDrawable() != null) {
            if (this.isPlaceholder) {
                Drawable drawable = getDrawable();
                Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
                applyTransformationMatrix$default(this, drawable, this.placeholderContentFit, (ContentPosition) null, 4, (Object) null);
                return;
            }
            Drawable drawable2 = getDrawable();
            Intrinsics.checkNotNullExpressionValue(drawable2, "drawable");
            applyTransformationMatrix(drawable2, this.contentFit, this.contentPosition);
        }
    }

    static /* synthetic */ void applyTransformationMatrix$default(ExpoImageView expoImageView, Drawable drawable, ContentFit contentFit2, ContentPosition contentPosition2, int i, Object obj) {
        if ((i & 4) != 0) {
            contentPosition2 = ContentPosition.Companion.getCenter();
        }
        expoImageView.applyTransformationMatrix(drawable, contentFit2, contentPosition2);
    }

    private final void applyTransformationMatrix(Drawable drawable, ContentFit contentFit2, ContentPosition contentPosition2) {
        RectF rectF = new RectF(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        RectF rectF2 = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        ImageViewWrapperTarget imageViewWrapperTarget = this.currentTarget;
        int i = -1;
        int sourceWidth = imageViewWrapperTarget != null ? imageViewWrapperTarget.getSourceWidth() : -1;
        ImageViewWrapperTarget imageViewWrapperTarget2 = this.currentTarget;
        if (imageViewWrapperTarget2 != null) {
            i = imageViewWrapperTarget2.getSourceHeight();
        }
        Matrix matrix$expo_image_release = contentFit2.toMatrix$expo_image_release(rectF, rectF2, sourceWidth, i);
        matrix$expo_image_release.mapRect(rectF);
        contentPosition2.apply$expo_image_release(matrix$expo_image_release, rectF, rectF2);
        setImageMatrix(matrix$expo_image_release);
    }

    private final ReactViewBackgroundDrawable getBorderDrawable() {
        return this.borderDrawableLazyHolder.getValue();
    }

    public final ContentFit getContentFit$expo_image_release() {
        return this.contentFit;
    }

    public final void setContentFit$expo_image_release(ContentFit contentFit2) {
        Intrinsics.checkNotNullParameter(contentFit2, "value");
        this.contentFit = contentFit2;
        this.transformationMatrixChanged = true;
    }

    public final ContentFit getPlaceholderContentFit$expo_image_release() {
        return this.placeholderContentFit;
    }

    public final void setPlaceholderContentFit$expo_image_release(ContentFit contentFit2) {
        Intrinsics.checkNotNullParameter(contentFit2, "value");
        this.placeholderContentFit = contentFit2;
        this.transformationMatrixChanged = true;
    }

    public final ContentPosition getContentPosition$expo_image_release() {
        return this.contentPosition;
    }

    public final void setContentPosition$expo_image_release(ContentPosition contentPosition2) {
        Intrinsics.checkNotNullParameter(contentPosition2, "value");
        this.contentPosition = contentPosition2;
        this.transformationMatrixChanged = true;
    }

    public final void setBorderRadius$expo_image_release(int i, float f) {
        if (this.outlineProvider.setBorderRadius(f, i)) {
            invalidateOutline();
            if (!this.outlineProvider.hasEqualCorners()) {
                invalidate();
            }
        }
        if (this.borderDrawableLazyHolder.isInitialized()) {
            if (!YogaConstants.isUndefined(f)) {
                f = PixelUtil.toPixelFromDIP(f);
            }
            ReactViewBackgroundDrawable value = this.borderDrawableLazyHolder.getValue();
            if (i == 0) {
                value.setRadius(f);
            } else {
                value.setRadius(f, i - 1);
            }
        }
    }

    public final void setBorderWidth$expo_image_release(int i, float f) {
        getBorderDrawable().setBorderWidth(i, f);
    }

    public final void setBorderColor$expo_image_release(int i, float f, float f2) {
        getBorderDrawable().setBorderColor(i, f, f2);
    }

    public final void setBorderStyle$expo_image_release(String str) {
        getBorderDrawable().setBorderStyle(str);
    }

    public final void setBackgroundColor$expo_image_release(Integer num) {
        if (num == null) {
            setBackgroundColor(0);
        } else {
            setBackgroundColor(num.intValue());
        }
    }

    public final void setTintColor$expo_image_release(Integer num) {
        Unit unit;
        if (num != null) {
            setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            clearColorFilter();
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        super.invalidateDrawable(drawable);
        if (this.borderDrawableLazyHolder.isInitialized() && drawable == getBorderDrawable()) {
            invalidate();
        }
    }

    /* JADX WARNING: type inference failed for: r1v6, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r5) {
        /*
            r4 = this;
            java.lang.String r0 = "canvas"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            expo.modules.image.drawing.OutlineProvider r0 = r4.outlineProvider
            r1 = r4
            android.view.View r1 = (android.view.View) r1
            r0.clipCanvasIfNeeded(r5, r1)
            android.graphics.drawable.Drawable r0 = r4.getDrawable()
            boolean r1 = r0 instanceof android.graphics.drawable.BitmapDrawable
            r2 = 0
            if (r1 == 0) goto L_0x0019
            android.graphics.drawable.BitmapDrawable r0 = (android.graphics.drawable.BitmapDrawable) r0
            goto L_0x001a
        L_0x0019:
            r0 = r2
        L_0x001a:
            r1 = 1
            r3 = 0
            if (r0 == 0) goto L_0x002b
            android.graphics.Bitmap r0 = r0.getBitmap()
            if (r0 == 0) goto L_0x002b
            boolean r0 = r0.isRecycled()
            if (r0 != r1) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r1 = r3
        L_0x002c:
            if (r1 == 0) goto L_0x0051
            java.lang.String r0 = "ExpoImage"
            java.lang.String r1 = "Trying to use a recycled bitmap"
            android.util.Log.e(r0, r1)
            expo.modules.image.ImageViewWrapperTarget r0 = r4.recycleView()
            if (r0 == 0) goto L_0x0051
            android.view.ViewParent r1 = r4.getParent()
            boolean r3 = r1 instanceof expo.modules.image.ExpoImageViewWrapper
            if (r3 == 0) goto L_0x0046
            r2 = r1
            expo.modules.image.ExpoImageViewWrapper r2 = (expo.modules.image.ExpoImageViewWrapper) r2
        L_0x0046:
            if (r2 == 0) goto L_0x0051
            com.bumptech.glide.RequestManager r1 = r2.getRequestManager$expo_image_release()
            if (r1 == 0) goto L_0x0051
            r0.clear(r1)
        L_0x0051:
            super.draw(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.image.ExpoImageView.draw(android.graphics.Canvas):void");
    }

    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.borderDrawableLazyHolder.isInitialized()) {
            boolean isRTL = I18nUtil.getInstance().isRTL(getContext());
            ReactViewBackgroundDrawable borderDrawable = getBorderDrawable();
            borderDrawable.setResolvedLayoutDirection(isRTL ? 1 : 0);
            borderDrawable.setBounds(0, 0, getWidth(), getHeight());
            borderDrawable.draw(canvas);
        }
    }
}
