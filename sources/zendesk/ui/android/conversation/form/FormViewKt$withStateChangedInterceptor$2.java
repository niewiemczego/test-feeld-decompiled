package zendesk.ui.android.conversation.form;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.conversation.form.FieldRendering;
import zendesk.ui.android.conversation.form.FieldState;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "emailState", "Lzendesk/ui/android/conversation/form/FieldState$Email;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormView.kt */
final class FormViewKt$withStateChangedInterceptor$2 extends Lambda implements Function1<FieldState.Email, Unit> {
    final /* synthetic */ int $currentIndex;
    final /* synthetic */ Function1<T, Unit> $interceptor;
    final /* synthetic */ Function1<DisplayedField, Unit> $onFormDisplayedFieldsChanged;
    final /* synthetic */ FieldRendering<T> $this_withStateChangedInterceptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FormViewKt$withStateChangedInterceptor$2(Function1<? super T, Unit> function1, FieldRendering<T> fieldRendering, Function1<? super DisplayedField, Unit> function12, int i) {
        super(1);
        this.$interceptor = function1;
        this.$this_withStateChangedInterceptor = fieldRendering;
        this.$onFormDisplayedFieldsChanged = function12;
        this.$currentIndex = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FieldState.Email) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(FieldState.Email email) {
        Intrinsics.checkNotNullParameter(email, "emailState");
        this.$interceptor.invoke(((FieldRendering.Email) this.$this_withStateChangedInterceptor).getNormalize$zendesk_ui_ui_android().invoke(email));
        ((FieldRendering.Email) this.$this_withStateChangedInterceptor).getOnStateChanged().invoke(email);
        this.$onFormDisplayedFieldsChanged.invoke(new DisplayedField(this.$currentIndex, email.getEmail()));
    }
}
