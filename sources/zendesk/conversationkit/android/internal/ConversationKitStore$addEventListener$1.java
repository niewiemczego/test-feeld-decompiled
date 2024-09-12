package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import zendesk.conversationkit.android.ConversationKitEventListener;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.ConversationKitStore$addEventListener$1", f = "ConversationKitStore.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConversationKitStore.kt */
final class ConversationKitStore$addEventListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConversationKitEventListener $listener;
    int label;
    final /* synthetic */ ConversationKitStore this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationKitStore$addEventListener$1(ConversationKitStore conversationKitStore, ConversationKitEventListener conversationKitEventListener, Continuation<? super ConversationKitStore$addEventListener$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationKitStore;
        this.$listener = conversationKitEventListener;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationKitStore$addEventListener$1(this.this$0, this.$listener, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConversationKitStore$addEventListener$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "zendesk.conversationkit.android.internal.ConversationKitStore$addEventListener$1$1", f = "ConversationKitStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: zendesk.conversationkit.android.internal.ConversationKitStore$addEventListener$1$1  reason: invalid class name */
    /* compiled from: ConversationKitStore.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(conversationKitStore, conversationKitEventListener, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                conversationKitStore.listeners.add(conversationKitEventListener);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ConversationKitStore conversationKitStore = this.this$0;
            final ConversationKitEventListener conversationKitEventListener = this.$listener;
            this.label = 1;
            if (BuildersKt.withContext(this.this$0.conversationKitDispatchers.main(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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
