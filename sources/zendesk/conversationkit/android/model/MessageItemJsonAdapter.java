package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lzendesk/conversationkit/android/model/MessageItemJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/MessageItem;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfMessageActionAdapter", "", "Lzendesk/conversationkit/android/model/MessageAction;", "messageItemSizeAdapter", "Lzendesk/conversationkit/android/model/MessageItemSize;", "nullableMapOfStringAnyAdapter", "", "", "", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageItemJsonAdapter.kt */
public final class MessageItemJsonAdapter extends JsonAdapter<MessageItem> {
    private final JsonAdapter<List<MessageAction>> listOfMessageActionAdapter;
    private final JsonAdapter<MessageItemSize> messageItemSizeAdapter;
    private final JsonAdapter<Map<String, Object>> nullableMapOfStringAnyAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MessageItemJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("title", "description", "actions", "size", TtmlNode.TAG_METADATA, "mediaUrl", "mediaType");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"title\", \"description… \"mediaUrl\", \"mediaType\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "title");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…mptySet(),\n      \"title\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "description");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…mptySet(), \"description\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<List<MessageAction>> adapter3 = moshi.adapter(Types.newParameterizedType(List.class, MessageAction.class), SetsKt.emptySet(), "actions");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…   emptySet(), \"actions\")");
        this.listOfMessageActionAdapter = adapter3;
        JsonAdapter<MessageItemSize> adapter4 = moshi.adapter(MessageItemSize.class, SetsKt.emptySet(), "size");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(MessageIte…java, emptySet(), \"size\")");
        this.messageItemSizeAdapter = adapter4;
        JsonAdapter<Map<String, Object>> adapter5 = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Types.newP…, emptySet(), \"metadata\")");
        this.nullableMapOfStringAnyAdapter = adapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(33);
        sb.append("GeneratedJsonAdapter(").append("MessageItem").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public MessageItem fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        List list = null;
        MessageItemSize messageItemSize = null;
        Map map = null;
        String str3 = null;
        String str4 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = this.stringAdapter.fromJson(jsonReader);
                    if (str != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("title", "title", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"title\", …tle\",\n            reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 2:
                    list = this.listOfMessageActionAdapter.fromJson(jsonReader);
                    if (list != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("actions", "actions", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"actions\", \"actions\", reader)");
                        throw unexpectedNull2;
                    }
                case 3:
                    messageItemSize = this.messageItemSizeAdapter.fromJson(jsonReader);
                    if (messageItemSize != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("size", "size", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"size\",\n            \"size\", reader)");
                        throw unexpectedNull3;
                    }
                case 4:
                    map = this.nullableMapOfStringAnyAdapter.fromJson(jsonReader);
                    break;
                case 5:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 6:
                    str4 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("title", "title", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"title\", \"title\", reader)");
            throw missingProperty;
        } else if (list == null) {
            JsonDataException missingProperty2 = Util.missingProperty("actions", "actions", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"actions\", \"actions\", reader)");
            throw missingProperty2;
        } else if (messageItemSize != null) {
            return new MessageItem(str, str2, list, messageItemSize, map, str3, str4);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("size", "size", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"size\", \"size\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, MessageItem messageItem) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (messageItem != null) {
            jsonWriter.beginObject();
            jsonWriter.name("title");
            this.stringAdapter.toJson(jsonWriter, messageItem.getTitle());
            jsonWriter.name("description");
            this.nullableStringAdapter.toJson(jsonWriter, messageItem.getDescription());
            jsonWriter.name("actions");
            this.listOfMessageActionAdapter.toJson(jsonWriter, messageItem.getActions());
            jsonWriter.name("size");
            this.messageItemSizeAdapter.toJson(jsonWriter, messageItem.getSize());
            jsonWriter.name(TtmlNode.TAG_METADATA);
            this.nullableMapOfStringAnyAdapter.toJson(jsonWriter, messageItem.getMetadata());
            jsonWriter.name("mediaUrl");
            this.nullableStringAdapter.toJson(jsonWriter, messageItem.getMediaUrl());
            jsonWriter.name("mediaType");
            this.nullableStringAdapter.toJson(jsonWriter, messageItem.getMediaType());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
