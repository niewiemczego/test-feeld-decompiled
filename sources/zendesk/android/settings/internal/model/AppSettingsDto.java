package zendesk.android.settings.internal.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000e"}, d2 = {"Lzendesk/android/settings/internal/model/AppSettingsDto;", "", "isMultiConvoEnabled", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SunCoConfigDto.kt */
public final class AppSettingsDto {
    private final boolean isMultiConvoEnabled;

    public static /* synthetic */ AppSettingsDto copy$default(AppSettingsDto appSettingsDto, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = appSettingsDto.isMultiConvoEnabled;
        }
        return appSettingsDto.copy(z);
    }

    public final boolean component1() {
        return this.isMultiConvoEnabled;
    }

    public final AppSettingsDto copy(@Json(name = "multiConvoEnabled") boolean z) {
        return new AppSettingsDto(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AppSettingsDto) && this.isMultiConvoEnabled == ((AppSettingsDto) obj).isMultiConvoEnabled;
    }

    public int hashCode() {
        boolean z = this.isMultiConvoEnabled;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "AppSettingsDto(isMultiConvoEnabled=" + this.isMultiConvoEnabled + ')';
    }

    public AppSettingsDto(@Json(name = "multiConvoEnabled") boolean z) {
        this.isMultiConvoEnabled = z;
    }

    public final boolean isMultiConvoEnabled() {
        return this.isMultiConvoEnabled;
    }
}
