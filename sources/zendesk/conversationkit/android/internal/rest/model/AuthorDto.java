package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/AuthorDto;", "", "appUserId", "", "role", "client", "Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "sessionId", "(Ljava/lang/String;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/ClientDto;Ljava/lang/String;)V", "getAppUserId", "()Ljava/lang/String;", "getClient", "()Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "getRole", "getSessionId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthorDto.kt */
public final class AuthorDto {
    private final String appUserId;
    private final ClientDto client;
    private final String role;
    private final String sessionId;

    public static /* synthetic */ AuthorDto copy$default(AuthorDto authorDto, String str, String str2, ClientDto clientDto, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authorDto.appUserId;
        }
        if ((i & 2) != 0) {
            str2 = authorDto.role;
        }
        if ((i & 4) != 0) {
            clientDto = authorDto.client;
        }
        if ((i & 8) != 0) {
            str3 = authorDto.sessionId;
        }
        return authorDto.copy(str, str2, clientDto, str3);
    }

    public final String component1() {
        return this.appUserId;
    }

    public final String component2() {
        return this.role;
    }

    public final ClientDto component3() {
        return this.client;
    }

    public final String component4() {
        return this.sessionId;
    }

    public final AuthorDto copy(String str, String str2, ClientDto clientDto, String str3) {
        Intrinsics.checkNotNullParameter(str, "appUserId");
        Intrinsics.checkNotNullParameter(str2, "role");
        Intrinsics.checkNotNullParameter(clientDto, "client");
        return new AuthorDto(str, str2, clientDto, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthorDto)) {
            return false;
        }
        AuthorDto authorDto = (AuthorDto) obj;
        return Intrinsics.areEqual((Object) this.appUserId, (Object) authorDto.appUserId) && Intrinsics.areEqual((Object) this.role, (Object) authorDto.role) && Intrinsics.areEqual((Object) this.client, (Object) authorDto.client) && Intrinsics.areEqual((Object) this.sessionId, (Object) authorDto.sessionId);
    }

    public int hashCode() {
        int hashCode = ((((this.appUserId.hashCode() * 31) + this.role.hashCode()) * 31) + this.client.hashCode()) * 31;
        String str = this.sessionId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AuthorDto(appUserId=" + this.appUserId + ", role=" + this.role + ", client=" + this.client + ", sessionId=" + this.sessionId + ')';
    }

    public AuthorDto(String str, String str2, ClientDto clientDto, String str3) {
        Intrinsics.checkNotNullParameter(str, "appUserId");
        Intrinsics.checkNotNullParameter(str2, "role");
        Intrinsics.checkNotNullParameter(clientDto, "client");
        this.appUserId = str;
        this.role = str2;
        this.client = clientDto;
        this.sessionId = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuthorDto(String str, String str2, ClientDto clientDto, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, clientDto, (i & 8) != 0 ? null : str3);
    }

    public final String getAppUserId() {
        return this.appUserId;
    }

    public final String getRole() {
        return this.role;
    }

    public final ClientDto getClient() {
        return this.client;
    }

    public final String getSessionId() {
        return this.sessionId;
    }
}
