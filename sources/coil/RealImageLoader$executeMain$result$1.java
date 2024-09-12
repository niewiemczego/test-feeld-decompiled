package coil;

import android.graphics.Bitmap;
import coil.intercept.RealInterceptorChain;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.size.Size;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcoil/request/ImageResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "coil.RealImageLoader$executeMain$result$1", f = "RealImageLoader.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RealImageLoader.kt */
final class RealImageLoader$executeMain$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {
    final /* synthetic */ EventListener $eventListener;
    final /* synthetic */ Bitmap $placeholderBitmap;
    final /* synthetic */ ImageRequest $request;
    final /* synthetic */ Size $size;
    int label;
    final /* synthetic */ RealImageLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealImageLoader$executeMain$result$1(ImageRequest imageRequest, RealImageLoader realImageLoader, Size size, EventListener eventListener, Bitmap bitmap, Continuation<? super RealImageLoader$executeMain$result$1> continuation) {
        super(2, continuation);
        this.$request = imageRequest;
        this.this$0 = realImageLoader;
        this.$size = size;
        this.$eventListener = eventListener;
        this.$placeholderBitmap = bitmap;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RealImageLoader$executeMain$result$1(this.$request, this.this$0, this.$size, this.$eventListener, this.$placeholderBitmap, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageResult> continuation) {
        return ((RealImageLoader$executeMain$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ImageRequest imageRequest = this.$request;
            List access$getInterceptors$p = this.this$0.interceptors;
            ImageRequest imageRequest2 = this.$request;
            Size size = this.$size;
            EventListener eventListener = this.$eventListener;
            boolean z = this.$placeholderBitmap != null;
            this.label = 1;
            obj = new RealInterceptorChain(imageRequest, access$getInterceptors$p, 0, imageRequest2, size, eventListener, z).proceed(this.$request, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
