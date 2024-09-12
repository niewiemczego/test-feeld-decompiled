package zendesk.messaging.android.internal.conversationscreen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.Field;
import zendesk.conversationkit.android.model.FieldOption;
import zendesk.ui.android.conversation.form.FieldState;
import zendesk.ui.android.conversation.form.SelectOption;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lzendesk/conversationkit/android/model/Field;", "state", "Lzendesk/ui/android/conversation/form/FieldState$Select;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RenderingUpdates.kt */
final class RenderingUpdates$formRenderingUpdate$1$2$5 extends Lambda implements Function1<FieldState.Select, Field> {
    final /* synthetic */ Field $field;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RenderingUpdates$formRenderingUpdate$1$2$5(Field field) {
        super(1);
        this.$field = field;
    }

    public final Field invoke(FieldState.Select select) {
        Intrinsics.checkNotNullParameter(select, "state");
        Field field = this.$field;
        Field.Select select2 = (Field.Select) field;
        Collection arrayList = new ArrayList();
        for (Object next : ((Field.Select) field).getOptions()) {
            FieldOption fieldOption = (FieldOption) next;
            Iterable<SelectOption> select3 = select.getSelect();
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(select3, 10));
            for (SelectOption id : select3) {
                arrayList2.add(id.getId());
            }
            if (((List) arrayList2).contains(fieldOption.getName())) {
                arrayList.add(next);
            }
        }
        return Field.Select.copy$default(select2, (String) null, (String) null, (String) null, (String) null, (List) null, 0, (List) arrayList, 63, (Object) null);
    }
}
