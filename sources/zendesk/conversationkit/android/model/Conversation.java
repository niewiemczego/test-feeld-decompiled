package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonClass;
import java.time.LocalDateTime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\f\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\f\u0012\u0006\u0010\u0016\u001a\u00020\n¢\u0006\u0002\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00120\fHÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00150\fHÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010$J®\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\f2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\b\b\u0002\u0010\u0016\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\n2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0016\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010 R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006@"}, d2 = {"Lzendesk/conversationkit/android/model/Conversation;", "", "id", "", "displayName", "description", "iconUrl", "type", "Lzendesk/conversationkit/android/model/ConversationType;", "isDefault", "", "business", "", "businessLastRead", "Ljava/time/LocalDateTime;", "lastUpdatedAt", "", "myself", "Lzendesk/conversationkit/android/model/Participant;", "participants", "messages", "Lzendesk/conversationkit/android/model/Message;", "hasPrevious", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/model/ConversationType;ZLjava/util/List;Ljava/time/LocalDateTime;Ljava/lang/Double;Lzendesk/conversationkit/android/model/Participant;Ljava/util/List;Ljava/util/List;Z)V", "getBusiness", "()Ljava/util/List;", "getBusinessLastRead", "()Ljava/time/LocalDateTime;", "getDescription", "()Ljava/lang/String;", "getDisplayName", "getHasPrevious", "()Z", "getIconUrl", "getId", "getLastUpdatedAt", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMessages", "getMyself", "()Lzendesk/conversationkit/android/model/Participant;", "getParticipants", "getType", "()Lzendesk/conversationkit/android/model/ConversationType;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/model/ConversationType;ZLjava/util/List;Ljava/time/LocalDateTime;Ljava/lang/Double;Lzendesk/conversationkit/android/model/Participant;Ljava/util/List;Ljava/util/List;Z)Lzendesk/conversationkit/android/model/Conversation;", "equals", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Conversation.kt */
public final class Conversation {
    private final List<String> business;
    private final LocalDateTime businessLastRead;
    private final String description;
    private final String displayName;
    private final boolean hasPrevious;
    private final String iconUrl;
    private final String id;
    private final boolean isDefault;
    private final Double lastUpdatedAt;
    private final List<Message> messages;
    private final Participant myself;
    private final List<Participant> participants;
    private final ConversationType type;

    public static /* synthetic */ Conversation copy$default(Conversation conversation, String str, String str2, String str3, String str4, ConversationType conversationType, boolean z, List list, LocalDateTime localDateTime, Double d, Participant participant, List list2, List list3, boolean z2, int i, Object obj) {
        Conversation conversation2 = conversation;
        int i2 = i;
        return conversation.copy((i2 & 1) != 0 ? conversation2.id : str, (i2 & 2) != 0 ? conversation2.displayName : str2, (i2 & 4) != 0 ? conversation2.description : str3, (i2 & 8) != 0 ? conversation2.iconUrl : str4, (i2 & 16) != 0 ? conversation2.type : conversationType, (i2 & 32) != 0 ? conversation2.isDefault : z, (i2 & 64) != 0 ? conversation2.business : list, (i2 & 128) != 0 ? conversation2.businessLastRead : localDateTime, (i2 & 256) != 0 ? conversation2.lastUpdatedAt : d, (i2 & 512) != 0 ? conversation2.myself : participant, (i2 & 1024) != 0 ? conversation2.participants : list2, (i2 & 2048) != 0 ? conversation2.messages : list3, (i2 & 4096) != 0 ? conversation2.hasPrevious : z2);
    }

    public final String component1() {
        return this.id;
    }

    public final Participant component10() {
        return this.myself;
    }

    public final List<Participant> component11() {
        return this.participants;
    }

    public final List<Message> component12() {
        return this.messages;
    }

    public final boolean component13() {
        return this.hasPrevious;
    }

    public final String component2() {
        return this.displayName;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.iconUrl;
    }

    public final ConversationType component5() {
        return this.type;
    }

    public final boolean component6() {
        return this.isDefault;
    }

    public final List<String> component7() {
        return this.business;
    }

    public final LocalDateTime component8() {
        return this.businessLastRead;
    }

    public final Double component9() {
        return this.lastUpdatedAt;
    }

