package com.braze.push;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeNotificationUtils.kt */
final class BrazeNotificationUtils$getNotificationId$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Integer $customNotificationId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazeNotificationUtils$getNotificationId$1(Integer num) {
        super(0);
        this.$customNotificationId = num;
    }

    public final String invoke() {
        return "Using notification id provided in the message's extras bundle: " + this.$customNotificationId;
    }
}
