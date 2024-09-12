package zendesk.messaging.android.internal.conversationscreen;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenCoordinator$requestRuntimePermissions$1;
import zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermissionState;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationScreenCoordinator$requestRuntimePermissions$1$1", f = "ConversationScreenCoordinator.kt", i = {}, l = {244, 249, 258, 264}, m = "emit", n = {}, s = {})
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$requestRuntimePermissions$1$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationScreenCoordinator$requestRuntimePermissions$1.AnonymousClass1<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenCoordinator$requestRuntimePermissions$1$1$emit$1(ConversationScreenCoordinator$requestRuntimePermissions$1.AnonymousClass1<? super T> r1, Continuation<? super ConversationScreenCoordinator$requestRuntimePermissions$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = r1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((List<RuntimePermissionState>) null, (Continuation<? super Unit>) this);
    }
}
