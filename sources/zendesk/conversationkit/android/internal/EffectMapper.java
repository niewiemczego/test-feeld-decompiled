package zendesk.conversationkit.android.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.ConversationKitEvent;
import zendesk.conversationkit.android.internal.Effect;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u000bH\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u000fH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0011H\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0013H\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0017H\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u001bH\u0002J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u001dH\u0002J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u001fH\u0002J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020!H\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020#H\u0002J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020%H\u0002¨\u0006'"}, d2 = {"Lzendesk/conversationkit/android/internal/EffectMapper;", "", "()V", "map", "", "Lzendesk/conversationkit/android/ConversationKitEvent;", "effect", "Lzendesk/conversationkit/android/internal/Effect;", "mapActivityEvent", "Lzendesk/conversationkit/android/internal/Effect$ActivityEventReceived;", "mapConnectionChanged", "Lzendesk/conversationkit/android/internal/Effect$ConnectionChanged;", "mapCreateConversationResult", "Lzendesk/conversationkit/android/internal/Effect$CreateConversationResult;", "mapGetConversationResult", "Lzendesk/conversationkit/android/internal/Effect$GetConversationResult;", "mapLoadMoreMessages", "Lzendesk/conversationkit/android/internal/Effect$LoadMoreMessages;", "mapLogoutUserResult", "Lzendesk/conversationkit/android/internal/Effect$LogoutUserResult;", "mapMessagePrepared", "Lzendesk/conversationkit/android/internal/Effect$MessagePrepared;", "mapMessageReceived", "Lzendesk/conversationkit/android/internal/Effect$MessageReceived;", "mapPersistedUserReceived", "Lzendesk/conversationkit/android/internal/Effect$PersistedUserReceived;", "mapPushRegistrationPending", "Lzendesk/conversationkit/android/internal/Effect$PushTokenPrepared;", "mapPushRegistrationResult", "Lzendesk/conversationkit/android/internal/Effect$PushTokenUpdateResult;", "mapRefreshConversationResult", "Lzendesk/conversationkit/android/internal/Effect$RefreshConversationResult;", "mapRefreshUserResult", "Lzendesk/conversationkit/android/internal/Effect$RefreshUserResult;", "mapSendMessageResult", "Lzendesk/conversationkit/android/internal/Effect$SendMessageResult;", "mapUserAccessRevoked", "Lzendesk/conversationkit/android/internal/Effect$UserAccessRevoked;", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EffectMapper.kt */
public final class EffectMapper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "EffectMapper";

    public final List<ConversationKitEvent> map(Effect effect) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        if (effect instanceof Effect.ConnectionChanged) {
            return mapConnectionChanged((Effect.ConnectionChanged) effect);
        }
        if (effect instanceof Effect.RefreshUserResult) {
            return mapRefreshUserResult((Effect.RefreshUserResult) effect);
        }
        if (effect instanceof Effect.CreateConversationResult) {
            return mapCreateConversationResult((Effect.CreateConversationResult) effect);
        }
        if (effect instanceof Effect.GetConversationResult) {
            return mapGetConversationResult((Effect.GetConversationResult) effect);
        }
        if (effect instanceof Effect.RefreshConversationResult) {
            return mapRefreshConversationResult((Effect.RefreshConversationResult) effect);
        }
        if (effect instanceof Effect.MessageReceived) {
            return mapMessageReceived((Effect.MessageReceived) effect);
        }
        if (effect instanceof Effect.LoadMoreMessages) {
            return mapLoadMoreMessages((Effect.LoadMoreMessages) effect);
        }
        if (effect instanceof Effect.MessagePrepared) {
            return mapMessagePrepared((Effect.MessagePrepared) effect);
        }
        if (effect instanceof Effect.SendMessageResult) {
            return mapSendMessageResult((Effect.SendMessageResult) effect);
        }
        if (effect instanceof Effect.PushTokenPrepared) {
            return mapPushRegistrationPending((Effect.PushTokenPrepared) effect);
        }
        if (effect instanceof Effect.PushTokenUpdateResult) {
            return mapPushRegistrationResult((Effect.PushTokenUpdateResult) effect);
        }
        if (effect instanceof Effect.ActivityEventReceived) {
            return mapActivityEvent((Effect.ActivityEventReceived) effect);
        }
        if (effect instanceof Effect.PersistedUserReceived) {
            return mapPersistedUserReceived((Effect.PersistedUserReceived) effect);
        }
        if (effect instanceof Effect.UserAccessRevoked) {
            return mapUserAccessRevoked((Effect.UserAccessRevoked) effect);
        }
        if (effect instanceof Effect.LogoutUserResult) {
            return mapLogoutUserResult((Effect.LogoutUserResult) effect);
        }
        Logger.d(LOG_TAG, "Effect " + effect + " has no public counterpart, skipping.", new Object[0]);
        return CollectionsKt.emptyList();
    }

    private final List<ConversationKitEvent> mapLogoutUserResult(Effect.LogoutUserResult logoutUserResult) {
        return EffectMapperKt.mapEvents(new EffectMapper$mapLogoutUserResult$1(logoutUserResult));
    }

    private final List<ConversationKitEvent> mapUserAccessRevoked(Effect.UserAccessRevoked userAccessRevoked) {
        return EffectMapperKt.mapEvents(new EffectMapper$mapUserAccessRevoked$1(userAccessRevoked));
    }

    private final List<ConversationKitEvent> mapConnectionChanged(Effect.ConnectionChanged connectionChanged) {
        return EffectMapperKt.mapEvents(new EffectMapper$mapConnectionChanged$1(connectionChanged));
    }

    private final List<ConversationKitEvent> mapRefreshUserResult(Effect.RefreshUserResult refreshUserResult) {
        return EffectMapperKt.mapEvents(new EffectMapper$mapRefreshUserResult$1(refreshUserResult));
    }

    private final List<ConversationKitEvent> mapCreateConversationResult(Effect.CreateConversationResult createConversationResult) {
        return EffectMapperKt.mapEvents(new EffectMapper$mapCreateConversationResult$1(createConversationResult));
    }

    private final List<ConversationKitEvent> mapGetConversationResult(Effect.GetConversationResult getConversationResult) {
        return EffectMapperKt.mapEvents(new EffectMapper$mapGetConversationResult$1(getConversationResult));
    }

    private final List<ConversationKitEvent> mapRefreshConversationResult(Effect.RefreshConversationResult refreshConversationResult) {
        return EffectMapperKt.mapEvents(new EffectMapper$mapRefreshConversationResult$1(refreshConversationResult));
    }

    private final List<ConversationKitEvent> mapMessageReceived(Effect.MessageReceived messageReceived) {
        return EffectMapperKt.mapEvents(new EffectMapper$mapMessageReceived$1(messageReceived));
    }

    private final List<ConversationKitEvent> mapLoadMoreMessages(Effect.LoadMoreMessages loadMoreMessages) {
        return EffectMapperKt.mapEvents(new EffectMapper$mapLoadMoreMessages$1(loadMoreMessages));
    }

    private final List<ConversationKitEvent> mapMessagePrepared(Effect.MessagePrepared messagePrepared) {
        return EffectMapperKt.mapEvents(new EffectMapper$mapMessagePrepared$1(messagePrepared));
    }

    private final List<ConversationKitEvent> mapSendMessageResult(Effect.SendMessageResult sendMessageResult) {
        return EffectMapperKt.mapEvents(new EffectMapper$mapSendMessageResult$1(sendMessageResult));
    }

    private final List<ConversationKitEvent> mapPushRegistrationPending(Effect.PushTokenPrepared pushTokenPrepared) {
        return EffectMapperKt.mapEvents(new EffectMapper$mapPushRegistrationPending$1(pushTokenPrepared));
    }

    private final List<ConversationKitEvent> mapPushRegistrationResult(Effect.PushTokenUpdateResult pushTokenUpdateResult) {
        return EffectMapperKt.mapEvents(new EffectMapper$mapPushRegistrationResult$1(pushTokenUpdateResult));
    }

    private final List<ConversationKitEvent> mapActivityEvent(Effect.ActivityEventReceived activityEventReceived) {
        return EffectMapperKt.mapEvents(new EffectMapper$mapActivityEvent$1(activityEventReceived));
    }

    private final List<ConversationKitEvent> mapPersistedUserReceived(Effect.PersistedUserReceived persistedUserReceived) {
        return EffectMapperKt.mapEvents(new EffectMapper$mapPersistedUserReceived$1(persistedUserReceived));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/conversationkit/android/internal/EffectMapper$Companion;", "", "()V", "LOG_TAG", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EffectMapper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
