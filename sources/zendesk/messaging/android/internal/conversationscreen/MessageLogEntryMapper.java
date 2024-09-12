package zendesk.messaging.android.internal.conversationscreen;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.conversationkit.android.model.Message;
import zendesk.conversationkit.android.model.MessageContent;
import zendesk.conversationkit.android.model.MessageStatus;
import zendesk.conversationkit.android.model.MessageType;
import zendesk.conversationkit.android.model.Participant;
import zendesk.core.android.internal.DateKtxKt;
import zendesk.messaging.android.internal.model.LoadMoreStatus;
import zendesk.messaging.android.internal.model.MessageDirection;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.messaging.android.internal.model.MessageLogType;
import zendesk.messaging.android.internal.model.MessagePosition;
import zendesk.messaging.android.internal.model.MessageShape;
import zendesk.messaging.android.internal.model.TypingUser;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u00016B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0002\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u001a\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J2\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000f2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J2\u0010*\u001a\u00020+*\b\u0012\u0004\u0012\u00020 0,2\u0006\u0010-\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0/H\u0002JL\u00100\u001a\u00020+*\b\u0012\u0004\u0012\u00020\u00140\u000f2\b\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00142\u0006\u00104\u001a\u00020\u00142\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0/2\f\u00105\u001a\b\u0012\u0004\u0012\u00020 0,H\u0002R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/MessageLogEntryMapper;", "", "messageContainerFactory", "Lzendesk/messaging/android/internal/conversationscreen/MessageContainerFactory;", "labelProvider", "Lzendesk/messaging/android/internal/conversationscreen/MessageLogLabelProvider;", "timestampFormatter", "Lzendesk/messaging/android/internal/conversationscreen/MessageLogTimestampFormatter;", "currentTimeProvider", "Lkotlin/Function0;", "Ljava/time/LocalDateTime;", "idProvider", "", "(Lzendesk/messaging/android/internal/conversationscreen/MessageContainerFactory;Lzendesk/messaging/android/internal/conversationscreen/MessageLogLabelProvider;Lzendesk/messaging/android/internal/conversationscreen/MessageLogTimestampFormatter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "allowedGroupingTypes", "", "Lzendesk/conversationkit/android/model/MessageType;", "compareWithNext", "Lzendesk/messaging/android/internal/conversationscreen/MessageLogEntryMapper$MessageNeighbour;", "currentMessage", "Lzendesk/conversationkit/android/model/Message;", "nextMessage", "compareWithPrevious", "previousMessage", "getPosition", "Lzendesk/messaging/android/internal/model/MessagePosition;", "previousNeighbour", "nextNeighbour", "getShape", "Lzendesk/messaging/android/internal/model/MessageShape;", "currentMessagePosition", "map", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "conversation", "Lzendesk/conversationkit/android/model/Conversation;", "newMessageDividerDate", "typingUser", "Lzendesk/messaging/android/internal/model/TypingUser;", "loadMoreStatus", "Lzendesk/messaging/android/internal/model/LoadMoreStatus;", "shouldAnimationOccur", "", "handleTimestampDivider", "", "", "message", "addedDayDividers", "", "mapIntoMessageLogEntry", "currentUser", "Lzendesk/conversationkit/android/model/Participant;", "lastReadMessage", "latestMessage", "destination", "MessageNeighbour", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogEntryMapper.kt */
public final class MessageLogEntryMapper {
    private final List<MessageType> allowedGroupingTypes;
    private final Function0<LocalDateTime> currentTimeProvider;
    private final Function0<String> idProvider;
    private final MessageLogLabelProvider labelProvider;
    private final MessageContainerFactory messageContainerFactory;
    private final MessageLogTimestampFormatter timestampFormatter;

    public MessageLogEntryMapper(MessageContainerFactory messageContainerFactory2, MessageLogLabelProvider messageLogLabelProvider, MessageLogTimestampFormatter messageLogTimestampFormatter, Function0<LocalDateTime> function0, Function0<String> function02) {
        Intrinsics.checkNotNullParameter(messageContainerFactory2, "messageContainerFactory");
        Intrinsics.checkNotNullParameter(messageLogLabelProvider, "labelProvider");
        Intrinsics.checkNotNullParameter(messageLogTimestampFormatter, "timestampFormatter");
        Intrinsics.checkNotNullParameter(function0, "currentTimeProvider");
        Intrinsics.checkNotNullParameter(function02, "idProvider");
        this.messageContainerFactory = messageContainerFactory2;
        this.labelProvider = messageLogLabelProvider;
        this.timestampFormatter = messageLogTimestampFormatter;
        this.currentTimeProvider = function0;
        this.idProvider = function02;
        this.allowedGroupingTypes = CollectionsKt.listOf(MessageType.TEXT, MessageType.FILE, MessageType.IMAGE, MessageType.UNSUPPORTED);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageLogEntryMapper(MessageContainerFactory messageContainerFactory2, MessageLogLabelProvider messageLogLabelProvider, MessageLogTimestampFormatter messageLogTimestampFormatter, Function0 function0, Function0 function02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(messageContainerFactory2, messageLogLabelProvider, messageLogTimestampFormatter, (i & 8) != 0 ? AnonymousClass1.INSTANCE : function0, (i & 16) != 0 ? AnonymousClass2.INSTANCE : function02);
    }

    public static /* synthetic */ List map$default(MessageLogEntryMapper messageLogEntryMapper, Conversation conversation, LocalDateTime localDateTime, TypingUser typingUser, LoadMoreStatus loadMoreStatus, int i, Object obj) {
        if ((i & 4) != 0) {
            typingUser = TypingUser.None.INSTANCE;
        }
        if ((i & 8) != 0) {
            loadMoreStatus = LoadMoreStatus.NONE;
        }
        return messageLogEntryMapper.map(conversation, localDateTime, typingUser, loadMoreStatus);
    }

    public final List<MessageLogEntry> map(Conversation conversation, LocalDateTime localDateTime, TypingUser typingUser, LoadMoreStatus loadMoreStatus) {
        Pair pair;
        String str;
        Conversation conversation2 = conversation;
        TypingUser typingUser2 = typingUser;
        LoadMoreStatus loadMoreStatus2 = loadMoreStatus;
        Intrinsics.checkNotNullParameter(conversation2, "conversation");
        Intrinsics.checkNotNullParameter(typingUser2, "typingUser");
        Intrinsics.checkNotNullParameter(loadMoreStatus2, "loadMoreStatus");
        List<MessageLogEntry> arrayList = new ArrayList<>();
        Collection arrayList2 = new ArrayList();
        Iterator it = conversation.getMessages().iterator();
        while (true) {
            String str2 = null;
            if (!it.hasNext()) {
                break;
            }
            MessageContent content = ((Message) it.next()).getContent();
            MessageContent.FormResponse formResponse = content instanceof MessageContent.FormResponse ? (MessageContent.FormResponse) content : null;
            if (formResponse != null) {
                str2 = formResponse.getQuotedMessageId();
            }
            if (str2 != null) {
                arrayList2.add(str2);
            }
        }
        List list = (List) arrayList2;
        Collection arrayList3 = new ArrayList();
        Iterator it2 = conversation.getMessages().iterator();
        while (true) {
            boolean z = false;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            Message message = (Message) next;
            if (message.getContent().getType() == MessageType.FORM && list.contains(message.getId())) {
                z = true;
            }
            if (!z) {
                arrayList3.add(next);
            }
        }
        Iterable<Message> iterable = (List) arrayList3;
        Collection arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Message access$overrideWithQuotedMessageDetails : iterable) {
            arrayList4.add(MessageLogEntryMapperKt.overrideWithQuotedMessageDetails(access$overrideWithQuotedMessageDetails, new MessageLogEntryMapper$map$1$messagesToShow$2$1(conversation2)));
        }
        List sortedWith = CollectionsKt.sortedWith((List) arrayList4, new MessageLogEntryMapper$map$lambda6$$inlined$sortedBy$1());
        if (!sortedWith.isEmpty()) {
            if (loadMoreStatus2 != LoadMoreStatus.NONE) {
                arrayList.add(new MessageLogEntry.LoadMore((String) null, (String) null, loadMoreStatus, 3, (DefaultConstructorMarker) null));
            }
            Set linkedHashSet = new LinkedHashSet();
            if (localDateTime != null) {
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                for (Object next2 : sortedWith) {
                    if (((Message) next2).getTimestamp().compareTo(localDateTime) < 0) {
                        arrayList5.add(next2);
                    } else {
                        arrayList6.add(next2);
                    }
                }
                pair = new Pair(arrayList5, arrayList6);
            } else {
                pair = new Pair(sortedWith, CollectionsKt.emptyList());
            }
            List list2 = (List) pair.component1();
            List list3 = (List) pair.component2();
            mapIntoMessageLogEntry$default(this, list2, conversation.getMyself(), (Message) null, (Message) (list3.isEmpty() ? CollectionsKt.last(list2) : CollectionsKt.last(list3)), linkedHashSet, arrayList, 2, (Object) null);
            if (!list3.isEmpty()) {
                if (!((Message) CollectionsKt.first(list3)).isAuthoredBy(conversation.getMyself())) {
                    if (localDateTime == null || (str = localDateTime.toString()) == null) {
                        str = this.idProvider.invoke();
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "newMessageDividerDate?.toString() ?: idProvider()");
                    arrayList.add(new MessageLogEntry.MessagesDivider(str, this.labelProvider.newMessages(), MessageLogType.NewMessagesDivider));
                }
                mapIntoMessageLogEntry(list3, conversation.getMyself(), (Message) CollectionsKt.lastOrNull(list2), (Message) CollectionsKt.last(list3), linkedHashSet, arrayList);
            }
            if (typingUser2 instanceof TypingUser.User) {
                arrayList.add(new MessageLogEntry.TypingIndicator((String) null, ((TypingUser.User) typingUser2).getAvatarUrl(), 1, (DefaultConstructorMarker) null));
            }
        }
        return arrayList;
    }

    static /* synthetic */ void mapIntoMessageLogEntry$default(MessageLogEntryMapper messageLogEntryMapper, List list, Participant participant, Message message, Message message2, Set set, List list2, int i, Object obj) {
        if ((i & 2) != 0) {
            message = null;
        }
        messageLogEntryMapper.mapIntoMessageLogEntry(list, participant, message, message2, set, list2);
    }

    private final void mapIntoMessageLogEntry(List<Message> list, Participant participant, Message message, Message message2, Set<LocalDateTime> set, List<MessageLogEntry> list2) {
        MessageDirection messageDirection;
        List<Message> list3 = list;
        List<MessageLogEntry> list4 = list2;
        int i = 0;
        for (Object next : list3) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Message message3 = (Message) next;
            Message message4 = (Message) CollectionsKt.getOrNull(list3, i - 1);
            MessageNeighbour compareWithPrevious = compareWithPrevious(message3, message4);
            MessageNeighbour compareWithNext = compareWithNext(message3, (Message) CollectionsKt.getOrNull(list3, i2));
            if (message3.isAuthoredBy(participant)) {
                messageDirection = MessageDirection.OUTBOUND;
            } else {
                messageDirection = MessageDirection.INBOUND;
            }
            MessagePosition position = getPosition(compareWithPrevious, compareWithNext);
            MessageShape shape = getShape(message3, position, compareWithPrevious, compareWithNext);
            if (message4 == null) {
                message4 = message;
            }
            handleTimestampDivider(list4, message3, message4, set);
            list4.addAll(this.messageContainerFactory.createMessageContainer(message3, messageDirection, position, shape, Intrinsics.areEqual((Object) message2, (Object) message3), shouldAnimationOccur(message3)));
            i = i2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper.MessageNeighbour compareWithPrevious(zendesk.conversationkit.android.model.Message r10, zendesk.conversationkit.android.model.Message r11) {
        /*
            r9 = this;
            zendesk.conversationkit.android.model.MessageStatus r0 = r10.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r1 = zendesk.conversationkit.android.model.MessageStatus.PENDING
            r2 = 0
            if (r0 == r1) goto L_0x0027
            if (r11 == 0) goto L_0x0010
            zendesk.conversationkit.android.model.MessageStatus r0 = r11.getStatus()
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            zendesk.conversationkit.android.model.MessageStatus r1 = zendesk.conversationkit.android.model.MessageStatus.PENDING
            if (r0 != r1) goto L_0x0016
            goto L_0x0027
        L_0x0016:
            zendesk.conversationkit.android.model.Author r0 = r10.getAuthor()
            if (r11 == 0) goto L_0x0021
            zendesk.conversationkit.android.model.Author r1 = r11.getAuthor()
            goto L_0x0022
        L_0x0021:
            r1 = r2
        L_0x0022:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            goto L_0x0041
        L_0x0027:
            zendesk.conversationkit.android.model.Author r0 = r10.getAuthor()
            java.lang.String r0 = r0.getUserId()
            if (r11 == 0) goto L_0x003c
            zendesk.conversationkit.android.model.Author r1 = r11.getAuthor()
            if (r1 == 0) goto L_0x003c
            java.lang.String r1 = r1.getUserId()
            goto L_0x003d
        L_0x003c:
            r1 = r2
        L_0x003d:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
        L_0x0041:
            r1 = 1
            r3 = 0
            if (r11 != 0) goto L_0x0047
        L_0x0045:
            r4 = r3
            goto L_0x0068
        L_0x0047:
            zendesk.conversationkit.android.model.MessageStatus r4 = r10.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r5 = zendesk.conversationkit.android.model.MessageStatus.PENDING
            if (r4 == r5) goto L_0x0057
            zendesk.conversationkit.android.model.MessageStatus r4 = r10.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r5 = zendesk.conversationkit.android.model.MessageStatus.SENT
            if (r4 != r5) goto L_0x0045
        L_0x0057:
            zendesk.conversationkit.android.model.MessageStatus r4 = r11.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r5 = zendesk.conversationkit.android.model.MessageStatus.PENDING
            if (r4 == r5) goto L_0x0067
            zendesk.conversationkit.android.model.MessageStatus r4 = r11.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r5 = zendesk.conversationkit.android.model.MessageStatus.SENT
            if (r4 != r5) goto L_0x0045
        L_0x0067:
            r4 = r1
        L_0x0068:
            if (r11 != 0) goto L_0x006c
        L_0x006a:
            r1 = r3
            goto L_0x0084
        L_0x006c:
            java.time.LocalDateTime r10 = r10.getTimestamp()
            long r5 = zendesk.core.android.internal.DateKtxKt.toTimestamp$default(r10, r2, r1, r2)
            java.time.LocalDateTime r10 = r11.getTimestamp()
            long r7 = zendesk.core.android.internal.DateKtxKt.toTimestamp$default(r10, r2, r1, r2)
            long r5 = r5 - r7
            r7 = 900000(0xdbba0, double:4.44659E-318)
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 >= 0) goto L_0x006a
        L_0x0084:
            zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper$MessageNeighbour r10 = new zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper$MessageNeighbour
            java.util.List<zendesk.conversationkit.android.model.MessageType> r3 = r9.allowedGroupingTypes
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            if (r11 == 0) goto L_0x0096
            zendesk.conversationkit.android.model.MessageContent r11 = r11.getContent()
            if (r11 == 0) goto L_0x0096
            zendesk.conversationkit.android.model.MessageType r2 = r11.getType()
        L_0x0096:
            boolean r11 = kotlin.collections.CollectionsKt.contains(r3, r2)
            r10.<init>(r0, r4, r1, r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper.compareWithPrevious(zendesk.conversationkit.android.model.Message, zendesk.conversationkit.android.model.Message):zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper$MessageNeighbour");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper.MessageNeighbour compareWithNext(zendesk.conversationkit.android.model.Message r10, zendesk.conversationkit.android.model.Message r11) {
        /*
            r9 = this;
            zendesk.conversationkit.android.model.MessageStatus r0 = r10.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r1 = zendesk.conversationkit.android.model.MessageStatus.PENDING
            r2 = 0
            if (r0 == r1) goto L_0x0027
            if (r11 == 0) goto L_0x0010
            zendesk.conversationkit.android.model.MessageStatus r0 = r11.getStatus()
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            zendesk.conversationkit.android.model.MessageStatus r1 = zendesk.conversationkit.android.model.MessageStatus.PENDING
            if (r0 != r1) goto L_0x0016
            goto L_0x0027
        L_0x0016:
            zendesk.conversationkit.android.model.Author r0 = r10.getAuthor()
            if (r11 == 0) goto L_0x0021
            zendesk.conversationkit.android.model.Author r1 = r11.getAuthor()
            goto L_0x0022
        L_0x0021:
            r1 = r2
        L_0x0022:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            goto L_0x0041
        L_0x0027:
            zendesk.conversationkit.android.model.Author r0 = r10.getAuthor()
            java.lang.String r0 = r0.getUserId()
            if (r11 == 0) goto L_0x003c
            zendesk.conversationkit.android.model.Author r1 = r11.getAuthor()
            if (r1 == 0) goto L_0x003c
            java.lang.String r1 = r1.getUserId()
            goto L_0x003d
        L_0x003c:
            r1 = r2
        L_0x003d:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
        L_0x0041:
            r1 = 1
            r3 = 0
            if (r11 != 0) goto L_0x0047
        L_0x0045:
            r4 = r3
            goto L_0x0068
        L_0x0047:
            zendesk.conversationkit.android.model.MessageStatus r4 = r10.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r5 = zendesk.conversationkit.android.model.MessageStatus.PENDING
            if (r4 == r5) goto L_0x0057
            zendesk.conversationkit.android.model.MessageStatus r4 = r10.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r5 = zendesk.conversationkit.android.model.MessageStatus.SENT
            if (r4 != r5) goto L_0x0045
        L_0x0057:
            zendesk.conversationkit.android.model.MessageStatus r4 = r11.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r5 = zendesk.conversationkit.android.model.MessageStatus.PENDING
            if (r4 == r5) goto L_0x0067
            zendesk.conversationkit.android.model.MessageStatus r4 = r11.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r5 = zendesk.conversationkit.android.model.MessageStatus.SENT
            if (r4 != r5) goto L_0x0045
        L_0x0067:
            r4 = r1
        L_0x0068:
            if (r11 != 0) goto L_0x006c
        L_0x006a:
            r1 = r3
            goto L_0x0084
        L_0x006c:
            java.time.LocalDateTime r5 = r11.getTimestamp()
            long r5 = zendesk.core.android.internal.DateKtxKt.toTimestamp$default(r5, r2, r1, r2)
            java.time.LocalDateTime r10 = r10.getTimestamp()
            long r7 = zendesk.core.android.internal.DateKtxKt.toTimestamp$default(r10, r2, r1, r2)
            long r5 = r5 - r7
            r7 = 900000(0xdbba0, double:4.44659E-318)
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 >= 0) goto L_0x006a
        L_0x0084:
            zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper$MessageNeighbour r10 = new zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper$MessageNeighbour
            java.util.List<zendesk.conversationkit.android.model.MessageType> r3 = r9.allowedGroupingTypes
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            if (r11 == 0) goto L_0x0096
            zendesk.conversationkit.android.model.MessageContent r11 = r11.getContent()
            if (r11 == 0) goto L_0x0096
            zendesk.conversationkit.android.model.MessageType r2 = r11.getType()
        L_0x0096:
            boolean r11 = kotlin.collections.CollectionsKt.contains(r3, r2)
            r10.<init>(r0, r4, r1, r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper.compareWithNext(zendesk.conversationkit.android.model.Message, zendesk.conversationkit.android.model.Message):zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper$MessageNeighbour");
    }

    private final void handleTimestampDivider(List<MessageLogEntry> list, Message message, Message message2, Set<LocalDateTime> set) {
        boolean z;
        MessageLogEntry.MessagesDivider messagesDivider;
        boolean z2;
        LocalDateTime timestamp = message.getTimestamp();
        LocalDateTime invoke = this.currentTimeProvider.invoke();
        invoke.getYear();
        boolean z3 = false;
        boolean z4 = (invoke.getYear() == timestamp.getYear() && invoke.getDayOfYear() == timestamp.getDayOfYear()) ? false : true;
        Iterable iterable = set;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                LocalDateTime localDateTime = (LocalDateTime) it.next();
                if (localDateTime.getYear() == timestamp.getYear() && localDateTime.getDayOfYear() == timestamp.getDayOfYear()) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (message2 == null || DateKtxKt.toTimestamp$default(message.getTimestamp(), (ZoneId) null, 1, (Object) null) - DateKtxKt.toTimestamp$default(message2.getTimestamp(), (ZoneId) null, 1, (Object) null) >= 900000) {
            z3 = true;
        }
        if (z4 && !z) {
            set.add(message.getTimestamp());
            messagesDivider = new MessageLogEntry.MessagesDivider(this.idProvider.invoke(), this.timestampFormatter.dayAndTime(message.getTimestamp()), MessageLogType.TimeStampDivider);
        } else if (z4 && z3) {
            messagesDivider = new MessageLogEntry.MessagesDivider(this.idProvider.invoke(), this.timestampFormatter.dayAndTime(message.getTimestamp()), MessageLogType.TimeStampDivider);
        } else if (z3) {
            messagesDivider = new MessageLogEntry.MessagesDivider(this.idProvider.invoke(), this.timestampFormatter.timeOnly(message.getTimestamp()), MessageLogType.TimeStampDivider);
        } else {
            return;
        }
        list.add(messagesDivider);
    }

    private final MessagePosition getPosition(MessageNeighbour messageNeighbour, MessageNeighbour messageNeighbour2) {
        if (!messageNeighbour.getAllowsPositionGrouping() && !messageNeighbour2.getAllowsPositionGrouping()) {
            return MessagePosition.STANDALONE;
        }
        if (!messageNeighbour.getAllowsPositionGrouping() && messageNeighbour2.getAllowsPositionGrouping()) {
            return MessagePosition.GROUP_TOP;
        }
        if (!messageNeighbour.getAllowsPositionGrouping() || messageNeighbour2.getAllowsPositionGrouping()) {
            return MessagePosition.GROUP_MIDDLE;
        }
        return MessagePosition.GROUP_BOTTOM;
    }

    private final MessageShape getShape(Message message, MessagePosition messagePosition, MessageNeighbour messageNeighbour, MessageNeighbour messageNeighbour2) {
        boolean z = false;
        boolean z2 = messagePosition == MessagePosition.STANDALONE || !this.allowedGroupingTypes.contains(message.getContent().getType()) || (messagePosition == MessagePosition.GROUP_TOP && !messageNeighbour2.getAllowsShapeGrouping()) || (messagePosition == MessagePosition.GROUP_BOTTOM && !messageNeighbour.getAllowsShapeGrouping());
        boolean z3 = (messagePosition == MessagePosition.GROUP_TOP && messageNeighbour2.getAllowsShapeGrouping()) || (messagePosition == MessagePosition.GROUP_MIDDLE && !messageNeighbour.getAllowsShapeGrouping());
        if ((messagePosition == MessagePosition.GROUP_BOTTOM && messageNeighbour.getAllowsShapeGrouping()) || (messagePosition == MessagePosition.GROUP_MIDDLE && !messageNeighbour2.getAllowsShapeGrouping())) {
            z = true;
        }
        if (z2) {
            return MessageShape.STANDALONE;
        }
        if (z3) {
            return MessageShape.GROUP_TOP;
        }
        if (z) {
            return MessageShape.GROUP_BOTTOM;
        }
        return MessageShape.GROUP_MIDDLE;
    }

    private final boolean shouldAnimationOccur(Message message) {
        boolean z = DateKtxKt.toTimestamp$default(this.currentTimeProvider.invoke(), (ZoneId) null, 1, (Object) null) - DateKtxKt.toTimestamp$default(message.getTimestamp(), (ZoneId) null, 1, (Object) null) <= 3000;
        if (message.getStatus() == MessageStatus.FAILED || !z) {
            return false;
        }
        return true;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/MessageLogEntryMapper$MessageNeighbour;", "", "sameAuthor", "", "statusAllowGrouping", "dateAllowsGrouping", "allowsShapeGrouping", "(ZZZZ)V", "allowsPositionGrouping", "getAllowsPositionGrouping", "()Z", "getAllowsShapeGrouping", "getDateAllowsGrouping", "getSameAuthor", "getStatusAllowGrouping", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLogEntryMapper.kt */
    private static final class MessageNeighbour {
        private final boolean allowsShapeGrouping;
        private final boolean dateAllowsGrouping;
        private final boolean sameAuthor;
        private final boolean statusAllowGrouping;

        public static /* synthetic */ MessageNeighbour copy$default(MessageNeighbour messageNeighbour, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z = messageNeighbour.sameAuthor;
            }
            if ((i & 2) != 0) {
                z2 = messageNeighbour.statusAllowGrouping;
            }
            if ((i & 4) != 0) {
                z3 = messageNeighbour.dateAllowsGrouping;
            }
            if ((i & 8) != 0) {
                z4 = messageNeighbour.allowsShapeGrouping;
            }
            return messageNeighbour.copy(z, z2, z3, z4);
        }

        public final boolean component1() {
            return this.sameAuthor;
        }

        public final boolean component2() {
            return this.statusAllowGrouping;
        }

        public final boolean component3() {
            return this.dateAllowsGrouping;
        }

        public final boolean component4() {
            return this.allowsShapeGrouping;
        }

        public final MessageNeighbour copy(boolean z, boolean z2, boolean z3, boolean z4) {
            return new MessageNeighbour(z, z2, z3, z4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MessageNeighbour)) {
                return false;
            }
            MessageNeighbour messageNeighbour = (MessageNeighbour) obj;
            return this.sameAuthor == messageNeighbour.sameAuthor && this.statusAllowGrouping == messageNeighbour.statusAllowGrouping && this.dateAllowsGrouping == messageNeighbour.dateAllowsGrouping && this.allowsShapeGrouping == messageNeighbour.allowsShapeGrouping;
        }

        public int hashCode() {
            boolean z = this.sameAuthor;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i = (z ? 1 : 0) * true;
            boolean z3 = this.statusAllowGrouping;
            if (z3) {
                z3 = true;
            }
            int i2 = (i + (z3 ? 1 : 0)) * 31;
            boolean z4 = this.dateAllowsGrouping;
            if (z4) {
                z4 = true;
            }
            int i3 = (i2 + (z4 ? 1 : 0)) * 31;
            boolean z5 = this.allowsShapeGrouping;
            if (!z5) {
                z2 = z5;
            }
            return i3 + (z2 ? 1 : 0);
        }

        public String toString() {
            return "MessageNeighbour(sameAuthor=" + this.sameAuthor + ", statusAllowGrouping=" + this.statusAllowGrouping + ", dateAllowsGrouping=" + this.dateAllowsGrouping + ", allowsShapeGrouping=" + this.allowsShapeGrouping + ')';
        }

        public MessageNeighbour(boolean z, boolean z2, boolean z3, boolean z4) {
            this.sameAuthor = z;
            this.statusAllowGrouping = z2;
            this.dateAllowsGrouping = z3;
            this.allowsShapeGrouping = z4;
        }

        public final boolean getSameAuthor() {
            return this.sameAuthor;
        }

        public final boolean getStatusAllowGrouping() {
            return this.statusAllowGrouping;
        }

        public final boolean getDateAllowsGrouping() {
            return this.dateAllowsGrouping;
        }

        public final boolean getAllowsShapeGrouping() {
            return this.allowsShapeGrouping;
        }

        public final boolean getAllowsPositionGrouping() {
            return this.sameAuthor && this.statusAllowGrouping && this.dateAllowsGrouping;
        }
    }
}
