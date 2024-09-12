package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.conversation.form.DisplayedField;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "displayedField", "Lzendesk/ui/android/conversation/form/DisplayedField;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$onFormDisplayedFieldsChanged$1 extends Lambda implements Function1<DisplayedField, Unit> {
    final /* synthetic */ ConversationScreenCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenCoordinator$onFormDisplayedFieldsChanged$1(ConversationScreenCoordinator conversationScreenCoordinator) {
        super(1);
        this.this$0 = conversationScreenCoordinator;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DisplayedField) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DisplayedField displayedField) {
        Intrinsics.checkNotNullParameter(displayedField, "displayedField");
        this.this$0.conversationScreenViewModel.updateMapOfDisplayedFields(displayedField);
    }
}
