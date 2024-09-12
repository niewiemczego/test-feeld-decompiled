package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ConfigResponseDto;", "", "config", "Lzendesk/conversationkit/android/internal/rest/model/ConfigDto;", "(Lzendesk/conversationkit/android/internal/rest/model/ConfigDto;)V", "getConfig", "()Lzendesk/conversationkit/android/internal/rest/model/ConfigDto;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfigResponseDto.kt */
public final class ConfigResponseDto {
    private final ConfigDto config;

    public static /* synthetic */ ConfigResponseDto copy$default(ConfigResponseDto configResponseDto, ConfigDto configDto, int i, Object obj) {
        if ((i & 1) != 0) {
            configDto = configResponseDto.config;
        }
        return configResponseDto.copy(configDto);
    }

    public final ConfigDto component1() {
        return this.config;
    }

    public final ConfigResponseDto copy(ConfigDto configDto) {
        Intrinsics.checkNotNullParameter(configDto, "config");
        return new ConfigResponseDto(configDto);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConfigResponseDto) && Intrinsics.areEqual((Object) this.config, (Object) ((ConfigResponseDto) obj).config);
    }

    public int hashCode() {
        return this.config.hashCode();
    }

    public String toString() {
        return "ConfigResponseDto(config=" + this.config + ')';
    }

    public ConfigResponseDto(ConfigDto configDto) {
        Intrinsics.checkNotNullParameter(configDto, "config");
        this.config = configDto;
    }

    public final ConfigDto getConfig() {
        return this.config;
    }
}
