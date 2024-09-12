package com.facebook.login;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/facebook/login/DeviceLoginManager;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: DeviceLoginManager.kt */
final class DeviceLoginManager$Companion$instance$2 extends Lambda implements Function0<DeviceLoginManager> {
    public static final DeviceLoginManager$Companion$instance$2 INSTANCE = new DeviceLoginManager$Companion$instance$2();

    DeviceLoginManager$Companion$instance$2() {
        super(0);
    }

    public final DeviceLoginManager invoke() {
        return new DeviceLoginManager();
    }
}
