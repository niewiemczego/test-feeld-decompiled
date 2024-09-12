package expo.modules.image;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import expo.modules.image.records.SourceMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "view", "Lexpo/modules/image/ExpoImageViewWrapper;", "placeholder", "", "Lexpo/modules/image/records/SourceMap;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageModule.kt */
final class ExpoImageModule$definition$1$4$13 extends Lambda implements Function2<ExpoImageViewWrapper, List<? extends SourceMap>, Unit> {
    public static final ExpoImageModule$definition$1$4$13 INSTANCE = new ExpoImageModule$definition$1$4$13();

    ExpoImageModule$definition$1$4$13() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ExpoImageViewWrapper) obj, (List<SourceMap>) (List) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ExpoImageViewWrapper expoImageViewWrapper, List<SourceMap> list) {
        Intrinsics.checkNotNullParameter(expoImageViewWrapper, ViewHierarchyConstants.VIEW_KEY);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        expoImageViewWrapper.setPlaceholders$expo_image_release(list);
    }
}
