package zendesk.conversationkit.android.internal.rest;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.ActivityDataRequestDto;
import zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto;
import zendesk.conversationkit.android.internal.rest.model.ConversationResponseDto;
import zendesk.conversationkit.android.internal.rest.model.CreateConversationRequestDto;
import zendesk.conversationkit.android.internal.rest.model.MessageListResponseDto;
import zendesk.conversationkit.android.internal.rest.model.SendMessageRequestDto;
import zendesk.conversationkit.android.internal.rest.model.SendMessageResponseDto;
import zendesk.conversationkit.android.internal.rest.model.UpdateAppUserLocaleDto;
import zendesk.conversationkit.android.internal.rest.model.UpdatePushTokenDto;
import zendesk.conversationkit.android.internal.rest.user.model.LoginRequestBody;
import zendesk.conversationkit.android.internal.rest.user.model.LogoutRequestBody;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J)\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ)\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010$J)\u0010%\u001a\u00020!2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H@ø\u0001\u0000¢\u0006\u0002\u0010(J)\u0010)\u001a\u00020*2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H@ø\u0001\u0000¢\u0006\u0002\u0010-J!\u0010.\u001a\u00020!2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u00101J)\u00102\u001a\u00020!2\u0006\u0010\f\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u000205H@ø\u0001\u0000¢\u0006\u0002\u00106J)\u00107\u001a\u0002082\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u00109\u001a\u00020:H@ø\u0001\u0000¢\u0006\u0002\u0010;R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006<"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/UserRestClient;", "", "appId", "", "appUserId", "sunshineConversationsApi", "Lzendesk/conversationkit/android/internal/rest/SunshineConversationsApi;", "restClientFiles", "Lzendesk/conversationkit/android/internal/rest/RestClientFiles;", "(Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/SunshineConversationsApi;Lzendesk/conversationkit/android/internal/rest/RestClientFiles;)V", "createConversation", "Lzendesk/conversationkit/android/internal/rest/model/ConversationResponseDto;", "authorization", "createConversationRequestDto", "Lzendesk/conversationkit/android/internal/rest/model/CreateConversationRequestDto;", "(Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/CreateConversationRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppUser", "Lzendesk/conversationkit/android/internal/rest/model/AppUserResponseDto;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConversation", "conversationId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessages", "Lzendesk/conversationkit/android/internal/rest/model/MessageListResponseDto;", "beforeTimestamp", "", "(Ljava/lang/String;Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginAppUser", "jwt", "loginRequestBody", "Lzendesk/conversationkit/android/internal/rest/user/model/LoginRequestBody;", "(Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/user/model/LoginRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logoutAppUser", "", "logoutRequestBody", "Lzendesk/conversationkit/android/internal/rest/user/model/LogoutRequestBody;", "(Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/user/model/LogoutRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendActivityData", "activityDataDto", "Lzendesk/conversationkit/android/internal/rest/model/ActivityDataRequestDto;", "(Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/ActivityDataRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessage", "Lzendesk/conversationkit/android/internal/rest/model/SendMessageResponseDto;", "sendMessageRequestDto", "Lzendesk/conversationkit/android/internal/rest/model/SendMessageRequestDto;", "(Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/SendMessageRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAppUserLocale", "updateAppUserLocaleDto", "Lzendesk/conversationkit/android/internal/rest/model/UpdateAppUserLocaleDto;", "(Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/UpdateAppUserLocaleDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePushToken", "clientId", "updatePushTokenDto", "Lzendesk/conversationkit/android/internal/rest/model/UpdatePushTokenDto;", "(Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/UpdatePushTokenDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadFile", "Lzendesk/conversationkit/android/internal/rest/model/UploadFileResponseDto;", "uploadFileDto", "Lzendesk/conversationkit/android/internal/rest/model/UploadFileDto;", "(Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/UploadFileDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserRestClient.kt */
public final class UserRestClient {
    private final String appId;
    private final String appUserId;
    private final RestClientFiles restClientFiles;
    private final SunshineConversationsApi sunshineConversationsApi;

