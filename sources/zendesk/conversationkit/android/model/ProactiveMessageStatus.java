package zendesk.conversationkit.android.model;

import io.sentry.clientreport.DiscardedEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lzendesk/conversationkit/android/model/ProactiveMessageStatus;", "", "()V", "ConversationHasBeenRepliedTo", "NotificationCannotBeDisplayed", "NotificationHasBeenClicked", "NotificationHasBeenDisplayed", "NotificationWillDisplay", "Lzendesk/conversationkit/android/model/ProactiveMessageStatus$NotificationWillDisplay;", "Lzendesk/conversationkit/android/model/ProactiveMessageStatus$NotificationHasBeenDisplayed;", "Lzendesk/conversationkit/android/model/ProactiveMessageStatus$NotificationHasBeenClicked;", "Lzendesk/conversationkit/android/model/ProactiveMessageStatus$ConversationHasBeenRepliedTo;", "Lzendesk/conversationkit/android/model/ProactiveMessageStatus$NotificationCannotBeDisplayed;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveMessageStatus.kt */
public abstract class ProactiveMessageStatus {
    public /* synthetic */ ProactiveMessageStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ProactiveMessageStatus() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/model/ProactiveMessageStatus$NotificationWillDisplay;", "Lzendesk/conversationkit/android/model/ProactiveMessageStatus;", "proactiveMessage", "Lzendesk/conversationkit/android/model/ProactiveMessage;", "(Lzendesk/conversationkit/android/model/ProactiveMessage;)V", "getProactiveMessage", "()Lzendesk/conversationkit/android/model/ProactiveMessage;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProactiveMessageStatus.kt */
    public static final class NotificationWillDisplay extends ProactiveMessageStatus {
        private final ProactiveMessage proactiveMessage;

        public static /* synthetic */ NotificationWillDisplay copy$default(NotificationWillDisplay notificationWillDisplay, ProactiveMessage proactiveMessage2, int i, Object obj) {
            if ((i & 1) != 0) {
                proactiveMessage2 = notificationWillDisplay.proactiveMessage;
            }
            return notificationWillDisplay.copy(proactiveMessage2);
        }

        public final ProactiveMessage component1() {
            return this.proactiveMessage;
        }

        public final NotificationWillDisplay copy(ProactiveMessage proactiveMessage2) {
            Intrinsics.checkNotNullParameter(proactiveMessage2, "proactiveMessage");
            return new NotificationWillDisplay(proactiveMessage2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NotificationWillDisplay) && Intrinsics.areEqual((Object) this.proactiveMessage, (Object) ((NotificationWillDisplay) obj).proactiveMessage);
        }

        public int hashCode() {
            return this.proactiveMessage.hashCode();
        }

        public String toString() {
            return "NotificationWillDisplay(proactiveMessage=" + this.proactiveMessage + ')';
        }

