package zendesk.android.settings.internal.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lzendesk/android/settings/internal/model/RetryIntervalDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/settings/internal/model/RetryIntervalDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RetryIntervalDtoJsonAdapter.kt */
public final class RetryIntervalDtoJsonAdapter extends JsonAdapter<RetryIntervalDto> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;

    public RetryIntervalDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("regular", "aggressive");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"regular\", \"aggressive\")");
        this.options = of;
        JsonAdapter<Integer> adapter = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "regular");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Int::class…a, emptySet(), \"regular\")");
        this.intAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(").append("RetryIntervalDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public RetryIntervalDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Integer num = null;
        Integer num2 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                num = this.intAdapter.fromJson(jsonReader);
                if (num == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("regular", "regular", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"regular\"…       \"regular\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (num2 = this.intAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("aggressive", "aggressive", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"aggressi…    \"aggressive\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (num != null) {
            int intValue = num.intValue();
            if (num2 != null) {
                return new RetryIntervalDto(intValue, num2.intValue());
            }
            JsonDataException missingProperty = Util.missingProperty("aggressive", "aggressive", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"aggress…e\", \"aggressive\", reader)");
            throw missingProperty;
        }
        JsonDataException missingProperty2 = Util.missingProperty("regular", "regular", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"regular\", \"regular\", reader)");
        throw missingProperty2;
    }

    public void toJson(JsonWriter jsonWriter, RetryIntervalDto retryIntervalDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (retryIntervalDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("regular");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(retryIntervalDto.getRegular()));
            jsonWriter.name("aggressive");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(retryIntervalDto.getAggressive()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
