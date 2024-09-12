package zendesk.conversationkit.android.internal.rest.user.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.ClientDto;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/user/model/LogoutRequestBody;", "", "client", "Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "(Lzendesk/conversationkit/android/internal/rest/model/ClientDto;)V", "getClient", "()Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LogoutRequestBody.kt */
public final class LogoutRequestBody {
    private final ClientDto client;

    public LogoutRequestBody(@Json(name = "client") ClientDto clientDto) {
        Intrinsics.checkNotNullParameter(clientDto, "client");
        this.client = clientDto;
    }

    public final ClientDto getClient() {
        return this.client;
    }
}
