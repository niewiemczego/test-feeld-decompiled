package com.braze.ui.inappmessage;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeInAppMessageManager.kt */
final class BrazeInAppMessageManager$unregisterInAppMessageManager$3 extends Lambda implements Function0<String> {
    final /* synthetic */ Activity $activity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazeInAppMessageManager$unregisterInAppMessageManager$3(Activity activity) {
        super(0);
        this.$activity = activity;
    }

    public final String invoke() {
        return "Unregistering InAppMessageManager from activity: " + this.$activity.getLocalClassName();
    }
}
