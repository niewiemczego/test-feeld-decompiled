package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ6\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/MessageListResponseDto;", "", "messages", "", "Lzendesk/conversationkit/android/internal/rest/model/MessageDto;", "hasPrevious", "", "hasNext", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getHasNext", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHasPrevious", "getMessages", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lzendesk/conversationkit/android/internal/rest/model/MessageListResponseDto;", "equals", "other", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageListResponseDto.kt */
public final class MessageListResponseDto {
    private final Boolean hasNext;
    private final Boolean hasPrevious;
    private final List<MessageDto> messages;

    public static /* synthetic */ MessageListResponseDto copy$default(MessageListResponseDto messageListResponseDto, List<MessageDto> list, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = messageListResponseDto.messages;
        }
        if ((i & 2) != 0) {
            bool = messageListResponseDto.hasPrevious;
        }
        if ((i & 4) != 0) {
            bool2 = messageListResponseDto.hasNext;
        }
        return messageListResponseDto.copy(list, bool, bool2);
    }

    public final List<MessageDto> component1() {
        return this.messages;
    }

    public final Boolean component2() {
        return this.hasPrevious;
    }

    public final Boolean component3() {
        return this.hasNext;
    }

    public final MessageListResponseDto copy(List<MessageDto> list, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(list, "messages");
        return new MessageListResponseDto(list, bool, bool2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageListResponseDto)) {
            return false;
        }
        MessageListResponseDto messageListResponseDto = (MessageListResponseDto) obj;
        return Intrinsics.areEqual((Object) this.messages, (Object) messageListResponseDto.messages) && Intrinsics.areEqual((Object) this.hasPrevious, (Object) messageListResponseDto.hasPrevious) && Intrinsics.areEqual((Object) this.hasNext, (Object) messageListResponseDto.hasNext);
    }

    public int hashCode() {
        int hashCode = this.messages.hashCode() * 31;
        Boolean bool = this.hasPrevious;
        int i = 0;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.hasNext;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "MessageListResponseDto(messages=" + this.messages + ", hasPrevious=" + this.hasPrevious + ", hasNext=" + this.hasNext + ')';
    }

    public MessageListResponseDto(List<MessageDto> list, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(list, "messages");
        this.messages = list;
        this.hasPrevious = bool;
        this.hasNext = bool2;
    }

    public final List<MessageDto> getMessages() {
        return this.messages;
    }

    public final Boolean getHasPrevious() {
        return this.hasPrevious;
    }

    public final Boolean getHasNext() {
        return this.hasNext;
    }
}
