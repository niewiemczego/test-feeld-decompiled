package zendesk.conversationkit.android.internal.rest;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import zendesk.conversationkit.android.internal.rest.model.ActivityDataRequestDto;
import zendesk.conversationkit.android.internal.rest.model.AppUserRequestDto;
import zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto;
import zendesk.conversationkit.android.internal.rest.model.AuthorDto;
import zendesk.conversationkit.android.internal.rest.model.ConfigResponseDto;
import zendesk.conversationkit.android.internal.rest.model.ConversationResponseDto;
import zendesk.conversationkit.android.internal.rest.model.CreateConversationRequestDto;
import zendesk.conversationkit.android.internal.rest.model.MessageListResponseDto;
import zendesk.conversationkit.android.internal.rest.model.MetadataDto;
import zendesk.conversationkit.android.internal.rest.model.SendMessageRequestDto;
import zendesk.conversationkit.android.internal.rest.model.SendMessageResponseDto;
import zendesk.conversationkit.android.internal.rest.model.UpdateAppUserLocaleDto;
import zendesk.conversationkit.android.internal.rest.model.UpdatePushTokenDto;
import zendesk.conversationkit.android.internal.rest.model.UploadFileResponseDto;
import zendesk.conversationkit.android.internal.rest.user.SunshineAppUserService;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 92\u00020\u0001:\u00019J/\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u000fH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J/\u0010\u0011\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\r\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J/\u0010\u0017\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0018\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J9\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0018\u001a\u00020\u00052\b\b\u0001\u0010\u001b\u001a\u00020\u001cH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ9\u0010\u001e\u001a\u00020\u001f2\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0018\u001a\u00020\u00052\b\b\u0001\u0010 \u001a\u00020!H§@ø\u0001\u0000¢\u0006\u0002\u0010\"J9\u0010#\u001a\u00020$2\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0018\u001a\u00020\u00052\b\b\u0001\u0010%\u001a\u00020&H§@ø\u0001\u0000¢\u0006\u0002\u0010'J9\u0010(\u001a\u00020\u001f2\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010)\u001a\u00020*H§@ø\u0001\u0000¢\u0006\u0002\u0010+JC\u0010,\u001a\u00020\u001f2\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010-\u001a\u00020.H§@ø\u0001\u0000¢\u0006\u0002\u0010/JM\u00100\u001a\u0002012\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0018\u001a\u00020\u00052\b\b\u0001\u00102\u001a\u0002032\b\b\u0001\u00104\u001a\u0002052\b\b\u0001\u00106\u001a\u000207H§@ø\u0001\u0000¢\u0006\u0002\u00108\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/SunshineConversationsApi;", "Lzendesk/conversationkit/android/internal/rest/user/SunshineAppUserService;", "createAppUser", "Lzendesk/conversationkit/android/internal/rest/model/AppUserResponseDto;", "appId", "", "clientId", "appUserRequestDto", "Lzendesk/conversationkit/android/internal/rest/model/AppUserRequestDto;", "(Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/AppUserRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConversation", "Lzendesk/conversationkit/android/internal/rest/model/ConversationResponseDto;", "authorization", "appUserId", "createConversationRequestDto", "Lzendesk/conversationkit/android/internal/rest/model/CreateConversationRequestDto;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/CreateConversationRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppUser", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConfig", "Lzendesk/conversationkit/android/internal/rest/model/ConfigResponseDto;", "integrationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConversation", "conversationId", "getMessages", "Lzendesk/conversationkit/android/internal/rest/model/MessageListResponseDto;", "beforeTimestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendActivityData", "", "activityDataDto", "Lzendesk/conversationkit/android/internal/rest/model/ActivityDataRequestDto;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/ActivityDataRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessage", "Lzendesk/conversationkit/android/internal/rest/model/SendMessageResponseDto;", "sendMessageRequestDto", "Lzendesk/conversationkit/android/internal/rest/model/SendMessageRequestDto;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/SendMessageRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAppUserLocale", "updateAppUserLocaleDto", "Lzendesk/conversationkit/android/internal/rest/model/UpdateAppUserLocaleDto;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/UpdateAppUserLocaleDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePushToken", "updatePushTokenDto", "Lzendesk/conversationkit/android/internal/rest/model/UpdatePushTokenDto;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/UpdatePushTokenDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadFile", "Lzendesk/conversationkit/android/internal/rest/model/UploadFileResponseDto;", "authorDto", "Lzendesk/conversationkit/android/internal/rest/model/AuthorDto;", "metadataDto", "Lzendesk/conversationkit/android/internal/rest/model/MetadataDto;", "file", "Lokhttp3/MultipartBody$Part;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/AuthorDto;Lzendesk/conversationkit/android/internal/rest/model/MetadataDto;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SunshineConversationsApi.kt */
public interface SunshineConversationsApi extends SunshineAppUserService {
    @Deprecated
    public static final String APP_ID_PATH = "appId";
    @Deprecated
    public static final String APP_USER_ID_PATH = "appUserId";
    @Deprecated
    public static final String AUTHORIZATION_HEADER = "Authorization";
    @Deprecated
    public static final String CONVERSATION_ID_PATH = "conversationId";
    public static final /* synthetic */ Companion Companion = Companion.$$INSTANCE;
    @Deprecated
    public static final String JSON_CONTENT_TYPE = "Content-Type:application/json";

