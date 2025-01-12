package zendesk.ui.android.conversation.textcell;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextCellRendering.kt */
final class TextCellRendering$Builder$onActionButtonClicked$1 extends Lambda implements Function2<String, String, Unit> {
    public static final TextCellRendering$Builder$onActionButtonClicked$1 INSTANCE = new TextCellRendering$Builder$onActionButtonClicked$1();

    TextCellRendering$Builder$onActionButtonClicked$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 1>");
        Logger.w("TextCellRendering", "TextCellRendering#onActionButtonClicked == null", new Object[0]);
    }
}
