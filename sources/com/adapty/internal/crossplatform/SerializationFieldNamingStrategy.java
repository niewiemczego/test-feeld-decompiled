package com.adapty.internal.crossplatform;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import java.lang.reflect.Field;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/adapty/internal/crossplatform/SerializationFieldNamingStrategy;", "Lcom/google/gson/FieldNamingStrategy;", "()V", "translateDefault", "", "kotlin.jvm.PlatformType", "f", "Ljava/lang/reflect/Field;", "translateName", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SerializationFieldNamingStrategy.kt */
public final class SerializationFieldNamingStrategy implements FieldNamingStrategy {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String translateName(java.lang.reflect.Field r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0008
            java.lang.Class r1 = r5.getDeclaringClass()
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            java.lang.Class<com.adapty.models.AdaptyPaywall> r2 = com.adapty.models.AdaptyPaywall.class
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            java.lang.String r3 = "when (f.name) {\n        …eDefault(f)\n            }"
            if (r2 == 0) goto L_0x005a
            java.lang.String r0 = r5.getName()
            if (r0 == 0) goto L_0x0051
            int r1 = r0.hashCode()
            switch(r1) {
                case -1949194674: goto L_0x0045;
                case 3373707: goto L_0x0039;
                case 121082583: goto L_0x002d;
                case 732231392: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x0051
        L_0x0021:
            java.lang.String r1 = "placementId"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002a
            goto L_0x0051
        L_0x002a:
            java.lang.String r5 = "developer_id"
            goto L_0x0055
        L_0x002d:
            java.lang.String r1 = "hasViewConfiguration"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0036
            goto L_0x0051
        L_0x0036:
            java.lang.String r5 = "use_paywall_builder"
            goto L_0x0055
        L_0x0039:
            java.lang.String r1 = "name"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0042
            goto L_0x0051
        L_0x0042:
            java.lang.String r5 = "paywall_name"
            goto L_0x0055
        L_0x0045:
            java.lang.String r1 = "updatedAt"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x004e
            goto L_0x0051
        L_0x004e:
            java.lang.String r5 = "paywall_updated_at"
            goto L_0x0055
        L_0x0051:
            java.lang.String r5 = r4.translateDefault(r5)
        L_0x0055:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            goto L_0x013d
        L_0x005a:
            java.lang.Class<com.adapty.models.AdaptyPaywallProduct> r2 = com.adapty.models.AdaptyPaywallProduct.class
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0085
            java.lang.String r0 = r5.getName()
            java.lang.String r1 = "paywallABTestName"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0071
            java.lang.String r5 = "paywall_ab_test_name"
            goto L_0x0080
        L_0x0071:
            java.lang.String r1 = "variationId"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x007c
            java.lang.String r5 = "paywall_variation_id"
            goto L_0x0080
        L_0x007c:
            java.lang.String r5 = r4.translateDefault(r5)
        L_0x0080:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            goto L_0x013d
        L_0x0085:
            java.lang.Class<com.adapty.models.AdaptyPaywallProduct$Price> r2 = com.adapty.models.AdaptyPaywallProduct.Price.class
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x00a5
            java.lang.String r0 = r5.getName()
            java.lang.String r1 = "localizedPrice"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x009c
            java.lang.String r5 = "localized_string"
            goto L_0x00a0
        L_0x009c:
            java.lang.String r5 = r4.translateDefault(r5)
        L_0x00a0:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            goto L_0x013d
        L_0x00a5:
            java.lang.Class<com.adapty.models.AdaptyProductSubscriptionDetails> r2 = com.adapty.models.AdaptyProductSubscriptionDetails.class
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x00f2
            java.lang.String r0 = r5.getName()
            if (r0 == 0) goto L_0x00ea
            int r1 = r0.hashCode()
            r2 = -1548813161(0xffffffffa3aefc97, float:-1.8972094E-17)
            if (r1 == r2) goto L_0x00de
            r2 = -911523755(0xffffffffc9ab4055, float:-1402890.6)
            if (r1 == r2) goto L_0x00d3
            r2 = 1944532117(0x73e73495, float:3.6635958E31)
            if (r1 == r2) goto L_0x00c7
            goto L_0x00ea
        L_0x00c7:
            java.lang.String r1 = "offerTags"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00d0
            goto L_0x00ea
        L_0x00d0:
            java.lang.String r5 = "android_offer_tags"
            goto L_0x00ee
        L_0x00d3:
            java.lang.String r1 = "basePlanId"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00ea
            java.lang.String r5 = "android_base_plan_id"
            goto L_0x00ee
        L_0x00de:
            java.lang.String r1 = "offerId"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00e7
            goto L_0x00ea
        L_0x00e7:
            java.lang.String r5 = "android_offer_id"
            goto L_0x00ee
        L_0x00ea:
            java.lang.String r5 = r4.translateDefault(r5)
        L_0x00ee:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            goto L_0x013d
        L_0x00f2:
            java.lang.Class<com.adapty.models.AdaptyProfile> r2 = com.adapty.models.AdaptyProfile.class
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0111
            java.lang.String r0 = r5.getName()
            java.lang.String r1 = "accessLevels"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0109
            java.lang.String r5 = "paid_access_levels"
            goto L_0x010d
        L_0x0109:
            java.lang.String r5 = r4.translateDefault(r5)
        L_0x010d:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            goto L_0x013d
        L_0x0111:
            java.lang.Class<com.adapty.internal.domain.models.BackendProduct> r2 = com.adapty.internal.crossplatform.AdaptyProductTypeTypeAdapterFactory.backendProductClass
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0134
            if (r5 == 0) goto L_0x011f
            java.lang.String r0 = r5.getName()
        L_0x011f:
            java.lang.String r1 = "id"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x012a
            java.lang.String r5 = "adapty_product_id"
            goto L_0x012e
        L_0x012a:
            java.lang.String r5 = r4.translateDefault(r5)
        L_0x012e:
            java.lang.String r0 = "when (f?.name) {\n       …eDefault(f)\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            goto L_0x013d
        L_0x0134:
            java.lang.String r5 = r4.translateDefault(r5)
            java.lang.String r0 = "translateDefault(f)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
        L_0x013d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.crossplatform.SerializationFieldNamingStrategy.translateName(java.lang.reflect.Field):java.lang.String");
    }

    private final String translateDefault(Field field) {
        return FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES.translateName(field);
    }
}
