package zendesk.conversationkit.android;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0005\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitError;", "", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "FailedToInitialize", "IncorrectAccessLevelForAction", "NoResultReceived", "UnexpectedType", "UserAlreadyExists", "Lzendesk/conversationkit/android/ConversationKitError$NoResultReceived;", "Lzendesk/conversationkit/android/ConversationKitError$FailedToInitialize;", "Lzendesk/conversationkit/android/ConversationKitError$UnexpectedType;", "Lzendesk/conversationkit/android/ConversationKitError$IncorrectAccessLevelForAction;", "Lzendesk/conversationkit/android/ConversationKitError$UserAlreadyExists;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationKitError.kt */
public abstract class ConversationKitError extends Throwable {
    private final String message;

    public /* synthetic */ ConversationKitError(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private ConversationKitError(String str) {
        super(str);
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitError$NoResultReceived;", "Lzendesk/conversationkit/android/ConversationKitError;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitError.kt */
    public static final class NoResultReceived extends ConversationKitError {
        public static final NoResultReceived INSTANCE = new NoResultReceived();

        private NoResultReceived() {
            super("No ConversationKitResult to return for this call.", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitError$FailedToInitialize;", "Lzendesk/conversationkit/android/ConversationKitError;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitError.kt */
    public static final class FailedToInitialize extends ConversationKitError {
        public static final FailedToInitialize INSTANCE = new FailedToInitialize();

        private FailedToInitialize() {
            super("The provided parameters were not valid to create an instance of ConversationKit.", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitError$UnexpectedType;", "Lzendesk/conversationkit/android/ConversationKitError;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitError.kt */
    public static final class UnexpectedType extends ConversationKitError {
        public static final UnexpectedType INSTANCE = new UnexpectedType();

        private UnexpectedType() {
            super("Unexpected type received, unable to return.", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitError$IncorrectAccessLevelForAction;", "Lzendesk/conversationkit/android/ConversationKitError;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitError.kt */
    public static final class IncorrectAccessLevelForAction extends ConversationKitError {
        public static final IncorrectAccessLevelForAction INSTANCE = new IncorrectAccessLevelForAction();

        private IncorrectAccessLevelForAction() {
            super("Action cannot be performed in current state of the SDK.", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitError$UserAlreadyExists;", "Lzendesk/conversationkit/android/ConversationKitError;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitError.kt */
    public static final class UserAlreadyExists extends ConversationKitError {
        public static final UserAlreadyExists INSTANCE = new UserAlreadyExists();

        private UserAlreadyExists() {
            super("A user already exists for this client.", (DefaultConstructorMarker) null);
        }
    }
}
