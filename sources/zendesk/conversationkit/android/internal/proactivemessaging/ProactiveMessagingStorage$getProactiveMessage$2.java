package zendesk.conversationkit.android.internal.proactivemessaging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.conversationkit.android.model.ProactiveMessage;
import zendesk.storage.android.Storage;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lzendesk/conversationkit/android/model/ProactiveMessage;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.proactivemessaging.ProactiveMessagingStorage$getProactiveMessage$2", f = "ProactiveMessagingStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProactiveMessagingStorage.kt */
final class ProactiveMessagingStorage$getProactiveMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ProactiveMessage>, Object> {
    final /* synthetic */ int $proactiveMessageId;
    int label;
    final /* synthetic */ ProactiveMessagingStorage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProactiveMessagingStorage$getProactiveMessage$2(ProactiveMessagingStorage proactiveMessagingStorage, int i, Continuation<? super ProactiveMessagingStorage$getProactiveMessage$2> continuation) {
        super(2, continuation);
        this.this$0 = proactiveMessagingStorage;
        this.$proactiveMessageId = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProactiveMessagingStorage$getProactiveMessage$2(this.this$0, this.$proactiveMessageId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ProactiveMessage> continuation) {
        return ((ProactiveMessagingStorage$getProactiveMessage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Storage access$getStorage$p = this.this$0.storage;
            String valueOf = String.valueOf(this.$proactiveMessageId);
            String name = ProactiveMessage.class.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -2056817302:
                        if (name.equals("java.lang.Integer")) {
                            return (ProactiveMessage) access$getStorage$p.get(valueOf, Integer.TYPE);
                        }
                        break;
                    case -527879800:
                        if (name.equals("java.lang.Float")) {
                            return (ProactiveMessage) access$getStorage$p.get(valueOf, Float.TYPE);
                        }
                        break;
                    case 344809556:
                        if (name.equals("java.lang.Boolean")) {
                            return (ProactiveMessage) access$getStorage$p.get(valueOf, Boolean.TYPE);
                        }
                        break;
                    case 398795216:
                        if (name.equals("java.lang.Long")) {
                            return (ProactiveMessage) access$getStorage$p.get(valueOf, Long.TYPE);
                        }
                        break;
                }
            }
            return access$getStorage$p.get(valueOf, ProactiveMessage.class);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
