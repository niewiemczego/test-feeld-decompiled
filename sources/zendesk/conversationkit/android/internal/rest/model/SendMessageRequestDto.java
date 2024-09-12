package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/SendMessageRequestDto;", "", "author", "Lzendesk/conversationkit/android/internal/rest/model/AuthorDto;", "message", "Lzendesk/conversationkit/android/internal/rest/model/SendMessageDto;", "(Lzendesk/conversationkit/android/internal/rest/model/AuthorDto;Lzendesk/conversationkit/android/internal/rest/model/SendMessageDto;)V", "getAuthor", "()Lzendesk/conversationkit/android/internal/rest/model/AuthorDto;", "getMessage", "()Lzendesk/conversationkit/android/internal/rest/model/SendMessageDto;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SendMessageRequestDto.kt */
public final class SendMessageRequestDto {
    private final AuthorDto author;
    private final SendMessageDto message;

    public static /* synthetic */ SendMessageRequestDto copy$default(SendMessageRequestDto sendMessageRequestDto, AuthorDto authorDto, SendMessageDto sendMessageDto, int i, Object obj) {
        if ((i & 1) != 0) {
            authorDto = sendMessageRequestDto.author;
        }
        if ((i & 2) != 0) {
            sendMessageDto = sendMessageRequestDto.message;
        }
        return sendMessageRequestDto.copy(authorDto, sendMessageDto);
    }

    public final AuthorDto component1() {
        return this.author;
    }

    public final SendMessageDto component2() {
        return this.message;
    }

    public final SendMessageRequestDto copy(AuthorDto authorDto, SendMessageDto sendMessageDto) {
        Intrinsics.checkNotNullParameter(authorDto, "author");
        Intrinsics.checkNotNullParameter(sendMessageDto, "message");
        return new SendMessageRequestDto(authorDto, sendMessageDto);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SendMessageRequestDto)) {
            return false;
        }
        SendMessageRequestDto sendMessageRequestDto = (SendMessageRequestDto) obj;
        return Intrinsics.areEqual((Object) this.author, (Object) sendMessageRequestDto.author) && Intrinsics.areEqual((Object) this.message, (Object) sendMessageRequestDto.message);
    }

    public int hashCode() {
        return (this.author.hashCode() * 31) + this.message.hashCode();
    }

    public String toString() {
        return "SendMessageRequestDto(author=" + this.author + ", message=" + this.message + ')';
    }

    public SendMessageRequestDto(AuthorDto authorDto, SendMessageDto sendMessageDto) {
        Intrinsics.checkNotNullParameter(authorDto, "author");
        Intrinsics.checkNotNullParameter(sendMessageDto, "message");
        this.author = authorDto;
        this.message = sendMessageDto;
    }

    public final AuthorDto getAuthor() {
        return this.author;
    }

    public final SendMessageDto getMessage() {
        return this.message;
    }
}
