package expo.modules.kotlin.functions;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u0001\"\u0006\b\u0005\u0010\u0007\u0018\u0001*\u00020\b2\u0010\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\nH@"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "P3", "P4", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {1, 7, 1}, xi = 176)
@DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$11", f = "AsyncFunctionBuilder.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AsyncFunctionBuilder.kt */
public final class AsyncFunctionBuilder$SuspendBody$11 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    final /* synthetic */ Function6<P0, P1, P2, P3, P4, Continuation<? super R>, Object> $block;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncFunctionBuilder$SuspendBody$11(Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Continuation<? super R>, ? extends Object> function6, Continuation<? super AsyncFunctionBuilder$SuspendBody$11> continuation) {
        super(3, continuation);
        this.$block = function6;
    }

    public final Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        AsyncFunctionBuilder$SuspendBody$11 asyncFunctionBuilder$SuspendBody$11 = new AsyncFunctionBuilder$SuspendBody$11(this.$block, continuation);
        asyncFunctionBuilder$SuspendBody$11.L$0 = objArr;
        return asyncFunctionBuilder$SuspendBody$11.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object[] objArr = (Object[]) this.L$0;
            Function6<P0, P1, P2, P3, P4, Continuation<? super R>, Object> function6 = this.$block;
            Object obj2 = objArr[0];
            Intrinsics.reifiedOperationMarker(1, "P0");
            Object obj3 = obj2;
            Object obj4 = objArr[1];
            Intrinsics.reifiedOperationMarker(1, "P1");
            Object obj5 = obj4;
            Object obj6 = objArr[2];
            Intrinsics.reifiedOperationMarker(1, "P2");
            Object obj7 = obj6;
            Object obj8 = objArr[3];
            Intrinsics.reifiedOperationMarker(1, "P3");
            Object obj9 = obj8;
            Object obj10 = objArr[4];
            Intrinsics.reifiedOperationMarker(1, "P4");
            Object obj11 = obj10;
            this.label = 1;
            obj = function6.invoke(obj2, obj4, obj6, obj8, obj10, this);
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

    public final Object invokeSuspend$$forInline(Object obj) {
        Object[] objArr = (Object[]) this.L$0;
        Function6<P0, P1, P2, P3, P4, Continuation<? super R>, Object> function6 = this.$block;
        Object obj2 = objArr[0];
        Intrinsics.reifiedOperationMarker(1, "P0");
        Object obj3 = obj2;
        Object obj4 = objArr[1];
        Intrinsics.reifiedOperationMarker(1, "P1");
        Object obj5 = obj4;
        Object obj6 = objArr[2];
        Intrinsics.reifiedOperationMarker(1, "P2");
        Object obj7 = obj6;
        Object obj8 = objArr[3];
        Intrinsics.reifiedOperationMarker(1, "P3");
        Object obj9 = obj8;
        Object obj10 = objArr[4];
        Intrinsics.reifiedOperationMarker(1, "P4");
        Object obj11 = obj10;
        return function6.invoke(obj2, obj4, obj6, obj8, obj10, this);
    }
}
