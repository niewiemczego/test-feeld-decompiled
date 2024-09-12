package com.braze.push;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazePushReceiver.kt */
final class BrazePushReceiver$Companion$handleAdmRegistrationIntent$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $error;
    final /* synthetic */ String $errorDescription;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazePushReceiver$Companion$handleAdmRegistrationIntent$1(String str, String str2) {
        super(0);
        this.$error = str;
        this.$errorDescription = str2;
    }

    public final String invoke() {
        return "Error during ADM registration: " + this.$error + " description: " + this.$errorDescription;
    }
}
