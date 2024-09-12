package com.adapty.models;

import com.adapty.models.AdaptyProfile;
import com.adapty.utils.ImmutableMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00012BÓ\u0001\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u0006\u00100\u001a\u000201R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR!\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001a¨\u00063"}, d2 = {"Lcom/adapty/models/AdaptyProfileParameters;", "", "email", "", "phoneNumber", "facebookAnonymousId", "mixpanelUserId", "amplitudeUserId", "amplitudeDeviceId", "appmetricaProfileId", "appmetricaDeviceId", "oneSignalPlayerId", "oneSignalSubscriptionId", "pushwooshHwid", "firebaseAppInstanceId", "airbridgeDeviceId", "firstName", "lastName", "gender", "birthday", "analyticsDisabled", "", "customAttributes", "Lcom/adapty/utils/ImmutableMap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/adapty/utils/ImmutableMap;)V", "getAirbridgeDeviceId", "()Ljava/lang/String;", "getAmplitudeDeviceId", "getAmplitudeUserId", "getAnalyticsDisabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAppmetricaDeviceId", "getAppmetricaProfileId", "getBirthday", "getCustomAttributes", "()Lcom/adapty/utils/ImmutableMap;", "getEmail", "getFacebookAnonymousId", "getFirebaseAppInstanceId", "getFirstName", "getGender", "getLastName", "getMixpanelUserId", "getOneSignalPlayerId", "getOneSignalSubscriptionId", "getPhoneNumber", "getPushwooshHwid", "builder", "Lcom/adapty/models/AdaptyProfileParameters$Builder;", "Builder", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyProfileParameters.kt */
public final class AdaptyProfileParameters {
    private final String airbridgeDeviceId;
    private final String amplitudeDeviceId;
    private final String amplitudeUserId;
    private final Boolean analyticsDisabled;
    private final String appmetricaDeviceId;
    private final String appmetricaProfileId;
    private final String birthday;
    private final ImmutableMap<String, Object> customAttributes;
    private final String email;
    private final String facebookAnonymousId;
    private final String firebaseAppInstanceId;
    private final String firstName;
    private final String gender;
    private final String lastName;
    private final String mixpanelUserId;
    private final String oneSignalPlayerId;
    private final String oneSignalSubscriptionId;
    private final String phoneNumber;
    private final String pushwooshHwid;

