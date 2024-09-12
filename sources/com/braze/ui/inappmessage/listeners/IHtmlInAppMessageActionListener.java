package com.braze.ui.inappmessage.listeners;

import android.os.Bundle;
import com.braze.models.inappmessage.IInAppMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcom/braze/ui/inappmessage/listeners/IHtmlInAppMessageActionListener;", "", "onCloseClicked", "", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "url", "", "queryBundle", "Landroid/os/Bundle;", "onCustomEventFired", "", "onNewsfeedClicked", "onOtherUrlAction", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IHtmlInAppMessageActionListener.kt */
public interface IHtmlInAppMessageActionListener {
    void onCloseClicked(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
    }

    boolean onCustomEventFired(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
        return false;
    }

    boolean onNewsfeedClicked(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
        return false;
    }

    boolean onOtherUrlAction(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
        return false;
    }
}
