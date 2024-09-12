package zendesk.android.settings.internal.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/android/settings/internal/model/SettingsResponseDto;", "", "settings", "Lzendesk/android/settings/internal/model/SettingsDto;", "(Lzendesk/android/settings/internal/model/SettingsDto;)V", "getSettings", "()Lzendesk/android/settings/internal/model/SettingsDto;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingsDto.kt */
public final class SettingsResponseDto {
    private final SettingsDto settings;

    public static /* synthetic */ SettingsResponseDto copy$default(SettingsResponseDto settingsResponseDto, SettingsDto settingsDto, int i, Object obj) {
        if ((i & 1) != 0) {
            settingsDto = settingsResponseDto.settings;
        }
        return settingsResponseDto.copy(settingsDto);
    }

    public final SettingsDto component1() {
        return this.settings;
    }

    public final SettingsResponseDto copy(SettingsDto settingsDto) {
        Intrinsics.checkNotNullParameter(settingsDto, "settings");
        return new SettingsResponseDto(settingsDto);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SettingsResponseDto) && Intrinsics.areEqual((Object) this.settings, (Object) ((SettingsResponseDto) obj).settings);
    }

    public int hashCode() {
        return this.settings.hashCode();
    }

    public String toString() {
        return "SettingsResponseDto(settings=" + this.settings + ')';
    }

    public SettingsResponseDto(SettingsDto settingsDto) {
        Intrinsics.checkNotNullParameter(settingsDto, "settings");
        this.settings = settingsDto;
    }

    public final SettingsDto getSettings() {
        return this.settings;
    }
}
