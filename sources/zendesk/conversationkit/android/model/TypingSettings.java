package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lzendesk/conversationkit/android/model/TypingSettings;", "", "enabled", "", "(Z)V", "getEnabled", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: User.kt */
public final class TypingSettings {
    private final boolean enabled;

    public static /* synthetic */ TypingSettings copy$default(TypingSettings typingSettings, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = typingSettings.enabled;
        }
        return typingSettings.copy(z);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final TypingSettings copy(boolean z) {
        return new TypingSettings(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TypingSettings) && this.enabled == ((TypingSettings) obj).enabled;
    }

    public int hashCode() {
        boolean z = this.enabled;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "TypingSettings(enabled=" + this.enabled + ')';
    }

    public TypingSettings(boolean z) {
        this.enabled = z;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }
}
