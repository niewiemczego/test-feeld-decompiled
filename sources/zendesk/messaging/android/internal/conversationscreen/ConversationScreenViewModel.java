package zendesk.messaging.android.internal.conversationscreen;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import zendesk.android.Zendesk;
import zendesk.android.messaging.Messaging;
import zendesk.android.messaging.model.ColorTheme;
import zendesk.android.messaging.model.MessagingSettings;
import zendesk.conversationkit.android.ConnectionStatus;
import zendesk.conversationkit.android.ConversationKit;
import zendesk.conversationkit.android.ConversationKitEvent;
import zendesk.conversationkit.android.ConversationKitEventListener;
import zendesk.conversationkit.android.model.ActivityData;
import zendesk.conversationkit.android.model.ActivityEvent;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.conversationkit.android.model.Message;
import zendesk.conversationkit.android.model.MessageContent;
import zendesk.conversationkit.android.model.User;
import zendesk.logger.Logger;
import zendesk.messaging.android.internal.DefaultMessaging;
import zendesk.messaging.android.internal.NewMessagesDividerHandler;
import zendesk.messaging.android.internal.NewMessagesDividerHandlerKt;
import zendesk.messaging.android.internal.ScreenStateStore;
import zendesk.messaging.android.internal.conversationscreen.cache.MessagingStorage;
import zendesk.messaging.android.internal.model.LoadMoreStatus;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.messaging.android.internal.model.TypingUser;
import zendesk.messaging.android.internal.proactivemessaging.ProactiveMessageEvent;
import zendesk.messaging.android.push.internal.NotificationBuilder;
import zendesk.ui.android.conversation.form.DisplayedField;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 Z2\u00020\u0001:\u0001ZBE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002J\u0006\u0010'\u001a\u00020#J\u0006\u0010(\u001a\u00020#J\u0013\u0010)\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00150.J\u001a\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u00020*H\u0002J\u0011\u00103\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0012\u00104\u001a\u0004\u0018\u00010*2\u0006\u00105\u001a\u000206H\u0002J\u000e\u00107\u001a\u00020#2\u0006\u00108\u001a\u000209J\u0012\u0010:\u001a\u00020\u00152\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u0019\u0010=\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010>J\u0011\u0010?\u001a\u000206H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bJ\u0019\u0010A\u001a\u0002012\u0006\u0010)\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010>J\u0019\u0010B\u001a\u0002012\u0006\u0010)\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010>J\u0019\u0010C\u001a\u0002012\u0006\u00105\u001a\u000206H@ø\u0001\u0000¢\u0006\u0002\u0010DJ\u0010\u0010E\u001a\u00020#2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u00020#2\u0006\u0010%\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010K\u001a\u00020#2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010L\u001a\u00020\u0015H\u0002J\u0019\u0010M\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010>J\b\u0010N\u001a\u00020\u0015H\u0002J\u0019\u0010O\u001a\u00020#2\u0006\u00108\u001a\u00020PH@ø\u0001\u0000¢\u0006\u0002\u0010QJ\u0011\u0010R\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0019\u0010S\u001a\u00020*2\u0006\u0010)\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010>J\b\u0010T\u001a\u00020\u0015H\u0002J\u0019\u0010U\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010>J\b\u0010V\u001a\u00020\u0015H\u0002J\u000e\u0010W\u001a\u00020#2\u0006\u0010X\u001a\u00020\u001dJ\u0010\u0010Y\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006["}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "messagingSettings", "Lzendesk/android/messaging/model/MessagingSettings;", "colorTheme", "Lzendesk/android/messaging/model/ColorTheme;", "conversationKit", "Lzendesk/conversationkit/android/ConversationKit;", "messageLogEntryMapper", "Lzendesk/messaging/android/internal/conversationscreen/MessageLogEntryMapper;", "messagingStorage", "Lzendesk/messaging/android/internal/conversationscreen/cache/MessagingStorage;", "newMessagesDividerHandler", "Lzendesk/messaging/android/internal/NewMessagesDividerHandler;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "sdkCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lzendesk/android/messaging/model/MessagingSettings;Lzendesk/android/messaging/model/ColorTheme;Lzendesk/conversationkit/android/ConversationKit;Lzendesk/messaging/android/internal/conversationscreen/MessageLogEntryMapper;Lzendesk/messaging/android/internal/conversationscreen/cache/MessagingStorage;Lzendesk/messaging/android/internal/NewMessagesDividerHandler;Landroidx/lifecycle/SavedStateHandle;Lkotlinx/coroutines/CoroutineScope;)V", "conversationScreenStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenState;", "eventListener", "Lzendesk/conversationkit/android/ConversationKitEventListener;", "hasRepliedToProactiveMessage", "", "mapOfDisplayedFields", "", "", "Lzendesk/ui/android/conversation/form/DisplayedField;", "notificationId", "Ljava/lang/Integer;", "refreshStateJob", "Lkotlinx/coroutines/Job;", "analyticsProactiveMessageOpened", "", "analyticsProactiveMessageReplayedTo", "conversationKitEvent", "Lzendesk/conversationkit/android/ConversationKitEvent$ConversationUpdated;", "clearNewMessagesDivider", "clearTypingUser", "conversationId", "", "conversationId$zendesk_messaging_messaging_android", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversationScreenState", "Lkotlinx/coroutines/flow/Flow;", "conversationState", "conversation", "Lzendesk/conversationkit/android/model/Conversation;", "composerText", "createConversation", "defaultConversationId", "user", "Lzendesk/conversationkit/android/model/User;", "dispatchAction", "conversationScreenAction", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction;", "errorState", "cause", "", "failedLoadMoreMessagesProgressBar", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUser", "getMapOfDisplayedFields", "getRemoteConversation", "getUpdatedConversation", "getUserDefaultConversation", "(Lzendesk/conversationkit/android/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleActivityEventReceived", "activityEventReceived", "Lzendesk/conversationkit/android/ConversationKitEvent$ActivityEventReceived;", "handleConnectionStatusChanged", "Lzendesk/conversationkit/android/ConversationKitEvent$ConnectionStatusChanged;", "handleConversationUpdated", "handleMessageReceived", "hideDeniedPermission", "hideLoadMoreMessagesProgressBar", "hideMessageComposerState", "loadMoreMessages", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$LoadMoreMessages;", "(Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenAction$LoadMoreMessages;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshState", "retrieveInitialText", "showDeniedPermission", "showLoadMoreMessagesProgressBar", "showMessageComposerState", "updateMapOfDisplayedFields", "displayedField", "updateNewMessagesDividerDate", "Companion", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenViewModel.kt */
public final class ConversationScreenViewModel extends ViewModel {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String HAS_REPLIED_TO_PROACTIVE_MESSAGE = "HAS_REPLIED_TO_PROACTIVE_MESSAGE";
    @Deprecated
    private static final String LOG_TAG = "ConversationScreenStore";
    @Deprecated
    private static final String MAP_OF_DISPLAYED_FIELD_VIEWS = "mapOfDisplayedFields";
    /* access modifiers changed from: private */
    public final ConversationKit conversationKit;
    /* access modifiers changed from: private */
    public final MutableStateFlow<ConversationScreenState> conversationScreenStateFlow;
    /* access modifiers changed from: private */
    public final ConversationKitEventListener eventListener;
    private boolean hasRepliedToProactiveMessage;
    private final Map<Integer, DisplayedField> mapOfDisplayedFields;
    private final MessageLogEntryMapper messageLogEntryMapper;
    /* access modifiers changed from: private */
    public final MessagingStorage messagingStorage;
    private final NewMessagesDividerHandler newMessagesDividerHandler;
    private final Integer notificationId;
    private Job refreshStateJob;
    private final SavedStateHandle savedStateHandle;
    private final CoroutineScope sdkCoroutineScope;

