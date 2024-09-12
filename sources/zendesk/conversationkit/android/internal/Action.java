package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.ConnectionStatus;
import zendesk.conversationkit.android.ConversationKitSettings;
import zendesk.conversationkit.android.model.ActivityData;
import zendesk.conversationkit.android.model.ActivityEvent;
import zendesk.conversationkit.android.model.Config;
import zendesk.conversationkit.android.model.Message;
import zendesk.conversationkit.android.model.ProactiveMessage;
import zendesk.conversationkit.android.model.User;
import zendesk.conversationkit.android.model.VisitType;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u001e\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u001e!\"#$%&'()*+,-./0123456789:;<=>¨\u0006?"}, d2 = {"Lzendesk/conversationkit/android/internal/Action;", "", "()V", "ActivityEventReceived", "AddProactiveMessage", "CheckForPersistedUser", "CreateConversation", "CreateUser", "ForwardConfig", "GetConfig", "GetConversation", "GetProactiveMessage", "GetVisitType", "LoadMoreMessages", "LoginUser", "LogoutUser", "MessageReceived", "NetworkConnectionStatusUpdate", "PauseRealtimeConnection", "PersistedUserRetrieve", "PrepareMessage", "PreparePushToken", "RealtimeConnectionStatusUpdate", "RefreshConversation", "RefreshUser", "SendActivityData", "SendMessage", "SetVisitType", "Setup", "SetupWithConfig", "StartRealtimeConnection", "UpdateAppUserLocale", "UpdatePushToken", "Lzendesk/conversationkit/android/internal/Action$Setup;", "Lzendesk/conversationkit/android/internal/Action$SetupWithConfig;", "Lzendesk/conversationkit/android/internal/Action$GetConfig;", "Lzendesk/conversationkit/android/internal/Action$ForwardConfig;", "Lzendesk/conversationkit/android/internal/Action$RealtimeConnectionStatusUpdate;", "Lzendesk/conversationkit/android/internal/Action$MessageReceived;", "Lzendesk/conversationkit/android/internal/Action$LoadMoreMessages;", "Lzendesk/conversationkit/android/internal/Action$NetworkConnectionStatusUpdate;", "Lzendesk/conversationkit/android/internal/Action$CreateUser;", "Lzendesk/conversationkit/android/internal/Action$CheckForPersistedUser;", "Lzendesk/conversationkit/android/internal/Action$StartRealtimeConnection;", "Lzendesk/conversationkit/android/internal/Action$PauseRealtimeConnection;", "Lzendesk/conversationkit/android/internal/Action$RefreshUser;", "Lzendesk/conversationkit/android/internal/Action$LoginUser;", "Lzendesk/conversationkit/android/internal/Action$LogoutUser;", "Lzendesk/conversationkit/android/internal/Action$CreateConversation;", "Lzendesk/conversationkit/android/internal/Action$GetConversation;", "Lzendesk/conversationkit/android/internal/Action$RefreshConversation;", "Lzendesk/conversationkit/android/internal/Action$PrepareMessage;", "Lzendesk/conversationkit/android/internal/Action$SendMessage;", "Lzendesk/conversationkit/android/internal/Action$PreparePushToken;", "Lzendesk/conversationkit/android/internal/Action$UpdatePushToken;", "Lzendesk/conversationkit/android/internal/Action$SendActivityData;", "Lzendesk/conversationkit/android/internal/Action$ActivityEventReceived;", "Lzendesk/conversationkit/android/internal/Action$UpdateAppUserLocale;", "Lzendesk/conversationkit/android/internal/Action$PersistedUserRetrieve;", "Lzendesk/conversationkit/android/internal/Action$GetVisitType;", "Lzendesk/conversationkit/android/internal/Action$SetVisitType;", "Lzendesk/conversationkit/android/internal/Action$AddProactiveMessage;", "Lzendesk/conversationkit/android/internal/Action$GetProactiveMessage;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Action.kt */
public abstract class Action {
    public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Action() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$Setup;", "Lzendesk/conversationkit/android/internal/Action;", "conversationKitSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "(Lzendesk/conversationkit/android/ConversationKitSettings;)V", "getConversationKitSettings", "()Lzendesk/conversationkit/android/ConversationKitSettings;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class Setup extends Action {
        private final ConversationKitSettings conversationKitSettings;

        public static /* synthetic */ Setup copy$default(Setup setup, ConversationKitSettings conversationKitSettings2, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitSettings2 = setup.conversationKitSettings;
            }
            return setup.copy(conversationKitSettings2);
        }

        public final ConversationKitSettings component1() {
            return this.conversationKitSettings;
        }

        public final Setup copy(ConversationKitSettings conversationKitSettings2) {
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            return new Setup(conversationKitSettings2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Setup) && Intrinsics.areEqual((Object) this.conversationKitSettings, (Object) ((Setup) obj).conversationKitSettings);
        }

        public int hashCode() {
            return this.conversationKitSettings.hashCode();
        }

        public String toString() {
            return "Setup(conversationKitSettings=" + this.conversationKitSettings + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Setup(ConversationKitSettings conversationKitSettings2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            this.conversationKitSettings = conversationKitSettings2;
        }

        public final ConversationKitSettings getConversationKitSettings() {
            return this.conversationKitSettings;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$SetupWithConfig;", "Lzendesk/conversationkit/android/internal/Action;", "conversationKitSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "config", "Lzendesk/conversationkit/android/model/Config;", "(Lzendesk/conversationkit/android/ConversationKitSettings;Lzendesk/conversationkit/android/model/Config;)V", "getConfig", "()Lzendesk/conversationkit/android/model/Config;", "getConversationKitSettings", "()Lzendesk/conversationkit/android/ConversationKitSettings;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class SetupWithConfig extends Action {
        private final Config config;
        private final ConversationKitSettings conversationKitSettings;

        public static /* synthetic */ SetupWithConfig copy$default(SetupWithConfig setupWithConfig, ConversationKitSettings conversationKitSettings2, Config config2, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitSettings2 = setupWithConfig.conversationKitSettings;
            }
            if ((i & 2) != 0) {
                config2 = setupWithConfig.config;
            }
            return setupWithConfig.copy(conversationKitSettings2, config2);
        }

        public final ConversationKitSettings component1() {
            return this.conversationKitSettings;
        }

        public final Config component2() {
            return this.config;
        }

        public final SetupWithConfig copy(ConversationKitSettings conversationKitSettings2, Config config2) {
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(config2, "config");
            return new SetupWithConfig(conversationKitSettings2, config2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SetupWithConfig)) {
                return false;
            }
            SetupWithConfig setupWithConfig = (SetupWithConfig) obj;
            return Intrinsics.areEqual((Object) this.conversationKitSettings, (Object) setupWithConfig.conversationKitSettings) && Intrinsics.areEqual((Object) this.config, (Object) setupWithConfig.config);
        }

        public int hashCode() {
            return (this.conversationKitSettings.hashCode() * 31) + this.config.hashCode();
        }

        public String toString() {
            return "SetupWithConfig(conversationKitSettings=" + this.conversationKitSettings + ", config=" + this.config + ')';
        }

        public final ConversationKitSettings getConversationKitSettings() {
            return this.conversationKitSettings;
        }

        public final Config getConfig() {
            return this.config;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SetupWithConfig(ConversationKitSettings conversationKitSettings2, Config config2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(config2, "config");
            this.conversationKitSettings = conversationKitSettings2;
            this.config = config2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$GetConfig;", "Lzendesk/conversationkit/android/internal/Action;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class GetConfig extends Action {
        public static final GetConfig INSTANCE = new GetConfig();

        private GetConfig() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$ForwardConfig;", "Lzendesk/conversationkit/android/internal/Action;", "config", "Lzendesk/conversationkit/android/model/Config;", "(Lzendesk/conversationkit/android/model/Config;)V", "getConfig", "()Lzendesk/conversationkit/android/model/Config;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class ForwardConfig extends Action {
        private final Config config;

        public static /* synthetic */ ForwardConfig copy$default(ForwardConfig forwardConfig, Config config2, int i, Object obj) {
            if ((i & 1) != 0) {
                config2 = forwardConfig.config;
            }
            return forwardConfig.copy(config2);
        }

        public final Config component1() {
            return this.config;
        }

        public final ForwardConfig copy(Config config2) {
            Intrinsics.checkNotNullParameter(config2, "config");
            return new ForwardConfig(config2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ForwardConfig) && Intrinsics.areEqual((Object) this.config, (Object) ((ForwardConfig) obj).config);
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "ForwardConfig(config=" + this.config + ')';
        }

        public final Config getConfig() {
            return this.config;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ForwardConfig(Config config2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(config2, "config");
            this.config = config2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$RealtimeConnectionStatusUpdate;", "Lzendesk/conversationkit/android/internal/Action;", "connectionStatus", "Lzendesk/conversationkit/android/ConnectionStatus;", "(Lzendesk/conversationkit/android/ConnectionStatus;)V", "getConnectionStatus", "()Lzendesk/conversationkit/android/ConnectionStatus;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class RealtimeConnectionStatusUpdate extends Action {
        private final ConnectionStatus connectionStatus;

        public static /* synthetic */ RealtimeConnectionStatusUpdate copy$default(RealtimeConnectionStatusUpdate realtimeConnectionStatusUpdate, ConnectionStatus connectionStatus2, int i, Object obj) {
            if ((i & 1) != 0) {
                connectionStatus2 = realtimeConnectionStatusUpdate.connectionStatus;
            }
            return realtimeConnectionStatusUpdate.copy(connectionStatus2);
        }

        public final ConnectionStatus component1() {
            return this.connectionStatus;
        }

        public final RealtimeConnectionStatusUpdate copy(ConnectionStatus connectionStatus2) {
            Intrinsics.checkNotNullParameter(connectionStatus2, "connectionStatus");
            return new RealtimeConnectionStatusUpdate(connectionStatus2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RealtimeConnectionStatusUpdate) && this.connectionStatus == ((RealtimeConnectionStatusUpdate) obj).connectionStatus;
        }

        public int hashCode() {
            return this.connectionStatus.hashCode();
        }

        public String toString() {
            return "RealtimeConnectionStatusUpdate(connectionStatus=" + this.connectionStatus + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RealtimeConnectionStatusUpdate(ConnectionStatus connectionStatus2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(connectionStatus2, "connectionStatus");
            this.connectionStatus = connectionStatus2;
        }

        public final ConnectionStatus getConnectionStatus() {
            return this.connectionStatus;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$MessageReceived;", "Lzendesk/conversationkit/android/internal/Action;", "conversationId", "", "message", "Lzendesk/conversationkit/android/model/Message;", "(Ljava/lang/String;Lzendesk/conversationkit/android/model/Message;)V", "getConversationId", "()Ljava/lang/String;", "getMessage", "()Lzendesk/conversationkit/android/model/Message;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class MessageReceived extends Action {
        private final String conversationId;
        private final Message message;

        public static /* synthetic */ MessageReceived copy$default(MessageReceived messageReceived, String str, Message message2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = messageReceived.conversationId;
            }
            if ((i & 2) != 0) {
                message2 = messageReceived.message;
            }
            return messageReceived.copy(str, message2);
        }

        public final String component1() {
            return this.conversationId;
        }

        public final Message component2() {
            return this.message;
        }

        public final MessageReceived copy(String str, Message message2) {
            Intrinsics.checkNotNullParameter(str, "conversationId");
            Intrinsics.checkNotNullParameter(message2, "message");
            return new MessageReceived(str, message2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MessageReceived)) {
                return false;
            }
            MessageReceived messageReceived = (MessageReceived) obj;
            return Intrinsics.areEqual((Object) this.conversationId, (Object) messageReceived.conversationId) && Intrinsics.areEqual((Object) this.message, (Object) messageReceived.message);
        }

        public int hashCode() {
            return (this.conversationId.hashCode() * 31) + this.message.hashCode();
        }

        public String toString() {
            return "MessageReceived(conversationId=" + this.conversationId + ", message=" + this.message + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MessageReceived(String str, Message message2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "conversationId");
            Intrinsics.checkNotNullParameter(message2, "message");
            this.conversationId = str;
            this.message = message2;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final Message getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$LoadMoreMessages;", "Lzendesk/conversationkit/android/internal/Action;", "conversationId", "", "beforeTimestamp", "", "(Ljava/lang/String;D)V", "getBeforeTimestamp", "()D", "getConversationId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class LoadMoreMessages extends Action {
        private final double beforeTimestamp;
        private final String conversationId;

        public static /* synthetic */ LoadMoreMessages copy$default(LoadMoreMessages loadMoreMessages, String str, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadMoreMessages.conversationId;
            }
            if ((i & 2) != 0) {
                d = loadMoreMessages.beforeTimestamp;
            }
            return loadMoreMessages.copy(str, d);
        }

        public final String component1() {
            return this.conversationId;
        }

        public final double component2() {
            return this.beforeTimestamp;
        }

        public final LoadMoreMessages copy(String str, double d) {
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new LoadMoreMessages(str, d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadMoreMessages)) {
                return false;
            }
            LoadMoreMessages loadMoreMessages = (LoadMoreMessages) obj;
            return Intrinsics.areEqual((Object) this.conversationId, (Object) loadMoreMessages.conversationId) && Intrinsics.areEqual((Object) Double.valueOf(this.beforeTimestamp), (Object) Double.valueOf(loadMoreMessages.beforeTimestamp));
        }

        public int hashCode() {
            return (this.conversationId.hashCode() * 31) + Double.hashCode(this.beforeTimestamp);
        }

        public String toString() {
            return "LoadMoreMessages(conversationId=" + this.conversationId + ", beforeTimestamp=" + this.beforeTimestamp + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadMoreMessages(String str, double d) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.conversationId = str;
            this.beforeTimestamp = d;
        }

        public final double getBeforeTimestamp() {
            return this.beforeTimestamp;
        }

        public final String getConversationId() {
            return this.conversationId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$NetworkConnectionStatusUpdate;", "Lzendesk/conversationkit/android/internal/Action;", "connectionStatus", "Lzendesk/conversationkit/android/ConnectionStatus;", "(Lzendesk/conversationkit/android/ConnectionStatus;)V", "getConnectionStatus", "()Lzendesk/conversationkit/android/ConnectionStatus;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class NetworkConnectionStatusUpdate extends Action {
        private final ConnectionStatus connectionStatus;

        public static /* synthetic */ NetworkConnectionStatusUpdate copy$default(NetworkConnectionStatusUpdate networkConnectionStatusUpdate, ConnectionStatus connectionStatus2, int i, Object obj) {
            if ((i & 1) != 0) {
                connectionStatus2 = networkConnectionStatusUpdate.connectionStatus;
            }
            return networkConnectionStatusUpdate.copy(connectionStatus2);
        }

        public final ConnectionStatus component1() {
            return this.connectionStatus;
        }

        public final NetworkConnectionStatusUpdate copy(ConnectionStatus connectionStatus2) {
            Intrinsics.checkNotNullParameter(connectionStatus2, "connectionStatus");
            return new NetworkConnectionStatusUpdate(connectionStatus2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NetworkConnectionStatusUpdate) && this.connectionStatus == ((NetworkConnectionStatusUpdate) obj).connectionStatus;
        }

        public int hashCode() {
            return this.connectionStatus.hashCode();
        }

        public String toString() {
            return "NetworkConnectionStatusUpdate(connectionStatus=" + this.connectionStatus + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NetworkConnectionStatusUpdate(ConnectionStatus connectionStatus2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(connectionStatus2, "connectionStatus");
            this.connectionStatus = connectionStatus2;
        }

        public final ConnectionStatus getConnectionStatus() {
            return this.connectionStatus;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$CreateUser;", "Lzendesk/conversationkit/android/internal/Action;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class CreateUser extends Action {
        public static final CreateUser INSTANCE = new CreateUser();

        private CreateUser() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$CheckForPersistedUser;", "Lzendesk/conversationkit/android/internal/Action;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class CheckForPersistedUser extends Action {
        public static final CheckForPersistedUser INSTANCE = new CheckForPersistedUser();

        private CheckForPersistedUser() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$StartRealtimeConnection;", "Lzendesk/conversationkit/android/internal/Action;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class StartRealtimeConnection extends Action {
        public static final StartRealtimeConnection INSTANCE = new StartRealtimeConnection();

        private StartRealtimeConnection() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$PauseRealtimeConnection;", "Lzendesk/conversationkit/android/internal/Action;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class PauseRealtimeConnection extends Action {
        public static final PauseRealtimeConnection INSTANCE = new PauseRealtimeConnection();

        private PauseRealtimeConnection() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$RefreshUser;", "Lzendesk/conversationkit/android/internal/Action;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class RefreshUser extends Action {
        public static final RefreshUser INSTANCE = new RefreshUser();

        private RefreshUser() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$LoginUser;", "Lzendesk/conversationkit/android/internal/Action;", "jwt", "", "(Ljava/lang/String;)V", "getJwt", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class LoginUser extends Action {
        private final String jwt;

        public static /* synthetic */ LoginUser copy$default(LoginUser loginUser, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loginUser.jwt;
            }
            return loginUser.copy(str);
        }

        public final String component1() {
            return this.jwt;
        }

        public final LoginUser copy(String str) {
            Intrinsics.checkNotNullParameter(str, "jwt");
            return new LoginUser(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoginUser) && Intrinsics.areEqual((Object) this.jwt, (Object) ((LoginUser) obj).jwt);
        }

        public int hashCode() {
            return this.jwt.hashCode();
        }

        public String toString() {
            return "LoginUser(jwt=" + this.jwt + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoginUser(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "jwt");
            this.jwt = str;
        }

        public final String getJwt() {
            return this.jwt;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$LogoutUser;", "Lzendesk/conversationkit/android/internal/Action;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class LogoutUser extends Action {
        public static final LogoutUser INSTANCE = new LogoutUser();

        private LogoutUser() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$CreateConversation;", "Lzendesk/conversationkit/android/internal/Action;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class CreateConversation extends Action {
        public static final CreateConversation INSTANCE = new CreateConversation();

        private CreateConversation() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$GetConversation;", "Lzendesk/conversationkit/android/internal/Action;", "conversationId", "", "(Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class GetConversation extends Action {
        private final String conversationId;

        public static /* synthetic */ GetConversation copy$default(GetConversation getConversation, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = getConversation.conversationId;
            }
            return getConversation.copy(str);
        }

        public final String component1() {
            return this.conversationId;
        }

        public final GetConversation copy(String str) {
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new GetConversation(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetConversation) && Intrinsics.areEqual((Object) this.conversationId, (Object) ((GetConversation) obj).conversationId);
        }

        public int hashCode() {
            return this.conversationId.hashCode();
        }

        public String toString() {
            return "GetConversation(conversationId=" + this.conversationId + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GetConversation(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.conversationId = str;
        }

        public final String getConversationId() {
            return this.conversationId;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$RefreshConversation;", "Lzendesk/conversationkit/android/internal/Action;", "conversationId", "", "(Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class RefreshConversation extends Action {
        private final String conversationId;

        public static /* synthetic */ RefreshConversation copy$default(RefreshConversation refreshConversation, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = refreshConversation.conversationId;
            }
            return refreshConversation.copy(str);
        }

        public final String component1() {
            return this.conversationId;
        }

        public final RefreshConversation copy(String str) {
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new RefreshConversation(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RefreshConversation) && Intrinsics.areEqual((Object) this.conversationId, (Object) ((RefreshConversation) obj).conversationId);
        }

        public int hashCode() {
            return this.conversationId.hashCode();
        }

        public String toString() {
            return "RefreshConversation(conversationId=" + this.conversationId + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RefreshConversation(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.conversationId = str;
        }

        public final String getConversationId() {
            return this.conversationId;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$PrepareMessage;", "Lzendesk/conversationkit/android/internal/Action;", "message", "Lzendesk/conversationkit/android/model/Message;", "conversationId", "", "(Lzendesk/conversationkit/android/model/Message;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getMessage", "()Lzendesk/conversationkit/android/model/Message;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class PrepareMessage extends Action {
        private final String conversationId;
        private final Message message;

        public static /* synthetic */ PrepareMessage copy$default(PrepareMessage prepareMessage, Message message2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                message2 = prepareMessage.message;
            }
            if ((i & 2) != 0) {
                str = prepareMessage.conversationId;
            }
            return prepareMessage.copy(message2, str);
        }

        public final Message component1() {
            return this.message;
        }

        public final String component2() {
            return this.conversationId;
        }

        public final PrepareMessage copy(Message message2, String str) {
            Intrinsics.checkNotNullParameter(message2, "message");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new PrepareMessage(message2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PrepareMessage)) {
                return false;
            }
            PrepareMessage prepareMessage = (PrepareMessage) obj;
            return Intrinsics.areEqual((Object) this.message, (Object) prepareMessage.message) && Intrinsics.areEqual((Object) this.conversationId, (Object) prepareMessage.conversationId);
        }

        public int hashCode() {
            return (this.message.hashCode() * 31) + this.conversationId.hashCode();
        }

        public String toString() {
            return "PrepareMessage(message=" + this.message + ", conversationId=" + this.conversationId + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PrepareMessage(Message message2, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(message2, "message");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.message = message2;
            this.conversationId = str;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final Message getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$SendMessage;", "Lzendesk/conversationkit/android/internal/Action;", "message", "Lzendesk/conversationkit/android/model/Message;", "conversationId", "", "(Lzendesk/conversationkit/android/model/Message;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getMessage", "()Lzendesk/conversationkit/android/model/Message;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class SendMessage extends Action {
        private final String conversationId;
        private final Message message;

        public static /* synthetic */ SendMessage copy$default(SendMessage sendMessage, Message message2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                message2 = sendMessage.message;
            }
            if ((i & 2) != 0) {
                str = sendMessage.conversationId;
            }
            return sendMessage.copy(message2, str);
        }

        public final Message component1() {
            return this.message;
        }

        public final String component2() {
            return this.conversationId;
        }

        public final SendMessage copy(Message message2, String str) {
            Intrinsics.checkNotNullParameter(message2, "message");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new SendMessage(message2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SendMessage)) {
                return false;
            }
            SendMessage sendMessage = (SendMessage) obj;
            return Intrinsics.areEqual((Object) this.message, (Object) sendMessage.message) && Intrinsics.areEqual((Object) this.conversationId, (Object) sendMessage.conversationId);
        }

        public int hashCode() {
            return (this.message.hashCode() * 31) + this.conversationId.hashCode();
        }

        public String toString() {
            return "SendMessage(message=" + this.message + ", conversationId=" + this.conversationId + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SendMessage(Message message2, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(message2, "message");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.message = message2;
            this.conversationId = str;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final Message getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$PreparePushToken;", "Lzendesk/conversationkit/android/internal/Action;", "pushToken", "", "(Ljava/lang/String;)V", "getPushToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class PreparePushToken extends Action {
        private final String pushToken;

        public static /* synthetic */ PreparePushToken copy$default(PreparePushToken preparePushToken, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = preparePushToken.pushToken;
            }
            return preparePushToken.copy(str);
        }

        public final String component1() {
            return this.pushToken;
        }

        public final PreparePushToken copy(String str) {
            Intrinsics.checkNotNullParameter(str, "pushToken");
            return new PreparePushToken(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PreparePushToken) && Intrinsics.areEqual((Object) this.pushToken, (Object) ((PreparePushToken) obj).pushToken);
        }

        public int hashCode() {
            return this.pushToken.hashCode();
        }

        public String toString() {
            return "PreparePushToken(pushToken=" + this.pushToken + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PreparePushToken(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "pushToken");
            this.pushToken = str;
        }

        public final String getPushToken() {
            return this.pushToken;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$UpdatePushToken;", "Lzendesk/conversationkit/android/internal/Action;", "pushToken", "", "(Ljava/lang/String;)V", "getPushToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class UpdatePushToken extends Action {
        private final String pushToken;

        public static /* synthetic */ UpdatePushToken copy$default(UpdatePushToken updatePushToken, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updatePushToken.pushToken;
            }
            return updatePushToken.copy(str);
        }

        public final String component1() {
            return this.pushToken;
        }

        public final UpdatePushToken copy(String str) {
            Intrinsics.checkNotNullParameter(str, "pushToken");
            return new UpdatePushToken(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdatePushToken) && Intrinsics.areEqual((Object) this.pushToken, (Object) ((UpdatePushToken) obj).pushToken);
        }

        public int hashCode() {
            return this.pushToken.hashCode();
        }

        public String toString() {
            return "UpdatePushToken(pushToken=" + this.pushToken + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpdatePushToken(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "pushToken");
            this.pushToken = str;
        }

        public final String getPushToken() {
            return this.pushToken;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$SendActivityData;", "Lzendesk/conversationkit/android/internal/Action;", "activityData", "Lzendesk/conversationkit/android/model/ActivityData;", "conversationId", "", "(Lzendesk/conversationkit/android/model/ActivityData;Ljava/lang/String;)V", "getActivityData", "()Lzendesk/conversationkit/android/model/ActivityData;", "getConversationId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class SendActivityData extends Action {
        private final ActivityData activityData;
        private final String conversationId;

        public static /* synthetic */ SendActivityData copy$default(SendActivityData sendActivityData, ActivityData activityData2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                activityData2 = sendActivityData.activityData;
            }
            if ((i & 2) != 0) {
                str = sendActivityData.conversationId;
            }
            return sendActivityData.copy(activityData2, str);
        }

        public final ActivityData component1() {
            return this.activityData;
        }

        public final String component2() {
            return this.conversationId;
        }

        public final SendActivityData copy(ActivityData activityData2, String str) {
            Intrinsics.checkNotNullParameter(activityData2, "activityData");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new SendActivityData(activityData2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SendActivityData)) {
                return false;
            }
            SendActivityData sendActivityData = (SendActivityData) obj;
            return this.activityData == sendActivityData.activityData && Intrinsics.areEqual((Object) this.conversationId, (Object) sendActivityData.conversationId);
        }

        public int hashCode() {
            return (this.activityData.hashCode() * 31) + this.conversationId.hashCode();
        }

        public String toString() {
            return "SendActivityData(activityData=" + this.activityData + ", conversationId=" + this.conversationId + ')';
        }

        public final ActivityData getActivityData() {
            return this.activityData;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SendActivityData(ActivityData activityData2, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(activityData2, "activityData");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.activityData = activityData2;
            this.conversationId = str;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$ActivityEventReceived;", "Lzendesk/conversationkit/android/internal/Action;", "activityEvent", "Lzendesk/conversationkit/android/model/ActivityEvent;", "(Lzendesk/conversationkit/android/model/ActivityEvent;)V", "getActivityEvent", "()Lzendesk/conversationkit/android/model/ActivityEvent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class ActivityEventReceived extends Action {
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

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$UpdateAppUserLocale;", "Lzendesk/conversationkit/android/internal/Action;", "deviceLocale", "", "(Ljava/lang/String;)V", "getDeviceLocale", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class UpdateAppUserLocale extends Action {
        private final String deviceLocale;

        public static /* synthetic */ UpdateAppUserLocale copy$default(UpdateAppUserLocale updateAppUserLocale, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updateAppUserLocale.deviceLocale;
            }
            return updateAppUserLocale.copy(str);
        }

        public final String component1() {
            return this.deviceLocale;
        }

        public final UpdateAppUserLocale copy(String str) {
            Intrinsics.checkNotNullParameter(str, "deviceLocale");
            return new UpdateAppUserLocale(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateAppUserLocale) && Intrinsics.areEqual((Object) this.deviceLocale, (Object) ((UpdateAppUserLocale) obj).deviceLocale);
        }

        public int hashCode() {
            return this.deviceLocale.hashCode();
        }

        public String toString() {
            return "UpdateAppUserLocale(deviceLocale=" + this.deviceLocale + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpdateAppUserLocale(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "deviceLocale");
            this.deviceLocale = str;
        }

        public final String getDeviceLocale() {
            return this.deviceLocale;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$PersistedUserRetrieve;", "Lzendesk/conversationkit/android/internal/Action;", "user", "Lzendesk/conversationkit/android/model/User;", "(Lzendesk/conversationkit/android/model/User;)V", "getUser", "()Lzendesk/conversationkit/android/model/User;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class PersistedUserRetrieve extends Action {
        private final User user;

        public static /* synthetic */ PersistedUserRetrieve copy$default(PersistedUserRetrieve persistedUserRetrieve, User user2, int i, Object obj) {
            if ((i & 1) != 0) {
                user2 = persistedUserRetrieve.user;
            }
            return persistedUserRetrieve.copy(user2);
        }

        public final User component1() {
            return this.user;
        }

        public final PersistedUserRetrieve copy(User user2) {
            Intrinsics.checkNotNullParameter(user2, "user");
            return new PersistedUserRetrieve(user2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PersistedUserRetrieve) && Intrinsics.areEqual((Object) this.user, (Object) ((PersistedUserRetrieve) obj).user);
        }

        public int hashCode() {
            return this.user.hashCode();
        }

        public String toString() {
            return "PersistedUserRetrieve(user=" + this.user + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PersistedUserRetrieve(User user2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(user2, "user");
            this.user = user2;
        }

        public final User getUser() {
            return this.user;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$GetVisitType;", "Lzendesk/conversationkit/android/internal/Action;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class GetVisitType extends Action {
        public static final GetVisitType INSTANCE = new GetVisitType();

        private GetVisitType() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$SetVisitType;", "Lzendesk/conversationkit/android/internal/Action;", "visitType", "Lzendesk/conversationkit/android/model/VisitType;", "(Lzendesk/conversationkit/android/model/VisitType;)V", "getVisitType", "()Lzendesk/conversationkit/android/model/VisitType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class SetVisitType extends Action {
        private final VisitType visitType;

        public static /* synthetic */ SetVisitType copy$default(SetVisitType setVisitType, VisitType visitType2, int i, Object obj) {
            if ((i & 1) != 0) {
                visitType2 = setVisitType.visitType;
            }
            return setVisitType.copy(visitType2);
        }

        public final VisitType component1() {
            return this.visitType;
        }

        public final SetVisitType copy(VisitType visitType2) {
            Intrinsics.checkNotNullParameter(visitType2, "visitType");
            return new SetVisitType(visitType2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SetVisitType) && this.visitType == ((SetVisitType) obj).visitType;
        }

        public int hashCode() {
            return this.visitType.hashCode();
        }

        public String toString() {
            return "SetVisitType(visitType=" + this.visitType + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SetVisitType(VisitType visitType2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(visitType2, "visitType");
            this.visitType = visitType2;
        }

        public final VisitType getVisitType() {
            return this.visitType;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$AddProactiveMessage;", "Lzendesk/conversationkit/android/internal/Action;", "proactiveMessage", "Lzendesk/conversationkit/android/model/ProactiveMessage;", "(Lzendesk/conversationkit/android/model/ProactiveMessage;)V", "getProactiveMessage", "()Lzendesk/conversationkit/android/model/ProactiveMessage;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class AddProactiveMessage extends Action {
        private final ProactiveMessage proactiveMessage;

        public static /* synthetic */ AddProactiveMessage copy$default(AddProactiveMessage addProactiveMessage, ProactiveMessage proactiveMessage2, int i, Object obj) {
            if ((i & 1) != 0) {
                proactiveMessage2 = addProactiveMessage.proactiveMessage;
            }
            return addProactiveMessage.copy(proactiveMessage2);
        }

        public final ProactiveMessage component1() {
            return this.proactiveMessage;
        }

        public final AddProactiveMessage copy(ProactiveMessage proactiveMessage2) {
            Intrinsics.checkNotNullParameter(proactiveMessage2, "proactiveMessage");
            return new AddProactiveMessage(proactiveMessage2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AddProactiveMessage) && Intrinsics.areEqual((Object) this.proactiveMessage, (Object) ((AddProactiveMessage) obj).proactiveMessage);
        }

        public int hashCode() {
            return this.proactiveMessage.hashCode();
        }

        public String toString() {
            return "AddProactiveMessage(proactiveMessage=" + this.proactiveMessage + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AddProactiveMessage(ProactiveMessage proactiveMessage2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(proactiveMessage2, "proactiveMessage");
            this.proactiveMessage = proactiveMessage2;
        }

        public final ProactiveMessage getProactiveMessage() {
            return this.proactiveMessage;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/conversationkit/android/internal/Action$GetProactiveMessage;", "Lzendesk/conversationkit/android/internal/Action;", "proactiveMessageId", "", "(I)V", "getProactiveMessageId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Action.kt */
    public static final class GetProactiveMessage extends Action {
        private final int proactiveMessageId;

        public static /* synthetic */ GetProactiveMessage copy$default(GetProactiveMessage getProactiveMessage, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = getProactiveMessage.proactiveMessageId;
            }
            return getProactiveMessage.copy(i);
        }

        public final int component1() {
            return this.proactiveMessageId;
        }

        public final GetProactiveMessage copy(int i) {
            return new GetProactiveMessage(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetProactiveMessage) && this.proactiveMessageId == ((GetProactiveMessage) obj).proactiveMessageId;
        }

        public int hashCode() {
            return Integer.hashCode(this.proactiveMessageId);
        }

        public String toString() {
            return "GetProactiveMessage(proactiveMessageId=" + this.proactiveMessageId + ')';
        }

        public GetProactiveMessage(int i) {
            super((DefaultConstructorMarker) null);
            this.proactiveMessageId = i;
        }

        public final int getProactiveMessageId() {
            return this.proactiveMessageId;
        }
    }
}
