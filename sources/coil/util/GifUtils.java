package coil.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PostProcessor;
import android.graphics.drawable.Animatable2;
import android.os.Build;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.transform.AnimatedTransformation;
import coil.transform.PixelOpacity;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0001\u001a(\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0001\u001a-\u0010\u0014\u001a\u00020\r\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00150\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\r0\u0018H\b\u001a#\u0010\u0019\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\b\u001a\u0014\u0010\u001e\u001a\u00020\u0001*\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000\u001a#\u0010 \u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\b¨\u0006!"}, d2 = {"flag", "", "Lcoil/transform/PixelOpacity;", "getFlag", "(Lcoil/transform/PixelOpacity;)I", "isHardware", "", "Landroid/graphics/Bitmap$Config;", "(Landroid/graphics/Bitmap$Config;)Z", "animatable2CallbackOf", "Landroid/graphics/drawable/Animatable2$AnimationCallback;", "onStart", "Lkotlin/Function0;", "", "onEnd", "animatable2CompatCallbackOf", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "asPostProcessor", "Landroid/graphics/PostProcessor;", "Lcoil/transform/AnimatedTransformation;", "forEachIndices", "T", "", "action", "Lkotlin/Function1;", "heightPx", "Lcoil/size/Size;", "scale", "Lcoil/size/Scale;", "original", "toPx", "Lcoil/size/Dimension;", "widthPx", "coil-gif_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* renamed from: coil.util.-GifUtils  reason: invalid class name */
/* compiled from: Utils.kt */
public final class GifUtils {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: coil.util.-GifUtils$WhenMappings */
    /* compiled from: Utils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PixelOpacity.values().length];
            iArr[PixelOpacity.UNCHANGED.ordinal()] = 1;
            iArr[PixelOpacity.TRANSLUCENT.ordinal()] = 2;
            iArr[PixelOpacity.OPAQUE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Scale.values().length];
            iArr2[Scale.FILL.ordinal()] = 1;
            iArr2[Scale.FIT.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final PostProcessor asPostProcessor(AnimatedTransformation animatedTransformation) {
        return new GifUtils$$ExternalSyntheticLambda0(animatedTransformation);
    }

    /* access modifiers changed from: private */
    /* renamed from: asPostProcessor$lambda-0  reason: not valid java name */
    public static final int m88asPostProcessor$lambda0(AnimatedTransformation animatedTransformation, Canvas canvas) {
        return getFlag(animatedTransformation.transform(canvas));
    }

    public static final int getFlag(PixelOpacity pixelOpacity) {
        int i = WhenMappings.$EnumSwitchMapping$0[pixelOpacity.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return -3;
        }
        if (i == 3) {
            return -1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Animatable2.AnimationCallback animatable2CallbackOf(Function0<Unit> function0, Function0<Unit> function02) {
        return new GifUtils$animatable2CallbackOf$1(function0, function02);
    }

    public static final Animatable2Compat.AnimationCallback animatable2CompatCallbackOf(Function0<Unit> function0, Function0<Unit> function02) {
        return new GifUtils$animatable2CompatCallbackOf$1(function0, function02);
    }

    public static final <T> void forEachIndices(List<? extends T> list, Function1<? super T, Unit> function1) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            function1.invoke(list.get(i));
        }
    }

    public static final boolean isHardware(Bitmap.Config config) {
        return Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE;
    }

    public static final int widthPx(Size size, Scale scale, Function0<Integer> function0) {
        return Sizes.isOriginal(size) ? function0.invoke().intValue() : toPx(size.getWidth(), scale);
    }

    public static final int heightPx(Size size, Scale scale, Function0<Integer> function0) {
        return Sizes.isOriginal(size) ? function0.invoke().intValue() : toPx(size.getHeight(), scale);
    }

    public static final int toPx(Dimension dimension, Scale scale) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).px;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[scale.ordinal()];
        if (i == 1) {
            return Integer.MIN_VALUE;
        }
        if (i == 2) {
            return Integer.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
