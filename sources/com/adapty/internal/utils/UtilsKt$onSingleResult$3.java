package com.adapty.internal.utils;

import com.adapty.utils.AdaptyResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "result", "Lcom/adapty/utils/AdaptyResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.utils.UtilsKt$onSingleResult$3", f = "utils.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: utils.kt */
final class UtilsKt$onSingleResult$3 extends SuspendLambda implements Function2<AdaptyResult<? extends T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<AdaptyResult<? extends T>, Continuation<? super Unit>, Object> $action;
    final /* synthetic */ Ref.BooleanRef $consumed;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UtilsKt$onSingleResult$3(Ref.BooleanRef booleanRef, Function2<? super AdaptyResult<? extends T>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super UtilsKt$onSingleResult$3> continuation) {
        super(2, continuation);
        this.$consumed = booleanRef;
        this.$action = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UtilsKt$onSingleResult$3 utilsKt$onSingleResult$3 = new UtilsKt$onSingleResult$3(this.$consumed, this.$action, continuation);
        utilsKt$onSingleResult$3.L$0 = obj;
        return utilsKt$onSingleResult$3;
    }

    public final Object invoke(AdaptyResult<? extends T> adaptyResult, Continuation<? super Unit> continuation) {
        return ((UtilsKt$onSingleResult$3) create(adaptyResult, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AdaptyResult adaptyResult = (AdaptyResult) this.L$0;
            if (!this.$consumed.element) {
                this.$consumed.element = true;
                Function2<AdaptyResult<? extends T>, Continuation<? super Unit>, Object> function2 = this.$action;
                this.label = 1;
                if (function2.invoke(adaptyResult, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
