package com.braze.ui.inappmessage.listeners;

import android.view.View;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.MessageButton;
import com.braze.support.BrazeFunctionNotImplemented;
import com.braze.ui.inappmessage.InAppMessageCloser;
import com.braze.ui.inappmessage.InAppMessageOperation;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Lcom/braze/ui/inappmessage/listeners/IInAppMessageManagerListener;", "", "afterInAppMessageViewClosed", "", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "afterInAppMessageViewOpened", "inAppMessageView", "Landroid/view/View;", "beforeInAppMessageDisplayed", "Lcom/braze/ui/inappmessage/InAppMessageOperation;", "beforeInAppMessageViewClosed", "beforeInAppMessageViewOpened", "onInAppMessageButtonClicked", "", "button", "Lcom/braze/models/inappmessage/MessageButton;", "inAppMessageCloser", "Lcom/braze/ui/inappmessage/InAppMessageCloser;", "onInAppMessageClicked", "onInAppMessageDismissed", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IInAppMessageManagerListener.kt */
public interface IInAppMessageManagerListener {
    void afterInAppMessageViewClosed(IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
    }

    void afterInAppMessageViewOpened(View view, IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
    }

    void beforeInAppMessageViewClosed(View view, IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
    }

    void beforeInAppMessageViewOpened(View view, IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
    }

    boolean onInAppMessageButtonClicked(IInAppMessage iInAppMessage, MessageButton messageButton) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(messageButton, "button");
        return false;
    }

    boolean onInAppMessageClicked(IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        return false;
    }

    void onInAppMessageDismissed(IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
    }

    InAppMessageOperation beforeInAppMessageDisplayed(IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        return InAppMessageOperation.DISPLAY_NOW;
    }

    @Deprecated(message = "InAppMessageCloser is deprecated", replaceWith = @ReplaceWith(expression = "onInAppMessageClicked(inAppMessage)", imports = {}))
    boolean onInAppMessageClicked(IInAppMessage iInAppMessage, InAppMessageCloser inAppMessageCloser) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        throw BrazeFunctionNotImplemented.INSTANCE;
    }

    @Deprecated(message = "InAppMessageCloser is deprecated", replaceWith = @ReplaceWith(expression = "onInAppMessageButtonClicked(inAppMessage, button)", imports = {}))
    boolean onInAppMessageButtonClicked(IInAppMessage iInAppMessage, MessageButton messageButton, InAppMessageCloser inAppMessageCloser) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(messageButton, "button");
        throw BrazeFunctionNotImplemented.INSTANCE;
    }
}
