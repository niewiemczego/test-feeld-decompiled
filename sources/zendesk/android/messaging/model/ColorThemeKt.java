package zendesk.android.messaging.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.settings.internal.model.ColorThemeDto;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toColorTheme", "Lzendesk/android/messaging/model/ColorTheme;", "Lzendesk/android/settings/internal/model/ColorThemeDto;", "zendesk_zendesk-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ColorTheme.kt */
public final class ColorThemeKt {
    public static final ColorTheme toColorTheme(ColorThemeDto colorThemeDto) {
        Intrinsics.checkNotNullParameter(colorThemeDto, "<this>");
        return new ColorTheme(colorThemeDto.getPrimaryColor(), colorThemeDto.getMessageColor(), colorThemeDto.getActionColor(), colorThemeDto.getNotifyColor(), colorThemeDto.getIconColor());
    }
}
