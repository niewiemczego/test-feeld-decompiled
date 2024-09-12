package com.braze.ui.inappmessage;

import android.view.View;
import com.braze.ui.inappmessage.listeners.SwipeDismissTouchListener;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"com/braze/ui/inappmessage/DefaultInAppMessageViewWrapper$createDismissCallbacks$1", "Lcom/braze/ui/inappmessage/listeners/SwipeDismissTouchListener$DismissCallbacks;", "canDismiss", "", "token", "", "onDismiss", "", "view", "Landroid/view/View;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultInAppMessageViewWrapper.kt */
public final class DefaultInAppMessageViewWrapper$createDismissCallbacks$1 implements SwipeDismissTouchListener.DismissCallbacks {
    final /* synthetic */ DefaultInAppMessageViewWrapper this$0;

    public boolean canDismiss(Object obj) {
        return true;
    }

    DefaultInAppMessageViewWrapper$createDismissCallbacks$1(DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper) {
        this.this$0 = defaultInAppMessageViewWrapper;
    }

    public void onDismiss(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        this.this$0.getInAppMessage().setAnimateOut(false);
        BrazeInAppMessageManager.Companion.getInstance().hideCurrentlyDisplayingInAppMessage(true);
    }
}
