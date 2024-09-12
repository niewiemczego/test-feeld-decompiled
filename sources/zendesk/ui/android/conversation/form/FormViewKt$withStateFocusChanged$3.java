package zendesk.ui.android.conversation.form;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormView.kt */
final class FormViewKt$withStateFocusChanged$3 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $onFieldFocusChanged;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FormViewKt$withStateFocusChanged$3(Function1<? super Boolean, Unit> function1) {
        super(1);
        this.$onFieldFocusChanged = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        this.$onFieldFocusChanged.invoke(Boolean.valueOf(z));
    }
}
