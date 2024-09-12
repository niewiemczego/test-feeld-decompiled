package zendesk.conversationkit.android;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.ActivityEvent;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.conversationkit.android.model.Message;
import zendesk.conversationkit.android.model.ProactiveMessageStatus;
import zendesk.conversationkit.android.model.User;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\r\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\r\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitEvent;", "", "()V", "ActivityEventReceived", "ConnectionStatusChanged", "ConversationUpdated", "LoadMoreMessages", "LogoutUserCompleted", "MessageReceived", "MessageUpdated", "PersistedUserReceived", "ProactiveMessageStatusChanged", "PushTokenPrepared", "PushTokenUpdateResult", "UserAccessRevoked", "UserUpdated", "Lzendesk/conversationkit/android/ConversationKitEvent$ConnectionStatusChanged;", "Lzendesk/conversationkit/android/ConversationKitEvent$UserAccessRevoked;", "Lzendesk/conversationkit/android/ConversationKitEvent$UserUpdated;", "Lzendesk/conversationkit/android/ConversationKitEvent$LogoutUserCompleted;", "Lzendesk/conversationkit/android/ConversationKitEvent$MessageReceived;", "Lzendesk/conversationkit/android/ConversationKitEvent$LoadMoreMessages;", "Lzendesk/conversationkit/android/ConversationKitEvent$MessageUpdated;", "Lzendesk/conversationkit/android/ConversationKitEvent$ConversationUpdated;", "Lzendesk/conversationkit/android/ConversationKitEvent$PushTokenPrepared;", "Lzendesk/conversationkit/android/ConversationKitEvent$PushTokenUpdateResult;", "Lzendesk/conversationkit/android/ConversationKitEvent$ActivityEventReceived;", "Lzendesk/conversationkit/android/ConversationKitEvent$PersistedUserReceived;", "Lzendesk/conversationkit/android/ConversationKitEvent$ProactiveMessageStatusChanged;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationKitEvent.kt */
public abstract class ConversationKitEvent {
    public /* synthetic */ ConversationKitEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ConversationKitEvent() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitEvent$ConnectionStatusChanged;", "Lzendesk/conversationkit/android/ConversationKitEvent;", "connectionStatus", "Lzendesk/conversationkit/android/ConnectionStatus;", "(Lzendesk/conversationkit/android/ConnectionStatus;)V", "getConnectionStatus", "()Lzendesk/conversationkit/android/ConnectionStatus;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitEvent.kt */
    public static final class ConnectionStatusChanged extends ConversationKitEvent {
        private final ConnectionStatus connectionStatus;

        public static /* synthetic */ ConnectionStatusChanged copy$default(ConnectionStatusChanged connectionStatusChanged, ConnectionStatus connectionStatus2, int i, Object obj) {
            if ((i & 1) != 0) {
                connectionStatus2 = connectionStatusChanged.connectionStatus;
            }
            return connectionStatusChanged.copy(connectionStatus2);
        }

        public final ConnectionStatus component1() {
            return this.connectionStatus;
        }

        public final ConnectionStatusChanged copy(ConnectionStatus connectionStatus2) {
            Intrinsics.checkNotNullParameter(connectionStatus2, "connectionStatus");
            return new ConnectionStatusChanged(connectionStatus2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConnectionStatusChanged) && this.connectionStatus == ((ConnectionStatusChanged) obj).connectionStatus;
        }

        public int hashCode() {
            return this.connectionStatus.hashCode();
        }

        public String toString() {
            return "ConnectionStatusChanged(connectionStatus=" + this.connectionStatus + ')';
        }

