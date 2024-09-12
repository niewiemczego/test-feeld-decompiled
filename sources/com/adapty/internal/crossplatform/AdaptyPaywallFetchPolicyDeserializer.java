package com.adapty.internal.crossplatform;

import com.adapty.models.AdaptyPaywall;
import com.google.gson.JsonDeserializer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/crossplatform/AdaptyPaywallFetchPolicyDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/adapty/models/AdaptyPaywall$FetchPolicy;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyPaywallFetchPolicyDeserializer.kt */
public final class AdaptyPaywallFetchPolicyDeserializer implements JsonDeserializer<AdaptyPaywall.FetchPolicy> {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.adapty.models.AdaptyPaywall.FetchPolicy deserialize(com.google.gson.JsonElement r3, java.lang.reflect.Type r4, com.google.gson.JsonDeserializationContext r5) {
        /*
            r2 = this;
            java.lang.String r0 = "json"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "typeOfT"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r4 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)
            boolean r4 = r3 instanceof com.google.gson.JsonObject
            r5 = 0
            if (r4 == 0) goto L_0x0017
            com.google.gson.JsonObject r3 = (com.google.gson.JsonObject) r3
            goto L_0x0018
        L_0x0017:
            r3 = r5
        L_0x0018:
            if (r3 != 0) goto L_0x001d
            com.adapty.models.AdaptyPaywall$FetchPolicy r3 = com.adapty.models.AdaptyPaywall.FetchPolicy.Default
            return r3
        L_0x001d:
            java.lang.String r4 = "type"
            com.google.gson.JsonElement r4 = r3.get(r4)
            if (r4 == 0) goto L_0x0034
            boolean r0 = r4.isJsonPrimitive()
            if (r0 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r4 = r5
        L_0x002d:
            if (r4 == 0) goto L_0x0034
            java.lang.String r4 = r4.getAsString()
            goto L_0x0035
        L_0x0034:
            r4 = r5
        L_0x0035:
            if (r4 == 0) goto L_0x00a0
            int r0 = r4.hashCode()
            r1 = -1045468435(0xffffffffc1af6aed, float:-21.92721)
            if (r0 == r1) goto L_0x0062
            r3 = 659124410(0x274970ba, float:2.7955463E-15)
            if (r0 == r3) goto L_0x0056
            r3 = 1764536291(0x692cafe3, float:1.3047865E25)
            if (r0 == r3) goto L_0x004b
            goto L_0x00a0
        L_0x004b:
            java.lang.String r3 = "return_cache_data_else_load"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00a0
            com.adapty.models.AdaptyPaywall$FetchPolicy r3 = com.adapty.models.AdaptyPaywall.FetchPolicy.ReturnCacheDataElseLoad
            goto L_0x00a2
        L_0x0056:
            java.lang.String r3 = "reload_revalidating_cache_data"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x005f
            goto L_0x00a0
        L_0x005f:
            com.adapty.models.AdaptyPaywall$FetchPolicy r3 = com.adapty.models.AdaptyPaywall.FetchPolicy.ReloadRevalidatingCacheData
            goto L_0x00a2
        L_0x0062:
            java.lang.String r0 = "return_cache_data_if_not_expired_else_load"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x006b
            goto L_0x00a0
        L_0x006b:
            java.lang.String r4 = "max_age"
            com.google.gson.JsonElement r3 = r3.get(r4)
            if (r3 == 0) goto L_0x0090
            boolean r4 = r3.isJsonPrimitive()
            if (r4 == 0) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r3 = r5
        L_0x007b:
            if (r3 == 0) goto L_0x0090
            java.lang.Number r3 = r3.getAsNumber()
            if (r3 == 0) goto L_0x0090
            double r3 = r3.doubleValue()
            r5 = 1000(0x3e8, float:1.401E-42)
            double r0 = (double) r5
            double r3 = r3 * r0
            long r3 = (long) r3
            java.lang.Long r5 = java.lang.Long.valueOf(r3)
        L_0x0090:
            if (r5 == 0) goto L_0x009d
            com.adapty.models.AdaptyPaywall$FetchPolicy$Companion r3 = com.adapty.models.AdaptyPaywall.FetchPolicy.Companion
            long r4 = r5.longValue()
            com.adapty.models.AdaptyPaywall$FetchPolicy r3 = r3.ReturnCacheDataIfNotExpiredElseLoad(r4)
            goto L_0x00a2
        L_0x009d:
            com.adapty.models.AdaptyPaywall$FetchPolicy r3 = com.adapty.models.AdaptyPaywall.FetchPolicy.Default
            goto L_0x00a2
        L_0x00a0:
            com.adapty.models.AdaptyPaywall$FetchPolicy r3 = com.adapty.models.AdaptyPaywall.FetchPolicy.Default
        L_0x00a2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.crossplatform.AdaptyPaywallFetchPolicyDeserializer.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):com.adapty.models.AdaptyPaywall$FetchPolicy");
    }
}
