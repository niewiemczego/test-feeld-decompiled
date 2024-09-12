package expo.modules.image.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.yoga.YogaConstants;
import expo.modules.image.YogaUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002./B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u000eJ\u0016\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0012J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J@\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000eH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lexpo/modules/image/drawing/OutlineProvider;", "Landroid/view/ViewOutlineProvider;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "borderRadiiConfig", "", "getBorderRadiiConfig", "()[F", "mBounds", "Landroid/graphics/RectF;", "mConvexPath", "Landroid/graphics/Path;", "mConvexPathInvalidated", "", "mCornerRadii", "mCornerRadiiInvalidated", "mLayoutDirection", "", "clipCanvasIfNeeded", "", "canvas", "Landroid/graphics/Canvas;", "view", "Landroid/view/View;", "getOutline", "outline", "Landroid/graphics/Outline;", "hasEqualCorners", "setBorderRadius", "radius", "", "position", "updateBoundsAndLayoutDirection", "updateConvexPathIfNeeded", "updateCornerRadiiIfNeeded", "updateCornerRadius", "outputPosition", "Lexpo/modules/image/drawing/OutlineProvider$CornerRadius;", "inputPosition", "Lexpo/modules/image/drawing/OutlineProvider$BorderRadiusConfig;", "oppositePosition", "startPosition", "endPosition", "isRTL", "isRTLSwap", "BorderRadiusConfig", "CornerRadius", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OutlineProvider.kt */
public final class OutlineProvider extends ViewOutlineProvider {
    private final float[] borderRadiiConfig;
    private final RectF mBounds = new RectF();
    private final Context mContext;
    private final Path mConvexPath;
    private boolean mConvexPathInvalidated;
    private final float[] mCornerRadii;
    private boolean mCornerRadiiInvalidated;
    private int mLayoutDirection;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/image/drawing/OutlineProvider$BorderRadiusConfig;", "", "(Ljava/lang/String;I)V", "ALL", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_RIGHT", "BOTTOM_LEFT", "TOP_START", "TOP_END", "BOTTOM_START", "BOTTOM_END", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OutlineProvider.kt */
    public enum BorderRadiusConfig {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        TOP_START,
        TOP_END,
        BOTTOM_START,
        BOTTOM_END
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/image/drawing/OutlineProvider$CornerRadius;", "", "(Ljava/lang/String;I)V", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_RIGHT", "BOTTOM_LEFT", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OutlineProvider.kt */
    public enum CornerRadius {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT
    }

    public OutlineProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        float[] fArr = new float[9];
        for (int i = 0; i < 9; i++) {
            fArr[i] = Float.NaN;
        }
        this.borderRadiiConfig = fArr;
        this.mCornerRadii = new float[4];
        this.mCornerRadiiInvalidated = true;
        this.mConvexPath = new Path();
        this.mConvexPathInvalidated = true;
        updateCornerRadiiIfNeeded();
    }

    public final float[] getBorderRadiiConfig() {
        return this.borderRadiiConfig;
    }

