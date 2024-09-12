package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.MessageAction;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016R\"\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/model/MessageAction_PostbackJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/MessageAction$Postback;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableMapOfStringAnyAdapter", "", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageAction_PostbackJsonAdapter.kt */
public final class MessageAction_PostbackJsonAdapter extends JsonAdapter<MessageAction.Postback> {
    private final JsonAdapter<Map<String, Object>> nullableMapOfStringAnyAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MessageAction_PostbackJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", TtmlNode.TAG_METADATA, "text", "payload");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"id\", \"metadata\", \"text\",\n      \"payload\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<Map<String, Object>> adapter2 = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…, emptySet(), \"metadata\")");
        this.nullableMapOfStringAnyAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(44);
        sb.append("GeneratedJsonAdapter(").append("MessageAction.Postback").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public MessageAction.Postback fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        Map map = null;
        String str2 = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                map = this.nullableMapOfStringAnyAdapter.fromJson(jsonReader);
            } else if (selectName == 2) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("text", "text", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"text\", \"text\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 3 && (str3 = this.stringAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("payload", "payload", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"payload\"…       \"payload\", reader)");
                throw unexpectedNull3;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("id", "id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("text", "text", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"text\", \"text\", reader)");
            throw missingProperty2;
        } else if (str3 != null) {
            return new MessageAction.Postback(str, map, str2, str3);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("payload", "payload", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"payload\", \"payload\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, MessageAction.Postback postback) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (postback != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, postback.getId());
            jsonWriter.name(TtmlNode.TAG_METADATA);
            this.nullableMapOfStringAnyAdapter.toJson(jsonWriter, postback.getMetadata());
            jsonWriter.name("text");
            this.stringAdapter.toJson(jsonWriter, postback.getText());
            jsonWriter.name("payload");
            this.stringAdapter.toJson(jsonWriter, postback.getPayload());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
