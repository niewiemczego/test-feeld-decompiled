package expo.modules.image;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import expo.modules.image.enums.Priority;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "view", "Lexpo/modules/image/ExpoImageViewWrapper;", "priority", "Lexpo/modules/image/enums/Priority;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageModule.kt */
final class ExpoImageModule$definition$1$4$17 extends Lambda implements Function2<ExpoImageViewWrapper, Priority, Unit> {
    public static final ExpoImageModule$definition$1$4$17 INSTANCE = new ExpoImageModule$definition$1$4$17();

    ExpoImageModule$definition$1$4$17() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ExpoImageViewWrapper) obj, (Priority) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ExpoImageViewWrapper expoImageViewWrapper, Priority priority) {
        Intrinsics.checkNotNullParameter(expoImageViewWrapper, ViewHierarchyConstants.VIEW_KEY);
        if (priority == null) {
            priority = Priority.NORMAL;
        }
        expoImageViewWrapper.setPriority$expo_image_release(priority);
    }
}
