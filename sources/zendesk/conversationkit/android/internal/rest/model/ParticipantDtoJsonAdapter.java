package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ParticipantDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/ParticipantDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableDoubleAdapter", "", "nullableIntAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ParticipantDtoJsonAdapter.kt */
public final class ParticipantDtoJsonAdapter extends JsonAdapter<ParticipantDto> {
    private final JsonAdapter<Double> nullableDoubleAdapter;
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ParticipantDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("_id", "appUserId", "unreadCount", "lastRead");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"_id\", \"appUserId\", \"…Count\",\n      \"lastRead\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.class, SetsKt.emptySet(), "unreadCount");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Int::class…mptySet(), \"unreadCount\")");
        this.nullableIntAdapter = adapter2;
        JsonAdapter<Double> adapter3 = moshi.adapter(Double.class, SetsKt.emptySet(), "lastRead");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Double::cl…, emptySet(), \"lastRead\")");
        this.nullableDoubleAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(36);
        sb.append("GeneratedJsonAdapter(").append("ParticipantDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ParticipantDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        Integer num = null;
        Double d = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("id", "_id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"_id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("appUserId", "appUserId", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"appUserI…     \"appUserId\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                num = this.nullableIntAdapter.fromJson(jsonReader);
            } else if (selectName == 3) {
                d = this.nullableDoubleAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("id", "_id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"_id\", reader)");
            throw missingProperty;
        } else if (str2 != null) {
            return new ParticipantDto(str, str2, num, d);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("appUserId", "appUserId", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"appUserId\", \"appUserId\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, ParticipantDto participantDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (participantDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("_id");
            this.stringAdapter.toJson(jsonWriter, participantDto.getId());
            jsonWriter.name("appUserId");
            this.stringAdapter.toJson(jsonWriter, participantDto.getAppUserId());
            jsonWriter.name("unreadCount");
            this.nullableIntAdapter.toJson(jsonWriter, participantDto.getUnreadCount());
            jsonWriter.name("lastRead");
            this.nullableDoubleAdapter.toJson(jsonWriter, participantDto.getLastRead());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
