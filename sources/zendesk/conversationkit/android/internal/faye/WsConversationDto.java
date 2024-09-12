package zendesk.conversationkit.android.internal.faye;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/internal/faye/WsConversationDto;", "", "id", "", "appMakerLastRead", "", "(Ljava/lang/String;Ljava/lang/Double;)V", "getAppMakerLastRead", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getId", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Double;)Lzendesk/conversationkit/android/internal/faye/WsConversationDto;", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WsFayeMessageDto.kt */
public final class WsConversationDto {
    private final Double appMakerLastRead;
    private final String id;

    public static /* synthetic */ WsConversationDto copy$default(WsConversationDto wsConversationDto, String str, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = wsConversationDto.id;
        }
        if ((i & 2) != 0) {
            d = wsConversationDto.appMakerLastRead;
        }
        return wsConversationDto.copy(str, d);
    }

    public final String component1() {
        return this.id;
    }

    public final Double component2() {
        return this.appMakerLastRead;
    }

    public final WsConversationDto copy(@Json(name = "_id") String str, Double d) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new WsConversationDto(str, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WsConversationDto)) {
            return false;
        }
        WsConversationDto wsConversationDto = (WsConversationDto) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) wsConversationDto.id) && Intrinsics.areEqual((Object) this.appMakerLastRead, (Object) wsConversationDto.appMakerLastRead);
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        Double d = this.appMakerLastRead;
        return hashCode + (d == null ? 0 : d.hashCode());
    }

    public String toString() {
        return "WsConversationDto(id=" + this.id + ", appMakerLastRead=" + this.appMakerLastRead + ')';
    }

    public WsConversationDto(@Json(name = "_id") String str, Double d) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
        this.appMakerLastRead = d;
    }

    public final String getId() {
        return this.id;
    }

    public final Double getAppMakerLastRead() {
        return this.appMakerLastRead;
    }
}
