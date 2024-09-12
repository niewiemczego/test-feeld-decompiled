package zendesk.conversationkit.android.model;

import java.time.ZoneId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.ParticipantDto;
import zendesk.core.android.internal.DateKtxKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toParticipant", "Lzendesk/conversationkit/android/model/Participant;", "Lzendesk/conversationkit/android/internal/rest/model/ParticipantDto;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Participant.kt */
public final class ParticipantKt {
    public static final Participant toParticipant(ParticipantDto participantDto) {
        Intrinsics.checkNotNullParameter(participantDto, "<this>");
        String id = participantDto.getId();
        String appUserId = participantDto.getAppUserId();
        Integer unreadCount = participantDto.getUnreadCount();
        return new Participant(id, appUserId, unreadCount != null ? unreadCount.intValue() : 0, DateKtxKt.toLocalDateTime$default(participantDto.getLastRead(), (ZoneId) null, 1, (Object) null));
    }
}
