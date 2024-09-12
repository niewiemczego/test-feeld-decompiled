package coil.decode;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import coil.util.GifUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "coil.decode.ImageDecoderDecoder$wrapDrawable$2", f = "ImageDecoderDecoder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ImageDecoderDecoder.kt */
final class ImageDecoderDecoder$wrapDrawable$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Drawable $baseDrawable;
    final /* synthetic */ Function0<Unit> $onEnd;
    final /* synthetic */ Function0<Unit> $onStart;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageDecoderDecoder$wrapDrawable$2(Drawable drawable, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super ImageDecoderDecoder$wrapDrawable$2> continuation) {
        super(2, continuation);
        this.$baseDrawable = drawable;
        this.$onStart = function0;
        this.$onEnd = function02;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageDecoderDecoder$wrapDrawable$2(this.$baseDrawable, this.$onStart, this.$onEnd, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ImageDecoderDecoder$wrapDrawable$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ((AnimatedImageDrawable) this.$baseDrawable).registerAnimationCallback(GifUtils.animatable2CallbackOf(this.$onStart, this.$onEnd));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
