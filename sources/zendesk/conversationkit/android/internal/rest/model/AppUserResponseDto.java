package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\fHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\rHÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/AppUserResponseDto;", "", "settings", "Lzendesk/conversationkit/android/internal/rest/model/UserSettingsDto;", "conversations", "", "Lzendesk/conversationkit/android/internal/rest/model/ConversationDto;", "conversationsPagination", "Lzendesk/conversationkit/android/internal/rest/model/ConversationsPaginationDto;", "appUser", "Lzendesk/conversationkit/android/internal/rest/model/AppUserDto;", "appUsers", "", "", "sessionToken", "(Lzendesk/conversationkit/android/internal/rest/model/UserSettingsDto;Ljava/util/List;Lzendesk/conversationkit/android/internal/rest/model/ConversationsPaginationDto;Lzendesk/conversationkit/android/internal/rest/model/AppUserDto;Ljava/util/Map;Ljava/lang/String;)V", "getAppUser", "()Lzendesk/conversationkit/android/internal/rest/model/AppUserDto;", "getAppUsers", "()Ljava/util/Map;", "getConversations", "()Ljava/util/List;", "getConversationsPagination", "()Lzendesk/conversationkit/android/internal/rest/model/ConversationsPaginationDto;", "getSessionToken", "()Ljava/lang/String;", "getSettings", "()Lzendesk/conversationkit/android/internal/rest/model/UserSettingsDto;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppUserResponseDto.kt */
public final class AppUserResponseDto {
    private final AppUserDto appUser;
    private final Map<String, AppUserDto> appUsers;
    private final List<ConversationDto> conversations;
    private final ConversationsPaginationDto conversationsPagination;
    private final String sessionToken;
    private final UserSettingsDto settings;

    public static /* synthetic */ AppUserResponseDto copy$default(AppUserResponseDto appUserResponseDto, UserSettingsDto userSettingsDto, List<ConversationDto> list, ConversationsPaginationDto conversationsPaginationDto, AppUserDto appUserDto, Map<String, AppUserDto> map, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            userSettingsDto = appUserResponseDto.settings;
        }
        if ((i & 2) != 0) {
            list = appUserResponseDto.conversations;
        }
        List<ConversationDto> list2 = list;
        if ((i & 4) != 0) {
            conversationsPaginationDto = appUserResponseDto.conversationsPagination;
        }
        ConversationsPaginationDto conversationsPaginationDto2 = conversationsPaginationDto;
        if ((i & 8) != 0) {
            appUserDto = appUserResponseDto.appUser;
        }
        AppUserDto appUserDto2 = appUserDto;
        if ((i & 16) != 0) {
            map = appUserResponseDto.appUsers;
        }
        Map<String, AppUserDto> map2 = map;
        if ((i & 32) != 0) {
            str = appUserResponseDto.sessionToken;
        }
        return appUserResponseDto.copy(userSettingsDto, list2, conversationsPaginationDto2, appUserDto2, map2, str);
    }

    public final UserSettingsDto component1() {
        return this.settings;
    }

    public final List<ConversationDto> component2() {
        return this.conversations;
    }

    public final ConversationsPaginationDto component3() {
        return this.conversationsPagination;
    }

    public final AppUserDto component4() {
        return this.appUser;
    }

    public final Map<String, AppUserDto> component5() {
        return this.appUsers;
    }

    public final String component6() {
        return this.sessionToken;
    }

    public final AppUserResponseDto copy(UserSettingsDto userSettingsDto, List<ConversationDto> list, ConversationsPaginationDto conversationsPaginationDto, AppUserDto appUserDto, Map<String, AppUserDto> map, String str) {
        Intrinsics.checkNotNullParameter(userSettingsDto, "settings");
        Intrinsics.checkNotNullParameter(list, "conversations");
        Intrinsics.checkNotNullParameter(conversationsPaginationDto, "conversationsPagination");
        Intrinsics.checkNotNullParameter(appUserDto, "appUser");
        Intrinsics.checkNotNullParameter(map, "appUsers");
        return new AppUserResponseDto(userSettingsDto, list, conversationsPaginationDto, appUserDto, map, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppUserResponseDto)) {
            return false;
        }
        AppUserResponseDto appUserResponseDto = (AppUserResponseDto) obj;
        return Intrinsics.areEqual((Object) this.settings, (Object) appUserResponseDto.settings) && Intrinsics.areEqual((Object) this.conversations, (Object) appUserResponseDto.conversations) && Intrinsics.areEqual((Object) this.conversationsPagination, (Object) appUserResponseDto.conversationsPagination) && Intrinsics.areEqual((Object) this.appUser, (Object) appUserResponseDto.appUser) && Intrinsics.areEqual((Object) this.appUsers, (Object) appUserResponseDto.appUsers) && Intrinsics.areEqual((Object) this.sessionToken, (Object) appUserResponseDto.sessionToken);
    }

    public int hashCode() {
        int hashCode = ((((((((this.settings.hashCode() * 31) + this.conversations.hashCode()) * 31) + this.conversationsPagination.hashCode()) * 31) + this.appUser.hashCode()) * 31) + this.appUsers.hashCode()) * 31;
        String str = this.sessionToken;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AppUserResponseDto(settings=" + this.settings + ", conversations=" + this.conversations + ", conversationsPagination=" + this.conversationsPagination + ", appUser=" + this.appUser + ", appUsers=" + this.appUsers + ", sessionToken=" + this.sessionToken + ')';
    }

    public AppUserResponseDto(UserSettingsDto userSettingsDto, List<ConversationDto> list, ConversationsPaginationDto conversationsPaginationDto, AppUserDto appUserDto, Map<String, AppUserDto> map, String str) {
        Intrinsics.checkNotNullParameter(userSettingsDto, "settings");
        Intrinsics.checkNotNullParameter(list, "conversations");
        Intrinsics.checkNotNullParameter(conversationsPaginationDto, "conversationsPagination");
        Intrinsics.checkNotNullParameter(appUserDto, "appUser");
        Intrinsics.checkNotNullParameter(map, "appUsers");
        this.settings = userSettingsDto;
        this.conversations = list;
        this.conversationsPagination = conversationsPaginationDto;
        this.appUser = appUserDto;
        this.appUsers = map;
        this.sessionToken = str;
    }

    public final UserSettingsDto getSettings() {
        return this.settings;
    }

    public final List<ConversationDto> getConversations() {
        return this.conversations;
    }

    public final ConversationsPaginationDto getConversationsPagination() {
        return this.conversationsPagination;
    }

    public final AppUserDto getAppUser() {
        return this.appUser;
    }

    public final Map<String, AppUserDto> getAppUsers() {
        return this.appUsers;
    }

    public final String getSessionToken() {
        return this.sessionToken;
    }
}
