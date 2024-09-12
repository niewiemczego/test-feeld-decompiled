package zendesk.android.events.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.events.ZendeskEventListener;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.events.internal.ZendeskEventDispatcher$removeEventListener$2", f = "ZendeskEventDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ZendeskEventDispatcher.kt */
final class ZendeskEventDispatcher$removeEventListener$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ZendeskEventListener $listener;
    int label;
    final /* synthetic */ ZendeskEventDispatcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZendeskEventDispatcher$removeEventListener$2(ZendeskEventDispatcher zendeskEventDispatcher, ZendeskEventListener zendeskEventListener, Continuation<? super ZendeskEventDispatcher$removeEventListener$2> continuation) {
        super(2, continuation);
        this.this$0 = zendeskEventDispatcher;
        this.$listener = zendeskEventListener;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZendeskEventDispatcher$removeEventListener$2(this.this$0, this.$listener, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZendeskEventDispatcher$removeEventListener$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.listeners.remove(this.$listener);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
