package zendesk.conversationkit.android.model;

import com.oblador.keychain.KeychainModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto;
import zendesk.conversationkit.android.internal.rest.model.ConversationDto;
import zendesk.conversationkit.android.internal.rest.model.RealtimeSettingsDto;
import zendesk.conversationkit.android.internal.rest.model.TypingSettingsDto;
import zendesk.conversationkit.android.model.AuthenticationType;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0000\u001a\u001e\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\rH\u0000¨\u0006\u000e"}, d2 = {"toRealtimeSettings", "Lzendesk/conversationkit/android/model/RealtimeSettings;", "Lzendesk/conversationkit/android/internal/rest/model/RealtimeSettingsDto;", "appId", "", "userId", "toTypingSettings", "Lzendesk/conversationkit/android/model/TypingSettings;", "Lzendesk/conversationkit/android/internal/rest/model/TypingSettingsDto;", "toUser", "Lzendesk/conversationkit/android/model/User;", "Lzendesk/conversationkit/android/internal/rest/model/AppUserResponseDto;", "authenticationType", "Lzendesk/conversationkit/android/model/AuthenticationType;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: User.kt */
public final class UserKt {
    public static /* synthetic */ User toUser$default(AppUserResponseDto appUserResponseDto, String str, AuthenticationType authenticationType, int i, Object obj) {
        if ((i & 2) != 0) {
            if (appUserResponseDto.getSessionToken() != null) {
                authenticationType = new AuthenticationType.SessionToken(appUserResponseDto.getSessionToken());
            } else {
                authenticationType = AuthenticationType.Unauthenticated.INSTANCE;
            }
        }
        return toUser(appUserResponseDto, str, authenticationType);
    }

    public static final User toUser(AppUserResponseDto appUserResponseDto, String str, AuthenticationType authenticationType) {
        String str2 = str;
        AuthenticationType authenticationType2 = authenticationType;
        Intrinsics.checkNotNullParameter(appUserResponseDto, "<this>");
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(authenticationType2, KeychainModule.Maps.AUTH_TYPE);
        String id = appUserResponseDto.getAppUser().getId();
        String userId = appUserResponseDto.getAppUser().getUserId();
        String givenName = appUserResponseDto.getAppUser().getGivenName();
        String surname = appUserResponseDto.getAppUser().getSurname();
        String email = appUserResponseDto.getAppUser().getEmail();
        String locale = appUserResponseDto.getAppUser().getLocale();
        String signedUpAt = appUserResponseDto.getAppUser().getSignedUpAt();
        Iterable<ConversationDto> conversations = appUserResponseDto.getConversations();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(conversations, 10));
        for (ConversationDto conversation$default : conversations) {
            arrayList.add(ConversationKt.toConversation$default(conversation$default, appUserResponseDto.getAppUser().getId(), appUserResponseDto.getAppUsers(), (List) null, false, 12, (Object) null));
        }
        List list = (List) arrayList;
        RealtimeSettings realtimeSettings = toRealtimeSettings(appUserResponseDto.getSettings().getRealtime(), str2, appUserResponseDto.getAppUser().getId());
        TypingSettings typingSettings = toTypingSettings(appUserResponseDto.getSettings().getTyping());
        AuthenticationType.Jwt jwt = authenticationType2 instanceof AuthenticationType.Jwt ? (AuthenticationType.Jwt) authenticationType2 : null;
        String value = jwt != null ? jwt.getValue() : null;
        AuthenticationType.SessionToken sessionToken = authenticationType2 instanceof AuthenticationType.SessionToken ? (AuthenticationType.SessionToken) authenticationType2 : null;
        return new User(id, userId, givenName, surname, email, locale, signedUpAt, list, realtimeSettings, typingSettings, sessionToken != null ? sessionToken.getValue() : null, value);
    }

    public static final RealtimeSettings toRealtimeSettings(RealtimeSettingsDto realtimeSettingsDto, String str, String str2) {
        RealtimeSettingsDto realtimeSettingsDto2 = realtimeSettingsDto;
        Intrinsics.checkNotNullParameter(realtimeSettingsDto, "<this>");
        Intrinsics.checkNotNullParameter(str, "appId");
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str3, "userId");
        return new RealtimeSettings(realtimeSettingsDto.getEnabled(), realtimeSettingsDto.getBaseUrl(), (long) realtimeSettingsDto.getRetryInterval(), realtimeSettingsDto.getMaxConnectionAttempts(), (long) realtimeSettingsDto.getConnectionDelay(), (TimeUnit) null, str, str3, 32, (DefaultConstructorMarker) null);
    }

    public static final TypingSettings toTypingSettings(TypingSettingsDto typingSettingsDto) {
        Intrinsics.checkNotNullParameter(typingSettingsDto, "<this>");
        return new TypingSettings(typingSettingsDto.getEnabled());
    }
}
