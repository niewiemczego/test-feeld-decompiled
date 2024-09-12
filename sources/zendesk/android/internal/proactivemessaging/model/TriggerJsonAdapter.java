package zendesk.android.internal.proactivemessaging.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lzendesk/android/internal/proactivemessaging/model/TriggerJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/internal/proactivemessaging/model/Trigger;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableIntAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "triggerTypeAdapter", "Lzendesk/android/internal/proactivemessaging/model/TriggerType;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TriggerJsonAdapter.kt */
public final class TriggerJsonAdapter extends JsonAdapter<Trigger> {
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<TriggerType> triggerTypeAdapter;

    public TriggerJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("type", "duration");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"type\", \"duration\")");
        this.options = of;
        JsonAdapter<TriggerType> adapter = moshi.adapter(TriggerType.class, SetsKt.emptySet(), "type");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(TriggerTyp…      emptySet(), \"type\")");
        this.triggerTypeAdapter = adapter;
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.class, SetsKt.emptySet(), "duration");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Int::class…  emptySet(), \"duration\")");
        this.nullableIntAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(29);
        sb.append("GeneratedJsonAdapter(").append("Trigger").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public Trigger fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        TriggerType triggerType = null;
        Integer num = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                triggerType = this.triggerTypeAdapter.fromJson(jsonReader);
                if (triggerType == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"type\", \"type\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                num = this.nullableIntAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        if (triggerType != null) {
            return new Trigger(triggerType, num);
        }
        JsonDataException missingProperty = Util.missingProperty("type", "type", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"type\", \"type\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, Trigger trigger) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (trigger != null) {
            jsonWriter.beginObject();
            jsonWriter.name("type");
            this.triggerTypeAdapter.toJson(jsonWriter, trigger.getType());
            jsonWriter.name("duration");
            this.nullableIntAdapter.toJson(jsonWriter, trigger.getDuration());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
