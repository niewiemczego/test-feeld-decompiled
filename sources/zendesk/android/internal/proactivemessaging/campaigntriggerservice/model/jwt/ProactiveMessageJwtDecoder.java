package zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.jwt;

import com.squareup.moshi.Moshi;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okio.ByteString;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageJwtDecoder;", "", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "decode", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageResponse;", "jwt", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveMessageJwtDecoder.kt */
public final class ProactiveMessageJwtDecoder {
    private final Moshi moshi;

    @Inject
    public ProactiveMessageJwtDecoder(Moshi moshi2) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.moshi = moshi2;
    }

    public final ProactiveMessageResponse decode(String str) {
        Intrinsics.checkNotNullParameter(str, "jwt");
        ByteString decodeBase64 = ByteString.Companion.decodeBase64((String) StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null).get(1));
        String string = decodeBase64 != null ? decodeBase64.string(Charsets.UTF_8) : null;
        if (string == null) {
            string = "";
        }
        return this.moshi.adapter(ProactiveMessageResponse.class).fromJson(string);
    }
}
