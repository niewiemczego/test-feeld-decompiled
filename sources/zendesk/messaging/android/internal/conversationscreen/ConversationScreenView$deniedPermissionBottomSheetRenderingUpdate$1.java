package zendesk.messaging.android.internal.conversationscreen;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.messaging.R;
import zendesk.ui.android.conversation.bottomsheet.BottomSheetRendering;
import zendesk.ui.android.conversation.bottomsheet.BottomSheetState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/bottomsheet/BottomSheetRendering;", "bottomSheetRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenView.kt */
final class ConversationScreenView$deniedPermissionBottomSheetRenderingUpdate$1 extends Lambda implements Function1<BottomSheetRendering, BottomSheetRendering> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ConversationScreenView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenView$deniedPermissionBottomSheetRenderingUpdate$1(ConversationScreenView conversationScreenView, Context context) {
        super(1);
        this.this$0 = conversationScreenView;
        this.$context = context;
    }

    public final BottomSheetRendering invoke(BottomSheetRendering bottomSheetRendering) {
        Intrinsics.checkNotNullParameter(bottomSheetRendering, "bottomSheetRendering");
        BottomSheetRendering.Builder onBottomSheetDismissed = bottomSheetRendering.toBuilder().onBottomSheetActionClicked(this.this$0.rendering.getOnDeniedPermissionActionClicked$zendesk_messaging_messaging_android()).onBottomSheetDismissed(this.this$0.rendering.getOnDeniedPermissionDismissed$zendesk_messaging_messaging_android());
        final Context context = this.$context;
        final ConversationScreenView conversationScreenView = this.this$0;
        return onBottomSheetDismissed.state(new Function1<BottomSheetState, BottomSheetState>() {
            public final BottomSheetState invoke(BottomSheetState bottomSheetState) {
                Intrinsics.checkNotNullParameter(bottomSheetState, "state");
                String string = context.getString(R.string.zuia_attachment_permissions_rationale);
                String string2 = context.getString(R.string.zuia_settings);
                int color = ContextCompat.getColor(context, R.color.zma_color_primary);
                int color2 = ContextCompat.getColor(context, R.color.zma_color_on_primary);
                int color3 = ContextCompat.getColor(context, R.color.zma_color_action);
                boolean showDeniedPermission = conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getShowDeniedPermission();
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.zuia_…nt_permissions_rationale)");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.zuia_settings)");
                return BottomSheetState.copy$default(bottomSheetState, string, string2, 0, showDeniedPermission, Integer.valueOf(color), Integer.valueOf(color2), Integer.valueOf(color3), 4, (Object) null);
            }
        }).build();
    }
}
