package zendesk.messaging.android.internal;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.conversationkit.android.ConversationKit;
import zendesk.conversationkit.android.ConversationKitEvent;
import zendesk.conversationkit.android.ConversationKitResult;
import zendesk.conversationkit.android.model.ProactiveMessage;
import zendesk.conversationkit.android.model.ProactiveMessageStatus;
import zendesk.logger.Logger;
import zendesk.messaging.android.internal.proactivemessaging.ProactiveMessageEvent;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.DefaultMessaging$handleProactiveMessageEvent$1", f = "DefaultMessaging.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultMessaging.kt */
final class DefaultMessaging$handleProactiveMessageEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProactiveMessageEvent $event;
    final /* synthetic */ int $proactiveMessageId;
    int label;
    final /* synthetic */ DefaultMessaging this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultMessaging.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProactiveMessageEvent.values().length];
            iArr[ProactiveMessageEvent.OPENED.ordinal()] = 1;
            iArr[ProactiveMessageEvent.REPLIED_TO.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultMessaging$handleProactiveMessageEvent$1(DefaultMessaging defaultMessaging, int i, ProactiveMessageEvent proactiveMessageEvent, Continuation<? super DefaultMessaging$handleProactiveMessageEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultMessaging;
        this.$proactiveMessageId = i;
        this.$event = proactiveMessageEvent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultMessaging$handleProactiveMessageEvent$1(this.this$0, this.$proactiveMessageId, this.$event, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultMessaging$handleProactiveMessageEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ConversationKitEvent.ProactiveMessageStatusChanged proactiveMessageStatusChanged;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getConversationKit$zendesk_messaging_messaging_android().getProactiveMessage(this.$proactiveMessageId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ConversationKitResult conversationKitResult = (ConversationKitResult) obj;
        if (conversationKitResult instanceof ConversationKitResult.Failure) {
            Logger.e(DefaultMessaging.LOG_TAG, "Failed to retrieve proactive message " + this.$proactiveMessageId + " from conversation kit", new Object[0]);
        } else if (conversationKitResult instanceof ConversationKitResult.Success) {
            ProactiveMessage proactiveMessage = (ProactiveMessage) ((ConversationKitResult.Success) conversationKitResult).getValue();
            ConversationKit conversationKit$zendesk_messaging_messaging_android = this.this$0.getConversationKit$zendesk_messaging_messaging_android();
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.$event.ordinal()];
            if (i2 == 1) {
                proactiveMessageStatusChanged = new ConversationKitEvent.ProactiveMessageStatusChanged(new ProactiveMessageStatus.NotificationHasBeenClicked(proactiveMessage));
            } else if (i2 == 2) {
                proactiveMessageStatusChanged = new ConversationKitEvent.ProactiveMessageStatusChanged(new ProactiveMessageStatus.ConversationHasBeenRepliedTo(proactiveMessage));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            conversationKit$zendesk_messaging_messaging_android.dispatchEvent(proactiveMessageStatusChanged);
        }
        return Unit.INSTANCE;
    }
}
