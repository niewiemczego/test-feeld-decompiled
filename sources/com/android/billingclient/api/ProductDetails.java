package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzaf;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class ProductDetails {
    private final String zza;
    private final JSONObject zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final String zzi;
    private final String zzj;
    private final String zzk;
    private final List zzl;
    private final List zzm;

    /* compiled from: com.android.billingclient:billing@@6.1.0 */
    public static final class OneTimePurchaseOfferDetails {
        private final String zza;
        private final long zzb;
        private final String zzc;
        private final String zzd;
        private final String zze;
        private final zzaf zzf;
        private final Long zzg;
        private final zzbz zzh;
        private final zzcc zzi;
        private final zzca zzj;
        private final zzcb zzk;

        OneTimePurchaseOfferDetails(JSONObject jSONObject) throws JSONException {
            zzbz zzbz;
            zzcc zzcc;
            zzca zzca;
            this.zza = jSONObject.optString("formattedPrice");
            this.zzb = jSONObject.optLong("priceAmountMicros");
            this.zzc = jSONObject.optString("priceCurrencyCode");
            this.zzd = jSONObject.optString("offerIdToken");
            this.zze = jSONObject.optString("offerId");
            jSONObject.optInt("offerType");
            JSONArray optJSONArray = jSONObject.optJSONArray("offerTags");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.getString(i));
                }
            }
            this.zzf = zzaf.zzj(arrayList);
            zzcb zzcb = null;
            this.zzg = jSONObject.has("fullPriceMicros") ? Long.valueOf(jSONObject.optLong("fullPriceMicros")) : null;
            JSONObject optJSONObject = jSONObject.optJSONObject("discountDisplayInfo");
            if (optJSONObject == null) {
                zzbz = null;
            } else {
                zzbz = new zzbz(optJSONObject);
            }
            this.zzh = zzbz;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("validTimeWindow");
            if (optJSONObject2 == null) {
                zzcc = null;
            } else {
                zzcc = new zzcc(optJSONObject2);
            }
            this.zzi = zzcc;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("limitedQuantityInfo");
            if (optJSONObject3 == null) {
                zzca = null;
            } else {
                zzca = new zzca(optJSONObject3);
            }
            this.zzj = zzca;
            JSONObject optJSONObject4 = jSONObject.optJSONObject("preorderDetails");
            this.zzk = optJSONObject4 != null ? new zzcb(optJSONObject4) : zzcb;
        }

        public String getFormattedPrice() {
            return this.zza;
        }

        public long getPriceAmountMicros() {
            return this.zzb;
        }

        public String getPriceCurrencyCode() {
            return this.zzc;
        }

        public final String zza() {
            return this.zzd;
        }
    }

    /* compiled from: com.android.billingclient:billing@@6.1.0 */
    public static final class PricingPhase {
        private final String zza;
        private final long zzb;
        private final String zzc;
        private final String zzd;
        private final int zze;
        private final int zzf;

        PricingPhase(JSONObject jSONObject) {
            this.zzd = jSONObject.optString("billingPeriod");
            this.zzc = jSONObject.optString("priceCurrencyCode");
            this.zza = jSONObject.optString("formattedPrice");
            this.zzb = jSONObject.optLong("priceAmountMicros");
            this.zzf = jSONObject.optInt("recurrenceMode");
            this.zze = jSONObject.optInt("billingCycleCount");
        }

        public int getBillingCycleCount() {
            return this.zze;
        }

        public String getBillingPeriod() {
            return this.zzd;
        }

        public String getFormattedPrice() {
            return this.zza;
        }

        public long getPriceAmountMicros() {
            return this.zzb;
        }

        public String getPriceCurrencyCode() {
            return this.zzc;
        }

        public int getRecurrenceMode() {
            return this.zzf;
        }
    }

    /* compiled from: com.android.billingclient:billing@@6.1.0 */
    public static class PricingPhases {
        private final List zza;

        PricingPhases(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        arrayList.add(new PricingPhase(optJSONObject));
                    }
                }
            }
            this.zza = arrayList;
        }

        public List<PricingPhase> getPricingPhaseList() {
            return this.zza;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.android.billingclient:billing@@6.1.0 */
    public @interface RecurrenceMode {
        public static final int FINITE_RECURRING = 2;
        public static final int INFINITE_RECURRING = 1;
        public static final int NON_RECURRING = 3;
    }

    /* compiled from: com.android.billingclient:billing@@6.1.0 */
    public static final class SubscriptionOfferDetails {
        private final String zza;
        private final String zzb;
        private final String zzc;
        private final PricingPhases zzd;
        private final List zze;
        private final zzby zzf;

        SubscriptionOfferDetails(JSONObject jSONObject) throws JSONException {
            this.zza = jSONObject.optString("basePlanId");
            String optString = jSONObject.optString("offerId");
            zzby zzby = null;
            this.zzb = true == optString.isEmpty() ? null : optString;
            this.zzc = jSONObject.getString("offerIdToken");
            this.zzd = new PricingPhases(jSONObject.getJSONArray("pricingPhases"));
            JSONObject optJSONObject = jSONObject.optJSONObject("installmentPlanDetails");
            this.zzf = optJSONObject != null ? new zzby(optJSONObject) : zzby;
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("offerTags");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.getString(i));
                }
            }
            this.zze = arrayList;
        }

        public String getBasePlanId() {
            return this.zza;
        }

        public String getOfferId() {
            return this.zzb;
        }

        public List<String> getOfferTags() {
            return this.zze;
        }

        public String getOfferToken() {
            return this.zzc;
        }

        public PricingPhases getPricingPhases() {
            return this.zzd;
        }
    }

    ProductDetails(String str) throws JSONException {
        ArrayList arrayList;
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        String optString = jSONObject.optString("productId");
        this.zzc = optString;
        String optString2 = jSONObject.optString("type");
        this.zzd = optString2;
        if (TextUtils.isEmpty(optString)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        } else if (!TextUtils.isEmpty(optString2)) {
            this.zze = jSONObject.optString("title");
            this.zzf = jSONObject.optString("name");
            this.zzg = jSONObject.optString("description");
            this.zzi = jSONObject.optString("packageDisplayName");
            this.zzj = jSONObject.optString("iconUrl");
            this.zzh = jSONObject.optString("skuDetailsToken");
            this.zzk = jSONObject.optString("serializedDocid");
            JSONArray optJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
            if (optJSONArray != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList2.add(new SubscriptionOfferDetails(optJSONArray.getJSONObject(i)));
                }
                this.zzl = arrayList2;
            } else {
                if (optString2.equals("subs") || optString2.equals("play_pass_subs")) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = null;
                }
                this.zzl = arrayList;
            }
            JSONObject optJSONObject = this.zzb.optJSONObject("oneTimePurchaseOfferDetails");
            JSONArray optJSONArray2 = this.zzb.optJSONArray("oneTimePurchaseOfferDetailsList");
            ArrayList arrayList3 = new ArrayList();
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    arrayList3.add(new OneTimePurchaseOfferDetails(optJSONArray2.getJSONObject(i2)));
                }
                this.zzm = arrayList3;
            } else if (optJSONObject != null) {
                arrayList3.add(new OneTimePurchaseOfferDetails(optJSONObject));
                this.zzm = arrayList3;
            } else {
                this.zzm = null;
            }
        } else {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetails)) {
            return false;
        }
        return TextUtils.equals(this.zza, ((ProductDetails) obj).zza);
    }

    public String getDescription() {
        return this.zzg;
    }

    public String getName() {
        return this.zzf;
    }

    public OneTimePurchaseOfferDetails getOneTimePurchaseOfferDetails() {
        List list = this.zzm;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (OneTimePurchaseOfferDetails) this.zzm.get(0);
    }

    public String getProductId() {
        return this.zzc;
    }

    public String getProductType() {
        return this.zzd;
    }

    public List<SubscriptionOfferDetails> getSubscriptionOfferDetails() {
        return this.zzl;
    }

    public String getTitle() {
        return this.zze;
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    public String toString() {
        List list = this.zzl;
        String obj = this.zzb.toString();
        String valueOf = String.valueOf(list);
        return "ProductDetails{jsonString='" + this.zza + "', parsedJson=" + obj + ", productId='" + this.zzc + "', productType='" + this.zzd + "', title='" + this.zze + "', productDetailsToken='" + this.zzh + "', subscriptionOfferDetails=" + valueOf + "}";
    }

    public final String zza() {
        return this.zzb.optString("packageName");
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzh;
    }

    public String zzc() {
        return this.zzk;
    }
}
