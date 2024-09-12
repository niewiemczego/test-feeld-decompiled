package expo.modules.kotlin.functions;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u0001\"\u0006\b\u0005\u0010\u0007\u0018\u0001\"\u0006\b\u0006\u0010\b\u0018\u0001\"\u0006\b\u0007\u0010\t\u0018\u0001\"\u0006\b\b\u0010\n\u0018\u0001*\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\rH@¨\u0006\u000e"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "P3", "P4", "P5", "P6", "P7", "Lkotlinx/coroutines/CoroutineScope;", "it", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$17"}, k = 3, mv = {1, 7, 1}, xi = 176)
@DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$8", f = "AsyncFunctionBuilder.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AsyncFunctionBuilder.kt */
public final class AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$8 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    final /* synthetic */ Function9 $block;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$8(Function9 function9, Continuation continuation) {
        super(3, continuation);
        this.$block = function9;
    }

    public final Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$8 asyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$8 = new AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$8(this.$block, continuation);
        asyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$8.L$0 = objArr;
        return asyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$8.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object[] objArr = (Object[]) this.L$0;
            Function9 function9 = this.$block;
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
            Object obj12 = objArr[5];
            Intrinsics.reifiedOperationMarker(1, "P5");
            Object obj13 = obj12;
            Object obj14 = objArr[6];
            Intrinsics.reifiedOperationMarker(1, "P6");
            Object obj15 = obj14;
            Object obj16 = objArr[7];
            Intrinsics.reifiedOperationMarker(1, "P7");
            Object obj17 = obj16;
            this.label = 1;
            obj = function9.invoke(obj2, obj4, obj6, obj8, obj10, obj12, obj14, obj16, this);
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
        Function9 function9 = this.$block;
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
        Object obj12 = objArr[5];
        Intrinsics.reifiedOperationMarker(1, "P5");
        Object obj13 = obj12;
        Object obj14 = objArr[6];
        Intrinsics.reifiedOperationMarker(1, "P6");
        Object obj15 = obj14;
        Object obj16 = objArr[7];
        Intrinsics.reifiedOperationMarker(1, "P7");
        Object obj17 = obj16;
        return function9.invoke(obj2, obj4, obj6, obj8, obj10, obj12, obj14, obj16, this);
    }
}
