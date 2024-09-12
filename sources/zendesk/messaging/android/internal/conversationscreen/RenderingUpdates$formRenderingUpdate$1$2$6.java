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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/form/FieldState$Select;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RenderingUpdates.kt */
final class RenderingUpdates$formRenderingUpdate$1$2$6 extends Lambda implements Function1<FieldState.Select, FieldState.Select> {
    final /* synthetic */ Field $field;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RenderingUpdates$formRenderingUpdate$1$2$6(Field field) {
        super(1);
        this.$field = field;
    }

    public final FieldState.Select invoke(FieldState.Select select) {
        Intrinsics.checkNotNullParameter(select, "it");
        FieldState.Select.Builder placeholder = new FieldState.Select.Builder().label(this.$field.getLabel()).placeholder(this.$field.getPlaceholder());
        Iterable<FieldOption> options = ((Field.Select) this.$field).getOptions();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(options, 10));
        for (FieldOption fieldOption : options) {
            arrayList.add(new SelectOption(fieldOption.getName(), fieldOption.getLabel()));
        }
        FieldState.Select.Builder options2 = placeholder.options((List<SelectOption>) (List) arrayList);
        Iterable<FieldOption> select2 = ((Field.Select) this.$field).getSelect();
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(select2, 10));
        for (FieldOption fieldOption2 : select2) {
            arrayList2.add(new SelectOption(fieldOption2.getName(), fieldOption2.getLabel()));
        }
        return options2.select((List<SelectOption>) (List) arrayList2).build();
    }
}
