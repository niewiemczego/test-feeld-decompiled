package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import io.sentry.protocol.App;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ConfigDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/ConfigDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "appDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/AppDto;", "baseUrlDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/BaseUrlDto;", "integrationDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/IntegrationDto;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "restRetryPolicyDtoAdapter", "Lzendesk/conversationkit/android/internal/rest/model/RestRetryPolicyDto;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfigDtoJsonAdapter.kt */
public final class ConfigDtoJsonAdapter extends JsonAdapter<ConfigDto> {
    private final JsonAdapter<AppDto> appDtoAdapter;
    private final JsonAdapter<BaseUrlDto> baseUrlDtoAdapter;
    private final JsonAdapter<IntegrationDto> integrationDtoAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<RestRetryPolicyDto> restRetryPolicyDtoAdapter;

    public ConfigDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(App.TYPE, "baseUrl", "integration", "restRetryPolicy");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"app\", \"baseUrl\", \"in…\n      \"restRetryPolicy\")");
        this.options = of;
        JsonAdapter<AppDto> adapter = moshi.adapter(AppDto.class, SetsKt.emptySet(), App.TYPE);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(AppDto::cl… emptySet(),\n      \"app\")");
        this.appDtoAdapter = adapter;
        JsonAdapter<BaseUrlDto> adapter2 = moshi.adapter(BaseUrlDto.class, SetsKt.emptySet(), "baseUrl");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(BaseUrlDto…   emptySet(), \"baseUrl\")");
        this.baseUrlDtoAdapter = adapter2;
        JsonAdapter<IntegrationDto> adapter3 = moshi.adapter(IntegrationDto.class, SetsKt.emptySet(), "integration");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Integratio…mptySet(), \"integration\")");
        this.integrationDtoAdapter = adapter3;
        JsonAdapter<RestRetryPolicyDto> adapter4 = moshi.adapter(RestRetryPolicyDto.class, SetsKt.emptySet(), "restRetryPolicy");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(RestRetryP…Set(), \"restRetryPolicy\")");
        this.restRetryPolicyDtoAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(31);
        sb.append("GeneratedJsonAdapter(").append("ConfigDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ConfigDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        AppDto appDto = null;
        BaseUrlDto baseUrlDto = null;
        IntegrationDto integrationDto = null;
        RestRetryPolicyDto restRetryPolicyDto = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                appDto = this.appDtoAdapter.fromJson(jsonReader);
                if (appDto == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(App.TYPE, App.TYPE, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"app\", \"app\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                baseUrlDto = this.baseUrlDtoAdapter.fromJson(jsonReader);
                if (baseUrlDto == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("baseUrl", "baseUrl", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"baseUrl\"…       \"baseUrl\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                integrationDto = this.integrationDtoAdapter.fromJson(jsonReader);
                if (integrationDto == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("integration", "integration", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"integrat…\", \"integration\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3 && (restRetryPolicyDto = this.restRetryPolicyDtoAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull4 = Util.unexpectedNull("restRetryPolicy", "restRetryPolicy", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"restRetr…restRetryPolicy\", reader)");
                throw unexpectedNull4;
            }
        }
        jsonReader.endObject();
        if (appDto == null) {
            JsonDataException missingProperty = Util.missingProperty(App.TYPE, App.TYPE, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"app\", \"app\", reader)");
            throw missingProperty;
        } else if (baseUrlDto == null) {
            JsonDataException missingProperty2 = Util.missingProperty("baseUrl", "baseUrl", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"baseUrl\", \"baseUrl\", reader)");
            throw missingProperty2;
        } else if (integrationDto == null) {
            JsonDataException missingProperty3 = Util.missingProperty("integration", "integration", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"integra…ion\",\n            reader)");
            throw missingProperty3;
        } else if (restRetryPolicyDto != null) {
            return new ConfigDto(appDto, baseUrlDto, integrationDto, restRetryPolicyDto);
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("restRetryPolicy", "restRetryPolicy", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"restRet…restRetryPolicy\", reader)");
            throw missingProperty4;
        }
    }

    public void toJson(JsonWriter jsonWriter, ConfigDto configDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (configDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name(App.TYPE);
            this.appDtoAdapter.toJson(jsonWriter, configDto.getApp());
            jsonWriter.name("baseUrl");
            this.baseUrlDtoAdapter.toJson(jsonWriter, configDto.getBaseUrl());
            jsonWriter.name("integration");
            this.integrationDtoAdapter.toJson(jsonWriter, configDto.getIntegration());
            jsonWriter.name("restRetryPolicy");
            this.restRetryPolicyDtoAdapter.toJson(jsonWriter, configDto.getRestRetryPolicy());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
