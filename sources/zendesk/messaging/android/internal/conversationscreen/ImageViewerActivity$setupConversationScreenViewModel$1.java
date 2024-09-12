package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ImageViewerActivity", f = "ImageViewerActivity.kt", i = {0}, l = {100}, m = "setupConversationScreenViewModel", n = {"this"}, s = {"L$0"})
/* compiled from: ImageViewerActivity.kt */
final class ImageViewerActivity$setupConversationScreenViewModel$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageViewerActivity$setupConversationScreenViewModel$1(ImageViewerActivity imageViewerActivity, Continuation<? super ImageViewerActivity$setupConversationScreenViewModel$1> continuation) {
        super(continuation);
        this.this$0 = imageViewerActivity;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setupConversationScreenViewModel(this);
    }
}
