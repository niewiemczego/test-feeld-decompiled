package coil.intercept;

import coil.EventListener;
import coil.intercept.Interceptor;
import coil.request.ImageRequest;
import coil.request.NullRequestData;
import coil.size.Size;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J&\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0002J\u0019\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0019R\u0014\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcoil/intercept/RealInterceptorChain;", "Lcoil/intercept/Interceptor$Chain;", "initialRequest", "Lcoil/request/ImageRequest;", "interceptors", "", "Lcoil/intercept/Interceptor;", "index", "", "request", "size", "Lcoil/size/Size;", "eventListener", "Lcoil/EventListener;", "isPlaceholderCached", "", "(Lcoil/request/ImageRequest;Ljava/util/List;ILcoil/request/ImageRequest;Lcoil/size/Size;Lcoil/EventListener;Z)V", "getEventListener", "()Lcoil/EventListener;", "getIndex", "()I", "getInitialRequest", "()Lcoil/request/ImageRequest;", "getInterceptors", "()Ljava/util/List;", "()Z", "getRequest", "getSize", "()Lcoil/size/Size;", "checkRequest", "", "interceptor", "copy", "proceed", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withSize", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RealInterceptorChain.kt */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final EventListener eventListener;
    private final int index;
    private final ImageRequest initialRequest;
    private final List<Interceptor> interceptors;
    private final boolean isPlaceholderCached;
    private final ImageRequest request;
    private final Size size;

    public RealInterceptorChain(ImageRequest imageRequest, List<? extends Interceptor> list, int i, ImageRequest imageRequest2, Size size2, EventListener eventListener2, boolean z) {
        this.initialRequest = imageRequest;
        this.interceptors = list;
        this.index = i;
        this.request = imageRequest2;
        this.size = size2;
        this.eventListener = eventListener2;
        this.isPlaceholderCached = z;
    }

    public final ImageRequest getInitialRequest() {
        return this.initialRequest;
    }

    public final List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public final int getIndex() {
        return this.index;
    }

    public ImageRequest getRequest() {
        return this.request;
    }

    public Size getSize() {
        return this.size;
    }

    public final EventListener getEventListener() {
        return this.eventListener;
    }

    public final boolean isPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    public RealInterceptorChain withSize(Size size2) {
        return copy$default(this, 0, (ImageRequest) null, size2, 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object proceed(coil.request.ImageRequest r12, kotlin.coroutines.Continuation<? super coil.request.ImageResult> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof coil.intercept.RealInterceptorChain$proceed$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            coil.intercept.RealInterceptorChain$proceed$1 r0 = (coil.intercept.RealInterceptorChain$proceed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            coil.intercept.RealInterceptorChain$proceed$1 r0 = new coil.intercept.RealInterceptorChain$proceed$1
            r0.<init>(r11, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r12 = r0.L$1
            coil.intercept.Interceptor r12 = (coil.intercept.Interceptor) r12
            java.lang.Object r0 = r0.L$0
            coil.intercept.RealInterceptorChain r0 = (coil.intercept.RealInterceptorChain) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0077
        L_0x0032:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r13)
            int r13 = r11.index
            if (r13 <= 0) goto L_0x004d
            java.util.List<coil.intercept.Interceptor> r2 = r11.interceptors
            int r13 = r13 - r3
            java.lang.Object r13 = r2.get(r13)
            coil.intercept.Interceptor r13 = (coil.intercept.Interceptor) r13
            r11.checkRequest(r12, r13)
        L_0x004d:
            java.util.List<coil.intercept.Interceptor> r13 = r11.interceptors
            int r2 = r11.index
            java.lang.Object r13 = r13.get(r2)
            coil.intercept.Interceptor r13 = (coil.intercept.Interceptor) r13
            int r2 = r11.index
            int r5 = r2 + 1
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r11
            r6 = r12
            coil.intercept.RealInterceptorChain r12 = copy$default(r4, r5, r6, r7, r8, r9)
            coil.intercept.Interceptor$Chain r12 = (coil.intercept.Interceptor.Chain) r12
            r0.L$0 = r11
            r0.L$1 = r13
            r0.label = r3
            java.lang.Object r12 = r13.intercept(r12, r0)
            if (r12 != r1) goto L_0x0073
            return r1
        L_0x0073:
            r0 = r11
            r10 = r13
            r13 = r12
            r12 = r10
        L_0x0077:
            coil.request.ImageResult r13 = (coil.request.ImageResult) r13
            coil.request.ImageRequest r1 = r13.getRequest()
            r0.checkRequest(r1, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.RealInterceptorChain.proceed(coil.request.ImageRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void checkRequest(ImageRequest imageRequest, Interceptor interceptor) {
        boolean z = true;
        if (imageRequest.getContext() == this.initialRequest.getContext()) {
            if (imageRequest.getData() != NullRequestData.INSTANCE) {
                if (imageRequest.getTarget() == this.initialRequest.getTarget()) {
                    if (imageRequest.getLifecycle() == this.initialRequest.getLifecycle()) {
                        if (imageRequest.getSizeResolver() != this.initialRequest.getSizeResolver()) {
                            z = false;
                        }
                        if (!z) {
                            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
                        }
                        return;
                    }
                    throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's lifecycle.").toString());
                }
                throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's target.").toString());
            }
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot set the request's data to null.").toString());
        }
        throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's context.").toString());
    }

    static /* synthetic */ RealInterceptorChain copy$default(RealInterceptorChain realInterceptorChain, int i, ImageRequest imageRequest, Size size2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = realInterceptorChain.index;
        }
        if ((i2 & 2) != 0) {
            imageRequest = realInterceptorChain.getRequest();
        }
        if ((i2 & 4) != 0) {
            size2 = realInterceptorChain.getSize();
        }
        return realInterceptorChain.copy(i, imageRequest, size2);
    }

    private final RealInterceptorChain copy(int i, ImageRequest imageRequest, Size size2) {
        return new RealInterceptorChain(this.initialRequest, this.interceptors, i, imageRequest, size2, this.eventListener, this.isPlaceholderCached);
    }
}
