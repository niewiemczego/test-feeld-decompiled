package zendesk.ui.android.conversation.form;

import android.view.KeyEvent;
import android.widget.TextView;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FormView$$ExternalSyntheticLambda1 implements TextView.OnEditorActionListener {
    public final /* synthetic */ FormView f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ FormView$$ExternalSyntheticLambda1(FormView formView, Function0 function0) {
        this.f$0 = formView;
        this.f$1 = function0;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return FormView.m2790nextActionButtonClicked$lambda6$lambda5(this.f$0, this.f$1, textView, i, keyEvent);
    }
}
