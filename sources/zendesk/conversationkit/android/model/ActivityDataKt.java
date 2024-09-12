package zendesk.conversationkit.android.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.faye.WsActivityEventDto;
import zendesk.core.android.internal.DateKtxKt;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"toActivityEvent", "Lzendesk/conversationkit/android/model/ActivityEvent;", "Lzendesk/conversationkit/android/internal/faye/WsActivityEventDto;", "conversationId", "", "appMakerLastRead", "", "(Lzendesk/conversationkit/android/internal/faye/WsActivityEventDto;Ljava/lang/String;Ljava/lang/Double;)Lzendesk/conversationkit/android/model/ActivityEvent;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActivityData.kt */
public final class ActivityDataKt {
    public static final ActivityEvent toActivityEvent(WsActivityEventDto wsActivityEventDto, String str, Double d) {
        ActivityData activityData;
        AuthorType authorType;
        LocalDateTime localDateTime;
        Intrinsics.checkNotNullParameter(wsActivityEventDto, "<this>");
        Intrinsics.checkNotNullParameter(str, "conversationId");
        ActivityData[] values = ActivityData.values();
        int length = values.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                activityData = null;
                break;
            }
            ActivityData activityData2 = values[i2];
            if (Intrinsics.areEqual((Object) activityData2.getType(), (Object) wsActivityEventDto.getType())) {
                activityData = activityData2;
                break;
            }
            i2++;
        }
        String appUserId = wsActivityEventDto.getAppUserId();
        String name = wsActivityEventDto.getData().getName();
        String avatarUrl = wsActivityEventDto.getData().getAvatarUrl();
        AuthorType[] values2 = AuthorType.values();
        int length2 = values2.length;
        while (true) {
            if (i >= length2) {
                authorType = null;
                break;
            }
            AuthorType authorType2 = values2[i];
            if (Intrinsics.areEqual((Object) authorType2.getValue$zendesk_conversationkit_conversationkit_android(), (Object) wsActivityEventDto.getRole())) {
                authorType = authorType2;
                break;
            }
            i++;
        }
        if (Intrinsics.areEqual((Object) AuthorType.BUSINESS.getValue$zendesk_conversationkit_conversationkit_android(), (Object) wsActivityEventDto.getRole())) {
            localDateTime = DateKtxKt.toLocalDateTime$default(d, (ZoneId) null, 1, (Object) null);
        } else {
            localDateTime = DateKtxKt.toLocalDateTime$default(wsActivityEventDto.getData().getLastRead(), (ZoneId) null, 1, (Object) null);
        }
        return new ActivityEvent(str, activityData, appUserId, name, avatarUrl, authorType, localDateTime);
    }
}
