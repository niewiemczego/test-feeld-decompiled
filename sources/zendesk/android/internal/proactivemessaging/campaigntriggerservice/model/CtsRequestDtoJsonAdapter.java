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

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/CtsRequestDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/CtsRequestDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfCampaignPathDtoAdapter", "", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/CampaignPathDto;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CtsRequestDtoJsonAdapter.kt */
public final class CtsRequestDtoJsonAdapter extends JsonAdapter<CtsRequestDto> {
    private final JsonAdapter<List<CampaignPathDto>> listOfCampaignPathDtoAdapter;
    private final JsonReader.Options options;

    public CtsRequestDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("campaign_paths");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"campaign_paths\")");
        this.options = of;
        JsonAdapter<List<CampaignPathDto>> adapter = moshi.adapter(Types.newParameterizedType(List.class, CampaignPathDto.class), SetsKt.emptySet(), "campaignPaths");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…tySet(), \"campaignPaths\")");
        this.listOfCampaignPathDtoAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(35);
        sb.append("GeneratedJsonAdapter(").append("CtsRequestDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public CtsRequestDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        List list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0 && (list = this.listOfCampaignPathDtoAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("campaignPaths", "campaign_paths", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"campaign…\"campaign_paths\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (list != null) {
            return new CtsRequestDto(list);
        }
        JsonDataException missingProperty = Util.missingProperty("campaignPaths", "campaign_paths", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"campaig…\"campaign_paths\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, CtsRequestDto ctsRequestDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (ctsRequestDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("campaign_paths");
            this.listOfCampaignPathDtoAdapter.toJson(jsonWriter, ctsRequestDto.getCampaignPaths());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
