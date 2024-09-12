package zendesk.conversationkit.android.internal.rest.model;

import app.notifee.core.event.LogEvent;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003Jm\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006)"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "", "id", "", "status", "lastSeen", "platform", "integrationId", "pushNotificationToken", "appVersion", "displayName", "info", "Lzendesk/conversationkit/android/internal/rest/model/ClientInfoDto;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/ClientInfoDto;)V", "getAppVersion", "()Ljava/lang/String;", "getDisplayName", "getId", "getInfo", "()Lzendesk/conversationkit/android/internal/rest/model/ClientInfoDto;", "getIntegrationId", "getLastSeen", "getPlatform", "getPushNotificationToken", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClientDto.kt */
public final class ClientDto {
    private final String appVersion;
    private final String displayName;
    private final String id;
    private final ClientInfoDto info;
    private final String integrationId;
    private final String lastSeen;
    private final String platform;
    private final String pushNotificationToken;
    private final String status;

    public static /* synthetic */ ClientDto copy$default(ClientDto clientDto, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, ClientInfoDto clientInfoDto, int i, Object obj) {
        ClientDto clientDto2 = clientDto;
        int i2 = i;
        return clientDto.copy((i2 & 1) != 0 ? clientDto2.id : str, (i2 & 2) != 0 ? clientDto2.status : str2, (i2 & 4) != 0 ? clientDto2.lastSeen : str3, (i2 & 8) != 0 ? clientDto2.platform : str4, (i2 & 16) != 0 ? clientDto2.integrationId : str5, (i2 & 32) != 0 ? clientDto2.pushNotificationToken : str6, (i2 & 64) != 0 ? clientDto2.appVersion : str7, (i2 & 128) != 0 ? clientDto2.displayName : str8, (i2 & 256) != 0 ? clientDto2.info : clientInfoDto);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.lastSeen;
    }

    public final String component4() {
        return this.platform;
    }

    public final String component5() {
        return this.integrationId;
    }

    public final String component6() {
        return this.pushNotificationToken;
    }

    public final String component7() {
        return this.appVersion;
    }

    public final String component8() {
        return this.displayName;
    }

    public final ClientInfoDto component9() {
        return this.info;
    }

    public final ClientDto copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, ClientInfoDto clientInfoDto) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str4, "platform");
        String str9 = str5;
        Intrinsics.checkNotNullParameter(str9, "integrationId");
        ClientInfoDto clientInfoDto2 = clientInfoDto;
        Intrinsics.checkNotNullParameter(clientInfoDto2, LogEvent.LEVEL_INFO);
        return new ClientDto(str, str2, str3, str4, str9, str6, str7, str8, clientInfoDto2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientDto)) {
            return false;
        }
        ClientDto clientDto = (ClientDto) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) clientDto.id) && Intrinsics.areEqual((Object) this.status, (Object) clientDto.status) && Intrinsics.areEqual((Object) this.lastSeen, (Object) clientDto.lastSeen) && Intrinsics.areEqual((Object) this.platform, (Object) clientDto.platform) && Intrinsics.areEqual((Object) this.integrationId, (Object) clientDto.integrationId) && Intrinsics.areEqual((Object) this.pushNotificationToken, (Object) clientDto.pushNotificationToken) && Intrinsics.areEqual((Object) this.appVersion, (Object) clientDto.appVersion) && Intrinsics.areEqual((Object) this.displayName, (Object) clientDto.displayName) && Intrinsics.areEqual((Object) this.info, (Object) clientDto.info);
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        String str = this.status;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.lastSeen;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.platform.hashCode()) * 31) + this.integrationId.hashCode()) * 31;
        String str3 = this.pushNotificationToken;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.appVersion;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.displayName;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return ((hashCode5 + i) * 31) + this.info.hashCode();
    }

    public String toString() {
        return "ClientDto(id=" + this.id + ", status=" + this.status + ", lastSeen=" + this.lastSeen + ", platform=" + this.platform + ", integrationId=" + this.integrationId + ", pushNotificationToken=" + this.pushNotificationToken + ", appVersion=" + this.appVersion + ", displayName=" + this.displayName + ", info=" + this.info + ')';
    }

    public ClientDto(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, ClientInfoDto clientInfoDto) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str4, "platform");
        Intrinsics.checkNotNullParameter(str5, "integrationId");
        Intrinsics.checkNotNullParameter(clientInfoDto, LogEvent.LEVEL_INFO);
        this.id = str;
        this.status = str2;
        this.lastSeen = str3;
        this.platform = str4;
        this.integrationId = str5;
        this.pushNotificationToken = str6;
        this.appVersion = str7;
        this.displayName = str8;
        this.info = clientInfoDto;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ClientDto(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, zendesk.conversationkit.android.internal.rest.model.ClientInfoDto r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000a
        L_0x0009:
            r5 = r15
        L_0x000a:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0010
            r6 = r2
            goto L_0x0012
        L_0x0010:
            r6 = r16
        L_0x0012:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0018
            r11 = r2
            goto L_0x001a
        L_0x0018:
            r11 = r21
        L_0x001a:
            r3 = r13
            r4 = r14
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r12 = r22
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.rest.model.ClientDto.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, zendesk.conversationkit.android.internal.rest.model.ClientInfoDto, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getId() {
        return this.id;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getLastSeen() {
        return this.lastSeen;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getIntegrationId() {
        return this.integrationId;
    }

    public final String getPushNotificationToken() {
        return this.pushNotificationToken;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final ClientInfoDto getInfo() {
        return this.info;
    }
}
