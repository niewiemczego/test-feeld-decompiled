package com.appsflyer.internal.platform_extension;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u001bB/\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0013\u001a\u00020\bHÇ\u0003¢\u0006\u0004\b\u0013\u0010\fJ\u0010\u0010\u0014\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u0014\u0010\u0011J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001HÇ\u0003¢\u0006\u0004\b\u0015\u0010\u0006J:\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00022\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001HÇ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\"\u0010\u0011R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00018\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lcom/appsflyer/internal/platform_extension/PluginInfo;", "", "", "values", "Ljava/util/Map;", "getAdditionalParams", "()Ljava/util/Map;", "additionalParams", "Lcom/appsflyer/internal/platform_extension/Plugin;", "valueOf", "Lcom/appsflyer/internal/platform_extension/Plugin;", "getPlugin", "()Lcom/appsflyer/internal/platform_extension/Plugin;", "plugin", "AFInAppEventParameterName", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "version", "component1", "component2", "component3", "p0", "p1", "p2", "copy", "(Lcom/appsflyer/internal/platform_extension/Plugin;Ljava/lang/String;Ljava/util/Map;)Lcom/appsflyer/internal/platform_extension/PluginInfo;", "", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "<init>", "(Lcom/appsflyer/internal/platform_extension/Plugin;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PluginInfo {
    private final String AFInAppEventParameterName;
    private final Plugin valueOf;
    private final Map<String, String> values;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PluginInfo(Plugin plugin, String str) {
        this(plugin, str, (Map) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(plugin, "");
        Intrinsics.checkNotNullParameter(str, "");
    }

    public static /* synthetic */ PluginInfo copy$default(PluginInfo pluginInfo, Plugin plugin, String str, Map<String, String> map, int i, Object obj) {
        if ((i & 1) != 0) {
            plugin = pluginInfo.valueOf;
        }
        if ((i & 2) != 0) {
            str = pluginInfo.AFInAppEventParameterName;
        }
        if ((i & 4) != 0) {
            map = pluginInfo.values;
        }
        return pluginInfo.copy(plugin, str, map);
    }

    public final Plugin component1() {
        return this.valueOf;
    }

    public final String component2() {
        return this.AFInAppEventParameterName;
    }

    public final Map<String, String> component3() {
        return this.values;
    }

    public final PluginInfo copy(Plugin plugin, String str, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(plugin, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(map, "");
        return new PluginInfo(plugin, str, map);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PluginInfo)) {
            return false;
        }
        PluginInfo pluginInfo = (PluginInfo) obj;
        return this.valueOf == pluginInfo.valueOf && Intrinsics.areEqual((Object) this.AFInAppEventParameterName, (Object) pluginInfo.AFInAppEventParameterName) && Intrinsics.areEqual((Object) this.values, (Object) pluginInfo.values);
    }

    public final int hashCode() {
        return (((this.valueOf.hashCode() * 31) + this.AFInAppEventParameterName.hashCode()) * 31) + this.values.hashCode();
    }

    public final String toString() {
        return new StringBuilder("PluginInfo(plugin=").append(this.valueOf).append(", version=").append(this.AFInAppEventParameterName).append(", additionalParams=").append(this.values).append(')').toString();
    }

    public PluginInfo(Plugin plugin, String str, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(plugin, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.valueOf = plugin;
        this.AFInAppEventParameterName = str;
        this.values = map;
    }

    public final Plugin getPlugin() {
        return this.valueOf;
    }

    public final String getVersion() {
        return this.AFInAppEventParameterName;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PluginInfo(Plugin plugin, String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(plugin, str, (i & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, String> getAdditionalParams() {
        return this.values;
    }
}
