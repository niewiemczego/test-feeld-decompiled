package coil.request;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "coil.request.ViewTargetRequestManager$dispose$1", f = "ViewTargetRequestManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ViewTargetRequestManager.kt */
final class ViewTargetRequestManager$dispose$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ViewTargetRequestManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewTargetRequestManager$dispose$1(ViewTargetRequestManager viewTargetRequestManager, Continuation<? super ViewTargetRequestManager$dispose$1> continuation) {
        super(2, continuation);
        this.this$0 = viewTargetRequestManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ViewTargetRequestManager$dispose$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ViewTargetRequestManager$dispose$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.setRequest((ViewTargetRequestDelegate) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
