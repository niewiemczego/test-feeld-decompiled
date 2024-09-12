package zendesk.conversationkit.android.internal;

import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.storage.android.Serializer;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J+\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016¢\u0006\u0002\u0010\u000bJ)\u0010\f\u001a\u00020\b\"\u0004\b\u0000\u0010\u00062\u0006\u0010\r\u001a\u0002H\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lzendesk/conversationkit/android/internal/DefaultSerializer;", "Lzendesk/storage/android/Serializer;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "deserialize", "T", "source", "", "type", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "serialize", "data", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/String;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StorageFactory.kt */
public final class DefaultSerializer implements Serializer {
    private final Moshi moshi;

    public DefaultSerializer() {
        this((Moshi) null, 1, (DefaultConstructorMarker) null);
    }

    public DefaultSerializer(Moshi moshi2) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.moshi = moshi2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DefaultSerializer(com.squareup.moshi.Moshi r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r2 = this;
            r4 = r4 & 1
            if (r4 == 0) goto L_0x0129
            com.squareup.moshi.Moshi$Builder r3 = new com.squareup.moshi.Moshi$Builder
            r3.<init>()
            java.lang.Class<zendesk.conversationkit.android.model.MessageContent> r4 = zendesk.conversationkit.android.model.MessageContent.class
            java.lang.String r5 = "type"
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory.of(r4, r5)
            java.lang.Class<zendesk.conversationkit.android.model.MessageContent$Unsupported> r0 = zendesk.conversationkit.android.model.MessageContent.Unsupported.class
            zendesk.conversationkit.android.model.MessageType r1 = zendesk.conversationkit.android.model.MessageType.UNSUPPORTED
            java.lang.String r1 = r1.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r0, r1)
            java.lang.Class<zendesk.conversationkit.android.model.MessageContent$Text> r0 = zendesk.conversationkit.android.model.MessageContent.Text.class
            zendesk.conversationkit.android.model.MessageType r1 = zendesk.conversationkit.android.model.MessageType.TEXT
            java.lang.String r1 = r1.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r0, r1)
            java.lang.Class<zendesk.conversationkit.android.model.MessageContent$Form> r0 = zendesk.conversationkit.android.model.MessageContent.Form.class
            zendesk.conversationkit.android.model.MessageType r1 = zendesk.conversationkit.android.model.MessageType.FORM
            java.lang.String r1 = r1.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r0, r1)
            java.lang.Class<zendesk.conversationkit.android.model.MessageContent$FormResponse> r0 = zendesk.conversationkit.android.model.MessageContent.FormResponse.class
            zendesk.conversationkit.android.model.MessageType r1 = zendesk.conversationkit.android.model.MessageType.FORM_RESPONSE
            java.lang.String r1 = r1.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r0, r1)
            java.lang.Class<zendesk.conversationkit.android.model.MessageContent$Carousel> r0 = zendesk.conversationkit.android.model.MessageContent.Carousel.class
            zendesk.conversationkit.android.model.MessageType r1 = zendesk.conversationkit.android.model.MessageType.CAROUSEL
            java.lang.String r1 = r1.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r0, r1)
            java.lang.Class<zendesk.conversationkit.android.model.MessageContent$File> r0 = zendesk.conversationkit.android.model.MessageContent.File.class
            zendesk.conversationkit.android.model.MessageType r1 = zendesk.conversationkit.android.model.MessageType.FILE
            java.lang.String r1 = r1.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r0, r1)
            java.lang.Class<zendesk.conversationkit.android.model.MessageContent$FileUpload> r0 = zendesk.conversationkit.android.model.MessageContent.FileUpload.class
            zendesk.conversationkit.android.model.MessageType r1 = zendesk.conversationkit.android.model.MessageType.FILE_UPLOAD
            java.lang.String r1 = r1.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r0, r1)
            java.lang.Class<zendesk.conversationkit.android.model.MessageContent$Image> r0 = zendesk.conversationkit.android.model.MessageContent.Image.class
            zendesk.conversationkit.android.model.MessageType r1 = zendesk.conversationkit.android.model.MessageType.IMAGE
            java.lang.String r1 = r1.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r0, r1)
            com.squareup.moshi.JsonAdapter$Factory r4 = (com.squareup.moshi.JsonAdapter.Factory) r4
            com.squareup.moshi.Moshi$Builder r3 = r3.add((com.squareup.moshi.JsonAdapter.Factory) r4)
            java.lang.Class<zendesk.conversationkit.android.model.Field> r4 = zendesk.conversationkit.android.model.Field.class
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory.of(r4, r5)
            java.lang.Class<zendesk.conversationkit.android.model.Field$Text> r0 = zendesk.conversationkit.android.model.Field.Text.class
            zendesk.conversationkit.android.model.FieldType r1 = zendesk.conversationkit.android.model.FieldType.TEXT
            java.lang.String r1 = r1.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r0, r1)
            java.lang.Class<zendesk.conversationkit.android.model.Field$Email> r0 = zendesk.conversationkit.android.model.Field.Email.class
            zendesk.conversationkit.android.model.FieldType r1 = zendesk.conversationkit.android.model.FieldType.EMAIL
            java.lang.String r1 = r1.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r0, r1)
            java.lang.Class<zendesk.conversationkit.android.model.Field$Select> r0 = zendesk.conversationkit.android.model.Field.Select.class
            zendesk.conversationkit.android.model.FieldType r1 = zendesk.conversationkit.android.model.FieldType.SELECT
            java.lang.String r1 = r1.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r0, r1)
            com.squareup.moshi.JsonAdapter$Factory r4 = (com.squareup.moshi.JsonAdapter.Factory) r4
            com.squareup.moshi.Moshi$Builder r3 = r3.add((com.squareup.moshi.JsonAdapter.Factory) r4)
            java.lang.Class<zendesk.conversationkit.android.model.MessageAction> r4 = zendesk.conversationkit.android.model.MessageAction.class
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory.of(r4, r5)
            java.lang.Class<zendesk.conversationkit.android.model.MessageAction$Buy> r5 = zendesk.conversationkit.android.model.MessageAction.Buy.class
            zendesk.conversationkit.android.model.MessageActionType r0 = zendesk.conversationkit.android.model.MessageActionType.BUY
            java.lang.String r0 = r0.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r5, r0)
            java.lang.Class<zendesk.conversationkit.android.model.MessageAction$Link> r5 = zendesk.conversationkit.android.model.MessageAction.Link.class
            zendesk.conversationkit.android.model.MessageActionType r0 = zendesk.conversationkit.android.model.MessageActionType.LINK
            java.lang.String r0 = r0.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r5, r0)
            java.lang.Class<zendesk.conversationkit.android.model.MessageAction$LocationRequest> r5 = zendesk.conversationkit.android.model.MessageAction.LocationRequest.class
            zendesk.conversationkit.android.model.MessageActionType r0 = zendesk.conversationkit.android.model.MessageActionType.LOCATION_REQUEST
            java.lang.String r0 = r0.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r5, r0)
            java.lang.Class<zendesk.conversationkit.android.model.MessageAction$Postback> r5 = zendesk.conversationkit.android.model.MessageAction.Postback.class
            zendesk.conversationkit.android.model.MessageActionType r0 = zendesk.conversationkit.android.model.MessageActionType.POSTBACK
            java.lang.String r0 = r0.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r5, r0)
            java.lang.Class<zendesk.conversationkit.android.model.MessageAction$Reply> r5 = zendesk.conversationkit.android.model.MessageAction.Reply.class
            zendesk.conversationkit.android.model.MessageActionType r0 = zendesk.conversationkit.android.model.MessageActionType.REPLY
            java.lang.String r0 = r0.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r5, r0)
            java.lang.Class<zendesk.conversationkit.android.model.MessageAction$Share> r5 = zendesk.conversationkit.android.model.MessageAction.Share.class
            zendesk.conversationkit.android.model.MessageActionType r0 = zendesk.conversationkit.android.model.MessageActionType.SHARE
            java.lang.String r0 = r0.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r5, r0)
            java.lang.Class<zendesk.conversationkit.android.model.MessageAction$WebView> r5 = zendesk.conversationkit.android.model.MessageAction.WebView.class
            zendesk.conversationkit.android.model.MessageActionType r0 = zendesk.conversationkit.android.model.MessageActionType.WEBVIEW
            java.lang.String r0 = r0.name()
            com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory r4 = r4.withSubtype(r5, r0)
            com.squareup.moshi.JsonAdapter$Factory r4 = (com.squareup.moshi.JsonAdapter.Factory) r4
            com.squareup.moshi.Moshi$Builder r3 = r3.add((com.squareup.moshi.JsonAdapter.Factory) r4)
            java.lang.Class<java.util.Date> r4 = java.util.Date.class
            java.lang.reflect.Type r4 = (java.lang.reflect.Type) r4
            com.squareup.moshi.adapters.Rfc3339DateJsonAdapter r5 = new com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
            r5.<init>()
            com.squareup.moshi.JsonAdapter r5 = (com.squareup.moshi.JsonAdapter) r5
            com.squareup.moshi.Moshi$Builder r3 = r3.add(r4, r5)
            zendesk.conversationkit.android.model.LocalDateTimeAdapter r4 = new zendesk.conversationkit.android.model.LocalDateTimeAdapter
            r4.<init>()
            com.squareup.moshi.Moshi$Builder r3 = r3.add((java.lang.Object) r4)
            com.squareup.moshi.Moshi r3 = r3.build()
            java.lang.String r4 = "Builder()\n        .add(\n…apter())\n        .build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
        L_0x0129:
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.DefaultSerializer.<init>(com.squareup.moshi.Moshi, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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
