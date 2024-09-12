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

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lzendesk/conversationkit/android/model/MessageContent_FormJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/MessageContent$Form;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "listOfFieldAdapter", "", "Lzendesk/conversationkit/android/model/Field;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageContent_FormJsonAdapter.kt */
public final class MessageContent_FormJsonAdapter extends JsonAdapter<MessageContent.Form> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<List<Field>> listOfFieldAdapter;
    private final JsonReader.Options options;

    public MessageContent_FormJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(GraphRequest.FIELDS_PARAM, "blockChatInput");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"fields\", \"blockChatInput\")");
        this.options = of;
        JsonAdapter<List<Field>> adapter = moshi.adapter(Types.newParameterizedType(List.class, Field.class), SetsKt.emptySet(), GraphRequest.FIELDS_PARAM);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…ptySet(),\n      \"fields\")");
        this.listOfFieldAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), "blockChatInput");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Boolean::c…,\n      \"blockChatInput\")");
        this.booleanAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(41);
        sb.append("GeneratedJsonAdapter(").append("MessageContent.Form").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public MessageContent.Form fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        List list = null;
        Boolean bool = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                list = this.listOfFieldAdapter.fromJson(jsonReader);
                if (list == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(GraphRequest.FIELDS_PARAM, GraphRequest.FIELDS_PARAM, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"fields\",…        \"fields\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (bool = this.booleanAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("blockChatInput", "blockChatInput", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"blockCha…\"blockChatInput\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (list == null) {
            JsonDataException missingProperty = Util.missingProperty(GraphRequest.FIELDS_PARAM, GraphRequest.FIELDS_PARAM, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"fields\", \"fields\", reader)");
            throw missingProperty;
        } else if (bool != null) {
            return new MessageContent.Form(list, bool.booleanValue());
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("blockChatInput", "blockChatInput", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"blockCh…\"blockChatInput\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, MessageContent.Form form) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (form != null) {
            jsonWriter.beginObject();
            jsonWriter.name(GraphRequest.FIELDS_PARAM);
            this.listOfFieldAdapter.toJson(jsonWriter, form.getFields());
            jsonWriter.name("blockChatInput");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(form.getBlockChatInput()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
