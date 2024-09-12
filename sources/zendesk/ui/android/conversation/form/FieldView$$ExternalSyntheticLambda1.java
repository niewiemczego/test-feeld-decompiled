package zendesk.ui.android.conversation.form;

import android.view.View;
import zendesk.ui.android.conversation.form.FieldRendering;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FieldView$$ExternalSyntheticLambda1 implements View.OnFocusChangeListener {
    public final /* synthetic */ FieldRendering.Email f$0;
    public final /* synthetic */ FieldView f$1;

    public /* synthetic */ FieldView$$ExternalSyntheticLambda1(FieldRendering.Email email, FieldView fieldView) {
        this.f$0 = email;
        this.f$1 = fieldView;
    }

    public final void onFocusChange(View view, boolean z) {
        FieldView.m2783renderFormField$lambda14(this.f$0, this.f$1, view, z);
    }
}
