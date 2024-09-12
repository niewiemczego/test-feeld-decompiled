package zendesk.ui.android.conversation.form;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.R;
import zendesk.ui.android.conversation.form.FormButtonRendering;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/form/FormButtonRendering;", "T", "formButtonRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormView.kt */
final class FormView$sendActionButtonClicked$1 extends Lambda implements Function1<FormButtonRendering, FormButtonRendering> {
    final /* synthetic */ FormView<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FormView$sendActionButtonClicked$1(FormView<T> formView) {
        super(1);
        this.this$0 = formView;
    }

    public final FormButtonRendering invoke(FormButtonRendering formButtonRendering) {
        Intrinsics.checkNotNullParameter(formButtonRendering, "formButtonRendering");
        FormButtonRendering.Builder builder = formButtonRendering.toBuilder();
        final FormView<T> formView = this.this$0;
        FormButtonRendering.Builder onButtonClicked = builder.onButtonClicked(new Function0<Unit>() {
            public final void invoke() {
                Collection arrayList = new ArrayList();
                for (Object next : formView.fieldViews) {
                    if (FieldView.validate$zendesk_ui_ui_android$default((FieldView) next, false, 1, (Object) null)) {
                        arrayList.add(next);
                    }
                }
                if (((List) arrayList).containsAll(formView.fieldViews)) {
                    formView.rendering.getOnFormCompleted$zendesk_ui_ui_android().invoke(CollectionsKt.toList(formView.fieldStates));
                    for (FieldView clearFocus : formView.fieldViews) {
                        clearFocus.clearFocus();
                    }
                } else if (!formView.rendering.getState$zendesk_ui_ui_android().getPending$zendesk_ui_ui_android()) {
                    FormView<T> formView = formView;
                    for (FieldView fieldView : formView.fieldViews) {
                        if (!FieldView.validate$zendesk_ui_ui_android$default(fieldView, false, 1, (Object) null)) {
                            formView.requestViewFocus(fieldView);
                            return;
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            }
        });
        final FormView<T> formView2 = this.this$0;
        return onButtonClicked.state(new Function1<FormButtonState, FormButtonState>() {
            public final FormButtonState invoke(FormButtonState formButtonState) {
                Intrinsics.checkNotNullParameter(formButtonState, "state");
                boolean pending$zendesk_ui_ui_android = formView2.rendering.getState$zendesk_ui_ui_android().getPending$zendesk_ui_ui_android();
                String string = formView2.getResources().getString(R.string.zuia_form_send_button);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.zuia_form_send_button)");
                return FormButtonState.copy$default(formButtonState, string, pending$zendesk_ui_ui_android, (Integer) null, 4, (Object) null);
            }
        }).build();
    }
}
