package com.braze.push;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeNotificationUtils.kt */
final class BrazeNotificationUtils$wakeScreenIfAppropriate$3 extends Lambda implements Function0<String> {
    public static final BrazeNotificationUtils$wakeScreenIfAppropriate$3 INSTANCE = new BrazeNotificationUtils$wakeScreenIfAppropriate$3();

    BrazeNotificationUtils$wakeScreenIfAppropriate$3() {
        super(0);
    }

    public final String invoke() {
        return "Not waking screen on Android O+ device, could not find notification channel.";
    }
}
