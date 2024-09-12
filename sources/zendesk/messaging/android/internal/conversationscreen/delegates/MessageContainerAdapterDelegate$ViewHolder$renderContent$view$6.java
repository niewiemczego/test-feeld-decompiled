package zendesk.messaging.android.internal.conversationscreen.delegates;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.Field;
import zendesk.messaging.android.internal.model.MessageLogEntry;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "field", "", "Lzendesk/conversationkit/android/model/Field;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageContainerAdapterDelegate.kt */
final class MessageContainerAdapterDelegate$ViewHolder$renderContent$view$6 extends Lambda implements Function1<List<? extends Field>, Unit> {
    final /* synthetic */ MessageLogEntry.MessageContainer $item;
    final /* synthetic */ Function2<List<? extends Field>, MessageLogEntry.MessageContainer, Unit> $onFormCompleted;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageContainerAdapterDelegate$ViewHolder$renderContent$view$6(Function2<? super List<? extends Field>, ? super MessageLogEntry.MessageContainer, Unit> function2, MessageLogEntry.MessageContainer messageContainer) {
        super(1);
        this.$onFormCompleted = function2;
        this.$item = messageContainer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends Field>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<? extends Field> list) {
        Intrinsics.checkNotNullParameter(list, "field");
        this.$onFormCompleted.invoke(list, this.$item);
    }
}
