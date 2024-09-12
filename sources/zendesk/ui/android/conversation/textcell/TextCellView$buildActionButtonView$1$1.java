package zendesk.ui.android.conversation.textcell;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.R;
import zendesk.ui.android.conversation.actionbutton.ActionButton;
import zendesk.ui.android.conversation.actionbutton.ActionButtonRendering;
import zendesk.ui.android.conversation.actionbutton.ActionButtonState;
import zendesk.ui.android.conversation.actionbutton.ActionButtonView;
import zendesk.ui.android.internal.ColorExtKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/actionbutton/ActionButtonRendering;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextCellView.kt */
final class TextCellView$buildActionButtonView$1$1 extends Lambda implements Function1<ActionButtonRendering, ActionButtonRendering> {
    final /* synthetic */ ActionButton $actionButton;
    final /* synthetic */ ActionButtonView $this_apply;
    final /* synthetic */ TextCellView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextCellView$buildActionButtonView$1$1(TextCellView textCellView, ActionButton actionButton, ActionButtonView actionButtonView) {
        super(1);
        this.this$0 = textCellView;
        this.$actionButton = actionButton;
        this.$this_apply = actionButtonView;
    }

    public final ActionButtonRendering invoke(ActionButtonRendering actionButtonRendering) {
        Intrinsics.checkNotNullParameter(actionButtonRendering, "it");
        ActionButtonRendering.Builder builder = actionButtonRendering.toBuilder();
        final ActionButton actionButton = this.$actionButton;
        final ActionButtonView actionButtonView = this.$this_apply;
        final TextCellView textCellView = this.this$0;
        return builder.state(new Function1<ActionButtonState, ActionButtonState>() {
            public final ActionButtonState invoke(ActionButtonState actionButtonState) {
                int i;
                int i2;
                Intrinsics.checkNotNullParameter(actionButtonState, "state");
                String text = actionButton.getText();
                if (actionButton.isSupported()) {
                    i = ContextCompat.getColor(actionButtonView.getContext(), R.color.zuia_color_white);
                } else {
                    i = ColorExtKt.adjustAlpha(ContextCompat.getColor(actionButtonView.getContext(), R.color.zuia_color_black), 0.35f);
                }
                if (actionButton.isSupported()) {
                    Integer actionColor$zendesk_ui_ui_android = textCellView.rendering.getState$zendesk_ui_ui_android().getActionColor$zendesk_ui_ui_android();
                    if (actionColor$zendesk_ui_ui_android != null) {
                        i2 = actionColor$zendesk_ui_ui_android.intValue();
                    } else {
                        Context context = actionButtonView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        i2 = ColorExtKt.resolveColorAttr(context, R.attr.colorAccent);
                    }
                } else {
                    i2 = ContextCompat.getColor(actionButtonView.getContext(), R.color.zuia_color_gray_light);
                }
                return actionButtonState.copy(text, actionButton.getUri(), actionButton.isSupported(), actionButton.getUrlSource(), Integer.valueOf(i2), Integer.valueOf(i));
            }
        }).onActionButtonClicked(this.this$0.rendering.getOnActionButtonClicked$zendesk_ui_ui_android()).build();
    }
}
