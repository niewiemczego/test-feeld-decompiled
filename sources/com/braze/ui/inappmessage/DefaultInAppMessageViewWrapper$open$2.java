package com.braze.ui.inappmessage;

import android.view.View;
import android.view.ViewGroup;
import com.braze.support.BrazeLogger;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"com/braze/ui/inappmessage/DefaultInAppMessageViewWrapper$open$2", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultInAppMessageViewWrapper.kt */
public final class DefaultInAppMessageViewWrapper$open$2 implements View.OnLayoutChangeListener {
    final /* synthetic */ ViewGroup $parentViewGroup;
    final /* synthetic */ DefaultInAppMessageViewWrapper this$0;

    DefaultInAppMessageViewWrapper$open$2(ViewGroup viewGroup, DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper) {
        this.$parentViewGroup = viewGroup;
        this.this$0 = defaultInAppMessageViewWrapper;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        this.$parentViewGroup.removeOnLayoutChangeListener(this);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new DefaultInAppMessageViewWrapper$open$2$onLayoutChange$1(i4, i2), 3, (Object) null);
        this.$parentViewGroup.removeView(this.this$0.getInAppMessageView());
        ViewGroup viewGroup = this.$parentViewGroup;
        viewGroup.post(new DefaultInAppMessageViewWrapper$open$2$$ExternalSyntheticLambda0(this.this$0, viewGroup));
    }

    /* access modifiers changed from: private */
    public static final void onLayoutChange$lambda$0(DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(defaultInAppMessageViewWrapper, "this$0");
        Intrinsics.checkNotNullParameter(viewGroup, "$parentViewGroup");
        defaultInAppMessageViewWrapper.addInAppMessageViewToViewGroup(viewGroup, defaultInAppMessageViewWrapper.getInAppMessage(), defaultInAppMessageViewWrapper.getInAppMessageView(), defaultInAppMessageViewWrapper.getInAppMessageViewLifecycleListener());
    }
}
