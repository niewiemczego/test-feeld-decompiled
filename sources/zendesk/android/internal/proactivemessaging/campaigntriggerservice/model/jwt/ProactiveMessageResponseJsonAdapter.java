package zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.jwt;

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

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfProactiveMessageAdapter", "", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessage;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "proactiveMessageCampaignAdapter", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageCampaign;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveMessageResponseJsonAdapter.kt */
public final class ProactiveMessageResponseJsonAdapter extends JsonAdapter<ProactiveMessageResponse> {
    private final JsonAdapter<List<ProactiveMessage>> listOfProactiveMessageAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<ProactiveMessageCampaign> proactiveMessageCampaignAdapter;

    public ProactiveMessageResponseJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("campaign", "messages");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"campaign\", \"messages\")");
        this.options = of;
        JsonAdapter<ProactiveMessageCampaign> adapter = moshi.adapter(ProactiveMessageCampaign.class, SetsKt.emptySet(), "campaign");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(ProactiveM…, emptySet(), \"campaign\")");
        this.proactiveMessageCampaignAdapter = adapter;
        JsonAdapter<List<ProactiveMessage>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, ProactiveMessage.class), SetsKt.emptySet(), "messages");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…  emptySet(), \"messages\")");
        this.listOfProactiveMessageAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(46);
        sb.append("GeneratedJsonAdapter(").append("ProactiveMessageResponse").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ProactiveMessageResponse fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        ProactiveMessageCampaign proactiveMessageCampaign = null;
        List list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                proactiveMessageCampaign = this.proactiveMessageCampaignAdapter.fromJson(jsonReader);
                if (proactiveMessageCampaign == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("campaign", "campaign", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"campaign\", \"campaign\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (list = this.listOfProactiveMessageAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("messages", "messages", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"messages\", \"messages\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (proactiveMessageCampaign == null) {
            JsonDataException missingProperty = Util.missingProperty("campaign", "campaign", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"campaign\", \"campaign\", reader)");
            throw missingProperty;
        } else if (list != null) {
            return new ProactiveMessageResponse(proactiveMessageCampaign, list);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("messages", "messages", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"messages\", \"messages\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, ProactiveMessageResponse proactiveMessageResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (proactiveMessageResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("campaign");
            this.proactiveMessageCampaignAdapter.toJson(jsonWriter, proactiveMessageResponse.getCampaign());
            jsonWriter.name("messages");
            this.listOfProactiveMessageAdapter.toJson(jsonWriter, proactiveMessageResponse.getMessages());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
