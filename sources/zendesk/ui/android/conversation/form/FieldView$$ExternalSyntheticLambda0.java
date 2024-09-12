package zendesk.ui.android.conversation.form;

import android.view.View;
import zendesk.ui.android.conversation.form.FieldRendering;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FieldView$$ExternalSyntheticLambda0 implements View.OnFocusChangeListener {
    public final /* synthetic */ FieldRendering.Text f$0;
    public final /* synthetic */ FieldView f$1;

    public /* synthetic */ FieldView$$ExternalSyntheticLambda0(FieldRendering.Text text, FieldView fieldView) {
        this.f$0 = text;
        this.f$1 = fieldView;
    }

    public final void onFocusChange(View view, boolean z) {
        FieldView.m2782renderFormField$lambda11(this.f$0, this.f$1, view, z);
    }
}
