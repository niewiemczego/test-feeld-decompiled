package zendesk.android.internal.proactivemessaging;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.CtsRequestDto;
import zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.CtsResponseDto;
import zendesk.android.internal.proactivemessaging.model.Campaign;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lzendesk/android/internal/proactivemessaging/ProactiveMessagingService;", "", "getCampaigns", "", "Lzendesk/android/internal/proactivemessaging/model/Campaign;", "integrationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProactiveMessage", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/CtsResponseDto;", "ctsRequest", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/CtsRequestDto;", "(Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/CtsRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveMessagingService.kt */
public interface ProactiveMessagingService {
    @GET("/embeddable/campaigns/{integrationId}")
    Object getCampaigns(@Path("integrationId") String str, Continuation<? super List<Campaign>> continuation);

    @POST("/api/v2/cts/proactive_message")
    Object getProactiveMessage(@Body CtsRequestDto ctsRequestDto, Continuation<? super CtsResponseDto> continuation);
}
