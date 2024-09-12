package zendesk.conversationkit.android.internal.rest.model;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003Je\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006%"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/AppUserRequestDto;", "", "client", "Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "userId", "", "givenName", "surname", "email", "properties", "", "intent", "(Lzendesk/conversationkit/android/internal/rest/model/ClientDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getClient", "()Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "getEmail", "()Ljava/lang/String;", "getGivenName", "getIntent", "getProperties", "()Ljava/util/Map;", "getSurname", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppUserRequestDto.kt */
public final class AppUserRequestDto {
    private final ClientDto client;
    private final String email;
    private final String givenName;
    private final String intent;
    private final Map<String, Object> properties;
    private final String surname;
    private final String userId;

    public static /* synthetic */ AppUserRequestDto copy$default(AppUserRequestDto appUserRequestDto, ClientDto clientDto, String str, String str2, String str3, String str4, Map<String, Object> map, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            clientDto = appUserRequestDto.client;
        }
        if ((i & 2) != 0) {
            str = appUserRequestDto.userId;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = appUserRequestDto.givenName;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = appUserRequestDto.surname;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = appUserRequestDto.email;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            map = appUserRequestDto.properties;
        }
        Map<String, Object> map2 = map;
        if ((i & 64) != 0) {
            str5 = appUserRequestDto.intent;
        }
        return appUserRequestDto.copy(clientDto, str6, str7, str8, str9, map2, str5);
    }

    public final ClientDto component1() {
        return this.client;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.givenName;
    }

    public final String component4() {
        return this.surname;
    }

    public final String component5() {
        return this.email;
    }

    public final Map<String, Object> component6() {
        return this.properties;
    }

    public final String component7() {
        return this.intent;
    }

    public final AppUserRequestDto copy(ClientDto clientDto, String str, String str2, String str3, String str4, Map<String, ? extends Object> map, String str5) {
        Intrinsics.checkNotNullParameter(clientDto, "client");
        String str6 = str5;
        Intrinsics.checkNotNullParameter(str6, SDKConstants.PARAM_INTENT);
        return new AppUserRequestDto(clientDto, str, str2, str3, str4, map, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppUserRequestDto)) {
            return false;
        }
        AppUserRequestDto appUserRequestDto = (AppUserRequestDto) obj;
        return Intrinsics.areEqual((Object) this.client, (Object) appUserRequestDto.client) && Intrinsics.areEqual((Object) this.userId, (Object) appUserRequestDto.userId) && Intrinsics.areEqual((Object) this.givenName, (Object) appUserRequestDto.givenName) && Intrinsics.areEqual((Object) this.surname, (Object) appUserRequestDto.surname) && Intrinsics.areEqual((Object) this.email, (Object) appUserRequestDto.email) && Intrinsics.areEqual((Object) this.properties, (Object) appUserRequestDto.properties) && Intrinsics.areEqual((Object) this.intent, (Object) appUserRequestDto.intent);
    }

    public int hashCode() {
        int hashCode = this.client.hashCode() * 31;
        String str = this.userId;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.givenName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.surname;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.email;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Map<String, Object> map = this.properties;
        if (map != null) {
            i = map.hashCode();
        }
        return ((hashCode5 + i) * 31) + this.intent.hashCode();
    }

    public String toString() {
        return "AppUserRequestDto(client=" + this.client + ", userId=" + this.userId + ", givenName=" + this.givenName + ", surname=" + this.surname + ", email=" + this.email + ", properties=" + this.properties + ", intent=" + this.intent + ')';
    }

    public AppUserRequestDto(ClientDto clientDto, String str, String str2, String str3, String str4, Map<String, ? extends Object> map, String str5) {
        Intrinsics.checkNotNullParameter(clientDto, "client");
        Intrinsics.checkNotNullParameter(str5, SDKConstants.PARAM_INTENT);
        this.client = clientDto;
        this.userId = str;
        this.givenName = str2;
        this.surname = str3;
        this.email = str4;
        this.properties = map;
        this.intent = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AppUserRequestDto(zendesk.conversationkit.android.internal.rest.model.ClientDto r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.util.Map r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r0 = r14 & 2
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r8
        L_0x0008:
            r2 = r14 & 4
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r9
        L_0x000f:
            r3 = r14 & 8
            if (r3 == 0) goto L_0x0015
            r3 = r1
            goto L_0x0016
        L_0x0015:
            r3 = r10
        L_0x0016:
            r4 = r14 & 16
            if (r4 == 0) goto L_0x001c
            r4 = r1
            goto L_0x001d
        L_0x001c:
            r4 = r11
        L_0x001d:
            r5 = r14 & 32
            if (r5 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r1 = r12
        L_0x0023:
            r5 = r14 & 64
            if (r5 == 0) goto L_0x002a
            java.lang.String r5 = "conversation:start"
            goto L_0x002b
        L_0x002a:
            r5 = r13
        L_0x002b:
            r8 = r6
            r9 = r7
            r10 = r0
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r1
            r15 = r5
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.rest.model.AppUserRequestDto.<init>(zendesk.conversationkit.android.internal.rest.model.ClientDto, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ClientDto getClient() {
        return this.client;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getGivenName() {
        return this.givenName;
    }

    public final String getSurname() {
        return this.surname;
    }

    public final String getEmail() {
        return this.email;
    }

    public final Map<String, Object> getProperties() {
        return this.properties;
    }

    public final String getIntent() {
        return this.intent;
    }
}
