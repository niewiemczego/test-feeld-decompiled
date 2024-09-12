package zendesk.conversationkit.android.internal.faye;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/internal/faye/WsActivityEventDataDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/faye/WsActivityEventDataDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableDoubleAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WsActivityEventDataDtoJsonAdapter.kt */
public final class WsActivityEventDataDtoJsonAdapter extends JsonAdapter<WsActivityEventDataDto> {
    private final JsonAdapter<Double> nullableDoubleAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public WsActivityEventDataDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("name", "avatarUrl", "lastRead");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"name\", \"avatarUrl\", \"lastRead\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "name");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…      emptySet(), \"name\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Double> adapter2 = moshi.adapter(Double.class, SetsKt.emptySet(), "lastRead");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Double::cl…, emptySet(), \"lastRead\")");
        this.nullableDoubleAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(44);
        sb.append("GeneratedJsonAdapter(").append("WsActivityEventDataDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public WsActivityEventDataDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        Double d = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 1) {
                str2 = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 2) {
                d = this.nullableDoubleAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        return new WsActivityEventDataDto(str, str2, d);
    }

    public void toJson(JsonWriter jsonWriter, WsActivityEventDataDto wsActivityEventDataDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (wsActivityEventDataDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("name");
            this.nullableStringAdapter.toJson(jsonWriter, wsActivityEventDataDto.getName());
            jsonWriter.name("avatarUrl");
            this.nullableStringAdapter.toJson(jsonWriter, wsActivityEventDataDto.getAvatarUrl());
            jsonWriter.name("lastRead");
            this.nullableDoubleAdapter.toJson(jsonWriter, wsActivityEventDataDto.getLastRead());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
