package zendesk.conversationkit.android.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.AppDto;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toApp", "Lzendesk/conversationkit/android/model/App;", "Lzendesk/conversationkit/android/internal/rest/model/AppDto;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: App.kt */
public final class AppKt {
    public static final App toApp(AppDto appDto) {
        Intrinsics.checkNotNullParameter(appDto, "<this>");
        return new App(appDto.getId(), appDto.getStatus(), appDto.getName(), appDto.getSettings().isMultiConvoEnabled());
    }
}
