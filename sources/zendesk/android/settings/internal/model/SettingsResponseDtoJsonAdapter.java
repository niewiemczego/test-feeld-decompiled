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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lzendesk/android/settings/internal/model/SettingsResponseDtoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/settings/internal/model/SettingsResponseDto;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "settingsDtoAdapter", "Lzendesk/android/settings/internal/model/SettingsDto;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingsResponseDtoJsonAdapter.kt */
public final class SettingsResponseDtoJsonAdapter extends JsonAdapter<SettingsResponseDto> {
    private final JsonReader.Options options;
    private final JsonAdapter<SettingsDto> settingsDtoAdapter;

    public SettingsResponseDtoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("settings");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"settings\")");
        this.options = of;
        JsonAdapter<SettingsDto> adapter = moshi.adapter(SettingsDto.class, SetsKt.emptySet(), "settings");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(SettingsDt…  emptySet(), \"settings\")");
        this.settingsDtoAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(41);
        sb.append("GeneratedJsonAdapter(").append("SettingsResponseDto").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public SettingsResponseDto fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        SettingsDto settingsDto = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0 && (settingsDto = this.settingsDtoAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("settings", "settings", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"settings…      \"settings\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (settingsDto != null) {
            return new SettingsResponseDto(settingsDto);
        }
        JsonDataException missingProperty = Util.missingProperty("settings", "settings", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"settings\", \"settings\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, SettingsResponseDto settingsResponseDto) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (settingsResponseDto != null) {
            jsonWriter.beginObject();
            jsonWriter.name("settings");
            this.settingsDtoAdapter.toJson(jsonWriter, settingsResponseDto.getSettings());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
