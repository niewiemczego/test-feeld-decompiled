package zendesk.conversationkit.android.internal.rest.user.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.ClientDto;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/user/model/LoginRequestBody;", "", "userId", "", "client", "Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "appUserId", "sessionToken", "(Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/ClientDto;Ljava/lang/String;Ljava/lang/String;)V", "getAppUserId", "()Ljava/lang/String;", "getClient", "()Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "getSessionToken", "getUserId", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoginRequestBody.kt */
public final class LoginRequestBody {
    private final String appUserId;
    private final ClientDto client;
    private final String sessionToken;
    private final String userId;

    public LoginRequestBody(@Json(name = "userId") String str, @Json(name = "client") ClientDto clientDto, @Json(name = "appUserId") String str2, @Json(name = "sessionToken") String str3) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(clientDto, "client");
        this.userId = str;
        this.client = clientDto;
        this.appUserId = str2;
        this.sessionToken = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoginRequestBody(String str, ClientDto clientDto, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, clientDto, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final ClientDto getClient() {
        return this.client;
    }

    public final String getAppUserId() {
        return this.appUserId;
    }

    public final String getSessionToken() {
        return this.sessionToken;
    }
}
