package zendesk.android.internal.proactivemessaging;

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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lzendesk/android/internal/proactivemessaging/SendOnceCampaignsStorageJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/internal/proactivemessaging/SendOnceCampaignsStorage;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfStringAdapter", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SendOnceCampaignsStorageJsonAdapter.kt */
public final class SendOnceCampaignsStorageJsonAdapter extends JsonAdapter<SendOnceCampaignsStorage> {
    private final JsonAdapter<List<String>> listOfStringAdapter;
    private final JsonReader.Options options;

    public SendOnceCampaignsStorageJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("campaignIds");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"campaignIds\")");
        this.options = of;
        JsonAdapter<List<String>> adapter = moshi.adapter(Types.newParameterizedType(List.class, String.class), SetsKt.emptySet(), "campaignIds");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…t(),\n      \"campaignIds\")");
        this.listOfStringAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(46);
        sb.append("GeneratedJsonAdapter(").append("SendOnceCampaignsStorage").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public SendOnceCampaignsStorage fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        List list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0 && (list = this.listOfStringAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("campaignIds", "campaignIds", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"campaign…\", \"campaignIds\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (list != null) {
            return new SendOnceCampaignsStorage(list);
        }
        JsonDataException missingProperty = Util.missingProperty("campaignIds", "campaignIds", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"campaig…Ids\",\n            reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, SendOnceCampaignsStorage sendOnceCampaignsStorage) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (sendOnceCampaignsStorage != null) {
            jsonWriter.beginObject();
            jsonWriter.name("campaignIds");
            this.listOfStringAdapter.toJson(jsonWriter, sendOnceCampaignsStorage.getCampaignIds());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
