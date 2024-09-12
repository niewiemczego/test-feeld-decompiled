package com.braze.push;

import android.app.NotificationChannel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeNotificationUtils.kt */
final class BrazeNotificationUtils$wakeScreenIfAppropriate$4 extends Lambda implements Function0<String> {
    final /* synthetic */ NotificationChannel $notificationChannel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazeNotificationUtils$wakeScreenIfAppropriate$4(NotificationChannel notificationChannel) {
        super(0);
        this.$notificationChannel = notificationChannel;
    }

    public final String invoke() {
        return "Not acquiring wake-lock for Android O+ notification with importance: " + this.$notificationChannel.getImportance();
    }
}