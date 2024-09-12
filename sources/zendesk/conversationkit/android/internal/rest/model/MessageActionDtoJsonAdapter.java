package zendesk.conversationkit.android.internal.rest.model;

import com.facebook.hermes.intl.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
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

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/MessageActionDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/MessageActionDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableBooleanAdapter", "", "nullableLongAdapter", "", "nullableMapOfStringAnyAdapter", "", "", "", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageActionDtoJsonAdapter.kt */
public final class MessageActionDtoJsonAdapter extends JsonAdapter<MessageActionDto> {
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    private final JsonAdapter<Long> nullableLongAdapter;
    private final JsonAdapter<Map<String, Object>> nullableMapOfStringAnyAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public MessageActionDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("_id", "type", "text", "uri", Constants.COLLATION_DEFAULT, "iconUrl", "fallback", "payload", TtmlNode.TAG_METADATA, "amount", FirebaseAnalytics.Param.CURRENCY, "state");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"_id\", \"type\", \"text\"…nt\", \"currency\", \"state\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "text");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…      emptySet(), \"text\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.class, SetsKt.emptySet(), Constants.COLLATION_DEFAULT);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…e, emptySet(), \"default\")");
        this.nullableBooleanAdapter = adapter3;
        JsonAdapter<Map<String, Object>> adapter4 = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Object.class), SetsKt.emptySet(), TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Types.newP…, emptySet(), \"metadata\")");
        this.nullableMapOfStringAnyAdapter = adapter4;
        JsonAdapter<Long> adapter5 = moshi.adapter(Long.class, SetsKt.emptySet(), "amount");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Long::clas…    emptySet(), \"amount\")");
        this.nullableLongAdapter = adapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(").append("MessageActionDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public MessageActionDto fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Boolean bool = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Map map = null;
        Long l = null;
        String str8 = null;
        String str9 = null;
        while (true) {
            String str10 = str9;
            String str11 = str8;
            if (jsonReader.hasNext()) {
                switch (jsonReader2.selectName(this.options)) {
                    case -1:
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                    case 0:
                        str = this.stringAdapter.fromJson(jsonReader2);
                        if (str == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("id", "_id", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"_id\", reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        str2 = this.stringAdapter.fromJson(jsonReader2);
                        if (str2 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("type", "type", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"type\", \"type\",\n            reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 2:
                        str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                        break;
                    case 3:
                        str4 = this.nullableStringAdapter.fromJson(jsonReader2);
                        break;
                    case 4:
                        bool = this.nullableBooleanAdapter.fromJson(jsonReader2);
                        break;
                    case 5:
                        str5 = this.nullableStringAdapter.fromJson(jsonReader2);
                        break;
                    case 6:
                        str6 = this.nullableStringAdapter.fromJson(jsonReader2);
                        break;
                    case 7:
                        str7 = this.nullableStringAdapter.fromJson(jsonReader2);
                        break;
                    case 8:
                        map = this.nullableMapOfStringAnyAdapter.fromJson(jsonReader2);
                        break;
                    case 9:
                        l = this.nullableLongAdapter.fromJson(jsonReader2);
                        break;
                    case 10:
                        str8 = this.nullableStringAdapter.fromJson(jsonReader2);
                        str9 = str10;
                        continue;
                    case 11:
                        str9 = this.nullableStringAdapter.fromJson(jsonReader2);
                        break;
                }
                str9 = str10;
                str8 = str11;
            } else {
                jsonReader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("id", "_id", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"_id\", reader)");
                    throw missingProperty;
                } else if (str2 != null) {
                    return new MessageActionDto(str, str2, str3, str4, bool, str5, str6, str7, map, l, str11, str10);
                } else {
                    JsonDataException missingProperty2 = Util.missingProperty("type", "type", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"type\", \"type\", reader)");
                    throw missingProperty2;
                }
            }
        }
    }

    public void toJson(JsonWriter jsonWriter, MessageActionDto messageActionDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (messageActionDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("_id");
            this.stringAdapter.toJson(jsonWriter, messageActionDto.getId());
            jsonWriter.name("type");
            this.stringAdapter.toJson(jsonWriter, messageActionDto.getType());
            jsonWriter.name("text");
            this.nullableStringAdapter.toJson(jsonWriter, messageActionDto.getText());
            jsonWriter.name("uri");
            this.nullableStringAdapter.toJson(jsonWriter, messageActionDto.getUri());
            jsonWriter.name(Constants.COLLATION_DEFAULT);
            this.nullableBooleanAdapter.toJson(jsonWriter, messageActionDto.getDefault());
            jsonWriter.name("iconUrl");
            this.nullableStringAdapter.toJson(jsonWriter, messageActionDto.getIconUrl());
            jsonWriter.name("fallback");
            this.nullableStringAdapter.toJson(jsonWriter, messageActionDto.getFallback());
            jsonWriter.name("payload");
            this.nullableStringAdapter.toJson(jsonWriter, messageActionDto.getPayload());
            jsonWriter.name(TtmlNode.TAG_METADATA);
            this.nullableMapOfStringAnyAdapter.toJson(jsonWriter, messageActionDto.getMetadata());
            jsonWriter.name("amount");
            this.nullableLongAdapter.toJson(jsonWriter, messageActionDto.getAmount());
            jsonWriter.name(FirebaseAnalytics.Param.CURRENCY);
            this.nullableStringAdapter.toJson(jsonWriter, messageActionDto.getCurrency());
            jsonWriter.name("state");
            this.nullableStringAdapter.toJson(jsonWriter, messageActionDto.getState());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
