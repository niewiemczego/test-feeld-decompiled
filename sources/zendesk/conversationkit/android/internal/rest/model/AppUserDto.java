package zendesk.conversationkit.android.internal.rest.model;

import com.braze.models.FeatureFlag;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000fHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u0001\u0010(\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000fHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006/"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/AppUserDto;", "", "id", "", "userId", "givenName", "surname", "email", "locale", "signedUpAt", "clients", "", "Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "pendingClients", "properties", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getClients", "()Ljava/util/List;", "getEmail", "()Ljava/lang/String;", "getGivenName", "getId", "getLocale", "getPendingClients", "getProperties", "()Ljava/util/Map;", "getSignedUpAt", "getSurname", "getUserId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppUserDto.kt */
public final class AppUserDto {
    private final List<ClientDto> clients;
    private final String email;
    private final String givenName;
    private final String id;
    private final String locale;
    private final List<ClientDto> pendingClients;
    private final Map<String, Object> properties;
    private final String signedUpAt;
    private final String surname;
    private final String userId;

    public static /* synthetic */ AppUserDto copy$default(AppUserDto appUserDto, String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, List list2, Map map, int i, Object obj) {
        AppUserDto appUserDto2 = appUserDto;
        int i2 = i;
        return appUserDto.copy((i2 & 1) != 0 ? appUserDto2.id : str, (i2 & 2) != 0 ? appUserDto2.userId : str2, (i2 & 4) != 0 ? appUserDto2.givenName : str3, (i2 & 8) != 0 ? appUserDto2.surname : str4, (i2 & 16) != 0 ? appUserDto2.email : str5, (i2 & 32) != 0 ? appUserDto2.locale : str6, (i2 & 64) != 0 ? appUserDto2.signedUpAt : str7, (i2 & 128) != 0 ? appUserDto2.clients : list, (i2 & 256) != 0 ? appUserDto2.pendingClients : list2, (i2 & 512) != 0 ? appUserDto2.properties : map);
    }

    public final String component1() {
        return this.id;
    }

    public final Map<String, Object> component10() {
        return this.properties;
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

    public final String component6() {
        return this.locale;
    }

    public final String component7() {
        return this.signedUpAt;
    }

    public final List<ClientDto> component8() {
        return this.clients;
    }

    public final List<ClientDto> component9() {
        return this.pendingClients;
    }

    public final AppUserDto copy(@Json(name = "_id") String str, String str2, String str3, String str4, String str5, String str6, String str7, List<ClientDto> list, List<ClientDto> list2, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        List<ClientDto> list3 = list;
        Intrinsics.checkNotNullParameter(list3, "clients");
        List<ClientDto> list4 = list2;
        Intrinsics.checkNotNullParameter(list4, "pendingClients");
        Map<String, ? extends Object> map2 = map;
        Intrinsics.checkNotNullParameter(map2, FeatureFlag.PROPERTIES);
        return new AppUserDto(str, str2, str3, str4, str5, str6, str7, list3, list4, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppUserDto)) {
            return false;
        }
        AppUserDto appUserDto = (AppUserDto) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) appUserDto.id) && Intrinsics.areEqual((Object) this.userId, (Object) appUserDto.userId) && Intrinsics.areEqual((Object) this.givenName, (Object) appUserDto.givenName) && Intrinsics.areEqual((Object) this.surname, (Object) appUserDto.surname) && Intrinsics.areEqual((Object) this.email, (Object) appUserDto.email) && Intrinsics.areEqual((Object) this.locale, (Object) appUserDto.locale) && Intrinsics.areEqual((Object) this.signedUpAt, (Object) appUserDto.signedUpAt) && Intrinsics.areEqual((Object) this.clients, (Object) appUserDto.clients) && Intrinsics.areEqual((Object) this.pendingClients, (Object) appUserDto.pendingClients) && Intrinsics.areEqual((Object) this.properties, (Object) appUserDto.properties);
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        String str = this.userId;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.givenName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.surname;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.email;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.locale;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.signedUpAt;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return ((((((hashCode6 + i) * 31) + this.clients.hashCode()) * 31) + this.pendingClients.hashCode()) * 31) + this.properties.hashCode();
    }

    public String toString() {
        return "AppUserDto(id=" + this.id + ", userId=" + this.userId + ", givenName=" + this.givenName + ", surname=" + this.surname + ", email=" + this.email + ", locale=" + this.locale + ", signedUpAt=" + this.signedUpAt + ", clients=" + this.clients + ", pendingClients=" + this.pendingClients + ", properties=" + this.properties + ')';
    }

    public AppUserDto(@Json(name = "_id") String str, String str2, String str3, String str4, String str5, String str6, String str7, List<ClientDto> list, List<ClientDto> list2, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(list, "clients");
        Intrinsics.checkNotNullParameter(list2, "pendingClients");
        Intrinsics.checkNotNullParameter(map, FeatureFlag.PROPERTIES);
        this.id = str;
        this.userId = str2;
        this.givenName = str3;
        this.surname = str4;
        this.email = str5;
        this.locale = str6;
        this.signedUpAt = str7;
        this.clients = list;
        this.pendingClients = list2;
        this.properties = map;
    }

    public final String getId() {
        return this.id;
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

    public final String getLocale() {
        return this.locale;
    }

    public final String getSignedUpAt() {
        return this.signedUpAt;
    }

    public final List<ClientDto> getClients() {
        return this.clients;
    }

    public final List<ClientDto> getPendingClients() {
        return this.pendingClients;
    }

    public final Map<String, Object> getProperties() {
        return this.properties;
    }
}
