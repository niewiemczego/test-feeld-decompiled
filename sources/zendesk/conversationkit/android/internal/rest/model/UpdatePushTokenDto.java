package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/UpdatePushTokenDto;", "", "pushNotificationToken", "", "integrationId", "(Ljava/lang/String;Ljava/lang/String;)V", "getIntegrationId", "()Ljava/lang/String;", "getPushNotificationToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UpdatePushTokenDto.kt */
public final class UpdatePushTokenDto {
    private final String integrationId;
    private final String pushNotificationToken;

    public static /* synthetic */ UpdatePushTokenDto copy$default(UpdatePushTokenDto updatePushTokenDto, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = updatePushTokenDto.pushNotificationToken;
        }
        if ((i & 2) != 0) {
            str2 = updatePushTokenDto.integrationId;
        }
        return updatePushTokenDto.copy(str, str2);
    }

    public final String component1() {
        return this.pushNotificationToken;
    }

    public final String component2() {
        return this.integrationId;
    }

    public final UpdatePushTokenDto copy(String str, String str2) {
        return new UpdatePushTokenDto(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdatePushTokenDto)) {
            return false;
        }
        UpdatePushTokenDto updatePushTokenDto = (UpdatePushTokenDto) obj;
        return Intrinsics.areEqual((Object) this.pushNotificationToken, (Object) updatePushTokenDto.pushNotificationToken) && Intrinsics.areEqual((Object) this.integrationId, (Object) updatePushTokenDto.integrationId);
    }

    public int hashCode() {
        String str = this.pushNotificationToken;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.integrationId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "UpdatePushTokenDto(pushNotificationToken=" + this.pushNotificationToken + ", integrationId=" + this.integrationId + ')';
    }

    public UpdatePushTokenDto(String str, String str2) {
        this.pushNotificationToken = str;
        this.integrationId = str2;
    }

    public final String getPushNotificationToken() {
        return this.pushNotificationToken;
    }

    public final String getIntegrationId() {
        return this.integrationId;
    }
}
