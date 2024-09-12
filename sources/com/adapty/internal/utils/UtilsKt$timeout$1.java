package com.adapty.internal.utils;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "e", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.utils.UtilsKt$timeout$1", f = "utils.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: utils.kt */
final class UtilsKt$timeout$1 extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    UtilsKt$timeout$1(Continuation<? super UtilsKt$timeout$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(FlowCollector<? super T> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        UtilsKt$timeout$1 utilsKt$timeout$1 = new UtilsKt$timeout$1(continuation);
        utilsKt$timeout$1.L$0 = flowCollector;
        utilsKt$timeout$1.L$1 = th;
        return utilsKt$timeout$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            AdaptyError adaptyError = th instanceof AdaptyError ? (AdaptyError) th : null;
            if ((adaptyError != null ? adaptyError.getAdaptyErrorCode() : null) == AdaptyErrorCode.SERVER_ERROR) {
                this.L$0 = null;
                this.label = 1;
                if (flowCollector.emit(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw th;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
