package com.adapty.internal.data.models;

import com.adapty.internal.crossplatform.AdaptyPaywallTypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b%\b\b\u0018\u00002\u00020\u0001Bw\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\u00132\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\tHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R&\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0016¨\u00068"}, d2 = {"Lcom/adapty/internal/data/models/PaywallDto;", "", "developerId", "", "name", "updatedAt", "", "abTestName", "revision", "", "variationId", "paywallId", "products", "Ljava/util/ArrayList;", "Lcom/adapty/internal/data/models/ProductDto;", "Lkotlin/collections/ArrayList;", "remoteConfig", "Lcom/adapty/internal/data/models/RemoteConfigDto;", "hasViewConfiguration", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/adapty/internal/data/models/RemoteConfigDto;Ljava/lang/Boolean;)V", "getAbTestName", "()Ljava/lang/String;", "getDeveloperId", "getHasViewConfiguration", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getPaywallId", "getProducts", "()Ljava/util/ArrayList;", "getRemoteConfig", "()Lcom/adapty/internal/data/models/RemoteConfigDto;", "getRevision", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUpdatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVariationId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/adapty/internal/data/models/RemoteConfigDto;Ljava/lang/Boolean;)Lcom/adapty/internal/data/models/PaywallDto;", "equals", "other", "hashCode", "toString", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PaywallDto.kt */
public final class PaywallDto {
    @SerializedName("ab_test_name")
    private final String abTestName;
    @SerializedName("developer_id")
    private final String developerId;
    @SerializedName("use_paywall_builder")
    private final Boolean hasViewConfiguration;
    @SerializedName("paywall_name")
    private final String name;
    @SerializedName("paywall_id")
    private final String paywallId;
    @SerializedName("products")
    private final ArrayList<ProductDto> products;
    @SerializedName("remote_config")
    private final RemoteConfigDto remoteConfig;
    @SerializedName("revision")
    private final Integer revision;
    @SerializedName("paywall_updated_at")
    private final Long updatedAt;
    @SerializedName("variation_id")
    private final String variationId;

    public static /* synthetic */ PaywallDto copy$default(PaywallDto paywallDto, String str, String str2, Long l, String str3, Integer num, String str4, String str5, ArrayList arrayList, RemoteConfigDto remoteConfigDto, Boolean bool, int i, Object obj) {
        PaywallDto paywallDto2 = paywallDto;
        int i2 = i;
        return paywallDto.copy((i2 & 1) != 0 ? paywallDto2.developerId : str, (i2 & 2) != 0 ? paywallDto2.name : str2, (i2 & 4) != 0 ? paywallDto2.updatedAt : l, (i2 & 8) != 0 ? paywallDto2.abTestName : str3, (i2 & 16) != 0 ? paywallDto2.revision : num, (i2 & 32) != 0 ? paywallDto2.variationId : str4, (i2 & 64) != 0 ? paywallDto2.paywallId : str5, (i2 & 128) != 0 ? paywallDto2.products : arrayList, (i2 & 256) != 0 ? paywallDto2.remoteConfig : remoteConfigDto, (i2 & 512) != 0 ? paywallDto2.hasViewConfiguration : bool);
    }

    public final String component1() {
        return this.developerId;
    }

    public final Boolean component10() {
        return this.hasViewConfiguration;
    }

    public final String component2() {
        return this.name;
    }

    public final Long component3() {
        return this.updatedAt;
    }

    public final String component4() {
        return this.abTestName;
    }

    public final Integer component5() {
        return this.revision;
    }

    public final String component6() {
        return this.variationId;
    }

    public final String component7() {
        return this.paywallId;
    }

    public final ArrayList<ProductDto> component8() {
        return this.products;
    }

    public final RemoteConfigDto component9() {
        return this.remoteConfig;
    }

    public final PaywallDto copy(String str, String str2, Long l, String str3, Integer num, String str4, String str5, ArrayList<ProductDto> arrayList, RemoteConfigDto remoteConfigDto, Boolean bool) {
        ArrayList<ProductDto> arrayList2 = arrayList;
        Intrinsics.checkNotNullParameter(arrayList2, AdaptyPaywallTypeAdapterFactory.PRODUCTS);
        return new PaywallDto(str, str2, l, str3, num, str4, str5, arrayList2, remoteConfigDto, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallDto)) {
            return false;
        }
        PaywallDto paywallDto = (PaywallDto) obj;
        return Intrinsics.areEqual((Object) this.developerId, (Object) paywallDto.developerId) && Intrinsics.areEqual((Object) this.name, (Object) paywallDto.name) && Intrinsics.areEqual((Object) this.updatedAt, (Object) paywallDto.updatedAt) && Intrinsics.areEqual((Object) this.abTestName, (Object) paywallDto.abTestName) && Intrinsics.areEqual((Object) this.revision, (Object) paywallDto.revision) && Intrinsics.areEqual((Object) this.variationId, (Object) paywallDto.variationId) && Intrinsics.areEqual((Object) this.paywallId, (Object) paywallDto.paywallId) && Intrinsics.areEqual((Object) this.products, (Object) paywallDto.products) && Intrinsics.areEqual((Object) this.remoteConfig, (Object) paywallDto.remoteConfig) && Intrinsics.areEqual((Object) this.hasViewConfiguration, (Object) paywallDto.hasViewConfiguration);
    }

    public int hashCode() {
        String str = this.developerId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.updatedAt;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str3 = this.abTestName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.revision;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.variationId;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.paywallId;
        int hashCode7 = (((hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.products.hashCode()) * 31;
        RemoteConfigDto remoteConfigDto = this.remoteConfig;
        int hashCode8 = (hashCode7 + (remoteConfigDto == null ? 0 : remoteConfigDto.hashCode())) * 31;
        Boolean bool = this.hasViewConfiguration;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "PaywallDto(developerId=" + this.developerId + ", name=" + this.name + ", updatedAt=" + this.updatedAt + ", abTestName=" + this.abTestName + ", revision=" + this.revision + ", variationId=" + this.variationId + ", paywallId=" + this.paywallId + ", products=" + this.products + ", remoteConfig=" + this.remoteConfig + ", hasViewConfiguration=" + this.hasViewConfiguration + ')';
    }

    public PaywallDto(String str, String str2, Long l, String str3, Integer num, String str4, String str5, ArrayList<ProductDto> arrayList, RemoteConfigDto remoteConfigDto, Boolean bool) {
        Intrinsics.checkNotNullParameter(arrayList, AdaptyPaywallTypeAdapterFactory.PRODUCTS);
        this.developerId = str;
        this.name = str2;
        this.updatedAt = l;
        this.abTestName = str3;
        this.revision = num;
        this.variationId = str4;
        this.paywallId = str5;
        this.products = arrayList;
        this.remoteConfig = remoteConfigDto;
        this.hasViewConfiguration = bool;
    }

    public final String getDeveloperId() {
        return this.developerId;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getAbTestName() {
        return this.abTestName;
    }

    public final Integer getRevision() {
        return this.revision;
    }

    public final String getVariationId() {
        return this.variationId;
    }

    public final String getPaywallId() {
        return this.paywallId;
    }

    public final ArrayList<ProductDto> getProducts() {
        return this.products;
    }

    public final RemoteConfigDto getRemoteConfig() {
        return this.remoteConfig;
    }

    public final Boolean getHasViewConfiguration() {
        return this.hasViewConfiguration;
    }
}
