package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.Field;
import zendesk.ui.android.conversation.form.FieldState;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lzendesk/conversationkit/android/model/Field;", "state", "Lzendesk/ui/android/conversation/form/FieldState$Email;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RenderingUpdates.kt */
final class RenderingUpdates$formRenderingUpdate$1$2$3 extends Lambda implements Function1<FieldState.Email, Field> {
    final /* synthetic */ Field $field;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RenderingUpdates$formRenderingUpdate$1$2$3(Field field) {
        super(1);
        this.$field = field;
    }

    public final Field invoke(FieldState.Email email) {
        Intrinsics.checkNotNullParameter(email, "state");
        Field.Email email2 = (Field.Email) this.$field;
        String email3 = email.getEmail();
        if (email3 == null) {
            email3 = "";
        }
        return Field.Email.copy$default(email2, (String) null, (String) null, (String) null, (String) null, email3, 15, (Object) null);
    }
}
