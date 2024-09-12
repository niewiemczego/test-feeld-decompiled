package zendesk.conversationkit.android.model;

import com.facebook.GraphRequest;
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
import zendesk.conversationkit.android.model.MessageContent;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/model/MessageContent_FormResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/MessageContent$FormResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfFieldAdapter", "", "Lzendesk/conversationkit/android/model/Field;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageContent_FormResponseJsonAdapter.kt */
public final class MessageContent_FormResponseJsonAdapter extends JsonAdapter<MessageContent.FormResponse> {
    private final JsonAdapter<List<Field>> listOfFieldAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MessageContent_FormResponseJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("quotedMessageId", GraphRequest.FIELDS_PARAM);
        Intrinsics.checkNotNullExpressionValue(of, "of(\"quotedMessageId\", \"fields\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "quotedMessageId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…\n      \"quotedMessageId\")");
        this.stringAdapter = adapter;
        JsonAdapter<List<Field>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, Field.class), SetsKt.emptySet(), GraphRequest.FIELDS_PARAM);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…ptySet(),\n      \"fields\")");
        this.listOfFieldAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(49);
        sb.append("GeneratedJsonAdapter(").append("MessageContent.FormResponse").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public MessageContent.FormResponse fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        List list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("quotedMessageId", "quotedMessageId", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"quotedMe…quotedMessageId\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (list = this.listOfFieldAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull(GraphRequest.FIELDS_PARAM, GraphRequest.FIELDS_PARAM, jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"fields\",…        \"fields\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("quotedMessageId", "quotedMessageId", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"quotedM…quotedMessageId\", reader)");
            throw missingProperty;
        } else if (list != null) {
            return new MessageContent.FormResponse(str, list);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty(GraphRequest.FIELDS_PARAM, GraphRequest.FIELDS_PARAM, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"fields\", \"fields\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, MessageContent.FormResponse formResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (formResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("quotedMessageId");
            this.stringAdapter.toJson(jsonWriter, formResponse.getQuotedMessageId());
            jsonWriter.name(GraphRequest.FIELDS_PARAM);
            this.listOfFieldAdapter.toJson(jsonWriter, formResponse.getFields());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
