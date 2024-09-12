package zendesk.conversationkit.android.internal.faye;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.MessageDto;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lzendesk/conversationkit/android/internal/faye/WsFayeMessageDto;", "", "type", "", "conversation", "Lzendesk/conversationkit/android/internal/faye/WsConversationDto;", "message", "Lzendesk/conversationkit/android/internal/rest/model/MessageDto;", "activity", "Lzendesk/conversationkit/android/internal/faye/WsActivityEventDto;", "(Ljava/lang/String;Lzendesk/conversationkit/android/internal/faye/WsConversationDto;Lzendesk/conversationkit/android/internal/rest/model/MessageDto;Lzendesk/conversationkit/android/internal/faye/WsActivityEventDto;)V", "getActivity", "()Lzendesk/conversationkit/android/internal/faye/WsActivityEventDto;", "getConversation", "()Lzendesk/conversationkit/android/internal/faye/WsConversationDto;", "getMessage", "()Lzendesk/conversationkit/android/internal/rest/model/MessageDto;", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WsFayeMessageDto.kt */
public final class WsFayeMessageDto {
    private final WsActivityEventDto activity;
    private final WsConversationDto conversation;
    private final MessageDto message;
    private final String type;

    public static /* synthetic */ WsFayeMessageDto copy$default(WsFayeMessageDto wsFayeMessageDto, String str, WsConversationDto wsConversationDto, MessageDto messageDto, WsActivityEventDto wsActivityEventDto, int i, Object obj) {
        if ((i & 1) != 0) {
            str = wsFayeMessageDto.type;
        }
        if ((i & 2) != 0) {
            wsConversationDto = wsFayeMessageDto.conversation;
        }
        if ((i & 4) != 0) {
            messageDto = wsFayeMessageDto.message;
        }
        if ((i & 8) != 0) {
            wsActivityEventDto = wsFayeMessageDto.activity;
        }
        return wsFayeMessageDto.copy(str, wsConversationDto, messageDto, wsActivityEventDto);
    }

    public final String component1() {
        return this.type;
    }

    public final WsConversationDto component2() {
        return this.conversation;
    }

    public final MessageDto component3() {
        return this.message;
    }

    public final WsActivityEventDto component4() {
        return this.activity;
    }

    public final WsFayeMessageDto copy(String str, WsConversationDto wsConversationDto, MessageDto messageDto, WsActivityEventDto wsActivityEventDto) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(wsConversationDto, "conversation");
        return new WsFayeMessageDto(str, wsConversationDto, messageDto, wsActivityEventDto);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WsFayeMessageDto)) {
            return false;
        }
        WsFayeMessageDto wsFayeMessageDto = (WsFayeMessageDto) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) wsFayeMessageDto.type) && Intrinsics.areEqual((Object) this.conversation, (Object) wsFayeMessageDto.conversation) && Intrinsics.areEqual((Object) this.message, (Object) wsFayeMessageDto.message) && Intrinsics.areEqual((Object) this.activity, (Object) wsFayeMessageDto.activity);
    }

    public int hashCode() {
        int hashCode = ((this.type.hashCode() * 31) + this.conversation.hashCode()) * 31;
        MessageDto messageDto = this.message;
        int i = 0;
        int hashCode2 = (hashCode + (messageDto == null ? 0 : messageDto.hashCode())) * 31;
        WsActivityEventDto wsActivityEventDto = this.activity;
        if (wsActivityEventDto != null) {
            i = wsActivityEventDto.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "WsFayeMessageDto(type=" + this.type + ", conversation=" + this.conversation + ", message=" + this.message + ", activity=" + this.activity + ')';
    }

    public WsFayeMessageDto(String str, WsConversationDto wsConversationDto, MessageDto messageDto, WsActivityEventDto wsActivityEventDto) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(wsConversationDto, "conversation");
        this.type = str;
        this.conversation = wsConversationDto;
        this.message = messageDto;
        this.activity = wsActivityEventDto;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WsFayeMessageDto(String str, WsConversationDto wsConversationDto, MessageDto messageDto, WsActivityEventDto wsActivityEventDto, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, wsConversationDto, (i & 4) != 0 ? null : messageDto, (i & 8) != 0 ? null : wsActivityEventDto);
    }

    public final String getType() {
        return this.type;
    }

    public final WsConversationDto getConversation() {
        return this.conversation;
    }

    public final MessageDto getMessage() {
        return this.message;
    }

    public final WsActivityEventDto getActivity() {
        return this.activity;
    }
}
