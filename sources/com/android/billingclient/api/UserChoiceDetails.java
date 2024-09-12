package com.android.billingclient.api;

import com.adapty.internal.crossplatform.AdaptyPaywallTypeAdapterFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class UserChoiceDetails {
    private final String zza;
    private final JSONObject zzb;
    private final List zzc;

    /* compiled from: com.android.billingclient:billing@@6.1.0 */
    public static class Product {
        private final String zza;
        private final String zzb;
        private final String zzc;

        /* synthetic */ Product(JSONObject jSONObject, zzcq zzcq) {
            this.zza = jSONObject.optString("productId");
            this.zzb = jSONObject.optString("productType");
            String optString = jSONObject.optString("offerToken");
            this.zzc = true == optString.isEmpty() ? null : optString;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
            r1 = r4.zzc;
            r5 = r5.getOfferToken();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L_0x0004
                return r0
            L_0x0004:
                boolean r1 = r5 instanceof com.android.billingclient.api.UserChoiceDetails.Product
                r2 = 0
                if (r1 != 0) goto L_0x000a
                return r2
            L_0x000a:
                com.android.billingclient.api.UserChoiceDetails$Product r5 = (com.android.billingclient.api.UserChoiceDetails.Product) r5
                java.lang.String r1 = r4.zza
                java.lang.String r3 = r5.getId()
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L_0x0035
                java.lang.String r1 = r4.zzb
                java.lang.String r3 = r5.getType()
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L_0x0035
                java.lang.String r1 = r4.zzc
                java.lang.String r5 = r5.getOfferToken()
                if (r1 == r5) goto L_0x0034
                if (r1 == 0) goto L_0x0035
                boolean r5 = r1.equals(r5)
                if (r5 == 0) goto L_0x0035
            L_0x0034:
                return r0
            L_0x0035:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.UserChoiceDetails.Product.equals(java.lang.Object):boolean");
        }

        public String getId() {
            return this.zza;
        }

        public String getOfferToken() {
            return this.zzc;
        }

        public String getType() {
            return this.zzb;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc});
        }

        public String toString() {
            return String.format("{id: %s, type: %s, offer token: %s}", new Object[]{this.zza, this.zzb, this.zzc});
        }
    }

    UserChoiceDetails(String str) throws JSONException {
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray(AdaptyPaywallTypeAdapterFactory.PRODUCTS);
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(new Product(optJSONObject, (zzcq) null));
                }
            }
        }
        this.zzc = arrayList;
    }

    public String getExternalTransactionToken() {
        return this.zzb.optString("externalTransactionToken");
    }

    public String getOriginalExternalTransactionId() {
        String optString = this.zzb.optString("originalExternalTransactionId");
        if (optString.isEmpty()) {
            return null;
        }
        return optString;
    }

    public List<Product> getProducts() {
        return this.zzc;
    }
}
