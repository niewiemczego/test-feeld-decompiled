package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/AppDto;", "", "id", "", "status", "name", "settings", "Lzendesk/conversationkit/android/internal/rest/model/AppSettingsDto;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/AppSettingsDto;)V", "getId", "()Ljava/lang/String;", "getName", "getSettings", "()Lzendesk/conversationkit/android/internal/rest/model/AppSettingsDto;", "getStatus", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppDto.kt */
public final class AppDto {
    private final String id;
    private final String name;
    private final AppSettingsDto settings;
    private final String status;

    public static /* synthetic */ AppDto copy$default(AppDto appDto, String str, String str2, String str3, AppSettingsDto appSettingsDto, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appDto.id;
        }
        if ((i & 2) != 0) {
            str2 = appDto.status;
        }
        if ((i & 4) != 0) {
            str3 = appDto.name;
        }
        if ((i & 8) != 0) {
            appSettingsDto = appDto.settings;
        }
        return appDto.copy(str, str2, str3, appSettingsDto);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.name;
    }

    public final AppSettingsDto component4() {
        return this.settings;
    }

    public final AppDto copy(@Json(name = "_id") String str, String str2, String str3, AppSettingsDto appSettingsDto) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "status");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(appSettingsDto, "settings");
        return new AppDto(str, str2, str3, appSettingsDto);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppDto)) {
            return false;
        }
        AppDto appDto = (AppDto) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) appDto.id) && Intrinsics.areEqual((Object) this.status, (Object) appDto.status) && Intrinsics.areEqual((Object) this.name, (Object) appDto.name) && Intrinsics.areEqual((Object) this.settings, (Object) appDto.settings);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.status.hashCode()) * 31) + this.name.hashCode()) * 31) + this.settings.hashCode();
    }

    public String toString() {
        return "AppDto(id=" + this.id + ", status=" + this.status + ", name=" + this.name + ", settings=" + this.settings + ')';
    }

    public AppDto(@Json(name = "_id") String str, String str2, String str3, AppSettingsDto appSettingsDto) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "status");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(appSettingsDto, "settings");
        this.id = str;
        this.status = str2;
        this.name = str3;
        this.settings = appSettingsDto;
    }

    public final String getId() {
        return this.id;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getName() {
        return this.name;
    }

    public final AppSettingsDto getSettings() {
        return this.settings;
    }
}
