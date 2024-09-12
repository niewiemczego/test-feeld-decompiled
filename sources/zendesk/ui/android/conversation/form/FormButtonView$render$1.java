package zendesk.ui.android.conversation.form;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormButtonView.kt */
final class FormButtonView$render$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FormButtonView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FormButtonView$render$1(FormButtonView formButtonView) {
        super(0);
        this.this$0 = formButtonView;
    }

    public final void invoke() {
        this.this$0.rendering.getOnButtonClicked$zendesk_ui_ui_android().invoke();
    }
}
