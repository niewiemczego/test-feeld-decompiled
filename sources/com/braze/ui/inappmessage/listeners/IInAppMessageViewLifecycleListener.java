package com.braze.ui.inappmessage.listeners;

import android.view.View;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.models.inappmessage.MessageButton;
import com.braze.ui.inappmessage.InAppMessageCloser;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Lcom/braze/ui/inappmessage/listeners/IInAppMessageViewLifecycleListener;", "", "afterClosed", "", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "afterOpened", "inAppMessageView", "Landroid/view/View;", "beforeClosed", "beforeOpened", "onButtonClicked", "inAppMessageCloser", "Lcom/braze/ui/inappmessage/InAppMessageCloser;", "messageButton", "Lcom/braze/models/inappmessage/MessageButton;", "inAppMessageImmersive", "Lcom/braze/models/inappmessage/IInAppMessageImmersive;", "onClicked", "onDismissed", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IInAppMessageViewLifecycleListener.kt */
public interface IInAppMessageViewLifecycleListener {
    void afterClosed(IInAppMessage iInAppMessage);

    void afterOpened(View view, IInAppMessage iInAppMessage);

    void beforeClosed(View view, IInAppMessage iInAppMessage);

    void beforeOpened(View view, IInAppMessage iInAppMessage);

    void onButtonClicked(InAppMessageCloser inAppMessageCloser, MessageButton messageButton, IInAppMessageImmersive iInAppMessageImmersive);

    void onClicked(InAppMessageCloser inAppMessageCloser, View view, IInAppMessage iInAppMessage);

    void onDismissed(View view, IInAppMessage iInAppMessage);
}
