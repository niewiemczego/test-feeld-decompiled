package zendesk.android.settings.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;
import zendesk.android.settings.internal.model.SettingsResponseDto;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lzendesk/android/settings/internal/SettingsApi;", "", "getSettings", "Lzendesk/android/settings/internal/model/SettingsResponseDto;", "settingsUrl", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingsApi.kt */
public interface SettingsApi {
    @GET
    @Headers({"X-Zendesk-Api-Version:2021-01-01"})
    Object getSettings(@Url String str, Continuation<? super SettingsResponseDto> continuation);
}
