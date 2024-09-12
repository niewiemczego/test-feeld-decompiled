package zendesk.android.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import zendesk.android.Zendesk;
import zendesk.android.internal.ZendeskError;
import zendesk.conversationkit.android.ConnectionStatus;
import zendesk.conversationkit.android.ConversationKit;
import zendesk.conversationkit.android.ConversationKitEvent;
import zendesk.conversationkit.android.ConversationKitEventListener;
import zendesk.conversationkit.android.ConversationKitResult;
import zendesk.conversationkit.android.ConversationKitSettings;
import zendesk.conversationkit.android.model.ActivityData;
import zendesk.conversationkit.android.model.Config;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.conversationkit.android.model.Message;
import zendesk.conversationkit.android.model.ProactiveMessage;
import zendesk.conversationkit.android.model.User;
import zendesk.conversationkit.android.model.VisitType;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0019\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u001e\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\n\u0010 \u001a\u0004\u0018\u00010\u0015H\u0016J-\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0\u00112\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00112\u0006\u0010(\u001a\u00020)H@ø\u0001\u0000¢\u0006\u0002\u0010*J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u001f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u00100\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0011\u00102\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0010\u00103\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0011\u00104\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J!\u00105\u001a\u00020\t2\u0006\u00106\u001a\u0002072\u0006\u0010\u001e\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u00108J'\u00109\u001a\b\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010:\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010;J\u0019\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020.H@ø\u0001\u0000¢\u0006\u0002\u0010>J\u0019\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006A"}, d2 = {"Lzendesk/android/internal/NotInitializedConversationKit;", "Lzendesk/conversationkit/android/ConversationKit;", "()V", "connectionStatusFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lzendesk/conversationkit/android/ConnectionStatus;", "getConnectionStatusFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "addEventListener", "", "listener", "Lzendesk/conversationkit/android/ConversationKitEventListener;", "addProactiveMessage", "proactiveMessage", "Lzendesk/conversationkit/android/model/ProactiveMessage;", "(Lzendesk/conversationkit/android/model/ProactiveMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConversation", "Lzendesk/conversationkit/android/ConversationKitResult;", "Lzendesk/conversationkit/android/model/Conversation;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUser", "Lzendesk/conversationkit/android/model/User;", "dispatchEvent", "event", "Lzendesk/conversationkit/android/ConversationKitEvent;", "getClientId", "", "getConfig", "Lzendesk/conversationkit/android/model/Config;", "getConversation", "conversationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUser", "getMessages", "", "Lzendesk/conversationkit/android/model/Message;", "beforeTimestamp", "", "(Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProactiveMessage", "proactiveMessageId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "getVisitType", "Lzendesk/conversationkit/android/model/VisitType;", "loginUser", "jwt", "logoutUser", "pause", "removeEventListener", "resume", "sendActivityData", "activityData", "Lzendesk/conversationkit/android/model/ActivityData;", "(Lzendesk/conversationkit/android/model/ActivityData;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessage", "message", "(Lzendesk/conversationkit/android/model/Message;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setVisitType", "visitType", "(Lzendesk/conversationkit/android/model/VisitType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePushNotificationToken", "pushNotificationToken", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotInitializedConversationKit.kt */
public final class NotInitializedConversationKit implements ConversationKit {
    public static final NotInitializedConversationKit INSTANCE = new NotInitializedConversationKit();

    public Config getConfig() {
        return null;
    }

    public User getCurrentUser() {
        return null;
    }

    public ConversationKitSettings getSettings() {
        return null;
    }

    private NotInitializedConversationKit() {
    }

    public StateFlow<ConnectionStatus> getConnectionStatusFlow() {
        return StateFlowKt.MutableStateFlow(ConnectionStatus.DISCONNECTED);
    }

    public void addEventListener(ConversationKitEventListener conversationKitEventListener) {
        Intrinsics.checkNotNullParameter(conversationKitEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
    }

    public void removeEventListener(ConversationKitEventListener conversationKitEventListener) {
        Intrinsics.checkNotNullParameter(conversationKitEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
    }

    public Object pause(Continuation<? super Unit> continuation) {
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
        return Unit.INSTANCE;
    }

    public Object resume(Continuation<? super Unit> continuation) {
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
        return Unit.INSTANCE;
    }

    public Object getClientId(Continuation<? super String> continuation) {
        throw ZendeskError.NotInitialized.INSTANCE;
    }

    public Object createUser(Continuation<? super ConversationKitResult<User>> continuation) {
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
        return new ConversationKitResult.Failure(ZendeskError.NotInitialized.INSTANCE);
    }

    public Object loginUser(String str, Continuation<? super ConversationKitResult<User>> continuation) {
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
        return new ConversationKitResult.Failure(ZendeskError.NotInitialized.INSTANCE);
    }

    public Object logoutUser(Continuation<? super ConversationKitResult<Unit>> continuation) {
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
        return new ConversationKitResult.Failure(ZendeskError.NotInitialized.INSTANCE);
    }

    public Object createConversation(Continuation<? super ConversationKitResult<Conversation>> continuation) {
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
        return new ConversationKitResult.Failure(ZendeskError.NotInitialized.INSTANCE);
    }

    public Object getConversation(String str, Continuation<? super ConversationKitResult<Conversation>> continuation) {
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
        return new ConversationKitResult.Failure(ZendeskError.NotInitialized.INSTANCE);
    }

    public Object sendMessage(Message message, String str, Continuation<? super ConversationKitResult<Message>> continuation) {
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
        return new ConversationKitResult.Failure(ZendeskError.NotInitialized.INSTANCE);
    }

    public Object getMessages(String str, double d, Continuation<? super ConversationKitResult<? extends List<Message>>> continuation) {
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
        return new ConversationKitResult.Failure(ZendeskError.NotInitialized.INSTANCE);
    }

    public Object updatePushNotificationToken(String str, Continuation<? super Unit> continuation) {
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
        return Unit.INSTANCE;
    }

    public Object sendActivityData(ActivityData activityData, String str, Continuation<? super Unit> continuation) {
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
        return Unit.INSTANCE;
    }

    public Object getVisitType(Continuation<? super ConversationKitResult<? extends VisitType>> continuation) {
        return new ConversationKitResult.Failure(ZendeskError.NotInitialized.INSTANCE);
    }

    public Object setVisitType(VisitType visitType, Continuation<? super Unit> continuation) {
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
        return Unit.INSTANCE;
    }

    public Object addProactiveMessage(ProactiveMessage proactiveMessage, Continuation<? super Unit> continuation) {
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
        return Unit.INSTANCE;
    }

    public Object getProactiveMessage(int i, Continuation<? super ConversationKitResult<ProactiveMessage>> continuation) {
        return new ConversationKitResult.Failure(ZendeskError.NotInitialized.INSTANCE);
    }

    public void dispatchEvent(ConversationKitEvent conversationKitEvent) {
        Intrinsics.checkNotNullParameter(conversationKitEvent, "event");
        Logger.w(Zendesk.LOG_TAG, ZendeskError.NotInitialized.INSTANCE.getMessage(), new Object[0]);
    }
}