    public ConversationScreenViewModel(MessagingSettings messagingSettings, ColorTheme colorTheme, ConversationKit conversationKit2, MessageLogEntryMapper messageLogEntryMapper2, MessagingStorage messagingStorage2, NewMessagesDividerHandler newMessagesDividerHandler2, SavedStateHandle savedStateHandle2, CoroutineScope coroutineScope) {
        ConversationKit conversationKit3 = conversationKit2;
        MessageLogEntryMapper messageLogEntryMapper3 = messageLogEntryMapper2;
        MessagingStorage messagingStorage3 = messagingStorage2;
        NewMessagesDividerHandler newMessagesDividerHandler3 = newMessagesDividerHandler2;
        SavedStateHandle savedStateHandle3 = savedStateHandle2;
        CoroutineScope coroutineScope2 = coroutineScope;
        Intrinsics.checkNotNullParameter(messagingSettings, "messagingSettings");
        Intrinsics.checkNotNullParameter(colorTheme, "colorTheme");
        Intrinsics.checkNotNullParameter(conversationKit3, "conversationKit");
        Intrinsics.checkNotNullParameter(messageLogEntryMapper3, "messageLogEntryMapper");
        Intrinsics.checkNotNullParameter(messagingStorage3, "messagingStorage");
        Intrinsics.checkNotNullParameter(newMessagesDividerHandler3, "newMessagesDividerHandler");
        Intrinsics.checkNotNullParameter(savedStateHandle3, "savedStateHandle");
        Intrinsics.checkNotNullParameter(coroutineScope2, "sdkCoroutineScope");
        this.conversationKit = conversationKit3;
        this.messageLogEntryMapper = messageLogEntryMapper3;
        this.messagingStorage = messagingStorage3;
        this.newMessagesDividerHandler = newMessagesDividerHandler3;
        this.savedStateHandle = savedStateHandle3;
        this.sdkCoroutineScope = coroutineScope2;
        this.notificationId = (Integer) savedStateHandle3.getLiveData(NotificationBuilder.NOTIFICATION_ID).getValue();
        Boolean bool = false;
        Boolean bool2 = (Boolean) savedStateHandle3.getLiveData(HAS_REPLIED_TO_PROACTIVE_MESSAGE, bool).getValue();
        this.hasRepliedToProactiveMessage = (bool2 != null ? bool2 : bool).booleanValue();
        analyticsProactiveMessageOpened();
        this.conversationScreenStateFlow = StateFlowKt.MutableStateFlow(new ConversationScreenState(colorTheme, messagingSettings.getTitle(), messagingSettings.getDescription(), messagingSettings.getLogoUrl(), (List) null, (Conversation) null, (Throwable) null, false, 0, (ConnectionStatus) null, false, false, (String) null, (Map) null, (TypingUser) null, (String) null, false, (LoadMoreStatus) null, false, 524272, (DefaultConstructorMarker) null));
        this.mapOfDisplayedFields = new LinkedHashMap();
        this.eventListener = new ConversationScreenViewModel$$ExternalSyntheticLambda0(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: eventListener$lambda-0  reason: not valid java name */
    public static final void m690eventListener$lambda0(ConversationScreenViewModel conversationScreenViewModel, ConversationKitEvent conversationKitEvent) {
        boolean z;
        Intrinsics.checkNotNullParameter(conversationScreenViewModel, "this$0");
        Intrinsics.checkNotNullParameter(conversationKitEvent, "conversationKitEvent");
        if (conversationKitEvent instanceof ConversationKitEvent.ConversationUpdated) {
            conversationScreenViewModel.handleConversationUpdated((ConversationKitEvent.ConversationUpdated) conversationKitEvent);
        } else if (conversationKitEvent instanceof ConversationKitEvent.ConnectionStatusChanged) {
            conversationScreenViewModel.handleConnectionStatusChanged((ConversationKitEvent.ConnectionStatusChanged) conversationKitEvent);
        } else if (conversationKitEvent instanceof ConversationKitEvent.MessageReceived) {
            conversationScreenViewModel.handleMessageReceived(((ConversationKitEvent.MessageReceived) conversationKitEvent).getConversationId());
        } else if (conversationKitEvent instanceof ConversationKitEvent.ActivityEventReceived) {
            conversationScreenViewModel.handleActivityEventReceived((ConversationKitEvent.ActivityEventReceived) conversationKitEvent);
        } else {
            boolean z2 = true;
            if (conversationKitEvent instanceof ConversationKitEvent.UserUpdated) {
                z = true;
            } else {
                z = conversationKitEvent instanceof ConversationKitEvent.PushTokenPrepared;
            }
            if (!z) {
                z2 = conversationKitEvent instanceof ConversationKitEvent.PushTokenUpdateResult;
            }
            if (z2) {
                Logger.d(LOG_TAG, conversationKitEvent.getClass().getSimpleName() + " received.", new Object[0]);
            }
        }
    }

    public final Map<Integer, DisplayedField> getMapOfDisplayedFields() {
        Map<Integer, DisplayedField> map = (Map) this.savedStateHandle.get(MAP_OF_DISPLAYED_FIELD_VIEWS);
        return map == null || map.isEmpty() ? this.mapOfDisplayedFields : map;
    }

    public final void updateMapOfDisplayedFields(DisplayedField displayedField) {
        Intrinsics.checkNotNullParameter(displayedField, "displayedField");
        this.mapOfDisplayedFields.put(Integer.valueOf(displayedField.getIndex()), displayedField);
        this.savedStateHandle.set(MAP_OF_DISPLAYED_FIELD_VIEWS, this.mapOfDisplayedFields);
    }

    private final void handleConversationUpdated(ConversationKitEvent.ConversationUpdated conversationUpdated) {
        Logger.d(LOG_TAG, "ConversationUpdated received for the conversation with id " + conversationUpdated.getConversation().getId(), new Object[0]);
        String id = conversationUpdated.getConversation().getId();
        Conversation conversation = this.conversationScreenStateFlow.getValue().getConversation();
        if (Intrinsics.areEqual((Object) id, (Object) conversation != null ? conversation.getId() : null)) {
            updateNewMessagesDividerDate(conversationUpdated);
            analyticsProactiveMessageReplayedTo(conversationUpdated);
            this.conversationScreenStateFlow.setValue(conversationState$default(this, conversationUpdated.getConversation(), (String) null, 2, (Object) null));
        }
    }

    private final void analyticsProactiveMessageOpened() {
        if (this.notificationId != null) {
            Messaging messaging = Zendesk.Companion.getInstance().getMessaging();
            DefaultMessaging defaultMessaging = messaging instanceof DefaultMessaging ? (DefaultMessaging) messaging : null;
            if (defaultMessaging != null) {
                defaultMessaging.handleProactiveMessageEvent$zendesk_messaging_messaging_android(this.notificationId.intValue(), ProactiveMessageEvent.OPENED);
            }
        }
    }

    private final void analyticsProactiveMessageReplayedTo(ConversationKitEvent.ConversationUpdated conversationUpdated) {
        int i;
        List<Message> messages;
        if (this.notificationId != null && !this.hasRepliedToProactiveMessage) {
            Conversation conversation = this.conversationScreenStateFlow.getValue().getConversation();
            if (conversation == null || (messages = conversation.getMessages()) == null) {
                i = 0;
            } else {
                Collection arrayList = new ArrayList();
                for (Object next : messages) {
                    if (((Message) next).isAuthoredBy(conversationUpdated.getConversation().getMyself())) {
                        arrayList.add(next);
                    }
                }
                i = ((List) arrayList).size();
            }
            Collection arrayList2 = new ArrayList();
            for (Object next2 : conversationUpdated.getConversation().getMessages()) {
                if (((Message) next2).isAuthoredBy(conversationUpdated.getConversation().getMyself())) {
                    arrayList2.add(next2);
                }
            }
            if (((List) arrayList2).size() > i) {
                Messaging messaging = Zendesk.Companion.getInstance().getMessaging();
                DefaultMessaging defaultMessaging = messaging instanceof DefaultMessaging ? (DefaultMessaging) messaging : null;
                if (defaultMessaging != null) {
                    defaultMessaging.handleProactiveMessageEvent$zendesk_messaging_messaging_android(this.notificationId.intValue(), ProactiveMessageEvent.REPLIED_TO);
                }
                this.hasRepliedToProactiveMessage = true;
                this.savedStateHandle.set(HAS_REPLIED_TO_PROACTIVE_MESSAGE, true);
            }
        }
    }

    private final void handleConnectionStatusChanged(ConversationKitEvent.ConnectionStatusChanged connectionStatusChanged) {
        boolean z = false;
        Logger.d(LOG_TAG, "ConnectionStatusChanged received with value " + connectionStatusChanged.getConnectionStatus(), new Object[0]);
        MutableStateFlow<ConversationScreenState> mutableStateFlow = this.conversationScreenStateFlow;
        mutableStateFlow.setValue(ConversationScreenState.copy$default(mutableStateFlow.getValue(), (ColorTheme) null, (String) null, (String) null, (String) null, (List) null, (Conversation) null, (Throwable) null, false, 0, connectionStatusChanged.getConnectionStatus(), false, false, (String) null, (Map) null, (TypingUser) null, (String) null, false, (LoadMoreStatus) null, false, 523775, (Object) null));
        if (connectionStatusChanged.getConnectionStatus() == ConnectionStatus.CONNECTED_REALTIME) {
            Job job = this.refreshStateJob;
            if (job != null) {
                if (job != null && job.isCompleted()) {
                    z = true;
                }
                if (!z) {
                    return;
                }
            }
            this.refreshStateJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationScreenViewModel$handleConnectionStatusChanged$1(this, (Continuation<? super ConversationScreenViewModel$handleConnectionStatusChanged$1>) null), 3, (Object) null);
        }
    }

    private final void handleMessageReceived(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationScreenViewModel$handleMessageReceived$1(this, str, (Continuation<? super ConversationScreenViewModel$handleMessageReceived$1>) null), 3, (Object) null);
    }

