package com.adapty.internal.utils;

import com.adapty.utils.AdaptyResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/adapty/utils/AdaptyResult;", "error", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.utils.UtilsKt$onSingleResult$2", f = "utils.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: utils.kt */
final class UtilsKt$onSingleResult$2 extends SuspendLambda implements Function3<FlowCollector<? super AdaptyResult<? extends T>>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    UtilsKt$onSingleResult$2(Continuation<? super UtilsKt$onSingleResult$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(FlowCollector<? super AdaptyResult<? extends T>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        UtilsKt$onSingleResult$2 utilsKt$onSingleResult$2 = new UtilsKt$onSingleResult$2(continuation);
        utilsKt$onSingleResult$2.L$0 = flowCollector;
        utilsKt$onSingleResult$2.L$1 = th;
        return utilsKt$onSingleResult$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = null;
            this.label = 1;
            if (((FlowCollector) this.L$0).emit(new AdaptyResult.Error(UtilsKt.asAdaptyError((Throwable) this.L$1)), this) == coroutine_suspended) {
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
