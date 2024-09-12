package zendesk.conversationkit.android.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.ConnectionStatus;
import zendesk.conversationkit.android.ConversationKitResult;
import zendesk.conversationkit.android.ConversationKitSettings;
import zendesk.conversationkit.android.model.ActivityEvent;
import zendesk.conversationkit.android.model.Config;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.conversationkit.android.model.Message;
import zendesk.conversationkit.android.model.ProactiveMessage;
import zendesk.conversationkit.android.model.User;
import zendesk.conversationkit.android.model.VisitType;
import zendesk.faye.internal.Bayeux;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u001c\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001eB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u001b\u001f !\"#$%&'()*+,-./0123456789¨\u0006:"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect;", "", "()V", "ActivityEventReceived", "AlreadyLoggedInResult", "CheckForPersistedUserResult", "ConfigResultReceived", "ConnectionChanged", "CreateConversationResult", "CreateUserResult", "GetConversationResult", "GetProactiveMessage", "GetVisitType", "IncorrectAccessLevel", "LoadMoreMessages", "LoginUserResult", "LogoutUserResult", "MessagePrepared", "MessageReceived", "NetworkConnectionChanged", "None", "PersistedUserReceived", "PushTokenPrepared", "PushTokenUpdateResult", "RealtimeConnectionChanged", "RefreshConversationResult", "RefreshUserResult", "SendMessageResult", "SettingsAndConfigReceived", "SettingsReceived", "UserAccessRevoked", "Lzendesk/conversationkit/android/internal/Effect$None;", "Lzendesk/conversationkit/android/internal/Effect$IncorrectAccessLevel;", "Lzendesk/conversationkit/android/internal/Effect$UserAccessRevoked;", "Lzendesk/conversationkit/android/internal/Effect$SettingsReceived;", "Lzendesk/conversationkit/android/internal/Effect$SettingsAndConfigReceived;", "Lzendesk/conversationkit/android/internal/Effect$ConfigResultReceived;", "Lzendesk/conversationkit/android/internal/Effect$NetworkConnectionChanged;", "Lzendesk/conversationkit/android/internal/Effect$RealtimeConnectionChanged;", "Lzendesk/conversationkit/android/internal/Effect$CreateUserResult;", "Lzendesk/conversationkit/android/internal/Effect$LoginUserResult;", "Lzendesk/conversationkit/android/internal/Effect$AlreadyLoggedInResult;", "Lzendesk/conversationkit/android/internal/Effect$LogoutUserResult;", "Lzendesk/conversationkit/android/internal/Effect$CheckForPersistedUserResult;", "Lzendesk/conversationkit/android/internal/Effect$RefreshUserResult;", "Lzendesk/conversationkit/android/internal/Effect$CreateConversationResult;", "Lzendesk/conversationkit/android/internal/Effect$GetConversationResult;", "Lzendesk/conversationkit/android/internal/Effect$RefreshConversationResult;", "Lzendesk/conversationkit/android/internal/Effect$MessageReceived;", "Lzendesk/conversationkit/android/internal/Effect$LoadMoreMessages;", "Lzendesk/conversationkit/android/internal/Effect$MessagePrepared;", "Lzendesk/conversationkit/android/internal/Effect$SendMessageResult;", "Lzendesk/conversationkit/android/internal/Effect$PushTokenPrepared;", "Lzendesk/conversationkit/android/internal/Effect$PushTokenUpdateResult;", "Lzendesk/conversationkit/android/internal/Effect$ActivityEventReceived;", "Lzendesk/conversationkit/android/internal/Effect$PersistedUserReceived;", "Lzendesk/conversationkit/android/internal/Effect$GetVisitType;", "Lzendesk/conversationkit/android/internal/Effect$GetProactiveMessage;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Effect.kt */
public abstract class Effect {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$ConnectionChanged;", "", "connectionStatus", "Lzendesk/conversationkit/android/ConnectionStatus;", "getConnectionStatus", "()Lzendesk/conversationkit/android/ConnectionStatus;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public interface ConnectionChanged {
        ConnectionStatus getConnectionStatus();
    }

