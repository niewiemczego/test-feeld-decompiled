package zendesk.android.internal.di;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.ZendeskCredentials;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lzendesk/android/internal/di/ZendeskComponentConfig;", "", "channelKey", "Lzendesk/android/ZendeskCredentials;", "baseUrl", "", "versionName", "osVersion", "(Lzendesk/android/ZendeskCredentials;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getChannelKey", "()Lzendesk/android/ZendeskCredentials;", "getOsVersion", "getVersionName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ZendeskComponentConfig.kt */
public final class ZendeskComponentConfig {
    private final String baseUrl;
    private final ZendeskCredentials channelKey;
    private final String osVersion;
    private final String versionName;

    public static /* synthetic */ ZendeskComponentConfig copy$default(ZendeskComponentConfig zendeskComponentConfig, ZendeskCredentials zendeskCredentials, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            zendeskCredentials = zendeskComponentConfig.channelKey;
        }
        if ((i & 2) != 0) {
            str = zendeskComponentConfig.baseUrl;
        }
        if ((i & 4) != 0) {
            str2 = zendeskComponentConfig.versionName;
        }
        if ((i & 8) != 0) {
            str3 = zendeskComponentConfig.osVersion;
        }
        return zendeskComponentConfig.copy(zendeskCredentials, str, str2, str3);
    }

    public final ZendeskCredentials component1() {
        return this.channelKey;
    }

    public final String component2() {
        return this.baseUrl;
    }

    public final String component3() {
        return this.versionName;
    }

    public final String component4() {
        return this.osVersion;
    }

    public final ZendeskComponentConfig copy(ZendeskCredentials zendeskCredentials, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(zendeskCredentials, "channelKey");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(str2, "versionName");
        Intrinsics.checkNotNullParameter(str3, "osVersion");
        return new ZendeskComponentConfig(zendeskCredentials, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZendeskComponentConfig)) {
            return false;
        }
        ZendeskComponentConfig zendeskComponentConfig = (ZendeskComponentConfig) obj;
        return Intrinsics.areEqual((Object) this.channelKey, (Object) zendeskComponentConfig.channelKey) && Intrinsics.areEqual((Object) this.baseUrl, (Object) zendeskComponentConfig.baseUrl) && Intrinsics.areEqual((Object) this.versionName, (Object) zendeskComponentConfig.versionName) && Intrinsics.areEqual((Object) this.osVersion, (Object) zendeskComponentConfig.osVersion);
    }

    public int hashCode() {
        return (((((this.channelKey.hashCode() * 31) + this.baseUrl.hashCode()) * 31) + this.versionName.hashCode()) * 31) + this.osVersion.hashCode();
    }

    public String toString() {
        return "ZendeskComponentConfig(channelKey=" + this.channelKey + ", baseUrl=" + this.baseUrl + ", versionName=" + this.versionName + ", osVersion=" + this.osVersion + ')';
    }

    public ZendeskComponentConfig(ZendeskCredentials zendeskCredentials, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(zendeskCredentials, "channelKey");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(str2, "versionName");
        Intrinsics.checkNotNullParameter(str3, "osVersion");
        this.channelKey = zendeskCredentials;
        this.baseUrl = str;
        this.versionName = str2;
        this.osVersion = str3;
    }

    public final ZendeskCredentials getChannelKey() {
        return this.channelKey;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }
}
