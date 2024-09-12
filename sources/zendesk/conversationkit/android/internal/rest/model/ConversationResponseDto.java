package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\fHÆ\u0003JV\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\fHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\rHÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ConversationResponseDto;", "", "conversation", "Lzendesk/conversationkit/android/internal/rest/model/ConversationDto;", "messages", "", "Lzendesk/conversationkit/android/internal/rest/model/MessageDto;", "hasPrevious", "", "appUser", "Lzendesk/conversationkit/android/internal/rest/model/AppUserDto;", "appUsers", "", "", "(Lzendesk/conversationkit/android/internal/rest/model/ConversationDto;Ljava/util/List;Ljava/lang/Boolean;Lzendesk/conversationkit/android/internal/rest/model/AppUserDto;Ljava/util/Map;)V", "getAppUser", "()Lzendesk/conversationkit/android/internal/rest/model/AppUserDto;", "getAppUsers", "()Ljava/util/Map;", "getConversation", "()Lzendesk/conversationkit/android/internal/rest/model/ConversationDto;", "getHasPrevious", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMessages", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lzendesk/conversationkit/android/internal/rest/model/ConversationDto;Ljava/util/List;Ljava/lang/Boolean;Lzendesk/conversationkit/android/internal/rest/model/AppUserDto;Ljava/util/Map;)Lzendesk/conversationkit/android/internal/rest/model/ConversationResponseDto;", "equals", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationResponseDto.kt */
public final class ConversationResponseDto {
    private final AppUserDto appUser;
    private final Map<String, AppUserDto> appUsers;
    private final ConversationDto conversation;
    private final Boolean hasPrevious;
    private final List<MessageDto> messages;

    public static /* synthetic */ ConversationResponseDto copy$default(ConversationResponseDto conversationResponseDto, ConversationDto conversationDto, List<MessageDto> list, Boolean bool, AppUserDto appUserDto, Map<String, AppUserDto> map, int i, Object obj) {
        if ((i & 1) != 0) {
            conversationDto = conversationResponseDto.conversation;
        }
        if ((i & 2) != 0) {
            list = conversationResponseDto.messages;
        }
        List<MessageDto> list2 = list;
        if ((i & 4) != 0) {
            bool = conversationResponseDto.hasPrevious;
        }
        Boolean bool2 = bool;
        if ((i & 8) != 0) {
            appUserDto = conversationResponseDto.appUser;
        }
        AppUserDto appUserDto2 = appUserDto;
        if ((i & 16) != 0) {
            map = conversationResponseDto.appUsers;
        }
        return conversationResponseDto.copy(conversationDto, list2, bool2, appUserDto2, map);
    }

    public final ConversationDto component1() {
        return this.conversation;
    }

    public final List<MessageDto> component2() {
        return this.messages;
    }

    public final Boolean component3() {
        return this.hasPrevious;
    }

    public final AppUserDto component4() {
        return this.appUser;
    }

    public final Map<String, AppUserDto> component5() {
        return this.appUsers;
    }

    public final ConversationResponseDto copy(ConversationDto conversationDto, List<MessageDto> list, Boolean bool, AppUserDto appUserDto, Map<String, AppUserDto> map) {
        Intrinsics.checkNotNullParameter(conversationDto, "conversation");
        Intrinsics.checkNotNullParameter(appUserDto, "appUser");
        Intrinsics.checkNotNullParameter(map, "appUsers");
        return new ConversationResponseDto(conversationDto, list, bool, appUserDto, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConversationResponseDto)) {
            return false;
        }
        ConversationResponseDto conversationResponseDto = (ConversationResponseDto) obj;
        return Intrinsics.areEqual((Object) this.conversation, (Object) conversationResponseDto.conversation) && Intrinsics.areEqual((Object) this.messages, (Object) conversationResponseDto.messages) && Intrinsics.areEqual((Object) this.hasPrevious, (Object) conversationResponseDto.hasPrevious) && Intrinsics.areEqual((Object) this.appUser, (Object) conversationResponseDto.appUser) && Intrinsics.areEqual((Object) this.appUsers, (Object) conversationResponseDto.appUsers);
    }

    public int hashCode() {
        int hashCode = this.conversation.hashCode() * 31;
        List<MessageDto> list = this.messages;
        int i = 0;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.hasPrevious;
        if (bool != null) {
            i = bool.hashCode();
        }
        return ((((hashCode2 + i) * 31) + this.appUser.hashCode()) * 31) + this.appUsers.hashCode();
    }

    public String toString() {
        return "ConversationResponseDto(conversation=" + this.conversation + ", messages=" + this.messages + ", hasPrevious=" + this.hasPrevious + ", appUser=" + this.appUser + ", appUsers=" + this.appUsers + ')';
    }

    public ConversationResponseDto(ConversationDto conversationDto, List<MessageDto> list, Boolean bool, AppUserDto appUserDto, Map<String, AppUserDto> map) {
        Intrinsics.checkNotNullParameter(conversationDto, "conversation");
        Intrinsics.checkNotNullParameter(appUserDto, "appUser");
        Intrinsics.checkNotNullParameter(map, "appUsers");
        this.conversation = conversationDto;
        this.messages = list;
        this.hasPrevious = bool;
        this.appUser = appUserDto;
        this.appUsers = map;
    }

    public final ConversationDto getConversation() {
        return this.conversation;
    }

    public final List<MessageDto> getMessages() {
        return this.messages;
    }

    public final Boolean getHasPrevious() {
        return this.hasPrevious;
    }

    public final AppUserDto getAppUser() {
        return this.appUser;
    }

    public final Map<String, AppUserDto> getAppUsers() {
        return this.appUsers;
    }
}
