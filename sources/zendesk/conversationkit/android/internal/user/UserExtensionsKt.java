package zendesk.conversationkit.android.internal.user;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Credentials;
import zendesk.conversationkit.android.model.AuthenticationType;
import zendesk.conversationkit.android.model.User;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"authorization", "", "Lzendesk/conversationkit/android/model/User;", "getAuthorization", "(Lzendesk/conversationkit/android/model/User;)Ljava/lang/String;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserExtensions.kt */
public final class UserExtensionsKt {
    public static final String getAuthorization(User user) {
        Intrinsics.checkNotNullParameter(user, "<this>");
        AuthenticationType authenticationType = user.getAuthenticationType();
        if (authenticationType instanceof AuthenticationType.Jwt) {
            return "Bearer " + ((AuthenticationType.Jwt) authenticationType).getValue();
        }
        return authenticationType instanceof AuthenticationType.SessionToken ? Credentials.basic$default(user.getId(), ((AuthenticationType.SessionToken) authenticationType).getValue(), (Charset) null, 4, (Object) null) : "";
    }
}
