package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001d"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/RealtimeSettingsDto;", "", "enabled", "", "baseUrl", "", "retryInterval", "", "maxConnectionAttempts", "connectionDelay", "(ZLjava/lang/String;III)V", "getBaseUrl", "()Ljava/lang/String;", "getConnectionDelay", "()I", "getEnabled", "()Z", "getMaxConnectionAttempts", "getRetryInterval", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserSettingsDto.kt */
public final class RealtimeSettingsDto {
    private final String baseUrl;
    private final int connectionDelay;
    private final boolean enabled;
    private final int maxConnectionAttempts;
    private final int retryInterval;

    public static /* synthetic */ RealtimeSettingsDto copy$default(RealtimeSettingsDto realtimeSettingsDto, boolean z, String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = realtimeSettingsDto.enabled;
        }
        if ((i4 & 2) != 0) {
            str = realtimeSettingsDto.baseUrl;
        }
        String str2 = str;
        if ((i4 & 4) != 0) {
            i = realtimeSettingsDto.retryInterval;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = realtimeSettingsDto.maxConnectionAttempts;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            i3 = realtimeSettingsDto.connectionDelay;
        }
        return realtimeSettingsDto.copy(z, str2, i5, i6, i3);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final String component2() {
        return this.baseUrl;
    }

    public final int component3() {
        return this.retryInterval;
    }

    public final int component4() {
        return this.maxConnectionAttempts;
    }

    public final int component5() {
        return this.connectionDelay;
    }

    public final RealtimeSettingsDto copy(boolean z, String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        return new RealtimeSettingsDto(z, str, i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RealtimeSettingsDto)) {
            return false;
        }
        RealtimeSettingsDto realtimeSettingsDto = (RealtimeSettingsDto) obj;
        return this.enabled == realtimeSettingsDto.enabled && Intrinsics.areEqual((Object) this.baseUrl, (Object) realtimeSettingsDto.baseUrl) && this.retryInterval == realtimeSettingsDto.retryInterval && this.maxConnectionAttempts == realtimeSettingsDto.maxConnectionAttempts && this.connectionDelay == realtimeSettingsDto.connectionDelay;
    }

    public int hashCode() {
        boolean z = this.enabled;
        if (z) {
            z = true;
        }
        return ((((((((z ? 1 : 0) * true) + this.baseUrl.hashCode()) * 31) + Integer.hashCode(this.retryInterval)) * 31) + Integer.hashCode(this.maxConnectionAttempts)) * 31) + Integer.hashCode(this.connectionDelay);
    }

    public String toString() {
        return "RealtimeSettingsDto(enabled=" + this.enabled + ", baseUrl=" + this.baseUrl + ", retryInterval=" + this.retryInterval + ", maxConnectionAttempts=" + this.maxConnectionAttempts + ", connectionDelay=" + this.connectionDelay + ')';
    }

    public RealtimeSettingsDto(boolean z, String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        this.enabled = z;
        this.baseUrl = str;
        this.retryInterval = i;
        this.maxConnectionAttempts = i2;
        this.connectionDelay = i3;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final int getRetryInterval() {
        return this.retryInterval;
    }

    public final int getMaxConnectionAttempts() {
        return this.maxConnectionAttempts;
    }

    public final int getConnectionDelay() {
        return this.connectionDelay;
    }
}
