package zendesk.android;

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
@DebugMetadata(c = "zendesk.android.Zendesk$addEventListener$1", f = "Zendesk.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Zendesk.kt */
final class Zendesk$addEventListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ZendeskEventListener $listener;
    int label;
    final /* synthetic */ Zendesk this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Zendesk$addEventListener$1(Zendesk zendesk2, ZendeskEventListener zendeskEventListener, Continuation<? super Zendesk$addEventListener$1> continuation) {
        super(2, continuation);
        this.this$0 = zendesk2;
        this.$listener = zendeskEventListener;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Zendesk$addEventListener$1(this.this$0, this.$listener, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Zendesk$addEventListener$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.eventDispatcher.addEventListener(this.$listener, this) == coroutine_suspended) {
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
