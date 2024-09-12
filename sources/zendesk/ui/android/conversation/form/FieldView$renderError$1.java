package zendesk.ui.android.conversation.form;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.conversation.receipt.MessageReceiptPosition;
import zendesk.ui.android.conversation.receipt.MessageReceiptRendering;
import zendesk.ui.android.conversation.receipt.MessageReceiptState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/receipt/MessageReceiptRendering;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldView.kt */
final class FieldView$renderError$1 extends Lambda implements Function1<MessageReceiptRendering, MessageReceiptRendering> {
    final /* synthetic */ String $error;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FieldView$renderError$1(String str) {
        super(1);
        this.$error = str;
    }

    public final MessageReceiptRendering invoke(MessageReceiptRendering messageReceiptRendering) {
        Intrinsics.checkNotNullParameter(messageReceiptRendering, "it");
        MessageReceiptRendering.Builder builder = new MessageReceiptRendering.Builder();
        final String str = this.$error;
        return builder.state(new Function1<MessageReceiptState, MessageReceiptState>() {
            public final MessageReceiptState invoke(MessageReceiptState messageReceiptState) {
                Intrinsics.checkNotNullParameter(messageReceiptState, "it");
                return new MessageReceiptState.Builder().label(str).messageReceiptPosition(MessageReceiptPosition.INBOUND_FAILED).build();
            }
        }).build();
    }
}
