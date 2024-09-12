package zendesk.ui.android.conversation.quickreply;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuickReplyOptionView.kt */
final class QuickReplyOptionView$render$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ QuickReplyOptionView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuickReplyOptionView$render$1(QuickReplyOptionView quickReplyOptionView) {
        super(0);
        this.this$0 = quickReplyOptionView;
    }

    public final void invoke() {
        Function2<String, String, Unit> onOptionClicked$zendesk_ui_ui_android = this.this$0.rendering.getOnOptionClicked$zendesk_ui_ui_android();
        if (onOptionClicked$zendesk_ui_ui_android != null) {
            QuickReplyOptionView quickReplyOptionView = this.this$0;
            onOptionClicked$zendesk_ui_ui_android.invoke(quickReplyOptionView.rendering.getState$zendesk_ui_ui_android().getId$zendesk_ui_ui_android(), quickReplyOptionView.rendering.getState$zendesk_ui_ui_android().getText$zendesk_ui_ui_android());
            quickReplyOptionView.setSelected(true);
            quickReplyOptionView.render(QuickReplyOptionView$render$1$1$1.INSTANCE);
        }
    }
}
