package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonClass;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001BI\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0013\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006*"}, d2 = {"Lzendesk/conversationkit/android/model/RealtimeSettings;", "", "enabled", "", "baseUrl", "", "retryInterval", "", "maxConnectionAttempts", "", "connectionDelay", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "appId", "userId", "(ZLjava/lang/String;JIJLjava/util/concurrent/TimeUnit;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getBaseUrl", "getConnectionDelay", "()J", "getEnabled", "()Z", "getMaxConnectionAttempts", "()I", "getRetryInterval", "getTimeUnit", "()Ljava/util/concurrent/TimeUnit;", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: User.kt */
public final class RealtimeSettings {
    private final String appId;
    private final String baseUrl;
    private final long connectionDelay;
    private final boolean enabled;
    private final int maxConnectionAttempts;
    private final long retryInterval;
    private final TimeUnit timeUnit;
    private final String userId;

    public static /* synthetic */ RealtimeSettings copy$default(RealtimeSettings realtimeSettings, boolean z, String str, long j, int i, long j2, TimeUnit timeUnit2, String str2, String str3, int i2, Object obj) {
        RealtimeSettings realtimeSettings2 = realtimeSettings;
        int i3 = i2;
        return realtimeSettings.copy((i3 & 1) != 0 ? realtimeSettings2.enabled : z, (i3 & 2) != 0 ? realtimeSettings2.baseUrl : str, (i3 & 4) != 0 ? realtimeSettings2.retryInterval : j, (i3 & 8) != 0 ? realtimeSettings2.maxConnectionAttempts : i, (i3 & 16) != 0 ? realtimeSettings2.connectionDelay : j2, (i3 & 32) != 0 ? realtimeSettings2.timeUnit : timeUnit2, (i3 & 64) != 0 ? realtimeSettings2.appId : str2, (i3 & 128) != 0 ? realtimeSettings2.userId : str3);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final String component2() {
        return this.baseUrl;
    }

    public final long component3() {
        return this.retryInterval;
    }

    public final int component4() {
        return this.maxConnectionAttempts;
    }

    public final long component5() {
        return this.connectionDelay;
    }

    public final TimeUnit component6() {
        return this.timeUnit;
    }

    public final String component7() {
        return this.appId;
    }

    public final String component8() {
        return this.userId;
    }

    public final RealtimeSettings copy(boolean z, String str, long j, int i, long j2, TimeUnit timeUnit2, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        TimeUnit timeUnit3 = timeUnit2;
        Intrinsics.checkNotNullParameter(timeUnit3, "timeUnit");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str4, "appId");
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str5, "userId");
        return new RealtimeSettings(z, str, j, i, j2, timeUnit3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RealtimeSettings)) {
            return false;
        }
        RealtimeSettings realtimeSettings = (RealtimeSettings) obj;
        return this.enabled == realtimeSettings.enabled && Intrinsics.areEqual((Object) this.baseUrl, (Object) realtimeSettings.baseUrl) && this.retryInterval == realtimeSettings.retryInterval && this.maxConnectionAttempts == realtimeSettings.maxConnectionAttempts && this.connectionDelay == realtimeSettings.connectionDelay && this.timeUnit == realtimeSettings.timeUnit && Intrinsics.areEqual((Object) this.appId, (Object) realtimeSettings.appId) && Intrinsics.areEqual((Object) this.userId, (Object) realtimeSettings.userId);
    }

    public int hashCode() {
        boolean z = this.enabled;
        if (z) {
            z = true;
        }
        return ((((((((((((((z ? 1 : 0) * true) + this.baseUrl.hashCode()) * 31) + Long.hashCode(this.retryInterval)) * 31) + Integer.hashCode(this.maxConnectionAttempts)) * 31) + Long.hashCode(this.connectionDelay)) * 31) + this.timeUnit.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.userId.hashCode();
    }

    public String toString() {
        return "RealtimeSettings(enabled=" + this.enabled + ", baseUrl=" + this.baseUrl + ", retryInterval=" + this.retryInterval + ", maxConnectionAttempts=" + this.maxConnectionAttempts + ", connectionDelay=" + this.connectionDelay + ", timeUnit=" + this.timeUnit + ", appId=" + this.appId + ", userId=" + this.userId + ')';
    }

    public RealtimeSettings(boolean z, String str, long j, int i, long j2, TimeUnit timeUnit2, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(timeUnit2, "timeUnit");
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, "userId");
        this.enabled = z;
        this.baseUrl = str;
        this.retryInterval = j;
        this.maxConnectionAttempts = i;
        this.connectionDelay = j2;
        this.timeUnit = timeUnit2;
        this.appId = str2;
        this.userId = str3;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final long getRetryInterval() {
        return this.retryInterval;
    }

    public final int getMaxConnectionAttempts() {
        return this.maxConnectionAttempts;
    }

    public final long getConnectionDelay() {
        return this.connectionDelay;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RealtimeSettings(boolean r13, java.lang.String r14, long r15, int r17, long r18, java.util.concurrent.TimeUnit r20, java.lang.String r21, java.lang.String r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r12 = this;
            r0 = r23 & 32
            if (r0 == 0) goto L_0x0008
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            r9 = r0
            goto L_0x000a
        L_0x0008:
            r9 = r20
        L_0x000a:
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r6 = r17
            r7 = r18
            r10 = r21
            r11 = r22
            r1.<init>(r2, r3, r4, r6, r7, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.model.RealtimeSettings.<init>(boolean, java.lang.String, long, int, long, java.util.concurrent.TimeUnit, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getUserId() {
        return this.userId;
    }
}
