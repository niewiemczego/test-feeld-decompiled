package zendesk.ui.android.conversation.form;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.conversation.form.FieldRendering;
import zendesk.ui.android.conversation.form.FieldState;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u0005\u001a8\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\bH\u0002\u001a,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0002\u001aN\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\bH\u0002\u001a2\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0\bH\u0002\u001a<\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\bH\u0002¨\u0006\u0017"}, d2 = {"withBorderColorOverride", "Lzendesk/ui/android/conversation/form/FieldRendering;", "T", "borderColor", "", "(Lzendesk/ui/android/conversation/form/FieldRendering;Ljava/lang/Integer;)Lzendesk/ui/android/conversation/form/FieldRendering;", "withSelectChangedInterceptor", "interceptor", "Lkotlin/Function1;", "", "Lzendesk/ui/android/conversation/form/SelectOption;", "", "withSelectCheckMarkActionInterceptor", "Lkotlin/Function0;", "withStateChangedInterceptor", "currentIndex", "onFormDisplayedFieldsChanged", "Lzendesk/ui/android/conversation/form/DisplayedField;", "withStateFocusChanged", "onFieldFocusChanged", "", "withStateInputCached", "displayedField", "zendesk.ui_ui-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormView.kt */
public final class FormViewKt {
    /* access modifiers changed from: private */
    public static final <T> FieldRendering<T> withSelectChangedInterceptor(FieldRendering<T> fieldRendering, Function1<? super List<SelectOption>, Unit> function1) {
        return !(fieldRendering instanceof FieldRendering.Select) ? fieldRendering : FieldRendering.Select.copy$default((FieldRendering.Select) fieldRendering, (FieldState.Select) null, (Function1) null, new FormViewKt$withSelectChangedInterceptor$1(function1, fieldRendering), (Function1) null, (Function1) null, (Function0) null, 59, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final <T> FieldRendering<T> withSelectCheckMarkActionInterceptor(FieldRendering<T> fieldRendering, Function0<Unit> function0) {
        return !(fieldRendering instanceof FieldRendering.Select) ? fieldRendering : FieldRendering.Select.copy$default((FieldRendering.Select) fieldRendering, (FieldState.Select) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, new FormViewKt$withSelectCheckMarkActionInterceptor$1(function0), 31, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final <T> FieldRendering<T> withStateFocusChanged(FieldRendering<T> fieldRendering, Function1<? super Boolean, Unit> function1) {
        if (fieldRendering instanceof FieldRendering.Text) {
            return FieldRendering.Text.copy$default((FieldRendering.Text) fieldRendering, (FieldState.Text) null, (Function1) null, (Function1) null, (Function1) null, new FormViewKt$withStateFocusChanged$1(function1), 15, (Object) null);
        }
        if (fieldRendering instanceof FieldRendering.Email) {
            return FieldRendering.Email.copy$default((FieldRendering.Email) fieldRendering, (FieldState.Email) null, (Function1) null, (Function1) null, (Function1) null, new FormViewKt$withStateFocusChanged$2(function1), 15, (Object) null);
        }
        if (fieldRendering instanceof FieldRendering.Select) {
            return FieldRendering.Select.copy$default((FieldRendering.Select) fieldRendering, (FieldState.Select) null, (Function1) null, (Function1) null, (Function1) null, new FormViewKt$withStateFocusChanged$3(function1), (Function0) null, 47, (Object) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    public static final <T> FieldRendering<T> withStateChangedInterceptor(FieldRendering<T> fieldRendering, int i, Function1<? super DisplayedField, Unit> function1, Function1<? super T, Unit> function12) {
        if (fieldRendering instanceof FieldRendering.Text) {
            return FieldRendering.Text.copy$default((FieldRendering.Text) fieldRendering, (FieldState.Text) null, new FormViewKt$withStateChangedInterceptor$1(function12, fieldRendering, function1, i), (Function1) null, (Function1) null, (Function1) null, 29, (Object) null);
        }
        if (fieldRendering instanceof FieldRendering.Email) {
            return FieldRendering.Email.copy$default((FieldRendering.Email) fieldRendering, (FieldState.Email) null, new FormViewKt$withStateChangedInterceptor$2(function12, fieldRendering, function1, i), (Function1) null, (Function1) null, (Function1) null, 29, (Object) null);
        }
        if (fieldRendering instanceof FieldRendering.Select) {
            return FieldRendering.Select.copy$default((FieldRendering.Select) fieldRendering, (FieldState.Select) null, new FormViewKt$withStateChangedInterceptor$3(function12, fieldRendering, function1, i), (Function1) null, (Function1) null, (Function1) null, (Function0) null, 61, (Object) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    public static final <T> FieldRendering<T> withBorderColorOverride(FieldRendering<T> fieldRendering, Integer num) {
        if (num == null) {
            return fieldRendering;
        }
        num.intValue();
        Integer borderColor$zendesk_ui_ui_android = fieldRendering.getState().getBorderColor$zendesk_ui_ui_android();
        if (borderColor$zendesk_ui_ui_android != null) {
            borderColor$zendesk_ui_ui_android.intValue();
            return fieldRendering;
        } else if (fieldRendering instanceof FieldRendering.Text) {
            FieldRendering.Text text = (FieldRendering.Text) fieldRendering;
            return FieldRendering.Text.copy$default(text, FieldState.Text.copy$default(text.getState(), (String) null, 0, 0, (String) null, (String) null, num, 31, (Object) null), (Function1) null, (Function1) null, (Function1) null, (Function1) null, 30, (Object) null);
        } else if (fieldRendering instanceof FieldRendering.Email) {
            FieldRendering.Email email = (FieldRendering.Email) fieldRendering;
            return FieldRendering.Email.copy$default(email, FieldState.Email.copy$default(email.getState(), (String) null, (String) null, (String) null, num, 7, (Object) null), (Function1) null, (Function1) null, (Function1) null, (Function1) null, 30, (Object) null);
        } else if (fieldRendering instanceof FieldRendering.Select) {
            FieldRendering.Select select = (FieldRendering.Select) fieldRendering;
            return FieldRendering.Select.copy$default(select, FieldState.Select.copy$default(select.getState(), (List) null, (List) null, (String) null, (String) null, num, 15, (Object) null), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function0) null, 62, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public static final <T> FieldRendering<T> withStateInputCached(FieldRendering<T> fieldRendering, DisplayedField displayedField, Function1<? super T, Unit> function1) {
        if (displayedField == null || displayedField.getValue() == null) {
            return fieldRendering;
        }
        if (fieldRendering instanceof FieldRendering.Text) {
            FieldRendering.Text text = (FieldRendering.Text) fieldRendering;
            FieldRendering.Text copy$default = FieldRendering.Text.copy$default(text, FieldState.Text.copy$default(text.getState(), displayedField.getValue(), 0, 0, (String) null, (String) null, (Integer) null, 62, (Object) null), (Function1) null, (Function1) null, (Function1) null, (Function1) null, 30, (Object) null);
            function1.invoke(text.getNormalize$zendesk_ui_ui_android().invoke(copy$default.getState()));
            return copy$default;
        } else if (fieldRendering instanceof FieldRendering.Email) {
            FieldRendering.Email email = (FieldRendering.Email) fieldRendering;
            FieldRendering.Email copy$default2 = FieldRendering.Email.copy$default(email, FieldState.Email.copy$default(email.getState(), displayedField.getValue(), (String) null, (String) null, (Integer) null, 14, (Object) null), (Function1) null, (Function1) null, (Function1) null, (Function1) null, 30, (Object) null);
            function1.invoke(email.getNormalize$zendesk_ui_ui_android().invoke(copy$default2.getState()));
            return copy$default2;
        } else if (fieldRendering instanceof FieldRendering.Select) {
            FieldRendering.Select select = (FieldRendering.Select) fieldRendering;
            FieldState.Select state = select.getState();
            Collection arrayList = new ArrayList();
            for (Object next : select.getState().getOptions()) {
                if (Intrinsics.areEqual((Object) ((SelectOption) next).getId(), (Object) displayedField.getValue())) {
                    arrayList.add(next);
                }
            }
            FieldRendering.Select copy$default3 = FieldRendering.Select.copy$default(select, FieldState.Select.copy$default(state, (List) null, (List) arrayList, (String) null, (String) null, (Integer) null, 29, (Object) null), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function0) null, 62, (Object) null);
            function1.invoke(select.getNormalize$zendesk_ui_ui_android().invoke(copy$default3.getState()));
            return copy$default3;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
