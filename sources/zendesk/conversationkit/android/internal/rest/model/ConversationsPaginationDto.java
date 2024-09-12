package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ConversationsPaginationDto;", "", "hasMore", "", "(Ljava/lang/Boolean;)V", "getHasMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lzendesk/conversationkit/android/internal/rest/model/ConversationsPaginationDto;", "equals", "other", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationsPaginationDto.kt */
public final class ConversationsPaginationDto {
    private final Boolean hasMore;

    public static /* synthetic */ ConversationsPaginationDto copy$default(ConversationsPaginationDto conversationsPaginationDto, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = conversationsPaginationDto.hasMore;
        }
        return conversationsPaginationDto.copy(bool);
    }

    public final Boolean component1() {
        return this.hasMore;
    }

    public final ConversationsPaginationDto copy(Boolean bool) {
        return new ConversationsPaginationDto(bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConversationsPaginationDto) && Intrinsics.areEqual((Object) this.hasMore, (Object) ((ConversationsPaginationDto) obj).hasMore);
    }

    public int hashCode() {
        Boolean bool = this.hasMore;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public String toString() {
        return "ConversationsPaginationDto(hasMore=" + this.hasMore + ')';
    }

    public ConversationsPaginationDto(Boolean bool) {
        this.hasMore = bool;
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }
}
