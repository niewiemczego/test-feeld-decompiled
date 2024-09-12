package expo.modules.image;

import android.content.Context;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.views.view.ReactViewBackgroundDrawable;
import com.facebook.yoga.YogaConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageView.kt */
final class ExpoImageView$borderDrawableLazyHolder$1 extends Lambda implements Function0<ReactViewBackgroundDrawable> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ExpoImageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExpoImageView$borderDrawableLazyHolder$1(Context context, ExpoImageView expoImageView) {
        super(0);
        this.$context = context;
        this.this$0 = expoImageView;
    }

    public final ReactViewBackgroundDrawable invoke() {
        ReactViewBackgroundDrawable reactViewBackgroundDrawable = new ReactViewBackgroundDrawable(this.$context);
        ExpoImageView expoImageView = this.this$0;
        reactViewBackgroundDrawable.setCallback(expoImageView);
        float[] borderRadiiConfig = expoImageView.outlineProvider.getBorderRadiiConfig();
        Collection arrayList = new ArrayList(borderRadiiConfig.length);
        for (float f : borderRadiiConfig) {
            if (!YogaConstants.isUndefined(f)) {
                f = PixelUtil.toPixelFromDIP(f);
            }
            arrayList.add(Float.valueOf(f));
        }
        for (IndexedValue indexedValue : CollectionsKt.withIndex((List) arrayList)) {
            int component1 = indexedValue.component1();
            float floatValue = ((Number) indexedValue.component2()).floatValue();
            if (component1 == 0) {
                reactViewBackgroundDrawable.setRadius(floatValue);
            } else {
                reactViewBackgroundDrawable.setRadius(floatValue, component1 - 1);
            }
        }
        return reactViewBackgroundDrawable;
    }
}
