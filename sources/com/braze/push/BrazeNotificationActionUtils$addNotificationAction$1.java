package com.braze.push;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeNotificationActionUtils.kt */
final class BrazeNotificationActionUtils$addNotificationAction$1 extends Lambda implements Function0<String> {
    public static final BrazeNotificationActionUtils$addNotificationAction$1 INSTANCE = new BrazeNotificationActionUtils$addNotificationAction$1();

    BrazeNotificationActionUtils$addNotificationAction$1() {
        super(0);
    }

    public final String invoke() {
        return "Cannot add notification action with null context from payload";
    }
}
