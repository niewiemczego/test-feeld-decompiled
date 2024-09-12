package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/UserSettingsDto;", "", "realtime", "Lzendesk/conversationkit/android/internal/rest/model/RealtimeSettingsDto;", "typing", "Lzendesk/conversationkit/android/internal/rest/model/TypingSettingsDto;", "(Lzendesk/conversationkit/android/internal/rest/model/RealtimeSettingsDto;Lzendesk/conversationkit/android/internal/rest/model/TypingSettingsDto;)V", "getRealtime", "()Lzendesk/conversationkit/android/internal/rest/model/RealtimeSettingsDto;", "getTyping", "()Lzendesk/conversationkit/android/internal/rest/model/TypingSettingsDto;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserSettingsDto.kt */
public final class UserSettingsDto {
    private final RealtimeSettingsDto realtime;
    private final TypingSettingsDto typing;

    public static /* synthetic */ UserSettingsDto copy$default(UserSettingsDto userSettingsDto, RealtimeSettingsDto realtimeSettingsDto, TypingSettingsDto typingSettingsDto, int i, Object obj) {
        if ((i & 1) != 0) {
            realtimeSettingsDto = userSettingsDto.realtime;
        }
        if ((i & 2) != 0) {
            typingSettingsDto = userSettingsDto.typing;
        }
        return userSettingsDto.copy(realtimeSettingsDto, typingSettingsDto);
    }

    public final RealtimeSettingsDto component1() {
        return this.realtime;
    }

    public final TypingSettingsDto component2() {
        return this.typing;
    }

    public final UserSettingsDto copy(RealtimeSettingsDto realtimeSettingsDto, TypingSettingsDto typingSettingsDto) {
        Intrinsics.checkNotNullParameter(realtimeSettingsDto, "realtime");
        Intrinsics.checkNotNullParameter(typingSettingsDto, "typing");
        return new UserSettingsDto(realtimeSettingsDto, typingSettingsDto);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserSettingsDto)) {
            return false;
        }
        UserSettingsDto userSettingsDto = (UserSettingsDto) obj;
        return Intrinsics.areEqual((Object) this.realtime, (Object) userSettingsDto.realtime) && Intrinsics.areEqual((Object) this.typing, (Object) userSettingsDto.typing);
    }

    public int hashCode() {
        return (this.realtime.hashCode() * 31) + this.typing.hashCode();
    }

    public String toString() {
        return "UserSettingsDto(realtime=" + this.realtime + ", typing=" + this.typing + ')';
    }

    public UserSettingsDto(RealtimeSettingsDto realtimeSettingsDto, TypingSettingsDto typingSettingsDto) {
        Intrinsics.checkNotNullParameter(realtimeSettingsDto, "realtime");
        Intrinsics.checkNotNullParameter(typingSettingsDto, "typing");
        this.realtime = realtimeSettingsDto;
        this.typing = typingSettingsDto;
    }

    public final RealtimeSettingsDto getRealtime() {
        return this.realtime;
    }

    public final TypingSettingsDto getTyping() {
        return this.typing;
    }
}
