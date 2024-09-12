package com.adapty.internal.data.models.requests;

import com.adapty.internal.data.models.InstallationMeta;
import com.adapty.models.AdaptyProfileParameters;
import com.adapty.utils.ImmutableMap;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00052\u00020\u0001:\u0002\u0005\u0006B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/requests/CreateOrUpdateProfileRequest;", "", "data", "Lcom/adapty/internal/data/models/requests/CreateOrUpdateProfileRequest$Data;", "(Lcom/adapty/internal/data/models/requests/CreateOrUpdateProfileRequest$Data;)V", "Companion", "Data", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CreateOrUpdateProfileRequest.kt */
public final class CreateOrUpdateProfileRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("data")
    private final Data data;

    public CreateOrUpdateProfileRequest(Data data2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        this.data = data2;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\rB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/adapty/internal/data/models/requests/CreateOrUpdateProfileRequest$Data;", "", "id", "", "type", "attributes", "Lcom/adapty/internal/data/models/requests/CreateOrUpdateProfileRequest$Data$Attributes;", "(Ljava/lang/String;Ljava/lang/String;Lcom/adapty/internal/data/models/requests/CreateOrUpdateProfileRequest$Data$Attributes;)V", "getAttributes", "()Lcom/adapty/internal/data/models/requests/CreateOrUpdateProfileRequest$Data$Attributes;", "getId", "()Ljava/lang/String;", "getType", "Attributes", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CreateOrUpdateProfileRequest.kt */
    public static final class Data {
        @SerializedName("attributes")
        private final Attributes attributes;
        @SerializedName("id")
        private final String id;
        @SerializedName("type")
        private final String type;

        public Data(String str, String str2, Attributes attributes2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "type");
            this.id = str;
            this.type = str2;
            this.attributes = attributes2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Data(String str, String str2, Attributes attributes2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? "adapty_analytics_profile" : str2, attributes2);
        }

        public final String getId() {
            return this.id;
        }

        public final String getType() {
            return this.type;
        }

        public final Attributes getAttributes() {
            return this.attributes;
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBí\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cR\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0002X\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b8\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/adapty/internal/data/models/requests/CreateOrUpdateProfileRequest$Data$Attributes;", "", "installationMeta", "Lcom/adapty/internal/data/models/InstallationMeta;", "customerUserId", "", "email", "phoneNumber", "facebookAnonymousId", "firstName", "lastName", "gender", "birthday", "amplitudeUserId", "amplitudeDeviceId", "appmetricaProfileId", "appmetricaDeviceId", "mixpanelUserId", "oneSignalPlayerId", "oneSignalSubscriptionId", "pushwooshHwid", "firebaseAppInstanceId", "airbridgeDeviceId", "analyticsDisabled", "", "ipv4Address", "customAttributes", "", "(Lcom/adapty/internal/data/models/InstallationMeta;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Map;)V", "Ljava/lang/Boolean;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: CreateOrUpdateProfileRequest.kt */
        public static final class Attributes {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @SerializedName("airbridge_device_id")
            private final String airbridgeDeviceId;
            @SerializedName("amplitude_device_id")
            private final String amplitudeDeviceId;
            @SerializedName("amplitude_user_id")
            private final String amplitudeUserId;
            @SerializedName("analytics_disabled")
            private final Boolean analyticsDisabled;
            @SerializedName("appmetrica_device_id")
            private final String appmetricaDeviceId;
            @SerializedName("appmetrica_profile_id")
            private final String appmetricaProfileId;
            @SerializedName("birthday")
            private final String birthday;
            @SerializedName("custom_attributes")
            private final Map<String, Object> customAttributes;
            @SerializedName("customer_user_id")
            private final String customerUserId;
            @SerializedName("email")
            private final String email;
            @SerializedName("facebook_anonymous_id")
            private final String facebookAnonymousId;
            @SerializedName("firebase_app_instance_id")
            private final String firebaseAppInstanceId;
            @SerializedName("first_name")
            private final String firstName;
            @SerializedName("gender")
            private final String gender;
            @SerializedName("installation_meta")
            private final InstallationMeta installationMeta;
            @SerializedName("ip_v4_address")
            private final String ipv4Address;
            @SerializedName("last_name")
            private final String lastName;
            @SerializedName("mixpanel_user_id")
            private final String mixpanelUserId;
            @SerializedName("one_signal_player_id")
            private final String oneSignalPlayerId;
            @SerializedName("one_signal_subscription_id")
            private final String oneSignalSubscriptionId;
            @SerializedName("phone_number")
            private final String phoneNumber;
            @SerializedName("pushwoosh_hwid")
            private final String pushwooshHwid;

            public Attributes(InstallationMeta installationMeta2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, Boolean bool, String str19, Map<String, ? extends Object> map) {
                this.installationMeta = installationMeta2;
                this.customerUserId = str;
                this.email = str2;
                this.phoneNumber = str3;
                this.facebookAnonymousId = str4;
                this.firstName = str5;
                this.lastName = str6;
                this.gender = str7;
                this.birthday = str8;
                this.amplitudeUserId = str9;
                this.amplitudeDeviceId = str10;
                this.appmetricaProfileId = str11;
                this.appmetricaDeviceId = str12;
                this.mixpanelUserId = str13;
                this.oneSignalPlayerId = str14;
                this.oneSignalSubscriptionId = str15;
                this.pushwooshHwid = str16;
                this.firebaseAppInstanceId = str17;
                this.airbridgeDeviceId = str18;
                this.analyticsDisabled = bool;
                this.ipv4Address = str19;
                this.customAttributes = map;
            }

            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b¨\u0006\f"}, d2 = {"Lcom/adapty/internal/data/models/requests/CreateOrUpdateProfileRequest$Data$Attributes$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/requests/CreateOrUpdateProfileRequest$Data$Attributes;", "installationMeta", "Lcom/adapty/internal/data/models/InstallationMeta;", "customerUserId", "", "updateProfileParams", "Lcom/adapty/models/AdaptyProfileParameters;", "ipv4Address", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: CreateOrUpdateProfileRequest.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final Attributes create(InstallationMeta installationMeta, String str, AdaptyProfileParameters adaptyProfileParameters, String str2) {
                    ImmutableMap<String, Object> customAttributes;
                    Map map$adapty_release;
                    Map map = null;
                    String email = adaptyProfileParameters != null ? adaptyProfileParameters.getEmail() : null;
                    String phoneNumber = adaptyProfileParameters != null ? adaptyProfileParameters.getPhoneNumber() : null;
                    String facebookAnonymousId = adaptyProfileParameters != null ? adaptyProfileParameters.getFacebookAnonymousId() : null;
                    String mixpanelUserId = adaptyProfileParameters != null ? adaptyProfileParameters.getMixpanelUserId() : null;
                    String amplitudeUserId = adaptyProfileParameters != null ? adaptyProfileParameters.getAmplitudeUserId() : null;
                    String amplitudeDeviceId = adaptyProfileParameters != null ? adaptyProfileParameters.getAmplitudeDeviceId() : null;
                    String appmetricaProfileId = adaptyProfileParameters != null ? adaptyProfileParameters.getAppmetricaProfileId() : null;
                    String appmetricaDeviceId = adaptyProfileParameters != null ? adaptyProfileParameters.getAppmetricaDeviceId() : null;
                    String oneSignalPlayerId = adaptyProfileParameters != null ? adaptyProfileParameters.getOneSignalPlayerId() : null;
                    String oneSignalSubscriptionId = adaptyProfileParameters != null ? adaptyProfileParameters.getOneSignalSubscriptionId() : null;
                    String pushwooshHwid = adaptyProfileParameters != null ? adaptyProfileParameters.getPushwooshHwid() : null;
                    String firebaseAppInstanceId = adaptyProfileParameters != null ? adaptyProfileParameters.getFirebaseAppInstanceId() : null;
                    String airbridgeDeviceId = adaptyProfileParameters != null ? adaptyProfileParameters.getAirbridgeDeviceId() : null;
                    String firstName = adaptyProfileParameters != null ? adaptyProfileParameters.getFirstName() : null;
                    String lastName = adaptyProfileParameters != null ? adaptyProfileParameters.getLastName() : null;
                    String gender = adaptyProfileParameters != null ? adaptyProfileParameters.getGender() : null;
                    String birthday = adaptyProfileParameters != null ? adaptyProfileParameters.getBirthday() : null;
                    Boolean analyticsDisabled = adaptyProfileParameters != null ? adaptyProfileParameters.getAnalyticsDisabled() : null;
                    if (!(adaptyProfileParameters == null || (customAttributes = adaptyProfileParameters.getCustomAttributes()) == null || (map$adapty_release = customAttributes.getMap$adapty_release()) == null)) {
                        map = new LinkedHashMap(MapsKt.mapCapacity(map$adapty_release.size()));
                        for (Map.Entry entry : map$adapty_release.entrySet()) {
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            if (value == null) {
                                value = "";
                            }
                            map.put(key, value);
                        }
                    }
                    return new Attributes(installationMeta, str, email, phoneNumber, facebookAnonymousId, firstName, lastName, gender, birthday, amplitudeUserId, amplitudeDeviceId, appmetricaProfileId, appmetricaDeviceId, mixpanelUserId, oneSignalPlayerId, oneSignalSubscriptionId, pushwooshHwid, firebaseAppInstanceId, airbridgeDeviceId, analyticsDisabled, str2, map);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nJ8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\r"}, d2 = {"Lcom/adapty/internal/data/models/requests/CreateOrUpdateProfileRequest$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/requests/CreateOrUpdateProfileRequest;", "profileId", "", "installationMeta", "Lcom/adapty/internal/data/models/InstallationMeta;", "updateProfileParams", "Lcom/adapty/models/AdaptyProfileParameters;", "ipv4Address", "customerUserId", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CreateOrUpdateProfileRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateOrUpdateProfileRequest create(String str, InstallationMeta installationMeta, AdaptyProfileParameters adaptyProfileParameters, String str2) {
            Intrinsics.checkNotNullParameter(str, "profileId");
            return create(str, installationMeta, (String) null, adaptyProfileParameters, str2);
        }

        public final CreateOrUpdateProfileRequest create(String str, InstallationMeta installationMeta, String str2, AdaptyProfileParameters adaptyProfileParameters) {
            Intrinsics.checkNotNullParameter(str, "profileId");
            return create(str, installationMeta, str2, adaptyProfileParameters, (String) null);
        }

        private final CreateOrUpdateProfileRequest create(String str, InstallationMeta installationMeta, String str2, AdaptyProfileParameters adaptyProfileParameters, String str3) {
            return new CreateOrUpdateProfileRequest(new Data(str, (String) null, Data.Attributes.Companion.create(installationMeta, str2, adaptyProfileParameters, str3), 2, (DefaultConstructorMarker) null));
        }
    }
}
