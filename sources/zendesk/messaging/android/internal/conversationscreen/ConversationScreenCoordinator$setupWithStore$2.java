package zendesk.messaging.android.internal.conversationscreen;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import zendesk.android.messaging.model.ColorTheme;
import zendesk.conversationkit.android.ConnectionStatus;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenRendering;
import zendesk.messaging.android.internal.model.LoadMoreStatus;
import zendesk.messaging.android.internal.model.TypingUser;
import zendesk.ui.android.Renderer;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "newState", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenState;", "emit", "(Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$setupWithStore$2<T> implements FlowCollector {
    final /* synthetic */ ConversationScreenViewModel $conversationScreenViewModel;
    final /* synthetic */ ConversationScreenCoordinator this$0;

    ConversationScreenCoordinator$setupWithStore$2(ConversationScreenCoordinator conversationScreenCoordinator, ConversationScreenViewModel conversationScreenViewModel) {
        this.this$0 = conversationScreenCoordinator;
        this.$conversationScreenViewModel = conversationScreenViewModel;
    }

    public final Object emit(final ConversationScreenState conversationScreenState, Continuation<? super Unit> continuation) {
        Renderer access$getConversationScreenRenderer$p = this.this$0.conversationScreenRenderer;
        final ConversationScreenCoordinator conversationScreenCoordinator = this.this$0;
        final ConversationScreenViewModel conversationScreenViewModel = this.$conversationScreenViewModel;
        access$getConversationScreenRenderer$p.render(new Function1<ConversationScreenRendering, ConversationScreenRendering>() {
            public final ConversationScreenRendering invoke(ConversationScreenRendering conversationScreenRendering) {
                Intrinsics.checkNotNullParameter(conversationScreenRendering, "currentRendering");
                Conversation conversation = conversationScreenState.getConversation();
                String id = conversation != null ? conversation.getId() : null;
                ConversationScreenRendering.Builder onRetryLoadMoreClickedListener = conversationScreenRendering.toBuilder().onSendButtonClicked((Function1) conversationScreenCoordinator.onSendButtonClickedProvider.invoke(conversationScreenViewModel, id)).onAttachMenuItemClicked(conversationScreenCoordinator.onAttachMenuItemClicked).onBackButtonClicked(conversationScreenCoordinator.onBackButtonClicked).onFailedMessageClicked((Function1) conversationScreenCoordinator.onFailedMessageClicked.invoke(conversationScreenViewModel, id)).onRetryConnectionButtonClicked((Function0) conversationScreenCoordinator.onRetryConnectionClicked.invoke(conversationScreenViewModel)).onReplyActionSelected((Function1) conversationScreenCoordinator.onReplyActionSelectedProvider.invoke(conversationScreenViewModel, id)).onUriClicked(conversationScreenCoordinator.uriHandler).onFormCompleted((Function2) conversationScreenCoordinator.onFormCompletedProvider.invoke(conversationScreenViewModel, id)).onFormFocusChanged((Function1) conversationScreenCoordinator.onFormFocusChanged.invoke(conversationScreenViewModel)).onFormDisplayedFieldsChanged(conversationScreenCoordinator.onFormDisplayedFieldsChanged).onTyping((Function0) conversationScreenCoordinator.onTyping.invoke(id)).onDeniedPermissionActionClicked(conversationScreenCoordinator.onDeniedPermissionActionClicked).onDeniedPermissionDismissed(conversationScreenCoordinator.onDeniedPermissionDismissed).onMessageComposerTextChanged((Function1) conversationScreenCoordinator.onComposerTextChanged.invoke(conversationScreenViewModel, id)).onLoadMoreMessages((Function1) conversationScreenCoordinator.onLoadMoreMessages.invoke(conversationScreenViewModel, id)).onRetryLoadMoreClickedListener((Function1) conversationScreenCoordinator.onLoadMoreMessages.invoke(conversationScreenViewModel, id));
                final ConversationScreenCoordinator conversationScreenCoordinator = conversationScreenCoordinator;
                final ConversationScreenViewModel conversationScreenViewModel = conversationScreenViewModel;
                final ConversationScreenState conversationScreenState = conversationScreenState;
                return onRetryLoadMoreClickedListener.state(new Function1<ConversationScreenState, ConversationScreenState>() {
                    public final ConversationScreenState invoke(ConversationScreenState conversationScreenState) {
                        Intrinsics.checkNotNullParameter(conversationScreenState, "it");
                        boolean canOpenCameraIntent = conversationScreenCoordinator.attachmentIntents.canOpenCameraIntent();
                        return ConversationScreenState.copy$default(conversationScreenState, (ColorTheme) null, (String) null, (String) null, (String) null, (List) null, (Conversation) null, (Throwable) null, false, 0, (ConnectionStatus) null, conversationScreenCoordinator.attachmentIntents.canOpenAttachmentIntent(), canOpenCameraIntent, (String) null, conversationScreenViewModel.getMapOfDisplayedFields(), (TypingUser) null, (String) null, false, (LoadMoreStatus) null, false, 513023, (Object) null);
                    }
                }).build();
            }
        });
        return Unit.INSTANCE;
    }
}
