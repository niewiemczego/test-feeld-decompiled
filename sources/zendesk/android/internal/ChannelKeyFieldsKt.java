package zendesk.android.internal;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"getBaseUrl", "", "Lzendesk/android/internal/ChannelKeyFields;", "zendesk_zendesk-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelKeyFields.kt */
public final class ChannelKeyFieldsKt {
    public static final String getBaseUrl(ChannelKeyFields channelKeyFields) {
        Intrinsics.checkNotNullParameter(channelKeyFields, "<this>");
        Uri parse = Uri.parse(channelKeyFields.getSettingsUrl());
        String uri = new Uri.Builder().scheme(parse.getScheme()).encodedAuthority(parse.getEncodedAuthority()).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uri.toString()");
        return uri;
    }
}
