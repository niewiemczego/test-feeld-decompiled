package zendesk.messaging.android.internal.conversationscreen.cache;

import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.storage.android.Serializer;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J+\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016¢\u0006\u0002\u0010\u000bJ)\u0010\f\u001a\u00020\b\"\u0004\b\u0000\u0010\u00062\u0006\u0010\r\u001a\u0002H\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/cache/MessagingStorageSerializer;", "Lzendesk/storage/android/Serializer;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "deserialize", "T", "source", "", "type", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "serialize", "data", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/String;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessagingStorage.kt */
public final class MessagingStorageSerializer implements Serializer {
    private final Moshi moshi;

    public MessagingStorageSerializer() {
        this((Moshi) null, 1, (DefaultConstructorMarker) null);
    }

    public MessagingStorageSerializer(Moshi moshi2) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.moshi = moshi2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MessagingStorageSerializer(com.squareup.moshi.Moshi r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x0012
            com.squareup.moshi.Moshi$Builder r1 = new com.squareup.moshi.Moshi$Builder
            r1.<init>()
            com.squareup.moshi.Moshi r1 = r1.build()
            java.lang.String r2 = "Builder()\n        .build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x0012:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.cache.MessagingStorageSerializer.<init>(com.squareup.moshi.Moshi, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public <T> T deserialize(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "source");
        Intrinsics.checkNotNullParameter(cls, "type");
        try {
            return this.moshi.adapter(cls).fromJson(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public <T> String serialize(T t, Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "type");
        String json = this.moshi.adapter(cls).toJson(t);
        Intrinsics.checkNotNullExpressionValue(json, "moshi.adapter(type).toJson(data)");
        return json;
    }
}
