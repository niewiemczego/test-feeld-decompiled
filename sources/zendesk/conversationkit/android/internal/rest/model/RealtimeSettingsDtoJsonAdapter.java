package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/RealtimeSettingsDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/conversationkit/android/internal/rest/model/RealtimeSettingsDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RealtimeSettingsDtoJsonAdapter.kt */
public final class RealtimeSettingsDtoJsonAdapter extends JsonAdapter<RealtimeSettingsDto> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public RealtimeSettingsDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("enabled", "baseUrl", "retryInterval", "maxConnectionAttempts", "connectionDelay");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"enabled\", \"baseUrl\",…mpts\", \"connectionDelay\")");
        this.options = of;
        JsonAdapter<Boolean> adapter = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), "enabled");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Boolean::c…tySet(),\n      \"enabled\")");
        this.booleanAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "baseUrl");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…tySet(),\n      \"baseUrl\")");
        this.stringAdapter = adapter2;
        JsonAdapter<Integer> adapter3 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "retryInterval");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Int::class…),\n      \"retryInterval\")");
        this.intAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(41);
        sb.append("GeneratedJsonAdapter(").append("RealtimeSettingsDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public RealtimeSettingsDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Boolean bool = null;
        Integer num = null;
        Integer num2 = null;
        String str = null;
        Integer num3 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                bool = this.booleanAdapter.fromJson(jsonReader);
                if (bool == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("enabled", "enabled", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"enabled\"…       \"enabled\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("baseUrl", "baseUrl", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"baseUrl\"…       \"baseUrl\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                num = this.intAdapter.fromJson(jsonReader);
                if (num == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("retryInterval", "retryInterval", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"retryInt… \"retryInterval\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                num2 = this.intAdapter.fromJson(jsonReader);
                if (num2 == null) {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("maxConnectionAttempts", "maxConnectionAttempts", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"maxConne…nectionAttempts\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4 && (num3 = this.intAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull5 = Util.unexpectedNull("connectionDelay", "connectionDelay", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"connecti…connectionDelay\", reader)");
                throw unexpectedNull5;
            }
        }
        jsonReader.endObject();
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (str == null) {
                JsonDataException missingProperty = Util.missingProperty("baseUrl", "baseUrl", jsonReader);
                Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"baseUrl\", \"baseUrl\", reader)");
                throw missingProperty;
            } else if (num != null) {
                int intValue = num.intValue();
                if (num2 != null) {
                    int intValue2 = num2.intValue();
                    if (num3 != null) {
                        return new RealtimeSettingsDto(booleanValue, str, intValue, intValue2, num3.intValue());
                    }
                    JsonDataException missingProperty2 = Util.missingProperty("connectionDelay", "connectionDelay", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"connect…connectionDelay\", reader)");
                    throw missingProperty2;
                }
                JsonDataException missingProperty3 = Util.missingProperty("maxConnectionAttempts", "maxConnectionAttempts", jsonReader);
                Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"maxConn…nectionAttempts\", reader)");
                throw missingProperty3;
            } else {
                JsonDataException missingProperty4 = Util.missingProperty("retryInterval", "retryInterval", jsonReader);
                Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"retryIn… \"retryInterval\", reader)");
                throw missingProperty4;
            }
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("enabled", "enabled", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"enabled\", \"enabled\", reader)");
            throw missingProperty5;
        }
    }

    public void toJson(JsonWriter jsonWriter, RealtimeSettingsDto realtimeSettingsDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (realtimeSettingsDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("enabled");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(realtimeSettingsDto.getEnabled()));
            jsonWriter.name("baseUrl");
            this.stringAdapter.toJson(jsonWriter, realtimeSettingsDto.getBaseUrl());
            jsonWriter.name("retryInterval");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(realtimeSettingsDto.getRetryInterval()));
            jsonWriter.name("maxConnectionAttempts");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(realtimeSettingsDto.getMaxConnectionAttempts()));
            jsonWriter.name("connectionDelay");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(realtimeSettingsDto.getConnectionDelay()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