    private final void updateCornerRadiiIfNeeded() {
        if (this.mCornerRadiiInvalidated) {
            boolean z = this.mLayoutDirection == 1;
            boolean doLeftAndRightSwapInRTL = I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext);
            updateCornerRadius(CornerRadius.TOP_LEFT, BorderRadiusConfig.TOP_LEFT, BorderRadiusConfig.TOP_RIGHT, BorderRadiusConfig.TOP_START, BorderRadiusConfig.TOP_END, z, doLeftAndRightSwapInRTL);
            updateCornerRadius(CornerRadius.TOP_RIGHT, BorderRadiusConfig.TOP_RIGHT, BorderRadiusConfig.TOP_LEFT, BorderRadiusConfig.TOP_END, BorderRadiusConfig.TOP_START, z, doLeftAndRightSwapInRTL);
            updateCornerRadius(CornerRadius.BOTTOM_LEFT, BorderRadiusConfig.BOTTOM_LEFT, BorderRadiusConfig.BOTTOM_RIGHT, BorderRadiusConfig.BOTTOM_START, BorderRadiusConfig.BOTTOM_END, z, doLeftAndRightSwapInRTL);
            updateCornerRadius(CornerRadius.BOTTOM_RIGHT, BorderRadiusConfig.BOTTOM_RIGHT, BorderRadiusConfig.BOTTOM_LEFT, BorderRadiusConfig.BOTTOM_END, BorderRadiusConfig.BOTTOM_START, z, doLeftAndRightSwapInRTL);
            this.mCornerRadiiInvalidated = false;
            this.mConvexPathInvalidated = true;
        }
    }

    private final void updateCornerRadius(CornerRadius cornerRadius, BorderRadiusConfig borderRadiusConfig, BorderRadiusConfig borderRadiusConfig2, BorderRadiusConfig borderRadiusConfig3, BorderRadiusConfig borderRadiusConfig4, boolean z, boolean z2) {
        float f = this.borderRadiiConfig[borderRadiusConfig.ordinal()];
        if (z) {
            if (z2) {
                f = this.borderRadiiConfig[borderRadiusConfig2.ordinal()];
            }
            if (YogaConstants.isUndefined(f)) {
                f = this.borderRadiiConfig[borderRadiusConfig4.ordinal()];
            }
        } else if (YogaConstants.isUndefined(f)) {
            f = this.borderRadiiConfig[borderRadiusConfig3.ordinal()];
        }
        this.mCornerRadii[cornerRadius.ordinal()] = PixelUtil.toPixelFromDIP(YogaUtilsKt.ifYogaUndefinedUse(YogaUtilsKt.ifYogaUndefinedUse(f, this.borderRadiiConfig[BorderRadiusConfig.ALL.ordinal()]), 0.0f));
    }

    private final void updateConvexPathIfNeeded() {
        if (this.mConvexPathInvalidated) {
            this.mConvexPath.reset();
            this.mConvexPath.addRoundRect(this.mBounds, new float[]{this.mCornerRadii[CornerRadius.TOP_LEFT.ordinal()], this.mCornerRadii[CornerRadius.TOP_LEFT.ordinal()], this.mCornerRadii[CornerRadius.TOP_RIGHT.ordinal()], this.mCornerRadii[CornerRadius.TOP_RIGHT.ordinal()], this.mCornerRadii[CornerRadius.BOTTOM_RIGHT.ordinal()], this.mCornerRadii[CornerRadius.BOTTOM_RIGHT.ordinal()], this.mCornerRadii[CornerRadius.BOTTOM_LEFT.ordinal()], this.mCornerRadii[CornerRadius.BOTTOM_LEFT.ordinal()]}, Path.Direction.CW);
            this.mConvexPathInvalidated = false;
        }
    }

    public final boolean hasEqualCorners() {
        updateCornerRadiiIfNeeded();
        float[] fArr = this.mCornerRadii;
        float f = fArr[0];
        int length = fArr.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                return true;
            }
            if (f != fArr[i]) {
                z = false;
            }
            if (!z) {
                return false;
            }
            i++;
        }
    }

    public final boolean setBorderRadius(float f, int i) {
        if (FloatUtil.floatsEqual(this.borderRadiiConfig[i], f)) {
            return false;
        }
        this.borderRadiiConfig[i] = f;
        this.mCornerRadiiInvalidated = true;
        return true;
    }

    private final void updateBoundsAndLayoutDirection(View view) {
        int layoutDirection = view.getLayoutDirection();
        if (this.mLayoutDirection != layoutDirection) {
            this.mLayoutDirection = layoutDirection;
            this.mCornerRadiiInvalidated = true;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        boolean z = false;
        float f = (float) 0;
        if (this.mBounds.left == f) {
            if (this.mBounds.top == f) {
                if (this.mBounds.right == ((float) width)) {
                    if (this.mBounds.bottom == ((float) height)) {
                        z = true;
                    }
                    if (z) {
                        return;
                    }
                }
            }
        }
        this.mBounds.set(f, f, (float) width, (float) height);
        this.mCornerRadiiInvalidated = true;
    }

    public void getOutline(View view, Outline outline) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(outline, "outline");
        updateBoundsAndLayoutDirection(view);
        updateCornerRadiiIfNeeded();
        if (hasEqualCorners()) {
            float f = this.mCornerRadii[0];
            if (f > 0.0f) {
                outline.setRoundRect(0, 0, (int) this.mBounds.width(), (int) this.mBounds.height(), f);
                return;
            }
            outline.setRect(0, 0, (int) this.mBounds.width(), (int) this.mBounds.height());
            return;
        }
        updateConvexPathIfNeeded();
        outline.setConvexPath(this.mConvexPath);
    }

    public final void clipCanvasIfNeeded(Canvas canvas, View view) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        updateBoundsAndLayoutDirection(view);
        updateCornerRadiiIfNeeded();
        if (!hasEqualCorners()) {
            updateConvexPathIfNeeded();
            canvas.clipPath(this.mConvexPath);
        }
    }
}
