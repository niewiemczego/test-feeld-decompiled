package zendesk.conversationkit.android.internal.faye;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0019"}, d2 = {"Lzendesk/conversationkit/android/internal/faye/WsActivityEventDataDto;", "", "name", "", "avatarUrl", "lastRead", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getAvatarUrl", "()Ljava/lang/String;", "getLastRead", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getName", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lzendesk/conversationkit/android/internal/faye/WsActivityEventDataDto;", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WsFayeMessageDto.kt */
public final class WsActivityEventDataDto {
    private final String avatarUrl;
    private final Double lastRead;
    private final String name;

    public static /* synthetic */ WsActivityEventDataDto copy$default(WsActivityEventDataDto wsActivityEventDataDto, String str, String str2, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = wsActivityEventDataDto.name;
        }
        if ((i & 2) != 0) {
            str2 = wsActivityEventDataDto.avatarUrl;
        }
        if ((i & 4) != 0) {
            d = wsActivityEventDataDto.lastRead;
        }
        return wsActivityEventDataDto.copy(str, str2, d);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.avatarUrl;
    }

    public final Double component3() {
        return this.lastRead;
    }

    public final WsActivityEventDataDto copy(String str, String str2, Double d) {
        return new WsActivityEventDataDto(str, str2, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WsActivityEventDataDto)) {
            return false;
        }
        WsActivityEventDataDto wsActivityEventDataDto = (WsActivityEventDataDto) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) wsActivityEventDataDto.name) && Intrinsics.areEqual((Object) this.avatarUrl, (Object) wsActivityEventDataDto.avatarUrl) && Intrinsics.areEqual((Object) this.lastRead, (Object) wsActivityEventDataDto.lastRead);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.avatarUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d = this.lastRead;
        if (d != null) {
            i = d.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "WsActivityEventDataDto(name=" + this.name + ", avatarUrl=" + this.avatarUrl + ", lastRead=" + this.lastRead + ')';
    }

    public WsActivityEventDataDto(String str, String str2, Double d) {
        this.name = str;
        this.avatarUrl = str2;
        this.lastRead = d;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final Double getLastRead() {
        return this.lastRead;
    }
}
