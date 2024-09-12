package zendesk.ui.android.conversation.receipt;

import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/LinearLayout;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageReceiptView.kt */
final class MessageReceiptView$buildLabelAndIconViews$1 extends Lambda implements Function1<LinearLayout, Unit> {
    final /* synthetic */ MessageReceiptView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageReceiptView$buildLabelAndIconViews$1(MessageReceiptView messageReceiptView) {
        super(1);
        this.this$0 = messageReceiptView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LinearLayout) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "$this$formatIconView");
        if (this.this$0.rendering.getState$zendesk_ui_ui_android().getShowIcon$zendesk_ui_ui_android()) {
            linearLayout.addView(this.this$0.iconImage);
        }
        linearLayout.addView(this.this$0.labelText);
    }
}
