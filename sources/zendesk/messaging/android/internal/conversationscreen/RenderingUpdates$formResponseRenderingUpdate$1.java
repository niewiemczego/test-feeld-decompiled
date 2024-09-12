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
import zendesk.ui.android.conversation.form.FormResponseRendering;
import zendesk.ui.android.conversation.form.FormResponseState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/form/FormResponseRendering;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RenderingUpdates.kt */
final class RenderingUpdates$formResponseRenderingUpdate$1 extends Lambda implements Function1<FormResponseRendering, FormResponseRendering> {
    final /* synthetic */ List<Field> $fields;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RenderingUpdates$formResponseRenderingUpdate$1(List<? extends Field> list) {
        super(1);
        this.$fields = list;
    }

    public final FormResponseRendering invoke(FormResponseRendering formResponseRendering) {
        Intrinsics.checkNotNullParameter(formResponseRendering, "it");
        FormResponseRendering.Builder builder = new FormResponseRendering.Builder();
        final List<Field> list = this.$fields;
        return builder.state(new Function1<FormResponseState, FormResponseState>() {
            public final FormResponseState invoke(FormResponseState formResponseState) {
                Intrinsics.checkNotNullParameter(formResponseState, "it");
                FormResponseState.Builder builder = new FormResponseState.Builder();
                Iterable<Field> iterable = list;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Field access$toFieldResponseState : iterable) {
                    arrayList.add(RenderingUpdatesKt.toFieldResponseState(access$toFieldResponseState));
                }
                return builder.fieldResponses((List) arrayList).build();
            }
        }).build();
    }
}
