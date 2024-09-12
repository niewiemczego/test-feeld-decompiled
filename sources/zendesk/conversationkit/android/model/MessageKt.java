package zendesk.conversationkit.android.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zendesk.conversationkit.android.internal.rest.model.MessageActionDto;
import zendesk.conversationkit.android.internal.rest.model.MessageDto;
import zendesk.conversationkit.android.internal.rest.model.MessageFieldDto;
import zendesk.conversationkit.android.internal.rest.model.MessageItemDto;
import zendesk.conversationkit.android.internal.rest.model.MessageListResponseDto;
import zendesk.conversationkit.android.internal.rest.model.MessageSourceDto;
import zendesk.conversationkit.android.internal.rest.model.SendMessageDto;
import zendesk.conversationkit.android.model.Field;
import zendesk.conversationkit.android.model.MessageContent;
import zendesk.core.android.internal.DateKtxKt;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\"\u0010\u0007\u001a\u00020\u0001*\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\bH\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0000\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0001H\u0000¨\u0006\u0014"}, d2 = {"enrichFormResponseFields", "Lzendesk/conversationkit/android/model/Message;", "conversation", "Lzendesk/conversationkit/android/model/Conversation;", "remoteOrLocalIdsAreEqual", "", "message", "toMessage", "Lzendesk/conversationkit/android/internal/rest/model/MessageDto;", "created", "Ljava/time/LocalDateTime;", "localId", "", "toMessageContent", "Lzendesk/conversationkit/android/model/MessageContent;", "toMessageList", "Lzendesk/conversationkit/android/model/MessageList;", "Lzendesk/conversationkit/android/internal/rest/model/MessageListResponseDto;", "toSendMessageDto", "Lzendesk/conversationkit/android/internal/rest/model/SendMessageDto;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Message.kt */
public final class MessageKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Message.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageType.values().length];
            iArr[MessageType.TEXT.ordinal()] = 1;
            iArr[MessageType.FILE.ordinal()] = 2;
            iArr[MessageType.FORM.ordinal()] = 3;
            iArr[MessageType.FORM_RESPONSE.ordinal()] = 4;
            iArr[MessageType.CAROUSEL.ordinal()] = 5;
            iArr[MessageType.IMAGE.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ Message toMessage$default(MessageDto messageDto, LocalDateTime localDateTime, String str, int i, Object obj) {
        MessageSourceDto source;
        if ((i & 1) != 0) {
            localDateTime = null;
        }
        if ((i & 2) != 0 && ((source = messageDto.getSource()) == null || (str = source.getSessionId()) == null)) {
            str = messageDto.getId();
        }
        return toMessage(messageDto, localDateTime, str);
    }

    public static final Message toMessage(MessageDto messageDto, LocalDateTime localDateTime, String str) {
        String str2;
        String id;
        MessageDto messageDto2 = messageDto;
        Intrinsics.checkNotNullParameter(messageDto, "<this>");
        Intrinsics.checkNotNullParameter(str, "localId");
        String id2 = messageDto.getId();
        String authorId = messageDto.getAuthorId();
        AuthorType findByValue = AuthorType.Companion.findByValue(messageDto.getRole());
        String name = messageDto.getName();
        if (name == null) {
            name = "";
        }
        Author author = new Author(authorId, findByValue, name, messageDto.getAvatarUrl());
        MessageStatus messageStatus = MessageStatus.SENT;
        LocalDateTime localDateTime$default = DateKtxKt.toLocalDateTime$default(messageDto.getReceived(), (ZoneId) null, 1, (Object) null);
        double received = messageDto.getReceived();
        MessageContent messageContent = toMessageContent(messageDto);
        Map<String, Object> metadata = messageDto.getMetadata();
        MessageSourceDto source = messageDto.getSource();
        if (source == null || (id = source.getId()) == null) {
            str2 = "";
        } else {
            str2 = id;
        }
        return new Message(id2, author, messageStatus, localDateTime, localDateTime$default, received, messageContent, metadata, str2, str, messageDto.getPayload());
    }

    public static final MessageContent toMessageContent(MessageDto messageDto) {
        Intrinsics.checkNotNullParameter(messageDto, "<this>");
        long j = 0;
        boolean z = false;
        String str = "";
        switch (WhenMappings.$EnumSwitchMapping$0[MessageType.Companion.findByValue(messageDto.getType()).ordinal()]) {
            case 1:
                String text = messageDto.getText();
                if (text != null) {
                    str = text;
                }
                List<MessageActionDto> actions = messageDto.getActions();
                if (actions == null) {
                    actions = CollectionsKt.emptyList();
                }
                Collection arrayList = new ArrayList();
                for (MessageActionDto action : actions) {
                    MessageAction action2 = MessageActionKt.toAction(action);
                    if (action2 != null) {
                        arrayList.add(action2);
                    }
                }
                return new MessageContent.Text(str, (List) arrayList);
            case 2:
                String text2 = messageDto.getText();
                String str2 = text2 == null ? str : text2;
                String altText = messageDto.getAltText();
                String str3 = altText == null ? str : altText;
                String mediaUrl = messageDto.getMediaUrl();
                String str4 = mediaUrl == null ? str : mediaUrl;
                String mediaType = messageDto.getMediaType();
                if (mediaType != null) {
                    str = mediaType;
                }
                Long mediaSize = messageDto.getMediaSize();
                if (mediaSize != null) {
                    j = mediaSize.longValue();
                }
                return new MessageContent.File(str2, str3, str4, str, j);
            case 3:
                List<MessageFieldDto> fields = messageDto.getFields();
                if (fields == null) {
                    fields = CollectionsKt.emptyList();
                }
                Collection arrayList2 = new ArrayList();
                for (MessageFieldDto field : fields) {
                    Field field2 = FieldKt.toField(field);
                    if (field2 != null) {
                        arrayList2.add(field2);
                    }
                }
                List list = (List) arrayList2;
                Boolean blockChatInput = messageDto.getBlockChatInput();
                if (blockChatInput != null) {
                    z = blockChatInput.booleanValue();
                }
                return new MessageContent.Form(list, z);
            case 4:
                List<MessageFieldDto> fields2 = messageDto.getFields();
                if (fields2 == null) {
                    fields2 = CollectionsKt.emptyList();
                }
                Collection arrayList3 = new ArrayList();
                for (MessageFieldDto field3 : fields2) {
                    Field field4 = FieldKt.toField(field3);
                    if (field4 != null) {
                        arrayList3.add(field4);
                    }
                }
                List list2 = (List) arrayList3;
                String quotedMessageId = messageDto.getQuotedMessageId();
                if (quotedMessageId != null) {
                    str = quotedMessageId;
                }
                return new MessageContent.FormResponse(str, list2);
            case 5:
                List<MessageItemDto> items = messageDto.getItems();
                if (items == null) {
                    items = CollectionsKt.emptyList();
                }
                Iterable<MessageItemDto> iterable = items;
                Collection arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (MessageItemDto item : iterable) {
                    arrayList4.add(MessageItemKt.toItem(item));
                }
                return new MessageContent.Carousel((List) arrayList4);
            case 6:
                String text3 = messageDto.getText();
                String str5 = text3 == null ? str : text3;
                String mediaUrl2 = messageDto.getMediaUrl();
                String str6 = mediaUrl2 == null ? str : mediaUrl2;
                String mediaType2 = messageDto.getMediaType();
                String str7 = mediaType2 == null ? str : mediaType2;
                Long mediaSize2 = messageDto.getMediaSize();
                if (mediaSize2 != null) {
                    j = mediaSize2.longValue();
                }
                long j2 = j;
                List<MessageActionDto> actions2 = messageDto.getActions();
                if (actions2 == null) {
                    actions2 = CollectionsKt.emptyList();
                }
                Collection arrayList5 = new ArrayList();
                for (MessageActionDto action3 : actions2) {
                    MessageAction action4 = MessageActionKt.toAction(action3);
                    if (action4 != null) {
                        arrayList5.add(action4);
                    }
                }
                return new MessageContent.Image(str5, str6, (String) null, str7, j2, (List) arrayList5);
            default:
                CharSequence textFallback = messageDto.getTextFallback();
                if (textFallback == null || StringsKt.isBlank(textFallback)) {
                    z = true;
                }
                if (z) {
                    return new MessageContent.Unsupported((String) null, 1, (DefaultConstructorMarker) null);
                }
                return new MessageContent.Text(messageDto.getTextFallback(), (List) null, 2, (DefaultConstructorMarker) null);
        }
    }

    public static final SendMessageDto toSendMessageDto(Message message) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(message, "<this>");
        MessageContent content = message.getContent();
        if (content instanceof MessageContent.Text) {
            return new SendMessageDto.Text(message.getAuthor().getType().getValue$zendesk_conversationkit_conversationkit_android(), message.getMetadata(), message.getPayload(), ((MessageContent.Text) message.getContent()).getText());
        }
        if (content instanceof MessageContent.FormResponse) {
            String value$zendesk_conversationkit_conversationkit_android = message.getAuthor().getType().getValue$zendesk_conversationkit_conversationkit_android();
            Map<String, Object> metadata = message.getMetadata();
            String payload = message.getPayload();
            Iterable<Field> fields = ((MessageContent.FormResponse) message.getContent()).getFields();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fields, 10));
            for (Field sendFieldResponseDto : fields) {
                arrayList.add(FieldKt.toSendFieldResponseDto(sendFieldResponseDto));
            }
            return new SendMessageDto.FormResponse(value$zendesk_conversationkit_conversationkit_android, metadata, payload, (List) arrayList, ((MessageContent.FormResponse) message.getContent()).getQuotedMessageId());
        }
        throw new IllegalArgumentException("Message with the " + message.getContent().getType() + " content type cannot be sent by this SDK");
    }

    public static final Message enrichFormResponseFields(Message message, Conversation conversation) {
        Object obj;
        Object obj2;
        Field copy$default;
        Object obj3;
        Object obj4;
        Message message2 = message;
        Intrinsics.checkNotNullParameter(message2, "<this>");
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        if (!(message.getContent() instanceof MessageContent.FormResponse)) {
            return message2;
        }
        Iterator it = conversation.getMessages().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((Message) obj).getId(), (Object) ((MessageContent.FormResponse) message.getContent()).getQuotedMessageId())) {
                break;
            }
        }
        Message message3 = (Message) obj;
        MessageContent content = message3 != null ? message3.getContent() : null;
        if (!(content instanceof MessageContent.Form)) {
            return message2;
        }
        MessageContent.FormResponse formResponse = (MessageContent.FormResponse) message.getContent();
        Iterable<Field> fields = ((MessageContent.FormResponse) message.getContent()).getFields();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fields, 10));
        for (Field field : fields) {
            if (field instanceof Field.Text) {
                Iterator it2 = ((MessageContent.Form) content).getFields().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj4 = null;
                        break;
                    }
                    obj4 = it2.next();
                    if (Intrinsics.areEqual((Object) ((Field) obj4).getId(), (Object) field.getId())) {
                        break;
                    }
                }
                Field field2 = (Field) obj4;
                if (!(field2 instanceof Field.Text)) {
                    arrayList.add(field);
                } else {
                    Field.Text text = (Field.Text) field2;
                    copy$default = Field.Text.copy$default((Field.Text) field, (String) null, (String) null, (String) null, text.getPlaceholder(), text.getMinSize(), text.getMaxSize(), (String) null, 71, (Object) null);
                }
            } else if (field instanceof Field.Email) {
                Iterator it3 = ((MessageContent.Form) content).getFields().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj3 = null;
                        break;
                    }
                    obj3 = it3.next();
                    if (Intrinsics.areEqual((Object) ((Field) obj3).getId(), (Object) field.getId())) {
                        break;
                    }
                }
                Field field3 = (Field) obj3;
                if (!(field3 instanceof Field.Email)) {
                    arrayList.add(field);
                } else {
                    copy$default = Field.Email.copy$default((Field.Email) field, (String) null, (String) null, (String) null, ((Field.Email) field3).getPlaceholder(), (String) null, 23, (Object) null);
                }
            } else if (field instanceof Field.Select) {
                Iterator it4 = ((MessageContent.Form) content).getFields().iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it4.next();
                    if (Intrinsics.areEqual((Object) ((Field) obj2).getId(), (Object) field.getId())) {
                        break;
                    }
                }
                Field field4 = (Field) obj2;
                if (!(field4 instanceof Field.Select)) {
                    arrayList.add(field);
                } else {
                    Field.Select select = (Field.Select) field4;
                    copy$default = Field.Select.copy$default((Field.Select) field, (String) null, (String) null, (String) null, select.getPlaceholder(), select.getOptions(), select.getSelectSize(), (List) null, 71, (Object) null);
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            field = copy$default;
            arrayList.add(field);
        }
        return Message.copy$default(message, (String) null, (Author) null, (MessageStatus) null, (LocalDateTime) null, (LocalDateTime) null, 0.0d, MessageContent.FormResponse.copy$default(formResponse, (String) null, (List) arrayList, 1, (Object) null), (Map) null, (String) null, (String) null, (String) null, 1983, (Object) null);
    }

    public static final boolean remoteOrLocalIdsAreEqual(Message message, Message message2) {
        Intrinsics.checkNotNullParameter(message, "<this>");
        Intrinsics.checkNotNullParameter(message2, "message");
        return Intrinsics.areEqual((Object) message.getLocalId(), (Object) message2.getLocalId()) || Intrinsics.areEqual((Object) message.getId(), (Object) message2.getId());
    }

    public static final MessageList toMessageList(MessageListResponseDto messageListResponseDto) {
        Intrinsics.checkNotNullParameter(messageListResponseDto, "<this>");
        Iterable<MessageDto> messages = messageListResponseDto.getMessages();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(messages, 10));
        for (MessageDto message$default : messages) {
            arrayList.add(toMessage$default(message$default, (LocalDateTime) null, (String) null, 3, (Object) null));
        }
        return new MessageList((List) arrayList, messageListResponseDto.getHasPrevious(), messageListResponseDto.getHasNext());
    }
}
