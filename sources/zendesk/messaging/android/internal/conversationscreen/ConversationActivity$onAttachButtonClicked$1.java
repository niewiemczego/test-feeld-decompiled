package zendesk.messaging.android.internal.conversationscreen;

import android.os.Build;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.R;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "menuId", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationActivity.kt */
final class ConversationActivity$onAttachButtonClicked$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationActivity$onAttachButtonClicked$1(ConversationActivity conversationActivity) {
        super(1);
        this.this$0 = conversationActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ConversationScreenCoordinator conversationScreenCoordinator = null;
        if (i == R.id.menu_item_camera) {
            ConversationScreenCoordinator access$getConversationScreenCoordinator$p = this.this$0.conversationScreenCoordinator;
            if (access$getConversationScreenCoordinator$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("conversationScreenCoordinator");
            } else {
                conversationScreenCoordinator = access$getConversationScreenCoordinator$p;
            }
            conversationScreenCoordinator.requestImageCapture$zendesk_messaging_messaging_android(this.this$0.runtimePermission);
        } else if (i != R.id.menu_item_gallery) {
        } else {
            if (Build.VERSION.SDK_INT <= 32) {
                ConversationScreenCoordinator access$getConversationScreenCoordinator$p2 = this.this$0.conversationScreenCoordinator;
                if (access$getConversationScreenCoordinator$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("conversationScreenCoordinator");
                } else {
                    conversationScreenCoordinator = access$getConversationScreenCoordinator$p2;
                }
                conversationScreenCoordinator.requestRuntimePermissions$zendesk_messaging_messaging_android(this.this$0.runtimePermission, CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE"));
                return;
            }
            ConversationScreenCoordinator access$getConversationScreenCoordinator$p3 = this.this$0.conversationScreenCoordinator;
            if (access$getConversationScreenCoordinator$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("conversationScreenCoordinator");
            } else {
                conversationScreenCoordinator = access$getConversationScreenCoordinator$p3;
            }
            conversationScreenCoordinator.requestRuntimePermissions$zendesk_messaging_messaging_android(this.this$0.runtimePermission, CollectionsKt.listOf("android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_AUDIO"));
        }
    }
}
