package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.Field;
import zendesk.ui.android.conversation.form.FieldState;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lzendesk/conversationkit/android/model/Field;", "state", "Lzendesk/ui/android/conversation/form/FieldState$Text;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RenderingUpdates.kt */
final class RenderingUpdates$formRenderingUpdate$1$2$1 extends Lambda implements Function1<FieldState.Text, Field> {
    final /* synthetic */ Field $field;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RenderingUpdates$formRenderingUpdate$1$2$1(Field field) {
        super(1);
        this.$field = field;
    }

    public final Field invoke(FieldState.Text text) {
        Intrinsics.checkNotNullParameter(text, "state");
        Field.Text text2 = (Field.Text) this.$field;
        String text3 = text.getText();
        if (text3 == null) {
            text3 = "";
        }
        return Field.Text.copy$default(text2, (String) null, (String) null, (String) null, (String) null, 0, 0, text3, 63, (Object) null);
    }
}