    @POST("v2/apps/{appId}/appusers")
    @Headers({"Content-Type:application/json"})
    Object createAppUser(@Path("appId") String str, @Header("x-smooch-clientid") String str2, @Body AppUserRequestDto appUserRequestDto, Continuation<? super AppUserResponseDto> continuation);

    @POST("v2/apps/{appId}/appusers/{appUserId}/conversations")
    @Headers({"Content-Type:application/json"})
    Object createConversation(@Header("Authorization") String str, @Path("appId") String str2, @Path("appUserId") String str3, @Body CreateConversationRequestDto createConversationRequestDto, Continuation<? super ConversationResponseDto> continuation);

    @GET("v2/apps/{appId}/appusers/{appUserId}")
    @Headers({"Content-Type:application/json"})
    Object getAppUser(@Header("Authorization") String str, @Path("appId") String str2, @Path("appUserId") String str3, Continuation<? super AppUserResponseDto> continuation);

    @GET("sdk/v2/integrations/{integrationId}/config")
    @Headers({"Content-Type:application/json"})
    Object getConfig(@Path("integrationId") String str, Continuation<? super ConfigResponseDto> continuation);

    @GET("v2/apps/{appId}/conversations/{conversationId}")
    @Headers({"Content-Type:application/json"})
    Object getConversation(@Header("Authorization") String str, @Path("appId") String str2, @Path("conversationId") String str3, Continuation<? super ConversationResponseDto> continuation);

    @GET("v2/apps/{appId}/conversations/{conversationId}/messages")
    @Headers({"Content-Type:application/json"})
    Object getMessages(@Header("Authorization") String str, @Path("appId") String str2, @Path("conversationId") String str3, @Query("before") double d, Continuation<? super MessageListResponseDto> continuation);

    @POST("v2/apps/{appId}/conversations/{conversationId}/activity")
    @Headers({"Content-Type:application/json"})
    Object sendActivityData(@Header("Authorization") String str, @Path("appId") String str2, @Path("conversationId") String str3, @Body ActivityDataRequestDto activityDataRequestDto, Continuation<? super Unit> continuation);

    @POST("v2/apps/{appId}/conversations/{conversationId}/messages")
    @Headers({"Content-Type:application/json"})
    Object sendMessage(@Header("Authorization") String str, @Path("appId") String str2, @Path("conversationId") String str3, @Body SendMessageRequestDto sendMessageRequestDto, Continuation<? super SendMessageResponseDto> continuation);

    @PUT("v2/apps/{appId}/appusers/{appUserId}")
    @Headers({"Content-Type:application/json"})
    Object updateAppUserLocale(@Header("Authorization") String str, @Path("appId") String str2, @Path("appUserId") String str3, @Body UpdateAppUserLocaleDto updateAppUserLocaleDto, Continuation<? super Unit> continuation);

    @PUT("v2/apps/{appId}/appusers/{appUserId}/clients/{clientId}")
    @Headers({"Content-Type:application/json"})
    Object updatePushToken(@Header("Authorization") String str, @Path("appId") String str2, @Path("appUserId") String str3, @Path("clientId") String str4, @Body UpdatePushTokenDto updatePushTokenDto, Continuation<? super Unit> continuation);

    @POST("v2/apps/{appId}/conversations/{conversationId}/files")
    @Multipart
    Object uploadFile(@Header("Authorization") String str, @Path("appId") String str2, @Path("conversationId") String str3, @Part("author") AuthorDto authorDto, @Part("message") MetadataDto metadataDto, @Part MultipartBody.Part part, Continuation<? super UploadFileResponseDto> continuation);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/SunshineConversationsApi$Companion;", "", "()V", "APP_ID_PATH", "", "APP_USER_ID_PATH", "AUTHORIZATION_HEADER", "CONVERSATION_ID_PATH", "JSON_CONTENT_TYPE", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SunshineConversationsApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String APP_ID_PATH = "appId";
        public static final String APP_USER_ID_PATH = "appUserId";
        public static final String AUTHORIZATION_HEADER = "Authorization";
        public static final String CONVERSATION_ID_PATH = "conversationId";
        public static final String JSON_CONTENT_TYPE = "Content-Type:application/json";

        private Companion() {
        }
    }
}
