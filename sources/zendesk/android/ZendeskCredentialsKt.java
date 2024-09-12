package zendesk.android;

import android.os.Build;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import zendesk.android.internal.ChannelKeyFields;
import zendesk.android.internal.ChannelKeyFieldsKt;
import zendesk.android.internal.ZendeskError;
import zendesk.android.internal.di.ZendeskComponentConfig;
import zendesk.conversationkit.android.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"getZendeskComponentConfig", "Lzendesk/android/internal/di/ZendeskComponentConfig;", "Lzendesk/android/ZendeskCredentials;", "toChannelKeyFields", "Lzendesk/android/internal/ChannelKeyFields;", "moshi", "Lcom/squareup/moshi/Moshi;", "zendesk_zendesk-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ZendeskCredentials.kt */
public final class ZendeskCredentialsKt {
    public static final ChannelKeyFields toChannelKeyFields(ZendeskCredentials zendeskCredentials, Moshi moshi) {
        String utf8;
        Intrinsics.checkNotNullParameter(zendeskCredentials, "<this>");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        try {
            ByteString decodeBase64 = ByteString.Companion.decodeBase64(zendeskCredentials.getChannelKey());
            if (decodeBase64 != null && (utf8 = decodeBase64.utf8()) != null) {
                return moshi.adapter(ChannelKeyFields.class).fromJson(utf8);
            }
            throw ZendeskError.InvalidChannelKey.INSTANCE;
        } catch (Throwable unused) {
            ChannelKeyFields channelKeyFields = null;
            return null;
        }
    }

    public static final ZendeskComponentConfig getZendeskComponentConfig(ZendeskCredentials zendeskCredentials) {
        Intrinsics.checkNotNullParameter(zendeskCredentials, "<this>");
        Moshi build = new Moshi.Builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "moshi");
        ChannelKeyFields channelKeyFields = toChannelKeyFields(zendeskCredentials, build);
        if (channelKeyFields != null) {
            String baseUrl = ChannelKeyFieldsKt.getBaseUrl(channelKeyFields);
            String str = Build.VERSION.RELEASE;
            if (str == null) {
                str = "";
            }
            return new ZendeskComponentConfig(zendeskCredentials, baseUrl, BuildConfig.VERSION_NAME, str);
        }
        throw ZendeskError.InvalidChannelKey.INSTANCE;
    }
}
