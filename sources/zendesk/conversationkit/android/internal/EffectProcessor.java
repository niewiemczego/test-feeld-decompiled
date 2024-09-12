package zendesk.conversationkit.android.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.ConnectionStatus;
import zendesk.conversationkit.android.ConversationKitError;
import zendesk.conversationkit.android.ConversationKitEvent;
import zendesk.conversationkit.android.ConversationKitResult;
import zendesk.conversationkit.android.internal.Action;
import zendesk.conversationkit.android.internal.Effect;
import zendesk.conversationkit.android.internal.EffectProcessorResult;
import zendesk.conversationkit.android.model.Config;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.conversationkit.android.model.User;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0015H\u0002J\u001e\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001cH\u0002J\u001e\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u001e\u0010\u001f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020 2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u001e\u0010!\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\"2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u001e\u0010#\u001a\u00020\b2\u0006\u0010\t\u001a\u00020$2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0016\u0010%\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u001e\u0010&\u001a\u00020\b2\u0006\u0010\t\u001a\u00020'2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u001e\u0010(\u001a\u00020\b2\u0006\u0010\t\u001a\u00020)2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u001e\u0010*\u001a\u00020\b2\u0006\u0010\t\u001a\u00020+2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0010\u0010,\u001a\u00020\b2\u0006\u0010\t\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\b2\u0006\u0010\t\u001a\u00020/H\u0002J\u001e\u00100\u001a\u00020\b2\u0006\u0010\t\u001a\u0002012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lzendesk/conversationkit/android/internal/EffectProcessor;", "", "effectMapper", "Lzendesk/conversationkit/android/internal/EffectMapper;", "accessLevelBuilder", "Lzendesk/conversationkit/android/internal/AccessLevelBuilder;", "(Lzendesk/conversationkit/android/internal/EffectMapper;Lzendesk/conversationkit/android/internal/AccessLevelBuilder;)V", "process", "Lzendesk/conversationkit/android/internal/EffectProcessorResult;", "effect", "Lzendesk/conversationkit/android/internal/Effect;", "processAlreadyLoggedInResult", "Lzendesk/conversationkit/android/internal/EffectProcessorResult$Ends;", "Lzendesk/conversationkit/android/internal/Effect$AlreadyLoggedInResult;", "processCheckForPersistedUserResult", "Lzendesk/conversationkit/android/internal/Effect$CheckForPersistedUserResult;", "processConfigResultReceived", "Lzendesk/conversationkit/android/internal/Effect$ConfigResultReceived;", "processCreateConversationResult", "Lzendesk/conversationkit/android/internal/Effect$CreateConversationResult;", "processCreateUserResult", "Lzendesk/conversationkit/android/internal/Effect$CreateUserResult;", "processGetConversationResult", "Lzendesk/conversationkit/android/internal/Effect$GetConversationResult;", "mappedEvents", "", "Lzendesk/conversationkit/android/ConversationKitEvent;", "processLoginUserResult", "Lzendesk/conversationkit/android/internal/Effect$LoginUserResult;", "processLogoutUserResult", "Lzendesk/conversationkit/android/internal/Effect$LogoutUserResult;", "processMessagePrepared", "Lzendesk/conversationkit/android/internal/Effect$MessagePrepared;", "processNetworkConnectionChanged", "Lzendesk/conversationkit/android/internal/Effect$NetworkConnectionChanged;", "processPushRegistrationPending", "Lzendesk/conversationkit/android/internal/Effect$PushTokenPrepared;", "processPushRegistrationResult", "processRealtimeConnectionChanged", "Lzendesk/conversationkit/android/internal/Effect$RealtimeConnectionChanged;", "processRefreshUserResult", "Lzendesk/conversationkit/android/internal/Effect$RefreshUserResult;", "processSendMessageResult", "Lzendesk/conversationkit/android/internal/Effect$SendMessageResult;", "processSettingsAndConfigReceived", "Lzendesk/conversationkit/android/internal/Effect$SettingsAndConfigReceived;", "processSettingsReceived", "Lzendesk/conversationkit/android/internal/Effect$SettingsReceived;", "processUserAccessRevoked", "Lzendesk/conversationkit/android/internal/Effect$UserAccessRevoked;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EffectProcessor.kt */
public final class EffectProcessor {
    private final AccessLevelBuilder accessLevelBuilder;
    private final EffectMapper effectMapper;

