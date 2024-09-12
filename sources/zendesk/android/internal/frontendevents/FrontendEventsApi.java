package zendesk.android.internal.frontendevents;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import zendesk.android.internal.frontendevents.analyticsevents.model.ProactiveMessageAnalyticsEvent;
import zendesk.android.internal.frontendevents.pageviewevents.model.PageViewEventDto;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ%\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lzendesk/android/internal/frontendevents/FrontendEventsApi;", "", "sendPageViewEvent", "Lretrofit2/Response;", "", "client", "", "pageViewEventDto", "Lzendesk/android/internal/frontendevents/pageviewevents/model/PageViewEventDto;", "(Ljava/lang/String;Lzendesk/android/internal/frontendevents/pageviewevents/model/PageViewEventDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendProactiveCampaignAnalyticsEvent", "proactiveMessageAnalyticsEvent", "Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveMessageAnalyticsEvent;", "(Ljava/lang/String;Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveMessageAnalyticsEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FrontendEventsApi.kt */
public interface FrontendEventsApi {
    @POST("/frontendevents/pv")
    @Headers({"X-Zendesk-Api-Version:2021-01-01"})
    Object sendPageViewEvent(@Query("client") String str, @Body PageViewEventDto pageViewEventDto, Continuation<? super Response<Unit>> continuation);

    @POST("/frontendevents/pca")
    Object sendProactiveCampaignAnalyticsEvent(@Query("client") String str, @Body ProactiveMessageAnalyticsEvent proactiveMessageAnalyticsEvent, Continuation<? super Unit> continuation);
}
