package zendesk.android;

import android.content.Context;
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
import zendesk.android.messaging.MessagingFactory;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.Zendesk$Companion$initialize$1", f = "Zendesk.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Zendesk.kt */
final class Zendesk$Companion$initialize$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelKey;
    final /* synthetic */ Context $context;
    final /* synthetic */ FailureCallback<Throwable> $failureCallback;
    final /* synthetic */ MessagingFactory $messagingFactory;
    final /* synthetic */ SuccessCallback<Zendesk> $successCallback;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Zendesk$Companion$initialize$1(Context context, String str, MessagingFactory messagingFactory, FailureCallback<Throwable> failureCallback, SuccessCallback<Zendesk> successCallback, Continuation<? super Zendesk$Companion$initialize$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$channelKey = str;
        this.$messagingFactory = messagingFactory;
        this.$failureCallback = failureCallback;
        this.$successCallback = successCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Zendesk$Companion$initialize$1(this.$context, this.$channelKey, this.$messagingFactory, this.$failureCallback, this.$successCallback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Zendesk$Companion$initialize$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = Zendesk.Companion.initialize(this.$context, this.$channelKey, this.$messagingFactory, (Continuation) this);
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
            this.$successCallback.onSuccess(((ZendeskResult.Success) zendeskResult).getValue());
        }
        return Unit.INSTANCE;
    }
}
