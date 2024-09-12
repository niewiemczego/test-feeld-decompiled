package zendesk.ui.android.conversation.item;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ItemView.kt */
final class ItemView$render$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ItemView$render$2(ItemView itemView) {
        super(0);
        this.this$0 = itemView;
    }

    public final void invoke() {
        Function1<Item<?>, Unit> onItemClicked$zendesk_ui_ui_android = this.this$0.rendering.getOnItemClicked$zendesk_ui_ui_android();
        if (onItemClicked$zendesk_ui_ui_android != null) {
            onItemClicked$zendesk_ui_ui_android.invoke(this.this$0.rendering.getState$zendesk_ui_ui_android().getItem$zendesk_ui_ui_android());
        }
    }
}
