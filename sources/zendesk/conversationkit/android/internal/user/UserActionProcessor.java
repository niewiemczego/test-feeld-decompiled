package zendesk.conversationkit.android.internal.user;

import com.squareup.moshi.Moshi;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import zendesk.conversationkit.android.ConversationKitSettings;
import zendesk.conversationkit.android.internal.Action;
import zendesk.conversationkit.android.internal.ActionProcessor;
import zendesk.conversationkit.android.internal.ClientDtoProvider;
import zendesk.conversationkit.android.internal.ConversationKitStorage;
import zendesk.conversationkit.android.internal.Effect;
import zendesk.conversationkit.android.internal.app.AppStorage;
import zendesk.conversationkit.android.internal.faye.SunCoFayeClient;
import zendesk.conversationkit.android.internal.proactivemessaging.ProactiveMessagingStorage;
import zendesk.conversationkit.android.internal.rest.RestClientFiles;
import zendesk.conversationkit.android.internal.rest.UserRestClient;
import zendesk.conversationkit.android.internal.user.Jwt;
import zendesk.conversationkit.android.model.ActivityData;
import zendesk.conversationkit.android.model.ActivityEvent;
import zendesk.conversationkit.android.model.AuthorType;
import zendesk.conversationkit.android.model.Config;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.conversationkit.android.model.ConversationType;
import zendesk.conversationkit.android.model.User;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000è\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H@ø\u0001\u0000¢\u0006\u0002\u0010-J\u001b\u0010.\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,H@ø\u0001\u0000¢\u0006\u0002\u0010-J\"\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\"2\u0006\u00104\u001a\u000205H\u0002J\u0019\u00106\u001a\u0002072\u0006\u00101\u001a\u000202H@ø\u0001\u0000¢\u0006\u0002\u00108J!\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020=H@ø\u0001\u0000¢\u0006\u0002\u0010>J\u0019\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010AJ!\u0010B\u001a\u00020C2\u0006\u0010@\u001a\u00020!2\u0006\u0010D\u001a\u00020EH@ø\u0001\u0000¢\u0006\u0002\u0010FJ\u001b\u0010G\u001a\u0004\u0018\u00010\"2\u0006\u0010@\u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0019\u0010H\u001a\u0002002\u0006\u00104\u001a\u000205H@ø\u0001\u0000¢\u0006\u0002\u0010IJ\u0019\u0010J\u001a\u0002002\u0006\u00101\u001a\u00020KH@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u0019\u0010M\u001a\u0002002\u0006\u00101\u001a\u00020NH@ø\u0001\u0000¢\u0006\u0002\u0010OJ\u0019\u0010P\u001a\u0002002\u0006\u00101\u001a\u00020QH@ø\u0001\u0000¢\u0006\u0002\u0010RJ\u0019\u0010S\u001a\u0002002\u0006\u00101\u001a\u00020TH@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u0019\u0010V\u001a\u0002002\u0006\u0010W\u001a\u00020XH@ø\u0001\u0000¢\u0006\u0002\u0010YJ\u0011\u0010Z\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u0010[J\u0011\u0010\\\u001a\u00020]H@ø\u0001\u0000¢\u0006\u0002\u0010[J\u0019\u0010^\u001a\u0002002\u0006\u00101\u001a\u00020_H@ø\u0001\u0000¢\u0006\u0002\u0010`J\u0019\u0010a\u001a\u0002002\u0006\u00101\u001a\u00020bH@ø\u0001\u0000¢\u0006\u0002\u0010cJ\u0011\u0010d\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u0010[J\u0019\u0010e\u001a\u0002002\u0006\u00101\u001a\u00020fH@ø\u0001\u0000¢\u0006\u0002\u0010gJ\u0019\u0010h\u001a\u0002002\u0006\u00101\u001a\u00020iH@ø\u0001\u0000¢\u0006\u0002\u0010jJ\u0011\u0010k\u001a\u00020lH@ø\u0001\u0000¢\u0006\u0002\u0010[J\u0019\u0010m\u001a\u0002002\u0006\u00101\u001a\u00020nH@ø\u0001\u0000¢\u0006\u0002\u0010oJ\u0010\u0010p\u001a\u0002002\u0006\u00101\u001a\u00020qH\u0002J\u0010\u0010r\u001a\u0002002\u0006\u00101\u001a\u00020sH\u0002J\u0019\u0010t\u001a\u0002002\u0006\u00101\u001a\u00020uH@ø\u0001\u0000¢\u0006\u0002\u0010vJ\u0019\u0010w\u001a\u0002002\u0006\u00101\u001a\u00020xH@ø\u0001\u0000¢\u0006\u0002\u0010yJ\u0011\u0010z\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u0010[J\u0019\u0010{\u001a\u0002002\u0006\u00101\u001a\u000202H@ø\u0001\u0000¢\u0006\u0002\u00108J\"\u0010|\u001a\u0002002\u0006\u0010}\u001a\u00020~2\u0006\u0010\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001c\u0010\u0001\u001a\u0002002\u0007\u00101\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0001\u001a\u0002002\u0006\u0010W\u001a\u00020XH\u0002J\u001c\u0010\u0001\u001a\u0002002\u0007\u00101\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001f\u0010\u0001\u001a\u00030\u00012\n\b\u0002\u00104\u001a\u0004\u0018\u000105H@ø\u0001\u0000¢\u0006\u0002\u0010IJ\u001c\u0010\u0001\u001a\u00030\u00012\u0006\u00103\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001c\u0010\u0001\u001a\u0002002\u0007\u00101\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001a\u0010\u0001\u001a\u00020~2\u0006\u00101\u001a\u000202H@ø\u0001\u0000¢\u0006\u0002\u00108J\u001c\u0010\u0001\u001a\u0004\u0018\u00010\"2\u0006\u00101\u001a\u000202H@ø\u0001\u0000¢\u0006\u0002\u00108J3\u0010\u0001\u001a\u0004\u0018\u00010\"2\u0006\u0010@\u001a\u00020!2\u0014\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020~\u0012\u0004\u0012\u00020~0\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\"2\u0006\u00103\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001c\u0010\u0001\u001a\u0002002\u0007\u00101\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lzendesk/conversationkit/android/internal/user/UserActionProcessor;", "Lzendesk/conversationkit/android/internal/ActionProcessor;", "conversationKitSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "config", "Lzendesk/conversationkit/android/model/Config;", "user", "Lzendesk/conversationkit/android/model/User;", "sunCoFayeClient", "Lzendesk/conversationkit/android/internal/faye/SunCoFayeClient;", "userRestClient", "Lzendesk/conversationkit/android/internal/rest/UserRestClient;", "userStorage", "Lzendesk/conversationkit/android/internal/user/UserStorage;", "appStorage", "Lzendesk/conversationkit/android/internal/app/AppStorage;", "conversationKitStorage", "Lzendesk/conversationkit/android/internal/ConversationKitStorage;", "proactiveMessagingStorage", "Lzendesk/conversationkit/android/internal/proactivemessaging/ProactiveMessagingStorage;", "restClientFiles", "Lzendesk/conversationkit/android/internal/rest/RestClientFiles;", "clientDtoProvider", "Lzendesk/conversationkit/android/internal/ClientDtoProvider;", "jwtDecoder", "Lzendesk/conversationkit/android/internal/user/Jwt$Decoder;", "(Lzendesk/conversationkit/android/ConversationKitSettings;Lzendesk/conversationkit/android/model/Config;Lzendesk/conversationkit/android/model/User;Lzendesk/conversationkit/android/internal/faye/SunCoFayeClient;Lzendesk/conversationkit/android/internal/rest/UserRestClient;Lzendesk/conversationkit/android/internal/user/UserStorage;Lzendesk/conversationkit/android/internal/app/AppStorage;Lzendesk/conversationkit/android/internal/ConversationKitStorage;Lzendesk/conversationkit/android/internal/proactivemessaging/ProactiveMessagingStorage;Lzendesk/conversationkit/android/internal/rest/RestClientFiles;Lzendesk/conversationkit/android/internal/ClientDtoProvider;Lzendesk/conversationkit/android/internal/user/Jwt$Decoder;)V", "getConfig", "()Lzendesk/conversationkit/android/model/Config;", "getConversationKitSettings", "()Lzendesk/conversationkit/android/ConversationKitSettings;", "conversations", "", "", "Lzendesk/conversationkit/android/model/Conversation;", "messageReceivedMutex", "Lkotlinx/coroutines/sync/Mutex;", "sendMessageMutex", "<set-?>", "getUser", "()Lzendesk/conversationkit/android/model/User;", "buildCreateConversationRequestDto", "Lzendesk/conversationkit/android/internal/rest/model/CreateConversationRequestDto;", "conversationType", "Lzendesk/conversationkit/android/model/ConversationType;", "(Lzendesk/conversationkit/android/model/ConversationType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConversationFromNetwork", "createSendMessageFailedResult", "Lzendesk/conversationkit/android/internal/Effect;", "action", "Lzendesk/conversationkit/android/internal/Action$SendMessage;", "conversation", "throwable", "", "createSendMessageRequestDto", "Lzendesk/conversationkit/android/internal/rest/model/SendMessageRequestDto;", "(Lzendesk/conversationkit/android/internal/Action$SendMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUploadFileRequestDto", "Lzendesk/conversationkit/android/internal/rest/model/UploadFileDto;", "localId", "messageContent", "Lzendesk/conversationkit/android/model/MessageContent$FileUpload;", "(Ljava/lang/String;Lzendesk/conversationkit/android/model/MessageContent$FileUpload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConversationFromNetwork", "conversationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessagesFromNetwork", "Lzendesk/conversationkit/android/model/MessageList;", "beforeTimestamp", "", "(Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPersistedConversation", "handleUnauthorized", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preparePushToken", "Lzendesk/conversationkit/android/internal/Action$PreparePushToken;", "(Lzendesk/conversationkit/android/internal/Action$PreparePushToken;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "process", "Lzendesk/conversationkit/android/internal/Action;", "(Lzendesk/conversationkit/android/internal/Action;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processActivityEventReceived", "Lzendesk/conversationkit/android/internal/Action$ActivityEventReceived;", "(Lzendesk/conversationkit/android/internal/Action$ActivityEventReceived;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processAddProactiveMessage", "Lzendesk/conversationkit/android/internal/Action$AddProactiveMessage;", "(Lzendesk/conversationkit/android/internal/Action$AddProactiveMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processConversationReadActivity", "activityEvent", "Lzendesk/conversationkit/android/model/ActivityEvent;", "(Lzendesk/conversationkit/android/model/ActivityEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCreateConversation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCreateUser", "Lzendesk/conversationkit/android/internal/Effect$CreateUserResult;", "processGetConversation", "Lzendesk/conversationkit/android/internal/Action$GetConversation;", "(Lzendesk/conversationkit/android/internal/Action$GetConversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processGetProactiveMessage", "Lzendesk/conversationkit/android/internal/Action$GetProactiveMessage;", "(Lzendesk/conversationkit/android/internal/Action$GetProactiveMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processGetVisitTypeReceived", "processLoadMoreMessages", "Lzendesk/conversationkit/android/internal/Action$LoadMoreMessages;", "(Lzendesk/conversationkit/android/internal/Action$LoadMoreMessages;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processLoginUser", "Lzendesk/conversationkit/android/internal/Action$LoginUser;", "(Lzendesk/conversationkit/android/internal/Action$LoginUser;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processLogoutUser", "Lzendesk/conversationkit/android/internal/Effect$LogoutUserResult;", "processMessageReceived", "Lzendesk/conversationkit/android/internal/Action$MessageReceived;", "(Lzendesk/conversationkit/android/internal/Action$MessageReceived;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNetworkConnectionStatusUpdate", "Lzendesk/conversationkit/android/internal/Action$NetworkConnectionStatusUpdate;", "processPersistedUserRetrieved", "Lzendesk/conversationkit/android/internal/Action$PersistedUserRetrieve;", "processPrepareMessage", "Lzendesk/conversationkit/android/internal/Action$PrepareMessage;", "(Lzendesk/conversationkit/android/internal/Action$PrepareMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processRefreshConversation", "Lzendesk/conversationkit/android/internal/Action$RefreshConversation;", "(Lzendesk/conversationkit/android/internal/Action$RefreshConversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processRefreshUser", "processSendMessage", "processSentFileMessageReceived", "message", "Lzendesk/conversationkit/android/model/Message;", "persistedConversation", "(Lzendesk/conversationkit/android/model/Message;Lzendesk/conversationkit/android/model/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processSetVisitTypeReceived", "Lzendesk/conversationkit/android/internal/Action$SetVisitType;", "(Lzendesk/conversationkit/android/internal/Action$SetVisitType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processTypingActivity", "processUpdateAppUserLocale", "Lzendesk/conversationkit/android/internal/Action$UpdateAppUserLocale;", "(Lzendesk/conversationkit/android/internal/Action$UpdateAppUserLocale;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revokeUser", "Lzendesk/conversationkit/android/internal/Effect$UserAccessRevoked;", "saveConversation", "", "(Lzendesk/conversationkit/android/model/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendActivityData", "Lzendesk/conversationkit/android/internal/Action$SendActivityData;", "(Lzendesk/conversationkit/android/internal/Action$SendActivityData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessageRestRequest", "transformFailedMessage", "transformPersistedConversation", "messageTransformation", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConversationInMemory", "updatePushToken", "Lzendesk/conversationkit/android/internal/Action$UpdatePushToken;", "(Lzendesk/conversationkit/android/internal/Action$UpdatePushToken;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserActionProcessor.kt */
public final class UserActionProcessor implements ActionProcessor {
    private static final double BEFORE_TIMESTAMP = 0.0d;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "UserActionProcessor";
    private final AppStorage appStorage;
    private final ClientDtoProvider clientDtoProvider;
    private final Config config;
    private final ConversationKitSettings conversationKitSettings;
    private final ConversationKitStorage conversationKitStorage;
    private final Map<String, Conversation> conversations;
    private final Jwt.Decoder jwtDecoder;
    private final Mutex messageReceivedMutex;
    private final ProactiveMessagingStorage proactiveMessagingStorage;
    private final RestClientFiles restClientFiles;
    private final Mutex sendMessageMutex;
    private final SunCoFayeClient sunCoFayeClient;
    private User user;
    private final UserRestClient userRestClient;
    private final UserStorage userStorage;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UserActionProcessor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AuthorType.values().length];
            iArr[AuthorType.USER.ordinal()] = 1;
            iArr[AuthorType.BUSINESS.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public UserActionProcessor(ConversationKitSettings conversationKitSettings2, Config config2, User user2, SunCoFayeClient sunCoFayeClient2, UserRestClient userRestClient2, UserStorage userStorage2, AppStorage appStorage2, ConversationKitStorage conversationKitStorage2, ProactiveMessagingStorage proactiveMessagingStorage2, RestClientFiles restClientFiles2, ClientDtoProvider clientDtoProvider2, Jwt.Decoder decoder) {
        Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
        Intrinsics.checkNotNullParameter(config2, "config");
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(sunCoFayeClient2, "sunCoFayeClient");
        Intrinsics.checkNotNullParameter(userRestClient2, "userRestClient");
        Intrinsics.checkNotNullParameter(userStorage2, "userStorage");
        Intrinsics.checkNotNullParameter(appStorage2, "appStorage");
        Intrinsics.checkNotNullParameter(conversationKitStorage2, "conversationKitStorage");
        Intrinsics.checkNotNullParameter(proactiveMessagingStorage2, "proactiveMessagingStorage");
        Intrinsics.checkNotNullParameter(restClientFiles2, "restClientFiles");
        Intrinsics.checkNotNullParameter(clientDtoProvider2, "clientDtoProvider");
        Intrinsics.checkNotNullParameter(decoder, "jwtDecoder");
        this.conversationKitSettings = conversationKitSettings2;
        this.config = config2;
        this.sunCoFayeClient = sunCoFayeClient2;
        this.userRestClient = userRestClient2;
        this.userStorage = userStorage2;
        this.appStorage = appStorage2;
        this.conversationKitStorage = conversationKitStorage2;
        this.proactiveMessagingStorage = proactiveMessagingStorage2;
        this.restClientFiles = restClientFiles2;
        this.clientDtoProvider = clientDtoProvider2;
        this.jwtDecoder = decoder;
        this.user = user2;
        this.conversations = new HashMap();
        this.messageReceivedMutex = MutexKt.Mutex$default(false, 1, (Object) null);
        this.sendMessageMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    }

    public final ConversationKitSettings getConversationKitSettings() {
        return this.conversationKitSettings;
    }

    public final Config getConfig() {
        return this.config;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserActionProcessor(ConversationKitSettings conversationKitSettings2, Config config2, User user2, SunCoFayeClient sunCoFayeClient2, UserRestClient userRestClient2, UserStorage userStorage2, AppStorage appStorage2, ConversationKitStorage conversationKitStorage2, ProactiveMessagingStorage proactiveMessagingStorage2, RestClientFiles restClientFiles2, ClientDtoProvider clientDtoProvider2, Jwt.Decoder decoder, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(conversationKitSettings2, config2, user2, sunCoFayeClient2, userRestClient2, userStorage2, appStorage2, conversationKitStorage2, proactiveMessagingStorage2, restClientFiles2, clientDtoProvider2, (i & 2048) != 0 ? new Jwt.Decoder((Moshi) null, 1, (DefaultConstructorMarker) null) : decoder);
    }

    public final User getUser() {
        return this.user;
    }

    public Object process(Action action, Continuation<? super Effect> continuation) {
        if (action instanceof Action.NetworkConnectionStatusUpdate) {
            return processNetworkConnectionStatusUpdate((Action.NetworkConnectionStatusUpdate) action);
        }
        if (Intrinsics.areEqual((Object) action, (Object) Action.StartRealtimeConnection.INSTANCE)) {
            this.sunCoFayeClient.connect();
            return Effect.None.INSTANCE;
        } else if (Intrinsics.areEqual((Object) action, (Object) Action.PauseRealtimeConnection.INSTANCE)) {
            this.sunCoFayeClient.disconnect();
            return Effect.None.INSTANCE;
        } else if (action instanceof Action.RealtimeConnectionStatusUpdate) {
            return new Effect.RealtimeConnectionChanged(((Action.RealtimeConnectionStatusUpdate) action).getConnectionStatus());
        } else {
            if (Intrinsics.areEqual((Object) action, (Object) Action.CreateUser.INSTANCE)) {
                Object processCreateUser = processCreateUser(continuation);
                return processCreateUser == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? processCreateUser : (Effect) processCreateUser;
            } else if (Intrinsics.areEqual((Object) action, (Object) Action.RefreshUser.INSTANCE)) {
                return processRefreshUser(continuation);
            } else {
                if (action instanceof Action.LoginUser) {
                    return processLoginUser((Action.LoginUser) action, continuation);
                }
                if (Intrinsics.areEqual((Object) action, (Object) Action.LogoutUser.INSTANCE)) {
                    Object processLogoutUser = processLogoutUser(continuation);
                    return processLogoutUser == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? processLogoutUser : (Effect) processLogoutUser;
                } else if (action instanceof Action.UpdateAppUserLocale) {
                    return processUpdateAppUserLocale((Action.UpdateAppUserLocale) action, continuation);
                } else {
                    if (action instanceof Action.CreateConversation) {
                        return processCreateConversation(continuation);
                    }
                    if (action instanceof Action.GetConversation) {
                        return processGetConversation((Action.GetConversation) action, continuation);
                    }
                    if (action instanceof Action.RefreshConversation) {
                        return processRefreshConversation((Action.RefreshConversation) action, continuation);
                    }
                    if (action instanceof Action.MessageReceived) {
                        return processMessageReceived((Action.MessageReceived) action, continuation);
                    }
                    if (action instanceof Action.LoadMoreMessages) {
                        return processLoadMoreMessages((Action.LoadMoreMessages) action, continuation);
                    }
                    if (action instanceof Action.PrepareMessage) {
                        return processPrepareMessage((Action.PrepareMessage) action, continuation);
                    }
                    if (action instanceof Action.SendMessage) {
                        return processSendMessage((Action.SendMessage) action, continuation);
                    }
                    if (action instanceof Action.PreparePushToken) {
                        return preparePushToken((Action.PreparePushToken) action, continuation);
                    }
                    if (action instanceof Action.UpdatePushToken) {
                        return updatePushToken((Action.UpdatePushToken) action, continuation);
                    }
                    if (action instanceof Action.SendActivityData) {
                        return sendActivityData((Action.SendActivityData) action, continuation);
                    }
                    if (action instanceof Action.ActivityEventReceived) {
                        return processActivityEventReceived((Action.ActivityEventReceived) action, continuation);
                    }
                    if (action instanceof Action.PersistedUserRetrieve) {
                        return processPersistedUserRetrieved((Action.PersistedUserRetrieve) action);
                    }
                    if (action instanceof Action.GetVisitType) {
                        return processGetVisitTypeReceived(continuation);
                    }
                    if (action instanceof Action.SetVisitType) {
                        return processSetVisitTypeReceived((Action.SetVisitType) action, continuation);
                    }
                    if (action instanceof Action.AddProactiveMessage) {
                        return processAddProactiveMessage((Action.AddProactiveMessage) action, continuation);
                    }
                    if (action instanceof Action.GetProactiveMessage) {
                        return processGetProactiveMessage((Action.GetProactiveMessage) action, continuation);
                    }
                    Logger.w(LOG_TAG, action + " cannot be processed.", new Object[0]);
                    return Effect.IncorrectAccessLevel.INSTANCE;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processSetVisitTypeReceived(zendesk.conversationkit.android.internal.Action.SetVisitType r5, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processSetVisitTypeReceived$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processSetVisitTypeReceived$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processSetVisitTypeReceived$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processSetVisitTypeReceived$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processSetVisitTypeReceived$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0044
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            zendesk.conversationkit.android.internal.ConversationKitStorage r6 = r4.conversationKitStorage
            zendesk.conversationkit.android.model.VisitType r5 = r5.getVisitType()
            r0.label = r3
            java.lang.Object r5 = r6.setVisitType(r5, r0)
            if (r5 != r1) goto L_0x0044
            return r1
        L_0x0044:
            zendesk.conversationkit.android.internal.Effect$None r5 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processSetVisitTypeReceived(zendesk.conversationkit.android.internal.Action$SetVisitType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processGetVisitTypeReceived(kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processGetVisitTypeReceived$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processGetVisitTypeReceived$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processGetVisitTypeReceived$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processGetVisitTypeReceived$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processGetVisitTypeReceived$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            zendesk.conversationkit.android.internal.ConversationKitStorage r5 = r4.conversationKitStorage
            r0.label = r3
            java.lang.Object r5 = r5.getVisitType(r0)
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x0040:
            zendesk.conversationkit.android.model.VisitType r5 = (zendesk.conversationkit.android.model.VisitType) r5
            zendesk.conversationkit.android.internal.Effect$GetVisitType r0 = new zendesk.conversationkit.android.internal.Effect$GetVisitType
            r0.<init>(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processGetVisitTypeReceived(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Effect processNetworkConnectionStatusUpdate(Action.NetworkConnectionStatusUpdate networkConnectionStatusUpdate) {
        return new Effect.NetworkConnectionChanged(networkConnectionStatusUpdate.getConnectionStatus());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processCreateUser(kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect.CreateUserResult> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processCreateUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processCreateUser$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processCreateUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processCreateUser$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processCreateUser$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r1 = r0.L$2
            zendesk.conversationkit.android.ConversationKitResult r1 = (zendesk.conversationkit.android.ConversationKitResult) r1
            java.lang.Object r2 = r0.L$1
            zendesk.conversationkit.android.model.Config r2 = (zendesk.conversationkit.android.model.Config) r2
            java.lang.Object r0 = r0.L$0
            zendesk.conversationkit.android.ConversationKitSettings r0 = (zendesk.conversationkit.android.ConversationKitSettings) r0
            kotlin.ResultKt.throwOnFailure(r9)
            r3 = r1
            r1 = r0
            goto L_0x0066
        L_0x0038:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r9)
            zendesk.conversationkit.android.ConversationKitSettings r9 = r8.conversationKitSettings
            zendesk.conversationkit.android.model.Config r2 = r8.config
            zendesk.conversationkit.android.ConversationKitResult$Failure r4 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            zendesk.conversationkit.android.ConversationKitError$UserAlreadyExists r5 = zendesk.conversationkit.android.ConversationKitError.UserAlreadyExists.INSTANCE
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r4.<init>(r5)
            zendesk.conversationkit.android.ConversationKitResult r4 = (zendesk.conversationkit.android.ConversationKitResult) r4
            zendesk.conversationkit.android.internal.ConversationKitStorage r5 = r8.conversationKitStorage
            r0.L$0 = r9
            r0.L$1 = r2
            r0.L$2 = r4
            r0.label = r3
            java.lang.Object r0 = r5.getClientId(r0)
            if (r0 != r1) goto L_0x0063
            return r1
        L_0x0063:
            r1 = r9
            r9 = r0
            r3 = r4
        L_0x0066:
            r4 = r9
            java.lang.String r4 = (java.lang.String) r4
            r5 = 0
            r6 = 16
            r7 = 0
            zendesk.conversationkit.android.internal.Effect$CreateUserResult r9 = new zendesk.conversationkit.android.internal.Effect$CreateUserResult
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processCreateUser(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: zendesk.conversationkit.android.internal.user.UserActionProcessor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: zendesk.conversationkit.android.internal.user.UserActionProcessor} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r0 = (java.lang.String) r0;
        r11 = r10.conversationKitStorage;
        r2.L$0 = r10;
        r2.L$1 = r9;
        r2.L$2 = r4;
        r2.L$3 = r8;
        r2.L$4 = r0;
        r2.label = 2;
        r11 = r11.getPushToken(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011f, code lost:
        if (r11 != r3) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0121, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0122, code lost:
        r19 = r4;
        r4 = r0;
        r0 = r11;
        r11 = r10;
        r10 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r14 = r10.buildClient(r8, r4, (java.lang.String) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0135, code lost:
        if (r11.user.getSessionToken$zendesk_conversationkit_conversationkit_android() != null) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0137, code lost:
        zendesk.logger.Logger.d(LOG_TAG, "Building login request... [merge=false]", new java.lang.Object[0]);
        r12 = new zendesk.conversationkit.android.internal.rest.user.model.LoginRequestBody(((zendesk.conversationkit.android.internal.user.Jwt) zendesk.conversationkit.android.ConversationKitResultKt.getOrThrow(r11.jwtDecoder.decode(r9.getJwt()))).getExternalId(), r14, (java.lang.String) null, (java.lang.String) null, 12, (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0160, code lost:
        zendesk.logger.Logger.d(LOG_TAG, "Building login request... [merge=true]", new java.lang.Object[0]);
        r0 = new zendesk.conversationkit.android.internal.rest.user.model.LoginRequestBody(((zendesk.conversationkit.android.internal.user.Jwt) zendesk.conversationkit.android.ConversationKitResultKt.getOrThrow(r11.jwtDecoder.decode(r9.getJwt()))).getExternalId(), r14, r11.user.getId(), r11.user.getSessionToken$zendesk_conversationkit_conversationkit_android());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x018c, code lost:
        r4 = r11.userRestClient;
        r8 = r9.getJwt();
        r2.L$0 = r11;
        r2.L$1 = r9;
        r2.L$2 = r11;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.label = 3;
        r0 = r4.loginAppUser(r8, r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01a3, code lost:
        if (r0 != r3) goto L_0x01a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01a5, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01a6, code lost:
        r8 = r9;
        r4 = r11;
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r8 = zendesk.conversationkit.android.model.UserKt.toUser((zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto) r0, r10.config.getApp().getId(), new zendesk.conversationkit.android.model.AuthenticationType.Jwt(r8.getJwt()));
        r0 = r10.appStorage;
        r2.L$0 = r10;
        r2.L$1 = r8;
        r2.L$2 = r4;
        r2.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01d3, code lost:
        if (r0.setUser(r8, r2) != r3) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01d5, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01d6, code lost:
        r4.user = r8;
        r10.sunCoFayeClient.disconnect();
        r9 = r10.conversationKitSettings;
        r8 = r10.config;
        r4 = new zendesk.conversationkit.android.ConversationKitResult.Success(r10.user);
        r0 = r10.conversationKitStorage;
        r2.L$0 = r10;
        r2.L$1 = r9;
        r2.L$2 = r8;
        r2.L$3 = r4;
        r2.label = 5;
        r0 = r0.getClientId(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01fc, code lost:
        if (r0 != r3) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01fe, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        return new zendesk.conversationkit.android.internal.Effect.LoginUserResult(r9, r8, r4, (java.lang.String) r0);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0235 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processLoginUser(zendesk.conversationkit.android.internal.Action.LoginUser r21, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r22) {
        /*
            r20 = this;
            r1 = r20
            r0 = r22
            boolean r2 = r0 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processLoginUser$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processLoginUser$1 r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processLoginUser$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processLoginUser$1 r2 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processLoginUser$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            r6 = 0
            java.lang.String r7 = "UserActionProcessor"
            switch(r4) {
                case 0: goto L_0x00bc;
                case 1: goto L_0x00a0;
                case 2: goto L_0x007e;
                case 3: goto L_0x006c;
                case 4: goto L_0x005a;
                case 5: goto L_0x0045;
                case 6: goto L_0x0034;
                default: goto L_0x002c;
            }
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0034:
            java.lang.Object r3 = r2.L$2
            zendesk.conversationkit.android.ConversationKitResult r3 = (zendesk.conversationkit.android.ConversationKitResult) r3
            java.lang.Object r4 = r2.L$1
            zendesk.conversationkit.android.model.Config r4 = (zendesk.conversationkit.android.model.Config) r4
            java.lang.Object r2 = r2.L$0
            zendesk.conversationkit.android.ConversationKitSettings r2 = (zendesk.conversationkit.android.ConversationKitSettings) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x023a
        L_0x0045:
            java.lang.Object r4 = r2.L$3
            zendesk.conversationkit.android.ConversationKitResult r4 = (zendesk.conversationkit.android.ConversationKitResult) r4
            java.lang.Object r8 = r2.L$2
            zendesk.conversationkit.android.model.Config r8 = (zendesk.conversationkit.android.model.Config) r8
            java.lang.Object r9 = r2.L$1
            zendesk.conversationkit.android.ConversationKitSettings r9 = (zendesk.conversationkit.android.ConversationKitSettings) r9
            java.lang.Object r10 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r10 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r10
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x00b9 }
            goto L_0x01ff
        L_0x005a:
            java.lang.Object r4 = r2.L$2
            zendesk.conversationkit.android.internal.user.UserActionProcessor r4 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r4
            java.lang.Object r8 = r2.L$1
            zendesk.conversationkit.android.model.User r8 = (zendesk.conversationkit.android.model.User) r8
            java.lang.Object r9 = r2.L$0
            r10 = r9
            zendesk.conversationkit.android.internal.user.UserActionProcessor r10 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r10
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x00b9 }
            goto L_0x01d6
        L_0x006c:
            java.lang.Object r4 = r2.L$2
            zendesk.conversationkit.android.internal.user.UserActionProcessor r4 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r4
            java.lang.Object r8 = r2.L$1
            zendesk.conversationkit.android.internal.Action$LoginUser r8 = (zendesk.conversationkit.android.internal.Action.LoginUser) r8
            java.lang.Object r9 = r2.L$0
            r10 = r9
            zendesk.conversationkit.android.internal.user.UserActionProcessor r10 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r10
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x00b9 }
            goto L_0x01a9
        L_0x007e:
            java.lang.Object r4 = r2.L$4
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r8 = r2.L$3
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r2.L$2
            zendesk.conversationkit.android.internal.ClientDtoProvider r9 = (zendesk.conversationkit.android.internal.ClientDtoProvider) r9
            java.lang.Object r10 = r2.L$1
            zendesk.conversationkit.android.internal.Action$LoginUser r10 = (zendesk.conversationkit.android.internal.Action.LoginUser) r10
            java.lang.Object r11 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r11 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r11
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x009c }
            r19 = r10
            r10 = r9
            r9 = r19
            goto L_0x0129
        L_0x009c:
            r0 = move-exception
            r10 = r11
            goto L_0x020b
        L_0x00a0:
            java.lang.Object r4 = r2.L$3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r8 = r2.L$2
            zendesk.conversationkit.android.internal.ClientDtoProvider r8 = (zendesk.conversationkit.android.internal.ClientDtoProvider) r8
            java.lang.Object r9 = r2.L$1
            zendesk.conversationkit.android.internal.Action$LoginUser r9 = (zendesk.conversationkit.android.internal.Action.LoginUser) r9
            java.lang.Object r10 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r10 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r10
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x00b9 }
            r19 = r8
            r8 = r4
            r4 = r19
            goto L_0x010a
        L_0x00b9:
            r0 = move-exception
            goto L_0x020b
        L_0x00bc:
            kotlin.ResultKt.throwOnFailure(r0)
            zendesk.conversationkit.android.model.User r0 = r1.user
            java.lang.String r0 = r0.getJwt$zendesk_conversationkit_conversationkit_android()
            java.lang.String r4 = r21.getJwt()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x00e5
            java.lang.Object[] r0 = new java.lang.Object[r6]
            java.lang.String r2 = "Login skipped: user with this JWT already logged in"
            zendesk.logger.Logger.w(r7, r2, r0)
            zendesk.conversationkit.android.internal.Effect$AlreadyLoggedInResult r0 = new zendesk.conversationkit.android.internal.Effect$AlreadyLoggedInResult
            zendesk.conversationkit.android.ConversationKitResult$Success r2 = new zendesk.conversationkit.android.ConversationKitResult$Success
            zendesk.conversationkit.android.model.User r3 = r1.user
            r2.<init>(r3)
            zendesk.conversationkit.android.ConversationKitResult r2 = (zendesk.conversationkit.android.ConversationKitResult) r2
            r0.<init>(r2)
            return r0
        L_0x00e5:
            zendesk.conversationkit.android.internal.ClientDtoProvider r0 = r1.clientDtoProvider     // Catch:{ Exception -> 0x0209 }
            zendesk.conversationkit.android.ConversationKitSettings r4 = r1.conversationKitSettings     // Catch:{ Exception -> 0x0209 }
            java.lang.String r4 = r4.getIntegrationId()     // Catch:{ Exception -> 0x0209 }
            zendesk.conversationkit.android.internal.ConversationKitStorage r8 = r1.conversationKitStorage     // Catch:{ Exception -> 0x0209 }
            r2.L$0 = r1     // Catch:{ Exception -> 0x0209 }
            r9 = r21
            r2.L$1 = r9     // Catch:{ Exception -> 0x0209 }
            r2.L$2 = r0     // Catch:{ Exception -> 0x0209 }
            r2.L$3 = r4     // Catch:{ Exception -> 0x0209 }
            r10 = 1
            r2.label = r10     // Catch:{ Exception -> 0x0209 }
            java.lang.Object r8 = r8.getClientId(r2)     // Catch:{ Exception -> 0x0209 }
            if (r8 != r3) goto L_0x0103
            return r3
        L_0x0103:
            r10 = r1
            r19 = r4
            r4 = r0
            r0 = r8
            r8 = r19
        L_0x010a:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00b9 }
            zendesk.conversationkit.android.internal.ConversationKitStorage r11 = r10.conversationKitStorage     // Catch:{ Exception -> 0x00b9 }
            r2.L$0 = r10     // Catch:{ Exception -> 0x00b9 }
            r2.L$1 = r9     // Catch:{ Exception -> 0x00b9 }
            r2.L$2 = r4     // Catch:{ Exception -> 0x00b9 }
            r2.L$3 = r8     // Catch:{ Exception -> 0x00b9 }
            r2.L$4 = r0     // Catch:{ Exception -> 0x00b9 }
            r12 = 2
            r2.label = r12     // Catch:{ Exception -> 0x00b9 }
            java.lang.Object r11 = r11.getPushToken(r2)     // Catch:{ Exception -> 0x00b9 }
            if (r11 != r3) goto L_0x0122
            return r3
        L_0x0122:
            r19 = r4
            r4 = r0
            r0 = r11
            r11 = r10
            r10 = r19
        L_0x0129:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x009c }
            zendesk.conversationkit.android.internal.rest.model.ClientDto r14 = r10.buildClient(r8, r4, r0)     // Catch:{ Exception -> 0x009c }
            zendesk.conversationkit.android.model.User r0 = r11.user     // Catch:{ Exception -> 0x009c }
            java.lang.String r0 = r0.getSessionToken$zendesk_conversationkit_conversationkit_android()     // Catch:{ Exception -> 0x009c }
            if (r0 != 0) goto L_0x0160
            java.lang.String r0 = "Building login request... [merge=false]"
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x009c }
            zendesk.logger.Logger.d(r7, r0, r4)     // Catch:{ Exception -> 0x009c }
            zendesk.conversationkit.android.internal.rest.user.model.LoginRequestBody r0 = new zendesk.conversationkit.android.internal.rest.user.model.LoginRequestBody     // Catch:{ Exception -> 0x009c }
            zendesk.conversationkit.android.internal.user.Jwt$Decoder r4 = r11.jwtDecoder     // Catch:{ Exception -> 0x009c }
            java.lang.String r8 = r9.getJwt()     // Catch:{ Exception -> 0x009c }
            zendesk.conversationkit.android.ConversationKitResult r4 = r4.decode(r8)     // Catch:{ Exception -> 0x009c }
            java.lang.Object r4 = zendesk.conversationkit.android.ConversationKitResultKt.getOrThrow(r4)     // Catch:{ Exception -> 0x009c }
            zendesk.conversationkit.android.internal.user.Jwt r4 = (zendesk.conversationkit.android.internal.user.Jwt) r4     // Catch:{ Exception -> 0x009c }
            java.lang.String r13 = r4.getExternalId()     // Catch:{ Exception -> 0x009c }
            r15 = 0
            r16 = 0
            r17 = 12
            r18 = 0
            r12 = r0
            r12.<init>(r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x009c }
            goto L_0x018c
        L_0x0160:
            java.lang.String r0 = "Building login request... [merge=true]"
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x009c }
            zendesk.logger.Logger.d(r7, r0, r4)     // Catch:{ Exception -> 0x009c }
            zendesk.conversationkit.android.internal.rest.user.model.LoginRequestBody r0 = new zendesk.conversationkit.android.internal.rest.user.model.LoginRequestBody     // Catch:{ Exception -> 0x009c }
            zendesk.conversationkit.android.internal.user.Jwt$Decoder r4 = r11.jwtDecoder     // Catch:{ Exception -> 0x009c }
            java.lang.String r8 = r9.getJwt()     // Catch:{ Exception -> 0x009c }
            zendesk.conversationkit.android.ConversationKitResult r4 = r4.decode(r8)     // Catch:{ Exception -> 0x009c }
            java.lang.Object r4 = zendesk.conversationkit.android.ConversationKitResultKt.getOrThrow(r4)     // Catch:{ Exception -> 0x009c }
            zendesk.conversationkit.android.internal.user.Jwt r4 = (zendesk.conversationkit.android.internal.user.Jwt) r4     // Catch:{ Exception -> 0x009c }
            java.lang.String r4 = r4.getExternalId()     // Catch:{ Exception -> 0x009c }
            zendesk.conversationkit.android.model.User r8 = r11.user     // Catch:{ Exception -> 0x009c }
            java.lang.String r8 = r8.getId()     // Catch:{ Exception -> 0x009c }
            zendesk.conversationkit.android.model.User r10 = r11.user     // Catch:{ Exception -> 0x009c }
            java.lang.String r10 = r10.getSessionToken$zendesk_conversationkit_conversationkit_android()     // Catch:{ Exception -> 0x009c }
            r0.<init>(r4, r14, r8, r10)     // Catch:{ Exception -> 0x009c }
        L_0x018c:
            zendesk.conversationkit.android.internal.rest.UserRestClient r4 = r11.userRestClient     // Catch:{ Exception -> 0x009c }
            java.lang.String r8 = r9.getJwt()     // Catch:{ Exception -> 0x009c }
            r2.L$0 = r11     // Catch:{ Exception -> 0x009c }
            r2.L$1 = r9     // Catch:{ Exception -> 0x009c }
            r2.L$2 = r11     // Catch:{ Exception -> 0x009c }
            r2.L$3 = r5     // Catch:{ Exception -> 0x009c }
            r2.L$4 = r5     // Catch:{ Exception -> 0x009c }
            r10 = 3
            r2.label = r10     // Catch:{ Exception -> 0x009c }
            java.lang.Object r0 = r4.loginAppUser(r8, r0, r2)     // Catch:{ Exception -> 0x009c }
            if (r0 != r3) goto L_0x01a6
            return r3
        L_0x01a6:
            r8 = r9
            r4 = r11
            r10 = r4
        L_0x01a9:
            zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto r0 = (zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto) r0     // Catch:{ Exception -> 0x00b9 }
            zendesk.conversationkit.android.model.Config r9 = r10.config     // Catch:{ Exception -> 0x00b9 }
            zendesk.conversationkit.android.model.App r9 = r9.getApp()     // Catch:{ Exception -> 0x00b9 }
            java.lang.String r9 = r9.getId()     // Catch:{ Exception -> 0x00b9 }
            zendesk.conversationkit.android.model.AuthenticationType$Jwt r11 = new zendesk.conversationkit.android.model.AuthenticationType$Jwt     // Catch:{ Exception -> 0x00b9 }
            java.lang.String r8 = r8.getJwt()     // Catch:{ Exception -> 0x00b9 }
            r11.<init>(r8)     // Catch:{ Exception -> 0x00b9 }
            zendesk.conversationkit.android.model.AuthenticationType r11 = (zendesk.conversationkit.android.model.AuthenticationType) r11     // Catch:{ Exception -> 0x00b9 }
            zendesk.conversationkit.android.model.User r8 = zendesk.conversationkit.android.model.UserKt.toUser(r0, r9, r11)     // Catch:{ Exception -> 0x00b9 }
            zendesk.conversationkit.android.internal.app.AppStorage r0 = r10.appStorage     // Catch:{ Exception -> 0x00b9 }
            r2.L$0 = r10     // Catch:{ Exception -> 0x00b9 }
            r2.L$1 = r8     // Catch:{ Exception -> 0x00b9 }
            r2.L$2 = r4     // Catch:{ Exception -> 0x00b9 }
            r9 = 4
            r2.label = r9     // Catch:{ Exception -> 0x00b9 }
            java.lang.Object r0 = r0.setUser(r8, r2)     // Catch:{ Exception -> 0x00b9 }
            if (r0 != r3) goto L_0x01d6
            return r3
        L_0x01d6:
            r4.user = r8     // Catch:{ Exception -> 0x00b9 }
            zendesk.conversationkit.android.internal.faye.SunCoFayeClient r0 = r10.sunCoFayeClient     // Catch:{ Exception -> 0x00b9 }
            r0.disconnect()     // Catch:{ Exception -> 0x00b9 }
            zendesk.conversationkit.android.ConversationKitSettings r9 = r10.conversationKitSettings     // Catch:{ Exception -> 0x00b9 }
            zendesk.conversationkit.android.model.Config r8 = r10.config     // Catch:{ Exception -> 0x00b9 }
            zendesk.conversationkit.android.ConversationKitResult$Success r0 = new zendesk.conversationkit.android.ConversationKitResult$Success     // Catch:{ Exception -> 0x00b9 }
            zendesk.conversationkit.android.model.User r4 = r10.user     // Catch:{ Exception -> 0x00b9 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x00b9 }
            r4 = r0
            zendesk.conversationkit.android.ConversationKitResult r4 = (zendesk.conversationkit.android.ConversationKitResult) r4     // Catch:{ Exception -> 0x00b9 }
            zendesk.conversationkit.android.internal.ConversationKitStorage r0 = r10.conversationKitStorage     // Catch:{ Exception -> 0x00b9 }
            r2.L$0 = r10     // Catch:{ Exception -> 0x00b9 }
            r2.L$1 = r9     // Catch:{ Exception -> 0x00b9 }
            r2.L$2 = r8     // Catch:{ Exception -> 0x00b9 }
            r2.L$3 = r4     // Catch:{ Exception -> 0x00b9 }
            r11 = 5
            r2.label = r11     // Catch:{ Exception -> 0x00b9 }
            java.lang.Object r0 = r0.getClientId(r2)     // Catch:{ Exception -> 0x00b9 }
            if (r0 != r3) goto L_0x01ff
            return r3
        L_0x01ff:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00b9 }
            zendesk.conversationkit.android.internal.Effect$LoginUserResult r11 = new zendesk.conversationkit.android.internal.Effect$LoginUserResult     // Catch:{ Exception -> 0x00b9 }
            r11.<init>(r9, r8, r4, r0)     // Catch:{ Exception -> 0x00b9 }
            zendesk.conversationkit.android.internal.Effect r11 = (zendesk.conversationkit.android.internal.Effect) r11     // Catch:{ Exception -> 0x00b9 }
            goto L_0x0244
        L_0x0209:
            r0 = move-exception
            r10 = r1
        L_0x020b:
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Object[] r4 = new java.lang.Object[r6]
            java.lang.String r6 = "Failed to login"
            zendesk.logger.Logger.e(r7, r6, r0, r4)
            zendesk.conversationkit.android.ConversationKitSettings r4 = r10.conversationKitSettings
            zendesk.conversationkit.android.model.Config r6 = r10.config
            zendesk.conversationkit.android.ConversationKitResult$Failure r7 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r7.<init>(r0)
            r0 = r7
            zendesk.conversationkit.android.ConversationKitResult r0 = (zendesk.conversationkit.android.ConversationKitResult) r0
            zendesk.conversationkit.android.internal.ConversationKitStorage r7 = r10.conversationKitStorage
            r2.L$0 = r4
            r2.L$1 = r6
            r2.L$2 = r0
            r2.L$3 = r5
            r2.L$4 = r5
            r5 = 6
            r2.label = r5
            java.lang.Object r2 = r7.getClientId(r2)
            if (r2 != r3) goto L_0x0236
            return r3
        L_0x0236:
            r3 = r0
            r0 = r2
            r2 = r4
            r4 = r6
        L_0x023a:
            java.lang.String r0 = (java.lang.String) r0
            zendesk.conversationkit.android.internal.Effect$LoginUserResult r5 = new zendesk.conversationkit.android.internal.Effect$LoginUserResult
            r5.<init>(r2, r4, r3, r0)
            r11 = r5
            zendesk.conversationkit.android.internal.Effect r11 = (zendesk.conversationkit.android.internal.Effect) r11
        L_0x0244:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processLoginUser(zendesk.conversationkit.android.internal.Action$LoginUser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0106 A[Catch:{ all -> 0x00a5 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0107 A[Catch:{ all -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012f A[Catch:{ all -> 0x00a5 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x013a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processLogoutUser(kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect.LogoutUserResult> r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            boolean r2 = r0 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processLogoutUser$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processLogoutUser$1 r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processLogoutUser$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processLogoutUser$1 r2 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processLogoutUser$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 5
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            r10 = 0
            if (r4 == 0) goto L_0x00a9
            if (r4 == r9) goto L_0x0083
            if (r4 == r8) goto L_0x0062
            if (r4 == r7) goto L_0x0054
            if (r4 == r6) goto L_0x0048
            if (r4 != r5) goto L_0x0040
            java.lang.Object r2 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0175
        L_0x0040:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0048:
            java.lang.Object r2 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0051 }
            goto L_0x013c
        L_0x0051:
            r0 = move-exception
            goto L_0x014e
        L_0x0054:
            java.lang.Object r4 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r4 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x005e }
            r14 = r4
            goto L_0x0130
        L_0x005e:
            r0 = move-exception
            r2 = r4
            goto L_0x014e
        L_0x0062:
            java.lang.Object r4 = r2.L$6
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r2.L$5
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r8 = r2.L$4
            zendesk.conversationkit.android.internal.ClientDtoProvider r8 = (zendesk.conversationkit.android.internal.ClientDtoProvider) r8
            java.lang.Object r11 = r2.L$3
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r2.L$2
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r2.L$1
            zendesk.conversationkit.android.internal.rest.UserRestClient r13 = (zendesk.conversationkit.android.internal.rest.UserRestClient) r13
            java.lang.Object r14 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r14 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r14
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00a5 }
            goto L_0x010e
        L_0x0083:
            java.lang.Object r4 = r2.L$5
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r2.L$4
            zendesk.conversationkit.android.internal.ClientDtoProvider r5 = (zendesk.conversationkit.android.internal.ClientDtoProvider) r5
            java.lang.Object r11 = r2.L$3
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r2.L$2
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r2.L$1
            zendesk.conversationkit.android.internal.rest.UserRestClient r13 = (zendesk.conversationkit.android.internal.rest.UserRestClient) r13
            java.lang.Object r14 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r14 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r14
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00a5 }
            r16 = r5
            r5 = r4
            r4 = r11
            r11 = r16
            goto L_0x00ec
        L_0x00a5:
            r0 = move-exception
            r2 = r14
            goto L_0x014e
        L_0x00a9:
            kotlin.ResultKt.throwOnFailure(r0)
            zendesk.conversationkit.android.model.User r0 = r1.user
            zendesk.conversationkit.android.model.AuthenticationType r0 = r0.getAuthenticationType()
            boolean r4 = r0 instanceof zendesk.conversationkit.android.model.AuthenticationType.Jwt
            if (r4 == 0) goto L_0x0169
            zendesk.conversationkit.android.internal.rest.UserRestClient r4 = r1.userRestClient     // Catch:{ all -> 0x014c }
            zendesk.conversationkit.android.model.AuthenticationType$Jwt r0 = (zendesk.conversationkit.android.model.AuthenticationType.Jwt) r0     // Catch:{ all -> 0x014c }
            java.lang.String r0 = r0.getValue()     // Catch:{ all -> 0x014c }
            zendesk.conversationkit.android.model.User r5 = r1.user     // Catch:{ all -> 0x014c }
            java.lang.String r5 = r5.getId()     // Catch:{ all -> 0x014c }
            zendesk.conversationkit.android.internal.ClientDtoProvider r11 = r1.clientDtoProvider     // Catch:{ all -> 0x014c }
            zendesk.conversationkit.android.ConversationKitSettings r12 = r1.conversationKitSettings     // Catch:{ all -> 0x014c }
            java.lang.String r12 = r12.getIntegrationId()     // Catch:{ all -> 0x014c }
            zendesk.conversationkit.android.internal.ConversationKitStorage r13 = r1.conversationKitStorage     // Catch:{ all -> 0x014c }
            r2.L$0 = r1     // Catch:{ all -> 0x014c }
            r2.L$1 = r4     // Catch:{ all -> 0x014c }
            r2.L$2 = r0     // Catch:{ all -> 0x014c }
            r2.L$3 = r5     // Catch:{ all -> 0x014c }
            r2.L$4 = r11     // Catch:{ all -> 0x014c }
            r2.L$5 = r12     // Catch:{ all -> 0x014c }
            r2.label = r9     // Catch:{ all -> 0x014c }
            java.lang.Object r13 = r13.getClientId(r2)     // Catch:{ all -> 0x014c }
            if (r13 != r3) goto L_0x00e3
            return r3
        L_0x00e3:
            r14 = r1
            r16 = r12
            r12 = r0
            r0 = r13
            r13 = r4
            r4 = r5
            r5 = r16
        L_0x00ec:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00a5 }
            zendesk.conversationkit.android.internal.ConversationKitStorage r15 = r14.conversationKitStorage     // Catch:{ all -> 0x00a5 }
            r2.L$0 = r14     // Catch:{ all -> 0x00a5 }
            r2.L$1 = r13     // Catch:{ all -> 0x00a5 }
            r2.L$2 = r12     // Catch:{ all -> 0x00a5 }
            r2.L$3 = r4     // Catch:{ all -> 0x00a5 }
            r2.L$4 = r11     // Catch:{ all -> 0x00a5 }
            r2.L$5 = r5     // Catch:{ all -> 0x00a5 }
            r2.L$6 = r0     // Catch:{ all -> 0x00a5 }
            r2.label = r8     // Catch:{ all -> 0x00a5 }
            java.lang.Object r8 = r15.getPushToken(r2)     // Catch:{ all -> 0x00a5 }
            if (r8 != r3) goto L_0x0107
            return r3
        L_0x0107:
            r16 = r4
            r4 = r0
            r0 = r8
            r8 = r11
            r11 = r16
        L_0x010e:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00a5 }
            zendesk.conversationkit.android.internal.rest.model.ClientDto r0 = r8.buildClient(r5, r4, r0)     // Catch:{ all -> 0x00a5 }
            zendesk.conversationkit.android.internal.rest.user.model.LogoutRequestBody r4 = new zendesk.conversationkit.android.internal.rest.user.model.LogoutRequestBody     // Catch:{ all -> 0x00a5 }
            r4.<init>(r0)     // Catch:{ all -> 0x00a5 }
            r2.L$0 = r14     // Catch:{ all -> 0x00a5 }
            r2.L$1 = r10     // Catch:{ all -> 0x00a5 }
            r2.L$2 = r10     // Catch:{ all -> 0x00a5 }
            r2.L$3 = r10     // Catch:{ all -> 0x00a5 }
            r2.L$4 = r10     // Catch:{ all -> 0x00a5 }
            r2.L$5 = r10     // Catch:{ all -> 0x00a5 }
            r2.L$6 = r10     // Catch:{ all -> 0x00a5 }
            r2.label = r7     // Catch:{ all -> 0x00a5 }
            java.lang.Object r0 = r13.logoutAppUser(r12, r11, r4, r2)     // Catch:{ all -> 0x00a5 }
            if (r0 != r3) goto L_0x0130
            return r3
        L_0x0130:
            r2.L$0 = r14     // Catch:{ all -> 0x00a5 }
            r2.label = r6     // Catch:{ all -> 0x00a5 }
            java.lang.Object r0 = revokeUser$default(r14, r10, r2, r9, r10)     // Catch:{ all -> 0x00a5 }
            if (r0 != r3) goto L_0x013b
            return r3
        L_0x013b:
            r2 = r14
        L_0x013c:
            zendesk.conversationkit.android.internal.Effect$UserAccessRevoked r0 = (zendesk.conversationkit.android.internal.Effect.UserAccessRevoked) r0     // Catch:{ all -> 0x0051 }
            zendesk.conversationkit.android.internal.Effect$LogoutUserResult r3 = new zendesk.conversationkit.android.internal.Effect$LogoutUserResult     // Catch:{ all -> 0x0051 }
            zendesk.conversationkit.android.ConversationKitSettings r4 = r2.conversationKitSettings     // Catch:{ all -> 0x0051 }
            zendesk.conversationkit.android.model.Config r5 = r2.config     // Catch:{ all -> 0x0051 }
            zendesk.conversationkit.android.ConversationKitResult r0 = r0.getResult()     // Catch:{ all -> 0x0051 }
            r3.<init>(r4, r5, r0)     // Catch:{ all -> 0x0051 }
            goto L_0x0184
        L_0x014c:
            r0 = move-exception
            r2 = r1
        L_0x014e:
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "UserActionProcessor"
            java.lang.String r5 = "Failed to logout the user"
            zendesk.logger.Logger.e(r4, r5, r0, r3)
            zendesk.conversationkit.android.internal.Effect$LogoutUserResult r3 = new zendesk.conversationkit.android.internal.Effect$LogoutUserResult
            zendesk.conversationkit.android.ConversationKitSettings r4 = r2.conversationKitSettings
            zendesk.conversationkit.android.model.Config r2 = r2.config
            zendesk.conversationkit.android.ConversationKitResult$Failure r5 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r5.<init>(r0)
            zendesk.conversationkit.android.ConversationKitResult r5 = (zendesk.conversationkit.android.ConversationKitResult) r5
            r3.<init>(r4, r2, r5)
            goto L_0x0184
        L_0x0169:
            r2.L$0 = r1
            r2.label = r5
            java.lang.Object r0 = revokeUser$default(r1, r10, r2, r9, r10)
            if (r0 != r3) goto L_0x0174
            return r3
        L_0x0174:
            r2 = r1
        L_0x0175:
            zendesk.conversationkit.android.internal.Effect$UserAccessRevoked r0 = (zendesk.conversationkit.android.internal.Effect.UserAccessRevoked) r0
            zendesk.conversationkit.android.internal.Effect$LogoutUserResult r3 = new zendesk.conversationkit.android.internal.Effect$LogoutUserResult
            zendesk.conversationkit.android.ConversationKitSettings r4 = r2.conversationKitSettings
            zendesk.conversationkit.android.model.Config r2 = r2.config
            zendesk.conversationkit.android.ConversationKitResult r0 = r0.getResult()
            r3.<init>(r4, r2, r0)
        L_0x0184:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processLogoutUser(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e1, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e2, code lost:
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f0, code lost:
        r0.L$0 = null;
        r0.label = 4;
        r12 = r2.handleUnauthorized(r12, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f8, code lost:
        if (r12 == r1) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fa, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010f, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0110, code lost:
        r12 = r12;
        zendesk.logger.Logger.e(LOG_TAG, "GET request for AppUser failed to decode malformed JSON response.", r12, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return new zendesk.conversationkit.android.internal.Effect.RefreshUserResult(new zendesk.conversationkit.android.ConversationKitResult.Failure(r12), (zendesk.conversationkit.android.model.Conversation) null, 2, (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return new zendesk.conversationkit.android.internal.Effect.RefreshUserResult(new zendesk.conversationkit.android.ConversationKitResult.Failure(r12), (zendesk.conversationkit.android.model.Conversation) null, 2, (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:16:0x0044, B:26:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0097 A[Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00aa A[Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bd A[Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cf A[Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010f A[ExcHandler: JsonDataException (r12v2 'e' com.squareup.moshi.JsonDataException A[CUSTOM_DECLARE]), Splitter:B:16:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processRefreshUser(kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processRefreshUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processRefreshUser$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processRefreshUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processRefreshUser$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processRefreshUser$1
            r0.<init>(r11, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            java.lang.String r4 = "UserActionProcessor"
            r5 = 4
            r6 = 3
            r7 = 1
            r8 = 2
            r9 = 0
            if (r2 == 0) goto L_0x005c
            if (r2 == r7) goto L_0x0051
            if (r2 == r8) goto L_0x0049
            if (r2 == r6) goto L_0x0040
            if (r2 != r5) goto L_0x0038
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00fb
        L_0x0038:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0040:
            java.lang.Object r2 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            goto L_0x00cc
        L_0x0049:
            java.lang.Object r2 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            goto L_0x0098
        L_0x0051:
            java.lang.Object r2 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            goto L_0x0073
        L_0x0059:
            r12 = move-exception
            goto L_0x00e3
        L_0x005c:
            kotlin.ResultKt.throwOnFailure(r12)
            zendesk.conversationkit.android.internal.rest.UserRestClient r12 = r11.userRestClient     // Catch:{ JsonDataException -> 0x010f, all -> 0x00e1 }
            zendesk.conversationkit.android.model.User r2 = r11.user     // Catch:{ JsonDataException -> 0x010f, all -> 0x00e1 }
            java.lang.String r2 = zendesk.conversationkit.android.internal.user.UserExtensionsKt.getAuthorization(r2)     // Catch:{ JsonDataException -> 0x010f, all -> 0x00e1 }
            r0.L$0 = r11     // Catch:{ JsonDataException -> 0x010f, all -> 0x00e1 }
            r0.label = r7     // Catch:{ JsonDataException -> 0x010f, all -> 0x00e1 }
            java.lang.Object r12 = r12.getAppUser(r2, r0)     // Catch:{ JsonDataException -> 0x010f, all -> 0x00e1 }
            if (r12 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r2 = r11
        L_0x0073:
            zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto r12 = (zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto) r12     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            zendesk.conversationkit.android.model.Config r7 = r2.config     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            zendesk.conversationkit.android.model.App r7 = r7.getApp()     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            java.lang.String r7 = r7.getId()     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            zendesk.conversationkit.android.model.User r10 = r2.user     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            zendesk.conversationkit.android.model.AuthenticationType r10 = r10.getAuthenticationType()     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            zendesk.conversationkit.android.model.User r12 = zendesk.conversationkit.android.model.UserKt.toUser(r12, r7, r10)     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            r2.user = r12     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            zendesk.conversationkit.android.internal.app.AppStorage r7 = r2.appStorage     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            r0.L$0 = r2     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            r0.label = r8     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            java.lang.Object r12 = r7.setUser(r12, r0)     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            if (r12 != r1) goto L_0x0098
            return r1
        L_0x0098:
            zendesk.conversationkit.android.model.User r12 = r2.user     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            java.util.List r12 = r12.getConversations()     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            java.lang.Iterable r12 = (java.lang.Iterable) r12     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
        L_0x00a4:
            boolean r7 = r12.hasNext()     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            if (r7 == 0) goto L_0x00b8
            java.lang.Object r7 = r12.next()     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            r10 = r7
            zendesk.conversationkit.android.model.Conversation r10 = (zendesk.conversationkit.android.model.Conversation) r10     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            boolean r10 = r10.isDefault()     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            if (r10 == 0) goto L_0x00a4
            goto L_0x00b9
        L_0x00b8:
            r7 = r9
        L_0x00b9:
            zendesk.conversationkit.android.model.Conversation r7 = (zendesk.conversationkit.android.model.Conversation) r7     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            if (r7 == 0) goto L_0x00cf
            java.lang.String r12 = r7.getId()     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            r0.L$0 = r2     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            r0.label = r6     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            java.lang.Object r12 = r2.getPersistedConversation(r12, r0)     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            if (r12 != r1) goto L_0x00cc
            return r1
        L_0x00cc:
            zendesk.conversationkit.android.model.Conversation r12 = (zendesk.conversationkit.android.model.Conversation) r12     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            goto L_0x00d0
        L_0x00cf:
            r12 = r9
        L_0x00d0:
            zendesk.conversationkit.android.internal.Effect$RefreshUserResult r6 = new zendesk.conversationkit.android.internal.Effect$RefreshUserResult     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            zendesk.conversationkit.android.ConversationKitResult$Success r7 = new zendesk.conversationkit.android.ConversationKitResult$Success     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            zendesk.conversationkit.android.model.User r10 = r2.user     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            r7.<init>(r10)     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            zendesk.conversationkit.android.ConversationKitResult r7 = (zendesk.conversationkit.android.ConversationKitResult) r7     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            r6.<init>(r7, r12)     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            zendesk.conversationkit.android.internal.Effect r6 = (zendesk.conversationkit.android.internal.Effect) r6     // Catch:{ JsonDataException -> 0x010f, all -> 0x0059 }
            goto L_0x0128
        L_0x00e1:
            r12 = move-exception
            r2 = r11
        L_0x00e3:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r6 = "Failed to get appUser."
            zendesk.logger.Logger.e(r4, r6, r12, r3)
            boolean r3 = zendesk.conversationkit.android.internal.ErrorKtxKt.isUnauthorizedException(r12)
            if (r3 == 0) goto L_0x00ff
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r12 = r2.handleUnauthorized(r12, r0)
            if (r12 != r1) goto L_0x00fb
            return r1
        L_0x00fb:
            zendesk.conversationkit.android.internal.Effect r12 = (zendesk.conversationkit.android.internal.Effect) r12
            r6 = r12
            goto L_0x0128
        L_0x00ff:
            zendesk.conversationkit.android.internal.Effect$RefreshUserResult r0 = new zendesk.conversationkit.android.internal.Effect$RefreshUserResult
            zendesk.conversationkit.android.ConversationKitResult$Failure r1 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r1.<init>(r12)
            zendesk.conversationkit.android.ConversationKitResult r1 = (zendesk.conversationkit.android.ConversationKitResult) r1
            r0.<init>(r1, r9, r8, r9)
            zendesk.conversationkit.android.internal.Effect r0 = (zendesk.conversationkit.android.internal.Effect) r0
            r6 = r0
            goto L_0x0128
        L_0x010f:
            r12 = move-exception
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r1 = "GET request for AppUser failed to decode malformed JSON response."
            zendesk.logger.Logger.e(r4, r1, r12, r0)
            zendesk.conversationkit.android.internal.Effect$RefreshUserResult r0 = new zendesk.conversationkit.android.internal.Effect$RefreshUserResult
            zendesk.conversationkit.android.ConversationKitResult$Failure r1 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r1.<init>(r12)
            zendesk.conversationkit.android.ConversationKitResult r1 = (zendesk.conversationkit.android.ConversationKitResult) r1
            r0.<init>(r1, r9, r8, r9)
            r6 = r0
            zendesk.conversationkit.android.internal.Effect r6 = (zendesk.conversationkit.android.internal.Effect) r6
        L_0x0128:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processRefreshUser(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processUpdateAppUserLocale(zendesk.conversationkit.android.internal.Action.UpdateAppUserLocale r7, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processUpdateAppUserLocale$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processUpdateAppUserLocale$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processUpdateAppUserLocale$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processUpdateAppUserLocale$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processUpdateAppUserLocale$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            java.lang.String r4 = "UserActionProcessor"
            r5 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r5) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ JsonDataException -> 0x002f, all -> 0x002d }
            goto L_0x0056
        L_0x002d:
            r7 = move-exception
            goto L_0x005b
        L_0x002f:
            r7 = move-exception
            goto L_0x0067
        L_0x0031:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r8)
            zendesk.conversationkit.android.internal.rest.model.UpdateAppUserLocaleDto r8 = new zendesk.conversationkit.android.internal.rest.model.UpdateAppUserLocaleDto     // Catch:{ JsonDataException -> 0x002f, all -> 0x002d }
            java.lang.String r7 = r7.getDeviceLocale()     // Catch:{ JsonDataException -> 0x002f, all -> 0x002d }
            r8.<init>(r7)     // Catch:{ JsonDataException -> 0x002f, all -> 0x002d }
            zendesk.conversationkit.android.internal.rest.UserRestClient r7 = r6.userRestClient     // Catch:{ JsonDataException -> 0x002f, all -> 0x002d }
            zendesk.conversationkit.android.model.User r2 = r6.user     // Catch:{ JsonDataException -> 0x002f, all -> 0x002d }
            java.lang.String r2 = zendesk.conversationkit.android.internal.user.UserExtensionsKt.getAuthorization(r2)     // Catch:{ JsonDataException -> 0x002f, all -> 0x002d }
            r0.label = r5     // Catch:{ JsonDataException -> 0x002f, all -> 0x002d }
            java.lang.Object r7 = r7.updateAppUserLocale(r2, r8, r0)     // Catch:{ JsonDataException -> 0x002f, all -> 0x002d }
            if (r7 != r1) goto L_0x0056
            return r1
        L_0x0056:
            zendesk.conversationkit.android.internal.Effect$None r7 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE     // Catch:{ JsonDataException -> 0x002f, all -> 0x002d }
            zendesk.conversationkit.android.internal.Effect r7 = (zendesk.conversationkit.android.internal.Effect) r7     // Catch:{ JsonDataException -> 0x002f, all -> 0x002d }
            goto L_0x0074
        L_0x005b:
            java.lang.Object[] r8 = new java.lang.Object[r3]
            java.lang.String r0 = "Failed to update app user locale."
            zendesk.logger.Logger.e(r4, r0, r7, r8)
            zendesk.conversationkit.android.internal.Effect$None r7 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE
            zendesk.conversationkit.android.internal.Effect r7 = (zendesk.conversationkit.android.internal.Effect) r7
            goto L_0x0074
        L_0x0067:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object[] r8 = new java.lang.Object[r3]
            java.lang.String r0 = "PUT request for AppUser failed to decode malformed JSON response."
            zendesk.logger.Logger.e(r4, r0, r7, r8)
            zendesk.conversationkit.android.internal.Effect$None r7 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE
            zendesk.conversationkit.android.internal.Effect r7 = (zendesk.conversationkit.android.internal.Effect) r7
        L_0x0074:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processUpdateAppUserLocale(zendesk.conversationkit.android.internal.Action$UpdateAppUserLocale, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0092, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0093, code lost:
        r2 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a1, code lost:
        r0.L$0 = null;
        r0.label = 3;
        r10 = r2.handleUnauthorized(r10, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a9, code lost:
        if (r10 == r1) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ab, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bf, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c0, code lost:
        r10 = r10;
        zendesk.logger.Logger.e(LOG_TAG, "POST request to create conversation failed to decode malformed JSON response.", r10, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return new zendesk.conversationkit.android.internal.Effect.CreateConversationResult(new zendesk.conversationkit.android.ConversationKitResult.Failure(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return new zendesk.conversationkit.android.internal.Effect.CreateConversationResult(new zendesk.conversationkit.android.ConversationKitResult.Failure(r10));
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:15:0x0041, B:22:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007f A[Catch:{ JsonDataException -> 0x00bf, all -> 0x004d }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bf A[ExcHandler: JsonDataException (r10v2 'e' com.squareup.moshi.JsonDataException A[CUSTOM_DECLARE]), Splitter:B:15:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processCreateConversation(kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processCreateConversation$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processCreateConversation$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processCreateConversation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processCreateConversation$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processCreateConversation$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            java.lang.String r4 = "UserActionProcessor"
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 1
            if (r2 == 0) goto L_0x004f
            if (r2 == r8) goto L_0x0045
            if (r2 == r6) goto L_0x003d
            if (r2 != r5) goto L_0x0035
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00ac
        L_0x0035:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x003d:
            java.lang.Object r2 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ JsonDataException -> 0x00bf, all -> 0x004d }
            goto L_0x0080
        L_0x0045:
            java.lang.Object r2 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ JsonDataException -> 0x00bf, all -> 0x004d }
            goto L_0x0073
        L_0x004d:
            r10 = move-exception
            goto L_0x0094
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r10)
            zendesk.conversationkit.android.model.User r10 = r9.user     // Catch:{ JsonDataException -> 0x00bf, all -> 0x0092 }
            java.util.List r10 = r10.getConversations()     // Catch:{ JsonDataException -> 0x00bf, all -> 0x0092 }
            java.util.Collection r10 = (java.util.Collection) r10     // Catch:{ JsonDataException -> 0x00bf, all -> 0x0092 }
            boolean r10 = r10.isEmpty()     // Catch:{ JsonDataException -> 0x00bf, all -> 0x0092 }
            r10 = r10 ^ r8
            if (r10 == 0) goto L_0x0067
            zendesk.conversationkit.android.internal.Effect$None r10 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE     // Catch:{ JsonDataException -> 0x00bf, all -> 0x0092 }
            zendesk.conversationkit.android.internal.Effect r10 = (zendesk.conversationkit.android.internal.Effect) r10     // Catch:{ JsonDataException -> 0x00bf, all -> 0x0092 }
            goto L_0x00d8
        L_0x0067:
            r0.L$0 = r9     // Catch:{ JsonDataException -> 0x00bf, all -> 0x0092 }
            r0.label = r8     // Catch:{ JsonDataException -> 0x00bf, all -> 0x0092 }
            java.lang.Object r10 = createConversationFromNetwork$default(r9, r7, r0, r8, r7)     // Catch:{ JsonDataException -> 0x00bf, all -> 0x0092 }
            if (r10 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r2 = r9
        L_0x0073:
            zendesk.conversationkit.android.model.Conversation r10 = (zendesk.conversationkit.android.model.Conversation) r10     // Catch:{ JsonDataException -> 0x00bf, all -> 0x004d }
            r0.L$0 = r2     // Catch:{ JsonDataException -> 0x00bf, all -> 0x004d }
            r0.label = r6     // Catch:{ JsonDataException -> 0x00bf, all -> 0x004d }
            java.lang.Object r10 = r2.updateConversationInMemory(r10, r0)     // Catch:{ JsonDataException -> 0x00bf, all -> 0x004d }
            if (r10 != r1) goto L_0x0080
            return r1
        L_0x0080:
            zendesk.conversationkit.android.model.Conversation r10 = (zendesk.conversationkit.android.model.Conversation) r10     // Catch:{ JsonDataException -> 0x00bf, all -> 0x004d }
            zendesk.conversationkit.android.internal.Effect$CreateConversationResult r6 = new zendesk.conversationkit.android.internal.Effect$CreateConversationResult     // Catch:{ JsonDataException -> 0x00bf, all -> 0x004d }
            zendesk.conversationkit.android.ConversationKitResult$Success r8 = new zendesk.conversationkit.android.ConversationKitResult$Success     // Catch:{ JsonDataException -> 0x00bf, all -> 0x004d }
            r8.<init>(r10)     // Catch:{ JsonDataException -> 0x00bf, all -> 0x004d }
            zendesk.conversationkit.android.ConversationKitResult r8 = (zendesk.conversationkit.android.ConversationKitResult) r8     // Catch:{ JsonDataException -> 0x00bf, all -> 0x004d }
            r6.<init>(r8)     // Catch:{ JsonDataException -> 0x00bf, all -> 0x004d }
            r10 = r6
            zendesk.conversationkit.android.internal.Effect r10 = (zendesk.conversationkit.android.internal.Effect) r10     // Catch:{ JsonDataException -> 0x00bf, all -> 0x004d }
            goto L_0x00d8
        L_0x0092:
            r10 = move-exception
            r2 = r9
        L_0x0094:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r6 = "Failed to create conversation."
            zendesk.logger.Logger.e(r4, r6, r10, r3)
            boolean r3 = zendesk.conversationkit.android.internal.ErrorKtxKt.isUnauthorizedException(r10)
            if (r3 == 0) goto L_0x00af
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r10 = r2.handleUnauthorized(r10, r0)
            if (r10 != r1) goto L_0x00ac
            return r1
        L_0x00ac:
            zendesk.conversationkit.android.internal.Effect r10 = (zendesk.conversationkit.android.internal.Effect) r10
            goto L_0x00d8
        L_0x00af:
            zendesk.conversationkit.android.internal.Effect$CreateConversationResult r0 = new zendesk.conversationkit.android.internal.Effect$CreateConversationResult
            zendesk.conversationkit.android.ConversationKitResult$Failure r1 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r1.<init>(r10)
            zendesk.conversationkit.android.ConversationKitResult r1 = (zendesk.conversationkit.android.ConversationKitResult) r1
            r0.<init>(r1)
            zendesk.conversationkit.android.internal.Effect r0 = (zendesk.conversationkit.android.internal.Effect) r0
            r10 = r0
            goto L_0x00d8
        L_0x00bf:
            r10 = move-exception
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r1 = "POST request to create conversation failed to decode malformed JSON response."
            zendesk.logger.Logger.e(r4, r1, r10, r0)
            zendesk.conversationkit.android.internal.Effect$CreateConversationResult r0 = new zendesk.conversationkit.android.internal.Effect$CreateConversationResult
            zendesk.conversationkit.android.ConversationKitResult$Failure r1 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r1.<init>(r10)
            zendesk.conversationkit.android.ConversationKitResult r1 = (zendesk.conversationkit.android.ConversationKitResult) r1
            r0.<init>(r1)
            r10 = r0
            zendesk.conversationkit.android.internal.Effect r10 = (zendesk.conversationkit.android.internal.Effect) r10
        L_0x00d8:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processCreateConversation(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0065, code lost:
        r12 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bf, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c0, code lost:
        r12 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ce, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 4;
        r13 = r12.handleUnauthorized(r13, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d8, code lost:
        if (r13 == r1) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00da, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ee, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ef, code lost:
        r12 = r12;
        zendesk.logger.Logger.e(LOG_TAG, "GET request for Conversation failed to decode malformed JSON response.", r12, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return new zendesk.conversationkit.android.internal.Effect.GetConversationResult(new zendesk.conversationkit.android.ConversationKitResult.Failure(r12), false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return new zendesk.conversationkit.android.internal.Effect.GetConversationResult(new zendesk.conversationkit.android.ConversationKitResult.Failure(r13), false);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:16:0x0044, B:23:0x005c] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:16:0x0044, B:29:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0082 A[Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008f A[Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ac A[Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ee A[ExcHandler: JsonDataException (r12v1 'e' com.squareup.moshi.JsonDataException A[CUSTOM_DECLARE]), Splitter:B:16:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processGetConversation(zendesk.conversationkit.android.internal.Action.GetConversation r12, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processGetConversation$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processGetConversation$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processGetConversation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processGetConversation$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processGetConversation$1
            r0.<init>(r11, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "UserActionProcessor"
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 1
            r9 = 0
            if (r2 == 0) goto L_0x0067
            if (r2 == r8) goto L_0x0054
            if (r2 == r6) goto L_0x0049
            if (r2 == r5) goto L_0x0040
            if (r2 != r4) goto L_0x0038
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00db
        L_0x0038:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0040:
            java.lang.Object r12 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r12 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r12
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            goto L_0x00ad
        L_0x0049:
            java.lang.Object r12 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r12 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r12
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            goto L_0x00a0
        L_0x0051:
            r13 = move-exception
            goto L_0x00c1
        L_0x0054:
            java.lang.Object r12 = r0.L$1
            zendesk.conversationkit.android.internal.Action$GetConversation r12 = (zendesk.conversationkit.android.internal.Action.GetConversation) r12
            java.lang.Object r2 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0064 }
            r10 = r13
            r13 = r12
            r12 = r2
            r2 = r10
            goto L_0x007e
        L_0x0064:
            r13 = move-exception
            r12 = r2
            goto L_0x00c1
        L_0x0067:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.String r13 = r12.getConversationId()     // Catch:{ JsonDataException -> 0x00ee, all -> 0x00bf }
            r0.L$0 = r11     // Catch:{ JsonDataException -> 0x00ee, all -> 0x00bf }
            r0.L$1 = r12     // Catch:{ JsonDataException -> 0x00ee, all -> 0x00bf }
            r0.label = r8     // Catch:{ JsonDataException -> 0x00ee, all -> 0x00bf }
            java.lang.Object r13 = r11.getPersistedConversation(r13, r0)     // Catch:{ JsonDataException -> 0x00ee, all -> 0x00bf }
            if (r13 != r1) goto L_0x007b
            return r1
        L_0x007b:
            r2 = r13
            r13 = r12
            r12 = r11
        L_0x007e:
            zendesk.conversationkit.android.model.Conversation r2 = (zendesk.conversationkit.android.model.Conversation) r2     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            if (r2 == 0) goto L_0x008f
            zendesk.conversationkit.android.internal.Effect$GetConversationResult r13 = new zendesk.conversationkit.android.internal.Effect$GetConversationResult     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            zendesk.conversationkit.android.ConversationKitResult$Success r5 = new zendesk.conversationkit.android.ConversationKitResult$Success     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            r5.<init>(r2)     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            zendesk.conversationkit.android.ConversationKitResult r5 = (zendesk.conversationkit.android.ConversationKitResult) r5     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            r13.<init>(r5, r8)     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            goto L_0x00bc
        L_0x008f:
            java.lang.String r13 = r13.getConversationId()     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            r0.L$0 = r12     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            r0.L$1 = r7     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            r0.label = r6     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            java.lang.Object r13 = r12.getConversationFromNetwork(r13, r0)     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            if (r13 != r1) goto L_0x00a0
            return r1
        L_0x00a0:
            zendesk.conversationkit.android.model.Conversation r13 = (zendesk.conversationkit.android.model.Conversation) r13     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            r0.L$0 = r12     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            r0.label = r5     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            java.lang.Object r13 = r12.updateConversationInMemory(r13, r0)     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            if (r13 != r1) goto L_0x00ad
            return r1
        L_0x00ad:
            zendesk.conversationkit.android.model.Conversation r13 = (zendesk.conversationkit.android.model.Conversation) r13     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            zendesk.conversationkit.android.internal.Effect$GetConversationResult r2 = new zendesk.conversationkit.android.internal.Effect$GetConversationResult     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            zendesk.conversationkit.android.ConversationKitResult$Success r5 = new zendesk.conversationkit.android.ConversationKitResult$Success     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            r5.<init>(r13)     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            zendesk.conversationkit.android.ConversationKitResult r5 = (zendesk.conversationkit.android.ConversationKitResult) r5     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            r2.<init>(r5, r9)     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            r13 = r2
        L_0x00bc:
            zendesk.conversationkit.android.internal.Effect r13 = (zendesk.conversationkit.android.internal.Effect) r13     // Catch:{ JsonDataException -> 0x00ee, all -> 0x0051 }
            goto L_0x0106
        L_0x00bf:
            r13 = move-exception
            r12 = r11
        L_0x00c1:
            java.lang.Object[] r2 = new java.lang.Object[r9]
            java.lang.String r5 = "Failed to get conversation."
            zendesk.logger.Logger.e(r3, r5, r13, r2)
            boolean r2 = zendesk.conversationkit.android.internal.ErrorKtxKt.isUnauthorizedException(r13)
            if (r2 == 0) goto L_0x00de
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r13 = r12.handleUnauthorized(r13, r0)
            if (r13 != r1) goto L_0x00db
            return r1
        L_0x00db:
            zendesk.conversationkit.android.internal.Effect r13 = (zendesk.conversationkit.android.internal.Effect) r13
            goto L_0x0106
        L_0x00de:
            zendesk.conversationkit.android.internal.Effect$GetConversationResult r12 = new zendesk.conversationkit.android.internal.Effect$GetConversationResult
            zendesk.conversationkit.android.ConversationKitResult$Failure r0 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r0.<init>(r13)
            zendesk.conversationkit.android.ConversationKitResult r0 = (zendesk.conversationkit.android.ConversationKitResult) r0
            r12.<init>(r0, r9)
            zendesk.conversationkit.android.internal.Effect r12 = (zendesk.conversationkit.android.internal.Effect) r12
            r13 = r12
            goto L_0x0106
        L_0x00ee:
            r12 = move-exception
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            java.lang.Object[] r13 = new java.lang.Object[r9]
            java.lang.String r0 = "GET request for Conversation failed to decode malformed JSON response."
            zendesk.logger.Logger.e(r3, r0, r12, r13)
            zendesk.conversationkit.android.internal.Effect$GetConversationResult r13 = new zendesk.conversationkit.android.internal.Effect$GetConversationResult
            zendesk.conversationkit.android.ConversationKitResult$Failure r0 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r0.<init>(r12)
            zendesk.conversationkit.android.ConversationKitResult r0 = (zendesk.conversationkit.android.ConversationKitResult) r0
            r13.<init>(r0, r9)
            zendesk.conversationkit.android.internal.Effect r13 = (zendesk.conversationkit.android.internal.Effect) r13
        L_0x0106:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processGetConversation(zendesk.conversationkit.android.internal.Action$GetConversation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007e, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007f, code lost:
        r9 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008d, code lost:
        r0.L$0 = null;
        r0.label = 3;
        r10 = r9.handleUnauthorized(r10, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0096, code lost:
        if (r10 == r1) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0098, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ad, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ae, code lost:
        r9 = r9;
        zendesk.logger.Logger.e(LOG_TAG, "GET request for Conversation failed to decode malformed JSON response.", r9, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return new zendesk.conversationkit.android.internal.Effect.RefreshConversationResult(new zendesk.conversationkit.android.ConversationKitResult.Failure(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return new zendesk.conversationkit.android.internal.Effect.RefreshConversationResult(new zendesk.conversationkit.android.ConversationKitResult.Failure(r10));
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:15:0x003f, B:22:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c A[Catch:{ JsonDataException -> 0x00ad, all -> 0x004b }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ad A[ExcHandler: JsonDataException (r9v1 'e' com.squareup.moshi.JsonDataException A[CUSTOM_DECLARE]), Splitter:B:15:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processRefreshConversation(zendesk.conversationkit.android.internal.Action.RefreshConversation r9, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processRefreshConversation$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processRefreshConversation$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processRefreshConversation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processRefreshConversation$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processRefreshConversation$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            java.lang.String r4 = "UserActionProcessor"
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r7) goto L_0x0043
            if (r2 == r6) goto L_0x003b
            if (r2 != r5) goto L_0x0033
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0099
        L_0x0033:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003b:
            java.lang.Object r9 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r9 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ JsonDataException -> 0x00ad, all -> 0x004b }
            goto L_0x006d
        L_0x0043:
            java.lang.Object r9 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r9 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ JsonDataException -> 0x00ad, all -> 0x004b }
            goto L_0x0060
        L_0x004b:
            r10 = move-exception
            goto L_0x0080
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.String r9 = r9.getConversationId()     // Catch:{ JsonDataException -> 0x00ad, all -> 0x007e }
            r0.L$0 = r8     // Catch:{ JsonDataException -> 0x00ad, all -> 0x007e }
            r0.label = r7     // Catch:{ JsonDataException -> 0x00ad, all -> 0x007e }
            java.lang.Object r10 = r8.getConversationFromNetwork(r9, r0)     // Catch:{ JsonDataException -> 0x00ad, all -> 0x007e }
            if (r10 != r1) goto L_0x005f
            return r1
        L_0x005f:
            r9 = r8
        L_0x0060:
            zendesk.conversationkit.android.model.Conversation r10 = (zendesk.conversationkit.android.model.Conversation) r10     // Catch:{ JsonDataException -> 0x00ad, all -> 0x004b }
            r0.L$0 = r9     // Catch:{ JsonDataException -> 0x00ad, all -> 0x004b }
            r0.label = r6     // Catch:{ JsonDataException -> 0x00ad, all -> 0x004b }
            java.lang.Object r10 = r9.updateConversationInMemory(r10, r0)     // Catch:{ JsonDataException -> 0x00ad, all -> 0x004b }
            if (r10 != r1) goto L_0x006d
            return r1
        L_0x006d:
            zendesk.conversationkit.android.model.Conversation r10 = (zendesk.conversationkit.android.model.Conversation) r10     // Catch:{ JsonDataException -> 0x00ad, all -> 0x004b }
            zendesk.conversationkit.android.internal.Effect$RefreshConversationResult r2 = new zendesk.conversationkit.android.internal.Effect$RefreshConversationResult     // Catch:{ JsonDataException -> 0x00ad, all -> 0x004b }
            zendesk.conversationkit.android.ConversationKitResult$Success r6 = new zendesk.conversationkit.android.ConversationKitResult$Success     // Catch:{ JsonDataException -> 0x00ad, all -> 0x004b }
            r6.<init>(r10)     // Catch:{ JsonDataException -> 0x00ad, all -> 0x004b }
            zendesk.conversationkit.android.ConversationKitResult r6 = (zendesk.conversationkit.android.ConversationKitResult) r6     // Catch:{ JsonDataException -> 0x00ad, all -> 0x004b }
            r2.<init>(r6)     // Catch:{ JsonDataException -> 0x00ad, all -> 0x004b }
            zendesk.conversationkit.android.internal.Effect r2 = (zendesk.conversationkit.android.internal.Effect) r2     // Catch:{ JsonDataException -> 0x00ad, all -> 0x004b }
            goto L_0x00c6
        L_0x007e:
            r10 = move-exception
            r9 = r8
        L_0x0080:
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.String r3 = "Failed to refresh conversation."
            zendesk.logger.Logger.e(r4, r3, r10, r2)
            boolean r2 = zendesk.conversationkit.android.internal.ErrorKtxKt.isUnauthorizedException(r10)
            if (r2 == 0) goto L_0x009d
            r2 = 0
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r10 = r9.handleUnauthorized(r10, r0)
            if (r10 != r1) goto L_0x0099
            return r1
        L_0x0099:
            zendesk.conversationkit.android.internal.Effect r10 = (zendesk.conversationkit.android.internal.Effect) r10
            r2 = r10
            goto L_0x00c6
        L_0x009d:
            zendesk.conversationkit.android.internal.Effect$RefreshConversationResult r9 = new zendesk.conversationkit.android.internal.Effect$RefreshConversationResult
            zendesk.conversationkit.android.ConversationKitResult$Failure r0 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r0.<init>(r10)
            zendesk.conversationkit.android.ConversationKitResult r0 = (zendesk.conversationkit.android.ConversationKitResult) r0
            r9.<init>(r0)
            zendesk.conversationkit.android.internal.Effect r9 = (zendesk.conversationkit.android.internal.Effect) r9
            r2 = r9
            goto L_0x00c6
        L_0x00ad:
            r9 = move-exception
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            java.lang.Object[] r10 = new java.lang.Object[r3]
            java.lang.String r0 = "GET request for Conversation failed to decode malformed JSON response."
            zendesk.logger.Logger.e(r4, r0, r9, r10)
            zendesk.conversationkit.android.internal.Effect$RefreshConversationResult r10 = new zendesk.conversationkit.android.internal.Effect$RefreshConversationResult
            zendesk.conversationkit.android.ConversationKitResult$Failure r0 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r0.<init>(r9)
            zendesk.conversationkit.android.ConversationKitResult r0 = (zendesk.conversationkit.android.ConversationKitResult) r0
            r10.<init>(r0)
            r2 = r10
            zendesk.conversationkit.android.internal.Effect r2 = (zendesk.conversationkit.android.internal.Effect) r2
        L_0x00c6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processRefreshConversation(zendesk.conversationkit.android.internal.Action$RefreshConversation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createConversationFromNetwork(zendesk.conversationkit.android.model.ConversationType r9, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.model.Conversation> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$createConversationFromNetwork$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            zendesk.conversationkit.android.internal.user.UserActionProcessor$createConversationFromNetwork$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$createConversationFromNetwork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$createConversationFromNetwork$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$createConversationFromNetwork$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0055
            if (r2 == r5) goto L_0x0045
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r9 = r0.L$0
            zendesk.conversationkit.android.model.Conversation r9 = (zendesk.conversationkit.android.model.Conversation) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00a4
        L_0x0035:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003d:
            java.lang.Object r9 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r9 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0086
        L_0x0045:
            java.lang.Object r9 = r0.L$2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r0.L$1
            zendesk.conversationkit.android.internal.rest.UserRestClient r2 = (zendesk.conversationkit.android.internal.rest.UserRestClient) r2
            java.lang.Object r5 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r5 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r5
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0073
        L_0x0055:
            kotlin.ResultKt.throwOnFailure(r10)
            zendesk.conversationkit.android.internal.rest.UserRestClient r2 = r8.userRestClient
            zendesk.conversationkit.android.model.User r10 = r8.user
            java.lang.String r10 = zendesk.conversationkit.android.internal.user.UserExtensionsKt.getAuthorization(r10)
            r0.L$0 = r8
            r0.L$1 = r2
            r0.L$2 = r10
            r0.label = r5
            java.lang.Object r9 = r8.buildCreateConversationRequestDto(r9, r0)
            if (r9 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r5 = r8
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0073:
            zendesk.conversationkit.android.internal.rest.model.CreateConversationRequestDto r10 = (zendesk.conversationkit.android.internal.rest.model.CreateConversationRequestDto) r10
            r0.L$0 = r5
            r6 = 0
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r4
            java.lang.Object r10 = r2.createConversation(r9, r10, r0)
            if (r10 != r1) goto L_0x0085
            return r1
        L_0x0085:
            r9 = r5
        L_0x0086:
            zendesk.conversationkit.android.internal.rest.model.ConversationResponseDto r10 = (zendesk.conversationkit.android.internal.rest.model.ConversationResponseDto) r10
            zendesk.conversationkit.android.model.User r2 = r9.user
            java.lang.String r2 = r2.getId()
            zendesk.conversationkit.android.model.Conversation r10 = zendesk.conversationkit.android.model.ConversationKt.toConversation(r10, r2)
            zendesk.conversationkit.android.model.Conversation r10 = zendesk.conversationkit.android.model.ConversationKt.enrichFormResponseFields(r10)
            zendesk.conversationkit.android.internal.user.UserStorage r9 = r9.userStorage
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r9 = r9.setConversation(r10, r0)
            if (r9 != r1) goto L_0x00a3
            return r1
        L_0x00a3:
            r9 = r10
        L_0x00a4:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.createConversationFromNetwork(zendesk.conversationkit.android.model.ConversationType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object createConversationFromNetwork$default(UserActionProcessor userActionProcessor, ConversationType conversationType, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            conversationType = ConversationType.PERSONAL;
        }
        return userActionProcessor.createConversationFromNetwork(conversationType, continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object buildCreateConversationRequestDto(zendesk.conversationkit.android.model.ConversationType r9, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.rest.model.CreateConversationRequestDto> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$buildCreateConversationRequestDto$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            zendesk.conversationkit.android.internal.user.UserActionProcessor$buildCreateConversationRequestDto$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$buildCreateConversationRequestDto$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$buildCreateConversationRequestDto$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$buildCreateConversationRequestDto$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0065
            if (r2 == r4) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r9 = r0.L$4
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r1 = r0.L$3
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r0.L$2
            zendesk.conversationkit.android.internal.ClientDtoProvider r2 = (zendesk.conversationkit.android.internal.ClientDtoProvider) r2
            java.lang.Object r3 = r0.L$1
            zendesk.conversationkit.android.internal.rest.model.Intent r3 = (zendesk.conversationkit.android.internal.rest.model.Intent) r3
            java.lang.Object r0 = r0.L$0
            zendesk.conversationkit.android.model.ConversationType r0 = (zendesk.conversationkit.android.model.ConversationType) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00a8
        L_0x0042:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x004a:
            java.lang.Object r9 = r0.L$4
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r0.L$3
            zendesk.conversationkit.android.internal.ClientDtoProvider r2 = (zendesk.conversationkit.android.internal.ClientDtoProvider) r2
            java.lang.Object r4 = r0.L$2
            zendesk.conversationkit.android.internal.rest.model.Intent r4 = (zendesk.conversationkit.android.internal.rest.model.Intent) r4
            java.lang.Object r5 = r0.L$1
            zendesk.conversationkit.android.model.ConversationType r5 = (zendesk.conversationkit.android.model.ConversationType) r5
            java.lang.Object r6 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r6 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r6
            kotlin.ResultKt.throwOnFailure(r10)
            r7 = r5
            r5 = r9
            r9 = r7
            goto L_0x008b
        L_0x0065:
            kotlin.ResultKt.throwOnFailure(r10)
            zendesk.conversationkit.android.internal.rest.model.Intent r10 = zendesk.conversationkit.android.internal.rest.model.Intent.CONVERSATION_START
            zendesk.conversationkit.android.internal.ClientDtoProvider r2 = r8.clientDtoProvider
            zendesk.conversationkit.android.ConversationKitSettings r5 = r8.conversationKitSettings
            java.lang.String r5 = r5.getIntegrationId()
            zendesk.conversationkit.android.internal.ConversationKitStorage r6 = r8.conversationKitStorage
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r2
            r0.L$4 = r5
            r0.label = r4
            java.lang.Object r4 = r6.getClientId(r0)
            if (r4 != r1) goto L_0x0087
            return r1
        L_0x0087:
            r6 = r8
            r7 = r4
            r4 = r10
            r10 = r7
        L_0x008b:
            java.lang.String r10 = (java.lang.String) r10
            zendesk.conversationkit.android.internal.ConversationKitStorage r6 = r6.conversationKitStorage
            r0.L$0 = r9
            r0.L$1 = r4
            r0.L$2 = r2
            r0.L$3 = r5
            r0.L$4 = r10
            r0.label = r3
            java.lang.Object r0 = r6.getPushToken(r0)
            if (r0 != r1) goto L_0x00a2
            return r1
        L_0x00a2:
            r3 = r4
            r1 = r5
            r7 = r0
            r0 = r9
            r9 = r10
            r10 = r7
        L_0x00a8:
            java.lang.String r10 = (java.lang.String) r10
            zendesk.conversationkit.android.internal.rest.model.ClientDto r9 = r2.buildClient(r1, r9, r10)
            zendesk.conversationkit.android.internal.rest.model.CreateConversationRequestDto r10 = new zendesk.conversationkit.android.internal.rest.model.CreateConversationRequestDto
            r10.<init>(r0, r3, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.buildCreateConversationRequestDto(zendesk.conversationkit.android.model.ConversationType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getConversationFromNetwork(java.lang.String r6, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.model.Conversation> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$getConversationFromNetwork$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            zendesk.conversationkit.android.internal.user.UserActionProcessor$getConversationFromNetwork$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$getConversationFromNetwork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$getConversationFromNetwork$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$getConversationFromNetwork$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r6 = r0.L$0
            zendesk.conversationkit.android.model.Conversation r6 = (zendesk.conversationkit.android.model.Conversation) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0076
        L_0x0031:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0039:
            java.lang.Object r6 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r6 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0058
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            zendesk.conversationkit.android.internal.rest.UserRestClient r7 = r5.userRestClient
            zendesk.conversationkit.android.model.User r2 = r5.user
            java.lang.String r2 = zendesk.conversationkit.android.internal.user.UserExtensionsKt.getAuthorization(r2)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r7.getConversation(r2, r6, r0)
            if (r7 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r6 = r5
        L_0x0058:
            zendesk.conversationkit.android.internal.rest.model.ConversationResponseDto r7 = (zendesk.conversationkit.android.internal.rest.model.ConversationResponseDto) r7
            zendesk.conversationkit.android.model.User r2 = r6.user
            java.lang.String r2 = r2.getId()
            zendesk.conversationkit.android.model.Conversation r7 = zendesk.conversationkit.android.model.ConversationKt.toConversation(r7, r2)
            zendesk.conversationkit.android.model.Conversation r7 = zendesk.conversationkit.android.model.ConversationKt.enrichFormResponseFields(r7)
            zendesk.conversationkit.android.internal.user.UserStorage r6 = r6.userStorage
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r6.setConversation(r7, r0)
            if (r6 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r6 = r7
        L_0x0076:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.getConversationFromNetwork(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getMessagesFromNetwork(java.lang.String r8, double r9, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.model.MessageList> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$getMessagesFromNetwork$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            zendesk.conversationkit.android.internal.user.UserActionProcessor$getMessagesFromNetwork$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$getMessagesFromNetwork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$getMessagesFromNetwork$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$getMessagesFromNetwork$1
            r0.<init>(r7, r11)
        L_0x0019:
            r6 = r0
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 != r2) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x004a
        L_0x002b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r11)
            zendesk.conversationkit.android.internal.rest.UserRestClient r1 = r7.userRestClient
            zendesk.conversationkit.android.model.User r11 = r7.user
            java.lang.String r11 = zendesk.conversationkit.android.internal.user.UserExtensionsKt.getAuthorization(r11)
            r6.label = r2
            r2 = r11
            r3 = r8
            r4 = r9
            java.lang.Object r11 = r1.getMessages(r2, r3, r4, r6)
            if (r11 != r0) goto L_0x004a
            return r0
        L_0x004a:
            zendesk.conversationkit.android.internal.rest.model.MessageListResponseDto r11 = (zendesk.conversationkit.android.internal.rest.model.MessageListResponseDto) r11
            zendesk.conversationkit.android.model.MessageList r8 = zendesk.conversationkit.android.model.MessageKt.toMessageList(r11)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.getMessagesFromNetwork(java.lang.String, double, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateConversationInMemory(zendesk.conversationkit.android.model.Conversation r41, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.model.Conversation> r42) {
        /*
            r40 = this;
            r0 = r40
            r1 = r42
            boolean r2 = r1 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$updateConversationInMemory$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            zendesk.conversationkit.android.internal.user.UserActionProcessor$updateConversationInMemory$1 r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$updateConversationInMemory$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$updateConversationInMemory$1 r2 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$updateConversationInMemory$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x003f
            if (r4 != r5) goto L_0x0037
            java.lang.Object r3 = r2.L$1
            zendesk.conversationkit.android.model.Conversation r3 = (zendesk.conversationkit.android.model.Conversation) r3
            java.lang.Object r2 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00c7
        L_0x0037:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r1)
            zendesk.conversationkit.android.model.User r6 = r0.user
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            java.util.List r1 = r6.getConversations()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r1 = r1.iterator()
        L_0x005b:
            boolean r14 = r1.hasNext()
            if (r14 == 0) goto L_0x007a
            java.lang.Object r14 = r1.next()
            r15 = r14
            zendesk.conversationkit.android.model.Conversation r15 = (zendesk.conversationkit.android.model.Conversation) r15
            java.lang.String r15 = r15.getId()
            java.lang.String r13 = r41.getId()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r13)
            if (r13 != 0) goto L_0x005b
            r4.add(r14)
            goto L_0x005b
        L_0x007a:
            java.util.List r4 = (java.util.List) r4
            java.util.Collection r4 = (java.util.Collection) r4
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            java.util.List r1 = r41.getMessages()
            java.util.List r25 = kotlin.collections.CollectionsKt.takeLast(r1, r5)
            r26 = 0
            r27 = 6143(0x17ff, float:8.608E-42)
            r28 = 0
            r13 = r41
            zendesk.conversationkit.android.model.Conversation r1 = zendesk.conversationkit.android.model.Conversation.copy$default(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            java.util.List r14 = kotlin.collections.CollectionsKt.plus(r4, r1)
            r19 = 3967(0xf7f, float:5.559E-42)
            r1 = 0
            r13 = r1
            zendesk.conversationkit.android.model.User r1 = zendesk.conversationkit.android.model.User.copy$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r0.user = r1
            zendesk.conversationkit.android.internal.app.AppStorage r4 = r0.appStorage
            r2.L$0 = r0
            r6 = r41
            r2.L$1 = r6
            r2.label = r5
            java.lang.Object r1 = r4.setUser(r1, r2)
            if (r1 != r3) goto L_0x00c5
            return r3
        L_0x00c5:
            r2 = r0
            r3 = r6
        L_0x00c7:
            java.util.Map<java.lang.String, zendesk.conversationkit.android.model.Conversation> r1 = r2.conversations
            java.lang.String r4 = r3.getId()
            java.lang.Object r1 = r1.get(r4)
            zendesk.conversationkit.android.model.Conversation r1 = (zendesk.conversationkit.android.model.Conversation) r1
            if (r1 == 0) goto L_0x00da
            java.util.List r1 = r1.getMessages()
            goto L_0x00db
        L_0x00da:
            r1 = 0
        L_0x00db:
            if (r1 != 0) goto L_0x00e1
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00e1:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r7 = r1.iterator()
        L_0x00ee:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0115
            java.lang.Object r8 = r7.next()
            r9 = r8
            zendesk.conversationkit.android.model.Message r9 = (zendesk.conversationkit.android.model.Message) r9
            zendesk.conversationkit.android.model.MessageStatus r10 = r9.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r11 = zendesk.conversationkit.android.model.MessageStatus.PENDING
            if (r10 == r11) goto L_0x010e
            zendesk.conversationkit.android.model.MessageStatus r9 = r9.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r10 = zendesk.conversationkit.android.model.MessageStatus.FAILED
            if (r9 != r10) goto L_0x010c
            goto L_0x010e
        L_0x010c:
            r9 = 0
            goto L_0x010f
        L_0x010e:
            r9 = r5
        L_0x010f:
            if (r9 == 0) goto L_0x00ee
            r6.add(r8)
            goto L_0x00ee
        L_0x0115:
            java.util.List r6 = (java.util.List) r6
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            java.util.List r5 = r3.getMessages()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Set r5 = kotlin.collections.CollectionsKt.union(r5, r6)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r12 = 10
            int r12 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r12)
            r6.<init>(r12)
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x0141:
            boolean r12 = r5.hasNext()
            if (r12 == 0) goto L_0x01f6
            java.lang.Object r12 = r5.next()
            r18 = r12
            zendesk.conversationkit.android.model.Message r18 = (zendesk.conversationkit.android.model.Message) r18
            java.util.Iterator r12 = r1.iterator()
        L_0x0153:
            boolean r19 = r12.hasNext()
            if (r19 == 0) goto L_0x0170
            java.lang.Object r19 = r12.next()
            r20 = r19
            zendesk.conversationkit.android.model.Message r20 = (zendesk.conversationkit.android.model.Message) r20
            java.lang.String r4 = r20.getId()
            java.lang.String r15 = r18.getId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r15)
            if (r4 == 0) goto L_0x0153
            goto L_0x0172
        L_0x0170:
            r19 = 0
        L_0x0172:
            zendesk.conversationkit.android.model.Message r19 = (zendesk.conversationkit.android.model.Message) r19
            if (r19 == 0) goto L_0x01ef
            zendesk.conversationkit.android.model.MessageContent r4 = r18.getContent()
            boolean r4 = r4 instanceof zendesk.conversationkit.android.model.MessageContent.Image
            if (r4 == 0) goto L_0x01cd
            zendesk.conversationkit.android.model.MessageContent r4 = r19.getContent()
            boolean r4 = r4 instanceof zendesk.conversationkit.android.model.MessageContent.FileUpload
            if (r4 == 0) goto L_0x01cd
            java.lang.String r29 = r19.getLocalId()
            zendesk.conversationkit.android.model.MessageContent r4 = r18.getContent()
            r30 = r4
            zendesk.conversationkit.android.model.MessageContent$Image r30 = (zendesk.conversationkit.android.model.MessageContent.Image) r30
            r31 = 0
            r32 = 0
            zendesk.conversationkit.android.model.MessageContent r4 = r19.getContent()
            zendesk.conversationkit.android.model.MessageContent$FileUpload r4 = (zendesk.conversationkit.android.model.MessageContent.FileUpload) r4
            java.lang.String r33 = r4.getUri()
            r34 = 0
            r35 = 0
            r37 = 0
            r38 = 59
            r39 = 0
            zendesk.conversationkit.android.model.MessageContent$Image r4 = zendesk.conversationkit.android.model.MessageContent.Image.copy$default(r30, r31, r32, r33, r34, r35, r37, r38, r39)
            java.time.LocalDateTime r22 = r19.getCreated()
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r26 = r4
            zendesk.conversationkit.android.model.MessageContent r26 = (zendesk.conversationkit.android.model.MessageContent) r26
            r27 = 0
            r28 = 0
            r30 = 0
            r31 = 1463(0x5b7, float:2.05E-42)
            zendesk.conversationkit.android.model.Message r18 = zendesk.conversationkit.android.model.Message.copy$default(r18, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30, r31, r32)
            goto L_0x01ef
        L_0x01cd:
            java.lang.String r29 = r19.getLocalId()
            java.time.LocalDateTime r22 = r19.getCreated()
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r30 = 0
            r31 = 1527(0x5f7, float:2.14E-42)
            r32 = 0
            zendesk.conversationkit.android.model.Message r18 = zendesk.conversationkit.android.model.Message.copy$default(r18, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30, r31, r32)
        L_0x01ef:
            r4 = r18
            r6.add(r4)
            goto L_0x0141
        L_0x01f6:
            java.util.List r6 = (java.util.List) r6
            r12 = 0
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            zendesk.conversationkit.android.internal.user.UserActionProcessor$updateConversationInMemory$$inlined$sortedBy$1 r1 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$updateConversationInMemory$$inlined$sortedBy$1
            r1.<init>()
            java.util.Comparator r1 = (java.util.Comparator) r1
            java.util.List r18 = kotlin.collections.CollectionsKt.sortedWith(r6, r1)
            r19 = 0
            r20 = 6143(0x17ff, float:8.608E-42)
            r21 = 0
            r6 = r3
            r1 = 0
            r15 = r1
            zendesk.conversationkit.android.model.Conversation r1 = zendesk.conversationkit.android.model.Conversation.copy$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            java.util.Map<java.lang.String, zendesk.conversationkit.android.model.Conversation> r2 = r2.conversations
            java.lang.String r3 = r3.getId()
            r2.put(r3, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.updateConversationInMemory(zendesk.conversationkit.android.model.Conversation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x022c, code lost:
        r5.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x022f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        r0 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0232, code lost:
        r4.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0235, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        r6 = zendesk.conversationkit.android.model.User.copy$default(r9.user, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, r22, (zendesk.conversationkit.android.model.RealtimeSettings) null, (zendesk.conversationkit.android.model.TypingSettings) null, (java.lang.String) null, (java.lang.String) null, 3967, (java.lang.Object) null);
        r9.user = r6;
        r10 = r9.appStorage;
        r2.L$0 = r9;
        r2.L$1 = r8;
        r2.L$2 = r4;
        r2.L$3 = r5;
        r2.L$4 = r0;
        r2.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x026a, code lost:
        if (r10.setUser(r6, r2) != r3) goto L_0x026d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x026c, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x026d, code lost:
        r6 = r8;
        r8 = r5;
        r5 = r4;
        r4 = r3;
        r3 = r0;
        r0 = r2;
        r2 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0274, code lost:
        if (r8 == null) goto L_0x02bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:?, code lost:
        r7 = zendesk.conversationkit.android.model.Conversation.copy$default(r8, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (zendesk.conversationkit.android.model.ConversationType) null, false, (java.util.List) null, (java.time.LocalDateTime) null, (java.lang.Double) null, (zendesk.conversationkit.android.model.Participant) null, (java.util.List) null, kotlin.collections.CollectionsKt.plus(r8.getMessages(), r3), false, 6143, (java.lang.Object) null);
        r8 = r2.userStorage;
        r0.L$0 = r2;
        r0.L$1 = r6;
        r0.L$2 = r5;
        r0.L$3 = r7;
        r0.L$4 = r3;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02ae, code lost:
        if (r8.setConversation(r7, r0) != r4) goto L_0x02b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02b0, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02b1, code lost:
        r4 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02b2, code lost:
        r2.conversations.put(r6.getConversationId(), r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02bc, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02bd, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02bf, code lost:
        r0 = new zendesk.conversationkit.android.internal.Effect.MessageReceived(r3, r6.getConversationId(), r2.conversations.get(r6.getConversationId()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02d4, code lost:
        r5.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02d8, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02d9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02da, code lost:
        r2 = null;
        r5 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b4, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b5, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r0 = r4.getConversationId();
        r2.L$0 = r9;
        r2.L$1 = r4;
        r2.L$2 = r8;
        r2.label = 2;
        r0 = r9.getPersistedConversation(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f7, code lost:
        if (r0 != r3) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f9, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fa, code lost:
        r29 = r8;
        r8 = r4;
        r4 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r0 = (zendesk.conversationkit.android.model.Conversation) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0101, code lost:
        if (r0 == null) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0103, code lost:
        r10 = r0.getMessages();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010b, code lost:
        if ((r10 instanceof java.util.Collection) == false) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0114, code lost:
        if (((java.util.Collection) r10).isEmpty() == false) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0116, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011d, code lost:
        r11 = r9;
        r29 = r8;
        r8 = r4;
        r4 = r10.iterator();
        r10 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0128, code lost:
        if (r4.hasNext() == false) goto L_0x0191;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x012a, code lost:
        r9 = (zendesk.conversationkit.android.model.Message) r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0140, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9.getId(), (java.lang.Object) r10.getMessage().getId()) != false) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x015a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9.getAuthor().getUserId(), (java.lang.Object) r10.getMessage().getAuthor().getUserId()) == false) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x015c, code lost:
        r9 = r11.conversationKitStorage;
        r2.L$0 = r11;
        r2.L$1 = r10;
        r2.L$2 = r8;
        r2.L$3 = r0;
        r2.L$4 = r4;
        r2.label = 3;
        r9 = r9.getClientId(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x016f, code lost:
        if (r9 != r3) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0171, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0172, code lost:
        r29 = r9;
        r9 = r0;
        r0 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0183, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, (java.lang.Object) r10.getMessage().getSourceId()) == false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0185, code lost:
        r0 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0187, code lost:
        r0 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0188, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x018a, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x018b, code lost:
        if (r9 == false) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x018d, code lost:
        r4 = r8;
        r8 = r10;
        r9 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0191, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0193, code lost:
        r6 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0194, code lost:
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0195, code lost:
        if (r5 == null) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r0 = zendesk.conversationkit.android.model.MessageKt.enrichFormResponseFields(r8.getMessage(), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x019f, code lost:
        if (r0 != null) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01a1, code lost:
        r0 = r8.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a5, code lost:
        r10 = r9.user.getConversations();
        r11 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, 10));
        r10 = r10.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c2, code lost:
        if (r10.hasNext() == false) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c4, code lost:
        r13 = (zendesk.conversationkit.android.model.Conversation) r10.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01d7, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13.getId(), (java.lang.Object) r8.getConversationId()) == false) goto L_0x01fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01d9, code lost:
        r13 = zendesk.conversationkit.android.model.Conversation.copy$default(r13, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (zendesk.conversationkit.android.model.ConversationType) null, false, (java.util.List) null, (java.time.LocalDateTime) null, (java.lang.Double) null, (zendesk.conversationkit.android.model.Participant) null, (java.util.List) null, kotlin.collections.CollectionsKt.listOf(r0), false, 6143, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01fb, code lost:
        r11.add(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01ff, code lost:
        r22 = (java.util.List) r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0203, code lost:
        if (r6 == false) goto L_0x0236;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x020b, code lost:
        if ((r0.getContent() instanceof zendesk.conversationkit.android.model.MessageContent.File) == false) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0213, code lost:
        if (r0.getStatus() != zendesk.conversationkit.android.model.MessageStatus.SENT) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0215, code lost:
        if (r5 == null) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0217, code lost:
        r2.L$0 = r4;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.label = 4;
        r0 = r9.processSentFileMessageReceived(r0, r5, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0228, code lost:
        if (r0 != r3) goto L_0x022b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x022a, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x022b, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processMessageReceived(zendesk.conversationkit.android.internal.Action.MessageReceived r32, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r33) {
        /*
            r31 = this;
            r1 = r31
            r0 = r33
            boolean r2 = r0 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processMessageReceived$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processMessageReceived$1 r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processMessageReceived$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processMessageReceived$1 r2 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processMessageReceived$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            r7 = 0
            switch(r4) {
                case 0: goto L_0x00ce;
                case 1: goto L_0x00b9;
                case 2: goto L_0x00a4;
                case 3: goto L_0x0081;
                case 4: goto L_0x0075;
                case 5: goto L_0x004c;
                case 6: goto L_0x0033;
                default: goto L_0x002b;
            }
        L_0x002b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0033:
            java.lang.Object r3 = r2.L$4
            zendesk.conversationkit.android.model.Message r3 = (zendesk.conversationkit.android.model.Message) r3
            java.lang.Object r4 = r2.L$3
            zendesk.conversationkit.android.model.Conversation r4 = (zendesk.conversationkit.android.model.Conversation) r4
            java.lang.Object r5 = r2.L$2
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r6 = r2.L$1
            zendesk.conversationkit.android.internal.Action$MessageReceived r6 = (zendesk.conversationkit.android.internal.Action.MessageReceived) r6
            java.lang.Object r2 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x007f }
            goto L_0x02b2
        L_0x004c:
            java.lang.Object r4 = r2.L$4
            zendesk.conversationkit.android.model.Message r4 = (zendesk.conversationkit.android.model.Message) r4
            java.lang.Object r5 = r2.L$3
            zendesk.conversationkit.android.model.Conversation r5 = (zendesk.conversationkit.android.model.Conversation) r5
            java.lang.Object r6 = r2.L$2
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r8 = r2.L$1
            zendesk.conversationkit.android.internal.Action$MessageReceived r8 = (zendesk.conversationkit.android.internal.Action.MessageReceived) r8
            java.lang.Object r9 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r9 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r9
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0072 }
            r0 = r2
            r2 = r9
            r29 = r4
            r4 = r3
            r3 = r29
            r30 = r8
            r8 = r5
            r5 = r6
            r6 = r30
            goto L_0x0274
        L_0x0072:
            r0 = move-exception
            r5 = r6
            goto L_0x00b6
        L_0x0075:
            java.lang.Object r2 = r2.L$0
            r5 = r2
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x007f }
            goto L_0x022c
        L_0x007f:
            r0 = move-exception
            goto L_0x00b6
        L_0x0081:
            java.lang.Object r4 = r2.L$4
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r8 = r2.L$3
            zendesk.conversationkit.android.model.Conversation r8 = (zendesk.conversationkit.android.model.Conversation) r8
            java.lang.Object r9 = r2.L$2
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r10 = r2.L$1
            zendesk.conversationkit.android.internal.Action$MessageReceived r10 = (zendesk.conversationkit.android.internal.Action.MessageReceived) r10
            java.lang.Object r11 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r11 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r11
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x009f }
            r29 = r9
            r9 = r8
            r8 = r29
            goto L_0x0177
        L_0x009f:
            r0 = move-exception
            r2 = r7
            r5 = r9
            goto L_0x02dc
        L_0x00a4:
            java.lang.Object r4 = r2.L$2
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            java.lang.Object r8 = r2.L$1
            zendesk.conversationkit.android.internal.Action$MessageReceived r8 = (zendesk.conversationkit.android.internal.Action.MessageReceived) r8
            java.lang.Object r9 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r9 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r9
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00b4 }
            goto L_0x00ff
        L_0x00b4:
            r0 = move-exception
            r5 = r4
        L_0x00b6:
            r2 = r7
            goto L_0x02dc
        L_0x00b9:
            java.lang.Object r4 = r2.L$2
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            java.lang.Object r8 = r2.L$1
            zendesk.conversationkit.android.internal.Action$MessageReceived r8 = (zendesk.conversationkit.android.internal.Action.MessageReceived) r8
            java.lang.Object r9 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r9 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r9
            kotlin.ResultKt.throwOnFailure(r0)
            r29 = r8
            r8 = r4
            r4 = r29
            goto L_0x00e6
        L_0x00ce:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlinx.coroutines.sync.Mutex r0 = r1.messageReceivedMutex
            r2.L$0 = r1
            r4 = r32
            r2.L$1 = r4
            r2.L$2 = r0
            r2.label = r5
            java.lang.Object r8 = r0.lock(r7, r2)
            if (r8 != r3) goto L_0x00e4
            return r3
        L_0x00e4:
            r8 = r0
            r9 = r1
        L_0x00e6:
            java.lang.String r0 = r4.getConversationId()     // Catch:{ all -> 0x02d9 }
            r2.L$0 = r9     // Catch:{ all -> 0x02d9 }
            r2.L$1 = r4     // Catch:{ all -> 0x02d9 }
            r2.L$2 = r8     // Catch:{ all -> 0x02d9 }
            r10 = 2
            r2.label = r10     // Catch:{ all -> 0x02d9 }
            java.lang.Object r0 = r9.getPersistedConversation(r0, r2)     // Catch:{ all -> 0x02d9 }
            if (r0 != r3) goto L_0x00fa
            return r3
        L_0x00fa:
            r29 = r8
            r8 = r4
            r4 = r29
        L_0x00ff:
            zendesk.conversationkit.android.model.Conversation r0 = (zendesk.conversationkit.android.model.Conversation) r0     // Catch:{ all -> 0x00b4 }
            if (r0 == 0) goto L_0x0194
            java.util.List r10 = r0.getMessages()     // Catch:{ all -> 0x00b4 }
            java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch:{ all -> 0x00b4 }
            boolean r11 = r10 instanceof java.util.Collection     // Catch:{ all -> 0x00b4 }
            if (r11 == 0) goto L_0x0119
            r11 = r10
            java.util.Collection r11 = (java.util.Collection) r11     // Catch:{ all -> 0x00b4 }
            boolean r11 = r11.isEmpty()     // Catch:{ all -> 0x00b4 }
            if (r11 == 0) goto L_0x0119
            r5 = r6
            goto L_0x0193
        L_0x0119:
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x00b4 }
            r11 = r9
            r29 = r8
            r8 = r4
            r4 = r10
            r10 = r29
        L_0x0124:
            boolean r9 = r4.hasNext()     // Catch:{ all -> 0x02d9 }
            if (r9 == 0) goto L_0x0191
            java.lang.Object r9 = r4.next()     // Catch:{ all -> 0x02d9 }
            zendesk.conversationkit.android.model.Message r9 = (zendesk.conversationkit.android.model.Message) r9     // Catch:{ all -> 0x02d9 }
            java.lang.String r12 = r9.getId()     // Catch:{ all -> 0x02d9 }
            zendesk.conversationkit.android.model.Message r13 = r10.getMessage()     // Catch:{ all -> 0x02d9 }
            java.lang.String r13 = r13.getId()     // Catch:{ all -> 0x02d9 }
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)     // Catch:{ all -> 0x02d9 }
            if (r12 != 0) goto L_0x018a
            zendesk.conversationkit.android.model.Author r9 = r9.getAuthor()     // Catch:{ all -> 0x02d9 }
            java.lang.String r9 = r9.getUserId()     // Catch:{ all -> 0x02d9 }
            zendesk.conversationkit.android.model.Message r12 = r10.getMessage()     // Catch:{ all -> 0x02d9 }
            zendesk.conversationkit.android.model.Author r12 = r12.getAuthor()     // Catch:{ all -> 0x02d9 }
            java.lang.String r12 = r12.getUserId()     // Catch:{ all -> 0x02d9 }
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r12)     // Catch:{ all -> 0x02d9 }
            if (r9 == 0) goto L_0x0188
            zendesk.conversationkit.android.internal.ConversationKitStorage r9 = r11.conversationKitStorage     // Catch:{ all -> 0x02d9 }
            r2.L$0 = r11     // Catch:{ all -> 0x02d9 }
            r2.L$1 = r10     // Catch:{ all -> 0x02d9 }
            r2.L$2 = r8     // Catch:{ all -> 0x02d9 }
            r2.L$3 = r0     // Catch:{ all -> 0x02d9 }
            r2.L$4 = r4     // Catch:{ all -> 0x02d9 }
            r12 = 3
            r2.label = r12     // Catch:{ all -> 0x02d9 }
            java.lang.Object r9 = r9.getClientId(r2)     // Catch:{ all -> 0x02d9 }
            if (r9 != r3) goto L_0x0172
            return r3
        L_0x0172:
            r29 = r9
            r9 = r0
            r0 = r29
        L_0x0177:
            zendesk.conversationkit.android.model.Message r12 = r10.getMessage()     // Catch:{ all -> 0x02d9 }
            java.lang.String r12 = r12.getSourceId()     // Catch:{ all -> 0x02d9 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r12)     // Catch:{ all -> 0x02d9 }
            if (r0 == 0) goto L_0x0187
            r0 = r9
            goto L_0x018a
        L_0x0187:
            r0 = r9
        L_0x0188:
            r9 = r6
            goto L_0x018b
        L_0x018a:
            r9 = r5
        L_0x018b:
            if (r9 == 0) goto L_0x0124
        L_0x018d:
            r4 = r8
            r8 = r10
            r9 = r11
            goto L_0x0193
        L_0x0191:
            r5 = r6
            goto L_0x018d
        L_0x0193:
            r6 = r5
        L_0x0194:
            r5 = r0
            if (r5 == 0) goto L_0x01a1
            zendesk.conversationkit.android.model.Message r0 = r8.getMessage()     // Catch:{ all -> 0x00b4 }
            zendesk.conversationkit.android.model.Message r0 = zendesk.conversationkit.android.model.MessageKt.enrichFormResponseFields(r0, r5)     // Catch:{ all -> 0x00b4 }
            if (r0 != 0) goto L_0x01a5
        L_0x01a1:
            zendesk.conversationkit.android.model.Message r0 = r8.getMessage()     // Catch:{ all -> 0x00b4 }
        L_0x01a5:
            zendesk.conversationkit.android.model.User r10 = r9.user     // Catch:{ all -> 0x00b4 }
            java.util.List r10 = r10.getConversations()     // Catch:{ all -> 0x00b4 }
            java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch:{ all -> 0x00b4 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x00b4 }
            r12 = 10
            int r12 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r12)     // Catch:{ all -> 0x00b4 }
            r11.<init>(r12)     // Catch:{ all -> 0x00b4 }
            java.util.Collection r11 = (java.util.Collection) r11     // Catch:{ all -> 0x00b4 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x00b4 }
        L_0x01be:
            boolean r12 = r10.hasNext()     // Catch:{ all -> 0x00b4 }
            if (r12 == 0) goto L_0x01ff
            java.lang.Object r12 = r10.next()     // Catch:{ all -> 0x00b4 }
            r13 = r12
            zendesk.conversationkit.android.model.Conversation r13 = (zendesk.conversationkit.android.model.Conversation) r13     // Catch:{ all -> 0x00b4 }
            java.lang.String r12 = r13.getId()     // Catch:{ all -> 0x00b4 }
            java.lang.String r14 = r8.getConversationId()     // Catch:{ all -> 0x00b4 }
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r14)     // Catch:{ all -> 0x00b4 }
            if (r12 == 0) goto L_0x01fb
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            java.util.List r25 = kotlin.collections.CollectionsKt.listOf(r0)     // Catch:{ all -> 0x00b4 }
            r26 = 0
            r27 = 6143(0x17ff, float:8.608E-42)
            r28 = 0
            zendesk.conversationkit.android.model.Conversation r13 = zendesk.conversationkit.android.model.Conversation.copy$default(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)     // Catch:{ all -> 0x00b4 }
        L_0x01fb:
            r11.add(r13)     // Catch:{ all -> 0x00b4 }
            goto L_0x01be
        L_0x01ff:
            r22 = r11
            java.util.List r22 = (java.util.List) r22     // Catch:{ all -> 0x00b4 }
            if (r6 == 0) goto L_0x0236
            zendesk.conversationkit.android.model.MessageContent r6 = r0.getContent()     // Catch:{ all -> 0x00b4 }
            boolean r6 = r6 instanceof zendesk.conversationkit.android.model.MessageContent.File     // Catch:{ all -> 0x00b4 }
            if (r6 == 0) goto L_0x0230
            zendesk.conversationkit.android.model.MessageStatus r6 = r0.getStatus()     // Catch:{ all -> 0x00b4 }
            zendesk.conversationkit.android.model.MessageStatus r8 = zendesk.conversationkit.android.model.MessageStatus.SENT     // Catch:{ all -> 0x00b4 }
            if (r6 != r8) goto L_0x0230
            if (r5 == 0) goto L_0x0230
            r2.L$0 = r4     // Catch:{ all -> 0x00b4 }
            r2.L$1 = r7     // Catch:{ all -> 0x00b4 }
            r2.L$2 = r7     // Catch:{ all -> 0x00b4 }
            r2.L$3 = r7     // Catch:{ all -> 0x00b4 }
            r2.L$4 = r7     // Catch:{ all -> 0x00b4 }
            r6 = 4
            r2.label = r6     // Catch:{ all -> 0x00b4 }
            java.lang.Object r0 = r9.processSentFileMessageReceived(r0, r5, r2)     // Catch:{ all -> 0x00b4 }
            if (r0 != r3) goto L_0x022b
            return r3
        L_0x022b:
            r5 = r4
        L_0x022c:
            r5.unlock(r7)
            return r0
        L_0x0230:
            zendesk.conversationkit.android.internal.Effect$None r0 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE     // Catch:{ all -> 0x00b4 }
            r4.unlock(r7)
            return r0
        L_0x0236:
            zendesk.conversationkit.android.model.User r14 = r9.user     // Catch:{ all -> 0x00b4 }
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 3967(0xf7f, float:5.559E-42)
            r28 = 0
            zendesk.conversationkit.android.model.User r6 = zendesk.conversationkit.android.model.User.copy$default(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)     // Catch:{ all -> 0x00b4 }
            r9.user = r6     // Catch:{ all -> 0x00b4 }
            zendesk.conversationkit.android.internal.app.AppStorage r10 = r9.appStorage     // Catch:{ all -> 0x00b4 }
            r2.L$0 = r9     // Catch:{ all -> 0x00b4 }
            r2.L$1 = r8     // Catch:{ all -> 0x00b4 }
            r2.L$2 = r4     // Catch:{ all -> 0x00b4 }
            r2.L$3 = r5     // Catch:{ all -> 0x00b4 }
            r2.L$4 = r0     // Catch:{ all -> 0x00b4 }
            r11 = 5
            r2.label = r11     // Catch:{ all -> 0x00b4 }
            java.lang.Object r6 = r10.setUser(r6, r2)     // Catch:{ all -> 0x00b4 }
            if (r6 != r3) goto L_0x026d
            return r3
        L_0x026d:
            r6 = r8
            r8 = r5
            r5 = r4
            r4 = r3
            r3 = r0
            r0 = r2
            r2 = r9
        L_0x0274:
            if (r8 == 0) goto L_0x02bf
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            java.util.List r20 = r8.getMessages()     // Catch:{ all -> 0x007f }
            r7 = r20
            java.util.Collection r7 = (java.util.Collection) r7     // Catch:{ all -> 0x02bc }
            java.util.List r20 = kotlin.collections.CollectionsKt.plus(r7, r3)     // Catch:{ all -> 0x02bc }
            r21 = 0
            r22 = 6143(0x17ff, float:8.608E-42)
            r23 = 0
            zendesk.conversationkit.android.model.Conversation r7 = zendesk.conversationkit.android.model.Conversation.copy$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x02bc }
            zendesk.conversationkit.android.internal.user.UserStorage r8 = r2.userStorage     // Catch:{ all -> 0x02bc }
            r0.L$0 = r2     // Catch:{ all -> 0x02bc }
            r0.L$1 = r6     // Catch:{ all -> 0x02bc }
            r0.L$2 = r5     // Catch:{ all -> 0x02bc }
            r0.L$3 = r7     // Catch:{ all -> 0x02bc }
            r0.L$4 = r3     // Catch:{ all -> 0x02bc }
            r9 = 6
            r0.label = r9     // Catch:{ all -> 0x02bc }
            java.lang.Object r0 = r8.setConversation(r7, r0)     // Catch:{ all -> 0x02bc }
            if (r0 != r4) goto L_0x02b1
            return r4
        L_0x02b1:
            r4 = r7
        L_0x02b2:
            java.util.Map<java.lang.String, zendesk.conversationkit.android.model.Conversation> r0 = r2.conversations     // Catch:{ all -> 0x02bc }
            java.lang.String r7 = r6.getConversationId()     // Catch:{ all -> 0x02bc }
            r0.put(r7, r4)     // Catch:{ all -> 0x02bc }
            goto L_0x02bf
        L_0x02bc:
            r0 = move-exception
            r2 = 0
            goto L_0x02dc
        L_0x02bf:
            zendesk.conversationkit.android.internal.Effect$MessageReceived r0 = new zendesk.conversationkit.android.internal.Effect$MessageReceived     // Catch:{ all -> 0x02bc }
            java.lang.String r4 = r6.getConversationId()     // Catch:{ all -> 0x02bc }
            java.util.Map<java.lang.String, zendesk.conversationkit.android.model.Conversation> r2 = r2.conversations     // Catch:{ all -> 0x02bc }
            java.lang.String r6 = r6.getConversationId()     // Catch:{ all -> 0x02bc }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x02bc }
            zendesk.conversationkit.android.model.Conversation r2 = (zendesk.conversationkit.android.model.Conversation) r2     // Catch:{ all -> 0x02bc }
            r0.<init>(r3, r4, r2)     // Catch:{ all -> 0x02bc }
            r2 = 0
            r5.unlock(r2)
            return r0
        L_0x02d9:
            r0 = move-exception
            r2 = r7
            r5 = r8
        L_0x02dc:
            r5.unlock(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processMessageReceived(zendesk.conversationkit.android.internal.Action$MessageReceived, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processSentFileMessageReceived(zendesk.conversationkit.android.model.Message r24, zendesk.conversationkit.android.model.Conversation r25, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r26) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            boolean r2 = r1 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processSentFileMessageReceived$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processSentFileMessageReceived$1 r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processSentFileMessageReceived$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processSentFileMessageReceived$1 r2 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processSentFileMessageReceived$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x0047
            if (r4 != r5) goto L_0x003f
            java.lang.Object r3 = r2.L$3
            zendesk.conversationkit.android.model.Conversation r3 = (zendesk.conversationkit.android.model.Conversation) r3
            java.lang.Object r4 = r2.L$2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r2.L$1
            zendesk.conversationkit.android.model.Message r5 = (zendesk.conversationkit.android.model.Message) r5
            java.lang.Object r2 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00da
        L_0x003f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r1)
            java.util.List r1 = r25.getMessages()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r6)
            r4.<init>(r6)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r1 = r1.iterator()
        L_0x0061:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x00a0
            java.lang.Object r6 = r1.next()
            zendesk.conversationkit.android.model.Message r6 = (zendesk.conversationkit.android.model.Message) r6
            java.lang.String r7 = r6.getLocalId()
            java.lang.String r8 = r24.getLocalId()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x009c
            java.time.LocalDateTime r12 = r6.getCreated()
            zendesk.conversationkit.android.model.Author r10 = r6.getAuthor()
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 2037(0x7f5, float:2.854E-42)
            r22 = 0
            r8 = r24
            zendesk.conversationkit.android.model.Message r6 = zendesk.conversationkit.android.model.Message.copy$default(r8, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22)
        L_0x009c:
            r4.add(r6)
            goto L_0x0061
        L_0x00a0:
            r19 = r4
            java.util.List r19 = (java.util.List) r19
            java.lang.String r4 = r25.getId()
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 6143(0x17ff, float:8.608E-42)
            r22 = 0
            r7 = r25
            zendesk.conversationkit.android.model.Conversation r1 = zendesk.conversationkit.android.model.Conversation.copy$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            zendesk.conversationkit.android.internal.user.UserStorage r6 = r0.userStorage
            r2.L$0 = r0
            r7 = r24
            r2.L$1 = r7
            r2.L$2 = r4
            r2.L$3 = r1
            r2.label = r5
            java.lang.Object r2 = r6.setConversation(r1, r2)
            if (r2 != r3) goto L_0x00d7
            return r3
        L_0x00d7:
            r2 = r0
            r3 = r1
            r5 = r7
        L_0x00da:
            java.util.Map<java.lang.String, zendesk.conversationkit.android.model.Conversation> r1 = r2.conversations
            r1.put(r4, r3)
            zendesk.conversationkit.android.internal.Effect$MessageReceived r1 = new zendesk.conversationkit.android.internal.Effect$MessageReceived
            java.util.Map<java.lang.String, zendesk.conversationkit.android.model.Conversation> r2 = r2.conversations
            java.lang.Object r2 = r2.get(r4)
            zendesk.conversationkit.android.model.Conversation r2 = (zendesk.conversationkit.android.model.Conversation) r2
            r1.<init>(r5, r4, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processSentFileMessageReceived(zendesk.conversationkit.android.model.Message, zendesk.conversationkit.android.model.Conversation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x015f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00da A[Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00dc A[Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00df A[Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e2 A[Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0102 A[Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0161 A[Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }, LOOP:0: B:78:0x011a->B:94:0x0161, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0167 A[Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x016a A[Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processLoadMoreMessages(zendesk.conversationkit.android.internal.Action.LoadMoreMessages r34, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r35) {
        /*
            r33 = this;
            r1 = r33
            r0 = r35
            boolean r2 = r0 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processLoadMoreMessages$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processLoadMoreMessages$1 r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processLoadMoreMessages$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processLoadMoreMessages$1 r2 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processLoadMoreMessages$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            java.lang.String r5 = "UserActionProcessor"
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 1
            r11 = 0
            if (r4 == 0) goto L_0x00b9
            if (r4 == r10) goto L_0x00a5
            if (r4 == r9) goto L_0x0089
            if (r4 == r8) goto L_0x0065
            if (r4 == r7) goto L_0x0046
            if (r4 != r6) goto L_0x003e
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x030f
        L_0x003e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0046:
            java.lang.Object r4 = r2.L$3
            zendesk.conversationkit.android.model.Conversation r4 = (zendesk.conversationkit.android.model.Conversation) r4
            java.lang.Object r7 = r2.L$2
            zendesk.conversationkit.android.model.MessageList r7 = (zendesk.conversationkit.android.model.MessageList) r7
            java.lang.Object r8 = r2.L$1
            zendesk.conversationkit.android.internal.Action$LoadMoreMessages r8 = (zendesk.conversationkit.android.internal.Action.LoadMoreMessages) r8
            java.lang.Object r9 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r9 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r9
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ JsonDataException -> 0x0061, all -> 0x005d }
            r6 = r4
            r4 = r8
            goto L_0x02a2
        L_0x005d:
            r0 = move-exception
            r4 = r8
            goto L_0x02ef
        L_0x0061:
            r0 = move-exception
            r4 = r8
            goto L_0x033b
        L_0x0065:
            java.lang.Object r4 = r2.L$3
            zendesk.conversationkit.android.model.MessageList r4 = (zendesk.conversationkit.android.model.MessageList) r4
            java.lang.Object r8 = r2.L$2
            zendesk.conversationkit.android.model.Conversation r8 = (zendesk.conversationkit.android.model.Conversation) r8
            java.lang.Object r9 = r2.L$1
            zendesk.conversationkit.android.internal.Action$LoadMoreMessages r9 = (zendesk.conversationkit.android.internal.Action.LoadMoreMessages) r9
            java.lang.Object r10 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r10 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r10
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ JsonDataException -> 0x0084, all -> 0x007f }
            r0 = r4
            r16 = r8
            r4 = r9
            r9 = r10
            goto L_0x024f
        L_0x007f:
            r0 = move-exception
            r4 = r9
            r9 = r10
            goto L_0x02ef
        L_0x0084:
            r0 = move-exception
            r4 = r9
            r9 = r10
            goto L_0x033b
        L_0x0089:
            java.lang.Object r4 = r2.L$2
            zendesk.conversationkit.android.model.Conversation r4 = (zendesk.conversationkit.android.model.Conversation) r4
            java.lang.Object r9 = r2.L$1
            zendesk.conversationkit.android.internal.Action$LoadMoreMessages r9 = (zendesk.conversationkit.android.internal.Action.LoadMoreMessages) r9
            java.lang.Object r12 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r12 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r12
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ JsonDataException -> 0x00a2, all -> 0x009f }
            r32 = r9
            r9 = r4
            r4 = r32
            goto L_0x00fe
        L_0x009f:
            r0 = move-exception
            r4 = r9
            goto L_0x00b2
        L_0x00a2:
            r0 = move-exception
            r4 = r9
            goto L_0x00b6
        L_0x00a5:
            java.lang.Object r4 = r2.L$1
            zendesk.conversationkit.android.internal.Action$LoadMoreMessages r4 = (zendesk.conversationkit.android.internal.Action.LoadMoreMessages) r4
            java.lang.Object r12 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r12 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r12
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            goto L_0x00d0
        L_0x00b1:
            r0 = move-exception
        L_0x00b2:
            r9 = r12
            goto L_0x02ef
        L_0x00b5:
            r0 = move-exception
        L_0x00b6:
            r9 = r12
            goto L_0x033b
        L_0x00b9:
            kotlin.ResultKt.throwOnFailure(r0)
            java.lang.String r0 = r34.getConversationId()     // Catch:{ JsonDataException -> 0x0337, all -> 0x02eb }
            r2.L$0 = r1     // Catch:{ JsonDataException -> 0x0337, all -> 0x02eb }
            r4 = r34
            r2.L$1 = r4     // Catch:{ JsonDataException -> 0x02e9, all -> 0x02e7 }
            r2.label = r10     // Catch:{ JsonDataException -> 0x02e9, all -> 0x02e7 }
            java.lang.Object r0 = r1.getPersistedConversation(r0, r2)     // Catch:{ JsonDataException -> 0x02e9, all -> 0x02e7 }
            if (r0 != r3) goto L_0x00cf
            return r3
        L_0x00cf:
            r12 = r1
        L_0x00d0:
            zendesk.conversationkit.android.model.Conversation r0 = (zendesk.conversationkit.android.model.Conversation) r0     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r0 == 0) goto L_0x00dc
            boolean r13 = r0.getHasPrevious()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r13 != 0) goto L_0x00dc
            r13 = r10
            goto L_0x00dd
        L_0x00dc:
            r13 = r11
        L_0x00dd:
            if (r13 == 0) goto L_0x00e2
            zendesk.conversationkit.android.internal.Effect$None r0 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            return r0
        L_0x00e2:
            java.lang.String r13 = r4.getConversationId()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            double r14 = r4.getBeforeTimestamp()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r2.L$0 = r12     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r2.L$1 = r4     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r2.L$2 = r0     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r2.label = r9     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.lang.Object r9 = r12.getMessagesFromNetwork(r13, r14, r2)     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r9 != r3) goto L_0x00f9
            return r3
        L_0x00f9:
            r32 = r9
            r9 = r0
            r0 = r32
        L_0x00fe:
            zendesk.conversationkit.android.model.MessageList r0 = (zendesk.conversationkit.android.model.MessageList) r0     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r9 == 0) goto L_0x0164
            java.util.List r13 = r9.getMessages()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.lang.Iterable r13 = (java.lang.Iterable) r13     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            boolean r14 = r13 instanceof java.util.Collection     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r14 == 0) goto L_0x0116
            r14 = r13
            java.util.Collection r14 = (java.util.Collection) r14     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            boolean r14 = r14.isEmpty()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r14 == 0) goto L_0x0116
            goto L_0x0164
        L_0x0116:
            java.util.Iterator r13 = r13.iterator()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
        L_0x011a:
            boolean r14 = r13.hasNext()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r14 == 0) goto L_0x0164
            java.lang.Object r14 = r13.next()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            zendesk.conversationkit.android.model.Message r14 = (zendesk.conversationkit.android.model.Message) r14     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.util.List r15 = r0.getMessages()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.lang.Iterable r15 = (java.lang.Iterable) r15     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            boolean r10 = r15 instanceof java.util.Collection     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r10 == 0) goto L_0x013b
            r10 = r15
            java.util.Collection r10 = (java.util.Collection) r10     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            boolean r10 = r10.isEmpty()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r10 == 0) goto L_0x013b
        L_0x0139:
            r6 = r11
            goto L_0x015d
        L_0x013b:
            java.util.Iterator r10 = r15.iterator()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
        L_0x013f:
            boolean r15 = r10.hasNext()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r15 == 0) goto L_0x0139
            java.lang.Object r15 = r10.next()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            zendesk.conversationkit.android.model.Message r15 = (zendesk.conversationkit.android.model.Message) r15     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.lang.String r6 = r14.getId()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.lang.String r15 = r15.getId()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r15)     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r6 == 0) goto L_0x015b
            r6 = 1
            goto L_0x015d
        L_0x015b:
            r6 = 5
            goto L_0x013f
        L_0x015d:
            if (r6 == 0) goto L_0x0161
            r10 = 1
            goto L_0x0165
        L_0x0161:
            r6 = 5
            r10 = 1
            goto L_0x011a
        L_0x0164:
            r10 = r11
        L_0x0165:
            if (r10 == 0) goto L_0x016a
            zendesk.conversationkit.android.internal.Effect$None r0 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            return r0
        L_0x016a:
            r6 = 10
            if (r9 == 0) goto L_0x019a
            java.util.List r10 = r9.getMessages()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            int r14 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r6)     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r13.<init>(r14)     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.util.Collection r13 = (java.util.Collection) r13     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
        L_0x0183:
            boolean r14 = r10.hasNext()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r14 == 0) goto L_0x0197
            java.lang.Object r14 = r10.next()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            zendesk.conversationkit.android.model.Message r14 = (zendesk.conversationkit.android.model.Message) r14     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            zendesk.conversationkit.android.model.Message r14 = zendesk.conversationkit.android.model.MessageKt.enrichFormResponseFields(r14, r9)     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r13.add(r14)     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            goto L_0x0183
        L_0x0197:
            java.util.List r13 = (java.util.List) r13     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            goto L_0x019e
        L_0x019a:
            java.util.List r13 = kotlin.collections.CollectionsKt.emptyList()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
        L_0x019e:
            zendesk.conversationkit.android.model.User r10 = r12.user     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.util.List r10 = r10.getConversations()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r6)     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r14.<init>(r6)     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.util.Collection r14 = (java.util.Collection) r14     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.util.Iterator r6 = r10.iterator()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
        L_0x01b5:
            boolean r10 = r6.hasNext()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r10 == 0) goto L_0x0211
            java.lang.Object r10 = r6.next()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r16 = r10
            zendesk.conversationkit.android.model.Conversation r16 = (zendesk.conversationkit.android.model.Conversation) r16     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.lang.String r10 = r16.getId()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.lang.String r15 = r4.getConversationId()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r15)     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r10 == 0) goto L_0x020b
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            java.util.List r10 = r0.getMessages()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.util.Collection r10 = (java.util.Collection) r10     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r15 = r13
            java.lang.Iterable r15 = (java.lang.Iterable) r15     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.util.List r28 = kotlin.collections.CollectionsKt.plus(r10, r15)     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.lang.Boolean r10 = r0.getHasPrevious()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r10 == 0) goto L_0x0201
            boolean r10 = r10.booleanValue()     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r29 = r10
            goto L_0x0203
        L_0x0201:
            r29 = r11
        L_0x0203:
            r30 = 2047(0x7ff, float:2.868E-42)
            r31 = 0
            zendesk.conversationkit.android.model.Conversation r16 = zendesk.conversationkit.android.model.Conversation.copy$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
        L_0x020b:
            r10 = r16
            r14.add(r10)     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            goto L_0x01b5
        L_0x0211:
            r24 = r14
            java.util.List r24 = (java.util.List) r24     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            zendesk.conversationkit.android.model.User r6 = r12.user     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 3967(0xf7f, float:5.559E-42)
            r30 = 0
            r16 = r6
            zendesk.conversationkit.android.model.User r6 = zendesk.conversationkit.android.model.User.copy$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r12.user = r6     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            zendesk.conversationkit.android.internal.app.AppStorage r10 = r12.appStorage     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r2.L$0 = r12     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r2.L$1 = r4     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r2.L$2 = r9     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r2.L$3 = r0     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            r2.label = r8     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            java.lang.Object r6 = r10.setUser(r6, r2)     // Catch:{ JsonDataException -> 0x00b5, all -> 0x00b1 }
            if (r6 != r3) goto L_0x024c
            return r3
        L_0x024c:
            r16 = r9
            r9 = r12
        L_0x024f:
            if (r16 == 0) goto L_0x02b2
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            java.util.List r6 = r0.getMessages()     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            java.util.List r8 = r16.getMessages()     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            java.util.List r28 = kotlin.collections.CollectionsKt.plus(r6, r8)     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            java.lang.Boolean r6 = r0.getHasPrevious()     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            if (r6 == 0) goto L_0x0284
            boolean r6 = r6.booleanValue()     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            r29 = r6
            goto L_0x0286
        L_0x0284:
            r29 = r11
        L_0x0286:
            r30 = 2047(0x7ff, float:2.868E-42)
            r31 = 0
            zendesk.conversationkit.android.model.Conversation r6 = zendesk.conversationkit.android.model.Conversation.copy$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            zendesk.conversationkit.android.internal.user.UserStorage r8 = r9.userStorage     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            r2.L$0 = r9     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            r2.L$1 = r4     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            r2.L$2 = r0     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            r2.L$3 = r6     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            r2.label = r7     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            java.lang.Object r7 = r8.setConversation(r6, r2)     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            if (r7 != r3) goto L_0x02a1
            return r3
        L_0x02a1:
            r7 = r0
        L_0x02a2:
            java.util.Map<java.lang.String, zendesk.conversationkit.android.model.Conversation> r0 = r9.conversations     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            java.lang.String r8 = r4.getConversationId()     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            r0.put(r8, r6)     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            r0 = r7
            goto L_0x02b2
        L_0x02ad:
            r0 = move-exception
            goto L_0x02ef
        L_0x02af:
            r0 = move-exception
            goto L_0x033b
        L_0x02b2:
            zendesk.conversationkit.android.internal.Effect$LoadMoreMessages r6 = new zendesk.conversationkit.android.internal.Effect$LoadMoreMessages     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            java.lang.String r17 = r4.getConversationId()     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            java.util.Map<java.lang.String, zendesk.conversationkit.android.model.Conversation> r7 = r9.conversations     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            java.lang.String r8 = r4.getConversationId()     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            java.lang.Object r7 = r7.get(r8)     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            r18 = r7
            zendesk.conversationkit.android.model.Conversation r18 = (zendesk.conversationkit.android.model.Conversation) r18     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            java.util.List r7 = r0.getMessages()     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            java.lang.Object r7 = kotlin.collections.CollectionsKt.first(r7)     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            zendesk.conversationkit.android.model.Message r7 = (zendesk.conversationkit.android.model.Message) r7     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            double r19 = r7.getBeforeTimestamp()     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            zendesk.conversationkit.android.ConversationKitResult$Success r7 = new zendesk.conversationkit.android.ConversationKitResult$Success     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            java.util.List r0 = r0.getMessages()     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            r7.<init>(r0)     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            r21 = r7
            zendesk.conversationkit.android.ConversationKitResult r21 = (zendesk.conversationkit.android.ConversationKitResult) r21     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            r16 = r6
            r16.<init>(r17, r18, r19, r21)     // Catch:{ JsonDataException -> 0x02af, all -> 0x02ad }
            return r6
        L_0x02e7:
            r0 = move-exception
            goto L_0x02ee
        L_0x02e9:
            r0 = move-exception
            goto L_0x033a
        L_0x02eb:
            r0 = move-exception
            r4 = r34
        L_0x02ee:
            r9 = r1
        L_0x02ef:
            java.lang.Object[] r6 = new java.lang.Object[r11]
            java.lang.String r7 = "Failed to get messages."
            zendesk.logger.Logger.e(r5, r7, r0, r6)
            boolean r5 = zendesk.conversationkit.android.internal.ErrorKtxKt.isUnauthorizedException(r0)
            if (r5 == 0) goto L_0x0312
            r4 = 0
            r2.L$0 = r4
            r2.L$1 = r4
            r2.L$2 = r4
            r2.L$3 = r4
            r4 = 5
            r2.label = r4
            java.lang.Object r0 = r9.handleUnauthorized(r0, r2)
            if (r0 != r3) goto L_0x030f
            return r3
        L_0x030f:
            zendesk.conversationkit.android.internal.Effect r0 = (zendesk.conversationkit.android.internal.Effect) r0
            goto L_0x0336
        L_0x0312:
            zendesk.conversationkit.android.internal.Effect$LoadMoreMessages r8 = new zendesk.conversationkit.android.internal.Effect$LoadMoreMessages
            java.lang.String r3 = r4.getConversationId()
            java.util.Map<java.lang.String, zendesk.conversationkit.android.model.Conversation> r2 = r9.conversations
            java.lang.String r4 = r4.getConversationId()
            java.lang.Object r2 = r2.get(r4)
            r4 = r2
            zendesk.conversationkit.android.model.Conversation r4 = (zendesk.conversationkit.android.model.Conversation) r4
            r5 = 0
            zendesk.conversationkit.android.ConversationKitResult$Failure r2 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r2.<init>(r0)
            r7 = r2
            zendesk.conversationkit.android.ConversationKitResult r7 = (zendesk.conversationkit.android.ConversationKitResult) r7
            r2 = r8
            r2.<init>(r3, r4, r5, r7)
            r0 = r8
            zendesk.conversationkit.android.internal.Effect r0 = (zendesk.conversationkit.android.internal.Effect) r0
        L_0x0336:
            return r0
        L_0x0337:
            r0 = move-exception
            r4 = r34
        L_0x033a:
            r9 = r1
        L_0x033b:
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Object[] r2 = new java.lang.Object[r11]
            java.lang.String r3 = "GET request for Messages failed to decode malformed JSON response."
            zendesk.logger.Logger.e(r5, r3, r0, r2)
            zendesk.conversationkit.android.internal.Effect$LoadMoreMessages r2 = new zendesk.conversationkit.android.internal.Effect$LoadMoreMessages
            java.lang.String r11 = r4.getConversationId()
            java.util.Map<java.lang.String, zendesk.conversationkit.android.model.Conversation> r3 = r9.conversations
            java.lang.String r4 = r4.getConversationId()
            java.lang.Object r3 = r3.get(r4)
            r12 = r3
            zendesk.conversationkit.android.model.Conversation r12 = (zendesk.conversationkit.android.model.Conversation) r12
            r13 = 0
            zendesk.conversationkit.android.ConversationKitResult$Failure r3 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r3.<init>(r0)
            r15 = r3
            zendesk.conversationkit.android.ConversationKitResult r15 = (zendesk.conversationkit.android.ConversationKitResult) r15
            r10 = r2
            r10.<init>(r11, r12, r13, r15)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processLoadMoreMessages(zendesk.conversationkit.android.internal.Action$LoadMoreMessages, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0099 A[Catch:{ all -> 0x01ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b9 A[Catch:{ all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bf A[SYNTHETIC, Splitter:B:41:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processPrepareMessage(zendesk.conversationkit.android.internal.Action.PrepareMessage r26, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r27) {
        /*
            r25 = this;
            r1 = r25
            r0 = r27
            boolean r2 = r0 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processPrepareMessage$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processPrepareMessage$1 r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processPrepareMessage$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processPrepareMessage$1 r2 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processPrepareMessage$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 0
            r7 = 1
            if (r4 == 0) goto L_0x005f
            if (r4 == r7) goto L_0x004a
            if (r4 != r5) goto L_0x0042
            java.lang.Object r3 = r2.L$2
            kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
            java.lang.Object r4 = r2.L$1
            zendesk.conversationkit.android.internal.Action$PrepareMessage r4 = (zendesk.conversationkit.android.internal.Action.PrepareMessage) r4
            java.lang.Object r2 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x003f }
            goto L_0x00b4
        L_0x003f:
            r0 = move-exception
            goto L_0x01bc
        L_0x0042:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004a:
            java.lang.Object r4 = r2.L$2
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            java.lang.Object r8 = r2.L$1
            zendesk.conversationkit.android.internal.Action$PrepareMessage r8 = (zendesk.conversationkit.android.internal.Action.PrepareMessage) r8
            java.lang.Object r9 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r9 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r9
            kotlin.ResultKt.throwOnFailure(r0)
            r24 = r8
            r8 = r4
            r4 = r24
            goto L_0x0077
        L_0x005f:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlinx.coroutines.sync.Mutex r0 = r1.sendMessageMutex
            r2.L$0 = r1
            r4 = r26
            r2.L$1 = r4
            r2.L$2 = r0
            r2.label = r7
            java.lang.Object r8 = r0.lock(r6, r2)
            if (r8 != r3) goto L_0x0075
            return r3
        L_0x0075:
            r8 = r0
            r9 = r1
        L_0x0077:
            zendesk.conversationkit.android.model.Message r0 = r4.getMessage()     // Catch:{ all -> 0x01ba }
            zendesk.conversationkit.android.model.MessageContent r0 = r0.getContent()     // Catch:{ all -> 0x01ba }
            boolean r0 = r0 instanceof zendesk.conversationkit.android.model.MessageContent.Text     // Catch:{ all -> 0x01ba }
            if (r0 == 0) goto L_0x009f
            zendesk.conversationkit.android.model.Message r0 = r4.getMessage()     // Catch:{ all -> 0x01ba }
            zendesk.conversationkit.android.model.MessageContent r0 = r0.getContent()     // Catch:{ all -> 0x01ba }
            zendesk.conversationkit.android.model.MessageContent$Text r0 = (zendesk.conversationkit.android.model.MessageContent.Text) r0     // Catch:{ all -> 0x01ba }
            java.lang.String r0 = r0.getText()     // Catch:{ all -> 0x01ba }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x01ba }
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)     // Catch:{ all -> 0x01ba }
            if (r0 == 0) goto L_0x009f
            zendesk.conversationkit.android.internal.Effect$None r0 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE     // Catch:{ all -> 0x01ba }
            r8.unlock(r6)
            return r0
        L_0x009f:
            java.lang.String r0 = r4.getConversationId()     // Catch:{ all -> 0x01ba }
            r2.L$0 = r9     // Catch:{ all -> 0x01ba }
            r2.L$1 = r4     // Catch:{ all -> 0x01ba }
            r2.L$2 = r8     // Catch:{ all -> 0x01ba }
            r2.label = r5     // Catch:{ all -> 0x01ba }
            java.lang.Object r0 = r9.getPersistedConversation(r0, r2)     // Catch:{ all -> 0x01ba }
            if (r0 != r3) goto L_0x00b2
            return r3
        L_0x00b2:
            r3 = r8
            r2 = r9
        L_0x00b4:
            r8 = r0
            zendesk.conversationkit.android.model.Conversation r8 = (zendesk.conversationkit.android.model.Conversation) r8     // Catch:{ all -> 0x003f }
            if (r8 != 0) goto L_0x00bf
            zendesk.conversationkit.android.internal.Effect$None r0 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE     // Catch:{ all -> 0x003f }
            r3.unlock(r6)
            return r0
        L_0x00bf:
            java.util.List r0 = r8.getMessages()     // Catch:{ all -> 0x003f }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ all -> 0x003f }
            boolean r5 = r0 instanceof java.util.Collection     // Catch:{ all -> 0x003f }
            r9 = 0
            if (r5 == 0) goto L_0x00d5
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x003f }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x003f }
            if (r5 == 0) goto L_0x00d5
        L_0x00d3:
            r7 = r9
            goto L_0x00fc
        L_0x00d5:
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x003f }
        L_0x00d9:
            boolean r5 = r0.hasNext()     // Catch:{ all -> 0x003f }
            if (r5 == 0) goto L_0x00d3
            java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x003f }
            zendesk.conversationkit.android.model.Message r5 = (zendesk.conversationkit.android.model.Message) r5     // Catch:{ all -> 0x003f }
            zendesk.conversationkit.android.model.Message r10 = r4.getMessage()     // Catch:{ all -> 0x003f }
            boolean r10 = zendesk.conversationkit.android.model.MessageKt.remoteOrLocalIdsAreEqual(r5, r10)     // Catch:{ all -> 0x003f }
            if (r10 == 0) goto L_0x00f9
            zendesk.conversationkit.android.model.MessageStatus r5 = r5.getStatus()     // Catch:{ all -> 0x003f }
            zendesk.conversationkit.android.model.MessageStatus r10 = zendesk.conversationkit.android.model.MessageStatus.PENDING     // Catch:{ all -> 0x003f }
            if (r5 != r10) goto L_0x00f9
            r5 = r7
            goto L_0x00fa
        L_0x00f9:
            r5 = r9
        L_0x00fa:
            if (r5 == 0) goto L_0x00d9
        L_0x00fc:
            if (r7 == 0) goto L_0x0104
            zendesk.conversationkit.android.internal.Effect$None r0 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE     // Catch:{ all -> 0x003f }
            r3.unlock(r6)
            return r0
        L_0x0104:
            zendesk.conversationkit.android.model.Message r9 = r4.getMessage()     // Catch:{ all -> 0x003f }
            r10 = 0
            zendesk.conversationkit.android.model.Message r0 = r4.getMessage()     // Catch:{ all -> 0x003f }
            zendesk.conversationkit.android.model.Author r11 = r0.getAuthor()     // Catch:{ all -> 0x003f }
            zendesk.conversationkit.android.model.User r0 = r2.user     // Catch:{ all -> 0x003f }
            java.lang.String r12 = r0.getId()     // Catch:{ all -> 0x003f }
            r13 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
            r0.<init>()     // Catch:{ all -> 0x003f }
            zendesk.conversationkit.android.model.User r5 = r2.user     // Catch:{ all -> 0x003f }
            java.lang.String r5 = r5.getGivenName()     // Catch:{ all -> 0x003f }
            java.lang.String r7 = ""
            if (r5 != 0) goto L_0x0128
            r5 = r7
        L_0x0128:
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ all -> 0x003f }
            r5 = 32
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ all -> 0x003f }
            zendesk.conversationkit.android.model.User r5 = r2.user     // Catch:{ all -> 0x003f }
            java.lang.String r5 = r5.getSurname()     // Catch:{ all -> 0x003f }
            if (r5 != 0) goto L_0x013b
            goto L_0x013c
        L_0x013b:
            r7 = r5
        L_0x013c:
            java.lang.StringBuilder r0 = r0.append(r7)     // Catch:{ all -> 0x003f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x003f }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x003f }
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r0)     // Catch:{ all -> 0x003f }
            java.lang.String r14 = r0.toString()     // Catch:{ all -> 0x003f }
            r15 = 0
            r16 = 10
            r17 = 0
            zendesk.conversationkit.android.model.Author r11 = zendesk.conversationkit.android.model.Author.copy$default(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x003f }
            zendesk.conversationkit.android.model.MessageStatus r12 = zendesk.conversationkit.android.model.MessageStatus.PENDING     // Catch:{ all -> 0x003f }
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 2041(0x7f9, float:2.86E-42)
            r23 = 0
            zendesk.conversationkit.android.model.Message r0 = zendesk.conversationkit.android.model.Message.copy$default(r9, r10, r11, r12, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x003f }
            java.util.List r5 = r8.getMessages()     // Catch:{ all -> 0x003f }
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processPrepareMessage$2$updatedMessages$1 r7 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processPrepareMessage$2$updatedMessages$1     // Catch:{ all -> 0x003f }
            r7.<init>(r4)     // Catch:{ all -> 0x003f }
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7     // Catch:{ all -> 0x003f }
            java.util.List r5 = zendesk.conversationkit.android.internal.ListKtxKt.replaceOrAppend(r5, r0, r7)     // Catch:{ all -> 0x003f }
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ all -> 0x003f }
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processPrepareMessage$lambda-27$$inlined$sortedBy$1 r7 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processPrepareMessage$lambda-27$$inlined$sortedBy$1     // Catch:{ all -> 0x003f }
            r7.<init>()     // Catch:{ all -> 0x003f }
            java.util.Comparator r7 = (java.util.Comparator) r7     // Catch:{ all -> 0x003f }
            java.util.List r20 = kotlin.collections.CollectionsKt.sortedWith(r5, r7)     // Catch:{ all -> 0x003f }
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 6143(0x17ff, float:8.608E-42)
            r23 = 0
            zendesk.conversationkit.android.model.Conversation r5 = zendesk.conversationkit.android.model.Conversation.copy$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x003f }
            java.util.Map<java.lang.String, zendesk.conversationkit.android.model.Conversation> r2 = r2.conversations     // Catch:{ all -> 0x003f }
            java.lang.String r7 = r5.getId()     // Catch:{ all -> 0x003f }
            r2.put(r7, r5)     // Catch:{ all -> 0x003f }
            zendesk.conversationkit.android.internal.Effect$MessagePrepared r2 = new zendesk.conversationkit.android.internal.Effect$MessagePrepared     // Catch:{ all -> 0x003f }
            java.lang.String r4 = r4.getConversationId()     // Catch:{ all -> 0x003f }
            r2.<init>(r0, r4, r5)     // Catch:{ all -> 0x003f }
            r3.unlock(r6)
            return r2
        L_0x01ba:
            r0 = move-exception
            r3 = r8
        L_0x01bc:
            r3.unlock(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processPrepareMessage(zendesk.conversationkit.android.internal.Action$PrepareMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0127 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendMessageRestRequest(zendesk.conversationkit.android.internal.Action.SendMessage r21, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.model.Message> r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            boolean r3 = r2 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$sendMessageRestRequest$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            zendesk.conversationkit.android.internal.user.UserActionProcessor$sendMessageRestRequest$1 r3 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$sendMessageRestRequest$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$sendMessageRestRequest$1 r3 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$sendMessageRestRequest$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            r10 = 0
            if (r5 == 0) goto L_0x0083
            if (r5 == r9) goto L_0x0069
            if (r5 == r8) goto L_0x0061
            if (r5 == r7) goto L_0x0047
            if (r5 != r6) goto L_0x003f
            java.lang.Object r1 = r3.L$0
            zendesk.conversationkit.android.internal.Action$SendMessage r1 = (zendesk.conversationkit.android.internal.Action.SendMessage) r1
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0128
        L_0x003f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0047:
            java.lang.Object r1 = r3.L$3
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r7 = r3.L$1
            zendesk.conversationkit.android.internal.rest.UserRestClient r7 = (zendesk.conversationkit.android.internal.rest.UserRestClient) r7
            java.lang.Object r8 = r3.L$0
            zendesk.conversationkit.android.internal.Action$SendMessage r8 = (zendesk.conversationkit.android.internal.Action.SendMessage) r8
            kotlin.ResultKt.throwOnFailure(r2)
            r19 = r8
            r8 = r1
            r1 = r19
            goto L_0x0115
        L_0x0061:
            java.lang.Object r1 = r3.L$0
            zendesk.conversationkit.android.internal.Action$SendMessage r1 = (zendesk.conversationkit.android.internal.Action.SendMessage) r1
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00d4
        L_0x0069:
            java.lang.Object r1 = r3.L$3
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r3.L$1
            zendesk.conversationkit.android.internal.rest.UserRestClient r6 = (zendesk.conversationkit.android.internal.rest.UserRestClient) r6
            java.lang.Object r7 = r3.L$0
            zendesk.conversationkit.android.internal.Action$SendMessage r7 = (zendesk.conversationkit.android.internal.Action.SendMessage) r7
            kotlin.ResultKt.throwOnFailure(r2)
            r19 = r2
            r2 = r1
            r1 = r7
            r7 = r19
            goto L_0x00c1
        L_0x0083:
            kotlin.ResultKt.throwOnFailure(r2)
            zendesk.conversationkit.android.model.Message r2 = r21.getMessage()
            zendesk.conversationkit.android.model.MessageContent r2 = r2.getContent()
            boolean r2 = r2 instanceof zendesk.conversationkit.android.model.MessageContent.FileUpload
            if (r2 == 0) goto L_0x00f3
            zendesk.conversationkit.android.internal.rest.UserRestClient r6 = r0.userRestClient
            zendesk.conversationkit.android.model.User r2 = r0.user
            java.lang.String r5 = zendesk.conversationkit.android.internal.user.UserExtensionsKt.getAuthorization(r2)
            java.lang.String r2 = r21.getConversationId()
            zendesk.conversationkit.android.model.Message r7 = r21.getMessage()
            java.lang.String r7 = r7.getLocalId()
            zendesk.conversationkit.android.model.Message r11 = r21.getMessage()
            zendesk.conversationkit.android.model.MessageContent r11 = r11.getContent()
            zendesk.conversationkit.android.model.MessageContent$FileUpload r11 = (zendesk.conversationkit.android.model.MessageContent.FileUpload) r11
            r3.L$0 = r1
            r3.L$1 = r6
            r3.L$2 = r5
            r3.L$3 = r2
            r3.label = r9
            java.lang.Object r7 = r0.createUploadFileRequestDto(r7, r11, r3)
            if (r7 != r4) goto L_0x00c1
            return r4
        L_0x00c1:
            zendesk.conversationkit.android.internal.rest.model.UploadFileDto r7 = (zendesk.conversationkit.android.internal.rest.model.UploadFileDto) r7
            r3.L$0 = r1
            r3.L$1 = r10
            r3.L$2 = r10
            r3.L$3 = r10
            r3.label = r8
            java.lang.Object r2 = r6.uploadFile(r5, r2, r7, r3)
            if (r2 != r4) goto L_0x00d4
            return r4
        L_0x00d4:
            zendesk.conversationkit.android.internal.rest.model.UploadFileResponseDto r2 = (zendesk.conversationkit.android.internal.rest.model.UploadFileResponseDto) r2
            zendesk.conversationkit.android.model.Message r3 = r1.getMessage()
            zendesk.conversationkit.android.model.MessageStatus r6 = zendesk.conversationkit.android.model.MessageStatus.SENT
            java.lang.String r4 = r2.getMessageId()
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 2042(0x7fa, float:2.861E-42)
            r17 = 0
            zendesk.conversationkit.android.model.Message r1 = zendesk.conversationkit.android.model.Message.copy$default(r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17)
            goto L_0x015e
        L_0x00f3:
            zendesk.conversationkit.android.internal.rest.UserRestClient r2 = r0.userRestClient
            zendesk.conversationkit.android.model.User r5 = r0.user
            java.lang.String r5 = zendesk.conversationkit.android.internal.user.UserExtensionsKt.getAuthorization(r5)
            java.lang.String r8 = r21.getConversationId()
            r3.L$0 = r1
            r3.L$1 = r2
            r3.L$2 = r5
            r3.L$3 = r8
            r3.label = r7
            java.lang.Object r7 = r0.createSendMessageRequestDto(r1, r3)
            if (r7 != r4) goto L_0x0110
            return r4
        L_0x0110:
            r19 = r7
            r7 = r2
            r2 = r19
        L_0x0115:
            zendesk.conversationkit.android.internal.rest.model.SendMessageRequestDto r2 = (zendesk.conversationkit.android.internal.rest.model.SendMessageRequestDto) r2
            r3.L$0 = r1
            r3.L$1 = r10
            r3.L$2 = r10
            r3.L$3 = r10
            r3.label = r6
            java.lang.Object r2 = r7.sendMessage(r5, r8, r2, r3)
            if (r2 != r4) goto L_0x0128
            return r4
        L_0x0128:
            zendesk.conversationkit.android.internal.rest.model.SendMessageResponseDto r2 = (zendesk.conversationkit.android.internal.rest.model.SendMessageResponseDto) r2
            java.util.List r2 = r2.getMessages()
            java.lang.Object r2 = kotlin.collections.CollectionsKt.first(r2)
            zendesk.conversationkit.android.internal.rest.model.MessageDto r2 = (zendesk.conversationkit.android.internal.rest.model.MessageDto) r2
            zendesk.conversationkit.android.model.Message r3 = r1.getMessage()
            java.time.LocalDateTime r3 = r3.getCreated()
            zendesk.conversationkit.android.model.Message r1 = r1.getMessage()
            java.lang.String r1 = r1.getLocalId()
            zendesk.conversationkit.android.model.Message r4 = zendesk.conversationkit.android.model.MessageKt.toMessage(r2, r3, r1)
            r5 = 0
            r6 = 0
            zendesk.conversationkit.android.model.MessageStatus r7 = zendesk.conversationkit.android.model.MessageStatus.SENT
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 2043(0x7fb, float:2.863E-42)
            r18 = 0
            zendesk.conversationkit.android.model.Message r1 = zendesk.conversationkit.android.model.Message.copy$default(r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18)
        L_0x015e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.sendMessageRestRequest(zendesk.conversationkit.android.internal.Action$SendMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x020f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0210, code lost:
        r5 = r8;
        r7 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0252, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0253, code lost:
        r3 = null;
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r0 = r4.getConversationId();
        r2.L$0 = r9;
        r2.L$1 = r4;
        r2.L$2 = r8;
        r2.label = 2;
        r0 = r9.getPersistedConversation(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x010a, code lost:
        if (r0 != r3) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010c, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010d, code lost:
        r26 = r8;
        r8 = r4;
        r4 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r0 = (zendesk.conversationkit.android.model.Conversation) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0114, code lost:
        if (r0 != null) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0116, code lost:
        r0 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0118, code lost:
        r4.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x011b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r2.L$0 = r9;
        r2.L$1 = r8;
        r2.L$2 = r4;
        r2.L$3 = r0;
        r2.label = 3;
        r10 = r9.sendMessageRestRequest(r8, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012b, code lost:
        if (r10 != r3) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x012d, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012e, code lost:
        r15 = r8;
        r14 = r9;
        r8 = r0;
        r0 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r0 = (zendesk.conversationkit.android.model.Message) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0150, code lost:
        r7 = r14;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r8 = zendesk.conversationkit.android.model.Conversation.copy$default(r8, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (zendesk.conversationkit.android.model.ConversationType) null, false, (java.util.List) null, (java.time.LocalDateTime) null, (java.lang.Double) null, (zendesk.conversationkit.android.model.Participant) null, (java.util.List) null, kotlin.collections.CollectionsKt.sortedWith(zendesk.conversationkit.android.internal.ListKtxKt.replaceOrAppend(r8.getMessages(), r0, new zendesk.conversationkit.android.internal.user.UserActionProcessor$processSendMessage$2$updatedMessages$1(r15)), new zendesk.conversationkit.android.internal.user.UserActionProcessor$processSendMessage$lambda29$$inlined$sortedBy$1()), false, 6143, (java.lang.Object) null);
        r2.L$0 = r7;
        r2.L$1 = r5;
        r2.L$2 = r4;
        r2.L$3 = r0;
        r2.L$4 = r8;
        r2.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0190, code lost:
        if (r7.saveConversation(r8, r2) != r3) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0192, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0193, code lost:
        r9 = r4;
        r10 = r5;
        r11 = r7;
        r4 = r8;
        r8 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r0 = new zendesk.conversationkit.android.internal.Effect.SendMessageResult(new zendesk.conversationkit.android.ConversationKitResult.Success(r8), r10.getConversationId(), r8, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01ac, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01ae, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01b1, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01b2, code lost:
        r7 = r14;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01b5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01b6, code lost:
        r7 = r14;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01b9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01ba, code lost:
        r5 = r8;
        r7 = r9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0231 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01ca A[Catch:{ all -> 0x024f }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01e9 A[SYNTHETIC, Splitter:B:98:0x01e9] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:94:0x01e0=Splitter:B:94:0x01e0, B:109:0x0206=Splitter:B:109:0x0206, B:126:0x023a=Splitter:B:126:0x023a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processSendMessage(zendesk.conversationkit.android.internal.Action.SendMessage r28, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r29) {
        /*
            r27 = this;
            r1 = r27
            r0 = r29
            boolean r2 = r0 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processSendMessage$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processSendMessage$1 r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processSendMessage$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processSendMessage$1 r2 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processSendMessage$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            java.lang.String r6 = "UserActionProcessor"
            r7 = 0
            switch(r4) {
                case 0: goto L_0x00e0;
                case 1: goto L_0x00cb;
                case 2: goto L_0x00b6;
                case 3: goto L_0x008e;
                case 4: goto L_0x0069;
                case 5: goto L_0x0051;
                case 6: goto L_0x0048;
                case 7: goto L_0x0033;
                default: goto L_0x002b;
            }
        L_0x002b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0033:
            java.lang.Object r3 = r2.L$3
            zendesk.conversationkit.android.internal.user.UserActionProcessor r3 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r3
            java.lang.Object r4 = r2.L$2
            zendesk.conversationkit.android.internal.Action$SendMessage r4 = (zendesk.conversationkit.android.internal.Action.SendMessage) r4
            java.lang.Object r5 = r2.L$1
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            java.lang.Object r2 = r2.L$0
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0066 }
            goto L_0x0206
        L_0x0048:
            java.lang.Object r2 = r2.L$0
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0066 }
            goto L_0x01e0
        L_0x0051:
            java.lang.Object r3 = r2.L$3
            zendesk.conversationkit.android.internal.user.UserActionProcessor r3 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r3
            java.lang.Object r4 = r2.L$2
            zendesk.conversationkit.android.internal.Action$SendMessage r4 = (zendesk.conversationkit.android.internal.Action.SendMessage) r4
            java.lang.Object r5 = r2.L$1
            com.squareup.moshi.JsonDataException r5 = (com.squareup.moshi.JsonDataException) r5
            java.lang.Object r2 = r2.L$0
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0066 }
            goto L_0x023a
        L_0x0066:
            r0 = move-exception
            goto L_0x00c8
        L_0x0069:
            java.lang.Object r4 = r2.L$4
            zendesk.conversationkit.android.model.Conversation r4 = (zendesk.conversationkit.android.model.Conversation) r4
            java.lang.Object r8 = r2.L$3
            zendesk.conversationkit.android.model.Message r8 = (zendesk.conversationkit.android.model.Message) r8
            java.lang.Object r9 = r2.L$2
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r10 = r2.L$1
            zendesk.conversationkit.android.internal.Action$SendMessage r10 = (zendesk.conversationkit.android.internal.Action.SendMessage) r10
            java.lang.Object r11 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r11 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r11
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ JsonDataException -> 0x0088, all -> 0x0082 }
            goto L_0x0198
        L_0x0082:
            r0 = move-exception
            r4 = r9
            r5 = r10
            r7 = r11
            goto L_0x01bc
        L_0x0088:
            r0 = move-exception
            r4 = r9
            r5 = r10
            r7 = r11
            goto L_0x0212
        L_0x008e:
            java.lang.Object r4 = r2.L$3
            zendesk.conversationkit.android.model.Conversation r4 = (zendesk.conversationkit.android.model.Conversation) r4
            java.lang.Object r8 = r2.L$2
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r9 = r2.L$1
            zendesk.conversationkit.android.internal.Action$SendMessage r9 = (zendesk.conversationkit.android.internal.Action.SendMessage) r9
            java.lang.Object r10 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r10 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r10
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ JsonDataException -> 0x00b0, all -> 0x00aa }
            r15 = r9
            r14 = r10
            r26 = r8
            r8 = r4
            r4 = r26
            goto L_0x0132
        L_0x00aa:
            r0 = move-exception
            r4 = r8
            r5 = r9
            r7 = r10
            goto L_0x01bc
        L_0x00b0:
            r0 = move-exception
            r4 = r8
            r5 = r9
            r7 = r10
            goto L_0x0212
        L_0x00b6:
            java.lang.Object r4 = r2.L$2
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            java.lang.Object r8 = r2.L$1
            zendesk.conversationkit.android.internal.Action$SendMessage r8 = (zendesk.conversationkit.android.internal.Action.SendMessage) r8
            java.lang.Object r9 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r9 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r9
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00c6 }
            goto L_0x0112
        L_0x00c6:
            r0 = move-exception
            r2 = r4
        L_0x00c8:
            r3 = r7
            goto L_0x0255
        L_0x00cb:
            java.lang.Object r4 = r2.L$2
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            java.lang.Object r8 = r2.L$1
            zendesk.conversationkit.android.internal.Action$SendMessage r8 = (zendesk.conversationkit.android.internal.Action.SendMessage) r8
            java.lang.Object r9 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r9 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r9
            kotlin.ResultKt.throwOnFailure(r0)
            r26 = r8
            r8 = r4
            r4 = r26
            goto L_0x00f9
        L_0x00e0:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlinx.coroutines.sync.Mutex r0 = r1.sendMessageMutex
            r2.L$0 = r1
            r4 = r28
            r2.L$1 = r4
            r2.L$2 = r0
            r8 = 1
            r2.label = r8
            java.lang.Object r8 = r0.lock(r7, r2)
            if (r8 != r3) goto L_0x00f7
            return r3
        L_0x00f7:
            r8 = r0
            r9 = r1
        L_0x00f9:
            java.lang.String r0 = r4.getConversationId()     // Catch:{ all -> 0x0252 }
            r2.L$0 = r9     // Catch:{ all -> 0x0252 }
            r2.L$1 = r4     // Catch:{ all -> 0x0252 }
            r2.L$2 = r8     // Catch:{ all -> 0x0252 }
            r10 = 2
            r2.label = r10     // Catch:{ all -> 0x0252 }
            java.lang.Object r0 = r9.getPersistedConversation(r0, r2)     // Catch:{ all -> 0x0252 }
            if (r0 != r3) goto L_0x010d
            return r3
        L_0x010d:
            r26 = r8
            r8 = r4
            r4 = r26
        L_0x0112:
            zendesk.conversationkit.android.model.Conversation r0 = (zendesk.conversationkit.android.model.Conversation) r0     // Catch:{ all -> 0x00c6 }
            if (r0 != 0) goto L_0x011c
            zendesk.conversationkit.android.internal.Effect$None r0 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE     // Catch:{ all -> 0x00c6 }
            r4.unlock(r7)
            return r0
        L_0x011c:
            r2.L$0 = r9     // Catch:{ JsonDataException -> 0x020f, all -> 0x01b9 }
            r2.L$1 = r8     // Catch:{ JsonDataException -> 0x020f, all -> 0x01b9 }
            r2.L$2 = r4     // Catch:{ JsonDataException -> 0x020f, all -> 0x01b9 }
            r2.L$3 = r0     // Catch:{ JsonDataException -> 0x020f, all -> 0x01b9 }
            r10 = 3
            r2.label = r10     // Catch:{ JsonDataException -> 0x020f, all -> 0x01b9 }
            java.lang.Object r10 = r9.sendMessageRestRequest(r8, r2)     // Catch:{ JsonDataException -> 0x020f, all -> 0x01b9 }
            if (r10 != r3) goto L_0x012e
            return r3
        L_0x012e:
            r15 = r8
            r14 = r9
            r8 = r0
            r0 = r10
        L_0x0132:
            zendesk.conversationkit.android.model.Message r0 = (zendesk.conversationkit.android.model.Message) r0     // Catch:{ JsonDataException -> 0x01b5, all -> 0x01b1 }
            java.util.List r9 = r8.getMessages()     // Catch:{ JsonDataException -> 0x01b5, all -> 0x01b1 }
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processSendMessage$2$updatedMessages$1 r10 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processSendMessage$2$updatedMessages$1     // Catch:{ JsonDataException -> 0x01b5, all -> 0x01b1 }
            r10.<init>(r15)     // Catch:{ JsonDataException -> 0x01b5, all -> 0x01b1 }
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10     // Catch:{ JsonDataException -> 0x01b5, all -> 0x01b1 }
            java.util.List r9 = zendesk.conversationkit.android.internal.ListKtxKt.replaceOrAppend(r9, r0, r10)     // Catch:{ JsonDataException -> 0x01b5, all -> 0x01b1 }
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ JsonDataException -> 0x01b5, all -> 0x01b1 }
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processSendMessage$lambda-29$$inlined$sortedBy$1 r10 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processSendMessage$lambda-29$$inlined$sortedBy$1     // Catch:{ JsonDataException -> 0x01b5, all -> 0x01b1 }
            r10.<init>()     // Catch:{ JsonDataException -> 0x01b5, all -> 0x01b1 }
            java.util.Comparator r10 = (java.util.Comparator) r10     // Catch:{ JsonDataException -> 0x01b5, all -> 0x01b1 }
            java.util.List r20 = kotlin.collections.CollectionsKt.sortedWith(r9, r10)     // Catch:{ JsonDataException -> 0x01b5, all -> 0x01b1 }
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 6143(0x17ff, float:8.608E-42)
            r25 = 0
            r7 = r14
            r14 = r16
            r5 = r15
            r15 = r17
            r16 = r18
            r17 = r19
            r18 = r21
            r19 = r22
            r21 = r23
            r22 = r24
            r23 = r25
            zendesk.conversationkit.android.model.Conversation r8 = zendesk.conversationkit.android.model.Conversation.copy$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ JsonDataException -> 0x01ae, all -> 0x01ac }
            r2.L$0 = r7     // Catch:{ JsonDataException -> 0x01ae, all -> 0x01ac }
            r2.L$1 = r5     // Catch:{ JsonDataException -> 0x01ae, all -> 0x01ac }
            r2.L$2 = r4     // Catch:{ JsonDataException -> 0x01ae, all -> 0x01ac }
            r2.L$3 = r0     // Catch:{ JsonDataException -> 0x01ae, all -> 0x01ac }
            r2.L$4 = r8     // Catch:{ JsonDataException -> 0x01ae, all -> 0x01ac }
            r9 = 4
            r2.label = r9     // Catch:{ JsonDataException -> 0x01ae, all -> 0x01ac }
            java.lang.Object r9 = r7.saveConversation(r8, r2)     // Catch:{ JsonDataException -> 0x01ae, all -> 0x01ac }
            if (r9 != r3) goto L_0x0193
            return r3
        L_0x0193:
            r9 = r4
            r10 = r5
            r11 = r7
            r4 = r8
            r8 = r0
        L_0x0198:
            zendesk.conversationkit.android.internal.Effect$SendMessageResult r0 = new zendesk.conversationkit.android.internal.Effect$SendMessageResult     // Catch:{ JsonDataException -> 0x0088, all -> 0x0082 }
            zendesk.conversationkit.android.ConversationKitResult$Success r5 = new zendesk.conversationkit.android.ConversationKitResult$Success     // Catch:{ JsonDataException -> 0x0088, all -> 0x0082 }
            r5.<init>(r8)     // Catch:{ JsonDataException -> 0x0088, all -> 0x0082 }
            zendesk.conversationkit.android.ConversationKitResult r5 = (zendesk.conversationkit.android.ConversationKitResult) r5     // Catch:{ JsonDataException -> 0x0088, all -> 0x0082 }
            java.lang.String r7 = r10.getConversationId()     // Catch:{ JsonDataException -> 0x0088, all -> 0x0082 }
            r0.<init>(r5, r7, r8, r4)     // Catch:{ JsonDataException -> 0x0088, all -> 0x0082 }
            zendesk.conversationkit.android.internal.Effect r0 = (zendesk.conversationkit.android.internal.Effect) r0     // Catch:{ JsonDataException -> 0x0088, all -> 0x0082 }
            goto L_0x020d
        L_0x01ac:
            r0 = move-exception
            goto L_0x01bc
        L_0x01ae:
            r0 = move-exception
            goto L_0x0212
        L_0x01b1:
            r0 = move-exception
            r7 = r14
            r5 = r15
            goto L_0x01bc
        L_0x01b5:
            r0 = move-exception
            r7 = r14
            r5 = r15
            goto L_0x0212
        L_0x01b9:
            r0 = move-exception
            r5 = r8
            r7 = r9
        L_0x01bc:
            java.lang.String r8 = "Failed to send message."
            r9 = 0
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x024f }
            zendesk.logger.Logger.e(r6, r8, r0, r9)     // Catch:{ all -> 0x024f }
            boolean r6 = zendesk.conversationkit.android.internal.ErrorKtxKt.isUnauthorizedException(r0)     // Catch:{ all -> 0x024f }
            if (r6 == 0) goto L_0x01e9
            r2.L$0 = r4     // Catch:{ all -> 0x024f }
            r5 = 0
            r2.L$1 = r5     // Catch:{ all -> 0x01e4 }
            r2.L$2 = r5     // Catch:{ all -> 0x01e4 }
            r2.L$3 = r5     // Catch:{ all -> 0x01e4 }
            r2.L$4 = r5     // Catch:{ all -> 0x01e4 }
            r5 = 6
            r2.label = r5     // Catch:{ all -> 0x024f }
            java.lang.Object r0 = r7.handleUnauthorized(r0, r2)     // Catch:{ all -> 0x024f }
            if (r0 != r3) goto L_0x01df
            return r3
        L_0x01df:
            r2 = r4
        L_0x01e0:
            zendesk.conversationkit.android.internal.Effect r0 = (zendesk.conversationkit.android.internal.Effect) r0     // Catch:{ all -> 0x0248 }
            goto L_0x0242
        L_0x01e4:
            r0 = move-exception
            r2 = r4
            r3 = r5
            goto L_0x0255
        L_0x01e9:
            r2.L$0 = r4     // Catch:{ all -> 0x024f }
            r2.L$1 = r0     // Catch:{ all -> 0x024f }
            r2.L$2 = r5     // Catch:{ all -> 0x024f }
            r2.L$3 = r7     // Catch:{ all -> 0x024f }
            r6 = 0
            r2.L$4 = r6     // Catch:{ all -> 0x024b }
            r6 = 7
            r2.label = r6     // Catch:{ all -> 0x024f }
            java.lang.Object r2 = r7.transformFailedMessage(r5, r2)     // Catch:{ all -> 0x024f }
            if (r2 != r3) goto L_0x01fe
            return r3
        L_0x01fe:
            r3 = r7
            r26 = r5
            r5 = r0
            r0 = r2
            r2 = r4
            r4 = r26
        L_0x0206:
            zendesk.conversationkit.android.model.Conversation r0 = (zendesk.conversationkit.android.model.Conversation) r0     // Catch:{ all -> 0x0248 }
            zendesk.conversationkit.android.internal.Effect r0 = r3.createSendMessageFailedResult(r4, r0, r5)     // Catch:{ all -> 0x0248 }
            goto L_0x0242
        L_0x020d:
            r2 = 0
            goto L_0x0244
        L_0x020f:
            r0 = move-exception
            r5 = r8
            r7 = r9
        L_0x0212:
            java.lang.String r8 = "POST request for Sending Message failed to decode malformed JSON response."
            r9 = r0
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ all -> 0x024f }
            r10 = 0
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ all -> 0x024f }
            zendesk.logger.Logger.e(r6, r8, r9, r10)     // Catch:{ all -> 0x024f }
            r2.L$0 = r4     // Catch:{ all -> 0x024f }
            r2.L$1 = r0     // Catch:{ all -> 0x024f }
            r2.L$2 = r5     // Catch:{ all -> 0x024f }
            r2.L$3 = r7     // Catch:{ all -> 0x024f }
            r6 = 0
            r2.L$4 = r6     // Catch:{ all -> 0x024b }
            r6 = 5
            r2.label = r6     // Catch:{ all -> 0x024f }
            java.lang.Object r2 = r7.transformFailedMessage(r5, r2)     // Catch:{ all -> 0x024f }
            if (r2 != r3) goto L_0x0232
            return r3
        L_0x0232:
            r3 = r7
            r26 = r5
            r5 = r0
            r0 = r2
            r2 = r4
            r4 = r26
        L_0x023a:
            zendesk.conversationkit.android.model.Conversation r0 = (zendesk.conversationkit.android.model.Conversation) r0     // Catch:{ all -> 0x0248 }
            java.lang.Throwable r5 = (java.lang.Throwable) r5     // Catch:{ all -> 0x0248 }
            zendesk.conversationkit.android.internal.Effect r0 = r3.createSendMessageFailedResult(r4, r0, r5)     // Catch:{ all -> 0x0248 }
        L_0x0242:
            r9 = r2
            goto L_0x020d
        L_0x0244:
            r9.unlock(r2)
            return r0
        L_0x0248:
            r0 = move-exception
        L_0x0249:
            r3 = 0
            goto L_0x0255
        L_0x024b:
            r0 = move-exception
            r2 = r4
            r3 = r6
            goto L_0x0255
        L_0x024f:
            r0 = move-exception
            r2 = r4
            goto L_0x0249
        L_0x0252:
            r0 = move-exception
            r3 = r7
            r2 = r8
        L_0x0255:
            r2.unlock(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processSendMessage(zendesk.conversationkit.android.internal.Action$SendMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object transformFailedMessage(Action.SendMessage sendMessage, Continuation<? super Conversation> continuation) {
        return transformPersistedConversation(sendMessage.getConversationId(), new UserActionProcessor$transformFailedMessage$2(sendMessage), continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        if (r4 == null) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final zendesk.conversationkit.android.internal.Effect createSendMessageFailedResult(zendesk.conversationkit.android.internal.Action.SendMessage r21, zendesk.conversationkit.android.model.Conversation r22, java.lang.Throwable r23) {
        /*
            r20 = this;
            r0 = r22
            zendesk.conversationkit.android.ConversationKitResult$Failure r1 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r2 = r23
            r1.<init>(r2)
            zendesk.conversationkit.android.ConversationKitResult r1 = (zendesk.conversationkit.android.ConversationKitResult) r1
            java.lang.String r2 = r21.getConversationId()
            if (r0 == 0) goto L_0x0042
            java.util.List r3 = r22.getMessages()
            if (r3 == 0) goto L_0x0042
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x001d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x003d
            java.lang.Object r4 = r3.next()
            r5 = r4
            zendesk.conversationkit.android.model.Message r5 = (zendesk.conversationkit.android.model.Message) r5
            java.lang.String r5 = r5.getId()
            zendesk.conversationkit.android.model.Message r6 = r21.getMessage()
            java.lang.String r6 = r6.getId()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x001d
            goto L_0x003e
        L_0x003d:
            r4 = 0
        L_0x003e:
            zendesk.conversationkit.android.model.Message r4 = (zendesk.conversationkit.android.model.Message) r4
            if (r4 != 0) goto L_0x005d
        L_0x0042:
            zendesk.conversationkit.android.model.Message r5 = r21.getMessage()
            r6 = 0
            r7 = 0
            zendesk.conversationkit.android.model.MessageStatus r8 = zendesk.conversationkit.android.model.MessageStatus.FAILED
            r9 = 0
            r10 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 2043(0x7fb, float:2.863E-42)
            r19 = 0
            zendesk.conversationkit.android.model.Message r4 = zendesk.conversationkit.android.model.Message.copy$default(r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19)
        L_0x005d:
            zendesk.conversationkit.android.internal.Effect$SendMessageResult r3 = new zendesk.conversationkit.android.internal.Effect$SendMessageResult
            r3.<init>(r1, r2, r4, r0)
            zendesk.conversationkit.android.internal.Effect r3 = (zendesk.conversationkit.android.internal.Effect) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.createSendMessageFailedResult(zendesk.conversationkit.android.internal.Action$SendMessage, zendesk.conversationkit.android.model.Conversation, java.lang.Throwable):zendesk.conversationkit.android.internal.Effect");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object saveConversation(zendesk.conversationkit.android.model.Conversation r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r25
            boolean r2 = r1 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$saveConversation$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            zendesk.conversationkit.android.internal.user.UserActionProcessor$saveConversation$1 r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$saveConversation$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$saveConversation$1 r2 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$saveConversation$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0046
            if (r4 == r6) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00f3
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            java.lang.Object r4 = r2.L$1
            zendesk.conversationkit.android.model.Conversation r4 = (zendesk.conversationkit.android.model.Conversation) r4
            java.lang.Object r6 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r6 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r6
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00ad
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r1)
            zendesk.conversationkit.android.internal.user.UserStorage r1 = r0.userStorage
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            java.util.List r4 = r24.getMessages()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r4 = r4.iterator()
        L_0x0069:
            boolean r13 = r4.hasNext()
            if (r13 == 0) goto L_0x008a
            java.lang.Object r13 = r4.next()
            r19 = r13
            zendesk.conversationkit.android.model.Message r19 = (zendesk.conversationkit.android.model.Message) r19
            zendesk.conversationkit.android.model.MessageStatus r5 = r19.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r6 = zendesk.conversationkit.android.model.MessageStatus.SENT
            if (r5 != r6) goto L_0x0081
            r5 = 1
            goto L_0x0082
        L_0x0081:
            r5 = 0
        L_0x0082:
            if (r5 == 0) goto L_0x0087
            r7.add(r13)
        L_0x0087:
            r5 = 2
            r6 = 1
            goto L_0x0069
        L_0x008a:
            r19 = r7
            java.util.List r19 = (java.util.List) r19
            r13 = 0
            r20 = 0
            r21 = 6143(0x17ff, float:8.608E-42)
            r22 = 0
            r7 = r24
            zendesk.conversationkit.android.model.Conversation r4 = zendesk.conversationkit.android.model.Conversation.copy$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r2.L$0 = r0
            r5 = r24
            r2.L$1 = r5
            r6 = 1
            r2.label = r6
            java.lang.Object r1 = r1.setConversation(r4, r2)
            if (r1 != r3) goto L_0x00ab
            return r3
        L_0x00ab:
            r6 = r0
            r4 = r5
        L_0x00ad:
            java.util.Map<java.lang.String, zendesk.conversationkit.android.model.Conversation> r1 = r6.conversations
            java.lang.String r5 = r4.getId()
            r1.put(r5, r4)
            zendesk.conversationkit.android.model.User r1 = r6.user
            java.util.List r1 = r1.getConversations()
            zendesk.conversationkit.android.internal.user.UserActionProcessor$saveConversation$updatedUserConversations$1 r5 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$saveConversation$updatedUserConversations$1
            r5.<init>(r4)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.util.List r15 = zendesk.conversationkit.android.internal.ListKtxKt.replace(r1, r4, r5)
            zendesk.conversationkit.android.model.User r7 = r6.user
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 3967(0xf7f, float:5.559E-42)
            r21 = 0
            zendesk.conversationkit.android.model.User r1 = zendesk.conversationkit.android.model.User.copy$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r6.user = r1
            zendesk.conversationkit.android.internal.app.AppStorage r4 = r6.appStorage
            r5 = 0
            r2.L$0 = r5
            r2.L$1 = r5
            r5 = 2
            r2.label = r5
            java.lang.Object r1 = r4.setUser(r1, r2)
            if (r1 != r3) goto L_0x00f3
            return r3
        L_0x00f3:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.saveConversation(zendesk.conversationkit.android.model.Conversation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createSendMessageRequestDto(zendesk.conversationkit.android.internal.Action.SendMessage r8, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.rest.model.SendMessageRequestDto> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$createSendMessageRequestDto$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            zendesk.conversationkit.android.internal.user.UserActionProcessor$createSendMessageRequestDto$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$createSendMessageRequestDto$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$createSendMessageRequestDto$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$createSendMessageRequestDto$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            java.lang.Object r8 = r0.L$4
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r1 = r0.L$3
            zendesk.conversationkit.android.internal.ClientDtoProvider r1 = (zendesk.conversationkit.android.internal.ClientDtoProvider) r1
            java.lang.Object r2 = r0.L$2
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r0.L$1
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r0 = r0.L$0
            zendesk.conversationkit.android.internal.Action$SendMessage r0 = (zendesk.conversationkit.android.internal.Action.SendMessage) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0077
        L_0x003e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r9)
            zendesk.conversationkit.android.model.User r9 = r7.user
            java.lang.String r9 = r9.getId()
            zendesk.conversationkit.android.model.AuthorType r2 = zendesk.conversationkit.android.model.AuthorType.USER
            java.lang.String r2 = r2.getValue$zendesk_conversationkit_conversationkit_android()
            zendesk.conversationkit.android.internal.ClientDtoProvider r4 = r7.clientDtoProvider
            zendesk.conversationkit.android.ConversationKitSettings r5 = r7.conversationKitSettings
            java.lang.String r5 = r5.getIntegrationId()
            zendesk.conversationkit.android.internal.ConversationKitStorage r6 = r7.conversationKitStorage
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r2
            r0.L$3 = r4
            r0.L$4 = r5
            r0.label = r3
            java.lang.Object r0 = r6.getClientId(r0)
            if (r0 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r3 = r9
            r9 = r0
            r1 = r4
            r0 = r8
            r8 = r5
        L_0x0077:
            java.lang.String r9 = (java.lang.String) r9
            r4 = 0
            zendesk.conversationkit.android.internal.rest.model.ClientDto r8 = r1.buildClient(r8, r9, r4)
            zendesk.conversationkit.android.model.Message r9 = r0.getMessage()
            java.lang.String r9 = r9.getLocalId()
            zendesk.conversationkit.android.internal.rest.model.AuthorDto r1 = new zendesk.conversationkit.android.internal.rest.model.AuthorDto
            r1.<init>(r3, r2, r8, r9)
            zendesk.conversationkit.android.model.Message r8 = r0.getMessage()
            zendesk.conversationkit.android.internal.rest.model.SendMessageDto r8 = zendesk.conversationkit.android.model.MessageKt.toSendMessageDto(r8)
            zendesk.conversationkit.android.internal.rest.model.SendMessageRequestDto r9 = new zendesk.conversationkit.android.internal.rest.model.SendMessageRequestDto
            r9.<init>(r1, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.createSendMessageRequestDto(zendesk.conversationkit.android.internal.Action$SendMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createUploadFileRequestDto(java.lang.String r13, zendesk.conversationkit.android.model.MessageContent.FileUpload r14, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.rest.model.UploadFileDto> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$createUploadFileRequestDto$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            zendesk.conversationkit.android.internal.user.UserActionProcessor$createUploadFileRequestDto$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$createUploadFileRequestDto$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$createUploadFileRequestDto$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$createUploadFileRequestDto$1
            r0.<init>(r12, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0076
            if (r2 == r4) goto L_0x0052
            if (r2 != r3) goto L_0x004a
            java.lang.Object r13 = r0.L$6
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r0.L$5
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r1 = r0.L$4
            zendesk.conversationkit.android.internal.ClientDtoProvider r1 = (zendesk.conversationkit.android.internal.ClientDtoProvider) r1
            java.lang.Object r2 = r0.L$3
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r0.L$2
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r0.L$1
            zendesk.conversationkit.android.model.MessageContent$FileUpload r4 = (zendesk.conversationkit.android.model.MessageContent.FileUpload) r4
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00d1
        L_0x004a:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0052:
            java.lang.Object r13 = r0.L$6
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r0.L$5
            zendesk.conversationkit.android.internal.ClientDtoProvider r14 = (zendesk.conversationkit.android.internal.ClientDtoProvider) r14
            java.lang.Object r2 = r0.L$4
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r0.L$3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r0.L$2
            zendesk.conversationkit.android.model.MessageContent$FileUpload r5 = (zendesk.conversationkit.android.model.MessageContent.FileUpload) r5
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r7 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r7
            kotlin.ResultKt.throwOnFailure(r15)
            r11 = r14
            r14 = r13
            r13 = r6
            r6 = r4
            goto L_0x00ac
        L_0x0076:
            kotlin.ResultKt.throwOnFailure(r15)
            zendesk.conversationkit.android.model.User r15 = r12.user
            java.lang.String r15 = r15.getId()
            zendesk.conversationkit.android.model.AuthorType r2 = zendesk.conversationkit.android.model.AuthorType.USER
            java.lang.String r2 = r2.getValue$zendesk_conversationkit_conversationkit_android()
            zendesk.conversationkit.android.internal.ClientDtoProvider r5 = r12.clientDtoProvider
            zendesk.conversationkit.android.ConversationKitSettings r6 = r12.conversationKitSettings
            java.lang.String r6 = r6.getIntegrationId()
            zendesk.conversationkit.android.internal.ConversationKitStorage r7 = r12.conversationKitStorage
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r14
            r0.L$3 = r15
            r0.L$4 = r2
            r0.L$5 = r5
            r0.L$6 = r6
            r0.label = r4
            java.lang.Object r4 = r7.getClientId(r0)
            if (r4 != r1) goto L_0x00a6
            return r1
        L_0x00a6:
            r7 = r12
            r11 = r5
            r5 = r14
            r14 = r6
            r6 = r15
            r15 = r4
        L_0x00ac:
            r4 = r2
            r2 = r11
            java.lang.String r15 = (java.lang.String) r15
            zendesk.conversationkit.android.internal.ConversationKitStorage r7 = r7.conversationKitStorage
            r0.L$0 = r13
            r0.L$1 = r5
            r0.L$2 = r6
            r0.L$3 = r4
            r0.L$4 = r2
            r0.L$5 = r14
            r0.L$6 = r15
            r0.label = r3
            java.lang.Object r0 = r7.getPushToken(r0)
            if (r0 != r1) goto L_0x00c9
            return r1
        L_0x00c9:
            r1 = r2
            r2 = r4
            r4 = r5
            r3 = r6
            r11 = r0
            r0 = r13
            r13 = r15
            r15 = r11
        L_0x00d1:
            java.lang.String r15 = (java.lang.String) r15
            zendesk.conversationkit.android.internal.rest.model.ClientDto r13 = r1.buildClient(r14, r13, r15)
            zendesk.conversationkit.android.internal.rest.model.AuthorDto r14 = new zendesk.conversationkit.android.internal.rest.model.AuthorDto
            r14.<init>(r3, r2, r13, r0)
            zendesk.conversationkit.android.internal.rest.model.MetadataDto r13 = new zendesk.conversationkit.android.internal.rest.model.MetadataDto
            java.util.Map r15 = kotlin.collections.MapsKt.emptyMap()
            r13.<init>(r15)
            zendesk.conversationkit.android.internal.rest.model.Upload r15 = new zendesk.conversationkit.android.internal.rest.model.Upload
            java.lang.String r6 = r4.getUri()
            java.lang.String r7 = r4.getName()
            long r8 = r4.getSize()
            java.lang.String r10 = r4.getMimeType()
            r5 = r15
            r5.<init>(r6, r7, r8, r10)
            zendesk.conversationkit.android.internal.rest.model.UploadFileDto r0 = new zendesk.conversationkit.android.internal.rest.model.UploadFileDto
            r0.<init>(r14, r13, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.createUploadFileRequestDto(java.lang.String, zendesk.conversationkit.android.model.MessageContent$FileUpload, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x012e A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object transformPersistedConversation(java.lang.String r43, kotlin.jvm.functions.Function1<? super zendesk.conversationkit.android.model.Message, zendesk.conversationkit.android.model.Message> r44, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.model.Conversation> r45) {
        /*
            r42 = this;
            r0 = r42
            r1 = r43
            r2 = r45
            boolean r3 = r2 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$transformPersistedConversation$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            zendesk.conversationkit.android.internal.user.UserActionProcessor$transformPersistedConversation$1 r3 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$transformPersistedConversation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$transformPersistedConversation$1 r3 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$transformPersistedConversation$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L_0x005e
            if (r5 == r7) goto L_0x0048
            if (r5 != r6) goto L_0x0040
            java.lang.Object r1 = r3.L$2
            zendesk.conversationkit.android.model.Conversation r1 = (zendesk.conversationkit.android.model.Conversation) r1
            java.lang.Object r4 = r3.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r3 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r3
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0128
        L_0x0040:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0048:
            java.lang.Object r1 = r3.L$2
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            java.lang.Object r5 = r3.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r8 = r3.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r8 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r8
            kotlin.ResultKt.throwOnFailure(r2)
            r41 = r2
            r2 = r1
            r1 = r5
            r5 = r41
            goto L_0x0073
        L_0x005e:
            kotlin.ResultKt.throwOnFailure(r2)
            r3.L$0 = r0
            r3.L$1 = r1
            r2 = r44
            r3.L$2 = r2
            r3.label = r7
            java.lang.Object r5 = r0.getPersistedConversation(r1, r3)
            if (r5 != r4) goto L_0x0072
            return r4
        L_0x0072:
            r8 = r0
        L_0x0073:
            r9 = r5
            zendesk.conversationkit.android.model.Conversation r9 = (zendesk.conversationkit.android.model.Conversation) r9
            if (r9 == 0) goto L_0x012e
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            java.util.List r5 = r9.getMessages()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r15 = new java.util.ArrayList
            r7 = 10
            int r7 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r7)
            r15.<init>(r7)
            java.util.Collection r15 = (java.util.Collection) r15
            java.util.Iterator r5 = r5.iterator()
        L_0x009e:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00b0
            java.lang.Object r7 = r5.next()
            java.lang.Object r7 = r2.invoke(r7)
            r15.add(r7)
            goto L_0x009e
        L_0x00b0:
            r21 = r15
            java.util.List r21 = (java.util.List) r21
            r15 = 0
            r22 = 0
            r23 = 6143(0x17ff, float:8.608E-42)
            r24 = 0
            zendesk.conversationkit.android.model.Conversation r2 = zendesk.conversationkit.android.model.Conversation.copy$default(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            zendesk.conversationkit.android.internal.user.UserStorage r5 = r8.userStorage
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            java.util.List r7 = r2.getMessages()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r7 = r7.iterator()
        L_0x00e6:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x0104
            java.lang.Object r10 = r7.next()
            r11 = r10
            zendesk.conversationkit.android.model.Message r11 = (zendesk.conversationkit.android.model.Message) r11
            zendesk.conversationkit.android.model.MessageStatus r11 = r11.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r12 = zendesk.conversationkit.android.model.MessageStatus.SENT
            if (r11 != r12) goto L_0x00fd
            r11 = 1
            goto L_0x00fe
        L_0x00fd:
            r11 = 0
        L_0x00fe:
            if (r11 == 0) goto L_0x00e6
            r9.add(r10)
            goto L_0x00e6
        L_0x0104:
            r37 = r9
            java.util.List r37 = (java.util.List) r37
            r31 = 0
            r38 = 0
            r39 = 6143(0x17ff, float:8.608E-42)
            r40 = 0
            r25 = r2
            zendesk.conversationkit.android.model.Conversation r7 = zendesk.conversationkit.android.model.Conversation.copy$default(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            r3.L$0 = r8
            r3.L$1 = r1
            r3.L$2 = r2
            r3.label = r6
            java.lang.Object r3 = r5.setConversation(r7, r3)
            if (r3 != r4) goto L_0x0125
            return r4
        L_0x0125:
            r4 = r1
            r1 = r2
            r3 = r8
        L_0x0128:
            java.util.Map<java.lang.String, zendesk.conversationkit.android.model.Conversation> r2 = r3.conversations
            r2.put(r4, r1)
            goto L_0x012f
        L_0x012e:
            r1 = 0
        L_0x012f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.transformPersistedConversation(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object getPersistedConversation(String str, Continuation<? super Conversation> continuation) {
        Conversation conversation = this.conversations.get(str);
        return conversation == null ? this.userStorage.getConversation(str, continuation) : conversation;
    }

    /* access modifiers changed from: private */
    public final Object handleUnauthorized(Throwable th, Continuation<? super Effect> continuation) {
        return revokeUser(th, continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0083 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0092 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object revokeUser(java.lang.Throwable r7, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect.UserAccessRevoked> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$revokeUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            zendesk.conversationkit.android.internal.user.UserActionProcessor$revokeUser$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$revokeUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$revokeUser$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$revokeUser$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0058
            if (r2 == r5) goto L_0x004c
            if (r2 == r4) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r7 = r0.L$1
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object r0 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0094
        L_0x0038:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0040:
            java.lang.Object r7 = r0.L$1
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object r2 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0084
        L_0x004c:
            java.lang.Object r7 = r0.L$1
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object r2 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0075
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r8)
            zendesk.conversationkit.android.internal.faye.SunCoFayeClient r8 = r6.sunCoFayeClient
            r8.disconnect()
            zendesk.conversationkit.android.internal.rest.RestClientFiles r8 = r6.restClientFiles
            r8.clearCache()
            zendesk.conversationkit.android.internal.user.UserStorage r8 = r6.userStorage
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r8 = r8.clear(r0)
            if (r8 != r1) goto L_0x0074
            return r1
        L_0x0074:
            r2 = r6
        L_0x0075:
            zendesk.conversationkit.android.internal.app.AppStorage r8 = r2.appStorage
            r0.L$0 = r2
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.clearUser(r0)
            if (r8 != r1) goto L_0x0084
            return r1
        L_0x0084:
            zendesk.conversationkit.android.internal.proactivemessaging.ProactiveMessagingStorage r8 = r2.proactiveMessagingStorage
            r0.L$0 = r2
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = r8.clear(r0)
            if (r8 != r1) goto L_0x0093
            return r1
        L_0x0093:
            r0 = r2
        L_0x0094:
            zendesk.conversationkit.android.ConversationKitSettings r8 = r0.conversationKitSettings
            zendesk.conversationkit.android.model.Config r0 = r0.config
            if (r7 == 0) goto L_0x00a2
            zendesk.conversationkit.android.ConversationKitResult$Failure r1 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r1.<init>(r7)
            zendesk.conversationkit.android.ConversationKitResult r1 = (zendesk.conversationkit.android.ConversationKitResult) r1
            goto L_0x00ac
        L_0x00a2:
            zendesk.conversationkit.android.ConversationKitResult$Success r7 = new zendesk.conversationkit.android.ConversationKitResult$Success
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r7.<init>(r1)
            r1 = r7
            zendesk.conversationkit.android.ConversationKitResult r1 = (zendesk.conversationkit.android.ConversationKitResult) r1
        L_0x00ac:
            zendesk.conversationkit.android.internal.Effect$UserAccessRevoked r7 = new zendesk.conversationkit.android.internal.Effect$UserAccessRevoked
            r7.<init>(r8, r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.revokeUser(java.lang.Throwable, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object revokeUser$default(UserActionProcessor userActionProcessor, Throwable th, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        return userActionProcessor.revokeUser(th, continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object preparePushToken(zendesk.conversationkit.android.internal.Action.PreparePushToken r5, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$preparePushToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            zendesk.conversationkit.android.internal.user.UserActionProcessor$preparePushToken$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$preparePushToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$preparePushToken$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$preparePushToken$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            zendesk.conversationkit.android.internal.Action$PreparePushToken r5 = (zendesk.conversationkit.android.internal.Action.PreparePushToken) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            zendesk.conversationkit.android.internal.ConversationKitStorage r6 = r4.conversationKitStorage
            java.lang.String r2 = r5.getPushToken()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.setPushToken(r2, r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            zendesk.conversationkit.android.internal.Effect$PushTokenPrepared r6 = new zendesk.conversationkit.android.internal.Effect$PushTokenPrepared
            java.lang.String r5 = r5.getPushToken()
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.preparePushToken(zendesk.conversationkit.android.internal.Action$PreparePushToken, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c1, code lost:
        r15 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c2, code lost:
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f4, code lost:
        r15 = e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:15:0x0045, B:26:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ad A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f4 A[ExcHandler: JsonDataException (e com.squareup.moshi.JsonDataException), PHI: r14 
      PHI: (r14v2 java.lang.String) = (r14v4 java.lang.String), (r14v4 java.lang.String), (r14v8 java.lang.String), (r14v16 java.lang.String), (r14v16 java.lang.String) binds: [B:36:0x00b0, B:37:?, B:26:0x0070, B:15:0x0045, B:16:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:15:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updatePushToken(zendesk.conversationkit.android.internal.Action.UpdatePushToken r14, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$updatePushToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            zendesk.conversationkit.android.internal.user.UserActionProcessor$updatePushToken$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$updatePushToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$updatePushToken$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$updatePushToken$1
            r0.<init>(r13, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            java.lang.String r4 = "UserActionProcessor"
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x0069
            if (r2 == r7) goto L_0x004d
            if (r2 == r6) goto L_0x003d
            if (r2 != r5) goto L_0x0035
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00e1
        L_0x0035:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x003d:
            java.lang.Object r14 = r0.L$1
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r2 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ JsonDataException -> 0x00f4, all -> 0x004a }
            goto L_0x00b0
        L_0x004a:
            r15 = move-exception
            goto L_0x00c3
        L_0x004d:
            java.lang.Object r14 = r0.L$3
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r2 = r0.L$2
            zendesk.conversationkit.android.internal.rest.UserRestClient r2 = (zendesk.conversationkit.android.internal.rest.UserRestClient) r2
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r9 = r0.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r9 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r9
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ JsonDataException -> 0x0065, all -> 0x0061 }
            goto L_0x0090
        L_0x0061:
            r15 = move-exception
            r14 = r7
            r2 = r9
            goto L_0x00c3
        L_0x0065:
            r15 = move-exception
            r14 = r7
            goto L_0x00f5
        L_0x0069:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.String r14 = r14.getPushToken()
            zendesk.conversationkit.android.internal.rest.UserRestClient r2 = r13.userRestClient     // Catch:{ JsonDataException -> 0x00f4, all -> 0x00c1 }
            zendesk.conversationkit.android.model.User r15 = r13.user     // Catch:{ JsonDataException -> 0x00f4, all -> 0x00c1 }
            java.lang.String r15 = zendesk.conversationkit.android.internal.user.UserExtensionsKt.getAuthorization(r15)     // Catch:{ JsonDataException -> 0x00f4, all -> 0x00c1 }
            zendesk.conversationkit.android.internal.ConversationKitStorage r9 = r13.conversationKitStorage     // Catch:{ JsonDataException -> 0x00f4, all -> 0x00c1 }
            r0.L$0 = r13     // Catch:{ JsonDataException -> 0x00f4, all -> 0x00c1 }
            r0.L$1 = r14     // Catch:{ JsonDataException -> 0x00f4, all -> 0x00c1 }
            r0.L$2 = r2     // Catch:{ JsonDataException -> 0x00f4, all -> 0x00c1 }
            r0.L$3 = r15     // Catch:{ JsonDataException -> 0x00f4, all -> 0x00c1 }
            r0.label = r7     // Catch:{ JsonDataException -> 0x00f4, all -> 0x00c1 }
            java.lang.Object r7 = r9.getClientId(r0)     // Catch:{ JsonDataException -> 0x00f4, all -> 0x00c1 }
            if (r7 != r1) goto L_0x008b
            return r1
        L_0x008b:
            r9 = r13
            r12 = r7
            r7 = r14
            r14 = r15
            r15 = r12
        L_0x0090:
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ JsonDataException -> 0x0065, all -> 0x0061 }
            zendesk.conversationkit.android.internal.rest.model.UpdatePushTokenDto r10 = new zendesk.conversationkit.android.internal.rest.model.UpdatePushTokenDto     // Catch:{ JsonDataException -> 0x0065, all -> 0x0061 }
            zendesk.conversationkit.android.ConversationKitSettings r11 = r9.conversationKitSettings     // Catch:{ JsonDataException -> 0x0065, all -> 0x0061 }
            java.lang.String r11 = r11.getIntegrationId()     // Catch:{ JsonDataException -> 0x0065, all -> 0x0061 }
            r10.<init>(r7, r11)     // Catch:{ JsonDataException -> 0x0065, all -> 0x0061 }
            r0.L$0 = r9     // Catch:{ JsonDataException -> 0x0065, all -> 0x0061 }
            r0.L$1 = r7     // Catch:{ JsonDataException -> 0x0065, all -> 0x0061 }
            r0.L$2 = r8     // Catch:{ JsonDataException -> 0x0065, all -> 0x0061 }
            r0.L$3 = r8     // Catch:{ JsonDataException -> 0x0065, all -> 0x0061 }
            r0.label = r6     // Catch:{ JsonDataException -> 0x0065, all -> 0x0061 }
            java.lang.Object r14 = r2.updatePushToken(r14, r15, r10, r0)     // Catch:{ JsonDataException -> 0x0065, all -> 0x0061 }
            if (r14 != r1) goto L_0x00ae
            return r1
        L_0x00ae:
            r14 = r7
            r2 = r9
        L_0x00b0:
            zendesk.conversationkit.android.internal.Effect$PushTokenUpdateResult r15 = new zendesk.conversationkit.android.internal.Effect$PushTokenUpdateResult     // Catch:{ JsonDataException -> 0x00f4, all -> 0x004a }
            zendesk.conversationkit.android.ConversationKitResult$Success r6 = new zendesk.conversationkit.android.ConversationKitResult$Success     // Catch:{ JsonDataException -> 0x00f4, all -> 0x004a }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ JsonDataException -> 0x00f4, all -> 0x004a }
            r6.<init>(r7)     // Catch:{ JsonDataException -> 0x00f4, all -> 0x004a }
            zendesk.conversationkit.android.ConversationKitResult r6 = (zendesk.conversationkit.android.ConversationKitResult) r6     // Catch:{ JsonDataException -> 0x00f4, all -> 0x004a }
            r15.<init>(r6, r14)     // Catch:{ JsonDataException -> 0x00f4, all -> 0x004a }
            zendesk.conversationkit.android.internal.Effect r15 = (zendesk.conversationkit.android.internal.Effect) r15     // Catch:{ JsonDataException -> 0x00f4, all -> 0x004a }
            goto L_0x010d
        L_0x00c1:
            r15 = move-exception
            r2 = r13
        L_0x00c3:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r6 = "Failed to update push token."
            zendesk.logger.Logger.e(r4, r6, r15, r3)
            boolean r3 = zendesk.conversationkit.android.internal.ErrorKtxKt.isUnauthorizedException(r15)
            if (r3 == 0) goto L_0x00e4
            r0.L$0 = r8
            r0.L$1 = r8
            r0.L$2 = r8
            r0.L$3 = r8
            r0.label = r5
            java.lang.Object r15 = r2.handleUnauthorized(r15, r0)
            if (r15 != r1) goto L_0x00e1
            return r1
        L_0x00e1:
            zendesk.conversationkit.android.internal.Effect r15 = (zendesk.conversationkit.android.internal.Effect) r15
            goto L_0x010d
        L_0x00e4:
            zendesk.conversationkit.android.internal.Effect$PushTokenUpdateResult r0 = new zendesk.conversationkit.android.internal.Effect$PushTokenUpdateResult
            zendesk.conversationkit.android.ConversationKitResult$Failure r1 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r1.<init>(r15)
            zendesk.conversationkit.android.ConversationKitResult r1 = (zendesk.conversationkit.android.ConversationKitResult) r1
            r0.<init>(r1, r14)
            zendesk.conversationkit.android.internal.Effect r0 = (zendesk.conversationkit.android.internal.Effect) r0
            r15 = r0
            goto L_0x010d
        L_0x00f4:
            r15 = move-exception
        L_0x00f5:
            java.lang.Throwable r15 = (java.lang.Throwable) r15
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r1 = "PUT request for Updating Push Token failed to decode malformed JSON response."
            zendesk.logger.Logger.e(r4, r1, r15, r0)
            zendesk.conversationkit.android.internal.Effect$PushTokenUpdateResult r0 = new zendesk.conversationkit.android.internal.Effect$PushTokenUpdateResult
            zendesk.conversationkit.android.ConversationKitResult$Failure r1 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r1.<init>(r15)
            zendesk.conversationkit.android.ConversationKitResult r1 = (zendesk.conversationkit.android.ConversationKitResult) r1
            r0.<init>(r1, r14)
            r15 = r0
            zendesk.conversationkit.android.internal.Effect r15 = (zendesk.conversationkit.android.internal.Effect) r15
        L_0x010d:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.updatePushToken(zendesk.conversationkit.android.internal.Action$UpdatePushToken, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0097, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0098, code lost:
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0171, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0172, code lost:
        zendesk.logger.Logger.e(LOG_TAG, "POST request for Sending Activity Data failed to decode malformed JSON response.", r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return zendesk.conversationkit.android.internal.Effect.None.INSTANCE;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:20:0x006c, B:35:0x00d1] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00eb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x013b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0171 A[ExcHandler: JsonDataException (r0v2 'e' com.squareup.moshi.JsonDataException A[CUSTOM_DECLARE]), Splitter:B:35:0x00d1] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendActivityData(zendesk.conversationkit.android.internal.Action.SendActivityData r25, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r26) {
        /*
            r24 = this;
            r1 = r24
            r0 = r26
            boolean r2 = r0 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$sendActivityData$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            zendesk.conversationkit.android.internal.user.UserActionProcessor$sendActivityData$1 r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$sendActivityData$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$sendActivityData$1 r2 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$sendActivityData$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            java.lang.String r6 = "UserActionProcessor"
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 1
            r11 = 0
            if (r4 == 0) goto L_0x009b
            if (r4 == r10) goto L_0x0075
            if (r4 == r9) goto L_0x0050
            if (r4 == r8) goto L_0x0044
            if (r4 != r7) goto L_0x003c
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0169
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0044:
            java.lang.Object r4 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r4 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ JsonDataException -> 0x0171, all -> 0x004d }
            goto L_0x013d
        L_0x004d:
            r0 = move-exception
            goto L_0x0144
        L_0x0050:
            java.lang.Object r4 = r2.L$6
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r9 = r2.L$5
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r2.L$4
            zendesk.conversationkit.android.internal.ClientDtoProvider r10 = (zendesk.conversationkit.android.internal.ClientDtoProvider) r10
            java.lang.Object r12 = r2.L$3
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r2.L$2
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r2.L$1
            zendesk.conversationkit.android.internal.Action$SendActivityData r14 = (zendesk.conversationkit.android.internal.Action.SendActivityData) r14
            java.lang.Object r15 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r15 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r15
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            r18 = r12
            r17 = r13
            goto L_0x00f4
        L_0x0075:
            java.lang.Object r4 = r2.L$5
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r10 = r2.L$4
            zendesk.conversationkit.android.internal.ClientDtoProvider r10 = (zendesk.conversationkit.android.internal.ClientDtoProvider) r10
            java.lang.Object r12 = r2.L$3
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r2.L$2
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r2.L$1
            zendesk.conversationkit.android.internal.Action$SendActivityData r14 = (zendesk.conversationkit.android.internal.Action.SendActivityData) r14
            java.lang.Object r15 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r15 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r15
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            r23 = r13
            r13 = r4
            r4 = r15
            r15 = r23
            goto L_0x00d1
        L_0x0097:
            r0 = move-exception
            r4 = r15
            goto L_0x0144
        L_0x009b:
            kotlin.ResultKt.throwOnFailure(r0)
            zendesk.conversationkit.android.model.User r0 = r1.user     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            java.lang.String r0 = r0.getId()     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            zendesk.conversationkit.android.model.AuthorType r4 = zendesk.conversationkit.android.model.AuthorType.USER     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            java.lang.String r4 = r4.getValue$zendesk_conversationkit_conversationkit_android()     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            zendesk.conversationkit.android.internal.ClientDtoProvider r12 = r1.clientDtoProvider     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            zendesk.conversationkit.android.ConversationKitSettings r13 = r1.conversationKitSettings     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            java.lang.String r13 = r13.getIntegrationId()     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            zendesk.conversationkit.android.internal.ConversationKitStorage r14 = r1.conversationKitStorage     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            r2.L$0 = r1     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            r15 = r25
            r2.L$1 = r15     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            r2.L$2 = r0     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            r2.L$3 = r4     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            r2.L$4 = r12     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            r2.L$5 = r13     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            r2.label = r10     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            java.lang.Object r10 = r14.getClientId(r2)     // Catch:{ JsonDataException -> 0x0171, all -> 0x0142 }
            if (r10 != r3) goto L_0x00cb
            return r3
        L_0x00cb:
            r14 = r15
            r15 = r0
            r0 = r10
            r10 = r12
            r12 = r4
            r4 = r1
        L_0x00d1:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JsonDataException -> 0x0171, all -> 0x004d }
            zendesk.conversationkit.android.internal.ConversationKitStorage r7 = r4.conversationKitStorage     // Catch:{ JsonDataException -> 0x0171, all -> 0x004d }
            r2.L$0 = r4     // Catch:{ JsonDataException -> 0x0171, all -> 0x004d }
            r2.L$1 = r14     // Catch:{ JsonDataException -> 0x0171, all -> 0x004d }
            r2.L$2 = r15     // Catch:{ JsonDataException -> 0x0171, all -> 0x004d }
            r2.L$3 = r12     // Catch:{ JsonDataException -> 0x0171, all -> 0x004d }
            r2.L$4 = r10     // Catch:{ JsonDataException -> 0x0171, all -> 0x004d }
            r2.L$5 = r13     // Catch:{ JsonDataException -> 0x0171, all -> 0x004d }
            r2.L$6 = r0     // Catch:{ JsonDataException -> 0x0171, all -> 0x004d }
            r2.label = r9     // Catch:{ JsonDataException -> 0x0171, all -> 0x004d }
            java.lang.Object r7 = r7.getPushToken(r2)     // Catch:{ JsonDataException -> 0x0171, all -> 0x004d }
            if (r7 != r3) goto L_0x00ec
            return r3
        L_0x00ec:
            r18 = r12
            r9 = r13
            r17 = r15
            r15 = r4
            r4 = r0
            r0 = r7
        L_0x00f4:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            zendesk.conversationkit.android.internal.rest.model.ClientDto r19 = r10.buildClient(r9, r4, r0)     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            r20 = 0
            r21 = 8
            r22 = 0
            zendesk.conversationkit.android.internal.rest.model.AuthorDto r0 = new zendesk.conversationkit.android.internal.rest.model.AuthorDto     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            r16 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22)     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            zendesk.conversationkit.android.internal.rest.model.ActivityDataDto r4 = new zendesk.conversationkit.android.internal.rest.model.ActivityDataDto     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            zendesk.conversationkit.android.model.ActivityData r7 = r14.getActivityData()     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            java.lang.String r7 = r7.getType()     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            r4.<init>(r7)     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            zendesk.conversationkit.android.internal.rest.model.ActivityDataRequestDto r7 = new zendesk.conversationkit.android.internal.rest.model.ActivityDataRequestDto     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            r7.<init>(r0, r4)     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            zendesk.conversationkit.android.internal.rest.UserRestClient r0 = r15.userRestClient     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            zendesk.conversationkit.android.model.User r4 = r15.user     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            java.lang.String r4 = zendesk.conversationkit.android.internal.user.UserExtensionsKt.getAuthorization(r4)     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            java.lang.String r9 = r14.getConversationId()     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            r2.L$0 = r15     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            r2.L$1 = r11     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            r2.L$2 = r11     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            r2.L$3 = r11     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            r2.L$4 = r11     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            r2.L$5 = r11     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            r2.L$6 = r11     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            r2.label = r8     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            java.lang.Object r0 = r0.sendActivityData(r4, r9, r7, r2)     // Catch:{ JsonDataException -> 0x0171, all -> 0x0097 }
            if (r0 != r3) goto L_0x013c
            return r3
        L_0x013c:
            r4 = r15
        L_0x013d:
            zendesk.conversationkit.android.internal.Effect$None r0 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE     // Catch:{ JsonDataException -> 0x0171, all -> 0x004d }
            zendesk.conversationkit.android.internal.Effect r0 = (zendesk.conversationkit.android.internal.Effect) r0     // Catch:{ JsonDataException -> 0x0171, all -> 0x004d }
            goto L_0x017f
        L_0x0142:
            r0 = move-exception
            r4 = r1
        L_0x0144:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r7 = "Failed to send activity data."
            zendesk.logger.Logger.e(r6, r7, r0, r5)
            boolean r5 = zendesk.conversationkit.android.internal.ErrorKtxKt.isUnauthorizedException(r0)
            if (r5 == 0) goto L_0x016c
            r2.L$0 = r11
            r2.L$1 = r11
            r2.L$2 = r11
            r2.L$3 = r11
            r2.L$4 = r11
            r2.L$5 = r11
            r2.L$6 = r11
            r5 = 4
            r2.label = r5
            java.lang.Object r0 = r4.handleUnauthorized(r0, r2)
            if (r0 != r3) goto L_0x0169
            return r3
        L_0x0169:
            zendesk.conversationkit.android.internal.Effect r0 = (zendesk.conversationkit.android.internal.Effect) r0
            goto L_0x017f
        L_0x016c:
            zendesk.conversationkit.android.internal.Effect$None r0 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE
            zendesk.conversationkit.android.internal.Effect r0 = (zendesk.conversationkit.android.internal.Effect) r0
            goto L_0x017f
        L_0x0171:
            r0 = move-exception
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Object[] r2 = new java.lang.Object[r5]
            java.lang.String r3 = "POST request for Sending Activity Data failed to decode malformed JSON response."
            zendesk.logger.Logger.e(r6, r3, r0, r2)
            zendesk.conversationkit.android.internal.Effect$None r0 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE
            zendesk.conversationkit.android.internal.Effect r0 = (zendesk.conversationkit.android.internal.Effect) r0
        L_0x017f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.sendActivityData(zendesk.conversationkit.android.internal.Action$SendActivityData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object processActivityEventReceived(Action.ActivityEventReceived activityEventReceived, Continuation<? super Effect> continuation) {
        if (activityEventReceived.getActivityEvent().getActivityData() == ActivityData.CONVERSATION_READ) {
            return processConversationReadActivity(activityEventReceived.getActivityEvent(), continuation);
        }
        return processTypingActivity(activityEventReceived.getActivityEvent());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0201 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processConversationReadActivity(zendesk.conversationkit.android.model.ActivityEvent r28, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r29) {
        /*
            r27 = this;
            r0 = r27
            r1 = r29
            boolean r2 = r1 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processConversationReadActivity$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processConversationReadActivity$1 r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processConversationReadActivity$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processConversationReadActivity$1 r2 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processConversationReadActivity$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 3
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L_0x0078
            if (r4 == r7) goto L_0x0063
            if (r4 == r6) goto L_0x004d
            if (r4 != r5) goto L_0x0045
            java.lang.Object r3 = r2.L$3
            zendesk.conversationkit.android.model.Conversation r3 = (zendesk.conversationkit.android.model.Conversation) r3
            java.lang.Object r4 = r2.L$2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r2.L$1
            zendesk.conversationkit.android.model.ActivityEvent r5 = (zendesk.conversationkit.android.model.ActivityEvent) r5
            java.lang.Object r2 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r2 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0205
        L_0x0045:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004d:
            java.lang.Object r4 = r2.L$3
            zendesk.conversationkit.android.model.Conversation r4 = (zendesk.conversationkit.android.model.Conversation) r4
            java.lang.Object r6 = r2.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r2.L$1
            zendesk.conversationkit.android.model.ActivityEvent r7 = (zendesk.conversationkit.android.model.ActivityEvent) r7
            java.lang.Object r8 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r8 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r8
            kotlin.ResultKt.throwOnFailure(r1)
            r5 = r7
            goto L_0x01ee
        L_0x0063:
            java.lang.Object r4 = r2.L$2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r8 = r2.L$1
            zendesk.conversationkit.android.model.ActivityEvent r8 = (zendesk.conversationkit.android.model.ActivityEvent) r8
            java.lang.Object r9 = r2.L$0
            zendesk.conversationkit.android.internal.user.UserActionProcessor r9 = (zendesk.conversationkit.android.internal.user.UserActionProcessor) r9
            kotlin.ResultKt.throwOnFailure(r1)
            r26 = r8
            r8 = r1
            r1 = r26
            goto L_0x009a
        L_0x0078:
            kotlin.ResultKt.throwOnFailure(r1)
            zendesk.conversationkit.android.model.AuthorType r1 = r28.getRole()
            if (r1 != 0) goto L_0x0084
            zendesk.conversationkit.android.internal.Effect$None r1 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE
            return r1
        L_0x0084:
            java.lang.String r4 = r28.getConversationId()
            r2.L$0 = r0
            r1 = r28
            r2.L$1 = r1
            r2.L$2 = r4
            r2.label = r7
            java.lang.Object r8 = r0.getPersistedConversation(r4, r2)
            if (r8 != r3) goto L_0x0099
            return r3
        L_0x0099:
            r9 = r0
        L_0x009a:
            r10 = r8
            zendesk.conversationkit.android.model.Conversation r10 = (zendesk.conversationkit.android.model.Conversation) r10
            if (r10 == 0) goto L_0x020c
            zendesk.conversationkit.android.model.AuthorType r8 = r1.getRole()
            if (r8 != 0) goto L_0x00a7
            r8 = -1
            goto L_0x00af
        L_0x00a7:
            int[] r11 = zendesk.conversationkit.android.internal.user.UserActionProcessor.WhenMappings.$EnumSwitchMapping$0
            int r8 = r8.ordinal()
            r8 = r11[r8]
        L_0x00af:
            r15 = 10
            if (r8 == r7) goto L_0x00de
            if (r8 != r6) goto L_0x00d8
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r7 = 0
            r16 = 0
            r17 = 0
            java.time.LocalDateTime r18 = r1.getLastRead()
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 8063(0x1f7f, float:1.1299E-41)
            r25 = 0
            r8 = r15
            r15 = r7
            zendesk.conversationkit.android.model.Conversation r7 = zendesk.conversationkit.android.model.Conversation.copy$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            goto L_0x0182
        L_0x00d8:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x00de:
            r8 = r15
            java.util.List r7 = r10.getParticipants()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r11 = new java.util.ArrayList
            int r12 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r8)
            r11.<init>(r12)
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.Iterator r7 = r7.iterator()
        L_0x00f4:
            boolean r12 = r7.hasNext()
            if (r12 == 0) goto L_0x0123
            java.lang.Object r12 = r7.next()
            r13 = r12
            zendesk.conversationkit.android.model.Participant r13 = (zendesk.conversationkit.android.model.Participant) r13
            java.lang.String r12 = r13.getUserId()
            java.lang.String r14 = r1.getUserId()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r14)
            if (r12 == 0) goto L_0x011f
            r14 = 0
            r15 = 0
            r16 = 0
            java.time.LocalDateTime r17 = r1.getLastRead()
            r18 = 3
            r19 = 0
            zendesk.conversationkit.android.model.Participant r13 = zendesk.conversationkit.android.model.Participant.copy$default(r13, r14, r15, r16, r17, r18, r19)
        L_0x011f:
            r11.add(r13)
            goto L_0x00f4
        L_0x0123:
            r21 = r11
            java.util.List r21 = (java.util.List) r21
            java.util.List r7 = r10.getParticipants()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0131:
            boolean r11 = r7.hasNext()
            r12 = 0
            if (r11 == 0) goto L_0x014e
            java.lang.Object r11 = r7.next()
            r13 = r11
            zendesk.conversationkit.android.model.Participant r13 = (zendesk.conversationkit.android.model.Participant) r13
            java.lang.String r13 = r13.getUserId()
            java.lang.String r14 = r1.getUserId()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            if (r13 == 0) goto L_0x0131
            goto L_0x014f
        L_0x014e:
            r11 = r12
        L_0x014f:
            r13 = r11
            zendesk.conversationkit.android.model.Participant r13 = (zendesk.conversationkit.android.model.Participant) r13
            if (r13 == 0) goto L_0x0167
            r14 = 0
            r15 = 0
            r16 = 0
            java.time.LocalDateTime r17 = r1.getLastRead()
            r18 = 3
            r19 = 0
            zendesk.conversationkit.android.model.Participant r7 = zendesk.conversationkit.android.model.Participant.copy$default(r13, r14, r15, r16, r17, r18, r19)
            r20 = r7
            goto L_0x0169
        L_0x0167:
            r20 = r12
        L_0x0169:
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r22 = 0
            r23 = 0
            r24 = 6655(0x19ff, float:9.326E-42)
            r25 = 0
            zendesk.conversationkit.android.model.Conversation r7 = zendesk.conversationkit.android.model.Conversation.copy$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
        L_0x0182:
            zendesk.conversationkit.android.model.User r10 = r9.user
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            java.util.List r18 = r10.getConversations()
            r5 = r18
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            int r8 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r8)
            r6.<init>(r8)
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x01a3:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x01be
            java.lang.Object r8 = r5.next()
            zendesk.conversationkit.android.model.Conversation r8 = (zendesk.conversationkit.android.model.Conversation) r8
            java.lang.String r15 = r8.getId()
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r4)
            if (r15 == 0) goto L_0x01ba
            r8 = r7
        L_0x01ba:
            r6.add(r8)
            goto L_0x01a3
        L_0x01be:
            r18 = r6
            java.util.List r18 = (java.util.List) r18
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 3967(0xf7f, float:5.559E-42)
            r24 = 0
            r5 = 0
            r15 = r5
            zendesk.conversationkit.android.model.User r5 = zendesk.conversationkit.android.model.User.copy$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r9.user = r5
            zendesk.conversationkit.android.internal.app.AppStorage r6 = r9.appStorage
            r2.L$0 = r9
            r2.L$1 = r1
            r2.L$2 = r4
            r2.L$3 = r7
            r8 = 2
            r2.label = r8
            java.lang.Object r5 = r6.setUser(r5, r2)
            if (r5 != r3) goto L_0x01ea
            return r3
        L_0x01ea:
            r5 = r1
            r6 = r4
            r4 = r7
            r8 = r9
        L_0x01ee:
            zendesk.conversationkit.android.internal.user.UserStorage r1 = r8.userStorage
            r2.L$0 = r8
            r2.L$1 = r5
            r2.L$2 = r6
            r2.L$3 = r4
            r7 = 3
            r2.label = r7
            java.lang.Object r1 = r1.setConversation(r4, r2)
            if (r1 != r3) goto L_0x0202
            return r3
        L_0x0202:
            r3 = r4
            r4 = r6
            r2 = r8
        L_0x0205:
            java.util.Map<java.lang.String, zendesk.conversationkit.android.model.Conversation> r1 = r2.conversations
            r1.put(r4, r3)
            r9 = r2
            r1 = r5
        L_0x020c:
            zendesk.conversationkit.android.internal.Effect$ActivityEventReceived r2 = new zendesk.conversationkit.android.internal.Effect$ActivityEventReceived
            java.util.Map<java.lang.String, zendesk.conversationkit.android.model.Conversation> r3 = r9.conversations
            java.lang.Object r3 = r3.get(r4)
            zendesk.conversationkit.android.model.Conversation r3 = (zendesk.conversationkit.android.model.Conversation) r3
            r2.<init>(r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processConversationReadActivity(zendesk.conversationkit.android.model.ActivityEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Effect processTypingActivity(ActivityEvent activityEvent) {
        Logger.d(LOG_TAG, "Process typing activity: " + activityEvent.getActivityData(), new Object[0]);
        return new Effect.ActivityEventReceived(activityEvent, this.conversations.get(activityEvent.getConversationId()));
    }

    private final Effect processPersistedUserRetrieved(Action.PersistedUserRetrieve persistedUserRetrieve) {
        return new Effect.PersistedUserReceived(persistedUserRetrieve.getUser());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processAddProactiveMessage(zendesk.conversationkit.android.internal.Action.AddProactiveMessage r5, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processAddProactiveMessage$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processAddProactiveMessage$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processAddProactiveMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processAddProactiveMessage$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processAddProactiveMessage$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0044
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            zendesk.conversationkit.android.internal.proactivemessaging.ProactiveMessagingStorage r6 = r4.proactiveMessagingStorage
            zendesk.conversationkit.android.model.ProactiveMessage r5 = r5.getProactiveMessage()
            r0.label = r3
            java.lang.Object r5 = r6.setProactiveMessage(r5, r0)
            if (r5 != r1) goto L_0x0044
            return r1
        L_0x0044:
            zendesk.conversationkit.android.internal.Effect$None r5 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processAddProactiveMessage(zendesk.conversationkit.android.internal.Action$AddProactiveMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processGetProactiveMessage(zendesk.conversationkit.android.internal.Action.GetProactiveMessage r5, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zendesk.conversationkit.android.internal.user.UserActionProcessor$processGetProactiveMessage$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processGetProactiveMessage$1 r0 = (zendesk.conversationkit.android.internal.user.UserActionProcessor$processGetProactiveMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.user.UserActionProcessor$processGetProactiveMessage$1 r0 = new zendesk.conversationkit.android.internal.user.UserActionProcessor$processGetProactiveMessage$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0044
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            zendesk.conversationkit.android.internal.proactivemessaging.ProactiveMessagingStorage r6 = r4.proactiveMessagingStorage
            int r5 = r5.getProactiveMessageId()
            r0.label = r3
            java.lang.Object r6 = r6.getProactiveMessage(r5, r0)
            if (r6 != r1) goto L_0x0044
            return r1
        L_0x0044:
            zendesk.conversationkit.android.model.ProactiveMessage r6 = (zendesk.conversationkit.android.model.ProactiveMessage) r6
            zendesk.conversationkit.android.internal.Effect$GetProactiveMessage r5 = new zendesk.conversationkit.android.internal.Effect$GetProactiveMessage
            r5.<init>(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.UserActionProcessor.processGetProactiveMessage(zendesk.conversationkit.android.internal.Action$GetProactiveMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lzendesk/conversationkit/android/internal/user/UserActionProcessor$Companion;", "", "()V", "BEFORE_TIMESTAMP", "", "LOG_TAG", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UserActionProcessor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
