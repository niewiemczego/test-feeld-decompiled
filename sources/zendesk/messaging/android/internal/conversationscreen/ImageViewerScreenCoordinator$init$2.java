package zendesk.messaging.android.internal.conversationscreen;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import zendesk.android.messaging.model.ColorTheme;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.conversation.imagerviewer.ImageViewerRendering;
import zendesk.ui.android.conversation.imagerviewer.ImageViewerState;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "newState", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenState;", "emit", "(Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageViewerScreenCoordinator.kt */
final class ImageViewerScreenCoordinator$init$2<T> implements FlowCollector {
    final /* synthetic */ ImageViewerScreenCoordinator this$0;

    ImageViewerScreenCoordinator$init$2(ImageViewerScreenCoordinator imageViewerScreenCoordinator) {
        this.this$0 = imageViewerScreenCoordinator;
    }

    public final Object emit(final ConversationScreenState conversationScreenState, Continuation<? super Unit> continuation) {
        Renderer access$getImageViewerRenderer$p = this.this$0.imageViewerRenderer;
        final ImageViewerScreenCoordinator imageViewerScreenCoordinator = this.this$0;
        access$getImageViewerRenderer$p.render(new Function1<ImageViewerRendering, ImageViewerRendering>() {
            public final ImageViewerRendering invoke(ImageViewerRendering imageViewerRendering) {
                Intrinsics.checkNotNullParameter(imageViewerRendering, "currentRendering");
                ImageViewerRendering.Builder builder = imageViewerRendering.toBuilder();
                final ImageViewerScreenCoordinator imageViewerScreenCoordinator = imageViewerScreenCoordinator;
                final ConversationScreenState conversationScreenState = conversationScreenState;
                ImageViewerRendering.Builder state = builder.state(new Function1<ImageViewerState, ImageViewerState>() {
                    public final ImageViewerState invoke(ImageViewerState imageViewerState) {
                        Intrinsics.checkNotNullParameter(imageViewerState, "imageViewerState");
                        String access$getImageUri$p = imageViewerScreenCoordinator.imageUri;
                        Integer access$getToolbarColor$p = imageViewerScreenCoordinator.toolbarColor;
                        ColorTheme colorTheme = conversationScreenState.getColorTheme();
                        return ImageViewerState.copy$default(imageViewerState, access$getImageUri$p, (String) null, (String) null, (Uri) null, access$getToolbarColor$p, colorTheme != null ? colorTheme.toColorInt(colorTheme.getPrimaryColor()) : null, 14, (Object) null);
                    }
                });
                final ImageViewerScreenCoordinator imageViewerScreenCoordinator2 = imageViewerScreenCoordinator;
                return state.onBackButtonClicked(new Function0<Unit>() {
                    public final void invoke() {
                        imageViewerScreenCoordinator2.onBackButtonClicked.invoke();
                    }
                }).build();
            }
        });
        return Unit.INSTANCE;
    }
}