    public UserRestClient(String str, String str2, SunshineConversationsApi sunshineConversationsApi2, RestClientFiles restClientFiles2) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "appUserId");
        Intrinsics.checkNotNullParameter(sunshineConversationsApi2, "sunshineConversationsApi");
        Intrinsics.checkNotNullParameter(restClientFiles2, "restClientFiles");
        this.appId = str;
        this.appUserId = str2;
        this.sunshineConversationsApi = sunshineConversationsApi2;
        this.restClientFiles = restClientFiles2;
    }

    public final Object getAppUser(String str, Continuation<? super AppUserResponseDto> continuation) {
        return this.sunshineConversationsApi.getAppUser(str, this.appId, this.appUserId, continuation);
    }

    public final Object createConversation(String str, CreateConversationRequestDto createConversationRequestDto, Continuation<? super ConversationResponseDto> continuation) {
        return this.sunshineConversationsApi.createConversation(str, this.appId, this.appUserId, createConversationRequestDto, continuation);
    }

    public final Object getConversation(String str, String str2, Continuation<? super ConversationResponseDto> continuation) {
        return this.sunshineConversationsApi.getConversation(str, this.appId, str2, continuation);
    }

    public final Object getMessages(String str, String str2, double d, Continuation<? super MessageListResponseDto> continuation) {
        return this.sunshineConversationsApi.getMessages(str, this.appId, str2, d, continuation);
    }

    public final Object sendMessage(String str, String str2, SendMessageRequestDto sendMessageRequestDto, Continuation<? super SendMessageResponseDto> continuation) {
        return this.sunshineConversationsApi.sendMessage(str, this.appId, str2, sendMessageRequestDto, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: zendesk.conversationkit.android.internal.rest.model.UploadFileDto} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object uploadFile(java.lang.String r11, java.lang.String r12, zendesk.conversationkit.android.internal.rest.model.UploadFileDto r13, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.rest.model.UploadFileResponseDto> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof zendesk.conversationkit.android.internal.rest.UserRestClient$uploadFile$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            zendesk.conversationkit.android.internal.rest.UserRestClient$uploadFile$1 r0 = (zendesk.conversationkit.android.internal.rest.UserRestClient$uploadFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.rest.UserRestClient$uploadFile$1 r0 = new zendesk.conversationkit.android.internal.rest.UserRestClient$uploadFile$1
            r0.<init>(r10, r14)
        L_0x0019:
            r8 = r0
            java.lang.Object r14 = r8.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L_0x003c
            if (r1 != r2) goto L_0x0034
            java.lang.Object r11 = r8.L$1
            r13 = r11
            zendesk.conversationkit.android.internal.rest.model.UploadFileDto r13 = (zendesk.conversationkit.android.internal.rest.model.UploadFileDto) r13
            java.lang.Object r11 = r8.L$0
            zendesk.conversationkit.android.internal.rest.UserRestClient r11 = (zendesk.conversationkit.android.internal.rest.UserRestClient) r11
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0097
        L_0x0034:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r14)
            zendesk.conversationkit.android.internal.rest.RestClientFiles r14 = r10.restClientFiles
            zendesk.conversationkit.android.internal.rest.model.Upload r1 = r13.getUpload()
            java.lang.String r1 = r1.getUri()
            zendesk.conversationkit.android.internal.rest.model.Upload r3 = r13.getUpload()
            java.lang.String r3 = r3.getName()
            java.io.File r14 = r14.getUploadFileForUri(r1, r3)
            okhttp3.MediaType$Companion r1 = okhttp3.MediaType.Companion
            zendesk.conversationkit.android.internal.rest.model.Upload r3 = r13.getUpload()
            java.lang.String r3 = r3.getMimeType()
            okhttp3.MediaType r1 = r1.parse(r3)
            zendesk.conversationkit.android.internal.rest.UserRestClient$uploadFile$uploadRequestBody$1 r3 = new zendesk.conversationkit.android.internal.rest.UserRestClient$uploadFile$uploadRequestBody$1
            r3.<init>(r14, r1)
            zendesk.conversationkit.android.internal.rest.SunshineConversationsApi r1 = r10.sunshineConversationsApi
            java.lang.String r14 = r10.appId
            zendesk.conversationkit.android.internal.rest.model.AuthorDto r5 = r13.getAuthor()
            zendesk.conversationkit.android.internal.rest.model.MetadataDto r6 = r13.getMetadata()
            okhttp3.MultipartBody$Part$Companion r4 = okhttp3.MultipartBody.Part.Companion
            zendesk.conversationkit.android.internal.rest.model.Upload r7 = r13.getUpload()
            java.lang.String r7 = r7.getName()
            okhttp3.RequestBody r3 = (okhttp3.RequestBody) r3
            java.lang.String r9 = "source"
            okhttp3.MultipartBody$Part r7 = r4.createFormData(r9, r7, r3)
            r8.L$0 = r10
            r8.L$1 = r13
            r8.label = r2
            r2 = r11
            r3 = r14
            r4 = r12
            java.lang.Object r14 = r1.uploadFile(r2, r3, r4, r5, r6, r7, r8)
            if (r14 != r0) goto L_0x0096
            return r0
        L_0x0096:
            r11 = r10
        L_0x0097:
            zendesk.conversationkit.android.internal.rest.model.UploadFileResponseDto r14 = (zendesk.conversationkit.android.internal.rest.model.UploadFileResponseDto) r14
            zendesk.conversationkit.android.internal.rest.RestClientFiles r11 = r11.restClientFiles
            zendesk.conversationkit.android.internal.rest.model.Upload r12 = r13.getUpload()
            java.lang.String r12 = r12.getName()
            r11.cleanUpUpload(r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.rest.UserRestClient.uploadFile(java.lang.String, java.lang.String, zendesk.conversationkit.android.internal.rest.model.UploadFileDto, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object updatePushToken(String str, String str2, UpdatePushTokenDto updatePushTokenDto, Continuation<? super Unit> continuation) {
        Object updatePushToken = this.sunshineConversationsApi.updatePushToken(str, this.appId, this.appUserId, str2, updatePushTokenDto, continuation);
        return updatePushToken == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updatePushToken : Unit.INSTANCE;
    }

    public final Object sendActivityData(String str, String str2, ActivityDataRequestDto activityDataRequestDto, Continuation<? super Unit> continuation) {
        Object sendActivityData = this.sunshineConversationsApi.sendActivityData(str, this.appId, str2, activityDataRequestDto, continuation);
        return sendActivityData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendActivityData : Unit.INSTANCE;
    }

    public final Object updateAppUserLocale(String str, UpdateAppUserLocaleDto updateAppUserLocaleDto, Continuation<? super Unit> continuation) {
        Object updateAppUserLocale = this.sunshineConversationsApi.updateAppUserLocale(str, this.appId, this.appUserId, updateAppUserLocaleDto, continuation);
        return updateAppUserLocale == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateAppUserLocale : Unit.INSTANCE;
    }

    public final Object loginAppUser(String str, LoginRequestBody loginRequestBody, Continuation<? super AppUserResponseDto> continuation) {
        return this.sunshineConversationsApi.loginAppUser(this.appId, "Bearer " + str, loginRequestBody, continuation);
    }

    public final Object logoutAppUser(String str, String str2, LogoutRequestBody logoutRequestBody, Continuation<? super Unit> continuation) {
        Object logoutAppUser = this.sunshineConversationsApi.logoutAppUser(this.appId, str2, "Bearer " + str, logoutRequestBody, continuation);
        return logoutAppUser == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? logoutAppUser : Unit.INSTANCE;
    }
}
