package com.braze.ui.inappmessage;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeInAppMessageManager.kt */
final class BrazeInAppMessageManager$displayInAppMessage$8 extends Lambda implements Function0<String> {
    public static final BrazeInAppMessageManager$displayInAppMessage$8 INSTANCE = new BrazeInAppMessageManager$displayInAppMessage$8();

    BrazeInAppMessageManager$displayInAppMessage$8() {
        super(0);
    }

    public final String invoke() {
        return "Cannot show message containing a Push Prompt due to existing push prompt status, Android API version, or Target SDK level.";
    }
}
