package com.adapty.internal.data.models;

import com.google.gson.annotations.SerializedName;
import io.sentry.protocol.OperatingSystem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0000J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/adapty/internal/data/models/InstallationMeta;", "", "deviceId", "", "adaptySdkVersion", "appBuild", "appVersion", "device", "locale", "os", "platform", "timezone", "userAgent", "advertisingId", "appSetId", "androidId", "storeCountry", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "equals", "", "other", "hasChanged", "previousMeta", "hashCode", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InstallationMeta.kt */
public final class InstallationMeta {
    @SerializedName("adapty_sdk_version")
    private final String adaptySdkVersion;
    @SerializedName("advertising_id")
    private final String advertisingId;
    @SerializedName("android_id")
    private final String androidId;
    @SerializedName("app_build")
    private final String appBuild;
    @SerializedName("android_app_set_id")
    private final String appSetId;
    @SerializedName("app_version")
    private final String appVersion;
    @SerializedName("device")
    private final String device;
    @SerializedName("device_id")
    private final String deviceId;
    @SerializedName("locale")
    private final String locale;
    @SerializedName("os")
    private final String os;
    @SerializedName("platform")
    private final String platform;
    @SerializedName("store_country")
    private final String storeCountry;
    @SerializedName("timezone")
    private final String timezone;
    @SerializedName("user_agent")
    private final String userAgent;

    public InstallationMeta(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        Intrinsics.checkNotNullParameter(str2, "adaptySdkVersion");
        Intrinsics.checkNotNullParameter(str3, "appBuild");
        Intrinsics.checkNotNullParameter(str4, "appVersion");
        Intrinsics.checkNotNullParameter(str5, "device");
        Intrinsics.checkNotNullParameter(str7, OperatingSystem.TYPE);
        Intrinsics.checkNotNullParameter(str8, "platform");
        Intrinsics.checkNotNullParameter(str9, "timezone");
        Intrinsics.checkNotNullParameter(str11, "advertisingId");
        Intrinsics.checkNotNullParameter(str12, "appSetId");
        Intrinsics.checkNotNullParameter(str13, "androidId");
        this.deviceId = str;
        this.adaptySdkVersion = str2;
        this.appBuild = str3;
        this.appVersion = str4;
        this.device = str5;
        this.locale = str6;
        this.os = str7;
        this.platform = str8;
        this.timezone = str9;
        this.userAgent = str10;
        this.advertisingId = str11;
        this.appSetId = str12;
        this.androidId = str13;
        this.storeCountry = str14;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.internal.data.models.InstallationMeta");
        InstallationMeta installationMeta = (InstallationMeta) obj;
        return Intrinsics.areEqual((Object) this.deviceId, (Object) installationMeta.deviceId) && Intrinsics.areEqual((Object) this.adaptySdkVersion, (Object) installationMeta.adaptySdkVersion) && Intrinsics.areEqual((Object) this.appBuild, (Object) installationMeta.appBuild) && Intrinsics.areEqual((Object) this.appVersion, (Object) installationMeta.appVersion) && Intrinsics.areEqual((Object) this.device, (Object) installationMeta.device) && Intrinsics.areEqual((Object) this.locale, (Object) installationMeta.locale) && Intrinsics.areEqual((Object) this.os, (Object) installationMeta.os) && Intrinsics.areEqual((Object) this.platform, (Object) installationMeta.platform) && Intrinsics.areEqual((Object) this.timezone, (Object) installationMeta.timezone) && Intrinsics.areEqual((Object) this.userAgent, (Object) installationMeta.userAgent) && Intrinsics.areEqual((Object) this.advertisingId, (Object) installationMeta.advertisingId) && Intrinsics.areEqual((Object) this.appSetId, (Object) installationMeta.appSetId) && Intrinsics.areEqual((Object) this.androidId, (Object) installationMeta.androidId);
    }

    public int hashCode() {
        int hashCode = ((((((((this.deviceId.hashCode() * 31) + this.adaptySdkVersion.hashCode()) * 31) + this.appBuild.hashCode()) * 31) + this.appVersion.hashCode()) * 31) + this.device.hashCode()) * 31;
        String str = this.locale;
        int i = 0;
        int hashCode2 = (((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.os.hashCode()) * 31) + this.platform.hashCode()) * 31) + this.timezone.hashCode()) * 31;
        String str2 = this.userAgent;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((((hashCode2 + i) * 31) + this.advertisingId.hashCode()) * 31) + this.appSetId.hashCode()) * 31) + this.androidId.hashCode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.storeCountry;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasChanged(com.adapty.internal.data.models.InstallationMeta r2) {
        /*
            r1 = this;
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0015
            java.lang.String r0 = r1.storeCountry
            if (r0 == 0) goto L_0x0013
            java.lang.String r2 = r2.storeCountry
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r2 = 0
            goto L_0x0016
        L_0x0015:
            r2 = 1
        L_0x0016:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.models.InstallationMeta.hasChanged(com.adapty.internal.data.models.InstallationMeta):boolean");
    }
}
