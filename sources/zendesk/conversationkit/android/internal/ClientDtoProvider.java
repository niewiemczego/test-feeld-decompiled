package zendesk.conversationkit.android.internal;

import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.ClientDto;
import zendesk.conversationkit.android.internal.rest.model.ClientInfoDto;
import zendesk.faye.internal.Bayeux;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lzendesk/conversationkit/android/internal/ClientDtoProvider;", "", "sdkVendor", "", "sdkVersion", "hostAppInfo", "Lzendesk/conversationkit/android/internal/HostAppInfo;", "localeString", "(Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/HostAppInfo;Ljava/lang/String;)V", "buildClient", "Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "integrationId", "clientId", "pushToken", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClientDtoProvider.kt */
public final class ClientDtoProvider {
    private final HostAppInfo hostAppInfo;
    private final String localeString;
    private final String sdkVendor;
    private final String sdkVersion;

    public ClientDtoProvider(String str, String str2, HostAppInfo hostAppInfo2, String str3) {
        Intrinsics.checkNotNullParameter(str, "sdkVendor");
        Intrinsics.checkNotNullParameter(str2, "sdkVersion");
        Intrinsics.checkNotNullParameter(hostAppInfo2, "hostAppInfo");
        Intrinsics.checkNotNullParameter(str3, "localeString");
        this.sdkVendor = str;
        this.sdkVersion = str2;
        this.hostAppInfo = hostAppInfo2;
        this.localeString = str3;
    }

    public final ClientDto buildClient(String str, String str2, String str3) {
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, "integrationId");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str5, Bayeux.KEY_CLIENT_ID);
        return new ClientDto(str5, (String) null, (String) null, "android", str4, str3, this.hostAppInfo.getAppVersion$zendesk_conversationkit_conversationkit_android(), (String) null, new ClientInfoDto(this.hostAppInfo.getAppPackage$zendesk_conversationkit_conversationkit_android(), this.hostAppInfo.getAppName$zendesk_conversationkit_conversationkit_android(), this.sdkVendor, this.sdkVersion, this.hostAppInfo.getDeviceManufacturer$zendesk_conversationkit_conversationkit_android() + ' ' + this.hostAppInfo.getDeviceModel$zendesk_conversationkit_conversationkit_android(), this.hostAppInfo.getDeviceOperatingSystem$zendesk_conversationkit_conversationkit_android(), this.hostAppInfo.getDeviceOperatingSystemVersion$zendesk_conversationkit_conversationkit_android(), this.hostAppInfo.getAppInstallerPackage$zendesk_conversationkit_conversationkit_android(), this.hostAppInfo.getDeviceCarrierName$zendesk_conversationkit_conversationkit_android(), this.localeString), TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, (DefaultConstructorMarker) null);
    }
}
