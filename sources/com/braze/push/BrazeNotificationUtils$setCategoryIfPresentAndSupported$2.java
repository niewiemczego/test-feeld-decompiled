package com.braze.push;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeNotificationUtils.kt */
final class BrazeNotificationUtils$setCategoryIfPresentAndSupported$2 extends Lambda implements Function0<String> {
    public static final BrazeNotificationUtils$setCategoryIfPresentAndSupported$2 INSTANCE = new BrazeNotificationUtils$setCategoryIfPresentAndSupported$2();

    BrazeNotificationUtils$setCategoryIfPresentAndSupported$2() {
        super(0);
    }

    public final String invoke() {
        return "Category not present in notification extras. Not setting category for notification.";
    }
}
