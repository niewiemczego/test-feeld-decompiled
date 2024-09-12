package com.facebook.appevents;

import com.facebook.internal.InstallReferrerUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/facebook/appevents/AppEventsLoggerImpl$Companion$getInstallReferrer$1", "Lcom/facebook/internal/InstallReferrerUtil$Callback;", "onReceiveReferrerUrl", "", "s", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEventsLoggerImpl.kt */
public final class AppEventsLoggerImpl$Companion$getInstallReferrer$1 implements InstallReferrerUtil.Callback {
    AppEventsLoggerImpl$Companion$getInstallReferrer$1() {
    }

    public void onReceiveReferrerUrl(String str) {
        AppEventsLoggerImpl.Companion.setInstallReferrer(str);
    }
}
