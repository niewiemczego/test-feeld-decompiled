package zendesk.ui.android.conversation.form;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.conversation.form.FieldResponseRendering;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/form/FieldResponseRendering;", "fieldResponseRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormResponseView.kt */
final class FormResponseView$render$1$1 extends Lambda implements Function1<FieldResponseRendering, FieldResponseRendering> {
    final /* synthetic */ FieldResponse $fieldResponse;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FormResponseView$render$1$1(FieldResponse fieldResponse) {
        super(1);
        this.$fieldResponse = fieldResponse;
    }

    public final FieldResponseRendering invoke(FieldResponseRendering fieldResponseRendering) {
        Intrinsics.checkNotNullParameter(fieldResponseRendering, "fieldResponseRendering");
        FieldResponseRendering.Builder builder = fieldResponseRendering.toBuilder();
        final FieldResponse fieldResponse = this.$fieldResponse;
        return builder.state(new Function1<FieldResponseState, FieldResponseState>() {
            public final FieldResponseState invoke(FieldResponseState fieldResponseState) {
                Intrinsics.checkNotNullParameter(fieldResponseState, "state");
                return fieldResponseState.copy(fieldResponse.getLabel(), fieldResponse.getResponse());
            }
        }).build();
    }
}