    private final void handleActivityEventReceived(ConversationKitEvent.ActivityEventReceived activityEventReceived) {
        TypingUser typingUser;
        Conversation conversation;
        ActivityEvent activityEvent = activityEventReceived.getActivityEvent();
        boolean z = activityEvent.getActivityData() == ActivityData.TYPING_START;
        String userAvatarUrl = activityEvent.getUserAvatarUrl();
        if (!z || userAvatarUrl == null) {
            typingUser = TypingUser.None.INSTANCE;
        } else {
            typingUser = new TypingUser.User(userAvatarUrl);
        }
        if (!Intrinsics.areEqual((Object) this.conversationScreenStateFlow.getValue().getTypingUser(), (Object) typingUser) && (conversation = this.conversationScreenStateFlow.getValue().getConversation()) != null && Intrinsics.areEqual((Object) conversation.getId(), (Object) activityEvent.getConversationId())) {
            MutableStateFlow<ConversationScreenState> mutableStateFlow = this.conversationScreenStateFlow;
            mutableStateFlow.setValue(ConversationScreenState.copy$default(mutableStateFlow.getValue(), (ColorTheme) null, (String) null, (String) null, (String) null, this.messageLogEntryMapper.map(conversation, this.newMessagesDividerHandler.getNewMessageDividerDate(conversation.getId()), typingUser, LoadMoreStatus.NONE), (Conversation) null, (Throwable) null, false, 0, (ConnectionStatus) null, false, false, (String) null, (Map) null, typingUser, (String) null, false, (LoadMoreStatus) null, false, 507887, (Object) null));
        }
    }

