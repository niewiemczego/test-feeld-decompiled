package zendesk.android.messaging.model;

import io.sentry.protocol.Device;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003Jo\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0013\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006,"}, d2 = {"Lzendesk/android/messaging/model/MessagingSettings;", "", "integrationId", "", "enabled", "", "brand", "title", "description", "logoUrl", "lightTheme", "Lzendesk/android/messaging/model/ColorTheme;", "darkTheme", "isMultiConvoEnabled", "canUserCreateMoreConversations", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/android/messaging/model/ColorTheme;Lzendesk/android/messaging/model/ColorTheme;ZZ)V", "getBrand", "()Ljava/lang/String;", "getCanUserCreateMoreConversations", "()Z", "getDarkTheme", "()Lzendesk/android/messaging/model/ColorTheme;", "getDescription", "getEnabled", "getIntegrationId", "getLightTheme", "getLogoUrl", "getTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessagingSettings.kt */
public final class MessagingSettings {
    private final String brand;
    private final boolean canUserCreateMoreConversations;
    private final ColorTheme darkTheme;
    private final String description;
    private final boolean enabled;
    private final String integrationId;
    private final boolean isMultiConvoEnabled;
    private final ColorTheme lightTheme;
    private final String logoUrl;
    private final String title;

    public static /* synthetic */ MessagingSettings copy$default(MessagingSettings messagingSettings, String str, boolean z, String str2, String str3, String str4, String str5, ColorTheme colorTheme, ColorTheme colorTheme2, boolean z2, boolean z3, int i, Object obj) {
        MessagingSettings messagingSettings2 = messagingSettings;
        int i2 = i;
        return messagingSettings.copy((i2 & 1) != 0 ? messagingSettings2.integrationId : str, (i2 & 2) != 0 ? messagingSettings2.enabled : z, (i2 & 4) != 0 ? messagingSettings2.brand : str2, (i2 & 8) != 0 ? messagingSettings2.title : str3, (i2 & 16) != 0 ? messagingSettings2.description : str4, (i2 & 32) != 0 ? messagingSettings2.logoUrl : str5, (i2 & 64) != 0 ? messagingSettings2.lightTheme : colorTheme, (i2 & 128) != 0 ? messagingSettings2.darkTheme : colorTheme2, (i2 & 256) != 0 ? messagingSettings2.isMultiConvoEnabled : z2, (i2 & 512) != 0 ? messagingSettings2.canUserCreateMoreConversations : z3);
    }

    public final String component1() {
        return this.integrationId;
    }

    public final boolean component10() {
        return this.canUserCreateMoreConversations;
    }

    public final boolean component2() {
        return this.enabled;
    }

    public final String component3() {
        return this.brand;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.description;
    }

    public final String component6() {
        return this.logoUrl;
    }

    public final ColorTheme component7() {
        return this.lightTheme;
    }

    public final ColorTheme component8() {
        return this.darkTheme;
    }

    public final boolean component9() {
        return this.isMultiConvoEnabled;
    }

    public final MessagingSettings copy(String str, boolean z, String str2, String str3, String str4, String str5, ColorTheme colorTheme, ColorTheme colorTheme2, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str2, Device.JsonKeys.BRAND);
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, "title");
        String str7 = str4;
        Intrinsics.checkNotNullParameter(str7, "description");
        String str8 = str5;
        Intrinsics.checkNotNullParameter(str8, "logoUrl");
        ColorTheme colorTheme3 = colorTheme;
        Intrinsics.checkNotNullParameter(colorTheme3, "lightTheme");
        ColorTheme colorTheme4 = colorTheme2;
        Intrinsics.checkNotNullParameter(colorTheme4, "darkTheme");
        return new MessagingSettings(str, z, str2, str6, str7, str8, colorTheme3, colorTheme4, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessagingSettings)) {
            return false;
        }
        MessagingSettings messagingSettings = (MessagingSettings) obj;
        return Intrinsics.areEqual((Object) this.integrationId, (Object) messagingSettings.integrationId) && this.enabled == messagingSettings.enabled && Intrinsics.areEqual((Object) this.brand, (Object) messagingSettings.brand) && Intrinsics.areEqual((Object) this.title, (Object) messagingSettings.title) && Intrinsics.areEqual((Object) this.description, (Object) messagingSettings.description) && Intrinsics.areEqual((Object) this.logoUrl, (Object) messagingSettings.logoUrl) && Intrinsics.areEqual((Object) this.lightTheme, (Object) messagingSettings.lightTheme) && Intrinsics.areEqual((Object) this.darkTheme, (Object) messagingSettings.darkTheme) && this.isMultiConvoEnabled == messagingSettings.isMultiConvoEnabled && this.canUserCreateMoreConversations == messagingSettings.canUserCreateMoreConversations;
    }

    public int hashCode() {
        String str = this.integrationId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.enabled;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode2 = (((((((((((((hashCode + (z ? 1 : 0)) * 31) + this.brand.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.lightTheme.hashCode()) * 31) + this.darkTheme.hashCode()) * 31;
        boolean z3 = this.isMultiConvoEnabled;
        if (z3) {
            z3 = true;
        }
        int i = (hashCode2 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.canUserCreateMoreConversations;
        if (!z4) {
            z2 = z4;
        }
        return i + (z2 ? 1 : 0);
    }

    public String toString() {
        return "MessagingSettings(integrationId=" + this.integrationId + ", enabled=" + this.enabled + ", brand=" + this.brand + ", title=" + this.title + ", description=" + this.description + ", logoUrl=" + this.logoUrl + ", lightTheme=" + this.lightTheme + ", darkTheme=" + this.darkTheme + ", isMultiConvoEnabled=" + this.isMultiConvoEnabled + ", canUserCreateMoreConversations=" + this.canUserCreateMoreConversations + ')';
    }

    public MessagingSettings(String str, boolean z, String str2, String str3, String str4, String str5, ColorTheme colorTheme, ColorTheme colorTheme2, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str2, Device.JsonKeys.BRAND);
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, "description");
        Intrinsics.checkNotNullParameter(str5, "logoUrl");
        Intrinsics.checkNotNullParameter(colorTheme, "lightTheme");
        Intrinsics.checkNotNullParameter(colorTheme2, "darkTheme");
        this.integrationId = str;
        this.enabled = z;
        this.brand = str2;
        this.title = str3;
        this.description = str4;
        this.logoUrl = str5;
        this.lightTheme = colorTheme;
        this.darkTheme = colorTheme2;
        this.isMultiConvoEnabled = z2;
        this.canUserCreateMoreConversations = z3;
    }

    public final String getIntegrationId() {
        return this.integrationId;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final ColorTheme getLightTheme() {
        return this.lightTheme;
    }

    public final ColorTheme getDarkTheme() {
        return this.darkTheme;
    }

    public final boolean isMultiConvoEnabled() {
        return this.isMultiConvoEnabled;
    }

    public final boolean getCanUserCreateMoreConversations() {
        return this.canUserCreateMoreConversations;
    }
}
