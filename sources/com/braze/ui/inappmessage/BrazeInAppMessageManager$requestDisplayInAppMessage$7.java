package com.braze.ui.inappmessage;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeInAppMessageManager.kt */
final class BrazeInAppMessageManager$requestDisplayInAppMessage$7 extends Lambda implements Function0<String> {
    public static final BrazeInAppMessageManager$requestDisplayInAppMessage$7 INSTANCE = new BrazeInAppMessageManager$requestDisplayInAppMessage$7();

    BrazeInAppMessageManager$requestDisplayInAppMessage$7() {
        super(0);
    }

    public final String invoke() {
        return "The IInAppMessageManagerListener method beforeInAppMessageDisplayed returned DISCARD. The in-app message will not be displayed and will not be put back on the stack.";
    }
}
