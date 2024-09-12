package zendesk.conversationkit.android.internal.rest;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.ConfigResponseDto;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/IntegrationRestClient;", "", "integrationId", "", "sunshineConversationsApi", "Lzendesk/conversationkit/android/internal/rest/SunshineConversationsApi;", "(Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/SunshineConversationsApi;)V", "getConfig", "Lzendesk/conversationkit/android/internal/rest/model/ConfigResponseDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntegrationRestClient.kt */
public final class IntegrationRestClient {
    private final String integrationId;
    private final SunshineConversationsApi sunshineConversationsApi;

    public IntegrationRestClient(String str, SunshineConversationsApi sunshineConversationsApi2) {
        Intrinsics.checkNotNullParameter(str, "integrationId");
        Intrinsics.checkNotNullParameter(sunshineConversationsApi2, "sunshineConversationsApi");
        this.integrationId = str;
        this.sunshineConversationsApi = sunshineConversationsApi2;
    }

    public final Object getConfig(Continuation<? super ConfigResponseDto> continuation) {
        return this.sunshineConversationsApi.getConfig(this.integrationId, continuation);
    }
}
