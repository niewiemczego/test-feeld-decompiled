package zendesk.messaging.android.internal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.conversationkit.android.model.Message;
import zendesk.conversationkit.android.model.Participant;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"hasNewInboundMessages", "", "Lzendesk/conversationkit/android/model/Conversation;", "zendesk.messaging_messaging-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewMessagesDividerHandler.kt */
public final class NewMessagesDividerHandlerKt {
    public static final boolean hasNewInboundMessages(Conversation conversation) {
        Object obj;
        Intrinsics.checkNotNullParameter(conversation, "<this>");
        if (!conversation.getMessages().isEmpty()) {
            Collection arrayList = new ArrayList();
            for (Object next : conversation.getMessages()) {
                if (!((Message) next).isAuthoredBy(conversation.getMyself())) {
                    arrayList.add(next);
                }
            }
            Iterator it = ((List) arrayList).iterator();
            LocalDateTime localDateTime = null;
            if (!it.hasNext()) {
                obj = null;
            } else {
                obj = it.next();
                if (it.hasNext()) {
                    Comparable received = ((Message) obj).getReceived();
                    do {
                        Object next2 = it.next();
                        Comparable received2 = ((Message) next2).getReceived();
                        if (received.compareTo(received2) < 0) {
                            obj = next2;
                            received = received2;
                        }
                    } while (it.hasNext());
                }
            }
            Message message = (Message) obj;
            LocalDateTime received3 = message != null ? message.getReceived() : null;
            Participant myself = conversation.getMyself();
            if (myself != null) {
                localDateTime = myself.getLastRead();
            }
            if (localDateTime != null) {
                if (localDateTime.compareTo(received3) < 0) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