        public final ProactiveMessage getProactiveMessage() {
            return this.proactiveMessage;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NotificationWillDisplay(ProactiveMessage proactiveMessage2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(proactiveMessage2, "proactiveMessage");
            this.proactiveMessage = proactiveMessage2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/model/ProactiveMessageStatus$NotificationHasBeenDisplayed;", "Lzendesk/conversationkit/android/model/ProactiveMessageStatus;", "proactiveMessage", "Lzendesk/conversationkit/android/model/ProactiveMessage;", "(Lzendesk/conversationkit/android/model/ProactiveMessage;)V", "getProactiveMessage", "()Lzendesk/conversationkit/android/model/ProactiveMessage;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProactiveMessageStatus.kt */
    public static final class NotificationHasBeenDisplayed extends ProactiveMessageStatus {
        private final ProactiveMessage proactiveMessage;

        public static /* synthetic */ NotificationHasBeenDisplayed copy$default(NotificationHasBeenDisplayed notificationHasBeenDisplayed, ProactiveMessage proactiveMessage2, int i, Object obj) {
            if ((i & 1) != 0) {
                proactiveMessage2 = notificationHasBeenDisplayed.proactiveMessage;
            }
            return notificationHasBeenDisplayed.copy(proactiveMessage2);
        }

        public final ProactiveMessage component1() {
            return this.proactiveMessage;
        }

        public final NotificationHasBeenDisplayed copy(ProactiveMessage proactiveMessage2) {
            Intrinsics.checkNotNullParameter(proactiveMessage2, "proactiveMessage");
            return new NotificationHasBeenDisplayed(proactiveMessage2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NotificationHasBeenDisplayed) && Intrinsics.areEqual((Object) this.proactiveMessage, (Object) ((NotificationHasBeenDisplayed) obj).proactiveMessage);
        }

        public int hashCode() {
            return this.proactiveMessage.hashCode();
        }

        public String toString() {
            return "NotificationHasBeenDisplayed(proactiveMessage=" + this.proactiveMessage + ')';
        }

        public final ProactiveMessage getProactiveMessage() {
            return this.proactiveMessage;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NotificationHasBeenDisplayed(ProactiveMessage proactiveMessage2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(proactiveMessage2, "proactiveMessage");
            this.proactiveMessage = proactiveMessage2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/model/ProactiveMessageStatus$NotificationHasBeenClicked;", "Lzendesk/conversationkit/android/model/ProactiveMessageStatus;", "proactiveMessage", "Lzendesk/conversationkit/android/model/ProactiveMessage;", "(Lzendesk/conversationkit/android/model/ProactiveMessage;)V", "getProactiveMessage", "()Lzendesk/conversationkit/android/model/ProactiveMessage;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProactiveMessageStatus.kt */
    public static final class NotificationHasBeenClicked extends ProactiveMessageStatus {
        private final ProactiveMessage proactiveMessage;

        public static /* synthetic */ NotificationHasBeenClicked copy$default(NotificationHasBeenClicked notificationHasBeenClicked, ProactiveMessage proactiveMessage2, int i, Object obj) {
            if ((i & 1) != 0) {
                proactiveMessage2 = notificationHasBeenClicked.proactiveMessage;
            }
            return notificationHasBeenClicked.copy(proactiveMessage2);
        }

        public final ProactiveMessage component1() {
            return this.proactiveMessage;
        }

        public final NotificationHasBeenClicked copy(ProactiveMessage proactiveMessage2) {
            Intrinsics.checkNotNullParameter(proactiveMessage2, "proactiveMessage");
            return new NotificationHasBeenClicked(proactiveMessage2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NotificationHasBeenClicked) && Intrinsics.areEqual((Object) this.proactiveMessage, (Object) ((NotificationHasBeenClicked) obj).proactiveMessage);
        }

        public int hashCode() {
            return this.proactiveMessage.hashCode();
        }

        public String toString() {
            return "NotificationHasBeenClicked(proactiveMessage=" + this.proactiveMessage + ')';
        }

        public final ProactiveMessage getProactiveMessage() {
            return this.proactiveMessage;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NotificationHasBeenClicked(ProactiveMessage proactiveMessage2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(proactiveMessage2, "proactiveMessage");
            this.proactiveMessage = proactiveMessage2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/model/ProactiveMessageStatus$ConversationHasBeenRepliedTo;", "Lzendesk/conversationkit/android/model/ProactiveMessageStatus;", "proactiveMessage", "Lzendesk/conversationkit/android/model/ProactiveMessage;", "(Lzendesk/conversationkit/android/model/ProactiveMessage;)V", "getProactiveMessage", "()Lzendesk/conversationkit/android/model/ProactiveMessage;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProactiveMessageStatus.kt */
    public static final class ConversationHasBeenRepliedTo extends ProactiveMessageStatus {
        private final ProactiveMessage proactiveMessage;

        public static /* synthetic */ ConversationHasBeenRepliedTo copy$default(ConversationHasBeenRepliedTo conversationHasBeenRepliedTo, ProactiveMessage proactiveMessage2, int i, Object obj) {
            if ((i & 1) != 0) {
                proactiveMessage2 = conversationHasBeenRepliedTo.proactiveMessage;
            }
            return conversationHasBeenRepliedTo.copy(proactiveMessage2);
        }

        public final ProactiveMessage component1() {
            return this.proactiveMessage;
        }

        public final ConversationHasBeenRepliedTo copy(ProactiveMessage proactiveMessage2) {
            Intrinsics.checkNotNullParameter(proactiveMessage2, "proactiveMessage");
            return new ConversationHasBeenRepliedTo(proactiveMessage2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConversationHasBeenRepliedTo) && Intrinsics.areEqual((Object) this.proactiveMessage, (Object) ((ConversationHasBeenRepliedTo) obj).proactiveMessage);
        }

        public int hashCode() {
            return this.proactiveMessage.hashCode();
        }

        public String toString() {
            return "ConversationHasBeenRepliedTo(proactiveMessage=" + this.proactiveMessage + ')';
        }

        public final ProactiveMessage getProactiveMessage() {
            return this.proactiveMessage;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ConversationHasBeenRepliedTo(ProactiveMessage proactiveMessage2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(proactiveMessage2, "proactiveMessage");
            this.proactiveMessage = proactiveMessage2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/model/ProactiveMessageStatus$NotificationCannotBeDisplayed;", "Lzendesk/conversationkit/android/model/ProactiveMessageStatus;", "reason", "", "(Ljava/lang/Throwable;)V", "getReason", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProactiveMessageStatus.kt */
    public static final class NotificationCannotBeDisplayed extends ProactiveMessageStatus {
        private final Throwable reason;

        public static /* synthetic */ NotificationCannotBeDisplayed copy$default(NotificationCannotBeDisplayed notificationCannotBeDisplayed, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = notificationCannotBeDisplayed.reason;
            }
            return notificationCannotBeDisplayed.copy(th);
        }

        public final Throwable component1() {
            return this.reason;
        }

        public final NotificationCannotBeDisplayed copy(Throwable th) {
            Intrinsics.checkNotNullParameter(th, DiscardedEvent.JsonKeys.REASON);
            return new NotificationCannotBeDisplayed(th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NotificationCannotBeDisplayed) && Intrinsics.areEqual((Object) this.reason, (Object) ((NotificationCannotBeDisplayed) obj).reason);
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "NotificationCannotBeDisplayed(reason=" + this.reason + ')';
        }

        public final Throwable getReason() {
            return this.reason;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NotificationCannotBeDisplayed(Throwable th) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th, DiscardedEvent.JsonKeys.REASON);
            this.reason = th;
        }
    }
}