    public EffectProcessor(EffectMapper effectMapper2, AccessLevelBuilder accessLevelBuilder2) {
        Intrinsics.checkNotNullParameter(effectMapper2, "effectMapper");
        Intrinsics.checkNotNullParameter(accessLevelBuilder2, "accessLevelBuilder");
        this.effectMapper = effectMapper2;
        this.accessLevelBuilder = accessLevelBuilder2;
    }

    public final EffectProcessorResult process(Effect effect) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        List<ConversationKitEvent> map = this.effectMapper.map(effect);
        if (Intrinsics.areEqual((Object) effect, (Object) Effect.IncorrectAccessLevel.INSTANCE)) {
            return new EffectProcessorResult.Ends((AccessLevel) null, (List) null, (List) null, new ConversationKitResult.Failure(ConversationKitError.IncorrectAccessLevelForAction.INSTANCE), 7, (DefaultConstructorMarker) null);
        }
        if (effect instanceof Effect.UserAccessRevoked) {
            return processUserAccessRevoked((Effect.UserAccessRevoked) effect, map);
        }
        if (effect instanceof Effect.SettingsReceived) {
            return processSettingsReceived((Effect.SettingsReceived) effect);
        }
        if (effect instanceof Effect.SettingsAndConfigReceived) {
            return processSettingsAndConfigReceived((Effect.SettingsAndConfigReceived) effect);
        }
        if (effect instanceof Effect.ConfigResultReceived) {
            return processConfigResultReceived((Effect.ConfigResultReceived) effect);
        }
        if (effect instanceof Effect.CreateUserResult) {
            return processCreateUserResult((Effect.CreateUserResult) effect);
        }
        if (effect instanceof Effect.LoginUserResult) {
            return processLoginUserResult((Effect.LoginUserResult) effect);
        }
        if (effect instanceof Effect.AlreadyLoggedInResult) {
            return processAlreadyLoggedInResult((Effect.AlreadyLoggedInResult) effect);
        }
        if (effect instanceof Effect.LogoutUserResult) {
            return processLogoutUserResult((Effect.LogoutUserResult) effect, map);
        }
        if (effect instanceof Effect.MessageReceived) {
            return new EffectProcessorResult.Ends((AccessLevel) null, map, (List) null, (ConversationKitResult) null, 13, (DefaultConstructorMarker) null);
        }
        if (effect instanceof Effect.CheckForPersistedUserResult) {
            return processCheckForPersistedUserResult((Effect.CheckForPersistedUserResult) effect);
        }
        if (effect instanceof Effect.RefreshUserResult) {
            return processRefreshUserResult((Effect.RefreshUserResult) effect, map);
        }
        if (effect instanceof Effect.CreateConversationResult) {
            return processCreateConversationResult((Effect.CreateConversationResult) effect);
        }
        if (effect instanceof Effect.GetConversationResult) {
            return processGetConversationResult((Effect.GetConversationResult) effect, map);
        }
        if (effect instanceof Effect.RefreshConversationResult) {
            return new EffectProcessorResult.Ends((AccessLevel) null, map, (List) null, ((Effect.RefreshConversationResult) effect).getResult(), 5, (DefaultConstructorMarker) null);
        }
        if (effect instanceof Effect.NetworkConnectionChanged) {
            return processNetworkConnectionChanged((Effect.NetworkConnectionChanged) effect, map);
        }
        if (effect instanceof Effect.RealtimeConnectionChanged) {
            return processRealtimeConnectionChanged((Effect.RealtimeConnectionChanged) effect, map);
        }
        if (effect instanceof Effect.MessagePrepared) {
            return processMessagePrepared((Effect.MessagePrepared) effect, map);
        }
        if (effect instanceof Effect.SendMessageResult) {
            return processSendMessageResult((Effect.SendMessageResult) effect, map);
        }
        if (effect instanceof Effect.PushTokenPrepared) {
            return processPushRegistrationPending((Effect.PushTokenPrepared) effect, map);
        }
        if (effect instanceof Effect.PushTokenUpdateResult) {
            return processPushRegistrationResult(map);
        }
        if (effect instanceof Effect.ActivityEventReceived) {
            return new EffectProcessorResult.Ends((AccessLevel) null, map, (List) null, new ConversationKitResult.Success(((Effect.ActivityEventReceived) effect).getActivityEvent()), 5, (DefaultConstructorMarker) null);
        }
        if (effect instanceof Effect.LoadMoreMessages) {
            return new EffectProcessorResult.Ends((AccessLevel) null, map, (List) null, ((Effect.LoadMoreMessages) effect).getResult(), 5, (DefaultConstructorMarker) null);
        }
        if (effect instanceof Effect.GetVisitType) {
            return new EffectProcessorResult.Ends((AccessLevel) null, map, (List) null, new ConversationKitResult.Success(((Effect.GetVisitType) effect).getVisitType()), 5, (DefaultConstructorMarker) null);
        }
        if (effect instanceof Effect.GetProactiveMessage) {
            return new EffectProcessorResult.Ends((AccessLevel) null, map, (List) null, new ConversationKitResult.Success(((Effect.GetProactiveMessage) effect).getProactiveMessage()), 5, (DefaultConstructorMarker) null);
        }
        return new EffectProcessorResult.Ends((AccessLevel) null, map, (List) null, (ConversationKitResult) null, 13, (DefaultConstructorMarker) null);
    }

    private final EffectProcessorResult processUserAccessRevoked(Effect.UserAccessRevoked userAccessRevoked, List<? extends ConversationKitEvent> list) {
        return new EffectProcessorResult.Ends(this.accessLevelBuilder.buildAppAccess(userAccessRevoked.getConversationKitSettings(), userAccessRevoked.getConfig()), list, (List) null, userAccessRevoked.getResult(), 4, (DefaultConstructorMarker) null);
    }

    private final EffectProcessorResult processSettingsReceived(Effect.SettingsReceived settingsReceived) {
        return new EffectProcessorResult.Continues(this.accessLevelBuilder.buildIntegrationAccess(settingsReceived.getConversationKitSettings()), (List) null, (List) null, Action.GetConfig.INSTANCE, 6, (DefaultConstructorMarker) null);
    }

    private final EffectProcessorResult processSettingsAndConfigReceived(Effect.SettingsAndConfigReceived settingsAndConfigReceived) {
        return new EffectProcessorResult.Continues(this.accessLevelBuilder.buildIntegrationAccess(settingsAndConfigReceived.getConversationKitSettings()), (List) null, (List) null, new Action.ForwardConfig(settingsAndConfigReceived.getConfig()), 6, (DefaultConstructorMarker) null);
    }

    private final EffectProcessorResult processConfigResultReceived(Effect.ConfigResultReceived configResultReceived) {
        ConversationKitResult<Config> result = configResultReceived.getResult();
        if (result instanceof ConversationKitResult.Success) {
            return new EffectProcessorResult.Continues(this.accessLevelBuilder.buildAppAccess(configResultReceived.getConversationKitSettings(), (Config) ((ConversationKitResult.Success) configResultReceived.getResult()).getValue()), (List) null, (List) null, Action.CheckForPersistedUser.INSTANCE, 6, (DefaultConstructorMarker) null);
        }
        if (result instanceof ConversationKitResult.Failure) {
            return new EffectProcessorResult.Ends(this.accessLevelBuilder.buildNoAccess(), (List) null, (List) null, configResultReceived.getResult(), 6, (DefaultConstructorMarker) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EffectProcessorResult processCreateUserResult(Effect.CreateUserResult createUserResult) {
        AccessLevel accessLevel;
        List arrayList = new ArrayList();
        if (createUserResult.getResult() instanceof ConversationKitResult.Success) {
            User user = (User) ((ConversationKitResult.Success) createUserResult.getResult()).getValue();
            AccessLevel buildUserAccess = this.accessLevelBuilder.buildUserAccess(createUserResult.getConversationKitSettings(), createUserResult.getConfig(), user, createUserResult.getClientId());
            if (!user.getConversations().isEmpty()) {
                arrayList.add(Action.StartRealtimeConnection.INSTANCE);
            }
            String pendingPushToken = createUserResult.getPendingPushToken();
            if (pendingPushToken != null) {
                arrayList.add(new Action.UpdatePushToken(pendingPushToken));
            }
            accessLevel = buildUserAccess;
        } else {
            accessLevel = null;
        }
        return new EffectProcessorResult.Ends(accessLevel, (List) null, arrayList, createUserResult.getResult(), 2, (DefaultConstructorMarker) null);
    }

    private final EffectProcessorResult processLoginUserResult(Effect.LoginUserResult loginUserResult) {
        ConversationKitResult<User> result = loginUserResult.getResult();
        if (result instanceof ConversationKitResult.Failure) {
            return new EffectProcessorResult.Ends((AccessLevel) null, (List) null, (List) null, result, 7, (DefaultConstructorMarker) null);
        }
        if (result instanceof ConversationKitResult.Success) {
            ConversationKitResult.Success success = (ConversationKitResult.Success) result;
            AccessLevel buildUserAccess = this.accessLevelBuilder.buildUserAccess(loginUserResult.getConversationKitSettings(), loginUserResult.getConfig(), (User) success.getValue(), loginUserResult.getClientId());
            List arrayList = new ArrayList();
            if (!((User) success.getValue()).getConversations().isEmpty()) {
                arrayList.add(Action.StartRealtimeConnection.INSTANCE);
            }
            return new EffectProcessorResult.Ends(buildUserAccess, (List) null, arrayList, result, 2, (DefaultConstructorMarker) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EffectProcessorResult.Ends processAlreadyLoggedInResult(Effect.AlreadyLoggedInResult alreadyLoggedInResult) {
        ConversationKitResult<User> result = alreadyLoggedInResult.getResult();
        if (result instanceof ConversationKitResult.Failure) {
            return new EffectProcessorResult.Ends((AccessLevel) null, (List) null, (List) null, result, 7, (DefaultConstructorMarker) null);
        }
        if (result instanceof ConversationKitResult.Success) {
            return new EffectProcessorResult.Ends((AccessLevel) null, (List) null, (List) null, result, 7, (DefaultConstructorMarker) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EffectProcessorResult processLogoutUserResult(Effect.LogoutUserResult logoutUserResult, List<? extends ConversationKitEvent> list) {
        ConversationKitResult<Object> result = logoutUserResult.getResult();
        if (result instanceof ConversationKitResult.Failure) {
            return new EffectProcessorResult.Ends((AccessLevel) null, (List) null, (List) null, result, 7, (DefaultConstructorMarker) null);
        }
        if (result instanceof ConversationKitResult.Success) {
            return new EffectProcessorResult.Ends(this.accessLevelBuilder.buildAppAccess(logoutUserResult.getConversationKitSettings(), logoutUserResult.getConfig()), list, (List) null, logoutUserResult.getResult(), 4, (DefaultConstructorMarker) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EffectProcessorResult processCheckForPersistedUserResult(Effect.CheckForPersistedUserResult checkForPersistedUserResult) {
        AccessLevel accessLevel;
        List arrayList = new ArrayList();
        if (checkForPersistedUserResult.getUser() != null) {
            accessLevel = this.accessLevelBuilder.buildUserAccess(checkForPersistedUserResult.getConversationKitSettings(), checkForPersistedUserResult.getResult().getValue(), checkForPersistedUserResult.getUser(), checkForPersistedUserResult.getClientId());
            arrayList.add(new Action.PersistedUserRetrieve(checkForPersistedUserResult.getUser()));
            if (!checkForPersistedUserResult.getUser().getConversations().isEmpty()) {
                arrayList.add(Action.StartRealtimeConnection.INSTANCE);
            }
        } else {
            accessLevel = null;
        }
        return new EffectProcessorResult.Ends(accessLevel, (List) null, arrayList, checkForPersistedUserResult.getResult(), 2, (DefaultConstructorMarker) null);
    }

    private final EffectProcessorResult processCreateConversationResult(Effect.CreateConversationResult createConversationResult) {
        List list;
        if (createConversationResult.getResult() instanceof ConversationKitResult.Success) {
            list = CollectionsKt.listOf(Action.StartRealtimeConnection.INSTANCE);
        } else {
            list = CollectionsKt.emptyList();
        }
        return new EffectProcessorResult.Ends((AccessLevel) null, (List) null, list, createConversationResult.getResult(), 3, (DefaultConstructorMarker) null);
    }

    private final EffectProcessorResult processGetConversationResult(Effect.GetConversationResult getConversationResult, List<? extends ConversationKitEvent> list) {
        List list2;
        if (!(getConversationResult.getResult() instanceof ConversationKitResult.Success) || !getConversationResult.getShouldRefresh()) {
            list2 = CollectionsKt.emptyList();
        } else {
            list2 = CollectionsKt.listOf(new Action.RefreshConversation(((Conversation) ((ConversationKitResult.Success) getConversationResult.getResult()).getValue()).getId()));
        }
        return new EffectProcessorResult.Ends((AccessLevel) null, list, list2, getConversationResult.getResult(), 1, (DefaultConstructorMarker) null);
    }

    private final EffectProcessorResult processNetworkConnectionChanged(Effect.NetworkConnectionChanged networkConnectionChanged, List<? extends ConversationKitEvent> list) {
        if (networkConnectionChanged.getConnectionStatus() != ConnectionStatus.CONNECTED) {
            return new EffectProcessorResult.Ends((AccessLevel) null, list, (List) null, (ConversationKitResult) null, 13, (DefaultConstructorMarker) null);
        }
        return new EffectProcessorResult.Continues((AccessLevel) null, list, (List) null, Action.StartRealtimeConnection.INSTANCE, 5, (DefaultConstructorMarker) null);
    }

    private final EffectProcessorResult processRealtimeConnectionChanged(Effect.RealtimeConnectionChanged realtimeConnectionChanged, List<? extends ConversationKitEvent> list) {
        if (realtimeConnectionChanged.getConnectionStatus() != ConnectionStatus.CONNECTED_REALTIME) {
            return new EffectProcessorResult.Ends((AccessLevel) null, list, (List) null, (ConversationKitResult) null, 13, (DefaultConstructorMarker) null);
        }
        return new EffectProcessorResult.Continues((AccessLevel) null, list, (List) null, Action.RefreshUser.INSTANCE, 5, (DefaultConstructorMarker) null);
    }

    private final EffectProcessorResult processMessagePrepared(Effect.MessagePrepared messagePrepared, List<? extends ConversationKitEvent> list) {
        return new EffectProcessorResult.Continues((AccessLevel) null, list, (List) null, new Action.SendMessage(messagePrepared.getMessage(), messagePrepared.getConversationId()), 5, (DefaultConstructorMarker) null);
    }

    private final EffectProcessorResult processSendMessageResult(Effect.SendMessageResult sendMessageResult, List<? extends ConversationKitEvent> list) {
        return new EffectProcessorResult.Ends((AccessLevel) null, list, (List) null, sendMessageResult.getResult(), 5, (DefaultConstructorMarker) null);
    }

    private final EffectProcessorResult processPushRegistrationPending(Effect.PushTokenPrepared pushTokenPrepared, List<? extends ConversationKitEvent> list) {
        return new EffectProcessorResult.Continues((AccessLevel) null, list, (List) null, new Action.UpdatePushToken(pushTokenPrepared.getPushToken()), 5, (DefaultConstructorMarker) null);
    }

    private final EffectProcessorResult processPushRegistrationResult(List<? extends ConversationKitEvent> list) {
        return new EffectProcessorResult.Ends((AccessLevel) null, list, (List) null, (ConversationKitResult) null, 13, (DefaultConstructorMarker) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: zendesk.conversationkit.android.model.Message} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final zendesk.conversationkit.android.internal.EffectProcessorResult processRefreshUserResult(zendesk.conversationkit.android.internal.Effect.RefreshUserResult r9, java.util.List<? extends zendesk.conversationkit.android.ConversationKitEvent> r10) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4 = r0
            java.util.List r4 = (java.util.List) r4
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r0 = r0.toLanguageTag()
            zendesk.conversationkit.android.ConversationKitResult r1 = r9.getResult()
            boolean r2 = r1 instanceof zendesk.conversationkit.android.ConversationKitResult.Success
            if (r2 == 0) goto L_0x00c0
            zendesk.conversationkit.android.ConversationKitResult$Success r1 = (zendesk.conversationkit.android.ConversationKitResult.Success) r1
            java.lang.Object r2 = r1.getValue()
            zendesk.conversationkit.android.model.User r2 = (zendesk.conversationkit.android.model.User) r2
            java.util.List r2 = r2.getConversations()
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ 1
            if (r2 == 0) goto L_0x00a3
            java.lang.Object r2 = r1.getValue()
            zendesk.conversationkit.android.model.User r2 = (zendesk.conversationkit.android.model.User) r2
            java.util.List r2 = r2.getConversations()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x003e:
            boolean r3 = r2.hasNext()
            r5 = 0
            if (r3 == 0) goto L_0x0053
            java.lang.Object r3 = r2.next()
            r6 = r3
            zendesk.conversationkit.android.model.Conversation r6 = (zendesk.conversationkit.android.model.Conversation) r6
            boolean r6 = r6.isDefault()
            if (r6 == 0) goto L_0x003e
            goto L_0x0054
        L_0x0053:
            r3 = r5
        L_0x0054:
            zendesk.conversationkit.android.model.Conversation r3 = (zendesk.conversationkit.android.model.Conversation) r3
            zendesk.conversationkit.android.model.Conversation r2 = r9.getPersistedConversation()
            if (r2 == 0) goto L_0x00a3
            java.util.List r6 = r2.getMessages()
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ 1
            if (r6 == 0) goto L_0x00a3
            if (r3 == 0) goto L_0x0079
            java.util.List r3 = r3.getMessages()
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = kotlin.collections.CollectionsKt.last(r3)
            r5 = r3
            zendesk.conversationkit.android.model.Message r5 = (zendesk.conversationkit.android.model.Message) r5
        L_0x0079:
            java.util.List r2 = r2.getMessages()
            java.lang.Object r2 = kotlin.collections.CollectionsKt.last(r2)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x00a3
            zendesk.conversationkit.android.internal.Action$RefreshConversation r2 = new zendesk.conversationkit.android.internal.Action$RefreshConversation
            java.lang.Object r3 = r1.getValue()
            zendesk.conversationkit.android.model.User r3 = (zendesk.conversationkit.android.model.User) r3
            java.util.List r3 = r3.getConversations()
            java.lang.Object r3 = kotlin.collections.CollectionsKt.first(r3)
            zendesk.conversationkit.android.model.Conversation r3 = (zendesk.conversationkit.android.model.Conversation) r3
            java.lang.String r3 = r3.getId()
            r2.<init>(r3)
            r4.add(r2)
        L_0x00a3:
            java.lang.Object r1 = r1.getValue()
            zendesk.conversationkit.android.model.User r1 = (zendesk.conversationkit.android.model.User) r1
            java.lang.String r1 = r1.getLocale()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r0)
            if (r1 != 0) goto L_0x00c0
            zendesk.conversationkit.android.internal.Action$UpdateAppUserLocale r1 = new zendesk.conversationkit.android.internal.Action$UpdateAppUserLocale
            java.lang.String r2 = "deviceLocale"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r1.<init>(r0)
            r4.add(r1)
        L_0x00c0:
            zendesk.conversationkit.android.ConversationKitResult r5 = r9.getResult()
            zendesk.conversationkit.android.internal.EffectProcessorResult$Ends r9 = new zendesk.conversationkit.android.internal.EffectProcessorResult$Ends
            r2 = 0
            r6 = 1
            r7 = 0
            r1 = r9
            r3 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7)
            zendesk.conversationkit.android.internal.EffectProcessorResult r9 = (zendesk.conversationkit.android.internal.EffectProcessorResult) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.EffectProcessor.processRefreshUserResult(zendesk.conversationkit.android.internal.Effect$RefreshUserResult, java.util.List):zendesk.conversationkit.android.internal.EffectProcessorResult");
    }
}
