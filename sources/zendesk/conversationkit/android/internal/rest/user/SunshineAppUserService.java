package zendesk.conversationkit.android.internal.rest.user;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto;
import zendesk.conversationkit.android.internal.rest.user.model.LoginRequestBody;
import zendesk.conversationkit.android.internal.rest.user.model.LogoutRequestBody;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J/\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\r\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/user/SunshineAppUserService;", "", "loginAppUser", "Lzendesk/conversationkit/android/internal/rest/model/AppUserResponseDto;", "appId", "", "authorization", "loginRequestBody", "Lzendesk/conversationkit/android/internal/rest/user/model/LoginRequestBody;", "(Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/user/model/LoginRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logoutAppUser", "", "appUserId", "logoutRequestBody", "Lzendesk/conversationkit/android/internal/rest/user/model/LogoutRequestBody;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/user/model/LogoutRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SunshineAppUserService.kt */
public interface SunshineAppUserService {
    public static final /* synthetic */ Companion Companion = Companion.$$INSTANCE;
    @Deprecated
    public static final String JSON_CONTENT_TYPE = "Content-Type:application/json";

    @POST("v2/apps/{appId}/login")
    @Headers({"Content-Type:application/json"})
    Object loginAppUser(@Path("appId") String str, @Header("Authorization") String str2, @Body LoginRequestBody loginRequestBody, Continuation<? super AppUserResponseDto> continuation);

    @POST("v2/apps/{appId}/appusers/{appUserId}/logout")
    @Headers({"Content-Type:application/json"})
    Object logoutAppUser(@Path("appId") String str, @Path("appUserId") String str2, @Header("Authorization") String str3, @Body LogoutRequestBody logoutRequestBody, Continuation<? super Unit> continuation);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/user/SunshineAppUserService$Companion;", "", "()V", "JSON_CONTENT_TYPE", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SunshineAppUserService.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String JSON_CONTENT_TYPE = "Content-Type:application/json";

        private Companion() {
        }
    }
}
