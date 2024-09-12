package coil.request;

import coil.decode.GifDecoder;
import coil.request.ImageRequest;
import coil.transform.AnimatedTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007\u001a\u0012\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005*\u00020\u0003\u001a\u0012\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005*\u00020\u0003\u001a\u001a\u0010\b\u001a\u00020\u0001*\u00020\u00012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u001a\u001a\u0010\n\u001a\u00020\u0001*\u00020\u00012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f\u001a\u0011\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"animatedTransformation", "Lcoil/request/ImageRequest$Builder;", "Lcoil/transform/AnimatedTransformation;", "Lcoil/request/Parameters;", "animationEndCallback", "Lkotlin/Function0;", "", "animationStartCallback", "onAnimationEnd", "callback", "onAnimationStart", "repeatCount", "", "(Lcoil/request/Parameters;)Ljava/lang/Integer;", "coil-gif_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Gifs.kt */
public final class Gifs {
    public static final ImageRequest.Builder repeatCount(ImageRequest.Builder builder, int i) {
        if (i >= -1) {
            return ImageRequest.Builder.setParameter$default(builder, GifDecoder.REPEAT_COUNT_KEY, Integer.valueOf(i), (String) null, 4, (Object) null);
        }
        throw new IllegalArgumentException(("Invalid repeatCount: " + i).toString());
    }

    public static final Integer repeatCount(Parameters parameters) {
        return (Integer) parameters.value(GifDecoder.REPEAT_COUNT_KEY);
    }

    public static final ImageRequest.Builder animatedTransformation(ImageRequest.Builder builder, AnimatedTransformation animatedTransformation) {
        return ImageRequest.Builder.setParameter$default(builder, GifDecoder.ANIMATED_TRANSFORMATION_KEY, animatedTransformation, (String) null, 4, (Object) null);
    }

    public static final AnimatedTransformation animatedTransformation(Parameters parameters) {
        return (AnimatedTransformation) parameters.value(GifDecoder.ANIMATED_TRANSFORMATION_KEY);
    }

    public static final ImageRequest.Builder onAnimationStart(ImageRequest.Builder builder, Function0<Unit> function0) {
        return ImageRequest.Builder.setParameter$default(builder, GifDecoder.ANIMATION_START_CALLBACK_KEY, function0, (String) null, 4, (Object) null);
    }

    public static final Function0<Unit> animationStartCallback(Parameters parameters) {
        return (Function0) parameters.value(GifDecoder.ANIMATION_START_CALLBACK_KEY);
    }

    public static final ImageRequest.Builder onAnimationEnd(ImageRequest.Builder builder, Function0<Unit> function0) {
        return ImageRequest.Builder.setParameter$default(builder, GifDecoder.ANIMATION_END_CALLBACK_KEY, function0, (String) null, 4, (Object) null);
    }

    public static final Function0<Unit> animationEndCallback(Parameters parameters) {
        return (Function0) parameters.value(GifDecoder.ANIMATION_END_CALLBACK_KEY);
    }
}
