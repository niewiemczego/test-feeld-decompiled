package zendesk.conversationkit.android.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.AppUserDto;
import zendesk.conversationkit.android.internal.rest.model.ConversationDto;
import zendesk.conversationkit.android.internal.rest.model.ConversationResponseDto;
import zendesk.conversationkit.android.internal.rest.model.MessageDto;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000\u001aD\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0000\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u000f"}, d2 = {"enrichFormResponseFields", "Lzendesk/conversationkit/android/model/Conversation;", "toConversation", "Lzendesk/conversationkit/android/internal/rest/model/ConversationDto;", "currentUserId", "", "appUsers", "", "Lzendesk/conversationkit/android/internal/rest/model/AppUserDto;", "altMessages", "", "Lzendesk/conversationkit/android/internal/rest/model/MessageDto;", "hasPrevious", "", "Lzendesk/conversationkit/android/internal/rest/model/ConversationResponseDto;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Conversation.kt */
public final class ConversationKt {
    public static final Conversation toConversation(ConversationResponseDto conversationResponseDto, String str) {
        Intrinsics.checkNotNullParameter(conversationResponseDto, "<this>");
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        ConversationDto conversation = conversationResponseDto.getConversation();
        Map<String, AppUserDto> plus = MapsKt.plus(conversationResponseDto.getAppUsers(), TuplesKt.to(conversationResponseDto.getAppUser().getId(), conversationResponseDto.getAppUser()));
        List<MessageDto> messages = conversationResponseDto.getMessages();
        Boolean hasPrevious = conversationResponseDto.getHasPrevious();
        return toConversation(conversation, str, plus, messages, hasPrevious != null ? hasPrevious.booleanValue() : false);
    }

    public static /* synthetic */ Conversation toConversation$default(ConversationDto conversationDto, String str, Map map, List<MessageDto> list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            list = conversationDto.getMessages();
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return toConversation(conversationDto, str, map, list, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a7 A[LOOP:1: B:23:0x00a1->B:25:0x00a7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final zendesk.conversationkit.android.model.Conversation toConversation(zendesk.conversationkit.android.internal.rest.model.ConversationDto r17, java.lang.String r18, java.util.Map<java.lang.String, zendesk.conversationkit.android.internal.rest.model.AppUserDto> r19, java.util.List<zendesk.conversationkit.android.internal.rest.model.MessageDto> r20, boolean r21) {
        /*
            r0 = r18
            java.lang.String r1 = "<this>"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "currentUserId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "appUsers"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.lang.String r3 = r17.getId()
            java.lang.String r4 = r17.getDisplayName()
            java.lang.String r5 = r17.getDescription()
            java.lang.String r6 = r17.getIconUrl()
            java.lang.String r1 = r17.getType()
            java.lang.String r7 = "personal"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r7)
            if (r1 == 0) goto L_0x0034
            zendesk.conversationkit.android.model.ConversationType r1 = zendesk.conversationkit.android.model.ConversationType.PERSONAL
            goto L_0x0036
        L_0x0034:
            zendesk.conversationkit.android.model.ConversationType r1 = zendesk.conversationkit.android.model.ConversationType.GROUP
        L_0x0036:
            r7 = r1
            boolean r8 = r17.isDefault()
            java.util.List r1 = r17.getAppMakers()
            if (r1 != 0) goto L_0x0045
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0045:
            r9 = r1
            java.lang.Double r1 = r17.getAppMakerLastRead()
            r10 = 1
            r11 = 0
            java.time.LocalDateTime r10 = zendesk.core.android.internal.DateKtxKt.toLocalDateTime$default((java.lang.Double) r1, (java.time.ZoneId) r11, (int) r10, (java.lang.Object) r11)
            java.lang.Double r1 = r17.getLastUpdatedAt()
            java.util.List r12 = r17.getParticipants()
            if (r12 == 0) goto L_0x0083
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L_0x0060:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0078
            java.lang.Object r13 = r12.next()
            r14 = r13
            zendesk.conversationkit.android.internal.rest.model.ParticipantDto r14 = (zendesk.conversationkit.android.internal.rest.model.ParticipantDto) r14
            java.lang.String r14 = r14.getAppUserId()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r0)
            if (r14 == 0) goto L_0x0060
            goto L_0x0079
        L_0x0078:
            r13 = r11
        L_0x0079:
            zendesk.conversationkit.android.internal.rest.model.ParticipantDto r13 = (zendesk.conversationkit.android.internal.rest.model.ParticipantDto) r13
            if (r13 == 0) goto L_0x0083
            zendesk.conversationkit.android.model.Participant r0 = zendesk.conversationkit.android.model.ParticipantKt.toParticipant(r13)
            r12 = r0
            goto L_0x0084
        L_0x0083:
            r12 = r11
        L_0x0084:
            java.util.List r0 = r17.getParticipants()
            if (r0 != 0) goto L_0x008e
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x008e:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r13 = 10
            int r14 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r13)
            r2.<init>(r14)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r0 = r0.iterator()
        L_0x00a1:
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x00b5
            java.lang.Object r14 = r0.next()
            zendesk.conversationkit.android.internal.rest.model.ParticipantDto r14 = (zendesk.conversationkit.android.internal.rest.model.ParticipantDto) r14
            zendesk.conversationkit.android.model.Participant r14 = zendesk.conversationkit.android.model.ParticipantKt.toParticipant(r14)
            r2.add(r14)
            goto L_0x00a1
        L_0x00b5:
            r0 = r2
            java.util.List r0 = (java.util.List) r0
            if (r20 == 0) goto L_0x00e5
            r2 = r20
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r14 = new java.util.ArrayList
            int r13 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r13)
            r14.<init>(r13)
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r2 = r2.iterator()
        L_0x00cd:
            boolean r13 = r2.hasNext()
            if (r13 == 0) goto L_0x00e2
            java.lang.Object r13 = r2.next()
            zendesk.conversationkit.android.internal.rest.model.MessageDto r13 = (zendesk.conversationkit.android.internal.rest.model.MessageDto) r13
            r15 = 3
            zendesk.conversationkit.android.model.Message r13 = zendesk.conversationkit.android.model.MessageKt.toMessage$default(r13, r11, r11, r15, r11)
            r14.add(r13)
            goto L_0x00cd
        L_0x00e2:
            java.util.List r14 = (java.util.List) r14
            goto L_0x00ea
        L_0x00e5:
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            r14 = r2
        L_0x00ea:
            zendesk.conversationkit.android.model.Conversation r16 = new zendesk.conversationkit.android.model.Conversation
            r2 = r16
            r11 = r1
            r13 = r0
            r15 = r21
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.model.ConversationKt.toConversation(zendesk.conversationkit.android.internal.rest.model.ConversationDto, java.lang.String, java.util.Map, java.util.List, boolean):zendesk.conversationkit.android.model.Conversation");
    }

    public static final Conversation enrichFormResponseFields(Conversation conversation) {
        Conversation conversation2 = conversation;
        Intrinsics.checkNotNullParameter(conversation2, "<this>");
        Iterable<Message> messages = conversation.getMessages();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(messages, 10));
        for (Message enrichFormResponseFields : messages) {
            arrayList.add(MessageKt.enrichFormResponseFields(enrichFormResponseFields, conversation2));
        }
        return Conversation.copy$default(conversation, (String) null, (String) null, (String) null, (String) null, (ConversationType) null, false, (List) null, (LocalDateTime) null, (Double) null, (Participant) null, (List) null, (List) arrayList, false, 6143, (Object) null);
    }
}
