package com.adapty.internal.utils;

import com.adapty.internal.data.models.AttributionData;
import com.adapty.models.AdaptyAttributionSource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\f\u001a\u00020\u0001H\u0002J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001H\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0014\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u000bH\u0002R!\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/adapty/internal/utils/AttributionHelper;", "", "()V", "adjustAttributionClass", "Ljava/lang/Class;", "getAdjustAttributionClass", "()Ljava/lang/Class;", "adjustAttributionClass$delegate", "Lkotlin/Lazy;", "convertAdjustAttributionToMap", "", "", "adjustAttribution", "convertAttribution", "attribution", "createAttributionData", "Lcom/adapty/internal/data/models/AttributionData;", "source", "Lcom/adapty/models/AdaptyAttributionSource;", "networkUserId", "getAdjustProperty", "propName", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AttributionHelper.kt */
public final class AttributionHelper {
    private final Lazy adjustAttributionClass$delegate = LazyKt.lazy(AttributionHelper$adjustAttributionClass$2.INSTANCE);

    public final /* synthetic */ AttributionData createAttributionData(Object obj, AdaptyAttributionSource adaptyAttributionSource, String str) {
        Intrinsics.checkNotNullParameter(obj, "attribution");
        Intrinsics.checkNotNullParameter(adaptyAttributionSource, "source");
        return new AttributionData(adaptyAttributionSource.toString(), convertAttribution(obj), str);
    }

    private final Object convertAttribution(Object obj) {
        if (obj instanceof JSONObject) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "attribution.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNullExpressionValue(next, "key");
                Object obj2 = jSONObject.get(next);
                Intrinsics.checkNotNullExpressionValue(obj2, "attribution.get(key)");
                hashMap.put(next, obj2);
            }
            return hashMap;
        }
        Class<?> adjustAttributionClass = getAdjustAttributionClass();
        boolean z = true;
        if (adjustAttributionClass == null || !adjustAttributionClass.isAssignableFrom(obj.getClass())) {
            z = false;
        }
        return z ? convertAdjustAttributionToMap(obj) : obj;
    }

    private final Class<?> getAdjustAttributionClass() {
        return (Class) this.adjustAttributionClass$delegate.getValue();
    }

    private final Map<String, Object> convertAdjustAttributionToMap(Object obj) {
        return MapsKt.mapOf(TuplesKt.to("adgroup", getAdjustProperty(obj, "adgroup")), TuplesKt.to("adid", getAdjustProperty(obj, "adid")), TuplesKt.to("campaign", getAdjustProperty(obj, "campaign")), TuplesKt.to("click_label", getAdjustProperty(obj, "clickLabel")), TuplesKt.to("creative", getAdjustProperty(obj, "creative")), TuplesKt.to("fbInstallReferrer", getAdjustProperty(obj, "fbInstallReferrer")), TuplesKt.to("network", getAdjustProperty(obj, "network")), TuplesKt.to("tracker_name", getAdjustProperty(obj, "trackerName")), TuplesKt.to("tracker_token", getAdjustProperty(obj, "trackerToken")));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r4 = r1.getField(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object getAdjustProperty(java.lang.Object r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            java.lang.Class r1 = r2.getAdjustAttributionClass()     // Catch:{ Exception -> 0x0018 }
            if (r1 == 0) goto L_0x0013
            java.lang.reflect.Field r4 = r1.getField(r4)     // Catch:{ Exception -> 0x0018 }
            if (r4 == 0) goto L_0x0013
            java.lang.Object r3 = r4.get(r3)     // Catch:{ Exception -> 0x0018 }
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            if (r3 != 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r0 = r3
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.AttributionHelper.getAdjustProperty(java.lang.Object, java.lang.String):java.lang.Object");
    }
}