    public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Effect() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$None;", "Lzendesk/conversationkit/android/internal/Effect;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class None extends Effect {
        public static final None INSTANCE = new None();

        private None() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$IncorrectAccessLevel;", "Lzendesk/conversationkit/android/internal/Effect;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class IncorrectAccessLevel extends Effect {
        public static final IncorrectAccessLevel INSTANCE = new IncorrectAccessLevel();

        private IncorrectAccessLevel() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$UserAccessRevoked;", "Lzendesk/conversationkit/android/internal/Effect;", "conversationKitSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "config", "Lzendesk/conversationkit/android/model/Config;", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "", "(Lzendesk/conversationkit/android/ConversationKitSettings;Lzendesk/conversationkit/android/model/Config;Lzendesk/conversationkit/android/ConversationKitResult;)V", "getConfig", "()Lzendesk/conversationkit/android/model/Config;", "getConversationKitSettings", "()Lzendesk/conversationkit/android/ConversationKitSettings;", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class UserAccessRevoked extends Effect {
        private final Config config;
        private final ConversationKitSettings conversationKitSettings;
        private final ConversationKitResult<Object> result;

        public static /* synthetic */ UserAccessRevoked copy$default(UserAccessRevoked userAccessRevoked, ConversationKitSettings conversationKitSettings2, Config config2, ConversationKitResult<Object> conversationKitResult, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitSettings2 = userAccessRevoked.conversationKitSettings;
            }
            if ((i & 2) != 0) {
                config2 = userAccessRevoked.config;
            }
            if ((i & 4) != 0) {
                conversationKitResult = userAccessRevoked.result;
            }
            return userAccessRevoked.copy(conversationKitSettings2, config2, conversationKitResult);
        }

        public final ConversationKitSettings component1() {
            return this.conversationKitSettings;
        }

        public final Config component2() {
            return this.config;
        }

        public final ConversationKitResult<Object> component3() {
            return this.result;
        }

        public final UserAccessRevoked copy(ConversationKitSettings conversationKitSettings2, Config config2, ConversationKitResult<? extends Object> conversationKitResult) {
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(config2, "config");
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            return new UserAccessRevoked(conversationKitSettings2, config2, conversationKitResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserAccessRevoked)) {
                return false;
            }
            UserAccessRevoked userAccessRevoked = (UserAccessRevoked) obj;
            return Intrinsics.areEqual((Object) this.conversationKitSettings, (Object) userAccessRevoked.conversationKitSettings) && Intrinsics.areEqual((Object) this.config, (Object) userAccessRevoked.config) && Intrinsics.areEqual((Object) this.result, (Object) userAccessRevoked.result);
        }

        public int hashCode() {
            return (((this.conversationKitSettings.hashCode() * 31) + this.config.hashCode()) * 31) + this.result.hashCode();
        }

        public String toString() {
            return "UserAccessRevoked(conversationKitSettings=" + this.conversationKitSettings + ", config=" + this.config + ", result=" + this.result + ')';
        }

        public final ConversationKitSettings getConversationKitSettings() {
            return this.conversationKitSettings;
        }

        public final Config getConfig() {
            return this.config;
        }

        public final ConversationKitResult<Object> getResult() {
            return this.result;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UserAccessRevoked(ConversationKitSettings conversationKitSettings2, Config config2, ConversationKitResult<? extends Object> conversationKitResult) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(config2, "config");
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            this.conversationKitSettings = conversationKitSettings2;
            this.config = config2;
            this.result = conversationKitResult;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$SettingsReceived;", "Lzendesk/conversationkit/android/internal/Effect;", "conversationKitSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "(Lzendesk/conversationkit/android/ConversationKitSettings;)V", "getConversationKitSettings", "()Lzendesk/conversationkit/android/ConversationKitSettings;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class SettingsReceived extends Effect {
        private final ConversationKitSettings conversationKitSettings;

        public static /* synthetic */ SettingsReceived copy$default(SettingsReceived settingsReceived, ConversationKitSettings conversationKitSettings2, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitSettings2 = settingsReceived.conversationKitSettings;
            }
            return settingsReceived.copy(conversationKitSettings2);
        }

        public final ConversationKitSettings component1() {
            return this.conversationKitSettings;
        }

        public final SettingsReceived copy(ConversationKitSettings conversationKitSettings2) {
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            return new SettingsReceived(conversationKitSettings2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SettingsReceived) && Intrinsics.areEqual((Object) this.conversationKitSettings, (Object) ((SettingsReceived) obj).conversationKitSettings);
        }

        public int hashCode() {
            return this.conversationKitSettings.hashCode();
        }

        public String toString() {
            return "SettingsReceived(conversationKitSettings=" + this.conversationKitSettings + ')';
        }

        public final ConversationKitSettings getConversationKitSettings() {
            return this.conversationKitSettings;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SettingsReceived(ConversationKitSettings conversationKitSettings2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            this.conversationKitSettings = conversationKitSettings2;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$SettingsAndConfigReceived;", "Lzendesk/conversationkit/android/internal/Effect;", "conversationKitSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "config", "Lzendesk/conversationkit/android/model/Config;", "(Lzendesk/conversationkit/android/ConversationKitSettings;Lzendesk/conversationkit/android/model/Config;)V", "getConfig", "()Lzendesk/conversationkit/android/model/Config;", "getConversationKitSettings", "()Lzendesk/conversationkit/android/ConversationKitSettings;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class SettingsAndConfigReceived extends Effect {
        private final Config config;
        private final ConversationKitSettings conversationKitSettings;

        public static /* synthetic */ SettingsAndConfigReceived copy$default(SettingsAndConfigReceived settingsAndConfigReceived, ConversationKitSettings conversationKitSettings2, Config config2, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitSettings2 = settingsAndConfigReceived.conversationKitSettings;
            }
            if ((i & 2) != 0) {
                config2 = settingsAndConfigReceived.config;
            }
            return settingsAndConfigReceived.copy(conversationKitSettings2, config2);
        }

        public final ConversationKitSettings component1() {
            return this.conversationKitSettings;
        }

        public final Config component2() {
            return this.config;
        }

        public final SettingsAndConfigReceived copy(ConversationKitSettings conversationKitSettings2, Config config2) {
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(config2, "config");
            return new SettingsAndConfigReceived(conversationKitSettings2, config2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingsAndConfigReceived)) {
                return false;
            }
            SettingsAndConfigReceived settingsAndConfigReceived = (SettingsAndConfigReceived) obj;
            return Intrinsics.areEqual((Object) this.conversationKitSettings, (Object) settingsAndConfigReceived.conversationKitSettings) && Intrinsics.areEqual((Object) this.config, (Object) settingsAndConfigReceived.config);
        }

        public int hashCode() {
            return (this.conversationKitSettings.hashCode() * 31) + this.config.hashCode();
        }

        public String toString() {
            return "SettingsAndConfigReceived(conversationKitSettings=" + this.conversationKitSettings + ", config=" + this.config + ')';
        }

        public final ConversationKitSettings getConversationKitSettings() {
            return this.conversationKitSettings;
        }

        public final Config getConfig() {
            return this.config;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SettingsAndConfigReceived(ConversationKitSettings conversationKitSettings2, Config config2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(config2, "config");
            this.conversationKitSettings = conversationKitSettings2;
            this.config = config2;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$ConfigResultReceived;", "Lzendesk/conversationkit/android/internal/Effect;", "conversationKitSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "Lzendesk/conversationkit/android/model/Config;", "(Lzendesk/conversationkit/android/ConversationKitSettings;Lzendesk/conversationkit/android/ConversationKitResult;)V", "getConversationKitSettings", "()Lzendesk/conversationkit/android/ConversationKitSettings;", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class ConfigResultReceived extends Effect {
        private final ConversationKitSettings conversationKitSettings;
        private final ConversationKitResult<Config> result;

        public static /* synthetic */ ConfigResultReceived copy$default(ConfigResultReceived configResultReceived, ConversationKitSettings conversationKitSettings2, ConversationKitResult<Config> conversationKitResult, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitSettings2 = configResultReceived.conversationKitSettings;
            }
            if ((i & 2) != 0) {
                conversationKitResult = configResultReceived.result;
            }
            return configResultReceived.copy(conversationKitSettings2, conversationKitResult);
        }

        public final ConversationKitSettings component1() {
            return this.conversationKitSettings;
        }

        public final ConversationKitResult<Config> component2() {
            return this.result;
        }

        public final ConfigResultReceived copy(ConversationKitSettings conversationKitSettings2, ConversationKitResult<Config> conversationKitResult) {
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            return new ConfigResultReceived(conversationKitSettings2, conversationKitResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ConfigResultReceived)) {
                return false;
            }
            ConfigResultReceived configResultReceived = (ConfigResultReceived) obj;
            return Intrinsics.areEqual((Object) this.conversationKitSettings, (Object) configResultReceived.conversationKitSettings) && Intrinsics.areEqual((Object) this.result, (Object) configResultReceived.result);
        }

        public int hashCode() {
            return (this.conversationKitSettings.hashCode() * 31) + this.result.hashCode();
        }

        public String toString() {
            return "ConfigResultReceived(conversationKitSettings=" + this.conversationKitSettings + ", result=" + this.result + ')';
        }

        public final ConversationKitSettings getConversationKitSettings() {
            return this.conversationKitSettings;
        }

        public final ConversationKitResult<Config> getResult() {
            return this.result;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ConfigResultReceived(ConversationKitSettings conversationKitSettings2, ConversationKitResult<Config> conversationKitResult) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            this.conversationKitSettings = conversationKitSettings2;
            this.result = conversationKitResult;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$NetworkConnectionChanged;", "Lzendesk/conversationkit/android/internal/Effect;", "Lzendesk/conversationkit/android/internal/Effect$ConnectionChanged;", "connectionStatus", "Lzendesk/conversationkit/android/ConnectionStatus;", "(Lzendesk/conversationkit/android/ConnectionStatus;)V", "getConnectionStatus", "()Lzendesk/conversationkit/android/ConnectionStatus;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class NetworkConnectionChanged extends Effect implements ConnectionChanged {
        private final ConnectionStatus connectionStatus;

        public static /* synthetic */ NetworkConnectionChanged copy$default(NetworkConnectionChanged networkConnectionChanged, ConnectionStatus connectionStatus2, int i, Object obj) {
            if ((i & 1) != 0) {
                connectionStatus2 = networkConnectionChanged.getConnectionStatus();
            }
            return networkConnectionChanged.copy(connectionStatus2);
        }

        public final ConnectionStatus component1() {
            return getConnectionStatus();
        }

        public final NetworkConnectionChanged copy(ConnectionStatus connectionStatus2) {
            Intrinsics.checkNotNullParameter(connectionStatus2, "connectionStatus");
            return new NetworkConnectionChanged(connectionStatus2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NetworkConnectionChanged) && getConnectionStatus() == ((NetworkConnectionChanged) obj).getConnectionStatus();
        }

        public int hashCode() {
            return getConnectionStatus().hashCode();
        }

        public String toString() {
            return "NetworkConnectionChanged(connectionStatus=" + getConnectionStatus() + ')';
        }

        public ConnectionStatus getConnectionStatus() {
            return this.connectionStatus;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NetworkConnectionChanged(ConnectionStatus connectionStatus2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(connectionStatus2, "connectionStatus");
            this.connectionStatus = connectionStatus2;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$RealtimeConnectionChanged;", "Lzendesk/conversationkit/android/internal/Effect;", "Lzendesk/conversationkit/android/internal/Effect$ConnectionChanged;", "connectionStatus", "Lzendesk/conversationkit/android/ConnectionStatus;", "(Lzendesk/conversationkit/android/ConnectionStatus;)V", "getConnectionStatus", "()Lzendesk/conversationkit/android/ConnectionStatus;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class RealtimeConnectionChanged extends Effect implements ConnectionChanged {
        private final ConnectionStatus connectionStatus;

        public static /* synthetic */ RealtimeConnectionChanged copy$default(RealtimeConnectionChanged realtimeConnectionChanged, ConnectionStatus connectionStatus2, int i, Object obj) {
            if ((i & 1) != 0) {
                connectionStatus2 = realtimeConnectionChanged.getConnectionStatus();
            }
            return realtimeConnectionChanged.copy(connectionStatus2);
        }

        public final ConnectionStatus component1() {
            return getConnectionStatus();
        }

        public final RealtimeConnectionChanged copy(ConnectionStatus connectionStatus2) {
            Intrinsics.checkNotNullParameter(connectionStatus2, "connectionStatus");
            return new RealtimeConnectionChanged(connectionStatus2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RealtimeConnectionChanged) && getConnectionStatus() == ((RealtimeConnectionChanged) obj).getConnectionStatus();
        }

        public int hashCode() {
            return getConnectionStatus().hashCode();
        }

        public String toString() {
            return "RealtimeConnectionChanged(connectionStatus=" + getConnectionStatus() + ')';
        }

        public ConnectionStatus getConnectionStatus() {
            return this.connectionStatus;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RealtimeConnectionChanged(ConnectionStatus connectionStatus2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(connectionStatus2, "connectionStatus");
            this.connectionStatus = connectionStatus2;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\nHÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$CreateUserResult;", "Lzendesk/conversationkit/android/internal/Effect;", "conversationKitSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "config", "Lzendesk/conversationkit/android/model/Config;", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "Lzendesk/conversationkit/android/model/User;", "clientId", "", "pendingPushToken", "(Lzendesk/conversationkit/android/ConversationKitSettings;Lzendesk/conversationkit/android/model/Config;Lzendesk/conversationkit/android/ConversationKitResult;Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getConfig", "()Lzendesk/conversationkit/android/model/Config;", "getConversationKitSettings", "()Lzendesk/conversationkit/android/ConversationKitSettings;", "getPendingPushToken", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class CreateUserResult extends Effect {
        private final String clientId;
        private final Config config;
        private final ConversationKitSettings conversationKitSettings;
        private final String pendingPushToken;
        private final ConversationKitResult<User> result;

        public static /* synthetic */ CreateUserResult copy$default(CreateUserResult createUserResult, ConversationKitSettings conversationKitSettings2, Config config2, ConversationKitResult<User> conversationKitResult, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitSettings2 = createUserResult.conversationKitSettings;
            }
            if ((i & 2) != 0) {
                config2 = createUserResult.config;
            }
            Config config3 = config2;
            if ((i & 4) != 0) {
                conversationKitResult = createUserResult.result;
            }
            ConversationKitResult<User> conversationKitResult2 = conversationKitResult;
            if ((i & 8) != 0) {
                str = createUserResult.clientId;
            }
            String str3 = str;
            if ((i & 16) != 0) {
                str2 = createUserResult.pendingPushToken;
            }
            return createUserResult.copy(conversationKitSettings2, config3, conversationKitResult2, str3, str2);
        }

        public final ConversationKitSettings component1() {
            return this.conversationKitSettings;
        }

        public final Config component2() {
            return this.config;
        }

        public final ConversationKitResult<User> component3() {
            return this.result;
        }

        public final String component4() {
            return this.clientId;
        }

        public final String component5() {
            return this.pendingPushToken;
        }

        public final CreateUserResult copy(ConversationKitSettings conversationKitSettings2, Config config2, ConversationKitResult<User> conversationKitResult, String str, String str2) {
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(config2, "config");
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            Intrinsics.checkNotNullParameter(str, Bayeux.KEY_CLIENT_ID);
            return new CreateUserResult(conversationKitSettings2, config2, conversationKitResult, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CreateUserResult)) {
                return false;
            }
            CreateUserResult createUserResult = (CreateUserResult) obj;
            return Intrinsics.areEqual((Object) this.conversationKitSettings, (Object) createUserResult.conversationKitSettings) && Intrinsics.areEqual((Object) this.config, (Object) createUserResult.config) && Intrinsics.areEqual((Object) this.result, (Object) createUserResult.result) && Intrinsics.areEqual((Object) this.clientId, (Object) createUserResult.clientId) && Intrinsics.areEqual((Object) this.pendingPushToken, (Object) createUserResult.pendingPushToken);
        }

        public int hashCode() {
            int hashCode = ((((((this.conversationKitSettings.hashCode() * 31) + this.config.hashCode()) * 31) + this.result.hashCode()) * 31) + this.clientId.hashCode()) * 31;
            String str = this.pendingPushToken;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "CreateUserResult(conversationKitSettings=" + this.conversationKitSettings + ", config=" + this.config + ", result=" + this.result + ", clientId=" + this.clientId + ", pendingPushToken=" + this.pendingPushToken + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CreateUserResult(ConversationKitSettings conversationKitSettings2, Config config2, ConversationKitResult conversationKitResult, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(conversationKitSettings2, config2, conversationKitResult, str, (i & 16) != 0 ? null : str2);
        }

        public final ConversationKitSettings getConversationKitSettings() {
            return this.conversationKitSettings;
        }

        public final Config getConfig() {
            return this.config;
        }

        public final ConversationKitResult<User> getResult() {
            return this.result;
        }

        public final String getClientId() {
            return this.clientId;
        }

        public final String getPendingPushToken() {
            return this.pendingPushToken;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CreateUserResult(ConversationKitSettings conversationKitSettings2, Config config2, ConversationKitResult<User> conversationKitResult, String str, String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(config2, "config");
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            Intrinsics.checkNotNullParameter(str, Bayeux.KEY_CLIENT_ID);
            this.conversationKitSettings = conversationKitSettings2;
            this.config = config2;
            this.result = conversationKitResult;
            this.clientId = str;
            this.pendingPushToken = str2;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\nHÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$LoginUserResult;", "Lzendesk/conversationkit/android/internal/Effect;", "conversationKitSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "config", "Lzendesk/conversationkit/android/model/Config;", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "Lzendesk/conversationkit/android/model/User;", "clientId", "", "(Lzendesk/conversationkit/android/ConversationKitSettings;Lzendesk/conversationkit/android/model/Config;Lzendesk/conversationkit/android/ConversationKitResult;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getConfig", "()Lzendesk/conversationkit/android/model/Config;", "getConversationKitSettings", "()Lzendesk/conversationkit/android/ConversationKitSettings;", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class LoginUserResult extends Effect {
        private final String clientId;
        private final Config config;
        private final ConversationKitSettings conversationKitSettings;
        private final ConversationKitResult<User> result;

        public static /* synthetic */ LoginUserResult copy$default(LoginUserResult loginUserResult, ConversationKitSettings conversationKitSettings2, Config config2, ConversationKitResult<User> conversationKitResult, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitSettings2 = loginUserResult.conversationKitSettings;
            }
            if ((i & 2) != 0) {
                config2 = loginUserResult.config;
            }
            if ((i & 4) != 0) {
                conversationKitResult = loginUserResult.result;
            }
            if ((i & 8) != 0) {
                str = loginUserResult.clientId;
            }
            return loginUserResult.copy(conversationKitSettings2, config2, conversationKitResult, str);
        }

        public final ConversationKitSettings component1() {
            return this.conversationKitSettings;
        }

        public final Config component2() {
            return this.config;
        }

        public final ConversationKitResult<User> component3() {
            return this.result;
        }

        public final String component4() {
            return this.clientId;
        }

        public final LoginUserResult copy(ConversationKitSettings conversationKitSettings2, Config config2, ConversationKitResult<User> conversationKitResult, String str) {
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(config2, "config");
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            Intrinsics.checkNotNullParameter(str, Bayeux.KEY_CLIENT_ID);
            return new LoginUserResult(conversationKitSettings2, config2, conversationKitResult, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoginUserResult)) {
                return false;
            }
            LoginUserResult loginUserResult = (LoginUserResult) obj;
            return Intrinsics.areEqual((Object) this.conversationKitSettings, (Object) loginUserResult.conversationKitSettings) && Intrinsics.areEqual((Object) this.config, (Object) loginUserResult.config) && Intrinsics.areEqual((Object) this.result, (Object) loginUserResult.result) && Intrinsics.areEqual((Object) this.clientId, (Object) loginUserResult.clientId);
        }

        public int hashCode() {
            return (((((this.conversationKitSettings.hashCode() * 31) + this.config.hashCode()) * 31) + this.result.hashCode()) * 31) + this.clientId.hashCode();
        }

        public String toString() {
            return "LoginUserResult(conversationKitSettings=" + this.conversationKitSettings + ", config=" + this.config + ", result=" + this.result + ", clientId=" + this.clientId + ')';
        }

        public final ConversationKitSettings getConversationKitSettings() {
            return this.conversationKitSettings;
        }

        public final Config getConfig() {
            return this.config;
        }

        public final ConversationKitResult<User> getResult() {
            return this.result;
        }

        public final String getClientId() {
            return this.clientId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoginUserResult(ConversationKitSettings conversationKitSettings2, Config config2, ConversationKitResult<User> conversationKitResult, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(config2, "config");
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            Intrinsics.checkNotNullParameter(str, Bayeux.KEY_CLIENT_ID);
            this.conversationKitSettings = conversationKitSettings2;
            this.config = config2;
            this.result = conversationKitResult;
            this.clientId = str;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$AlreadyLoggedInResult;", "Lzendesk/conversationkit/android/internal/Effect;", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "Lzendesk/conversationkit/android/model/User;", "(Lzendesk/conversationkit/android/ConversationKitResult;)V", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class AlreadyLoggedInResult extends Effect {
        private final ConversationKitResult<User> result;

        public static /* synthetic */ AlreadyLoggedInResult copy$default(AlreadyLoggedInResult alreadyLoggedInResult, ConversationKitResult<User> conversationKitResult, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitResult = alreadyLoggedInResult.result;
            }
            return alreadyLoggedInResult.copy(conversationKitResult);
        }

        public final ConversationKitResult<User> component1() {
            return this.result;
        }

        public final AlreadyLoggedInResult copy(ConversationKitResult<User> conversationKitResult) {
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            return new AlreadyLoggedInResult(conversationKitResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AlreadyLoggedInResult) && Intrinsics.areEqual((Object) this.result, (Object) ((AlreadyLoggedInResult) obj).result);
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "AlreadyLoggedInResult(result=" + this.result + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AlreadyLoggedInResult(ConversationKitResult<User> conversationKitResult) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            this.result = conversationKitResult;
        }

        public final ConversationKitResult<User> getResult() {
            return this.result;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$LogoutUserResult;", "Lzendesk/conversationkit/android/internal/Effect;", "conversationKitSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "config", "Lzendesk/conversationkit/android/model/Config;", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "", "(Lzendesk/conversationkit/android/ConversationKitSettings;Lzendesk/conversationkit/android/model/Config;Lzendesk/conversationkit/android/ConversationKitResult;)V", "getConfig", "()Lzendesk/conversationkit/android/model/Config;", "getConversationKitSettings", "()Lzendesk/conversationkit/android/ConversationKitSettings;", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class LogoutUserResult extends Effect {
        private final Config config;
        private final ConversationKitSettings conversationKitSettings;
        private final ConversationKitResult<Object> result;

        public static /* synthetic */ LogoutUserResult copy$default(LogoutUserResult logoutUserResult, ConversationKitSettings conversationKitSettings2, Config config2, ConversationKitResult<Object> conversationKitResult, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitSettings2 = logoutUserResult.conversationKitSettings;
            }
            if ((i & 2) != 0) {
                config2 = logoutUserResult.config;
            }
            if ((i & 4) != 0) {
                conversationKitResult = logoutUserResult.result;
            }
            return logoutUserResult.copy(conversationKitSettings2, config2, conversationKitResult);
        }

        public final ConversationKitSettings component1() {
            return this.conversationKitSettings;
        }

        public final Config component2() {
            return this.config;
        }

        public final ConversationKitResult<Object> component3() {
            return this.result;
        }

        public final LogoutUserResult copy(ConversationKitSettings conversationKitSettings2, Config config2, ConversationKitResult<? extends Object> conversationKitResult) {
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(config2, "config");
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            return new LogoutUserResult(conversationKitSettings2, config2, conversationKitResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LogoutUserResult)) {
                return false;
            }
            LogoutUserResult logoutUserResult = (LogoutUserResult) obj;
            return Intrinsics.areEqual((Object) this.conversationKitSettings, (Object) logoutUserResult.conversationKitSettings) && Intrinsics.areEqual((Object) this.config, (Object) logoutUserResult.config) && Intrinsics.areEqual((Object) this.result, (Object) logoutUserResult.result);
        }

        public int hashCode() {
            return (((this.conversationKitSettings.hashCode() * 31) + this.config.hashCode()) * 31) + this.result.hashCode();
        }

        public String toString() {
            return "LogoutUserResult(conversationKitSettings=" + this.conversationKitSettings + ", config=" + this.config + ", result=" + this.result + ')';
        }

        public final ConversationKitSettings getConversationKitSettings() {
            return this.conversationKitSettings;
        }

        public final Config getConfig() {
            return this.config;
        }

        public final ConversationKitResult<Object> getResult() {
            return this.result;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LogoutUserResult(ConversationKitSettings conversationKitSettings2, Config config2, ConversationKitResult<? extends Object> conversationKitResult) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(config2, "config");
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            this.conversationKitSettings = conversationKitSettings2;
            this.config = config2;
            this.result = conversationKitResult;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\nHÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$CheckForPersistedUserResult;", "Lzendesk/conversationkit/android/internal/Effect;", "user", "Lzendesk/conversationkit/android/model/User;", "conversationKitSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "result", "Lzendesk/conversationkit/android/ConversationKitResult$Success;", "Lzendesk/conversationkit/android/model/Config;", "clientId", "", "(Lzendesk/conversationkit/android/model/User;Lzendesk/conversationkit/android/ConversationKitSettings;Lzendesk/conversationkit/android/ConversationKitResult$Success;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getConversationKitSettings", "()Lzendesk/conversationkit/android/ConversationKitSettings;", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult$Success;", "getUser", "()Lzendesk/conversationkit/android/model/User;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class CheckForPersistedUserResult extends Effect {
        private final String clientId;
        private final ConversationKitSettings conversationKitSettings;
        private final ConversationKitResult.Success<Config> result;
        private final User user;

        public static /* synthetic */ CheckForPersistedUserResult copy$default(CheckForPersistedUserResult checkForPersistedUserResult, User user2, ConversationKitSettings conversationKitSettings2, ConversationKitResult.Success<Config> success, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                user2 = checkForPersistedUserResult.user;
            }
            if ((i & 2) != 0) {
                conversationKitSettings2 = checkForPersistedUserResult.conversationKitSettings;
            }
            if ((i & 4) != 0) {
                success = checkForPersistedUserResult.result;
            }
            if ((i & 8) != 0) {
                str = checkForPersistedUserResult.clientId;
            }
            return checkForPersistedUserResult.copy(user2, conversationKitSettings2, success, str);
        }

        public final User component1() {
            return this.user;
        }

        public final ConversationKitSettings component2() {
            return this.conversationKitSettings;
        }

        public final ConversationKitResult.Success<Config> component3() {
            return this.result;
        }

        public final String component4() {
            return this.clientId;
        }

        public final CheckForPersistedUserResult copy(User user2, ConversationKitSettings conversationKitSettings2, ConversationKitResult.Success<Config> success, String str) {
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(success, "result");
            Intrinsics.checkNotNullParameter(str, Bayeux.KEY_CLIENT_ID);
            return new CheckForPersistedUserResult(user2, conversationKitSettings2, success, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CheckForPersistedUserResult)) {
                return false;
            }
            CheckForPersistedUserResult checkForPersistedUserResult = (CheckForPersistedUserResult) obj;
            return Intrinsics.areEqual((Object) this.user, (Object) checkForPersistedUserResult.user) && Intrinsics.areEqual((Object) this.conversationKitSettings, (Object) checkForPersistedUserResult.conversationKitSettings) && Intrinsics.areEqual((Object) this.result, (Object) checkForPersistedUserResult.result) && Intrinsics.areEqual((Object) this.clientId, (Object) checkForPersistedUserResult.clientId);
        }

        public int hashCode() {
            User user2 = this.user;
            return ((((((user2 == null ? 0 : user2.hashCode()) * 31) + this.conversationKitSettings.hashCode()) * 31) + this.result.hashCode()) * 31) + this.clientId.hashCode();
        }

        public String toString() {
            return "CheckForPersistedUserResult(user=" + this.user + ", conversationKitSettings=" + this.conversationKitSettings + ", result=" + this.result + ", clientId=" + this.clientId + ')';
        }

        public final User getUser() {
            return this.user;
        }

        public final ConversationKitSettings getConversationKitSettings() {
            return this.conversationKitSettings;
        }

        public final ConversationKitResult.Success<Config> getResult() {
            return this.result;
        }

        public final String getClientId() {
            return this.clientId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CheckForPersistedUserResult(User user2, ConversationKitSettings conversationKitSettings2, ConversationKitResult.Success<Config> success, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
            Intrinsics.checkNotNullParameter(success, "result");
            Intrinsics.checkNotNullParameter(str, Bayeux.KEY_CLIENT_ID);
            this.user = user2;
            this.conversationKitSettings = conversationKitSettings2;
            this.result = success;
            this.clientId = str;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$RefreshUserResult;", "Lzendesk/conversationkit/android/internal/Effect;", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "Lzendesk/conversationkit/android/model/User;", "persistedConversation", "Lzendesk/conversationkit/android/model/Conversation;", "(Lzendesk/conversationkit/android/ConversationKitResult;Lzendesk/conversationkit/android/model/Conversation;)V", "getPersistedConversation", "()Lzendesk/conversationkit/android/model/Conversation;", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class RefreshUserResult extends Effect {
        private final Conversation persistedConversation;
        private final ConversationKitResult<User> result;

        public static /* synthetic */ RefreshUserResult copy$default(RefreshUserResult refreshUserResult, ConversationKitResult<User> conversationKitResult, Conversation conversation, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitResult = refreshUserResult.result;
            }
            if ((i & 2) != 0) {
                conversation = refreshUserResult.persistedConversation;
            }
            return refreshUserResult.copy(conversationKitResult, conversation);
        }

        public final ConversationKitResult<User> component1() {
            return this.result;
        }

        public final Conversation component2() {
            return this.persistedConversation;
        }

        public final RefreshUserResult copy(ConversationKitResult<User> conversationKitResult, Conversation conversation) {
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            return new RefreshUserResult(conversationKitResult, conversation);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RefreshUserResult)) {
                return false;
            }
            RefreshUserResult refreshUserResult = (RefreshUserResult) obj;
            return Intrinsics.areEqual((Object) this.result, (Object) refreshUserResult.result) && Intrinsics.areEqual((Object) this.persistedConversation, (Object) refreshUserResult.persistedConversation);
        }

        public int hashCode() {
            int hashCode = this.result.hashCode() * 31;
            Conversation conversation = this.persistedConversation;
            return hashCode + (conversation == null ? 0 : conversation.hashCode());
        }

        public String toString() {
            return "RefreshUserResult(result=" + this.result + ", persistedConversation=" + this.persistedConversation + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ RefreshUserResult(ConversationKitResult conversationKitResult, Conversation conversation, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(conversationKitResult, (i & 2) != 0 ? null : conversation);
        }

        public final ConversationKitResult<User> getResult() {
            return this.result;
        }

        public final Conversation getPersistedConversation() {
            return this.persistedConversation;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RefreshUserResult(ConversationKitResult<User> conversationKitResult, Conversation conversation) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            this.result = conversationKitResult;
            this.persistedConversation = conversation;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$CreateConversationResult;", "Lzendesk/conversationkit/android/internal/Effect;", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "Lzendesk/conversationkit/android/model/Conversation;", "(Lzendesk/conversationkit/android/ConversationKitResult;)V", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class CreateConversationResult extends Effect {
        private final ConversationKitResult<Conversation> result;

        public static /* synthetic */ CreateConversationResult copy$default(CreateConversationResult createConversationResult, ConversationKitResult<Conversation> conversationKitResult, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitResult = createConversationResult.result;
            }
            return createConversationResult.copy(conversationKitResult);
        }

        public final ConversationKitResult<Conversation> component1() {
            return this.result;
        }

        public final CreateConversationResult copy(ConversationKitResult<Conversation> conversationKitResult) {
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            return new CreateConversationResult(conversationKitResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CreateConversationResult) && Intrinsics.areEqual((Object) this.result, (Object) ((CreateConversationResult) obj).result);
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "CreateConversationResult(result=" + this.result + ')';
        }

        public final ConversationKitResult<Conversation> getResult() {
            return this.result;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CreateConversationResult(ConversationKitResult<Conversation> conversationKitResult) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            this.result = conversationKitResult;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$GetConversationResult;", "Lzendesk/conversationkit/android/internal/Effect;", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "Lzendesk/conversationkit/android/model/Conversation;", "shouldRefresh", "", "(Lzendesk/conversationkit/android/ConversationKitResult;Z)V", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "getShouldRefresh", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class GetConversationResult extends Effect {
        private final ConversationKitResult<Conversation> result;
        private final boolean shouldRefresh;

        public static /* synthetic */ GetConversationResult copy$default(GetConversationResult getConversationResult, ConversationKitResult<Conversation> conversationKitResult, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitResult = getConversationResult.result;
            }
            if ((i & 2) != 0) {
                z = getConversationResult.shouldRefresh;
            }
            return getConversationResult.copy(conversationKitResult, z);
        }

        public final ConversationKitResult<Conversation> component1() {
            return this.result;
        }

        public final boolean component2() {
            return this.shouldRefresh;
        }

        public final GetConversationResult copy(ConversationKitResult<Conversation> conversationKitResult, boolean z) {
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            return new GetConversationResult(conversationKitResult, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GetConversationResult)) {
                return false;
            }
            GetConversationResult getConversationResult = (GetConversationResult) obj;
            return Intrinsics.areEqual((Object) this.result, (Object) getConversationResult.result) && this.shouldRefresh == getConversationResult.shouldRefresh;
        }

        public int hashCode() {
            int hashCode = this.result.hashCode() * 31;
            boolean z = this.shouldRefresh;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public String toString() {
            return "GetConversationResult(result=" + this.result + ", shouldRefresh=" + this.shouldRefresh + ')';
        }

        public final ConversationKitResult<Conversation> getResult() {
            return this.result;
        }

        public final boolean getShouldRefresh() {
            return this.shouldRefresh;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GetConversationResult(ConversationKitResult<Conversation> conversationKitResult, boolean z) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            this.result = conversationKitResult;
            this.shouldRefresh = z;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$RefreshConversationResult;", "Lzendesk/conversationkit/android/internal/Effect;", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "Lzendesk/conversationkit/android/model/Conversation;", "(Lzendesk/conversationkit/android/ConversationKitResult;)V", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class RefreshConversationResult extends Effect {
        private final ConversationKitResult<Conversation> result;

        public static /* synthetic */ RefreshConversationResult copy$default(RefreshConversationResult refreshConversationResult, ConversationKitResult<Conversation> conversationKitResult, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitResult = refreshConversationResult.result;
            }
            return refreshConversationResult.copy(conversationKitResult);
        }

        public final ConversationKitResult<Conversation> component1() {
            return this.result;
        }

        public final RefreshConversationResult copy(ConversationKitResult<Conversation> conversationKitResult) {
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            return new RefreshConversationResult(conversationKitResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RefreshConversationResult) && Intrinsics.areEqual((Object) this.result, (Object) ((RefreshConversationResult) obj).result);
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "RefreshConversationResult(result=" + this.result + ')';
        }

        public final ConversationKitResult<Conversation> getResult() {
            return this.result;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RefreshConversationResult(ConversationKitResult<Conversation> conversationKitResult) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            this.result = conversationKitResult;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$MessageReceived;", "Lzendesk/conversationkit/android/internal/Effect;", "message", "Lzendesk/conversationkit/android/model/Message;", "conversationId", "", "conversation", "Lzendesk/conversationkit/android/model/Conversation;", "(Lzendesk/conversationkit/android/model/Message;Ljava/lang/String;Lzendesk/conversationkit/android/model/Conversation;)V", "getConversation", "()Lzendesk/conversationkit/android/model/Conversation;", "getConversationId", "()Ljava/lang/String;", "getMessage", "()Lzendesk/conversationkit/android/model/Message;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class MessageReceived extends Effect {
        private final Conversation conversation;
        private final String conversationId;
        private final Message message;

        public static /* synthetic */ MessageReceived copy$default(MessageReceived messageReceived, Message message2, String str, Conversation conversation2, int i, Object obj) {
            if ((i & 1) != 0) {
                message2 = messageReceived.message;
            }
            if ((i & 2) != 0) {
                str = messageReceived.conversationId;
            }
            if ((i & 4) != 0) {
                conversation2 = messageReceived.conversation;
            }
            return messageReceived.copy(message2, str, conversation2);
        }

        public final Message component1() {
            return this.message;
        }

        public final String component2() {
            return this.conversationId;
        }

        public final Conversation component3() {
            return this.conversation;
        }

        public final MessageReceived copy(Message message2, String str, Conversation conversation2) {
            Intrinsics.checkNotNullParameter(message2, "message");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new MessageReceived(message2, str, conversation2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MessageReceived)) {
                return false;
            }
            MessageReceived messageReceived = (MessageReceived) obj;
            return Intrinsics.areEqual((Object) this.message, (Object) messageReceived.message) && Intrinsics.areEqual((Object) this.conversationId, (Object) messageReceived.conversationId) && Intrinsics.areEqual((Object) this.conversation, (Object) messageReceived.conversation);
        }

        public int hashCode() {
            int hashCode = ((this.message.hashCode() * 31) + this.conversationId.hashCode()) * 31;
            Conversation conversation2 = this.conversation;
            return hashCode + (conversation2 == null ? 0 : conversation2.hashCode());
        }

        public String toString() {
            return "MessageReceived(message=" + this.message + ", conversationId=" + this.conversationId + ", conversation=" + this.conversation + ')';
        }

        public final Message getMessage() {
            return this.message;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final Conversation getConversation() {
            return this.conversation;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MessageReceived(Message message2, String str, Conversation conversation2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(message2, "message");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.message = message2;
            this.conversationId = str;
            this.conversation = conversation2;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$LoadMoreMessages;", "Lzendesk/conversationkit/android/internal/Effect;", "conversationId", "", "conversation", "Lzendesk/conversationkit/android/model/Conversation;", "beforeTimestamp", "", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "", "Lzendesk/conversationkit/android/model/Message;", "(Ljava/lang/String;Lzendesk/conversationkit/android/model/Conversation;DLzendesk/conversationkit/android/ConversationKitResult;)V", "getBeforeTimestamp", "()D", "getConversation", "()Lzendesk/conversationkit/android/model/Conversation;", "getConversationId", "()Ljava/lang/String;", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class LoadMoreMessages extends Effect {
        private final double beforeTimestamp;
        private final Conversation conversation;
        private final String conversationId;
        private final ConversationKitResult<List<Message>> result;

        public static /* synthetic */ LoadMoreMessages copy$default(LoadMoreMessages loadMoreMessages, String str, Conversation conversation2, double d, ConversationKitResult<List<Message>> conversationKitResult, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadMoreMessages.conversationId;
            }
            if ((i & 2) != 0) {
                conversation2 = loadMoreMessages.conversation;
            }
            Conversation conversation3 = conversation2;
            if ((i & 4) != 0) {
                d = loadMoreMessages.beforeTimestamp;
            }
            double d2 = d;
            if ((i & 8) != 0) {
                conversationKitResult = loadMoreMessages.result;
            }
            return loadMoreMessages.copy(str, conversation3, d2, conversationKitResult);
        }

        public final String component1() {
            return this.conversationId;
        }

        public final Conversation component2() {
            return this.conversation;
        }

        public final double component3() {
            return this.beforeTimestamp;
        }

        public final ConversationKitResult<List<Message>> component4() {
            return this.result;
        }

        public final LoadMoreMessages copy(String str, Conversation conversation2, double d, ConversationKitResult<? extends List<Message>> conversationKitResult) {
            Intrinsics.checkNotNullParameter(str, "conversationId");
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            return new LoadMoreMessages(str, conversation2, d, conversationKitResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadMoreMessages)) {
                return false;
            }
            LoadMoreMessages loadMoreMessages = (LoadMoreMessages) obj;
            return Intrinsics.areEqual((Object) this.conversationId, (Object) loadMoreMessages.conversationId) && Intrinsics.areEqual((Object) this.conversation, (Object) loadMoreMessages.conversation) && Intrinsics.areEqual((Object) Double.valueOf(this.beforeTimestamp), (Object) Double.valueOf(loadMoreMessages.beforeTimestamp)) && Intrinsics.areEqual((Object) this.result, (Object) loadMoreMessages.result);
        }

        public int hashCode() {
            int hashCode = this.conversationId.hashCode() * 31;
            Conversation conversation2 = this.conversation;
            return ((((hashCode + (conversation2 == null ? 0 : conversation2.hashCode())) * 31) + Double.hashCode(this.beforeTimestamp)) * 31) + this.result.hashCode();
        }

        public String toString() {
            return "LoadMoreMessages(conversationId=" + this.conversationId + ", conversation=" + this.conversation + ", beforeTimestamp=" + this.beforeTimestamp + ", result=" + this.result + ')';
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final Conversation getConversation() {
            return this.conversation;
        }

        public final double getBeforeTimestamp() {
            return this.beforeTimestamp;
        }

        public final ConversationKitResult<List<Message>> getResult() {
            return this.result;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadMoreMessages(String str, Conversation conversation2, double d, ConversationKitResult<? extends List<Message>> conversationKitResult) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "conversationId");
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            this.conversationId = str;
            this.conversation = conversation2;
            this.beforeTimestamp = d;
            this.result = conversationKitResult;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$MessagePrepared;", "Lzendesk/conversationkit/android/internal/Effect;", "message", "Lzendesk/conversationkit/android/model/Message;", "conversationId", "", "conversation", "Lzendesk/conversationkit/android/model/Conversation;", "(Lzendesk/conversationkit/android/model/Message;Ljava/lang/String;Lzendesk/conversationkit/android/model/Conversation;)V", "getConversation", "()Lzendesk/conversationkit/android/model/Conversation;", "getConversationId", "()Ljava/lang/String;", "getMessage", "()Lzendesk/conversationkit/android/model/Message;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class MessagePrepared extends Effect {
        private final Conversation conversation;
        private final String conversationId;
        private final Message message;

        public static /* synthetic */ MessagePrepared copy$default(MessagePrepared messagePrepared, Message message2, String str, Conversation conversation2, int i, Object obj) {
            if ((i & 1) != 0) {
                message2 = messagePrepared.message;
            }
            if ((i & 2) != 0) {
                str = messagePrepared.conversationId;
            }
            if ((i & 4) != 0) {
                conversation2 = messagePrepared.conversation;
            }
            return messagePrepared.copy(message2, str, conversation2);
        }

        public final Message component1() {
            return this.message;
        }

        public final String component2() {
            return this.conversationId;
        }

        public final Conversation component3() {
            return this.conversation;
        }

        public final MessagePrepared copy(Message message2, String str, Conversation conversation2) {
            Intrinsics.checkNotNullParameter(message2, "message");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new MessagePrepared(message2, str, conversation2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MessagePrepared)) {
                return false;
            }
            MessagePrepared messagePrepared = (MessagePrepared) obj;
            return Intrinsics.areEqual((Object) this.message, (Object) messagePrepared.message) && Intrinsics.areEqual((Object) this.conversationId, (Object) messagePrepared.conversationId) && Intrinsics.areEqual((Object) this.conversation, (Object) messagePrepared.conversation);
        }

        public int hashCode() {
            int hashCode = ((this.message.hashCode() * 31) + this.conversationId.hashCode()) * 31;
            Conversation conversation2 = this.conversation;
            return hashCode + (conversation2 == null ? 0 : conversation2.hashCode());
        }

        public String toString() {
            return "MessagePrepared(message=" + this.message + ", conversationId=" + this.conversationId + ", conversation=" + this.conversation + ')';
        }

        public final Message getMessage() {
            return this.message;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final Conversation getConversation() {
            return this.conversation;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MessagePrepared(Message message2, String str, Conversation conversation2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(message2, "message");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.message = message2;
            this.conversationId = str;
            this.conversation = conversation2;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$SendMessageResult;", "Lzendesk/conversationkit/android/internal/Effect;", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "Lzendesk/conversationkit/android/model/Message;", "conversationId", "", "message", "conversation", "Lzendesk/conversationkit/android/model/Conversation;", "(Lzendesk/conversationkit/android/ConversationKitResult;Ljava/lang/String;Lzendesk/conversationkit/android/model/Message;Lzendesk/conversationkit/android/model/Conversation;)V", "getConversation", "()Lzendesk/conversationkit/android/model/Conversation;", "getConversationId", "()Ljava/lang/String;", "getMessage", "()Lzendesk/conversationkit/android/model/Message;", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class SendMessageResult extends Effect {
        private final Conversation conversation;
        private final String conversationId;
        private final Message message;
        private final ConversationKitResult<Message> result;

        public static /* synthetic */ SendMessageResult copy$default(SendMessageResult sendMessageResult, ConversationKitResult<Message> conversationKitResult, String str, Message message2, Conversation conversation2, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitResult = sendMessageResult.result;
            }
            if ((i & 2) != 0) {
                str = sendMessageResult.conversationId;
            }
            if ((i & 4) != 0) {
                message2 = sendMessageResult.message;
            }
            if ((i & 8) != 0) {
                conversation2 = sendMessageResult.conversation;
            }
            return sendMessageResult.copy(conversationKitResult, str, message2, conversation2);
        }

        public final ConversationKitResult<Message> component1() {
            return this.result;
        }

        public final String component2() {
            return this.conversationId;
        }

        public final Message component3() {
            return this.message;
        }

        public final Conversation component4() {
            return this.conversation;
        }

        public final SendMessageResult copy(ConversationKitResult<Message> conversationKitResult, String str, Message message2, Conversation conversation2) {
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            return new SendMessageResult(conversationKitResult, str, message2, conversation2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SendMessageResult)) {
                return false;
            }
            SendMessageResult sendMessageResult = (SendMessageResult) obj;
            return Intrinsics.areEqual((Object) this.result, (Object) sendMessageResult.result) && Intrinsics.areEqual((Object) this.conversationId, (Object) sendMessageResult.conversationId) && Intrinsics.areEqual((Object) this.message, (Object) sendMessageResult.message) && Intrinsics.areEqual((Object) this.conversation, (Object) sendMessageResult.conversation);
        }

        public int hashCode() {
            int hashCode = ((this.result.hashCode() * 31) + this.conversationId.hashCode()) * 31;
            Message message2 = this.message;
            int i = 0;
            int hashCode2 = (hashCode + (message2 == null ? 0 : message2.hashCode())) * 31;
            Conversation conversation2 = this.conversation;
            if (conversation2 != null) {
                i = conversation2.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "SendMessageResult(result=" + this.result + ", conversationId=" + this.conversationId + ", message=" + this.message + ", conversation=" + this.conversation + ')';
        }

        public final ConversationKitResult<Message> getResult() {
            return this.result;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final Conversation getConversation() {
            return this.conversation;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SendMessageResult(ConversationKitResult<Message> conversationKitResult, String str, Message message2, Conversation conversation2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.result = conversationKitResult;
            this.conversationId = str;
            this.message = message2;
            this.conversation = conversation2;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$PushTokenPrepared;", "Lzendesk/conversationkit/android/internal/Effect;", "pushToken", "", "(Ljava/lang/String;)V", "getPushToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class PushTokenPrepared extends Effect {
        private final String pushToken;

        public static /* synthetic */ PushTokenPrepared copy$default(PushTokenPrepared pushTokenPrepared, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pushTokenPrepared.pushToken;
            }
            return pushTokenPrepared.copy(str);
        }

        public final String component1() {
            return this.pushToken;
        }

        public final PushTokenPrepared copy(String str) {
            Intrinsics.checkNotNullParameter(str, "pushToken");
            return new PushTokenPrepared(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PushTokenPrepared) && Intrinsics.areEqual((Object) this.pushToken, (Object) ((PushTokenPrepared) obj).pushToken);
        }

        public int hashCode() {
            return this.pushToken.hashCode();
        }

        public String toString() {
            return "PushTokenPrepared(pushToken=" + this.pushToken + ')';
        }

        public final String getPushToken() {
            return this.pushToken;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PushTokenPrepared(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "pushToken");
            this.pushToken = str;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$PushTokenUpdateResult;", "Lzendesk/conversationkit/android/internal/Effect;", "result", "Lzendesk/conversationkit/android/ConversationKitResult;", "", "pushToken", "", "(Lzendesk/conversationkit/android/ConversationKitResult;Ljava/lang/String;)V", "getPushToken", "()Ljava/lang/String;", "getResult", "()Lzendesk/conversationkit/android/ConversationKitResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class PushTokenUpdateResult extends Effect {
        private final String pushToken;
        private final ConversationKitResult<Unit> result;

        public static /* synthetic */ PushTokenUpdateResult copy$default(PushTokenUpdateResult pushTokenUpdateResult, ConversationKitResult<Unit> conversationKitResult, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationKitResult = pushTokenUpdateResult.result;
            }
            if ((i & 2) != 0) {
                str = pushTokenUpdateResult.pushToken;
            }
            return pushTokenUpdateResult.copy(conversationKitResult, str);
        }

        public final ConversationKitResult<Unit> component1() {
            return this.result;
        }

        public final String component2() {
            return this.pushToken;
        }

        public final PushTokenUpdateResult copy(ConversationKitResult<Unit> conversationKitResult, String str) {
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            Intrinsics.checkNotNullParameter(str, "pushToken");
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
            return Intrinsics.areEqual((Object) this.result, (Object) pushTokenUpdateResult.result) && Intrinsics.areEqual((Object) this.pushToken, (Object) pushTokenUpdateResult.pushToken);
        }

        public int hashCode() {
            return (this.result.hashCode() * 31) + this.pushToken.hashCode();
        }

        public String toString() {
            return "PushTokenUpdateResult(result=" + this.result + ", pushToken=" + this.pushToken + ')';
        }

        public final ConversationKitResult<Unit> getResult() {
            return this.result;
        }

        public final String getPushToken() {
            return this.pushToken;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PushTokenUpdateResult(ConversationKitResult<Unit> conversationKitResult, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversationKitResult, "result");
            Intrinsics.checkNotNullParameter(str, "pushToken");
            this.result = conversationKitResult;
            this.pushToken = str;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$ActivityEventReceived;", "Lzendesk/conversationkit/android/internal/Effect;", "activityEvent", "Lzendesk/conversationkit/android/model/ActivityEvent;", "conversation", "Lzendesk/conversationkit/android/model/Conversation;", "(Lzendesk/conversationkit/android/model/ActivityEvent;Lzendesk/conversationkit/android/model/Conversation;)V", "getActivityEvent", "()Lzendesk/conversationkit/android/model/ActivityEvent;", "getConversation", "()Lzendesk/conversationkit/android/model/Conversation;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class ActivityEventReceived extends Effect {
        private final ActivityEvent activityEvent;
        private final Conversation conversation;

        public static /* synthetic */ ActivityEventReceived copy$default(ActivityEventReceived activityEventReceived, ActivityEvent activityEvent2, Conversation conversation2, int i, Object obj) {
            if ((i & 1) != 0) {
                activityEvent2 = activityEventReceived.activityEvent;
            }
            if ((i & 2) != 0) {
                conversation2 = activityEventReceived.conversation;
            }
            return activityEventReceived.copy(activityEvent2, conversation2);
        }

        public final ActivityEvent component1() {
            return this.activityEvent;
        }

        public final Conversation component2() {
            return this.conversation;
        }

        public final ActivityEventReceived copy(ActivityEvent activityEvent2, Conversation conversation2) {
            Intrinsics.checkNotNullParameter(activityEvent2, "activityEvent");
            return new ActivityEventReceived(activityEvent2, conversation2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActivityEventReceived)) {
                return false;
            }
            ActivityEventReceived activityEventReceived = (ActivityEventReceived) obj;
            return Intrinsics.areEqual((Object) this.activityEvent, (Object) activityEventReceived.activityEvent) && Intrinsics.areEqual((Object) this.conversation, (Object) activityEventReceived.conversation);
        }

        public int hashCode() {
            int hashCode = this.activityEvent.hashCode() * 31;
            Conversation conversation2 = this.conversation;
            return hashCode + (conversation2 == null ? 0 : conversation2.hashCode());
        }

        public String toString() {
            return "ActivityEventReceived(activityEvent=" + this.activityEvent + ", conversation=" + this.conversation + ')';
        }

        public final ActivityEvent getActivityEvent() {
            return this.activityEvent;
        }

        public final Conversation getConversation() {
            return this.conversation;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ActivityEventReceived(ActivityEvent activityEvent2, Conversation conversation2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(activityEvent2, "activityEvent");
            this.activityEvent = activityEvent2;
            this.conversation = conversation2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$PersistedUserReceived;", "Lzendesk/conversationkit/android/internal/Effect;", "user", "Lzendesk/conversationkit/android/model/User;", "(Lzendesk/conversationkit/android/model/User;)V", "getUser", "()Lzendesk/conversationkit/android/model/User;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class PersistedUserReceived extends Effect {
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

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PersistedUserReceived(User user2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(user2, "user");
            this.user = user2;
        }

        public final User getUser() {
            return this.user;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$GetVisitType;", "Lzendesk/conversationkit/android/internal/Effect;", "visitType", "Lzendesk/conversationkit/android/model/VisitType;", "(Lzendesk/conversationkit/android/model/VisitType;)V", "getVisitType", "()Lzendesk/conversationkit/android/model/VisitType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class GetVisitType extends Effect {
        private final VisitType visitType;

        public static /* synthetic */ GetVisitType copy$default(GetVisitType getVisitType, VisitType visitType2, int i, Object obj) {
            if ((i & 1) != 0) {
                visitType2 = getVisitType.visitType;
            }
            return getVisitType.copy(visitType2);
        }

        public final VisitType component1() {
            return this.visitType;
        }

        public final GetVisitType copy(VisitType visitType2) {
            Intrinsics.checkNotNullParameter(visitType2, "visitType");
            return new GetVisitType(visitType2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetVisitType) && this.visitType == ((GetVisitType) obj).visitType;
        }

        public int hashCode() {
            return this.visitType.hashCode();
        }

        public String toString() {
            return "GetVisitType(visitType=" + this.visitType + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GetVisitType(VisitType visitType2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(visitType2, "visitType");
            this.visitType = visitType2;
        }

        public final VisitType getVisitType() {
            return this.visitType;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/Effect$GetProactiveMessage;", "Lzendesk/conversationkit/android/internal/Effect;", "proactiveMessage", "Lzendesk/conversationkit/android/model/ProactiveMessage;", "(Lzendesk/conversationkit/android/model/ProactiveMessage;)V", "getProactiveMessage", "()Lzendesk/conversationkit/android/model/ProactiveMessage;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Effect.kt */
    public static final class GetProactiveMessage extends Effect {
        private final ProactiveMessage proactiveMessage;

        public static /* synthetic */ GetProactiveMessage copy$default(GetProactiveMessage getProactiveMessage, ProactiveMessage proactiveMessage2, int i, Object obj) {
            if ((i & 1) != 0) {
                proactiveMessage2 = getProactiveMessage.proactiveMessage;
            }
            return getProactiveMessage.copy(proactiveMessage2);
        }

        public final ProactiveMessage component1() {
            return this.proactiveMessage;
        }

        public final GetProactiveMessage copy(ProactiveMessage proactiveMessage2) {
            return new GetProactiveMessage(proactiveMessage2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetProactiveMessage) && Intrinsics.areEqual((Object) this.proactiveMessage, (Object) ((GetProactiveMessage) obj).proactiveMessage);
        }

        public int hashCode() {
            ProactiveMessage proactiveMessage2 = this.proactiveMessage;
            if (proactiveMessage2 == null) {
                return 0;
            }
            return proactiveMessage2.hashCode();
        }

        public String toString() {
            return "GetProactiveMessage(proactiveMessage=" + this.proactiveMessage + ')';
        }

        public GetProactiveMessage(ProactiveMessage proactiveMessage2) {
            super((DefaultConstructorMarker) null);
            this.proactiveMessage = proactiveMessage2;
        }

        public final ProactiveMessage getProactiveMessage() {
            return this.proactiveMessage;
        }
    }
}
