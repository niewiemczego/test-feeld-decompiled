package zendesk.ui.android.conversation.form;

import android.view.KeyEvent;
import android.widget.TextView;
import zendesk.ui.android.conversation.form.FieldRendering;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FieldView$$ExternalSyntheticLambda4 implements TextView.OnEditorActionListener {
    public final /* synthetic */ FieldView f$0;
    public final /* synthetic */ FieldInputArrayAdapter f$1;
    public final /* synthetic */ FieldRendering.Select f$2;

    public /* synthetic */ FieldView$$ExternalSyntheticLambda4(FieldView fieldView, FieldInputArrayAdapter fieldInputArrayAdapter, FieldRendering.Select select) {
        this.f$0 = fieldView;
        this.f$1 = fieldInputArrayAdapter;
        this.f$2 = select;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return FieldView.m2786renderFormField$lambda6(this.f$0, this.f$1, this.f$2, textView, i, keyEvent);
    }
}
