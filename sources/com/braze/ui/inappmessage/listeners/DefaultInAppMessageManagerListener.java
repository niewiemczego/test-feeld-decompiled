package com.braze.ui.inappmessage.listeners;

import android.content.Context;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageThemeable;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.InAppMessageOperation;
import com.braze.ui.support.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/braze/ui/inappmessage/listeners/DefaultInAppMessageManagerListener;", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageManagerListener;", "()V", "beforeInAppMessageDisplayed", "Lcom/braze/ui/inappmessage/InAppMessageOperation;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultInAppMessageManagerListener.kt */
public class DefaultInAppMessageManagerListener implements IInAppMessageManagerListener {
    public InAppMessageOperation beforeInAppMessageDisplayed(IInAppMessage iInAppMessage) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        if ((iInAppMessage instanceof IInAppMessageThemeable) && (applicationContext = BrazeInAppMessageManager.Companion.getInstance().getApplicationContext()) != null && ViewUtils.isDeviceInNightMode(applicationContext)) {
            ((IInAppMessageThemeable) iInAppMessage).enableDarkTheme();
        }
        return InAppMessageOperation.DISPLAY_NOW;
    }
}
