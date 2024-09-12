package com.adapty.internal;

import com.android.billingclient.api.ProductDetails;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.AdaptyInternal$activate$2", f = "AdaptyInternal.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AdaptyInternal.kt */
final class AdaptyInternal$activate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AdaptyInternal this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdaptyInternal$activate$2(AdaptyInternal adaptyInternal, Continuation<? super AdaptyInternal$activate$2> continuation) {
        super(2, continuation);
        this.this$0 = adaptyInternal;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdaptyInternal$activate$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdaptyInternal$activate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/android/billingclient/api/ProductDetails;", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.adapty.internal.AdaptyInternal$activate$2$1", f = "AdaptyInternal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.adapty.internal.AdaptyInternal$activate$2$1  reason: invalid class name */
    /* compiled from: AdaptyInternal.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends ProductDetails>>, Throwable, Continuation<? super Unit>, Object> {
        int label;

        public final Object invoke(FlowCollector<? super List<ProductDetails>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return new AnonymousClass1(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (FlowKt.collect(FlowKt.m2547catch(this.this$0.productsInteractor.getProductsOnStart(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null)), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
