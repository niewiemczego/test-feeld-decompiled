package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000b¢\u0006\u0002\u0010\u0013J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0001\u0010.\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001eR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001f\u0010\u0015R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001a¨\u00065"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ConversationDto;", "", "id", "", "displayName", "description", "iconUrl", "type", "isDefault", "", "appMakers", "", "appMakerLastRead", "", "lastUpdatedAt", "participants", "Lzendesk/conversationkit/android/internal/rest/model/ParticipantDto;", "messages", "Lzendesk/conversationkit/android/internal/rest/model/MessageDto;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;)V", "getAppMakerLastRead", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAppMakers", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "getDisplayName", "getIconUrl", "getId", "()Z", "getLastUpdatedAt", "getMessages", "getParticipants", "getType", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;)Lzendesk/conversationkit/android/internal/rest/model/ConversationDto;", "equals", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationDto.kt */
public final class ConversationDto {
    private final Double appMakerLastRead;
    private final List<String> appMakers;
    private final String description;
    private final String displayName;
    private final String iconUrl;
    private final String id;
    private final boolean isDefault;
    private final Double lastUpdatedAt;
    private final List<MessageDto> messages;
    private final List<ParticipantDto> participants;
    private final String type;

    public static /* synthetic */ ConversationDto copy$default(ConversationDto conversationDto, String str, String str2, String str3, String str4, String str5, boolean z, List list, Double d, Double d2, List list2, List list3, int i, Object obj) {
        ConversationDto conversationDto2 = conversationDto;
        int i2 = i;
        return conversationDto.copy((i2 & 1) != 0 ? conversationDto2.id : str, (i2 & 2) != 0 ? conversationDto2.displayName : str2, (i2 & 4) != 0 ? conversationDto2.description : str3, (i2 & 8) != 0 ? conversationDto2.iconUrl : str4, (i2 & 16) != 0 ? conversationDto2.type : str5, (i2 & 32) != 0 ? conversationDto2.isDefault : z, (i2 & 64) != 0 ? conversationDto2.appMakers : list, (i2 & 128) != 0 ? conversationDto2.appMakerLastRead : d, (i2 & 256) != 0 ? conversationDto2.lastUpdatedAt : d2, (i2 & 512) != 0 ? conversationDto2.participants : list2, (i2 & 1024) != 0 ? conversationDto2.messages : list3);
    }

    public final String component1() {
        return this.id;
    }

    public final List<ParticipantDto> component10() {
        return this.participants;
    }

    public final List<MessageDto> component11() {
        return this.messages;
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

    public final String component5() {
        return this.type;
    }

    public final boolean component6() {
        return this.isDefault;
    }

    public final List<String> component7() {
        return this.appMakers;
    }

    public final Double component8() {
        return this.appMakerLastRead;
    }

    public final Double component9() {
        return this.lastUpdatedAt;
    }

    public final ConversationDto copy(@Json(name = "_id") String str, String str2, String str3, String str4, String str5, boolean z, List<String> list, Double d, Double d2, List<ParticipantDto> list2, List<MessageDto> list3) {
        Intrinsics.checkNotNullParameter(str, "id");
        String str6 = str5;
        Intrinsics.checkNotNullParameter(str6, "type");
        return new ConversationDto(str, str2, str3, str4, str6, z, list, d, d2, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConversationDto)) {
            return false;
        }
        ConversationDto conversationDto = (ConversationDto) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) conversationDto.id) && Intrinsics.areEqual((Object) this.displayName, (Object) conversationDto.displayName) && Intrinsics.areEqual((Object) this.description, (Object) conversationDto.description) && Intrinsics.areEqual((Object) this.iconUrl, (Object) conversationDto.iconUrl) && Intrinsics.areEqual((Object) this.type, (Object) conversationDto.type) && this.isDefault == conversationDto.isDefault && Intrinsics.areEqual((Object) this.appMakers, (Object) conversationDto.appMakers) && Intrinsics.areEqual((Object) this.appMakerLastRead, (Object) conversationDto.appMakerLastRead) && Intrinsics.areEqual((Object) this.lastUpdatedAt, (Object) conversationDto.lastUpdatedAt) && Intrinsics.areEqual((Object) this.participants, (Object) conversationDto.participants) && Intrinsics.areEqual((Object) this.messages, (Object) conversationDto.messages);
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
        if (z) {
            z = true;
        }
        int i2 = (hashCode4 + (z ? 1 : 0)) * 31;
        List<String> list = this.appMakers;
        int hashCode5 = (i2 + (list == null ? 0 : list.hashCode())) * 31;
        Double d = this.appMakerLastRead;
        int hashCode6 = (hashCode5 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.lastUpdatedAt;
        int hashCode7 = (hashCode6 + (d2 == null ? 0 : d2.hashCode())) * 31;
        List<ParticipantDto> list2 = this.participants;
        int hashCode8 = (hashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MessageDto> list3 = this.messages;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConversationDto(id=").append(this.id).append(", displayName=").append(this.displayName).append(", description=").append(this.description).append(", iconUrl=").append(this.iconUrl).append(", type=").append(this.type).append(", isDefault=").append(this.isDefault).append(", appMakers=").append(this.appMakers).append(", appMakerLastRead=").append(this.appMakerLastRead).append(", lastUpdatedAt=").append(this.lastUpdatedAt).append(", participants=").append(this.participants).append(", messages=").append(this.messages).append(')');
        return sb.toString();
    }

    public ConversationDto(@Json(name = "_id") String str, String str2, String str3, String str4, String str5, boolean z, List<String> list, Double d, Double d2, List<ParticipantDto> list2, List<MessageDto> list3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str5, "type");
        this.id = str;
        this.displayName = str2;
        this.description = str3;
        this.iconUrl = str4;
        this.type = str5;
        this.isDefault = z;
        this.appMakers = list;
        this.appMakerLastRead = d;
        this.lastUpdatedAt = d2;
        this.participants = list2;
        this.messages = list3;
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

    public final String getType() {
        return this.type;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final List<String> getAppMakers() {
        return this.appMakers;
    }

    public final Double getAppMakerLastRead() {
        return this.appMakerLastRead;
    }

    public final Double getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public final List<ParticipantDto> getParticipants() {
        return this.participants;
    }

    public final List<MessageDto> getMessages() {
        return this.messages;
    }
}
