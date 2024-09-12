package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonClass;
import java.time.LocalDateTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001b"}, d2 = {"Lzendesk/conversationkit/android/model/Participant;", "", "id", "", "userId", "unreadCount", "", "lastRead", "Ljava/time/LocalDateTime;", "(Ljava/lang/String;Ljava/lang/String;ILjava/time/LocalDateTime;)V", "getId", "()Ljava/lang/String;", "getLastRead", "()Ljava/time/LocalDateTime;", "getUnreadCount", "()I", "getUserId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Participant.kt */
public final class Participant {
    private final String id;
    private final LocalDateTime lastRead;
    private final int unreadCount;
    private final String userId;

    public static /* synthetic */ Participant copy$default(Participant participant, String str, String str2, int i, LocalDateTime localDateTime, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = participant.id;
        }
        if ((i2 & 2) != 0) {
            str2 = participant.userId;
        }
        if ((i2 & 4) != 0) {
            i = participant.unreadCount;
        }
        if ((i2 & 8) != 0) {
            localDateTime = participant.lastRead;
        }
        return participant.copy(str, str2, i, localDateTime);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.userId;
    }

    public final int component3() {
        return this.unreadCount;
    }

    public final LocalDateTime component4() {
        return this.lastRead;
    }

    public final Participant copy(String str, String str2, int i, LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "userId");
        return new Participant(str, str2, i, localDateTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Participant)) {
            return false;
        }
        Participant participant = (Participant) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) participant.id) && Intrinsics.areEqual((Object) this.userId, (Object) participant.userId) && this.unreadCount == participant.unreadCount && Intrinsics.areEqual((Object) this.lastRead, (Object) participant.lastRead);
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.userId.hashCode()) * 31) + Integer.hashCode(this.unreadCount)) * 31;
        LocalDateTime localDateTime = this.lastRead;
        return hashCode + (localDateTime == null ? 0 : localDateTime.hashCode());
    }

    public String toString() {
        return "Participant(id=" + this.id + ", userId=" + this.userId + ", unreadCount=" + this.unreadCount + ", lastRead=" + this.lastRead + ')';
    }

    public Participant(String str, String str2, int i, LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "userId");
        this.id = str;
        this.userId = str2;
        this.unreadCount = i;
        this.lastRead = localDateTime;
    }

    public final String getId() {
        return this.id;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public final LocalDateTime getLastRead() {
        return this.lastRead;
    }
}
