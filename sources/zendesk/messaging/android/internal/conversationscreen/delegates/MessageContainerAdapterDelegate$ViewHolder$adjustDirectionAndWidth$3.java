package zendesk.messaging.android.internal.conversationscreen.delegates;

import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.messaging.android.internal.model.MessageDirection;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/LinearLayout$LayoutParams;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageContainerAdapterDelegate.kt */
final class MessageContainerAdapterDelegate$ViewHolder$adjustDirectionAndWidth$3 extends Lambda implements Function1<LinearLayout.LayoutParams, Unit> {
    final /* synthetic */ MessageDirection $direction;
    final /* synthetic */ int $inboundMarginEnd;
    final /* synthetic */ int $outboundMarginEnd;
    final /* synthetic */ int $spacingSmall;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageContainerAdapterDelegate$ViewHolder$adjustDirectionAndWidth$3(MessageDirection messageDirection, int i, int i2, int i3) {
        super(1);
        this.$direction = messageDirection;
        this.$inboundMarginEnd = i;
        this.$outboundMarginEnd = i2;
        this.$spacingSmall = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LinearLayout.LayoutParams) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LinearLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "$this$wrap");
        if (this.$direction == MessageDirection.INBOUND) {
            layoutParams.setMarginEnd(this.$inboundMarginEnd);
            return;
        }
        layoutParams.setMarginStart(this.$outboundMarginEnd);
        layoutParams.setMarginEnd(this.$spacingSmall);
    }
}
