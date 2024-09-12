package com.adapty.internal.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.utils.IPv4Retriever$getIPv4$1", f = "IPv4Retriever.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IPv4Retriever.kt */
final class IPv4Retriever$getIPv4$1 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IPv4Retriever this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IPv4Retriever$getIPv4$1(IPv4Retriever iPv4Retriever, Continuation<? super IPv4Retriever$getIPv4$1> continuation) {
        super(2, continuation);
        this.this$0 = iPv4Retriever;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        IPv4Retriever$getIPv4$1 iPv4Retriever$getIPv4$1 = new IPv4Retriever$getIPv4$1(this.this$0, continuation);
        iPv4Retriever$getIPv4$1.L$0 = obj;
        return iPv4Retriever$getIPv4$1;
    }

    public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
        return ((IPv4Retriever$getIPv4$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String value = this.this$0.cloudRepository.getIPv4Request().getValue();
            this.this$0.setValue(value);
            this.label = 1;
            if (((FlowCollector) this.L$0).emit(value, this) == coroutine_suspended) {
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