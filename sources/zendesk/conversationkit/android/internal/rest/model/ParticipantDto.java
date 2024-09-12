package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJ:\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ParticipantDto;", "", "id", "", "appUserId", "unreadCount", "", "lastRead", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;)V", "getAppUserId", "()Ljava/lang/String;", "getId", "getLastRead", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getUnreadCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;)Lzendesk/conversationkit/android/internal/rest/model/ParticipantDto;", "equals", "", "other", "hashCode", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ParticipantDto.kt */
public final class ParticipantDto {
    private final String appUserId;
    private final String id;
    private final Double lastRead;
    private final Integer unreadCount;

    public static /* synthetic */ ParticipantDto copy$default(ParticipantDto participantDto, String str, String str2, Integer num, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = participantDto.id;
        }
        if ((i & 2) != 0) {
            str2 = participantDto.appUserId;
        }
        if ((i & 4) != 0) {
            num = participantDto.unreadCount;
        }
        if ((i & 8) != 0) {
            d = participantDto.lastRead;
        }
        return participantDto.copy(str, str2, num, d);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.appUserId;
    }

    public final Integer component3() {
        return this.unreadCount;
    }

    public final Double component4() {
        return this.lastRead;
    }

    public final ParticipantDto copy(@Json(name = "_id") String str, String str2, Integer num, Double d) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "appUserId");
        return new ParticipantDto(str, str2, num, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParticipantDto)) {
            return false;
        }
        ParticipantDto participantDto = (ParticipantDto) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) participantDto.id) && Intrinsics.areEqual((Object) this.appUserId, (Object) participantDto.appUserId) && Intrinsics.areEqual((Object) this.unreadCount, (Object) participantDto.unreadCount) && Intrinsics.areEqual((Object) this.lastRead, (Object) participantDto.lastRead);
    }

    public int hashCode() {
        int hashCode = ((this.id.hashCode() * 31) + this.appUserId.hashCode()) * 31;
        Integer num = this.unreadCount;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Double d = this.lastRead;
        if (d != null) {
            i = d.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ParticipantDto(id=" + this.id + ", appUserId=" + this.appUserId + ", unreadCount=" + this.unreadCount + ", lastRead=" + this.lastRead + ')';
    }

    public ParticipantDto(@Json(name = "_id") String str, String str2, Integer num, Double d) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "appUserId");
        this.id = str;
        this.appUserId = str2;
        this.unreadCount = num;
        this.lastRead = d;
    }

    public final String getId() {
        return this.id;
    }

    public final String getAppUserId() {
        return this.appUserId;
    }

    public final Integer getUnreadCount() {
        return this.unreadCount;
    }

    public final Double getLastRead() {
        return this.lastRead;
    }
}
