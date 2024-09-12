package coil;

import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "coil.RealImageLoader", f = "RealImageLoader.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2}, l = {164, 175, 179}, m = "executeMain", n = {"this", "requestDelegate", "request", "eventListener", "this", "requestDelegate", "request", "eventListener", "placeholderBitmap", "this", "requestDelegate", "request", "eventListener"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"})
/* compiled from: RealImageLoader.kt */
final class RealImageLoader$executeMain$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealImageLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealImageLoader$executeMain$1(RealImageLoader realImageLoader, Continuation<? super RealImageLoader$executeMain$1> continuation) {
        super(continuation);
        this.this$0 = realImageLoader;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.executeMain((ImageRequest) null, 0, this);
    }
}
