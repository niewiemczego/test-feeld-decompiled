package zendesk.messaging.android.internal.conversationscreen;

import android.content.Intent;
import androidx.core.content.ContextCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.Zendesk;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.conversationscreen.di.ImageViewerComponent;
import zendesk.messaging.android.internal.di.MessagingComponent;
import zendesk.messaging.android.internal.extension.ZendeskKtxKt;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.conversation.imagerviewer.ImageViewerView;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ImageViewerActivity$onCreate$1", f = "ImageViewerActivity.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ImageViewerActivity.kt */
final class ImageViewerActivity$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageViewerView $imageViewerView;
    int label;
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageViewerActivity$onCreate$1(ImageViewerActivity imageViewerActivity, ImageViewerView imageViewerView, Continuation<? super ImageViewerActivity$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = imageViewerActivity;
        this.$imageViewerView = imageViewerView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageViewerActivity$onCreate$1(this.this$0, this.$imageViewerView, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ImageViewerActivity$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ImageViewerComponent.Factory imageViewerActivityComponent;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MessagingComponent messagingComponent = ZendeskKtxKt.messagingComponent(Zendesk.Companion);
            if (!(messagingComponent == null || (imageViewerActivityComponent = messagingComponent.imageViewerActivityComponent()) == null)) {
                ImageViewerActivity imageViewerActivity = this.this$0;
                ImageViewerComponent create = imageViewerActivityComponent.create(imageViewerActivity, imageViewerActivity, imageViewerActivity.getIntent().getExtras());
                if (create != null) {
                    create.inject(this.this$0);
                }
            }
            this.label = 1;
            if (this.this$0.setupConversationScreenViewModel(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ImageViewerActivity imageViewerActivity2 = this.this$0;
        Intent intent = this.this$0.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, SDKConstants.PARAM_INTENT);
        String access$getUri = ImageViewerActivityKt.getUri(intent);
        Integer boxInt = Boxing.boxInt(ContextCompat.getColor(this.this$0, R.color.zuia_color_black_38p));
        final ImageViewerActivity imageViewerActivity3 = this.this$0;
        Function0 r3 = new Function0<Unit>() {
            public final void invoke() {
                imageViewerActivity3.onBackPressed();
            }
        };
        Renderer renderer = this.$imageViewerView;
        ConversationScreenViewModel access$getConversationScreenViewModel$p = this.this$0.conversationScreenViewModel;
        if (access$getConversationScreenViewModel$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conversationScreenViewModel");
            access$getConversationScreenViewModel$p = null;
        }
        imageViewerActivity2.imageViewerScreenCoordinator = new ImageViewerScreenCoordinator(access$getUri, boxInt, r3, renderer, access$getConversationScreenViewModel$p);
        return Unit.INSTANCE;
    }
}
