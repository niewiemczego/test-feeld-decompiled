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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lzendesk/android/settings/internal/model/RestRetryPolicyDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/settings/internal/model/RestRetryPolicyDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "retryIntervalDtoAdapter", "Lzendesk/android/settings/internal/model/RetryIntervalDto;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RestRetryPolicyDtoJsonAdapter.kt */
public final class RestRetryPolicyDtoJsonAdapter extends JsonAdapter<RestRetryPolicyDto> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<RetryIntervalDto> retryIntervalDtoAdapter;

    public RestRetryPolicyDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("intervals", "backoffMultiplier", "maxRetries");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"intervals\", \"backoff…ier\",\n      \"maxRetries\")");
        this.options = of;
        JsonAdapter<RetryIntervalDto> adapter = moshi.adapter(RetryIntervalDto.class, SetsKt.emptySet(), "intervals");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(RetryInter… emptySet(), \"intervals\")");
        this.retryIntervalDtoAdapter = adapter;
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "backoffMultiplier");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Int::class…     \"backoffMultiplier\")");
        this.intAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("GeneratedJsonAdapter(").append("RestRetryPolicyDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public RestRetryPolicyDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        RetryIntervalDto retryIntervalDto = null;
        Integer num = null;
        Integer num2 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                retryIntervalDto = this.retryIntervalDtoAdapter.fromJson(jsonReader);
                if (retryIntervalDto == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("intervals", "intervals", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"intervals\", \"intervals\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                num = this.intAdapter.fromJson(jsonReader);
                if (num == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("backoffMultiplier", "backoffMultiplier", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"backoffM…ckoffMultiplier\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (num2 = this.intAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("maxRetries", "maxRetries", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"maxRetri…    \"maxRetries\", reader)");
                throw unexpectedNull3;
            }
        }
        jsonReader.endObject();
        if (retryIntervalDto == null) {
            JsonDataException missingProperty = Util.missingProperty("intervals", "intervals", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"intervals\", \"intervals\", reader)");
            throw missingProperty;
        } else if (num != null) {
            int intValue = num.intValue();
            if (num2 != null) {
                return new RestRetryPolicyDto(retryIntervalDto, intValue, num2.intValue());
            }
            JsonDataException missingProperty2 = Util.missingProperty("maxRetries", "maxRetries", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"maxRetr…s\", \"maxRetries\", reader)");
            throw missingProperty2;
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("backoffMultiplier", "backoffMultiplier", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"backoff…ckoffMultiplier\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, RestRetryPolicyDto restRetryPolicyDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (restRetryPolicyDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("intervals");
            this.retryIntervalDtoAdapter.toJson(jsonWriter, restRetryPolicyDto.getIntervals());
            jsonWriter.name("backoffMultiplier");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(restRetryPolicyDto.getBackoffMultiplier()));
            jsonWriter.name("maxRetries");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(restRetryPolicyDto.getMaxRetries()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
