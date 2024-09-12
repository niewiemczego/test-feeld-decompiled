package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bi\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006*"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ClientInfoDto;", "", "appId", "", "appName", "vendor", "sdkVersion", "devicePlatform", "os", "osVersion", "installer", "carrier", "locale", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppName", "getCarrier", "getDevicePlatform", "getInstaller", "getLocale", "getOs", "getOsVersion", "getSdkVersion", "getVendor", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClientDto.kt */
public final class ClientInfoDto {
    private final String appId;
    private final String appName;
    private final String carrier;
    private final String devicePlatform;
    private final String installer;
    private final String locale;
    private final String os;
    private final String osVersion;
    private final String sdkVersion;
    private final String vendor;

    public static /* synthetic */ ClientInfoDto copy$default(ClientInfoDto clientInfoDto, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, Object obj) {
        ClientInfoDto clientInfoDto2 = clientInfoDto;
        int i2 = i;
        return clientInfoDto.copy((i2 & 1) != 0 ? clientInfoDto2.appId : str, (i2 & 2) != 0 ? clientInfoDto2.appName : str2, (i2 & 4) != 0 ? clientInfoDto2.vendor : str3, (i2 & 8) != 0 ? clientInfoDto2.sdkVersion : str4, (i2 & 16) != 0 ? clientInfoDto2.devicePlatform : str5, (i2 & 32) != 0 ? clientInfoDto2.os : str6, (i2 & 64) != 0 ? clientInfoDto2.osVersion : str7, (i2 & 128) != 0 ? clientInfoDto2.installer : str8, (i2 & 256) != 0 ? clientInfoDto2.carrier : str9, (i2 & 512) != 0 ? clientInfoDto2.locale : str10);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component10() {
        return this.locale;
    }

    public final String component2() {
        return this.appName;
    }

    public final String component3() {
        return this.vendor;
    }

    public final String component4() {
        return this.sdkVersion;
    }

    public final String component5() {
        return this.devicePlatform;
    }

    public final String component6() {
        return this.os;
    }

    public final String component7() {
        return this.osVersion;
    }

    public final String component8() {
        return this.installer;
    }

    public final String component9() {
        return this.carrier;
    }

    public final ClientInfoDto copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        return new ClientInfoDto(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientInfoDto)) {
            return false;
        }
        ClientInfoDto clientInfoDto = (ClientInfoDto) obj;
        return Intrinsics.areEqual((Object) this.appId, (Object) clientInfoDto.appId) && Intrinsics.areEqual((Object) this.appName, (Object) clientInfoDto.appName) && Intrinsics.areEqual((Object) this.vendor, (Object) clientInfoDto.vendor) && Intrinsics.areEqual((Object) this.sdkVersion, (Object) clientInfoDto.sdkVersion) && Intrinsics.areEqual((Object) this.devicePlatform, (Object) clientInfoDto.devicePlatform) && Intrinsics.areEqual((Object) this.os, (Object) clientInfoDto.os) && Intrinsics.areEqual((Object) this.osVersion, (Object) clientInfoDto.osVersion) && Intrinsics.areEqual((Object) this.installer, (Object) clientInfoDto.installer) && Intrinsics.areEqual((Object) this.carrier, (Object) clientInfoDto.carrier) && Intrinsics.areEqual((Object) this.locale, (Object) clientInfoDto.locale);
    }

    public int hashCode() {
        String str = this.appId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.appName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.vendor;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sdkVersion;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.devicePlatform;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.os;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.osVersion;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.installer;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.carrier;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.locale;
        if (str10 != null) {
            i = str10.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "ClientInfoDto(appId=" + this.appId + ", appName=" + this.appName + ", vendor=" + this.vendor + ", sdkVersion=" + this.sdkVersion + ", devicePlatform=" + this.devicePlatform + ", os=" + this.os + ", osVersion=" + this.osVersion + ", installer=" + this.installer + ", carrier=" + this.carrier + ", locale=" + this.locale + ')';
    }

    public ClientInfoDto(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.appId = str;
        this.appName = str2;
        this.vendor = str3;
        this.sdkVersion = str4;
        this.devicePlatform = str5;
        this.os = str6;
        this.osVersion = str7;
        this.installer = str8;
        this.carrier = str9;
        this.locale = str10;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getVendor() {
        return this.vendor;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final String getDevicePlatform() {
        return this.devicePlatform;
    }

    public final String getOs() {
        return this.os;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getInstaller() {
        return this.installer;
    }

    public final String getCarrier() {
        return this.carrier;
    }

    public final String getLocale() {
        return this.locale;
    }
}
