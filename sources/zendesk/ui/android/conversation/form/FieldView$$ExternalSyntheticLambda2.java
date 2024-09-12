package zendesk.ui.android.conversation.form;

import android.view.View;
import android.widget.AdapterView;
import zendesk.ui.android.conversation.form.FieldRendering;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FieldView$$ExternalSyntheticLambda2 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ FieldInputArrayAdapter f$0;
    public final /* synthetic */ FieldView f$1;
    public final /* synthetic */ FieldRendering.Select f$2;

    public /* synthetic */ FieldView$$ExternalSyntheticLambda2(FieldInputArrayAdapter fieldInputArrayAdapter, FieldView fieldView, FieldRendering.Select select) {
        this.f$0 = fieldInputArrayAdapter;
        this.f$1 = fieldView;
        this.f$2 = select;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        FieldView.m2784renderFormField$lambda4(this.f$0, this.f$1, this.f$2, adapterView, view, i, j);
    }
}
