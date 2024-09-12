package expo.modules.image;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"androidx/core/view/ViewKt$doOnDetach$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: expo.modules.image.ExpoImageModule$definition$lambda-9$lambda-8$lambda-7$$inlined$doOnDetach$1  reason: invalid class name */
/* compiled from: View.kt */
public final class ExpoImageModule$definition$lambda9$lambda8$lambda7$$inlined$doOnDetach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ View $this_doOnDetach;
    final /* synthetic */ ExpoImageViewWrapper $view$inlined;

    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
    }

    public ExpoImageModule$definition$lambda9$lambda8$lambda7$$inlined$doOnDetach$1(View view, ExpoImageViewWrapper expoImageViewWrapper) {
        this.$this_doOnDetach = view;
        this.$view$inlined = expoImageViewWrapper;
    }

    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        this.$this_doOnDetach.removeOnAttachStateChangeListener(this);
        this.$view$inlined.onViewDestroys();
    }
}
