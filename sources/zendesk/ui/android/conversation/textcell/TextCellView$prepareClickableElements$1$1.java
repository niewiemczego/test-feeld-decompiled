package zendesk.ui.android.conversation.textcell;

import android.text.style.URLSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"zendesk/ui/android/conversation/textcell/TextCellView$prepareClickableElements$1$1", "Landroid/text/style/URLSpan;", "onClick", "", "widget", "Landroid/view/View;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextCellView.kt */
public final class TextCellView$prepareClickableElements$1$1 extends URLSpan {
    final /* synthetic */ TextCellView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextCellView$prepareClickableElements$1$1(TextCellView textCellView, String str) {
        super(str);
        this.this$0 = textCellView;
    }

    public void onClick(View view) {
        Unit unit;
        Intrinsics.checkNotNullParameter(view, "widget");
        Function1<String, Unit> onCellTextClicked$zendesk_ui_ui_android = this.this$0.rendering.getOnCellTextClicked$zendesk_ui_ui_android();
        if (onCellTextClicked$zendesk_ui_ui_android != null) {
            String url = getURL();
            Intrinsics.checkNotNullExpressionValue(url, "url");
            onCellTextClicked$zendesk_ui_ui_android.invoke(url);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.onClick(view);
        }
    }
}
