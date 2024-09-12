package zendesk.ui.android.conversation.form;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormView.kt */
final class FormView$addFieldView$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $nextIndex;
    final /* synthetic */ int $numberOfFields;
    final /* synthetic */ FormView<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FormView$addFieldView$3(FormView<T> formView, int i, int i2) {
        super(0);
        this.this$0 = formView;
        this.$nextIndex = i;
        this.$numberOfFields = i2;
    }

    public final void invoke() {
        FormView<T> formView = this.this$0;
        int i = this.$nextIndex;
        final FormView<T> formView2 = this.this$0;
        final int i2 = this.$nextIndex;
        final int i3 = this.$numberOfFields;
        formView.displayNextFieldView(i, new Function0<Unit>() {
            public final void invoke() {
                FormView.addFieldView$default(formView2, i2, (DisplayedField) null, i3, 2, (Object) null);
            }
        });
    }
}
