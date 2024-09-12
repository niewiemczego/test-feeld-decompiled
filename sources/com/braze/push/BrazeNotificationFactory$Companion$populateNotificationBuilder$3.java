package com.braze.push;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeNotificationFactory.kt */
final class BrazeNotificationFactory$Companion$populateNotificationBuilder$3 extends Lambda implements Function0<String> {
    public static final BrazeNotificationFactory$Companion$populateNotificationBuilder$3 INSTANCE = new BrazeNotificationFactory$Companion$populateNotificationBuilder$3();

    BrazeNotificationFactory$Companion$populateNotificationBuilder$3() {
        super(0);
    }

    public final String invoke() {
        return "BrazeNotificationPayload has null app configuration provider. Not creating notification";
    }
}
