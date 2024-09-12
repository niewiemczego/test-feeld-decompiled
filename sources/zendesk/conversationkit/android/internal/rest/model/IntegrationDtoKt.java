package zendesk.conversationkit.android.internal.rest.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.Integration;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toIntegration", "Lzendesk/conversationkit/android/model/Integration;", "Lzendesk/conversationkit/android/internal/rest/model/IntegrationDto;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntegrationDto.kt */
public final class IntegrationDtoKt {
    public static final Integration toIntegration(IntegrationDto integrationDto) {
        Intrinsics.checkNotNullParameter(integrationDto, "<this>");
        return new Integration(integrationDto.getId(), integrationDto.getCanUserCreateMoreConversations(), integrationDto.getCanUserSeeConversationList());
    }
}
