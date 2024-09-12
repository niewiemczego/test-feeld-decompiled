package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.MessageContent;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/model/MessageContent_FileJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/model/MessageContent$File;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "longAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageContent_FileJsonAdapter.kt */
public final class MessageContent_FileJsonAdapter extends JsonAdapter<MessageContent.File> {
    private final JsonAdapter<Long> longAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MessageContent_FileJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("text", "altText", "mediaUrl", "mediaType", "mediaSize");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"text\", \"altText\", \"m…\"mediaType\", \"mediaSize\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "text");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"text\")");
        this.stringAdapter = adapter;
        JsonAdapter<Long> adapter2 = moshi.adapter(Long.TYPE, SetsKt.emptySet(), "mediaSize");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Long::clas…Set(),\n      \"mediaSize\")");
        this.longAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(41);
        sb.append("GeneratedJsonAdapter(").append("MessageContent.File").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public MessageContent.File fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Long l = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("text", "text", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"text\", \"text\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("altText", "altText", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"altText\"…       \"altText\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str3 = this.stringAdapter.fromJson(jsonReader);
                if (str3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("mediaUrl", "mediaUrl", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"mediaUrl…      \"mediaUrl\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                str4 = this.stringAdapter.fromJson(jsonReader);
                if (str4 == null) {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("mediaType", "mediaType", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"mediaTyp…     \"mediaType\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4 && (l = this.longAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull5 = Util.unexpectedNull("mediaSize", "mediaSize", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"mediaSiz…     \"mediaSize\", reader)");
                throw unexpectedNull5;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("text", "text", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"text\", \"text\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("altText", "altText", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"altText\", \"altText\", reader)");
            throw missingProperty2;
        } else if (str3 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("mediaUrl", "mediaUrl", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"mediaUrl\", \"mediaUrl\", reader)");
            throw missingProperty3;
        } else if (str4 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("mediaType", "mediaType", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"mediaType\", \"mediaType\", reader)");
            throw missingProperty4;
        } else if (l != null) {
            return new MessageContent.File(str, str2, str3, str4, l.longValue());
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("mediaSize", "mediaSize", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"mediaSize\", \"mediaSize\", reader)");
            throw missingProperty5;
        }
    }

    public void toJson(JsonWriter jsonWriter, MessageContent.File file) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (file != null) {
            jsonWriter.beginObject();
            jsonWriter.name("text");
            this.stringAdapter.toJson(jsonWriter, file.getText());
            jsonWriter.name("altText");
            this.stringAdapter.toJson(jsonWriter, file.getAltText());
            jsonWriter.name("mediaUrl");
            this.stringAdapter.toJson(jsonWriter, file.getMediaUrl());
            jsonWriter.name("mediaType");
            this.stringAdapter.toJson(jsonWriter, file.getMediaType());
            jsonWriter.name("mediaSize");
            this.longAdapter.toJson(jsonWriter, Long.valueOf(file.getMediaSize()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
