package com.facebook.internal.gatekeeper;

import com.facebook.FacebookSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\f\b\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u0006J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00072\f\b\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\f\u001a\u00020\u0005J$\u0010\r\u001a\u00020\u000e2\f\b\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u0014\u0010\u0010\u001a\u00020\u00112\f\b\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u0006J\u001c\u0010\u0012\u001a\u00020\u00112\f\b\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0013\u001a\u00020\u0007J$\u0010\u0014\u001a\u00020\u00112\f\b\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000eJ\"\u0010\u0016\u001a\u00020\u00112\f\b\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\tR*\u0010\u0003\u001a\u001e\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "", "()V", "gateKeepers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/facebook/internal/gatekeeper/AppID;", "Lcom/facebook/internal/gatekeeper/GateKeeper;", "dumpGateKeepers", "", "appId", "getGateKeeper", "name", "getGateKeeperValue", "", "defaultValue", "resetCache", "", "setGateKeeper", "gateKeeper", "setGateKeeperValue", "value", "setGateKeepers", "gateKeeperList", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GateKeeperRuntimeCache.kt */
public final class GateKeeperRuntimeCache {
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, GateKeeper>> gateKeepers = new ConcurrentHashMap<>();

    public static /* synthetic */ void setGateKeepers$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.setGateKeepers(str, list);
    }

    public final void setGateKeepers(String str, List<GateKeeper> list) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(list, "gateKeeperList");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (GateKeeper gateKeeper : list) {
            concurrentHashMap.put(gateKeeper.getName(), gateKeeper);
        }
        this.gateKeepers.put(str, concurrentHashMap);
    }

    public static /* synthetic */ List dumpGateKeepers$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        return gateKeeperRuntimeCache.dumpGateKeepers(str);
    }

    public final List<GateKeeper> dumpGateKeepers(String str) {
        Intrinsics.checkNotNullParameter(str, "appId");
        ConcurrentHashMap concurrentHashMap = this.gateKeepers.get(str);
        if (concurrentHashMap == null) {
            return null;
        }
        Map map = concurrentHashMap;
        Collection arrayList = new ArrayList(map.size());
        for (Map.Entry value : map.entrySet()) {
            arrayList.add((GateKeeper) value.getValue());
        }
        return (List) arrayList;
    }

    public static /* synthetic */ boolean getGateKeeperValue$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        return gateKeeperRuntimeCache.getGateKeeperValue(str, str2, z);
    }

    public final boolean getGateKeeperValue(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "name");
        GateKeeper gateKeeper = getGateKeeper(str, str2);
        return gateKeeper == null ? z : gateKeeper.getValue();
    }

    public static /* synthetic */ void setGateKeeperValue$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.setGateKeeperValue(str, str2, z);
    }

    public final void setGateKeeperValue(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "name");
        setGateKeeper(str, new GateKeeper(str2, z));
    }

    public static /* synthetic */ GateKeeper getGateKeeper$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        return gateKeeperRuntimeCache.getGateKeeper(str, str2);
    }

    public final GateKeeper getGateKeeper(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "name");
        ConcurrentHashMap concurrentHashMap = this.gateKeepers.get(str);
        if (concurrentHashMap == null) {
            return null;
        }
        return (GateKeeper) concurrentHashMap.get(str2);
    }

    public static /* synthetic */ void setGateKeeper$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, GateKeeper gateKeeper, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.setGateKeeper(str, gateKeeper);
    }

    public final void setGateKeeper(String str, GateKeeper gateKeeper) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(gateKeeper, "gateKeeper");
        if (!this.gateKeepers.containsKey(str)) {
            this.gateKeepers.put(str, new ConcurrentHashMap());
        }
        ConcurrentHashMap concurrentHashMap = this.gateKeepers.get(str);
        if (concurrentHashMap != null) {
            concurrentHashMap.put(gateKeeper.getName(), gateKeeper);
        }
    }

    public static /* synthetic */ void resetCache$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.resetCache(str);
    }

    public final void resetCache(String str) {
        Intrinsics.checkNotNullParameter(str, "appId");
        this.gateKeepers.remove(str);
    }
}
