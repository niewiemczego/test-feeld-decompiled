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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/CoordinatesDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/CoordinatesDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "doubleAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoordinatesDtoJsonAdapter.kt */
public final class CoordinatesDtoJsonAdapter extends JsonAdapter<CoordinatesDto> {
    private final JsonAdapter<Double> doubleAdapter;
    private final JsonReader.Options options;

    public CoordinatesDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("lat", "long");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"lat\", \"long\")");
        this.options = of;
        JsonAdapter<Double> adapter = moshi.adapter(Double.TYPE, SetsKt.emptySet(), "lat");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Double::cl… emptySet(),\n      \"lat\")");
        this.doubleAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(36);
        sb.append("GeneratedJsonAdapter(").append("CoordinatesDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public CoordinatesDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Double d = null;
        Double d2 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                d = this.doubleAdapter.fromJson(jsonReader);
                if (d == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("lat", "lat", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"lat\", \"lat\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (d2 = this.doubleAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("long", "long", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"long\", \"long\",\n            reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (d != null) {
            double doubleValue = d.doubleValue();
            if (d2 != null) {
                return new CoordinatesDto(doubleValue, d2.doubleValue());
            }
            JsonDataException missingProperty = Util.missingProperty("long", "long", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"long\", \"long\", reader)");
            throw missingProperty;
        }
        JsonDataException missingProperty2 = Util.missingProperty("lat", "lat", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"lat\", \"lat\", reader)");
        throw missingProperty2;
    }

    public void toJson(JsonWriter jsonWriter, CoordinatesDto coordinatesDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (coordinatesDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("lat");
            this.doubleAdapter.toJson(jsonWriter, Double.valueOf(coordinatesDto.getLat()));
            jsonWriter.name("long");
            this.doubleAdapter.toJson(jsonWriter, Double.valueOf(coordinatesDto.getLong()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
