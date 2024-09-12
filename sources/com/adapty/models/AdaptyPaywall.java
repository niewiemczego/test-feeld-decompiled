package com.adapty.models;

import com.adapty.internal.crossplatform.AdaptyPaywallTypeAdapterFactory;
import com.adapty.internal.domain.models.BackendProduct;
import com.adapty.utils.ImmutableList;
import com.adapty.utils.ImmutableMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00011B}\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u0013\u0010-\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010/\u001a\u00020\u0007H\u0016J\b\u00100\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u00020\u000e8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0014\u0010\u0012\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030*8F¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00062"}, d2 = {"Lcom/adapty/models/AdaptyPaywall;", "", "placementId", "", "name", "abTestName", "revision", "", "variationId", "locale", "remoteConfigString", "remoteConfig", "Lcom/adapty/utils/ImmutableMap;", "hasViewConfiguration", "", "products", "", "Lcom/adapty/internal/domain/models/BackendProduct;", "paywallId", "updatedAt", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/adapty/utils/ImmutableMap;ZLjava/util/List;Ljava/lang/String;J)V", "getAbTestName", "()Ljava/lang/String;", "()Z", "id", "getId$annotations", "()V", "getId", "getLocale", "getName", "getPaywallId$adapty_release", "getPlacementId", "getProducts$adapty_release", "()Ljava/util/List;", "getRemoteConfig", "()Lcom/adapty/utils/ImmutableMap;", "getRemoteConfigString", "getRevision", "()I", "getVariationId", "vendorProductIds", "Lcom/adapty/utils/ImmutableList;", "getVendorProductIds", "()Lcom/adapty/utils/ImmutableList;", "equals", "other", "hashCode", "toString", "FetchPolicy", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyPaywall.kt */
public final class AdaptyPaywall {
    private final String abTestName;
    private final boolean hasViewConfiguration;
    private final String locale;
    private final String name;
    private final String paywallId;
    private final String placementId;
    private final List<BackendProduct> products;
    private final ImmutableMap<String, Object> remoteConfig;
    private final String remoteConfigString;
    private final int revision;
    private final long updatedAt;
    private final String variationId;

    @Deprecated(level = DeprecationLevel.ERROR, message = "Renamed to placementId", replaceWith = @ReplaceWith(expression = "placementId", imports = {}))
    public static /* synthetic */ void getId$annotations() {
    }

    public AdaptyPaywall(String str, String str2, String str3, int i, String str4, String str5, String str6, ImmutableMap<String, Object> immutableMap, boolean z, List<BackendProduct> list, String str7, long j) {
        Intrinsics.checkNotNullParameter(str, "placementId");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "abTestName");
        Intrinsics.checkNotNullParameter(str4, "variationId");
        Intrinsics.checkNotNullParameter(str5, "locale");
        Intrinsics.checkNotNullParameter(list, AdaptyPaywallTypeAdapterFactory.PRODUCTS);
        Intrinsics.checkNotNullParameter(str7, "paywallId");
        this.placementId = str;
        this.name = str2;
        this.abTestName = str3;
        this.revision = i;
        this.variationId = str4;
        this.locale = str5;
        this.remoteConfigString = str6;
        this.remoteConfig = immutableMap;
        this.hasViewConfiguration = z;
        this.products = list;
        this.paywallId = str7;
        this.updatedAt = j;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAbTestName() {
        return this.abTestName;
    }

    public final int getRevision() {
        return this.revision;
    }

