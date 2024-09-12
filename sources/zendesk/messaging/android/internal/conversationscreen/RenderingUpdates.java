package zendesk.messaging.android.internal.conversationscreen;

import com.facebook.GraphRequest;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.Field;
import zendesk.ui.android.conversation.form.DisplayedField;
import zendesk.ui.android.conversation.form.FormRendering;
import zendesk.ui.android.conversation.form.FormResponseRendering;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J¯\u0001\u0010\u0003\u001a*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\t\u0012\u0004\u0012\u00020\u000b0\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u00042\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u0015¢\u0006\u0002\u0010\u0016J*\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0004j\b\u0012\u0004\u0012\u00020\u0018`\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¨\u0006\u0019"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/RenderingUpdates;", "", "()V", "formRenderingUpdate", "Lkotlin/Function1;", "Lzendesk/ui/android/conversation/form/FormRendering;", "Lzendesk/conversationkit/android/model/Field;", "Lzendesk/messaging/android/internal/conversationscreen/RenderingUpdate;", "fields", "", "onFormCompleted", "", "onFormFocusChanged", "", "colorAccent", "", "pending", "onFormDisplayedFieldsChanged", "Lzendesk/ui/android/conversation/form/DisplayedField;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormDisplayedFieldsChanged;", "mapOfDisplayedFields", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function1;Ljava/util/Map;)Lkotlin/jvm/functions/Function1;", "formResponseRenderingUpdate", "Lzendesk/ui/android/conversation/form/FormResponseRendering;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RenderingUpdates.kt */
public final class RenderingUpdates {
    public static final RenderingUpdates INSTANCE = new RenderingUpdates();

    private RenderingUpdates() {
    }

    public final Function1<FormRendering<Field>, FormRendering<Field>> formRenderingUpdate(List<? extends Field> list, Function1<? super List<? extends Field>, Unit> function1, Function1<? super Boolean, Unit> function12, Integer num, boolean z, Function1<? super DisplayedField, Unit> function13, Map<Integer, DisplayedField> map) {
        Intrinsics.checkNotNullParameter(list, GraphRequest.FIELDS_PARAM);
        Intrinsics.checkNotNullParameter(function1, "onFormCompleted");
        Intrinsics.checkNotNullParameter(function12, "onFormFocusChanged");
        Intrinsics.checkNotNullParameter(function13, "onFormDisplayedFieldsChanged");
        Map<Integer, DisplayedField> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "mapOfDisplayedFields");
        return new RenderingUpdates$formRenderingUpdate$1(list, function1, function12, function13, map2, num, z);
    }

    public final Function1<FormResponseRendering, FormResponseRendering> formResponseRenderingUpdate(List<? extends Field> list) {
        Intrinsics.checkNotNullParameter(list, GraphRequest.FIELDS_PARAM);
        return new RenderingUpdates$formResponseRenderingUpdate$1(list);
    }
}
