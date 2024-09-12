package zendesk.ui.android.conversation.form;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.R;
import zendesk.ui.android.conversation.form.FormButtonRendering;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/form/FormButtonRendering;", "T", "formButtonRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormView.kt */
final class FormView$render$1 extends Lambda implements Function1<FormButtonRendering, FormButtonRendering> {
    final /* synthetic */ FormView<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FormView$render$1(FormView<T> formView) {
        super(1);
        this.this$0 = formView;
    }

    public final FormButtonRendering invoke(FormButtonRendering formButtonRendering) {
        Intrinsics.checkNotNullParameter(formButtonRendering, "formButtonRendering");
        FormButtonRendering.Builder builder = formButtonRendering.toBuilder();
        final FormView<T> formView = this.this$0;
        return builder.state(new Function1<FormButtonState, FormButtonState>() {
            public final FormButtonState invoke(FormButtonState formButtonState) {
                Intrinsics.checkNotNullParameter(formButtonState, "state");
                boolean pending$zendesk_ui_ui_android = formView.rendering.getState$zendesk_ui_ui_android().getPending$zendesk_ui_ui_android();
                Integer colorAccent$zendesk_ui_ui_android = formView.rendering.getState$zendesk_ui_ui_android().getColorAccent$zendesk_ui_ui_android();
                String string = formView.getResources().getString(R.string.zuia_form_next_button);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.zuia_form_next_button)");
                return formButtonState.copy(string, pending$zendesk_ui_ui_android, colorAccent$zendesk_ui_ui_android);
            }
        }).build();
    }
}