        public final ConnectionStatus getConnectionStatus() {
            return this.connectionStatus;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ConnectionStatusChanged(ConnectionStatus connectionStatus2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(connectionStatus2, "connectionStatus");
            this.connectionStatus = connectionStatus2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitEvent$UserAccessRevoked;", "Lzendesk/conversationkit/android/ConversationKitEvent;", "cause", "", "(Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitEvent.kt */
    public static final class UserAccessRevoked extends ConversationKitEvent {
        private final Throwable cause;

        public static /* synthetic */ UserAccessRevoked copy$default(UserAccessRevoked userAccessRevoked, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = userAccessRevoked.cause;
            }
            return userAccessRevoked.copy(th);
        }

        public final Throwable component1() {
            return this.cause;
        }

        public final UserAccessRevoked copy(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "cause");
            return new UserAccessRevoked(th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UserAccessRevoked) && Intrinsics.areEqual((Object) this.cause, (Object) ((UserAccessRevoked) obj).cause);
        }

        public int hashCode() {
            return this.cause.hashCode();
        }

        public String toString() {
            return "UserAccessRevoked(cause=" + this.cause + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UserAccessRevoked(Throwable th) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th, "cause");
            this.cause = th;
        }

        public final Throwable getCause() {
            return this.cause;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitEvent$UserUpdated;", "Lzendesk/conversationkit/android/ConversationKitEvent;", "user", "Lzendesk/conversationkit/android/model/User;", "(Lzendesk/conversationkit/android/model/User;)V", "getUser", "()Lzendesk/conversationkit/android/model/User;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitEvent.kt */
    public static final class UserUpdated extends ConversationKitEvent {
        private final User user;

        public static /* synthetic */ UserUpdated copy$default(UserUpdated userUpdated, User user2, int i, Object obj) {
            if ((i & 1) != 0) {
                user2 = userUpdated.user;
            }
            return userUpdated.copy(user2);
        }

        public final User component1() {
            return this.user;
        }

        public final UserUpdated copy(User user2) {
            Intrinsics.checkNotNullParameter(user2, "user");
            return new UserUpdated(user2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UserUpdated) && Intrinsics.areEqual((Object) this.user, (Object) ((UserUpdated) obj).user);
        }

        public int hashCode() {
            return this.user.hashCode();
        }

        public String toString() {
            return "UserUpdated(user=" + this.user + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UserUpdated(User user2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(user2, "user");
            this.user = user2;
        }

        public final User getUser() {
            return this.user;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitEvent$LogoutUserCompleted;", "Lzendesk/conversationkit/android/ConversationKitEvent;", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "", "(Lzendesk/conversationkit/android/ConversationKitResult;)V", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitEvent.kt */
    public static final class LogoutUserCompleted extends ConversationKitEvent {
        private final ConversationKitResult<Unit> result;

        public static /* synthetic */ LogoutUserCompleted copy$default(LogoutUserCompleted logoutUserCompleted, ConversationKitResult<Unit> conversationKitResult, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitResult = logoutUserCompleted.result;
            }
            return logoutUserCompleted.copy(conversationKitResult);
        }

        public final ConversationKitResult<Unit> component1() {
            return this.result;
        }

        public final LogoutUserCompleted copy(ConversationKitResult<Unit> conversationKitResult) {
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            return new LogoutUserCompleted(conversationKitResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LogoutUserCompleted) && Intrinsics.areEqual((Object) this.result, (Object) ((LogoutUserCompleted) obj).result);
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "LogoutUserCompleted(result=" + this.result + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LogoutUserCompleted(ConversationKitResult<Unit> conversationKitResult) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            this.result = conversationKitResult;
        }

        public final ConversationKitResult<Unit> getResult() {
            return this.result;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitEvent$MessageReceived;", "Lzendesk/conversationkit/android/ConversationKitEvent;", "message", "Lzendesk/conversationkit/android/model/Message;", "conversationId", "", "(Lzendesk/conversationkit/android/model/Message;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getMessage", "()Lzendesk/conversationkit/android/model/Message;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitEvent.kt */
    public static final class MessageReceived extends ConversationKitEvent {
        private final String conversationId;
        private final Message message;

        public static /* synthetic */ MessageReceived copy$default(MessageReceived messageReceived, Message message2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                message2 = messageReceived.message;
            }
            if ((i & 2) != 0) {
                str = messageReceived.conversationId;
            }
            return messageReceived.copy(message2, str);
        }

        public final Message component1() {
            return this.message;
        }

        public final String component2() {
            return this.conversationId;
        }

        public final MessageReceived copy(Message message2, String str) {
            Intrinsics.checkNotNullParameter(message2, "message");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new MessageReceived(message2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MessageReceived)) {
                return false;
            }
            MessageReceived messageReceived = (MessageReceived) obj;
            return Intrinsics.areEqual((Object) this.message, (Object) messageReceived.message) && Intrinsics.areEqual((Object) this.conversationId, (Object) messageReceived.conversationId);
        }

        public int hashCode() {
            return (this.message.hashCode() * 31) + this.conversationId.hashCode();
        }

        public String toString() {
            return "MessageReceived(message=" + this.message + ", conversationId=" + this.conversationId + ')';
        }

        public final Message getMessage() {
            return this.message;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MessageReceived(Message message2, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(message2, "message");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.message = message2;
            this.conversationId = str;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitEvent$LoadMoreMessages;", "Lzendesk/conversationkit/android/ConversationKitEvent;", "listOfMessages", "", "Lzendesk/conversationkit/android/model/Message;", "conversationId", "", "(Ljava/util/List;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getListOfMessages", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitEvent.kt */
    public static final class LoadMoreMessages extends ConversationKitEvent {
        private final String conversationId;
        private final List<Message> listOfMessages;

        public static /* synthetic */ LoadMoreMessages copy$default(LoadMoreMessages loadMoreMessages, List<Message> list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = loadMoreMessages.listOfMessages;
            }
            if ((i & 2) != 0) {
                str = loadMoreMessages.conversationId;
            }
            return loadMoreMessages.copy(list, str);
        }

        public final List<Message> component1() {
            return this.listOfMessages;
        }

        public final String component2() {
            return this.conversationId;
        }

        public final LoadMoreMessages copy(List<Message> list, String str) {
            Intrinsics.checkNotNullParameter(list, "listOfMessages");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new LoadMoreMessages(list, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadMoreMessages)) {
                return false;
            }
            LoadMoreMessages loadMoreMessages = (LoadMoreMessages) obj;
            return Intrinsics.areEqual((Object) this.listOfMessages, (Object) loadMoreMessages.listOfMessages) && Intrinsics.areEqual((Object) this.conversationId, (Object) loadMoreMessages.conversationId);
        }

        public int hashCode() {
            return (this.listOfMessages.hashCode() * 31) + this.conversationId.hashCode();
        }

        public String toString() {
            return "LoadMoreMessages(listOfMessages=" + this.listOfMessages + ", conversationId=" + this.conversationId + ')';
        }

        public final List<Message> getListOfMessages() {
            return this.listOfMessages;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadMoreMessages(List<Message> list, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "listOfMessages");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.listOfMessages = list;
            this.conversationId = str;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitEvent$MessageUpdated;", "Lzendesk/conversationkit/android/ConversationKitEvent;", "message", "Lzendesk/conversationkit/android/model/Message;", "conversationId", "", "(Lzendesk/conversationkit/android/model/Message;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getMessage", "()Lzendesk/conversationkit/android/model/Message;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitEvent.kt */
    public static final class MessageUpdated extends ConversationKitEvent {
        private final String conversationId;
        private final Message message;

        public static /* synthetic */ MessageUpdated copy$default(MessageUpdated messageUpdated, Message message2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                message2 = messageUpdated.message;
            }
            if ((i & 2) != 0) {
                str = messageUpdated.conversationId;
            }
            return messageUpdated.copy(message2, str);
        }

        public final Message component1() {
            return this.message;
        }

        public final String component2() {
            return this.conversationId;
        }

        public final MessageUpdated copy(Message message2, String str) {
            Intrinsics.checkNotNullParameter(message2, "message");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new MessageUpdated(message2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MessageUpdated)) {
                return false;
            }
            MessageUpdated messageUpdated = (MessageUpdated) obj;
            return Intrinsics.areEqual((Object) this.message, (Object) messageUpdated.message) && Intrinsics.areEqual((Object) this.conversationId, (Object) messageUpdated.conversationId);
        }

        public int hashCode() {
            return (this.message.hashCode() * 31) + this.conversationId.hashCode();
        }

        public String toString() {
            return "MessageUpdated(message=" + this.message + ", conversationId=" + this.conversationId + ')';
        }

        public final Message getMessage() {
            return this.message;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MessageUpdated(Message message2, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(message2, "message");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.message = message2;
            this.conversationId = str;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitEvent$ConversationUpdated;", "Lzendesk/conversationkit/android/ConversationKitEvent;", "conversation", "Lzendesk/conversationkit/android/model/Conversation;", "(Lzendesk/conversationkit/android/model/Conversation;)V", "getConversation", "()Lzendesk/conversationkit/android/model/Conversation;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitEvent.kt */
    public static final class ConversationUpdated extends ConversationKitEvent {
        private final Conversation conversation;

        public static /* synthetic */ ConversationUpdated copy$default(ConversationUpdated conversationUpdated, Conversation conversation2, int i, Object obj) {
            if ((i & 1) != 0) {
                conversation2 = conversationUpdated.conversation;
            }
            return conversationUpdated.copy(conversation2);
        }

        public final Conversation component1() {
            return this.conversation;
        }

        public final ConversationUpdated copy(Conversation conversation2) {
            Intrinsics.checkNotNullParameter(conversation2, "conversation");
            return new ConversationUpdated(conversation2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConversationUpdated) && Intrinsics.areEqual((Object) this.conversation, (Object) ((ConversationUpdated) obj).conversation);
        }

        public int hashCode() {
            return this.conversation.hashCode();
        }

        public String toString() {
            return "ConversationUpdated(conversation=" + this.conversation + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ConversationUpdated(Conversation conversation2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversation2, "conversation");
            this.conversation = conversation2;
        }

        public final Conversation getConversation() {
            return this.conversation;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitEvent$PushTokenPrepared;", "Lzendesk/conversationkit/android/ConversationKitEvent;", "pushNotificationToken", "", "(Ljava/lang/String;)V", "getPushNotificationToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitEvent.kt */
    public static final class PushTokenPrepared extends ConversationKitEvent {
        private final String pushNotificationToken;

        public static /* synthetic */ PushTokenPrepared copy$default(PushTokenPrepared pushTokenPrepared, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pushTokenPrepared.pushNotificationToken;
            }
            return pushTokenPrepared.copy(str);
        }

        public final String component1() {
            return this.pushNotificationToken;
        }

        public final PushTokenPrepared copy(String str) {
            Intrinsics.checkNotNullParameter(str, "pushNotificationToken");
            return new PushTokenPrepared(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PushTokenPrepared) && Intrinsics.areEqual((Object) this.pushNotificationToken, (Object) ((PushTokenPrepared) obj).pushNotificationToken);
        }

        public int hashCode() {
            return this.pushNotificationToken.hashCode();
        }

        public String toString() {
            return "PushTokenPrepared(pushNotificationToken=" + this.pushNotificationToken + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PushTokenPrepared(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "pushNotificationToken");
            this.pushNotificationToken = str;
        }

        public final String getPushNotificationToken() {
            return this.pushNotificationToken;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitEvent$PushTokenUpdateResult;", "Lzendesk/conversationkit/android/ConversationKitEvent;", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "", "pushNotificationToken", "", "(Lzendesk/conversationkit/android/ConversationKitResult;Ljava/lang/String;)V", "getPushNotificationToken", "()Ljava/lang/String;", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitEvent.kt */
    public static final class PushTokenUpdateResult extends ConversationKitEvent {
        private final String pushNotificationToken;
        private final ConversationKitResult<Unit> result;

        public static /* synthetic */ PushTokenUpdateResult copy$default(PushTokenUpdateResult pushTokenUpdateResult, ConversationKitResult<Unit> conversationKitResult, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitResult = pushTokenUpdateResult.result;
            }
            if ((i & 2) != 0) {
                str = pushTokenUpdateResult.pushNotificationToken;
            }
            return pushTokenUpdateResult.copy(conversationKitResult, str);
        }

        public final ConversationKitResult<Unit> component1() {
            return this.result;
        }

        public final String component2() {
            return this.pushNotificationToken;
        }

        public final PushTokenUpdateResult copy(ConversationKitResult<Unit> conversationKitResult, String str) {
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            Intrinsics.checkNotNullParameter(str, "pushNotificationToken");
            return new PushTokenUpdateResult(conversationKitResult, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PushTokenUpdateResult)) {
                return false;
            }
            PushTokenUpdateResult pushTokenUpdateResult = (PushTokenUpdateResult) obj;
            return Intrinsics.areEqual((Object) this.result, (Object) pushTokenUpdateResult.result) && Intrinsics.areEqual((Object) this.pushNotificationToken, (Object) pushTokenUpdateResult.pushNotificationToken);
        }

        public int hashCode() {
            return (this.result.hashCode() * 31) + this.pushNotificationToken.hashCode();
        }

        public String toString() {
            return "PushTokenUpdateResult(result=" + this.result + ", pushNotificationToken=" + this.pushNotificationToken + ')';
        }

        public final ConversationKitResult<Unit> getResult() {
            return this.result;
        }

        public final String getPushNotificationToken() {
            return this.pushNotificationToken;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PushTokenUpdateResult(ConversationKitResult<Unit> conversationKitResult, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            Intrinsics.checkNotNullParameter(str, "pushNotificationToken");
            this.result = conversationKitResult;
            this.pushNotificationToken = str;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitEvent$ActivityEventReceived;", "Lzendesk/conversationkit/android/ConversationKitEvent;", "activityEvent", "Lzendesk/conversationkit/android/model/ActivityEvent;", "(Lzendesk/conversationkit/android/model/ActivityEvent;)V", "getActivityEvent", "()Lzendesk/conversationkit/android/model/ActivityEvent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitEvent.kt */
    public static final class ActivityEventReceived extends ConversationKitEvent {
        private final ActivityEvent activityEvent;

        public static /* synthetic */ ActivityEventReceived copy$default(ActivityEventReceived activityEventReceived, ActivityEvent activityEvent2, int i, Object obj) {
            if ((i & 1) != 0) {
                activityEvent2 = activityEventReceived.activityEvent;
            }
            return activityEventReceived.copy(activityEvent2);
        }

        public final ActivityEvent component1() {
            return this.activityEvent;
        }

        public final ActivityEventReceived copy(ActivityEvent activityEvent2) {
            Intrinsics.checkNotNullParameter(activityEvent2, "activityEvent");
            return new ActivityEventReceived(activityEvent2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ActivityEventReceived) && Intrinsics.areEqual((Object) this.activityEvent, (Object) ((ActivityEventReceived) obj).activityEvent);
        }

        public int hashCode() {
            return this.activityEvent.hashCode();
        }

        public String toString() {
            return "ActivityEventReceived(activityEvent=" + this.activityEvent + ')';
        }

        public final ActivityEvent getActivityEvent() {
            return this.activityEvent;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ActivityEventReceived(ActivityEvent activityEvent2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(activityEvent2, "activityEvent");
            this.activityEvent = activityEvent2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitEvent$PersistedUserReceived;", "Lzendesk/conversationkit/android/ConversationKitEvent;", "user", "Lzendesk/conversationkit/android/model/User;", "(Lzendesk/conversationkit/android/model/User;)V", "getUser", "()Lzendesk/conversationkit/android/model/User;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitEvent.kt */
    public static final class PersistedUserReceived extends ConversationKitEvent {
        private final User user;

        public static /* synthetic */ PersistedUserReceived copy$default(PersistedUserReceived persistedUserReceived, User user2, int i, Object obj) {
            if ((i & 1) != 0) {
                user2 = persistedUserReceived.user;
            }
            return persistedUserReceived.copy(user2);
        }

        public final User component1() {
            return this.user;
        }

        public final PersistedUserReceived copy(User user2) {
            Intrinsics.checkNotNullParameter(user2, "user");
            return new PersistedUserReceived(user2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PersistedUserReceived) && Intrinsics.areEqual((Object) this.user, (Object) ((PersistedUserReceived) obj).user);
        }

        public int hashCode() {
            return this.user.hashCode();
        }

        public String toString() {
            return "PersistedUserReceived(user=" + this.user + ')';
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PersistedUserReceived(User user2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(user2, "user");
            this.user = user2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitEvent$ProactiveMessageStatusChanged;", "Lzendesk/conversationkit/android/ConversationKitEvent;", "status", "Lzendesk/conversationkit/android/model/ProactiveMessageStatus;", "(Lzendesk/conversationkit/android/model/ProactiveMessageStatus;)V", "getStatus", "()Lzendesk/conversationkit/android/model/ProactiveMessageStatus;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitEvent.kt */
    public static final class ProactiveMessageStatusChanged extends ConversationKitEvent {
        private final ProactiveMessageStatus status;

        public static /* synthetic */ ProactiveMessageStatusChanged copy$default(ProactiveMessageStatusChanged proactiveMessageStatusChanged, ProactiveMessageStatus proactiveMessageStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                proactiveMessageStatus = proactiveMessageStatusChanged.status;
            }
            return proactiveMessageStatusChanged.copy(proactiveMessageStatus);
        }

        public final ProactiveMessageStatus component1() {
            return this.status;
        }

        public final ProactiveMessageStatusChanged copy(ProactiveMessageStatus proactiveMessageStatus) {
            Intrinsics.checkNotNullParameter(proactiveMessageStatus, "status");
            return new ProactiveMessageStatusChanged(proactiveMessageStatus);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ProactiveMessageStatusChanged) && Intrinsics.areEqual((Object) this.status, (Object) ((ProactiveMessageStatusChanged) obj).status);
        }

        public int hashCode() {
            return this.status.hashCode();
        }

        public String toString() {
            return "ProactiveMessageStatusChanged(status=" + this.status + ')';
        }

        public final ProactiveMessageStatus getStatus() {
            return this.status;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProactiveMessageStatusChanged(ProactiveMessageStatus proactiveMessageStatus) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(proactiveMessageStatus, "status");
            this.status = proactiveMessageStatus;
        }
    }
}
