package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.conversationkit.android.ConnectionStatus;
import zendesk.conversationkit.android.internal.Action;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.ConnectivityObserver$onLost$1", f = "ConnectivityObserver.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConnectivityObserver.kt */
final class ConnectivityObserver$onLost$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConnectivityObserver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectivityObserver$onLost$1(ConnectivityObserver connectivityObserver, Continuation<? super ConnectivityObserver$onLost$1> continuation) {
        super(2, continuation);
        this.this$0 = connectivityObserver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConnectivityObserver$onLost$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConnectivityObserver$onLost$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.getActionDispatcher().dispatch(new Action.NetworkConnectionStatusUpdate(ConnectionStatus.DISCONNECTED), this) == coroutine_suspended) {
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
