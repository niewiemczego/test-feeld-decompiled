package com.braze.push;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazePushReceiver.kt */
final class BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Intent $intent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$1(Intent intent) {
        super(0);
        this.$intent = intent;
    }

    public final String invoke() {
        return "Received ADM registration. Message: " + this.$intent;
    }
}
