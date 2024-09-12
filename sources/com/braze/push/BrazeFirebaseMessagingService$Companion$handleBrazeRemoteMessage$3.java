package com.braze.push;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeFirebaseMessagingService.kt */
final class BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$3 extends Lambda implements Function0<String> {
    public static final BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$3 INSTANCE = new BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$3();

    BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$3() {
        super(0);
    }

    public final String invoke() {
        return "Fallback FCM service enabled but classpath is null. Not routing to any fallback service.";
    }
}
