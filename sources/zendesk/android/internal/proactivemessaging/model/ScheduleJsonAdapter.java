package zendesk.android.internal.proactivemessaging.model;

import com.facebook.appevents.AppEventsConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lzendesk/android/internal/proactivemessaging/model/ScheduleJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/internal/proactivemessaging/model/Schedule;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "frequencyAdapter", "Lzendesk/android/internal/proactivemessaging/model/Frequency;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScheduleJsonAdapter.kt */
public final class ScheduleJsonAdapter extends JsonAdapter<Schedule> {
    private final JsonAdapter<Frequency> frequencyAdapter;
    private final JsonReader.Options options;

    public ScheduleJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("frequency");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"frequency\")");
        this.options = of;
        JsonAdapter<Frequency> adapter = moshi.adapter(Frequency.class, SetsKt.emptySet(), "frequency");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Frequency:… emptySet(), \"frequency\")");
        this.frequencyAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(30);
        sb.append("GeneratedJsonAdapter(").append(AppEventsConstants.EVENT_NAME_SCHEDULE).append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public Schedule fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Frequency frequency = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0 && (frequency = this.frequencyAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("frequency", "frequency", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"frequenc…     \"frequency\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (frequency != null) {
            return new Schedule(frequency);
        }
        JsonDataException missingProperty = Util.missingProperty("frequency", "frequency", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"frequency\", \"frequency\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, Schedule schedule) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (schedule != null) {
            jsonWriter.beginObject();
            jsonWriter.name("frequency");
            this.frequencyAdapter.toJson(jsonWriter, schedule.getFrequency());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
