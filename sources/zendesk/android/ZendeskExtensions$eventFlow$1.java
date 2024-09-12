package zendesk.android;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import zendesk.android.events.ZendeskEvent;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lzendesk/android/events/ZendeskEvent;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.ZendeskExtensions$eventFlow$1", f = "ZendeskExtensions.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ZendeskExtensions.kt */
final class ZendeskExtensions$eventFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super ZendeskEvent>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Zendesk $this_eventFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZendeskExtensions$eventFlow$1(Zendesk zendesk2, Continuation<? super ZendeskExtensions$eventFlow$1> continuation) {
        super(2, continuation);
        this.$this_eventFlow = zendesk2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ZendeskExtensions$eventFlow$1 zendeskExtensions$eventFlow$1 = new ZendeskExtensions$eventFlow$1(this.$this_eventFlow, continuation);
        zendeskExtensions$eventFlow$1.L$0 = obj;
        return zendeskExtensions$eventFlow$1;
    }

    public final Object invoke(ProducerScope<? super ZendeskEvent> producerScope, Continuation<? super Unit> continuation) {
        return ((ZendeskExtensions$eventFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            final ZendeskExtensions$eventFlow$1$$ExternalSyntheticLambda0 zendeskExtensions$eventFlow$1$$ExternalSyntheticLambda0 = new ZendeskExtensions$eventFlow$1$$ExternalSyntheticLambda0(producerScope);
            this.$this_eventFlow.addEventListener(zendeskExtensions$eventFlow$1$$ExternalSyntheticLambda0);
            final Zendesk zendesk2 = this.$this_eventFlow;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() {
                public final void invoke() {
                    zendesk2.removeEventListener(zendeskExtensions$eventFlow$1$$ExternalSyntheticLambda0);
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m2747invokeSuspend$lambda0(ProducerScope producerScope, ZendeskEvent zendeskEvent) {
        producerScope.m2546trySendJP2dKIU(zendeskEvent);
    }
}