    public final String getVariationId() {
        return this.variationId;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getRemoteConfigString() {
        return this.remoteConfigString;
    }

    public final ImmutableMap<String, Object> getRemoteConfig() {
        return this.remoteConfig;
    }

    public final boolean hasViewConfiguration() {
        return this.hasViewConfiguration;
    }

    public final /* synthetic */ List getProducts$adapty_release() {
        return this.products;
    }

    public final /* synthetic */ String getPaywallId$adapty_release() {
        return this.paywallId;
    }

    public final ImmutableList<String> getVendorProductIds() {
        Iterable<BackendProduct> iterable = this.products;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (BackendProduct vendorProductId : iterable) {
            arrayList.add(vendorProductId.getVendorProductId());
        }
        return Intrinsics.checkNotNullParameter((List) arrayList, "<this>");
    }

    public final String getId() {
        return this.placementId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.models.AdaptyPaywall");
        AdaptyPaywall adaptyPaywall = (AdaptyPaywall) obj;
        return Intrinsics.areEqual((Object) this.placementId, (Object) adaptyPaywall.placementId) && Intrinsics.areEqual((Object) this.name, (Object) adaptyPaywall.name) && Intrinsics.areEqual((Object) this.abTestName, (Object) adaptyPaywall.abTestName) && this.revision == adaptyPaywall.revision && Intrinsics.areEqual((Object) this.variationId, (Object) adaptyPaywall.variationId) && Intrinsics.areEqual((Object) getVendorProductIds(), (Object) adaptyPaywall.getVendorProductIds()) && Intrinsics.areEqual((Object) this.locale, (Object) adaptyPaywall.locale) && Intrinsics.areEqual((Object) this.remoteConfigString, (Object) adaptyPaywall.remoteConfigString) && Intrinsics.areEqual((Object) this.remoteConfig, (Object) adaptyPaywall.remoteConfig);
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.placementId.hashCode() * 31) + this.name.hashCode()) * 31) + this.abTestName.hashCode()) * 31) + this.revision) * 31) + this.variationId.hashCode()) * 31) + getVendorProductIds().hashCode()) * 31) + this.locale.hashCode()) * 31;
        String str = this.remoteConfigString;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        ImmutableMap<String, Object> immutableMap = this.remoteConfig;
        if (immutableMap != null) {
            i = immutableMap.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "AdaptyPaywall(placementId=" + this.placementId + ", name=" + this.name + ", abTestName=" + this.abTestName + ", revision=" + this.revision + ", variationId=" + this.variationId + ", vendorProductIds=" + getVendorProductIds() + ", locale=" + this.locale + ", remoteConfig=" + this.remoteConfig + ')';
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00032\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/adapty/models/AdaptyPaywall$FetchPolicy;", "", "()V", "Companion", "ReloadRevalidatingCacheData", "ReturnCacheDataElseLoad", "ReturnCacheDataIfNotExpiredElseLoad", "Lcom/adapty/models/AdaptyPaywall$FetchPolicy$ReloadRevalidatingCacheData;", "Lcom/adapty/models/AdaptyPaywall$FetchPolicy$ReturnCacheDataElseLoad;", "Lcom/adapty/models/AdaptyPaywall$FetchPolicy$ReturnCacheDataIfNotExpiredElseLoad;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyPaywall.kt */
    public static abstract class FetchPolicy {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final FetchPolicy Default;
        public static final FetchPolicy ReloadRevalidatingCacheData;
        public static final FetchPolicy ReturnCacheDataElseLoad = ReturnCacheDataElseLoad.Companion.create();

        public /* synthetic */ FetchPolicy(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static final FetchPolicy ReturnCacheDataIfNotExpiredElseLoad(long j) {
            return Companion.ReturnCacheDataIfNotExpiredElseLoad(j);
        }

        private FetchPolicy() {
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/adapty/models/AdaptyPaywall$FetchPolicy$ReloadRevalidatingCacheData;", "Lcom/adapty/models/AdaptyPaywall$FetchPolicy;", "()V", "toString", "", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyPaywall.kt */
        public static final class ReloadRevalidatingCacheData extends FetchPolicy {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

            public /* synthetic */ ReloadRevalidatingCacheData(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public String toString() {
                return "ReloadRevalidatingCacheData";
            }

            private ReloadRevalidatingCacheData() {
                super((DefaultConstructorMarker) null);
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/adapty/models/AdaptyPaywall$FetchPolicy$ReloadRevalidatingCacheData$Companion;", "", "()V", "create", "Lcom/adapty/models/AdaptyPaywall$FetchPolicy$ReloadRevalidatingCacheData;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyPaywall.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final ReloadRevalidatingCacheData create() {
                    return new ReloadRevalidatingCacheData((DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/adapty/models/AdaptyPaywall$FetchPolicy$ReturnCacheDataElseLoad;", "Lcom/adapty/models/AdaptyPaywall$FetchPolicy;", "()V", "toString", "", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyPaywall.kt */
        public static final class ReturnCacheDataElseLoad extends FetchPolicy {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

            public /* synthetic */ ReturnCacheDataElseLoad(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public String toString() {
                return "ReturnCacheDataElseLoad";
            }

            private ReturnCacheDataElseLoad() {
                super((DefaultConstructorMarker) null);
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/adapty/models/AdaptyPaywall$FetchPolicy$ReturnCacheDataElseLoad$Companion;", "", "()V", "create", "Lcom/adapty/models/AdaptyPaywall$FetchPolicy$ReturnCacheDataElseLoad;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyPaywall.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final ReturnCacheDataElseLoad create() {
                    return new ReturnCacheDataElseLoad((DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/adapty/models/AdaptyPaywall$FetchPolicy$ReturnCacheDataIfNotExpiredElseLoad;", "Lcom/adapty/models/AdaptyPaywall$FetchPolicy;", "maxAgeMillis", "", "(J)V", "getMaxAgeMillis", "()J", "toString", "", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyPaywall.kt */
        public static final class ReturnCacheDataIfNotExpiredElseLoad extends FetchPolicy {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final long maxAgeMillis;

            public /* synthetic */ ReturnCacheDataIfNotExpiredElseLoad(long j, DefaultConstructorMarker defaultConstructorMarker) {
                this(j);
            }

            private ReturnCacheDataIfNotExpiredElseLoad(long j) {
                super((DefaultConstructorMarker) null);
                this.maxAgeMillis = j;
            }

            public final long getMaxAgeMillis() {
                return this.maxAgeMillis;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/models/AdaptyPaywall$FetchPolicy$ReturnCacheDataIfNotExpiredElseLoad$Companion;", "", "()V", "create", "Lcom/adapty/models/AdaptyPaywall$FetchPolicy$ReturnCacheDataIfNotExpiredElseLoad;", "maxAgeMillis", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AdaptyPaywall.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final ReturnCacheDataIfNotExpiredElseLoad create(long j) {
                    return new ReturnCacheDataIfNotExpiredElseLoad(j, (DefaultConstructorMarker) null);
                }
            }

            public String toString() {
                return "ReturnCacheDataIfNotExpiredElseLoad(maxAgeMillis=" + this.maxAgeMillis + ')';
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/adapty/models/AdaptyPaywall$FetchPolicy$Companion;", "", "()V", "Default", "Lcom/adapty/models/AdaptyPaywall$FetchPolicy;", "ReloadRevalidatingCacheData", "ReturnCacheDataElseLoad", "ReturnCacheDataIfNotExpiredElseLoad", "maxAgeMillis", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyPaywall.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final FetchPolicy ReturnCacheDataIfNotExpiredElseLoad(long j) {
                return ReturnCacheDataIfNotExpiredElseLoad.Companion.create(j);
            }
        }

        static {
            FetchPolicy create = ReloadRevalidatingCacheData.Companion.create();
            ReloadRevalidatingCacheData = create;
            Default = create;
        }
    }
}
