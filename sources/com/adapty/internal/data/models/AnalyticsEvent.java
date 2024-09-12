package com.adapty.internal.data.models;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.internal.domain.models.PurchaseableProduct;
import com.adapty.models.AdaptyPaywall;
import com.adapty.models.AdaptyPaywallProduct;
import com.adapty.models.AdaptySubscriptionUpdateParameters;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.facebook.react.util.JSStackTrace;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 %2\u00020\u0001:\b#$%&'()*BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010 \u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010!\u001a\u00020\"H\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000e¨\u0006+"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent;", "", "eventId", "", "eventName", "profileId", "sessionId", "deviceId", "createdAt", "platform", "other", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getCreatedAt", "()Ljava/lang/String;", "getDeviceId", "getEventId", "getEventName", "isSystemLog", "", "()Z", "ordinal", "", "getOrdinal", "()J", "setOrdinal", "(J)V", "getOther", "()Ljava/util/Map;", "getPlatform", "getProfileId", "getSessionId", "equals", "hashCode", "", "BackendAPIRequestData", "BackendAPIResponseData", "Companion", "CustomData", "GoogleAPIRequestData", "GoogleAPIResponseData", "SDKMethodRequestData", "SDKMethodResponseData", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnalyticsEvent.kt */
public final class AnalyticsEvent {
    public static final String CUSTOM_DATA = "custom_data";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int RETAIN_LIMIT = 500;
    public static final int SEND_LIMIT = 500;
    public static final String SYSTEM_LOG = "system_log";
    private final String createdAt;
    private final String deviceId;
    private final String eventId;
    private final String eventName;
    private long ordinal;
    private final Map<String, Object> other;
    private final String platform;
    private final String profileId;
    private final String sessionId;

    public AnalyticsEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Intrinsics.checkNotNullParameter(str2, "eventName");
        Intrinsics.checkNotNullParameter(str3, "profileId");
        Intrinsics.checkNotNullParameter(str4, "sessionId");
        Intrinsics.checkNotNullParameter(str5, "deviceId");
        Intrinsics.checkNotNullParameter(str6, "createdAt");
        Intrinsics.checkNotNullParameter(str7, "platform");
        Intrinsics.checkNotNullParameter(map, "other");
        this.eventId = str;
        this.eventName = str2;
        this.profileId = str3;
        this.sessionId = str4;
        this.deviceId = str5;
        this.createdAt = str6;
        this.platform = str7;
        this.other = map;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final Map<String, Object> getOther() {
        return this.other;
    }

    public final long getOrdinal() {
        return this.ordinal;
    }

    public final void setOrdinal(long j) {
        this.ordinal = j;
    }

