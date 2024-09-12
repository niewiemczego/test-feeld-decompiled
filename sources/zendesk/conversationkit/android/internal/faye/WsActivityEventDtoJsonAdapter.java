package zendesk.conversationkit.android.internal.faye;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/internal/faye/WsActivityEventDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/faye/WsActivityEventDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "wsActivityEventDataDtoAdapter", "Lzendesk/conversationkit/android/internal/faye/WsActivityEventDataDto;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WsActivityEventDtoJsonAdapter.kt */
public final class WsActivityEventDtoJsonAdapter extends JsonAdapter<WsActivityEventDto> {
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<WsActivityEventDataDto> wsActivityEventDataDtoAdapter;

    public WsActivityEventDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("role", "type", "appUserId", "data");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"role\", \"type\", \"appUserId\",\n      \"data\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "role");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"role\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "appUserId");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl… emptySet(), \"appUserId\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<WsActivityEventDataDto> adapter3 = moshi.adapter(WsActivityEventDataDto.class, SetsKt.emptySet(), "data");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(WsActivity…java, emptySet(), \"data\")");
        this.wsActivityEventDataDtoAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("GeneratedJsonAdapter(").append("WsActivityEventDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public WsActivityEventDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        WsActivityEventDataDto wsActivityEventDataDto = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("role", "role", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"role\", \"role\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("type", "type", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"type\", \"type\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str3 = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 3 && (wsActivityEventDataDto = this.wsActivityEventDataDtoAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("data_", "data", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"data_\", \"data\", reader)");
                throw unexpectedNull3;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("role", "role", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"role\", \"role\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("type", "type", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"type\", \"type\", reader)");
            throw missingProperty2;
        } else if (wsActivityEventDataDto != null) {
            return new WsActivityEventDto(str, str2, str3, wsActivityEventDataDto);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("data_", "data", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"data_\", \"data\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, WsActivityEventDto wsActivityEventDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (wsActivityEventDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("role");
            this.stringAdapter.toJson(jsonWriter, wsActivityEventDto.getRole());
            jsonWriter.name("type");
            this.stringAdapter.toJson(jsonWriter, wsActivityEventDto.getType());
            jsonWriter.name("appUserId");
            this.nullableStringAdapter.toJson(jsonWriter, wsActivityEventDto.getAppUserId());
            jsonWriter.name("data");
            this.wsActivityEventDataDtoAdapter.toJson(jsonWriter, wsActivityEventDto.getData());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
