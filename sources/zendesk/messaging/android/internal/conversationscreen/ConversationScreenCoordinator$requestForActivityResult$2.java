package zendesk.messaging.android.internal.conversationscreen;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission;
import zendesk.messaging.android.internal.model.UploadFile;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "uploadFiles", "", "Lzendesk/messaging/android/internal/model/UploadFile;", "emit", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$requestForActivityResult$2<T> implements FlowCollector {
    final /* synthetic */ RuntimePermission $runtimePermission;
    final /* synthetic */ ConversationScreenCoordinator this$0;

    ConversationScreenCoordinator$requestForActivityResult$2(ConversationScreenCoordinator conversationScreenCoordinator, RuntimePermission runtimePermission) {
        this.this$0 = conversationScreenCoordinator;
        this.$runtimePermission = runtimePermission;
    }

    public final Object emit(List<UploadFile> list, Continuation<? super Unit> continuation) {
        this.this$0.dispatchUploadFilesAction$zendesk_messaging_messaging_android(list);
        this.$runtimePermission.cancel$zendesk_messaging_messaging_android();
        return Unit.INSTANCE;
    }
}
