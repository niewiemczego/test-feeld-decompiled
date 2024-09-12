package zendesk.messaging.android.internal.conversationscreen;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationScreenCoordinator$requestImageCapture$1", f = "ConversationScreenCoordinator.kt", i = {}, l = {312}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$requestImageCapture$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RuntimePermission $runtimePermission;
    int label;
    final /* synthetic */ ConversationScreenCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenCoordinator$requestImageCapture$1(ConversationScreenCoordinator conversationScreenCoordinator, RuntimePermission runtimePermission, Continuation<? super ConversationScreenCoordinator$requestImageCapture$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationScreenCoordinator;
        this.$runtimePermission = runtimePermission;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationScreenCoordinator$requestImageCapture$1(this.this$0, this.$runtimePermission, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConversationScreenCoordinator$requestImageCapture$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Intent cameraIntent = this.this$0.attachmentIntents.getCameraIntent();
            this.label = 1;
            if (this.this$0.requestForActivityResult(this.$runtimePermission, false, cameraIntent, this) == coroutine_suspended) {
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