    public final void clearTypingUser() {
        Conversation conversation = this.conversationScreenStateFlow.getValue().getConversation();
        if (conversation != null) {
            TypingUser.None none = TypingUser.None.INSTANCE;
            MutableStateFlow<ConversationScreenState> mutableStateFlow = this.conversationScreenStateFlow;
            TypingUser typingUser = none;
            mutableStateFlow.setValue(ConversationScreenState.copy$default(mutableStateFlow.getValue(), (ColorTheme) null, (String) null, (String) null, (String) null, this.messageLogEntryMapper.map(conversation, this.newMessagesDividerHandler.getNewMessageDividerDate(conversation.getId()), typingUser, LoadMoreStatus.NONE), (Conversation) null, (Throwable) null, false, 0, (ConnectionStatus) null, false, false, (String) null, (Map) null, typingUser, (String) null, false, (LoadMoreStatus) null, false, 507887, (Object) null));
        }
    }

    public final void dispatchAction(ConversationScreenAction conversationScreenAction) {
        Intrinsics.checkNotNullParameter(conversationScreenAction, "conversationScreenAction");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.sdkCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationScreenViewModel$dispatchAction$1(conversationScreenAction, this, (Continuation<? super ConversationScreenViewModel$dispatchAction$1>) null), 3, (Object) null);
    }

    public final Flow<ConversationScreenState> conversationScreenState() {
        return FlowKt.onCompletion(FlowKt.onStart(FlowKt.onSubscription(this.conversationScreenStateFlow, new ConversationScreenViewModel$conversationScreenState$1(this, (Continuation<? super ConversationScreenViewModel$conversationScreenState$1>) null)), new ConversationScreenViewModel$conversationScreenState$2(this, (Continuation<? super ConversationScreenViewModel$conversationScreenState$2>) null)), new ConversationScreenViewModel$conversationScreenState$3(this, (Continuation<? super ConversationScreenViewModel$conversationScreenState$3>) null));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object retrieveInitialText(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.String> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$retrieveInitialText$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$retrieveInitialText$1 r0 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$retrieveInitialText$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$retrieveInitialText$1 r0 = new zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$retrieveInitialText$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            zendesk.messaging.android.internal.conversationscreen.cache.MessagingStorage r6 = r4.messagingStorage
            r0.label = r3
            java.lang.Object r6 = r6.getMessagingPersistence(r5, r0)
            if (r6 != r1) goto L_0x0040
            return r1
        L_0x0040:
            zendesk.messaging.android.internal.conversationscreen.cache.MessagingUIPersistence r6 = (zendesk.messaging.android.internal.conversationscreen.cache.MessagingUIPersistence) r6
            java.lang.String r5 = r6.getComposerText()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel.retrieveInitialText(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071 A[Catch:{ Exception -> 0x0053 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0084 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0097 A[Catch:{ Exception -> 0x0038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object refreshState(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$refreshState$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$refreshState$1 r0 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$refreshState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$refreshState$1 r0 = new zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$refreshState$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r5) goto L_0x004b
            if (r2 == r4) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r1 = r0.L$1
            zendesk.conversationkit.android.model.Conversation r1 = (zendesk.conversationkit.android.model.Conversation) r1
            java.lang.Object r0 = r0.L$0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r0 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x0038 }
            goto L_0x0088
        L_0x0038:
            r7 = move-exception
            goto L_0x00a8
        L_0x003b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0043:
            java.lang.Object r2 = r0.L$0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0072
        L_0x004b:
            java.lang.Object r2 = r0.L$0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0065
        L_0x0053:
            r7 = move-exception
            r0 = r2
            goto L_0x00a8
        L_0x0056:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r6     // Catch:{ Exception -> 0x00a6 }
            r0.label = r5     // Catch:{ Exception -> 0x00a6 }
            java.lang.Object r7 = r6.getCurrentUser(r0)     // Catch:{ Exception -> 0x00a6 }
            if (r7 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r2 = r6
        L_0x0065:
            zendesk.conversationkit.android.model.User r7 = (zendesk.conversationkit.android.model.User) r7     // Catch:{ Exception -> 0x0053 }
            r0.L$0 = r2     // Catch:{ Exception -> 0x0053 }
            r0.label = r4     // Catch:{ Exception -> 0x0053 }
            java.lang.Object r7 = r2.getUserDefaultConversation(r7, r0)     // Catch:{ Exception -> 0x0053 }
            if (r7 != r1) goto L_0x0072
            return r1
        L_0x0072:
            zendesk.conversationkit.android.model.Conversation r7 = (zendesk.conversationkit.android.model.Conversation) r7     // Catch:{ Exception -> 0x0053 }
            java.lang.String r4 = r7.getId()     // Catch:{ Exception -> 0x0053 }
            r0.L$0 = r2     // Catch:{ Exception -> 0x0053 }
            r0.L$1 = r7     // Catch:{ Exception -> 0x0053 }
            r0.label = r3     // Catch:{ Exception -> 0x0053 }
            java.lang.Object r0 = r2.retrieveInitialText(r4, r0)     // Catch:{ Exception -> 0x0053 }
            if (r0 != r1) goto L_0x0085
            return r1
        L_0x0085:
            r1 = r7
            r7 = r0
            r0 = r2
        L_0x0088:
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0038 }
            java.util.List r2 = r1.getMessages()     // Catch:{ Exception -> 0x0038 }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ Exception -> 0x0038 }
            boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x0038 }
            r2 = r2 ^ r5
            if (r2 == 0) goto L_0x009c
            zendesk.messaging.android.internal.NewMessagesDividerHandler r2 = r0.newMessagesDividerHandler     // Catch:{ Exception -> 0x0038 }
            r2.updateNewMessageDividerDate(r1)     // Catch:{ Exception -> 0x0038 }
        L_0x009c:
            kotlinx.coroutines.flow.MutableStateFlow<zendesk.messaging.android.internal.conversationscreen.ConversationScreenState> r2 = r0.conversationScreenStateFlow     // Catch:{ Exception -> 0x0038 }
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r7 = r0.conversationState(r1, r7)     // Catch:{ Exception -> 0x0038 }
            r2.setValue(r7)     // Catch:{ Exception -> 0x0038 }
            goto L_0x00b7
        L_0x00a6:
            r7 = move-exception
            r0 = r6
        L_0x00a8:
            boolean r1 = r7 instanceof java.util.concurrent.CancellationException
            if (r1 != 0) goto L_0x00ba
            kotlinx.coroutines.flow.MutableStateFlow<zendesk.messaging.android.internal.conversationscreen.ConversationScreenState> r1 = r0.conversationScreenStateFlow
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r7 = r0.errorState(r7)
            r1.setValue(r7)
        L_0x00b7:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x00ba:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel.refreshState(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getCurrentUser(kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.model.User> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$getCurrentUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$getCurrentUser$1 r0 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$getCurrentUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$getCurrentUser$1 r0 = new zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$getCurrentUser$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r0 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0059
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            zendesk.conversationkit.android.ConversationKit r6 = r5.conversationKit
            zendesk.conversationkit.android.model.User r6 = r6.getCurrentUser()
            if (r6 != 0) goto L_0x008d
            r6 = 0
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r2 = "ConversationScreenStore"
            java.lang.String r4 = "No user created yet, creating user to show the conversation."
            zendesk.logger.Logger.i(r2, r4, r6)
            zendesk.conversationkit.android.ConversationKit r6 = r5.conversationKit
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.createUser(r0)
            if (r6 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r0 = r5
        L_0x0059:
            zendesk.conversationkit.android.ConversationKitResult r6 = (zendesk.conversationkit.android.ConversationKitResult) r6
            boolean r1 = r6 instanceof zendesk.conversationkit.android.ConversationKitResult.Success
            if (r1 == 0) goto L_0x0068
            zendesk.conversationkit.android.ConversationKitResult$Success r6 = (zendesk.conversationkit.android.ConversationKitResult.Success) r6
            java.lang.Object r6 = r6.getValue()
            zendesk.conversationkit.android.model.User r6 = (zendesk.conversationkit.android.model.User) r6
            goto L_0x007e
        L_0x0068:
            boolean r1 = r6 instanceof zendesk.conversationkit.android.ConversationKitResult.Failure
            if (r1 == 0) goto L_0x0087
            zendesk.conversationkit.android.ConversationKitResult$Failure r6 = (zendesk.conversationkit.android.ConversationKitResult.Failure) r6
            java.lang.Throwable r1 = r6.getCause()
            boolean r1 = r1 instanceof zendesk.conversationkit.android.ConversationKitError.UserAlreadyExists
            if (r1 == 0) goto L_0x0082
            zendesk.conversationkit.android.ConversationKit r6 = r0.conversationKit
            zendesk.conversationkit.android.model.User r6 = r6.getCurrentUser()
            if (r6 == 0) goto L_0x007f
        L_0x007e:
            return r6
        L_0x007f:
            zendesk.conversationkit.android.ConversationKitError$FailedToInitialize r6 = zendesk.conversationkit.android.ConversationKitError.FailedToInitialize.INSTANCE
            throw r6
        L_0x0082:
            java.lang.Throwable r6 = r6.getCause()
            throw r6
        L_0x0087:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x008d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel.getCurrentUser(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object getUserDefaultConversation(User user, Continuation<? super Conversation> continuation) {
        String defaultConversationId = defaultConversationId(user);
        if (defaultConversationId == null) {
            return createConversation(continuation);
        }
        Logger.i(LOG_TAG, "No conversation ID provided, fetching the default conversation for the user.", new Object[0]);
        return getRemoteConversation(defaultConversationId, continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createConversation(kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.model.Conversation> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$createConversation$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$createConversation$1 r0 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$createConversation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$createConversation$1 r0 = new zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$createConversation$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            zendesk.conversationkit.android.ConversationKit r5 = r4.conversationKit
            r0.label = r3
            java.lang.Object r5 = r5.createConversation(r0)
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x0040:
            zendesk.conversationkit.android.ConversationKitResult r5 = (zendesk.conversationkit.android.ConversationKitResult) r5
            boolean r0 = r5 instanceof zendesk.conversationkit.android.ConversationKitResult.Failure
            if (r0 != 0) goto L_0x0059
            boolean r0 = r5 instanceof zendesk.conversationkit.android.ConversationKitResult.Success
            if (r0 == 0) goto L_0x0053
            zendesk.conversationkit.android.ConversationKitResult$Success r5 = (zendesk.conversationkit.android.ConversationKitResult.Success) r5
            java.lang.Object r5 = r5.getValue()
            zendesk.conversationkit.android.model.Conversation r5 = (zendesk.conversationkit.android.model.Conversation) r5
            return r5
        L_0x0053:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L_0x0059:
            zendesk.conversationkit.android.ConversationKitResult$Failure r5 = (zendesk.conversationkit.android.ConversationKitResult.Failure) r5
            java.lang.Throwable r5 = r5.getCause()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel.createConversation(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String defaultConversationId(User user) {
        Object obj;
        Iterator it = user.getConversations().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Conversation) obj).isDefault()) {
                break;
            }
        }
        Conversation conversation = (Conversation) obj;
        if (conversation != null) {
            return conversation.getId();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getRemoteConversation(java.lang.String r5, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.model.Conversation> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$getRemoteConversation$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$getRemoteConversation$1 r0 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$getRemoteConversation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$getRemoteConversation$1 r0 = new zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$getRemoteConversation$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            zendesk.conversationkit.android.ConversationKit r6 = r4.conversationKit
            r0.label = r3
            java.lang.Object r6 = r6.getConversation(r5, r0)
            if (r6 != r1) goto L_0x0040
            return r1
        L_0x0040:
            zendesk.conversationkit.android.ConversationKitResult r6 = (zendesk.conversationkit.android.ConversationKitResult) r6
            boolean r5 = r6 instanceof zendesk.conversationkit.android.ConversationKitResult.Success
            if (r5 == 0) goto L_0x004f
            zendesk.conversationkit.android.ConversationKitResult$Success r6 = (zendesk.conversationkit.android.ConversationKitResult.Success) r6
            java.lang.Object r5 = r6.getValue()
            zendesk.conversationkit.android.model.Conversation r5 = (zendesk.conversationkit.android.model.Conversation) r5
            return r5
        L_0x004f:
            boolean r5 = r6 instanceof zendesk.conversationkit.android.ConversationKitResult.Failure
            if (r5 == 0) goto L_0x005a
            zendesk.conversationkit.android.ConversationKitResult$Failure r6 = (zendesk.conversationkit.android.ConversationKitResult.Failure) r6
            java.lang.Throwable r5 = r6.getCause()
            throw r5
        L_0x005a:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel.getRemoteConversation(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ ConversationScreenState conversationState$default(ConversationScreenViewModel conversationScreenViewModel, Conversation conversation, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return conversationScreenViewModel.conversationState(conversation, str);
    }

    private final ConversationScreenState conversationState(Conversation conversation, String str) {
        ConversationScreenState value = this.conversationScreenStateFlow.getValue();
        List<MessageLogEntry> map = this.messageLogEntryMapper.map(conversation, this.newMessagesDividerHandler.getNewMessageDividerDate(conversation.getId()), this.conversationScreenStateFlow.getValue().getTypingUser(), LoadMoreStatus.NONE);
        Message message = (Message) CollectionsKt.lastOrNull(conversation.getMessages());
        ConversationScreenState copy$default = ConversationScreenState.copy$default(value, (ColorTheme) null, (String) null, (String) null, (String) null, map, conversation, (Throwable) null, ((message != null ? message.getContent() : null) instanceof MessageContent.Form) && ((MessageContent.Form) message.getContent()).getBlockChatInput(), 0, this.conversationScreenStateFlow.getValue().getConnectionStatus(), false, false, str, (Map) null, this.conversationScreenStateFlow.getValue().getTypingUser(), (String) null, false, this.conversationScreenStateFlow.getValue().getLoadMoreStatus(), NewMessagesDividerHandlerKt.hasNewInboundMessages(conversation), 44047, (Object) null);
        Logger.d(LOG_TAG, "Creating a new conversationState", new Object[0]);
        return copy$default;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadMoreMessages(zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction.LoadMoreMessages r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r1 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$loadMoreMessages$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$loadMoreMessages$1 r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$loadMoreMessages$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$loadMoreMessages$1 r2 = new zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$loadMoreMessages$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 5
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 0
            r10 = 1
            if (r4 == 0) goto L_0x007f
            if (r4 == r10) goto L_0x0071
            if (r4 == r8) goto L_0x005e
            if (r4 == r7) goto L_0x0051
            if (r4 == r6) goto L_0x0048
            if (r4 != r5) goto L_0x0040
            java.lang.Object r2 = r2.L$0
            kotlinx.coroutines.flow.MutableStateFlow r2 = (kotlinx.coroutines.flow.MutableStateFlow) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x011e
        L_0x0040:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0048:
            java.lang.Object r2 = r2.L$0
            kotlinx.coroutines.flow.MutableStateFlow r2 = (kotlinx.coroutines.flow.MutableStateFlow) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0102
        L_0x0051:
            java.lang.Object r4 = r2.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r7 = r2.L$0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r7 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel) r7
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00e8
        L_0x005e:
            double r10 = r2.D$0
            java.lang.Object r4 = r2.L$2
            kotlinx.coroutines.flow.MutableStateFlow r4 = (kotlinx.coroutines.flow.MutableStateFlow) r4
            java.lang.Object r8 = r2.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r12 = r2.L$0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r12 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel) r12
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r12
            goto L_0x00d2
        L_0x0071:
            double r11 = r2.D$0
            java.lang.Object r4 = r2.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r13 = r2.L$0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r13 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel) r13
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x009a
        L_0x007f:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.String r4 = r18.getConversationId()
            double r11 = r18.getBeforeTimestamp()
            r2.L$0 = r0
            r2.L$1 = r4
            r2.D$0 = r11
            r2.label = r10
            java.lang.Object r1 = r0.getUpdatedConversation(r4, r2)
            if (r1 != r3) goto L_0x0099
            return r3
        L_0x0099:
            r13 = r0
        L_0x009a:
            zendesk.conversationkit.android.model.Conversation r1 = (zendesk.conversationkit.android.model.Conversation) r1
            kotlinx.coroutines.flow.MutableStateFlow<zendesk.messaging.android.internal.conversationscreen.ConversationScreenState> r14 = r13.conversationScreenStateFlow
            java.lang.Object r14 = r14.getValue()
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r14 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenState) r14
            zendesk.messaging.android.internal.model.LoadMoreStatus r14 = r14.getLoadMoreStatus()
            zendesk.messaging.android.internal.model.LoadMoreStatus r15 = zendesk.messaging.android.internal.model.LoadMoreStatus.LOADING
            r10 = 0
            if (r14 != r15) goto L_0x00af
            r14 = 1
            goto L_0x00b0
        L_0x00af:
            r14 = r10
        L_0x00b0:
            boolean r1 = r1.getHasPrevious()
            if (r1 == 0) goto L_0x0122
            if (r14 != 0) goto L_0x0122
            kotlinx.coroutines.flow.MutableStateFlow<zendesk.messaging.android.internal.conversationscreen.ConversationScreenState> r1 = r13.conversationScreenStateFlow
            r2.L$0 = r13
            r2.L$1 = r4
            r2.L$2 = r1
            r2.D$0 = r11
            r2.label = r8
            java.lang.Object r8 = r13.showLoadMoreMessagesProgressBar(r4, r2)
            if (r8 != r3) goto L_0x00cb
            return r3
        L_0x00cb:
            r10 = r11
            r16 = r4
            r4 = r1
            r1 = r8
            r8 = r16
        L_0x00d2:
            r4.setValue(r1)
            zendesk.conversationkit.android.ConversationKit r1 = r13.conversationKit
            r2.L$0 = r13
            r2.L$1 = r8
            r2.L$2 = r9
            r2.label = r7
            java.lang.Object r1 = r1.getMessages(r8, r10, r2)
            if (r1 != r3) goto L_0x00e6
            return r3
        L_0x00e6:
            r4 = r8
            r7 = r13
        L_0x00e8:
            zendesk.conversationkit.android.ConversationKitResult r1 = (zendesk.conversationkit.android.ConversationKitResult) r1
            boolean r8 = r1 instanceof zendesk.conversationkit.android.ConversationKitResult.Success
            if (r8 == 0) goto L_0x0106
            kotlinx.coroutines.flow.MutableStateFlow<zendesk.messaging.android.internal.conversationscreen.ConversationScreenState> r1 = r7.conversationScreenStateFlow
            r2.L$0 = r1
            r2.L$1 = r9
            r2.label = r6
            java.lang.Object r2 = r7.hideLoadMoreMessagesProgressBar(r4, r2)
            if (r2 != r3) goto L_0x00fd
            return r3
        L_0x00fd:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x0102:
            r2.setValue(r1)
            goto L_0x012b
        L_0x0106:
            boolean r1 = r1 instanceof zendesk.conversationkit.android.ConversationKitResult.Failure
            if (r1 == 0) goto L_0x012b
            kotlinx.coroutines.flow.MutableStateFlow<zendesk.messaging.android.internal.conversationscreen.ConversationScreenState> r1 = r7.conversationScreenStateFlow
            r2.L$0 = r1
            r2.L$1 = r9
            r2.label = r5
            java.lang.Object r2 = r7.failedLoadMoreMessagesProgressBar(r4, r2)
            if (r2 != r3) goto L_0x0119
            return r3
        L_0x0119:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x011e:
            r2.setValue(r1)
            goto L_0x012b
        L_0x0122:
            java.lang.Object[] r1 = new java.lang.Object[r10]
            java.lang.String r2 = "ConversationScreenStore"
            java.lang.String r3 = "Conversation screen reaches to the top of the screen and no more items."
            zendesk.logger.Logger.d(r2, r3, r1)
        L_0x012b:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel.loadMoreMessages(zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction$LoadMoreMessages, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final ConversationScreenState errorState(Throwable th) {
        ConversationScreenState copy$default = ConversationScreenState.copy$default(this.conversationScreenStateFlow.getValue(), (ColorTheme) null, (String) null, (String) null, (String) null, (List) null, (Conversation) null, th, false, 0, (ConnectionStatus) null, false, false, (String) null, (Map) null, (TypingUser) null, (String) null, false, (LoadMoreStatus) null, false, 524223, (Object) null);
        Logger.e(LOG_TAG, "Creating a new errorState", th, new Object[0]);
        return copy$default;
    }

    /* access modifiers changed from: private */
    public final ConversationScreenState showMessageComposerState() {
        return ConversationScreenState.copy$default(this.conversationScreenStateFlow.getValue(), (ColorTheme) null, (String) null, (String) null, (String) null, (List) null, (Conversation) null, (Throwable) null, false, 0, (ConnectionStatus) null, false, false, (String) null, (Map) null, (TypingUser) null, (String) null, false, (LoadMoreStatus) null, false, 524031, (Object) null);
    }

    /* access modifiers changed from: private */
    public final ConversationScreenState hideMessageComposerState() {
        return ConversationScreenState.copy$default(this.conversationScreenStateFlow.getValue(), (ColorTheme) null, (String) null, (String) null, (String) null, (List) null, (Conversation) null, (Throwable) null, false, 8, (ConnectionStatus) null, false, false, (String) null, (Map) null, (TypingUser) null, (String) null, false, (LoadMoreStatus) null, false, 524031, (Object) null);
    }

    /* access modifiers changed from: private */
    public final ConversationScreenState showDeniedPermission() {
        return ConversationScreenState.copy$default(this.conversationScreenStateFlow.getValue(), (ColorTheme) null, (String) null, (String) null, (String) null, (List) null, (Conversation) null, (Throwable) null, false, 0, (ConnectionStatus) null, false, false, (String) null, (Map) null, (TypingUser) null, (String) null, true, (LoadMoreStatus) null, false, 458751, (Object) null);
    }

    /* access modifiers changed from: private */
    public final ConversationScreenState hideDeniedPermission() {
        return ConversationScreenState.copy$default(this.conversationScreenStateFlow.getValue(), (ColorTheme) null, (String) null, (String) null, (String) null, (List) null, (Conversation) null, (Throwable) null, false, 0, (ConnectionStatus) null, false, false, (String) null, (Map) null, (TypingUser) null, (String) null, false, (LoadMoreStatus) null, false, 458751, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showLoadMoreMessagesProgressBar(java.lang.String r27, kotlin.coroutines.Continuation<? super zendesk.messaging.android.internal.conversationscreen.ConversationScreenState> r28) {
        /*
            r26 = this;
            r0 = r26
            r1 = r28
            boolean r2 = r1 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$showLoadMoreMessagesProgressBar$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$showLoadMoreMessagesProgressBar$1 r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$showLoadMoreMessagesProgressBar$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$showLoadMoreMessagesProgressBar$1 r2 = new zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$showLoadMoreMessagesProgressBar$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            java.lang.Object r2 = r2.L$0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x004b
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r1)
            r2.L$0 = r0
            r2.label = r5
            r1 = r27
            java.lang.Object r1 = r0.getUpdatedConversation(r1, r2)
            if (r1 != r3) goto L_0x004a
            return r3
        L_0x004a:
            r2 = r0
        L_0x004b:
            zendesk.conversationkit.android.model.Conversation r1 = (zendesk.conversationkit.android.model.Conversation) r1
            kotlinx.coroutines.flow.MutableStateFlow<zendesk.messaging.android.internal.conversationscreen.ConversationScreenState> r3 = r2.conversationScreenStateFlow
            java.lang.Object r3 = r3.getValue()
            r4 = r3
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r4 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenState) r4
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper r3 = r2.messageLogEntryMapper
            zendesk.messaging.android.internal.NewMessagesDividerHandler r9 = r2.newMessagesDividerHandler
            java.lang.String r10 = r1.getId()
            java.time.LocalDateTime r9 = r9.getNewMessageDividerDate(r10)
            kotlinx.coroutines.flow.MutableStateFlow<zendesk.messaging.android.internal.conversationscreen.ConversationScreenState> r2 = r2.conversationScreenStateFlow
            java.lang.Object r2 = r2.getValue()
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenState) r2
            zendesk.messaging.android.internal.model.TypingUser r2 = r2.getTypingUser()
            zendesk.messaging.android.internal.model.LoadMoreStatus r10 = zendesk.messaging.android.internal.model.LoadMoreStatus.LOADING
            java.util.List r9 = r3.map(r1, r9, r2, r10)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            zendesk.messaging.android.internal.model.LoadMoreStatus r22 = zendesk.messaging.android.internal.model.LoadMoreStatus.LOADING
            r23 = 0
            r24 = 393199(0x5ffef, float:5.50989E-40)
            r25 = 0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r1 = zendesk.messaging.android.internal.conversationscreen.ConversationScreenState.copy$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel.showLoadMoreMessagesProgressBar(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object getUpdatedConversation(String str, Continuation<? super Conversation> continuation) {
        Conversation conversation = this.conversationScreenStateFlow.getValue().getConversation();
        return conversation == null ? getRemoteConversation(str, continuation) : conversation;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object hideLoadMoreMessagesProgressBar(java.lang.String r27, kotlin.coroutines.Continuation<? super zendesk.messaging.android.internal.conversationscreen.ConversationScreenState> r28) {
        /*
            r26 = this;
            r0 = r26
            r1 = r28
            boolean r2 = r1 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$hideLoadMoreMessagesProgressBar$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$hideLoadMoreMessagesProgressBar$1 r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$hideLoadMoreMessagesProgressBar$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$hideLoadMoreMessagesProgressBar$1 r2 = new zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$hideLoadMoreMessagesProgressBar$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            java.lang.Object r2 = r2.L$0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x004b
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r1)
            r2.L$0 = r0
            r2.label = r5
            r1 = r27
            java.lang.Object r1 = r0.getUpdatedConversation(r1, r2)
            if (r1 != r3) goto L_0x004a
            return r3
        L_0x004a:
            r2 = r0
        L_0x004b:
            zendesk.conversationkit.android.model.Conversation r1 = (zendesk.conversationkit.android.model.Conversation) r1
            kotlinx.coroutines.flow.MutableStateFlow<zendesk.messaging.android.internal.conversationscreen.ConversationScreenState> r3 = r2.conversationScreenStateFlow
            java.lang.Object r3 = r3.getValue()
            r4 = r3
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r4 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenState) r4
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper r3 = r2.messageLogEntryMapper
            zendesk.messaging.android.internal.NewMessagesDividerHandler r9 = r2.newMessagesDividerHandler
            java.lang.String r10 = r1.getId()
            java.time.LocalDateTime r9 = r9.getNewMessageDividerDate(r10)
            kotlinx.coroutines.flow.MutableStateFlow<zendesk.messaging.android.internal.conversationscreen.ConversationScreenState> r2 = r2.conversationScreenStateFlow
            java.lang.Object r2 = r2.getValue()
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenState) r2
            zendesk.messaging.android.internal.model.TypingUser r2 = r2.getTypingUser()
            zendesk.messaging.android.internal.model.LoadMoreStatus r10 = zendesk.messaging.android.internal.model.LoadMoreStatus.NONE
            java.util.List r9 = r3.map(r1, r9, r2, r10)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 393199(0x5ffef, float:5.50989E-40)
            r25 = 0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r1 = zendesk.messaging.android.internal.conversationscreen.ConversationScreenState.copy$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel.hideLoadMoreMessagesProgressBar(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object failedLoadMoreMessagesProgressBar(java.lang.String r27, kotlin.coroutines.Continuation<? super zendesk.messaging.android.internal.conversationscreen.ConversationScreenState> r28) {
        /*
            r26 = this;
            r0 = r26
            r1 = r28
            boolean r2 = r1 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$failedLoadMoreMessagesProgressBar$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$failedLoadMoreMessagesProgressBar$1 r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$failedLoadMoreMessagesProgressBar$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$failedLoadMoreMessagesProgressBar$1 r2 = new zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$failedLoadMoreMessagesProgressBar$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            java.lang.Object r2 = r2.L$0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x004b
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r1)
            r2.L$0 = r0
            r2.label = r5
            r1 = r27
            java.lang.Object r1 = r0.getUpdatedConversation(r1, r2)
            if (r1 != r3) goto L_0x004a
            return r3
        L_0x004a:
            r2 = r0
        L_0x004b:
            zendesk.conversationkit.android.model.Conversation r1 = (zendesk.conversationkit.android.model.Conversation) r1
            kotlinx.coroutines.flow.MutableStateFlow<zendesk.messaging.android.internal.conversationscreen.ConversationScreenState> r3 = r2.conversationScreenStateFlow
            java.lang.Object r3 = r3.getValue()
            r4 = r3
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r4 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenState) r4
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper r3 = r2.messageLogEntryMapper
            zendesk.messaging.android.internal.NewMessagesDividerHandler r9 = r2.newMessagesDividerHandler
            java.lang.String r10 = r1.getId()
            java.time.LocalDateTime r9 = r9.getNewMessageDividerDate(r10)
            kotlinx.coroutines.flow.MutableStateFlow<zendesk.messaging.android.internal.conversationscreen.ConversationScreenState> r2 = r2.conversationScreenStateFlow
            java.lang.Object r2 = r2.getValue()
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r2 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenState) r2
            zendesk.messaging.android.internal.model.TypingUser r2 = r2.getTypingUser()
            zendesk.messaging.android.internal.model.LoadMoreStatus r10 = zendesk.messaging.android.internal.model.LoadMoreStatus.FAILED
            java.util.List r9 = r3.map(r1, r9, r2, r10)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            zendesk.messaging.android.internal.model.LoadMoreStatus r22 = zendesk.messaging.android.internal.model.LoadMoreStatus.FAILED
            r23 = 0
            r24 = 393199(0x5ffef, float:5.50989E-40)
            r25 = 0
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r1 = zendesk.messaging.android.internal.conversationscreen.ConversationScreenState.copy$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel.failedLoadMoreMessagesProgressBar(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void clearNewMessagesDivider() {
        Conversation conversation = this.conversationScreenStateFlow.getValue().getConversation();
        if (conversation != null) {
            this.newMessagesDividerHandler.clearNewMessageDividerDate(conversation.getId());
        }
    }

    private final void updateNewMessagesDividerDate(ConversationKitEvent.ConversationUpdated conversationUpdated) {
        if (ScreenStateStore.INSTANCE.getCurrentlyVisibleScreen$zendesk_messaging_messaging_android().getValue() == null) {
            this.newMessagesDividerHandler.updateNewMessageDividerDate(conversationUpdated.getConversation());
        }
    }

    public final Object conversationId$zendesk_messaging_messaging_android(Continuation<? super String> continuation) {
        return FlowKt.first(new ConversationScreenViewModel$conversationId$$inlined$mapNotNull$1(this.conversationScreenStateFlow), continuation);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel$Companion;", "", "()V", "HAS_REPLIED_TO_PROACTIVE_MESSAGE", "", "LOG_TAG", "MAP_OF_DISPLAYED_FIELD_VIEWS", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenViewModel.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
