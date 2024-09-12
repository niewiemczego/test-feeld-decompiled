package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.Field;
import zendesk.ui.android.conversation.form.FieldState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/form/FieldState$Text;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RenderingUpdates.kt */
final class RenderingUpdates$formRenderingUpdate$1$2$2 extends Lambda implements Function1<FieldState.Text, FieldState.Text> {
    final /* synthetic */ Field $field;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RenderingUpdates$formRenderingUpdate$1$2$2(Field field) {
        super(1);
        this.$field = field;
    }

    public final FieldState.Text invoke(FieldState.Text text) {
        Intrinsics.checkNotNullParameter(text, "it");
        return new FieldState.Text.Builder().minLength(((Field.Text) this.$field).getMinSize()).maxLength(((Field.Text) this.$field).getMaxSize()).placeholder(this.$field.getPlaceholder()).label(this.$field.getLabel()).text(((Field.Text) this.$field).getText()).build();
    }
}
