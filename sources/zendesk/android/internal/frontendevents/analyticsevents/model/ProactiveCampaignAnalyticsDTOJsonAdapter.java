package zendesk.android.internal.frontendevents.analyticsevents.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveCampaignAnalyticsDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveCampaignAnalyticsDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "proactiveCampaignAnalyticsActionAdapter", "Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveCampaignAnalyticsAction;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveCampaignAnalyticsDTOJsonAdapter.kt */
public final class ProactiveCampaignAnalyticsDTOJsonAdapter extends JsonAdapter<ProactiveCampaignAnalyticsDTO> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<ProactiveCampaignAnalyticsAction> proactiveCampaignAnalyticsActionAdapter;
    private final JsonAdapter<String> stringAdapter;

    public ProactiveCampaignAnalyticsDTOJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("campaignId", "action", "timestamp", "version", "visitorId");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"campaignId\", \"action…, \"version\", \"visitorId\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "campaignId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…et(),\n      \"campaignId\")");
        this.stringAdapter = adapter;
        JsonAdapter<ProactiveCampaignAnalyticsAction> adapter2 = moshi.adapter(ProactiveCampaignAnalyticsAction.class, SetsKt.emptySet(), "action");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(ProactiveC…va, emptySet(), \"action\")");
        this.proactiveCampaignAnalyticsActionAdapter = adapter2;
        JsonAdapter<Integer> adapter3 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "version");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Int::class…a, emptySet(), \"version\")");
        this.intAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(51);
        sb.append("GeneratedJsonAdapter(").append("ProactiveCampaignAnalyticsDTO").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ProactiveCampaignAnalyticsDTO fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Integer num = null;
        String str = null;
        ProactiveCampaignAnalyticsAction proactiveCampaignAnalyticsAction = null;
        String str2 = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("campaignId", "campaignId", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"campaign…    \"campaignId\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                proactiveCampaignAnalyticsAction = this.proactiveCampaignAnalyticsActionAdapter.fromJson(jsonReader);
                if (proactiveCampaignAnalyticsAction == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("action", "action", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"action\", \"action\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("timestamp", "timestamp", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"timestam…     \"timestamp\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                num = this.intAdapter.fromJson(jsonReader);
                if (num == null) {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("version", "version", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"version\"…       \"version\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4 && (str3 = this.stringAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull5 = Util.unexpectedNull("visitorId", "visitorId", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"visitorI…     \"visitorId\", reader)");
                throw unexpectedNull5;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("campaignId", "campaignId", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"campaig…d\", \"campaignId\", reader)");
            throw missingProperty;
        } else if (proactiveCampaignAnalyticsAction == null) {
            JsonDataException missingProperty2 = Util.missingProperty("action", "action", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"action\", \"action\", reader)");
            throw missingProperty2;
        } else if (str2 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("timestamp", "timestamp", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"timestamp\", \"timestamp\", reader)");
            throw missingProperty3;
        } else if (num != null) {
            int intValue = num.intValue();
            if (str3 != null) {
                return new ProactiveCampaignAnalyticsDTO(str, proactiveCampaignAnalyticsAction, str2, intValue, str3);
            }
            JsonDataException missingProperty4 = Util.missingProperty("visitorId", "visitorId", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"visitorId\", \"visitorId\", reader)");
            throw missingProperty4;
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("version", "version", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"version\", \"version\", reader)");
            throw missingProperty5;
        }
    }

    public void toJson(JsonWriter jsonWriter, ProactiveCampaignAnalyticsDTO proactiveCampaignAnalyticsDTO) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (proactiveCampaignAnalyticsDTO != null) {
            jsonWriter.beginObject();
            jsonWriter.name("campaignId");
            this.stringAdapter.toJson(jsonWriter, proactiveCampaignAnalyticsDTO.getCampaignId());
            jsonWriter.name("action");
            this.proactiveCampaignAnalyticsActionAdapter.toJson(jsonWriter, proactiveCampaignAnalyticsDTO.getAction());
            jsonWriter.name("timestamp");
            this.stringAdapter.toJson(jsonWriter, proactiveCampaignAnalyticsDTO.getTimestamp());
            jsonWriter.name("version");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(proactiveCampaignAnalyticsDTO.getVersion()));
            jsonWriter.name("visitorId");
            this.stringAdapter.toJson(jsonWriter, proactiveCampaignAnalyticsDTO.getVisitorId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
