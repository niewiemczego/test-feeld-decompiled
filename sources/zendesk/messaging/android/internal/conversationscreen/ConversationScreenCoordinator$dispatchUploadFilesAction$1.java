package zendesk.messaging.android.internal.conversationscreen;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction;
import zendesk.messaging.android.internal.model.UploadFile;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationScreenCoordinator$dispatchUploadFilesAction$1", f = "ConversationScreenCoordinator.kt", i = {}, l = {388}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$dispatchUploadFilesAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<UploadFile> $uploads;
    Object L$0;
    int label;
    final /* synthetic */ ConversationScreenCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenCoordinator$dispatchUploadFilesAction$1(List<UploadFile> list, ConversationScreenCoordinator conversationScreenCoordinator, Continuation<? super ConversationScreenCoordinator$dispatchUploadFilesAction$1> continuation) {
        super(2, continuation);
        this.$uploads = list;
        this.this$0 = conversationScreenCoordinator;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationScreenCoordinator$dispatchUploadFilesAction$1(this.$uploads, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConversationScreenCoordinator$dispatchUploadFilesAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List<UploadFile> list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List<UploadFile> list2 = this.$uploads;
            this.L$0 = list2;
            this.label = 1;
            Object conversationId$zendesk_messaging_messaging_android = this.this$0.conversationScreenViewModel.conversationId$zendesk_messaging_messaging_android(this);
            if (conversationId$zendesk_messaging_messaging_android == coroutine_suspended) {
                return coroutine_suspended;
            }
            list = list2;
            obj = conversationId$zendesk_messaging_messaging_android;
        } else if (i == 1) {
            list = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.conversationScreenViewModel.dispatchAction(new ConversationScreenAction.UploadFiles(list, (String) obj));
        return Unit.INSTANCE;
    }
}
