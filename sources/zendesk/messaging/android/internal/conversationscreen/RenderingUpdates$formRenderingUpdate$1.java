package zendesk.messaging.android.internal.conversationscreen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.Field;
import zendesk.ui.android.conversation.form.DisplayedField;
import zendesk.ui.android.conversation.form.FieldRendering;
import zendesk.ui.android.conversation.form.FormRendering;
import zendesk.ui.android.conversation.form.FormState;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/form/FormRendering;", "Lzendesk/conversationkit/android/model/Field;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RenderingUpdates.kt */
final class RenderingUpdates$formRenderingUpdate$1 extends Lambda implements Function1<FormRendering<Field>, FormRendering<Field>> {
    final /* synthetic */ Integer $colorAccent;
    final /* synthetic */ List<Field> $fields;
    final /* synthetic */ Map<Integer, DisplayedField> $mapOfDisplayedFields;
    final /* synthetic */ Function1<List<? extends Field>, Unit> $onFormCompleted;
    final /* synthetic */ Function1<DisplayedField, Unit> $onFormDisplayedFieldsChanged;
    final /* synthetic */ Function1<Boolean, Unit> $onFormFocusChanged;
    final /* synthetic */ boolean $pending;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RenderingUpdates$formRenderingUpdate$1(List<? extends Field> list, Function1<? super List<? extends Field>, Unit> function1, Function1<? super Boolean, Unit> function12, Function1<? super DisplayedField, Unit> function13, Map<Integer, DisplayedField> map, Integer num, boolean z) {
        super(1);
        this.$fields = list;
        this.$onFormCompleted = function1;
        this.$onFormFocusChanged = function12;
        this.$onFormDisplayedFieldsChanged = function13;
        this.$mapOfDisplayedFields = map;
        this.$colorAccent = num;
        this.$pending = z;
    }

    public final FormRendering<Field> invoke(FormRendering<Field> formRendering) {
        FieldRendering fieldRendering;
        Intrinsics.checkNotNullParameter(formRendering, "it");
        FormRendering.Builder builder = new FormRendering.Builder();
        final Integer num = this.$colorAccent;
        final boolean z = this.$pending;
        FormRendering.Builder state = builder.state(new Function1<FormState, FormState>() {
            public final FormState invoke(FormState formState) {
                Intrinsics.checkNotNullParameter(formState, "state");
                return formState.copy(num, z);
            }
        });
        Collection arrayList = new ArrayList();
        for (Field field : this.$fields) {
            if (field instanceof Field.Text) {
                fieldRendering = new FieldRendering.Text.Builder(new RenderingUpdates$formRenderingUpdate$1$2$1(field)).state(new RenderingUpdates$formRenderingUpdate$1$2$2(field)).build();
            } else if (field instanceof Field.Email) {
                fieldRendering = new FieldRendering.Email.Builder(new RenderingUpdates$formRenderingUpdate$1$2$3(field)).state(new RenderingUpdates$formRenderingUpdate$1$2$4(field)).build();
            } else if (field instanceof Field.Select) {
                fieldRendering = new FieldRendering.Select.Builder(new RenderingUpdates$formRenderingUpdate$1$2$5(field)).state(new RenderingUpdates$formRenderingUpdate$1$2$6(field)).build();
            } else {
                fieldRendering = null;
            }
            if (fieldRendering != null) {
                arrayList.add(fieldRendering);
            }
        }
        return state.fieldRenderings((List) arrayList).onFormCompleted(this.$onFormCompleted).onFormFocusChanged(this.$onFormFocusChanged).onFormDisplayedFieldsChanged(this.$onFormDisplayedFieldsChanged).mapOfDisplayedFields(this.$mapOfDisplayedFields).build();
    }
}
