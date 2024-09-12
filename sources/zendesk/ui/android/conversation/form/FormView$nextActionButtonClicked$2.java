package zendesk.ui.android.conversation.form;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.conversation.form.FormButtonRendering;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/form/FormButtonRendering;", "T", "formButtonRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormView.kt */
final class FormView$nextActionButtonClicked$2 extends Lambda implements Function1<FormButtonRendering, FormButtonRendering> {
    final /* synthetic */ Function0<Unit> $progressToNextFieldView;
    final /* synthetic */ FormView<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FormView$nextActionButtonClicked$2(FormView<T> formView, Function0<Unit> function0) {
        super(1);
        this.this$0 = formView;
        this.$progressToNextFieldView = function0;
    }

    public final FormButtonRendering invoke(FormButtonRendering formButtonRendering) {
        Intrinsics.checkNotNullParameter(formButtonRendering, "formButtonRendering");
        FormButtonRendering.Builder builder = formButtonRendering.toBuilder();
        final FormView<T> formView = this.this$0;
        final Function0<Unit> function0 = this.$progressToNextFieldView;
        return builder.onButtonClicked(new Function0<Unit>() {
            public final void invoke() {
                if (formView.arePreviousFieldsValid()) {
                    function0.invoke();
                }
                FormView<T> formView = formView;
                formView.requestViewFocus((FieldView) CollectionsKt.last(formView.fieldViews));
            }
        }).build();
    }
}
