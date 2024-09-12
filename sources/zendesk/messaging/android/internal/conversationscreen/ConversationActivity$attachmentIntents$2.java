package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import zendesk.messaging.android.internal.DefaultAttachmentIntents;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lzendesk/messaging/android/internal/DefaultAttachmentIntents;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationActivity.kt */
final class ConversationActivity$attachmentIntents$2 extends Lambda implements Function0<DefaultAttachmentIntents> {
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationActivity$attachmentIntents$2(ConversationActivity conversationActivity) {
        super(0);
        this.this$0 = conversationActivity;
    }

    public final DefaultAttachmentIntents invoke() {
        return new DefaultAttachmentIntents(this.this$0);
    }
}