    public final boolean isSystemLog() {
        return Intrinsics.areEqual((Object) this.eventName, (Object) SYSTEM_LOG);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.internal.data.models.AnalyticsEvent");
        AnalyticsEvent analyticsEvent = (AnalyticsEvent) obj;
        if (!Intrinsics.areEqual((Object) this.eventId, (Object) analyticsEvent.eventId) || !Intrinsics.areEqual((Object) this.eventName, (Object) analyticsEvent.eventName) || !Intrinsics.areEqual((Object) this.profileId, (Object) analyticsEvent.profileId) || !Intrinsics.areEqual((Object) this.sessionId, (Object) analyticsEvent.sessionId) || !Intrinsics.areEqual((Object) this.deviceId, (Object) analyticsEvent.deviceId) || !Intrinsics.areEqual((Object) this.createdAt, (Object) analyticsEvent.createdAt) || !Intrinsics.areEqual((Object) this.platform, (Object) analyticsEvent.platform) || !Intrinsics.areEqual(obj, (Object) analyticsEvent.other)) {
            return false;
        }
        if (this.ordinal == analyticsEvent.ordinal) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.eventId.hashCode() * 31) + this.eventName.hashCode()) * 31) + this.profileId.hashCode()) * 31) + this.sessionId.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + this.platform.hashCode()) * 31) + this.other.hashCode()) * 31) + Long.hashCode(this.ordinal);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007\u0001\u0006\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$CustomData;", "", "eventName", "", "flowId", "(Ljava/lang/String;Ljava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "<set-?>", "sdkFlowId", "getSdkFlowId", "resetFlowId", "", "Companion", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIResponseData;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData;", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData;", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodResponseData;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnalyticsEvent.kt */
    public static abstract class CustomData {
        public static final String API_REQUEST_PREFIX = "api_request_";
        public static final String API_RESPONSE_PREFIX = "api_response_";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String GOOGLE_REQUEST_PREFIX = "google_request_";
        public static final String GOOGLE_RESPONSE_PREFIX = "google_response_";
        public static final String SDK_REQUEST_PREFIX = "sdk_request_";
        public static final String SDK_RESPONSE_PREFIX = "sdk_response_";
        private final String eventName;
        private String sdkFlowId;

        public /* synthetic */ CustomData(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        private CustomData(String str, String str2) {
            this.eventName = str;
            this.sdkFlowId = str2;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final String getSdkFlowId() {
            return this.sdkFlowId;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$CustomData$Companion;", "", "()V", "API_REQUEST_PREFIX", "", "API_RESPONSE_PREFIX", "GOOGLE_REQUEST_PREFIX", "GOOGLE_RESPONSE_PREFIX", "SDK_REQUEST_PREFIX", "SDK_RESPONSE_PREFIX", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public final void resetFlowId() {
            this.sdkFlowId = UUID.randomUUID().toString();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00072\u00020\u0001:\b\u0005\u0006\u0007\b\t\n\u000b\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u0001\u0007\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData;", "Lcom/adapty/internal/data/models/AnalyticsEvent$CustomData;", "methodName", "", "(Ljava/lang/String;)V", "Activate", "Basic", "Companion", "GetPaywall", "GetPaywallProducts", "MakePurchase", "SetVariationId", "UpdateAttribution", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$Activate;", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$Basic;", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$GetPaywall;", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$GetPaywallProducts;", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$MakePurchase;", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$SetVariationId;", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$UpdateAttribution;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnalyticsEvent.kt */
    public static abstract class SDKMethodRequestData extends CustomData {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        public /* synthetic */ SDKMethodRequestData(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$Basic;", "methodName", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Basic create(String str) {
                Intrinsics.checkNotNullParameter(str, JSStackTrace.METHOD_NAME_KEY);
                return Basic.Companion.create(str);
            }
        }

        private SDKMethodRequestData(String str) {
            super(CustomData.SDK_REQUEST_PREFIX + str, UUID.randomUUID().toString(), (DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$Basic;", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData;", "methodName", "", "(Ljava/lang/String;)V", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class Basic extends SDKMethodRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

            public /* synthetic */ Basic(String str, DefaultConstructorMarker defaultConstructorMarker) {
                this(str);
            }

            private Basic(String str) {
                super(str, (DefaultConstructorMarker) null);
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$Basic$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$Basic;", "methodName", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final Basic create(String str) {
                    Intrinsics.checkNotNullParameter(str, JSStackTrace.METHOD_NAME_KEY);
                    return new Basic(str, (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B=\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$GetPaywall;", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData;", "placementId", "", "locale", "fetchPolicy", "", "", "loadTimeout", "", "methodName", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;DLjava/lang/String;)V", "getFetchPolicy", "()Ljava/util/Map;", "getLoadTimeout", "()D", "getLocale", "()Ljava/lang/String;", "getPlacementId", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class GetPaywall extends SDKMethodRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final Map<String, Object> fetchPolicy;
            private final double loadTimeout;
            private final String locale;
            private final String placementId;

            public /* synthetic */ GetPaywall(String str, String str2, Map map, double d, String str3, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, map, d, str3);
            }

            public final String getPlacementId() {
                return this.placementId;
            }

            public final String getLocale() {
                return this.locale;
            }

            public final Map<String, Object> getFetchPolicy() {
                return this.fetchPolicy;
            }

            public final double getLoadTimeout() {
                return this.loadTimeout;
            }

            private GetPaywall(String str, String str2, Map<String, ? extends Object> map, double d, String str3) {
                super(str3, (DefaultConstructorMarker) null);
                this.placementId = str;
                this.locale = str2;
                this.fetchPolicy = map;
                this.loadTimeout = d;
            }

            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$GetPaywall$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$GetPaywall;", "placementId", "", "locale", "fetchPolicy", "Lcom/adapty/models/AdaptyPaywall$FetchPolicy;", "loadTimeoutMillis", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final GetPaywall create(String str, String str2, AdaptyPaywall.FetchPolicy fetchPolicy, int i) {
                    Map mapOf;
                    Intrinsics.checkNotNullParameter(str, "placementId");
                    Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
                    if (fetchPolicy instanceof AdaptyPaywall.FetchPolicy.ReloadRevalidatingCacheData) {
                        mapOf = MapsKt.mapOf(TuplesKt.to("type", "reload_revalidating_cache_data"));
                    } else if (fetchPolicy instanceof AdaptyPaywall.FetchPolicy.ReturnCacheDataElseLoad) {
                        mapOf = MapsKt.mapOf(TuplesKt.to("type", "return_cache_data_else_load"));
                    } else if (fetchPolicy instanceof AdaptyPaywall.FetchPolicy.ReturnCacheDataIfNotExpiredElseLoad) {
                        mapOf = MapsKt.mapOf(TuplesKt.to("type", "return_cache_data_else_load"), TuplesKt.to("max_age", Double.valueOf(((double) ((AdaptyPaywall.FetchPolicy.ReturnCacheDataIfNotExpiredElseLoad) fetchPolicy).getMaxAgeMillis()) / 1000.0d)));
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    return new GetPaywall(str, str2, mapOf, ((double) i) / 1000.0d, "get_paywall", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$GetPaywallProducts;", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData;", "placementId", "", "methodName", "(Ljava/lang/String;Ljava/lang/String;)V", "getPlacementId", "()Ljava/lang/String;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class GetPaywallProducts extends SDKMethodRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String placementId;

            public /* synthetic */ GetPaywallProducts(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2);
            }

            public final String getPlacementId() {
                return this.placementId;
            }

            private GetPaywallProducts(String str, String str2) {
                super(str2, (DefaultConstructorMarker) null);
                this.placementId = str;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$GetPaywallProducts$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$GetPaywallProducts;", "placementId", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final GetPaywallProducts create(String str) {
                    Intrinsics.checkNotNullParameter(str, "placementId");
                    return new GetPaywallProducts(str, "get_paywall_products", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u0001\fB'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$MakePurchase;", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData;", "paywallName", "", "variationId", "productId", "methodName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPaywallName", "()Ljava/lang/String;", "getProductId", "getVariationId", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class MakePurchase extends SDKMethodRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String paywallName;
            private final String productId;
            private final String variationId;

            public /* synthetic */ MakePurchase(String str, String str2, String str3, String str4, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3, str4);
            }

            public final String getPaywallName() {
                return this.paywallName;
            }

            public final String getVariationId() {
                return this.variationId;
            }

            public final String getProductId() {
                return this.productId;
            }

            private MakePurchase(String str, String str2, String str3, String str4) {
                super(str4, (DefaultConstructorMarker) null);
                this.paywallName = str;
                this.variationId = str2;
                this.productId = str3;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$MakePurchase$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$MakePurchase;", "product", "Lcom/adapty/models/AdaptyPaywallProduct;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final MakePurchase create(AdaptyPaywallProduct adaptyPaywallProduct) {
                    Intrinsics.checkNotNullParameter(adaptyPaywallProduct, "product");
                    return new MakePurchase(adaptyPaywallProduct.getPaywallName(), adaptyPaywallProduct.getVariationId(), adaptyPaywallProduct.getVendorProductId(), "make_purchase", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$UpdateAttribution;", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData;", "source", "", "hasNetworkUserId", "", "methodName", "(Ljava/lang/String;ZLjava/lang/String;)V", "getHasNetworkUserId", "()Z", "getSource", "()Ljava/lang/String;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class UpdateAttribution extends SDKMethodRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final boolean hasNetworkUserId;
            private final String source;

            public /* synthetic */ UpdateAttribution(String str, boolean z, String str2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, z, str2);
            }

            public final String getSource() {
                return this.source;
            }

            public final boolean getHasNetworkUserId() {
                return this.hasNetworkUserId;
            }

            private UpdateAttribution(String str, boolean z, String str2) {
                super(str2, (DefaultConstructorMarker) null);
                this.source = str;
                this.hasNetworkUserId = z;
            }

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\b"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$UpdateAttribution$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$UpdateAttribution;", "source", "", "networkUserId", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final UpdateAttribution create(String str, String str2) {
                    Intrinsics.checkNotNullParameter(str, "source");
                    return new UpdateAttribution(str, str2 != null, "update_attribution", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\f"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$Activate;", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData;", "observerMode", "", "hasCustomerUserId", "methodName", "", "(ZZLjava/lang/String;)V", "getHasCustomerUserId", "()Z", "getObserverMode", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class Activate extends SDKMethodRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final boolean hasCustomerUserId;
            private final boolean observerMode;

            public /* synthetic */ Activate(boolean z, boolean z2, String str, DefaultConstructorMarker defaultConstructorMarker) {
                this(z, z2, str);
            }

            public final boolean getObserverMode() {
                return this.observerMode;
            }

            public final boolean getHasCustomerUserId() {
                return this.hasCustomerUserId;
            }

            private Activate(boolean z, boolean z2, String str) {
                super(str, (DefaultConstructorMarker) null);
                this.observerMode = z;
                this.hasCustomerUserId = z2;
            }

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$Activate$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$Activate;", "observerMode", "", "hasCustomerUserId", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final Activate create(boolean z, boolean z2) {
                    return new Activate(z, z2, "activate", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$SetVariationId;", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData;", "transactionId", "", "variationId", "methodName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTransactionId", "()Ljava/lang/String;", "getVariationId", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class SetVariationId extends SDKMethodRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String transactionId;
            private final String variationId;

            public /* synthetic */ SetVariationId(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3);
            }

            public final String getTransactionId() {
                return this.transactionId;
            }

            public final String getVariationId() {
                return this.variationId;
            }

            private SetVariationId(String str, String str2, String str3) {
                super(str3, (DefaultConstructorMarker) null);
                this.transactionId = str;
                this.variationId = str2;
            }

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$SetVariationId$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData$SetVariationId;", "transactionId", "", "variationId", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final SetVariationId create(String str, String str2) {
                    Intrinsics.checkNotNullParameter(str, "transactionId");
                    Intrinsics.checkNotNullParameter(str2, "variationId");
                    return new SetVariationId(str, str2, "set_variation_id", (DefaultConstructorMarker) null);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\rB+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodResponseData;", "Lcom/adapty/internal/data/models/AnalyticsEvent$CustomData;", "eventName", "", "flowId", "success", "", "error", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getError", "()Ljava/lang/String;", "getSuccess", "()Z", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnalyticsEvent.kt */
    public static final class SDKMethodResponseData extends CustomData {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String error;
        private final boolean success;

        public /* synthetic */ SDKMethodResponseData(String str, String str2, boolean z, String str3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, z, str3);
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final String getError() {
            return this.error;
        }

        private SDKMethodResponseData(String str, String str2, boolean z, String str3) {
            super(str, str2, (DefaultConstructorMarker) null);
            this.success = z;
            this.error = str3;
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodResponseData$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodResponseData;", "paired", "Lcom/adapty/internal/data/models/AnalyticsEvent$SDKMethodRequestData;", "error", "Lcom/adapty/errors/AdaptyError;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ SDKMethodResponseData create$default(Companion companion, SDKMethodRequestData sDKMethodRequestData, AdaptyError adaptyError, int i, Object obj) {
                if ((i & 2) != 0) {
                    adaptyError = null;
                }
                return companion.create(sDKMethodRequestData, adaptyError);
            }

            public final SDKMethodResponseData create(SDKMethodRequestData sDKMethodRequestData, AdaptyError adaptyError) {
                String localizedMessage;
                Intrinsics.checkNotNullParameter(sDKMethodRequestData, "paired");
                String replace$default = StringsKt.replace$default(sDKMethodRequestData.getEventName(), CustomData.SDK_REQUEST_PREFIX, CustomData.SDK_RESPONSE_PREFIX, false, 4, (Object) null);
                String sdkFlowId = sDKMethodRequestData.getSdkFlowId();
                boolean z = adaptyError == null;
                if (adaptyError == null || (localizedMessage = adaptyError.getMessage()) == null) {
                    localizedMessage = adaptyError != null ? adaptyError.getLocalizedMessage() : null;
                }
                return new SDKMethodResponseData(replace$default, sdkFlowId, z, localizedMessage, (DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\r\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u0001\r\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "Lcom/adapty/internal/data/models/AnalyticsEvent$CustomData;", "methodName", "", "(Ljava/lang/String;)V", "CreateProfile", "GetAnalyticsConfig", "GetFallbackPaywall", "GetFallbackPaywallBuilder", "GetPaywall", "GetPaywallBuilder", "GetProductIds", "GetProfile", "Restore", "SetAttribution", "SetVariationId", "UpdateProfile", "Validate", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$CreateProfile;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetAnalyticsConfig;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetFallbackPaywall;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetFallbackPaywallBuilder;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetPaywall;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetPaywallBuilder;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetProductIds;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetProfile;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$Restore;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$SetAttribution;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$SetVariationId;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$UpdateProfile;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$Validate;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnalyticsEvent.kt */
    public static abstract class BackendAPIRequestData extends CustomData {
        public /* synthetic */ BackendAPIRequestData(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        private BackendAPIRequestData(String str) {
            super(CustomData.API_REQUEST_PREFIX + str, (String) null, (DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetAnalyticsConfig;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "methodName", "", "(Ljava/lang/String;)V", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class GetAnalyticsConfig extends BackendAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

            public /* synthetic */ GetAnalyticsConfig(String str, DefaultConstructorMarker defaultConstructorMarker) {
                this(str);
            }

            private GetAnalyticsConfig(String str) {
                super(str, (DefaultConstructorMarker) null);
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetAnalyticsConfig$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetAnalyticsConfig;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final GetAnalyticsConfig create() {
                    return new GetAnalyticsConfig("get_events_blacklist", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B=\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$Validate;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "productId", "", "basePlanId", "offerId", "transactionId", "variationId", "methodName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBasePlanId", "()Ljava/lang/String;", "getOfferId", "getProductId", "getTransactionId", "getVariationId", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class Validate extends BackendAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String basePlanId;
            private final String offerId;
            private final String productId;
            private final String transactionId;
            private final String variationId;

            public /* synthetic */ Validate(String str, String str2, String str3, String str4, String str5, String str6, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3, str4, str5, str6);
            }

            public final String getProductId() {
                return this.productId;
            }

            public final String getBasePlanId() {
                return this.basePlanId;
            }

            public final String getOfferId() {
                return this.offerId;
            }

            public final String getTransactionId() {
                return this.transactionId;
            }

            public final String getVariationId() {
                return this.variationId;
            }

            private Validate(String str, String str2, String str3, String str4, String str5, String str6) {
                super(str6, (DefaultConstructorMarker) null);
                this.productId = str;
                this.basePlanId = str2;
                this.offerId = str3;
                this.transactionId = str4;
                this.variationId = str5;
            }

            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$Validate$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$Validate;", "product", "Lcom/adapty/internal/domain/models/PurchaseableProduct;", "purchase", "Lcom/android/billingclient/api/Purchase;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final Validate create(PurchaseableProduct purchaseableProduct, Purchase purchase) {
                    Intrinsics.checkNotNullParameter(purchaseableProduct, "product");
                    Intrinsics.checkNotNullParameter(purchase, FirebaseAnalytics.Event.PURCHASE);
                    String vendorProductId = purchaseableProduct.getVendorProductId();
                    ProductDetails.SubscriptionOfferDetails currentOfferDetails = purchaseableProduct.getCurrentOfferDetails();
                    String basePlanId = currentOfferDetails != null ? currentOfferDetails.getBasePlanId() : null;
                    ProductDetails.SubscriptionOfferDetails currentOfferDetails2 = purchaseableProduct.getCurrentOfferDetails();
                    return new Validate(vendorProductId, basePlanId, currentOfferDetails2 != null ? currentOfferDetails2.getOfferId() : null, purchase.getOrderId(), purchaseableProduct.getVariationId(), "validate_transaction", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u001d\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$Restore;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "productIds", "", "", "methodName", "(Ljava/util/List;Ljava/lang/String;)V", "getProductIds", "()Ljava/util/List;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class Restore extends BackendAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final List<String> productIds;

            public /* synthetic */ Restore(List list, String str, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, str);
            }

            public final List<String> getProductIds() {
                return this.productIds;
            }

            private Restore(List<String> list, String str) {
                super(str, (DefaultConstructorMarker) null);
                this.productIds = list;
            }

            @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\b"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$Restore$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$Restore;", "purchases", "", "Lcom/adapty/internal/data/models/RestoreProductInfo;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final Restore create(List<RestoreProductInfo> list) {
                    Intrinsics.checkNotNullParameter(list, "purchases");
                    Collection arrayList = new ArrayList();
                    for (RestoreProductInfo productId : list) {
                        String productId2 = productId.getProductId();
                        if (productId2 != null) {
                            arrayList.add(productId2);
                        }
                    }
                    return new Restore((List) arrayList, "restore_purchases", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$CreateProfile;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "hasCustomerUserId", "", "methodName", "", "(ZLjava/lang/String;)V", "getHasCustomerUserId", "()Z", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class CreateProfile extends BackendAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final boolean hasCustomerUserId;

            public /* synthetic */ CreateProfile(boolean z, String str, DefaultConstructorMarker defaultConstructorMarker) {
                this(z, str);
            }

            public final boolean getHasCustomerUserId() {
                return this.hasCustomerUserId;
            }

            private CreateProfile(boolean z, String str) {
                super(str, (DefaultConstructorMarker) null);
                this.hasCustomerUserId = z;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$CreateProfile$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$CreateProfile;", "hasCustomerUserId", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final CreateProfile create(boolean z) {
                    return new CreateProfile(z, "create_profile", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$UpdateProfile;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "methodName", "", "(Ljava/lang/String;)V", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class UpdateProfile extends BackendAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

            public /* synthetic */ UpdateProfile(String str, DefaultConstructorMarker defaultConstructorMarker) {
                this(str);
            }

            private UpdateProfile(String str) {
                super(str, (DefaultConstructorMarker) null);
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$UpdateProfile$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$UpdateProfile;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final UpdateProfile create() {
                    return new UpdateProfile("update_profile", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetProfile;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "methodName", "", "(Ljava/lang/String;)V", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class GetProfile extends BackendAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

            public /* synthetic */ GetProfile(String str, DefaultConstructorMarker defaultConstructorMarker) {
                this(str);
            }

            private GetProfile(String str) {
                super(str, (DefaultConstructorMarker) null);
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetProfile$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetProfile;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final GetProfile create() {
                    return new GetProfile("get_profile", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u0001\fB'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetFallbackPaywall;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "apiPrefix", "", "placementId", "languageCode", "methodName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiPrefix", "()Ljava/lang/String;", "getLanguageCode", "getPlacementId", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class GetFallbackPaywall extends BackendAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String apiPrefix;
            private final String languageCode;
            private final String placementId;

            public /* synthetic */ GetFallbackPaywall(String str, String str2, String str3, String str4, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3, str4);
            }

            public final String getApiPrefix() {
                return this.apiPrefix;
            }

            public final String getPlacementId() {
                return this.placementId;
            }

            public final String getLanguageCode() {
                return this.languageCode;
            }

            private GetFallbackPaywall(String str, String str2, String str3, String str4) {
                super(str4, (DefaultConstructorMarker) null);
                this.apiPrefix = str;
                this.placementId = str2;
                this.languageCode = str3;
            }

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetFallbackPaywall$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetFallbackPaywall;", "apiPrefix", "", "placementId", "languageCode", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final GetFallbackPaywall create(String str, String str2, String str3) {
                    Intrinsics.checkNotNullParameter(str, "apiPrefix");
                    Intrinsics.checkNotNullParameter(str2, "placementId");
                    Intrinsics.checkNotNullParameter(str3, "languageCode");
                    return new GetFallbackPaywall(str, str2, str3, "get_fallback_paywall", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetFallbackPaywallBuilder;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "apiPrefix", "", "paywallInstanceId", "builderVersion", "languageCode", "methodName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiPrefix", "()Ljava/lang/String;", "getBuilderVersion", "getLanguageCode", "getPaywallInstanceId", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class GetFallbackPaywallBuilder extends BackendAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String apiPrefix;
            private final String builderVersion;
            private final String languageCode;
            private final String paywallInstanceId;

            public /* synthetic */ GetFallbackPaywallBuilder(String str, String str2, String str3, String str4, String str5, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3, str4, str5);
            }

            public final String getApiPrefix() {
                return this.apiPrefix;
            }

            public final String getPaywallInstanceId() {
                return this.paywallInstanceId;
            }

            public final String getBuilderVersion() {
                return this.builderVersion;
            }

            public final String getLanguageCode() {
                return this.languageCode;
            }

            private GetFallbackPaywallBuilder(String str, String str2, String str3, String str4, String str5) {
                super(str5, (DefaultConstructorMarker) null);
                this.apiPrefix = str;
                this.paywallInstanceId = str2;
                this.builderVersion = str3;
                this.languageCode = str4;
            }

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetFallbackPaywallBuilder$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetFallbackPaywallBuilder;", "apiPrefix", "", "paywallInstanceId", "builderVersion", "languageCode", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final GetFallbackPaywallBuilder create(String str, String str2, String str3, String str4) {
                    Intrinsics.checkNotNullParameter(str, "apiPrefix");
                    Intrinsics.checkNotNullParameter(str2, "paywallInstanceId");
                    Intrinsics.checkNotNullParameter(str3, "builderVersion");
                    Intrinsics.checkNotNullParameter(str4, "languageCode");
                    return new GetFallbackPaywallBuilder(str, str2, str3, str4, "get_fallback_paywall_builder", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetPaywall;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "apiPrefix", "", "placementId", "locale", "segmentId", "md5", "methodName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiPrefix", "()Ljava/lang/String;", "getLocale", "getMd5", "getPlacementId", "getSegmentId", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class GetPaywall extends BackendAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String apiPrefix;
            private final String locale;
            private final String md5;
            private final String placementId;
            private final String segmentId;

            public /* synthetic */ GetPaywall(String str, String str2, String str3, String str4, String str5, String str6, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3, str4, str5, str6);
            }

            public final String getApiPrefix() {
                return this.apiPrefix;
            }

            public final String getPlacementId() {
                return this.placementId;
            }

            public final String getLocale() {
                return this.locale;
            }

            public final String getSegmentId() {
                return this.segmentId;
            }

            public final String getMd5() {
                return this.md5;
            }

            private GetPaywall(String str, String str2, String str3, String str4, String str5, String str6) {
                super(str6, (DefaultConstructorMarker) null);
                this.apiPrefix = str;
                this.placementId = str2;
                this.locale = str3;
                this.segmentId = str4;
                this.md5 = str5;
            }

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetPaywall$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetPaywall;", "apiPrefix", "", "placementId", "locale", "segmentId", "md5", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final GetPaywall create(String str, String str2, String str3, String str4, String str5) {
                    Intrinsics.checkNotNullParameter(str, "apiPrefix");
                    Intrinsics.checkNotNullParameter(str2, "placementId");
                    Intrinsics.checkNotNullParameter(str3, "locale");
                    Intrinsics.checkNotNullParameter(str4, "segmentId");
                    Intrinsics.checkNotNullParameter(str5, "md5");
                    return new GetPaywall(str, str2, str3, str5, str4, "get_paywall", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetPaywallBuilder;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "variationId", "", "methodName", "(Ljava/lang/String;Ljava/lang/String;)V", "getVariationId", "()Ljava/lang/String;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class GetPaywallBuilder extends BackendAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String variationId;

            public /* synthetic */ GetPaywallBuilder(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2);
            }

            public final String getVariationId() {
                return this.variationId;
            }

            private GetPaywallBuilder(String str, String str2) {
                super(str2, (DefaultConstructorMarker) null);
                this.variationId = str;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetPaywallBuilder$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetPaywallBuilder;", "variationId", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final GetPaywallBuilder create(String str) {
                    Intrinsics.checkNotNullParameter(str, "variationId");
                    return new GetPaywallBuilder(str, "get_paywall_builder", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$SetVariationId;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "transaction", "", "variationId", "methodName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTransaction", "()Ljava/lang/String;", "getVariationId", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class SetVariationId extends BackendAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String transaction;
            private final String variationId;

            public /* synthetic */ SetVariationId(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3);
            }

            public final String getTransaction() {
                return this.transaction;
            }

            public final String getVariationId() {
                return this.variationId;
            }

            private SetVariationId(String str, String str2, String str3) {
                super(str3, (DefaultConstructorMarker) null);
                this.transaction = str;
                this.variationId = str2;
            }

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$SetVariationId$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$SetVariationId;", "transactionId", "", "variationId", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final SetVariationId create(String str, String str2) {
                    Intrinsics.checkNotNullParameter(str, "transactionId");
                    Intrinsics.checkNotNullParameter(str2, "variationId");
                    return new SetVariationId(str, str2, "set_variation_id", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\nB!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$SetAttribution;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "source", "", "networkUserId", "methodName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNetworkUserId", "()Ljava/lang/String;", "getSource", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class SetAttribution extends BackendAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String networkUserId;
            private final String source;

            public /* synthetic */ SetAttribution(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3);
            }

            public final String getSource() {
                return this.source;
            }

            public final String getNetworkUserId() {
                return this.networkUserId;
            }

            private SetAttribution(String str, String str2, String str3) {
                super(str3, (DefaultConstructorMarker) null);
                this.source = str;
                this.networkUserId = str2;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$SetAttribution$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$SetAttribution;", "attributionData", "Lcom/adapty/internal/data/models/AttributionData;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final SetAttribution create(AttributionData attributionData) {
                    Intrinsics.checkNotNullParameter(attributionData, "attributionData");
                    return new SetAttribution(attributionData.getSource(), attributionData.getNetworkUserId(), "set_attribution", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetProductIds;", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "methodName", "", "(Ljava/lang/String;)V", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class GetProductIds extends BackendAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

            public /* synthetic */ GetProductIds(String str, DefaultConstructorMarker defaultConstructorMarker) {
                this(str);
            }

            private GetProductIds(String str) {
                super(str, (DefaultConstructorMarker) null);
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetProductIds$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData$GetProductIds;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final GetProductIds create() {
                    return new GetProductIds("get_products_ids", (DefaultConstructorMarker) null);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB3\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIResponseData;", "Lcom/adapty/internal/data/models/AnalyticsEvent$CustomData;", "apiRequestId", "", "eventName", "flowId", "success", "", "error", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getApiRequestId", "()Ljava/lang/String;", "getError", "getSuccess", "()Z", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnalyticsEvent.kt */
    public static final class BackendAPIResponseData extends CustomData {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String apiRequestId;
        private final String error;
        private final boolean success;

        public /* synthetic */ BackendAPIResponseData(String str, String str2, String str3, boolean z, String str4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, z, str4);
        }

        public final String getApiRequestId() {
            return this.apiRequestId;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final String getError() {
            return this.error;
        }

        private BackendAPIResponseData(String str, String str2, String str3, boolean z, String str4) {
            super(str2, str3, (DefaultConstructorMarker) null);
            this.apiRequestId = str;
            this.success = z;
            this.error = str4;
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIResponseData$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIResponseData;", "apiRequestId", "", "paired", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "error", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ BackendAPIResponseData create$default(Companion companion, String str, BackendAPIRequestData backendAPIRequestData, Throwable th, int i, Object obj) {
                if ((i & 4) != 0) {
                    th = null;
                }
                return companion.create(str, backendAPIRequestData, th);
            }

            public final BackendAPIResponseData create(String str, BackendAPIRequestData backendAPIRequestData, Throwable th) {
                String localizedMessage;
                Intrinsics.checkNotNullParameter(str, "apiRequestId");
                Intrinsics.checkNotNullParameter(backendAPIRequestData, "paired");
                String replace$default = StringsKt.replace$default(backendAPIRequestData.getEventName(), CustomData.API_REQUEST_PREFIX, CustomData.API_RESPONSE_PREFIX, false, 4, (Object) null);
                String sdkFlowId = backendAPIRequestData.getSdkFlowId();
                boolean z = th == null;
                if (th == null || (localizedMessage = th.getMessage()) == null) {
                    localizedMessage = th != null ? th.getLocalizedMessage() : null;
                }
                return new BackendAPIResponseData(str, replace$default, sdkFlowId, z, localizedMessage, (DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0005\u0006\u0007\b\t\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u0001\u0006\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData;", "Lcom/adapty/internal/data/models/AnalyticsEvent$CustomData;", "methodName", "", "(Ljava/lang/String;)V", "AcknowledgePurchase", "ConsumePurchase", "MakePurchase", "QueryActivePurchases", "QueryProductDetails", "QueryPurchaseHistory", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$AcknowledgePurchase;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$ConsumePurchase;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$MakePurchase;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$QueryActivePurchases;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$QueryProductDetails;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$QueryPurchaseHistory;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnalyticsEvent.kt */
    public static abstract class GoogleAPIRequestData extends CustomData {
        public /* synthetic */ GoogleAPIRequestData(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        private GoogleAPIRequestData(String str) {
            super(CustomData.GOOGLE_REQUEST_PREFIX + str, UUID.randomUUID().toString(), (DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\fB%\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$QueryProductDetails;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData;", "productIds", "", "", "googleProductType", "methodName", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getGoogleProductType", "()Ljava/lang/String;", "getProductIds", "()Ljava/util/List;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class QueryProductDetails extends GoogleAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String googleProductType;
            private final List<String> productIds;

            public /* synthetic */ QueryProductDetails(List list, String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, str, str2);
            }

            public final List<String> getProductIds() {
                return this.productIds;
            }

            public final String getGoogleProductType() {
                return this.googleProductType;
            }

            private QueryProductDetails(List<String> list, String str, String str2) {
                super(str2, (DefaultConstructorMarker) null);
                this.productIds = list;
                this.googleProductType = str;
            }

            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$QueryProductDetails$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$QueryProductDetails;", "productIds", "", "", "googleProductType", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final QueryProductDetails create(List<String> list, String str) {
                    Intrinsics.checkNotNullParameter(list, "productIds");
                    Intrinsics.checkNotNullParameter(str, "googleProductType");
                    return new QueryProductDetails(list, str, "query_product_details", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$QueryActivePurchases;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData;", "googleProductType", "", "methodName", "(Ljava/lang/String;Ljava/lang/String;)V", "getGoogleProductType", "()Ljava/lang/String;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class QueryActivePurchases extends GoogleAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String googleProductType;

            public /* synthetic */ QueryActivePurchases(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2);
            }

            public final String getGoogleProductType() {
                return this.googleProductType;
            }

            private QueryActivePurchases(String str, String str2) {
                super(str2, (DefaultConstructorMarker) null);
                this.googleProductType = str;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$QueryActivePurchases$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$QueryActivePurchases;", "googleProductType", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final QueryActivePurchases create(String str) {
                    Intrinsics.checkNotNullParameter(str, "googleProductType");
                    return new QueryActivePurchases(str, "query_active_purchases", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$QueryPurchaseHistory;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData;", "googleProductType", "", "methodName", "(Ljava/lang/String;Ljava/lang/String;)V", "getGoogleProductType", "()Ljava/lang/String;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class QueryPurchaseHistory extends GoogleAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String googleProductType;

            public /* synthetic */ QueryPurchaseHistory(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2);
            }

            public final String getGoogleProductType() {
                return this.googleProductType;
            }

            private QueryPurchaseHistory(String str, String str2) {
                super(str2, (DefaultConstructorMarker) null);
                this.googleProductType = str;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$QueryPurchaseHistory$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$QueryPurchaseHistory;", "googleProductType", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final QueryPurchaseHistory create(String str) {
                    Intrinsics.checkNotNullParameter(str, "googleProductType");
                    return new QueryPurchaseHistory(str, "query_purchase_history", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012BG\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$MakePurchase;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData;", "productId", "", "productType", "basePlanId", "offerId", "oldSubVendorProductId", "replacementMode", "methodName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBasePlanId", "()Ljava/lang/String;", "getOfferId", "getOldSubVendorProductId", "getProductId", "getProductType", "getReplacementMode", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class MakePurchase extends GoogleAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String basePlanId;
            private final String offerId;
            private final String oldSubVendorProductId;
            private final String productId;
            private final String productType;
            private final String replacementMode;

            public /* synthetic */ MakePurchase(String str, String str2, String str3, String str4, String str5, String str6, String str7, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3, str4, str5, str6, str7);
            }

            public final String getProductId() {
                return this.productId;
            }

            public final String getProductType() {
                return this.productType;
            }

            public final String getBasePlanId() {
                return this.basePlanId;
            }

            public final String getOfferId() {
                return this.offerId;
            }

            public final String getOldSubVendorProductId() {
                return this.oldSubVendorProductId;
            }

            public final String getReplacementMode() {
                return this.replacementMode;
            }

            private MakePurchase(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
                super(str7, (DefaultConstructorMarker) null);
                this.productId = str;
                this.productType = str2;
                this.basePlanId = str3;
                this.offerId = str4;
                this.oldSubVendorProductId = str5;
                this.replacementMode = str6;
            }

            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$MakePurchase$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$MakePurchase;", "purchaseableProduct", "Lcom/adapty/internal/domain/models/PurchaseableProduct;", "subscriptionUpdateParams", "Lcom/adapty/models/AdaptySubscriptionUpdateParameters;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final MakePurchase create(PurchaseableProduct purchaseableProduct, AdaptySubscriptionUpdateParameters adaptySubscriptionUpdateParameters) {
                    AdaptySubscriptionUpdateParameters.ReplacementMode replacementMode;
                    Intrinsics.checkNotNullParameter(purchaseableProduct, "purchaseableProduct");
                    String vendorProductId = purchaseableProduct.getVendorProductId();
                    String type = purchaseableProduct.getType();
                    ProductDetails.SubscriptionOfferDetails currentOfferDetails = purchaseableProduct.getCurrentOfferDetails();
                    String basePlanId = currentOfferDetails != null ? currentOfferDetails.getBasePlanId() : null;
                    ProductDetails.SubscriptionOfferDetails currentOfferDetails2 = purchaseableProduct.getCurrentOfferDetails();
                    return new MakePurchase(vendorProductId, type, basePlanId, currentOfferDetails2 != null ? currentOfferDetails2.getOfferId() : null, adaptySubscriptionUpdateParameters != null ? adaptySubscriptionUpdateParameters.getOldSubVendorProductId() : null, (adaptySubscriptionUpdateParameters == null || (replacementMode = adaptySubscriptionUpdateParameters.getReplacementMode()) == null) ? null : replacementMode.name(), "make_purchase", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$AcknowledgePurchase;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData;", "productId", "", "methodName", "(Ljava/lang/String;Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class AcknowledgePurchase extends GoogleAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String productId;

            public /* synthetic */ AcknowledgePurchase(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2);
            }

            public final String getProductId() {
                return this.productId;
            }

            private AcknowledgePurchase(String str, String str2) {
                super(str2, (DefaultConstructorMarker) null);
                this.productId = str;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$AcknowledgePurchase$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$AcknowledgePurchase;", "purchase", "Lcom/android/billingclient/api/Purchase;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final AcknowledgePurchase create(Purchase purchase) {
                    Intrinsics.checkNotNullParameter(purchase, FirebaseAnalytics.Event.PURCHASE);
                    List<String> products = purchase.getProducts();
                    Intrinsics.checkNotNullExpressionValue(products, "purchase.products");
                    String str = (String) CollectionsKt.firstOrNull(products);
                    if (str == null) {
                        str = "";
                    }
                    return new AcknowledgePurchase(str, "acknowledge_purchase", (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$ConsumePurchase;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData;", "productId", "", "methodName", "(Ljava/lang/String;Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class ConsumePurchase extends GoogleAPIRequestData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String productId;

            public /* synthetic */ ConsumePurchase(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2);
            }

            public final String getProductId() {
                return this.productId;
            }

            private ConsumePurchase(String str, String str2) {
                super(str2, (DefaultConstructorMarker) null);
                this.productId = str;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$ConsumePurchase$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$ConsumePurchase;", "purchase", "Lcom/android/billingclient/api/Purchase;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final ConsumePurchase create(Purchase purchase) {
                    Intrinsics.checkNotNullParameter(purchase, FirebaseAnalytics.Event.PURCHASE);
                    List<String> products = purchase.getProducts();
                    Intrinsics.checkNotNullExpressionValue(products, "purchase.products");
                    String str = (String) CollectionsKt.firstOrNull(products);
                    if (str == null) {
                        str = "";
                    }
                    return new ConsumePurchase(str, "consume_purchase", (DefaultConstructorMarker) null);
                }
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000e2\u00020\u0001:\u0006\r\u000e\u000f\u0010\u0011\u0012B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0001\u0005\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData;", "Lcom/adapty/internal/data/models/AnalyticsEvent$CustomData;", "eventName", "", "flowId", "success", "", "error", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getError", "()Ljava/lang/String;", "getSuccess", "()Z", "Basic", "Companion", "MakePurchase", "QueryActivePurchases", "QueryProductDetails", "QueryPurchaseHistory", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$Basic;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$MakePurchase;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$QueryActivePurchases;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$QueryProductDetails;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$QueryPurchaseHistory;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnalyticsEvent.kt */
    public static abstract class GoogleAPIResponseData extends CustomData {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String error;
        private final boolean success;

        public /* synthetic */ GoogleAPIResponseData(String str, String str2, boolean z, String str3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, z, str3);
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final String getError() {
            return this.error;
        }

        private GoogleAPIResponseData(String str, String str2, boolean z, String str3) {
            super(str, str2, (DefaultConstructorMarker) null);
            this.success = z;
            this.error = str3;
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$Basic;", "paired", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData;", "error", "Lcom/adapty/errors/AdaptyError;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ Basic create$default(Companion companion, GoogleAPIRequestData googleAPIRequestData, AdaptyError adaptyError, int i, Object obj) {
                if ((i & 2) != 0) {
                    adaptyError = null;
                }
                return companion.create(googleAPIRequestData, adaptyError);
            }

            public final Basic create(GoogleAPIRequestData googleAPIRequestData, AdaptyError adaptyError) {
                Intrinsics.checkNotNullParameter(googleAPIRequestData, "paired");
                return Basic.Companion.create(googleAPIRequestData, adaptyError);
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$Basic;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData;", "eventName", "", "flowId", "success", "", "error", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class Basic extends GoogleAPIResponseData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

            public /* synthetic */ Basic(String str, String str2, boolean z, String str3, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, z, str3);
            }

            private Basic(String str, String str2, boolean z, String str3) {
                super(str, str2, z, str3, (DefaultConstructorMarker) null);
            }

            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$Basic$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$Basic;", "paired", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData;", "error", "Lcom/adapty/errors/AdaptyError;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final Basic create(GoogleAPIRequestData googleAPIRequestData, AdaptyError adaptyError) {
                    Intrinsics.checkNotNullParameter(googleAPIRequestData, "paired");
                    return new Basic(StringsKt.replace$default(googleAPIRequestData.getEventName(), CustomData.GOOGLE_REQUEST_PREFIX, CustomData.GOOGLE_RESPONSE_PREFIX, false, 4, (Object) null), googleAPIRequestData.getSdkFlowId(), adaptyError == null, adaptyError != null ? adaptyError.getMessage() : null, (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB;\b\u0002\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\nR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$QueryProductDetails;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData;", "productIds", "", "", "eventName", "flowId", "success", "", "error", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getProductIds", "()Ljava/util/List;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class QueryProductDetails extends GoogleAPIResponseData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final List<String> productIds;

            public /* synthetic */ QueryProductDetails(List list, String str, String str2, boolean z, String str3, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, str, str2, z, str3);
            }

            public final List<String> getProductIds() {
                return this.productIds;
            }

            private QueryProductDetails(List<String> list, String str, String str2, boolean z, String str3) {
                super(str, str2, z, str3, (DefaultConstructorMarker) null);
                this.productIds = list;
            }

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0003\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$QueryProductDetails$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$QueryProductDetails;", "error", "Lcom/adapty/errors/AdaptyError;", "paired", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$QueryProductDetails;", "productList", "", "Lcom/android/billingclient/api/ProductDetails;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final QueryProductDetails create(AdaptyError adaptyError, GoogleAPIRequestData.QueryProductDetails queryProductDetails) {
                    Intrinsics.checkNotNullParameter(adaptyError, "error");
                    Intrinsics.checkNotNullParameter(queryProductDetails, "paired");
                    return new QueryProductDetails((List) null, StringsKt.replace$default(queryProductDetails.getEventName(), CustomData.GOOGLE_REQUEST_PREFIX, CustomData.GOOGLE_RESPONSE_PREFIX, false, 4, (Object) null), queryProductDetails.getSdkFlowId(), false, adaptyError.getMessage(), (DefaultConstructorMarker) null);
                }

                public final QueryProductDetails create(List<ProductDetails> list, GoogleAPIRequestData.QueryProductDetails queryProductDetails) {
                    Intrinsics.checkNotNullParameter(queryProductDetails, "paired");
                    if (list == null) {
                        list = CollectionsKt.emptyList();
                    }
                    Iterable<ProductDetails> iterable = list;
                    Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    for (ProductDetails productId : iterable) {
                        String productId2 = productId.getProductId();
                        Intrinsics.checkNotNullExpressionValue(productId2, "it.productId");
                        arrayList.add(productId2);
                    }
                    return new QueryProductDetails((List) arrayList, StringsKt.replace$default(queryProductDetails.getEventName(), CustomData.GOOGLE_REQUEST_PREFIX, CustomData.GOOGLE_RESPONSE_PREFIX, false, 4, (Object) null), queryProductDetails.getSdkFlowId(), true, (String) null, (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB;\b\u0002\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\nR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$QueryActivePurchases;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData;", "productIds", "", "", "eventName", "flowId", "success", "", "error", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getProductIds", "()Ljava/util/List;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class QueryActivePurchases extends GoogleAPIResponseData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final List<String> productIds;

            public /* synthetic */ QueryActivePurchases(List list, String str, String str2, boolean z, String str3, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, str, str2, z, str3);
            }

            public final List<String> getProductIds() {
                return this.productIds;
            }

            private QueryActivePurchases(List<String> list, String str, String str2, boolean z, String str3) {
                super(str, str2, z, str3, (DefaultConstructorMarker) null);
                this.productIds = list;
            }

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0003\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$QueryActivePurchases$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$QueryActivePurchases;", "error", "Lcom/adapty/errors/AdaptyError;", "paired", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$QueryActivePurchases;", "purchaseList", "", "Lcom/android/billingclient/api/Purchase;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final QueryActivePurchases create(AdaptyError adaptyError, GoogleAPIRequestData.QueryActivePurchases queryActivePurchases) {
                    Intrinsics.checkNotNullParameter(adaptyError, "error");
                    Intrinsics.checkNotNullParameter(queryActivePurchases, "paired");
                    return new QueryActivePurchases((List) null, StringsKt.replace$default(queryActivePurchases.getEventName(), CustomData.GOOGLE_REQUEST_PREFIX, CustomData.GOOGLE_RESPONSE_PREFIX, false, 4, (Object) null), queryActivePurchases.getSdkFlowId(), false, adaptyError.getMessage(), (DefaultConstructorMarker) null);
                }

                public final QueryActivePurchases create(List<? extends Purchase> list, GoogleAPIRequestData.QueryActivePurchases queryActivePurchases) {
                    Intrinsics.checkNotNullParameter(queryActivePurchases, "paired");
                    if (list == null) {
                        list = CollectionsKt.emptyList();
                    }
                    Iterable<Purchase> iterable = list;
                    Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    for (Purchase products : iterable) {
                        List<String> products2 = products.getProducts();
                        Intrinsics.checkNotNullExpressionValue(products2, "it.products");
                        String str = (String) CollectionsKt.firstOrNull(products2);
                        if (str == null) {
                            str = "";
                        }
                        arrayList.add(str);
                    }
                    return new QueryActivePurchases((List) arrayList, StringsKt.replace$default(queryActivePurchases.getEventName(), CustomData.GOOGLE_REQUEST_PREFIX, CustomData.GOOGLE_RESPONSE_PREFIX, false, 4, (Object) null), queryActivePurchases.getSdkFlowId(), true, (String) null, (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB;\b\u0002\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\nR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$QueryPurchaseHistory;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData;", "productIds", "", "", "eventName", "flowId", "success", "", "error", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getProductIds", "()Ljava/util/List;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class QueryPurchaseHistory extends GoogleAPIResponseData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final List<String> productIds;

            public /* synthetic */ QueryPurchaseHistory(List list, String str, String str2, boolean z, String str3, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, str, str2, z, str3);
            }

            public final List<String> getProductIds() {
                return this.productIds;
            }

            private QueryPurchaseHistory(List<String> list, String str, String str2, boolean z, String str3) {
                super(str, str2, z, str3, (DefaultConstructorMarker) null);
                this.productIds = list;
            }

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0003\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$QueryPurchaseHistory$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$QueryPurchaseHistory;", "error", "Lcom/adapty/errors/AdaptyError;", "paired", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$QueryPurchaseHistory;", "purchaseList", "", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final QueryPurchaseHistory create(AdaptyError adaptyError, GoogleAPIRequestData.QueryPurchaseHistory queryPurchaseHistory) {
                    Intrinsics.checkNotNullParameter(adaptyError, "error");
                    Intrinsics.checkNotNullParameter(queryPurchaseHistory, "paired");
                    return new QueryPurchaseHistory((List) null, StringsKt.replace$default(queryPurchaseHistory.getEventName(), CustomData.GOOGLE_REQUEST_PREFIX, CustomData.GOOGLE_RESPONSE_PREFIX, false, 4, (Object) null), queryPurchaseHistory.getSdkFlowId(), false, adaptyError.getMessage(), (DefaultConstructorMarker) null);
                }

                public final QueryPurchaseHistory create(List<? extends PurchaseHistoryRecord> list, GoogleAPIRequestData.QueryPurchaseHistory queryPurchaseHistory) {
                    Intrinsics.checkNotNullParameter(queryPurchaseHistory, "paired");
                    if (list == null) {
                        list = CollectionsKt.emptyList();
                    }
                    Iterable<PurchaseHistoryRecord> iterable = list;
                    Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    for (PurchaseHistoryRecord products : iterable) {
                        List<String> products2 = products.getProducts();
                        Intrinsics.checkNotNullExpressionValue(products2, "it.products");
                        String str = (String) CollectionsKt.firstOrNull(products2);
                        if (str == null) {
                            str = "";
                        }
                        arrayList.add(str);
                    }
                    return new QueryPurchaseHistory((List) arrayList, StringsKt.replace$default(queryPurchaseHistory.getEventName(), CustomData.GOOGLE_REQUEST_PREFIX, CustomData.GOOGLE_RESPONSE_PREFIX, false, 4, (Object) null), queryPurchaseHistory.getSdkFlowId(), true, (String) null, (DefaultConstructorMarker) null);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB=\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$MakePurchase;", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData;", "state", "", "productId", "eventName", "flowId", "success", "", "error", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "getState", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AnalyticsEvent.kt */
        public static final class MakePurchase extends GoogleAPIResponseData {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String productId;
            private final String state;

            public /* synthetic */ MakePurchase(String str, String str2, String str3, String str4, boolean z, String str5, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3, str4, z, str5);
            }

            public final String getState() {
                return this.state;
            }

            public final String getProductId() {
                return this.productId;
            }

            private MakePurchase(String str, String str2, String str3, String str4, boolean z, String str5) {
                super(str3, str4, z, str5, (DefaultConstructorMarker) null);
                this.state = str;
                this.productId = str2;
            }

            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$MakePurchase$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIResponseData$MakePurchase;", "paired", "Lcom/adapty/internal/data/models/AnalyticsEvent$GoogleAPIRequestData$MakePurchase;", "error", "Lcom/adapty/errors/AdaptyError;", "purchaseProductId", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: AnalyticsEvent.kt */
            public static final class Companion {

                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                /* compiled from: AnalyticsEvent.kt */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    /* JADX WARNING: Failed to process nested try/catch */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
                    static {
                        /*
                            com.adapty.errors.AdaptyErrorCode[] r0 = com.adapty.errors.AdaptyErrorCode.values()
                            int r0 = r0.length
                            int[] r0 = new int[r0]
                            com.adapty.errors.AdaptyErrorCode r1 = com.adapty.errors.AdaptyErrorCode.USER_CANCELED     // Catch:{ NoSuchFieldError -> 0x0010 }
                            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                            r2 = 1
                            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                        L_0x0010:
                            com.adapty.errors.AdaptyErrorCode r1 = com.adapty.errors.AdaptyErrorCode.PENDING_PURCHASE     // Catch:{ NoSuchFieldError -> 0x0019 }
                            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                            r2 = 2
                            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                        L_0x0019:
                            $EnumSwitchMapping$0 = r0
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.models.AnalyticsEvent.GoogleAPIResponseData.MakePurchase.Companion.WhenMappings.<clinit>():void");
                    }
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public static /* synthetic */ MakePurchase create$default(Companion companion, GoogleAPIRequestData.MakePurchase makePurchase, AdaptyError adaptyError, String str, int i, Object obj) {
                    if ((i & 4) != 0) {
                        str = null;
                    }
                    return companion.create(makePurchase, adaptyError, str);
                }

                public final MakePurchase create(GoogleAPIRequestData.MakePurchase makePurchase, AdaptyError adaptyError, String str) {
                    AdaptyErrorCode adaptyErrorCode;
                    String str2;
                    boolean z;
                    String str3;
                    String str4;
                    Intrinsics.checkNotNullParameter(makePurchase, "paired");
                    String str5 = null;
                    if (adaptyError != null) {
                        adaptyErrorCode = adaptyError.getAdaptyErrorCode();
                    } else {
                        adaptyErrorCode = null;
                    }
                    int i = adaptyErrorCode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[adaptyErrorCode.ordinal()];
                    if (i == -1) {
                        str4 = "purchased";
                    } else if (i == 1) {
                        str4 = "canceled";
                    } else if (i != 2) {
                        String message = adaptyError.getMessage();
                        CharSequence charSequence = message;
                        if (!(!(charSequence == null || charSequence.length() == 0))) {
                            message = null;
                        }
                        if (message == null) {
                            Throwable originalError = adaptyError.getOriginalError();
                            if (originalError != null) {
                                str5 = originalError.getLocalizedMessage();
                            }
                        } else {
                            str5 = message;
                        }
                        str2 = str5;
                        str3 = "failed";
                        z = false;
                        return new MakePurchase(str3, str, StringsKt.replace$default(makePurchase.getEventName(), CustomData.GOOGLE_REQUEST_PREFIX, CustomData.GOOGLE_RESPONSE_PREFIX, false, 4, (Object) null), makePurchase.getSdkFlowId(), z, str2, (DefaultConstructorMarker) null);
                    } else {
                        str4 = "pending";
                    }
                    str2 = null;
                    str3 = str4;
                    z = true;
                    return new MakePurchase(str3, str, StringsKt.replace$default(makePurchase.getEventName(), CustomData.GOOGLE_REQUEST_PREFIX, CustomData.GOOGLE_RESPONSE_PREFIX, false, 4, (Object) null), makePurchase.getSdkFlowId(), z, str2, (DefaultConstructorMarker) null);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsEvent$Companion;", "", "()V", "CUSTOM_DATA", "", "RETAIN_LIMIT", "", "SEND_LIMIT", "SYSTEM_LOG", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnalyticsEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
