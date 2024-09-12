package coil.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import coil.decode.DecodeUtils;
import coil.size.Scale;
import coil.transform.AnimatedTransformation;
import coil.transform.PixelOpacity;
import coil.util.GifUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001IB#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u0002022\u0006\u00104\u001a\u00020*H\u0016J\u0010\u00105\u001a\u0002022\u0006\u00104\u001a\u00020*H\u0002J\b\u00106\u001a\u0004\u0018\u00010\u000bJ\b\u00107\u001a\u00020\u001fH\u0016J\b\u00108\u001a\u00020\u001fH\u0016J\b\u00109\u001a\u00020\u001fH\u0017J\u0006\u0010:\u001a\u00020\u001fJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020\u001fH\u0016J\u0010\u0010?\u001a\u0002022\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010@\u001a\u0002022\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u000e\u0010C\u001a\u0002022\u0006\u0010$\u001a\u00020\u001fJ\b\u0010D\u001a\u000202H\u0016J\b\u0010E\u001a\u000202H\u0016J\u0010\u0010F\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u0010H\u0016J\u0010\u0010G\u001a\u0002022\u0006\u0010.\u001a\u00020\u0014H\u0002J\b\u0010H\u001a\u00020\u001cH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010.\u001a\u00020\u0014*\u00020*8BX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006J"}, d2 = {"Lcoil/drawable/MovieDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat;", "movie", "Landroid/graphics/Movie;", "config", "Landroid/graphics/Bitmap$Config;", "scale", "Lcoil/size/Scale;", "(Landroid/graphics/Movie;Landroid/graphics/Bitmap$Config;Lcoil/size/Scale;)V", "animatedTransformation", "Lcoil/transform/AnimatedTransformation;", "animatedTransformationPicture", "Landroid/graphics/Picture;", "callbacks", "", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "getConfig", "()Landroid/graphics/Bitmap$Config;", "currentBounds", "Landroid/graphics/Rect;", "frameTimeMillis", "", "hardwareDx", "", "hardwareDy", "hardwareScale", "isRunning", "", "isSoftwareScalingEnabled", "loopIteration", "", "paint", "Landroid/graphics/Paint;", "pixelOpacity", "Lcoil/transform/PixelOpacity;", "repeatCount", "getScale", "()Lcoil/size/Scale;", "softwareBitmap", "Landroid/graphics/Bitmap;", "softwareCanvas", "Landroid/graphics/Canvas;", "softwareScale", "startTimeMillis", "tempCanvasBounds", "bounds", "getBounds", "(Landroid/graphics/Canvas;)Landroid/graphics/Rect;", "clearAnimationCallbacks", "", "draw", "canvas", "drawFrame", "getAnimatedTransformation", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "getRepeatCount", "registerAnimationCallback", "callback", "setAlpha", "alpha", "setAnimatedTransformation", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setRepeatCount", "start", "stop", "unregisterAnimationCallback", "updateBounds", "updateFrameTime", "Companion", "coil-gif_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MovieDrawable.kt */
public final class MovieDrawable extends Drawable implements Animatable2Compat {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int REPEAT_INFINITE = -1;
    private AnimatedTransformation animatedTransformation;
    private Picture animatedTransformationPicture;
    private final List<Animatable2Compat.AnimationCallback> callbacks;
    private final Bitmap.Config config;
    private final Rect currentBounds;
    private long frameTimeMillis;
    private float hardwareDx;
    private float hardwareDy;
    private float hardwareScale;
    private boolean isRunning;
    private boolean isSoftwareScalingEnabled;
    private int loopIteration;
    private final Movie movie;
    private final Paint paint;
    private PixelOpacity pixelOpacity;
    private int repeatCount;
    private final Scale scale;
    private Bitmap softwareBitmap;
    private Canvas softwareCanvas;
    private float softwareScale;
    private long startTimeMillis;
    private final Rect tempCanvasBounds;

    public MovieDrawable(Movie movie2) {
        this(movie2, (Bitmap.Config) null, (Scale) null, 6, (DefaultConstructorMarker) null);
    }

