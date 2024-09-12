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
import zendesk.android.internal.frontendevents.FrontendEventsStorage;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveMessageAnalyticsEventJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveMessageAnalyticsEvent;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "proactiveCampaignAnalyticsDTOAdapter", "Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveCampaignAnalyticsDTO;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveMessageAnalyticsEventJsonAdapter.kt */
public final class ProactiveMessageAnalyticsEventJsonAdapter extends JsonAdapter<ProactiveMessageAnalyticsEvent> {
    private final JsonReader.Options options;
    private final JsonAdapter<ProactiveCampaignAnalyticsDTO> proactiveCampaignAnalyticsDTOAdapter;
    private final JsonAdapter<String> stringAdapter;

    public ProactiveMessageAnalyticsEventJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("buid", "channel", "version", "timestamp", FrontendEventsStorage.KEY_SUID, "idempotencyToken", "proactiveCampaign");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"buid\", \"channel\", \"v…en\", \"proactiveCampaign\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "buid");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"buid\")");
        this.stringAdapter = adapter;
        JsonAdapter<ProactiveCampaignAnalyticsDTO> adapter2 = moshi.adapter(ProactiveCampaignAnalyticsDTO.class, SetsKt.emptySet(), "proactiveCampaign");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(ProactiveC…t(), \"proactiveCampaign\")");
        this.proactiveCampaignAnalyticsDTOAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(52);
        sb.append("GeneratedJsonAdapter(").append("ProactiveMessageAnalyticsEvent").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ProactiveMessageAnalyticsEvent fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        ProactiveCampaignAnalyticsDTO proactiveCampaignAnalyticsDTO = null;
        while (true) {
            ProactiveCampaignAnalyticsDTO proactiveCampaignAnalyticsDTO2 = proactiveCampaignAnalyticsDTO;
            if (jsonReader.hasNext()) {
                switch (jsonReader2.selectName(this.options)) {
                    case -1:
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                    case 0:
                        str = this.stringAdapter.fromJson(jsonReader2);
                        if (str == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull("buid", "buid", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"buid\", \"buid\",\n            reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        str2 = this.stringAdapter.fromJson(jsonReader2);
                        if (str2 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("channel", "channel", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"channel\"…       \"channel\", reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 2:
                        str3 = this.stringAdapter.fromJson(jsonReader2);
                        if (str3 == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("version", "version", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"version\"…       \"version\", reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 3:
                        str4 = this.stringAdapter.fromJson(jsonReader2);
                        if (str4 == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("timestamp", "timestamp", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"timestam…     \"timestamp\", reader)");
                            throw unexpectedNull4;
                        }
                        break;
                    case 4:
                        str5 = this.stringAdapter.fromJson(jsonReader2);
                        if (str5 == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull(FrontendEventsStorage.KEY_SUID, FrontendEventsStorage.KEY_SUID, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"suid\", \"suid\",\n            reader)");
                            throw unexpectedNull5;
                        }
                        break;
                    case 5:
                        str6 = this.stringAdapter.fromJson(jsonReader2);
                        if (str6 == null) {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("idempotencyToken", "idempotencyToken", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"idempote…dempotencyToken\", reader)");
                            throw unexpectedNull6;
                        }
                        break;
                    case 6:
                        proactiveCampaignAnalyticsDTO = this.proactiveCampaignAnalyticsDTOAdapter.fromJson(jsonReader2);
                        if (proactiveCampaignAnalyticsDTO != null) {
                            continue;
                        } else {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull("proactiveCampaign", "proactiveCampaign", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"proactiv…oactiveCampaign\", reader)");
                            throw unexpectedNull7;
                        }
                }
                proactiveCampaignAnalyticsDTO = proactiveCampaignAnalyticsDTO2;
            } else {
                jsonReader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("buid", "buid", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"buid\", \"buid\", reader)");
                    throw missingProperty;
                } else if (str2 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("channel", "channel", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"channel\", \"channel\", reader)");
                    throw missingProperty2;
                } else if (str3 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("version", "version", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"version\", \"version\", reader)");
                    throw missingProperty3;
                } else if (str4 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("timestamp", "timestamp", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"timestamp\", \"timestamp\", reader)");
                    throw missingProperty4;
                } else if (str5 == null) {
                    JsonDataException missingProperty5 = Util.missingProperty(FrontendEventsStorage.KEY_SUID, FrontendEventsStorage.KEY_SUID, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"suid\", \"suid\", reader)");
                    throw missingProperty5;
                } else if (str6 == null) {
                    JsonDataException missingProperty6 = Util.missingProperty("idempotencyToken", "idempotencyToken", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"idempot…dempotencyToken\", reader)");
                    throw missingProperty6;
                } else if (proactiveCampaignAnalyticsDTO2 != null) {
                    return new ProactiveMessageAnalyticsEvent(str, str2, str3, str4, str5, str6, proactiveCampaignAnalyticsDTO2);
                } else {
                    JsonDataException missingProperty7 = Util.missingProperty("proactiveCampaign", "proactiveCampaign", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"proacti…oactiveCampaign\", reader)");
                    throw missingProperty7;
                }
            }
        }
    }

    public void toJson(JsonWriter jsonWriter, ProactiveMessageAnalyticsEvent proactiveMessageAnalyticsEvent) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (proactiveMessageAnalyticsEvent != null) {
            jsonWriter.beginObject();
            jsonWriter.name("buid");
            this.stringAdapter.toJson(jsonWriter, proactiveMessageAnalyticsEvent.getBuid());
            jsonWriter.name("channel");
            this.stringAdapter.toJson(jsonWriter, proactiveMessageAnalyticsEvent.getChannel());
            jsonWriter.name("version");
            this.stringAdapter.toJson(jsonWriter, proactiveMessageAnalyticsEvent.getVersion());
            jsonWriter.name("timestamp");
            this.stringAdapter.toJson(jsonWriter, proactiveMessageAnalyticsEvent.getTimestamp());
            jsonWriter.name(FrontendEventsStorage.KEY_SUID);
            this.stringAdapter.toJson(jsonWriter, proactiveMessageAnalyticsEvent.getSuid());
            jsonWriter.name("idempotencyToken");
            this.stringAdapter.toJson(jsonWriter, proactiveMessageAnalyticsEvent.getIdempotencyToken());
            jsonWriter.name("proactiveCampaign");
            this.proactiveCampaignAnalyticsDTOAdapter.toJson(jsonWriter, proactiveMessageAnalyticsEvent.getProactiveCampaign());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