    public /* synthetic */ AdaptyProfileParameters(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Boolean bool, ImmutableMap immutableMap, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, bool, immutableMap);
    }

    private AdaptyProfileParameters(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Boolean bool, ImmutableMap<String, Object> immutableMap) {
        this.email = str;
        this.phoneNumber = str2;
        this.facebookAnonymousId = str3;
        this.mixpanelUserId = str4;
        this.amplitudeUserId = str5;
        this.amplitudeDeviceId = str6;
        this.appmetricaProfileId = str7;
        this.appmetricaDeviceId = str8;
        this.oneSignalPlayerId = str9;
        this.oneSignalSubscriptionId = str10;
        this.pushwooshHwid = str11;
        this.firebaseAppInstanceId = str12;
        this.airbridgeDeviceId = str13;
        this.firstName = str14;
        this.lastName = str15;
        this.gender = str16;
        this.birthday = str17;
        this.analyticsDisabled = bool;
        this.customAttributes = immutableMap;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getFacebookAnonymousId() {
        return this.facebookAnonymousId;
    }

    public final String getMixpanelUserId() {
        return this.mixpanelUserId;
    }

    public final String getAmplitudeUserId() {
        return this.amplitudeUserId;
    }

    public final String getAmplitudeDeviceId() {
        return this.amplitudeDeviceId;
    }

    public final String getAppmetricaProfileId() {
        return this.appmetricaProfileId;
    }

    public final String getAppmetricaDeviceId() {
        return this.appmetricaDeviceId;
    }

    public final String getOneSignalPlayerId() {
        return this.oneSignalPlayerId;
    }

    public final String getOneSignalSubscriptionId() {
        return this.oneSignalSubscriptionId;
    }

    public final String getPushwooshHwid() {
        return this.pushwooshHwid;
    }

    public final String getFirebaseAppInstanceId() {
        return this.firebaseAppInstanceId;
    }

    public final String getAirbridgeDeviceId() {
        return this.airbridgeDeviceId;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final Boolean getAnalyticsDisabled() {
        return this.analyticsDisabled;
    }

    public final ImmutableMap<String, Object> getCustomAttributes() {
        return this.customAttributes;
    }

    public final Builder builder() {
        return Builder.Companion.from(this);
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 82\u00020\u0001:\u00018B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B÷\u0001\b\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010 \u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010!\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\"\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010#J\u0016\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'J\u0016\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004J\u0010\u0010(\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0015\u0010)\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0010\u0010-\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010.\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u0010\u0010/\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u000100J\u0010\u00101\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0010\u00102\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u00103\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0010\u00104\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u0010\u00105\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u00106\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u000e\u00107\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0004R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/adapty/models/AdaptyProfileParameters$Builder;", "", "()V", "email", "", "phoneNumber", "facebookAnonymousId", "mixpanelUserId", "amplitudeUserId", "amplitudeDeviceId", "appmetricaProfileId", "appmetricaDeviceId", "oneSignalPlayerId", "oneSignalSubscriptionId", "pushwooshHwid", "firebaseAppInstanceId", "airbridgeDeviceId", "firstName", "lastName", "gender", "birthday", "analyticsDisabled", "", "customAttributes", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)V", "Ljava/lang/Boolean;", "build", "Lcom/adapty/models/AdaptyProfileParameters;", "withAirbridgeDeviceId", "withAmplitudeDeviceId", "withAmplitudeUserId", "withAppmetricaDeviceId", "withAppmetricaProfileId", "withBirthday", "Lcom/adapty/models/AdaptyProfile$Date;", "withCustomAttribute", "key", "value", "", "withEmail", "withExternalAnalyticsDisabled", "disabled", "(Ljava/lang/Boolean;)Lcom/adapty/models/AdaptyProfileParameters$Builder;", "withFacebookAnonymousId", "withFirebaseAppInstanceId", "withFirstName", "withGender", "Lcom/adapty/models/AdaptyProfile$Gender;", "withLastName", "withMixpanelUserId", "withOneSignalPlayerId", "withOneSignalSubscriptionId", "withPhoneNumber", "withPushwooshHwid", "withRemovedCustomAttribute", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyProfileParameters.kt */
    public static final class Builder {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String airbridgeDeviceId;
        private String amplitudeDeviceId;
        private String amplitudeUserId;
        private Boolean analyticsDisabled;
        private String appmetricaDeviceId;
        private String appmetricaProfileId;
        private String birthday;
        private final Map<String, Object> customAttributes;
        private String email;
        private String facebookAnonymousId;
        private String firebaseAppInstanceId;
        private String firstName;
        private String gender;
        private String lastName;
        private String mixpanelUserId;
        private String oneSignalPlayerId;
        private String oneSignalSubscriptionId;
        private String phoneNumber;
        private String pushwooshHwid;

        public /* synthetic */ Builder(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Boolean bool, Map map, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, bool, map);
        }

        private Builder(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Boolean bool, Map<String, Object> map) {
            this.email = str;
            this.phoneNumber = str2;
            this.facebookAnonymousId = str3;
            this.mixpanelUserId = str4;
            this.amplitudeUserId = str5;
            this.amplitudeDeviceId = str6;
            this.appmetricaProfileId = str7;
            this.appmetricaDeviceId = str8;
            this.oneSignalPlayerId = str9;
            this.oneSignalSubscriptionId = str10;
            this.pushwooshHwid = str11;
            this.firebaseAppInstanceId = str12;
            this.airbridgeDeviceId = str13;
            this.firstName = str14;
            this.lastName = str15;
            this.gender = str16;
            this.birthday = str17;
            this.analyticsDisabled = bool;
            this.customAttributes = map;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* synthetic */ Builder(java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.Boolean r38, java.util.Map r39, int r40, kotlin.jvm.internal.DefaultConstructorMarker r41) {
            /*
                r20 = this;
                r0 = r40
                r1 = r0 & 1
                if (r1 == 0) goto L_0x0008
                r1 = 0
                goto L_0x000a
            L_0x0008:
                r1 = r21
            L_0x000a:
                r3 = r0 & 2
                if (r3 == 0) goto L_0x0010
                r3 = 0
                goto L_0x0012
            L_0x0010:
                r3 = r22
            L_0x0012:
                r4 = r0 & 4
                if (r4 == 0) goto L_0x0018
                r4 = 0
                goto L_0x001a
            L_0x0018:
                r4 = r23
            L_0x001a:
                r5 = r0 & 8
                if (r5 == 0) goto L_0x0020
                r5 = 0
                goto L_0x0022
            L_0x0020:
                r5 = r24
            L_0x0022:
                r6 = r0 & 16
                if (r6 == 0) goto L_0x0028
                r6 = 0
                goto L_0x002a
            L_0x0028:
                r6 = r25
            L_0x002a:
                r7 = r0 & 32
                if (r7 == 0) goto L_0x0030
                r7 = 0
                goto L_0x0032
            L_0x0030:
                r7 = r26
            L_0x0032:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x0038
                r8 = 0
                goto L_0x003a
            L_0x0038:
                r8 = r27
            L_0x003a:
                r9 = r0 & 128(0x80, float:1.794E-43)
                if (r9 == 0) goto L_0x0040
                r9 = 0
                goto L_0x0042
            L_0x0040:
                r9 = r28
            L_0x0042:
                r10 = r0 & 256(0x100, float:3.59E-43)
                if (r10 == 0) goto L_0x0048
                r10 = 0
                goto L_0x004a
            L_0x0048:
                r10 = r29
            L_0x004a:
                r11 = r0 & 512(0x200, float:7.175E-43)
                if (r11 == 0) goto L_0x0050
                r11 = 0
                goto L_0x0052
            L_0x0050:
                r11 = r30
            L_0x0052:
                r12 = r0 & 1024(0x400, float:1.435E-42)
                if (r12 == 0) goto L_0x0058
                r12 = 0
                goto L_0x005a
            L_0x0058:
                r12 = r31
            L_0x005a:
                r13 = r0 & 2048(0x800, float:2.87E-42)
                if (r13 == 0) goto L_0x0060
                r13 = 0
                goto L_0x0062
            L_0x0060:
                r13 = r32
            L_0x0062:
                r14 = r0 & 4096(0x1000, float:5.74E-42)
                if (r14 == 0) goto L_0x0068
                r14 = 0
                goto L_0x006a
            L_0x0068:
                r14 = r33
            L_0x006a:
                r15 = r0 & 8192(0x2000, float:1.14794E-41)
                if (r15 == 0) goto L_0x0070
                r15 = 0
                goto L_0x0072
            L_0x0070:
                r15 = r34
            L_0x0072:
                r2 = r0 & 16384(0x4000, float:2.2959E-41)
                if (r2 == 0) goto L_0x0078
                r2 = 0
                goto L_0x007a
            L_0x0078:
                r2 = r35
            L_0x007a:
                r16 = 32768(0x8000, float:4.5918E-41)
                r16 = r0 & r16
                if (r16 == 0) goto L_0x0084
                r16 = 0
                goto L_0x0086
            L_0x0084:
                r16 = r36
            L_0x0086:
                r17 = 65536(0x10000, float:9.18355E-41)
                r17 = r0 & r17
                if (r17 == 0) goto L_0x008f
                r17 = 0
                goto L_0x0091
            L_0x008f:
                r17 = r37
            L_0x0091:
                r18 = 131072(0x20000, float:1.83671E-40)
                r18 = r0 & r18
                if (r18 == 0) goto L_0x009a
                r18 = 0
                goto L_0x009c
            L_0x009a:
                r18 = r38
            L_0x009c:
                r19 = 262144(0x40000, float:3.67342E-40)
                r0 = r0 & r19
                if (r0 == 0) goto L_0x00aa
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                java.util.Map r0 = (java.util.Map) r0
                goto L_0x00ac
            L_0x00aa:
                r0 = r39
            L_0x00ac:
                r21 = r20
                r22 = r1
                r23 = r3
                r24 = r4
                r25 = r5
                r26 = r6
                r27 = r7
                r28 = r8
                r29 = r9
                r30 = r10
                r31 = r11
                r32 = r12
                r33 = r13
                r34 = r14
                r35 = r15
                r36 = r2
                r37 = r16
                r38 = r17
                r39 = r18
                r40 = r0
                r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adapty.models.AdaptyProfileParameters.Builder.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public Builder() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Map) null, 524286, (DefaultConstructorMarker) null);
        }

        public final Builder withEmail(String str) {
            this.email = str;
            return this;
        }

        public final Builder withPhoneNumber(String str) {
            this.phoneNumber = str;
            return this;
        }

        public final Builder withFacebookAnonymousId(String str) {
            this.facebookAnonymousId = str;
            return this;
        }

        public final Builder withMixpanelUserId(String str) {
            this.mixpanelUserId = str;
            return this;
        }

        public final Builder withAmplitudeUserId(String str) {
            this.amplitudeUserId = str;
            return this;
        }

        public final Builder withAmplitudeDeviceId(String str) {
            this.amplitudeDeviceId = str;
            return this;
        }

        public final Builder withAppmetricaProfileId(String str) {
            this.appmetricaProfileId = str;
            return this;
        }

        public final Builder withAppmetricaDeviceId(String str) {
            this.appmetricaDeviceId = str;
            return this;
        }

        public final Builder withOneSignalPlayerId(String str) {
            this.oneSignalPlayerId = str;
            return this;
        }

        public final Builder withOneSignalSubscriptionId(String str) {
            this.oneSignalSubscriptionId = str;
            return this;
        }

        public final Builder withPushwooshHwid(String str) {
            this.pushwooshHwid = str;
            return this;
        }

        public final Builder withFirebaseAppInstanceId(String str) {
            this.firebaseAppInstanceId = str;
            return this;
        }

        public final Builder withAirbridgeDeviceId(String str) {
            this.airbridgeDeviceId = str;
            return this;
        }

        public final Builder withFirstName(String str) {
            this.firstName = str;
            return this;
        }

        public final Builder withLastName(String str) {
            this.lastName = str;
            return this;
        }

        public final Builder withGender(AdaptyProfile.Gender gender2) {
            this.gender = gender2 != null ? gender2.toString() : null;
            return this;
        }

        public final Builder withBirthday(AdaptyProfile.Date date) {
            this.birthday = date != null ? date.toString() : null;
            return this;
        }

        public final Builder withExternalAnalyticsDisabled(Boolean bool) {
            this.analyticsDisabled = bool;
            return this;
        }

        public final Builder withCustomAttribute(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "value");
            this.customAttributes.put(str, str2);
            return this;
        }

        public final Builder withCustomAttribute(String str, double d) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.customAttributes.put(str, Double.valueOf(d));
            return this;
        }

        public final Builder withRemovedCustomAttribute(String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.customAttributes.put(str, (Object) null);
            return this;
        }

        public final AdaptyProfileParameters build() {
            String str = this.email;
            String str2 = this.phoneNumber;
            String str3 = this.facebookAnonymousId;
            String str4 = this.mixpanelUserId;
            String str5 = this.amplitudeUserId;
            String str6 = this.amplitudeDeviceId;
            String str7 = this.appmetricaProfileId;
            String str8 = this.appmetricaDeviceId;
            String str9 = this.oneSignalPlayerId;
            String str10 = this.oneSignalSubscriptionId;
            String str11 = this.pushwooshHwid;
            String str12 = this.firebaseAppInstanceId;
            String str13 = this.airbridgeDeviceId;
            String str14 = this.firstName;
            String str15 = this.lastName;
            String str16 = str14;
            String str17 = this.gender;
            String str18 = this.birthday;
            Boolean bool = this.analyticsDisabled;
            String str19 = str15;
            Map<String, Object> map = this.customAttributes;
            if (!(!map.isEmpty())) {
                map = null;
            }
            return new AdaptyProfileParameters(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str16, str19, str17, str18, bool, map != null ? Intrinsics.checkNotNullParameter(map, "<this>") : null, (DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/models/AdaptyProfileParameters$Builder$Companion;", "", "()V", "from", "Lcom/adapty/models/AdaptyProfileParameters$Builder;", "params", "Lcom/adapty/models/AdaptyProfileParameters;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AdaptyProfileParameters.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Builder from(AdaptyProfileParameters adaptyProfileParameters) {
                Map map;
                Map map$adapty_release;
                Intrinsics.checkNotNullParameter(adaptyProfileParameters, "params");
                String email = adaptyProfileParameters.getEmail();
                String phoneNumber = adaptyProfileParameters.getPhoneNumber();
                String facebookAnonymousId = adaptyProfileParameters.getFacebookAnonymousId();
                String mixpanelUserId = adaptyProfileParameters.getMixpanelUserId();
                String amplitudeUserId = adaptyProfileParameters.getAmplitudeUserId();
                String amplitudeDeviceId = adaptyProfileParameters.getAmplitudeDeviceId();
                String appmetricaProfileId = adaptyProfileParameters.getAppmetricaProfileId();
                String appmetricaDeviceId = adaptyProfileParameters.getAppmetricaDeviceId();
                String oneSignalPlayerId = adaptyProfileParameters.getOneSignalPlayerId();
                String oneSignalSubscriptionId = adaptyProfileParameters.getOneSignalSubscriptionId();
                String pushwooshHwid = adaptyProfileParameters.getPushwooshHwid();
                String firebaseAppInstanceId = adaptyProfileParameters.getFirebaseAppInstanceId();
                String airbridgeDeviceId = adaptyProfileParameters.getAirbridgeDeviceId();
                String firstName = adaptyProfileParameters.getFirstName();
                String lastName = adaptyProfileParameters.getLastName();
                String gender = adaptyProfileParameters.getGender();
                String birthday = adaptyProfileParameters.getBirthday();
                Boolean analyticsDisabled = adaptyProfileParameters.getAnalyticsDisabled();
                ImmutableMap<String, Object> customAttributes = adaptyProfileParameters.getCustomAttributes();
                if (customAttributes == null || (map$adapty_release = customAttributes.getMap$adapty_release()) == null || (map = MapsKt.toMutableMap(map$adapty_release)) == null) {
                    map = new LinkedHashMap();
                }
                return new Builder(email, phoneNumber, facebookAnonymousId, mixpanelUserId, amplitudeUserId, amplitudeDeviceId, appmetricaProfileId, appmetricaDeviceId, oneSignalPlayerId, oneSignalSubscriptionId, pushwooshHwid, firebaseAppInstanceId, airbridgeDeviceId, firstName, lastName, gender, birthday, analyticsDisabled, map, (DefaultConstructorMarker) null);
            }
        }
    }
}
