package com.braze.reactbridge;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BrazeReactBridgeImpl.kt */
final class BrazeReactBridgeImpl$subscribeToPushNotificationEvents$2 extends Lambda implements Function0<String> {
    public static final BrazeReactBridgeImpl$subscribeToPushNotificationEvents$2 INSTANCE = new BrazeReactBridgeImpl$subscribeToPushNotificationEvents$2();

    BrazeReactBridgeImpl$subscribeToPushNotificationEvents$2() {
        super(0);
    }

    public final String invoke() {
        return "Cannot call subscribeToPushNotificationEvents without an active react instance";
    }
}