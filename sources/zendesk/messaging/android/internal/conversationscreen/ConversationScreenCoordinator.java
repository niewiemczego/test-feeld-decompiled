package zendesk.messaging.android.internal.conversationscreen;

import android.content.Intent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import zendesk.android.messaging.UrlSource;
import zendesk.conversationkit.android.model.Field;
import zendesk.conversationkit.android.model.MessageAction;
import zendesk.logger.Logger;
import zendesk.messaging.android.internal.AttachmentIntents;
import zendesk.messaging.android.internal.UriHandler;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction;
import zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission;
import zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermissionState;
import zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermissionStateHandler;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.messaging.android.internal.model.UploadFile;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.conversation.form.DisplayedField;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 R2\u00020\u0001:\u0001RBk\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\r\u00100\u001a\u00020\u0007H\u0000¢\u0006\u0002\b1J\u001b\u00102\u001a\u00020\u00072\f\u00103\u001a\b\u0012\u0004\u0012\u0002040\u001fH\u0001¢\u0006\u0002\b5J$\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0013\u0010;\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b<\u0010=J+\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020&2\b\u0010B\u001a\u0004\u0018\u00010CH@ø\u0001\u0000¢\u0006\u0002\u0010DJ5\u0010E\u001a\u00020\u00072\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u001f2\u0006\u0010?\u001a\u00020@2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CH@ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u0015\u0010J\u001a\u00020\u00072\u0006\u0010?\u001a\u00020@H\u0000¢\u0006\u0002\bKJ#\u0010L\u001a\u00020\u00072\u0006\u0010?\u001a\u00020@2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00190\u001fH\u0000¢\u0006\u0002\bNJ\u0010\u0010O\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0019\u0010P\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010QR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R.\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00070\n0\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R2\u0010\u001b\u001a&\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00070\nj\u0002`\u001d0\u0018X\u0004¢\u0006\u0002\n\u0000R>\u0010\u001e\u001a2\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012 \u0012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00070\u0018j\u0002`!0\u0018X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00070\nj\u0002`$X\u0004¢\u0006\u0002\n\u0000R*\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00070\nj\u0002`'0\nX\u0004¢\u0006\u0002\n\u0000R.\u0010(\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00070\n0\u0018X\u0004¢\u0006\u0002\n\u0000R.\u0010*\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00070\n0\u0018X\u0004¢\u0006\u0002\n\u0000R$\u0010,\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`-0\nX\u0004¢\u0006\u0002\n\u0000R.\u0010.\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00070\n0\u0018X\u0004¢\u0006\u0002\n\u0000R\"\u0010/\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006S"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenCoordinator;", "", "conversationScreenRenderer", "Lzendesk/ui/android/Renderer;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenRendering;", "onBackButtonClicked", "Lkotlin/Function0;", "", "onDeniedPermissionActionClicked", "onAttachMenuItemClicked", "Lkotlin/Function1;", "", "uriHandler", "Lzendesk/messaging/android/internal/UriHandler;", "attachmentIntents", "Lzendesk/messaging/android/internal/AttachmentIntents;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "conversationTypingEvents", "Lzendesk/messaging/android/internal/conversationscreen/ConversationTypingEvents;", "conversationScreenViewModel", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;", "(Lzendesk/ui/android/Renderer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lzendesk/messaging/android/internal/UriHandler;Lzendesk/messaging/android/internal/AttachmentIntents;Lkotlinx/coroutines/CoroutineScope;Lzendesk/messaging/android/internal/conversationscreen/ConversationTypingEvents;Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;)V", "onComposerTextChanged", "Lkotlin/Function2;", "", "onDeniedPermissionDismissed", "onFailedMessageClicked", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFailedMessageClickedListener;", "onFormCompletedProvider", "", "Lzendesk/conversationkit/android/model/Field;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormCompleted;", "onFormDisplayedFieldsChanged", "Lzendesk/ui/android/conversation/form/DisplayedField;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormDisplayedFieldsChanged;", "onFormFocusChanged", "", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormFocusChangedListener;", "onLoadMoreMessages", "", "onReplyActionSelectedProvider", "Lzendesk/conversationkit/android/model/MessageAction$Reply;", "onRetryConnectionClicked", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnRetryConnectionClickedListener;", "onSendButtonClickedProvider", "onTyping", "clearNewMessagesDivider", "clearNewMessagesDivider$zendesk_messaging_messaging_android", "dispatchUploadFilesAction", "uploads", "Lzendesk/messaging/android/internal/model/UploadFile;", "dispatchUploadFilesAction$zendesk_messaging_messaging_android", "handleUri", "uri", "urlSource", "Lzendesk/android/messaging/UrlSource;", "launchIntent", "init", "init$zendesk_messaging_messaging_android", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestForActivityResult", "runtimePermission", "Lzendesk/messaging/android/internal/conversationscreen/permissions/RuntimePermission;", "showPermissionDialog", "intent", "Landroid/content/Intent;", "(Lzendesk/messaging/android/internal/conversationscreen/permissions/RuntimePermission;ZLandroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestForMultiplePermissions", "runtimePermissionStates", "Lzendesk/messaging/android/internal/conversationscreen/permissions/RuntimePermissionState;", "requestForMultiplePermissions$zendesk_messaging_messaging_android", "(Ljava/util/List;Lzendesk/messaging/android/internal/conversationscreen/permissions/RuntimePermission;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestImageCapture", "requestImageCapture$zendesk_messaging_messaging_android", "requestRuntimePermissions", "requestedPermissions", "requestRuntimePermissions$zendesk_messaging_messaging_android", "setupScreenEvents", "setupWithStore", "(Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenCoordinator.kt */
public final class ConversationScreenCoordinator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "ConversationScreenCoordinator";
    /* access modifiers changed from: private */
    public final AttachmentIntents attachmentIntents;
    /* access modifiers changed from: private */
    public final Renderer<ConversationScreenRendering> conversationScreenRenderer;
    /* access modifiers changed from: private */
    public final ConversationScreenViewModel conversationScreenViewModel;
    /* access modifiers changed from: private */
    public final ConversationTypingEvents conversationTypingEvents;
    private final CoroutineScope coroutineScope;
    /* access modifiers changed from: private */
    public final Function1<Integer, Unit> onAttachMenuItemClicked;
    /* access modifiers changed from: private */
    public final Function0<Unit> onBackButtonClicked;
    /* access modifiers changed from: private */
    public final Function2<ConversationScreenViewModel, String, Function1<String, Unit>> onComposerTextChanged = ConversationScreenCoordinator$onComposerTextChanged$1.INSTANCE;
    /* access modifiers changed from: private */
    public final Function0<Unit> onDeniedPermissionActionClicked;
    /* access modifiers changed from: private */
    public final Function0<Unit> onDeniedPermissionDismissed = new ConversationScreenCoordinator$onDeniedPermissionDismissed$1(this);
    /* access modifiers changed from: private */
    public final Function2<ConversationScreenViewModel, String, Function1<MessageLogEntry.MessageContainer, Unit>> onFailedMessageClicked = ConversationScreenCoordinator$onFailedMessageClicked$1.INSTANCE;
    /* access modifiers changed from: private */
    public final Function2<ConversationScreenViewModel, String, Function2<List<? extends Field>, MessageLogEntry.MessageContainer, Unit>> onFormCompletedProvider = ConversationScreenCoordinator$onFormCompletedProvider$1.INSTANCE;
    /* access modifiers changed from: private */
    public final Function1<DisplayedField, Unit> onFormDisplayedFieldsChanged = new ConversationScreenCoordinator$onFormDisplayedFieldsChanged$1(this);
    /* access modifiers changed from: private */
    public final Function1<ConversationScreenViewModel, Function1<Boolean, Unit>> onFormFocusChanged = ConversationScreenCoordinator$onFormFocusChanged$1.INSTANCE;
    /* access modifiers changed from: private */
    public final Function2<ConversationScreenViewModel, String, Function1<Double, Unit>> onLoadMoreMessages = ConversationScreenCoordinator$onLoadMoreMessages$1.INSTANCE;
    /* access modifiers changed from: private */
    public final Function2<ConversationScreenViewModel, String, Function1<MessageAction.Reply, Unit>> onReplyActionSelectedProvider = ConversationScreenCoordinator$onReplyActionSelectedProvider$1.INSTANCE;
    /* access modifiers changed from: private */
    public final Function1<ConversationScreenViewModel, Function0<Unit>> onRetryConnectionClicked = ConversationScreenCoordinator$onRetryConnectionClicked$1.INSTANCE;
    /* access modifiers changed from: private */
    public final Function2<ConversationScreenViewModel, String, Function1<String, Unit>> onSendButtonClickedProvider = new ConversationScreenCoordinator$onSendButtonClickedProvider$1(this);
    /* access modifiers changed from: private */
    public final Function1<String, Function0<Unit>> onTyping = new ConversationScreenCoordinator$onTyping$1(this);
    /* access modifiers changed from: private */
    public final UriHandler uriHandler;

    public ConversationScreenCoordinator(Renderer<ConversationScreenRendering> renderer, Function0<Unit> function0, Function0<Unit> function02, Function1<? super Integer, Unit> function1, UriHandler uriHandler2, AttachmentIntents attachmentIntents2, CoroutineScope coroutineScope2, ConversationTypingEvents conversationTypingEvents2, ConversationScreenViewModel conversationScreenViewModel2) {
        Intrinsics.checkNotNullParameter(renderer, "conversationScreenRenderer");
        Intrinsics.checkNotNullParameter(function0, "onBackButtonClicked");
        Intrinsics.checkNotNullParameter(function02, "onDeniedPermissionActionClicked");
        Intrinsics.checkNotNullParameter(function1, "onAttachMenuItemClicked");
        Intrinsics.checkNotNullParameter(uriHandler2, "uriHandler");
        Intrinsics.checkNotNullParameter(attachmentIntents2, "attachmentIntents");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(conversationTypingEvents2, "conversationTypingEvents");
        Intrinsics.checkNotNullParameter(conversationScreenViewModel2, "conversationScreenViewModel");
        this.conversationScreenRenderer = renderer;
        this.onBackButtonClicked = function0;
        this.onDeniedPermissionActionClicked = function02;
        this.onAttachMenuItemClicked = function1;
        this.uriHandler = uriHandler2;
        this.attachmentIntents = attachmentIntents2;
        this.coroutineScope = coroutineScope2;
        this.conversationTypingEvents = conversationTypingEvents2;
        this.conversationScreenViewModel = conversationScreenViewModel2;
    }

    public final Object init$zendesk_messaging_messaging_android(Continuation<? super Unit> continuation) {
        Object obj = setupWithStore(this.conversationScreenViewModel, continuation);
        return obj == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? obj : Unit.INSTANCE;
    }

    public final void requestRuntimePermissions$zendesk_messaging_messaging_android(RuntimePermission runtimePermission, List<String> list) {
        Intrinsics.checkNotNullParameter(runtimePermission, "runtimePermission");
        Intrinsics.checkNotNullParameter(list, "requestedPermissions");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationScreenCoordinator$requestRuntimePermissions$1(runtimePermission, list, this, (Continuation<? super ConversationScreenCoordinator$requestRuntimePermissions$1>) null), 3, (Object) null);
    }

    public static /* synthetic */ Object requestForMultiplePermissions$zendesk_messaging_messaging_android$default(ConversationScreenCoordinator conversationScreenCoordinator, List list, RuntimePermission runtimePermission, Intent intent, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            intent = null;
        }
        return conversationScreenCoordinator.requestForMultiplePermissions$zendesk_messaging_messaging_android(list, runtimePermission, intent, continuation);
    }

    public final Object requestForMultiplePermissions$zendesk_messaging_messaging_android(List<RuntimePermissionState> list, RuntimePermission runtimePermission, Intent intent, Continuation<? super Unit> continuation) {
        Object requestForActivityResult = requestForActivityResult(runtimePermission, RuntimePermissionStateHandler.INSTANCE.shouldShowRuntimePermissionRational$zendesk_messaging_messaging_android(list), intent, continuation);
        return requestForActivityResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? requestForActivityResult : Unit.INSTANCE;
    }

    public final void requestImageCapture$zendesk_messaging_messaging_android(RuntimePermission runtimePermission) {
        Intrinsics.checkNotNullParameter(runtimePermission, "runtimePermission");
        if (this.attachmentIntents.shouldAskForCameraPermission()) {
            requestRuntimePermissions$zendesk_messaging_messaging_android(runtimePermission, CollectionsKt.listOf("android.permission.CAMERA"));
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationScreenCoordinator$requestImageCapture$1(this, runtimePermission, (Continuation<? super ConversationScreenCoordinator$requestImageCapture$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final Object requestForActivityResult(RuntimePermission runtimePermission, boolean z, Intent intent, Continuation<? super Unit> continuation) {
        if (z) {
            this.conversationScreenViewModel.dispatchAction(ConversationScreenAction.ShowDeniedPermission.INSTANCE);
        } else {
            this.conversationScreenViewModel.dispatchAction(ConversationScreenAction.HideDeniedPermission.INSTANCE);
            if (intent == null) {
                runtimePermission.cancel$zendesk_messaging_messaging_android();
            } else {
                Object collect = runtimePermission.requestForActivityResult$zendesk_messaging_messaging_android(intent).collect(new ConversationScreenCoordinator$requestForActivityResult$2(this, runtimePermission), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    public final void handleUri(String str, UrlSource urlSource, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "uri");
        Intrinsics.checkNotNullParameter(urlSource, "urlSource");
        Intrinsics.checkNotNullParameter(function0, "launchIntent");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationScreenCoordinator$handleUri$1(str, function0, urlSource, (Continuation<? super ConversationScreenCoordinator$handleUri$1>) null), 3, (Object) null);
    }

    public final void dispatchUploadFilesAction$zendesk_messaging_messaging_android(List<UploadFile> list) {
        Intrinsics.checkNotNullParameter(list, "uploads");
        Logger.i(LOG_TAG, "Sending conversation upload file event", new Object[0]);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationScreenCoordinator$dispatchUploadFilesAction$1(list, this, (Continuation<? super ConversationScreenCoordinator$dispatchUploadFilesAction$1>) null), 3, (Object) null);
    }

    public final void clearNewMessagesDivider$zendesk_messaging_messaging_android() {
        this.conversationScreenViewModel.clearNewMessagesDivider();
    }

    /* access modifiers changed from: private */
    public final Object setupWithStore(ConversationScreenViewModel conversationScreenViewModel2, Continuation<? super Unit> continuation) {
        Logger.i(LOG_TAG, "Listening to Conversation Screen updates.", new Object[0]);
        setupScreenEvents(conversationScreenViewModel2);
        Object collect = conversationScreenViewModel2.conversationScreenState().collect(new ConversationScreenCoordinator$setupWithStore$2(this, conversationScreenViewModel2), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    private final void setupScreenEvents(ConversationScreenViewModel conversationScreenViewModel2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationScreenCoordinator$setupScreenEvents$1(conversationScreenViewModel2, this, (Continuation<? super ConversationScreenCoordinator$setupScreenEvents$1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenCoordinator$Companion;", "", "()V", "LOG_TAG", "", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenCoordinator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
