package zendesk.conversationkit.android.internal.faye;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lzendesk/conversationkit/android/internal/faye/WsActivityEventDto;", "", "role", "", "type", "appUserId", "data", "Lzendesk/conversationkit/android/internal/faye/WsActivityEventDataDto;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/faye/WsActivityEventDataDto;)V", "getAppUserId", "()Ljava/lang/String;", "getData", "()Lzendesk/conversationkit/android/internal/faye/WsActivityEventDataDto;", "getRole", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WsFayeMessageDto.kt */
public final class WsActivityEventDto {
    private final String appUserId;
    private final WsActivityEventDataDto data;
    private final String role;
    private final String type;

    public static /* synthetic */ WsActivityEventDto copy$default(WsActivityEventDto wsActivityEventDto, String str, String str2, String str3, WsActivityEventDataDto wsActivityEventDataDto, int i, Object obj) {
        if ((i & 1) != 0) {
            str = wsActivityEventDto.role;
        }
        if ((i & 2) != 0) {
            str2 = wsActivityEventDto.type;
        }
        if ((i & 4) != 0) {
            str3 = wsActivityEventDto.appUserId;
        }
        if ((i & 8) != 0) {
            wsActivityEventDataDto = wsActivityEventDto.data;
        }
        return wsActivityEventDto.copy(str, str2, str3, wsActivityEventDataDto);
    }

    public final String component1() {
        return this.role;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.appUserId;
    }

    public final WsActivityEventDataDto component4() {
        return this.data;
    }

    public final WsActivityEventDto copy(String str, String str2, String str3, WsActivityEventDataDto wsActivityEventDataDto) {
        Intrinsics.checkNotNullParameter(str, "role");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(wsActivityEventDataDto, "data");
        return new WsActivityEventDto(str, str2, str3, wsActivityEventDataDto);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WsActivityEventDto)) {
            return false;
        }
        WsActivityEventDto wsActivityEventDto = (WsActivityEventDto) obj;
        return Intrinsics.areEqual((Object) this.role, (Object) wsActivityEventDto.role) && Intrinsics.areEqual((Object) this.type, (Object) wsActivityEventDto.type) && Intrinsics.areEqual((Object) this.appUserId, (Object) wsActivityEventDto.appUserId) && Intrinsics.areEqual((Object) this.data, (Object) wsActivityEventDto.data);
    }

    public int hashCode() {
        int hashCode = ((this.role.hashCode() * 31) + this.type.hashCode()) * 31;
        String str = this.appUserId;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "WsActivityEventDto(role=" + this.role + ", type=" + this.type + ", appUserId=" + this.appUserId + ", data=" + this.data + ')';
    }

    public WsActivityEventDto(String str, String str2, String str3, WsActivityEventDataDto wsActivityEventDataDto) {
        Intrinsics.checkNotNullParameter(str, "role");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(wsActivityEventDataDto, "data");
        this.role = str;
        this.type = str2;
        this.appUserId = str3;
        this.data = wsActivityEventDataDto;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getType() {
        return this.type;
    }

    public final String getAppUserId() {
        return this.appUserId;
    }

    public final WsActivityEventDataDto getData() {
        return this.data;
    }
}
