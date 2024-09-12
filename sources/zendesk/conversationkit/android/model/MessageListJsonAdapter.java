package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lzendesk/conversationkit/android/model/MessageListJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/MessageList;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfMessageAdapter", "", "Lzendesk/conversationkit/android/model/Message;", "nullableBooleanAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageListJsonAdapter.kt */
public final class MessageListJsonAdapter extends JsonAdapter<MessageList> {
    private final JsonAdapter<List<Message>> listOfMessageAdapter;
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    private final JsonReader.Options options;

    public MessageListJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("messages", "hasPrevious", "hasNext");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"messages\", \"hasPrevious\",\n      \"hasNext\")");
        this.options = of;
        JsonAdapter<List<Message>> adapter = moshi.adapter(Types.newParameterizedType(List.class, Message.class), SetsKt.emptySet(), "messages");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…ySet(),\n      \"messages\")");
        this.listOfMessageAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.class, SetsKt.emptySet(), "hasPrevious");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Boolean::c…mptySet(), \"hasPrevious\")");
        this.nullableBooleanAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(33);
        sb.append("GeneratedJsonAdapter(").append("MessageList").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public MessageList fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        List list = null;
        Boolean bool = null;
        Boolean bool2 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                list = this.listOfMessageAdapter.fromJson(jsonReader);
                if (list == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("messages", "messages", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"messages\", \"messages\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                bool = this.nullableBooleanAdapter.fromJson(jsonReader);
            } else if (selectName == 2) {
                bool2 = this.nullableBooleanAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        if (list != null) {
            return new MessageList(list, bool, bool2);
        }
        JsonDataException missingProperty = Util.missingProperty("messages", "messages", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"messages\", \"messages\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, MessageList messageList) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (messageList != null) {
            jsonWriter.beginObject();
            jsonWriter.name("messages");
            this.listOfMessageAdapter.toJson(jsonWriter, messageList.getMessages());
            jsonWriter.name("hasPrevious");
            this.nullableBooleanAdapter.toJson(jsonWriter, messageList.getHasPrevious());
            jsonWriter.name("hasNext");
            this.nullableBooleanAdapter.toJson(jsonWriter, messageList.getHasNext());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
