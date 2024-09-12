package coil.intercept;

import coil.EventListener;
import coil.intercept.EngineInterceptor;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.transform.Transformation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "coil.intercept.EngineInterceptor$transform$3", f = "EngineInterceptor.kt", i = {0, 0, 0}, l = {242}, m = "invokeSuspend", n = {"$this$withContext", "$this$foldIndices$iv", "i$iv"}, s = {"L$0", "L$1", "I$0"})
/* compiled from: EngineInterceptor.kt */
final class EngineInterceptor$transform$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EngineInterceptor.ExecuteResult>, Object> {
    final /* synthetic */ EventListener $eventListener;
    final /* synthetic */ Options $options;
    final /* synthetic */ ImageRequest $request;
    final /* synthetic */ EngineInterceptor.ExecuteResult $result;
    final /* synthetic */ List<Transformation> $transformations;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EngineInterceptor$transform$3(EngineInterceptor engineInterceptor, EngineInterceptor.ExecuteResult executeResult, Options options, List<? extends Transformation> list, EventListener eventListener, ImageRequest imageRequest, Continuation<? super EngineInterceptor$transform$3> continuation) {
        super(2, continuation);
        this.this$0 = engineInterceptor;
        this.$result = executeResult;
        this.$options = options;
        this.$transformations = list;
        this.$eventListener = eventListener;
        this.$request = imageRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EngineInterceptor$transform$3 engineInterceptor$transform$3 = new EngineInterceptor$transform$3(this.this$0, this.$result, this.$options, this.$transformations, this.$eventListener, this.$request, continuation);
        engineInterceptor$transform$3.L$0 = obj;
        return engineInterceptor$transform$3;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super EngineInterceptor.ExecuteResult> continuation) {
        return ((EngineInterceptor$transform$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            int r2 = r0.I$1
            int r4 = r0.I$0
            java.lang.Object r5 = r0.L$2
            coil.request.Options r5 = (coil.request.Options) r5
            java.lang.Object r6 = r0.L$1
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            kotlin.ResultKt.throwOnFailure(r20)
            r9 = r0
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r20
            goto L_0x0081
        L_0x0027:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            coil.intercept.EngineInterceptor r4 = r0.this$0
            coil.intercept.EngineInterceptor$ExecuteResult r5 = r0.$result
            android.graphics.drawable.Drawable r5 = r5.getDrawable()
            coil.request.Options r6 = r0.$options
            java.util.List<coil.transform.Transformation> r7 = r0.$transformations
            android.graphics.Bitmap r4 = r4.convertDrawableToBitmap(r5, r6, r7)
            coil.EventListener r5 = r0.$eventListener
            coil.request.ImageRequest r6 = r0.$request
            r5.transformStart(r6, r4)
            java.util.List<coil.transform.Transformation> r5 = r0.$transformations
            coil.request.Options r6 = r0.$options
            r7 = 0
            int r8 = r5.size()
            r9 = r0
            r17 = r8
            r8 = r2
            r2 = r17
            r18 = r5
            r5 = r4
            r4 = r7
            r7 = r18
        L_0x0062:
            if (r4 >= r2) goto L_0x0088
            java.lang.Object r10 = r7.get(r4)
            coil.transform.Transformation r10 = (coil.transform.Transformation) r10
            coil.size.Size r11 = r6.getSize()
            r9.L$0 = r8
            r9.L$1 = r7
            r9.L$2 = r6
            r9.I$0 = r4
            r9.I$1 = r2
            r9.label = r3
            java.lang.Object r5 = r10.transform(r5, r11, r9)
            if (r5 != r1) goto L_0x0081
            return r1
        L_0x0081:
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            kotlinx.coroutines.CoroutineScopeKt.ensureActive(r8)
            int r4 = r4 + r3
            goto L_0x0062
        L_0x0088:
            coil.EventListener r1 = r9.$eventListener
            coil.request.ImageRequest r2 = r9.$request
            r1.transformEnd(r2, r5)
            coil.intercept.EngineInterceptor$ExecuteResult r10 = r9.$result
            coil.request.ImageRequest r1 = r9.$request
            android.content.Context r1 = r1.getContext()
            android.content.res.Resources r1 = r1.getResources()
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable
            r2.<init>(r1, r5)
            r11 = r2
            android.graphics.drawable.Drawable r11 = (android.graphics.drawable.Drawable) r11
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 14
            r16 = 0
            coil.intercept.EngineInterceptor$ExecuteResult r1 = coil.intercept.EngineInterceptor.ExecuteResult.copy$default(r10, r11, r12, r13, r14, r15, r16)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor$transform$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
