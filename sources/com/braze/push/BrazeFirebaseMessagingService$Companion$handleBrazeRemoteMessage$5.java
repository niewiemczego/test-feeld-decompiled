package com.braze.push;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeFirebaseMessagingService.kt */
final class BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$5 extends Lambda implements Function0<String> {
    final /* synthetic */ String $key;
    final /* synthetic */ String $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$5(String str, String str2) {
        super(0);
        this.$key = str;
        this.$value = str2;
    }

    public final String invoke() {
        return "Adding bundle item from FCM remote data with key: " + this.$key + " and value: " + this.$value;
    }
}
