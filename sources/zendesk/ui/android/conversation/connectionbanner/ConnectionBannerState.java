package zendesk.ui.android.conversation.connectionbanner;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0011\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState;", "", "connectionState", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState;", "(Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState;)V", "getConnectionState", "()Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState;", "component1", "copy", "equals", "", "other", "hashCode", "", "toBuilder", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$Builder;", "toString", "", "Builder", "ConnectionState", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionBannerState.kt */
public final class ConnectionBannerState {
    private final ConnectionState connectionState;

    public ConnectionBannerState() {
        this((ConnectionState) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ConnectionBannerState copy$default(ConnectionBannerState connectionBannerState, ConnectionState connectionState2, int i, Object obj) {
        if ((i & 1) != 0) {
            connectionState2 = connectionBannerState.connectionState;
        }
        return connectionBannerState.copy(connectionState2);
    }

    public final ConnectionState component1() {
        return this.connectionState;
    }

    public final ConnectionBannerState copy(ConnectionState connectionState2) {
        Intrinsics.checkNotNullParameter(connectionState2, "connectionState");
        return new ConnectionBannerState(connectionState2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConnectionBannerState) && Intrinsics.areEqual((Object) this.connectionState, (Object) ((ConnectionBannerState) obj).connectionState);
    }

    public int hashCode() {
        return this.connectionState.hashCode();
    }

    public String toString() {
        return "ConnectionBannerState(connectionState=" + this.connectionState + ')';
    }

    public ConnectionBannerState(ConnectionState connectionState2) {
        Intrinsics.checkNotNullParameter(connectionState2, "connectionState");
        this.connectionState = connectionState2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConnectionBannerState(ConnectionState connectionState2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ConnectionState.Connected.INSTANCE : connectionState2);
    }

    public final ConnectionState getConnectionState() {
        return this.connectionState;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$Builder;", "", "state", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState;", "(Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState;)V", "()V", "build", "connectionState", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionBannerState.kt */
    public static final class Builder {
        private ConnectionBannerState state;

        public Builder() {
            this.state = new ConnectionBannerState((ConnectionState) null, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(ConnectionBannerState connectionBannerState) {
            this();
            Intrinsics.checkNotNullParameter(connectionBannerState, "state");
            this.state = connectionBannerState;
        }

        public final Builder connectionState(ConnectionState connectionState) {
            Intrinsics.checkNotNullParameter(connectionState, "connectionState");
            Builder builder = this;
            this.state = this.state.copy(connectionState);
            return this;
        }

        public final ConnectionBannerState build() {
            return this.state;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState;", "", "stateValue", "", "(Ljava/lang/String;)V", "getStateValue", "()Ljava/lang/String;", "Connected", "Disconnected", "Reconnected", "Reconnecting", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState$Reconnecting;", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState$Reconnected;", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState$Disconnected;", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState$Connected;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionBannerState.kt */
    public static abstract class ConnectionState {
        private final String stateValue;

        public /* synthetic */ ConnectionState(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState$Reconnecting;", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState;", "()V", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConnectionBannerState.kt */
        public static final class Reconnecting extends ConnectionState {
            public static final Reconnecting INSTANCE = new Reconnecting();

            private Reconnecting() {
                super("Reconnecting", (DefaultConstructorMarker) null);
            }
        }

        private ConnectionState(String str) {
            this.stateValue = str;
        }

        public final String getStateValue() {
            return this.stateValue;
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState$Reconnected;", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState;", "()V", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConnectionBannerState.kt */
        public static final class Reconnected extends ConnectionState {
            public static final Reconnected INSTANCE = new Reconnected();

            private Reconnected() {
                super("Reconnected", (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState$Disconnected;", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState;", "()V", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConnectionBannerState.kt */
        public static final class Disconnected extends ConnectionState {
            public static final Disconnected INSTANCE = new Disconnected();

            private Disconnected() {
                super("Disconnected", (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState$Connected;", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerState$ConnectionState;", "()V", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConnectionBannerState.kt */
        public static final class Connected extends ConnectionState {
            public static final Connected INSTANCE = new Connected();

            private Connected() {
                super("Connected", (DefaultConstructorMarker) null);
            }
        }
    }
}
