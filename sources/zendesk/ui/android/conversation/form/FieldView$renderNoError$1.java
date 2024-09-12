package zendesk.ui.android.conversation.form;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.conversation.receipt.MessageReceiptRendering;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/receipt/MessageReceiptRendering;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldView.kt */
final class FieldView$renderNoError$1 extends Lambda implements Function1<MessageReceiptRendering, MessageReceiptRendering> {
    public static final FieldView$renderNoError$1 INSTANCE = new FieldView$renderNoError$1();

    FieldView$renderNoError$1() {
        super(1);
    }

    public final MessageReceiptRendering invoke(MessageReceiptRendering messageReceiptRendering) {
        Intrinsics.checkNotNullParameter(messageReceiptRendering, "it");
        return new MessageReceiptRendering.Builder().build();
    }
}
