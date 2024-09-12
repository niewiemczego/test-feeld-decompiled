package com.appsflyer.internal;

import com.appsflyer.internal.platform_extension.Plugin;
import com.appsflyer.internal.platform_extension.PluginInfo;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class AFf1qSDK implements AFf1rSDK {
    private PluginInfo valueOf = new PluginInfo(Plugin.NATIVE, "6.10.3", (Map) null, 4, (DefaultConstructorMarker) null);

    public final void AFKeystoreWrapper(PluginInfo pluginInfo) {
        Intrinsics.checkNotNullParameter(pluginInfo, "");
        this.valueOf = pluginInfo;
    }

    public final Map<String, Object> AFInAppEventType() {
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("platform", this.valueOf.getPlugin().getPluginName()), TuplesKt.to("version", this.valueOf.getVersion()));
        if (!this.valueOf.getAdditionalParams().isEmpty()) {
            mutableMapOf.put("extras", this.valueOf.getAdditionalParams());
        }
        return mutableMapOf;
    }
}
