package com.braze.push;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeFirebaseMessagingService.kt */
final class BrazeFirebaseMessagingService$onNewToken$2 extends Lambda implements Function0<String> {
    final /* synthetic */ String $newToken;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazeFirebaseMessagingService$onNewToken$2(String str) {
        super(0);
        this.$newToken = str;
    }

    public final String invoke() {
        return "Automatic FirebaseMessagingService.OnNewToken() registration disabled, not registering token: " + this.$newToken;
    }
}
