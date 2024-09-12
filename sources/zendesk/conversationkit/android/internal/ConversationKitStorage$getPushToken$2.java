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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.ConversationKitStorage$getPushToken$2", f = "ConversationKitStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConversationKitStorage.kt */
final class ConversationKitStorage$getPushToken$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;
    final /* synthetic */ ConversationKitStorage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationKitStorage$getPushToken$2(ConversationKitStorage conversationKitStorage, Continuation<? super ConversationKitStorage$getPushToken$2> continuation) {
        super(2, continuation);
        this.this$0 = conversationKitStorage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationKitStorage$getPushToken$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((ConversationKitStorage$getPushToken$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.getPushToken();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
