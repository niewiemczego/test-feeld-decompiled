package zendesk.android.internal.frontendevents.pageviewevents;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.ZendeskResult;
import zendesk.android.internal.proactivemessaging.ProactiveMessagingManager;
import zendesk.android.pageviewevents.PageView;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H@"}, d2 = {"<anonymous>", "Lzendesk/android/ZendeskResult;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.internal.frontendevents.pageviewevents.DefaultPageViewEvents$sendPageViewEvent$2", f = "DefaultPageViewEvents.kt", i = {1}, l = {23, 25}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
/* compiled from: DefaultPageViewEvents.kt */
final class DefaultPageViewEvents$sendPageViewEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZendeskResult<? extends Unit, ? extends Throwable>>, Object> {
    final /* synthetic */ PageView $pageView;
    Object L$0;
    int label;
    final /* synthetic */ DefaultPageViewEvents this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultPageViewEvents$sendPageViewEvent$2(DefaultPageViewEvents defaultPageViewEvents, PageView pageView, Continuation<? super DefaultPageViewEvents$sendPageViewEvent$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultPageViewEvents;
        this.$pageView = pageView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultPageViewEvents$sendPageViewEvent$2(this.this$0, this.$pageView, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZendeskResult<Unit, ? extends Throwable>> continuation) {
        return ((DefaultPageViewEvents$sendPageViewEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ZendeskResult zendeskResult;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.frontendEventsRepository.sendPageViewEvent(this.$pageView, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            zendeskResult = (ZendeskResult) this.L$0;
            ResultKt.throwOnFailure(obj);
            return zendeskResult;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ZendeskResult zendeskResult2 = (ZendeskResult) obj;
        if (!ProactiveMessagingManager.Companion.isProactiveMessagingEnabled$zendesk_zendesk_android()) {
            return zendeskResult2;
        }
        this.L$0 = zendeskResult2;
        this.label = 2;
        if (this.this$0.proactiveMessagingManager.evaluate$zendesk_zendesk_android(this.$pageView, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        zendeskResult = zendeskResult2;
        return zendeskResult;
    }
}
