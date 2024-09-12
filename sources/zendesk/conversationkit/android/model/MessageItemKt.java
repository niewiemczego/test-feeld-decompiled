package zendesk.conversationkit.android.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.MessageActionDto;
import zendesk.conversationkit.android.internal.rest.model.MessageItemDto;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toItem", "Lzendesk/conversationkit/android/model/MessageItem;", "Lzendesk/conversationkit/android/internal/rest/model/MessageItemDto;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageItem.kt */
public final class MessageItemKt {
    public static final MessageItem toItem(MessageItemDto messageItemDto) {
        Intrinsics.checkNotNullParameter(messageItemDto, "<this>");
        String title = messageItemDto.getTitle();
        String description = messageItemDto.getDescription();
        Collection arrayList = new ArrayList();
        for (MessageActionDto action : messageItemDto.getActions()) {
            MessageAction action2 = MessageActionKt.toAction(action);
            if (action2 != null) {
                arrayList.add(action2);
            }
        }
        return new MessageItem(title, description, (List) arrayList, Intrinsics.areEqual((Object) messageItemDto.getSize(), (Object) "large") ? MessageItemSize.LARGE : MessageItemSize.COMPACT, messageItemDto.getMetadata(), messageItemDto.getMediaUrl(), messageItemDto.getMediaType());
    }
}
