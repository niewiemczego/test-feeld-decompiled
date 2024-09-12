package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.conversation.imagerviewer.ImageViewerRendering;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ImageViewerScreenCoordinator;", "", "imageUri", "", "toolbarColor", "", "onBackButtonClicked", "Lkotlin/Function0;", "", "imageViewerRenderer", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/imagerviewer/ImageViewerRendering;", "conversationScreenViewModel", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Lzendesk/ui/android/Renderer;Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;)V", "Ljava/lang/Integer;", "init", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageViewerScreenCoordinator.kt */
public final class ImageViewerScreenCoordinator {
    private final ConversationScreenViewModel conversationScreenViewModel;
    /* access modifiers changed from: private */
    public final String imageUri;
    /* access modifiers changed from: private */
    public final Renderer<ImageViewerRendering> imageViewerRenderer;
    /* access modifiers changed from: private */
    public final Function0<Unit> onBackButtonClicked;
    /* access modifiers changed from: private */
    public final Integer toolbarColor;

    public ImageViewerScreenCoordinator(String str, Integer num, Function0<Unit> function0, Renderer<ImageViewerRendering> renderer, ConversationScreenViewModel conversationScreenViewModel2) {
        Intrinsics.checkNotNullParameter(str, "imageUri");
        Intrinsics.checkNotNullParameter(function0, "onBackButtonClicked");
        Intrinsics.checkNotNullParameter(renderer, "imageViewerRenderer");
        Intrinsics.checkNotNullParameter(conversationScreenViewModel2, "conversationScreenViewModel");
        this.imageUri = str;
        this.toolbarColor = num;
        this.onBackButtonClicked = function0;
        this.imageViewerRenderer = renderer;
        this.conversationScreenViewModel = conversationScreenViewModel2;
    }

    public final Object init(Continuation<? super Unit> continuation) {
        Object collect = this.conversationScreenViewModel.conversationScreenState().collect(new ImageViewerScreenCoordinator$init$2(this), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }
}
