package zendesk.conversationkit.android.model;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.RestRetryPolicyDto;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toRestRetryPolicy", "Lzendesk/conversationkit/android/model/RestRetryPolicy;", "Lzendesk/conversationkit/android/internal/rest/model/RestRetryPolicyDto;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: RestRetryPolicy.kt */
public final class RestRetryPolicyKt {
    public static final RestRetryPolicy toRestRetryPolicy(RestRetryPolicyDto restRetryPolicyDto) {
        Intrinsics.checkNotNullParameter(restRetryPolicyDto, "<this>");
        return new RestRetryPolicy(restRetryPolicyDto.getIntervals().getRegular(), restRetryPolicyDto.getIntervals().getAggressive(), (TimeUnit) null, restRetryPolicyDto.getBackoffMultiplier(), restRetryPolicyDto.getMaxRetries(), 4, (DefaultConstructorMarker) null);
    }
}
