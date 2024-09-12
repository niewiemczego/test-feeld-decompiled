package zendesk.android.internal.proactivemessaging.campaigntriggerservice.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/CampaignPathDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/CampaignPathDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "listOfStringAdapter", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CampaignPathDtoJsonAdapter.kt */
public final class CampaignPathDtoJsonAdapter extends JsonAdapter<CampaignPathDto> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<List<String>> listOfStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public CampaignPathDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("pcm_id", "path_ids", "version");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"pcm_id\", \"path_ids\", \"version\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "campaignId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…et(),\n      \"campaignId\")");
        this.stringAdapter = adapter;
        JsonAdapter<List<String>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, String.class), SetsKt.emptySet(), "pathIds");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…tySet(),\n      \"pathIds\")");
        this.listOfStringAdapter = adapter2;
        JsonAdapter<Integer> adapter3 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "version");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Int::class…a, emptySet(), \"version\")");
        this.intAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(37);
        sb.append("GeneratedJsonAdapter(").append("CampaignPathDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public CampaignPathDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        List list = null;
        Integer num = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("campaignId", "pcm_id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"campaign…        \"pcm_id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                list = this.listOfStringAdapter.fromJson(jsonReader);
                if (list == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("pathIds", "path_ids", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"pathIds\"…      \"path_ids\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (num = this.intAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("version", "version", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"version\"…       \"version\", reader)");
                throw unexpectedNull3;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("campaignId", "pcm_id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"campaignId\", \"pcm_id\", reader)");
            throw missingProperty;
        } else if (list == null) {
            JsonDataException missingProperty2 = Util.missingProperty("pathIds", "path_ids", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"pathIds\", \"path_ids\", reader)");
            throw missingProperty2;
        } else if (num != null) {
            return new CampaignPathDto(str, list, num.intValue());
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("version", "version", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"version\", \"version\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, CampaignPathDto campaignPathDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (campaignPathDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("pcm_id");
            this.stringAdapter.toJson(jsonWriter, campaignPathDto.getCampaignId());
            jsonWriter.name("path_ids");
            this.listOfStringAdapter.toJson(jsonWriter, campaignPathDto.getPathIds());
            jsonWriter.name("version");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(campaignPathDto.getVersion()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
