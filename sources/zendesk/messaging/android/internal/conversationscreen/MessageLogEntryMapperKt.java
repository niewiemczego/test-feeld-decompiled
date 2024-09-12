package zendesk.messaging.android.internal.conversationscreen;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import zendesk.conversationkit.android.model.Message;
import zendesk.conversationkit.android.model.MessageContent;
import zendesk.conversationkit.android.model.MessageStatus;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00012#\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H\u0002¨\u0006\b"}, d2 = {"overrideWithQuotedMessageDetails", "Lzendesk/conversationkit/android/model/Message;", "quotedMessageFinder", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "quotedMessageId", "zendesk.messaging_messaging-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogEntryMapper.kt */
public final class MessageLogEntryMapperKt {
    /* access modifiers changed from: private */
    public static final Message overrideWithQuotedMessageDetails(Message message, Function1<? super String, Message> function1) {
        Message invoke;
        MessageContent content = message.getContent();
        if (!(content instanceof MessageContent.FormResponse) || (invoke = function1.invoke(((MessageContent.FormResponse) content).getQuotedMessageId())) == null) {
            return message;
        }
        return Message.copy$default(message, (String) null, invoke.getAuthor(), (MessageStatus) null, invoke.getCreated(), invoke.getReceived(), 0.0d, (MessageContent) null, (Map) null, (String) null, (String) null, (String) null, 2021, (Object) null);
    }
}
