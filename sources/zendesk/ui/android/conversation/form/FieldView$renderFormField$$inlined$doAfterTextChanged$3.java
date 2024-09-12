package zendesk.ui.android.conversation.form;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import zendesk.ui.android.conversation.form.FieldRendering;
import zendesk.ui.android.conversation.form.FieldState;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"zendesk/ui/android/internal/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "zendesk.ui_ui-android", "zendesk/ui/android/internal/TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextView.kt */
public final class FieldView$renderFormField$$inlined$doAfterTextChanged$3 implements TextWatcher {
    final /* synthetic */ FieldRendering.Email $fieldRendering$inlined;
    final /* synthetic */ FieldView this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public FieldView$renderFormField$$inlined$doAfterTextChanged$3(FieldRendering.Email email, FieldView fieldView) {
        this.$fieldRendering$inlined = email;
        this.this$0 = fieldView;
    }

    public void afterTextChanged(Editable editable) {
        FieldRendering.Email email = this.$fieldRendering$inlined;
        FieldRendering.Email copy$default = FieldRendering.Email.copy$default(email, FieldState.Email.copy$default(email.getState(), String.valueOf(editable), (String) null, (String) null, (Integer) null, 14, (Object) null), (Function1) null, (Function1) null, (Function1) null, (Function1) null, 30, (Object) null);
        this.this$0.rendering = copy$default;
        FieldView fieldView = this.this$0;
        boolean unused = fieldView.validate(fieldView.rendering.getState(), true);
        Function1<String, Unit> onEmailChanged$zendesk_ui_ui_android = this.$fieldRendering$inlined.getOnEmailChanged$zendesk_ui_ui_android();
        String email2 = copy$default.getState().getEmail();
        if (email2 == null) {
            email2 = "";
        }
        onEmailChanged$zendesk_ui_ui_android.invoke(email2);
        this.$fieldRendering$inlined.getOnStateChanged().invoke(copy$default.getState());
    }
}
