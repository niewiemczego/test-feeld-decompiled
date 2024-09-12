package zendesk.conversationkit.android;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import zendesk.conversationkit.android.model.ActivityData;
import zendesk.conversationkit.android.model.Config;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.conversationkit.android.model.Message;
import zendesk.conversationkit.android.model.ProactiveMessage;
import zendesk.conversationkit.android.model.User;
import zendesk.conversationkit.android.model.VisitType;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0019\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u001d\u001a\u00020\u0019H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\n\u0010\u001f\u001a\u0004\u0018\u00010\u0014H&J-\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\u00102\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H¦@ø\u0001\u0000¢\u0006\u0002\u0010%J\u001f\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\u0006\u0010'\u001a\u00020(H¦@ø\u0001\u0000¢\u0006\u0002\u0010)J\n\u0010*\u001a\u0004\u0018\u00010+H&J\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0010H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00140\u00102\u0006\u0010/\u001a\u00020\u0019H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0011\u00101\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0010\u00102\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0011\u00103\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J!\u00104\u001a\u00020\b2\u0006\u00105\u001a\u0002062\u0006\u0010\u001d\u001a\u00020\u0019H¦@ø\u0001\u0000¢\u0006\u0002\u00107J'\u00108\u001a\b\u0012\u0004\u0012\u00020\"0\u00102\u0006\u00109\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u0019H¦@ø\u0001\u0000¢\u0006\u0002\u0010:J\u0019\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020-H¦@ø\u0001\u0000¢\u0006\u0002\u0010=J\u0019\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u0019H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, d2 = {"Lzendesk/conversationkit/android/ConversationKit;", "", "connectionStatusFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lzendesk/conversationkit/android/ConnectionStatus;", "getConnectionStatusFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "addEventListener", "", "listener", "Lzendesk/conversationkit/android/ConversationKitEventListener;", "addProactiveMessage", "proactiveMessage", "Lzendesk/conversationkit/android/model/ProactiveMessage;", "(Lzendesk/conversationkit/android/model/ProactiveMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConversation", "Lzendesk/conversationkit/android/ConversationKitResult;", "Lzendesk/conversationkit/android/model/Conversation;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUser", "Lzendesk/conversationkit/android/model/User;", "dispatchEvent", "event", "Lzendesk/conversationkit/android/ConversationKitEvent;", "getClientId", "", "getConfig", "Lzendesk/conversationkit/android/model/Config;", "getConversation", "conversationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUser", "getMessages", "", "Lzendesk/conversationkit/android/model/Message;", "beforeTimestamp", "", "(Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProactiveMessage", "proactiveMessageId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "getVisitType", "Lzendesk/conversationkit/android/model/VisitType;", "loginUser", "jwt", "logoutUser", "pause", "removeEventListener", "resume", "sendActivityData", "activityData", "Lzendesk/conversationkit/android/model/ActivityData;", "(Lzendesk/conversationkit/android/model/ActivityData;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessage", "message", "(Lzendesk/conversationkit/android/model/Message;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setVisitType", "visitType", "(Lzendesk/conversationkit/android/model/VisitType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePushNotificationToken", "pushNotificationToken", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationKit.kt */
public interface ConversationKit {
    void addEventListener(ConversationKitEventListener conversationKitEventListener);

    Object addProactiveMessage(ProactiveMessage proactiveMessage, Continuation<? super Unit> continuation);

    Object createConversation(Continuation<? super ConversationKitResult<Conversation>> continuation);

    Object createUser(Continuation<? super ConversationKitResult<User>> continuation);

    void dispatchEvent(ConversationKitEvent conversationKitEvent);

    Object getClientId(Continuation<? super String> continuation);

    Config getConfig();

    StateFlow<ConnectionStatus> getConnectionStatusFlow();

    Object getConversation(String str, Continuation<? super ConversationKitResult<Conversation>> continuation);

    User getCurrentUser();

    Object getMessages(String str, double d, Continuation<? super ConversationKitResult<? extends List<Message>>> continuation);

    Object getProactiveMessage(int i, Continuation<? super ConversationKitResult<ProactiveMessage>> continuation);

    ConversationKitSettings getSettings();

    Object getVisitType(Continuation<? super ConversationKitResult<? extends VisitType>> continuation);

    Object loginUser(String str, Continuation<? super ConversationKitResult<User>> continuation);

    Object logoutUser(Continuation<? super ConversationKitResult<Unit>> continuation);

    Object pause(Continuation<? super Unit> continuation);

    void removeEventListener(ConversationKitEventListener conversationKitEventListener);

    Object resume(Continuation<? super Unit> continuation);

    Object sendActivityData(ActivityData activityData, String str, Continuation<? super Unit> continuation);

    Object sendMessage(Message message, String str, Continuation<? super ConversationKitResult<Message>> continuation);

    Object setVisitType(VisitType visitType, Continuation<? super Unit> continuation);

    Object updatePushNotificationToken(String str, Continuation<? super Unit> continuation);
}
