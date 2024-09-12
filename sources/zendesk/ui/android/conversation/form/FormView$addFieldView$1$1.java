package zendesk.ui.android.conversation.form;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\u0004\b\u0000\u0010\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/form/FieldRendering;", "T", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormView.kt */
final class FormView$addFieldView$1$1 extends Lambda implements Function1<FieldRendering<?>, FieldRendering<?>> {
    final /* synthetic */ int $currentIndex;
    final /* synthetic */ DisplayedField $displayedField;
    final /* synthetic */ boolean $isLastField;
    final /* synthetic */ int $nextIndex;
    final /* synthetic */ int $numberOfFields;
    final /* synthetic */ FormView<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FormView$addFieldView$1$1(FormView<T> formView, int i, DisplayedField displayedField, int i2, boolean z, int i3) {
        super(1);
        this.this$0 = formView;
        this.$currentIndex = i;
        this.$displayedField = displayedField;
        this.$nextIndex = i2;
        this.$isLastField = z;
        this.$numberOfFields = i3;
    }

    public final FieldRendering<?> invoke(FieldRendering<?> fieldRendering) {
        Intrinsics.checkNotNullParameter(fieldRendering, "it");
        FieldRendering access$withBorderColorOverride = FormViewKt.withBorderColorOverride((FieldRendering) this.this$0.rendering.getFieldRenderings$zendesk_ui_ui_android().get(this.$currentIndex), this.this$0.rendering.getState$zendesk_ui_ui_android().getColorAccent$zendesk_ui_ui_android());
        int i = this.$currentIndex;
        Function1<DisplayedField, Unit> onFormDisplayedFieldsChanged$zendesk_ui_ui_android = this.this$0.rendering.getOnFormDisplayedFieldsChanged$zendesk_ui_ui_android();
        final FormView<T> formView = this.this$0;
        final int i2 = this.$currentIndex;
        FieldRendering access$withStateChangedInterceptor = FormViewKt.withStateChangedInterceptor(access$withBorderColorOverride, i, onFormDisplayedFieldsChanged$zendesk_ui_ui_android, new Function1<T, Unit>() {
            public final void invoke(T t) {
                formView.fieldStates.set(i2, t);
                formView.rendering.getOnFormChanged$zendesk_ui_ui_android().invoke(formView.fieldStates);
            }
        });
        final FormView<T> formView2 = this.this$0;
        final int i3 = this.$nextIndex;
        FieldRendering access$withStateFocusChanged = FormViewKt.withStateFocusChanged(FormViewKt.withSelectChangedInterceptor(access$withStateChangedInterceptor, new Function1<List<? extends SelectOption>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<SelectOption>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<SelectOption> list) {
                Intrinsics.checkNotNullParameter(list, "it");
                FieldView fieldView = (FieldView) CollectionsKt.getOrNull(formView2.fieldViews, i3);
                if (fieldView != null) {
                    formView2.requestViewFocus(fieldView);
                }
            }
        }), this.this$0.rendering.getOnFormFocusChanged$zendesk_ui_ui_android());
        DisplayedField displayedField = this.$displayedField;
        final FormView<T> formView3 = this.this$0;
        final int i4 = this.$currentIndex;
        FieldRendering access$withStateInputCached = FormViewKt.withStateInputCached(access$withStateFocusChanged, displayedField, new Function1<T, Unit>() {
            public final void invoke(T t) {
                formView3.fieldStates.set(i4, t);
            }
        });
        final boolean z = this.$isLastField;
        final FormView<T> formView4 = this.this$0;
        final int i5 = this.$currentIndex;
        final int i6 = this.$nextIndex;
        final int i7 = this.$numberOfFields;
        return FormViewKt.withSelectCheckMarkActionInterceptor(access$withStateInputCached, new Function0<Unit>() {
            public final void invoke() {
                FieldView fieldView;
                if (z && (fieldView = (FieldView) CollectionsKt.getOrNull(formView4.fieldViews, i5)) != null) {
                    fieldView.clearFocus();
                }
                FormView<T> formView = formView4;
                int i = i6;
                final FormView<T> formView2 = formView4;
                final int i2 = i6;
                final int i3 = i7;
                formView.displayNextFieldView(i, new Function0<Unit>() {
                    public final void invoke() {
                        FormView.addFieldView$default(formView2, i2, (DisplayedField) null, i3, 2, (Object) null);
                    }
                });
            }
        });
    }
}
