package zendesk.android.events;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lzendesk/android/events/ZendeskEvent;", "", "()V", "AuthenticationFailed", "UnreadMessageCountChanged", "Lzendesk/android/events/ZendeskEvent$UnreadMessageCountChanged;", "Lzendesk/android/events/ZendeskEvent$AuthenticationFailed;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ZendeskEvent.kt */
public abstract class ZendeskEvent {
    public /* synthetic */ ZendeskEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ZendeskEvent() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/android/events/ZendeskEvent$UnreadMessageCountChanged;", "Lzendesk/android/events/ZendeskEvent;", "currentUnreadCount", "", "(I)V", "getCurrentUnreadCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ZendeskEvent.kt */
    public static final class UnreadMessageCountChanged extends ZendeskEvent {
        private final int currentUnreadCount;

        public static /* synthetic */ UnreadMessageCountChanged copy$default(UnreadMessageCountChanged unreadMessageCountChanged, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = unreadMessageCountChanged.currentUnreadCount;
            }
            return unreadMessageCountChanged.copy(i);
        }

        public final int component1() {
            return this.currentUnreadCount;
        }

        public final UnreadMessageCountChanged copy(int i) {
            return new UnreadMessageCountChanged(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UnreadMessageCountChanged) && this.currentUnreadCount == ((UnreadMessageCountChanged) obj).currentUnreadCount;
        }

        public int hashCode() {
            return Integer.hashCode(this.currentUnreadCount);
        }

        public String toString() {
            return "UnreadMessageCountChanged(currentUnreadCount=" + this.currentUnreadCount + ')';
        }

        public final int getCurrentUnreadCount() {
            return this.currentUnreadCount;
        }

        public UnreadMessageCountChanged(int i) {
            super((DefaultConstructorMarker) null);
            this.currentUnreadCount = i;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/android/events/ZendeskEvent$AuthenticationFailed;", "Lzendesk/android/events/ZendeskEvent;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ZendeskEvent.kt */
    public static final class AuthenticationFailed extends ZendeskEvent {
        private final Throwable error;

        public static /* synthetic */ AuthenticationFailed copy$default(AuthenticationFailed authenticationFailed, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = authenticationFailed.error;
            }
            return authenticationFailed.copy(th);
        }

        public final Throwable component1() {
            return this.error;
        }

        public final AuthenticationFailed copy(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "error");
            return new AuthenticationFailed(th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AuthenticationFailed) && Intrinsics.areEqual((Object) this.error, (Object) ((AuthenticationFailed) obj).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "AuthenticationFailed(error=" + this.error + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AuthenticationFailed(Throwable th) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th, "error");
            this.error = th;
        }

        public final Throwable getError() {
            return this.error;
        }
    }
}
