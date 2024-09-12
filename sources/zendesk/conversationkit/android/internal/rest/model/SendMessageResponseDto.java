package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/SendMessageResponseDto;", "", "messages", "", "Lzendesk/conversationkit/android/internal/rest/model/MessageDto;", "(Ljava/util/List;)V", "getMessages", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SendMessageResponseDto.kt */
public final class SendMessageResponseDto {
    private final List<MessageDto> messages;

    public static /* synthetic */ SendMessageResponseDto copy$default(SendMessageResponseDto sendMessageResponseDto, List<MessageDto> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = sendMessageResponseDto.messages;
        }
        return sendMessageResponseDto.copy(list);
    }

    public final List<MessageDto> component1() {
        return this.messages;
    }

    public final SendMessageResponseDto copy(List<MessageDto> list) {
        Intrinsics.checkNotNullParameter(list, "messages");
        return new SendMessageResponseDto(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SendMessageResponseDto) && Intrinsics.areEqual((Object) this.messages, (Object) ((SendMessageResponseDto) obj).messages);
    }

    public int hashCode() {
        return this.messages.hashCode();
    }

    public String toString() {
        return "SendMessageResponseDto(messages=" + this.messages + ')';
    }

    public SendMessageResponseDto(List<MessageDto> list) {
        Intrinsics.checkNotNullParameter(list, "messages");
        this.messages = list;
    }

    public final List<MessageDto> getMessages() {
        return this.messages;
    }
}
