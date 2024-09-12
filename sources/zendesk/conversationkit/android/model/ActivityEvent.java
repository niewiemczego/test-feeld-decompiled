package zendesk.conversationkit.android.model;

import java.time.LocalDateTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003J[\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006'"}, d2 = {"Lzendesk/conversationkit/android/model/ActivityEvent;", "", "conversationId", "", "activityData", "Lzendesk/conversationkit/android/model/ActivityData;", "userId", "userName", "userAvatarUrl", "role", "Lzendesk/conversationkit/android/model/AuthorType;", "lastRead", "Ljava/time/LocalDateTime;", "(Ljava/lang/String;Lzendesk/conversationkit/android/model/ActivityData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/model/AuthorType;Ljava/time/LocalDateTime;)V", "getActivityData", "()Lzendesk/conversationkit/android/model/ActivityData;", "getConversationId", "()Ljava/lang/String;", "getLastRead", "()Ljava/time/LocalDateTime;", "getRole", "()Lzendesk/conversationkit/android/model/AuthorType;", "getUserAvatarUrl", "getUserId", "getUserName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActivityData.kt */
public final class ActivityEvent {
    private final ActivityData activityData;
    private final String conversationId;
    private final LocalDateTime lastRead;
    private final AuthorType role;
    private final String userAvatarUrl;
    private final String userId;
    private final String userName;

    public static /* synthetic */ ActivityEvent copy$default(ActivityEvent activityEvent, String str, ActivityData activityData2, String str2, String str3, String str4, AuthorType authorType, LocalDateTime localDateTime, int i, Object obj) {
        if ((i & 1) != 0) {
            str = activityEvent.conversationId;
        }
        if ((i & 2) != 0) {
            activityData2 = activityEvent.activityData;
        }
        ActivityData activityData3 = activityData2;
        if ((i & 4) != 0) {
            str2 = activityEvent.userId;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = activityEvent.userName;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = activityEvent.userAvatarUrl;
        }
        String str7 = str4;
        if ((i & 32) != 0) {
            authorType = activityEvent.role;
        }
        AuthorType authorType2 = authorType;
        if ((i & 64) != 0) {
            localDateTime = activityEvent.lastRead;
        }
        return activityEvent.copy(str, activityData3, str5, str6, str7, authorType2, localDateTime);
    }

    public final String component1() {
        return this.conversationId;
    }

    public final ActivityData component2() {
        return this.activityData;
    }

    public final String component3() {
        return this.userId;
    }

    public final String component4() {
        return this.userName;
    }

    public final String component5() {
        return this.userAvatarUrl;
    }

    public final AuthorType component6() {
        return this.role;
    }

    public final LocalDateTime component7() {
        return this.lastRead;
    }

    public final ActivityEvent copy(String str, ActivityData activityData2, String str2, String str3, String str4, AuthorType authorType, LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(str, "conversationId");
        return new ActivityEvent(str, activityData2, str2, str3, str4, authorType, localDateTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityEvent)) {
            return false;
        }
        ActivityEvent activityEvent = (ActivityEvent) obj;
        return Intrinsics.areEqual((Object) this.conversationId, (Object) activityEvent.conversationId) && this.activityData == activityEvent.activityData && Intrinsics.areEqual((Object) this.userId, (Object) activityEvent.userId) && Intrinsics.areEqual((Object) this.userName, (Object) activityEvent.userName) && Intrinsics.areEqual((Object) this.userAvatarUrl, (Object) activityEvent.userAvatarUrl) && this.role == activityEvent.role && Intrinsics.areEqual((Object) this.lastRead, (Object) activityEvent.lastRead);
    }

    public int hashCode() {
        int hashCode = this.conversationId.hashCode() * 31;
        ActivityData activityData2 = this.activityData;
        int i = 0;
        int hashCode2 = (hashCode + (activityData2 == null ? 0 : activityData2.hashCode())) * 31;
        String str = this.userId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.userName;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userAvatarUrl;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        AuthorType authorType = this.role;
        int hashCode6 = (hashCode5 + (authorType == null ? 0 : authorType.hashCode())) * 31;
        LocalDateTime localDateTime = this.lastRead;
        if (localDateTime != null) {
            i = localDateTime.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "ActivityEvent(conversationId=" + this.conversationId + ", activityData=" + this.activityData + ", userId=" + this.userId + ", userName=" + this.userName + ", userAvatarUrl=" + this.userAvatarUrl + ", role=" + this.role + ", lastRead=" + this.lastRead + ')';
    }

    public ActivityEvent(String str, ActivityData activityData2, String str2, String str3, String str4, AuthorType authorType, LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(str, "conversationId");
        this.conversationId = str;
        this.activityData = activityData2;
        this.userId = str2;
        this.userName = str3;
        this.userAvatarUrl = str4;
        this.role = authorType;
        this.lastRead = localDateTime;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final ActivityData getActivityData() {
        return this.activityData;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserAvatarUrl() {
        return this.userAvatarUrl;
    }

    public final AuthorType getRole() {
        return this.role;
    }

    public final LocalDateTime getLastRead() {
        return this.lastRead;
    }
}
