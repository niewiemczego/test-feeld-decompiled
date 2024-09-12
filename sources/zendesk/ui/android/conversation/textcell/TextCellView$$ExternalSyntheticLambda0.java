package zendesk.ui.android.conversation.textcell;

import android.view.View;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TextCellView$$ExternalSyntheticLambda0 implements View.OnFocusChangeListener {
    public final /* synthetic */ TextCellView f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ TextCellView$$ExternalSyntheticLambda0(TextCellView textCellView, int i) {
        this.f$0 = textCellView;
        this.f$1 = i;
    }

    public final void onFocusChange(View view, boolean z) {
        TextCellView.m2807updateFocusedBackgroundState$lambda6(this.f$0, this.f$1, view, z);
    }
}