    public MovieDrawable(Movie movie2, Bitmap.Config config2) {
        this(movie2, config2, (Scale) null, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MovieDrawable(Movie movie2, Bitmap.Config config2, Scale scale2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(movie2, (i & 2) != 0 ? Bitmap.Config.ARGB_8888 : config2, (i & 4) != 0 ? Scale.FIT : scale2);
    }

    public final Bitmap.Config getConfig() {
        return this.config;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public MovieDrawable(Movie movie2, Bitmap.Config config2, Scale scale2) {
        this.movie = movie2;
        this.config = config2;
        this.scale = scale2;
        this.paint = new Paint(3);
        this.callbacks = new ArrayList();
        this.currentBounds = new Rect();
        this.tempCanvasBounds = new Rect();
        this.softwareScale = 1.0f;
        this.hardwareScale = 1.0f;
        this.repeatCount = -1;
        this.pixelOpacity = PixelOpacity.UNCHANGED;
        if (!(!GifUtils.isHardware(config2))) {
            throw new IllegalArgumentException("Bitmap config must not be hardware.".toString());
        }
    }

    public void draw(Canvas canvas) {
        boolean updateFrameTime = updateFrameTime();
        if (this.isSoftwareScalingEnabled) {
            updateBounds(getBounds(canvas));
            int save = canvas.save();
            try {
                float f = ((float) 1) / this.softwareScale;
                canvas.scale(f, f);
                drawFrame(canvas);
            } finally {
                canvas.restoreToCount(save);
            }
        } else {
            updateBounds(getBounds());
            drawFrame(canvas);
        }
        if (!this.isRunning || !updateFrameTime) {
            stop();
        } else {
            invalidateSelf();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean updateFrameTime() {
        /*
            r7 = this;
            android.graphics.Movie r0 = r7.movie
            int r0 = r0.duration()
            r1 = 0
            if (r0 != 0) goto L_0x000b
            r0 = r1
            goto L_0x002f
        L_0x000b:
            boolean r2 = r7.isRunning
            if (r2 == 0) goto L_0x0015
            long r2 = android.os.SystemClock.uptimeMillis()
            r7.frameTimeMillis = r2
        L_0x0015:
            long r2 = r7.frameTimeMillis
            long r4 = r7.startTimeMillis
            long r2 = r2 - r4
            int r2 = (int) r2
            int r3 = r2 / r0
            r7.loopIteration = r3
            int r4 = r7.repeatCount
            r5 = -1
            if (r4 == r5) goto L_0x0026
            if (r3 > r4) goto L_0x0027
        L_0x0026:
            r1 = 1
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            int r3 = r3 * r0
            int r0 = r2 - r3
        L_0x002c:
            r6 = r1
            r1 = r0
            r0 = r6
        L_0x002f:
            android.graphics.Movie r2 = r7.movie
            r2.setTime(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.drawable.MovieDrawable.updateFrameTime():boolean");
    }

    /* JADX INFO: finally extract failed */
    private final void drawFrame(Canvas canvas) {
        Canvas canvas2 = this.softwareCanvas;
        Bitmap bitmap = this.softwareBitmap;
        if (canvas2 != null && bitmap != null) {
            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
            int save = canvas2.save();
            try {
                float f = this.softwareScale;
                canvas2.scale(f, f);
                this.movie.draw(canvas2, 0.0f, 0.0f, this.paint);
                Picture picture = this.animatedTransformationPicture;
                if (picture != null) {
                    picture.draw(canvas2);
                }
                canvas2.restoreToCount(save);
                int save2 = canvas.save();
                try {
                    canvas.translate(this.hardwareDx, this.hardwareDy);
                    float f2 = this.hardwareScale;
                    canvas.scale(f2, f2);
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.paint);
                } finally {
                    canvas.restoreToCount(save2);
                }
            } catch (Throwable th) {
                canvas2.restoreToCount(save);
                throw th;
            }
        }
    }

    public final void setRepeatCount(int i) {
        if (i >= -1) {
            this.repeatCount = i;
            return;
        }
        throw new IllegalArgumentException(("Invalid repeatCount: " + i).toString());
    }

    public final int getRepeatCount() {
        return this.repeatCount;
    }

    public final void setAnimatedTransformation(AnimatedTransformation animatedTransformation2) {
        this.animatedTransformation = animatedTransformation2;
        if (animatedTransformation2 == null || this.movie.width() <= 0 || this.movie.height() <= 0) {
            this.animatedTransformationPicture = null;
            this.pixelOpacity = PixelOpacity.UNCHANGED;
            this.isSoftwareScalingEnabled = false;
        } else {
            Picture picture = new Picture();
            this.pixelOpacity = animatedTransformation2.transform(picture.beginRecording(this.movie.width(), this.movie.height()));
            picture.endRecording();
            this.animatedTransformationPicture = picture;
            this.isSoftwareScalingEnabled = true;
        }
        invalidateSelf();
    }

    public final AnimatedTransformation getAnimatedTransformation() {
        return this.animatedTransformation;
    }

    public void setAlpha(int i) {
        boolean z = false;
        if (i >= 0 && i < 256) {
            z = true;
        }
        if (z) {
            this.paint.setAlpha(i);
            return;
        }
        throw new IllegalArgumentException(("Invalid alpha: " + i).toString());
    }

    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return (this.paint.getAlpha() != 255 || (this.pixelOpacity != PixelOpacity.OPAQUE && (this.pixelOpacity != PixelOpacity.UNCHANGED || !this.movie.isOpaque()))) ? -3 : -1;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    private final void updateBounds(Rect rect) {
        if (!Intrinsics.areEqual((Object) this.currentBounds, (Object) rect)) {
            this.currentBounds.set(rect);
            int width = rect.width();
            int height = rect.height();
            int width2 = this.movie.width();
            int height2 = this.movie.height();
            if (width2 > 0 && height2 > 0) {
                double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width2, height2, width, height, this.scale);
                if (!this.isSoftwareScalingEnabled) {
                    computeSizeMultiplier = RangesKt.coerceAtMost(computeSizeMultiplier, 1.0d);
                }
                float f = (float) computeSizeMultiplier;
                this.softwareScale = f;
                int i = (int) (((float) width2) * f);
                int i2 = (int) (f * ((float) height2));
                Bitmap createBitmap = Bitmap.createBitmap(i, i2, this.config);
                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, height, config)");
                Bitmap bitmap = this.softwareBitmap;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                this.softwareBitmap = createBitmap;
                this.softwareCanvas = new Canvas(createBitmap);
                if (this.isSoftwareScalingEnabled) {
                    this.hardwareScale = 1.0f;
                    this.hardwareDx = 0.0f;
                    this.hardwareDy = 0.0f;
                    return;
                }
                this.hardwareScale = (float) DecodeUtils.computeSizeMultiplier(i, i2, width, height, this.scale);
                float f2 = (float) 2;
                this.hardwareDx = ((float) rect.left) + ((((float) width) - (this.hardwareScale * ((float) i))) / f2);
                this.hardwareDy = ((float) rect.top) + ((((float) height) - (this.hardwareScale * ((float) i2))) / f2);
            }
        }
    }

    public int getIntrinsicWidth() {
        return this.movie.width();
    }

    public int getIntrinsicHeight() {
        return this.movie.height();
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.loopIteration = 0;
            this.startTimeMillis = SystemClock.uptimeMillis();
            List<Animatable2Compat.AnimationCallback> list = this.callbacks;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.get(i).onAnimationStart(this);
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.isRunning) {
            this.isRunning = false;
            List<Animatable2Compat.AnimationCallback> list = this.callbacks;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.get(i).onAnimationEnd(this);
            }
        }
    }

    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        this.callbacks.add(animationCallback);
    }

    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        return this.callbacks.remove(animationCallback);
    }

    public void clearAnimationCallbacks() {
        this.callbacks.clear();
    }

    private final Rect getBounds(Canvas canvas) {
        Rect rect = this.tempCanvasBounds;
        rect.set(0, 0, canvas.getWidth(), canvas.getHeight());
        return rect;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/drawable/MovieDrawable$Companion;", "", "()V", "REPEAT_INFINITE", "", "coil-gif_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MovieDrawable.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
