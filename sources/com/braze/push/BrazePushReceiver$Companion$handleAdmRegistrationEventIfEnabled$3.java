package com.braze.push;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazePushReceiver.kt */
final class BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$3 extends Lambda implements Function0<String> {
    public static final BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$3 INSTANCE = new BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$3();

    BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$3() {
        super(0);
    }

    public final String invoke() {
        return "ADM not enabled in braze.xml. Ignoring ADM registration intent. Note: you must set com_braze_push_adm_messaging_registration_enabled to true in your braze.xml to enable ADM.";
    }
}