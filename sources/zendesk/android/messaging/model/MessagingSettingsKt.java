package zendesk.android.messaging.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.settings.internal.model.BrandDto;
import zendesk.android.settings.internal.model.NativeMessagingDto;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0000¨\u0006\t"}, d2 = {"toMessagingSettings", "Lzendesk/android/messaging/model/MessagingSettings;", "Lzendesk/android/settings/internal/model/NativeMessagingDto;", "lightTheme", "Lzendesk/android/messaging/model/ColorTheme;", "darkTheme", "isMultiConvoEnabled", "", "canUserCreateMoreConversations", "zendesk_zendesk-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessagingSettings.kt */
public final class MessagingSettingsKt {
    public static /* synthetic */ MessagingSettings toMessagingSettings$default(NativeMessagingDto nativeMessagingDto, ColorTheme colorTheme, ColorTheme colorTheme2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return toMessagingSettings(nativeMessagingDto, colorTheme, colorTheme2, z, z2);
    }

    public static final MessagingSettings toMessagingSettings(NativeMessagingDto nativeMessagingDto, ColorTheme colorTheme, ColorTheme colorTheme2, boolean z, boolean z2) {
        String str;
        String str2;
        NativeMessagingDto nativeMessagingDto2 = nativeMessagingDto;
        Intrinsics.checkNotNullParameter(nativeMessagingDto, "<this>");
        ColorTheme colorTheme3 = colorTheme;
        Intrinsics.checkNotNullParameter(colorTheme, "lightTheme");
        ColorTheme colorTheme4 = colorTheme2;
        Intrinsics.checkNotNullParameter(colorTheme2, "darkTheme");
        String integrationId = nativeMessagingDto.getIntegrationId();
        boolean enabled = nativeMessagingDto.getEnabled();
        BrandDto brand = nativeMessagingDto.getBrand();
        if (brand == null || (str = brand.getName()) == null) {
            str = "";
        }
        String title = nativeMessagingDto.getTitle();
        if (title == null) {
            title = "";
        }
        String description = nativeMessagingDto.getDescription();
        if (description == null) {
            description = "";
        }
        String logoUrl = nativeMessagingDto.getLogoUrl();
        if (logoUrl == null) {
            str2 = "";
        } else {
            str2 = logoUrl;
        }
        return new MessagingSettings(integrationId, enabled, str, title, description, str2, colorTheme, colorTheme2, z, z2);
    }
}
