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
import zendesk.android.ZendeskResult;
import zendesk.android.pageviewevents.PageView;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.Zendesk$sendPageView$1", f = "Zendesk.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Zendesk.kt */
final class Zendesk$sendPageView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FailureCallback<Throwable> $failureCallback;
    final /* synthetic */ PageView $pageView;
    final /* synthetic */ SuccessCallback<Unit> $successCallback;
    int label;
    final /* synthetic */ Zendesk this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Zendesk$sendPageView$1(Zendesk zendesk2, PageView pageView, FailureCallback<Throwable> failureCallback, SuccessCallback<Unit> successCallback, Continuation<? super Zendesk$sendPageView$1> continuation) {
        super(2, continuation);
        this.this$0 = zendesk2;
        this.$pageView = pageView;
        this.$failureCallback = failureCallback;
        this.$successCallback = successCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Zendesk$sendPageView$1(this.this$0, this.$pageView, this.$failureCallback, this.$successCallback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Zendesk$sendPageView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.pageViewEvents.sendPageViewEvent(this.$pageView, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ZendeskResult zendeskResult = (ZendeskResult) obj;
        if (zendeskResult instanceof ZendeskResult.Failure) {
            this.$failureCallback.onFailure((Throwable) ((ZendeskResult.Failure) zendeskResult).getError());
        } else if (zendeskResult instanceof ZendeskResult.Success) {
            SuccessCallback<Unit> successCallback = this.$successCallback;
            ((ZendeskResult.Success) zendeskResult).getValue();
            successCallback.onSuccess(Unit.INSTANCE);
        }
        return Unit.INSTANCE;
    }
}
