package zendesk.ui.android.conversation.form;

import android.view.View;
import zendesk.ui.android.conversation.form.FieldRendering;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FieldView$$ExternalSyntheticLambda3 implements View.OnFocusChangeListener {
    public final /* synthetic */ FieldRendering.Select f$0;
    public final /* synthetic */ FieldView f$1;
    public final /* synthetic */ FieldInputArrayAdapter f$2;

    public /* synthetic */ FieldView$$ExternalSyntheticLambda3(FieldRendering.Select select, FieldView fieldView, FieldInputArrayAdapter fieldInputArrayAdapter) {
        this.f$0 = select;
        this.f$1 = fieldView;
        this.f$2 = fieldInputArrayAdapter;
    }

    public final void onFocusChange(View view, boolean z) {
        FieldView.m2785renderFormField$lambda5(this.f$0, this.f$1, this.f$2, view, z);
    }
}