    public final Conversation copy(String str, String str2, String str3, String str4, ConversationType conversationType, boolean z, List<String> list, LocalDateTime localDateTime, Double d, Participant participant, List<Participant> list2, List<Message> list3, boolean z2) {
        String str5 = str;
        Intrinsics.checkNotNullParameter(str5, "id");
        ConversationType conversationType2 = conversationType;
        Intrinsics.checkNotNullParameter(conversationType2, "type");
        List<String> list4 = list;
        Intrinsics.checkNotNullParameter(list4, "business");
        List<Participant> list5 = list2;
        Intrinsics.checkNotNullParameter(list5, "participants");
        List<Message> list6 = list3;
        Intrinsics.checkNotNullParameter(list6, "messages");
        return new Conversation(str5, str2, str3, str4, conversationType2, z, list4, localDateTime, d, participant, list5, list6, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Conversation)) {
            return false;
        }
        Conversation conversation = (Conversation) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) conversation.id) && Intrinsics.areEqual((Object) this.displayName, (Object) conversation.displayName) && Intrinsics.areEqual((Object) this.description, (Object) conversation.description) && Intrinsics.areEqual((Object) this.iconUrl, (Object) conversation.iconUrl) && this.type == conversation.type && this.isDefault == conversation.isDefault && Intrinsics.areEqual((Object) this.business, (Object) conversation.business) && Intrinsics.areEqual((Object) this.businessLastRead, (Object) conversation.businessLastRead) && Intrinsics.areEqual((Object) this.lastUpdatedAt, (Object) conversation.lastUpdatedAt) && Intrinsics.areEqual((Object) this.myself, (Object) conversation.myself) && Intrinsics.areEqual((Object) this.participants, (Object) conversation.participants) && Intrinsics.areEqual((Object) this.messages, (Object) conversation.messages) && this.hasPrevious == conversation.hasPrevious;
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        String str = this.displayName;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconUrl;
        int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.type.hashCode()) * 31;
        boolean z = this.isDefault;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode5 = (((hashCode4 + (z ? 1 : 0)) * 31) + this.business.hashCode()) * 31;
        LocalDateTime localDateTime = this.businessLastRead;
        int hashCode6 = (hashCode5 + (localDateTime == null ? 0 : localDateTime.hashCode())) * 31;
        Double d = this.lastUpdatedAt;
        int hashCode7 = (hashCode6 + (d == null ? 0 : d.hashCode())) * 31;
        Participant participant = this.myself;
        if (participant != null) {
            i = participant.hashCode();
        }
        int hashCode8 = (((((hashCode7 + i) * 31) + this.participants.hashCode()) * 31) + this.messages.hashCode()) * 31;
        boolean z3 = this.hasPrevious;
        if (!z3) {
            z2 = z3;
        }
        return hashCode8 + (z2 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Conversation(id=").append(this.id).append(", displayName=").append(this.displayName).append(", description=").append(this.description).append(", iconUrl=").append(this.iconUrl).append(", type=").append(this.type).append(", isDefault=").append(this.isDefault).append(", business=").append(this.business).append(", businessLastRead=").append(this.businessLastRead).append(", lastUpdatedAt=").append(this.lastUpdatedAt).append(", myself=").append(this.myself).append(", participants=").append(this.participants).append(", messages=");
        sb.append(this.messages).append(", hasPrevious=").append(this.hasPrevious).append(')');
        return sb.toString();
    }

    public Conversation(String str, String str2, String str3, String str4, ConversationType conversationType, boolean z, List<String> list, LocalDateTime localDateTime, Double d, Participant participant, List<Participant> list2, List<Message> list3, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(conversationType, "type");
        Intrinsics.checkNotNullParameter(list, "business");
        Intrinsics.checkNotNullParameter(list2, "participants");
        Intrinsics.checkNotNullParameter(list3, "messages");
        this.id = str;
        this.displayName = str2;
        this.description = str3;
        this.iconUrl = str4;
        this.type = conversationType;
        this.isDefault = z;
        this.business = list;
        this.businessLastRead = localDateTime;
        this.lastUpdatedAt = d;
        this.myself = participant;
        this.participants = list2;
        this.messages = list3;
        this.hasPrevious = z2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final ConversationType getType() {
        return this.type;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final List<String> getBusiness() {
        return this.business;
    }

    public final LocalDateTime getBusinessLastRead() {
        return this.businessLastRead;
    }

    public final Double getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public final Participant getMyself() {
        return this.myself;
    }

    public final List<Participant> getParticipants() {
        return this.participants;
    }

    public final List<Message> getMessages() {
        return this.messages;
    }

    public final boolean getHasPrevious() {
        return this.hasPrevious;
    }
}
