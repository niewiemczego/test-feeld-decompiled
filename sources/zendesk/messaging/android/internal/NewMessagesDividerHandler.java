package zendesk.messaging.android.internal;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.conversationkit.android.model.Message;
import zendesk.conversationkit.android.model.Participant;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lzendesk/messaging/android/internal/NewMessagesDividerHandler;", "", "()V", "newMessageDivider", "", "", "Ljava/time/LocalDateTime;", "clearNewMessageDividerDate", "", "conversationId", "getNewMessageDividerDate", "updateNewMessageDividerDate", "conversation", "Lzendesk/conversationkit/android/model/Conversation;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewMessagesDividerHandler.kt */
public final class NewMessagesDividerHandler {
    private final Map<String, LocalDateTime> newMessageDivider = new LinkedHashMap();

    public final LocalDateTime getNewMessageDividerDate(String str) {
        Intrinsics.checkNotNullParameter(str, "conversationId");
        return this.newMessageDivider.get(str);
    }

    public final void updateNewMessageDividerDate(Conversation conversation) {
        boolean z;
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        Participant myself = conversation.getMyself();
        LocalDateTime lastRead = myself != null ? myself.getLastRead() : null;
        if (NewMessagesDividerHandlerKt.hasNewInboundMessages(conversation) && lastRead != null) {
            Map<String, LocalDateTime> map = this.newMessageDivider;
            String id = conversation.getId();
            for (Message message : conversation.getMessages()) {
                if (message.isAuthoredBy(conversation.getMyself()) || message.getReceived().compareTo(lastRead) <= 0) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    map.put(id, message.getReceived());
                    return;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
    }

    public final void clearNewMessageDividerDate(String str) {
        Intrinsics.checkNotNullParameter(str, "conversationId");
        this.newMessageDivider.remove(str);
    }
}
