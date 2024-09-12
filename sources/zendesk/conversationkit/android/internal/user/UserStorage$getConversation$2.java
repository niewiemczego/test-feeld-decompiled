package zendesk.conversationkit.android.internal.user;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.storage.android.Storage;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lzendesk/conversationkit/android/model/Conversation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.user.UserStorage$getConversation$2", f = "UserStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: UserStorage.kt */
final class UserStorage$getConversation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Conversation>, Object> {
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ UserStorage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserStorage$getConversation$2(UserStorage userStorage, String str, Continuation<? super UserStorage$getConversation$2> continuation) {
        super(2, continuation);
        this.this$0 = userStorage;
        this.$conversationId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserStorage$getConversation$2(this.this$0, this.$conversationId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Conversation> continuation) {
        return ((UserStorage$getConversation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Storage access$getStorage$p = this.this$0.storage;
            String str = this.$conversationId;
            String name = Conversation.class.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -2056817302:
                        if (name.equals("java.lang.Integer")) {
                            return (Conversation) access$getStorage$p.get(str, Integer.TYPE);
                        }
                        break;
                    case -527879800:
                        if (name.equals("java.lang.Float")) {
                            return (Conversation) access$getStorage$p.get(str, Float.TYPE);
                        }
                        break;
                    case 344809556:
                        if (name.equals("java.lang.Boolean")) {
                            return (Conversation) access$getStorage$p.get(str, Boolean.TYPE);
                        }
                        break;
                    case 398795216:
                        if (name.equals("java.lang.Long")) {
                            return (Conversation) access$getStorage$p.get(str, Long.TYPE);
                        }
                        break;
                }
            }
            return access$getStorage$p.get(str, Conversation.class);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
