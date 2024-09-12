package zendesk.conversationkit.android.internal.user;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okio.ByteString;
import zendesk.conversationkit.android.ConversationKitResult;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0001\t¨\u0006\n"}, d2 = {"Lzendesk/conversationkit/android/internal/user/Jwt;", "", "()V", "externalId", "", "getExternalId", "()Ljava/lang/String;", "Decoder", "Unified", "Lzendesk/conversationkit/android/internal/user/Jwt$Unified;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Jwt.kt */
public abstract class Jwt {
    public /* synthetic */ Jwt(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getExternalId();

    private Jwt() {
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lzendesk/conversationkit/android/internal/user/Jwt$Unified;", "Lzendesk/conversationkit/android/internal/user/Jwt;", "externalId", "", "(Ljava/lang/String;)V", "getExternalId", "()Ljava/lang/String;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Jwt.kt */
    public static final class Unified extends Jwt {
        private final String externalId;

        public String getExternalId() {
            return this.externalId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Unified(@Json(name = "external_id") String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "externalId");
            this.externalId = str;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lzendesk/conversationkit/android/internal/user/Jwt$Decoder;", "", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "decode", "Lzendesk/conversationkit/android/ConversationKitResult;", "Lzendesk/conversationkit/android/internal/user/Jwt;", "jwt", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Jwt.kt */
    public static final class Decoder {
        private final Moshi moshi;

        public Decoder() {
            this((Moshi) null, 1, (DefaultConstructorMarker) null);
        }

        public Decoder(Moshi moshi2) {
            Intrinsics.checkNotNullParameter(moshi2, "moshi");
            this.moshi = moshi2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Decoder(com.squareup.moshi.Moshi r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
            /*
                r0 = this;
                r2 = r2 & 1
                if (r2 == 0) goto L_0x0012
                com.squareup.moshi.Moshi$Builder r1 = new com.squareup.moshi.Moshi$Builder
                r1.<init>()
                com.squareup.moshi.Moshi r1 = r1.build()
                java.lang.String r2 = "Builder().build()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            L_0x0012:
                r0.<init>(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.user.Jwt.Decoder.<init>(com.squareup.moshi.Moshi, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final ConversationKitResult<Jwt> decode(String str) {
            Intrinsics.checkNotNullParameter(str, "jwt");
            try {
                ByteString decodeBase64 = ByteString.Companion.decodeBase64((String) StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null).get(1));
                String string = decodeBase64 != null ? decodeBase64.string(Charsets.UTF_8) : null;
                if (string == null) {
                    string = "";
                }
                Unified fromJson = this.moshi.adapter(Unified.class).fromJson(string);
                Intrinsics.checkNotNull(fromJson);
                return new ConversationKitResult.Success<>(fromJson);
            } catch (Exception e) {
                return new ConversationKitResult.Failure(e);
            }
        }
    }
}
