package zendesk.ui.android.conversation.actionbutton;

import android.webkit.URLUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActionButtonView.kt */
final class ActionButtonView$render$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ActionButtonView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionButtonView$render$3(ActionButtonView actionButtonView) {
        super(0);
        this.this$0 = actionButtonView;
    }

    public final void invoke() {
        ActionButtonState state$zendesk_ui_ui_android = this.this$0.rendering.getState$zendesk_ui_ui_android();
        ActionButtonView actionButtonView = this.this$0;
        CharSequence uri$zendesk_ui_ui_android = state$zendesk_ui_ui_android.getUri$zendesk_ui_ui_android();
        if (!(uri$zendesk_ui_ui_android == null || uri$zendesk_ui_ui_android.length() == 0) && state$zendesk_ui_ui_android.getUrlSource$zendesk_ui_ui_android() != null && URLUtil.isValidUrl(state$zendesk_ui_ui_android.getUri$zendesk_ui_ui_android())) {
            actionButtonView.rendering.getOnActionButtonClicked$zendesk_ui_ui_android().invoke(state$zendesk_ui_ui_android.getUri$zendesk_ui_ui_android(), state$zendesk_ui_ui_android.getUrlSource$zendesk_ui_ui_android());
        }
    }
}
