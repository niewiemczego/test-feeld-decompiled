package zendesk.android.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import zendesk.android.events.ZendeskEvent;
import zendesk.android.events.internal.ZendeskEventDispatcher;
import zendesk.android.internal.di.ZendeskComponent;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "it", "Lzendesk/android/events/ZendeskEvent;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.internal.ZendeskFactory$create$messaging$1", f = "ZendeskFactory.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ZendeskFactory.kt */
final class ZendeskFactory$create$messaging$1 extends SuspendLambda implements Function2<ZendeskEvent, Continuation<? super Unit>, Object> {
    final /* synthetic */ ZendeskComponent $zendeskComponent;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZendeskFactory$create$messaging$1(ZendeskComponent zendeskComponent, Continuation<? super ZendeskFactory$create$messaging$1> continuation) {
        super(2, continuation);
        this.$zendeskComponent = zendeskComponent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ZendeskFactory$create$messaging$1 zendeskFactory$create$messaging$1 = new ZendeskFactory$create$messaging$1(this.$zendeskComponent, continuation);
        zendeskFactory$create$messaging$1.L$0 = obj;
        return zendeskFactory$create$messaging$1;
    }

    public final Object invoke(ZendeskEvent zendeskEvent, Continuation<? super Unit> continuation) {
        return ((ZendeskFactory$create$messaging$1) create(zendeskEvent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ZendeskEventDispatcher zendeskEventDispatcher = this.$zendeskComponent.zendeskEventDispatcher();
            this.label = 1;
            if (zendeskEventDispatcher.notifyEventListeners((ZendeskEvent) this.L$0, this) == coroutine_suspended) {
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
