package zendesk.ui.android.conversation.form;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.conversation.form.FieldRendering;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "selectOptions", "", "Lzendesk/ui/android/conversation/form/SelectOption;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormView.kt */
final class FormViewKt$withSelectChangedInterceptor$1 extends Lambda implements Function1<List<? extends SelectOption>, Unit> {
    final /* synthetic */ Function1<List<SelectOption>, Unit> $interceptor;
    final /* synthetic */ FieldRendering<T> $this_withSelectChangedInterceptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FormViewKt$withSelectChangedInterceptor$1(Function1<? super List<SelectOption>, Unit> function1, FieldRendering<T> fieldRendering) {
        super(1);
        this.$interceptor = function1;
        this.$this_withSelectChangedInterceptor = fieldRendering;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<SelectOption>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<SelectOption> list) {
        Intrinsics.checkNotNullParameter(list, "selectOptions");
        this.$interceptor.invoke(list);
        ((FieldRendering.Select) this.$this_withSelectChangedInterceptor).getOnSelected$zendesk_ui_ui_android().invoke(list);
    }
}
