package zendesk.conversationkit.android.internal.rest;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.AppUserRequestDto;
import zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto;
import zendesk.conversationkit.android.internal.rest.user.model.LoginRequestBody;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/AppRestClient;", "", "appId", "", "sunshineConversationsApi", "Lzendesk/conversationkit/android/internal/rest/SunshineConversationsApi;", "(Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/SunshineConversationsApi;)V", "createAppUser", "Lzendesk/conversationkit/android/internal/rest/model/AppUserResponseDto;", "clientId", "appUserRequestDto", "Lzendesk/conversationkit/android/internal/rest/model/AppUserRequestDto;", "(Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/AppUserRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginAppUser", "jwt", "loginRequestBody", "Lzendesk/conversationkit/android/internal/rest/user/model/LoginRequestBody;", "(Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/user/model/LoginRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppRestClient.kt */
public final class AppRestClient {
    private final String appId;
    private final SunshineConversationsApi sunshineConversationsApi;

    public AppRestClient(String str, SunshineConversationsApi sunshineConversationsApi2) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(sunshineConversationsApi2, "sunshineConversationsApi");
        this.appId = str;
        this.sunshineConversationsApi = sunshineConversationsApi2;
    }

    public final Object createAppUser(String str, AppUserRequestDto appUserRequestDto, Continuation<? super AppUserResponseDto> continuation) {
        return this.sunshineConversationsApi.createAppUser(this.appId, str, appUserRequestDto, continuation);
    }

    public final Object loginAppUser(String str, LoginRequestBody loginRequestBody, Continuation<? super AppUserResponseDto> continuation) {
        return this.sunshineConversationsApi.loginAppUser(this.appId, "Bearer " + str, loginRequestBody, continuation);
    }
}
