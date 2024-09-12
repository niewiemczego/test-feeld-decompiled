package zendesk.android.settings.internal.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003JP\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0003\u0010\t\u001a\u00020\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lzendesk/android/settings/internal/model/SettingsDto;", "", "identifier", "", "lightTheme", "Lzendesk/android/settings/internal/model/ColorThemeDto;", "darkTheme", "showZendeskLogo", "", "nativeMessaging", "Lzendesk/android/settings/internal/model/NativeMessagingDto;", "sunCoConfigDto", "Lzendesk/android/settings/internal/model/SunCoConfigDto;", "(Ljava/lang/String;Lzendesk/android/settings/internal/model/ColorThemeDto;Lzendesk/android/settings/internal/model/ColorThemeDto;Ljava/lang/Boolean;Lzendesk/android/settings/internal/model/NativeMessagingDto;Lzendesk/android/settings/internal/model/SunCoConfigDto;)V", "getDarkTheme", "()Lzendesk/android/settings/internal/model/ColorThemeDto;", "getIdentifier", "()Ljava/lang/String;", "getLightTheme", "getNativeMessaging", "()Lzendesk/android/settings/internal/model/NativeMessagingDto;", "getShowZendeskLogo", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSunCoConfigDto", "()Lzendesk/android/settings/internal/model/SunCoConfigDto;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Lzendesk/android/settings/internal/model/ColorThemeDto;Lzendesk/android/settings/internal/model/ColorThemeDto;Ljava/lang/Boolean;Lzendesk/android/settings/internal/model/NativeMessagingDto;Lzendesk/android/settings/internal/model/SunCoConfigDto;)Lzendesk/android/settings/internal/model/SettingsDto;", "equals", "other", "hashCode", "", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingsDto.kt */
public final class SettingsDto {
    private final ColorThemeDto darkTheme;
    private final String identifier;
    private final ColorThemeDto lightTheme;
    private final NativeMessagingDto nativeMessaging;
    private final Boolean showZendeskLogo;
    private final SunCoConfigDto sunCoConfigDto;

    public static /* synthetic */ SettingsDto copy$default(SettingsDto settingsDto, String str, ColorThemeDto colorThemeDto, ColorThemeDto colorThemeDto2, Boolean bool, NativeMessagingDto nativeMessagingDto, SunCoConfigDto sunCoConfigDto2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = settingsDto.identifier;
        }
        if ((i & 2) != 0) {
            colorThemeDto = settingsDto.lightTheme;
        }
        ColorThemeDto colorThemeDto3 = colorThemeDto;
        if ((i & 4) != 0) {
            colorThemeDto2 = settingsDto.darkTheme;
        }
        ColorThemeDto colorThemeDto4 = colorThemeDto2;
        if ((i & 8) != 0) {
            bool = settingsDto.showZendeskLogo;
        }
        Boolean bool2 = bool;
        if ((i & 16) != 0) {
            nativeMessagingDto = settingsDto.nativeMessaging;
        }
        NativeMessagingDto nativeMessagingDto2 = nativeMessagingDto;
        if ((i & 32) != 0) {
            sunCoConfigDto2 = settingsDto.sunCoConfigDto;
        }
        return settingsDto.copy(str, colorThemeDto3, colorThemeDto4, bool2, nativeMessagingDto2, sunCoConfigDto2);
    }

    public final String component1() {
        return this.identifier;
    }

    public final ColorThemeDto component2() {
        return this.lightTheme;
    }

    public final ColorThemeDto component3() {
        return this.darkTheme;
    }

    public final Boolean component4() {
        return this.showZendeskLogo;
    }

    public final NativeMessagingDto component5() {
        return this.nativeMessaging;
    }

    public final SunCoConfigDto component6() {
        return this.sunCoConfigDto;
    }

    public final SettingsDto copy(String str, @Json(name = "light_theme") ColorThemeDto colorThemeDto, @Json(name = "dark_theme") ColorThemeDto colorThemeDto2, @Json(name = "show_zendesk_logo") Boolean bool, @Json(name = "native_messaging") NativeMessagingDto nativeMessagingDto, @Json(name = "sunco_config") SunCoConfigDto sunCoConfigDto2) {
        Intrinsics.checkNotNullParameter(colorThemeDto, "lightTheme");
        Intrinsics.checkNotNullParameter(colorThemeDto2, "darkTheme");
        Intrinsics.checkNotNullParameter(nativeMessagingDto, "nativeMessaging");
        return new SettingsDto(str, colorThemeDto, colorThemeDto2, bool, nativeMessagingDto, sunCoConfigDto2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettingsDto)) {
            return false;
        }
        SettingsDto settingsDto = (SettingsDto) obj;
        return Intrinsics.areEqual((Object) this.identifier, (Object) settingsDto.identifier) && Intrinsics.areEqual((Object) this.lightTheme, (Object) settingsDto.lightTheme) && Intrinsics.areEqual((Object) this.darkTheme, (Object) settingsDto.darkTheme) && Intrinsics.areEqual((Object) this.showZendeskLogo, (Object) settingsDto.showZendeskLogo) && Intrinsics.areEqual((Object) this.nativeMessaging, (Object) settingsDto.nativeMessaging) && Intrinsics.areEqual((Object) this.sunCoConfigDto, (Object) settingsDto.sunCoConfigDto);
    }

    public int hashCode() {
        String str = this.identifier;
        int i = 0;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.lightTheme.hashCode()) * 31) + this.darkTheme.hashCode()) * 31;
        Boolean bool = this.showZendeskLogo;
        int hashCode2 = (((hashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.nativeMessaging.hashCode()) * 31;
        SunCoConfigDto sunCoConfigDto2 = this.sunCoConfigDto;
        if (sunCoConfigDto2 != null) {
            i = sunCoConfigDto2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SettingsDto(identifier=" + this.identifier + ", lightTheme=" + this.lightTheme + ", darkTheme=" + this.darkTheme + ", showZendeskLogo=" + this.showZendeskLogo + ", nativeMessaging=" + this.nativeMessaging + ", sunCoConfigDto=" + this.sunCoConfigDto + ')';
    }

    public SettingsDto(String str, @Json(name = "light_theme") ColorThemeDto colorThemeDto, @Json(name = "dark_theme") ColorThemeDto colorThemeDto2, @Json(name = "show_zendesk_logo") Boolean bool, @Json(name = "native_messaging") NativeMessagingDto nativeMessagingDto, @Json(name = "sunco_config") SunCoConfigDto sunCoConfigDto2) {
        Intrinsics.checkNotNullParameter(colorThemeDto, "lightTheme");
        Intrinsics.checkNotNullParameter(colorThemeDto2, "darkTheme");
        Intrinsics.checkNotNullParameter(nativeMessagingDto, "nativeMessaging");
        this.identifier = str;
        this.lightTheme = colorThemeDto;
        this.darkTheme = colorThemeDto2;
        this.showZendeskLogo = bool;
        this.nativeMessaging = nativeMessagingDto;
        this.sunCoConfigDto = sunCoConfigDto2;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final ColorThemeDto getLightTheme() {
        return this.lightTheme;
    }

    public final ColorThemeDto getDarkTheme() {
        return this.darkTheme;
    }

    public final Boolean getShowZendeskLogo() {
        return this.showZendeskLogo;
    }

    public final NativeMessagingDto getNativeMessaging() {
        return this.nativeMessaging;
    }

    public final SunCoConfigDto getSunCoConfigDto() {
        return this.sunCoConfigDto;
    }
}
